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

public class Map_24 extends LaunchBrowser
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
	String fileName="Map_24";
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
	String releaseName2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_2");
	boolean[] actual=new boolean[10];
	 SoftAssert soft=new SoftAssert();
	@Given("^user in requirements page$")
	public void user_in_requirements_page() throws Throwable 
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

	@When("^add phase and add requoirement and resize the Grid$")
	public void add_phase_and_add_requoirement_and_resize_the_Grid() throws Throwable 
	{
		 try
			{
		    	bp.waitForElement();
				rp= new ReleasePage(driver);
			    rp.clickOnRequirements();
			    bp.waitForElement();
				req=new RequirementsPage(driver);
				req.doubleClickOnRelease(releaseName);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Requirements", 4, 0);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_4, "Requirements", 4, 1);
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

	@When("^select Release(\\d+) and get the size$")
	public void select_Release_and_get_the_size(int arg1) throws Throwable 
	{
		try
		{
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Normal_Project_1");
		   actual[4]=pp.selectProject(projectName);
		   actual[5]=pp.selectRelease(releaseName2);
		   bp.waitForElement();  
		   rp.clickOnRequirements();
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

	@Then("^should retain the same value$")
	public void should_retain_the_same_value() throws Throwable 
	{
		try
		{
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

	@Then("^select the project(\\d+) and get the size$")
	public void select_the_project_and_get_the_size(int arg1) throws Throwable 
	{
		try
		{
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Normal_Project_2");
		   actual[6]=pp.selectProject(projectName);
		   actual[7]=pp.selectRelease(releaseName);
		   bp.waitForElement();  
		   rp.clickOnRequirements();
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

	@Then("^should not reflect the size$")
	public void should_not_reflect_the_size() throws Throwable 
	{
		try
		{
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

	@Then("^logout and login with user(\\d+)$")
	public void logout_and_login_with_user(int arg1) throws Throwable 
	{
		try
		{
	  pp=new ProjectPage(driver);
	  pp.clickOnLogout();
	  
	  lp=new LoginPage(driver);
		String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Lead_Username_2");
		String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Lead_Password_2");
		lp.enterUname(Uname);
		lp.enterPass(Pass);
		lp.clickOnLogin();
		  pp=new ProjectPage(driver);
		   bp=new BasePage();
		   rp=new ReleasePage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Normal_Project_1");
		   actual[8]=pp.selectProject(projectName);
		   actual[9]=pp.selectRelease(releaseName);
		   bp.waitForElement();
		   rp.clickOnRequirements();
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

	@Then("^should not reflect the user size$")
	public void should_not_reflect_the_user_size() throws Throwable 
	{
		try
		{
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
