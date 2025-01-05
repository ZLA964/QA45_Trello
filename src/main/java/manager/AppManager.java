package manager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.WDListener;

import java.lang.reflect.Method;

public class AppManager {
//    private WebDriver driver;

    private EventFiringWebDriver driver;

    public Logger logger = LoggerFactory.getLogger(AppManager.class);


    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setUp(Method method){
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--force-device-scale-factor=0.8"); // set zoom 80%

//        driver = new ChromeDriver();
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.manage().window().maximize();
        logger.info("start method --> " + method.getName());

        driver.register(new WDListener());


//  Resize current window to the set dimension //  Dimension d = new Dimension(300, 1080);
//        driver.manage().window().setSize(d);
    }

    @AfterMethod
    public void tearDown(Method method){
        logger.info("stop test --> " + method.getName());
        if(driver != null) {
//            driver.quit();
        }
    }
}
