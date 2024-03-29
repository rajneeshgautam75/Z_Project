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

public class Defect_Tracking_Admin_292 extends  LaunchBrowser {
	
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
    String fileName="Defect_Tracking_Admin_292";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
    
    @Given("^user Logins As Manager Credentials To ZEPHYR$")
    public void user_Logins_As_Manager_Credentials_To_ZEPHYR() throws Throwable {
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

    @When("^User clicks On THE Administration Page$")
    public void user_clicks_On_THE_Administration_Page() throws Throwable {
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

    @When("^Further Clicks ON Defect admin and Preferences$")
    public void further_Clicks_ON_Defect_admin_and_Preferences() throws Throwable {
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

    @When("^In custom fields,user defines property Name and value and saves$")
    public void in_custom_fields_user_defines_property_Name_and_value_and_saves() throws Throwable {
			try
			{
				String category=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 0);
		    	String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 28, 5);
		    	String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 28, 6);
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

		@Then("^should be able to add property in custom fields$")
		public void should_be_able_to_add_property_in_custom_fields() throws Throwable {
			try
			{
				String name=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 28, 5);
				String value=Excel_Lib.getData(INPUT_PATH_7,"Excecution", 28, 6);
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

		@When("^user goes to defect tracking and clicks on create defect$")
		public void user_goes_to_defect_tracking_and_clicks_on_create_defect() throws Throwable {
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

		@When("^Create a defect with custom fileds containing multiple values and text containg special charaters in Free text field$")
		public void create_a_defect_with_custom_fileds_containing_multiple_values_and_text_containg_special_charaters_in_Free_text_field() throws Throwable {
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
				
				String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 25, 12);
				String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 25, 13);
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 23, 3);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 23, 9);
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

		@Then("^should able to create a defect in Defect Tracking with multiple values$")
		public void should_able_to_create_a_defect_in_Defect_Tracking_with_multiple_values() throws Throwable {
			try
		    {
		    	String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
				String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
		    	bp.waitForElement();
				actual[16]=dt.validateDefect(projectType, issueType);
				bp.waitForElement();
				actual[17]=dt.updateDefect();
				actual[18]=bp.waitForElement();
			
		    }
		    catch(Exception e)
			{
				 lb=new LaunchBrowser();
				 lb.getScreenShot(fileName);
				 e.printStackTrace();
				 driver.close();
				 Relogin_TPE rl=new Relogin_TPE();
				 rl.reLogin();
				 throw e;
			} 
		}

		@When("^user Creates a new phase in Test Repository$")
		public void user_Creates_a_new_phase_in_Test_Repository() throws Throwable {
			try
			   {
					String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 22, 2);
					String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 22, 3);
					String [] navigation=new String [1];
					navigation[0]=name;
					bp.waitForElement();
					actual[19]=bp.waitForElement();
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

		@When("^launches test planning,Creates new Cycle and adds phase to cycle$")
		public void launches_test_planning_Creates_new_Cycle_and_adds_phase_to_cycle() throws Throwable {
			try
			{
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 18, 3);
				String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 2, 1);
				String Environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 2, 2);
				String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
				String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 7, 1);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 7, 2));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
				String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 1);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 10, 5));
				String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 1, 0);
				String [] cycle1 =new String[1];
				cycle1[0]=cycle;
				String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 22,2);
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

		@When("^launch test execution app and execute  testcase with any status and clicks on D button$")
		public void launch_test_execution_app_and_execute_testcase_with_any_status_and_clicks_on_D_button() throws Throwable {
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

		@Then("^window of LINK Defect to be launched$")
		public void window_of_LINK_Defect_to_be_launched() throws Throwable {
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

		@When("^user clicks on Create defect and creates a defect with custom fileds and Text containg special charaters in Freetext$")
		public void user_clicks_on_Create_defect_and_creates_a_defect_with_custom_fileds_and_Text_containg_special_charaters_in_Freetext() throws Throwable {
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
				
				String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 25, 12);
				String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 25, 13);
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
				String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 23, 3);
				String ze_Label_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
				String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 23, 9);
				String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_7, "Defects", 17, 7);
				bp.waitForElement();
				actual[39]=dt.createDefect(projectType, issueType);
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

		@Then("^To be able allow allow multiple values in custom field when multiple value seperator is configured to other than \\$$")
		public void to_be_able_allow_allow_multiple_values_in_custom_field_when_multiple_value_seperator_is_configured_to_other_than_$() throws Throwable {
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