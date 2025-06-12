package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReusableMethods {

    public class reusableMethods {

        /** Waits for the specified number of seconds */
        public static void waitFor(int seconds) {
            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        /** Converts a list of WebElements into a list of Strings (text values) */
        public static List<String> getTextList(List<WebElement> elements) {
            List<String> textList = new ArrayList<>();
            for (WebElement element : elements) {
                textList.add(element.getText());
            }
            return textList;
        }

        /** Switches to a browser window with the specified URL */
        public static void switchToWindowByUrl(WebDriver driver, String targetUrl) {
            for (String windowHandle : driver.getWindowHandles()) {
                driver.switchTo().window(windowHandle);
                if (driver.getCurrentUrl().equals(targetUrl)) {
                    break;
                }
            }
        }

        /** Switches to a browser window with the specified title */
        public static void switchToWindowByTitle(WebDriver driver, String targetTitle) {
            for (String windowHandle : driver.getWindowHandles()) {
                driver.switchTo().window(windowHandle);
                if (driver.getTitle().equals(targetTitle)) {
                    break;
                }
            }
        }

        /** Takes a full-page screenshot and saves it with default name */
        public static void takeFullPageScreenshot(WebDriver driver) {
            takeFullPageScreenshot(driver, "fullPageScreenshot");
        }

        /** Takes a full-page screenshot with custom name */
        public static void takeFullPageScreenshot(WebDriver driver, String name) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File("target/screenshots/" + name + ".jpg");
            try {
                FileUtils.copyFile(src, dest);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /** Takes a full-page screenshot with a timestamped file name */
        public static void takeTimestampedScreenshot(WebDriver driver) {
            takeTimestampedScreenshot(driver, "fullPageScreenshot");
        }

        /** Takes a full-page screenshot with custom name and timestamp */
        public static void takeTimestampedScreenshot(WebDriver driver, String name) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("_ddMMyy_HHmmss"));
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File("target/screenshots/" + name + timestamp + ".jpg");
            try {
                FileUtils.copyFile(src, dest);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /** Takes a screenshot of the specified WebElement */
        public static void takeElementScreenshot(WebElement element) {
            takeElementScreenshot(element, "elementScreenshot");
        }

        /** Takes a screenshot of the specified WebElement with custom name */
        public static void takeElementScreenshot(WebElement element, String name) {
            File src = element.getScreenshotAs(OutputType.FILE);
            File dest = new File("target/screenshots/" + name + ".jpg");
            try {
                FileUtils.copyFile(src, dest);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /** Takes a screenshot of a WebElement with a timestamped name */
        public static void takeTimestampedElementScreenshot(WebElement element) {
            takeTimestampedElementScreenshot(element, "elementScreenshot");
        }

        /** Takes a screenshot of a WebElement with custom name and timestamp */
        public static void takeTimestampedElementScreenshot(WebElement element, String name) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("_ddMMyy_HHmmss"));
            File src = element.getScreenshotAs(OutputType.FILE);
            File dest = new File("target/screenshots/" + name + timestamp + ".jpg");
            try {
                FileUtils.copyFile(src, dest);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
