package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserHomePage {

	private WebDriver driver;
	private By navDropDown = By.cssSelector("div#userNavigationLabel");
	private By logOut = By.linkText("Log Out");
	private By home = By.linkText("Home");
	
	public UserHomePage(WebDriver mpDriver)
	{
		this.driver = mpDriver;
	}
	
	
	public void verifyUserHomePage(){
		Assert.assertTrue(driver.findElement(home).isDisplayed(),"Home text not found");
	}
	
	
	public void LogOut()
	{
		driver.findElement(navDropDown).click();
		System.out.println("looking for logout");
		driver.findElement(logOut).click();
	}
}
