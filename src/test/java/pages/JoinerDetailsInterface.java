package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class JoinerDetailsInterface extends BasePage{
    private WebDriver driver;
    @FindBy(how = How.CSS, using = "div[class='ui large scrolling modal transition visible active modal-class']")
    private WebElement detailsPopUp;
    @FindBy(how = How.CSS, using = "button[class='ui button ui primary button']")
    private WebElement closeButton;

    private static JoinerDetailsInterface joinerDetailsInterface;

    public  static JoinerDetailsInterface getJoinerDetailsInterface(WebDriver driver) {

        if (joinerDetailsInterface==null) {
            joinerDetailsInterface=new JoinerDetailsInterface(driver);
        }
        return joinerDetailsInterface;
    }

    private JoinerDetailsInterface(WebDriver driver){
        super(driver);
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Long.parseLong("10"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='ui large scrolling modal transition visible active modal-class']")));
    }

    public WebElement getDetailsPopUp() {
        return detailsPopUp;
    }

    public void goBack(){
        WebDriverWait wait = new WebDriverWait(driver, Long.parseLong("10"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[class='ui button ui primary button']")));
        closeButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        this.detailsPopUp = driver.findElement(By.cssSelector("div[class='ui large scrolling modal transition visible active modal-class']"));
        //return driver.findElement(By.cssSelector("div[class='ui large scrolling modal transition visible active modal-class']"));
    }

}
