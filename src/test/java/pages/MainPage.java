package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Alex Komanov
 */
public class MainPage extends BasePage {

    @FindBy(name = "name")
    WebElement footerNameField;
    @FindBy(name = "email")
    WebElement footerEmailField;
    @FindBy(name = "phone")
    WebElement footerPhoneField;
    @FindBy(css = "[class='Footer__Button-sc-1xqajj9-7 jixtxJ']")
    WebElement footerSendButton;
    @FindBy(css = "[name='name'] + label")
    WebElement footerNameErrorMessage;
    @FindBy(css = "[name='email'] + label")
    WebElement footerEmailErrorMessage;
    @FindBy(css = "[name='phone'] + label")
    WebElement footerPhoneErrorMessage;
    @FindBy(css = "[class = 'callUsWhatsapp__BtnWhatsapp-sc-1bcgurk-0 cPQmgB']")
    WebElement whatsAppButton;

    @FindBy(css = "[class='socialMediaBar__ImgSocial-sc-1f95hbj-2 gAmXai']")
    WebElement webSiteIcon;
    @FindBy(css = "[class='socialMediaBar__ImgSocial-sc-1f95hbj-2 gdrWsw']")
    WebElement faceBookIcon;
    @FindBy(css = "[class='socialMediaBar__ImgSocial-sc-1f95hbj-2 iZfnyd']")
    WebElement whatsAppSiteIcon;
    @FindBy(css = "[class='socialMediaBar__ImgSocial-sc-1f95hbj-2 jCiLrI']")
    WebElement linkedInIcon;
    @FindBy(css = "a[class='commun__ContactText-mgrfny-7 dPWxSc']")
    WebElement mailToLink;
    @FindBy(css = "[class='backToTop__BtnGoUp-sc-1deq75d-0 fIqtKc']")
    WebElement backToTopButton;

    @FindBy(xpath = "(//div[@class='slick-slide slick-active slick-current'])[1]")
    WebElement upperSlickSlide;
    @FindBy(css = ".slick-arrow.slick-next img")
    WebElement slickArrowNext;
    @FindBy(css = ".slick-arrow.slick-prev img")
    WebElement slickArrowPrevious;

    @FindBy(id = "footer")
    WebElement footerForm;

    @FindBy(css = ".form__ButtonContact-sc-1ju2h8q-1")
    WebElement lowerFormSendButton;
    @FindBy(css = "#name")
    WebElement lowerFormNameField;
    @FindBy(css = "#company")
    WebElement lowerFormCompanyField;
    @FindBy(css = "#email")
    WebElement lowerFormEmailField;
    @FindBy(css = "#telephone")
    WebElement lowerFormPhoneField;

    @FindBy(css = "#name + span")
    WebElement lowerFormNameFieldError;
    @FindBy(css = "#company + span")
    WebElement lowerFormCompanyFieldError;
    @FindBy(css = "#email + span")
    WebElement lowerFormEmailFieldError;
    @FindBy(css = "#telephone + span")
    WebElement lowerFormPhoneFieldError;


    protected static String mainPageWindow;
    protected static int startDataIndex;
    protected static int endDataIndex;


    public String getMainPageWindow() {
        return mainPageWindow;
    }


    public MainPage() {
        super();
    }

    public void fillFooterNameField(String nameValue) {
        fillText(footerNameField, nameValue);
    }

    public void fillFooterEmailField(String emailValue) {
        fillText(footerEmailField, emailValue);
    }

    public void fillFooterPhoneField(String phoneValue) {
        fillText(footerPhoneField, phoneValue);
    }

    public void assertEmailErrorMessage(String expectedMessage) {
        assertThat(getElementText(footerEmailErrorMessage)).as("Wrong message").isEqualTo(expectedMessage);
    }

    public void assertPhoneErrorMessage(String expectedMessage) {
        assertThat(getElementText(footerPhoneErrorMessage)).as("Wrong message").isEqualTo(expectedMessage);
    }

    public void assertMainPageTitle(String expectedTitle) {
        assertThat(getPageTitle()).as("Wrong title").isEqualTo(expectedTitle);
    }

    public void assertMailToText(String expectedText) {
        assertThat(getElementText(mailToLink)).as("Wrong Text").isEqualTo(expectedText);
    }

    public void assertUpperPosition() {
        assertThat(checkPosition()).as("Incorrect Position").isEqualTo(0);
    }

    public void assertMailToLink(String attribute, String expectedLink) {
        assertThat(getAttributeValue(mailToLink, attribute)).as("Wrong Text").isEqualTo(expectedLink);
    }

    public void clickFooterSendButton() {
        click(footerSendButton);
    }

    public void clickUpButtion() {
        click(backToTopButton);
        sleep(3000);
    }

    public void clickWhatsAppButton() {
        click(whatsAppButton);
    }

    public void getMainPageWindowHandle() {
        mainPageWindow = getWindowHandle();
    }

    public void switchToOpenedTab() {
        sleep(2000);
        switchToOpenedWindow();
    }

    public void clickSocialMedia(String socialMedia) {
        scrollDown();
        switch (socialMedia) {
            case "LinkedIn":
                click(linkedInIcon);
                break;
            case "WhatsApp":
                click(whatsAppSiteIcon);
                break;
            case "FaceBook":
                click(faceBookIcon);
                break;
            case "WebSite":
                click(webSiteIcon);
                break;
        }
    }

    public void clickArrow(String button) {
        navigateToObject(upperSlickSlide);
        startDataIndex = getDataIndex();
        switch (button) {
            case "Next":
                click(slickArrowNext);
                break;
            case "Previous":
                click(slickArrowPrevious);
                break;
        }
        endDataIndex = getDataIndex();
    }

    public int getDataIndex() {
        return Integer.valueOf(getAttributeValue(upperSlickSlide, "data-index"));
    }

    public void assertCorrectSwitch(String button) {
        int dataIndexDelta = endDataIndex - startDataIndex;
        switch (button) {
            case "Next":
                assertThat(dataIndexDelta).as("Wrong Direction").isEqualTo(1);
                break;
            case "Previous":
                assertThat(dataIndexDelta).as("Wrong Direction").isEqualTo(-1);
        }

    }

    public void assertFooterForm(String status) {
        switch (status) {
            case "Displayed":
                assertThat(footerForm.isDisplayed()).as("Wrong Direction").isTrue();
                break;
            case "Not Displayed":
                assertThat(footerForm.isDisplayed()).as("Wrong Direction").isFalse();
                break;
        }

    }

    public void fillLowerFormName(String name) {
        fillText(lowerFormNameField, name);
    }

    public void fillLowerFormCompany(String company) {
        fillText(lowerFormCompanyField, company);
    }

    public void fillLowerFormEmail(String email) {
        fillText(lowerFormEmailField, email);
    }

    public void fillLowerFormPhone(String phone) {
        fillText(lowerFormPhoneField, phone);
    }

    public void clickLowerFormSendButton() {
        click(lowerFormSendButton);
    }

    public void assertFormError(String field, String expectedError) {
        switch (field) {
            case "Name":
                assertThat(getElementText(lowerFormNameFieldError)).as("Wrong Message").isEqualTo(expectedError);
                break;
            case "Company":
                assertThat(getElementText(lowerFormCompanyFieldError)).as("Wrong Message").isEqualTo(expectedError);
                break;
            case "Email":
                assertThat(getElementText(lowerFormEmailFieldError)).as("Wrong Message").isEqualTo(expectedError);
                break;
            case "Phone":
                assertThat(getElementText(lowerFormPhoneFieldError)).as("Wrong Message").isEqualTo(expectedError);
                break;
            case "FooterName":
                assertThat(getElementText(footerNameErrorMessage)).as("Wrong Message").isEqualTo(expectedError);
                break;
            case "FooterEmail":
                assertThat(getElementText(footerEmailErrorMessage)).as("Wrong Message").isEqualTo(expectedError);
                break;
            case "FooterPhone":
                assertThat(getElementText(footerPhoneErrorMessage)).as("Wrong Message").isEqualTo(expectedError);
                break;
        }
    }


}
