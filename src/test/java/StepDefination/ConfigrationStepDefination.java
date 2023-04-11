package StepDefination;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.Configration;
import PageObjects.LoginPage;
import Utils.FailedScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfigrationStepDefination {
	
	public LoginPage loginPage;

	public static Logger logger;
	public WebDriver driver;
	public Configration configration;
	
	@Before("@smoke5")
	public void setup() {
		logger = Logger.getLogger("Performance");
		PropertyConfigurator.configure("log4j.properties");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		configration=new Configration(driver);
	}
	
	
	@Given("User has successfully launched chromes")
	public void user_has_successfully_launched_chromes() {
		
		loginPage = new LoginPage(driver);
		logger.info("Driver is initialised");
	}

	@Given("URL {string} is opened")
	public void url_is_opened(String string) {
		driver.get(string);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		logger.info("Browser is launched");
	}
	
	@And("Click on Login button")
	public void user_click_login() {
		loginPage.loginbtn();
	}
    
	@When("enter email value as {string} and password as {string}")
	public void user_enter_emailID(String email, String password) {
		loginPage.username(email);
		loginPage.password(password);
	}

	
	@When("Navigate to Email accounts inside configration tab")
	public void navigate_to_email_accounts_inside_configration_tab() {
		//configration.navigateToConfigration();
	}

	@When("Click on Add new button")
	public void click_on_add_new_button() {
	    configration.navigateToEmail();
	    configration.AddNewButton();
	}

	@When("enter email details")
	public void enter_email_details(DataTable dataTable) {
	   configration.enterValuesInTextField(dataTable);
	}

	@When("Click on save button")
	public void click_on_save_button() {
	    System.out.println("clicked on save");
	}
	
	@After
	public void teardown(Scenario scenario) {
	Status s = scenario.getStatus();
	System.out.println(s);
	if(scenario.getStatus().toString().equals("FAILED")) {
	FailedScenario.capture(driver, scenario.getName());
	logger.error("Scenario - "+ scenario.getName() + " failed. Screenshot Captured at : target/screenshot/*");
	}}
	
	
	
	


}
