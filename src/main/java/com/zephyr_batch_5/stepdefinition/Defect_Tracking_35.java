package com.zephyr_batch_5.stepdefinition;


import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
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

public class Defect_Tracking_35 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestPlanningPage tp;
	TestRepositoryPage tr;
	ExecutionPage ep;
	CreateTestCasePage ctc;
	DefectTracking dt;
	boolean[] actual=new boolean[272];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_35";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^User is in a Page Of Defect Tracking and clicks on Create Defect$")
	public void user_is_in_a_Page_Of_Defect_Tracking_and_clicks_on_Create_Defect() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			rp=new ReleasePage(driver);
			dt=new DefectTracking(driver);
			bp=new BasePage();
			ep=new ExecutionPage(driver);
			rp=new ReleasePage(driver);
			tp=new TestPlanningPage(driver);
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			ctc=new CreateTestCasePage(driver);
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 19, 0);
			actual[0]=pp.selectProject(project);
			actual[1]=pp.selectRelease(release);
			bp.waitForElement();
		    actual[2]=pp.clickOnDefectTracking();
		    bp.waitForElement();
		    actual[3]=dt.createDefect(projectType, issueType);
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

	@When("^user creates a defect with select list of values containing only numbers$")
	public void user_creates_a_defect_with_select_list_of_values_containing_only_numbers() throws Throwable {
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multiple_Select_Field[]=new String[1];
				ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_Version_field[]=new String[1];
				String ze_Single_Select_Field=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 16, 3));
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
				String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 19, 0);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				bp.waitForElement();
				actual[4]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		        bp.waitForElement();
		        actual[5]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
		        bp.waitForElement();
		        actual[6]=dt.saveDefect();
				bp.waitForElement();
				actual[7]=dt.validateDefect(projectType, issueType);
				bp.waitForElement();
				actual[8]=dt.updateDefect();
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

	@When("^user creates a defect with Select List of values in UPPERCASE$")
	public void user_creates_a_defect_with_Select_List_of_values_in_UPPERCASE() throws Throwable {
		 try
		   {
			    String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
				String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 20, 0);
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multiple_Select_Field[]=new String[1];
				ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_Version_field[]=new String[1];
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 17, 3);
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				bp.waitForElement();
				actual[9]=dt.createDefect(projectType, issueType);
				bp.waitForElement();
				actual[10]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		        bp.waitForElement();
		        actual[11]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
		        bp.waitForElement();
		        actual[12]=dt.saveDefect();
		        bp.waitForElement();
				actual[13]=dt.validateDefect(projectType, issueType);
				bp.waitForElement();
				actual[14]=dt.updateDefect();
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

	@When("^create a defct with select list of values in lower case$")
	public void create_a_defct_with_select_list_of_values_in_lower_case() throws Throwable {
		try
		   {
			    String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			    String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 21, 0);
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multiple_Select_Field[]=new String[1];
				ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_Version_field[]=new String[1];
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 18, 3);
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				actual[15]=dt.createDefect(projectType, issueType);
				bp.waitForElement();
				actual[16]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		        bp.waitForElement();
		        actual[17]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
		        bp.waitForElement();
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

	@Then("^should be able to create defect with Select LOV in lowercase$")
	public void should_be_able_to_create_defect_with_Select_LOV_in_lowercase() throws Throwable {
		 try
		    {
		    	String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
				String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 21, 0);
				bp.waitForElement();
				actual[19]=dt.validateDefect(projectType, issueType);
				bp.waitForElement();
				actual[20]=dt.updateDefect();
	
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

	@When("^user Creates a defect with Select List of values containing alphanumeric characters and spaces$")
	public void user_Creates_a_defect_with_Select_List_of_values_containing_alphanumeric_characters_and_spaces() throws Throwable {
		try
		   {   
			    String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			    String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 22, 0);
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multiple_Select_Field[]=new String[1];
				ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_Version_field[]=new String[1];
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 19, 3);
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				bp.waitForElement();
				actual[21]=dt.createDefect(projectType, issueType);
				bp.waitForElement();
				actual[22]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		        bp.waitForElement();
		        actual[23]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
		        bp.waitForElement();
		        actual[24]=dt.saveDefect();
		        bp.waitForElement();
				actual[25]=dt.validateDefect(projectType, issueType);
				bp.waitForElement();
				actual[26]=dt.updateDefect();
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

	@When("^Create a defect with Select List of values containing special characters$")
	public void create_a_defect_with_Select_List_of_values_containing_special_characters() throws Throwable {
		try
		   {
			    String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			    String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 20, 0);
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multiple_Select_Field[]=new String[1];
				ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_Version_field[]=new String[1];
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 20, 3);
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				bp.waitForElement();
				actual[27]=dt.createDefect(projectType, issueType);
				bp.waitForElement();
				actual[28]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		        bp.waitForElement();
		        actual[29]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
		        bp.waitForElement();
		        actual[30]=dt.saveDefect();
		        bp.waitForElement();
				actual[31]=dt.validateDefect(projectType, issueType);
				bp.waitForElement();
				actual[32]=dt.updateDefect();
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

	@When("^Create a defect with Select List of values containing international characters$")
	public void create_a_defect_with_Select_List_of_values_containing_international_characters() throws Throwable {
		try
		   {
			    String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			    String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 19, 0);
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multiple_Select_Field[]=new String[1];
				ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_Version_field[]=new String[1];
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 21, 3);
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				bp.waitForElement();
				actual[33]=dt.createDefect(projectType, issueType);
				bp.waitForElement();
				actual[34]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		        bp.waitForElement();
		        actual[35]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
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

	@Then("^should be able to create a defect with select LOV$")
	public void should_be_able_to_create_a_defect_with_select_LOV() throws Throwable {
		 try
		    {
		    	String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
				String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 19, 0);
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

	@When("^User is in page of defect tracking,and searches defect$")
	public void user_is_in_page_of_defect_tracking_and_searches_defect() throws Throwable {
		try
        { 
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 16, 2);
			bp.waitForElement();
			actual[39]=pp.clickOnDefectTracking();
			bp.waitForElement();
			actual[40]=dt.searchDefect(defectId);
			
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

	@When("^selects defect and clicks on create subtask$")
	public void selects_defect_and_clicks_on_create_subtask() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[41]=dt.selectAllDefects();
			actual[42]=dt.clickOnCreateSubTask();
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

	@When("^Create the subtask with Select LOV containing only numbers$")
	public void create_the_subtask_with_Select_LOV_containing_only_numbers() throws Throwable {
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multiple_Select_Field[]=new String[1];
				ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_Version_field[]=new String[1];
				String ze_Single_Select_Field=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 16, 3));
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				bp.waitForElement();
				actual[43]=dt.createDefectSubtask(issueType);
				bp.waitForElement();
				actual[44]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		        bp.waitForElement();
		        actual[45]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
		        bp.waitForElement();
		        actual[46]=dt.saveDefect();
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

	@Then("^subtask with Select LOV containing only numbers should be created$")
	public void subtask_with_Select_LOV_containing_only_numbers_should_be_created() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			bp.waitForElement();
			actual[47]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[48]=dt.updateDefect();
		
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

	@When("^Create the subtask with Select List of values in UPPERCASE$")
	public void create_the_subtask_with_Select_List_of_values_in_UPPERCASE() throws Throwable {
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multiple_Select_Field[]=new String[1];
				ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_Version_field[]=new String[1];
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 17, 3);
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
				bp.waitForElement();
				String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 17, 2);
				actual[49]=dt.searchDefect(defectId);
				bp.waitForElement();
				actual[50]=dt.selectAllDefects();
				actual[51]=dt.clickOnCreateSubTask();
				bp.waitForElement();
				actual[52]=dt.createDefectSubtask(issueType);
				bp.waitForElement();
				actual[53]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
				bp.waitForElement();
				actual[54]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
				bp.waitForElement();
				actual[55]=dt.saveDefect();
				bp.waitForElement();
				actual[56]=dt.validateDefect(projectType, issueType);
				bp.waitForElement();
				actual[57]=dt.updateDefect();
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

	@When("^Create subtask with Select List Of Values in lowercase$")
	public void create_subtask_with_Select_List_Of_Values_in_lowercase() throws Throwable {
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multiple_Select_Field[]=new String[1];
				ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_Version_field[]=new String[1];
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 18, 3);
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
				bp.waitForElement();
				String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 18, 2);
				actual[58]=dt.searchDefect(defectId);
				bp.waitForElement();
				actual[59]=dt.selectAllDefects();
				actual[60]=dt.clickOnCreateSubTask();
				bp.waitForElement();
				actual[61]=dt.createDefectSubtask(issueType);
				bp.waitForElement();
				actual[62]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
				bp.waitForElement();
				actual[63]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
				bp.waitForElement();
				actual[64]=dt.saveDefect();
				bp.waitForElement();
				actual[65]=dt.validateDefect(projectType, issueType);
				bp.waitForElement();
				actual[66]=dt.updateDefect();
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

	@When("^Create a subtask with Select List LOV containing alphanumeric characters and spaces$")
	public void create_a_subtask_with_Select_List_LOV_containing_alphanumeric_characters_and_spaces() throws Throwable {
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multiple_Select_Field[]=new String[1];
				ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_Version_field[]=new String[1];
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 19, 3);
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 19, 2);
				actual[67]=dt.searchDefect(defectId);
				bp.waitForElement();
				actual[68]=dt.selectAllDefects();
				actual[69]=dt.clickOnCreateSubTask();
				bp.waitForElement();
				actual[70]=dt.createDefectSubtask(issueType);
				bp.waitForElement();
				actual[71]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
				bp.waitForElement();
				actual[72]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
				bp.waitForElement();
				actual[73]=dt.saveDefect();
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

	@Then("^subtask with Select List LOV containing alphanumeric characters to be created$")
	public void subtask_with_Select_List_LOV_containing_alphanumeric_characters_to_be_created() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			bp.waitForElement();
			actual[74]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[75]=dt.updateDefect();
		
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

	@When("^Create a subtask with select List of values containing special characters$")
	public void create_a_subtask_with_select_List_of_values_containing_special_characters() throws Throwable {
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multiple_Select_Field[]=new String[1];
				ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_Version_field[]=new String[1];
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 20, 3);
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
				bp.waitForElement();
				String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 20, 2);
				actual[76]=dt.searchDefect(defectId);
				bp.waitForElement();
				actual[77]=dt.selectAllDefects();
				actual[78]=dt.clickOnCreateSubTask();
				bp.waitForElement();
				actual[79]=dt.createDefectSubtask(issueType);
				bp.waitForElement();
				actual[80]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
				bp.waitForElement();
				actual[81]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
				bp.waitForElement();
				actual[82]=dt.saveDefect();
				bp.waitForElement();
				actual[83]=dt.validateDefect(projectType, issueType);
				bp.waitForElement();
				actual[84]=dt.updateDefect();
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

	@When("^create the sub task with select list of values containg International characters$")
	public void create_the_sub_task_with_select_list_of_values_containg_International_characters() throws Throwable {
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multiple_Select_Field[]=new String[1];
				ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_Version_field[]=new String[1];
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 21, 3);
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				bp.waitForElement();
				String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 21, 2);
				actual[85]=dt.searchDefect(defectId);
				bp.waitForElement();
				actual[86]=dt.selectAllDefects();
				actual[87]=dt.clickOnCreateSubTask();
				bp.waitForElement();
				actual[88]=dt.createDefectSubtask(issueType);
				bp.waitForElement();
				actual[89]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
				bp.waitForElement();
				actual[90]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
				bp.waitForElement();
				actual[91]=dt.saveDefect();
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

	@Then("^should be able to create the sub task with select list of values$")
	public void should_be_able_to_create_the_sub_task_with_select_list_of_values() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			bp.waitForElement();
			actual[92]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[93]=dt.updateDefect();
		
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

	@When("^user Is in a Page of Test repository,creates a phase and adds few Testcases$")
	public void user_Is_in_a_Page_of_Test_repository_creates_a_phase_and_adds_few_Testcases() throws Throwable {
		try
		   {
			   
				rp=new ReleasePage(driver);
				tp=new TestPlanningPage(driver);
				rp=new ReleasePage(driver);
				tr=new TestRepositoryPage(driver);
				ctc=new CreateTestCasePage(driver);
				String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 10, 5);
				String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 10, 6);
				String [] navigation=new String [1];
				navigation[0]=name;
				bp.waitForElement();
				actual[94]=rp.clickOnTestRep();
				bp.waitForElement();
				actual[95]=tr.clickOnRelease(release);
				actual[96]=tr.addNode(name, desc);
				bp.waitForElement();
				actual[97]=tr.navigateToNode(release, navigation);
				bp.waitForElement();
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

	@When("^user Is in a Page of test planning,creates a cycle and assign phase to cycle and assign testcases to anyone$")
	public void user_Is_in_a_Page_of_test_planning_creates_a_cycle_and_assign_phase_to_cycle_and_assign_testcases_to_anyone() throws Throwable {
		 try
		   {
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 12, 4);
				String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 2, 1);
				String Environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 4, 2);
				String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
				String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 8, 1);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 9, 2));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
				String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 8, 1);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 9, 5));
				String [] cycle1 =new String[1];
				cycle1[0]=cycle;
				String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 10,5);
				String phase_1[]=new String[1];
				String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 2, 0);
			    phase_1[0]=phase;
				bp.waitForElement();
				actual[98]=rp.clickOnTestPlanning();
				actual[99]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				actual[100]=tp.CreateCycle(cycle, build, Environment, hide);
				bp.waitForElement();
				actual[101]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[102]=tp.saveTestCycle(); 
				bp.waitForElement(); 
				actual[103]=tp.navigateToCycle(cycle1);
				bp.waitForElement();
				actual[104]=tp.addPhaseToCycle(phase);
				bp.waitForElement();
				actual[105]=tp.bulkAssignment(bulk_type);
				bp.waitForElement();
				tp.goBackToCycle();
			
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

	@When("^user Launches Test Execution,selects testcases and executes with any status and clicks on d button$")
	public void user_Launches_Test_Execution_selects_testcases_and_executes_with_any_status_and_clicks_on_d_button() throws Throwable {
		try
		{
			ep=new ExecutionPage(driver);
			bp.waitForElement();
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",12,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",10,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[106]=rp.clickOnTestExecution();
			actual[107]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[108]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[109]=ep.changeMultiSelectedStatus(status);
			bp.waitForElement();
			actual[110]=ep.clickOnDefectButton(testcase1);
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

	@Then("^Link defect window to be Launched$")
	public void link_defect_window_to_be_Launched() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[111]=ep.validateLinkDefectWindow();
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

	@When("^user clicks on Create Defect$")
	public void user_clicks_on_Create_Defect() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			bp.waitForElement();
			actual[112]=dt.createDefect(projectType, issueType);
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

	@When("^creates the defect with select list of Values containing Only Numbers$")
	public void creates_the_defect_with_select_list_of_Values_containing_Only_Numbers() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multiple_Select_Field[]=new String[1];
			ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_Version_field[]=new String[1];
			String ze_Single_Select_Field=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 16, 3));
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			bp.waitForElement();
			actual[113]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			actual[114]=bp.waitForElement();
			actual[115]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        actual[116]=bp.waitForElement();
			actual[117]=dt.saveDefect();
			actual[118]=bp.waitForElement();
			actual[119]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[120]=dt.updateDefect();
			bp.waitForElement();
			actual[121]=ep.closeLinkedDefectWindow();
			
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

	@When("^creates The Defect With select lov consists Uppercase characters$")
	public void creates_The_Defect_With_select_lov_consists_Uppercase_characters() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multiple_Select_Field[]=new String[1];
			ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_Version_field[]=new String[1];
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 17, 3);
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",12,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",10,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			actual[122]=bp.waitForElement();
			//actual[122]=rp.clickOnTestExecution();
			actual[123]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[124]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[125]=ep.changeMultiSelectedStatus(status);
			bp.waitForElement();
			actual[126]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			actual[127]=dt.createDefect(projectType, issueType);
			actual[128]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[129]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
	        actual[130]=dt.saveDefect();
			
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

	@Then("^Defect With select lov consists Uppercase characters to be created$")
	public void defect_With_select_lov_consists_Uppercase_characters_to_be_created() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			bp.waitForElement();
			actual[131]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[132]=dt.updateDefect();
			bp.waitForElement();
			actual[133]=ep.closeLinkedDefectWindow();
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

	@When("^create a defect with Select LOV consists  lowercase characters$")
	public void create_a_defect_with_Select_LOV_consists_lowercase_characters() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multiple_Select_Field[]=new String[1];
			ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_Version_field[]=new String[1];
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 18, 3);
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",12,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",10,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			actual[134]=bp.waitForElement();
			//actual[134]=rp.clickOnTestExecution();
			actual[135]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[136]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[137]=ep.changeMultiSelectedStatus(status);
			bp.waitForElement();
			actual[138]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			actual[139]=dt.createDefect(projectType, issueType);
			bp.waitForElement();
			actual[140]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			actual[141]=bp.waitForElement();
			actual[142]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        actual[143]=bp.waitForElement();
			actual[144]=dt.saveDefect();
			bp.waitForElement();
			actual[145]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[146]=dt.updateDefect();
			bp.waitForElement();
			actual[147]=ep.closeLinkedDefectWindow();
			
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

	@When("^Create a defect with Select List LOV consists Alphanumeric characters and spaces$")
	public void create_a_defect_with_Select_List_LOV_consists_Alphanumeric_characters_and_spaces() throws Throwable {
		
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multiple_Select_Field[]=new String[1];
				ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_Version_field[]=new String[1];
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 19, 3);
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String[] cycleName=new String[2];          
				cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",12,4 );
				cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",10,5);
				String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
				int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
				actual[148]=bp.waitForElement();
				//actual[148]=rp.clickOnTestExecution();
				actual[149]=tr.navigateToNode(release, cycleName);
				bp.waitForElement();
				actual[150]=ep.selectAndDeselectAllTestCase();
				bp.waitForElement();
				actual[151]=ep.changeMultiSelectedStatus(status);
				bp.waitForElement();
				actual[152]=ep.clickOnDefectButton(testcase1);
				bp.waitForElement();
				actual[153]=dt.createDefect(projectType, issueType);
				actual[154]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
				bp.waitForElement();
				actual[155]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
		        bp.waitForElement();
				actual[156]=dt.saveDefect();
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

	@Then("^defect with Select List LOV consists Alphanumeric should be created$")
	public void defect_with_Select_List_LOV_consists_Alphanumeric_should_be_created() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			bp.waitForElement();
			actual[157]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[158]=dt.updateDefect();
			bp.waitForElement();
			actual[159]=ep.closeLinkedDefectWindow();
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

	@When("^User creates defect with select LOV consists special characters$")
	public void user_creates_defect_with_select_LOV_consists_special_characters() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multiple_Select_Field[]=new String[1];
			ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_Version_field[]=new String[1];
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 20, 3);
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",12,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",10,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			actual[160]=bp.waitForElement();
			//actual[160]=rp.clickOnTestExecution();
			actual[161]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[162]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[163]=ep.changeMultiSelectedStatus(status);
			bp.waitForElement();
			actual[164]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			actual[165]=dt.createDefect(projectType, issueType);
			actual[166]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[167]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[168]=dt.saveDefect();
			bp.waitForElement();
			dt.updateDefect();
			bp.waitForElement();
			ep.closeLinkedDefectWindow();
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

	@When("^user create The Defect With Select lov containing international characters$")
	public void user_create_The_Defect_With_Select_lov_containing_international_characters() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multiple_Select_Field[]=new String[1];
			ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_Version_field[]=new String[1];
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 21, 3);
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",12,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",10,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			actual[169]=bp.waitForElement();
			//actual[169]=rp.clickOnTestExecution();
			actual[170]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[171]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[172]=ep.changeMultiSelectedStatus(status);
			bp.waitForElement();
			actual[173]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			actual[174]=dt.createDefect(projectType, issueType);
			actual[175]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[176]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
			actual[177]=bp.waitForElement();
			actual[178]=dt.saveDefect();
			actual[179]=bp.waitForElement();
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

	@Then("^Defect With Select lov containing international characters should be created$")
	public void defect_With_Select_lov_containing_international_characters_should_be_created() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			actual[180]=bp.waitForElement();
			actual[181]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[182]=dt.updateDefect();
			bp.waitForElement();
			actual[183]=ep.closeLinkedDefectWindow();
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

	@When("^User Launch test repository page,creates a phase and Adds Few TestCases$")
	public void user_Launch_test_repository_page_creates_a_phase_and_Adds_Few_TestCases() throws Throwable {
		try
		   {
			   
				rp=new ReleasePage(driver);
				tp=new TestPlanningPage(driver);
				rp=new ReleasePage(driver);
				tr=new TestRepositoryPage(driver);
				ctc=new CreateTestCasePage(driver);
				String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 12, 5);
				String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 12, 6);
				String [] navigation=new String [1];
				navigation[0]=name;
				bp.waitForElement();
				actual[184]=rp.clickOnTestRep();
				bp.waitForElement();
				actual[185]=tr.clickOnRelease(release);
				actual[186]=tr.addNode(name, desc);
				bp.waitForElement();
				actual[187]=tr.navigateToNode(release, navigation);
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

	@When("^User Launch TestPlanning page,create a cycle and assign Phase to cycle$")
	public void user_Launch_TestPlanning_page_create_a_cycle_and_assign_Phase_to_cycle() throws Throwable {
		try
		{
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 14, 4);
			String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 3, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 4, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 7, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 8, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 1);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 9, 5));
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 2, 0);
			String [] cycle1 =new String[1];
			cycle1[0]=cycle;
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 12,5);
			String phase_1[]=new String[1];
		    phase_1[0]=phase;
			bp.waitForElement();
			actual[188]=rp.clickOnTestPlanning();
			actual[189]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[190]=tp.CreateCycle(cycle, build, Environment, hide);
			bp.waitForElement();
			actual[191]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[192]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			actual[190]=tp.navigateToCycle(cycle1);
			bp.waitForElement();
			actual[193]=tp.addPhaseToCycle(phase);
			bp.waitForElement();
			actual[194]=tp.bulkAssignment(bulk_type);
			bp.waitForElement();
			tp.goBackToCycle();
			
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

	@When("^Launches TestExecution,selects testcases and executes with any status$")
	public void launches_TestExecution_selects_testcases_and_executes_with_any_status() throws Throwable {
	   try
	   {
			ep=new ExecutionPage(driver);
			bp.waitForElement();
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",14,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",12,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			bp.waitForElement();
			bp.waitForElement();
			actual[195]=rp.clickOnTestExecution();
			actual[196]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[197]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[198]=ep.changeMultiSelectedStatus(status);
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

	@When("^user click on d button$")
	public void user_click_on_d_button() throws Throwable {
		try
		{
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			actual[199]=ep.clickOnDefectButton(testcase1);
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

	@Then("^defect window to be opened$")
	public void defect_window_to_be_opened() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[200]=ep.validateLinkDefectWindow();
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

	@When("^User create the subtask with select Lov consists containing only numbers$")
	public void user_create_the_subtask_with_select_Lov_consists_containing_only_numbers() throws Throwable {
		try
		{
			
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 22, 2);
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multiple_Select_Field[]=new String[1];
			ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_Version_field[]=new String[1];
			String ze_Single_Select_Field=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 16, 3));
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",14,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",12,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			bp.waitForElement();
			bp.waitForElement();
//			actual[201]=rp.clickOnTestExecution();
//			actual[202]=tr.navigateToNode(release, cycleName);
//			bp.waitForElement();
//			actual[203]=ep.selectAndDeselectAllTestCase();
//			bp.waitForElement();
//			actual[204]=ep.changeMultiSelectedStatus(status);
//			actual[205]=ep.clickOnDefectButton(testcase1);
			actual[201]=bp.waitForElement();
			actual[202]=bp.waitForElement();
			actual[203]=ep.searchDefect(defectId);
			actual[204]=bp.waitForElement();
			actual[205]=ep.clickOnSubTask();
			actual[206]=bp.waitForElement();
			actual[207]=dt.createDefectSubtask(issueType);
			actual[208]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			actual[209]=bp.waitForElement();
			actual[210]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
	        actual[211]=dt.saveDefect();
	        bp.waitForElement();
	        actual[212]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
		    actual[213]=dt.updateDefect();
			bp.waitForElement();
			actual[214]=ep.closeLinkedDefectWindow();
			
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

	@When("^create the sub task with select list in UPPERCASE characters$")
	public void create_the_sub_task_with_select_list_in_UPPERCASE_characters() throws Throwable {
		try
		{
			
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 23, 2);
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multiple_Select_Field[]=new String[1];
			ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_Version_field[]=new String[1];
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 17, 3);
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",14,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",12,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[215]=bp.waitForElement();
			//actual[215]=rp.clickOnTestExecution();
			actual[216]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[217]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[218]=ep.changeMultiSelectedStatus(status);
			actual[219]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			bp.waitForElement();
			actual[220]=ep.searchDefect(defectId);
			bp.waitForElement();
			actual[221]=ep.clickOnSubTask();
			bp.waitForElement();
			actual[222]=dt.createDefectSubtask(issueType);
			actual[223]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			actual[224]=bp.waitForElement();
			actual[225]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
	        actual[226]=dt.saveDefect();
			
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
	

	@Then("^sub task with lov in uppercase should be created$")
	public void sub_task_with_lov_in_uppercase_should_be_created() throws Throwable {
		 try
		   {
			   String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			   String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			   actual[227]=dt.validateDefect(projectType, issueType);
			   bp.waitForElement();
			   actual[228]=dt.updateDefect();
			   bp.waitForElement();
			   actual[229]=ep.closeLinkedDefectWindow();
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
	@When("^create a subtask with select LOV in lowercase characters$")
	public void create_a_subtask_with_select_LOV_in_lowercase_characters() throws Throwable {
		try
		{
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 26, 2);
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multiple_Select_Field[]=new String[1];
			ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_Version_field[]=new String[1];
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 18, 3);
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",14,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",12,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			bp.waitForElement();
			//rp.clickOnTestExecution();
			tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			ep.changeMultiSelectedStatus(status);
			ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			bp.waitForElement();
			ep.searchDefect(defectId);
			bp.waitForElement();
			ep.clickOnSubTask();
			bp.waitForElement();
			dt.createDefectSubtask(issueType);
			dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
	        dt.saveDefect();
			
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

	@Then("^The sub task with Select list of values in lowercase to be able to create$")
	public void the_sub_task_with_Select_list_of_values_in_lowercase_to_be_able_to_create() throws Throwable {
		try
		   {
			   String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			   String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			   dt.validateDefect(projectType, issueType);
			   bp.waitForElement();
			   dt.updateDefect();
			   bp.waitForElement();
			   ep.closeLinkedDefectWindow();
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


	@When("^create the sub task with select LOV containing Alpha Numeric characters and Spaces$")
	public void create_the_sub_task_with_select_LOV_containing_Alpha_Numeric_characters_and_Spaces() throws Throwable {
		try
		{
			
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 24, 2);
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multiple_Select_Field[]=new String[1];
			ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_Version_field[]=new String[1];
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 19, 3);
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",14,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",12,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			bp.waitForElement();
			actual[230]=bp.waitForElement();
			//actual[230]=rp.clickOnTestExecution();
			actual[231]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[232]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[233]=ep.changeMultiSelectedStatus(status);
			actual[234]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			bp.waitForElement();
			actual[235]=ep.searchDefect(defectId);
			bp.waitForElement();
			actual[236]=ep.clickOnSubTask();
			bp.waitForElement();
			actual[237]=dt.createDefectSubtask(issueType);
			actual[238]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[239]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
	        actual[240]=dt.saveDefect();
	        bp.waitForElement();
	        actual[241]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
		    actual[242]=dt.updateDefect();
			bp.waitForElement();
			actual[243]=ep.closeLinkedDefectWindow();
			
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

	@When("^create the SubTask with select list of values containing special characters$")
	public void create_the_SubTask_with_select_list_of_values_containing_special_characters() throws Throwable {
		try
		{
			
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 25, 2);
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multiple_Select_Field[]=new String[1];
			ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_Version_field[]=new String[1];
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 20, 3);
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",14,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",12,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			bp.waitForElement();
			actual[244]=bp.waitForElement();
			//actual[244]=rp.clickOnTestExecution();
			actual[245]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[246]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[247]=ep.changeMultiSelectedStatus(status);
			actual[248]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			bp.waitForElement();
			actual[249]=ep.searchDefect(defectId);
			bp.waitForElement();
			actual[250]=ep.clickOnSubTask();
			bp.waitForElement();
			actual[251]=dt.createDefectSubtask(issueType);
			actual[252]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[253]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
	        actual[254]=dt.saveDefect();
	        bp.waitForElement();
	        actual[255]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
		    actual[256]=dt.updateDefect();
			bp.waitForElement();
			actual[257]=ep.closeLinkedDefectWindow();
			
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

	@When("^create the subTask with select LOV consists International characters$")
	public void create_the_subTask_with_select_LOV_consists_International_characters() throws Throwable {
		try
		{
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 26, 2);
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multiple_Select_Field[]=new String[1];
			ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_Version_field[]=new String[1];
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 21, 3);
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",14,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",12,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[258]=bp.waitForElement();
			//actual[258]=rp.clickOnTestExecution();
			actual[259]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[260]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[261]=ep.changeMultiSelectedStatus(status);
			actual[262]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			bp.waitForElement();
			actual[263]=ep.searchDefect(defectId);
			bp.waitForElement();
			actual[264]=ep.clickOnSubTask();
			bp.waitForElement();
			actual[265]=dt.createDefectSubtask(issueType);
			actual[266]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[267]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
	        actual[268]=dt.saveDefect();
			
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

	@Then("^subTask with select LOV consists International characters should be able to create$")
	public void subtask_with_select_LOV_consists_International_characters_should_be_able_to_create() throws Throwable {
		try
		   {
			   String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			   String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			   actual[269]=dt.validateDefect(projectType, issueType);
				bp.waitForElement();
				actual[270]=dt.updateDefect();
				bp.waitForElement();
				actual[271]=ep.closeLinkedDefectWindow();
				bp.waitForElement();
				tp.doubleClickOnCycle(release);
				bp.waitForElement();
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
