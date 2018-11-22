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

public class Requirement_7 extends LaunchBrowser {

	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	RequirementsPage req;
	BasePage bp;
	CreateTestCasePage ctc;
	
	boolean[] actual=new boolean[20];
	SoftAssert soft=new SoftAssert();
	 
	 LaunchBrowser lb=new LaunchBrowser();;
	 String fileName="Requirement_7";

@When("^add a node in the local release with multiple requirement$")
public void add_a_node_in_the_local_release_with_multiple_requirement() throws Throwable {
  try
  {
	
	req=new RequirementsPage(driver);
   tr=new TestRepositoryPage(driver);
   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 12, 1);
   String desc=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 12, 2);
   
  
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

@Then("^multiple requirements added in the node$")
public void multiple_requirements_added_in_the_node() throws Throwable {
   try
   {
	   actual[3]=req.VerifyRequirementCount();
	   
	   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		req.minimizeFolderNode(releaseName);
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

@Then("^user view the requirement count in global node$")
public void user_view_the_requirement_count_in_global_node() throws Throwable {
    
	try
	{
	String globalName=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 7);
	  String[] node1=new String[1];
	   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 12, 1);
	   
	   actual[4]=tr.navigateToNode(globalName, node1);
	   
	   actual[5]=req.VerifyRequirementCount();
	   
	   
	    req.minimizeFolderNode(globalName);
	   
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

@When("^user select single requirement from local node and deallocate$")
public void user_select_single_requirement_from_local_node_and_deallocate() throws Throwable {
	try
	{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		 String[] node1=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 12, 1);
		   
		   actual[6]=tr.navigateToNode(releaseName, node1);
		   
//	String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 12, 1);
//	actual[6]=tr.selectPhase(name);
	
	
	 String[] requirements=new String[1];
	 requirements[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"ReqDetails", 1, 6));
	 actual[7]=req.selectMultipleRequirementFromGrids(requirements);
	 
	 String type=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 12, 8);
	 actual[8]=req.deleteOrDeallocateRequirements(type);
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

@Then("^requirement should be deleted from local node$")
public void requirement_should_be_deleted_from_local_node() throws Throwable {
	try
	{
		
		
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		String[] node1=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 12, 1);
		   
		   actual[9]=tr.navigateToNode(releaseName, node1);
		   
	
	actual[10]=req.VerifyRequirementCount();
	
	 //String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
	req.minimizeFolderNode(releaseName);
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

@Then("^view the requirement count in global node,requirement should be present in global node$")
public void view_the_requirement_count_in_global_node_requirement_should_be_present_in_global_node() throws Throwable {
	try
	{
	String globalName=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 7);
	  String[] node1=new String[1];
	   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 12, 1);
	   
	   actual[11]=tr.navigateToNode(globalName, node1);
	   
	   actual[12]=req.VerifyRequirementCount();
	   
	  req.minimizeFolderNode(globalName);
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

@When("^user select multiple requirement from local node and deallocate$")
public void user_select_multiple_requirement_from_local_node_and_deallocate() throws Throwable {
	try
	{
		
		
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		String[] node1=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 12, 1);;
		   
		   actual[13]=tr.navigateToNode(releaseName, node1);
//	String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 12, 1);
//	 actual[13]=tr.selectPhase(name);
	
	
	 actual[14]=req.selectAllRequirements();
	 String type=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 12, 8);
	 actual[15]=req.deleteOrDeallocateRequirements(type);
	 
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

@Then("^requirements should be deleted from local node$")
public void requirements_should_be_deleted_from_local_node() throws Throwable {
	try
	{
		
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		String[] node1=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 12, 1);;
		   
		   actual[16]=tr.navigateToNode(releaseName, node1);
//	String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 12, 1);
//	 actual[16]=tr.selectPhase(name);
	//tr.selectPhase(phaseName);
	 actual[17]=req.VerifyRequirementCount();
	 
	req.minimizeFolderNode(releaseName);

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

@Then("^view the requirement count in global node,requirements should be present in global node$")
public void view_the_requirement_count_in_global_node_requirements_should_be_present_in_global_node() throws Throwable {
	try
	{
	String globalName=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 7);
	  String[] node1=new String[1];
	   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 12, 1);
	   
	   actual[18]=tr.navigateToNode(globalName, node1);
	   
	   actual[19]=req.VerifyRequirementCount();
	   
	  req.minimizeFolderNode(globalName);
	   
	   
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
