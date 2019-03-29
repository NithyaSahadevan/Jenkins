package com.training.selenium;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;



public class TC2Login extends ReusableMethodsSalesForce{

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		//ExtentReports path setting
		startTest();

		LaunchSF("TC2 LoginPage");
		
		System.out.println("Welcome to your free trial");
		logger.log(LogStatus.PASS, "Welcome to your free trial");

		Thread.sleep(3000);
		//ending test and write test information to your report
		endTest();

		System.out.println("End");
		Thread.sleep(2000);
		//Close the driver
		driver.close();
	}

}
