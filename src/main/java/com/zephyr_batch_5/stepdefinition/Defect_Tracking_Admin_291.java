package com.zephyr_batch_5.stepdefinition;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.CreateTestCasePage;
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

public class Defect_Tracking_Admin_291 extends  LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ExecutionPage ep;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	CreateCustomFieldsPage ccp;
	CreateTestCasePage ctc;
	DefectTracking dt;
	boolean[] actual=new boolean[46];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_Admin_291";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^user Logins To Zephyr as Manager Credentials$")
	public void user_Logins_To_Zephyr_as_Manager_Credentials() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			lp=new LoginPage(driver);
			bp=new BasePage();
			lb=new LaunchBrowser();
			dt=new DefectTracking(driver);
			ccp=new CreateCustomFieldsPage(driver);
			rp=new ReleasePage(driver);
			tp=new TestPlanningPage(driver);
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
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

	@When("^User is in the Administration page$")
	public void user_is_in_the_Administration_page() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[4]=pp.launchAdministration();
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

	@When("^user Clicks on defect Admin and preferences$")
	public void user_Clicks_on_defect_Admin_and_preferences() throws Throwable {
		try
		{
			bp.waitForElement();
	    	actual[5]=ccp.moveToPreferences();
	    	
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

	@When("^user defines a property Uppercase and lowercase in custom fields$")
	public void user_defines_a_property_Uppercase_and_lowercase_in_custom_fields() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
	    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 26, 5);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 26, 6);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==false)
			{
			actual[6]=ccp.addNewProperty(category, name, value);	
			
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

	@Then("^Uppercase and lowercase Property should be defined$")
	public void uppercase_and_lowercase_Property_should_be_defined() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 26, 5);
	    	bp.waitForElement();
	    	actual[7]=ccp.validatePropertyName(name); 
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

	@When("^user clicks on defect tracking and clicks on create defect$")
	public void user_clicks_on_defect_tracking_and_clicks_on_create_defect() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			actual[8]=pp.backToProjectPage();
	    	bp.waitForElement();
	    	actual[9]=pp.selectProject(project);
			actual[10]=pp.selectRelease(release);
			bp.waitForElement();
	    	actual[11]=pp.clickOnDefectTracking();
	    	bp.waitForElement();
			actual[12]=dt.createDefect(projectType, issueType);

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

	@When("^Creates a Defect of Type MultiCheckboxes,Free MultiSelect,Free Radiobutton,user,Multi user and single version picker$")
	public void creates_a_Defect_of_Type_MultiCheckboxes_Free_MultiSelect_Free_Radiobutton_user_Multi_user_and_single_version_picker() throws Throwable {
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
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			
			
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 22, 12);
			String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 22, 13);
			String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multiple_Select_Field[]=new String[6];
			ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 19, 11);
			ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 20, 11);
			ze_Multiple_Select_Field[2]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 21, 11);
			ze_Multiple_Select_Field[3]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 22, 11));
			ze_Multiple_Select_Field[4]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 23, 11);
			ze_Multiple_Select_Field[5]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 24, 11);
			String ze_Multi_Version_field[]=new String[1];
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 16, 7);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 21, 9);
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 17, 7);
			
			bp.waitForElement();
			actual[13]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, affectsVersion, affectsVersion, affectsVersion, affectsVersion, affectsVersion);
	        bp.waitForElement();
	        actual[14]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
	        actual[15]=dt.saveDefect();
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

	@Then("^should create a defect with custom fields$")
	public void should_create_a_defect_with_custom_fields() throws Throwable {
		try
	    {
	    	String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
	    	bp.waitForElement();
			actual[16]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[17]=dt.updateDefect();
		
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

	@When("^user is in the Test Repository page,creates a phase$")
	public void user_is_in_the_Test_Repository_page_creates_a_phase() throws Throwable {
		try
		   {
				String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 20, 2);
				String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 20, 3);
				String [] navigation=new String [1];
				navigation[0]=name;
				actual[18]=pp.selectProject(project);
				actual[19]=pp.selectRelease(release);
				bp.waitForElement();
				actual[20]=rp.clickOnTestRep();
				bp.waitForElement();
				actual[21]=tr.clickOnRelease(release);
				actual[22]=tr.addNode(name, desc);
				bp.waitForElement();
				actual[23]=tr.navigateToNode(release, navigation);
				bp.waitForElement();
				tr.addTestCase();
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

	@When("^Launches Test planning,creates a cycle Adds phase to cycle$")
	public void launches_Test_planning_creates_a_cycle_Adds_phase_to_cycle() throws Throwable {
		try
		{
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 17, 3);
			String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 2, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 6, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 7, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 7, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 1);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 8, 5));
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 1, 0);
			String [] cycle1 =new String[1];
			cycle1[0]=cycle;
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 20,2);
			String phase_1[]=new String[1];
		    phase_1[0]=phase;
			bp.waitForElement();
			actual[24]=rp.clickOnTestPlanning();
			actual[25]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[26]=tp.CreateCycle(cycle, build, Environment, hide);
			bp.waitForElement();
			actual[27]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[28]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			actual[29]=tp.navigateToCycle(cycle1);
			bp.waitForElement();
			actual[30]=tp.addPhaseToCycle(phase);
			bp.waitForElement();
			actual[31]=tp.bulkAssignment(bulk_type);
			bp.waitForElement();
			actual[32]=tp.goBackToCycle();
			
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

	@When("^user Launches Test Execution,Executes Testcase with Any status and clicks on d button$")
	public void user_Launches_Test_Execution_Executes_Testcase_with_Any_status_and_clicks_on_d_button() throws Throwable {
		try
		{
			ep=new ExecutionPage(driver);
			bp.waitForElement();
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",17,3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",20,2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[33]=rp.clickOnTestExecution();
			actual[34]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[35]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[36]=ep.changeMultiSelectedStatus(status);
			bp.waitForElement();
			actual[37]=ep.clickOnDefectButton(testcase1);
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

	@Then("^Link Defect window should be launched in Test execution page$")
	public void link_Defect_window_should_be_launched_in_Test_execution_page() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[38]=ep.validateLinkDefectWindow();
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

	@When("^user clicks on Create defect in TestExecution Page$")
	public void user_clicks_on_Create_defect_in_TestExecution_Page() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			bp.waitForElement();
			actual[39]=dt.createDefect(projectType, issueType);
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

	@When("^creates a defect with Multicheckbox,Free multiselect,Free radiobutton,user,multi user and single version picker$")
	public void creates_a_defect_with_Multicheckbox_Free_multiselect_Free_radiobutton_user_multi_user_and_single_version_picker() throws Throwable {
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
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			
			
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 22, 12);
			String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 22, 13);
			String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multiple_Select_Field[]=new String[6];
			ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 19, 11);
			ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 20, 11);
			ze_Multiple_Select_Field[2]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 21, 11);
			ze_Multiple_Select_Field[3]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 22, 11));
			ze_Multiple_Select_Field[4]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 23, 11);
			ze_Multiple_Select_Field[5]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 24, 11);
			String ze_Multi_Version_field[]=new String[1];
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 16, 7);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 21, 9);
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 17, 7);
			bp.waitForElement();
			actual[40]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, affectsVersion, affectsVersion, affectsVersion, affectsVersion, affectsVersion);
			bp.waitForElement();
			actual[41]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[42]=dt.saveDefect();
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

	@Then("^should be able to file a Defect when customfield property of any type is defined as uppercase and lowercase$")
	public void should_be_able_to_file_a_Defect_when_customfield_property_of_any_type_is_defined_as_uppercase_and_lowercase() throws Throwable {
		try
	    {
	    String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
		String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);	
		actual[43]=dt.validateDefect(projectType, issueType);
		bp.waitForElement();
		actual[44]=dt.updateDefect();
		bp.waitForElement();
		actual[45]=ep.clickOnCancelDefectWindow();
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
