package Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageobject.tests.BaseClass;

import net.bytebuddy.asm.Advice.Argument;

public class Actions extends BaseClass {

	// Select value from dropdown
	public static void selectDropdownByValue(WebElement ele,String value) {

		Select select = new Select(ele);
		select.selectByValue(value);
	}

	public static void selectDropdownByIndex(WebElement ele,String index) {

		Select select = new Select(ele);
		select.selectByValue(index);
	}

	// Enter text in the input field

	public static void enterText(WebElement ele, String textToBeEntered) {
		ele.clear();
		ele.sendKeys(textToBeEntered);
	}
	// click on element

	public static void clickOnElement(WebElement ele,long waitTimeunit) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waitTimeunit));
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		
	}
	
				
	 // create fluentWait method
	// Waiting 30 seconds for an element to be present on the page, checking
	   // for its presence once every 5 seconds.
	public static void fluentWait(WebElement ele,long waitTimeunit,Exception e) {
	   Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
	       .withTimeout(Duration.ofSeconds(30L))
	       .pollingEvery(Duration.ofSeconds(5L))
	       .ignoring(Exception.class);

	   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
	     public WebElement apply(WebDriver driver) {
	       return getDriver().findElement(By.id("foo"));
	     }
	   });
	}
	
	public static boolean isDisplayed(WebElement ele) {

		return ele.isDisplayed();
	}
	
	// click on element by javascriptExecutor
	
	public static void javaScriptClick(WebDriver driver,WebElement ele) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("Argument[0].click()", ele);
	}
	
	//to capture screenshot
	public static String captureScreenShot(WebDriver driver,String testName) throws IOException
	{
		//step1: convert webdriver object to TakesScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot)driver);

		//step2: call getScreenshotAs method to create image file

		File src = screenshot.getScreenshotAs(OutputType.FILE);

		String dest = System.getProperty("user.dir") + "//Screenshots//" + testName + ".png";

		//step3: copy image file to destination
		
		try {
		FileUtils.copyFile(src, new File(dest));
		}catch (Exception e) {
			e.getMessage();
		}
		
		return dest;	
	}
	

	

	
}
