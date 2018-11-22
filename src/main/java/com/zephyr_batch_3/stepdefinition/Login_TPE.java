package com.zephyr_batch_3.stepdefinition;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_TPE extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	String filename="Login_TPE";
@Given("^User Selects the Browser, Launches it and Maximises it_TPE$")
public void user_Selects_the_Browser_Launches_it_and_Maximises_it_TPE() throws Throwable 
{
	try
	{
	   lb=new LaunchBrowser();
	   lb.preCond();
	}
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
}

@When("^User Navigates to the URL provided_TPE$")
public void user_Navigates_to_the_URL_provided_TPE() throws Throwable
{
	try
	{
	  lb=new LaunchBrowser();
	    String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"URL");
	    lb.getUrl(url);
	}
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
}

@When("^User Enters Username, Password and clicks on login_TPE$")
public void user_Enters_Username_Password_and_clicks_on_login_TPE() throws Throwable 
{
	try
	{
	lp=new LoginPage(driver);
	String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Lead_Username_1");
	String pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Lead_Password_1");
	lp.enterUname(Uname);
	System.out.println(" User name is " + Uname +"name");
	lp.enterPass(pass);
	System.out.println("Password is " + pass + "passsowrd");
	lp.clickOnLogin();
	System.out.println(Uname);
	}
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
}

@Then("^User should be Logged in into Zephyr Successfully_TPE$")
public void user_should_be_Logged_in_into_Zephyr_Successfully_TPE() throws Throwable 
{
	try
	{
	lp.verifyLoginTitle();
    log.info("Pass - User should be Logged in into Zephyr Successfully");
}
catch(Exception e)
	{
	   lb=new LaunchBrowser();
	   lb.getScreenShot(filename);
		e.printStackTrace();
	   driver.close();
   	Relogin_TPE rl=new Relogin_TPE();
   	rl.reLogin();
   	throw e;
	 
	}
}

}



