package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {
	WebDriver driver;

	@FindBy(css = "[placeholder='Select Country']")
	private WebElement enterCountry;
	private By checkCountryResults = By.cssSelector(".ta-results");
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	private WebElement selectCountry;

	@FindBy(css = ".action__submit")
	private WebElement placeOrder;

	public CheckoutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterPaymentDetails() {
		Actions a = new Actions(driver);
		a.sendKeys(enterCountry, "India").build().perform();
		waitForElementToAppear(checkCountryResults);

		selectCountry.click();
	}

	public OrderConfirmationPage placeOrder() {
		placeOrder.click();
		OrderConfirmationPage orderconfirmationpage = new OrderConfirmationPage(driver);

		return orderconfirmationpage;
	}
}
