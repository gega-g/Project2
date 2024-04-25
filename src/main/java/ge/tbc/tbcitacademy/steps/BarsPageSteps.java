package ge.tbc.tbcitacademy.steps;

import com.codeborne.selenide.WebDriverRunner;
import ge.tbc.tbcitacademy.data.URLS;
import ge.tbc.tbcitacademy.pages.BarsPage;
import io.qameta.allure.Step;
import org.testng.Assert;

public class BarsPageSteps {
    BarsPage barsPage = new BarsPage();

    @Step("Click on favorite button")
    public BarsPageSteps clickOnFavorite() {
        barsPage.favoriteButton.click();
        return this;
    }

    @Step("Validate that the product isn't sold out")
    public BarsPageSteps notSoldOut() {
        barsPage.diagrams.forEach(element -> {
            String styleAttribute = element.getAttribute("style");
            String widthValue = styleAttribute.substring(styleAttribute.indexOf("width:") + 6, styleAttribute.indexOf("%"));
            double width = Double.parseDouble(widthValue.trim());
            Assert.assertTrue(width < 100);
        });
        return this;
    }

    @Step("Verify login page appearance after clicking on favorite button")
    public BarsPageSteps verifyLoginPageAppearance(){
        String currentUrl = WebDriverRunner.url();
        Assert.assertTrue(currentUrl.contains(URLS.AUTHNET));
        return this;
    }

    @Step("Navigate to first returned item")
    public BarsPageSteps navigateToFirstReturnedItem(){
        barsPage.firstOffer.click();
        return this;
    }

    @Step("Validating that the diagram of product with 0 sales is indeed empty")
    public BarsPageSteps diagramOfEmptyProductEmpty(){
        String styleAttribute = barsPage.progressDiagram.getAttribute("style");
        String widthValue = styleAttribute.substring(styleAttribute.indexOf("width:") + 6, styleAttribute.indexOf("%"));
        double width = Double.parseDouble(widthValue.trim());
        Assert.assertEquals(width, 0);
        return this;
    }
}
