package com.hepsiburada.qa.pages;

import com.hepsiburada.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductDetail extends TestBase {

    public ProductDetail() { PageFactory.initElements(driver, this); }

    @FindBy(xpath = "//span[@class='cart-copy']")
    WebElement goToCart;

    public ProductDetail getSeller() throws InterruptedException
    {
        //satici adina göre liste olusturuldu
        List<WebElement> sellerList = driver.findElements(By.xpath("//a[@class='merchantStore small']"));
        System.out.println("Toplam satici sayisi: " + sellerList.size());
        //sepete ekle butonu sayisina göre liste olusturuldu
        List<WebElement> marketplaceList = driver.findElements(By.xpath("//div[contains(@class,'addToCart')]"));

        String seller1 = sellerList.get(0).getText(); //birinci saticinin ismi alindi
        System.out.println("Birinci satici: " + seller1);
        marketplaceList.get(0).click(); //birinci saticidan urun sepete eklendi
        Thread.sleep(2000);

        String seller2 = sellerList.get(sellerList.size()-1).getText();//ikinci saticinin isimi alindi
        System.out.println("Ikinci satici: " + seller2);
        marketplaceList.get(marketplaceList.size()-1).click(); //ikinci saticidan urun sepete eklendi
        Thread.sleep(2000);

        goToCart.click();

        //Sepetteki itemlerin tutuldugu bir liste olusturulur (satici adini baz alarak)
        List<WebElement> cartList = driver.findElements(By.xpath("//div[contains(@class,'item-content')]//div[contains(@class,'merchant')]//a"));
        System.out.println("Sepetteki toplam urun sayisi: "+ cartList.size());

        String item1 = cartList.get(cartList.size()-2).getText();
        System.out.println("Sepete eklenen ilk urunun saticisi: " + item1);

        String item2 = cartList.get(cartList.size()-1).getText();
        System.out.println("Sepete eklenen ikinci urunun saticisi: " + item2);

        if (item1.equals(seller1))
        {
            System.out.println("Secilen 1.urun dogru bir sekilde sepete eklenmistir.");
        }
        else{
            System.out.println("Secilen 1.urun dogru bir sekilde sepete eklenmemistir.");
        }
        if ( item2.equals(seller2))
        {
            System.out.println("Secilen 2.urun dogru bir sekilde sepete eklenmistir.");
        }
        else{
            System.out.println("Secilen 2.urun dogru bir sekilde sepete eklenmemistir.");
        }

        return this;
    }
}
