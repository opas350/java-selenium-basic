package academy.basic.pages;

import javafx.util.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeFormPage {

    private WebDriver driver;

    public PracticeFormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private WebElement alert;

    @FindBy(how = How.ID, using = "draga")
    private WebElement draga;

    @FindBy(id = "dragb")
    private WebElement dragb;

    public void clickAlert(){
        alert.click();
    }

    public void dismissAlert(){
        driver.switchTo().alert().accept();
    }

    public boolean alertButtonIsVisible(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement alertStatus = wait.until(ExpectedConditions.visibilityOf(alert));
        return alertStatus.isEnabled();
    }

    public void dragAtoB(){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draga, dragb).build().perform();
        actions.moveToElement(draga)
                .pause(10)
                .clickAndHold(draga)
                .pause(10)
                .moveByOffset(1,0)
                .moveToElement(dragb)
                .moveByOffset(1, 0)
                .pause(10)
                .release().build().perform();
    }

    public void getJoinText(){
        System.out.println(dragb.getText());
    }
}
