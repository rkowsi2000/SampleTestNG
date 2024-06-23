package com.aiite.pageexecution;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aiite.basepackage.BaseClass;
import com.aiite.pagefactory.LoginPage;

public class ClassA {
	private static Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		logger.debug("This is debug message");
		logger.info("This is info message");
		logger.warn("This is warn message");		
		logger.error("This is error message");
		logger.fatal("This is fatal message");
	}
	
	
	@Test
	public void loginWithValidCredential() throws InterruptedException {
		BaseClass.browserLaunch();
		BaseClass.loadUrl("https://www.saucedemo.com/");
		
//		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		
		
		System.out.println("Login With Valid Credential");
		Thread.sleep(2000);
		LoginPage lp = new LoginPage();
		lp.userName.sendKeys("standard_user");
		lp.passWord.sendKeys("secret_sauce");
		Thread.sleep(2000);
		lp.loginBtn.click();
		//validation
//		String actualUrl = BaseClass.getpresentUrl();
//		Assert.assertEquals(expectedUrl, actualUrl);
		LoginPage lp1 = new LoginPage();
		Assert.assertTrue(lp1.error.isDisplayed());
		Thread.sleep(2000);
		BaseClass.closeBrowser();
	}

}
