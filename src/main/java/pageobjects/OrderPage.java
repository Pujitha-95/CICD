package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents {
	WebDriver driver;

	@FindBy(xpath="//tr[@class='ng-star-inserted']/td[2]")
	private List<WebElement> productNames;

	public OrderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyOrderDisplay(String productName)
	{
		
		Boolean match = productNames.stream().anyMatch(item -> item.getText().equalsIgnoreCase(productName));
		return match;
	
		
	}
}
