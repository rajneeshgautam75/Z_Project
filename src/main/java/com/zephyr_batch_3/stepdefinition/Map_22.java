package com.zephyr_batch_3.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Map_22 extends LaunchBrowser{
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	TestPlanningPage tp;
	ExecutionPage exep;
	String fileName="Map_22";
	
	boolean[] actual=new boolean[11];
	 SoftAssert soft=new SoftAssert();

	@Given("^As a Manager create a node in requirements page$")
	public void as_a_Manager_create_a_node_in_requirements_page() throws Throwable {
	   try
	   {
		   bp=new BasePage();
	    	pp=new ProjectPage(driver);
	    	bp.waitForElement();
	    	pp.clickOnLogout();
	    	bp.waitForElement();
	    	tp=new TestPlanningPage(driver);
	    	exep=new ExecutionPage(driver);
		   
		   lp=new LoginPage(driver);
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Lead_Username_1");
			   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Lead_Password_1");
			   
			   lp.enterUname(Uname);
			   lp.enterPass(Pass);
			   lp.clickOnLogin();
			   
			   pp=new ProjectPage(driver);
			   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Normal_Project_1");
		    	 bp.waitForElement();
		    	 actual[0]=pp.selectProject(projectName);
		    	 actual[1]=pp.selectRelease(releaseName);
				
				bp.waitForElement();
				rp= new ReleasePage(driver);
			    actual[2]=rp.clickOnRequirements();
			    bp.waitForElement();

			    
			    String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 0);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 1);
				
				
				req=new RequirementsPage(driver);
			    actual[3]=req.doubleClickOnRelease(releaseName);
				
				
				req.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
				String[] phase=new String[1];
				phase[0]=p_Name1;
				tr=new TestRepositoryPage(driver);
				//actual[4]=tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
				actual[4]=tr.navigateToNode(releaseName, phase);
				
	   }
	   catch(Exception e)
		{
	    	lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
	    	e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		} 
	}

	@Given("^create few requirements under the created node and logout the from application$")
	public void create_few_requirements_under_the_created_node_and_logout_the_from_application() throws Throwable {
	    try
	    {
	    	bp=new BasePage();
	    	pp=new ProjectPage(driver);
	    	req.addRequirement();
			req.addRequirement();
			
			bp.waitForElement();
			actual[5]=pp.clickOnLogout();
	    }
	    catch(Exception e)
		{
	    	lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
	    	e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		} 
	}

	@When("^As a Lead,navigate to the manager created node and update the requirement details$")
	public void as_a_Lead_navigate_to_the_manager_created_node_and_update_the_requirement_details() throws Throwable {
	    try
	    {
	    	/*bp=new BasePage();
	    	pp=new ProjectPage(driver);
	    	bp.waitForElement();
	    	pp.clickOnLogout();
	    	bp.waitForElement();
	    	req=new RequirementsPage(driver);
	    	tp=new TestPlanningPage(driver);
	    	exep=new ExecutionPage(driver);*/
	    	
	    	lp=new LoginPage(driver);
			
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Lead_Username_2");
			   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Lead_Password_2");
			   
			   lp.enterUname(Uname);
			   lp.enterPass(Pass);
			   lp.clickOnLogin();
			   
			   pp=new ProjectPage(driver);
			   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Normal_Project_1");
		    	 bp.waitForElement();
		    	 actual[6]=pp.selectProject(projectName);
		    	 actual[7]=pp.selectRelease(releaseName);
				
				bp.waitForElement();
				rp= new ReleasePage(driver);
				tr=new TestRepositoryPage(driver);
			    actual[8]=rp.clickOnRequirements();
			    bp.waitForElement();
			    String[] navigation=new String[1];
			    navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 0);
			    actual[9]=tr.navigateToNode(releaseName, navigation);
	    }
	    catch(Exception e)
		{
	    	lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
	    	e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		} 
	}

	@Then("^able to edit the other user created requirements$")
	public void able_to_edit_the_other_user_created_requirements() throws Throwable {
	    try
	    {
	    	
	    	String name=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
	    	String altID=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
	    	String link=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
	    	String priority=Excel_Lib.getData(INPUT_PATH_3,"FreeForm",1,20);
	    	String Description=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
	    	tr.clickDetailButton();
	    	actual[10]=req.enterRequirementDetails(name, altID, link, priority, Description);
	    	
	    	
	    	tr.clickOnList();
	    	for(int k=0;k<=actual.length-1;k++)
		     {
			  System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();

		log.info("able to edit the other user created requirements");
	    }
	    catch(Exception e)
		{
	    	lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
	    	e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		} 

	}


}
