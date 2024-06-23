package com.aiite.pageexecution;

import com.aiite.basepackage.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ClassB {
	
	public static void main(String[] args) {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("ExtentReport.html");
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(reporter);
		
		ExtentTest test = reports.createTest("Url validation");
		try {
			
			BaseClass.browserLaunch();
			test.info("Launched browser");
			BaseClass.loadUrl("https://www.amazon.in/");
			test.info("Loaded url");
			//validation
				test.pass("Validation success");
			BaseClass.closeBrowser();
		} catch (Exception e) {
			test.error(e);
		}	
		
		reports.flush();      //save close
	}

}
