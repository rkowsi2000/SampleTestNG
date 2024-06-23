package com.aiite.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aiite.basepackage.BaseClass;

public class LoginPage extends BaseClass{
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="user-name")
	public WebElement userName;
	
	@FindBy(id="password")
	public WebElement passWord;
	
	@FindBy(xpath="//input[@value='Login']")
	public WebElement loginBtn;
	
	//h3[@data-test="error"]
	@FindBy(xpath="//h3[@data-test=\"error\"]")
	public WebElement error;
	

}
