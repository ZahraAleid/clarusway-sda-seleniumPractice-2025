package TestPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_XPath {

    WebDriver driver;

    @BeforeEach
    void setup(){
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
     driver.get("https://thinking-tester-contact-list.herokuapp.com/");
    }

    @AfterEach
    void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    void absoluteXPath(){
        WebElement emailInput = driver.findElement(By.xpath("/html/body/div/form/p[1]/input"));
        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/form/p[2]/input"));
        passwordInput.sendKeys("JohndoeSDA@yahoo.com");
        emailInput.sendKeys("John.123", Keys.ENTER);


    }

    @Test
    void relativeXPath(){
        WebElement emailInput = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        emailInput.sendKeys("JohndoeSDA@yahoo.com");
        passwordInput.sendKeys("John.123", Keys.ENTER);
        WebElement logoutButton = driver.findElement(By.xpath("//button[@id='logout']"));
        Assertions.assertTrue(logoutButton.isDisplayed());

    }
}
