package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

/**
 * @author Alex Komanov
 */

@Epic("Thank You Page")
@Feature("Thank You Page General Tests")
public class ThankYouPageTests extends BaseTest{

    private String name = "Alex";
    private String company = "SeatGeek";
    private String phoneCorrect = "0546123456";
    private String emailCorrect = "akoman@gmail.com";
    String mainTitle = "תודה!";
    String pageTitle = "הירולו - חברת פיתוח מובילה המתמחה בפתרונות פרונט אנד";
    String pageUrl = "https://automation.herolo.co.il/thank-you/";


    @Link(value = "AUT-TP-1", name = "#")
    @Story("Basic Tests")
    @Description("Test validates correct redirection to 'Thank You' page via footer form")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "01_Redirection via footer form")
    public void test_01(){
        steps.fillCorrectFooterForm(name, emailCorrect, phoneCorrect)
                .validateCorrectRedirection(mainTitle, pageTitle, pageUrl)
                .backToMainPage();
    }

    @Link(value = "AUT-TP-2", name = "#")
    @Story("Basic Tests")
    @Description("Test validates correct redirection to 'Thank You' page via lower form")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "02_Redirection via lower form")
    public void test_02(){
        steps.fillCorrectLowerForm(name, company, emailCorrect, phoneCorrect)
                .validateCorrectRedirection(mainTitle, pageTitle, pageUrl);
    }

    @Link(value = "AUT-TP-3", name = "#")
    @Story("Basic Tests")
    @Description("Test validates correct redirection to social media pages")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "03_Redirection to social media pages")
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
