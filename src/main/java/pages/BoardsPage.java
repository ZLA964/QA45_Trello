package pages;

import dto.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


    public boolean validateUrl() {
        return new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlContains("boards"));
    }

    public void createNewBoard(Board board) {
        clickWait(btnCreateNewBoard,5);
        waitNewElementOnPage(sectionCreateBoard, 3);
        inputBoardTitle.sendKeys(board.getBoardTitle());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", btnCreateNewBoard);
        WebElement button = new WebDriverWait(driver,5)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@data-testid='create-board-submit-button']")));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(btnSubmitNewBoard).perform();

        button.click();
//        clickWait(btnSubmitNewBoard,5);
    }

}
