package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class ViewJoinerDetailsSteps {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Long.parseLong("10"));

    DashBoardPage dashBoardPage;
    JoinerManagerPage joinerManagerPage;
    JoinerDetailsInterface joinerDetailsInterface;

    String queryResult;

    @And("^the joiner \"([^\"]*)\" is created$")
    public void theJoinerIsCreated(String arg0){
        joinerManagerPage = dashBoardPage.go();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("tr"),6));
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
        driver.quit();
        assertThat("The joiners details must not be visible",
                joinerDetailsInterface.getDetailsPopUp(), is(nullValue()));
    }



}
