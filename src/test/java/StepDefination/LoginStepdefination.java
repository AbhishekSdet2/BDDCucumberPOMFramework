package StepDefination;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepdefination {

	public LoginPage loginPage;

	public static Logger logger;
	public WebDriver driver;

	@Before
	public void setup() {
		logger = Logger.getLogger("Performance");
		PropertyConfigurator.configure("log4j.properties");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Given("User launch Chrome successfully")
	public void user_launch_chromebrowser() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		loginPage = new LoginPage(driver);
		logger.info("Driver is initialised");

	}

	@And("User opens URL {string}")
	public void user_opens_URL(String url) {

		driver.get(url);
		logger.info("Browser is launched");
	}

	@And("Click on Login")
	public void user_click_login() {
		loginPage.loginbtn();
	}

	@When("User enter email as {string} and password as {string}")
	public void user_enter_emailID(String email, String password) {
		loginPage.username(email);
		loginPage.password(password);
	}

	@Then("Page title should be {string}")
	public boolean validate_page_title(String title) {
		if (driver.getTitle().equals(title)) {
			return true;
		} else {
			return false;
		}
	}

	@And("Close browser")
	public void closebrowser() {
		driver.quit();
	}
	
	@Then("Error message should be displayed as {string}")
	public void error_message_should_be_displayed_as(String string) {
	    
         loginPage.verifyErrorMessage();	    	
	    }
	}


