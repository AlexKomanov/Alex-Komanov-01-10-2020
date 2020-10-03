package tests;

import io.qameta.allure.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 * @author Alex Komanov
 */

@Epic("WhatsApp Page")
@Feature("WhatsApp General Tests")
public class WhatsAppTests extends BaseTest{

    @Link(value = "AUT-WP-1", name = "#")
    @Story("Basic Tests")
    @Description("Test validates correct redirection to WhatsApp page")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Correct redirection to WhatsApp Page")
    public void test_01(){
        steps.navigateToWhatsAppPage()
                .validateCorrectPageTitle("Share on WhatsApp")
                .validateCorrectPageUrl("https://api.whatsapp.com/send?phone=972544945333");
    }

    @Link(value = "AUT-WP-2", name = "#")
    @Story("Basic Tests")
    @Description("Test validates presence of the elements on WhatsApp page")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Presence of the elements")
    public void test_02(){
        whatsAppPageSteps
                .validateMainTitle("Chat on WhatsApp with +972 54-494-5333")
                .validateChatButtonPresence("CONTINUE TO CHAT", "href",
                        "https://web.whatsapp.com/send?phone=972544945333");
    }

    @Link(value = "AUT-WP-3", name = "#")
    @Story("Basic Tests")
    @Description("Test validates navigate to the Main Page")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Redirection to the Main Page")
    public void test_03(){
        whatsAppPageSteps
                .closeWindowAndSwitchToMain()
                .validateMainPageTitle("הירולו - חברת פיתוח מובילה המתמחה בפתרונות פרונט אנד");
    }
}
