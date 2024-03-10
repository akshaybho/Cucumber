package PageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utility.Utils;


public class AddNewCustomerPage {
	
	 public WebDriver ldriver;
	 Utils u;
	
	public AddNewCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a")
	WebElement CustomersMenu;
	
	@FindBy(xpath = "/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p")
	WebElement Customers;
	
	@FindBy(css = "a.btn.btn-primary")
	WebElement AddNew;
	
	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(id = "FirstName")
	WebElement firstName;
	
	@FindBy(id = "LastName")
	WebElement lastName;
	
	@FindBy(id = "Gender_Male")
	WebElement radioBtn;
	
	@FindBy(id = "DateOfBirth")
	WebElement DOB;
	
	@FindBy(id = "Company")
	WebElement companyName;
	
	@FindBy(id = "IsTaxExempt")
	WebElement checkTax;
	
	@FindBy(xpath = "//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div")
	WebElement newsLetter;

	@FindBy(xpath = "//li[text()='Your store name']")
	WebElement newsLetterOption;
	
	@FindBy(css = "select#VendorId")
	WebElement vendor;

	@FindBy(xpath = "//*[@id=\"VendorId\"]/option[2]")
	WebElement vendorOption;
	
	@FindBy(name = "save")
	WebElement saveBtn;

	public String getPageTitle(){

		return ldriver.getTitle();
	}

	public void clickOnCustomerMenu(){

		CustomersMenu.click();
	}

	public void clickOnCustomer(){

		Customers.click();
	}

	public void addNewButton()
	{

		AddNew.click();
	}

    public void enterEmail(String mailText)
    {
    	
		email.sendKeys(mailText);
		
	}

	public void enterPassword(){

		password.sendKeys("Akshay@11");
	}

	public void enterFirstName(){

		firstName.sendKeys("Akshay");
	}

	public void enterLastName(){

		lastName.sendKeys("Bhogale");
	}

	public void selectGender(){

		radioBtn.click();
	}

	public void enterDOB(){

		DOB.sendKeys("11/02/1995");
	}

	public void enterCompanyName(){

		companyName.sendKeys("abcd");
	}

	public void checkTaxBox(){

		checkTax.click();
	}

	public void selectNewsLetter() throws InterruptedException {
		newsLetter.click();
		Thread.sleep(2000);
		newsLetterOption.click();

	}

	public void selectVendor(){
		vendor.click();
		vendorOption.click();

	}

	public void saveInfo(){

		saveBtn.click();
	}

}
