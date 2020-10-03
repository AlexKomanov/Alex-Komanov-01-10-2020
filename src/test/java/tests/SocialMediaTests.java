package tests;

import org.testng.annotations.Test;

/**
 * @author Alex Komanov
 */
public class SocialMediaTests extends BaseTest {

    @Test
    public void generalTest(){
        steps.navigateToSocialMedia("FaceBook");
    }
}
