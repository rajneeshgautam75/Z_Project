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

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Requirement_4 extends LaunchBrowser
{

	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	RequirementsPage req;
	BasePage bp;
	CreateTestCasePage ctc;
	
	boolean[] actual=new boolean[9];
	 SoftAssert soft=new SoftAssert();
	 
	 LaunchBrowser lb=new LaunchBrowser();;
	 String fileName="Requirement_4";
	
	@When("^add a node with name and description$")
	public void add_a_node_with_name_and_description() throws Throwable {
	   try
	   {
		   bp=new BasePage();
		req=new RequirementsPage(driver);
	   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 8, 1);
	   String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 8, 2);
	   
	   actual[0]=req.addNode(name, desc);
		  
	   }
	   
	   catch(Exception e)
	 	{
	     
	        lb.getScreenShot(fileName);
	 	   e.printStackTrace();
	 	   driver.close();
	     	Relogin_TPE rl=new Relogin_TPE();
	     	rl.reLogin();
	     	throw e;
	 	}  
	}

	@When("^add a single requirement in the created node$")
	public void add_a_single_requirement_in_the_created_node() throws Throwable {
	  try
	  {
		  tr=new TestRepositoryPage(driver);
		  String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		  String[] node1=new String[1];
			 node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 8, 1);
			 
			 actual[1]=tr.navigateToNode(releaseName, node1);
		 // tr.navigateToNode(releaseName, navigation)
			 actual[2]=req.addRequirement();
		  
	  }
	  
	  catch(Exception e)
		{
	    
	       lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	    	Relogin_TPE rl=new Relogin_TPE();
	    	rl.reLogin();
	    	throw e;
		}  
	}

	@When("^copy the single requirement using clone option$")
	public void copy_the_single_requirement_using_clone_option() throws Throwable {
		 try
		  {
			 String[] requirements=new String[1];
			 requirements[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"ReqDetails", 1, 6));
			 actual[3]=req.selectMultipleRequirementFromGrids(requirements);
			
			 
			 actual[4]=req.cloneRequirement();
		  }
		  
		  catch(Exception e)
			{
		    
		       lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		    	Relogin_TPE rl=new Relogin_TPE();
		    	rl.reLogin();
		    	throw e;
			}  
	}

	@Then("^single requirement should be copied to the node$")
	public void single_requirement_should_be_copied_to_the_node() throws Throwable {
		 try
		  {
			 actual[5]=req.VerifyRequirementCount();
			  
		  }
		  
		  catch(Exception e)
			{
		    
		       lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		    	Relogin_TPE rl=new Relogin_TPE();
		    	rl.reLogin();
		    	throw e;
			}  
	}

	@When("^user copy the multiple requirement more than four hundered using clone option$")
	public void user_copy_the_multiple_requirement_more_than_four_hundered_using_clone_option() throws Throwable {
		 try
		  {
			
			 for(int i=1;i<=9;i++)
			 {
				 actual[6]=req.selectAllRequirements();
				 bp.waitForElement();
				 actual[7]=req.cloneRequirement();
			 }
			 bp.waitForElement();
			 bp.waitForElement();
			  
		  }
		  
		  catch(Exception e)
			{
		    
		       lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		    	Relogin_TPE rl=new Relogin_TPE();
		    	rl.reLogin();
		    	throw e;
			}  
		 
	}

	@Then("^multiple requirement should be copied to the node$")
	public void multiple_requirement_should_be_copied_to_the_node() throws Throwable {
		 try
		  {
			 actual[8]=req.VerifyRequirementCount();
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
			   driver.close();
		    	Relogin_TPE rl=new Relogin_TPE();
		    	rl.reLogin();
		    	throw e;
			}  
	}
}
