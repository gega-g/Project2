package ge.tbc.tbcitacademy.dataprovider;

import org.testng.annotations.DataProvider;

public class MinMaxPriceDataprovider {
    @DataProvider()
    public Object[][] priceData() {
        return new Object[][] {
                { 100, 200 },
                { 200, 300 },
                { 300, 400 },
                { 400, 500 },
                { 500, 600 }
        };
    }
}
