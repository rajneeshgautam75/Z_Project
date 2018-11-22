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

public class Defect_Tracking_34 extends LaunchBrowser {
	
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
	boolean[] actual=new boolean[435];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_34";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^user is in a page of defect tracking and clicks on create defect$")
	public void user_is_in_a_page_of_defect_tracking_and_clicks_on_create_defect() throws Throwable {
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

	@When("^user creates a defect with only numbers in custom field of type Free Text$")
	public void user_creates_a_defect_with_only_numbers_in_custom_field_of_type_Free_Text() throws Throwable {
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
				String zeFreeTextField=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 5, 0));
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
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
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

	@Then("^should able to create a defect with only numbers in custom field of type free Text$")
	public void should_able_to_create_a_defect_with_only_numbers_in_custom_field_of_type_free_Text() throws Throwable {
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

	@When("^Create the Defect with custom field of type Free Text in UPPERCASE characters$")
	public void create_the_Defect_with_custom_field_of_type_Free_Text_in_UPPERCASE_characters() throws Throwable {
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 6, 0);
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
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
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

	@Then("^Uppercase character defect should be created$")
	public void uppercase_character_defect_should_be_created() throws Throwable {
		 try
		    {
		    	String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
				String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
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

	@When("^Create Defect With custom field of type Free text in lowercase$")
	public void create_Defect_With_custom_field_of_type_Free_text_in_lowercase() throws Throwable {
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 7, 0);
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
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				actual[15]=dt.createDefect(projectType, issueType);
				bp.waitForElement();
				actual[16]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		        bp.waitForElement();
		        actual[17]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
		        bp.waitForElement();
		        actual[18]=dt.saveDefect();
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

	@When("^user Creates defect with Custom field of Type Free Text containing alphanumeric characters and spaces$")
	public void user_Creates_defect_with_Custom_field_of_Type_Free_Text_containing_alphanumeric_characters_and_spaces() throws Throwable {
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 8, 0);
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
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
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

	@When("^create Defect with custom field of type Free Text containing Special characters$")
	public void create_Defect_with_custom_field_of_type_Free_Text_containing_Special_characters() throws Throwable {
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 9, 0);
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
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
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

	@When("^create a defect with custom field of type free text containing international characters$")
	public void create_a_defect_with_custom_field_of_type_free_text_containing_international_characters() throws Throwable {
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 0);
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
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
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

	@Then("^to be able to create the defect$")
	public void to_be_able_to_create_the_defect() throws Throwable {
		 try
		    {
		    	String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
				String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
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

	@When("^Create a defect with custom field of type Free Text containing new line characters$")
	public void create_a_defect_with_custom_field_of_type_Free_Text_containing_new_line_characters() throws Throwable {
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "TextFields", 20, 1);
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
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				actual[39]=dt.createDefect(projectType, issueType);
				bp.waitForElement();
				actual[40]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		        bp.waitForElement();
		        actual[41]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
		        bp.waitForElement();
		        actual[42]=dt.saveDefect();
				bp.waitForElement();
				actual[43]=dt.validateDefect(projectType, issueType);
				bp.waitForElement();
				actual[44]=dt.updateDefect();
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

	@When("^Create defect With custom field of type Free Text by Copy/Paste pre-formatted text containing new line characters from clipboard$")
	public void create_defect_With_custom_field_of_type_Free_Text_by_Copy_Paste_pre_formatted_text_containing_new_line_characters_from_clipboard() throws Throwable {
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "TextFields", 18, 1);
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
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				actual[45]=dt.createDefect(projectType, issueType);
				bp.waitForElement();
				actual[46]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		        bp.waitForElement();
		        actual[47]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
		        bp.waitForElement();
		        actual[48]=dt.saveDefect();
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

	@Then("^should create the defect$")
	public void should_create_the_defect() throws Throwable {
		 try
		    {
		    	String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
				String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
				bp.waitForElement();
				actual[49]=dt.validateDefect(projectType, issueType);
				bp.waitForElement();
				actual[50]=dt.updateDefect();
	
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

	@When("^Create a defect with custom field of type Free Text greater than two thousand fourty eight characters$")
	public void create_a_defect_with_custom_field_of_type_Free_Text_greater_than_two_thousand_fourty_eight_characters() throws Throwable {
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "TextFields", 2, 1);
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
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				bp.waitForElement();
				actual[51]=dt.createDefect(projectType, issueType);
				bp.waitForElement();
				actual[52]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		        bp.waitForElement();
		        actual[53]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
		        bp.waitForElement();
		        actual[54]=dt.saveDefect();
				bp.waitForElement();
				actual[55]=dt.validateDefect(projectType, issueType);
				bp.waitForElement();
				actual[56]=dt.updateDefect();
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

	@When("^Create a defect with custom field of type Free Text with very long text as defined in  Defects Admin$")
	public void create_a_defect_with_custom_field_of_type_Free_Text_with_very_long_text_as_defined_in_Defects_Admin() throws Throwable {
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "TextFields", 5, 1);
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
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				actual[57]=dt.createDefect(projectType, issueType);
				bp.waitForElement();
				actual[58]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		        bp.waitForElement();
		        actual[59]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
		        bp.waitForElement();
		        actual[60]=dt.saveDefect();
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

	@Then("^defect should create as very long text as defined in  Defects Admin$")
	public void defect_should_create_as_very_long_text_as_defined_in_Defects_Admin() throws Throwable {
		 try
		    {
		    	String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
				String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
				bp.waitForElement();
				actual[61]=dt.validateDefect(projectType, issueType);
				bp.waitForElement();
				actual[62]=dt.updateDefect();
	
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

	@When("^Defect with custom field of type free text longer than configured maxlength using old property DTS\\.CUSTOMFIELD\\.customfield_xx\\.MAXLENGTH$")
	public void defect_with_custom_field_of_type_free_text_longer_than_configured_maxlength_using_old_property_DTS_CUSTOMFIELD_customfield_xx_MAXLENGTH() throws Throwable {
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "TextFields", 15, 1);
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
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				actual[63]=dt.createDefect(projectType, issueType);
				bp.waitForElement();
				actual[64]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		        bp.waitForElement();
		        actual[65]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
		        bp.waitForElement();
		        actual[66]=dt.saveDefect();
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

	@Then("^should create defect with custom field of type free text$")
	public void should_create_defect_with_custom_field_of_type_free_text() throws Throwable {
		 try
		    {
		    	String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
				String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
				bp.waitForElement();
				actual[67]=dt.validateDefect(projectType, issueType);
				bp.waitForElement();
				actual[68]=dt.updateDefect();
	
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

	@When("^user launches defect Tracking app,search defect and selects it$")
	public void user_launches_defect_Tracking_app_search_defect_and_selects_it() throws Throwable {
		try
        { 
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 5, 2);
			bp.waitForElement();
			actual[69]=pp.clickOnDefectTracking();
			bp.waitForElement();
			actual[70]=dt.searchDefect(defectId);
			bp.waitForElement();
			actual[71]=dt.selectAllDefects();
			
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

	@When("^clicks on Create Sub-task$")
	public void clicks_on_Create_Sub_task() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[72]=dt.clickOnCreateSubTask();
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

	@When("^Create subtask with Only Numbers in Custom field of type Free Text$")
	public void create_subtask_with_Only_Numbers_in_Custom_field_of_type_Free_Text() throws Throwable {
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
				String zeFreeTextField=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 5, 1));
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
				String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				actual[73]=dt.createDefectSubtask(issueType);
				bp.waitForElement();
				actual[74]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		        bp.waitForElement();
		        actual[75]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
		        bp.waitForElement();
		        actual[76]=dt.saveDefect();
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

	@Then("^should be able to create a subtask with only numbers in custom field of type free text$")
	public void should_be_able_to_create_a_subtask_with_only_numbers_in_custom_field_of_type_free_text() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			bp.waitForElement();
			actual[77]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[78]=dt.updateDefect();
		
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

	@When("^create subtask with custom field of type Free text in UPPERCASE$")
	public void create_subtask_with_custom_field_of_type_Free_text_in_UPPERCASE() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 6, 1);
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			bp.waitForElement();
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 6, 2);
			actual[79]=dt.searchDefect(defectId);
			bp.waitForElement();
			actual[80]=dt.selectAllDefects();
			actual[81]=dt.clickOnCreateSubTask();
			bp.waitForElement();
			actual[82]=dt.createDefectSubtask(issueType);
			bp.waitForElement();
			actual[83]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[84]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
			bp.waitForElement();
			actual[85]=dt.saveDefect();
			bp.waitForElement();
			actual[86]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[87]=dt.updateDefect();
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

	@When("^create Subtask with custom field of type Free Text in lowercase$")
	public void create_Subtask_with_custom_field_of_type_Free_Text_in_lowercase() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 7, 1);
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			bp.waitForElement();
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 7, 2);
			actual[88]=dt.searchDefect(defectId);
			bp.waitForElement();
			actual[89]=dt.selectAllDefects();
			actual[90]=dt.clickOnCreateSubTask();
			bp.waitForElement();
			actual[91]=dt.createDefectSubtask(issueType);
			bp.waitForElement();
			actual[92]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[93]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
			bp.waitForElement();
			actual[94]=dt.saveDefect();
			bp.waitForElement();
			actual[95]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[96]=dt.updateDefect();
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

	@When("^Create subtask with custom field of type Free Text containing alphanumeric characters and spaces$")
	public void create_subtask_with_custom_field_of_type_Free_Text_containing_alphanumeric_characters_and_spaces() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 8, 1);
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			bp.waitForElement();
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 8, 2);
			actual[97]=dt.searchDefect(defectId);
			bp.waitForElement();
			actual[98]=dt.selectAllDefects();
			actual[99]=dt.clickOnCreateSubTask();
			bp.waitForElement();
			actual[100]=dt.createDefectSubtask(issueType);
			bp.waitForElement();
			actual[101]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[102]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
			bp.waitForElement();
			actual[103]=dt.saveDefect();
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

	@Then("^to be able to create the subtask with custom field of type Free Text consists of alphanumeric$")
	public void to_be_able_to_create_the_subtask_with_custom_field_of_type_Free_Text_consists_of_alphanumeric() throws Throwable {
	    
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			bp.waitForElement();
			actual[104]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[105]=dt.updateDefect();
		
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

	@When("^Create Subtask with custom field of type free text Containing Special characters$")
	public void create_Subtask_with_custom_field_of_type_free_text_Containing_Special_characters() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 9, 1);
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			bp.waitForElement();
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 8, 2);
			actual[106]=dt.searchDefect(defectId);
			bp.waitForElement();
			actual[107]=dt.selectAllDefects();
			actual[108]=dt.clickOnCreateSubTask();
			bp.waitForElement();
			actual[109]=dt.createDefectSubtask(issueType);
			bp.waitForElement();
			actual[110]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[111]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
			bp.waitForElement();
			actual[112]=dt.saveDefect();
			bp.waitForElement();
			actual[113]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[114]=dt.updateDefect();
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

	@When("^Create a subtask with Custom field of Type Free Text containing international characters$")
	public void create_a_subtask_with_Custom_field_of_Type_Free_Text_containing_international_characters() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 0);
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			bp.waitForElement();
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 2);
			actual[115]=dt.searchDefect(defectId);
			bp.waitForElement();
			actual[116]=dt.selectAllDefects();
			actual[117]=dt.clickOnCreateSubTask();
			bp.waitForElement();
			actual[118]=dt.createDefectSubtask(issueType);
			bp.waitForElement();
			actual[119]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[120]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
			bp.waitForElement();
			actual[121]=dt.saveDefect();
			bp.waitForElement();
			actual[122]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[123]=dt.updateDefect();
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

	@When("^Create a Sub task with custom field of type free text containing new line characters$")
	public void create_a_Sub_task_with_custom_field_of_type_free_text_containing_new_line_characters() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "TextFields", 20, 1);
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			bp.waitForElement();
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 11, 2);
			actual[124]=dt.searchDefect(defectId);
			bp.waitForElement();
			actual[125]=dt.selectAllDefects();
			actual[126]=dt.clickOnCreateSubTask();
			bp.waitForElement();
			actual[127]=dt.createDefectSubtask(issueType);
			bp.waitForElement();
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

	@Then("^should create a sub task with custom field of type free text consists of new line characters$")
	public void should_create_a_sub_task_with_custom_field_of_type_free_text_consists_of_new_line_characters() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			bp.waitForElement();
			actual[131]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[132]=dt.updateDefect();
		
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

	@When("^Create Subtask with custom field of type Free Text with very long text as defined in Defects Admin$")
	public void create_Subtask_with_custom_field_of_type_Free_Text_with_very_long_text_as_defined_in_Defects_Admin() throws Throwable {
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
			String zeFreeTextField=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 5, 1));
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			bp.waitForElement();
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 12, 2);
			actual[133]=dt.searchDefect(defectId);
			bp.waitForElement();
			actual[134]=dt.selectAllDefects();
			actual[135]=dt.clickOnCreateSubTask();
			bp.waitForElement();
			actual[136]=dt.createDefectSubtask(issueType);
			bp.waitForElement();
			actual[137]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[138]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
			bp.waitForElement();
			actual[139]=dt.saveDefect();
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

	@Then("^should able to create a subtask with very long text$")
	public void should_able_to_create_a_subtask_with_very_long_text() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			bp.waitForElement();
			actual[140]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[141]=dt.updateDefect();
		
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

	@When("^Create a Sub task with custom field of type Free Text longer than the configured maxlength using the old property$")
	public void create_a_Sub_task_with_custom_field_of_type_Free_Text_longer_than_the_configured_maxlength_using_the_old_property() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 15, 1);
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			bp.waitForElement();
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 13, 2);
			actual[142]=dt.searchDefect(defectId);
			bp.waitForElement();
			actual[143]=dt.selectAllDefects();
			actual[144]=dt.clickOnCreateSubTask();
			bp.waitForElement();
			actual[145]=dt.createDefectSubtask(issueType);
			bp.waitForElement();
			actual[146]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[147]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
			bp.waitForElement();
			actual[148]=dt.saveDefect();
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

	@Then("^subtask should be created with custom field of type Free Text longer than the configured maxlength$")
	public void subtask_should_be_created_with_custom_field_of_type_Free_Text_longer_than_the_configured_maxlength() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			bp.waitForElement();
			actual[149]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[150]=dt.updateDefect();
		
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

	@When("^Launch test repository,create a phase and add few test cases$")
	public void launch_test_repository_create_a_phase_and_add_few_test_cases() throws Throwable {
		try
		   {
			   
				rp=new ReleasePage(driver);
				tp=new TestPlanningPage(driver);
				rp=new ReleasePage(driver);
				tr=new TestRepositoryPage(driver);
				ctc=new CreateTestCasePage(driver);
				String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 7, 5);
				String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 7, 6);
				String [] navigation=new String [1];
				navigation[0]=name;
				bp.waitForElement();
				actual[151]=rp.clickOnTestRep();
				bp.waitForElement();
				actual[152]=tr.clickOnRelease(release);
				actual[153]=tr.addNode(name, desc);
				bp.waitForElement();
				actual[154]=tr.navigateToNode(release, navigation);
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

	@When("^go to test planning,create a cycle and assign phase to cycle and assign testcase to anyone$")
	public void go_to_test_planning_create_a_cycle_and_assign_phase_to_cycle_and_assign_testcase_to_anyone() throws Throwable {
		 try
		   {
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 9, 4);
				String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 3, 1);
				String Environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 3, 2);
				String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
				String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 8, 1);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 9, 2));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
				String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 8, 4);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 9, 5));
				String [] cycle1 =new String[1];
				cycle1[0]=cycle;
				String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 7,5);
				String phase_1[]=new String[1];
				String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 2, 0);
			    phase_1[0]=phase;
				bp.waitForElement();
				actual[155]=rp.clickOnTestPlanning();
				actual[156]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				actual[157]=tp.CreateCycle(cycle, build, Environment, hide);
				bp.waitForElement();
				actual[158]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[159]=tp.saveTestCycle(); 
				bp.waitForElement(); 
				actual[160]=tp.navigateToCycle(cycle1);
				bp.waitForElement();
				actual[161]=tp.addPhaseToCycle(phase);
				bp.waitForElement();
				actual[162]=tp.bulkAssignment(bulk_type);
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

	@When("^go to test execution,select testcases and execute with any status$")
	public void go_to_test_execution_select_testcases_and_execute_with_any_status() throws Throwable {
		try
		{
			ep=new ExecutionPage(driver);
			bp.waitForElement();
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",9,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",7,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			bp.waitForElement();
			actual[163]=rp.clickOnTestExecution();
			actual[164]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[165]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[166]=ep.changeMultiSelectedStatus(status);
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

	@When("^user clicks on D button$")
	public void user_clicks_on_D_button() throws Throwable {
		try
		{ 
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[167]=ep.clickOnDefectButton(testcase1);
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

	@Then("^link defect Window Should be Launched$")
	public void link_defect_Window_Should_be_Launched() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[168]=ep.validateLinkDefectWindow();
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

	@When("^user clicks on create defect and creates defect with only Numbers in custom field of Type free Text$")
	public void user_clicks_on_create_defect_and_creates_defect_with_only_Numbers_in_custom_field_of_Type_free_Text() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 1);
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			actual[169]=dt.createDefect(projectType, issueType);
			actual[170]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			actual[171]=bp.waitForElement();
			actual[172]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[173]=dt.saveDefect();
			actual[174]=bp.waitForElement();
			actual[175]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[176]=dt.updateDefect();
			actual[177]=bp.waitForElement();
			//actual[177]=ep.closeLinkedDefectWindow();
			
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
	@When("^Create defect with custom field of Type Free Text in uppercase$")
	public void create_defect_with_custom_field_of_Type_Free_Text_in_uppercase() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 11, 1);
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			actual[178]=dt.createDefect(projectType, issueType);
			actual[179]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[180]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[181]=dt.saveDefect();
			bp.waitForElement();
			actual[182]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[183]=dt.updateDefect();
			actual[184]=bp.waitForElement();
			//actual[184]=ep.closeLinkedDefectWindow();
			
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

	@When("^create Defect with custom field of type Free Text in lowercase$")
	public void create_Defect_with_custom_field_of_type_Free_Text_in_lowercase() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 12, 1);
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			actual[185]=dt.createDefect(projectType, issueType);
			actual[186]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[187]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[188]=dt.saveDefect();
			
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

	@Then("^Defect with custom field of type Free Text in lowercase should be created$")
	public void defect_with_custom_field_of_type_Free_Text_in_lowercase_should_be_created() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			bp.waitForElement();
			actual[189]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[190]=dt.updateDefect();
			actual[191]=bp.waitForElement();
			//actual[191]=ep.closeLinkedDefectWindow();
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

	@When("^user Creates the defect with custom field of type Free Text containing alphanumeric characters and spaces$")
	public void user_Creates_the_defect_with_custom_field_of_type_Free_Text_containing_alphanumeric_characters_and_spaces() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 13, 1);
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			actual[192]=dt.createDefect(projectType, issueType);
			actual[193]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[194]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
	        actual[195]=dt.saveDefect();
			bp.waitForElement();
			actual[196]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[197]=dt.updateDefect();
			actual[198]=bp.waitForElement();
			//actual[198]=ep.closeLinkedDefectWindow();
			
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

	@When("^Create Defect with custom field of type Free Text containing special characters$")
	public void create_Defect_with_custom_field_of_type_Free_Text_containing_special_characters() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 14, 1);
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			actual[199]=dt.createDefect(projectType, issueType);
			actual[200]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[201]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[202]=dt.saveDefect();
			bp.waitForElement();
			actual[203]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[204]=dt.updateDefect();
			actual[205]=bp.waitForElement();
			//actual[205]=ep.closeLinkedDefectWindow();
			
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

	@When("^create Defect with custom field of type Free Text containing international characters$")
	public void create_Defect_with_custom_field_of_type_Free_Text_containing_international_characters() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 15, 1);
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			actual[206]=dt.createDefect(projectType, issueType);
			actual[207]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[208]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[209]=dt.saveDefect();
			
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

	@Then("^Defect with custom field of type Free Text consists international characters should be created$")
	public void defect_with_custom_field_of_type_Free_Text_consists_international_characters_should_be_created() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			bp.waitForElement();
			actual[210]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[211]=dt.updateDefect();
			actual[212]=bp.waitForElement();
			//actual[212]=ep.closeLinkedDefectWindow();
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

	@When("^Create a defect With custom field of type Free Text Containing New line characters$")
	public void create_a_defect_With_custom_field_of_type_Free_Text_Containing_New_line_characters() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "TextFields", 20, 1);
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			actual[213]=dt.createDefect(projectType, issueType);
			actual[214]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[215]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[216]=dt.saveDefect();
			bp.waitForElement();
			actual[217]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[218]=dt.updateDefect();
			actual[219]=bp.waitForElement();
			//actual[219]=ep.closeLinkedDefectWindow();
			
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

	@When("^create defect with custom field of type Free Text by copy/paste pre-formatted text consists new line characters$")
	public void create_defect_with_custom_field_of_type_Free_Text_by_copy_paste_pre_formatted_text_consists_new_line_characters() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "TextFields", 18, 1);
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			actual[220]=dt.createDefect(projectType, issueType);
			actual[221]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[222]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[223]=dt.saveDefect();
			bp.waitForElement();
			actual[224]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[225]=dt.updateDefect();
			actual[226]=bp.waitForElement();
			//actual[226]=ep.closeLinkedDefectWindow();
			
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

	@When("^create a defect with custom field of type Free Text more than two thousand fourty eight characters$")
	public void create_a_defect_with_custom_field_of_type_Free_Text_more_than_two_thousand_fourty_eight_characters() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "TextFields", 5, 1);
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			actual[227]=dt.createDefect(projectType, issueType);
			actual[228]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[229]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
	        actual[230]=dt.saveDefect();
			
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

	@Then("^should be able to create a defect with custom field of type Free Text$")
	public void should_be_able_to_create_a_defect_with_custom_field_of_type_Free_Text() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			bp.waitForElement();
			actual[231]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[232]=dt.updateDefect();
			actual[233]=bp.waitForElement();
			//actual[233]=ep.closeLinkedDefectWindow();
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

	@When("^create Sub task with custom field of Type Free Text with very long text as defined in defects admin$")
	public void create_Sub_task_with_custom_field_of_Type_Free_Text_with_very_long_text_as_defined_in_defects_admin() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "TextFields", 5, 1);
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			actual[234]=dt.createDefect(projectType, issueType);
			actual[235]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[236]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[237]=dt.saveDefect();
			bp.waitForElement();
			actual[238]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[239]=dt.updateDefect();
			actual[240]=bp.waitForElement();
			//actual[240]=ep.closeLinkedDefectWindow();
			
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

	@When("^create a defect with custom field of type Free Text longer than the configured maxlength$")
	public void create_a_defect_with_custom_field_of_type_Free_Text_longer_than_the_configured_maxlength() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "TextFields", 15, 1);
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			actual[241]=dt.createDefect(projectType, issueType);
			actual[242]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[243]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[244]=dt.saveDefect();
			
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

	@Then("^defect with custom field of type Free Text to be created$")
	public void defect_with_custom_field_of_type_Free_Text_to_be_created() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			bp.waitForElement();
			actual[245]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[246]=dt.updateDefect();
			actual[247]=bp.waitForElement();
			actual[247]=ep.closeLinkedDefectWindow();
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

	@When("^launch test repository Page,create a phase and add testcases$")
	public void launch_test_repository_Page_create_a_phase_and_add_testcases() throws Throwable {
		 try
		   {
			   
				rp=new ReleasePage(driver);
				tp=new TestPlanningPage(driver);
				rp=new ReleasePage(driver);
				tr=new TestRepositoryPage(driver);
				ctc=new CreateTestCasePage(driver);
				String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 8, 5);
				String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 8, 6);
				String [] navigation=new String [1];
				navigation[0]=name;
				bp.waitForElement();
				actual[248]=rp.clickOnTestRep();
				bp.waitForElement();
				actual[249]=tr.clickOnRelease(release);
				actual[250]=tr.addNode(name, desc);
				bp.waitForElement();
				actual[251]=tr.navigateToNode(release, navigation);
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

	@When("^launch tesplanning,create new cycle and assign phase to cycle and assign testcases to anyone$")
	public void launch_tesplanning_create_new_cycle_and_assign_phase_to_cycle_and_assign_testcases_to_anyone() throws Throwable {
		try
		{
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 10, 4);
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
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 8,5);
			String phase_1[]=new String[1];
		    phase_1[0]=phase;
			bp.waitForElement();
			actual[252]=rp.clickOnTestPlanning();
			actual[253]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[254]=tp.CreateCycle(cycle, build, Environment, hide);
			bp.waitForElement();
			actual[255]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[256]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			actual[257]=tp.navigateToCycle(cycle1);
			bp.waitForElement();
			actual[258]=tp.addPhaseToCycle(phase);
			bp.waitForElement();
			actual[259]=tp.bulkAssignment(bulk_type);
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

	@When("^launch test execution,execute TestCases with Any status$")
	public void launch_test_execution_execute_TestCases_with_Any_status() throws Throwable {
		try
		{
			ep=new ExecutionPage(driver);
			bp.waitForElement();
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",10,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",8,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			bp.waitForElement();
			bp.waitForElement();
			actual[260]=rp.clickOnTestExecution();
			actual[261]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[262]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[263]=ep.changeMultiSelectedStatus(status);
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

	@When("^select testcase and clicks on D button$")
	public void select_testcase_and_clicks_on_D_button() throws Throwable {
		try
		{
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			actual[264]=ep.clickOnDefectButton(testcase1);
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

	@Then("^link defect window should be opened$")
	public void link_defect_window_should_be_opened() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[265]=ep.validateLinkDefectWindow();
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

	@When("^user search defect,and selects it$")
	public void user_search_defect_and_selects_it() throws Throwable {
		try
		{
			
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 10);
			bp.waitForElement();
			actual[266]=ep.searchDefect(defectId);
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

	@When("^clicks on Create subtask$")
	public void clicks_on_Create_subtask() throws Throwable {
		try
		{
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			actual[267]=ep.clickOnSubTask();
			bp.waitForElement();
			actual[268]=dt.createDefectSubtask(issueType);
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

	@When("^Create Subtask with only numbers in custom field of type Free Text$")
	public void create_Subtask_with_only_numbers_in_custom_field_of_type_Free_Text() throws Throwable {
		
		try{
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
			String zeCheckboxField=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 21,13));
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			bp.waitForElement();
			actual[269]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[270]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[271]=dt.saveDefect();
			
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

	@Then("^Subtask with only numbers in custom field of type Free Text should be created$")
	public void subtask_with_only_numbers_in_custom_field_of_type_Free_Text_should_be_created() throws Throwable {
	   try
	   {
		    String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
		    bp.waitForElement();
			actual[272]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[273]=dt.updateDefect();
			bp.waitForElement();
			actual[274]=ep.closeLinkedDefectWindow();
			
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

	@When("^create Subtask with custom field of type Free Text in UPPER CASE characters$")
	public void create_Subtask_with_custom_field_of_type_Free_Text_in_UPPER_CASE_characters() throws Throwable {
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
			String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 12, 0);
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",10,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",8,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			bp.waitForElement();
			actual[275]=bp.waitForElement();
			//actual[275]=rp.clickOnTestExecution();
			actual[276]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[277]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[278]=ep.changeMultiSelectedStatus(status);
			actual[279]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			bp.waitForElement();
			actual[280]=ep.searchDefect(defectId);
			bp.waitForElement();
			actual[281]=ep.clickOnSubTask();
			bp.waitForElement();
			actual[282]=dt.createDefectSubtask(issueType);
			actual[283]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[284]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[285]=dt.saveDefect();
			bp.waitForElement();
			actual[286]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[287]=dt.updateDefect();
			bp.waitForElement();
			actual[288]=ep.closeLinkedDefectWindow();
			
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

	@When("^Create the subtask with custom field of type Free Text in lowercase$")
	public void create_the_subtask_with_custom_field_of_type_Free_Text_in_lowercase() throws Throwable {
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 13, 0);
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",10,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",8,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			bp.waitForElement();
			actual[289]=bp.waitForElement();
			//actual[289]=rp.clickOnTestExecution();
			actual[290]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[291]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[292]=ep.changeMultiSelectedStatus(status);
			actual[293]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			bp.waitForElement();
			actual[294]=ep.searchDefect(defectId);
			bp.waitForElement();
			actual[295]=ep.clickOnSubTask();
			bp.waitForElement();
			actual[296]=dt.createDefectSubtask(issueType);
			actual[297]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[298]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[299]=dt.saveDefect();
			bp.waitForElement();
			actual[300]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[301]=dt.updateDefect();
			bp.waitForElement();
			actual[302]=ep.closeLinkedDefectWindow();
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

	@When("^Create The subtask with custom field Of Type Free Text consists alphanumeric characters and spaces$")
	public void create_The_subtask_with_custom_field_Of_Type_Free_Text_consists_alphanumeric_characters_and_spaces() throws Throwable {
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",10,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",8,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[303]=bp.waitForElement();
			//actual[303]=rp.clickOnTestExecution();
			actual[304]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[305]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[306]=ep.changeMultiSelectedStatus(status);
			actual[307]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			bp.waitForElement();
			actual[308]=ep.searchDefect(defectId);
			bp.waitForElement();
			actual[309]=ep.clickOnSubTask();
			bp.waitForElement();
			actual[310]=dt.createDefectSubtask(issueType);
			actual[311]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[312]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[313]=dt.saveDefect();
			
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

	@Then("^should be able to create a subtask$")
	public void should_be_able_to_create_a_subtask() throws Throwable {
		 try
		   {
			   String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			   String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			   actual[314]=dt.validateDefect(projectType, issueType);
			   bp.waitForElement();
			   actual[315]=dt.updateDefect();
			   bp.waitForElement();
			   actual[316]=ep.closeLinkedDefectWindow();
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

	@When("^user creates subtask with custom field of type Free Text Containing special characters$")
	public void user_creates_subtask_with_custom_field_of_type_Free_Text_Containing_special_characters() throws Throwable {
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",10,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",8,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			bp.waitForElement();
			actual[317]=bp.waitForElement();
			//actual[317]=rp.clickOnTestExecution();
			actual[318]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[319]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[340]=ep.changeMultiSelectedStatus(status);
			actual[341]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			bp.waitForElement();
			actual[342]=ep.searchDefect(defectId);
			bp.waitForElement();
			actual[343]=ep.clickOnSubTask();
			bp.waitForElement();
			actual[344]=dt.createDefectSubtask(issueType);
			actual[345]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[346]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[347]=dt.saveDefect();
			bp.waitForElement();
			actual[348]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[349]=dt.updateDefect();
			bp.waitForElement();
			actual[350]=ep.closeLinkedDefectWindow();
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

	@When("^Create a subtask with custom field of type Free Text containing international characters$")
	public void create_a_subtask_with_custom_field_of_type_Free_Text_containing_international_characters() throws Throwable {
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",10,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",8,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			bp.waitForElement();
			actual[351]=bp.waitForElement();
			//actual[351]=rp.clickOnTestExecution();
			actual[352]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[353]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[354]=ep.changeMultiSelectedStatus(status);
			actual[355]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			bp.waitForElement();
			actual[356]=ep.searchDefect(defectId);
			bp.waitForElement();
			actual[357]=ep.clickOnSubTask();
			bp.waitForElement();
			actual[358]=dt.createDefectSubtask(issueType);
			actual[359]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[360]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[361]=dt.saveDefect();
			bp.waitForElement();
			actual[362]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[363]=dt.updateDefect();
			bp.waitForElement();
			actual[364]=ep.closeLinkedDefectWindow();
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

	@When("^create Sub task with custom field of type Free Text containing new line characters$")
	public void create_Sub_task_with_custom_field_of_type_Free_Text_containing_new_line_characters() throws Throwable {
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",10,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",8,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			 String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			bp.waitForElement();
			actual[365]=bp.waitForElement();
			//actual[365]=rp.clickOnTestExecution();
			actual[366]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[367]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[368]=ep.changeMultiSelectedStatus(status);
			actual[369]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			bp.waitForElement();
			actual[370]=ep.searchDefect(defectId);
			bp.waitForElement();
			actual[371]=ep.clickOnSubTask();
			bp.waitForElement();
			actual[372]=dt.createDefectSubtask(issueType);
			actual[373]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[374]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[375]=dt.saveDefect();
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

	@Then("^should be able to create a subTask$")
	public void should_be_able_to_create_a_subTask() throws Throwable {
	 try
	   {
		   String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
		   String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
		   actual[376]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[377]=dt.updateDefect();
			bp.waitForElement();
			actual[378]=ep.closeLinkedDefectWindow();
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
	
	@When("^Create subtask with custom field of type Free Text by Copy/Paste pre-formatted text containing new line characters$")
	public void create_subtask_with_custom_field_of_type_Free_Text_by_Copy_Paste_pre_formatted_text_containing_new_line_characters() throws Throwable {
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",10,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",8,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			bp.waitForElement();
			actual[379]=bp.waitForElement();
			//actual[379]=rp.clickOnTestExecution();
			actual[380]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[381]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[382]=ep.changeMultiSelectedStatus(status);
			actual[383]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			bp.waitForElement();
			actual[384]=ep.searchDefect(defectId);
			bp.waitForElement();
			actual[385]=ep.clickOnSubTask();
			bp.waitForElement();
			actual[386]=dt.createDefectSubtask(issueType);
			actual[387]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[388]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[389]=dt.saveDefect();
			bp.waitForElement();
			actual[390]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[391]=dt.updateDefect();
			bp.waitForElement();
			actual[392]=ep.closeLinkedDefectWindow();
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

	
	@When("^Create a Sub task with custom field of type Free Text more than two thousand fourty eight characters$")
	public void create_a_Sub_task_with_custom_field_of_type_Free_Text_more_than_two_thousand_fourty_eight_characters() throws Throwable {
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",10,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",8,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			bp.waitForElement();
			actual[393]=bp.waitForElement();
			//actual[393]=rp.clickOnTestExecution();
			actual[394]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[395]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[396]=ep.changeMultiSelectedStatus(status);
			actual[397]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			bp.waitForElement();
			actual[398]=ep.searchDefect(defectId);
			bp.waitForElement();
			actual[399]=ep.clickOnSubTask();
			bp.waitForElement();
			actual[400]=dt.createDefectSubtask(issueType);
			actual[401]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[402]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[403]=dt.saveDefect();
			bp.waitForElement();
			actual[404]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[405]=dt.updateDefect();
			bp.waitForElement();
			actual[406]=ep.closeLinkedDefectWindow();
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

	@When("^create a Sub task with custom field of type Free Text with very long text as defined in  Defects Admin$")
	public void create_a_Sub_task_with_custom_field_of_type_Free_Text_with_very_long_text_as_defined_in_Defects_Admin() throws Throwable {
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",10,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",8,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			bp.waitForElement();
			actual[407]=bp.waitForElement();
			//actual[407]=rp.clickOnTestExecution();
			actual[408]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[409]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[410]=ep.changeMultiSelectedStatus(status);
			actual[411]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			bp.waitForElement();
			actual[412]=ep.searchDefect(defectId);
			bp.waitForElement();
			actual[413]=ep.clickOnSubTask();
			bp.waitForElement();
			actual[414]=dt.createDefectSubtask(issueType);
			actual[415]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[416]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[417]=dt.saveDefect();
			bp.waitForElement();
			actual[418]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[419]=dt.updateDefect();
			bp.waitForElement();
			actual[420]=ep.closeLinkedDefectWindow();
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

	@When("^create the Subtask with custom field of type Free Text longer than the configured maxlength$")
	public void create_the_Subtask_with_custom_field_of_type_Free_Text_longer_than_the_configured_maxlength() throws Throwable {
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
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",10,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",8,5);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[421]=bp.waitForElement();
			//actual[421]=rp.clickOnTestExecution();
			actual[422]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[423]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[424]=ep.changeMultiSelectedStatus(status);
			actual[425]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			bp.waitForElement();
			actual[426]=ep.searchDefect(defectId);
			bp.waitForElement();
			actual[427]=ep.clickOnSubTask();
			bp.waitForElement();
			actual[428]=dt.createDefectSubtask(issueType);
			actual[429]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			bp.waitForElement();
			actual[430]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[431]=dt.saveDefect();
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

	@Then("^Subtask with custom field of type Free Text should be created$")
	public void subtask_with_custom_field_of_type_Free_Text_should_be_created() throws Throwable {
		 try
		   {
			   String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			   String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 1);
			   actual[432]=dt.validateDefect(projectType, issueType);
			   bp.waitForElement();
			   actual[433]=dt.updateDefect();
			   bp.waitForElement();
			   actual[434]=ep.closeLinkedDefectWindow();
			   bp.waitForElement();
			   tp.doubleClickOnCycle(release);
			   bp.waitForElement();
			   for(int k=0;k<=actual.length-1;k++)
				{
					System.out.println(actual[k]);
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
