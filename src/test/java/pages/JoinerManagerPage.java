package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.How;

import java.util.List;

public class JoinerManagerPage extends BasePage {
    private WebDriver driver;
    @FindBy(how = How.CLASS_NAME, using = "prompt")
    private WebElement searchInput;

    @FindBy(how = How.CSS, using = "i[class='trash alternate outline link icon']")
    private WebElement DelFilter;

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
    }

    public String search(String query) {
        WebDriverWait wait = new WebDriverWait(driver, Long.parseLong("10"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("prompt")));
        //searchInput = driver.findElement(By.className("prompt"));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("tr"),6));
        searchInput.sendKeys(query);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(query)));

        return driver.findElement(By.partialLinkText(query)).getText();
    }

    public JoinerDetailsInterface goJoinersDetails(String joiner){
        WebDriverWait wait = new WebDriverWait(driver, Long.parseLong("10"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(joiner)));
        driver.findElement(By.partialLinkText(joiner)).click();
        return new JoinerDetailsInterface(driver);
    }

    public void removeFilter(){
        WebDriverWait wait = new WebDriverWait(driver, Long.parseLong("10"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("i[class='trash alternate outline link icon']")));
        DelFilter.click();
    }

}
