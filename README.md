# Selenium Academy
# Javier Reyes [link](https://github.com/opas350)

# Setup

### Maven
* Download Maven **bin** from this [link](https://maven.apache.org/)
* Unzip file and add the path to your system variables with administrator privileges. More info [here](https://www.java.com/en/download/help/path.xml)
* Set JAVA_HOME to your system variables also. More information [here](https://javatutorial.net/set-java-home-windows-10)
* On cmd (windows console) type `mvn -v` it should return something similar to this
```
Apache Maven 3.6.0 (97c98ec64a1fdfee7767ce5ffb20918da4f719f3; 2018-10-24T13:41:47-05:00)
Maven home: C:\PATH.TO.YOUR.FOLDER\apache-maven-3.6.0-bin\apache-maven-3.6.0
Java version: 1.8.0_181, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk1.8.0_181\jre
Default locale: en_US, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```

### Generating new project from archetype
The final files are attached, but in case there is the need to start from scratch here is the procedure.
* Use the cmd (Command Line) and go to the directory where you want to create the root of your project.
* Type `mvn archetype:generate` the Command Line Interface (CLI) will 

On execution it should appear something like this.

```
2436: remote -> us.fatehi:schemacrawler-archetype-plugin-dbconnector (-)
2437: remote -> us.fatehi:schemacrawler-archetype-plugin-lint (-)
2438: remote -> ws.osiris:osiris-archetype (Maven Archetype for Osiris)
2439: remote -> xyz.luan.generator:xyz-gae-generator (-)
2440: remote -> xyz.luan.generator:xyz-generator (-)
Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): 1381:
```

To find the desired archetype type `webdriver` to filter the results
```
Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): 1381: webdriver
Choose archetype:
1: remote -> com.github.webdriverextensions:webdriverextensions-archetype-quickstart (Use this archetype to create a new Page Object Pattern based WebDriver Extension project.)
2: remote -> com.saucelabs:quickstart-webdriver-junit (-)
3: remote -> com.saucelabs:quickstart-webdriver-testng (-)
4: remote -> io.testsmith:webdriver-testng-archetype (Generates a basic skeleton project with Selenium WebDriver, WebDrivermanager, TestNG and Allure)
5: remote -> ru.stqa.selenium:webdriver-java-archetype (Archetype for a Maven project intended to develop tests with Selenium WebDriver and JUnit/TestNG)
6: remote -> ru.stqa.selenium:webdriver-junit-archetype (Archetype for a Maven project intended to develop tests with Selenium WebDriver and JUnit)
7: remote -> ru.stqa.selenium:webdriver-junit5-archetype (Archetype for a Maven project intended to develop tests with Selenium WebDriver and JUnit5)
8: remote -> ru.stqa.selenium:webdriver-testng-archetype (Archetype for a Maven project intended to develop tests with Selenium WebDriver and TestNG)
Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): :
```
For the examples we used `testng` so we will use `webdriver-testng-archetype` or option `8` **(The option can be different as the remotes get updated)**

For the version you can choose any and for this case we will use the newest 

```
Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): : 8
Choose ru.stqa.selenium:webdriver-testng-archetype version:
1: 1.1.41
2: 1.1.42
3: 1.1.43
4: 1.1.45
5: 1.1.46
6: 2.0
7: 2.1
8: 3.0
9: 4.0
10: 4.1
11: 4.2
12: 4.3
Choose a number: 12: 12
Define value for property 'groupId': test.archetype
Define value for property 'artifactId': TestArchetype
Define value for property 'version' 1.0-SNAPSHOT: :
Define value for property 'package' test.archetype: :
Confirm properties configuration:
groupId: test.archetype
artifactId: TestArchetype
version: 1.0-SNAPSHOT
package: test.archetype
```

For `groupId` you can use any word and `.` instead of space

For `artifactId` you can use any value separated with `-`

The other values can be left with the default by just pressing `enter`

After that the project should be created 

```
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: groupId, Value: test.example
[INFO] Parameter: artifactId, Value: Example-Test
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] Parameter: package, Value: test.example
[INFO] Parameter: packageInPathFormat, Value: test/example
[INFO] Parameter: package, Value: test.example
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] Parameter: groupId, Value: test.example
[INFO] Parameter: artifactId, Value: Example-Test
[WARNING] Don't override file C:\Users\javiera.reyes\academy-workspace\trash\Example-Test\pom.xml
[INFO] Project created from Archetype in dir: C:\Users\javiera.reyes\academy-workspace\trash\Example-Test
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  45.106 s
[INFO] Finished at: 2019-07-05T17:56:17-05:00
[INFO] ------------------------------------------------------------------------
```

Now the project will have the following structure

```
C:.
└───Example-Test
    │   pom.xml
    │
    └───src
        ├───main
        │   ├───java
        │   │   └───test
        │   │       └───example
        │   └───resources
        └───test
            ├───java
            │   └───test
            │       └───example
            │           │   SampleTestNgTest.java
            │           │   SuiteConfiguration.java
            │           │   TestNgTestBase.java
            │           │
            │           └───pages
            │                   HomePage.java
            │                   Page.java
            │
            └───resources
                    application.properties
                    chrome.capabilities
                    debug.properties
                    firefox.capabilities
                    htmlunit.capabilities
                    ie.capabilities
                    opera.capabilities
                    phantomjs.capabilities
                    safari.capabilities
                    testng.xml
```

### Adding dependencies to POM.xml

On the root of the project is the `POM.xml` where the dependencies are defined, to understand more about how to work with the POM 
is recommended the following [link](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html)

[Maven Repository](https://mvnrepository.com/) is the main source to find any dependency that can be added to the project, for this project we will add 
`WebDriverManager`, you can look for it or just copy the following code 
```xml
<dependencies>
    <!-- Other Dependencies -->
    <!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>3.6.1</version>
    </dependency>
    <!-- Other Dependencies -->
</dependencies>

```

**Note: the dependency should be added between the dependencies tags**

After that make sure you save the changes then on console type `mvn install` and the additional dependencies will be added.

# AppTest.java
This file is the same as the first exercise, the only main difference is 
the use of the tags `@Before` and `@After` for test, method and suite.

This is for the main purpose to understand the scopes for each tag.



```
 INFO: Detected dialect: W3C
  --------------- BEFORE TEST ---------------
  --------------- BEFORE TEST END --------------
  --------------- BEFORE METHOD -----------
  validateHappyPathRedTea is running
  --------------- BEFORE METHOD END --------------
  --------------- AFTER METHOD  --------------
  
  validateHappyPathRedTea is done!
  
  --------------- AFTER METHOD END --------------
  --------------- BEFORE METHOD -----------
  validateMenuIsClickable is running
  --------------- BEFORE METHOD END --------------
  --------------- TEST START --------------
  --------------- TEST START END --------------
  --------------- AFTER METHOD  --------------
  
  validateMenuIsClickable is done!
  
  --------------- AFTER METHOD END --------------
  --------------- BEFORE METHOD -----------
  validateOurPassionText is running
  --------------- BEFORE METHOD END --------------
  --------------- TEST START --------------
  --------------- TEST END --------------
  --------------- AFTER METHOD  --------------
  
  validateOurPassionText is done!
  
  --------------- AFTER METHOD END --------------
  --------------- After TEST --------------
  --------------- After TEST END --------------
  
  ===============================================
  Default Suite
  Total tests run: 3, Failures: 0, Skips: 0
  =============================================== 
```

The methods show when they start to run and when they end, also is worth noticing 
`@ITestResult` that is used to get the information of the test case for more information
here is the [documentation](https://static.javadoc.io/org.testng/testng/6.8.21/org/testng/ITestResult.html)

#AppTestImproved

This exercise took some of the things that where done and make some improvements to make the code more encapsulated and reusable.

The approach that will be used is Page Object Model for a brief introduction you can read the following [article](https://medium.com/tech-tajawal/page-object-model-pom-design-pattern-f9588630800b)

The project structure to be used is the following, most if not all the changes will be done on the `src/test`, proceed to create the following directories `src/test/your artifact name is here/driverconfig` and `src/test/..../pages`
after that the structure should be similar to this.
```
├───main
│   ├───java
│   │   └───academy
│   │       └───basic
│   └───resources
└───test
    ├───java
    │   └───academy
    │       └───basic
    │           ├───drivercofig
    │           ├───pages
    │           └───Utilities
    └───resources
```


To start we will create the `TestBase.java` and `PageBase.java` which as the name implies both classes will be inherited and shared between them.

##BasePage.java
Create the file `pages/BasePage.java` this file will contain all the different functions that are shared between all the pages, like getting the url, or source.

```java
public class BasePage {

    // Create the driver variable to use all the WebDriver functions
    protected WebDriver driver;

    // Method that returns the current page title
    public String getPageTitle(WebDriver driver){
        return driver.getTitle();
    }
}
```

**Note: Remember to use the IDE help to make sure you have all the imports, try using ctrl+space to access the help**

###WebDriver functions breakdown
`getTitle()` 
Use this function to retrieve the Title  of the current page, the function returns `null` in case there is no title set.

For more information [here](https://static.javadoc.io/org.seleniumhq.selenium/selenium-api/2.50.1/org/openqa/selenium/WebDriver.html#getTitle--)

**Remember in order to use the WebDriver methods we need to have a instance of the driver**

##TestBase.java

First step is to create the file `/driverconfig/TestBase.java` :
```java
public class TestBase{
    // The class right now is empty
}
```

###Creating and configuring the WebDriver Instance
Create the class variables of `driver` and `options` as the following:
```java
public class TestBase{
    private WebDriver driver;
    private ChromeOptions options = new ChromeOptions();
}
```

###ChromeOptions
The new instance of the class ChromeOptions is what be used to configure the browser (In this example Chrome) with the desired properties
that can change the way the browser starts or behaves during the test execution.

We will use the following parameters:
```
--incognito
start-maximized
//Optional
--headless
```

`--incognito` This parameter will start the browser in incognito mode, and can be helpful to avoid cache issues.

`start-maximized` Just as it states

`--headless` This parameter will run the test with a invisible browser

For additional chrome capabilities [here](https://sites.google.com/a/chromium.org/chromedriver/capabilities)

There are some general capabilities that can be used regardless the browser/driver. [here](https://github.com/SeleniumHQ/selenium/wiki/DesiredCapabilities)

The next step is to modify `TestBase.java` and add the options

```java 
public class TestBase{
    // ... code omitted to make it shorter
    private void setupCapabilities() {
    		options.addArguments("--incognito");
    		options.addArguments("start-maximized");
    //		options.addArguments("--headless");
    	}
}
```

Now to create the method which will be called to load the driver and the configuration.
```java
public class TestBase{
    // ... Previous code omitted
    	private void setupDriver() {
    		WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver(options); // Use the options defined 
    		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	}
}
```

This method uses `WebDriverManager` which was one of the dependencies that was added on the `POM.xml`, this class is in charge of retrieving the location of the driver in this case `chromedriver.setup()` there are other methods to call other browser specific drivers.

The line `driver = new ChromeDriver(options);` creates the instance of the chrome driver and loads the parameters.

Right now we have two different methods and to achieve the desired sequence and avoid unhandled errors we will add the following method:
```java
public class TestBase{
    // ... Previous code omitted
	public void initDriver(){
		try{
			setupCapabilities();
			setupDriver();
		} catch (Exception e){
			System.out.println("Error --- " + e.getStackTrace());
		}
	}
}
```
We call the methods `setupCapabilities()` and then `setupDriver()` and wrap those methods in a try/catch block
as the setupDriver() could throw an error if the `chromedriver.exe` is not found

We need to add another method to call that will close the driver, and avoiding any zombie instances of the driver to remain open.
```java
public class TestBase{
    //....
    
	public void tearDown() {
		driver.quit();
	}
}
```

The final step is to create a getter as we want to make sure only this class can create the webdriver
```java
public class TestBase{
    	protected WebDriver getWebDriver() {
    		return driver;
    	}
}
```
When we require to use or set the driver we should use this method to save the instance to a variable to future use.

`TestBase.java` should end up similar to this:
```java
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
```

##Setting the Page Objects
The page that will be used is the following [Tea Company](https://www.practiceselenium.com/welcome.html) site, and the chrome developer tools were used to retrieve the id,class or xpath of all the elements.

To make the code more maintainable we will create a page model for each of the website pages that will be used.

##WelcomePage.java

The `WelcomePage` class will extend `BasePage` that we previously defined, then we will define the [WebElements](https://seleniumhq.github.io/selenium/docs/api/javascript/module/selenium-webdriver/index_exports_WebElement.html)
of the page that we will use, these elements are the navigation buttons located on the left.
```java
public class WelcomePage extends BasePage{

	private static By NAVIGATION_CONTAINER = By.cssSelector("#wsb-nav-00000000-0000-0000-0000-000450914915");
	private static By WELCOME_BUTTON = By.cssSelector("#00000000-0000-0000-0000-000000247216");
	private static By OUR_PASSION_BUTTON = By.xpath("//*[@id='wsb-nav-00000000-0000-0000-0000-000450914915']/ul/li[2]/a");
	private static By MENU_BUTTON = By.cssSelector("#wsb-nav-00000000-0000-0000-0000-000450914915");
	private static By LETS_TALK_TEA_BUTTON = By.partialLinkText("Let's Talk Tea");
	private static By CHECK_OUT_BUTTON = By.className("wsb-element-navigation");
}
```

In the code snippet above we used `static` but they could be `final` as well as we don't wan't any other method to change the selector.

Also the use of `By` to find the elements, for more info [here](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/By.html)

Next we will add the methods to interact with the elements.
```java
public class WelcomePage extends BasePage{
    // ... previous code
    
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

    // This method used a method to find the element via the nav-bar and demonstrates a case where the element is hard to reach
	public void clickCheckOutButton(WebDriver driver) {

		WebElement element = driver.findElement(NAVIGATION_CONTAINER);
		List<WebElement> elementsList = element.findElements(By.tagName("li"));

        // The break is important to avoid additional cycles
		for(WebElement x : elementsList){
		    if(x.getText().equals("Check Out")){
		    	x.click();
		    	break;
			}
		}
	}
}
```

the `click` method is implemented on the WebDriver class and is available for WebElements.

##MenuPage.java
Next the menu page model will be implemented create `pages/MenuPage.java` and add the following lines:
```java
public class MenuPage extends BasePage{

	private static By RED_TEA_CHECKOUT_BUTTON = By.id("wsb-button-00000000-0000-0000-0000-000451959280");

	public void clickRedTeaCheckOutButton(WebDriver driver) {
		driver.findElement(RED_TEA_CHECKOUT_BUTTON).click();
	}
}
```

There are several other methods that can be implemented, but for now we will just use that one in which we will proceed to the product checkout

##CheckOutPage.java
Create the `pages/CheckOutPage.java` and define the locator to be used for the WebElements
```java
public class CheckOutPage extends BasePage{

    private final By EMAIL_INPUT = By.id("email");
    private final By NAME_INPUT = By.id("name");
    private final By ADDRESS_INPUT = By.id("address");
    private final By CARD_TYPE = By.id("card_type");
    private final By CARD_NUMBER = By.id("card_number");
    private final By CARD_HOLDER_NAME = By.id("cardholder_name");
    private final By VERIFICATION_CODE = By.id("verification_code");
    private final By PLACE_ORDER = By.xpath("//*[@id='wsb-element-00000000-0000-0000-0000-000452010925']/div/div/form/div/button");
}
```
The defined WebElements correspond to all the available inputs from the form.

After the elements are defined we should add the methods to send the text to the form, or interact with the elements.
```java
public class CheckOutPage extends BasePage {
    
    // ...Previous code
    
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
}
```
The methods from above implement the method `sendKeys()` to send the `String` value to the input field.

Also all the methods are being injected the driver instantiated on the Test to be used to find and sent the information.

Finally as the test page doesnt have a specific confirmation page after placing the order, and it just redirect to the menu page. Then we will wait 
the page loads and look for the tea picture to confirm it has "Completed the purchase"
```java
public class CheckOutPage{
    // ... Previous code
    
    // This method will sent true if the page was redirected after a completed purchase
    public boolean clickPlaceOrder(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(PLACE_ORDER).click();
        WebElement imageAfterCheckout = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='wsb-element-00000000-0000-0000-0000-000451933201']/div/div/img"))));
        return imageAfterCheckout.isDisplayed();
    }
}
```
For the method above we implemented explicit wait using the class `WebDriverWait` and setting the amount in seconds to wait for the element.

Then we used the class `ExpectedConditions` which has several implemented methods that can be used to verify a specific state of a webElement, in this
case we wait for `visibilityOf` a WebElement of the defined Locator.


##AppTestImproved.java

Create the `AppTestImproved.java` and add the class variables for the driver and the page objects.
```java
public class AppTestImproved extends TestBase{

    private WebDriver driver;
    private WelcomePage welcomePage;
    private MenuPage menuPage;
    private CheckOutPage checkOutPage;
    private final String TEA_URL = "http://www.practiceselenium.com/welcome.html";
    private final String ADDRESS = "Fake Street 123";
}
```
After that we can add the `@Before` and `@After` methods to do the setup and teardown for the test.
```java
public class AppTestImproved extends TestBase{
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
    @AfterTest(alwaysRun = true)
        public void tearDownDriver(){
        		tearDown();
        	}
}
```
The `alwaysRun = true` parameter is used as we want to always run those steps.

Our first Test will just validate that clicking the Menu button redirects to the Menu page.
###Validate Menu Redirect Test
```java
public class AppTestImproved extends TestBase{
    // ... Previous code
    @Ignore
    @Test(description = "Validate Menu redirect", groups = {"Happy Path"})
    public void validateMenuRedirect(){
        driver.get(TEA_URL);
        welcomePage.getPageTitle(driver);
        welcomePage.clickMenuButton(driver);
        // We validate the getPageTitle return "Menu" string
        Assert.assertEquals(menuPage.getPageTitle(driver), "Menu");
    }
}
```

To run the test you can use the IDE or run the command `mvn test`, but first make sure you have configured the `testng.xml` file located
on the `resources` folder.
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="Example Suite" verbose="5">
<test name="Example Tests">
</test>
		<test name="Happy Path Test">
		<groups>
			<run>
				<include name="Happy Path" />
			</run>
		</groups>
 		<classes>
            <class name="academy.basic.AppTestImproved"/>
 		</classes>
	</test>
</suite>
```
If everything is correct than the terminal should display something similar to this.
```
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running TestSuite
...
... TestNG 6.14.2 by Cédric Beust (cedric@beust.com)
...

SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Starting ChromeDriver 75.0.3770.8 (681f24ea911fe754973dda2fdc6d2a2e159dd300-refs/branch-heads/3770@{#40}) on port 4564
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Jul 07, 2019 2:58:07 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 27.07 s - in TestSuite
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  34.739 s
[INFO] Finished at: 2019-07-07T14:58:23-05:00
[INFO] ------------------------------------------------------------------------
```
###Validate Happy Path with parameters
Now we will create a test that will do a happy path from welcome page to checkout using the `@Parameters` function to define the information to be filled.

This can be used to avoid the hardcoding of the values on the src code, and pass the parameters among different test and suites that are defined on the `testng.xml`
for more information you can check the [documentation](https://testng.org/doc/documentation-main.html)

The information is required to fill the "customer data" which input fields are defined on the `CheckOutPage.java` like first name, last name,
email and others.

First `testng.xml` will be modified to add the parameters
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="Example Suite" verbose="5">
	<parameter name="email" value="test@mail.com" />
	<parameter name="name" value="Test User"/>
	<parameter name="address" value="Fake Street 123"/>
	<parameter name="cc" value="Visa"/>
	<parameter name="cc_number" value="123456"/>
	<parameter name="holder_name" value="User 1"/>
	<test name="Example Tests">
	<!-- Unmodified code beyond here -->
```
The `<parameter />` tag should contain the `name` which is the variable name to be used in the test and also should contain `value`.

Next we should create our test `validateHappyPathRedTea` with the annotation `@Parameters` and the name of the parameters defined on the xml file and those same names as the arguments for the test.
```java
public class AppTestImproved{
    //... previous code
    @Test(description = "Happy path for red Tea", groups = { "Happy Path" })
    @Parameters({"email", "name", "cc", "cc_number", "holder_name", "code"})
    public void validateHappyPathRedTea(@Optional String email, @Optional String name, @Optional String cc,
    										@Optional String cc_number, @Optional String holder_name, @Optional String code) {
        driver.get(TEA_URL);
    
        welcomePage.clickMenuButton(driver);
        menuPage.clickRedTeaCheckOutButton(driver);
        checkOutPage.enterEmail(email, driver);
        checkOutPage.enterName(name, driver);
        checkOutPage.enterAddress(ADDRESS, driver); // Example of how to use a value defined in class
        checkOutPage.enterCardType(cc, driver);
        checkOutPage.enterCardNumber(cc_number, driver);
        checkOutPage.enterCardHolderName(holder_name, driver);
        checkOutPage.enterVerificationCode(code, driver);
    
        Assert.assertTrue(checkOutPage.clickPlaceOrder(driver));
    }
    	// ... rest of code
}
```
`@Optional` used to help the IDE execute the test case directly, otherwise some errors may appear if the execution method used is IDE instead of cmd line as there is a dependency from the `testng.xml`

Also you can add `@Ignore` annotation to the previous test so the execution just focus on the new test.

###Validate Happy Path with dataprovider
Using `@Parameters` is useful to run multiple test with the same unchanging information, but when there is the need to test or validate the same fields with different information, for example to validate a input field with different values.

To do this the use of `@DataProvider` is useful, the use of the data provider allows to create an object with the different values.
```java
public class AppTestImproved extends TestBase{
    // ... prev code
    @DataProvider(name="AccountInfo")
    public Object[][] getAccountInfoDataProvider(){
        return new Object[][]{
                {"email_1@test.com", "User 1", " Fake Street 123", "Visa", "123456", "Cardholder Name 1", "737"},
                {"email_2@test.com", "User 2", "Evergreen", "Mastercard", "654321", "Cardholder Name 2", "373"},
    	};
    }
    // ... rest of code
}
```
The annotation `@DataProvider(name="AccountInfo")` declares the method below should be used on the test that has the `AccountInfo` provider as dependency.

The object created has 2 different data entries which when called to be used on the test, the execution will recognise and run the test for each of the entries without any additional setup.

Now add the test
```java
public class AppTextImproved extends TestBase{
    // ... prev code
    	@Test(description = "Happy path with DataProvider", groups = {"Happy Path"}, dataProvider = "AccountInfo" )
    	public void validateHappyPathWithDataProvider(String email, String name, String address, String cc, String cc_number,
    												  String holder_name, String code){
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
}
```
With everything in place execute the test and the result should be similar:
```
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running TestSuite
...
... TestNG 6.14.2 by Cédric Beust (cedric@beust.com)
...

SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Starting ChromeDriver 75.0.3770.8 (681f24ea911fe754973dda2fdc6d2a2e159dd300-refs/branch-heads/3770@{#40}) on port 18585
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Jul 07, 2019 6:16:44 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 69.07 s - in TestSuite
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:18 min
[INFO] Finished at: 2019-07-07T18:17:44-05:00
[INFO] ------------------------------------------------------------------------
```
`Test run: 2` confirms the execution of the test for each data set.

For a more graphical report check `target/surefire-reports/index.html`

#AppAdvanced Example
The final example will be used to show another built-in functionality on selenium.

[Page Factory](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/PageFactory.html) by using this class some of the boilerplate code can be avoided, for the following example [this](http://www.seleniumframework.com/Practiceform/) site will be used.

The fist step is to create the `pages/PracticeFormPage.java` and add the following code
```java
public class PracticeFormPage{
    private WebDriver driver;
    
    public PracticeFormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
```
The code above is just the class constructor that on execution will autogenerate the locators for the elements specified below.
```java
public class AppAdvanced extends TestBase {
    // ... previous code 
    // Location Method 1
     private WebElement alert;
       
    // Location Method 2
     @FindBy(how = How.ID, using = "draga")
     private WebElement draga;
    
    // Location Method 3
     @FindBy(id = "dragb")
     private WebElement dragb;
    
}
```
The method 1 consist in using the variable name of `alert`, the `PageFactory` class will iterate by looking a WebElement with `id` `alert` if not found it will look for classname, etc.
If the page is simple enough this approach can greatly reduce the amount of code.

Method 2 uses the same approach and we use the id as variable name, but also use the `@FindBy` annotation to specify the search method like `How.ID` or `How.ID_OR_NAME` among others, also we can specify the specific value

Finally method 3 is a shorter version of the method two in which we just add the type of locator `id` and then assign the id we are looking for.

All the methods above are alternatives for the classic `driver.findElement(By.cssSelector(xxxxx))`

For the example purposes methods handling the alert are defined.
```
 public void clickAlert(){
        alert.click();
    }

    public void dismissAlert(){
        driver.switchTo().alert().accept();
    }

    public boolean alertButtonIsVisible(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement alertStatus = wait.until(ExpectedConditions.visibilityOf(alert));
```
`switchTo().alert()` methods are defined on the webdriver to handle the interactions with other elements that can change the focus of what the browser can work with.

Using `switchTo` to change the focus to the alert which is being displayed above the page is necessary, otherwise the driver wont be able to interact, a similar instance is when working with browsers in multiple windows or iFrames.

##AppAdvanced.java
Create `AppAdvanced.java` and for the test the approach is similar to the other test created.
```java
public class AppAdvanced extends TestBase {

    private static WebDriver driver = null;
    private static final String FORMS_URL = "http://www.seleniumframework.com/Practiceform/";

    @BeforeTest(alwaysRun = true)
    public void st(){
        initDriver();
        driver = getWebDriver();
    }

    @Test(description = "Page Factory Test", groups = "Page Factory")
    public void validateAlert(){
        driver.get(FORMS_URL);

        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);

        practiceFormPage.clickAlert();
        practiceFormPage.dismissAlert();

        Assert.assertTrue(practiceFormPage.alertButtonIsVisible());

    }
    @AfterTest(alwaysRun = true)
    public void finish(){
        tearDown();
    }
}
```
`PracticeFormPage practiceFormPage = new PracticeFormPage(driver);` is what calls the constructor that builds the page model.

And by using the PageFactory the test and models can be created using fewer lines.

Just to add something extra we will create a new class `RetryInit.java` to create a custom retry to use in the test, this custom setup will be used during the test execution
to retry the failed test until there are not retries or the test pass.

```java
public class RetryInit implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetry = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetry){
            retryCount++;
            System.out.println("Retrying Test method: " + result.getName() + " For " + retryCount + " times");
            return true;
        }
        return false;
    }
}
```

And then add it to the test
```java
public class AppAdvanced{
    // ..previous code
     @Test(description = "Page Factory Test", groups = "Page Factory", retryAnalyzer = RetryInit.class)
        public void validateDragAndDrop(){
            driver.get(FORMS_URL);

    }
}
```

#References

### WebDriver
To understand better all the webdriver be sure to check the API [here](https://static.javadoc.io/org.seleniumhq.selenium/selenium-api/2.50.1/org/openqa/selenium/WebDriver.html) and [here](https://seleniumhq.github.io/selenium/docs/api/javascript/index.html)

#Javier Reyes