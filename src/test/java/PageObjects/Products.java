package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Products {

	public WebDriver driver;
	@FindBy(xpath = "//select[@id='SearchWarehouseId']")
	WebElement warehouse;
    @FindBy(xpath = "//select[@id='SearchProductTypeId']")
	WebElement productType;
    @FindBy(xpath = "//select[@id='SearchPublishedId']")
    WebElement published;
	public Products(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void verifyDropdownValue(String warehousevalue) {
		Select select=new Select(warehouse);
		List<WebElement> li=select.getOptions();
		for (WebElement m : li) {
			if(m.getText().contains(warehousevalue)) {
				m.click();
			}
		}
	}
}
