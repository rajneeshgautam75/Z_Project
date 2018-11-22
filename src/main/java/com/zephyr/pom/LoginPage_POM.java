package com.zephyr.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.zephyr.common.LaunchBrowser;
import com.zephyr.reusablemethods.BasePage;


public class LoginPage_POM
{	
	WebDriver driver=null;
	WebDriver driver2;
	BasePage bp;
	public Logger log;
	
//Modified
@FindBy(xpath="(//*[@id='zee-login-username-two'])")
public WebElement username;
		
//@FindBy(xpath="(//*[@id='zee-login-username'])[2]")
//public WebElement username;

//Modified
@FindBy(xpath="(//*[@id='zee-login-password-two'])")
public WebElement password;

//@FindBy(xpath="(//*[@id='zee-login-password'])[2]")
// public WebElement password;
    
@FindBy(xpath="(//button[text()='Login'])[2]")
public WebElement loginButton;
	
public String role;


public LoginPage_POM(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(LaunchBrowser.driver, this);
	
}


}
