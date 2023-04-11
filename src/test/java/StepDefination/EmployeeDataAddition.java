package StepDefination;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.AddEmployee;
import PageObjects.Configration;
import PageObjects.LoginPage;
import PageObjects.LoginPageOrangeHRM;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EmployeeDataAddition {
	
	public AddEmployee addemployee;
    public LoginPageOrangeHRM loginPageOrangeHRM;
	public static Logger logger;
	public WebDriver driver;
	public Configration configration;
	
	@Before("@smoke6")
	public void setup() {
		logger = Logger.getLogger("Performance");
		PropertyConfigurator.configure("log4j.properties");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	    addemployee=new AddEmployee(driver);
	    loginPageOrangeHRM=new LoginPageOrangeHRM(driver);
		configration=new Configration(driver);
	}
	
	
	@Given("User has successfully launched chromes browser")
	public void user_has_successfully_launched_chromes_browser() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   
	}

	@Given("URL is {string} is opened")
	public void url_is_is_opened(String string) {
		 driver.navigate().to(string);
	}

	@Given("Entered username in as {string} password as {string}")
	public void entered_username_in_as_password_as(String string, String string2) {
	   loginPageOrangeHRM.username(string);
	   loginPageOrangeHRM.password(string2);
	   loginPageOrangeHRM.loginbtn();
	}

	@When("user click on PIM tab")
	public void user_click_on_pim_tab() {
	    addemployee.clickOnPimAndAddEmployee();
	}

	@When("user add multiple employee and save")
	public void user_add_multiple_employee_and_save() throws IOException, InterruptedException {
	   addemployee.addEmployeeDetails();
	   
	   
	}

	@Then("user should see all the employees added inside Employee list")
	public void user_should_see_all_the_employees_added_inside_employee_list() {
	    System.out.println("hbashdsd");
	}	

}
