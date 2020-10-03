package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AllureAttachment;

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


    protected static String mainPageWindow;

    public String getMainPageWindow() {
        return mainPageWindow;
    }
//
//
//        assertTrue(errorText.equals("שדה אימייל הוא שדה חובה"));
//
//        WebElement errMessage = driver.findElement(By.cssSelector("[name='phone'] + label"));
//        assertEquals(errMessage.isDisplayed(), true, "The error not displayed");
//
//        assertThat(errMessage.isDisplayed()).as("It is displayed").isTrue();
//

//        //nameField.sendKeys(Keys.ENTER);
//        nameField.sendKeys(value);

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

    public void assertEmailErrorMessage(String expectedMessage){
        assertThat(getElementText(footerEmailErrorMessage)).as("Wrong message").isEqualTo(expectedMessage);
    }

    public void assertPhoneErrorMessage(String expectedMessage){
        assertThat(getElementText(footerPhoneErrorMessage)).as("Wrong message").isEqualTo(expectedMessage);
    }

    public void assertMainPageTitle(String expectedTitle){
        assertThat(getPageTitle()).as("Wrong title").isEqualTo(expectedTitle);
    }

    public void assertMailToText(String expectedText){
        assertThat(getElementText(mailToLink)).as("Wrong Text").isEqualTo(expectedText);
    }

    public void assertMailToLink(String attribute, String expectedLink){
        assertThat(getAttributeValue(mailToLink, attribute)).as("Wrong Text").isEqualTo(expectedLink);
    }

    public void clickFooterSendButton(){
        click(footerSendButton);
    }

    public void clickWhatsAppButton(){
        click(whatsAppButton);
    }

    public void getMainPageWindowHandle(){
        mainPageWindow = getWindowHandle();
    }

    public void switchToOpenedTab(){
        sleep(2000);
        switchToOpenedWindow();
    }

    public void clickSocialMedia(String socialMedia){
        scrollDown();
        switch (socialMedia){
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


}
