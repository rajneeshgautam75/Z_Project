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
import com.zephyr.reusablemethods.TestPlanningPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Dashboard_19 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	TestPlanningPage tp;
	DashBoardPage db;
	String fileName="Dashboard_19";
	boolean[] actual=new boolean[11];
	 SoftAssert soft=new SoftAssert();
	@Given("^login with manager and create a project$")
	public void login_with_manager_and_create_a_project() throws Throwable 
	{
		 try
		   {
			   bp=new BasePage();
			   rp=new ReleasePage(driver);
			   lp=new LoginPage(driver);
			   pp=new ProjectPage(driver);
			   pp.clickOnLogout();
			   String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
			   lp.enterUname(Uname);
			   lp.enterPass(Uname);
			   lp.clickOnLogin();
			   bp.waitForElement();
			   pp.launchAdministration();
			   pp.launchManageprojects();
			   
			   String projectname=Excel_Lib.getData(INPUT_PATH_4,"projectdetails",1,0);
			   String description=Excel_Lib.getData(INPUT_PATH_4,"projectdetails",1,1);
			   String leadType=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
			   String[] stardate=new String[3];
			   stardate[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"StartAndEndDate",1,0));
			   stardate[1]=Excel_Lib.getData(INPUT_PATH_4,"StartAndEndDate",1,1);
			   stardate[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"StartAndEndDate",1,2));
			   String[] endDate=new String[1];
			   endDate[0]=Excel_Lib.getData(INPUT_PATH_4,"StartAndEndDate",100,0);
			   boolean val=pp.validateProject(projectname);
			   if(val==false)
			   {
				 
			    pp.createProject(projectname, description,"Normal",leadType,"", stardate, stardate,"");
			   }
			   pp.backToProjectPage();
			   pp=new ProjectPage(driver);
			   actual[0]=pp.selectProject(projectname);
			   rp=new ReleasePage(driver);
			    rp.clickOnManageRelease();
				String release1=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 9, 0);
				String Desc1=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 9, 1);
				String Hide=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 100,100);
				String MapexternalDefect=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 100,100);
				
				rp.addNewRelease(release1, Desc1, Hide, MapexternalDefect);
				
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
				String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
				String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
				rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
				rp.clickOnAdd();
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

	@When("^launch Dashboard and create a dashboard$")
	public void launch_Dashboard_and_create_a_dashboard() throws Throwable 
	{
		 
		  try
		   {
			  db=new DashBoardPage(driver);
			  db.clickOnManageDashboards();
				db=new DashBoardPage(driver);
				bp=new BasePage();
				actual[3]=db.clickOnAddDashBoardSymbol();
				String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 2,0);
				String desc=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 2,1);
				String layout=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,2);
				String shareType=Excel_Lib.getData(INPUT_PATH_4, "Dashboard",1,3);
				actual[4]=db.enterDashBoardDetails(dashboardName, desc, layout, shareType);
				actual[5]=db.validateDashBoard(dashboardName);
				//String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,0);
				actual[6]=db.selectDashboard(dashboardName);
				
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

	@When("^add test automation Gadjet with project and release and save$")
	public void add_test_automation_Gadjet_with_project_and_release_and_save() throws Throwable 
	{
		try
		{
			actual[7]=db.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,4); 
			 actual[8]=db.addGadget(gadgetName);
			 String projectname=Excel_Lib.getData(INPUT_PATH_4,"projectdetails",1,0);
			   String release1=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 9, 0);
			 //String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 //String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1,5); 
			 actual[9]=db.configureTestAutomationStatusGadget(projectname, release1, refreshRate);
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

	@Then("^delete the release and project$")
	public void delete_the_release_and_project() throws Throwable 
	{
	   try
	   {
		   
		   pp.backToProjectPage();
		   String projectname=Excel_Lib.getData(INPUT_PATH_4,"projectdetails",1,0);
		   String release1=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 9, 0);
		   pp.deleteRelease(projectname, release1);
		   pp.launchAdministration();
		   bp.waitForElement();
		   pp.launchManageprojects();
		   pp.DeleteProject(projectname);
		   
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
