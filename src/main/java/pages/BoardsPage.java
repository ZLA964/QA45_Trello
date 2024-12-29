package pages;

import dto.Board;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardsPage extends BasePage {

    public BoardsPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//li[@data-testid='create-board-tile']")
    WebElement btnCreateNewBoard;
    @FindBy(xpath = "//input[@data-testid='create-board-title-input']")
    WebElement inputBoardTitle;
    @FindBy(xpath = "//button[@data-testid='create-board-submit-button']")
    WebElement btnSubmitNewBoard;
    @FindBy(xpath = "//h2[@title='Create board']/../..")
    WebElement sectionCreateBoard;

    @FindBy(xpath = "//div[@class='board-tile-details is-badged']")
    WebElement firstBoard;

    @FindBy(xpath = "//span[@class='QMKgZFIlTLiEJN']")
    WebElement popUpMessageBoardDelete;

    @FindBy(xpath = "//div[@class='B1uWdim9Jd0dJ9']")
    WebElement btnAccount;
    @FindBy(xpath = "//span[text()='Manage account']")
    WebElement btnManageAccount;

    public void openMyAccount(){
        clickWait(btnAccount,3);
        clickWait(btnManageAccount,3);
    }

    public boolean validatePopUpMessage(String text){
        return validateTextInElementWait(popUpMessageBoardDelete, text, 5);
    }


    public void openFirstBoard(){
        firstBoard.click();
    }


    public boolean validateUrl() {
        return new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlContains("boards"));
    }

    public void createNewBoard(Board board) {
        btnCreateNewBoard.click();
        inputBoardTitle.sendKeys(board.getBoardTitle());
        clickWait(btnSubmitNewBoard,3);
    }

    public void createNewBoardNegative(Board board) {
        btnCreateNewBoard.click();
        inputBoardTitle.sendKeys(board.getBoardTitle());
    }

    public boolean buttonCreateIsNotClickable() {
       return new WebDriverWait(driver,3)
                .until(ExpectedConditions.not(
                        ExpectedConditions.elementToBeClickable(btnSubmitNewBoard)));
    }
}
