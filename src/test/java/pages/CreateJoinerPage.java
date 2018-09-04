package pages;

import helpers.Checker;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CreateJoinerPage extends BasePage {
    private WebDriver driver;
    WebDriverWait wait;

    @FindBy(how = How.NAME, using = "discipline")
    private WebElement disciplineField;
    private WebElement discipline;

    @FindBy(how = How.NAME, using = "buddy")
    private WebElement buddyField;
    @FindBy(how = How.NAME, using = "careerCoach")
    private WebElement careerCoachField;
    @FindBy(how = How.NAME, using = "lineManager")
    private WebElement lineManagerField;

    public CreateJoinerPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Long.parseLong("10"));
    }

    public void SelectDiscipline(String disciplineName){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name( "discipline")));
        disciplineField.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(.,'"+disciplineName+"')]")));
        discipline = driver.findElement(By.xpath("//span[contains(.,'"+disciplineName+"')]"));
        discipline.click();


    }

    public boolean CheckAutoPopulatedFields(String LineManager, String careerCoach, String buddy){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(.,'"+buddy+"')]")));
        buddyField.findElements(By.xpath("//div[contains(.,'"+buddy+"')]"));
        careerCoachField.findElements(By.xpath("//div[contains(.,'"+careerCoach+"')]"));
        lineManagerField.findElements(By.xpath("//div[contains(.,'"+LineManager+"')]"));
        return Checker.checkForElementPresence(buddyField, By.xpath("//div[contains(.,'"+buddy+"')]"), driver) &&
                Checker.checkForElementPresence(careerCoachField, By.xpath("//div[contains(.,'"+careerCoach+"')]"), driver) &&
                Checker.checkForElementPresence(lineManagerField,By.xpath("//div[contains(.,'"+LineManager+"')]"), driver);

    }



}
