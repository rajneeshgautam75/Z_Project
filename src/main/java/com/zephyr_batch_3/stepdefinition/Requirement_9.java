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

public class Requirement_9 extends LaunchBrowser {

	
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	RequirementsPage req;
	BasePage bp;
	CreateTestCasePage ctc;
	
	boolean[] actual=new boolean[43];
	SoftAssert soft=new SoftAssert();
	 
	 LaunchBrowser lb=new LaunchBrowser();;
	 String fileName="Requirement_9";

	 
	@When("^add a first phase in local release with requirements$")
	public void add_a_first_phase_in_local_release_with_requirements() throws Throwable {
		try
		{
			bp=new BasePage();
		    req=new RequirementsPage(driver);
		   tr=new TestRepositoryPage(driver);
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 14, 1);
		   String desc=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 14, 2);
		   
		  
		   actual[0]=req.addNode(name, desc);
		   
		   String[] node1=new String[1];
		   node1[0]=name;
		   
		   actual[1]=tr.navigateToNode(releaseName, node1);
		   
		   for(int i=1;i<=4;i++)
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

	@Then("^requirement should be added in first node$")
	public void requirement_should_be_added_in_first_node() throws Throwable {
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

	@When("^user add a child node to the first phase with requirement$")
	public void user_add_a_child_node_to_the_first_phase_with_requirement() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		String[] node1=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 14, 1);
		   
		   actual[4]=tr.navigateToNode(releaseName, node1);
		   
		   String name=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 14, 3);
		   String desc=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 14, 4);
		   actual[5]=req.addNode(name, desc);
		   
		   String[] node11=new String[2];
		   node11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 14, 1);
		   node11[1]=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 14, 3);
		   
		   
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

	@Then("^requirement should be added in child node unde first phase$")
	public void requirement_should_be_added_in_child_node_unde_first_phase() throws Throwable {
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

	@When("^user create a second phase and create two child node under second phase$")
	public void user_create_a_second_phase_and_create_two_child_node_under_second_phase() throws Throwable {
		try
		{
		
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 1);
		   String desc=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 2);
		   actual[9]=tr.doubleClickOnRelease(releaseName);
		   actual[10]= req.addNode(name, desc);
		   
		   String[] node1=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 1);
		   
		   actual[11]=tr.navigateToNode(releaseName, node1);
		   
		   String childName1=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 3);
		   String childDesc1=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 4);
		   req.addNode(childName1, childDesc1);
		   
		   String[] node12=new String[2];
		   node12[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 1);
		   node12[1]=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 3);
		   actual[12]=tr.navigateToNode(releaseName, node12);
		   
		   String childName2=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 5);
		   String childDesc2=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 6);
		   actual[13]=req.addNode(childName2, childDesc2);
		   
		   String[] node13=new String[3];
		   node13[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 1);
		   node13[1]=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 3);
		   node13[2]=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 5);
		   actual[14]=tr.navigateToNode(releaseName, node13);
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

	@When("^Add requirements to all the nodes$")
	public void add_requirements_to_all_the_nodes() throws Throwable {
	    
		try
		{
		String[] nodes=new String[3];
		nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 1);
		nodes[1]=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 3);
		nodes[2]=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 5);
		
		
		for(int i=0;i<=2;i++)
		{
			actual[15]=tr.selectPhase(nodes[i]);
		
			for(int j=1;j<=3;j++)
			{
			
				actual[16]=req.addRequirement();
		    }
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

	@Then("^requirement should be added in the nodes$")
	public void requirement_should_be_added_in_the_nodes() throws Throwable {
		try
		{
		String[] nodes=new String[3];
		nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 1);
		nodes[1]=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 3);
		nodes[2]=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 5);
		
		
		for(int i=0;i<=2;i++)
		{
			actual[17]=tr.selectPhase(nodes[i]);
			actual[18]=req.VerifyRequirementCount();
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

	@When("^user create a third phase with no requirements$")
	public void user_create_a_third_phase_with_no_requirements() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 16, 1);
		   String desc=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 16, 2);
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

	@When("^view the requirement count$")
	public void view_the_requirement_count() throws Throwable {
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

	@When("^user select the first phase and deallocate it$")
	public void user_select_the_first_phase_and_deallocate_it() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		String[] node1=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 14, 1);
		   
		   actual[23]=tr.navigateToNode(releaseName, node1);
		   
		   String type=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 14, 8);
		   actual[24]=req.deleteOrDeallocateRequirementNode(type);
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

	@Then("^first phase with child nodes should be removed from local release$")
	public void first_phase_with_child_nodes_should_be_removed_from_local_release() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 14, 1);
		actual[25]=req.validateDeletedOrDeallocatedNode(nodeName);
		
		actual[26]=req.minimizeFolderNode(releaseName);
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

	@Then("^first phase with child nodes should be present in Global node$")
	public void first_phase_with_child_nodes_should_be_present_in_Global_node() throws Throwable {
		try
		{
		String globalFolder=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 7);
		String[] node11=new String[2];
		   node11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 14, 1);
		   node11[1]=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 14, 3);
		   
		   
		   actual[27]=tr.navigateToNode(globalFolder, node11);
		   actual[28]=req.VerifyRequirementCount();
		   
		   actual[29]= req.minimizeFolderNode(globalFolder);
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

	@When("^user navigate to child node under second phase and deallocate it$")
	public void user_navigate_to_child_node_under_second_phase_and_deallocate_it() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		String[] node12=new String[2];
		   node12[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 1);
		   node12[1]=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 3);
		   actual[30]=tr.navigateToNode(releaseName, node12);
		   
		   String type=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 8);
		   actual[31]= req.deleteOrDeallocateRequirementNode(type);
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

	@Then("^child node should be should be removed from local release$")
	public void child_node_should_be_should_be_removed_from_local_release() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		String nodeName=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 3);
		actual[32]=req.validateDeletedOrDeallocatedNode(nodeName);
		
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

	@Then("^child node should be should be present in Global node$")
	public void child_node_should_be_should_be_present_in_Global_node() throws Throwable {
	    try
	    {
		String globalFolder=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 7);
		//String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		String[] node12=new String[2];
		   node12[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 1);
		   node12[1]=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 15, 3);
		   actual[5]=tr.navigateToNode(globalFolder, node12);
		   
		   actual[34]=req.VerifyRequirementCount();
		   
		   actual[35]=req.minimizeFolderNode(globalFolder);
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

	@When("^user navigate to the third phase and deallocate it$")
	public void user_navigate_to_the_third_phase_and_deallocate_it() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		String[] node1=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 16, 1);
		   actual[36]=tr.navigateToNode(releaseName, node1);
		   String type=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 16, 8);
		   actual[37]=req.deleteOrDeallocateRequirementNode(type);
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

	@Then("^third phase should be should be removed from local release$")
	public void third_phase_should_be_should_be_removed_from_local_release() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 16, 1);
		actual[38]=req.validateDeletedOrDeallocatedNode(nodeName);
		
		actual[39]=req.minimizeFolderNode(releaseName);
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

	@Then("^third phase should be should be present in Global node$")
	public void third_phase_should_be_should_be_present_in_Global_node() throws Throwable {
		try
		{
		String globalFolder=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 7);
		//String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		String[] node1=new String[1];
		   node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 16, 1);
		   actual[40]=tr.navigateToNode(globalFolder, node1);
		   
		   actual[41]= req.VerifyRequirementCount();
		   
		   actual[42]=req.minimizeFolderNode(globalFolder);
		   
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
