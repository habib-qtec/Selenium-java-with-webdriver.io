// package utilis;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import java.io.FileInputStream;
// import java.io.IOException;
// import java.time.Duration;
// import java.util.Properties;
// public class TestBase {
//     public WebDriver driver;
//     public WebDriver WebDriverManager() throws IOException, InterruptedException {
//         FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
//                 "//src//test//resources//global.properties");
//         Properties prop = new Properties();
//         prop.load(fis);
//         String url = prop.getProperty("QAUrl");
//         String browser_properties = prop.getProperty("browser");
//         String browser_maven = System.getProperty("browser");
// // result = testCondition ? value1 : value2
//         String browser = browser_maven != null ? browser_maven : browser_properties;
//         if (driver == null) {
//             if (browser.equalsIgnoreCase("chrome")) {
//                 ChromeOptions options = new ChromeOptions();
//                 options.addArguments("--remote-allow-origins=*");
//                 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
//                         "//src//test//resources//chromedriver.exe");
//                 driver = new ChromeDriver(options);
//             }
//             if (browser.equalsIgnoreCase("firefox")) {
//                 System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
//                 driver = new FirefoxDriver();
//             }
//             assert driver != null;
//             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//             driver.manage().window().maximize();
//             driver.get(url);
//             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//             wait.until(ExpectedConditions.urlToBe(url));
//         }
//         return driver;
//     }
//     public void CloseDriver() {
//         if (driver != null) {
//             driver.quit();
//         }
//     }
// }


package utilis;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
                "/src/test/resources/global.properties");
        Properties prop = new Properties();
        prop.load(fis);

        String url = prop.getProperty("QAUrl");
        String browser_properties = prop.getProperty("browser");
        String browser_maven = System.getProperty("browser");

        // Choose browser based on Maven or properties file
        String browser = browser_maven != null ? browser_maven : browser_properties;

        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
            }

            if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }

            assert driver != null;
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            driver.get(url);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.urlToBe(url));
        }

        return driver;
    }



    // ✅ Common explicit wait method for visibility
    public WebElement waitForVisibility(WebElement element, int timeoutInSeconds) {
        WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return localWait.until(ExpectedConditions.visibilityOf(element));
    }

    // ✅ Common explicit wait method for clickability
    public WebElement waitForClickability(WebElement element, int timeoutInSeconds) {
        WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return localWait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public void CloseDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
