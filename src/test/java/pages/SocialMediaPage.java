package pages;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Alex Komanov
 */
public class SocialMediaPage extends BasePage {

    public SocialMediaPage() {
        super();
    }

    public void assertPageTitle(String expectedTitle) {
        System.out.println(getPageTitle());
        assertThat(getPageTitle()).as("Wrong page title").contains(expectedTitle);
    }

    public void assertPageUrl(String expectedTitle) {
        assertThat(getPageUrl()).as("Wrong URL").contains(expectedTitle);
    }

    public void switchBack(String window) {
        switchToWindow(window);
    }

    public void closeCurrentWindow() {
        closeCurrentTab();
    }
}
