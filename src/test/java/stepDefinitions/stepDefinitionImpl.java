package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;

import TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.LandingPage;
import pageobjects.OrderConfirmationPage;
import pageobjects.ProductCatologue;

public class stepDefinitionImpl extends BaseTest {

	public LandingPage landingPage;
	ProductCatologue productcatologue;
	OrderConfirmationPage orderconfirmationpage;

	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		landingPage = launchApplication();
	}

	@Given("^logged in with username as (.+) and Password as (.+)$")
	public void login(String uName, String Pwd) {
		productcatologue = landingpage.loginApplication(uName, Pwd);
	}

	@When("^I add product (.+) to cart$")
	public void addingProductToCart(String productName) {
		List<WebElement> products = productcatologue.getProductsList();
		productcatologue.addProductToCart(productName);
	}

	@And("^Checkout (.+) and submit the order$")
	public void checkout_SubmitOrder(String productName) {
		CartPage cartpage = productcatologue.goToCartPage();
		Boolean match = cartpage.verifyItemsAdded(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartpage.goToCheckout();
		checkoutPage.enterPaymentDetails();
		orderconfirmationpage = checkoutPage.placeOrder();
	}

	@Then("{string} message is displayed on ConfirmationPage")
	public void message_displayed_conformation_Page(String string) {
		String ConfirmMessage = orderconfirmationpage.getOrderSuccessMessage();
		Assert.assertTrue(ConfirmMessage.equalsIgnoreCase(string));
		driver.close();
	}
	
	@Then("{string} message is displayed")
	public void loginError_is_dispalyed(String string) throws Throwable{

		Assert.assertEquals(string, landingpage.getErrorMessage());
		driver.close();
	}

}
