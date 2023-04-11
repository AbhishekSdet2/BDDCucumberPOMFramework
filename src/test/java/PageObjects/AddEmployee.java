package PageObjects;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ExcelDataReader;
import Utils.UploadingPhotoFromFileLocation;

public class AddEmployee {
	
	

	WebDriver driver;
	// Pim link text web element find through id
	@FindBy(id = "menu_pim_viewPimModule")
	@CacheLookup
	WebElement pim;
	// add employee link text web element find through id
	@FindBy(id = "menu_pim_addEmployee")
	WebElement addemployee;
	@FindBy(id = "firstName")
	@CacheLookup
	WebElement firstname;
	@FindBy(id = "lastName")
	@CacheLookup
	WebElement lastname;
	@FindBy(id = "employeeId")
	@CacheLookup
	WebElement employeeId;
	@FindBy(id = "photofile")
	@CacheLookup
	WebElement photo;
	@FindBy(id = "chkLogin")
	@CacheLookup
	WebElement chklogin;
	@FindBy(id = "user_name")
	@CacheLookup
	WebElement username;
	@FindBy(id = "user_password")
	@CacheLookup
	WebElement password;
	@FindBy(id = "re_password")
	@CacheLookup
	WebElement confirmpassword;
	@FindBy(id = "status")
	@CacheLookup
	WebElement status;
	@FindBy(id = "btnSave")
	@CacheLookup
	WebElement save;
	@FindBy(xpath = "//input[@id='photofile']")
	WebElement photograph;

	// constructor to assign driver
	public AddEmployee(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to navigate to add employee option
	
	public void clickOnPimAndAddEmployee() {
		Actions actions=new Actions(driver);
		actions.moveToElement(pim).perform();
		actions.moveToElement(addemployee).perform();
		actions.click(addemployee).perform();
	}
	
	public void addEmployeeDetails() throws IOException, InterruptedException {
		
		ArrayList<String> a=new ArrayList<>(ExcelDataReader.getRowsData("OrangeHRM.xlsx", "Sheet1",2));
		firstname.sendKeys(a.get(1));
		lastname.sendKeys(a.get(2));
		employeeId.sendKeys(a.get(3));
		photograph.sendKeys("C:\\Users\\ABHISKUM\\Downloads\\Error while connecting jumbox.jpeg");
		//photograph.click();
		save.click();
		
		
		
		
	}
}
