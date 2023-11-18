package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class LoginPageTest extends TestBase{

	public LoginPage page;
	
	@BeforeMethod
	public void setup() throws Exception{
		
		initialization();
		page = new LoginPage();
	}
	
	@Test
	public void verifyValidlogintest() throws Exception{
		page.verifyValidlogin();
		
		// Verify successful login
		WebElement welcomMessage = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		Assert.assertEquals(welcomMessage.getText(), "Hello, Gaurav");
	}
	
	@Test
	public void verifyInvalidlogintest() throws Exception{
		page.verifyInvalidlogin();
		
		// Verify successful login
		WebElement welcomMessage = driver.findElement(By.xpath("//h4[text()='There was a problem']"));
		Assert.assertEquals(welcomMessage.getText(), "Invalid user");
	}
	
	@AfterMethod
	public void exit() {
		driver.quit();
	}
}
