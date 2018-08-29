package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.RunnerHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashBoardPage;
import pages.JoinerDetailsInterface;
import pages.JoinerManagerPage;
import pages.LoginPage;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class ConsultJoinersSteps extends RunnerHelper {
     WebDriver driver = new ChromeDriver();
     WebDriverWait wait = new WebDriverWait(driver, Long.parseLong("10"));

    DashBoardPage dashBoardPage;
    JoinerManagerPage joinerManagerPage;
    JoinerDetailsInterface joinerDetailsInterface;
    String queryResult;

    @Given("^I am already logged with email: \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iAmAlreadyLoggedWithEmailAndPassword(String email, String password) {
        driver.get("http://35.174.48.148:3000/");
        LoginPage loginPage = new LoginPage(driver);
        dashBoardPage = loginPage.login(email, password);
    }

    @And("^i am on the Joiner Manager interface$")
    public void iAmOnTheJoinerManagerInterface(){
        joinerManagerPage = dashBoardPage.go();
    }

    @And("^there are joiners created$")
    public void thereAreJoinersCreated(){
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("tr"),6));
    }

    @When("^I enter \"([^\"]*)\" in the search field$")
    public void iEnterInTheSearchField(String query){
        queryResult = joinerManagerPage.search(query);
    }

    @Then("^I should see a list of the joiners that include those specific \"([^\"]*)\" in their names$")
    public void iShouldSeeAListOfTheJoinersThatIncludeThoseSpecificInTheirNames(String query){
        driver.quit();
        assertThat("In the joiners list must be a joiner with the query included in its' name",
                queryResult,
                containsString(query));
    }


    @When("^I choose the joiners \"([^\"]*)\"$")
    public void iChooseTheJoiners(String name){
        joinerDetailsInterface = joinerManagerPage.goJoinersDetails(name);
    }

    @Then("^I should see the interface with the Joiners’ information$")
    public void iShouldSeeTheInterfaceWithTheJoinersInformation(){
        driver.quit();
        assertThat("A new pop up must be visible",
                joinerDetailsInterface.getDetailsPopUp(),is(notNullValue()));
    }

    @And("^a filter of Joiners using \"([^\"]*)\"  was made$")
    public void aFilterOfJoinersUsingWasMade(String query){
        queryResult = joinerManagerPage.search(query);
    }

    @When("^I choose clear option$")
    public void iChooseClearOption() {
        joinerManagerPage.removeFilter();

    }

    @Then("^I should see the list of all existing Joiners included \"([^\"]*)\"$")
    public void iShouldSeeTheListOfAllExistingJoinersIncluded(String name){

        List<WebElement> links = driver.findElement(By.cssSelector("table[class='ui celled table']" )).findElements(By.tagName("a"));
        boolean cond = false;
        for(int i = 0;i<links.size();i++){
            if(links.get(i).getText().contains(name)){
                cond = true;
            }
        }
        assertThat("A new pop up must be visible",
               cond,is(true)
                );
        driver.quit();
    }
}
