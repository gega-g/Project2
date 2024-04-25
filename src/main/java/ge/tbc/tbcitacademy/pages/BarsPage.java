package ge.tbc.tbcitacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class BarsPage {
    public SelenideElement favoriteButton = $(".deal-box-wishlist");
    public SelenideElement firstOffer = $(".special-offer");
    public ElementsCollection diagrams = $$(".voucher-diagram > div");
    public SelenideElement productWithNoSales = $(byText("გაყიდულია 0")).parent().parent();
    public SelenideElement progressDiagram = productWithNoSales.find(".voucher-diagram > div");
    public static final String SOLUTION = "Solution";
}
