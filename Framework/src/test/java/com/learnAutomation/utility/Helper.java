package com.learnAutomation.utility;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public static String CaptureScreenShot(WebDriver driver)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath=System.getProperty("user.dir")+"/Screenshots/FreeCRM"+getcurrentdatatime()+".png";
		try {
			FileHandler.copy(src, new File(screenshotpath));
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot"+e.getMessage());
		}
		
		return screenshotpath;
		
	}
public static String getcurrentdatatime()
{
	DateFormat customformat=new SimpleDateFormat("MM_dd_yyyy _HH_mm_ss");
	Date currentdate=new Date();
	return customformat.format(currentdate);
	
}
}
