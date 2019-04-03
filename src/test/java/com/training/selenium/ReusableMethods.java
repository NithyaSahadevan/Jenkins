package com.training.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReusableMethods {
	
	static WebDriver driver;
	static ExtentReports report;
	static ExtentTest logger;
	
	/*
	 * Name of the method : InitializeDriver()
	 * Brief Description  : Firefox object creation
	 * Arguments		  : No Arguments
	 * Created By		  : Automation Team
	 * Created Date       : 03/21/2019
	 * Last Modified	  : 03/21/2019
	 */
	public static void InitializeDriver() throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		driver=new FirefoxDriver();
	}

	/*
	 * Name of the method : Launch
	 * Brief Description  : Open the SalesForce Page and maximize the web page
	 * Arguments		  : URL of sales force page 
	 * Created By		  : Automation Team
	 * Created Date       : 03/21/2019
	 * Last Modified	  : 03/21/2019
	 */
	public static void Launch(String url,String Msg) throws InterruptedException
	{ 
		driver.get(url);
		driver.manage().window().maximize();
		logger = report.startTest("Login to Firebaseapp "+Msg);
		Thread.sleep(2000);
		System.out.println("Application Launched Successfully");
		logger.log(LogStatus.PASS,"Application Launched Successfully");
	}
	
	/*
	 * Name of the method : startTest
	 * Brief Description  : To generate reports
	 * Arguments		  : Path  of the file in .htm or .html format
	 * Created By		  : Automation Team
	 * Created Date       : 03/21/2019
	 * Last Modified	  : 03/21/2019
	 */
	public static void startTest()
	{
		//("user.dir") +"/test-output/homeExtentReport.html", true)
		report = new ExtentReports(System.getProperty("user.dir") +"/test-output/fireBaseAppExtentReport.html", true);
	}
	/*
	 * Name of the method : enterText
	 * Brief Description  : Enter text into TextBox
	 * Arguments		  : WebElement and the string to pass to the TextBox 
	 * Created By		  : Automation Team
	 * Created Date       : 03/21/2019
	 * Last Modified	  : 03/21/2019
	 */
	public static void enterText(WebElement Obj,String textVal,String MsgTxtBox) throws InterruptedException
	{
		if(Obj.isDisplayed())
		{
			Thread.sleep(1000);
			Obj.sendKeys(textVal);
			System.out.println("Entering into the "+MsgTxtBox+" text field is success");
			logger.log(LogStatus.PASS,("Entering into the "+MsgTxtBox+" text field is success"));
		}
		else
		{
			System.out.println(MsgTxtBox+" Field doesn't exist please check");
			logger.log(LogStatus.FAIL,(MsgTxtBox+" Field doesn't exist please check"));
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
	public static void clickObject(WebElement Obj,String eleBtn) throws InterruptedException
	{
		if(Obj.isDisplayed()) {
		Thread.sleep(1000);
		Obj.click();
		System.out.println(eleBtn+ " Button is clicked");
		logger.log(LogStatus.PASS,(eleBtn+ " Button is clicked"));
		}
		else
		{
			System.out.println(eleBtn+ " Button doesn't exist please check");
			logger.log(LogStatus.FAIL,(eleBtn+ " Button doesn't exist please check"));
		}
	}
	
	/*
	 * Name of the method : selectCheckBox
	 * Brief Description  : Select the remember username checkbox
	 * Arguments		  : WebElement and the string to pass to the TextBox 
	 * Created By		  : Automation Team
	 * Created Date       : 03/21/2019
	 * Last Modified	  : 03/21/2019
	 */
	public static void selectCheckBox(WebElement obj, String eleChkBox)
	{
		if(obj == null)
			return;
		if (obj.isDisplayed()) {
			if(!obj.isSelected())
			{
				obj.click();
			}
			System.out.println("Pass: checkbox " + eleChkBox + " CheckBox is selected");
			logger.log(LogStatus.PASS,(eleChkBox+ " checkbox is clicked"));
		} else {
			System.out.println("Fail: " + eleChkBox + " CheckBox could not be found");
			logger.log(LogStatus.FAIL,(eleChkBox+ " CheckBox could not be found"));
		}
	}
	
	/*
	 * Name of the method : selectCheckBox
	 * Brief Description  : Select the remember username checkbox
	 * Arguments		  : WebElement and the string to pass to the TextBox 
	 * Created By		  : Automation Team
	 * Created Date       : 03/21/2019
	 * Last Modified	  : 03/21/2019
	 */
	public static void selectDropDown(WebElement obj,String eleDropDown)
	{
		if(obj == null)
			return;
		if (obj.isDisplayed()) {
			if(!obj.isSelected())
			{
				obj.click();
			}
			System.out.println("Pass: DropDown " + eleDropDown + " is selected");
			logger.log(LogStatus.PASS,(eleDropDown+ " DropDown is clicked"));
		} else {
			System.out.println("Fail: " + eleDropDown + " DropDown could not be found");
			logger.log(LogStatus.FAIL,(eleDropDown+ " DropDown could not be found"));
		}
	}
	
	
	/*
	 * Name of the method : endTest
	 * Brief Description  : ending test and write test information to your report
	 * Arguments		  : -----------
	 * Created By		  : Automation Team
	 * Created Date       : 03/21/2019
	 * Last Modified	  : 03/21/2019
	 */
	public static void endTest()
	{
		report.endTest(logger);
		report.flush();

	}
}
