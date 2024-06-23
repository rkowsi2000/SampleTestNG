package com.aiite.pageexecution;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aiite.basepackage.BaseClass;
import com.aiite.pagefactory.OrderPage;

public class OrderpageExecution {
	
	@Test(groups= {"Regression", "Smoke"})
	public void mobileSearch() {
		BaseClass.browserLaunch();
		BaseClass.loadUrl("https://www.amazon.in/");
		OrderPage op = new OrderPage();
		op.searchBox.sendKeys("Mobile");
		op.searchBtn.click();
		//validation
		BaseClass.closeBrowser();
	}
	
	@Test(groups= {"Regression"})
	public void laptopSearch() {
		BaseClass.browserLaunch();
		BaseClass.loadUrl("https://www.amazon.in/");
		OrderPage op = new OrderPage();
		op.searchBox.sendKeys("Laptop");
		op.searchBtn.click();
		//validation
		BaseClass.closeBrowser();
	}
	
	@BeforeSuite(alwaysRun=true)
	public void beforeSuite(){
		System.out.println("VPN connection - Open");
	}
	
	@AfterSuite(alwaysRun=true)
	public void afterSuite(){
		System.out.println("VPN connection - Close");
	}
	
	@BeforeGroups("Smoke")
	public void beforeGroups() {
		System.out.println("Before Group");
	}
	
	@AfterGroups("Smoke")
	public void afterGroups() {
		System.out.println("After Group");
	}

}
