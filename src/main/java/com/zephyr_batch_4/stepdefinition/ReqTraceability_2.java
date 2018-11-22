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

public class ReqTraceability_2 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	ReleasePage rp;
	RequirementsPage req;
	TestRepositoryPage tr;
	boolean[] actual=new boolean[58];
	SoftAssert soft=new SoftAssert();
    String fileName="ReqTraceability_2";
	@Given("^user is in a dashboard Window$")
	public void user_is_in_a_dashboard_Window() throws Throwable {
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

	@When("^user adds a New DashBoard$")
	public void user_adds_a_New_DashBoard() throws Throwable {
		 try
		   {
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 15, 1);
			   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
			   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
			   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
		       bp.waitForElement();
		       actual[2]=dp.clickOnAddDashBoardSymbol();
		       actual[3]=dp.enterDashBoardDetails(name, description, layout, shareType);
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

	@Then("^New Dashboard should be added$")
	public void new_Dashboard_should_be_added() throws Throwable {
		try
		  {
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 15, 1);
			actual[4]=dp.validateDashBoard(name);
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

	@When("^user selects added dashboard and adds traceability report gadget by clicking plus button$")
	public void user_selects_added_dashboard_and_adds_traceability_report_gadget_by_clicking_plus_button() throws Throwable {
		try
		{
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 15, 1);
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
			actual[5]=dp.selectDashboard(name);
			bp.waitForElement();
			actual[6]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[7]=dp.addGadget(gadget);
			
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

	@Then("^user should able to add gadget$")
	public void user_should_able_to_add_gadget() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
			actual[8]=dp.validateGadget(gadget);
			
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

	@When("^user adds traceability report gadget Project not assinged to current user$")
	public void user_adds_traceability_report_gadget_Project_not_assinged_to_current_user() throws Throwable {
		try
		{
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
			String release=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
			String refreshRate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
			bp.waitForElement();
			actual[9]=dp.configureTraceabilityGadget(project, release, refreshRate);
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

	@When("^user attempts to add Traceability Report Gadget for Project and hidden release$")
	public void user_attempts_to_add_Traceability_Report_Gadget_for_Project_and_hidden_release() throws Throwable {
		try
		{
			rp=new ReleasePage(driver);
//			String release=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 4,9);
//			String desc=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 14);
//			String hide=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 8);
//			String mapexternalDefect=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 21);
//			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 3, 13));
//			String smonth=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 12);
//			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard",20,11));
//			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 4, 13));
//			String emonth=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 12);
//			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 10, 11));
		//	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 16, 1);
			String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
			String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
			String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
			actual[10]=bp.waitForElement();
			pp.navigateToProjectPage();
			bp.waitForElement();
			pp.selectProject(project);
	        pp.clickOnManageRelease();
	        
			String release=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 4,9);
			boolean res=rp.checkAvailableRelease(release);
		if(res==false)
		{
			String desc=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 14);
			String hide=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 8);
			String mapexternalDefect=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 21);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 3, 13));
			String smonth=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 12);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard",20,11));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 4, 13));
			String emonth=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 12);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 10, 11));
		    
	        bp.waitForElement();
	        rp.addNewRelease(release, desc, hide, mapexternalDefect);
	        bp.waitForElement();
	        rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
		    rp.clickOnAdd();
		}    
		
		    actual[11]=dp.clickOnManageDashboards();
		    actual[12]=dp.clickOnAddDashBoardSymbol();
		    bp.waitForElement();
		    actual[13]=dp.enterDashBoardDetails(name, description, layout, shareType);
		    bp.waitForElement();
		    actual[14]=dp.selectDashboard(name);
		    actual[15]=dp.clickOnAddGadgetSymbol();
		    bp.waitForElement();
		    actual[16]=dp.addGadget(gadget);
		 
	
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

	@Then("^hidden release should not be shown in the dropdown$")
	public void hidden_release_should_not_be_shown_in_the_dropdown() throws Throwable {
		try
		{
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
			bp.waitForElement();
			actual[17]=dp.checkProject(project);
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

	@When("^user try to add Traceability Report Gadget for Project the is deleted$")
	public void user_try_to_add_Traceability_Report_Gadget_for_Project_the_is_deleted() throws Throwable {
		try
		{
			bp.waitForElement();
			pp.clickOnLogout();
			lp=new LoginPage(driver);
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Password_1");
			String project=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 8);
			String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 6, 8);
			String typeName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 4, 8);
			String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
			String mapDefectProject=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
			String[] startDate=new String[3];
			startDate[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 13, 13));
			startDate[1]=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 10, 12);
			startDate[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 12, 11));
			String[] endDate=new String[1];
			endDate[0]=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
			String shareCheckbox=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
			bp.waitForElement();
			actual[18]=lp.enterUname(uname);
			actual[19]=lp.enterPass(password);
			System.out.println("UserName is"+uname);
			System.out.println("Password is"+password);        
			actual[20]=lp.clickOnLogin();  
			bp.waitForElement(); 
			actual[21]=pp.launchAdministration();
			bp.waitForElement();
			actual[22]=pp.launchManageprojects();
			bp.waitForElement();
			actual[23]=pp.createProject(project, description, typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
			bp.waitForElement();
			bp.waitForElement();
			actual[24]=pp.DeleteProject(project);
			bp.waitForElement();
			actual[25]=pp.clickOnLogout();
			
			
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

	@Then("^Deleted project should not be seen in the dropdown$")
	public void deleted_project_should_not_be_seen_in_the_dropdown() throws Throwable {
		try
		{
		String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_1");
		String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_1");
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 15, 1);
		String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
		String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
		String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
		String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
		bp.waitForElement();
		actual[26]=lp.enterUname(uname);
		actual[27]=lp.enterPass(password);
		System.out.println("UserName is"+uname);
		System.out.println("Password is"+password);
		actual[28]=lp.clickOnLogin();
		bp.waitForElement();
		actual[29]=dp.clickOnManageDashboards();
	    bp.waitForElement();
	    actual[30]=dp.clickOnAddDashBoardSymbol();
	    actual[31]=dp.enterDashBoardDetails(name, description, layout, shareType);
	    bp.waitForElement();
	    actual[32]=dp.selectDashboard(name);
	    bp.waitForElement();
	    actual[33]=dp.clickOnAddGadgetSymbol();
	    actual[34]=dp.addGadget(gadget);
	    bp.waitForElement();
	    dp.selectProject.click();
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

	@When("^user Attempts to add Traceability Report Gadget for Release having no requirements$")
	public void user_Attempts_to_add_Traceability_Report_Gadget_for_Release_having_no_requirements() throws Throwable {
		try
		{
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
//			String release=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 4,9);
//			String desc=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 14);
//			String hide=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
//			String mapexternalDefect=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 21);
//			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 3, 13));
//			String smonth=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 12);
//			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard",20,11));
//			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 4, 13));
//			String emonth=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 12);
//			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 10, 11));
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 15, 1);
			String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
			String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
			String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
			pp.navigateToProjectPage();
			bp.waitForElement();
			actual[35]=pp.selectProject(project);
			bp.waitForElement();
			pp.clickOnManageRelease();
			 
			String release=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5,9);
			boolean res=rp.checkAvailableRelease(release);
		if(res==false)
		{
			
			String desc=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 14);
			String hide=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
			String mapexternalDefect=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 21);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 3, 13));
			String smonth=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 12);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard",20,11));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 4, 13));
			String emonth=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 12);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"AddDashboard", 10, 11));
		    
			bp.waitForElement();
			rp.addNewRelease(release, desc, hide, mapexternalDefect);
			rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
		    rp.clickOnAdd();
		}    
		    actual[36]=rp.checkAvailableRelease(release);
		    String project1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		    pp.selectProject(project1);
		    bp.waitForElement();
		    actual[37]=pp.selectProject(project);
		    bp.waitForElement();
		    
		    actual[38]=pp.selectRelease(release);
		    bp.waitForElement();
		    actual[39]=dp.clickOnManageDashboards();
		    actual[40]=dp.clickOnAddDashBoardSymbol();
		    bp.waitForElement();
		    actual[41]=dp.enterDashBoardDetails(name, description, layout, shareType);
		    bp.waitForElement();
		    actual[42]=dp.selectDashboard(name);
		    bp.waitForElement();
		    actual[43]=dp.clickOnAddGadgetSymbol();
		    bp.waitForElement();
		    actual[44]=dp.addGadget(gadget);
			
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

	@Then("^Save button should not be enabled without any requirement$")
	public void save_button_should_not_be_enabled_without_any_requirement() throws Throwable {
		try
		{
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
			String release=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5,9);
			String refreshRate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 7);
			bp.waitForElement();
			actual[45]=dp.configureTraceabilityGadget(project, release, refreshRate);
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

	@When("^user attempts to add Traceability Report Gadget for Project and Release if requirements are added only at Global level$")
	public void user_attempts_to_add_Traceability_Report_Gadget_for_Project_and_Release_if_requirements_are_added_only_at_Global_level() throws Throwable {
	  try
	  {
		  rp= new ReleasePage(driver);
		  tr=new TestRepositoryPage(driver);
		  req=new RequirementsPage(driver);
		  String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
		  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		  String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 5, 0);
		  String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 4, 1);
		  String global=Excel_Lib.getData(INPUT_PATH_7, "Phase", 4, 0);
		  String [] navigation=new String [1];
		  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 5, 0);
		  bp.waitForElement();
    	  pp.navigateToProjectPage();
		  bp.waitForElement();
		  actual[46]=pp.selectProject(projectName);
		  actual[47]=pp.selectRelease(release);
		  bp.waitForElement();
		  actual[48]=rp.clickOnRequirements();
		  bp.waitForElement();
		  actual[49]=tr.clickOnRelease(global);
		  actual[50]=req.addNode(name, desc);
		  actual[51]=req.navigateToNode(global, navigation);
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

	@Then("^Save button should not be enabled without any requirements in local release$")
	public void save_button_should_not_be_enabled_without_any_requirements_in_local_release() throws Throwable {
		try
		{
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 17, 1);
			String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
			String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
			String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 6);
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
		    String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		    String refreshRate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 7);
			actual[52]=dp.clickOnManageDashboards();
		    bp.waitForElement();
		    actual[53]=dp.clickOnAddDashBoardSymbol();
		    actual[54]=dp.enterDashBoardDetails(name, description, layout, shareType);
		    bp.waitForElement();
		    actual[55]=dp.selectDashboard(name);
		    bp.waitForElement();
		    actual[56]=dp.clickOnAddGadgetSymbol();
		    actual[57]=dp.addGadget(gadget);
		    bp.waitForElement();
		    dp.configureTraceabilityGadget(projectName, release, refreshRate);
		    bp.waitForElement();
		    pp.backToProjectPage();
		    
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
