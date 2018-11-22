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

public class Requirement_1 extends LaunchBrowser {
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	RequirementsPage req;
	BasePage bp;
	CreateTestCasePage ctc;
	
	boolean[] actual=new boolean[21];
	 SoftAssert soft=new SoftAssert();
	 
	 LaunchBrowser lb=new LaunchBrowser();;
	 String fileName="Requirement_1";
	
	
@Given("^User is in requirement module page$")
public void user_is_in_requirement_module_page() throws Throwable {
  try
  {
	  
	  pp=new ProjectPage(driver);
	  bp=new BasePage();
	   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Normal_Project_1");
	   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
	   actual[0]=pp.selectProject(projectName);
	  
	   bp.waitForElement();
	   actual[1]=pp.selectRelease(releaseName);
	  
	   rp=new ReleasePage(driver);
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

@When("^user select the release$")
public void user_select_the_release() throws Throwable {
     try
    {
      String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
  	  tr=new TestRepositoryPage(driver);
  	actual[3]=tr.clickOnRelease(releaseName);
  	  
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

@When("^add two parent nodes with name and description$")
public void add_two_parent_nodes_with_name_and_description() throws Throwable {
	 try
	    {
	  	  
	  	  req=new RequirementsPage(driver);
	  	  
	  	  String pName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 1);
	  	  String pDesc1=Excel_Lib.getData(INPUT_PATH_2, "Requirement", 1, 2);
	  	  
	  	actual[4]=req.addNode(pName1, pDesc1);
	  	 
	  	  String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
	  	actual[5]=tr.selectPhase(releaseName);
	  	 String pName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 4, 1);
	  	  String pDesc2=Excel_Lib.getData(INPUT_PATH_2, "Requirement", 4, 2);
	  	  
	  	actual[6]= req.addNode(pName2, pDesc2);
	  	 
	  	  
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

@When("^add three sub nodes under parent each node with name and description for only two sub nodes$")
public void add_three_sub_nodes_under_parent_each_node_with_name_and_description_for_only_two_sub_nodes() throws Throwable {
	 try
	    {
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		 String[] node1=new String[1];
		 node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 1);
		 actual[7]= tr.navigateToNode(releaseName, node1);
	  	  
	  	 String sName1=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 3);
	  	  String sDesc1=Excel_Lib.getData(INPUT_PATH_2, "Requirement", 1, 4);
	  	  
	  	actual[8]=req.addNode(sName1, sDesc1);
	 
	  	 
	  	 String sName2=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 2, 3);
	  	  String sDesc2=Excel_Lib.getData(INPUT_PATH_2, "Requirement", 2, 4);
	  	actual[9]=tr.navigateToNode(releaseName, node1);
	  	  
	  	actual[10]=req.addNode(sName2, sDesc2);
	  	  
	  	  
	  	 String sName3=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 3, 3);
	  	  String sDesc3=Excel_Lib.getData(INPUT_PATH_2, "Requirement", 3, 4);
	  	actual[11]=tr.navigateToNode(releaseName, node1);
	  	
	  	tr.selectPhase(node1[0]);
	  	  
	  	actual[12]=req.addNode(sName3, sDesc3);
	  	  
	  	 String[] node2=new String[1];
		 node2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 4, 1);
		 actual[13]=tr.navigateToNode(releaseName, node2);
	  	  
	  	 String sysName1=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 4, 3);
	  	  String sysDesc1=Excel_Lib.getData(INPUT_PATH_2, "Requirement", 4, 4);
	  	  
	  	actual[14]=req.addNode(sysName1, sysDesc1);
	 
	  	 
	  	 String sysName2=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 5, 3);
	  	  String sysDesc2=Excel_Lib.getData(INPUT_PATH_2, "Requirement", 5, 4);
	  	actual[15]=tr.navigateToNode(releaseName, node2);
	  	actual[16]=req.addNode(sysName2, sysDesc2);
	  	  
	  	  
	  	 String sysName3=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 6, 3);
	  	  String sysDesc3=Excel_Lib.getData(INPUT_PATH_2, "Requirement", 6, 4);
	  	actual[17]=tr.navigateToNode(releaseName, node2);
	  	tr.selectPhase(node2[0]);
	  	actual[18]=req.addNode(sysName3, sysDesc3);
	  	  
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

@Then("^sub nodes created successfully under parent node$")
public void sub_nodes_created_successfully_under_parent_node() throws Throwable {
	 try
	    {
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1"); 
		 
		 String[] node1=new String[2];
		 node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 1);
		 node1[1]=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 3);

		 actual[19]=tr.navigateToNode(releaseName, node1);
	  	  
	  	 String[] node2=new String[2];
		 node2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 4, 1);
		 node2[1]=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 4, 3);

		 actual[20]=tr.navigateToNode(releaseName, node2);
		 
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
