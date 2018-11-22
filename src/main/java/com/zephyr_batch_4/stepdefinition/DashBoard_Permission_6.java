package com.zephyr_batch_4.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashBoard_Permission_6 extends LaunchBrowser {

	LaunchBrowser lb;
	BasePage bp;
	ProjectPage pp;
	DashBoardPage db;
	
	String fileName="DashBoard_Permission_6";
	 boolean[] actual=new boolean[8];
		SoftAssert soft=new SoftAssert();
	

@Given("^User is in project page$")
public void user_is_in_project_page() throws Throwable {
    
	try
	{
	 pp=new ProjectPage(driver);
	 bp=new BasePage();
	 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	 actual[0]=pp.selectProject(projectName);
	 
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }   
	 
}

	@When("^user clicks on manage dashboard$")
	public void user_clicks_on_manage_dashboard() throws Throwable {
	   try
	   {
		db=new DashBoardPage(driver);
	    actual[1]=db.clickOnManageDashboards();
	    
	   }
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	    
	}

	@Then("^manage dashboard page should be displayed$")
	public void manage_dashboard_page_should_be_displayed() throws Throwable {
		try
		{
		actual[2]=db.validateDashboards();
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
		
	    
	}

	@When("^user add a new dashboard$")
	public void user_add_a_new_dashboard() throws Throwable {
	    
		try
		{
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 44, 1);
		String dashBoardDesc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 44, 2);
		String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 44, 3);
		String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 44, 4);
		actual[3]=db.clickOnAddDashBoardSymbol();
		
		actual[4]=db.enterDashBoardDetails(dashBoardName, dashBoardDesc, layout, shareType);
		
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}

	@Then("^Dashboard Should be created successfully$")
	public void dashboard_Should_be_created_successfully() throws Throwable {
		try
		{
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 44, 1);
		actual[5]=db.validateDashBoard(dashBoardName);
		
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}

	@Then("^user view the action column options in grid$")
	public void user_view_the_action_column_options_in_grid() throws Throwable {
		try
		{
			
		String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 44, 1);
		WebElement editOption=driver.findElement(By.xpath(db.editDashBoard1+dashBoardName+db.editDashBoard2));
		actual[6]=bp.moveToElement(editOption);
		
		if(actual[6]=true)
		{
			log.info("Edit option is visble in dashboard grid");
		}
		
		WebElement deleteOption=driver.findElement(By.xpath(db.deleteDashBoard1+dashBoardName+db.deleteDashBoard2));
		
		actual[7]=bp.moveToElement(deleteOption);
		
		if(actual[7]=true)
		{
			log.info("Delete option is visble in dashboard grid");
		}
		
	
		pp.backToProjectPage();
		for(int k=0;k<=actual.length-1;k++)
		{
			//System.out.println("Actual["+k+"]="+actual[k]);
			soft.assertEquals(actual[k], true);
		}
		soft.assertAll();
		
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }   
	
}

}