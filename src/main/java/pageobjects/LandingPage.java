package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// PageFactory

	@FindBy(id = "userEmail")
	private WebElement uName;
	@FindBy(id = "userPassword")
	private WebElement pwd;

	@FindBy(id = "login")
	private WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	private WebElement errorToast;

	public ProductCatologue loginApplication(String email, String password) {
		uName.sendKeys(email);
		pwd.sendKeys(password);
		submit.click();
		ProductCatologue productcatologue = new ProductCatologue(driver);
		return productcatologue;
	}
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorToast);
		return errorToast.getText();
	}

	

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
}
