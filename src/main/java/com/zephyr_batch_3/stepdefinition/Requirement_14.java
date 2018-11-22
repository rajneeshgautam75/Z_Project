package com.zephyr_batch_3.stepdefinition;

import org.openqa.selenium.WebElement;
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

public class Requirement_14 extends LaunchBrowser
{
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	RequirementsPage req;
	BasePage bp;
	CreateTestCasePage ctc;
	
	boolean[] actual=new boolean[14];
	SoftAssert soft=new SoftAssert();
	 
	 LaunchBrowser lb=new LaunchBrowser();
	 String fileName="Requirement_14";
	
	 @Given("^User is in requirement module Page$")
	 public void user_is_in_requirement_module_Page() throws Throwable {
		 try
		  {
			  
			  pp=new ProjectPage(driver);
			  rp=new ReleasePage(driver);
			  bp=new BasePage();
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Normal_Project_1");
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
			   actual[0]=pp.selectProject(projectName);
			   actual[1]=pp.selectRelease(releaseName);
			  

			   actual[2]=rp.clickOnRequirements();
			   
			  
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

	 
	 
	 @When("^add a first node with requirements in Global tree$")
	 public void add_a_first_node_with_requirements_in_Global_tree() throws Throwable {
		 try
			{
			 tr=new TestRepositoryPage(driver);
			 req=new RequirementsPage(driver);
			String folderName=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 7);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 22, 1);
			   String desc=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 22, 2);
			   
			  tr.doubleClickOnRelease(folderName);
			   actual[0]=req.addNode(name, desc);
			   
			   String[] node1=new String[1];
			   node1[0]=name;
			   
			   actual[1]=tr.navigateToNode(folderName, node1);
			   
			   for(int i=1;i<=5;i++)
			   {
				   actual[2]=req.addRequirement();
			   }
			   
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

	 @Then("^requirements should be added in the first node$")
	 public void requirements_should_be_added_in_the_first_node() throws Throwable {
		 try
			{
				 
			actual[3]=req.VerifyRequirementCount();
			
			
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

	 @When("^user add second node in global tree with empty requirements in it$")
	 public void user_add_second_node_in_global_tree_with_empty_requirements_in_it() throws Throwable {
		 try
			{
			String folderName=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 7);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 23, 1);
			   String desc=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 23, 2);
			   
			  
			   actual[4]=tr.doubleClickOnRelease(folderName);
			   actual[5]=req.addNode(name, desc);
			   
			   String[] node1=new String[1];
			   node1[0]=name;
			   
			   actual[6]=tr.navigateToNode(folderName, node1);
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

	 @Then("^no requirement should be present in the second node$")
	 public void no_requirement_should_be_present_in_the_second_node() throws Throwable {
		 try
			{
				 
			actual[7]=req.VerifyRequirementCount();
			
			
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

	 @When("^user selects multiple requirements from first Node present in global tree$")
	 public void user_selects_multiple_requirements_from_first_Node_present_in_global_tree() throws Throwable {
         try
       {
             String folderName=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 7);
		 String[] node1=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 22, 1);
		   
		   actual[8]=tr.navigateToNode(folderName, node1);
		   
		   String[] requirements=new String[2];
		   requirements[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"ReqDetails", 1, 6));
		   requirements[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"ReqDetails", 2, 6));
		   actual[9]=req.selectMultipleRequirementFromGrids(requirements);
		   
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

	 @When("^move the selected requirement to second node in global tree using Dnd$")
	 public void move_the_selected_requirement_to_second_node_in_global_tree_using_Dnd() throws Throwable {
	    
		 try
		 {
		 WebElement src=req.srcReq;
	     String destNode=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 23, 1);
		   actual[10]=tr.dragAndDropTestCase(src, destNode);
		   
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

	 @Then("^requirements should be moved to the second node in global tree$")
	 public void requirements_should_be_moved_to_the_second_node_in_global_tree() throws Throwable {
		
		 try
		 {
		 String folderName=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 7);
		   String[] node1=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 23, 1);
		   
		   actual[11]=tr.navigateToNode(folderName, node1);
		   actual[12]=req.VerifyRequirementCount();
		   actual[13]=req.minimizeFolderNode(folderName);
		   
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
