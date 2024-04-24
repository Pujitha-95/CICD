package frameworkdesign.Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



import TestComponents.BaseTest;
import TestComponents.Retry;
import pageobjects.CartPage;
import pageobjects.ProductCatologue;

public class ErrorValidationsTest extends BaseTest{
	

		@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
		public void loginErrorValidation() throws IOException ,InterruptedException{
			

			ProductCatologue productcatologue = landingpage.loginApplication("test123@gft.com", "bhjhjh@95");
	
			Assert.assertEquals("Incrrect email or password." ,landingpage.getErrorMessage());
			
			
		}
				@Test
				public void submitOrder() throws IOException ,InterruptedException{
					String itemsNeedsToBeAdded = "ADIDAS ORIGINAL";

					ProductCatologue productcatologue = landingpage.loginApplication("test123@gft.com", "Pujitha@95");
					List<WebElement> products = productcatologue.getProductsList();
					productcatologue.addProductToCart(itemsNeedsToBeAdded);
					CartPage cartpage = productcatologue.goToCartPage();
					Boolean match = cartpage.verifyItemsAdded("ADIDAS ORIGINAL12");
					Assert.assertFalse(match);
}
	}
