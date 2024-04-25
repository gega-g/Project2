package ge.tbc.tbcitacademy.tests.swoop;

import ge.tbc.tbcitacademy.dataprovider.MinMaxPriceDataprovider;
import ge.tbc.tbcitacademy.steps.BarsOfferPageSteps;
import ge.tbc.tbcitacademy.steps.BarsPageSteps;
import ge.tbc.tbcitacademy.steps.HolidayPageSteps;
import ge.tbc.tbcitacademy.steps.SwoopMainPageSteps;
import ge.tbc.tbcitacademy.data.configuration.ConfigTests;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("swoop.ge Offers and Filters tests")
public class OfferTests extends ConfigTests {
    SwoopMainPageSteps mainPageSteps = new SwoopMainPageSteps();
    HolidayPageSteps holidayPageSteps = new HolidayPageSteps();
    BarsPageSteps barsPageSteps = new BarsPageSteps();
    BarsOfferPageSteps barsOfferPageSteps = new BarsOfferPageSteps();

    @Test(dataProvider = "priceData", dataProviderClass = MinMaxPriceDataprovider.class, groups = "SwoopRegression"
    , description = "Filtering by price and validating that all offers are within range, " +
            "this test will fail in multiple cases since price filter does not work correctly on the website")
    @Story("Testing main and holiday pages")
    public void rangeTest(int minPriceValue, int maxPriceValue) {
        mainPageSteps
                .navigateToSwoopMainPage()
                .navigateToHolidayPage();
        holidayPageSteps
                .fillPriceFilter(minPriceValue,maxPriceValue)
                .validatePriceRanges(minPriceValue, maxPriceValue);
    }

    @Feature("Testing main and Bars pages")
    @Test(groups = "SwoopRegression",
            description = "Filtering by price, adding to favorites, sharing, and clearing filters.")
    public void favouriteOfferTest(){
        mainPageSteps
                .navigateToSwoopMainPage()
                .clickOnCategoriesDropdown()
                .hoverOnFood()
                .clickOnBars();
        barsPageSteps
                .notSoldOut()
                .clickOnFavorite()
                .verifyLoginPageAppearance();
    }

    @Feature("Testing main and Bars pages")
    @Test(groups = "SwoopRegression",
            description = "Validating FB window appearance after clicking share of first element")
    public void shareOfferTest(){
        mainPageSteps
                .navigateToSwoopMainPage()
                .clickOnCategoriesDropdown()
                .hoverOnFood()
                .clickOnBars();
        barsPageSteps
                .navigateToFirstReturnedItem();
        barsOfferPageSteps
                .clickShare()
                .validateFBAppearance();
    }

    @Test(groups = "SwoopRegression",
            description = "Validating that the diagram of product with no sales is empty")
    @Feature("Testing main and Bars pages")
    public void noOffersSoldTest(){
        mainPageSteps
                .navigateToSwoopMainPage()
                .clickOnCategoriesDropdown()
                .hoverOnFood()
                .clickOnBars();
        barsPageSteps
                .diagramOfEmptyProductEmpty();
    }

    @Test(groups = "SwoopRegression"
    , description = "Applying filters, clearing them using clear all filters button and validating that the filters are switched to default")
    @Feature("Testing main page and selection bar")
    public void clearFilterTest(){
        mainPageSteps
                .navigateToSwoopMainPage()
                .clickOnCategoriesDropdown()
                .hoverOnFood()
                .clickOnBars()
                .selectVoucherOption()
                .changeLocation()
                .fillPrices()
                .clearAllFilters()
                .validateDefaultOptions();
    }
}
