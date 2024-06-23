package com.aiite.basepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static void browserLaunch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void browserLaunch(String browser) {
		if(browser.equals("Edge")){
		driver = new EdgeDriver();
		}
		else if(browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		else{
			System.out.println("No driver found");
		}
		driver.manage().window().maximize();
	}
	
	public static void loadUrl(String url) {
		driver.get(url);
	}
	
	public static void closeBrowser() {
		driver.close();
	}
	
	public static String getpresentUrl() {
		return driver.getCurrentUrl();
	}

}
