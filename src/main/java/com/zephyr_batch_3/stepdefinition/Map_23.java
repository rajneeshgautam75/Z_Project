package com.zephyr_batch_3.stepdefinition;


import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Map_23 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestRepositoryPage tp;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	String size;
	String fileName="Map_23";
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
	boolean[] actual=new boolean[10];
	 SoftAssert soft=new SoftAssert();
	@Given("^User in Requirement page$")
	public void user_in_Requirement_page() throws Throwable 
	{
		try
		   {
			   pp=new ProjectPage(driver);
			   bp=new BasePage();
			   rp=new ReleasePage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Normal_Project_1");
			   actual[0]=pp.selectProject(projectName);
			   actual[1]=pp.selectRelease(releaseName);
			   bp.waitForElement();
		   }
		catch(Exception e)
		{
	    	lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
	    	e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		} 
	}

	@Given("^Customize the requirement grid by selecting more colomn chooser resize the column name$")
	public void customize_the_requirement_grid_by_selecting_more_colomn_chooser_resize_the_column_name() throws Throwable 
	{
		 try
			{
		    	bp.waitForElement();
				rp= new ReleasePage(driver);
			    rp.clickOnRequirements();
			    bp.waitForElement();
				req=new RequirementsPage(driver);
				req.doubleClickOnRelease(releaseName);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Requirements", 3, 0);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_4, "Requirements", 3, 1);
				actual[2]=req.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
				String[] phase=new String[1];
				phase[0]=p_Name1;
				tr=new TestRepositoryPage(driver);
				bp.waitForElement();
				actual[3]=tr.navigateToNode(releaseName, phase);
				req.addRequirement();
				size=req.ValidaterequirementGridSize();
				 System.out.println("Original Size- "+size);
				 bp.dragAndDrop(req.dndName, 20, 30);
				String size1=req.ValidaterequirementGridSize();
				 System.out.println("After Resize - "+size1);
				if(size==size1)
				{
					System.out.println("FAil-size not modified");
				}
				else
				{
					System.out.println("Pass-Size modified Sucessfully");
				}
			}
		 	catch(Exception e)
		 	{
		 		lb=new LaunchBrowser();
		 		lb.getScreenShot(fileName);	
		 		e.printStackTrace();
		 		driver.close();
		 		Relogin_TPE rl=new Relogin_TPE();
		 		rl.reLogin();
		 		throw e;
		 	} 
	}

	@When("^Switch to other application and return back to requirements$")
	public void switch_to_other_application_and_return_back_to_requirements() throws Throwable 
	{
		try
		{
			actual[4]=rp.clickOnTestRep();
			actual[5]=rp.clickOnRequirements();
		   String[] phase=new String[1];
		   phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Requirements", 3, 0);
		   actual[6]=tr.navigateToNode(releaseName, phase);
		   String size1=req.ValidaterequirementGridSize();
		   System.out.println("after switch to other application"+size1);
		if(size==size1)
		{
			System.out.println("FAil-size modified");
		}
		else
		{
			System.out.println("Pass-Size not Modified");
		}
		}
	 	catch(Exception e)
	 	{
	 		lb=new LaunchBrowser();
	 		lb.getScreenShot(fileName);	
	 		e.printStackTrace();
	 		driver.close();
	 		Relogin_TPE rl=new Relogin_TPE();
	 		rl.reLogin();
	 		throw e;
	 	} 
	}

	@When("^Now as lead logout from the Zee and relogin$")
	public void now_as_lead_logout_from_the_Zee_and_relogin() throws Throwable 
	{
		try
		{
		 pp=new ProjectPage(driver);
		 pp.clickOnLogout();
		 
		 lp=new LoginPage(driver);
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Lead_Username_1");
			String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Lead_Password_1");
			lp.enterUname(Uname);
			lp.enterPass(Pass);
			lp.clickOnLogin();
			  pp=new ProjectPage(driver);
			   bp=new BasePage();
			   rp=new ReleasePage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Normal_Project_1");
			   actual[7]=pp.selectProject(projectName);
			   actual[8]=pp.selectRelease(releaseName);
			   bp.waitForElement();
		}
	 	catch(Exception e)
	 	{
	 		lb=new LaunchBrowser();
	 		lb.getScreenShot(fileName);	
	 		e.printStackTrace();
	 		driver.close();
	 		Relogin_TPE rl=new Relogin_TPE();
	 		rl.reLogin();
	 		throw e;
	 	} 
	}

	@When("^Click on Reset button under grid$")
	public void click_on_Reset_button_under_grid() throws Throwable 
	{
		try
		{
		 rp.clickOnRequirements();
		   String[] phase=new String[1];
		   phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Requirements", 3, 0);
		   actual[9]=tr.navigateToNode(releaseName, phase);
		   bp.waitForElement();
		   req.resetRequirementGrid();
		}
	 	catch(Exception e)
	 	{
	 		lb=new LaunchBrowser();
	 		lb.getScreenShot(fileName);	
	 		e.printStackTrace();
	 		driver.close();
	 		Relogin_TPE rl=new Relogin_TPE();
	 		rl.reLogin();
	 		throw e;
	 	} 
		  
	}

	@Then("^Grid should retain to back original grid, and grid reset message should be shown$")
	public void grid_should_retain_to_back_original_grid_and_grid_reset_message_should_be_shown() throws Throwable {
		try
		{
		 String size2=req.ValidaterequirementGridSize();
		 System.out.println("After reset"+size2);
			if(size==size2)
			{
				System.out.println("Pass-Grid retain its original position");
			}
			else
			{
			   
				System.out.println("Fail-Grid not retain its original position");
			}
			for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		     }
		    soft.assertAll();
		}
	 	catch(Exception e)
	 	{
	 		lb=new LaunchBrowser();
	 		lb.getScreenShot(fileName);	
	 		e.printStackTrace();
	 		driver.close();
	 		Relogin_TPE rl=new Relogin_TPE();
	 		rl.reLogin();
	 		throw e;
	 	} 
	}
}
