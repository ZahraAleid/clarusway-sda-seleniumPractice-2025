package TestPackage.Week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C30_JavaScriptExecutor extends TestBase {

    @Test
    public void JscriptExecutorTtest1() {
        driver.get("https://google.com");

        // Create JavaScript Executor object
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // We can execute JavaScript Codes with executeScript()
        js.executeScript("document.body.style.backgroundColor = 'lightBlue';");
        js.executeScript("alert('My Own Alert');");

    }

    @Test
    void dummyTest02() throws InterruptedException {
        //Go to URL: https://api.jquery.com/dblclick/
        driver.get("https://api.jquery.com/dblclick/");

        //Double-click on the blue square at the middle of the page and then write the changed color.
        driver.switchTo().frame(0);

        WebElement blueSquare =driver.findElement(By.xpath("//span[.='Double click the block']//preceding::div"));

        Actions actions = new Actions(driver);


        //scroll to that element by JavaScript codes
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",blueSquare);

        String colorBeforeDoubleClick = blueSquare.getCssValue("background-color");

        actions.doubleClick(blueSquare).perform();

        String colorAfterDoubleClick = blueSquare.getCssValue("background-color");
        Assertions.assertEquals("rgba(0, 0, 255, 1)",colorBeforeDoubleClick);


        //don't forget to go back to main frame !!
        driver.switchTo().defaultContent();

        Thread.sleep(3000);
        // scroll to the top of the page by js
       js.executeScript("window.scrollTo(0,0);");

        Thread.sleep(3000);
        // scroll to the bottom of the page by js
        js.executeScript("0,window.scrollTo(0,document.body.scrollHeight);");

        Thread.sleep(3000);

    }

}