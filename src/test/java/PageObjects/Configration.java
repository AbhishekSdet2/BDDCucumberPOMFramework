package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.datatable.DataTable;

public class Configration {
	
	public WebDriver driver;
	@FindBy(xpath = "(//ul[contains(@class,'flex-column nav-legacy')]//li[@class='nav-item has-treeview'])[7]")
	WebElement configration;
	@FindBy(xpath = "//p[contains(text(),'Email')]//parent::a//parent::li")
	WebElement emailAccount;
   @FindBy(xpath = "//a[@class='btn btn-primary']//i")
	WebElement addNew;
   @FindBy(xpath = "//input[@id='Email']")
    WebElement email;
   @FindBy(id="DisplayName")
   WebElement emailDisplayName;
   @FindBy(id="Host")
   WebElement host;
   @FindBy(id="Username")
   WebElement username;
   @FindBy(id="Password")
   WebElement password;
   @FindBy(xpath = "//button[@name='save']")
   WebElement saveButton;
	public Configration(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToConfigration() {
		configration.click();
	}
	
   public void navigateToEmail() {
	   emailAccount.click();
   }
   
   public void AddNewButton() {
	   addNew.click();
   }
   
   public void enterValuesInTextField(DataTable dataTable) {
	   List<List<String>> value=dataTable.asLists();
	   for (List<String> list : value) {
		email.sendKeys(list.get(0));
		emailDisplayName.sendKeys(list.get(1));
		host.sendKeys(list.get(2));
		username.sendKeys(list.get(4));
		password.sendKeys(list.get(5));
		saveButton.click();
		addNew.click();
	}
   }
   
   
}
