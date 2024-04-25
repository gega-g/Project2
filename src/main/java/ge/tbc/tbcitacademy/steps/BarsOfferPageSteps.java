package ge.tbc.tbcitacademy.steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbc.tbcitacademy.data.URLS;
import ge.tbc.tbcitacademy.pages.BarsOfferPage;
import io.qameta.allure.Step;
import org.testng.Assert;

public class BarsOfferPageSteps {
    BarsOfferPage barsOfferPage = new BarsOfferPage();

    @Step("Validating appearance of new FB window after clicking on share")
    public BarsOfferPageSteps validateFBAppearance(){
        Selenide.switchTo().window(1);
        String currentUrl = WebDriverRunner.url();
        Assert.assertTrue(currentUrl.contains(URLS.FB));
        return this;
    }

    @Step("Click Share button")
    public BarsOfferPageSteps clickShare(){
        barsOfferPage.share.click();
        return this;
    }
}
