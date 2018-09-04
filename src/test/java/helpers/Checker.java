package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checker {
    public static boolean checkForElementPresence(By locator, WebDriver driver) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public static boolean checkForElementPresence(WebElement parentElement, By locator, WebDriver driver) {
        try {
            parentElement.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
