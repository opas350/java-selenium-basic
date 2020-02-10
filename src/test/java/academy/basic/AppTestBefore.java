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

public class AppTestBefore {
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
		driver.get("https://www.practiceselenium.com/welcome.html");
	}

	@BeforeMethod(groups = { "Working" })
	public void setupMethod(ITestResult context) {
		System.out.println(context.getMethod().getMethodName() + " is running");
		driver.get("https://www.practiceselenium.com/welcome.html");
	}

	@Test(description = "This is a sample", groups = { "Tea", "Working" })
	public void validateOurPassionText() {
		WebElement element;

		element = driver.findElement(By.xpath("//*[@id='wsb-nav-00000000-0000-0000-0000-000450914915']/ul/li[2]/a"));

		Assert.assertTrue(element.getText().equals("Our Passion"), "Our Passion was not found or visible");
	}

	@Test(description = "Click Menu and choose Red Tea", groups = { "Tea", "Working" })
	public void validateMenuIsClickable(ITestContext context) {
		WebElement element;
		driver.get("https://www.practiceselenium.com/welcome.html");
		element = driver.findElement(By.cssSelector("[data-pageid='00000000-0000-0000-0000-000009816342'"));
		element.click();

		Assert.assertTrue(driver.getTitle().equals("Menu"), "Menu Title is not pressent");
	}

	@Test(description = "Happy path flow", groups = { "NotWorking" })
	public void validateHappyPathRedTea() {

		// More repeated code!!!!!
	}

	@AfterTest(groups = { "Working" })
	public void tearDown() {
		driver.quit();
	}

	@AfterMethod(groups = { "Working" })
	public void logAfter(ITestResult result) {

		System.out.println();
		System.out.println(result.getMethod().getMethodName() + " is done!");
		System.out.println();

	}

}
