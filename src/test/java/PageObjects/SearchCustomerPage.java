package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
	
	WebDriver ldriver;
	
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "SearchEmail")
	WebElement emailAdd;
	
	@FindBy(id = "search-customers")
	WebElement searchBtn;
	
	@FindBy(xpath = "//table[@role='grid']")
	WebElement searchResult;
	
	@FindBy(xpath = "//table[@id ='customer-grid']//tbody/tr")
	List <WebElement>  tableRows;
	
	@FindBy(xpath = "//table[@id ='customer-grid']//tbody[1]/tr[1]/td")
	List <WebElement>  tableColoumns;

	
	//action method to enter email address
	public void enterEmailAdd(String email)
	{
		emailAdd.sendKeys(email);
	}
	
	//action method to perform click action on search button
	public void clickOnSearchButton() 
	{
		searchBtn.click();
	}

	public boolean searchCustomerByEmail(String email)
	{
		boolean found = false;

		//total no. of rows in a grid
		int ttlRows = tableRows.size();


		//total no. of columns
		//int ttlColumns = tableColumns.size();



			WebElement webElementEmail = ldriver.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr[1]/td[2]"));
			String actualEmailAdd = webElementEmail.getText();
			System.out.println(actualEmailAdd);

			if(actualEmailAdd.equals(email))
			{
				found=true;
			}




		return found;

	}




	
	
}
