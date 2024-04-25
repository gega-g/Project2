package ge.tbc.tbcitacademy.util;

import com.codeborne.selenide.*;
import ge.tbc.tbcitacademy.data.Constants;
import ge.tbc.tbcitacademy.pages.HolidayPage;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class Comparator {
    HolidayPage holidayPage = new HolidayPage();
    NumericValue numericValue = new NumericValue();
    SoftAssert softAssert = new SoftAssert();

    public void comparePrices(int minPrice, int maxPrice) {
        Configuration.assertionMode = AssertionMode.SOFT;
        String currentUrl = WebDriverRunner.url();
        List<Integer> prices = numericValue.numericValue(holidayPage.prices);
        List<Integer> filteredPrices = new ArrayList<>();
        if (currentUrl.contains(Constants.MINPRICE)) {
            for (int price : prices) {
                filteredPrices.add(price);
                softAssert.assertTrue(price >= minPrice && price <= maxPrice,
                        price + Constants.ISNTINRANGE + minPrice + "-" + maxPrice);
            }
        }
        softAssert.assertAll();
    }
}