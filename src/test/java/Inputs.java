import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Inputs {
    WebDriver driver;

    @BeforeClass
    public void play() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void testingInputsUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/inputs");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP, "12");
        Assert.assertEquals(driver.findElement(By.tagName("input")).getAttribute("value"), 12);
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP, "22");
        Assert.assertEquals(driver.findElement(By.tagName("input")).getAttribute("value"), "122");
    }

    @Test
    public void testingInputsDown() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/inputs");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN, "11");
        Assert.assertEquals(driver.findElement(By.tagName("input")).getAttribute("value"), -11);
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN, "22");
        Assert.assertEquals(driver.findElement(By.tagName("input")).getAttribute("value"), "-122");
    }

    @Test
    public void testingInputsChwracters() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/inputs");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN, "test");
        Assert.assertEquals(driver.findElement(By.tagName("input")).getAttribute("value"), "test");
        Assert.assertEquals(driver.findElement(By.tagName("input")).getAttribute("value"), "-1test");
    }

}
