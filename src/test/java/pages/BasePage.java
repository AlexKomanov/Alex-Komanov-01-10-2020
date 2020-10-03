package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

import static tests.BaseTest.getDriver;


/**
 * @author Alex Komanov
 */
public abstract class BasePage {

    WebDriver driver;
    DevTools devTools;

    public BasePage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public void sleep(int interval){
        try {
            Thread.sleep(interval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fillText(WebElement element, String text){
        //AllureAttachment.attachElementScreenshot(element);
        element.clear();
        element.sendKeys(text);
    }

    public void click(WebElement element){
        //AllureAttachment.attachElementScreenshot(element);
        element.click();
    }

    public String getElementText(WebElement element){
        //AllureAttachment.attachElementScreenshot(element);
        return element.getText();
    }

    public String getWindowHandle(){
        String currentPage = driver.getWindowHandle();
        return currentPage;
    }

    public void switchToOpenedWindow(){
        Set<String> list = driver.getWindowHandles();
        for (String wind : list){
            driver.switchTo().window(wind);
        }
    }

    public void closeCurrentTab(){
        driver.close();
    }

    public void switchToWindow(String window){
        driver.switchTo().window(window);
    }

    public String getAttributeValue(WebElement element, String attribute){
        return element.getAttribute(attribute);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }
}
