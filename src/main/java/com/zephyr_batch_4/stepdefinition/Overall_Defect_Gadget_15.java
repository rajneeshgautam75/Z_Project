package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Overall_Defect_Gadget_15 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	DashBoardPage dbp;
	String fileName="Overall_Defect_Gadget_15";
	
	boolean[] actual=new boolean[23];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^Log in As an Manager$")
	public void log_in_As_an_Manager() throws Throwable {
		try
	    {
			bp=new BasePage();
			pp=new ProjectPage(driver);
			pp.clickOnLogout();
			lp=new LoginPage(driver);
		 	 
		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
		     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Password_1");
		     actual[0]=lp.enterUname(Uname);
		     actual[1]=lp.enterPass(Pass);
		     //lp.clickOnLogin();
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

	@Then("^Manager Logged into A application successfully$")
	public void manager_Logged_into_A_application_successfully() throws Throwable {
		try
		   {
			   actual[2]=lp.clickOnLogin();
			   bp.waitForElement();
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

	@When("^Launch the Administration window$")
	public void launch_the_Administration_window() throws Throwable {
		try
		   {
			   pp=new ProjectPage(driver);
			   actual[3]=pp.launchAdministration();
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

	@When("^Navigate to the Defect Tracking to set DTS$")
	public void navigate_to_the_Defect_Tracking_to_set_DTS() throws Throwable {
		try
		   {
			   pp=new ProjectPage(driver);
			   actual[4]=pp.clickOnDefectTracking();
			   
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
	

	@Then("^JIRA Is Set$")
	public void jira_Is_Set() throws Throwable {
		try
		   {
			 String DTS=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 17);  
			 String url=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 26);
			 String username=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 24);
			 String password=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 25);
			 actual[5]=pp.setDTS(DTS, url, username, password);
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

	@When("^Launch manage projects to create a project name with max char limit$")
	public void launch_manage_projects_to_create_a_project_name_with_max_char_limit() throws Throwable {
		try
		{
			  actual[6]=pp.launchAdministration();
	 	 	  bp.waitForElement();
	 	 	  actual[7]=pp.launchManageprojects();
	 	 	  bp.waitForElement();
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

	@Then("^project name with max char limit is created successfully$")
	public void project_name_with_max_char_limit_is_created_successfully() throws Throwable {
		try
		{
		String maxCharProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_6");
 	 	String description=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100, 100);
 		String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_1");
 		String mapDefectProject=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100);
 		String shareCheckbox=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100);
 	 	boolean result1=pp.validateProject(maxCharProject);
 	 	String [] startDate=new String [3];
 	 	{
 	 	startDate[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 18));
 	 	startDate[1]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 19);
 	 	startDate[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 20));
 	 	}
 	 	
 	 	String [] endDate=new String [3];
 	 	{
 	 	endDate[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 21));
 	 	endDate[1]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 22);
 	 	endDate[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 23));
 	 	}
		  //System.out.println(result + " inside step definition");
		  if(result1==false)
		   {
		  String typeName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 27);
		  actual[7]=pp.createProject(maxCharProject, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
		  bp.waitForElement();
			}
		  pp.clickOnLogout();
		   pp.closeBrowser();
   
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

	@When("^As a Lead,User select a project name containing max char limit and create release with max char limit$")
	public void as_a_Lead_User_select_a_project_name_containing_max_char_limit_and_create_release_with_max_char_limit() throws Throwable {
		try
	    {
			bp=new BasePage();
			lb=new LaunchBrowser();
		 	 lb.preCond();
		 	 String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"URL");
		 	 lb.getUrl(url);
		 	 lp=new LoginPage(driver);
		 	 pp=new ProjectPage(driver);
		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_1");
		     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_1");
		     lp.enterUname(Uname);
		     lp.enterPass(Pass);
		     lp.clickOnLogin();
		     
		        bp=new BasePage();
			    rp=new ReleasePage(driver);
			    pp=new ProjectPage(driver);
			    String maxCharProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_6");
			   //String releaseName4=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 6,0);
				   actual[8]=pp.selectProject(maxCharProject);
				   rp=new ReleasePage(driver);
				   bp.waitForElement();
				   actual[9]=rp.clickOnManageRelease();
				   bp.waitForElement();
					String releaseName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_7");
					boolean res1=rp.checkAvailableRelease(releaseName1);
					System.out.println(res1);
					if(res1==false)
					{
			    	//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 2,0);
					String Hide=Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100,100);
			    	String Desc=Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100,100);
					String MapexternalDefect=Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100,100);
			    	rp.addNewRelease(releaseName1, Desc, Hide, MapexternalDefect);
			    	String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 2));
					String smonth=Excel_Lib.getData(INPUT_PATH_3, "Projects", 0, 3);
					String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 4));
					String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 5));
					String emonth=Excel_Lib.getData(INPUT_PATH_3, "Projects", 0, 6);
					String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 7));
					rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
					//rp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
					rp.clickOnAdd();
					bp.waitForElement();
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

	@Then("^release with max char limit is created$")
	public void release_with_max_char_limit_is_created() throws Throwable {
		try
		   {
			   String releaseName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_7");
			   actual[10]=rp.checkAvailableRelease(releaseName1);
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

	@When("^User is in The DashBoard Page$")
	public void user_is_in_The_DashBoard_Page() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
			bp=new BasePage();
			actual[11]=dbp.clickOnManageDashboards();
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

	@Then("^DashBoard Window should Be Launched$")
	public void dashboard_Window_should_Be_Launched() throws Throwable {
		try
		{
			actual[12]=dbp.validateDashboards();
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

	@When("^User CreAte A DashBoard$")
	public void user_CreAte_A_DashBoard() throws Throwable {
		try
		{
		actual[13]=dbp.clickOnAddDashBoardSymbol();
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 11,16);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[14]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
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

	@Then("^CreaTed DashBoard is Selected successfully$")
	public void created_DashBoard_is_Selected_successfully() throws Throwable {
		try
		   {
			   String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 11,16);
			   actual[15]=dbp.validateDashBoard(dashboardName);
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

	@When("^CreaTe a New DashBoarD$")
	public void create_a_New_DashBoarD() throws Throwable {
		try
		{
		actual[16]=dbp.clickOnAddDashBoardSymbol();
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 12,16);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[17]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
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

	@Then("^Should be Able to select an added Dashboard$")
	public void should_be_Able_to_select_an_added_Dashboard() throws Throwable {
		try
		   {
			   String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 12,16);
			   dbp.searchDashboard(dashboardName)  ; 
			   
			   actual[18]=dbp.validateDashBoard(dashboardName);
			   dbp.selectDashboard(dashboardName);
			   
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

	@When("^Add the 'Overall Defects Gadget' by Clicking on a plus symbol$")
	public void add_the_Overall_Defects_Gadget_by_Clicking_on_a_plus_symbol() throws Throwable {
		try
	    {
	    	actual[19]=dbp.clickOnAddGadgetSymbol();
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

	@Then("^Should Be able to Save the gadget$")
	public void should_Be_able_to_Save_the_gadget() throws Throwable {
		try
		{
			 String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,6); 
			 actual[20]=dbp.addGadget(gadgetName);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_6"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_7");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8); 
			 actual[21]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
			 
		     actual[22]=dbp.validateSavedGadget(projectName, release);
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
			   lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}       
	}

}
