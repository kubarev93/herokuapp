import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ContextMenu extends BaseTest {
    @Test
    public void contextMenuTest() {
        driver.findElement(By.linkText("Context Menu")).click();
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("hot-spot"));
        actions.contextClick(element).build().perform();
        driver.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        ((Alert) alert).accept();
        Assert.assertEquals(text, "You selected a context menu");
        driver.navigate().back();
    }

}
