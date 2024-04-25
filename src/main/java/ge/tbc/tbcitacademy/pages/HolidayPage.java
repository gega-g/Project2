package ge.tbc.tbcitacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class HolidayPage {
    public ElementsCollection prices = $$x("//div[@class='voucher-counts']" +
            "//p[@class='deal-voucher-price' and not(@style='text-decoration: line-through;')]");
    public SelenideElement offer = $(".special-offer");
}
