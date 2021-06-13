package com.learnAutomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class RegistrationPage {

	WebDriver driver;

	@Test
	public void regitrationCRM(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(xpath = "//input[@name='email']")
	WebElement emailid;

	@FindBy(xpath = "//div[@class='menu transition visible']/div")
	WebElement Countrycode;

	@FindBy(xpath = "//input[@id='phone_number']")
	WebElement phonenumber;

	@FindBy(name = "action")
	WebElement Signup;

	@FindBy(name = "terms")
	WebElement AgreeCondition;

	@FindBy(xpath = "//span[@id='recaptcha-anchor']/div[1]")
	WebElement Captcha;

	@FindBy(xpath = "//button[@name='action']")
	WebElement SignUpButton;

	@SuppressWarnings("unchecked")
	public void selectCounrty(String Nameofcountry) {
		List<WebElement> lst = (List<WebElement>) Countrycode;
		for (WebElement countryname : lst) {
			String Country=countryname.getText();
			if(Country==Nameofcountry)
			{
				countryname.click();

			}

		}

	}

	public void SignUp() {
		SignUpButton.click();
	}

	public void selectCounrty(int Index) {

		Select sel = new Select(Countrycode);
		sel.selectByIndex(Index);

	}

	public void checkCaptcha() {
		Captcha.click();
	}

	public void chekTermsCheckBox() {
		AgreeCondition.click();
	}

	public void enterPersonalDetails(String EmailSignID, String Personalphoone) throws InterruptedException {
		System.out.println("Enter email id");

		Thread.sleep(30);
		emailid.sendKeys(EmailSignID);
		phonenumber.sendKeys(Personalphoone);

	}
}
