package ge.tbc.tbcitacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SaucedemoMainPage {
    public SelenideElement usernameField = $(By.id("user-name"));
    public ElementsCollection Xes = $$("[data-prefix='fas']");
    public SelenideElement passwordField = $(By.id("password"));
    public SelenideElement loginButton = $(By.id("login-button"));
    public SelenideElement errorBox = $(".error-message-container");
}
