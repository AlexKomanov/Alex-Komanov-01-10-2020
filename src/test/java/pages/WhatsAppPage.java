package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Alex Komanov
 */
public class WhatsAppPage extends BasePage{

    @FindBy(css = "h1 p")
    WebElement chatWithTitle;
    @FindBy(id = "action-button")
    WebElement continueToChatButton;

    String whatsAppWindowHandle;

    public WhatsAppPage() {
        super();
    }

    public void printTitle(){
        System.out.println(driver.getTitle());
    }

    public void getButtonText(){
        System.out.println(getElementText(chatWithTitle));
        System.out.println(getElementText(continueToChatButton));
    }
    public void assertMainTitle(String expectedTitle){
        assertThat(getElementText(chatWithTitle)).as("Wrong title").isEqualTo(expectedTitle);
    }

    public void assertPageTitle(String expectedTitle){
        assertThat(getPageTitle()).as("Wrong page title").isEqualTo(expectedTitle);
    }

    public void assertPageUrl(String expectedTitle){
        assertThat(getPageUrl()).as("Wrong URL").isEqualTo(expectedTitle);
    }

    public void assertButtonLink(String expectedTitle){
        assertThat(getAttributeValue(continueToChatButton, "href")).as("Wrong link").isEqualTo(expectedTitle);
    }



    public void getWhatsAppWindowHandle(){
        sleep(2000);
        whatsAppWindowHandle = getWindowHandle();
    }

    public void switchToWhatsAppWindow(){
        sleep(2000);
        switchToOpenedWindow();
    }

    public void closeCurrentWindow(){
        closeCurrentTab();
    }


    public void switchBackToMainWindow(String window){
        switchToWindow(window);
    }
}
