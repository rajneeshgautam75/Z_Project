package com.zephyr_batch_3.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class External_Jira_Precondition extends LaunchBrowser {
	
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	RequirementsPage req;
	BasePage bp;
	CreateTestCasePage ctc;
	
	boolean[] actual=new boolean[10];
	SoftAssert soft=new SoftAssert();
	 
	 LaunchBrowser lb=new LaunchBrowser();
	 String fileName="External_Jira_Precondition";
	 
	@Given("^User is in test repository Page$")
	public void user_is_in_test_repository_Page() throws Throwable {
		try
		{
		pp=new ProjectPage(driver);
		  rp=new ReleasePage(driver);
		  bp=new BasePage();
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Normal_Project_1");
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   actual[2]=rp.clickOnTestRep();
		   bp.waitForElement();
		   
		}
		  
		  catch(Exception e)
			{
		    
		       lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.quit();
		    	Relogin_TPE rl=new Relogin_TPE();
		    	rl.reLogin();
		    	throw e;
			}  
		
		  
	}

	@When("^User add a first node and add testcases$")
	public void user_add_a_first_node_and_add_testcases() throws Throwable {
		try
		{
	   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
	   tr=new TestRepositoryPage(driver);
	   tr.clickOnRelease(releaseName);
	   String pName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_5,"Req", 1, 8);
	   String pDesc1=Excel_Lib.getData(INPUT_PATH_5, "Req", 1, 8);
	   actual[3]=tr.addNode(pName1, pDesc1);
	   bp.waitForElement();
	   String[] node1=new String[1];
	   node1[0]=pName1;
	   actual[4]=tr.navigateToNode(releaseName, node1);
	   bp.waitForElement();
	   for(int i=1;i<=2;i++)
	   {
		actual[5]=tr.addTestCase();
		bp.waitForElement();
	   }
		} 
		  catch(Exception e)
			{
		    
		       lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.quit();
		    	Relogin_TPE rl=new Relogin_TPE();
		    	rl.reLogin();
		    	throw e;
			}  
		
	}

	@Then("^test cases added successfully$")
	public void test_cases_added_successfully() throws Throwable {
	   try
	   {
		   actual[6]=tr.verifyPresentTestCase();
		   bp.waitForElement();
		
		}
		  
		  catch(Exception e)
			{
		    
		       lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.quit();
		    	Relogin_TPE rl=new Relogin_TPE();
		    	rl.reLogin();
		    	throw e;
			}  
		
	}

	@When("^user add a second node and add testcases$")
	public void user_add_a_second_node_and_add_testcases() throws Throwable {
		
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1"); 
		String pName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_5,"Req", 2, 8);
	  	String pDesc2=Excel_Lib.getData(INPUT_PATH_5, "Req", 2, 8);
	  	tr.clickOnRelease(releaseName);
	  	bp.waitForElement();
	    tr.addNode(pName2, pDesc2);
	    bp.waitForElement();
	    String[] node1=new String[1];
	    node1[0]=pName2;
	    actual[7]=tr.navigateToNode(releaseName, node1);
	    for(int i=1;i<=4;i++)
	    {
	    actual[8]=tr.addTestCase();
	   }
	    bp.waitForElement();
		}
		  
		  catch(Exception e)
			{
		    
		       lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.quit();
		    	Relogin_TPE rl=new Relogin_TPE();
		    	rl.reLogin();
		    	throw e;
			}  
		
	   
	}

	@Then("^test cases should be added successfully$")
	public void test_cases_should_be_added_successfully() throws Throwable {
		try
		{
			
		actual[9]=tr.verifyPresentTestCase();
		bp.waitForElement();
				
		for(int k=0;k<=actual.length-1;k++)
	     {
	      soft.assertEquals(actual[k], true);
	      System.out.println(actual[k]);
	     }
	    soft.assertAll();
	    
		}
		  
		  catch(Exception e)
			{
		    
		       lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.quit();
		    	Relogin_TPE rl=new Relogin_TPE();
		    	rl.reLogin();
		    	throw e;
			}  
		
	}
}
