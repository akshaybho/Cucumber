package StepDefinition;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


import Utility.Utils;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import PageObjects.AddNewCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Logger;
public class StepDef extends BaseClass {
	//conditional hook
	@Before
	public void setUp1()
	{

		log = LogManager.getLogger("StepDef");
		System.out.println("SetUp Method Executed");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		log.info("setUp1 executed....");
	}
//conditional hook
	/*@Before("@Sanity")
	public void setUp2()
	{
		System.out.println("SetUp Method Executed");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}*/

	//@Before(order=1) - if we give order for @Before it will execute lower order first
	//@After(order=1) - if we give order for @After it will execute higher order first
	
	
	@Given("User luanch the chrome browser")
	public void user_luanch_the_chrome_browser() {
		


		loginpage = new LoginPage(driver);
		 addNew = new AddNewCustomerPage(driver);
		 searchPage = new SearchCustomerPage(driver);
		 log.info("Browser is launch....");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {

		driver.get(url);
		log.info("Url is Open....");
	}

	@And("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailAdd, String password) {
		loginpage.enterEmail(emailAdd);
		loginpage.enterPaswword(password);
		log.info("User enters email and password....");
	}

	@And("Click on login")
	public void click_on_login() {
		loginpage.clickOnLogin();
        log.info("User clicks on login button.....");
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) throws InterruptedException {
		String actualTitle = driver.getTitle();

		if(actualTitle.equals(expectedTitle)) {
			log.warn(":Test Passed :Login feature :Page title matched....");
			Assert.assertTrue(true);
		}
		else {
			log.warn(":Test Failed :Login feature :Page title not matched....");
			Assert.assertTrue(false);
		}
		Thread.sleep(5000);

	}


	@When("User click on logout link")
	public void user_click_on_logout_link() {

		loginpage.clickOnLogout();
		log.info("User clicks on logout button....");
	}

	/*@And("Close browser")
	public void close_browser() {
		driver.close();
		driver.quit();
	}*/
	
	@Then("User can view dashboard")
	public void user_can_view_dashboard() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";
		if(actualTitle.equals(expectedTitle)){
			log.warn(":Test Passed :Dashboard :Page title matched....");
			Assert.assertTrue(true);
			System.out.println("===PASS===");
		}
		else{
			log.warn(":Test Failed :Dashboard :Page title matched....");
			Assert.assertTrue(false);
		}
	}

	@When("User clicks on customer menu")
	public void user_clicks_on_customer_menu() {
		log.info("User clicks on customer menu....");
		addNew.clickOnCustomerMenu();
	    
	}

	@When("Click on customers menu item")
	public void click_on_customers_menu_item() {
	    log.info("User clicks on customer menu item....");
		addNew.clickOnCustomer();
	}

	@When("Click on add new button")
	public void click_on_add_new_button() {
		log.info("User clicks on add new button....");
	   addNew.addNewButton();
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle = addNew.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";
		if(actualTitle.equals(expectedTitle)){
			log.warn(":Test Passed....");
			Assert.assertTrue(true);
		}
		else{
			log.warn(":Test Failed....");
			Assert.assertTrue(false);
		}

	}

	@When("User enters customer info")
	public void user_enters_customer_info() throws InterruptedException {
		log.info("User enters a information....");
		addNew.enterEmail(genarateEmailId()+"@gmail.com");
		Thread.sleep(2000);
		addNew.enterPassword();
		Thread.sleep(2000);
		addNew.enterFirstName();
		Thread.sleep(2000);
		addNew.enterLastName();
		Thread.sleep(2000);
		addNew.selectGender();
		Thread.sleep(2000);
		addNew.enterDOB();
		Thread.sleep(2000);
		addNew.enterCompanyName();
		Thread.sleep(2000);
		addNew.checkTaxBox();
		Thread.sleep(2000);
		addNew.selectNewsLetter();
		Thread.sleep(2000);
		addNew.selectVendor();
		Thread.sleep(2000);
	}

	@When("Click on save button")
	public void click_on_save_button() {
	    log.info("User clicks on save button....");
		addNew.saveInfo();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMessage) {
		String bodyTag = driver.findElement(By.tagName("Body")).getText();
		if(bodyTag.contains(expectedConfirmationMessage)){
			log.warn("Test Passed....");
			Assert.assertTrue(true);
		}
		else{
			log.warn(":Test Failed....");
			Assert.assertTrue(false);
		}
	}
	
	///////Search Customer by email//////
	
	@When("Enter customer Email")
	public void enter_customer_email() 
	{
		log.info("User enter email address....");
		searchPage.enterEmailAdd("victoria_victoria@nopCommerce.com");
	}

	@Then("Click on search button")
	public void click_on_search_button() 
	{
	    log.info("User clicks on search button....");
		searchPage.clickOnSearchButton();
	}

	@And("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() 
	{
		String expectedEmail = "victoria_victoria@nopCommerce.com";
	    if(searchPage.searchCustomerByEmail(expectedEmail)==true)
	    {
			log.warn(":Test Passed....");
	    	Assert.assertTrue(true);
	    }
	    else
	    {
			log.warn(":Test Failed....");
	    	Assert.assertTrue(false);
	    }
	}
    @After
	public void tearDown(Scenario sc) throws IOException {
		System.out.println("Tear Down Method Executed");
		if(sc.isFailed()==true)
		{
			log.info("tearDown executed....");
			SimpleDateFormat dateFormat = new SimpleDateFormat("HHmmss");
			String currentTime = dateFormat.format(new Date());
			String path = "D:\\ak\\CucumberFramework\\screenshots\\"+currentTime+".png";
			TakesScreenshot srcShot = ((TakesScreenshot) driver);
			File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File(path);
			FileUtils.copyFile(srcFile, destFile);
		}
		driver.quit();
	}
/*@AfterStep
public void afterSetpMethod()
{
	System.out.println("This is after step .......................");
}

@BeforeStep
public void beforeStepMethod()
{
	System.out.println("This is before step .......................");
}
*/
	
}
