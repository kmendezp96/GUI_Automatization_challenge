package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.How;

public class DashBoardPage extends BasePage {
    private WebDriver driver;

    @FindBy(how = How.CSS, using = "a[class='item joiner-manager']")
    private WebElement itemJoinerManager;

    @FindBy(how = How.CSS, using = "a[class='item create-joiner']")
    private WebElement itemCreateJoiner;
    /*private static DashBoardPage dashBoardPage;

    public  static DashBoardPage getDashBoardPage(WebDriver driver) {

        if (dashBoardPage==null) {
            dashBoardPage=new DashBoardPage(driver);
        }
        return dashBoardPage;
    }*/

    public DashBoardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public JoinerManagerPage goJoinerManager() {
        WebDriverWait wait = new WebDriverWait(driver, Long.parseLong("10"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[class='item joiner-manager']")));
        itemJoinerManager.click();
        return new JoinerManagerPage(driver);

    }

    public CreateJoinerPage goCreateJoiner() {
        WebDriverWait wait = new WebDriverWait(driver, Long.parseLong("10"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[class='item create-joiner']")));
        itemCreateJoiner.click();
        return new CreateJoinerPage(driver);

    }
}