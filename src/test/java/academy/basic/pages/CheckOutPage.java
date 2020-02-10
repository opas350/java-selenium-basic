package academy.basic.pages;

import academy.basic.drivercofig.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage extends BasePage{

    private final By EMAIL_INPUT = By.id("email");
    private final By NAME_INPUT = By.id("name");
    private final By ADDRESS_INPUT = By.id("address");
    private final By CARD_TYPE = By.id("card_type");
    private final By CARD_NUMBER = By.id("card_number");
    private final By CARD_HOLDER_NAME = By.id("cardholder_name");
    private final By VERIFICATION_CODE = By.id("verification_code");
    private final By PLACE_ORDER = By.xpath("//*[@id='wsb-element-00000000-0000-0000-0000-000452010925']/div/div/form/div/button");

    public void enterEmail(String email, WebDriver driver){
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    public void enterName(String name, WebDriver driver){
        driver.findElement(NAME_INPUT).sendKeys(name);
    }

    public void enterAddress(String address, WebDriver driver){
        driver.findElement(ADDRESS_INPUT).sendKeys(address);
    }

    public void enterCardType(String cardType, WebDriver driver){
        driver.findElement(CARD_TYPE).sendKeys(cardType);
    }

    public void enterCardNumber(String cardNumber, WebDriver driver){
        driver.findElement(CARD_NUMBER).sendKeys(cardNumber);
    }

    public void enterCardHolderName(String cardHolder, WebDriver driver){
        driver.findElement(CARD_HOLDER_NAME).sendKeys(cardHolder);
    }

    public void enterVerificationCode(String verificationCode, WebDriver driver){
        driver.findElement(VERIFICATION_CODE).sendKeys(verificationCode);
    }

    public boolean clickPlaceOrder(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(PLACE_ORDER).click();
        WebElement imageAfterCheckout = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='wsb-element-00000000-0000-0000-0000-000451933201']/div/div/img"))));
        return imageAfterCheckout.isDisplayed();
    }
}
