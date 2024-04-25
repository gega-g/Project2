package ge.tbc.tbcitacademy.tests.saucedemo;

import ge.tbc.tbcitacademy.data.configuration.ConfigTests;
import ge.tbc.tbcitacademy.steps.SaucedemoMainPageSteps;
import ge.tbc.tbcitacademy.steps.UsersProfilePageSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("saucedemo.com Login Tests")
public class LoginTests extends ConfigTests {
    SaucedemoMainPageSteps saucedemoMainPageSteps = new SaucedemoMainPageSteps();
    UsersProfilePageSteps usersProfilePageSteps = new UsersProfilePageSteps();

    @Test(groups = "SauceDemoLogin",
            description = "Successful Login, pictures visibility validation")
    @Feature("Testing standard_user")
    public void successfulLoginTest(){
        saucedemoMainPageSteps
                .navigateToSaucedemoMainPage()
                .loginUsingStandardUser();
        usersProfilePageSteps
                .picturesVisibility();
    }

    @Test(groups = "SauceDemoLogin",
            description = "Unsuccessful Login using Banned User, X buttons and message appearance validation")
    @Story("Testing locked_out_user")
    public void bannedUserLoginTest(){
        saucedemoMainPageSteps
                .navigateToSaucedemoMainPage()
                .loginUsingLockedOutUser()
                .validateMessageAppearance()
                .validateEveryXIconAppearance();
    }

    @Test(groups = "SauceDemoLogin",
            description = "Successful Login using Problematic User, pictures visibility validation, this test will fail since all pictures are same")
    @Story("Testing problem_user")
    public void problematicLoginTest(){
        saucedemoMainPageSteps
                .navigateToSaucedemoMainPage()
                .problematicLoginTest();
        usersProfilePageSteps
                .picturesVisibility()
                .problemPictures();
    }

    @Test(groups = "SauceDemoLogin",
            description = "Successful Login and Logout, validation of username and password fields emptiness")
    @Feature("Testing standard_user")
    public void logOutTest(){
        saucedemoMainPageSteps
                .navigateToSaucedemoMainPage()
                .loginUsingStandardUser();
        usersProfilePageSteps
                .logOut();
        saucedemoMainPageSteps
                .validateUsernameEmpty();
    }
}