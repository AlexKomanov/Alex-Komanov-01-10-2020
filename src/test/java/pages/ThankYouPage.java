package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Alex Komanov
 */
public class ThankYouPage extends BasePage{

    @FindBy(css = "[class='thankYou__title-bl9e43-5 fSmmAW']")
    WebElement thankYouTitle;
    @FindBy(css = "[class='thankYou__backLink-bl9e43-10 idImZT']")
    WebElement backToMainButton;

    @FindBy(css = "[href='https://www.linkedin.com/company/herolo/'] img")
    WebElement linkedInIcon;
    @FindBy(css = "[href='https://www.instagram.com/herolofrontend/'] img")
    WebElement instagramIcon;
    @FindBy(css = "[href='https://www.facebook.com/Herolofrontend'] img")
    WebElement faceBookIcon;
    @FindBy(css = "[class='thankYou__button-bl9e43-9 NQqYi']")
    WebElement webSiteButton;

    private static String thankYouPageWindow;

    public static String getThankYouPageWindow() {
        return thankYouPageWindow;
    }

    public void getMainPageWindowHandle() {
        thankYouPageWindow = getWindowHandle();
    }

    public ThankYouPage() {
        super();
    }

    public void clickBackButton(){
        click(backToMainButton);
    }

    public void assertPageTitle(String expectedTitle) {
        assertThat(getPageTitle()).as("Incorrect Title").isEqualTo(expectedTitle);
    }

    public void assertPageUrl(String expectedUrl){
        assertThat(getPageUrl()).as("Incorrect URL").contains(expectedUrl);
    }

    public void assertMainTitle(String expectedTitle){
        assertThat(thankYouTitle.getText()).as("Incorrect Title").isEqualTo(expectedTitle);
    }

    public void clickSocialMedia(String socialMedia) {
        scrollDown();
        switch (socialMedia) {
            case "LinkedIn":
                click(linkedInIcon);
                break;
            case "Instagram":
                click(instagramIcon);
                break;
            case "FaceBook":
                click(faceBookIcon);
                break;
            case "WebSite":
                click(webSiteButton);
                break;
        }
    }

    public void switchToOpenedTab() {
        sleep(2000);
        switchToOpenedWindow();
    }

    public void switchBack(String window) {
        switchToWindow(window);
        sleep(1000);
    }
}
