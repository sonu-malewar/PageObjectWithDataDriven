package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pageobject.tests.BaseClass;

public class ExtentListenerClass implements ITestListener {
	WebDriver driver;
	static ExtentSparkReporter  htmlReporter;
	static ExtentReports reports;
	static ExtentTest test;

	public static void configureReport()
	{

		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "PageObject-" + timestamp + ".html";

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);

          reports = new ExtentReports();
          reports.attachReporter(htmlReporter);
		
		//add system information/environment info to reports
		reports.setSystemInfo("Machine:", "testpc1");
		reports.setSystemInfo("OS", "windows 10");
		reports.setSystemInfo("browser:", "chrome");
		reports.setSystemInfo("user name:", "Sonu");

		//configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("This is my First Report");
		htmlReporter.config().setTheme(Theme.DARK);


	}

	//OnStart method is called when any Test starts.
	public void onStart(ITestContext Result)					
	{		
		configureReport();
		System.out.println("On Start method invoked....");  		
	}	

	//onFinish method is called after all Tests are executed
	public void onFinish(ITestContext Result) 					
	{		
		System.out.println("On Finished method invoked....");  	
		reports.flush();//it is mandatory to call flush method to ensure information is written to the started reporter.

	}		



	// When Test case get failed, this method is called.		

	public void onTestFailure(ITestResult Result) 					
	{	
		if(Result.getStatus()==ITestResult.FAILURE) {
			try { 		
				test = reports.createTest(Result.getName());//create entry in html report
				test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName() ,ExtentColor.RED));

				String sspath= Actions.captureScreenShot(BaseClass.getDriver(), Result.getName());
				test.fail("screenshot is attached",MediaEntityBuilder.createScreenCaptureFromPath(sspath).build());

			}catch (Exception e) {
				e.printStackTrace();
			} 
		} 
	}	

	public void onTestSkipped(ITestResult Result)					
	{		
		if(Result.getStatus()==ITestResult.SKIP) {
			test = reports.createTest(Result.getName());
			test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName() ,ExtentColor.YELLOW));
		}
	}			

	// When Test case get Started, this method is called.		

	public void onTestStart(ITestResult Result)					
	{		
		System.out.println("Name of test method started:" + Result.getName() );  		

	}		

	// When Test case get passed, this method is called.		

	public void onTestSuccess(ITestResult Result)					
	{		
		System.out.println("Name of test method sucessfully executed:" + Result.getName() );  		

		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName() ,ExtentColor.GREEN));
	}		


	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
	{		

	}		

}
