package ge.tbc.tbcitacademy.util;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.data.Constants;

import java.util.ArrayList;
import java.util.List;

public class NumericValue {
    public List<Integer> numericValue(ElementsCollection priceElements) {
        List<Integer> prices = new ArrayList<>();
        for (SelenideElement priceElement : priceElements) {
            String priceAsText = priceElement.getAttribute(Constants.INNERTEXT).trim();
            String numbersFromText = priceAsText.replaceAll("[^\\d]", "");
            int finalPrice = Integer.parseInt(numbersFromText);
            prices.add(finalPrice);
        }
        return prices;
    }
}
