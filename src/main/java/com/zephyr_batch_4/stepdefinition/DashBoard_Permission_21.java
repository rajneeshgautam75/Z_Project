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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashBoard_Permission_21 extends LaunchBrowser{
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="DashBoards_Permission_21";
	
	BasePage bp;
	DashBoardPage dp;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	
	boolean actual[]=new boolean[46];
	SoftAssert soft=new SoftAssert();
	
	private String project1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	private String dashBoardName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 22, 0);
	private String dashBoardName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 23, 0);
	private String projectGadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 4, 4);
	
	@Given("^Login as Manager and navigate to manage projects page$")
	public void login_as_Manager_and_navigate_to_manage_projects_page() throws Throwable {
		 try
		   {
			pp=new ProjectPage(driver);
			rp=new ReleasePage(driver);
			bp=new BasePage();
			lp=new LoginPage(driver);
			actual[0]=pp.clickOnLogout();
			String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
			String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Password_1");
			actual[1]=lp.enterUnameAndPassword(name, passWord);
			bp.waitForElement();
        	actual[2]=pp.launchAdministration();
			bp.waitForElement();
			actual[3]=pp.launchManageprojects();
			bp.waitForElement(); 
			}	
			catch(Exception e)
			{
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
			}	  
	   
	}

	@When("^Create two new projects$")
	public void create_two_new_projects() throws Throwable {
		 try
		  {
		    String description=Excel_Lib.getData(INPUT_PATH_5, "Projects", 0, 1);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
		    String mapDefectProject=Excel_Lib.getData(INPUT_PATH_5, "Projects", 100, 100);
		    String [] startDate = new String[3];
		    startDate[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Projects", 1, 2));
		    startDate[1]=Excel_Lib.getData(INPUT_PATH_5,"Projects", 1,3);
		    startDate[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Projects", 1,4));
		    String [] endDate = new String[3];
		    endDate[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Projects", 1, 5));
		    endDate[1]=Excel_Lib.getData(INPUT_PATH_5, "Projects", 1, 6);
		    endDate[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Projects", 1, 7));		
		    String shareCheckbox=Excel_Lib.getData(INPUT_PATH_5, "Projects", 100, 100);		
		    String typeName=Excel_Lib.getData(INPUT_PATH_5, "Projects", 1, 9);
		    boolean check1=pp.validateProject(project1);
		    if(check1==false)
		    {
		    pp.createProject(project1, description, typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
		    bp.waitForElement();
		    }
		    boolean check2=pp.validateProject(project2);
		    if(check2==false)
		    {
		    pp.createProject(project2, description, typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
		    bp.waitForElement();
		    }  
		   }	
		   catch(Exception e)
		   {
		   e.printStackTrace();
		   lb.getScreenShot(fileName);
		   driver.close();
		   Relogin_TPE rl=new Relogin_TPE();
		   rl.reLogin();
		   throw e;
		   }	  
	   
	}

	@When("^assign all users for first project and assign all users except lead for second project$")
	public void assign_all_users_for_first_project_and_assign_all_users_except_lead_for_second_project() throws Throwable {
		try
		{
			actual[4]=pp.launchManageUsers();
			bp.waitForElement();
			String user=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_1");
			actual[5]=pp.selectUser(user);																																																																																																																																																																																																																								
			bp.waitForElement();
			actual[6]=pp.unAssignProject(project2); 
			pp.backToProjectPage();
			bp.waitForElement();
		 }
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}
	}

	@When("^Now as Manager create a dashboard with sharetype any logged in user$")
	public void now_as_Manager_create_a_dashboard_with_sharetype_any_logged_in_user() throws Throwable {
		try
		{
		    dp=new DashBoardPage(driver);
		    actual[7]=dp.clickOnManageDashboards();
			actual[8]=dp.validateDashboards();
			bp.waitForElement();
			actual[9]=dp.clickOnAddDashBoardSymbol();
			String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
			String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
			String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 3, 3);
			actual[10]=dp.enterDashBoardDetails(dashBoardName1, desc, layout, shareType);
			bp.waitForElement();
			actual[11]=dp.validateDashBoard(dashBoardName1);
			actual[12]=dp.selectDashboard(dashBoardName1);
			bp.waitForElement();
			actual[13]=dp.clickOnAddGadgetSymbol();
			actual[14]=dp.addGadget(projectGadget);
			bp.waitForElement();
			actual[15]=dp.configureProjectStatusGadget(project1);
			actual[16]=dp.saveGadget();
			bp.waitForElement(); 
			
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}  
	   
	}

	@Then("^Should be able to create Dashboard successfully and logout$")
	public void should_be_able_to_create_Dashboard_successfully_and_logout() throws Throwable {
		try
		{
			actual[17]=dp.validateSavedGadget(project1);
			bp.waitForElement();
			actual[18]=pp.clickOnLogout();	
			
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		} 
	   
	}

	@When("^Now login as lead and check the gadget$")
	public void now_login_as_lead_and_check_the_gadget() throws Throwable {
		try
		{
			String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_1");
			String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_1");
			actual[19]=lp.enterUnameAndPassword(name, passWord);
			bp.waitForElement();	
			actual[20]=dp.clickOnManageDashboards();
			actual[21]=dp.validateDashboards();
			bp.waitForElement();
			actual[22]=dp.searchDashboard(dashBoardName1);
			bp.waitForElement();
			actual[23]=dp.selectDashboard(dashBoardName1);
			bp.waitForElement();
			actual[24]=dp.validateSavedGadget(project1); 
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		} 
	   
	}

	@When("^Add two project status gadget with both projects and one requirement status gadget with second project$")
	public void add_two_project_status_gadget_with_both_projects_and_one_requirement_status_gadget_with_second_project() throws Throwable {
		try
		{
			actual[25]=dp.clickOnManageDashboards();
			actual[26]=dp.validateDashboards();
			bp.waitForElement();
			actual[27]=dp.clickOnAddDashBoardSymbol();
			String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
			String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
			String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 3, 3);
			actual[28]=dp.enterDashBoardDetails(dashBoardName2, desc, layout, shareType);
			bp.waitForElement();
			actual[29]=dp.validateDashBoard(dashBoardName2);
			actual[30]=dp.selectDashboard(dashBoardName2);
			bp.waitForElement();
			actual[31]=dp.clickOnAddGadgetSymbol();
			actual[32]=dp.addGadget(projectGadget);
			bp.waitForElement();
			actual[33]=dp.configureProjectStatusGadget(project1);
			actual[34]=dp.saveGadget();
			bp.waitForElement();
			actual[35]=dp.validateSavedGadget(project1);
			bp.waitForElement();
			actual[36]=dp.clickOnAddGadgetSymbol();
			String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 5, 4);
			actual[37]=dp.addGadget(projectGadget);
			bp.waitForElement();
			String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			actual[38]=dp.configureProjectStatusGadget(project1);
			actual[39]=dp.saveGadget();
			bp.waitForElement();
			actual[40]=dp.validateSavedGadget(project1);
			bp.waitForElement();
			actual[41]=dp.clickOnAddGadgetSymbol();
			actual[42]=dp.addGadget(gadget);
			bp.waitForElement();
			actual[43]=dp.configureTestAutomationStatusGadget(project1, release, refreshRate);
			bp.waitForElement();
			actual[44]=dp.validateSavedGadget(project1);
			actual[45]=pp.backToProjectPage();
			
			pp.clickOnLogout();
			String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
			String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Password_1");
			actual[1]=lp.enterUnameAndPassword(name, passWord);
			bp.waitForElement();
			pp.launchAdministration();
		    pp.launchManageUsers();
			bp.waitForElement();
			String user=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_1");
			actual[5]=pp.selectUser(user);																																																																																																																																																																																																																								
			bp.waitForElement();
			actual[6]=pp.assignProject(project2);
			bp.waitForElement();
			pp.backToProjectPage();
			bp.waitForElement();
			
			
			for(int k=0;k<=actual.length-1;k++)
			{
			System.out.println("Actual["+k+"]="+actual[k]);
			soft.assertEquals(actual[k], true);
			}	
		}
		catch(Exception e)
		{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		} 
	   
	}

}
