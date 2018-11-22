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

public class Defect_Tracking_7 extends LaunchBrowser{

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
	String fileName="Defect_Tracking_7";
	
	boolean[] actual=new boolean[31];
	 SoftAssert soft=new SoftAssert();

	
	@Given("^User is in Defect Tracking Page$")
	public void user_is_in_Defect_Tracking_Page() throws Throwable {
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

	@When("^User click on create defect and enter the external Jira project and issue type$")
	public void user_click_on_create_defect_and_enter_the_external_Jira_project_and_issue_type() throws Throwable {
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

	@When("^User enter all types of custom fields$")
	public void user_enter_all_types_of_custom_fields() throws Throwable {
		try
		   {
			   dt=new DefectTracking(driver);
			   exep=new ExecutionPage(driver);
			   String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
				String components=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,19);
				String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,6);
				String version=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,27);
				String fixVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,27);
				String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String labels=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String descType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String Sprint=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String env=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String Assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String AffectsVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String EpicLink=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
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
			    actual[2]=dt.fileNewDefect(summary, components, descType,desc, fixVersion, priority, Assignee, labels, Sprint, env, EpicLink, AffectsVersion, linkedIssue);
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

	@Then("^Should be able to create defect$")
	public void should_be_able_to_create_defect() throws Throwable {
	  try
	  {
		 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		 actual[6]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[7]=dt.updateDefect();
		
	  }
	  catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}    
	}

	@When("^User launch TCC page to create a phase with testcases$")
	public void user_launch_TCC_page_to_create_a_phase_with_testcases() throws Throwable {
		try
		   {
			 tr=new TestRepositoryPage(driver);
		     bp.waitForElement();
		    
		     tr=new TestRepositoryPage(driver);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 10, 12);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			actual[8]=rp.clickOnTestRep();
			actual[9]=tr.clickOnRelease(releaseName);
			bp.waitForElement();
			actual[10]=tr.addNode(p_Name1,p_Desc1);  
			tr.doubleClickOnRelease(releaseName);
			String[] phase=new String[1];
			phase[0]=p_Name1;
			bp.waitForElement();
			actual[11]=tr.navigateToNode(releaseName, phase);
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

	@When("^launch test planning to create the cycle and add the phase to cycle$")
	public void launch_test_planning_to_create_the_cycle_and_add_the_phase_to_cycle() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[12]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 10, 13);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[13]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[14]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[15]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				bp.waitForElement();
				actual[16]=tp.saveTestCycle();
				bp.waitForElement();
				
		    	String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 10, 13);
				actual[17]=tp.navigateToCycle(cycle1);
				
				bp.waitForElement();
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 10, 12);
				actual[18]=tp.addPhaseToCycle(Phase);
				bp.waitForElement();
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
				bp.waitForElement();
				actual[19]=tp.bulkAssignment(Bulk_Type);
				actual[20]=tp.goBackToCycle();
		   }
		   catch(Exception e)
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(fileName);
			   e.printStackTrace();
				driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}   
	}

	@When("^User launch Test Execution page to execute testcase and click on D button$")
	public void user_launch_Test_Execution_page_to_execute_testcase_and_click_on_D_button() throws Throwable {
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
			   actual[21]=rp.clickOnTestExecution(); 
	           bp.waitForElement();
			   
			   String[] cycleName=new String[2];
			    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",10,13 );
			    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",10 ,12 );
			    
			    bp.waitForElement();
			    tp=new TestPlanningPage(driver);
				actual[22]=tr.navigateToNode(releaseName, cycleName);
				bp.waitForElement();
			
				int[] tcNo1=new int[1];
				tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
			    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[23]=exep.executeStatus(tcNo1[0], statusType1);
			    
			    int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1,16 );
				 String defectID1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,7 );
				 actual[24]=exep.clickOnDefectButton(testcase1);
		   }
		   catch(Exception e)
			{
				lb=new LaunchBrowser();
				lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}      
	}

	@When("^click on create defect and enters the external Jira project and issue type$")
	public void click_on_create_defect_and_enters_the_external_Jira_project_and_issue_type() throws Throwable {
		try
		   {
			   dt=new DefectTracking(driver);
			   String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
			   String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
			   actual[25]=dt.createDefect(project, issuetype);
		   }
		   catch(Exception e)
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}      
	}

	@When("^enter the all the custom fields$")
	public void enter_the_all_the_custom_fields() throws Throwable {
		try
		   {
			   dt=new DefectTracking(driver);
			   exep=new ExecutionPage(driver);
			   String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
				String components=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,19);
				String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,6);
				String version=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String fixVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String desc=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,17);
				String labels=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String descType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String Sprint=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String env=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String Assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String AffectsVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				String EpicLink=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
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
			    actual[26]=dt.fileNewDefect(summary, components,descType, desc, fixVersion, priority, Assignee, labels, Sprint, env, EpicLink, AffectsVersion, linkedIssue);
			    actual[27]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
			    actual[28]=dt.customDatePicker(syear, smonth, sday);
			    actual[29]=dt.saveDefect();
		   }
		   catch(Exception e)
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}       
	}

	@Then("^Should be Able to create Defect$")
	public void should_be_Able_to_create_Defect() throws Throwable {
		 try
		  {
			 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
			 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
			 actual[30]=dt.validateDefect(project, issuetype);
			 dt.updateDefect();
			 bp.waitForElement();
			 exep.cancelDefect.click();
			 bp.waitForElement();
			 //pp.backToProjectPage();
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
