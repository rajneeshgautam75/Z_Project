package com.zephyr_batch_3.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Requirement_27 extends LaunchBrowser {
	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ExportPage ep;
	LaunchBrowser lb=new LaunchBrowser();
	String screen="Requirement_27";
	boolean[] actual=new boolean[11];
	SoftAssert soft=new SoftAssert();
	@Given("^user is in a page of Requirements$")
	public void user_is_in_a_page_of_Requirements() throws Throwable {
		try
		{
			
			   bp=new BasePage();
			   pp=new ProjectPage(driver);
			   rp= new ReleasePage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Normal_Project_1");
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
			   actual[0]=pp.selectProject(projectName);
			   actual[1]=pp.selectRelease(releaseName);
			   bp.waitForElement();
			   actual[2]=rp.clickOnRequirements();
		}
		catch(Exception e)
		 {
		      e.printStackTrace();
		      driver.close();
		      Relogin_TPE rl=new Relogin_TPE();
		      rl.reLogin();
		      throw e;
		 }
	    
	    
	}

	@When("^user double Clicks on Release node$")
	public void user_double_Clicks_on_Release_node() throws Throwable {
		try
		{    tr=new TestRepositoryPage(driver);
		     bp=new BasePage();
			 String fileName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
			 tr=new TestRepositoryPage(driver);
			 actual[3]=tr.clickOnRelease(fileName);
		
		}
		catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(screen);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }
	    
	   
	}

	@When("^user adds The node$")
	public void user_adds_The_node() throws Throwable {
		 try
		    {
		    	 bp=new BasePage();
		    	 req=new RequirementsPage(driver);
		    	 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"Requirements",1,1);
			     String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"Requirements",1,2);
			     actual[4]=req.addNode(name, desc);
		    }
		    catch(Exception e)
			 {
			  e.printStackTrace();
			  lb.getScreenShot(screen);
			  driver.close();
			  Relogin_TPE rl=new Relogin_TPE();
			  rl.reLogin();
			  throw e;
			 }
	   
	}

	@When("^user Adds the Requirements$")
	public void user_Adds_the_Requirements() throws Throwable {
		try{
			bp=new BasePage();
			req=new RequirementsPage(driver);
			String fileName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
			String navigation[]=new String[1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"Requirements",1,1);
			actual[5]=tr.navigateToNode(fileName, navigation);
			for(int i=0;i<=4;i++)
			{
			req.addRequirement();
			}
			}catch(Exception e)
			{
				e.printStackTrace();
				 lb.getScreenShot(screen);
				  driver.close();
				 Relogin_TPE rl=new Relogin_TPE();
				  rl.reLogin();
				  throw e;
				
			}
			
	    
	}
	
	

@Then("^user is in folder view$")
public void user_is_in_folder_view() throws Throwable {
	try
	{
   actual[6]=req.VerifyRequirementCount();
	}
   catch(Exception e)
	{
		e.printStackTrace();
		 lb.getScreenShot(screen);
		  driver.close();
		 Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		
	}
}

@When("^user navigate to search view$")
public void user_navigate_to_search_view() throws Throwable {
	try
  {
	  bp=new BasePage();
	  tr=new TestRepositoryPage(driver);
	  actual[7]=tr.clickOnSearch();
	  }
	  catch(Exception e)
	  {
	  e.printStackTrace();
	  lb.getScreenShot(screen);
	  driver.close();
	  Relogin_TPE rl=new Relogin_TPE();
	  rl.reLogin();
	  throw e;
	  }
}
	
	
	@Then("^user is successfully switched to search view$")
	public void user_is_successfully_switched_to_search_view() throws Throwable {
		try
		  {
		   actual[8]=req.VerifyRequirementCount();
		  }
		  catch(Exception e)
		  {
		  e.printStackTrace();
		  lb.getScreenShot(screen);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		  }
	    
	}
	
	

@When("^user move to folder view$")
public void user_move_to_folder_view() throws Throwable {
	try
	{
    actual[9]=tr.clickedOnFolder();  
	}
	catch(Exception e)
	 {
	  e.printStackTrace();
	  lb.getScreenShot(screen);
	  driver.close();
	 Relogin_TPE rl=new Relogin_TPE();
	  rl.reLogin();
	  throw e;
	 }
}

	@Then("^user is successfully switched to folder view$")
	public void user_is_successfully_switched_to_folder_view() throws Throwable {
		try
	    {
	    	actual[10]=req.VerifyRequirementCount();
	    	 for(int k=0;k<=actual.length-1;k++)
	 	    {
	 		System.out.println(actual[k]);
	 		soft.assertEquals(actual[k], true);
	 	    }
	        soft.assertAll();
	    }
	    catch(Exception e)
	    {
	    	  e.printStackTrace();
			  lb.getScreenShot(screen);
			  driver.close();
			  Relogin_TPE rl=new Relogin_TPE();
			  rl.reLogin();
			  throw e;
	    }
	    	
	    
	}
	
}
