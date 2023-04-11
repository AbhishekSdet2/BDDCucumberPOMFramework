package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
public WebDriver driver;
	
	@FindBy(xpath = "//input[@name='Email']")
	WebElement email;
	@FindBy(xpath = "//input[@name='Password']")
	WebElement pass;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement login;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String username(String username) {
		email.clear();
		email.sendKeys(username);
		return username;
	}
	
	public String password(String password) {
		pass.clear();
		pass.sendKeys(password);
		return password;
	}
	
	public void loginbtn() {
		login.click();
	}
   
	public boolean verifyErrorMessage() {
		String expectedmessage="Login was unsuccessful. Please correct the errors and try again.";
		String actualMessage=driver.findElement(By.xpath("//div[contains(text(),'Login was unsuccessful. Please correct the errors and try again.')]")).getText();
		if(actualMessage.equals(expectedmessage)) {
			return true;
		}
		else {
			return false;
		}
	}

}
