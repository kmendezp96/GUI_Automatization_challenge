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
    WebDriverWait wait;
    //@FindBy(how = How.XPATH, using = "//button[@class, 'submit' and text()='Clonse']")
    @FindBy(how = How.CSS, using = "div[class='ui large scrolling modal transition visible active modal-class']")
    private WebElement detailsPopUp;

    @FindBy(how = How.XPATH, using = "//button[contains(.,'Close')]")
    private WebElement closeButton;

    @FindBy(how = How.CSS, using = "div[class='accordion ui details-joiner']")
    private WebElement accordion;
    @FindBy(how = How.XPATH, using = "//button[contains(.,'Assign Tasks')]")
    private WebElement assignButton;

    /*private static JoinerDetailsInterface joinerDetailsInterface;

    public  static JoinerDetailsInterface getJoinerDetailsInterface(WebDriver driver) {

        if (joinerDetailsInterface==null) {
            joinerDetailsInterface=new JoinerDetailsInterface(driver);
        }
        return joinerDetailsInterface;
    }*/

    public JoinerDetailsInterface(WebDriver driver){
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Long.parseLong("30"));

    }

    public WebElement getDetailsPopUp() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='ui large scrolling modal transition visible active modal-class']")));
        return detailsPopUp;
    }

    /*public boolean checkPopUp() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Close')]")));
        return checkForElementPresence(By.xpath("//button[contains(.,'Close')]")) && checkForElementPresence(By.xpath("//button[contains(.,'Assign Tasks')]"));
    }*/

    public void goBack(){

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Close')]")));
        closeButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

/*
    public void checkAssignedTasks(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='accordion ui details-joiner']")));
        accordion = driver.findElement(By.cssSelector("div[class='accordion ui details-joiner']"));
    }*/

}
