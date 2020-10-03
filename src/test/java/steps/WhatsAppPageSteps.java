package steps;

import pages.MainPage;
import pages.WhatsAppPage;

/**
 * @author Alex Komanov
 */
public class WhatsAppPageSteps {

    private WhatsAppPage whatsAppPage = new WhatsAppPage();
    private MainPage mainPage = new MainPage();

    public MainPageSteps closeWindowAndSwitchToMain(){
        whatsAppPage.closeCurrentWindow();
        whatsAppPage.switchBackToMainWindow(mainPage.getMainPageWindow());
        return new MainPageSteps();
    }

    public WhatsAppPageSteps validateCorrectPageTitle(String expectedTitle){
        whatsAppPage.assertPageTitle(expectedTitle);
        return this;
    }

    public WhatsAppPageSteps validateCorrectPageUrl(String expectedUrl){
        whatsAppPage.assertPageUrl(expectedUrl);
        return this;
    }

    public WhatsAppPageSteps validateMainTitle(String expectedTitle){
        whatsAppPage.assertMainTitle(expectedTitle);
        return this;
    }

    public WhatsAppPageSteps validateChatButtonPresence(String expectedText, String attribute, String expectedLink){
        whatsAppPage.assertChatButtonText(expectedText);
        whatsAppPage.assertChatButtonLink(attribute, expectedLink);
        return this;
    }

}
