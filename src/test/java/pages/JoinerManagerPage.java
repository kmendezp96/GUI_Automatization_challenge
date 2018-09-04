package pages;

import helpers.JsonHelper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.How;

import java.util.List;

import static net.serenitybdd.rest.SerenityRest.given;

public class JoinerManagerPage extends BasePage {
    private WebDriver driver;
    WebDriverWait wait;
    @FindBy(how = How.CLASS_NAME, using = "prompt")
    private WebElement searchInput;

    @FindBy(how = How.CSS, using = "i[class='trash alternate outline link icon']")
    private WebElement DelFilter;

    @FindBy(how = How.CSS, using = "div[class='ui pagination menu']")
    private WebElement paginationBar;

    int numberOfjoiners;
    //private static JoinerManagerPage joinerManagerPage;

    /*public  static JoinerManagerPage getJoinerManagerPage(WebDriver driver) {

        if (joinerManagerPage==null) {
            joinerManagerPage=new JoinerManagerPage(driver);
        }
        return joinerManagerPage;
    }*/

    public JoinerManagerPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Long.parseLong("3"));
        this.numberOfjoiners = this.takeNumberOfjoiners();
    }

    public int takeNumberOfjoiners(){
        RequestSpecification request = given().contentType("application/json");
        Response response = request.when().get("http://35.173.104.34:9002/api/joiners");
        return JsonHelper.getJsonObjectListFromResponse(response).size();
    }

    public String search(String query) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("prompt")));
        //searchInput = driver.findElement(By.className("prompt"));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("tr"),6));
        searchInput.sendKeys(query);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(query)));
        return driver.findElement(By.partialLinkText(query)).getText();
    }

    public JoinerDetailsInterface goJoinersDetails(String joiner){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(joiner)));
        driver.findElement(By.partialLinkText(joiner)).click();
        return new JoinerDetailsInterface(driver);
    }

    public void removeFilter(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("i[class='trash alternate outline link icon']")));
        DelFilter.click();
    }



    public boolean checkNumberOfJoiners(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='ui pagination menu']")));
        List<WebElement> pagButtons = paginationBar.findElements(By.tagName("a"));

        String lastPageButtonText = pagButtons.get(pagButtons.size()-3).getText();
        int maxPag = Integer.parseInt(lastPageButtonText);

        if (Math.ceil((float)numberOfjoiners/5) ==maxPag){
            return true;
        }
        return false;
    }

}
