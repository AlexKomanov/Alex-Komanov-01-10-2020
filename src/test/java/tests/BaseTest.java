package tests;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.log.Log;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.devtools.network.model.ConnectionType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import steps.MainPageSteps;
import steps.WhatsAppPageSteps;
import utils.DriverFactory;
import utils.PropertyReader;

import java.util.Optional;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

/**
 * @author Alex Komanov
 */
public abstract class BaseTest {

    String browserVersion;
    String browserName;
    String baseUrl;

    //PageObject Pattern
    //PageFactory Pattern
    //Steps Pattern
    //Chains of invocations Pattern
    //Driver Factory Method Pattern
    //Property Reader Pattern

    private static WebDriver driver;
    MainPageSteps steps;
    WhatsAppPageSteps whatsAppPageSteps;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp(){
        driver = DriverFactory.getDriver(PropertyReader.getBrowser());
        baseUrl = PropertyReader.getUrl();
        driver.get(baseUrl);
        browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
        browserVersion = ((RemoteWebDriver) driver).getCapabilities().getVersion();
        steps = new MainPageSteps();
        whatsAppPageSteps = new WhatsAppPageSteps();
        allureEnvironmentWriter(ImmutableMap.<String, String>builder().put("Browser", browserName.toUpperCase()).put("Browser Version", browserVersion).put("URL", baseUrl).build());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

//    @AfterMethod
//    public void refresh(){
//        driver.navigate().refresh();
//    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProviderMethod(){
        return new Object[][]{{"Alex"}, {"Sasha"}, {"TTTTTTT"}};
    }



}
