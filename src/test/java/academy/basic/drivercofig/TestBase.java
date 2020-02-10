package academy.basic.drivercofig;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	private WebDriver driver;
	private ChromeOptions options = new ChromeOptions();

	private void setupCapabilities() {
		options.addArguments("--incognito");
		options.addArguments("start-maximized");
//		options.addArguments("--headless");
	}

	private void setupDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void logToConsole(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " is done!");
	}

	protected WebDriver getWebDriver() {
		return driver;
	}

	public void initDriver(){
		try{
			setupCapabilities();
			setupDriver();
		} catch (Exception e){
			System.out.println("Error --- " + e.getStackTrace());
		}
	}

	public void tearDown() {
		driver.quit();
	}
}
