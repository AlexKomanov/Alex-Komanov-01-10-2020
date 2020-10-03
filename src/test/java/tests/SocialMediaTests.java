package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

/**
 * @author Alex Komanov
 */

@Epic("Social Media Redirection")
@Feature("Social Media General Tests")
public class SocialMediaTests extends BaseTest {


    @Link(value = "AUT-SM-1", name = "#")
    @Story("Basic Tests")
    @Description("Test validates correct redirection to LinkedIn page")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Correct redirection to LinkedIn Page")
    public void test_01() {
        steps.navigateToSocialMedia("LinkedIn")
                .validateCorrectRedirection("LinkedIn", "https://www.linkedin.com");
    }

    @Link(value = "AUT-SM-2", name = "#")
    @Story("Basic Tests")
    @Description("Test validates correct redirection to WhatsApp page")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Correct redirection to WhatsApp Page")
    public void test_02() {
        socialMediaSteps
                .closeWindowAndSwitchToMain()
                .navigateToSocialMedia("WhatsApp")
                .validateCorrectRedirection("Share on WhatsApp", "https://api.whatsapp.com/send?phone=972544945333");
    }

    @Link(value = "AUT-SM-3", name = "#")
    @Story("Basic Tests")
    @Description("Test validates correct redirection to FaceBook page")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Correct redirection to FaceBook Page")
    public void test_03() {
        socialMediaSteps
                .closeWindowAndSwitchToMain()
                .navigateToSocialMedia("FaceBook")
                .validateCorrectRedirection("Herolo - Home | Facebook", "https://www.facebook.com/Herolofrontend");
    }

    @Link(value = "AUT-SM-4", name = "#")
    @Story("Basic Tests")
    @Description("Test validates correct redirection to WebSite page")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Correct redirection to WebSite Page")
    public void test_04() {
        socialMediaSteps
                .closeWindowAndSwitchToMain()
                .navigateToSocialMedia("WebSite")
                .validateCorrectRedirection("Herolo. Fullstack & Frontend Firm", "https://herolo.co.il/?lang=he");
    }

    @Link(value = "AUT-SM-5", name = "#")
    @Story("Basic Tests")
    @Description("Test validates correct redirection to Main page")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Correct redirection to Main Page")
    public void test_05() {
        socialMediaSteps
                .closeWindowAndSwitchToMain()
                .validateMainPageTitle("הירולו - חברת פיתוח מובילה המתמחה בפתרונות פרונט אנד");
    }

    @Link(value = "AUT-SM-6", name = "#")
    @Story("Basic Tests")
    @Description("Test validates correct mailTo link")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Correct mailTo link")
    public void test_06() {
        steps.
                validateMailToLink("href", "mailto:mati@herolo.co.il", "mati@herolo.co.il");
    }

}
