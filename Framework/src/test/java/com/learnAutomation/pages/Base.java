package com.learnAutomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnAutomation.utility.Browserfactory;
import com.learnAutomation.utility.ConfigDataProvider;
import com.learnAutomation.utility.ExcelDataProvider;
import com.learnAutomation.utility.Helper;

public class Base {
public WebDriver driver;
public ExcelDataProvider excell;
public ConfigDataProvider config;
public ExtentReports report;
public ExtentTest logger;


   @BeforeSuite
    public void setUpSuite()
    {
	   Reporter.log("Setting up the reports and excel started");
    	excell=new ExcelDataProvider();
    	config=new ConfigDataProvider();
    	ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"
    	+Helper.getcurrentdatatime()+".html"));
    	report=new ExtentReports();
    	report.attachReporter(extent);
    	Reporter.log("Setting up the reports and excel done");
    	
    }
	
	@BeforeClass
	public void setUp()
	{
		Reporter.log("Called the startapplication");
		driver=Browserfactory.startApplication(driver,config.getbrowser(),config.getUrl());
	}
	@AfterClass
	public void tearDown()
	{
		Reporter.log("Closed the browser");
		Browserfactory.quitebrowser(driver);
	}
	
@AfterMethod
public void teardownMethod(ITestResult result) throws IOException
{
	if(result.getStatus()==ITestResult.FAILURE)
	{

	logger.fail("Test failed ",MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenShot(driver)).build());
	}
	
	else if(result.getStatus()==ITestResult.SUCCESS)
	{
		logger.pass("Test passed ",MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenShot(driver)).build());
		
	}
	else if(result.getStatus()==ITestResult.SKIP)
	{
		logger.skip("Test skipped ",MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenShot(driver)).build());
		
	}
	report.flush();
}
}
