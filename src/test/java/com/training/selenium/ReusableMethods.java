package com.training.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReusableMethods {
	
	static WebDriver driver;
	/*
	 * Name of the method : enterText
	 * Brief Description  : Enter text into TextBox
	 * Arguments		  : WebElement and the string to pass to the TextBox 
	 * Created By		  : Automation Team
	 * Created Date       : 03/21/2019
	 * Last Modified	  : 03/21/2019
	 */
	public static void enterText(WebElement Obj,String textVal) throws InterruptedException
	{
		if(Obj.isDisplayed())
		{
			Thread.sleep(3000);
			Obj.sendKeys(textVal);
			System.out.println("Entering into the text field is success");
		}
		else
		{
			System.out.println("Field doesn't exist please check");
		}
	}

	/*
	 * Name of the method : clickObject
	 * Brief Description  : Click the button
	 * Arguments		  : WebElement 
	 * Created By		  : Automation Team
	 * Created Date       : 03/21/2019
	 * Last Modified	  : 03/21/2019
	 */
	public static void clickObject(WebElement Obj) throws InterruptedException
	{
		if(Obj.isDisplayed()) {
		Thread.sleep(1000);
		Obj.click();
		System.out.println("Button is clicked");
		}
		else
		{
			System.out.println("Button doesn't exist please check");
		}
	}
}
