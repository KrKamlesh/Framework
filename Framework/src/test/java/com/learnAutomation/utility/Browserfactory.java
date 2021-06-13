package com.learnAutomation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browserfactory {
	
	public static WebDriver startApplication(WebDriver driver, String BrowserName,String appUrl )
	{
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe" );
			driver=new ChromeDriver();
			
			
	}
		
		else if(BrowserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		else 
		{
			System.out.println("Does not support the browser");
		}
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public static void quitebrowser(WebDriver driver)
	{
		driver.quit();
	}

}
