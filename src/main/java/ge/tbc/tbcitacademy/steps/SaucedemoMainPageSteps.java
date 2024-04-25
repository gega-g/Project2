package ge.tbc.tbcitacademy.steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.data.Constants;
import ge.tbc.tbcitacademy.data.URLS;
import ge.tbc.tbcitacademy.pages.SaucedemoMainPage;
import ge.tbc.tbcitacademy.util.TableParser;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.open;

public class SaucedemoMainPageSteps {
    SoftAssert sfa = new SoftAssert();
    TableParser tableParser = new TableParser();
    SaucedemoMainPage saucedemoMainPage = new SaucedemoMainPage();

    @Step("Navigate to saucedemo.com")
    public SaucedemoMainPageSteps navigateToSaucedemoMainPage(){
        open(URLS.SAUCEDEMOMAINPAGE);
        return this;
    }

    @Step("Login using standard_user")
    public SaucedemoMainPageSteps loginUsingStandardUser() {
        saucedemoMainPage.usernameField.sendKeys(tableParser.getUsernameById("1"));
        saucedemoMainPage.passwordField.sendKeys(tableParser.getPassword());
        saucedemoMainPage.loginButton.click();
        return this;
    }

    @Step("Login using locked_out_user")
    public SaucedemoMainPageSteps loginUsingLockedOutUser() {
        saucedemoMainPage.usernameField.sendKeys(tableParser.getUsernameById("2"));
        saucedemoMainPage.passwordField.sendKeys(tableParser.getPassword());
        saucedemoMainPage.loginButton.click();
        return this;
    }

    @Step("Login using problem_user")
    public SaucedemoMainPageSteps problematicLoginTest() {
        saucedemoMainPage.usernameField.sendKeys(tableParser.getUsernameById("3"));
        saucedemoMainPage.passwordField.sendKeys(tableParser.getPassword());
        saucedemoMainPage.loginButton.click();
        return this;
    }

    @Step("Validate error message pop up after unsuccessful login attempt")
    public SaucedemoMainPageSteps validateMessageAppearance(){
        sfa.assertTrue(saucedemoMainPage.errorBox.isDisplayed());
        sfa.assertEquals(saucedemoMainPage.errorBox.getText(), Constants.ERRORMESSAGE);
        sfa.assertAll();
        return this;
    }

    public SaucedemoMainPageSteps validateEveryXIconAppearance(){
        for (SelenideElement x: saucedemoMainPage.Xes){
            sfa.assertTrue(x.isDisplayed());
        }
        sfa.assertAll();
        return this;
    }

    @Step("Validate that fields are empty after logout")
    public SaucedemoMainPageSteps validateUsernameEmpty(){
        Selenide.Wait().until(ExpectedConditions.elementToBeClickable(saucedemoMainPage.loginButton));
        sfa.assertTrue(saucedemoMainPage.usernameField.getValue().isEmpty());
        sfa.assertTrue(saucedemoMainPage.passwordField.getValue().isEmpty());
        sfa.assertAll();
        return this;
    }
}