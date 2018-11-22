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

public class Requirement_8 extends LaunchBrowser {

	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	RequirementsPage req;
	BasePage bp;
	CreateTestCasePage ctc;
	
	boolean[] actual=new boolean[26];
	SoftAssert soft=new SoftAssert();
	 
	 LaunchBrowser lb=new LaunchBrowser();;
	 String fileName="Requirement_8";

	 
	@When("^add a node in the local release with multiple requirements$")
	public void add_a_node_in_the_local_release_with_multiple_requirements() throws Throwable {
		try
		{
			bp=new BasePage();
		    req=new RequirementsPage(driver);
		   tr=new TestRepositoryPage(driver);
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 13, 1);
		   String desc=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 13, 2);
		   
		  
		   actual[0]=req.addNode(name, desc);
		   
		   String[] node1=new String[1];
		   node1[0]=name;
		   
		   actual[1]=tr.navigateToNode(releaseName, node1);
		   
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

	@Then("^multiple requirements should be added in the node$")
	public void multiple_requirements_should_be_added_in_the_node() throws Throwable {
		 
		try
		{
			 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		actual[3]=req.VerifyRequirementCount();
		actual[4]=req.minimizeFolderNode(releaseName);
		
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

	@Then("^user view the requirement count in Global node$")
	public void user_view_the_requirement_count_in_Global_node() throws Throwable {
		try
		{
		
		String globalName=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 7);
		  String[] node1=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 13, 1);
		   
		   actual[5]=tr.navigateToNode(globalName, node1);
		   
		   actual[6]=req.VerifyRequirementCount();
		   
		   actual[7]=req.minimizeFolderNode(globalName);
		   
		   
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

	@When("^user select single requirement from local node and delete it$")
	public void user_select_single_requirement_from_local_node_and_delete_it() throws Throwable {
		
		try
		{
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 13, 1);
		
		String[] requirements=new String[1];
		 requirements[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"ReqDetails", 1, 6));
		
		 String[] node1=new String[1];
		   node1[0]=name;
		   
		   actual[8]=tr.navigateToNode(releaseName, node1);
		 
		 
		 actual[9]=req.selectMultipleRequirementFromGrids(requirements);
		 
		 String type=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 13, 8);
		 actual[10]=req.deleteOrDeallocateRequirements(type);
		 
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

	@Then("^single requirement should be deleted from local node$")
	public void single_requirement_should_be_deleted_from_local_node() throws Throwable {
		try
		{
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
			String[] node1=new String[1];
			   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 13, 1);;
			   
			   actual[11]=tr.navigateToNode(releaseName, node1);
			   
			   actual[12]= req.VerifyRequirementCount();
		
		
			   actual[13]=req.minimizeFolderNode(releaseName);
		
			
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

	@Then("^view the requirement count in Global node,requirement should be present in global node$")
	public void view_the_requirement_count_in_Global_node_requirement_should_be_present_in_global_node() throws Throwable {
		try
		{
		String globalName=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 7);
		  String[] node1=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 13, 1);
		   
		   actual[14]=tr.navigateToNode(globalName, node1);
		   
		   actual[15]=req.VerifyRequirementCount();
		
		   actual[16]=req.minimizeFolderNode(globalName);
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

	@When("^user select multiple requirement from local node and delete it$")
	public void user_select_multiple_requirement_from_local_node_and_delete_it() throws Throwable {
     
		try
		{
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 13, 1);
		
		String[] requirements=new String[3];
		 requirements[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"ReqDetails", 1, 6));
		 requirements[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"ReqDetails", 2, 6));
		 requirements[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"ReqDetails", 3, 6));
		 
		 String[] node1=new String[1];
		   node1[0]=name;
		   
		   actual[17]=tr.navigateToNode(releaseName, node1);
		 
		 actual[18]=req.selectMultipleRequirementFromGrids(requirements);
		 
		 String type=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 13, 8);
		 actual[19]=req.deleteOrDeallocateRequirements(type);
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

	@Then("^multiple requirements should be deleted from local node$")
	public void multiple_requirements_should_be_deleted_from_local_node() throws Throwable {
	   
		try
		{
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		 String[] node1=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 13, 1);
		   
		   actual[20]=tr.navigateToNode(releaseName, node1);
		 
		   actual[21]=req.VerifyRequirementCount();
		 
		   actual[22]=req.minimizeFolderNode(releaseName);
		 
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

	@Then("^view the requirement count in Global node,requirements should be present in global node$")
	public void view_the_requirement_count_in_Global_node_requirements_should_be_present_in_global_node() throws Throwable {
	    
		try
		{
		String globalName=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 7);
		  String[] node1=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 13, 1);
		   
		   actual[23]=tr.navigateToNode(globalName, node1);
		   
		   actual[24]=req.VerifyRequirementCount();
		   
		   actual[25]=req.minimizeFolderNode(globalName);
		    
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
