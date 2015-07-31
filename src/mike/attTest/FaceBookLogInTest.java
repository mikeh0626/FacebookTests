package mike.attTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import POM.IncorrectLoginPage;
import POM.MainPage;
import POM.UserHomePage;

public class FaceBookLogInTest {
	
	WebDriver driver;
	MainPage objlogin;
	UserHomePage userHome;
	IncorrectLoginPage unLogIn;
	
	@BeforeTest
	public void setup(){
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.get("http://facebook.com");
	}
	
	/**
	 * This is the test case to test login in http://facebook.com
	 * verify title is facebook
	 * Login to application
	 * verify homepage using dashboard
	 */
	
	@Test
	public void successfulLoginInTest(){
		objlogin = new MainPage(driver);
		String loginPageTitle = objlogin.getLoginTitle();
		System.out.println(loginPageTitle);
		userHome=objlogin.LoginToFaceBook("", "");
		userHome.verifyUserHomePage();
		userHome.LogOut();
	}

	
	/**
	 * Test  case to test an unsuccessful login attempt
	 * 
	 */
	@Test
	public void unsuccessfulLoginTest()
	{
		unLogIn =objlogin.UnsuccessfulLogin("jj", "mo");
		unLogIn.verifyOnInccorectLoginPage();
	}
	
	
}
