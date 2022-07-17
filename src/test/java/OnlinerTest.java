import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class OnlinerTest extends BaseTest {
    @Test
    public void checkSearchFelled() {
        driver.get("https://www.onliner.by/");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Тостер");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='modal-iframe']"));
        driver.switchTo().frame(iframe);
        String firstItem = driver.findElement(By.xpath("//div[@class='product__title'][1]/a")).getText();
        driver.findElement(By.xpath("//input[@type='text']")).clear();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(firstItem);


    }
}
