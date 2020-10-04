package tests;

import org.testng.annotations.Test;

/**
 * @author Alex Komanov
 */
public class ThankYouPageTests extends BaseTest{

    private String name = "Alex";
    private String company = "SeatGeek";
    private String phoneCorrect = "0546123456";
    private String emailCorrect = "akoman@gmail.com";
    String mainTitle = "תודה!";
    String pageTitle = "הירולו - חברת פיתוח מובילה המתמחה בפתרונות פרונט אנד";
    String pageUrl = "https://automation.herolo.co.il/thank-you/";


    @Test
    public void test_01(){
        steps.fillCorrectFooterForm(name, emailCorrect, phoneCorrect)
                .validateCorrectRedirection(mainTitle, pageTitle, pageUrl)
                .backToMainPage();
    }

    @Test
    public void test_02(){
        steps.fillCorrectLowerForm(name, company, emailCorrect, phoneCorrect)
                .validateCorrectRedirection(mainTitle, pageTitle, pageUrl);
    }

    @Test
    public void test_03(){
        thankYouPageSteps
                .navigateToSocialMedia("LinkedIn")
                .validateCorrectRedirection("linkedin")
                .navigateBack()
                .navigateToSocialMedia("Instagram")
                .validateCorrectRedirection("instagram")
                .navigateBack()
                .navigateToSocialMedia("FaceBook")
                .validateCorrectRedirection("facebook")
                .navigateBack()
                .navigateToSocialMedia("WebSite")
                .validateCorrectRedirection("herolo.co.il")
                .navigateBack();
    }
}
