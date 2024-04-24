package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	WebDriver driver;

	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartProducts;

	@FindBy(css = ".totalRow button")
	private WebElement checkout;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// List<WebElement> itemsAdded=driver.findElements(By.cssSelector(".cartSection
	// h3"));

	public boolean verifyItemsAdded(String productName) {
		Boolean match = cartProducts.stream().anyMatch(item -> item.getText().equalsIgnoreCase(productName));
		return match;
	}

	public CheckoutPage goToCheckout() {
		checkout.click();
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		return checkoutpage;
	}

}
