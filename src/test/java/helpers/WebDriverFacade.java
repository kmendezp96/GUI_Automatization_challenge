package helpers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class WebDriverFacade {

    private static final long WAIT_SECONDS = 5;

    private WebDriver driver;

    public WebDriverFacade() {
        driver = new ChromeDriver();;
    }

    public void start(String url) {
        driver.get(url);
    }

    public void stop() {
        driver.quit();
    }

    public WebElement findElement(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, WAIT_SECONDS);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception ex) {
            return NullWebElement.getNull();
        }
    }

    public List<WebElement> findElements(By by) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_SECONDS);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
}