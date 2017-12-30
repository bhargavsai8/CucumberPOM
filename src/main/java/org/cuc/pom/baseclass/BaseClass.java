package org.cuc.pom.baseclass;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.cuc.pom.utility.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;



public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver edriver;
	//public static WebEventListener weblistener;
	
	
	public BaseClass()
	{
	
		
		try
		{
			prop = new Properties();
			FileInputStream inp = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/org/cuc/pom/config/config.properties");
			prop.load(inp);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void init()
	{
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",  System.getProperty("user.dir")+"\\chromedriver.exe");

			/* Headless Chrome
			ChromeOptions options = new ChromeOptions();
			options.addArguments("window-size=1400,800");
			options.addArguments("headless");
			driver = new ChromeDriver(options); */
			
		/*	ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1400,800");*/
			
			driver=new ChromeDriver();
		}
		
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageloadTimeout,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicityTimeout,TimeUnit.SECONDS);
		
	
	}

}
