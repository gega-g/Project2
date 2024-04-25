package ge.tbc.tbcitacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class UsersProfilePage {
    public ElementsCollection pictures = $$x("//div[@class='inventory_item_img']");
    public ElementsCollection problemUserPictures = $$("img.inventory_item_img");
    public SelenideElement moreOptionsButton = $(".bm-burger-button");
    public SelenideElement logout = $(By.id("logout_sidebar_link"));
}
