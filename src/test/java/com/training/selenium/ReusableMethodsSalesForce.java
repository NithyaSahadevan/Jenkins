package com.training.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReusableMethodsSalesForce {

	static WebDriver driver;
	static ExtentReports report;
	static ExtentTest logger;
	//static String path="extent = new ExtentReports (System.getProperty(\"user.dir\") +\"/test-output/homeExtentReport.html\", true);";
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
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sysadmin\\selenium\\geckodriver-v0.21.0-win64\\geckodriver.exe");
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
		logger = report.startTest("Login to Sales Force"+Msg);
		Thread.sleep(2000);
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
		report = new ExtentReports(System.getProperty("user.dir") +"/test-output/homeExtentReport.html", true);
	}

	/*
	 * Name of the method : readExcelData
	 * Brief Description  : Read username and password from excel sheet
	 * Arguments		  : path of the excel sheet, sheet name
	 * Created By		  : Automation Team
	 * Created Date       : 03/21/2019
	 * Last Modified	  : 03/21/2019
	 */
	public static String[][] readExcelData(String dataTablePath,String sheetName) throws IOException
	{

		//Step 1: Get the XL path
		File xlFile=new File(dataTablePath);

		//Step 2: Access the XL file
		FileInputStream xlDoc=new FileInputStream(xlFile);

		//Step 3: Access the work book
		HSSFWorkbook wb=new HSSFWorkbook(xlDoc);

		//Step 4: Access the sheet
		HSSFSheet sheet=wb.getSheet(sheetName);

		int iRowCount=sheet.getLastRowNum()+1;
		int iColCount=sheet.getRow(0).getLastCellNum();

		String[][] xlData=new String[iRowCount][iColCount];
		for(int i=0;i<iRowCount;i++)
		{
			for(int j=0;j<iColCount;j++)
			{

				xlData[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		wb.close();
		return xlData;
	}

	/*
	 * Name of the method : LaunchSF
	 * Brief Description  : Launch the salesforcepage with valid username and password
	 * Arguments		  : String for extent report Test Name 
	 * Created By		  : Automation Team
	 * Created Date       : 03/21/2019
	 * Last Modified	  : 03/21/2019
	 */
	public static void LaunchSF(String Msg) throws InterruptedException, IOException
	{
		//Initialize the driver
		InitializeDriver();

		//Launch the Sales Force page
		Launch("https://login.salesforce.com/",Msg);

		System.out.println("Sales Force page is launched");
		logger.log(LogStatus.INFO, "Salesforce application page is displayed");

		//call the readExcelData function to  Read username and password from excel sheet
		String dt_path="C:\\Users\\sysadmin\\Desktop\\SeleniumTraining\\Selenium_TestData.xls";
		String[][] retData=readExcelData(dt_path,"Sheet1");

		//Enter the UserName
		WebElement emailUserName=driver.findElement(By.id("username"));
		emailUserName.clear();
		enterText(emailUserName,retData[0][0],"Email");
		logger.log(LogStatus.PASS, "Username is displayed in username field");

		//Enter the Password
		WebElement password=driver.findElement(By.id("password"));
		password.clear();
		enterText( password,retData[0][1],"Password");

		//Click on Login button		
		WebElement loginButton=driver.findElement(By.id("Login"));
		clickObject(loginButton,"Login");
		
		
	}
	
	/*
	 * Name of the method : selectCheckBox
	 * Brief Description  : Select the remember username checkbox
	 * Arguments		  : WebElement and the string to pass to the TextBox 
	 * Created By		  : Automation Team
	 * Created Date       : 03/21/2019
	 * Last Modified	  : 03/21/2019
	 */
	public static void selectCheckBox(WebElement obj, String objName)
	{
		if(obj == null)
			return;
		if (obj.isDisplayed()) {
			if(!obj.isSelected())
			{
				obj.click();
			}
			System.out.println("Pass: checkbox " + objName + " is selected");
		} else {
			System.out.println("Fail: " + objName + " could not be found");
		}
	}
	
	/*
	 * Name of the method : enterText
	 * Brief Description  : Enter text into TextBox
	 * Arguments		  : WebElement and the string to pass to the TextBox 
	 * Created By		  : Automation Team
	 * Created Date       : 03/21/2019
	 * Last Modified	  : 03/21/2019
	 */
	public static void enterText(WebElement Obj,String textVal,String Msg) throws InterruptedException
	{
		if(Obj.isDisplayed())
		{
			Thread.sleep(3000);
			Obj.sendKeys(textVal);
			System.out.println(Msg+" text field is success");
		}
		else
		{
			System.out.println(Msg+" Field doesn't exist please check");
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
	public static void clickObject(WebElement Obj,String Msg) throws InterruptedException
	{
		if(Obj.isDisplayed()) {
			Thread.sleep(1000);
			Obj.click();
			System.out.println(Msg+" Button is clicked");
		}
		else
		{
			System.out.println(Msg+" Button doesn't exist please check");
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
