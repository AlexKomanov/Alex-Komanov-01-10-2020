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

    private static String whatsAppWindowHandle;

    public String getWhatsAppWindowHandle() {
        return whatsAppWindowHandle;
    }

    public WhatsAppPage() {
        super();
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

    public void assertChatButtonLink(String attribute, String expectedValue){
        assertThat(getAttributeValue(continueToChatButton, attribute)).as("Wrong link").isEqualTo(expectedValue);
    }

    public void assertChatButtonText(String expectedText){
        assertThat(getElementText(continueToChatButton)).as("Wrong link").isEqualTo(expectedText);
    }

    public void getWhatsAppWindowValue(){
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
