package com.aiite.pageexecution;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aiite.basepackage.BaseClass;
import com.aiite.pagefactory.OrderPage;
import com.aiite.pagefactory.SummaryPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

//@Listeners(ListenerImp.class)
public class SummaryPageExecution {
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	@Parameters({"Browser","User"})
	@Test(groups= {"Regression", "Smoke"}, retryAnalyzer = MyRetry.class)
	public void tvSearch(String browser, String user) {
		ExtentTest extlog = extent.createTest("tvSearch");
		System.out.println(browser);
		System.out.println(user);
		BaseClass.browserLaunch(browser);
		extlog.info("Message");
		BaseClass.loadUrl("https://www.amazon.in/");
		extlog.info("URL");
		SummaryPage op = new SummaryPage();
		op.searchBox.sendKeys("TeleVision");
		op.searchBtn.click();
		//validation
		Assert.assertEquals(false, true);
		extlog.pass("Passed");
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		BaseClass.closeBrowser();
	}
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		System.out.println("Before class - Open");
	}
	
	@AfterClass
	public void afterClass() {
		extent.flush();
		System.out.println("After class - Close");
	}

}
