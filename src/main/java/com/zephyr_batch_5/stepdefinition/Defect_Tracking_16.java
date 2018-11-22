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

public class Defect_Tracking_16 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	DefectTracking dt;
	ExecutionPage exep;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	CreateTestCasePage ctc;
	String fileName="Defect_Tracking_16";
	
	boolean[] actual=new boolean[35];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in The TestRepository page$")
	public void user_is_in_The_TestRepository_page() throws Throwable {
		try
		   {
			 bp=new BasePage();
			 pp=new ProjectPage(driver);
			 rp=new ReleasePage(driver);
			 dt=new DefectTracking(driver);
		     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			 actual[0]=pp.selectProject(projectName);
		     actual[1]=pp.selectRelease(releaseName);
		     bp.waitForElement();
		     actual[2]=rp.clickOnTestRep();
		   }
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}                    
	}

	@When("^Create a phase with testcases$")
	public void create_a_phase_with_testcases() throws Throwable {
		try
		   {
		     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		     tr=new TestRepositoryPage(driver);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4, 12);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			
			actual[3]=tr.clickOnRelease(releaseName);
			bp.waitForElement();
			actual[4]=tr.addNode(p_Name1,p_Desc1);  
			tr.doubleClickOnRelease(releaseName);
			String[] phase=new String[1];
			phase[0]=p_Name1;
			bp.waitForElement();
			actual[5]=tr.navigateToNode(releaseName, phase);
			for(int i=1;i<=4;i++)
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

	@When("^Launch test planning to create a cycle and add phase to cycle$")
	public void launch_test_planning_to_create_a_cycle_and_add_phase_to_cycle() throws Throwable {
		try
		   {
			  bp.waitForElement();
			  actual[6]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4, 13);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[7]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[8]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[9]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				bp.waitForElement();
				actual[10]=tp.saveTestCycle();
				bp.waitForElement();
				
		    	String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4, 13);
				actual[11]=tp.navigateToCycle(cycle1);
				
				bp.waitForElement();
				String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4, 12);
				actual[12]=tp.addPhaseToCycle(phase);
				bp.waitForElement();
				String bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
				bp.waitForElement();
				actual[13]=tp.bulkAssignment(bulk_Type);
				actual[14]=tp.goBackToCycle();
		   }
		   catch(Exception e)
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(fileName);
			   e.printStackTrace();
				driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}          
	}

	@When("^Launch test Execution to execute testcase$")
	public void launch_test_Execution_to_execute_testcase() throws Throwable {
		try
		   {
			     /*pp=new ProjectPage(driver);//
				 bp=new BasePage();
				 rp=new ReleasePage(driver);
				 dt=new DefectTracking(driver);
				 tr=new TestRepositoryPage(driver);
				 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
				 pp.selectProject(projectName);
			     pp.selectRelease(releaseName);// */
			   
			   bp.waitForElement();
			   actual[15]=rp.clickOnTestExecution(); 
	           bp.waitForElement();
			   
			   String[] cycleName=new String[2];
			    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,13 );
			    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,12 );
			    
			    bp.waitForElement();
			    tp=new TestPlanningPage(driver);
				actual[16]=tr.navigateToNode(releaseName, cycleName);
				bp.waitForElement();
			
				int[] tcNo1=new int[1];
				tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
			    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[17]=exep.executeStatus(tcNo1[0], statusType1);
		   }
		   catch(Exception e)
			{
				lb=new LaunchBrowser();
				lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}      
	}

	@When("^Click on D button and click on create defect button and enter the external Jira project and issue type$")
	public void click_on_D_button_and_click_on_create_defect_button_and_enter_the_external_Jira_project_and_issue_type() throws Throwable {
		try
		   {
			   int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1,16 );
			   String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
			   String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
			   actual[18]=exep.clickOnDefectButton(testcase1);
			   bp.waitForElement();
			   actual[19]=dt.createDefect(project, issuetype);
			   
		   }
		   catch(Exception e)
			{
				lb=new LaunchBrowser();
				lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}       
	}

	@When("^Enter the available fields with values and save$")
	public void enter_the_available_fields_with_values_and_save() throws Throwable {
		try
		   {
			   dt=new DefectTracking(driver);
			   exep=new ExecutionPage(driver);
			   String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
				String components=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,19);
				String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,6);
				Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,27);
				String fixVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,27);
				String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String labels=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String descType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,17);
				String sprint=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String env=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String affectsVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String epicLink=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String linkedIssue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
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
			    actual[20]=exep.fileNewDefect(summary, components, descType,desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			    actual[21]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
			    actual[22]=dt.customDatePicker(syear, smonth, sday);
			    actual[23]=dt.saveDefect();
		   }
		   catch(Exception e)
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}            
	}

	@Then("^Should Be able to create defect with available fields$")
	public void should_Be_able_to_create_defect_with_available_fields() throws Throwable {
		try
		  {
			 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
			 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
			 actual[24]=dt.validateDefect(project, issuetype);
			 bp.waitForElement();
			 actual[25]=dt.updateDefect();
		  }
		  catch(Exception e)
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}           
	}

	@When("^Search a defect and click on subtask to create subtask$")
	public void search_a_defect_and_click_on_subtask_to_create_subtask() throws Throwable {
		try
		   {
			   int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1,19 );
			   String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3 ,9 );
			   String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2 ,30 );
			   String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,31);
			   bp.waitForElement();
			   exep.clickOnCancelDefectWindow();
			   //exep.cancelDefect.click();
			   actual[26]=exep.clickOnDefectButton(testcase1);
			   actual[27]=exep.defectSearch(selectSearch,defectID);
			   bp.waitForElement();
			   actual[28]=exep.clickOnSubtask();
			   dt.createDefectSubtask(issuetype);
		   }
		   catch(Exception e)
			{
				lb=new LaunchBrowser();
				lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}        
	}
	
	

	@When("^Enter all the available fields along with custom fields and save$")
	public void enter_all_the_available_fields_along_with_custom_fields_and_save() throws Throwable {
		try
		   {
			   dt=new DefectTracking(driver);
			   exep=new ExecutionPage(driver);
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
			    actual[29]=exep.fileNewDefect(summary, components, descType,desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
			    actual[30]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
			    actual[31]=dt.customDatePicker(syear, smonth, sday);
			    actual[32]=dt.saveDefect();
			    
			    
			   
		   }
		   catch(Exception e)
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}            
	}

	@Then("^Should be Able to create defect subtask with the available fields$")
	public void should_be_Able_to_create_defect_subtask_with_the_available_fields() throws Throwable {
		try
		  {
			 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
			 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
			 actual[33]=dt.validateDefect(project, issuetype);
			 actual[34]=dt.updateDefect();
			 bp.waitForElement();
			 exep.cancelDefect.click();
			 bp.waitForElement();
			 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			 tp.doubleClickOnCycle(releaseName);
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
