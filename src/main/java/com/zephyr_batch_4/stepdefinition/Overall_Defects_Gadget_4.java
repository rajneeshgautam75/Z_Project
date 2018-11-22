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

public class Overall_Defects_Gadget_4 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	DashBoardPage dp;
	boolean[] actual=new boolean[21];
	SoftAssert soft=new SoftAssert();
    String fileName="Overall_Defects_Gadget_4";
	@Given("^User Logins as Manager credentials$")
	public void user_Logins_as_Manager_credentials() throws Throwable {
		
		try
		{
			pp=new ProjectPage(driver);
			bp=new BasePage();
			lb=new LaunchBrowser();
			lp=new LoginPage(driver);
			dp=new DashBoardPage(driver);
		    pp.clickOnLogout();
			bp.waitForElement();
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Password_1");
			bp.waitForElement();
			actual[0]=lp.enterUname(uname);
			actual[1]=lp.enterPass(password);
			lp.clickOnLogin();
			
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

	@When("^user Sets DTS to JIRA$")
	public void user_Sets_DTS_to_JIRA() throws Throwable {
		
	    try
	    {  
	    	pp=new ProjectPage(driver);
	    	rp=new ReleasePage(driver);
	    	bp.waitForElement();
	    	actual[2]=pp.launchAdministration();
	    	actual[3]=pp.clickOnDefectTracking();
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

	@Then("^Should be able to set$")
	public void should_be_able_to_set() throws Throwable {
		try
		{
			String dts=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 10);
			String url=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 4, 10);
	    	String username=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 10);
			String password=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 10);
			bp.waitForElement();
	    	actual[4]=pp.setDTS(dts, url, username, password);
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

	@When("^user Goes to release setup ,Create (\\d+) releases$")
	public void user_Goes_to_release_setup_Create_releases(int arg1) throws Throwable {
		try
		{
			actual[5]=pp.clickOnLogout();
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_1");
			bp.waitForElement();
			actual[6]=lp.enterUname(uname);
			actual[7]=lp.enterPass(password);
			lp.clickOnLogin();
			String selectProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			bp.waitForElement();
//			//pp.launchAdministration();
			pp.selectProject(selectProject);
			actual[8]=bp.waitForElement();
			    
			
			   pp.clickOnManageRelease();
			    for(int i=0;i<=5;i++)
				{
				String release=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 4+i,9);
				boolean res=rp.checkAvailableRelease(release);
			if(res==false)
			{
				String desc=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 14);
				String hide=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 20);
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

	@Then("^should able to create releases$")
	public void should_able_to_create_releases() throws Throwable {
	   try
	   {
		   for(int i=0;i<=5;i++)
		   {
		   
		   String release=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 4+i, 9);
		   bp.waitForElement();
		   rp.checkAvailableRelease(release);
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

	@When("^User is In a DashBoard Page$")
	public void user_is_In_a_DashBoard_Page() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[9]=dp.clickOnManageDashboards();
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

	@Then("^Should be Launched DashBoard Window$")
	public void should_be_Launched_DashBoard_Window() throws Throwable {
		try
		{
			actual[10]=dp.validateDashboards();
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

	@When("^User Adds New DashBoard$")
	public void user_Adds_New_DashBoard() throws Throwable {
		try
		   {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 21, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
		   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
		   bp.waitForElement();
		   actual[11]=dp.clickOnAddDashBoardSymbol();
		   actual[12]=dp.enterDashBoardDetails(name, description, layout, shareType);
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

	@Then("^New DashBoard Should be added$")
	public void new_DashBoard_Should_be_added() throws Throwable {
		try
		  {
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 21, 1);
			actual[13]=dp.validateDashBoard(name);
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

	@When("^user clicks on added dashboard$")
	public void user_clicks_on_added_dashboard() throws Throwable {
		try
		{
			
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 21, 1);
			actual[14]=dp.selectDashboard(name);
			
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

	@Then("^Added Dashboard should be selected$")
	public void added_Dashboard_should_be_selected() throws Throwable {
		try
		{
			String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 21, 1);
			bp.waitForElement();
			actual[15]=dp.validateDashBoard(dashBoard);
			
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

	@When("^By clicking on \"([^\"]*)\" button, user adds Overall Defects Gadget$")
	public void by_clicking_on_button_user_adds_Overall_Defects_Gadget(String arg1) throws Throwable {
		try
		{
			String gadgetName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 6);
			bp.waitForElement();
			actual[16]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
		   actual[17]=dp.addGadget(gadgetName);
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

	@Then("^overall Defect Gadget should be added$")
	public void overall_Defect_Gadget_should_be_added() throws Throwable {
		try
		{
			String gadgetName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 6);
			bp.waitForElement();
			actual[18]=dp.validateGadget(gadgetName);
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

	@When("^user selects one release out of (\\d+) releases$")
	public void user_selects_one_release_out_of_releases(int arg1) throws Throwable {
		try
		{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
	    	String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
			String refreshRate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 7);
			actual[19]=dp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
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

	@Then("^Should be able to select one release out of (\\d+) releases$")
	public void should_be_able_to_select_one_release_out_of_releases(int arg1) throws Throwable {
		
		try
		{
			
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
	    	String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
			actual[20]=dp.validateSavedGadget(projectName, release);
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
