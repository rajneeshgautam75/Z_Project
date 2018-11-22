package com.zephyr_batch_5.stepdefinition;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_39 extends LaunchBrowser {
	
	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	ExecutionPage exep;
	DefectTracking dt;
	ExternalJiraPage ejp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	ExecutionPage ep;
	CreateCustomFieldsPage ccp;
	boolean[] actual=new boolean[92];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_39";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
   
    @Given("^user Logins To Jira as admin$")
    public void user_Logins_To_Jira_as_admin() throws Throwable {
		try
		{
			 pp=new ProjectPage(driver);
			 rp=new ReleasePage(driver);
			 bp=new BasePage();
			 lp=new LoginPage(driver);
			 dt=new DefectTracking(driver);
			 tr=new TestRepositoryPage(driver);
			 tp=new TestPlanningPage(driver);
			 ep=new ExecutionPage(driver);
			 exep=new ExecutionPage(driver);
			 ccp=new CreateCustomFieldsPage(driver);
			 String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
		     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
			 ejp=new ExternalJiraPage(driver);
			 actual[0]=pp.selectProject(project);
			 pp.clickOnLogout(); 
		     driver.navigate().to(jira_Url);
		     bp.waitForElement();
		     actual[1]=ejp.loginToExternalJira(Uname,Pwd);
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

	@When("^User clicks ON Administration and clicks on system$")
	public void user_clicks_ON_Administration_and_clicks_on_system() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 5, 0);
			String pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
			bp.waitForElement();
			actual[2]=ejp.launchJiraAdministration(name);
			bp.waitForElement();
			actual[3]=ejp.enterAdministratorAccessPassword(pwd);
			
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

	@When("^clicks on Advance Settings$")
	public void clicks_on_Advance_Settings() throws Throwable {
	    try
	    {
	    	bp.waitForElement();
	    	actual[4]=ccp.clickOnAdvanceSettings();
	    	
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

	@When("^Changes the format jira date picker javaformat to yyyy-MM-dd$")
	public void changes_the_format_jira_date_picker_javaformat_to_yyyy_MM_dd() throws Throwable {
		try
	    {
	    	String key=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 4, 1);
	    	String keyValue=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 4, 2);
	    	actual[5]=bp.waitForElement();
			boolean res=ccp.checkAvailableKeysValueInJira(key, keyValue);
			if(res==false)
			{
				ccp.changeKeyValues(key, keyValue);
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

	@When("^Create a custom field in Jira of type date picker$")
	public void create_a_custom_field_in_Jira_of_type_date_picker() throws Throwable {
		try
	    {
			String name=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 4, 0);
			String fieldType=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 3, 1);
			String field=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 3, 2);
			String customName=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 3, 3);
			String customDescription=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 100, 1000);
			String fieldValue[]=new String[1];
			fieldValue[0]=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 100, 100);
	    	bp.waitForElement();
	    	actual[6]=ejp.launchJiraAdministration(name);
			bp.waitForElement();
			actual[7]=ejp.navigateToCustomfields();	
			actual[8]=bp.waitForElement();
			boolean res=ccp.checkAvailableCustomFieldsInJira(customName);
			if(res==false)
			{
				ejp.addCustomFields(fieldType, field, customName, customDescription, fieldValue);
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

	@Then("^custom field should be created$")
	public void custom_field_should_be_created() throws Throwable {
		try
	    {
			String customName=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 3, 3);
			bp.waitForElement();
			actual[9]=ccp.checkAvailableCustomFieldsInJira(customName);
			bp.waitForElement();
			actual[10]=ejp.logOutFromExternal_JIRA();
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

	@When("^user Logins as Manager Credentials to zephyr and clicks on Administration$")
	public void user_Logins_as_Manager_Credentials_to_zephyr_and_clicks_on_Administration() throws Throwable {
		try
		{
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
			String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
			bp.waitForElement();
			driver.navigate().to(url);
		    bp.waitForElement();
			bp.waitForElement();
			actual[11]=lp.enterUname(uname);
			actual[12]=lp.enterPass(password);       
			actual[13]=lp.clickOnLogin();  
			bp.waitForElement(); 
			actual[14]=pp.launchAdministration();
			
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

	@When("^set DTS to JIRA by user$")
	public void set_DTS_to_JIRA_by_user() throws Throwable {
		try
		{
			String dts=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "DTS_Type");
			String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "JIRA_URL");
	    	String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Jira_Username");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Jira_Password");
			bp.waitForElement();
			actual[15]=pp.clickOnDefectTracking();
			bp.waitForElement();
	    	actual[16]=pp.setDTS(dts, url, username, password);
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

	@When("^Launch Defects Admin app  and configured  dts customfield jira date_format = yyyy-MM-dd$")
	public void launch_Defects_Admin_app_and_configured_dts_customfield_jira_date_format_yyyy_MM_dd() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 8, 1);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 8, 0);
			String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 100, 100);
			bp.waitForElement();
			actual[17]=ccp.moveToPreferences();
			actual[18]=bp.waitForElement();
			boolean res=ccp.checkAvailableCategories(category, name, value);
			if(res==false)
			{
				ccp.editCategories(category, name, value, active);
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

	@Then("^should be configuered jira date format$")
	public void should_be_configuered_jira_date_format() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 8, 1);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 8, 0);
			bp.waitForElement();
			actual[19]=ccp.validateCategories(name, value);
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

	@When("^user Launches Defect Tracking app and clicks on Create Defect$")
	public void user_Launches_Defect_Tracking_app_and_clicks_on_Create_Defect() throws Throwable {
		try
		{
		String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
		String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
		bp.waitForElement();
		actual[20]=pp.backToProjectPage();
		actual[21]=pp.selectProject(project);
		actual[22]=pp.selectRelease(release);
		bp.waitForElement();
	    actual[23]=pp.clickOnDefectTracking();
	    bp.waitForElement();
	    actual[24]=dt.createDefect(projectType, issueType);
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

	@When("^creates a defect with customfield of type date Picker$")
	public void creates_a_defect_with_customfield_of_type_date_Picker() throws Throwable {
		try
		   {
			    String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 3);
				String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 11, 3);
				String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String sprint=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String env=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String epicLink=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 5, 0));
				String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 1);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 1, 6));
				bp.waitForElement();
				actual[25]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		        bp.waitForElement();
		        actual[26]=dt.customDatePicker(syear, smonth, sday);
		        bp.waitForElement();
		        actual[27]=dt.saveDefect();
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

	@Then("^should be able to create a defect with custom field of type Date Picker$")
	public void should_be_able_to_create_a_defect_with_custom_field_of_type_Date_Picker() throws Throwable {
		try
		{
		String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
		String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
		bp.waitForElement();
		actual[28]=dt.validateDefect(projectType, issueType);
		bp.waitForElement();
		actual[29]=dt.updateDefect();
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

	@When("^user Launches Defect Tracking,searches a defect and selects it$")
	public void user_Launches_Defect_Tracking_searches_a_defect_and_selects_it() throws Throwable {
		 try
		    {  
					
					String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 4, 6);
					bp.waitForElement();
					actual[30]=pp.clickOnDefectTracking();
					bp.waitForElement();
					actual[31]=dt.searchDefect(defectId);
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

	@When("^creates a subtask with Custom Field of type Date Picker$")
	public void creates_a_subtask_with_Custom_Field_of_type_Date_Picker() throws Throwable {
		try
	    {  
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
		    String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 3);
			String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 11, 3);
			String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String sprint=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String env=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String epicLink=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 5, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 1, 6));
			bp.waitForElement();
			dt.selectAllDefects();
			actual[32]=dt.clickOnCreateSubTask();
			actual[33]=dt.createDefectSubtask(issueType);
		    bp.waitForElement();
		    actual[34]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
            bp.waitForElement();
            actual[35]=dt.customDatePicker(syear, smonth, sday);
		    bp.waitForElement();
		    actual[36]=dt.saveDefect();	    
		
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

	@Then("^should be able to create a defect with Customfield of Type Date Picker$")
	public void should_be_able_to_create_a_defect_with_Customfield_of_Type_Date_Picker() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			bp.waitForElement();
			actual[37]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[38]=dt.updateDefect();
		
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

	@When("^user Launches Test Repository and creates a phase and adds Few Testcases$")
	public void user_Launches_Test_Repository_and_creates_a_phase_and_adds_Few_Testcases() throws Throwable {
		 try
		   {
			   
				rp=new ReleasePage(driver);
				tp=new TestPlanningPage(driver);
				rp=new ReleasePage(driver);
				tr=new TestRepositoryPage(driver);
				String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 15, 4);
				String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 15, 5);
				String [] navigation=new String [1];
				navigation[0]=name;
				bp.waitForElement();
				actual[39]=rp.clickOnTestRep();
				bp.waitForElement();
				actual[40]=tr.clickOnRelease(release);
				actual[41]=tr.addNode(name, desc);
				bp.waitForElement();
				actual[42]=tr.navigateToNode(release, navigation);
				for(int i=0;i<=2;i++)
				{
				tr.addTestCase();	
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

	@When("^Launches TestPlanning and creates a new Cycle and adds phase to cycle$")
	public void launches_TestPlanning_and_creates_a_new_Cycle_and_adds_phase_to_cycle() throws Throwable {
		try
		{
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 1);
			String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 5, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 8, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 10, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 8, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 10, 5));
			String [] cycle1 =new String[1];
			cycle1[0]=cycle;
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 15,4);
			String phase_1[]=new String[1];
		    phase_1[0]=phase;
			bp.waitForElement();
			actual[43]=rp.clickOnTestPlanning();
			actual[44]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[45]=tp.CreateCycle(cycle, build, Environment, hide);
			bp.waitForElement();
			actual[46]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[47]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			actual[48]=tp.navigateToCycle(cycle1);
			bp.waitForElement();
			actual[49]=tp.addPhaseToCycle(phase);
		
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

	@When("^assign Testcases to Anyone$")
	public void assign_Testcases_to_Anyone() throws Throwable {
		try
		{
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 2, 0);
			bp.waitForElement();
			actual[50]=tp.bulkAssignment(bulk_type);
			bp.waitForElement();
			actual[51]=tp.goBackToCycle();
		    
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

	@When("^Launches TestExecution,executes testcase with any status and clicks on D button$")
	public void launches_TestExecution_executes_testcase_with_any_status_and_clicks_on_D_button() throws Throwable {
		try
		{
			ep=new ExecutionPage(driver);
			bp.waitForElement();
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",13,1 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",15,4);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			bp.waitForElement();
			actual[52]=rp.clickOnTestExecution();
			actual[53]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[54]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[55]=ep.changeMultiSelectedStatus(status);
	
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

	@Then("^Link defect window should be launched by user$")
	public void link_defect_window_should_be_launched_by_user() throws Throwable {
		try
		{
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[56]=ep.clickOnDefectButton(testcase1);
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

	@When("^user clicks on create defect and creates a defect with Customfield of Type Date Picker$")
	public void user_clicks_on_create_defect_and_creates_a_defect_with_Customfield_of_Type_Date_Picker() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 3);
			String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 11, 3);
			String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String sprint=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String env=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String epicLink=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 5, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 1, 6));
			actual[57]=dt.createDefect(projectType, issueType);
			actual[58]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[59]=dt.customDatePicker(syear, smonth, sday);
	        actual[60]=bp.waitForElement();
			actual[61]=dt.saveDefect();
			
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

	@Then("^defect should be created of type date picker$")
	public void defect_should_be_created_of_type_date_picker() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			actual[62]=bp.waitForElement();
			actual[63]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[64]=dt.updateDefect();
			bp.waitForElement();
			actual[65]=ep.clickOnCancelDefectWindow();
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

	@When("^user Launches TestRepository Page and creates a New phase and adds Few Testcases$")
	public void user_Launches_TestRepository_Page_and_creates_a_New_phase_and_adds_Few_Testcases() throws Throwable {
		try
		   {
			 
				String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 14, 4);
				String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 14, 5);
				String [] navigation=new String [1];
				navigation[0]=name;
				bp.waitForElement();
				actual[66]=rp.clickOnTestRep();
				bp.waitForElement();
				actual[67]=tr.clickOnRelease(release);
				actual[68]=tr.addNode(name, desc);
				bp.waitForElement();
				actual[69]=tr.navigateToNode(release, navigation);
				for(int i=0;i<=2;i++)
				{
				tr.addTestCase();	
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

	@When("^Launches TestPlanning Page and creates a new Cycle and adds created phase to cycle,and assign testcases to anyone$")
	public void launches_TestPlanning_Page_and_creates_a_new_Cycle_and_adds_created_phase_to_cycle_and_assign_testcases_to_anyone() throws Throwable {
		try
		{
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 15, 1);
			String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 5, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 8, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 10, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 8, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 10, 5));
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 2, 0);
			bp.waitForElement();
			String [] cycle1 =new String[1];
			cycle1[0]=cycle;
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 14,4);
			String phase_1[]=new String[1];
		    phase_1[0]=phase;
			bp.waitForElement();
			actual[70]=rp.clickOnTestPlanning();
			actual[71]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[72]=tp.CreateCycle(cycle, build, Environment, hide);
			bp.waitForElement();
			actual[73]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[74]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			actual[75]=tp.navigateToCycle(cycle1);
			bp.waitForElement();
			actual[76]=tp.addPhaseToCycle(phase);
			actual[77]=tp.bulkAssignment(bulk_type);
			bp.waitForElement();
			actual[78]=tp.goBackToCycle();
		
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

	@When("^Launches Test Execution,Executes testcase with Any status and Clicks on D button$")
	public void launches_Test_Execution_Executes_testcase_with_Any_status_and_Clicks_on_D_button() throws Throwable {
		try
		{
			ep=new ExecutionPage(driver);
			bp.waitForElement();
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",15,1 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",14,4);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			bp.waitForElement();
			actual[79]=rp.clickOnTestExecution();
			actual[80]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[81]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[82]=ep.changeMultiSelectedStatus(status);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[83]=ep.clickOnDefectButton(testcase1);
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

	@Then("^Link Defect Window should be launched by user$")
	public void link_Defect_Window_should_be_launched_by_user() throws Throwable {
	   try
	   {
		   bp.waitForElement();
		   actual[84]=ep.validateLinkDefectWindow();
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

	@When("^user clicks on Create Defect and creates a defect with custom field of Type Date Picker$")
	public void user_clicks_on_Create_Defect_and_creates_a_defect_with_custom_field_of_Type_Date_Picker() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 3);
			String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 11, 3);
			String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String sprint=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String env=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String epicLink=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 5, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 1, 6));
			actual[85]=dt.createDefect(projectType, issueType);
			actual[86]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
	        actual[87]=dt.customDatePicker(syear, smonth, sday);
	        bp.waitForElement();
			actual[88]=dt.saveDefect();
			
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

	@Then("^defect should be created with custom field of type date picker$")
	public void defect_should_be_created_with_custom_field_of_type_date_picker() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			bp.waitForElement();
			actual[89]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[90]=dt.updateDefect();
			bp.waitForElement();
			actual[91]=ep.clickOnCancelDefectWindow();
			 for(int k=0;k<=actual.length-1;k++)
				{
					System.out.println("Actual["+k+"]="+actual[k]);
					soft.assertEquals(actual[k], true);
					System.out.println(actual[k]);
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
