package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import helpers.DriverGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JoinerCreationSteps {
    WebDriver driver = new ChromeDriver();
    //WebDriver driver = DriverGenerator.generateDriver();
    WebDriverWait wait = new WebDriverWait(driver, Long.parseLong("10"));

    DashBoardPage dashBoardPage;
    CreateJoinerPage createJoinerPage;
    String queryResult;

    @Given("^I am already logged using email: \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iAmAlreadyLoggedUsingEmailAndPassword(String email, String password) {
        driver.get("http://35.174.48.148:3000/");
        LoginPage loginPage = new LoginPage(driver);
        dashBoardPage = loginPage.login(email, password);
    }

    @And("^i am on the create joiner interface$")
    public void iAmOnTheCreateJoinerInterface() {
        createJoinerPage = dashBoardPage.goCreateJoiner();
    }

    @When("^I select one \"([^\"]*)\"$")
    public void iSelectOne(String discipline) {
        createJoinerPage.SelectDiscipline(discipline);
    }



    @Then("^the fields: \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"have to be auto-populated with the belonged default value$")
    public void theFieldsAndHaveToBeAutoPopulatedWithTheBelongedDefaultValue(String LineManager,
                                                                             String careerCoach, String buddy) {
        assertThat("The joiners details must not be visible",
                createJoinerPage.CheckAutoPopulatedFields(LineManager, careerCoach, buddy), is(true));
        driver.quit();
    }
}
