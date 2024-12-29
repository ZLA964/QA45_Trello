package manager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class AppManager {
    private WebDriver driver;

    public Logger logger = LoggerFactory.getLogger(AppManager.class);


    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setUp(Method method){
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--force-device-scale-factor=0.8"); // set zoom 80%

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        logger.info("start method --> " + method.getName());


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
