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

public class Requirement_10 extends LaunchBrowser {

	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	RequirementsPage req;
	BasePage bp;
	CreateTestCasePage ctc;
	
	boolean[] actual=new boolean[47];
	SoftAssert soft=new SoftAssert();
	 
	 LaunchBrowser lb=new LaunchBrowser();
	 String fileName="Requirement_10";
	
	
	@When("^User add a first phase with requirement$")
	public void user_add_a_first_phase_with_requirement() throws Throwable {
		try
		{
			bp=new BasePage();
		    req=new RequirementsPage(driver);
		   tr=new TestRepositoryPage(driver);
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 17, 1);
		   String desc=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 17, 2);
		   
		  
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

	@Then("^requirement should be added in the first phase$")
	public void requirement_should_be_added_in_the_first_phase() throws Throwable {
		 
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

	@When("^user create a child node under first phase and add requirement in it$")
	public void user_create_a_child_node_under_first_phase_and_add_requirement_in_it() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		String[] node1=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 17, 1);
		   
		   actual[4]=tr.navigateToNode(releaseName, node1);
		   
		   String name=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 17, 3);
		   String desc=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 17, 4);
		   actual[5]=req.addNode(name, desc);
		   
		   String[] node11=new String[2];
		   node11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 17, 1);
		   node11[1]=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 17, 3);
		   
		   
		   actual[6]=tr.navigateToNode(releaseName, node11);
		   
		   
		   for(int i=1;i<=2;i++)
		   {
			   actual[7]=req.addRequirement();
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

	@Then("^requirement should be added in the child node$")
	public void requirement_should_be_added_in_the_child_node() throws Throwable {
		try
		{
			 
		actual[8]=req.VerifyRequirementCount();
		
		
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

	@When("^user add a second phase with two requirements$")
	public void user_add_a_second_phase_with_two_requirements() throws Throwable {
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 18, 1);
		   String desc=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 18, 2);
		   
		   actual[9]=tr.doubleClickOnRelease(releaseName);
		   actual[10]=req.addNode(name, desc);
		   
		   String[] node1=new String[1];
		   node1[0]=name;
		   
		   actual[11]=tr.navigateToNode(releaseName, node1);
		   
		   for(int i=1;i<=2;i++)
		   {
			   actual[12]=req.addRequirement();
		   }
		   
	}

	@Then("^requirement should be added in the second phase$")
	public void requirement_should_be_added_in_the_second_phase() throws Throwable {
		try
		{
			 
		actual[13]=req.VerifyRequirementCount();
		
		
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

	@When("^user create a child node under second phase and add requirement in it$")
	public void user_create_a_child_node_under_second_phase_and_add_requirement_in_it() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		String[] node1=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 18, 1);
		   
		   actual[14]=tr.navigateToNode(releaseName, node1);
		   
		   String name=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 18, 3);
		   String desc=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 18, 4);
		   actual[15]=req.addNode(name, desc);
		   
		   String[] node11=new String[2];
		   node11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 18, 1);
		   node11[1]=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 18, 3);
		   
		   
		   actual[16]=tr.navigateToNode(releaseName, node11);
		   
		   
		   for(int i=1;i<=2;i++)
		   {
			   actual[17]=req.addRequirement();
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

	@Then("^requirement should be added in the child node present under second phase$")
	public void requirement_should_be_added_in_the_child_node_present_under_second_phase() throws Throwable {
		try
		{
			 
		actual[18]=req.VerifyRequirementCount();
		
		
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

	@When("^user add a third phase with no requirements$")
	public void user_add_a_third_phase_with_no_requirements() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 19, 1);
		   String desc=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 19, 2);
		   
		   actual[19]=tr.doubleClickOnRelease(releaseName);
		   actual[20]=req.addNode(name, desc);
		   
		   String[] node1=new String[1];
		   node1[0]=name;
		   
		   actual[21]=tr.navigateToNode(releaseName, node1);
		   
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

	@When("^view the requirement count of third phase$")
	public void view_the_requirement_count_of_third_phase() throws Throwable {
		try
		{
			 
		actual[22]=req.VerifyRequirementCount();
		
		
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

	@When("^user navigate to first phase under local release and delete it$")
	public void user_navigate_to_first_phase_under_local_release_and_delete_it() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		String[] node1=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 17, 1);
		   
		   actual[23]=tr.navigateToNode(releaseName, node1);
		  
		   String type=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 17, 8);
		   actual[24]=req.deleteOrDeallocateRequirementNode(type);
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

	@Then("^first phase with child node should be deleted from local release$")
	public void first_phase_with_child_node_should_be_deleted_from_local_release() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		 actual[25]=tr.doubleClickOnRelease(releaseName);
		String nodeName= UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 17, 1);
		actual[26]=req.validateDeletedOrDeallocatedNode(nodeName);
		actual[27]=req.minimizeFolderNode(releaseName);
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

	@Then("^first phase with child node should be deleted from Global folder$")
	public void first_phase_with_child_node_should_be_deleted_from_Global_folder() throws Throwable {
	   try
	   {
		String folderName=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 7);
		
		actual[28]=tr.doubleClickOnRelease(folderName);
		String nodeName= UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 17, 1);
		actual[29]= req.validateDeletedOrDeallocatedNode(nodeName);
		 
		actual[30]=req.minimizeFolderNode(folderName);
		
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

	@When("^user navigate to child node of second phase under local release and delete it$")
	public void user_navigate_to_child_node_of_second_phase_under_local_release_and_delete_it() throws Throwable {
		
		try
		{
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		   String[] node11=new String[2];
		   node11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 18, 1);
		   node11[1]=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 18, 3);
		   
		   
		   actual[31]=tr.navigateToNode(releaseName, node11);
			
		   String type=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 18, 8);
		   actual[32]=req.deleteOrDeallocateRequirementNode(type);
		  bp.waitForElement();
		   actual[33]=req.minimizeFolderNode(releaseName);
		   
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

	@Then("^child node under second phase should be deleted from local release$")
	public void child_node_under_second_phase_should_be_deleted_from_local_release() throws Throwable {
		try
		{
		
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1"); 
		String[] node11=new String[1];
		   node11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 18, 1);
		   actual[34]=tr.navigateToNode(releaseName, node11);
		   
		   String nodeName= Excel_Lib.getData(INPUT_PATH_2,"Requirement", 18, 3);
		   actual[35]=req.validateDeletedOrDeallocatedNode(nodeName);
		   
		   actual[36]=req.minimizeFolderNode(releaseName);
		   
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

	@Then("^child node under second phase should be deleted from Global folder$")
	public void child_node_under_second_phase_should_be_deleted_from_Global_folder() throws Throwable {
		try
		{
		String folderName=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 7);
		String[] node11=new String[1];
		   node11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 18, 1);
		  
		   actual[37]=tr.navigateToNode(folderName, node11);
		   
		   String nodeName= UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 18, 3);
		   actual[38]=req.validateDeletedOrDeallocatedNode(nodeName);
		   
		   actual[39]=req.minimizeFolderNode(folderName);
		   
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

	@When("^user navigate to third phase under local release and delete it$")
	public void user_navigate_to_third_phase_under_local_release_and_delete_it() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1"); 
		String[] node1=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 19, 1);
		   
		   actual[1]=tr.navigateToNode(releaseName, node1);
		   String type=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 19, 8);
		   actual[40]=req.deleteOrDeallocateRequirementNode(type);
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

	@Then("^third phase should be deleted from local release$")
	public void third_phase_should_be_deleted_from_local_release() throws Throwable {
		
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		 actual[41]=tr.doubleClickOnRelease(releaseName);
		  String nodeName= UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 19, 1);
		  actual[42]= req.validateDeletedOrDeallocatedNode(nodeName);
		  actual[43]= req.minimizeFolderNode(releaseName);
		  
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

	@Then("^third phase should be deleted from Global folder$")
	public void third_phase_should_be_deleted_from_Global_folder() throws Throwable {
		
		try
		{
		String folderName=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 7);
		actual[44]=tr.doubleClickOnRelease(folderName);
		  String nodeName= UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 19, 1);
		  actual[45]=req.validateDeletedOrDeallocatedNode(nodeName);
		  actual[46]= req.minimizeFolderNode(folderName);
		  
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
