package academy.basic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import academy.basic.drivercofig.TestBase;

public class MenuPage extends BasePage{

	private static By RED_TEA_CHECKOUT_BUTTON = By.id("wsb-button-00000000-0000-0000-0000-000451959280");

	public void clickRedTeaCheckOutButton(WebDriver driver) {
		driver.findElement(RED_TEA_CHECKOUT_BUTTON).click();
	}
}
