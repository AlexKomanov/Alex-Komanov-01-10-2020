package tests;

import org.testng.annotations.Test;

/**
 * @author Alex Komanov
 */
public class SocialMediaTests extends BaseTest {

    @Test
    public void test_01() {
        steps.navigateToSocialMedia("LinkedIn")
                .validateCorrectRedirection("LinkedIn", "https://www.linkedin.com");
    }

    @Test
    public void test_02() {
        socialMediaSteps
                .closeWindowAndSwitchToMain()
                .navigateToSocialMedia("WhatsApp")
                .validateCorrectRedirection("Share on WhatsApp", "https://api.whatsapp.com/send?phone=972544945333");
    }

    @Test
    public void test_03() {
        socialMediaSteps
                .closeWindowAndSwitchToMain()
                .navigateToSocialMedia("FaceBook")
                .validateCorrectRedirection("Herolo - Home | Facebook", "https://www.facebook.com/Herolofrontend");
    }

    @Test
    public void test_04() {
        socialMediaSteps
                .closeWindowAndSwitchToMain()
                .navigateToSocialMedia("WebSite")
                .validateCorrectRedirection("Herolo. Fullstack & Frontend Firm", "https://herolo.co.il/?lang=he");
    }

    @Test
    public void test_05() {
        socialMediaSteps
                .closeWindowAndSwitchToMain()
                .validateMainPageTitle("הירולו - חברת פיתוח מובילה המתמחה בפתרונות פרונט אנד");
    }

    @Test
    public void test_06() {
        steps.
                validateMailToLink("href", "mailto:mati@herolo.co.il", "mati@herolo.co.il");
    }

}
