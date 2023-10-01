package nucotjulypomseries.driversetup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class InitialSetUp {
	
	public WebDriver odriver;
	public Properties prop;
	public OptionsManager optionsManager;
	public static String highlight;
	
	public WebDriver initDriver(Properties prop)
	{
		
		
		 highlight = prop.getProperty("highlight").trim();
		 optionsManager=new OptionsManager(prop);
		
		String browserName= prop.getProperty("browser").toLowerCase().trim();
		
		System.out.println("Browser name is : "+browserName);
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			odriver=new ChromeDriver(optionsManager.getChromeOptions());
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			odriver=new FirefoxDriver(optionsManager.getFirefoxOptions());
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			odriver=new EdgeDriver(optionsManager.getEdgeOptions());
		}
		else if(browserName.equalsIgnoreCase("safari"))
		{
			odriver=new SafariDriver();
		}
		else 
		{
			System.out.println("Please pass the vaild browser---"+browserName );
		}
		
		odriver.manage().deleteAllCookies();
		odriver.manage().window().maximize();
		odriver.get(prop.getProperty("url"));
		return odriver;
		
	}
	
	/*
	 * 
	 * 
	 * Reading the data from the config
	 * 
	 * 
	 */
	
	
	
	
	
	public Properties initProp()
	{
		prop=new Properties();
		
		try {
			FileInputStream ip=new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
		
	}
	
}
