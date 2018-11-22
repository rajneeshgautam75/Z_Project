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

public class ReqTraceability_28 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	ReleasePage rp;
	RequirementsPage req;
	TestRepositoryPage tr;
	boolean[] actual=new boolean[30];
	SoftAssert soft=new SoftAssert();
    String fileName="ReqTraceability_28";
	@Given("^User is In a requirements page$")
	
	public void user_is_In_a_requirements_page() throws Throwable {
		try
		{
			   bp=new BasePage();
			   pp=new ProjectPage(driver);
			   rp= new ReleasePage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
			   actual[0]=pp.selectProject(projectName);
			   actual[1]=pp.selectRelease(releaseName);	   
			   bp.waitForElement();
			   actual[2]=rp.clickOnRequirements();
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

	@When("^user adds the node and adds the requirements$")
	public void user_adds_the_node_and_adds_the_requirements() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);
			req=new RequirementsPage(driver);
			String fileName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
			actual[3]=tr.clickOnRelease(fileName);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"Requirements",1,1);
	    	String desc=Excel_Lib.getData(INPUT_PATH_7,"Requirements",1,2);
	    	actual[4]=req.addNode(name, desc);
			String navigation[]=new String[1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"Requirements",1,1);
			actual[5]=tr.navigateToNode(fileName, navigation);
			bp.waitForElement();
			req.addRequirement();
		
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

	@When("^user enters the requirements Name,altId,link,priority$")
	public void user_enters_the_requirements_Name_altId_link_priority() throws Throwable {
		try{
			
			String name=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 1, 5);
			String altId=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 6, 4);
			String link=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 1, 9);
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 4, 4);
			String Description=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 1, 6);
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
		    actual[6]=req.enterRequirementDetails(name, altId, link, priority, Description);    
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

	@When("^user clicks on ManageDashBoard and Adds a New DashBoard$")
	public void user_clicks_on_ManageDashBoard_and_Adds_a_New_DashBoard() throws Throwable {
		try
		{
			dp=new DashBoardPage(driver);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 19, 1);
		    String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
			String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
			String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
			bp.waitForElement();
			actual[7]=dp.clickOnManageDashboards();
			bp.waitForElement();
		    actual[8]=dp.clickOnAddDashBoardSymbol();
		    actual[9]=dp.enterDashBoardDetails(name, description, layout, shareType);
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

	@When("^DashBoard is added, user selects added Dashboard and adds Traceability Report Gadget$")
	public void dashboard_is_added_user_selects_added_Dashboard_and_adds_Traceability_Report_Gadget() throws Throwable {
		 try
		    {
		    	String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 19, 1);
				String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
				actual[10]=dp.selectDashboard(name);
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

	@When("^user Searches requirement by name in quick search$")
	public void user_Searches_requirement_by_name_in_quick_search() throws Throwable {
		try
		{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
			String refreshrate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 7);
			String searchOption=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 1, 5);
			actual[13]=dp.configureTraceabilityGadget(projectName, release, refreshrate);
			bp.waitForElement();
			actual[14]=dp.manageTraceability();
			driver.navigate().refresh();
			bp.waitForElement();
			bp.waitForElement();
			dp.configureTraceabilityGadget(projectName, release, refreshrate);
			dp.manageTraceability();
			actual[15]=dp.traceabilityQuickSearch(searchOption);
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

	@Then("^user Should be able to search requirement$")
	public void user_Should_be_able_to_search_requirement() throws Throwable {
		try
	    {
			 String searchOption=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 1, 5);
	    	 actual[16]=dp.validateRequirements(searchOption);
	    	 bp.waitForElement();
	    	 actual[17]=dp.closeTraceabilityTable();

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

	@When("^user Searches requirement by priority in quick search$")
	public void user_Searches_requirement_by_priority_in_quick_search() throws Throwable {
		try
	    {
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
			String refreshrate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 7);
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 4, 4);
			actual[18]=dp.configureTraceabilityGadget(projectName, release, refreshrate);
			bp.waitForElement();
			actual[19]=dp.manageTraceability();
			driver.navigate().refresh();
			bp.waitForElement();
			bp.waitForElement();
			actual[20]=dp.configureTraceabilityGadget(projectName, release, refreshrate);
			actual[21]=dp.manageTraceability();
			actual[22]=dp.traceabilityQuickSearch(priority);
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

	@Then("^Should be able to search requirement of priority$")
	public void should_be_able_to_search_requirement_of_priority() throws Throwable {
		 
		       try{
			     String priority=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 4, 4);
			     bp.waitForElement();
		    	 actual[23]=dp.validateRequirements(priority);
			     bp.waitForElement();
			     actual[24]=dp.closeTraceabilityTable();

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
	  
	

	@When("^user searches Requirement by altid in quick search$")
	public void user_searches_Requirement_by_altid_in_quick_search() throws Throwable {
		try
	    {
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
			String refreshrate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 7);
			String altId=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 6, 4);
			bp.waitForElement();
			actual[25]=dp.configureTraceabilityGadget(projectName, release, refreshrate);
			bp.waitForElement();
			actual[26]=dp.manageTraceability();
			driver.navigate().refresh();
			bp.waitForElement();
			bp.waitForElement();
			dp.configureTraceabilityGadget(projectName, release, refreshrate);
			dp.manageTraceability();
			bp.waitForElement();
			actual[27]=dp.traceabilityQuickSearch(altId);
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

	@Then("^should be able to search Requirement$")
	public void should_be_able_to_search_Requirement() throws Throwable {
		try{
			
			
			 String altId=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 6, 4);
	    	 actual[28]=dp.validateRequirements(altId);
	    	 bp.waitForElement();
	    	 actual[29]=dp.closeTraceabilityTable();
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
