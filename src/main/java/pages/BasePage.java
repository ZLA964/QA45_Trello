package pages;

import manager.AppManager;
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



}
