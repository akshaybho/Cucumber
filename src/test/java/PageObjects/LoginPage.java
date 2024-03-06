package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(css = "button.button-1.login-button")
	WebElement LoginBtn;
	
	@FindBy(linkText = "Logout")
	WebElement LogoutBtn;
	
	public void enterEmail(String emailAdd) {
		email.clear();
		email.sendKeys(emailAdd);
	}
	
	public void enterPaswword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickOnLogin() {

		LoginBtn.click();
	}
	
	public void clickOnLogout() {

		LogoutBtn.click();
	}

}
