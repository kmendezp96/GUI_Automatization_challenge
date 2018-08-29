package steps;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashBoardPage;
import pages.LoginPage;

public class GlobalSteps {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Long.parseLong("10"));
    DashBoardPage dashBoardPage;
    @Given("^I am already logged with email: \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iAmAlreadyLoggedWithEmailAndPassword(String email, String password) {
        driver.get("http://35.174.48.148:3000/");
        LoginPage loginPage = LoginPage.getLoginPage(driver);
        dashBoardPage = loginPage.login(email, password);
    }
}
