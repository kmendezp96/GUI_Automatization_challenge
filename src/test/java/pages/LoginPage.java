package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    @FindBy(how = How.NAME, using = "email")
    private WebElement emailInput;

    @FindBy(how = How.NAME, using = "password")
    private WebElement passwordInput;
    private WebDriver driver;
    /*private static LoginPage loginPage;

    public  static LoginPage getLoginPage(WebDriver driver) {

        if (loginPage==null) {
            loginPage=new LoginPage(driver);
        }
        return loginPage;
    }*/

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public DashBoardPage login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        WebDriverWait wait = new WebDriverWait(driver, Long.parseLong("10"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("logIn")));
        driver.findElement(By.name("logIn")).click();

        return  new DashBoardPage(driver);
    }
}
