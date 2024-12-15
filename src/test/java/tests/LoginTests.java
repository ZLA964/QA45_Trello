package tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends AppManager {

    @Test
    public void loginPositiveTest(){

        User user = User.builder()
                .email("1zlv964@gmail.com")
                .password("5+h5sH7D_$*RjaH")
                .build();

        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        Assert.assertTrue(new BoardsPage(getDriver()).validateUrl());
    }
}
