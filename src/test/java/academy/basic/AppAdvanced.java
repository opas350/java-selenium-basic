package academy.basic;

import academy.basic.drivercofig.TestBase;
import academy.basic.pages.PracticeFormPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.util.RetryAnalyzerCount;

import java.util.concurrent.TimeUnit;

public class AppAdvanced extends TestBase {

    private static WebDriver driver = null;
    private static final String FORMS_URL = "http://www.seleniumframework.com/Practiceform/";

    @BeforeTest(alwaysRun = true)
    public void st(){
        initDriver();
        driver = getWebDriver();
    }

    @Test(description = "Page Factory Test", groups = "Page Factory", retryAnalyzer = RetryInit.class)
    public void validateAlert(){
        driver.get(FORMS_URL);

        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);

        practiceFormPage.clickAlert();
        practiceFormPage.dismissAlert();

        Assert.assertTrue(practiceFormPage.alertButtonIsVisible());

    }

    @Ignore
    @Test(description = "Page Factory Test", groups = "Page Factory", retryAnalyzer = RetryInit.class)
    public void validateDragAndDrop(){
        driver.get(FORMS_URL);

        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
        practiceFormPage.dragAtoB();
        practiceFormPage.getJoinText();

        Assert.assertTrue(true);
    }

    @AfterTest(alwaysRun = true)
    public void finish(){
        tearDown();
    }
}
