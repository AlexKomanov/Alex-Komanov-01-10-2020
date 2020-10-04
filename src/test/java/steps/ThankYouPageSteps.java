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
}
