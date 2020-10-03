package steps;

import pages.MainPage;
import pages.WhatsAppPage;

/**
 * @author Alex Komanov
 */
public class WhatsAppPageSteps {

    private WhatsAppPage whatsAppPage = new WhatsAppPage();
    private MainPage mainPage = new MainPage();

    public WhatsAppPageSteps getInfo(){
        whatsAppPage.getButtonText();
        whatsAppPage.printTitle();
        return this;
    }

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

}
