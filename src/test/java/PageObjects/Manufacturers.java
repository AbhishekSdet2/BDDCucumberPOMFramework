package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Manufacturers {
	
	public WebDriver driver;
	
	public Manufacturers(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//ul[contains(@class,'flex-column nav-legacy')]//li[@class='nav-item has-treeview'])[1]")
	WebElement catalogue;
	@FindBy(xpath = "//a[@href='/Admin/Manufacturer/List']")
	WebElement manufacturer;
	@FindBy(xpath = "//input[@id='SearchManufacturerName']")
	WebElement manufactureName;
	@FindBy(xpath = "//button[@id='search-manufacturers']")
	WebElement search;
	@FindBy(xpath = "(//table[@class='table table-bordered table-hover table-striped dataTable no-footer'])/tbody/tr[1]/td[2]")
	WebElement ManufacturerNameInTable;
	
	public void clickOnCatalogue() {
		catalogue.click();
		System.out.println("clicked on catalogue");
	}
    
	public void clickOnManufacturer() {
		manufacturer.click();
	}
	
	public void enterManufactureName(String ManufacturerName) {
		manufactureName.sendKeys(ManufacturerName);
	}
	
	public void clickOnSearch() {
		search.click();
	}
	
	public boolean validateManufacturerName(String ManufacturerName) {
		if(ManufacturerName.equals(ManufacturerNameInTable.getText())) {
			return true;
		}
		else {
		return false;
		}
	}
}
