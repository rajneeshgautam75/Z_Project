package com.zephyr_batch_4.stepdefinition;


import org.testng.asserts.SoftAssert;
import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Execution_Backlog_36 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	boolean[] actual=new boolean[12];
	SoftAssert soft=new SoftAssert();
    String fileName="Execution_Backlog_36";
	@Given("^DashBoard Page is opened by User$")
	public void dashboard_Page_is_opened_by_User() throws Throwable {
		try
		{
		pp=new ProjectPage(driver);
		dp=new DashBoardPage(driver);
		bp=new BasePage();
		actual[0]=bp.waitForElement();
		actual[1]=dp.clickOnManageDashboards();
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

	@When("^user will add a new dashboard and selects$")
	public void user_will_add_a_new_dashboard_and_selects() throws Throwable {
		try
		{
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 7, 2);
			   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
			   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
			   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
			   actual[2]=bp.waitForElement();
			   actual[3]=dp.clickOnAddDashBoardSymbol();
			   actual[4]=dp.enterDashBoardDetails(name, description, layout, shareType);
			   actual[5]=dp.selectDashboard(name);
			   bp.waitForElement();
			   actual[6]=dp.validateDashBoard(name);
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

	@When("^user adds multiple two or four or eight Executions Backlog Gadget with same project but different releases in same dashabord$")
	public void user_adds_multiple_two_or_four_or_eight_Executions_Backlog_Gadget_with_same_project_but_different_releases_in_same_dashabord() throws Throwable {
		 try
		    {
			    String release[]=new String[10];
			    release[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
			    release[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_2");
			    release[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_3");
			    release[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			    release[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
			    release[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_6");
			    release[6]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_7");
			    release[7]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_8");
			    release[8]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_9");
			    release[9]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_10");
		    	String filterByName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 9, 2);
		    	String values[]=new String[1];
		    	values[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
		    	String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 6);
		    	String projectName_1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		    	String refreshrate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 7);
				bp.waitForElement();
				for(int i=0;i<=2;i++)
				{
				actual[7]=dp.clickOnAddGadgetSymbol();
				bp.waitForElement();
				actual[8]=dp.addGadget(gadget);
				bp.waitForElement();
				dp.validateGadget(gadget);
				bp.waitForElement();
				actual[9]=dp.configureTraceabilityGadget(projectName_1, release[i], refreshrate);
				bp.waitForElement();
				bp.waitForElement();
				actual[10]=dp.filterBy(filterByName, values);
				bp.waitForElement();
				dp.saveTraceabilityGadget();
				}
				
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

	@Then("^To be Able to add Multiple executions backlog Gadget with Same project but different releases in same DashBoard$")
	public void to_be_Able_to_add_Multiple_executions_backlog_Gadget_with_Same_project_but_different_releases_in_same_DashBoard() throws Throwable {
		try
	    {
			String projectName_1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		    String release[]=new String[10];
		    release[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		    release[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_2");
		    release[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_3");
		    release[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
		    release[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
		    release[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_6");
		    release[6]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_7");
		    release[7]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_8");
		    release[8]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_9");
		    release[9]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_10");
		    for(int i=0;i<=2;i++)
		    {
			actual[11]=dp.validateSavedGadget(projectName_1, release[i]);
		    }
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
