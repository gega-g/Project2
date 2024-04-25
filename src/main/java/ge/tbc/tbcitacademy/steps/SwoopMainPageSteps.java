package ge.tbc.tbcitacademy.steps;

import com.codeborne.selenide.WebDriverRunner;
import ge.tbc.tbcitacademy.data.Constants;
import ge.tbc.tbcitacademy.data.URLS;
import ge.tbc.tbcitacademy.pages.SwoopMainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.open;

public class SwoopMainPageSteps {

    SwoopMainPage swoopMainPage = new SwoopMainPage();

    @Step("Navigate to swoop.ge")
    public SwoopMainPageSteps navigateToSwoopMainPage() {
        open(URLS.SWOOPMAINPAGE);
        return this;
    }

    @Step("Navigate to holiday page")
    public SwoopMainPageSteps navigateToHolidayPage() {
        swoopMainPage.holiday.click();
        return this;
    }

    @Step("Click on categories dropdown")
    public SwoopMainPageSteps clickOnCategoriesDropdown() {
        swoopMainPage.categories.click();
        return this;
    }

    @Step("Hover on food element")
    public SwoopMainPageSteps hoverOnFood() {
        new Actions(WebDriverRunner.getWebDriver()).moveToElement(swoopMainPage.food).perform();
        return this;
    }

    @Step("Click on Bars and restaurants option")
    public SwoopMainPageSteps clickOnBars() {
        swoopMainPage.bars.click();
        return this;
    }

    @Step("Select voucher option in payment options")
    public SwoopMainPageSteps selectVoucherOption(){
        swoopMainPage.voucher.click();
        return this;
    }

    @Step("Fill prices filter")
    public SwoopMainPageSteps fillPrices(){
        swoopMainPage.minPriceField.sendKeys("20");
        swoopMainPage.maxPriceField.sendKeys("50");
        swoopMainPage.searchButton.click();
        return this;
    }

    @Step("Set location to Saburtalo")
    public SwoopMainPageSteps changeLocation(){
        swoopMainPage.locationDropdownButton.click();
        swoopMainPage.saburtalo.click();
        return this;
    }

    @Step("Clear all filters")
    public SwoopMainPageSteps clearAllFilters(){
        swoopMainPage.clearFilters.click();
        return this;
    }

    @Step("Validate after clearing that the options are set to default")
    public SwoopMainPageSteps validateDefaultOptions(){
        swoopMainPage.defaultDropdown.shouldHave(text(Constants.DEFAULTLOCATION));
        swoopMainPage.all.shouldBe(checked);
        swoopMainPage.maxPriceField.shouldHave(attribute(Constants.PLACEHOLDER, Constants.FROM));
        swoopMainPage.minPriceField.shouldHave(attribute(Constants.PLACEHOLDER, Constants.TO));
        return this;
    }
}
