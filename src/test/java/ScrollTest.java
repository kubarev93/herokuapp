import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ScrollTest extends BaseTest {
    @Test
    public void checkScroll (){
       driver.get("https://www.onliner.by");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ( "window.scrollBy(0,100)" , "" );
        WebElement first = driver.findElement(By.xpath("//h2/a[text()='Кошелек']"));
        js.executeScript("arguments[0].scrollIntoView(true);",first);
        js.executeScript("window.scrollTo(0, document.querySelector(\".g-middle\").scrollHeight);");
        js.executeScript("window.scrollTo(0, -document.querySelector(\".g-middle\").scrollHeight);");
    }
}
