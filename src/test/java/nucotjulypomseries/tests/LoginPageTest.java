package nucotjulypomseries.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import nucotjulypomseries.applicationconstant.ApplicationConstant;

public class LoginPageTest extends BaseTest {
	
	
	
	@Test
	public void getLoginPageCurrentUrlTest()
	{
				
		String actualUrl=loginpage.getLoginPageUrl();
		//validation part
		Assert.assertEquals(actualUrl, ApplicationConstant.LOGINPAGE_CURRENTURL_VALUE);
	}
	
	@Test
	public void getLoginPageTitleTest()
	{
		String actualTitle=loginpage.getLoginPageTitle();
		//validation part
		Assert.assertEquals(actualTitle, ApplicationConstant.LOGINPAGE_TITLE_VALUE);
		
	}
	
	@Test
	public void doLoginTest()
	{
		String actualData=loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		String expectedData=ApplicationConstant.LOGINPAGE_SUCCESSFULL;
		Assert.assertEquals(actualData,expectedData);
		
	}
	

}
