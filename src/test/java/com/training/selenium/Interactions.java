package com.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Interactions extends ReusableMethods{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		WebDriver driver;
		driver=new FirefoxDriver();
		
		driver.get("https://selenium-prd.firebaseapp.com/");
		
		System.out.println("Application Launched Successfully");
		Thread.sleep(4000);
		
		//Enter the UserName
		WebElement emailUserName=driver.findElement(By.id("email_field"));
		emailUserName.clear();
		enterText(emailUserName,"admin123@gmail.com");
				
		//Enter the Password
		WebElement password=driver.findElement(By.id("password_field"));
		password.clear();
		enterText( password,"admin123");
		
		//Click on Login button		
		WebElement loginButton=driver.findElement(By.xpath("/html/body/div[1]/button"));
		clickObject(loginButton);
	}

}
