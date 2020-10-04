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


    @Test
    public void test_01(){
        steps.fillCorrectFooterForm(name, emailCorrect, phoneCorrect)
                .backToMainPage();
    }

    @Test
    public void test_02(){
        steps.fillCorrectLowerForm(name, company, emailCorrect, phoneCorrect)
                .backToMainPage();
    }
}
