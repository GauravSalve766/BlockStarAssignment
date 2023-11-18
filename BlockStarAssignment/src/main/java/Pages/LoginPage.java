package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ConfigPropertiesRead;

public class LoginPage extends TestBase{

	@FindBy(xpath = "//span[text()='Hello, sign in']") private WebElement signinoption;
	@FindBy(xpath = "//input[@id='ap_email']") private WebElement usernametextbox;
	@FindBy(xpath = "//input[@id='continue']") private WebElement continuebutton;
	@FindBy(xpath = "//input[@id='ap_password']") private WebElement passwordtextbox;
	@FindBy(xpath = "//input[@id='signInSubmit']") private WebElement signinbutton;
	
	Actions a = new Actions(driver);
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyValidlogin() throws Exception{
		
		a.moveToElement(signinoption).click().build().perform();
		Thread.sleep(1000);
		
		// Enter valid email id
		usernametextbox.sendKeys(ConfigPropertiesRead.configPropFileRead("Username"));
		Thread.sleep(1000);
		
		// click on continue button
		continuebutton.click();
		Thread.sleep(3000);
		
		// Enter valid password
		passwordtextbox.sendKeys(ConfigPropertiesRead.configPropFileRead("Password"));
		Thread.sleep(1000);
		
		// click on signin button
		signinbutton.click();
				
	}
	
	public void verifyInvalidlogin() throws Exception{
		
		a.moveToElement(signinoption).click().build().perform();
		Thread.sleep(1000);
		
		// Enter valid email id
		usernametextbox.sendKeys("Invalid email");
		Thread.sleep(1000);
		
		// click on continue button
		continuebutton.click();
		Thread.sleep(3000);
		
		// Enter valid password
		passwordtextbox.sendKeys("invalid password");
		Thread.sleep(1000);
		
		// click on signin button
		signinbutton.click();
				
	}
}
