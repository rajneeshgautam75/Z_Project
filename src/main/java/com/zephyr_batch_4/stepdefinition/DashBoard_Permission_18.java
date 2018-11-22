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

public class DashBoard_Permission_18 extends LaunchBrowser{
	
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="DashBoards_Permission_18";
	
	BasePage bp;
	DashBoardPage dp;
	LoginPage lp;
	ProjectPage pp;
	
	boolean actual[]=new boolean[24];
	SoftAssert soft=new SoftAssert();
	
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 19, 0);
	private String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 3, 4);
	
	private String URL;
	
	@Given("^Login as Test Manager and navigate to Manage Projects page$")
	public void login_as_Test_Manager_and_navigate_to_Manage_Projects_page() throws Throwable {
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

	@When("^Select a project and assign the project to Lead, Tester and logout$")
	public void select_a_project_and_assign_the_project_to_Lead_Tester_and_logout() throws Throwable {
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

	@When("^Login as Lead, add dashboard, add gadget and save$")
	public void login_as_Lead_add_dashboard_add_gadget_and_save() throws Throwable {
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
		 actual[13]=dp.validateDashBoard(dashBoardName);
		 actual[14]=dp.selectDashboard(dashBoardName);
		 bp.waitForElement();
		 actual[15]=dp.clickOnAddGadgetSymbol();
		 actual[16]=dp.addGadget(gadget);
		 actual[17]=dp.validateGadget(gadget);
		 String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
		 actual[18]=dp.configureTestAutomationStatusGadget(project, release, refreshRate);
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

	@Then("^Dashboard and Gadget should be added successfully$")
	public void dashboard_and_Gadget_should_be_added_successfully() throws Throwable {
		try
		 {
		 actual[19]=dp.validateSavedGadget(project);
		 bp.waitForElement();
		 URL=driver.getCurrentUrl();
		 System.out.println(URL);
		 actual[20]=pp.clickOnLogout();	
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

	@When("^Login as Tester and hit the DashBoard 'URL'$")
	public void login_as_Tester_and_hit_the_DashBoard_URL() throws Throwable {
		try
		 {
		 String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Tester_Username_1");
	     String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Tester_Password_1");
		 actual[21]=lp.enterUnameAndPassword(name, passWord);
		 bp.waitForElement();
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

	@Then("^Able to Lauch dashboard and view gadgets$")
	public void able_to_Lauch_dashboard_and_view_gadgets() throws Throwable {
		try
		 {
		 actual[22]=dp.validateGadget(gadget);	
		 pp.clickOnLogout();
		 String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_1");
		 String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_1");
		 actual[23]=lp.enterUnameAndPassword(name, passWord);
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
