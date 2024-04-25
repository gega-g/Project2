package ge.tbc.tbcitacademy.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;

public class SwoopMainPage {
    public SelenideElement holiday = $x("//li[@class='MoreCategories']/a[@href='/category/24/dasveneba']");
    public SelenideElement categories = $x("//div[@class='NewCategories newcat']");
    public SelenideElement food = $x("//li[@cat_id='CatId-3']");
    public SelenideElement bars = $x("//a[@href='/category/228/restornebi-da-barebi/kafe-bari']");
    public SelenideElement filterDesk = $x("//div[@class='category-filter-desk']");
    public SelenideElement maxPriceField = filterDesk.$(By.id("maxprice"));
    public SelenideElement minPriceField = filterDesk.$(By.id("minprice"));
    public SelenideElement searchButton = $x("//div[@class='category-filter-desk']//div[@class='submit-button']");
    public SelenideElement locationDropdownButton =filterDesk.$x(".//button");
    public SelenideElement saburtalo = filterDesk.$x(".//input[@data-key='option_3']");
    public SelenideElement voucher = filterDesk.$x(".//input[@value='1']");
    public SelenideElement all = filterDesk.$x(".//input[@value='2']");
    public SelenideElement defaultDropdown = filterDesk.$x(".//span[@class='placeholder']");
    public SelenideElement clearFilters = filterDesk.$x(".//div[@onclick='deals()']");
}