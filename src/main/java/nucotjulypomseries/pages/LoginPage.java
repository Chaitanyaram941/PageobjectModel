package nucotjulypomseries.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import nucotjunepomseries.util.ElementUtil;

public class LoginPage {
	
	private WebDriver odriver;
	private ElementUtil eleUtil;
	
	//1.private By locators
	
		By userName=By.xpath("//input[@name='username']");
		By passWord=By.xpath("//input[@name='password']");
		By loginBtn=By.xpath("//button[@type='submit']");
		By successLogin=By.xpath("//h6[text()='Dashboard']");
	
	
	//2.constructor
	
	public	LoginPage(WebDriver odriver)
	{
		this.odriver=odriver;
		eleUtil=new ElementUtil(odriver);
	
	}
		
	//3.Actions/methods
	
	public String getLoginPageUrl()
	{
		String url=odriver.getCurrentUrl();
		System.out.println("Login page ur is"+ url);
		return url;
	}
	
	public String getLoginPageTitle()
	{
		String title=odriver.getTitle();
		System.out.println("Login page ur is"+ title);
		return title;
	}
	
	
	public String doLogin(String un,String pw)
	{
		
		odriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		odriver.findElement(userName).sendKeys(un);
//		odriver.findElement(passWord).sendKeys(pw);
//		odriver.findElement(loginBtn).click();
//		
		eleUtil.waitForElementVisible(userName, 20).isDisplayed();
		eleUtil.doSendKeys(userName, un);
		eleUtil.doSendKeys(passWord, pw);
		eleUtil.doClick(loginBtn);
		String text=odriver.findElement(successLogin).getText();
		System.out.println(text);
		return text;
		

	}
	
	
	
	
	
	
	
	
	
	
	

}
