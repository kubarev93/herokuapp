import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {
    @Test
    public void checkAlertText() {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();
        Alert alert = driver.switchTo().alert();
        String textAlert = driver.switchTo().alert().getText();
        Assert.assertEquals(textAlert, "You clicked a button", "Alert is not presented");
        alert.accept();
    }

    @Test
    public void checkWaitUntilButton() {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("timerAlertButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        Assert.assertEquals(driver.switchTo().alert().getText(), "This alert appeared after 5 seconds", "Alert is not presented after waited 5 second");
        driver.switchTo().alert().accept();
    }

    @Test
    public void checkConfirmBox() {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert();
        Assert.assertEquals(driver.switchTo().alert().getText(), "Do you confirm action?", "Wrong text in alert");
        driver.switchTo().alert().dismiss();
        String text = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals(text, "You selected Cancel", "wrong text in confirmation");
    }

    @Test
    public void checkPromtButton() {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("promtButton")).click();
        driver.switchTo().alert();
        Assert.assertEquals(driver.switchTo().alert().getText(), "Please enter your name", "Wrong text in alert");
        String name = "Dima";
        driver.switchTo().alert().sendKeys(name);
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.id("promptResult")).getText(), "You entered " + name);
    }
}