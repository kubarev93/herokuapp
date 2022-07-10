
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FileUpload extends BaseTest {

    @Test
    public void fileUploading() {
        driver.findElement(By.linkText("File Upload")).click();
        String filePath = System.getProperty("user.dir") + "/src/main/resources/text.txt";
        driver.findElement(By.id("file-upload")).sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();
        driver.navigate().back();
    }
}
