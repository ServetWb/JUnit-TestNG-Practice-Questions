package Utilities;

import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
// import org.openqa.selenium.firefox.FirefoxDriver; // optional if you switch browsers

import java.time.Duration;


    /**
     * Base test class to set up and tear down WebDriver for all tests.
     */
    public class TestBase {

        protected static WebDriver driver;

        @BeforeClass
        public static void setUp() {
            driver = new ChromeDriver(); // You can switch to FirefoxDriver if needed
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @AfterClass
        public static void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
}
