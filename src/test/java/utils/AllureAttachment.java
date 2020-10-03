package utils;

import com.github.underscore.lodash.U;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.OutputType.BYTES;

/**
 * @author Alex Komanov
 */
public class AllureAttachment {

    @Attachment(value = "{0}", type = "text/plain")
    public static String addTextAttachment(String message){
        return message;
    }

    @Attachment(value = "CSV attachment", type = "text/csv", fileExtension = ".csv")
    public static String attachCSV(String csv) {
        return csv;
    }

    @Attachment(value = "Element Screenshot {element.}", type = "image/png", fileExtension = ".png")
    public static byte[] attachElementScreenshot(WebElement element) {
        return element.getScreenshotAs(BYTES);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
        public static byte[] captureScreenshot(WebDriver driver) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }

    @Attachment(value = "JSON attachment", type = "application/json", fileExtension = ".json")
    public static String attachJson(String json) {
        return U.formatJson(json);
    }
}
