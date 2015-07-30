package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class IncorrectLoginPage {
	
	private WebDriver driver;
	private By ErrorMessage = By.partialLinkText("Incorrect");
	
	public IncorrectLoginPage(WebDriver drive)
	{
		this.driver=drive;
		System.out.println("in const ilp");
	}

	public void verifyOnInccorectLoginPage()
	{
		System.out.println(driver.findElement(ErrorMessage).toString());
	}
}
