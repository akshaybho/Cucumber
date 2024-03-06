package StepDefinition;

import java.util.concurrent.TimeUnit;

import Utility.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.AddNewCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef {
	
	WebDriver driver;
	
	LoginPage loginpage;
	
	AddNewCustomerPage addNew;
	
	SearchCustomerPage searchPage;

	public Utils u = new Utils();
	
	public String mail = u.generateEmail(); 
	
	public String textMail = mail;
	
	
	@Given("User luanch the chrome browser")
	public void user_luanch_the_chrome_browser() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		loginpage = new LoginPage(driver);
		 addNew = new AddNewCustomerPage(driver);
		 searchPage = new SearchCustomerPage(driver);
		 
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	}

	@And("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailAdd, String password) {
		loginpage.enterEmail(emailAdd);
		loginpage.enterPaswword(password);
	}

	@And("Click on login")
	public void click_on_login() {
		loginpage.clickOnLogin();

	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle = driver.getTitle();

		if(actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}


	@When("User click on logout link")
	public void user_click_on_logout_link() {

		loginpage.clickOnLogout();
	}

	@And("Close browser")
	public void close_browser() {
		driver.close();
		driver.quit();
	}
	
	@Then("User can view dashboard")
	public void user_can_view_dashboard() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";
		if(actualTitle.equals(expectedTitle)){
			Assert.assertTrue(true);
			System.out.println("===PASS===");
		}
		else{
			Assert.assertTrue(false);
		}
	}

	@When("User clicks on customer menu")
	public void user_clicks_on_customer_menu() {
		addNew.clickOnCustomerMenu();
	    
	}

	@When("Click on customers menu item")
	public void click_on_customers_menu_item() {
	    addNew.clickOnCustomer();
	}

	@When("Click on add new button")
	public void click_on_add_new_button() {
	   addNew.addNewButton();
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle = addNew.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";
		if(actualTitle.equals(expectedTitle)){
			Assert.assertTrue(true);
		}
		else{
			Assert.assertTrue(false);
		}

	}

	@When("User enters customer info")
	public void user_enters_customer_info() throws InterruptedException {
		
		addNew.enterEmail(mail);
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
	    addNew.saveInfo();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMessage) {
		String bodyTag = driver.findElement(By.tagName("Body")).getText();
		if(bodyTag.contains(expectedConfirmationMessage)){
			Assert.assertTrue(true);
		}
		else{
			Assert.assertTrue(false);
		}
	}
	
	///////Search Customer//////
	
	@When("Enter customer Email")
	public void enter_customer_email() 
	{
		searchPage.enterEmailAdd(textMail);
	}

	@Then("Click on search button")
	public void click_on_search_button() 
	{
	    searchPage.clickOnSearchButton();
	}

	@And("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() 
	{
	    String expected = textMail;
	    if(searchPage.searchCustomerByEmail(expected)==true)
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	}

	
}
