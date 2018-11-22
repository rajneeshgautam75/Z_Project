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

public class Defect_Tracking_Admin_293 extends  LaunchBrowser {
	
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
	boolean[] actual=new boolean[32];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_Admin_293";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
    @Given("^user Logins to Zephyr As Manager$")
    public void user_Logins_to_Zephyr_As_Manager() throws Throwable {
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

    @When("^User clicks ON Administration$")
    public void user_clicks_ON_Administration() throws Throwable {
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

    @When("^Again clicks On Defect admin and preferences$")
    public void again_clicks_On_Defect_admin_and_preferences() throws Throwable {
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

    @When("^user adds Property name and Value and saves in custom fields$")
    public void user_adds_Property_name_and_Value_and_saves_in_custom_fields() throws Throwable {
		try
		{
			String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 28, 5);
	    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 29, 6);
	    	String active=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 2, 1);
			bp.waitForElement();
			boolean res=ccp.checkAvailablePropertyName(category, name);
			if(res==true)
			{
				bp.waitForElement();
				ccp.editCategoriesOperation(category, name, value, active);
				bp.waitForElement();
				ccp.editCategories(category, name, value, active);
			}
			else
			{
				bp.waitForElement();
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

	@Then("^To be able to Add property in Custom fields$")
	public void to_be_able_to_Add_property_in_Custom_fields() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 28, 5);
			String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 29, 6);
	    	bp.waitForElement();
	    	actual[7]=ccp.validateCategories(name, value);
		}
		catch(Exception e)
		{
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;
		}	            
	}

	@When("^User goes to Defect tracking and clicks on create defect$")
	public void user_goes_to_Defect_tracking_and_clicks_on_create_defect() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			actual[8]=bp.waitForElement();
			actual[9]=pp.backToProjectPage();
	    	bp.waitForElement();
	    	actual[10]=pp.selectProject(project);
			actual[11]=pp.selectRelease(release);
			bp.waitForElement();
	    	actual[12]=pp.clickOnDefectTracking();
	    	bp.waitForElement();
			actual[13]=dt.createDefect(projectType, issueType);

		}
		catch(Exception e)
		{
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;
		}	         
	}

	@When("^Creates Defect with custom fileds containing Multiple values and Text containing Special charaters in Freetext field$")
	public void creates_Defect_with_custom_fileds_containing_Multiple_values_and_Text_containing_Special_charaters_in_Freetext_field() throws Throwable {
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
			
			String zeRadioField=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 21, 12));
			String zeCheckboxField=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 21, 13));
			String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multiple_Select_Field[]=new String[2];
			ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 19, 11);
			ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 20, 11);
			String ze_Multi_Version_field[]=new String[1];
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 16, 7);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 24, 3);
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 0);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 23, 9);
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 17, 7);
			
			bp.waitForElement();
			actual[14]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, affectsVersion, affectsVersion, affectsVersion, affectsVersion, affectsVersion);
	        bp.waitForElement();
	        actual[15]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
	        actual[16]=dt.saveDefect();
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

	@Then("^defect should be created in Defect Tracking with multiple values$")
	public void defect_should_be_created_in_Defect_Tracking_with_multiple_values() throws Throwable {
		try
	    {
	    	String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
	    	bp.waitForElement();
			actual[17]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[18]=dt.updateDefect();
		
	    }
	    catch(Exception e)
		{
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;
		} 
	}

	@When("^Launch test execution app and execute  Testcase with Any status and clicks on D button$")
	public void launch_test_execution_app_and_execute_Testcase_with_Any_status_and_clicks_on_D_button() throws Throwable {
		try
		{
			ep=new ExecutionPage(driver);
			bp.waitForElement();
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",18,3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",22,2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[19]=rp.clickOnTestExecution();
			actual[20]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[21]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[22]=ep.changeMultiSelectedStatus(status);
			bp.waitForElement();
			actual[23]=ep.clickOnDefectButton(testcase1);
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

	@Then("^window of LINK Defect Should be launched$")
	public void window_of_LINK_Defect_Should_be_launched() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[24]=ep.validateLinkDefectWindow();
		}
		catch(Exception e)
		{
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;
		}    
	}

	@When("^User clicks on Create Defect and creates defect with custom fileds and Text containing special charaters in Freetext$")
	public void user_clicks_on_Create_Defect_and_creates_defect_with_custom_fileds_and_Text_containing_special_charaters_in_Freetext() throws Throwable {
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
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 22, 12);
			String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 22, 13);
			String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multiple_Select_Field[]=new String[2];
			ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 19, 11);
			ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 20, 11);
			String ze_Multi_Version_field[]=new String[1];
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 16, 7);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 24, 3);
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 10, 0);
			String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 23, 9);
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 17, 7);
			bp.waitForElement();
			actual[25]=dt.createDefect(projectType, issueType);
			bp.waitForElement();
			actual[26]=dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, affectsVersion, affectsVersion, affectsVersion, affectsVersion, affectsVersion);
			bp.waitForElement();
			actual[27]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	        bp.waitForElement();
			actual[28]=dt.saveDefect();
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

	@Then("^To be able multiple values in custom field when multiple value seperator is configured more than one character$")
	public void to_be_able_multiple_values_in_custom_field_when_multiple_value_seperator_is_configured_more_than_one_character() throws Throwable {
		 try
		    {
		    String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);	
			actual[29]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[30]=dt.updateDefect();
			bp.waitForElement();
			actual[31]=ep.clickOnCancelDefectWindow();
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
