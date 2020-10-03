package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

/**
 * @author Alex Komanov
 */

@Epic("Main Page")
@Feature("Base Test Feature")
public class MainPageTests extends BaseTest {

    private String blankField = "";
    private String name = "Alex";
    private String company = "SeatGeek";
    private String phoneCorrect = "0546123456";
    private String phoneIncorrect = "ddddddddd";
    private String emailCorrect = "akoman@gmail.com";
    private String emailIncorrect = "gmail.com";


    @Test
    public void test_01() {
        steps.scrollDown()
                .validateBackToTopButtonAction();
    }

    @Test
    public void test_02() {
        steps.clickOnSlickArrow("Next")
                .validateCorrectSwitchOfArrow("Next")
                .clickOnSlickArrow("Next")
                .validateCorrectSwitchOfArrow("Next");
    }

    @Test
    public void test_03() {
        steps.clickOnSlickArrow("Previous")
                .validateCorrectSwitchOfArrow("Previous")
                .clickOnSlickArrow("Previous")
                .validateCorrectSwitchOfArrow("Previous");
    }

    @Test
    public void test_04() {
        steps.validateFooterForm("Displayed")
                .scrollDown()
                .validateFooterForm("Not Displayed")
                .backToTop()
                .validateFooterForm("Displayed");
    }

    @Test
    public void test_05() {
        steps.scrollDown()
                .fillIncorrectLowerForm(blankField, blankField, blankField, blankField)
                .validateFieldError("Name", "שדה שם הוא שדה חובה")
                .validateFieldError("Company", "שדה חברה הוא שדה חובה")
                .validateFieldError("Email", "שדה אימייל הוא שדה חובה")
                .validateFieldError("Phone", "שדה טלפון הוא שדה חובה")
                .fillIncorrectLowerForm(name, company, emailIncorrect, phoneIncorrect)
                .validateFieldError("Email", "כתובת אימייל לא חוקית")
                .validateFieldError("Phone", "מספר טלפון לא חוקי");
    }

    @Test
    public void test_06() {
        steps.backToTop()
                .fillIncorrectFooterForm(blankField, blankField, blankField)
                .validateFieldError("FooterName", "שדה שם הוא שדה חובה")
                .validateFieldError("FooterEmail", "שדה אימייל הוא שדה חובה")
                .validateFieldError("FooterPhone", "שדה טלפון הוא שדה חובה")
                .fillIncorrectFooterForm(name, emailIncorrect, phoneIncorrect)
                .validateFieldError("FooterEmail", "כתובת אימייל לא חוקית")
                .validateFieldError("FooterPhone", "מספר טלפון לא חוקי");
    }





//    //@Step("Writing '{value}' in the E-Mail field")
//    @Link(value = "AUT-122", name = "https://seatgeekenterprise.atlassian.net/browse/AUT-122")
//    @Test(dataProvider = "dataProvider", description = "Write E-Mail")
//    @Story("I want to check error messages")
//    @Description("Fills only the E-Mail field")
//    @Severity(SeverityLevel.CRITICAL)
//    public void openMainSite(String value) {
//
//        steps.fillFooterNameFieldAndSubmit(value)
//                .validateFooterEmailErrorMessage("שדה אימייל הוא שדה חובה")
//                .validateFooterPhoneErrorMessage("שדה טלפון הוא שדה חובה");
//        AllureAttachment.addTextAttachment("Finished...");
//        AllureAttachment.attachCSV("USED VALUE \n" + value);
//        AllureAttachment.captureScreenshot(BaseTest.getDriver());
//        AllureAttachment.attachJson("{\n" +
//                "  \"test\": \"Automation Test\",\n" +
//                "  \"values\": {\n" +
//                "    \"type\": \"Email\",\n" +
//                "    \"value\": \""+value+"\"\n" +
//                "  }\n" +
//                "}");
//
//
//
//    }


}
