package TestPackage.Week4;



import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class C32_RobotClass01 {
    @Test
    public void robotClassKeyboardTest1() throws AWTException, InterruptedException {
        Robot robot = new Robot();


        // This pause is given so that we can click on the script. Robot will write "sout" on the screen
        Thread.sleep(5000);

        robot.keyPress(KeyEvent.VK_S); //after pressing a key don't forget to release !!
        robot.keyRelease(KeyEvent.VK_S);

        robot.keyPress(KeyEvent.VK_O); //after pressing a key don't forget to release !!
        robot.keyRelease(KeyEvent.VK_O);

        robot.keyPress(KeyEvent.VK_U); //after pressing a key don't forget to release !!
        robot.keyRelease(KeyEvent.VK_U);

        robot.keyPress(KeyEvent.VK_T); //after pressing a key don't forget to release !!
        robot.keyRelease(KeyEvent.VK_T);

        robot.keyPress(KeyEvent.VK_TAB); //after pressing a key don't forget to release !!
        robot.keyRelease(KeyEvent.VK_TAB);


//        robot  .keyPress(KeyEvent.VK_CONTROL);
//        robot  .keyPress(KeyEvent.VK_A);
//        robot  .keyRelease(KeyEvent.VK_A);
//        robot  .keyRelease(KeyEvent.VK_CONTROL);

        robot.delay(3000);

        // Select All

        // robot.keyPress(KeyEvent.VK_CONTROL); // Windows users

        // robot.keyRelease(KeyEvent.VK_CONTROL); // Windows users

        // Copy the selected text

        // Delete

        // Paste the copied text


    }

    @Test
    public void robotClassKeyboardTest2() throws InterruptedException {

        Thread.sleep(5000);
        String text = "google.com";

        try {
            Robot robot = new Robot();

            for (Character ch : text.toCharArray()){
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(ch));
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(ch));
                robot.delay(200);
            }

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_F10);
            robot.keyRelease(KeyEvent.VK_F10);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(200);

        } catch (AWTException e) {
            throw new RuntimeException(e);
        }


    }
}