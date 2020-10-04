package steps;

import pages.MainPage;
import pages.SocialMediaPage;

/**
 * @author Alex Komanov
 */
public class SocialMediaSteps {

    MainPage mainPage = new MainPage();
    SocialMediaPage socialMediaPage = new SocialMediaPage();

     public SocialMediaSteps validateCorrectRedirection(String expectedTitle, String expectedUrl){
         socialMediaPage.assertPageTitle(expectedTitle);
         socialMediaPage.assertPageUrl(expectedUrl);
         socialMediaPage.sleep(1500);
         return this;
     }

    public MainPageSteps closeWindowAndSwitchToMain(){
         socialMediaPage.closeCurrentWindow();
         socialMediaPage.switchBack(mainPage.getMainPageWindow());
         socialMediaPage.refreshPage();
         return new MainPageSteps();
    }

}
