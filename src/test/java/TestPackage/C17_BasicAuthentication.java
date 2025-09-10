package TestPackage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C17_BasicAuthentication {
    /*
    Go to URL: https://the-internet.herokuapp.com/basic_auth
    Username: admin
    Password: admin


    Syntax:  driver.get("https://url"/);


    Authenticate using the above method and test data.
    https://the-internet.herokuapp.com/basic_auth
    Verify the congratulations message.
     */

    String url = "https://the-internet.herokuapp.com/basic_auth";
    WebDriver  driver;

    @Test
    void authenticationTest() throws InterruptedException {


            WebDriver driver = new ChromeDriver();

            driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
            Thread.sleep(2000);
            Assertions.assertTrue(driver.findElement(By.xpath("//h3[.='Basic Auth']")).isDisplayed());
            driver.quit();



    }


    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}