package com.hepsiburada.qa.pages;

import com.hepsiburada.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    // initializing the page objects
    public LoginPage()  {


        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//button[@class='btn full btn-login-submit']")
    WebElement giris;

    // Actions

    public Homepage login(String un, String pwd) 	 {


        email.sendKeys(un);
        password.sendKeys(pwd);
        giris.click();

        return new Homepage();

    }

}
