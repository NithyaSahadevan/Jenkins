package com.training.selenium;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {

	static ExtentReports extent;
	static ExtentTest homeTest;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/homeExtentReport.html", true);
		
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		WebDriver driver;
		driver=new FirefoxDriver();
		homeTest=extent.startTest("Launch firebaseapp");
		
		//WebDriverWait wait=new WebDriverWait(driver,40);
		driver.get("https://selenium-prd.firebaseapp.com/");
		System.out.println("Application Launched Successfully");
		Thread.sleep(4000);
		
		//Enter the UserName
		WebElement emailUserName=driver.findElement(By.id("email_field"));
		emailUserName.clear();
		emailUserName.sendKeys("admin123@gmail.com");
		System.out.println("Username is entered successfully");
		homeTest.log(LogStatus.PASS,"username entered successfully");
		
		//Enter the Password
		WebElement password=driver.findElement(By.id("password_field"));
		password.clear();
		password.sendKeys("admin123");
		System.out.println("Password is successfully entered");
		homeTest.log(LogStatus.PASS,"password entered successfully");
		
		//Click on Login button
		
		WebElement loginButton=driver.findElement(By.xpath("/html/body/div[1]/button"));
		loginButton.click();
		System.out.println("Login button is clicked successfully");
		homeTest.log(LogStatus.PASS,"Login button entered successfully");
		Thread.sleep(2000);
		
		//Click on the Home button
		WebElement homeTab=driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		homeTab.click();
		System.out.println("Home button is clicked successfully");
		Thread.sleep(2000);
		
		//Enter Name
		WebElement studName=driver.findElement(By.xpath("//input[@id='name']"));
		studName.clear();
		studName.sendKeys("Nithya");
		
		//Enter Fathers Name
		WebElement fatherName=driver.findElement(By.xpath("//input[@id='lname']"));
		fatherName.clear();
		fatherName.sendKeys("Sahadevan");
		
		//Enter postal address
		WebElement postalAddress=driver.findElement(By.id("postaladdress"));
		postalAddress.clear();
		postalAddress.sendKeys("95051");
		
		//Enter personal address
		WebElement personalAddress=driver.findElement(By.xpath("//input[@id='personaladdress']"));
		personalAddress.clear();
		personalAddress.sendKeys("678551");
		
		//Enter Gender
		 WebElement genderRadioButton = driver.findElement(By.xpath("//input[@value='female']")); 
		 if(!genderRadioButton.isSelected())
		 {
			 genderRadioButton.click();
		 }
		 
		 //Select city from DropDown
		 Select city=new Select(driver.findElement(By.id("city")));
		 city.selectByValue("mumbai");
		 
		 //Select course from DropDown
		 Select course=new Select(driver.findElement(By.id("course")));
		 course.selectByValue("mca");
		 
		 //Select district from DropDown
		 Select district=new Select(driver.findElement(By.id("district")));
		 district.selectByValue("goa");
		 
		 //Select state from DropDown
		 Select state=new Select(driver.findElement(By.id("state")));
		 state.selectByVisibleText("UP");
		 Thread.sleep(2000);
		 
		 //Enter Pincode
		 WebElement pinCode=driver.findElement(By.id("pincode"));
		 pinCode.clear();
		 pinCode.sendKeys("678001");
		 
		 //Enter EmailId
		 WebElement email=driver.findElement(By.id("emailid"));
		 email.clear();
		 email.sendKeys("abc@123.com");
		 Thread.sleep(2000);
		 
		 //Click the Submit Button
		 WebElement submit=driver.findElement(By.xpath("//button[@class='bootbutton']"));
		 submit.click();
		 Thread.sleep(2000);
		 
		 //Switch To Tab Actions
		 WebElement switchTo=driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		 switchTo.click();
		 
		 //Click on the Alert
		 WebElement Alert=driver.findElement(By.xpath("//a[contains(text(),'Alert')]"));
		 Alert.click();
		 
		 //Click on the Window Alert
		 WebElement windowsAlert=driver.findElement(By.xpath("//button[contains(text(),'Window Alert')]"));
		 windowsAlert.click();
		 
		 //switch to alert and print the text from alert
		 Alert wAlert=driver.switchTo().alert();
		 String alertText=wAlert.getText();
		 System.out.println("Alert text is: "+alertText);
		 Thread.sleep(2000);
		 wAlert.accept();
		 
		 //Click on Prompt Alert
		 WebElement promptAlert=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/button[2]"));
		 promptAlert.click();
		 Thread.sleep(2000);
		 
		 //switch to alert and accept
		 Alert pAlert=driver.switchTo().alert();
		 Thread.sleep(2000);
		 pAlert.sendKeys("Nithya");
		 Thread.sleep(2000);
		 pAlert.accept();
		 
		 extent.endTest(homeTest);
		 extent.flush();
	}
}

