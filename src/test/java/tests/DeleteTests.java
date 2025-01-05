package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyBoardPage;

import static utils.RandomUtils.*;

public class DeleteTests extends AppManager {
    BoardsPage boardsPage;


    @BeforeMethod
    public void login(){
        User user = User.builder()
                .email("1zlv964@gmail.com")
                .password("5+h5sH7D_$*RjaH")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        boardsPage = new BoardsPage(getDriver());
        Board board = Board.builder()
                .boardTitle(generateString(6)).build();
        boardsPage.createNewBoard(board);
    }

    @Test(invocationCount = 1)
    public void deleteFistBoardPositiveTest(){
        boardsPage.openFirstBoard();
        new MyBoardPage(getDriver()).deleteBoard();
        Assert.assertTrue(boardsPage.validatePopUpMessage("Board deleted."));
    }

}
