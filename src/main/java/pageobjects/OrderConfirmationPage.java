package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class OrderConfirmationPage extends AbstractComponents {
	WebDriver driver;

	@FindBy(className = "hero-primary")
	private WebElement successMessage;

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getOrderSuccessMessage() {
		String orderConfirmation = successMessage.getText();
		return orderConfirmation;
	}
	
	
}
