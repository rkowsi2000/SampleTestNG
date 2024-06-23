package com.aiite.pageexecution;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aiite.basepackage.BaseClass;
import com.aiite.pagefactory.OrderPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class CheckoutPageExecution {
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class");
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
		extent.flush();
	}
	
	@Test
	public void mobileSearch() {
		ExtentTest test1 = extent.createTest("mobileSearch");
		BaseClass.browserLaunch();
		test1.info("Browser Lanuch");
		BaseClass.loadUrl("https://www.amazon.in/");
		test1.info("Url loaded");
		OrderPage op = new OrderPage();
		op.searchBox.sendKeys("Mobile");
		op.searchBtn.click();
		//validation
		test1.pass("Test Passed");
		BaseClass.closeBrowser();
	}
	
	@Test
	public void laptopSearch() {
		ExtentTest test2 = extent.createTest("laptopSearch");
		BaseClass.browserLaunch();
		test2.info("Browser Launched");
		BaseClass.loadUrl("https://www.amazon.in/");
		test2.info("Url loaded");
		OrderPage op = new OrderPage();
		op.searchBox.sendKeys("Laptop");
		op.searchBtn.click();
		//validation
		test2.fail("Test failed");
		BaseClass.closeBrowser();
	}
	

}
