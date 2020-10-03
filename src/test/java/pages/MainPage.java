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
    @FindBy(css = "[class='Footer__Button-sc-1xqajj9-7 jixtxJ']")
    WebElement footerSendButton;
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

    public void fillFooterEmailField(String text) {

    }

    public void fillFooterPhoneField(String text) {

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
        naviעateToObject(upperSlickSlide);
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


}
