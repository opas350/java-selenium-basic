package academy.basic;

import academy.basic.drivercofig.TestBase;
import academy.basic.pages.CheckOutPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import academy.basic.pages.MenuPage;
import academy.basic.pages.WelcomePage;
import org.testng.log4testng.Logger;

import java.util.logging.LogManager;

public class AppTestImproved extends TestBase{

    private WebDriver driver;
    private WelcomePage welcomePage;
    private MenuPage menuPage;
    private CheckOutPage checkOutPage;
    private final String TEA_URL = "http://www.practiceselenium.com/welcome.html";
    private final String ADDRESS = "Fake Street 123";

    public static  final Logger LOGGER = Logger.getLogger(AppTestImproved.class);

	@BeforeClass(alwaysRun = true)
	public void setup(){
		initDriver();
		driver = getWebDriver();
	}

	@BeforeMethod(alwaysRun = true)
	public void setupPages(){
		this.welcomePage = new WelcomePage();
		this.menuPage = new MenuPage();
		this.checkOutPage = new CheckOutPage();
	}

	@DataProvider(name="AccountInfo")
	public Object[][] getAccountInfoDataProvider(){
		return new Object[][]{
				{"email_1@test.com", "User 1", " Fake Street 123", "Visa", "123456", "Cardholder Name 1", "737"},
				{"email_2@test.com", "User 2", "Evergreen", "Mastercard", "654321", "Cardholder Name 2", "373"},
		};
	}

	@Ignore
	@Test(description = "Validate Menu redirect", groups = {"Happy Path"})
	public void validateMenuRedirect(){
		LOGGER.info("Running validate Menu Redirect");
		driver.get(TEA_URL);
		welcomePage.getPageTitle(driver);
		welcomePage.clickMenuButton(driver);
		Assert.assertEquals(menuPage.getPageTitle(driver), "Menu");
	}

	@Ignore
	@Test(description = "Happy path for red Tea", groups = { "Happy Path" })
	@Parameters({"email", "name", "cc", "cc_number", "holder_name", "code"})
	public void validateHappyPathRedTea(@Optional String email, @Optional String name, @Optional String cc,
										@Optional String cc_number, @Optional String holder_name, @Optional String code) {
		LOGGER.info("Running validateHappyPathRedTea");
		driver.get(TEA_URL);

		welcomePage.clickMenuButton(driver);
		menuPage.clickRedTeaCheckOutButton(driver);
		checkOutPage.enterEmail(email, driver);
		checkOutPage.enterName(name, driver);
		checkOutPage.enterAddress(ADDRESS, driver);
		checkOutPage.enterCardType(cc, driver);
		checkOutPage.enterCardNumber(cc_number, driver);
		checkOutPage.enterCardHolderName(holder_name, driver);
		checkOutPage.enterVerificationCode(code, driver);

		Assert.assertTrue(checkOutPage.clickPlaceOrder(driver));
	}

	@Ignore
	@Test(description = "Happy path with DataProvider", groups = {"Happy Path"}, dataProvider = "AccountInfo" )
	public void validateHappyPathWithDataProvider(String email, String name, String address, String cc, String cc_number,
												  String holder_name, String code){
	    LOGGER.info("Running validateHappyPathWithDataProvider");
		driver.get(TEA_URL);

		welcomePage.clickMenuButton(driver);
		menuPage.clickRedTeaCheckOutButton(driver);

		checkOutPage.enterEmail(email, driver);
		checkOutPage.enterName(name, driver);
		checkOutPage.enterAddress(address, driver);
		checkOutPage.enterCardType(cc, driver);
		checkOutPage.enterCardNumber(cc_number, driver);
		checkOutPage.enterCardHolderName(holder_name, driver);
		checkOutPage.enterVerificationCode(code, driver);

		Assert.assertTrue(checkOutPage.clickPlaceOrder(driver));
	}

	@AfterTest(alwaysRun = true)
	public void tearDownDriver(){
		tearDown();
	}
}
