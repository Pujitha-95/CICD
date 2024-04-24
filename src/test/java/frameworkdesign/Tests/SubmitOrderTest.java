package frameworkdesign.Tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import TestComponents.BaseTest;
import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.OrderConfirmationPage;
import pageobjects.OrderPage;
import pageobjects.ProductCatologue;

public class SubmitOrderTest extends BaseTest {
	String itemsNeedsToBeAdded = "ADIDAS ORIGINAL";
	@Test(dataProvider="getData",groups="Purchase")
	public void submitOrder(HashMap<String, String> input) throws IOException ,InterruptedException{
		

		ProductCatologue productcatologue = landingpage.loginApplication(input.get("email"),input.get("Pwd"));
		List<WebElement> products = productcatologue.getProductsList();
		productcatologue.addProductToCart(input.get("productName"));
		CartPage cartpage = productcatologue.goToCartPage();
		Boolean match = cartpage.verifyItemsAdded(input.get("productName"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartpage.goToCheckout();
		checkoutPage.enterPaymentDetails();
		OrderConfirmationPage orderconfirmationpage = checkoutPage.placeOrder();
		String ConfirmMessage = orderconfirmationpage.getOrderSuccessMessage();
		Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void orderHistoryTest() throws IOException, InterruptedException
	{
		ProductCatologue productcatologue = landingpage.loginApplication("test123@gft.com", "Pujitha@95");
		
		OrderPage orderpage = productcatologue.goToOrderPage();
		
		
		Assert.assertTrue(orderpage.verifyOrderDisplay(itemsNeedsToBeAdded));
		
	}
	
	
	
	//it basically drives the data
	@DataProvider 
	public Object[][] getData() throws IOException
	{
		
		//return new Object[][] {{"test123@gft.com","Pujitha@95","ADIDAS ORIGINAL"},{"shetty@gmail.com","Iamking@000","ZARA COAT 3"}};
		

		
		List<HashMap<String,String>> data= getJsonToMap(System.getProperty("user.dir")+"//src//test//java//data//PurchaseOrder.json") ;
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
		
		
	//	HashMap<String,String> map= new HashMap<String, String>();
//		map.put("email", "test123@gft.com");
//		map.put("Pwd","Pujitha@95");
//		map.put("productName","ADIDAS ORIGINAL");
//		HashMap<String,String> map1= new HashMap<String, String>();
//		
//		map1.put("email", "shetty@gmail.com");
//		map1.put("Pwd","Iamking@000");
//		map1.put("productName","ZARA COAT 3");

		
	//	return new Object[][] {{map},{map1}};
		
	}

}
