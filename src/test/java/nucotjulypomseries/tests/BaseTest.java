package nucotjulypomseries.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import nucotjulypomseries.driversetup.InitialSetUp;
import nucotjulypomseries.pages.LoginPage;

public class BaseTest {
	
	public LoginPage loginpage;
	InitialSetUp is;
	WebDriver odriver;
	Properties prop;
	
	@BeforeTest
	void loginSetUp()
	{
		is=new InitialSetUp();
		prop=is.initProp();
		odriver=is.initDriver(prop);
		loginpage=new LoginPage(odriver);
		
	}
	
	
	
	@AfterTest
	void closeApp()
	{
		odriver.quit();
		
		
		
	}
	

}
