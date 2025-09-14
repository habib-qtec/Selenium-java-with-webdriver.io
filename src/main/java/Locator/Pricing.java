package Locator;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pricing {

    @Getter
    WebDriver driver;

    By Pricing = By.xpath("//a[normalize-space()='Pricing']");


    public Pricing(WebDriver driver) {this.driver = driver;}
    public WebElement Pricing(){return driver.findElement(Pricing);}


}
