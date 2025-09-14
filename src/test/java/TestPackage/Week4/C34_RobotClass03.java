package TestPackage.Week4;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class C34_RobotClass03 extends TestBase {
    /*
       Go to https://testpages.eviltester.com/styled/basic-html-form-test.html
       Copy h1 element's text and paste it into username input
       Click enter
       Scroll page down
       Scroll page up
       (Don't use click() and sendKeys() methods)
    */
    @Test
    public void robotClassTaskTest() throws AWTException, InterruptedException {

        Robot robot = new Robot();
        robot.setAutoDelay(250);
        //Go to https://testpages.eviltester.com/styled/basic-html-form-test.html
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");


        //Copy h1 element's text and paste it into username input
        String h1Text= driver.findElement(By.tagName("h1")).getText();
        System.out.println("h1Text = " + h1Text);


        // Clipboard and Robot operations...
        StringSelection ss = new StringSelection(h1Text);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);


        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);



        //Scroll page down
        robot.mouseWheel(500);
        //Scroll page upv
        robot.mouseWheel(-500);

    }

}