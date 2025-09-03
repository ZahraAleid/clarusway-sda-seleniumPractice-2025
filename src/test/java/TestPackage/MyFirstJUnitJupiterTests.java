package TestPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstJUnitJupiterTests {

    WebDriver driver;
    @Test
    void myFirstTest() {
        // Test code goes here
        System.out.println("hello my first test");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        Assertions.assertEquals("GoolgleX", driver.getTitle());

        //Assertions.assert
        driver.quit();
    }


}
