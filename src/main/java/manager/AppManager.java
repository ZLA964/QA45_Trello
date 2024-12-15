package manager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AppManager {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();


//  Resize current window to the set dimension //  Dimension d = new Dimension(300, 1080);
//        driver.manage().window().setSize(d);
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null) {
//            driver.quit();
        }
    }
}
