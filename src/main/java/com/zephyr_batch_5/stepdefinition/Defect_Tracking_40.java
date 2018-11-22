package com.zephyr_batch_5.stepdefinition;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_40 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestPlanningPage tp;
	TestRepositoryPage tr;
	ExecutionPage ep;
	DefectTracking dt;
	CreateCustomFieldsPage ccp;
	boolean[] actual=new boolean[59];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_40";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^In zephyr  login as a manager$")
	public void in_zephyr_login_as_a_manager() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			lp=new LoginPage(driver);
			bp=new BasePage();
			lb=new LaunchBrowser();
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
			bp.waitForElement();
			actual[0]=pp.clickOnLogout();
			bp.waitForElement();
			actual[1]=lp.enterUname(uname);
			actual[2]=lp.enterPass(password);        
			actual[3]=lp.clickOnLogin();  
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

	@When("^user launches Administration set DTS to Jira$")
	public void user_launches_Administration_set_DTS_to_Jira() throws Throwable {
		try
		{
			actual[4]=pp.launchAdministration();
			bp.waitForElement();
			actual[5]=pp.clickOnDefectTracking();	
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

	@Then("^should be Set DTS to JIRA$")
	public void should_be_Set_DTS_to_JIRA() throws Throwable {
		try
		{
			String dts=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 10);
			String url=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 4, 10);
	    	String username=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 10);
			String password=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 10);
			bp.waitForElement();
	    	actual[6]=pp.setDTS(dts, url, username, password);
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

	@When("^user Launches Defects Admin app  and configured  dts\\.customfield\\.jira\\.date_format = yyyy-MM-dd$")
	public void user_Launches_Defects_Admin_app_and_configured_dts_customfield_jira_date_format_yyyy_MM_dd() throws Throwable {
	    try
	    {
	    	ccp=new CreateCustomFieldsPage(driver);
	    	bp.waitForElement();
	    	actual[7]=ccp.moveToPreferences();
	    	
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

	@Then("^To be able to configure$")
	public void to_be_able_to_configure() throws Throwable {
		try
	    {
			dt=new DefectTracking(driver);
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 1);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 2);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 100, 100);
	    	bp.waitForElement();
	    	actual[8]=dt.editCategories(category, name, value, active);
	    	
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

	@When("^user launches Defect Tracking app and clicks on create defect$")
	public void user_launches_Defect_Tracking_app_and_clicks_on_create_defect() throws Throwable {
		try
		{
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
			actual[9]=pp.clickOnLogout();
			bp.waitForElement();
			actual[10]=lp.enterUname(uname);
			actual[11]=lp.enterPass(password);
			bp.waitForElement();
			actual[12]=lp.clickOnLogin();
			bp.waitForElement();
			actual[13]=pp.selectProject(project);
			actual[14]=pp.selectRelease(release);
			bp.waitForElement();
		    actual[15]=pp.clickOnDefectTracking();

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

	@When("^Create a defect with special characters$")
	public void create_a_defect_with_special_characters() throws Throwable {
		try
		{
			ep=new ExecutionPage(driver);
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 3, 5);
			String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100,100);
			String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 3, 4);
			String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String sprint=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String env=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String epicLink=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			actual[16]=ep.createDefect(projectType, issueType);
			bp.waitForElement();
			actual[17]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			actual[18]=dt.saveDefect();
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

	@Then("^should create a defect with special characters$")
	public void should_create_a_defect_with_special_characters() throws Throwable {
		try
	    {
	    	String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			bp.waitForElement();
			actual[19]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[20]=dt.updateDefect();
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

	@When("^In zephyr as a manager launch Administration and set DTS to Jira$")
	public void in_zephyr_as_a_manager_launch_Administration_and_set_DTS_to_Jira() throws Throwable {
		try
		{
		String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
		String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
		bp.waitForElement();
		bp.waitForElement();
		actual[21]=pp.clickOnLogout();
		bp.waitForElement();
		actual[22]=lp.enterUname(uname);
		actual[23]=lp.enterPass(password);
		System.out.println("UserName is"+uname);
		System.out.println("Password is"+password);  
		bp.waitForElement();
		actual[24]=lp.clickOnLogin(); 
		actual[25]=pp.launchAdministration();
		bp.waitForElement();
		actual[26]=pp.clickOnDefectTracking();
		
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

	@Then("^should set dts to jira$")
	public void should_set_dts_to_jira() throws Throwable {
		try
		{
			String dts=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 10);
			String url=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 4, 10);
	    	String username=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 10);
			String password=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 10);
			bp.waitForElement();
	    	actual[27]=pp.setDTS(dts, url, username, password);	
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

	@When("^user launches TestExecution app,Execute a testcase with any status$")
	public void user_launches_TestExecution_app_Execute_a_testcase_with_any_status() throws Throwable {
		try
		{
			tp=new TestPlanningPage(driver);
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 20, 0);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 20, 1);
			String [] navigation=new String [1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 20, 0);
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 0, 4);
			String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 1, 1);
			String environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 2, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 4, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 10, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 5));
			String [] cycle1 =new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 0, 4);
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 20,0);
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 1, 0);
			String phase_1[]=new String[1];
	    	phase_1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 20, 0);
	    	int testcase[]=new int[1];
	    	testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
	    	String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",0,4);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",20,0 );
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
			actual[28]=pp.clickOnLogout();
			bp.waitForElement();
			actual[29]=lp.enterUname(uname);
			actual[30]=lp.enterPass(password);     
			actual[31]=lp.clickOnLogin();  
			bp.waitForElement();
			actual[32]=pp.selectProject(project);
			actual[33]=pp.selectRelease(release);
			bp.waitForElement();
			actual[34]=rp.clickOnTestRep();
			bp.waitForElement();
			actual[35]=tr.clickOnRelease(release);
			actual[36]=tr.addNode(name, desc);
			bp.waitForElement();
			actual[37]=tr.navigateToNode(release, navigation);
			actual[38]=tr.addTestCase();
			bp.waitForElement();
			actual[39]=rp.clickOnTestPlanning();
			bp.waitForElement();
			actual[40]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[41]=tp.CreateCycle(cycle, build, environment, hide);
			bp.waitForElement();
			actual[42]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[43]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			actual[44]=tp.navigateToCycle(cycle1);
			bp.waitForElement();
			actual[45]=tp.addPhaseToCycle(phase);
			bp.waitForElement();
			actual[46]=tp.bulkAssignment(bulk_type);
			
			tp.goBackToCycle();
			actual[47]=rp.clickOnTestExecution();
			actual[48]=bp.waitForElement();
			actual[49]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[50]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[51]=ep.changeMultiSelectedStatus(status);
			
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

	@When("^user Clicks on D and  Clicks on Create Defect$")
	public void user_Clicks_on_D_and_Clicks_on_Create_Defect() throws Throwable {
		try
		{
		 int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
		 String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
		 String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
		 bp.waitForElement();
		 actual[52]=ep.clickOnDefectButton(testcase1);
		 bp.waitForElement();
		 actual[53]=ep.createDefect(projectType, issueType);
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

	@When("^user Create a defect with special characters$")
	public void user_Create_a_defect_with_special_characters() throws Throwable {
		try
		{
			String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 3);
			String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100,100);
			String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 4, 4);
			String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String sprint=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String env=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String epicLink=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			bp.waitForElement();
			actual[54]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			actual[55]=dt.saveDefect();
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

	@Then("^Should be able to Submit a defect with < > tag in the Description field$")
	public void should_be_able_to_Submit_a_defect_with_tag_in_the_Description_field() throws Throwable {
		try
	    {
	    	String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			bp.waitForElement();
			actual[56]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[57]=dt.updateDefect();
			bp.waitForElement();
			actual[58]=ep.closeLinkedDefectWindow();
	    	
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
