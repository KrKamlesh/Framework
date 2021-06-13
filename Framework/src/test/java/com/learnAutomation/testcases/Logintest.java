package com.learnAutomation.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.learnAutomation.utility.Browserfactory;

public class Logintest {

	WebDriver driver;
	@Test
	public void logintoApp()
	{
		driver=Browserfactory.startApplication(driver, "chrome", "https://freecrm.com/");
	  
		
	   System.out.println(driver.getTitle());
}
}