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

public class Requirement_2 extends LaunchBrowser {
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	RequirementsPage req;
	BasePage bp;
	CreateTestCasePage ctc;
	
	boolean[] actual=new boolean[59];
	 SoftAssert soft=new SoftAssert();
	 
	 LaunchBrowser lb=new LaunchBrowser();;
	 String fileName="Requirement_2";
	 
	 
	 @When("^navigate to first parent and child nodes and add two requirements to all the nodes with fields priority,altId,Link and req details$")
	 public void navigate_to_first_parent_and_child_nodes_and_add_two_requirements_to_all_the_nodes_with_fields_priority_altId_Link_and_req_details() throws Throwable {
	  
		 try
		 {
			 tr=new TestRepositoryPage(driver);
			 bp=new BasePage();
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		 String[] node1=new String[2];
		 node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 1);
		 node1[1]=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 3);
		 actual[0]=tr.navigateToNode(releaseName, node1);
		 
		 req=new RequirementsPage(driver);
		 actual[1]=tr.selectPhase(node1[0]);
		 
		 
		 actual[2]=req.addRequirement();
		 
		 tr.clickOnDetails();
		 
		String[] reqDetails1=new String[5];
		reqDetails1[0]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 1, 1);
		reqDetails1[1]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 1, 2);
		reqDetails1[2]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 1, 3);
		reqDetails1[3]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 1, 4);
		reqDetails1[4]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 1, 5);
		
		
		actual[3]=req.enterRequirementDetails(reqDetails1[0], reqDetails1[1], reqDetails1[2], reqDetails1[3], reqDetails1[4]);
	    actual[4]=req.addRequirement();
		actual[5]=req.enterRequirementDetails(reqDetails1[0], reqDetails1[1], reqDetails1[2], reqDetails1[3], reqDetails1[4]);
	    
		 tr.clickOnList();
		actual[6]=tr.selectPhase(node1[1]);
		 
		 
		actual[7]=req.addRequirement();
		
		tr.clickOnDetails();
		 
		String[] reqDetails2=new String[5];
		reqDetails2[0]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 2, 1);
		reqDetails2[1]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 2, 2);
		reqDetails2[2]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 2, 3);
		reqDetails2[3]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 2, 4);
		reqDetails2[4]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 2, 5);
		bp.waitForElement();
		actual[8]=req.enterRequirementDetails(reqDetails2[0], reqDetails2[1], reqDetails2[2], reqDetails2[3], reqDetails2[4]);
		actual[9]=req.addRequirement(); 
		bp.waitForElement();
		actual[10]= req.enterRequirementDetails(reqDetails2[0], reqDetails2[1], reqDetails2[2], reqDetails2[3], reqDetails2[4]);
	    
	    
	    String sys2=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 2, 3);
	    tr.clickOnList();
	    
	    actual[11]=tr.selectPhase(sys2);
	    actual[12]= req.addRequirement();
	    tr.clickOnDetails();
			String[] reqDetails3=new String[5];
			reqDetails3[0]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 3, 1);
			reqDetails3[1]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 3, 2);
			reqDetails3[2]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 3, 3);
			reqDetails3[3]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 3, 4);
			reqDetails3[4]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 3, 5);
			bp.waitForElement();
			actual[13]= req.enterRequirementDetails(reqDetails3[0], reqDetails3[1], reqDetails3[2], reqDetails3[3], reqDetails3[4]);
			actual[14]=req.addRequirement();
			 bp.waitForElement();
			actual[15]= req.enterRequirementDetails(reqDetails3[0], reqDetails3[1], reqDetails3[2], reqDetails3[3], reqDetails3[4]);
		    
		    String sys3=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 3, 3);
		    tr.clickOnList();
		    
		    actual[16]=tr.selectPhase(sys3);
			 
			 
		    actual[17]= req.addRequirement();
		    
		    tr.clickOnDetails();
				String[] reqDetails4=new String[5];
				reqDetails4[0]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 4, 1);
				reqDetails4[1]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 4, 2);
				reqDetails4[2]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 4, 3);
				reqDetails4[3]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 4, 4);
				reqDetails4[4]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 4, 5);
				bp.waitForElement();
				actual[18]=req.enterRequirementDetails(reqDetails4[0], reqDetails4[1], reqDetails4[2], reqDetails4[3], reqDetails4[4]);
				actual[19]=req.addRequirement();
				bp.waitForElement();
				actual[20]=req.enterRequirementDetails(reqDetails4[0], reqDetails4[1], reqDetails4[2], reqDetails4[3], reqDetails4[4]);
				tr.clickOnList();
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

	 @Then("^requirements added in all the nodes$")
	 public void requirements_added_in_all_the_nodes() throws Throwable {
	  try
	  {
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		 
		 String[] node1=new String[2];
		 node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 1);
		 node1[1]=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 1, 3);
		 actual[21]=tr.navigateToNode(releaseName, node1);
		 
		 actual[22]= tr.selectPhase(node1[0]);
		 actual[23]=req.VerifyRequirementCount();
		
		 actual[24]= tr.selectPhase(node1[1]);
		 actual[25]=req.VerifyRequirementCount();
			
		String sys2=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 2, 3);
		actual[26]=tr.selectPhase(sys2);
		actual[27]=req.VerifyRequirementCount();
				
				String sys3=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 3, 3);
				actual[28]=tr.selectPhase(sys3);
				actual[29]=req.VerifyRequirementCount();
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

	 @When("^navigate to second parent and child nodes and add two requirements to all the nodes with fields priority,altId,Link and req details$")
	 public void navigate_to_second_parent_and_child_nodes_and_add_two_requirements_to_all_the_nodes_with_fields_priority_altId_Link_and_req_details() throws Throwable {
		try
		{
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		 String[] node1=new String[2];
		 node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 4, 1);
		 node1[1]=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 4, 3);
		 actual[30]=tr.navigateToNode(releaseName, node1);
		 
		 req=new RequirementsPage(driver);
		 actual[31]= tr.selectPhase(node1[0]);
		 
		 
		 actual[32]= req.addRequirement();
		 tr.clickOnDetails();
		 
		String[] reqDetails1=new String[5];
		reqDetails1[0]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 5, 1);
		reqDetails1[1]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 5, 2);
		reqDetails1[2]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 5, 3);
		reqDetails1[3]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 5, 4);
		reqDetails1[4]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 5, 5);
		
		actual[33]=req.enterRequirementDetails(reqDetails1[0], reqDetails1[1], reqDetails1[2], reqDetails1[3], reqDetails1[4]);
		actual[34]=req.addRequirement();
		actual[35]=req.enterRequirementDetails(reqDetails1[0], reqDetails1[1], reqDetails1[2], reqDetails1[3], reqDetails1[4]);
		tr.clickOnList();
		actual[36]=tr.selectPhase(node1[1]);
		 
		 
		actual[37]=req.addRequirement();
		tr.clickOnDetails();
		String[] reqDetails2=new String[5];
		reqDetails2[0]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 6, 1);
		reqDetails2[1]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 6, 2);
		reqDetails2[2]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 6, 3);
		reqDetails2[3]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 6, 4);
		reqDetails2[4]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 6, 5);
		
		actual[38]=req.enterRequirementDetails(reqDetails2[0], reqDetails2[1], reqDetails2[2], reqDetails2[3], reqDetails2[4]);
		actual[39]=req.addRequirement();
		actual[40]=req.enterRequirementDetails(reqDetails2[0], reqDetails2[1], reqDetails2[2], reqDetails2[3], reqDetails2[4]);
	    String sys2=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 5, 3);
	    tr.clickOnList();
	    actual[0]=tr.selectPhase(sys2);
		 
		 
	    actual[41]=req.addRequirement();
	    tr.clickOnDetails();
			String[] reqDetails3=new String[5];
			reqDetails3[0]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 7, 1);
			reqDetails3[1]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 7, 2);
			reqDetails3[2]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 7, 3);
			reqDetails3[3]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 7, 4);
			reqDetails3[4]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 7, 5);
			
			actual[42]=req.enterRequirementDetails(reqDetails3[0], reqDetails3[1], reqDetails3[2], reqDetails3[3], reqDetails3[4]);
			actual[43]=req.addRequirement();
			actual[44]=req.enterRequirementDetails(reqDetails3[0], reqDetails3[1], reqDetails3[2], reqDetails3[3], reqDetails3[4]);
		    
		    String sys3=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 6, 3);
		    tr.clickOnList();
		    actual[45]=tr.selectPhase(sys3);
			 
			 
		    actual[46]=req.addRequirement();
		    tr.clickOnDetails();
				String[] reqDetails4=new String[5];
				reqDetails4[0]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 8, 1);
				reqDetails4[1]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 8, 2);
				reqDetails4[2]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails",8, 3);
				reqDetails4[3]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 8, 4);
				reqDetails4[4]=Excel_Lib.getData(INPUT_PATH_2,"ReqDetails", 8, 5);
				
				actual[47]=req.enterRequirementDetails(reqDetails4[0], reqDetails4[1], reqDetails4[2], reqDetails4[3], reqDetails4[4]);
				actual[48]=req.addRequirement();
				actual[49]=req.enterRequirementDetails(reqDetails4[0], reqDetails4[1], reqDetails4[2], reqDetails4[3], reqDetails4[4]);
				tr.clickOnList();
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

	 @Then("^requirements added in all the second nodes$")
	 public void requirements_added_in_all_the_second_nodes() throws Throwable {
 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		 
 try
 {
		 String[] node1=new String[2];
		 node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Requirement", 4, 1);
		 node1[1]=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 4, 3);
		 actual[50]=tr.navigateToNode(releaseName, node1);
		 
		 actual[51]=tr.selectPhase(node1[0]);
		 actual[52]=req.VerifyRequirementCount();
		
		 actual[53]=tr.selectPhase(node1[1]);
		 actual[54]=req.VerifyRequirementCount();
			
		String sys2=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 5, 3);
		actual[55]=tr.selectPhase(sys2);
		actual[56]=req.VerifyRequirementCount();
				
				String sys3=Excel_Lib.getData(INPUT_PATH_2,"Requirement", 6, 3);
				actual[57]=tr.selectPhase(sys3);
				actual[58]=req.VerifyRequirementCount();
				
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
