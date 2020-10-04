package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

/**
 * @author Alex Komanov
 */

@Epic("Main Page")
@Feature("Main Page General Tests")
public class MainPageTests extends BaseTest {

    private String blankField = "";
    private String name = "Alex";
    private String company = "SeatGeek";
    private String phoneCorrect = "0546123456";
    private String phoneIncorrect = "ddddddddd";
    private String emailCorrect = "akoman@gmail.com";
    private String emailIncorrect = "gmail.com";


    @Link(value = "AUT-MP-1", name = "#")
    @Story("Basic Tests")
    @Description("Test validates action of 'Back to top' button")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "01_Action of 'Back to top' button")
    public void test_01() {
        steps.scrollDown()
                .validateBackToTopButtonAction();
    }

    @Link(value = "AUT-MP-2", name = "#")
    @Story("Basic Tests")
    @Description("Test validates action of 'Next' button")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "02_Action of 'Next' button")
    public void test_02() {
        steps.clickOnSlickArrow("Next")
                .validateCorrectSwitchOfArrow("Next")
                .clickOnSlickArrow("Next")
                .validateCorrectSwitchOfArrow("Next");
    }

    @Link(value = "AUT-MP-3", name = "#")
    @Story("Basic Tests")
    @Description("Test validates action of 'Previous' button")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "03_Action of 'Previous' button")
    public void test_03() {
        steps.clickOnSlickArrow("Previous")
                .validateCorrectSwitchOfArrow("Previous")
                .clickOnSlickArrow("Previous")
                .validateCorrectSwitchOfArrow("Previous");
    }

    @Link(value = "AUT-MP-4", name = "#")
    @Story("Basic Tests")
    @Description("Test validates correct behaviour of footer form")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "04_Correct behaviour of footer form")
    public void test_04() {
        steps.validateFooterForm("Displayed")
                .scrollDown()
                .validateFooterForm("Not Displayed")
                .backToTop()
                .validateFooterForm("Displayed");
    }

    @Link(value = "AUT-MP-5", name = "#")
    @Story("Basic Tests")
    @Description("Test validates correct error messages of lower form")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "05_Correct error messages of lower form")
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

    @Link(value = "AUT-MP-6", name = "#")
    @Story("Basic Tests")
    @Description("Test validates correct error messages of footer form")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "06_Correct error messages of footer form")
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

/**
 *  *********** Optional scenario with Allure attachments ***********

    //@Step("Writing '{value}' in the E-Mail field")
      @Link(value = "AUT-122", name = "https://seatgeekenterprise.atlassian.net/browse/AUT-122")
      @Test(dataProvider = "dataProvider", description = "Write E-Mail")
      @Story("I want to check error messages")
      @Description("Fills only the E-Mail field")
      @Severity(SeverityLevel.CRITICAL)
      public void openMainSite(String value) {

          steps.fillFooterNameFieldAndSubmit(value)
                  .validateFooterEmailErrorMessage("שדה אימייל הוא שדה חובה")
                  .validateFooterPhoneErrorMessage("שדה טלפון הוא שדה חובה");
          AllureAttachment.addTextAttachment("Finished...");
          AllureAttachment.attachCSV("USED VALUE \n" + value);
          AllureAttachment.captureScreenshot(BaseTest.getDriver());
          AllureAttachment.attachJson("{\n" +
                  "  \"test\": \"Automation Test\",\n" +
                  "  \"values\": {\n" +
                  "    \"type\": \"Email\",\n" +
                  "    \"value\": \""+value+"\"\n" +
                  "  }\n" +
                  "}");
 */
}



