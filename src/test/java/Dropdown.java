import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Dropdown {
    WebDriver driver;


    @BeforeClass
    public void play() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void checkingDropdown() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.findElement(By.xpath("//select[@id='dropdown']")).click();
        driver.findElement(By.xpath("//select[@id='dropdown']/option[2]")).click();
        driver.findElement(By.xpath("//select[@id='dropdown']/option[2]")).isDisplayed();
        driver.findElement(By.xpath("//select[@id='dropdown']")).click();
        driver.findElement(By.xpath("//select[@id='dropdown']/option[3]")).click();
        driver.findElement(By.xpath("//select[@id='dropdown']/option[3]")).isDisplayed();
        List<WebElement> list = this.driver.findElements(By.xpath("//*[@id=\"dropdown\"]/option"));
        int countlements = list.size();
        Assert.assertEquals(countlements, 3);
    }
}