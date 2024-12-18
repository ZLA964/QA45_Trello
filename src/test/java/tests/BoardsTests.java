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

public class BoardsTests extends AppManager {

    @BeforeMethod
    public void login(){
        User user = User.builder()
                .email("1zlv964@gmail.com")
                .password("5+h5sH7D_$*RjaH")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
    }

    @Test
    public void createNewBoardPositiveTest(){
        Board board = Board.builder().boardTitle(generateString(5)).build();
        new BoardsPage(getDriver()).createNewBoard(board);
        Assert.assertTrue(new MyBoardPage(getDriver()).valadateBoardName(board.getBoardTitle(), 5));
    }

    @Test
    public void createNewBoardNegativeTest() {
        Board board = Board.builder().boardTitle("").build();
        new BoardsPage(getDriver()).createNewBoardNegative(board);
        Assert.assertTrue(new BoardsPage(getDriver()).buttonCreateIsNotClickable());
    }


}
