package Reports;

import Locator.*;
import org.openqa.selenium.WebDriver;


public class PageObjectManage {
    public static WebDriver driver;


    public Smartphones smartphones;
    public Computers computers;
    public Solutions solutions;
    public Pricing pricings;


    public PageObjectManage(WebDriver driver) {
        this.driver = driver;
    }


    public Smartphones getsmartphones() {
        smartphones = new Smartphones(driver);
        return smartphones;
    }

    public Computers getcomputers() {
        computers = new Computers(driver);
        return computers;
    }
    public Solutions getsolutions() {
        solutions = new Solutions(driver);
        return solutions;
    }
    // public Pricing getpricings() {
    //     pricings = new Pricings(driver);
    //     return pricings;
}
