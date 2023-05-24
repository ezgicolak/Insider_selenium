

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
public class T1_Login_Button {

    By loginpage = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div[5]/div/div/div/a[2]");
    By email =By.xpath("//*[@id=\"email\"]");
    By password = By.xpath("//*[@id=\"password\"]");
    By loginbutton = By.xpath("//*[@id=\"loginButton\"]");

    @Test

    public void LoginButton(){

        WebDriverManager.chromedriver().setup();


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.n11.com/");
        driver.manage().window().maximize();



        driver.findElement(loginpage).click();


        driver.findElement(email).sendKeys("ezgi.colak97@gmail.com");
        driver.findElement(password).sendKeys("Admin_12345");

        WebElement webElement = driver.findElement(loginbutton);

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        executor.executeScript("arguments[0].click();", webElement);
    }
}
