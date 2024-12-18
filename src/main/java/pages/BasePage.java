package pages;

import manager.AppManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BasePage extends AppManager {
    static WebDriver driver;

    public static void setDriver(WebDriver wD) {
        BasePage.driver = wD;
    }

    public void pause(int timeInSeconds){
        try {
            Thread.sleep(timeInSeconds*1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // wait new Element on Page
    public void waitNewElementOnPage(WebElement element, int timeoutInSeconds) {
        new WebDriverWait(driver, timeoutInSeconds)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void clickWait(WebElement element, int time){
        new WebDriverWait(driver,time)
                .until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }

    public boolean validateTextInElementWait(WebElement element, String text, int time) {
        try {
            return new WebDriverWait(driver, time)
                    .until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (NoSuchElementException | TimeoutException exception){
            System.out.println("Create Exception. " + exception.getMessage());
            return false;
        }
    }

}
