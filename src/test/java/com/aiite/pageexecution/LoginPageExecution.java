package com.aiite.pageexecution;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aiite.basepackage.BaseClass;
import com.aiite.pagefactory.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LoginPageExecution {
	
	private static Logger logger = LogManager.getLogger();
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	//invocationCount=1, priority=-1
	@Test(enabled=false, invocationCount=1, groups= {"Regression", "Smoke"})
	public void loginWithValidCredential() throws InterruptedException {
//		BaseClass.browserLaunch();
//		BaseClass.loadUrl("https://www.saucedemo.com/");
		
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		
//		System.out.println("Login With Valid Credential");
		logger.info("Login With Valid Credential");
		Thread.sleep(2000);
		LoginPage lp = new LoginPage();
		lp.userName.sendKeys("standard_user");
		lp.passWord.sendKeys("secret_sauce");
		Thread.sleep(2000);
		lp.loginBtn.click();
//		System.out.println(8/0);
		//validation
		String actualUrl = BaseClass.getpresentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);		
		Thread.sleep(2000);
//		BaseClass.closeBrowser();
	}
	
	@Test(enabled=false, dependsOnMethods = {"loginWithValidCredential"}, groups= {"Regression"})
	public void loginWithInvalidCredential() throws InterruptedException {
//		BaseClass.browserLaunch();
//		BaseClass.loadUrl("https://www.saucedemo.com/");
//		System.out.println("Login With Invalid Credential");
		logger.info("Login With Valid Credential");
		ExtentTest test = extent.createTest("Url validation");
		Thread.sleep(2000);
		LoginPage lp2 = new LoginPage();
		lp2.userName.sendKeys("test_user");
		lp2.passWord.sendKeys("Welcome@123");
		Thread.sleep(2000);
		lp2.loginBtn.click();
		test.info("providing credentials");
		
		//validation
		Thread.sleep(2000);
		test.pass("passed");
//		BaseClass.closeBrowser();
	}
	
	@BeforeMethod
	public void beforeMethod() {
//		System.out.println("Before Method");
		logger.info("Before Method");
		BaseClass.browserLaunch();
		BaseClass.loadUrl("https://www.saucedemo.com/");
	}
	
	@AfterMethod(alwaysRun=true)
	public void afterMethod() {
//		System.out.println("After Method");
		logger.info("After Method");
		BaseClass.closeBrowser();
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class - DB connection Open");
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After class - DB connection Close");
		System.out.println("After class - Close");
		extent.flush();
	}
	
	@Test(dataProvider = "testData", groups= {"Regression"})
	public void loginWithValidCredentialMultiple(String userName, String password) {
		try {
			System.out.println("Login With Valid Credential");
			Thread.sleep(2000);
			LoginPage lp = new LoginPage();
			lp.userName.sendKeys(userName);
			lp.passWord.sendKeys(password);
			Thread.sleep(2000);
			System.out.println(8/0);
			lp.loginBtn.click();
			//validation
			Thread.sleep(2000);
		} catch (Exception e) {
			logger.error(e);
		}
	}
	
	
	//, parallel=true
	@DataProvider(name="testData")
	public String[][] generateData() {
		String[][] credential = new String[3][2];
		credential[0][0]="standard_user";
		credential[0][1]="secret_sauce";
		
		credential[1][0]="locked_out_user";
		credential[1][1]="secret_sauce";
		
		credential[2][0]="problem_user";
		credential[2][1]="secret_sauce";
		
		return credential;
		
	}
	
	

}
