package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjects.CartPage;
import pageobjects.OrderPage;

public class AbstractComponents {

	WebDriver driver;

	@FindBy(css = "[routerlink*='cart']")
	WebElement cart;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orders;


	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForElementToDisappear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element));
		;
	}
	
	public void waitForWebElementToAppear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}

	public CartPage goToCartPage() {
		cart.click();

		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrderPage() {
		orders.click();

		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
	
	
}
