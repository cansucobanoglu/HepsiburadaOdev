package com.hepsiburada.testcases;

import com.hepsiburada.qa.base.TestBase;
import com.hepsiburada.qa.pages.Homepage;
import com.hepsiburada.qa.pages.LoginPage;
import com.hepsiburada.qa.pages.ProductDetail;
import com.hepsiburada.qa.pages.Products;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomepageWithLogin extends TestBase {

    Homepage homePage ;
    LoginPage loginPage ;
    Products products;
    ProductDetail productDtl;

    public HomepageWithLogin() {
        super();
    }

    @BeforeTest
    public void setUp() throws InterruptedException {

        initialization();
        homePage =new Homepage();
        loginPage = new LoginPage();
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
    public void goToLogin() throws InterruptedException{
        homePage.goLoginPage();
        loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        Thread.sleep(2000);
    }

    @Test (priority = 3)
    public void checkLogin()
    {
        homePage.loginCheck();
    }

    @Test(priority = 4)
    public void enterProduct()
    {
        homePage.setSearchBar(prop.getProperty("searchText"));
    }

    @Test(priority = 5)
    public void clickProduct()
    {
        products.clickOnProduct();
    }

    @Test(priority = 6)
    public void chooseSeller()throws InterruptedException
    {
        productDtl.getSeller();
    }

    @AfterTest
    public void tearDown() {

        driver.close();
    }



}
