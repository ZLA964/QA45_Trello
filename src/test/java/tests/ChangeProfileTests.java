package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AtlassianProfilePage;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static utils.RandomUtils.generateString;

public class ChangeProfileTests extends AppManager {
    BoardsPage boardsPage;

    @BeforeMethod
    public void login(Method method){
        User user = User.builder()
                .email("1zlv964@gmail.com")
                .password("5+h5sH7D_$*RjaH")
                .build();
        logger.info("start test --> " + method.getName()+" with data: " + user );
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        boardsPage = new BoardsPage(getDriver());
    }

    @Test
    public void changeProfilePhoto(){
        boardsPage.openMyAccount();
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        System.out.println(tabs);
        String photoPath = "src/main/resources/3a48975929e9ffc6b77ff9ca0a706b8c.jpg";
        getDriver().switchTo().window(tabs.get(1));
        AtlassianProfilePage atlassianProfilePage = new AtlassianProfilePage(getDriver());
        atlassianProfilePage.changeMyProfilePhoto(photoPath);
        Assert.assertTrue(atlassianProfilePage.validateMessage("We've uploaded your new avatar. It may take a few minutes to display everywhere."));

    }

    @Test
    public void changeProfilePhotoNegativeWrongFormatFile(){
        boardsPage.openMyAccount();
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        System.out.println(tabs);
        String photoPath = "src/main/resources/board_file_dp.csv";
        getDriver().switchTo().window(tabs.get(1));
        AtlassianProfilePage atlassianProfilePage = new AtlassianProfilePage(getDriver());
        atlassianProfilePage.changeMyProfilePhoto(photoPath);
      Assert.assertTrue(atlassianProfilePage.validateMessWrongFormat("Upload a photo or select from some default options"));

    }


}
