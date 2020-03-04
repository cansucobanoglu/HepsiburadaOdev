package com.hepsiburada.qa.pages;

import com.hepsiburada.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products extends TestBase {

    public Products(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[contains(@class,'product-list results-container do-flex list')]//li[1]")
    WebElement product;

    public ProductDetail clickOnProduct()
    {
        product.click();
        return new ProductDetail();
    }
}
