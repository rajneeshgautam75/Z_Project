package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReqTraceability_24 extends LaunchBrowser{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	ReleasePage rp;
	RequirementsPage req;
	TestRepositoryPage tr;
	boolean[] actual=new boolean[32];
	SoftAssert soft=new SoftAssert();
    String fileName="ReqTraceability_24";
	@Given("^user is in a DashBoard Window$")
	public void user_is_in_a_DashBoard_Window() throws Throwable {
		try
		{
			   bp=new BasePage();
			   pp=new ProjectPage(driver);
			   rp= new ReleasePage(driver);
			   tr=new TestRepositoryPage(driver);
			   req=new RequirementsPage(driver);
			   dp=new DashBoardPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
			   String rname=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 6, 5);
			   String altId=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 6, 4);
			   String link=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 2, 9);
			   String priority=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 4, 4);
			   String Description=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 1, 6);
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"Requirements",6,1);
		       String desc=Excel_Lib.getData(INPUT_PATH_7,"Requirements",6,2);
		       String navigation[]=new String[1];
			   navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"Requirements",6,1);
			   actual[0]=pp.selectProject(projectName);
			   actual[1]=pp.selectRelease(releaseName);	   
			   bp.waitForElement();
			   actual[2]=rp.clickOnRequirements();
			   actual[3]=tr.clickOnRelease(releaseName);
		       actual[4]=req.addNode(name, desc);
			   actual[5]=tr.navigateToNode(releaseName, navigation);
			   bp.waitForElement();
			   req.addRequirement();
			   bp.waitForElement();
			   tr.clickOnDetails();
			   bp.waitForElement();
			   actual[6]=req.enterRequirementDetails(rname, altId, link, priority, Description);   
			   bp.waitForElement();
			   bp.waitForElement();
			   tr.clickOnList();
			   bp.waitForElement();
			   
			   
			   String projectName2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
			   actual[0]=pp.selectProject(projectName2);
			   actual[1]=pp.selectRelease(releaseName);	   
			   bp.waitForElement();
			   actual[2]=rp.clickOnRequirements();
			   actual[3]=tr.clickOnRelease(releaseName);
		       actual[4]=req.addNode(name, desc);
			   actual[5]=tr.navigateToNode(releaseName, navigation);
			   bp.waitForElement();
			   req.addRequirement();
			   bp.waitForElement();
			   tr.clickOnDetails();
			   bp.waitForElement();
			   String rname1=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 1, 5);
			   actual[6]=req.enterRequirementDetails(rname1, altId, link, priority, Description);   
			   bp.waitForElement();
			   bp.waitForElement();
			   tr.clickOnList();
			   
			   
			   
			   actual[7]=dp.clickOnManageDashboards();
			   
				
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

	@When("^user adds a new dashboard and selects that added dashboard$")
	public void user_adds_a_new_dashboard_and_selects_that_added_dashboard() throws Throwable {
		try
		{
			String dname=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 22, 1);
		    String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
			String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
			String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
			bp.waitForElement();
		    actual[8]=dp.clickOnAddDashBoardSymbol();
		    actual[9]=dp.enterDashBoardDetails(dname, description, layout, shareType);
		    bp.waitForElement();
			actual[10]=dp.selectDashboard(dname);
			
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

	@When("^user adds traceability report for added gadget$")
	public void user_adds_traceability_report_for_added_gadget() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
			bp.waitForElement();
			actual[11]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[12]=dp.addGadget(gadget);
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

	@When("^Gadget and select different release or requirements within same project and save the gadget$")
	public void gadget_and_select_different_release_or_requirements_within_same_project_and_save_the_gadget() throws Throwable {
		try
		{
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
			   String refreshrate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 7);
			   String searchOption=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 6, 5);
			   actual[13]=dp.configureTraceabilityGadget(projectName, releaseName, refreshrate);
			   bp.waitForElement();
			   actual[14]=dp.manageTraceability();
			   driver.navigate().refresh();
			   bp.waitForElement();
			   bp.waitForElement();
			   dp.configureTraceabilityGadget(projectName, releaseName, refreshrate);
			   bp.waitForElement();
			   dp.manageTraceability();
			   bp.waitForElement();
			   actual[15]=dp.traceabilityQuickSearch(searchOption);
		       actual[16]=req.selectAllRequirements();
		       bp.waitForElement();
		       actual[17]=dp.closeTraceabilityTable();
		       actual[18]=dp.saveTraceabilityGadget();
			
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

	@Then("^should able to reconfigure gadget$")
	public void should_able_to_reconfigure_gadget() throws Throwable {
		try
	    {
			String configure=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 7, 8);
			bp.waitForElement();
			driver.navigate().refresh();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[19]=dp.gadgetOperation(configure);
			 
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

	@When("^user edits Traceability Report Gadget and attempt to save without selecting release$")
	public void user_edits_Traceability_Report_Gadget_and_attempt_to_save_without_selecting_release() throws Throwable {
		try
		{
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
			   String refreshrate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
				bp.waitForElement();
				bp.waitForElement();
				bp.waitForElement();
				bp.waitForElement();
				bp.waitForElement();
				bp.waitForElement();
				bp.waitForElement();
				bp.waitForElement();
				bp.waitForElement();
				bp.waitForElement();
				bp.waitForElement();
			    actual[20]=dp.configureTraceabilityGadget(projectName, releaseName, refreshrate);
	
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

	@When("^user Edits Traceability Report Gadget and attempt to select the hidden release in same project$")
	public void user_Edits_Traceability_Report_Gadget_and_attempt_to_select_the_hidden_release_in_same_project() throws Throwable {
		try
		{  
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
//			String releaseName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
//			String refreshrate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
			bp.waitForElement();
			actual[21]=dp.checkProject(projectName);
			
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

	@Then("^Should not be able to view or select hidden release$")
	public void should_not_be_able_to_view_or_select_hidden_release() throws Throwable {
	    try
	    {
	    	bp.waitForElement();
			dp.selectRelease.click();
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

	@When("^user edits Traceability Report gadget and select different project,release and requirements and save the gadget$")
	public void user_edits_Traceability_Report_gadget_and_select_different_project_release_and_requirements_and_save_the_gadget() throws Throwable {
	   try
	   {
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		   String refreshrate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 7);
		   String name=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 1, 5);
		   String configure=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 7, 8);
		   bp.waitForElement();
		   actual[22]=dp.configureTraceabilityGadget(projectName, releaseName, refreshrate);
		   bp.waitForElement();
		   actual[23]=dp.manageTraceability();
		   driver.navigate().refresh();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
//		   bp.waitForElement();
//		   bp.waitForElement();
		   actual[24]=dp.gadgetOperation(configure);
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[25]=dp.configureTraceabilityGadget(projectName, releaseName, refreshrate);
		   actual[26]=dp.manageTraceability();
		   actual[27]=dp.traceabilityQuickSearch(name);
	       actual[28]=req.selectAllRequirements();
	       bp.waitForElement();
	       actual[29]=dp.closeTraceabilityTable();
	       actual[30]=dp.saveTraceabilityGadget();
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

	@Then("^To be able to reconfigure gadget$")
	public void to_be_able_to_reconfigure_gadget() throws Throwable {
		try
	    {
			String configure=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 7, 8);
			driver.navigate().refresh();
			bp.waitForElement();
			bp.waitForElement();
			actual[31]=dp.gadgetOperation(configure);
			bp.waitForElement();
			   bp.waitForElement();
			   bp.waitForElement();
			   bp.waitForElement();
			   bp.waitForElement();
			   bp.waitForElement();
			   bp.waitForElement();
			   bp.waitForElement();
             pp.backToProjectPage();
			for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		     }
			 soft.assertAll();
			 
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
