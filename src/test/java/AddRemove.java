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
public class AddRemove {
    WebDriver driver;

    @BeforeClass
    public void play () {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public  void Add(){
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[@onclick=\"addElement()\"]")).click();
        driver.findElement(By.xpath("//button[@onclick=\"addElement()\"]")).click();
        driver.findElement(By.xpath("//button[@onclick=\"deleteElement()\"]")).click();
        List<WebElement> forms = driver.findElements(By.id("elements"));
        int count = forms.size();
        Assert.assertEquals(count,1);
    }



}
