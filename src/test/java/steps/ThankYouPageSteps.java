package steps;

import pages.MainPage;
import pages.ThankYouPage;

/**
 * @author Alex Komanov
 */
public class ThankYouPageSteps {

    MainPage mainPage = new MainPage();
    ThankYouPage thankYouPage = new ThankYouPage();

    public MainPageSteps backToMainPage(){
        thankYouPage.clickBackButton();
        thankYouPage.sleep(2000);
        return new MainPageSteps();
    }

    public ThankYouPageSteps validateCorrectRedirection(String mainTitle, String pageTitle, String pageUrl){
        thankYouPage.assertMainTitle(mainTitle);
        thankYouPage.assertPageTitle(pageTitle);
        thankYouPage.assertPageUrl(pageUrl);
        return this;
    }

    public ThankYouPageSteps navigateToSocialMedia(String socialMedia){
        thankYouPage.getMainPageWindowHandle();
        thankYouPage.clickSocialMedia(socialMedia);
        thankYouPage.switchToOpenedTab();
        return this;
    }

    public ThankYouPageSteps validateCorrectRedirection(String pageUrl){
        thankYouPage.assertPageUrl(pageUrl);
        return this;
    }

    public ThankYouPageSteps navigateBack(){
        thankYouPage.closeCurrentTab();
        thankYouPage.switchBack(thankYouPage.getThankYouPageWindow());
        return this;
    }
}
