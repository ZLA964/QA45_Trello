package pages;

import dto.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(id = "username")
    WebElement inputEmail;
    @FindBy(id="login-submit")
    WebElement btnContinue;
    @FindBy(id="password")
    WebElement inputPassword;
    @FindBy(xpath = "//button[@id='login-submit' and .//span[text()='Log in']]")
    WebElement btnLogin;

    public void login(User user){
        if(user == null) return;
        inputEmail.sendKeys(user.getEmail());
        btnContinue.click();
//        pause(3);
        waitNewElementOnPage(btnLogin, 3);
        inputPassword.sendKeys(user.getPassword());
        btnLogin.click();
    }}
