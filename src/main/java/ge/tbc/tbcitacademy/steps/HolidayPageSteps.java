package ge.tbc.tbcitacademy.steps;

import com.codeborne.selenide.Selenide;
import ge.tbc.tbcitacademy.data.Constants;
import ge.tbc.tbcitacademy.pages.SwoopMainPage;
import ge.tbc.tbcitacademy.util.Comparator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HolidayPageSteps {
    SwoopMainPage swoopMainPage = new SwoopMainPage();
    Comparator comparator = new Comparator();

    @Step("Fill price filter with numbers")
    public HolidayPageSteps fillPriceFilter(int minPriceValue, int maxPriceValue) {
        swoopMainPage.minPriceField.setValue(String.valueOf(minPriceValue));
        swoopMainPage.maxPriceField.setValue(String.valueOf(maxPriceValue));
        swoopMainPage.searchButton.click();
        Selenide.Wait().until(ExpectedConditions.urlContains(Constants.MINPRICE));
        return this;
    }

    @Step("Validate that all offers are in applied price range")
    public void validatePriceRanges(int minPriceValue, int maxPriceValue){
        comparator.comparePrices(minPriceValue, maxPriceValue);
    }
}