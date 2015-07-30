package POM;



import org.testng.Assert;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class MainPage {
	
		
	static Logger log;
	
	
	private final WebDriver driver;
	
	private String title = "Facebook - Log In or Sign Up";
	private By userName = By.name("email");
	private By passWord = By.name("pass");
	private By signInBtn = By.cssSelector("label#loginbutton");
	private By forgotPass = By.linkText("Forgot your password?");
	
	
	public MainPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void EnterUserName(String inputUN){
		driver.findElement(userName).sendKeys(inputUN);
	}
	
	public void EnterPass(String pass){
		driver.findElement(passWord).sendKeys(pass);
	}
	
	public void clickLogIn(){
		Assert.assertTrue(driver.findElement(signInBtn).isDisplayed(),"sign in button not visible");
		driver.findElement(signInBtn).click();
	}
	
	public String getLoginTitle(){
		Assert.assertEquals(driver.getTitle().toString(),title);
		return driver.getTitle().toString();
	}
	
	
	
	public UserHomePage LoginToFaceBook(String Un, String Pw){
		
		this.EnterUserName(Un);
		
		this.EnterPass(Pw);
		
		this.clickLogIn();
		
		return new UserHomePage(driver);
	}
	
	public IncorrectLoginPage UnsuccessfulLogin(String Un, String Pass)
	{
		this.EnterUserName(Un);
		this.EnterPass(Pass);
		this.clickLogIn();
		return new IncorrectLoginPage(driver);
	}
}
