package com.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Interactions extends ReusableMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		startTest();

		InitializeDriver();

		Launch("https://selenium-prd.firebaseapp.com/", "Login");

		Thread.sleep(2000);

		// Enter the UserName
		WebElement emailUserName = driver.findElement(By.id("email_field"));
		emailUserName.clear();
		enterText(emailUserName, "admin123@gmail.com", "Email");

		// Enter the Password
		WebElement password = driver.findElement(By.id("password_field"));
		password.clear();
		enterText(password, "admin123", "Password");

		// Click on Login button
		WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/button"));
		clickObject(loginButton, "Login");
		Thread.sleep(2000);

		// Click on the Home button
		WebElement homeTab = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		clickObject(homeTab, "Home");

		//Enter Name
		WebElement studName=driver.findElement(By.xpath("//input[@id='name']"));
		enterText(studName,"Divya","Name");

		//Enter Fathers Name
		WebElement fatherName=driver.findElement(By.xpath("//input[@id='lname']"));
		enterText(fatherName,"Sahadevan","Fathers Name");

		//Enter postal address
		WebElement postalAddress=driver.findElement(By.id("postaladdress"));
		enterText(postalAddress,"95051","Postal Address");

		//Enter personal address
		WebElement personalAddress=driver.findElement(By.xpath("//input[@id='personaladdress']"));
		enterText(personalAddress,"678551","Personal Address");

		//Enter Gender
		 WebElement genderRadioButton = driver.findElement(By.xpath("//input[@value='female']")); 
		 selectCheckBox(genderRadioButton,"Gender");
		 
		 //Select city from DropDown
		 //WebElement ddCity=driver.findElement(By.id("city"));
		 //selectDropDown(ddCity,"city");
		 //Select city=new Select(driver.findElement(By.id("city")));
		 //city.selectByValue("mumbai");
		 
		Thread.sleep(2000);
		endTest();
	}

}
