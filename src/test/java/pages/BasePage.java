package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

import static tests.BaseTest.getDriver;
import static tests.BaseTest.getJs;


/**
 * @author Alex Komanov
 */
public abstract class BasePage {

    WebDriver driver;
    JavascriptExecutor js;
    DevTools devTools;

    public BasePage() {
        this.driver = getDriver();
        this.js = getJs();
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
        highlightElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void click(WebElement element){
        //AllureAttachment.attachElementScreenshot(element);
        highlightElement(element);
        element.click();
        sleep(1000);
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

    /** JS Executor Methods **/
    public void scrollDown(){
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        sleep(2000);
    }

    public void highlightElement(WebElement element) {
        //Keep the old style to change it back
        String originalStyle = element.getAttribute("style");
        // Change the style
        js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", element);
        sleep(300);
        // Change the style back
        js.executeScript("arguments[0].setAttribute('style','" + originalStyle +";');", element);
        sleep(400);

    }

    public Long checkPosition(){
        return (Long) js.executeScript("return window.pageYOffset;");
    }

    public void naviעateToObject(WebElement element){
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        sleep(2000);
    }
}
