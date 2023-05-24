import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T4_Login_WrongMail {

    By loginpage = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div[5]/div/div/div/a[2]");
    By email =By.xpath("//*[@id=\"email\"]");
    By password = By.xpath("//*[@id=\"password\"]");
    By loginbutton = By.xpath("//*[@id=\"loginButton\"]");
    By WrongMail = By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div");

    @Test

    public void WrongMail(){

        WebDriverManager.chromedriver().setup();


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.n11.com/");
        driver.manage().window().maximize();

        driver.findElement(loginpage).click();
        driver.findElement(email).sendKeys("test");
        driver.findElement(password).sendKeys("Admin_12345");

        WebElement webElement = driver.findElement(loginbutton);

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        executor.executeScript("arguments[0].click();", webElement);

        WebElement t = driver.findElement(WrongMail);
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(2));
        w.until(ExpectedConditions.visibilityOfElementLocated(WrongMail));

        String truewarning = "Lütfen geçerli bir e-posta adresi girin.";
        WebElement warning = driver.findElement(WrongMail);
        Assert.assertTrue(warning.getText().equals(truewarning));

    }

}
