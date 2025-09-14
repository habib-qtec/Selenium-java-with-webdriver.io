package Locator;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Solutions {

    @Getter
    WebDriver driver;

    By Solutions = By.xpath("//span[normalize-space()='Solutions']");




    public Solutions(WebDriver driver) {this.driver = driver;}
    public WebElement Solution(){return driver.findElement(Solutions);}


}
