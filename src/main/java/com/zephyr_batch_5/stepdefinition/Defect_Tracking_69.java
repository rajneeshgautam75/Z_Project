package com.zephyr_batch_5.stepdefinition;

import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_69 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ReleasePage rp;
    BasePage bp;
	DashBoardPage dp;
	ProjectPage pp;
	boolean[] actual=new boolean[23];
	SoftAssert soft=new SoftAssert();
	String filename="Defect_Tracking_69";

	
	@Given("^Manager is in a administration page$")
	public void manager_is_in_a_administration_page() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			bp=new BasePage();
			lp=new LoginPage(driver);
			rp= new ReleasePage(driver);
			bp.waitForElement();
			String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
		     String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
		     actual[0]=pp.clickOnLogout();
		     bp.waitForElement();
		     actual[1]=lp.enterUnameAndPassword(name, passWord);
		     bp.waitForElement();
		     actual[2]=pp.launchAdministration();
		     bp.waitForElement();
		     
		     
		}
		   catch(Exception e)
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e; 	 
			}  
	  
	}

	@When("^manager clicks on Project SetUp button$")
	public void manager_clicks_on_Project_SetUp_button() throws Throwable {
		try
		{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			actual[3]=pp.launchManageprojects();
			bp.waitForElement();
			actual[4]=pp.selectProjectInProjectSetup(projectName);
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	}

	@When("^map the jira project to ZE$")
	public void map_the_jira_project_to_ZE() throws Throwable {
		try
		{
			 String mapDefectProject=Excel_Lib.getData(INPUT_PATH_8, "Jira", 1, 6);
			Select sel2=new Select(pp.defectProject);
			   sel2.selectByVisibleText(mapDefectProject);
			   bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	 
	}

	@When("^manager will logout from application$")
	public void manager_will_logout_from_application() throws Throwable {
		try
		{
			  actual[5]=pp.clickOnLogout();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
		
	   
	}

	@When("^User will login with lead credentails$")
	public void user_will_login_with_lead_credentails() throws Throwable {
		try
		{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
			String pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
			actual[6]=lp.enterUnameAndPassword(uname, pass);
			bp.waitForElement();
			bp.waitForElement();
			actual[7]=pp.selectProject(projectName);
		    bp.waitForElement();
			actual[8]=pp.selectRelease(releaseName);
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	   
	}

	@When("^user will click on dashboard button$")
	public void user_will_click_on_dashboard_button() throws Throwable {
		try
		{
			 dp=new DashBoardPage(driver);
				actual[9]=dp.clickOnManageDashboards();
				bp.waitForElement(); 
			
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	   
	}

	@Then("^user must comes to dashboard page successfully$")
	public void user_must_comes_to_dashboard_page_successfully() throws Throwable {
		try
		{
			actual[10]=dp.validateDashboards();
			bp.waitForElement(); 
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	   
	}

	@When("^user clicks on add dashboard button and fill the details$")
	public void user_clicks_on_add_dashboard_button_and_fill_the_details() throws Throwable {
		try
		{
			String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 5, 5);
	    	 String description=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 2);
	    	 String layout=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 4);
	    	 String shareType=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 3);
			actual[11]=dp.clickOnAddDashBoardSymbol();
			bp.waitForElement();
	    	 actual[12]=dp.enterDashBoardDetails(dashboard, description, layout, shareType);
	    	 bp.waitForElement(); 
	    	 bp.waitForElement(); 
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	 
	}

	@Then("^dashboard created successfully$")
	public void dashboard_created_successfully() throws Throwable {
		try
		{
			String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 5, 5);
			actual[13]=dp.validateDashBoard(dashboard);
			bp.waitForElement(); 
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	   
	}

	@When("^user cliks on add gadget symbol$")
	public void user_cliks_on_add_gadget_symbol() throws Throwable {
		try
		{
			String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 5, 5);
			actual[14]=dp.selectDashboard(dashboard);
			bp.waitForElement(); 
			
			actual[15]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement(); 
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	    
	}

	@When("^adds Daily pulse gadget$")
	public void adds_Daily_pulse_gadget() throws Throwable {
		try
		{
			String gadgetName=Excel_Lib.getData(INPUT_PATH_8, "AddDashboard", 5, 5);
			actual[16]=dp.addGadget(gadgetName);
			bp.waitForElement(); 
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	  
	}

	@Then("^Daily pulse gadget must be added successfully$")
	public void daily_pulse_gadget_must_be_added_successfully() throws Throwable {
		try
		{
			String gadgetName=Excel_Lib.getData(INPUT_PATH_8, "AddDashboard", 5, 5);
			actual[17]=dp.validateGadget(gadgetName);
			bp.waitForElement(); 
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}   
		
	 
	}

	@When("^user will fill all the details and click on save button$")
	public void user_will_fill_all_the_details_and_click_on_save_button() throws Throwable {
		try
		{
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			String refreshRate=Excel_Lib.getData(INPUT_PATH_8, "Gadget", 100, 100);
			String timeFrameValue=Excel_Lib.getData(INPUT_PATH_8, "Gadget", 1, 3);

			actual[18]=dp.configureTraceabilityGadget(project, release, refreshRate);
			bp.waitForElement();
			actual[19]=dp.enterTimeFrame(timeFrameValue);
			bp.waitForElement();
			actual[20]=dp.saveGadget();
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}   
	  
	}

	@Then("^user must view the total defect count in mapped JIRA project$")
	public void user_must_view_the_total_defect_count_in_mapped_JIRA_project() throws Throwable {
		try
		{
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			actual[21]=dp.validateSavedGadget(project);
			bp.waitForElement(); 
			String count=dp.Dailypulse.getText();
			System.out.println(count);
			actual[22]=pp.backToProjectPage();
			bp.waitForElement(); 
			for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}   
	    
	}


}
