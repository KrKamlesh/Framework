package com.learnAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
	WebDriver driver;
	
	public void landing(WebDriver driver)

	{
		this.driver=driver;
	}
	
	@FindBy(xpath="//span[@class='mdi-chart-bar icon icon-md']")
	WebElement SignUp;
	
	
	
	public void clickonsignIn()
	{
		SignUp.click();
	}
	
}
