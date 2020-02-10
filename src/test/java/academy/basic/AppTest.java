package academy.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {

	private WebDriver driver;
	private ChromeOptions options = new ChromeOptions();

	@BeforeSuite(groups = { "Working" })
	public void setupDriver() {
		options.addArguments("--incognito");
		options.addArguments("start-maximized");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
	}

	@BeforeTest(groups = { "Working" })
	public void setupTest() {
		System.out.println("--------------- BEFORE TEST ---------------");
		driver.get("https://www.practiceselenium.com/welcome.html");
		System.out.println("--------------- BEFORE TEST END --------------");
	}

	@BeforeMethod(groups = { "Working" })
	public void setupMethod(ITestResult context) {
		System.out.println("--------------- BEFORE METHOD -----------");
		System.out.println(context.getMethod().getMethodName() + " is running");
		driver.get("https://www.practiceselenium.com/welcome.html");
		System.out.println("--------------- BEFORE METHOD END --------------");
	}

	@Test(description = "This is a sample", groups = { "Tea", "Working" })
	public void validateOurPassionText() {
		System.out.println("--------------- TEST START --------------");
		WebElement element;

		element = driver.findElement(By.xpath("//*[@id='wsb-nav-00000000-0000-0000-0000-000450914915']/ul/li[2]/a"));

		System.out.println("--------------- TEST END --------------");

		Assert.assertTrue(element.getText().equals("Our Passion"), "Our Passion was not found or visible");
	}

	@Test(description = "Click Menu and choose Red Tea", groups = { "Tea", "Working" })
	public void validateMenuIsClickable(ITestContext context) {
		System.out.println("--------------- TEST START --------------");
		WebElement element;
		driver.get("https://www.practiceselenium.com/welcome.html");
		element = driver.findElement(By.cssSelector("[data-pageid='00000000-0000-0000-0000-000009816342'"));
		element.click();

		System.out.println("--------------- TEST START END --------------");
		Assert.assertEquals(driver.getTitle(), "Menu", "Menu Title is not pressent");
	}

	@Test(description = "Happy path flow", groups = { "NotWorking" })
	public void validateHappyPathRedTea() {

		// More repeated code!!!!!
	}

	@AfterTest(groups = { "Working" })
	public void tearDown() {
		System.out.println("--------------- After TEST --------------");
		driver.quit();
		System.out.println("--------------- After TEST END --------------");
	}

	@AfterMethod(groups = { "Working" })
	public void logAfter(ITestResult result) {
		System.out.println("--------------- AFTER METHOD  --------------");
		System.out.println();
		System.out.println(result.getMethod().getMethodName() + " is done!");
		System.out.println();
		System.out.println("--------------- AFTER METHOD END --------------");
	}

}
