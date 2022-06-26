import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
//test
public class Checkboxes {
    WebDriver driver;
    @BeforeClass
    public void play() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void uncheck() {
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        driver.findElement(By.cssSelector("[type=checkbox]"));
        Assert.assertFalse(driver.findElement(By.cssSelector("[type=checkbox]")).isSelected());
        driver.findElement(By.cssSelector("[type=checkbox]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("[type=checkbox]")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//input[2]")).isSelected());
        driver.findElement(By.xpath("//input[2]")).click();
        Assert.assertFalse(driver.findElement(By.xpath("//input[2]")).isSelected());

    }
}
