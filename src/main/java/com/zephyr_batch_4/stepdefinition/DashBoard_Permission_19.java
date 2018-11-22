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

public class DashBoard_Permission_19 extends LaunchBrowser {
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="DashBoards_Permission_19";
	
	BasePage bp;
	DashBoardPage dp;
	LoginPage lp;
	ProjectPage pp;
	
	boolean actual[]=new boolean[20];
	SoftAssert soft=new SoftAssert();
	
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 20, 0);
	private String URL;
	
	@Given("^Login as a Test Manager and launch administration$")
	public void login_as_a_Test_Manager_and_launch_administration() throws Throwable {
		try
		 {
		 lp=new LoginPage(driver);
		 pp=new ProjectPage(driver);
		 bp=new BasePage();
		 actual[0]=pp.clickOnLogout();
		 bp.waitForElement();
		 String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Manager_Username_1");
		 String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Manager_Password_1");
		 actual[1]=lp.enterUnameAndPassword(name, passWord);
		 bp.waitForElement();
		 actual[2]=pp.launchAdministration();
		 bp.waitForElement();
		 pp.manageUser.click();
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

	@When("^click on Manage users, assign one project to lead, another project to tester and Logout$")
	public void click_on_Manage_users_assign_one_project_to_lead_another_project_to_tester_and_Logout() throws Throwable {
		try
		 {
		 String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_1");
		 actual[3]=pp.selectUser(lead);
		 actual[4]=pp.assignProject(project);
		 bp.waitForElement();
		 String tester=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Tester_1");
		 actual[5]=pp.selectUser(tester);
		 actual[6]=pp.assignProject(project);
		 bp.waitForElement();
		 actual[7]=pp.clickOnLogout(); 
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

	@When("^Login as a Lead, create a dashboard with access type Project Team, save and Logout$")
	public void login_as_a_Lead_create_a_dashboard_with_access_type_Project_Team_save_and_Logout() throws Throwable {
		try
		 {
		 dp=new DashBoardPage(driver);
		 String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_1");
		 String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_1");
		 actual[8]=lp.enterUnameAndPassword(name, passWord);
		 bp.waitForElement();	
		 actual[9]=dp.clickOnManageDashboards();
		 actual[10]=dp.validateDashboards();
		 bp.waitForElement();
		 actual[11]=dp.clickOnAddDashBoardSymbol();
		 String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
		 String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
		 String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
		 actual[12]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
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

	@Then("^DashBoard should be added successfully$")
	public void dashboard_should_be_added_successfully() throws Throwable {
		try
		 {
		 actual[13]=dp.validateDashBoard(dashBoardName);
		 actual[14]=dp.selectDashboard(dashBoardName);
		 bp.waitForElement();
		 URL=driver.getCurrentUrl();
		 System.out.println(URL);
		 actual[15]=pp.clickOnLogout();	
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

	@When("^Login as Tester, launch dashboards page and hit the URL$")
	public void login_as_Tester_launch_dashboards_page_and_hit_the_URL() throws Throwable {
		try
		 {
		 String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Tester_Username_1");
	     String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Tester_Password_1");
		 actual[16]=lp.enterUnameAndPassword(name, passWord);
		 bp.waitForElement();
		 actual[17]=dp.clickOnManageDashboards();
		 driver.navigate().to(URL);
		 bp.waitForElement();
		 bp.waitForElement();
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

	@Then("^Should navigate to dashboard page$")
	public void should_navigate_to_dashboard_page() throws Throwable {
		try
		 {
		 actual[18]=dp.validateDashBoard(dashBoardName);
		 pp.clickOnLogout();
		 String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_1");
		 String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_1");
		 actual[19]=lp.enterUnameAndPassword(name, passWord);
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
