package academy.basic.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    // Create the driver variable to use all the WebDriver functions
    protected WebDriver driver;

    // Method that returns the current page title
    public String getPageTitle(WebDriver driver){
        return driver.getTitle();
    }
}
