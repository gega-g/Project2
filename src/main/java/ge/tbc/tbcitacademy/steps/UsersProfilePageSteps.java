package ge.tbc.tbcitacademy.steps;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.data.Constants;
import ge.tbc.tbcitacademy.pages.UsersProfilePage;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.HashSet;
import java.util.Set;

public class UsersProfilePageSteps {
    UsersProfilePage usersProfilePage = new UsersProfilePage();

    @Step("Validate that all pictures are displayed and visible")
    public UsersProfilePageSteps picturesVisibility(){
        for (SelenideElement pic:usersProfilePage.pictures){
            Assert.assertTrue(pic.isDisplayed());
        }
        return this;
    }

    @Step("Logout from account")
    public UsersProfilePageSteps logOut(){
        usersProfilePage.moreOptionsButton.click();
        usersProfilePage.logout.click();
        return this;
    }

    public UsersProfilePageSteps problemPictures(){
            Set<String> set = new HashSet<>();
            usersProfilePage.problemUserPictures.forEach(element -> {
                String src = element.getAttribute("src");
                set.add(src);
            });
            Assert.assertEquals(set.size(), usersProfilePage.problemUserPictures.size(), Constants.PROBLEMUSERMESSAGE);
        return this;
    }
}
