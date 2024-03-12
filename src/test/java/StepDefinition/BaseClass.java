package StepDefinition;

import PageObjects.AddNewCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import Utility.Utils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

public class BaseClass {
    WebDriver driver;

    LoginPage loginpage;

    AddNewCustomerPage addNew;

    SearchCustomerPage searchPage;

    public static Logger log;
    public String genarateEmailId()

    {
        return(RandomStringUtils.randomAlphabetic(5));
    }
}
