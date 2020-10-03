package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

/**
 * @author Alex Komanov
 */

@Epic("WhatsApp Page")
@Feature("Validate correct navigation to WhatsApp page and presence of the elements")
public class WhatsAppTests extends BaseTest{

    @Link(value = "AUT-1", name = "#")
    @Story("Correct redirection to WhatsApp page")
    @Description("Test validates correct redirection to WhatsApp page")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void test_01(){
        steps.navigateToWhatsAppPage()
                .validateCorrectPageTitle("Share on WhatsApp")
                .validateCorrectPageUrl("https://api.whatsapp.com/send?phone=972544945333");
    }

    @Link(value = "AUT-2", name = "#")
    @Story("Presence of the elements on WhatsApp page")
    @Description("Test validates presence of the elements on WhatsApp page")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void test_02(){
        steps.navigateToWhatsAppPage()
                .validateCorrectPageTitle("Share on WhatsApp")
                .validateCorrectPageUrl("https://api.whatsapp.com/send?phone=972544945333");
    }
}
