package com.hepsiburada.testcases;

import com.hepsiburada.qa.base.TestBase;
import com.hepsiburada.qa.pages.Homepage;
import com.hepsiburada.qa.pages.LoginPage;
import com.hepsiburada.qa.pages.ProductDetail;
import com.hepsiburada.qa.pages.Products;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomepageWithoutLogin extends TestBase {

    Homepage homePage ;
    Products products;
    ProductDetail productDtl;

    public HomepageWithoutLogin() {
        super();
    }

    @BeforeTest
    public void setUp() throws InterruptedException {

        initialization();
        homePage =new Homepage();
        products = new Products();
        productDtl = new ProductDetail();
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void getTitle() {
        String title = homePage.getHomePageTitle();
        String expectedTitle = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";

        try {
            Assert.assertEquals(title, expectedTitle);
            System.out.println("Anasayfadasınız");
            System.out.println(title);

        } catch (Exception e) {
            System.out.println("Anasayfada değilsiniz");
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void enterProduct()
    {
        homePage.setSearchBar(prop.getProperty("searchText"));
    }

    @Test(priority = 3)
    public void clickProduct()
    {
        products.clickOnProduct();
    }

    @Test(priority = 4)
    public void chooseSeller()throws InterruptedException
    {
        productDtl.getSeller();
    }

    @AfterTest
    public void tearDown() {

        driver.close();
    }



}
