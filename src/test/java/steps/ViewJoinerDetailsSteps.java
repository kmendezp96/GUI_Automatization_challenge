package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.Checker;
import helpers.DriverGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashBoardPage;
import pages.JoinerDetailsInterface;
import pages.JoinerManagerPage;
import pages.LoginPage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ViewJoinerDetailsSteps {
    WebDriver driver = new ChromeDriver();
    //WebDriver driver = DriverGenerator.generateDriver();
    WebDriverWait wait = new WebDriverWait(driver, Long.parseLong("10"));

    DashBoardPage dashBoardPage;
    JoinerManagerPage joinerManagerPage;
    JoinerDetailsInterface joinerDetailsInterface;

    @Given("^I am logged with email: \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iAmLoggedWithEmailAndPassword(String email, String password){
        driver.get("http://35.174.48.148:3000/");
        LoginPage loginPage = new LoginPage(driver);
        dashBoardPage = loginPage.login(email, password);
    }

    @And("^the joiner \"([^\"]*)\" is created$")
    public void theJoinerIsCreated(String name){
        joinerManagerPage = dashBoardPage.goJoinerManager();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("tr"),6));
        joinerManagerPage.search(name);
    }


    @And("^i am on the view joiner details interface of \"([^\"]*)\"$")
    public void iAmOnTheViewJoinerDetailsInterfaceOf(String name) {
        joinerDetailsInterface = joinerManagerPage.goJoinersDetails(name);
    }


    @When("^I select the Close option$")
    public void iSelectTheCloseOption(){
        joinerDetailsInterface.goBack();
    }

    @Then("^I should see the Joiner Manager interface$")
    public void iShouldSeeTheJoinerManagerInterface(){
        assertThat("The joiners details must not be visible",
                Checker.checkForElementPresence(By.cssSelector("div[class='ui large scrolling modal transition visible active modal-class']"), driver), is(false));
        driver.quit();
    }

    @When("^the Joiner does not have any assigned task$")
    public void theJoinerDoesNotHaveAnyAssignedTask() {
        assertThat("The joiner must not have assigned tasks",
                joinerDetailsInterface.checkAssignedTasks(), is(0));


    }

    @Then("^I should see the message \"([^\"]*)\" instead of accordion task$")
    public void iShouldSeeTheMessageInsteadOfAccordionTask(String text){
        assertThat("The joiners details must not be visible",
                Checker.checkForElementPresence(By.cssSelector("div[class='details-joiner__empty']"), driver), is(true));
        assertThat("The joiners details must not be visible",
                driver.findElement(By.cssSelector("div[class='details-joiner__empty']")).getText(), containsString(text));
    }

    @And("^It does not appear the accordion´s tasks$")
    public void itDoesNotAppearTheAccordionSTasks(){
        assertThat("The joiners details must not be visible",
                Checker.checkForElementPresence(By.cssSelector("div[class='accordion ui details-joiner']"), driver), is(false));
        driver.quit();
    }
}
