package ge.tbc.tbcitacademy.data.configuration;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbc.tbcitacademy.data.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class ConfigTests {
    protected WebDriver driver;
    SoftAssert sfa = new SoftAssert();

    @BeforeMethod
    @Parameters(Constants.BROWSER)
    public void setUp(@Optional(Constants.CHROME) String browser) throws IOException {
        if (browser.equalsIgnoreCase(Constants.CHROME)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            throw new IllegalArgumentException(Constants.UNSUPPORTEDBROWSER + browser);
        }
        Configuration.reportsFolder = Constants.SCREENPATH;
        Configuration.timeout = 10000;
        Configuration.savePageSource = true;
        WebDriverRunner.setWebDriver(driver);
        open();
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        try{
            sfa.assertAll();
        }
        catch (AssertionError e){
            takeScreenshot();
        }
        if (driver != null) {
            driver.quit();
        }
    }

    public void takeScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File(Constants.SCREENPATH, "screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}