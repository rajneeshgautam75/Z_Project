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

public class Defect_Tracking_33 extends LaunchBrowser {
	
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
	boolean[] actual=new boolean[266];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_33";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^User is in a Defect Tracking Page and clicks on create defect$")
	public void user_is_in_a_Defect_Tracking_Page_and_clicks_on_create_defect() throws Throwable {
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
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
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

	@When("^user Creates a defect with only numbers in custom field of type Text Field$")
	public void user_Creates_a_defect_with_only_numbers_in_custom_field_of_type_Text_Field() throws Throwable {
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
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 1, 9));
				bp.waitForElement();
				actual[4]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		        bp.waitForElement();
		        actual[5]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
		        bp.waitForElement();
		        actual[6]=dt.saveDefect();
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

	@Then("^should be able to create a defect with only numbers$")
	public void should_be_able_to_create_a_defect_with_only_numbers() throws Throwable {
		try
		{
		String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
		String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
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

	@When("^User Creates a defect with custom field of type Text Field in UPPERCASE$")
	public void user_Creates_a_defect_with_custom_field_of_type_Text_Field_in_UPPERCASE() throws Throwable {
		 try
		   {
			    String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
				String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 17, 0);
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
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 9);
				bp.waitForElement();
				actual[9]=dt.createDefect(projectType, issueType);
				bp.waitForElement();
				actual[10]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		        bp.waitForElement();
		        actual[11]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
		        bp.waitForElement();
		        actual[12]=dt.saveDefect();
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

	@Then("^should create a defect with custom field of type Text Field in UPPERCASE$")
	public void should_create_a_defect_with_custom_field_of_type_Text_Field_in_UPPERCASE() throws Throwable {
		 try
		    {
		    	String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
		    	String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 17, 0);
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

	@When("^user Creates a defect with custom field of type Text Field in lowercase$")
	public void user_Creates_a_defect_with_custom_field_of_type_Text_Field_in_lowercase() throws Throwable {
		try
		   {
			    String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			    String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 17, 0);
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
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 3, 9);
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

	@Then("^Defect should be created with custom Field of type TextField$")
	public void defect_should_be_created_with_custom_Field_of_type_TextField() throws Throwable {
		 try
		    {
		    	String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
				String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 17, 0);
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

	@When("^Creates a defect with custom field of type Text Field containing alphanumeric characters and spaces$")
	public void creates_a_defect_with_custom_field_of_type_Text_Field_containing_alphanumeric_characters_and_spaces() throws Throwable {
		try
		   {   
			    String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			    String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 18, 0);
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
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 4, 9);
				actual[21]=dt.createDefect(projectType, issueType);
				bp.waitForElement();
				actual[22]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		        bp.waitForElement();
		        actual[23]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
		        bp.waitForElement();
		        actual[24]=dt.saveDefect();
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

	@Then("^should be able to create a defect with custom field containing alphanumeric characters$")
	public void should_be_able_to_create_a_defect_with_custom_field_containing_alphanumeric_characters() throws Throwable {
		 try
		    {
		    	String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
				String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 18, 0);
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

	@When("^user Creates a defect with custom field of type Text Field containing special characters$")
	public void user_Creates_a_defect_with_custom_field_of_type_Text_Field_containing_special_characters() throws Throwable {
	    
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
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 5, 9);
				bp.waitForElement();
				actual[27]=dt.createDefect(projectType, issueType);
				bp.waitForElement();
				actual[28]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		        bp.waitForElement();
		        actual[29]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
		        bp.waitForElement();
		        actual[30]=dt.saveDefect();
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

	@Then("^should be created a defect with custom field of Type  Text field$")
	public void should_be_created_a_defect_with_custom_field_of_Type_Text_field() throws Throwable {
		 try
		    {
		    	String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
				String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 19, 0);
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

	@When("^Create a defect with custom field of type Text Field containing international characters$")
	public void create_a_defect_with_custom_field_of_type_Text_Field_containing_international_characters() throws Throwable {
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
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 6, 9);
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

	@Then("^Defect should be created with custom field of type Text Field containing international characters$")
	public void defect_should_be_created_with_custom_field_of_type_Text_Field_containing_international_characters() throws Throwable {
		 try
		    {
		    	String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
				String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 20, 0);
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

	@When("^user launches defect tracking app,searches a defect and selects it and clicks on Create Sub-task$")
	public void user_launches_defect_tracking_app_searches_a_defect_and_selects_it_and_clicks_on_Create_Sub_task() throws Throwable {
		       try
	           { 
				String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 10);
				bp.waitForElement();
				actual[39]=pp.clickOnDefectTracking();
				bp.waitForElement();
				actual[40]=dt.searchDefect(defectId);
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

	@When("^creates a subtask only numbers in custom field of type Text Field$")
	public void creates_a_subtask_only_numbers_in_custom_field_of_type_Text_Field() throws Throwable {
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
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 7, 9);
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

	@Then("^should create a subtask only numbers in custom field of type text Field$")
	public void should_create_a_subtask_only_numbers_in_custom_field_of_type_text_Field() throws Throwable {
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

	@When("^user creates a subtask with custom field of type Text Field in lowercase$")
	public void user_creates_a_subtask_with_custom_field_of_type_Text_Field_in_lowercase() throws Throwable {
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
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 8, 9);
				bp.waitForElement();
				String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 10);
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

	@Then("^lowercase of subtask should be created$")
	public void lowercase_of_subtask_should_be_created() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
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

	@When("^user creates a subtask of type Text Field containing alphanumeric characters and spaces$")
	public void user_creates_a_subtask_of_type_Text_Field_containing_alphanumeric_characters_and_spaces() throws Throwable {
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
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 9, 9);
				bp.waitForElement();
				String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 3, 10);
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

	@Then("^subtask should be created of type Text Field containing alphanumeric characters$")
	public void subtask_should_be_created_of_type_Text_Field_containing_alphanumeric_characters() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
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

	@When("^user Creates a subtask with custom field of type Text Field containing special characters$")
	public void user_Creates_a_subtask_with_custom_field_of_type_Text_Field_containing_special_characters() throws Throwable {
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
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 9);
				String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 4, 10);
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

	@Then("^should be created a subtask with custom field of type Text field consists of special characters$")
	public void should_be_created_a_subtask_with_custom_field_of_type_Text_field_consists_of_special_characters() throws Throwable {
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

	@When("^user creates a sub task the text field containing international characters$")
	public void user_creates_a_sub_task_the_text_field_containing_international_characters() throws Throwable {
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
				String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Multi_User_Picker[]=new String[1];
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 11, 9);
				bp.waitForElement();
				String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 5, 10);
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

	@Then("^should be created a defect which containing international characters of text field$")
	public void should_be_created_a_defect_which_containing_international_characters_of_text_field() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
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

	@When("^user launches test repository page, creates a Phase$")
	public void user_launches_test_repository_page_creates_a_Phase() throws Throwable {
		try
		   {
			   
				rp=new ReleasePage(driver);
				tp=new TestPlanningPage(driver);
				rp=new ReleasePage(driver);
				tr=new TestRepositoryPage(driver);
				ctc=new CreateTestCasePage(driver);
				String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 4, 5);
				String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 4, 6);
				String [] navigation=new String [1];
				navigation[0]=name;
				bp.waitForElement();
				actual[85]=rp.clickOnTestRep();
				bp.waitForElement();
				actual[86]=tr.clickOnRelease(release);
				actual[87]=tr.addNode(name, desc);
				bp.waitForElement();
				actual[88]=tr.navigateToNode(release, navigation);
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

	@When("^adds a few testcases, and goes to Test Planning Creates a cycle and assigns testcases to Anyone$")
	public void adds_a_few_testcases_and_goes_to_Test_Planning_Creates_a_cycle_and_assigns_testcases_to_Anyone() throws Throwable {
	   try
	   {
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 7, 4);
			String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 3, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 3, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 7, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 9, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 8, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 8, 5));
			String [] cycle1 =new String[1];
			cycle1[0]=cycle;
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 4,5);
			String phase_1[]=new String[1];
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 2, 0);
		    phase_1[0]=phase;
		    for(int i=0;i<=2;i++)
			{
			tr.addTestCase();	
			}
			bp.waitForElement();
			actual[89]=rp.clickOnTestPlanning();
			actual[90]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[91]=tp.CreateCycle(cycle, build, Environment, hide);
			bp.waitForElement();
			actual[92]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[93]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			actual[94]=tp.navigateToCycle(cycle1);
			bp.waitForElement();
			actual[95]=tp.addPhaseToCycle(phase);
			bp.waitForElement();
			actual[96]=tp.bulkAssignment(bulk_type);
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

	@When("^User launches Test execution,selects test cases and executes with any status and clicks on D$")
	public void user_launches_Test_execution_selects_test_cases_and_executes_with_any_status_and_clicks_on_D() throws Throwable {
		try
		{
			ep=new ExecutionPage(driver);
			bp.waitForElement();
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",7,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",4,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[97]=rp.clickOnTestExecution();
			actual[98]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[99]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[100]=ep.changeMultiSelectedStatus(status);
			bp.waitForElement();
			actual[101]=ep.clickOnDefectButton(testcase1);
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

	@Then("^Defect window to be Launched$")
	public void defect_window_to_be_Launched() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[102]=ep.validateLinkDefectWindow();
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

	@When("^User clicks on create defect and creates a defect with only numbers in text field$")
	public void user_clicks_on_create_defect_and_creates_a_defect_with_only_numbers_in_text_field() throws Throwable {
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
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 12, 9));
			actual[103]=dt.createDefect(projectType, issueType);
			actual[104]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			actual[105]=bp.waitForElement();
			actual[106]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        actual[107]=bp.waitForElement();
			actual[108]=dt.saveDefect();
			
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

	@Then("^defect should create only numbers in text field$")
	public void defect_should_create_only_numbers_in_text_field() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 21, 0);
			actual[109]=bp.waitForElement();
			actual[110]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[111]=dt.updateDefect();
			bp.waitForElement();
			actual[112]=ep.closeLinkedDefectWindow();
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

	@When("^Create a defect of type Text Field in UPPERCASE$")
	public void create_a_defect_of_type_Text_Field_in_UPPERCASE() throws Throwable {
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
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 16, 9);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",7,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",4,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[113]=rp.clickOnTestExecution();
			actual[114]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[115]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[116]=ep.changeMultiSelectedStatus(status);
			bp.waitForElement();
			actual[117]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			actual[118]=dt.createDefect(projectType, issueType);
			actual[119]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			actual[120]=bp.waitForElement();
			actual[121]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        actual[122]=bp.waitForElement();
			actual[123]=dt.saveDefect();
			
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

	@Then("^defect should be created of type text field in Upper case$")
	public void defect_should_be_created_of_type_text_field_in_Upper_case() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 22, 0);
			actual[124]=bp.waitForElement();
			actual[125]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[126]=dt.updateDefect();
			bp.waitForElement();
			actual[127]=ep.closeLinkedDefectWindow();
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

	@When("^create a defect of type text field in lower case$")
	public void create_a_defect_of_type_text_field_in_lower_case() throws Throwable {
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
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 13, 9);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",7,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",4,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[128]=rp.clickOnTestExecution();
			actual[129]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[130]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[131]=ep.changeMultiSelectedStatus(status);
			bp.waitForElement();
			actual[132]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			actual[133]=dt.createDefect(projectType, issueType);
			actual[134]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			actual[135]=bp.waitForElement();
			actual[136]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        actual[137]=bp.waitForElement();
			actual[138]=dt.saveDefect();
			
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

	@Then("^defect should create of type text field in lower case$")
	public void defect_should_create_of_type_text_field_in_lower_case() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			actual[139]=bp.waitForElement();
			actual[140]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[141]=dt.updateDefect();
			bp.waitForElement();
			actual[142]=ep.closeLinkedDefectWindow();
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

	@When("^user will Create a defect  of type Text Field containing alphanumeric characters and spaces$")
	public void user_will_Create_a_defect_of_type_Text_Field_containing_alphanumeric_characters_and_spaces() throws Throwable {
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
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 14, 9);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",7,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",4,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[143]=rp.clickOnTestExecution();
			actual[144]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[145]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[146]=ep.changeMultiSelectedStatus(status);
			bp.waitForElement();
			actual[147]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			actual[148]=dt.createDefect(projectType, issueType);
			actual[149]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			actual[150]=bp.waitForElement();
			actual[151]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[152]=dt.saveDefect();
			actual[153]=bp.waitForElement();
			actual[154]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[155]=dt.updateDefect();
			bp.waitForElement();
			actual[156]=ep.closeLinkedDefectWindow();
			
			
			
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

	@When("^user will create a defect of type Text Field containing special characters$")
	public void user_will_create_a_defect_of_type_Text_Field_containing_special_characters() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 17, 0);
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
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 4, 4);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",7,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",4,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[157]=rp.clickOnTestExecution();
			actual[158]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[159]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[160]=ep.changeMultiSelectedStatus(status);
			bp.waitForElement();
			actual[161]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			actual[162]=dt.createDefect(projectType, issueType);
			actual[163]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[164]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[165]=dt.saveDefect();
			bp.waitForElement();
			actual[166]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[167]=dt.updateDefect();
			bp.waitForElement();
			actual[168]=ep.closeLinkedDefectWindow();
			
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

	@When("^user will create a defect of type Text Field containing international characters$")
	public void user_will_create_a_defect_of_type_Text_Field_containing_international_characters() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 18, 0);
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
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 15, 9);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",7,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",4,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[169]=rp.clickOnTestExecution();
			actual[170]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[171]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[172]=ep.changeMultiSelectedStatus(status);
			bp.waitForElement();
			actual[173]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			actual[174]=ep.createDefect(projectType, issueType);
			actual[175]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[176]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[177]=dt.saveDefect();
			
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

	@Then("^should be able to create a defects of Type text field$")
	public void should_be_able_to_create_a_defects_of_Type_text_field() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 18, 0);
			bp.waitForElement();
			actual[178]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[179]=dt.updateDefect();
			bp.waitForElement();
			actual[180]=ep.closeLinkedDefectWindow();
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

	@When("^user launch test repository page and creates a phase and adds few testcases$")
	public void user_launch_test_repository_page_and_creates_a_phase_and_adds_few_testcases() throws Throwable {
		 try
		   {
			   
				rp=new ReleasePage(driver);
				tp=new TestPlanningPage(driver);
				rp=new ReleasePage(driver);
				tr=new TestRepositoryPage(driver);
				ctc=new CreateTestCasePage(driver);
				String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 5, 5);
				String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 5, 6);
				String [] navigation=new String [1];
				navigation[0]=name;
				bp.waitForElement();
				actual[181]=rp.clickOnTestRep();
				bp.waitForElement();
				actual[182]=tr.clickOnRelease(release);
				actual[183]=tr.addNode(name, desc);
				bp.waitForElement();
				actual[184]=tr.navigateToNode(release, navigation);
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

	@When("^user launch test planning page,create a cycle and assign phase to cycle,assigns testcases to anyone$")
	public void user_launch_test_planning_page_create_a_cycle_and_assign_phase_to_cycle_assigns_testcases_to_anyone() throws Throwable {
		try
		{
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 8, 4);
			String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 2, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 4, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 8, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 8, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 6, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 9, 5));
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 2, 0);
			String [] cycle1 =new String[1];
			cycle1[0]=cycle;
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 5,5);
			String phase_1[]=new String[1];
		    phase_1[0]=phase;
			bp.waitForElement();
			actual[185]=rp.clickOnTestPlanning();
			actual[186]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[187]=tp.CreateCycle(cycle, build, Environment, hide);
			bp.waitForElement();
			actual[188]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[189]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			actual[190]=tp.navigateToCycle(cycle1);
			bp.waitForElement();
			actual[191]=tp.addPhaseToCycle(phase);
			bp.waitForElement();
			actual[192]=tp.bulkAssignment(bulk_type);
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

	@When("^user goes to test execution,executes testcases with ANY Status,clicks on D button$")
	public void user_goes_to_test_execution_executes_testcases_with_ANY_Status_clicks_on_D_button() throws Throwable {
		try
		{
			ep=new ExecutionPage(driver);
			bp.waitForElement();
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",8,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",5,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			bp.waitForElement();
			actual[193]=rp.clickOnTestExecution();
			actual[194]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[195]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[196]=ep.changeMultiSelectedStatus(status);
			actual[197]=ep.clickOnDefectButton(testcase1);
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

	@Then("^defect window should be opened$")
	public void defect_window_should_be_opened() throws Throwable {
	    try
	    {
	     bp.waitForElement();
	     actual[198]=ep.validateLinkDefectWindow();
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

	@When("^user clicks on create defect button$")
	public void user_clicks_on_create_defect_button() throws Throwable {
		try
		{
			
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 10);
			bp.waitForElement();
			actual[199]=ep.searchDefect(defectId);
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

	@When("^searches a defect and creates subtask$")
	public void searches_a_defect_and_creates_subtask() throws Throwable {
		try
		{
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			actual[200]=ep.clickOnSubTask();
			bp.waitForElement();
			actual[201]=dt.createDefectSubtask(issueType);
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

	@When("^Create subtask with custom field of type Text Field in Uppercase$")
	public void create_subtask_with_custom_field_of_type_Text_Field_in_Uppercase() throws Throwable {
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
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 16, 9);
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			actual[202]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[203]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[204]=dt.saveDefect();
			bp.waitForElement();
			actual[205]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[206]=dt.updateDefect();
			bp.waitForElement();
			actual[207]=ep.closeLinkedDefectWindow();
			
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

	@When("^Create SubTask with Custom field of type text field in Lowercase$")
	public void create_SubTask_with_Custom_field_of_type_text_field_in_Lowercase() throws Throwable {
		try
		{
			
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 12, 6);
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
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 17, 9);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",8,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",5,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			bp.waitForElement();
			actual[208]=rp.clickOnTestExecution();
			actual[209]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[210]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[211]=ep.changeMultiSelectedStatus(status);
			actual[212]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			bp.waitForElement();
			actual[213]=ep.searchDefect(defectId);
			bp.waitForElement();
			actual[214]=ep.clickOnSubTask();
			bp.waitForElement();
			actual[215]=dt.createDefectSubtask(issueType);
			actual[216]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			actual[217]=bp.waitForElement();
			actual[218]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
	        actual[219]=dt.saveDefect();
			
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

	@Then("^should be created a sub task with custom field of type text fields$")
	public void should_be_created_a_sub_task_with_custom_field_of_type_text_fields() throws Throwable {
	   try
	   {
		   String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
		   String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
		   actual[220]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[221]=dt.updateDefect();
			bp.waitForElement();
			actual[222]=ep.closeLinkedDefectWindow();
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

	@When("^create a subtask with custom field of type Text Field Containing alphanumeric Characters$")
	public void create_a_subtask_with_custom_field_of_type_Text_Field_Containing_alphanumeric_Characters() throws Throwable {
	   
		try
		{
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 13, 6);
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
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 6, 4);
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",8,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",5,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			bp.waitForElement();
			actual[223]=rp.clickOnTestExecution();
			actual[224]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[225]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[226]=ep.changeMultiSelectedStatus(status);
			actual[227]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			bp.waitForElement();
			actual[228]=ep.searchDefect(defectId);
			bp.waitForElement();
			actual[229]=ep.clickOnSubTask();
			bp.waitForElement();
			actual[230]=dt.createDefectSubtask(issueType);
			actual[231]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[232]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        actual[233]=bp.waitForElement();
			actual[234]=dt.saveDefect();
			actual[235]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[236]=dt.updateDefect();
			bp.waitForElement();
			actual[237]=ep.closeLinkedDefectWindow();
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

	@When("^Create a subtask with custom field of Type text Fields containing Special Characters$")
	public void create_a_subtask_with_custom_field_of_Type_text_Fields_containing_Special_Characters() throws Throwable {
		try
		{
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 14, 6);
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
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 3, 4);
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			bp.waitForElement();
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",8,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",5,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			bp.waitForElement();
			actual[238]=rp.clickOnTestExecution();
			actual[239]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[240]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[241]=ep.changeMultiSelectedStatus(status);
			actual[242]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			actual[243]=ep.searchDefect(defectId);
			bp.waitForElement();
			actual[244]=ep.clickOnSubTask();
			bp.waitForElement();
			actual[245]=dt.createDefectSubtask(issueType);
			actual[246]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[247]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
			bp.waitForElement();
			actual[248]=dt.saveDefect();
			actual[249]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[250]=dt.updateDefect();
			bp.waitForElement();
			actual[251]=ep.closeLinkedDefectWindow();
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

	@When("^Creates the subtask with custom field of type text field Containing International characters$")
	public void creates_the_subtask_with_custom_field_of_type_text_field_Containing_International_characters() throws Throwable {
		try
		{
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 15, 6);
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
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 5, 4);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",8,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",5,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			bp.waitForElement();
			actual[252]=rp.clickOnTestExecution();
			actual[253]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[254]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[255]=ep.changeMultiSelectedStatus(status);
			actual[256]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			bp.waitForElement();
			actual[257]=ep.searchDefect(defectId);
			bp.waitForElement();
			actual[258]=ep.clickOnSubTask();
			bp.waitForElement();
			actual[259]=dt.createDefectSubtask(issueType);
			actual[260]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[261]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
	        actual[262]=dt.saveDefect();
			
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

	@Then("^should be able to create a subtask with custom field of type text field consists international characters$")
	public void should_be_able_to_create_a_subtask_with_custom_field_of_type_text_field_consists_international_characters() throws Throwable {
	   try
	   {
		   String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
		   String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
		   actual[263]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[264]=dt.updateDefect();
			bp.waitForElement();
			actual[265]=ep.closeLinkedDefectWindow();
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
