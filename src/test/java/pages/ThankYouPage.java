package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Alex Komanov
 */
public class ThankYouPage extends BasePage{

    @FindBy(css = "[class='thankYou__title-bl9e43-5 fSmmAW']")
    WebElement thankYouTitle;
    @FindBy(css = "[class='thankYou__backLink-bl9e43-10 idImZT']")
    WebElement backToMainButton;

    public ThankYouPage() {
        super();
    }

    public void clickBackButton(){
        click(backToMainButton);
    }
}
