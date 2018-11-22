package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_13 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	DefectTracking dt;
	String fileName="Defect_Tracking_13";
	
	boolean[] actual=new boolean[17];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in Defect tracking page$")
	public void user_is_in_Defect_tracking_page() throws Throwable {
		try
		   {
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			 pp=new ProjectPage(driver);
			 bp=new BasePage();
			 rp=new ReleasePage(driver);
			 dt=new DefectTracking(driver);
			 pp.selectProject(projectName);
			 pp.selectRelease(releaseName);
			 actual[0]=pp.clickOnDefectTracking();
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

	@When("^User click on create defect button and enter the external Jira project and issue type$")
	public void user_click_on_create_defect_button_and_enter_the_external_Jira_project_and_issue_type() throws Throwable {
		try
		   {
			   dt=new DefectTracking(driver);
			   String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
			   String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
			   actual[1]=dt.createDefect(project, issuetype);
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

	@When("^enter the the available fields$")
	public void enter_the_the_available_fields() throws Throwable {
		try
		   {
			   dt=new DefectTracking(driver);
			   String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
				String components=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,19);
				String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,6);
				String fixVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,27);
				String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String labels=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String descType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String sprint=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String env=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String affectsVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String epicLink=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String linkedIssue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			    actual[2]=dt.fileNewDefect(summary, components, descType,desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
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

	@When("^enter the all types of custom fields$")
	public void enter_the_all_types_of_custom_fields() throws Throwable {
		try
		   {
			   dt=new DefectTracking(driver);
				String zeFreeTextField=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String zeRadioField=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,23);
				String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,25);
				String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,26);
				String[] ze_Multiple_Select_Field=new String[2];
				ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,24);
				ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,24);
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,29);
				String[] ze_Multi_Version_field=new String[2];
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,27);
				ze_Multi_Version_field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,27);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,27);
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,28);
				String ze_Label_Field=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String[] ze_Multi_User_Picker=new String[2];
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,28);
				ze_Multi_User_Picker[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,28);
				String ze_Text_Field=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
			    actual[3]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
			    actual[4]=dt.customDatePicker(syear, smonth, sday);
			    actual[5]=dt.saveDefect();
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

	@Then("^Should be able to create defect with available values$")
	public void should_be_able_to_create_defect_with_available_values() throws Throwable {
		try
		  {
			 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
			 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
			 actual[6]=dt.validateDefect(project, issuetype);
			 bp.waitForElement();
			 actual[7]=dt.updateDefect();
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

	@When("^User search a defect and select the defect to create a subtask$")
	public void user_search_a_defect_and_select_the_defect_to_create_a_subtask() throws Throwable {
		try
		   {
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,30);
			 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,14);
			 actual[8]=dt.searchDefect(defectID);
			 actual[9]=dt.selectAllDefects();
			 actual[10]=dt.defectsOperation(defectValue);
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

	@When("^enter the issue type$")
	public void enter_the_issue_type() throws Throwable {
		try
		  {
			 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,31);
			 actual[11]=dt.createDefectSubtask(issuetype);
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

	@When("^enter all the available fields with values$")
	public void enter_all_the_available_fields_with_values() throws Throwable {
		try
		   {
			   dt=new DefectTracking(driver);
			   String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
				String components=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,19);
				String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,6);
				String fixVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String desc=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,17);
				String labels=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String descType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String sprint=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String env=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String affectsVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String epicLink=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String linkedIssue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String zeRadioField=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,23);
				String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,25);
				String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,26);
				String[] ze_Multiple_Select_Field=new String[2];
				ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,24);
				ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,24);
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String[] ze_Multi_Version_field=new String[2];
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,27);
				ze_Multi_Version_field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,27);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String[] ze_Multi_User_Picker=new String[2];
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				ze_Multi_User_Picker[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
			    actual[12]=dt.fileNewDefect(summary, components,descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			    actual[13]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
			    actual[14]=dt.customDatePicker(syear, smonth, sday);
			    actual[15]=dt.saveDefect();
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

	@Then("^Should be able to create a defect subtask with available fields$")
	public void should_be_able_to_create_a_defect_subtask_with_available_fields() throws Throwable {
		try
		  {
			 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
			 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
			 actual[16]=dt.validateDefect(project, issuetype);
			 dt.updateDefect();
			
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
