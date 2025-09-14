package StepDef;


import Locator.Computers;
import Locator.Pricing;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import utilis.HTML_TO_PDF;
import java.io.IOException;
import utilis.TestContextSetup;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;


public class Pricings {

    private TestContextSetup testContextSetup;
    private WebDriver driver;
    private Pricing pricing;
    private HTML_TO_PDF html_to_pdf ;
    private int wait = 3000;

    public Pricings(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.driver = testContextSetup.driver;
        // this.pricing = testContextSetup.pageObjectManager.getpricings();
    }

    ////////////////////////////////////Test Case-1///////////////////////////////////

    @Given("Check that Pricing Button is displayed")
    public void CheckthatPricingButtonisdisplayed() throws InterruptedException {
        Thread.sleep(wait);
        Assert.assertTrue(pricing.Pricing().isDisplayed());
        Thread.sleep(wait);
    }

    @When("Click on Pricing Button")
    public void ClickonPricingButton() throws InterruptedException {
        pricing.Pricing().click();
        Thread.sleep(wait);
    }









}
