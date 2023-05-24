import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T7_LoginPassword15Character {

    By loginpage = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div[5]/div/div/div/a[2]");
    By email = By.xpath("//*[@id=\"email\"]");
    By password = By.xpath("//*[@id=\"password\"]");
    By loginbutton = By.xpath("//*[@id=\"loginButton\"]");
    By Password15 = By.xpath("//*[@id=\"loginForm\"]/div[2]/div[2]/div");


    @Test
    public void WrongPassword() {

        WebDriverManager.chromedriver().setup();


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.n11.com/");
        driver.manage().window().maximize();

        driver.findElement(loginpage).click();

        driver.findElement(email).sendKeys("ezgi.colak97@gmail.com");
        driver.findElement(password).sendKeys("Admin_12345Admin_12345Admin_12345");

        WebElement webElement = driver.findElement(loginbutton);

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        executor.executeScript("arguments[0].click();", webElement);


        WebElement t = driver.findElement(Password15);
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(2));
        w.until(ExpectedConditions.visibilityOfElementLocated(Password15));

        String truewarning = "Girilen değer en fazla 15 karakter olmalıdır.";
        WebElement warning = driver.findElement(Password15);
        Assert.assertTrue(warning.getText().equals(truewarning));









    }
}
