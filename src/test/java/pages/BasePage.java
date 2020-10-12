package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static tests.BaseTest.getDriver;
import static tests.BaseTest.getJs;


/**
 * @author Alex Komanov
 */
public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    DevTools devTools;

    public BasePage() {
        this.driver = getDriver();
        this.js = getJs();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    public void refreshPage(){
        driver.navigate().refresh();
        sleep(2000);
    }

    /** JS Executor Methods **/
    public void scrollDown(){
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void highlightElement(WebElement element) {
        //Keep the old style to change it back
        String originalStyle = element.getAttribute("style");
        // Change the style
        js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", element);
        sleep(500);
        // Change the style back
        js.executeScript("arguments[0].setAttribute('style','" + originalStyle +";');", element);
        sleep(100);

    }

    public Long checkPosition(){
        return (Long) js.executeScript("return window.pageYOffset;");
    }

    public void navigateToObject(WebElement element){
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
