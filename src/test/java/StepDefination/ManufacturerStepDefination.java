package StepDefination;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.LoginPage;
import PageObjects.Manufacturers;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ManufacturerStepDefination {

	public WebDriver driver;
	public LoginPage loginPage;
	public static Logger logger;
	public Manufacturers manufacturers;

	@Before("@Smoke1")
	public void setup() {
		logger = Logger.getLogger("Performance");
		PropertyConfigurator.configure("log4j.properties");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		manufacturers = new Manufacturers(driver);
		loginPage = new LoginPage(driver);
	}

	@Given("User launch URL {string}")
	public void user_launch_url(String string) {
		driver.get(string);
		logger.info("Browser is launched");
	}

	@And("User login using email as {string} and password as {string}")
	public void user_login_using_email_as_and_password_as(String string, String string2) {
		loginPage.username(string);
		loginPage.password(string2);
	}

	@And("Click Login button")
	public void click_on_login_button() {
		loginPage.loginbtn();
	}
	
	@And("Maximize the window")
	public void maximize_the_window() {
	   driver.manage().window().maximize();
	    
	}

	@When("user navigates to Manufacturer page")
	public void user_navigates_to_manufacturer_page() {
		manufacturers.clickOnCatalogue();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		manufacturers.clickOnManufacturer();

	}

	@And("user searches for {string}")
	public void user_searches_for(String string) {

		manufacturers.enterManufactureName(string);
		manufacturers.clickOnSearch();
	}



	@Then("user should verify {string} in the table")
	public void user_should_verify_in_the_table(String string) {
		manufacturers.validateManufacturerName(string);
		
	}


}