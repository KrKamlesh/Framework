package com.learnAutomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnAutomation.pages.Base;
import com.learnAutomation.pages.LandingPage;
import com.learnAutomation.pages.RegistrationPage;
import com.learnAutomation.utility.Browserfactory;
import com.learnAutomation.utility.ExcelDataProvider;

public class RegistrationTest extends Base {

	@Test
	public void registeraUser() throws InterruptedException

	{
		logger=report.createTest("Registration to crm");
		
		LandingPage landingpage = PageFactory.initElements(driver, LandingPage.class);
		RegistrationPage Registerpage = PageFactory.initElements(driver, RegistrationPage.class);
		logger.info("Clicking on Sign buttono on landing page");
		Reporter.log("Clicking on Sign buttono on landing page");
		landingpage.clickonsignIn();
		
		Thread.sleep(30);
		logger.info("entereing email id and phone number on registration page");
		Reporter.log("entereing email id and phone number on registration page");
		Registerpage.enterPersonalDetails(excell.getStringdata("Login", 1, 0),excell.getStringdata("Login", 1, 0) );
		
		logger.info("Clickeing on terms and condition check box");
		Reporter.log("Clickeing on terms and condition check box");
		Registerpage.chekTermsCheckBox();
		
		
		/*Registerpage.checkCaptcha();
		System.out.println("Confirm the robot verification check box ");*/
	
		logger.info("Clickeing on Sign Up button on Registration page");
		Reporter.log("Clickeing on Sign Up button on Registration page");
		Registerpage.SignUp();
		
	}
	

}
