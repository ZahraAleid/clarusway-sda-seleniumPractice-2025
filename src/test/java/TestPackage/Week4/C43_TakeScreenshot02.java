package TestPackage.Week4;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.JavaScriptUtils;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C43_TakeScreenshot02 extends TestBase {
    /*
    Go to Linkedin
    Take homepage's screenshot
    Take logo's screenshot
*/

    @Test
    public void screenShotWithTestBaseTest() throws InterruptedException {
        driver.get("https://www.linkedIn.com");
        Thread.sleep(3000);
        takeScreenshot(driver);

        WebElement element = driver.findElement(By.xpath("//icon[@data-test-id]"));  //should work but I have invalid xpath
        takeScreenshotOfElement(driver,element);


    }

}