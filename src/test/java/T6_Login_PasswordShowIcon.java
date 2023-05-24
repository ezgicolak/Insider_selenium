import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class T6_Login_PasswordShowIcon {
    By loginpage = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div[5]/div/div/div/a[2]");

    By password = By.xpath("//*[@id=\"password\"]");

    By eyeicon = By.xpath("//*[@id=\"loginForm\"]/div[2]/div[1]");

    @Test

    public void PasswordShowIcon(){

        WebDriverManager.chromedriver().setup();


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.n11.com/");
        driver.manage().window().maximize();

        driver.findElement(loginpage).click();
        driver.findElement(password).sendKeys("Admin_12345");

        WebElement webElement = driver.findElement(eyeicon);

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        executor.executeScript("arguments[0].click();", webElement);


    }




}
