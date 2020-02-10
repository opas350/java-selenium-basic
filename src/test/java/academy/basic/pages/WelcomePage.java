package academy.basic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WelcomePage extends BasePage{

	private static By NAVIGATION_CONTAINER = By.cssSelector("#wsb-nav-00000000-0000-0000-0000-000450914915");
	private static By WELCOME_BUTTON = By.cssSelector("#00000000-0000-0000-0000-000000247216");
	private static By OUR_PASSION_BUTTON = By.xpath("//*[@id='wsb-nav-00000000-0000-0000-0000-000450914915']/ul/li[2]/a");
	private static By MENU_BUTTON = By.cssSelector("#wsb-nav-00000000-0000-0000-0000-000450914915");
	private static By LETS_TALK_TEA_BUTTON = By.partialLinkText("Let's Talk Tea");
	private static By CHECK_OUT_BUTTON = By.className("wsb-element-navigation");

	public void getWelcomeButton(WebDriver driver) {
		driver.findElement(WELCOME_BUTTON).click();
	}

	public void clickOurPassionButton(WebDriver driver) {
		driver.findElement(OUR_PASSION_BUTTON).click();
	}

	public void clickMenuButton(WebDriver driver) {
		driver.findElement(MENU_BUTTON).click();
	}

	public void clickLetsTalkTeaButton(WebDriver driver) {
		driver.findElement(LETS_TALK_TEA_BUTTON).click();
	}

	public void clickCheckOutButton(WebDriver driver) {

		WebElement element = driver.findElement(NAVIGATION_CONTAINER);
		List<WebElement> elementsList = element.findElements(By.tagName("li"));

		for(WebElement x : elementsList){
		    if(x.getText().equals("Check Out")){
		    	x.click();
		    	break;
			}
		}
	}
}
