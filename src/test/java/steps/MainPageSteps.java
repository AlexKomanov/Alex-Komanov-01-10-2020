package steps;

import io.qameta.allure.Step;
import pages.MainPage;
import pages.WhatsAppPage;
import utils.AllureAttachment;

/**
 * @author Alex Komanov
 */
public class MainPageSteps {

    private MainPage mainPage = new MainPage();
    private WhatsAppPage whatsAppPage = new WhatsAppPage();


    @Step("Writing '{nameValue}' in the E-Mail field")
    public MainPageSteps fillFooterNameFieldAndSubmit(String nameValue){
        mainPage.sleep(2000);
        mainPage.fillFooterNameField(nameValue);
        mainPage.clickFooterSendButton();
        AllureAttachment.addTextAttachment("Filling email...");
        return this;
    }

    @Step("Validating that error message is '{expectedErrorMessage}'")
    public MainPageSteps validateFooterEmailErrorMessage(String expectedErrorMessage){
        mainPage.assertEmailErrorMessage(expectedErrorMessage);
        return this;
    }

    @Step("Validating that error message is '{expectedErrorMessage}'")
    public MainPageSteps validateFooterPhoneErrorMessage(String expectedErrorMessage){
        mainPage.assertPhoneErrorMessage(expectedErrorMessage);
        return this;
    }

    public MainPageSteps validateMainPageTitle(String expectedTitle){
        mainPage.assertMainPageTitle(expectedTitle);
        return this;
    }

    public WhatsAppPageSteps navigateToWhatsAppPage(){
        mainPage.getMainPageWindowHandle();
        mainPage.clickWhatsAppButton();
        whatsAppPage.getWhatsAppWindowHandle();
        whatsAppPage.switchToWhatsAppWindow();
        return new WhatsAppPageSteps();
    }



}
