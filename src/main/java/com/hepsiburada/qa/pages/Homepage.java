package com.hepsiburada.qa.pages;

import com.hepsiburada.qa.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends TestBase {

    public Homepage() {

        PageFactory.initElements(driver, this);
    }

    //WebElements
    @FindBy(id="myAccount")
    WebElement giris1;

    @FindBy(id="login")
    WebElement giris2;

    @FindBy(xpath = "//a[contains(text(),'Cansu Cobanoglu')]")
    WebElement loginuser;

    @FindBy(id = "productSearch")
    WebElement searchProduct;

    //Actions
    public String getHomePageTitle() {

        return driver.getTitle();
    }


    public LoginPage goLoginPage() {

        giris1.click();
        giris2.click();
        return new LoginPage();
    }

    public void loginCheck()
    {

        boolean present = loginuser.isDisplayed();

            if (present == true) {
                System.out.println("Login başarılı!");
            }
            else {
                System.out.println("Login başarısız!");
            }
    }

    public Products setSearchBar(String search)
    {
        searchProduct.sendKeys(search);
        searchProduct.sendKeys(Keys.RETURN);

        return new Products();
    }

}
