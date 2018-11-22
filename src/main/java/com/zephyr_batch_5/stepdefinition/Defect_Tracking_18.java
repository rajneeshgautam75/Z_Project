package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
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

public class Defect_Tracking_18 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	ExecutionPage exep;
	DefectTracking dt;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	String fileName="Defect_Tracking_18";
	
	boolean[] actual=new boolean[36];
	SoftAssert soft=new SoftAssert();
	
	 @Given("^User is in Test Repository page$")
	 public void user_is_in_Test_Repository_page() throws Throwable {
	 try
	  {
		  pp=new ProjectPage(driver);
		  rp= new ReleasePage(driver);
		  bp=new BasePage();
		  dt=new DefectTracking(driver);
		  String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		  String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1"); 
		  pp.selectProject(projectName);
		   actual[0]=pp.selectRelease(releaseName);
		   bp.waitForElement();
		   actual[1]=rp.clickOnTestRep();
	  }
	  catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}              
	 }

	 @When("^User create a phase with testcase$")
	 public void user_create_a_phase_with_testcase() throws Throwable {
		 try
		   {
			   tr=new TestRepositoryPage(driver);
			    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 12, 12);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				
				actual[2]=tr.clickOnRelease(releaseName);
				bp.waitForElement();
				actual[3]=tr.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
			    String[] str=new String[1];
			    str[0]=p_Name1;
			    actual[4]=tr.navigateToNode(releaseName, str);
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

	 @When("^User launch TestPlanning to create a cycle and add phase to cycle$")
	 public void user_launch_TestPlanning_to_create_a_cycle_and_add_phase_to_cycle() throws Throwable {
	 try
	   {
		  bp.waitForElement();
		  actual[5]=rp.clickOnTestPlanning();
		  
		  tp=new TestPlanningPage(driver);
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",12,13);
			String build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
			String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
			String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
			actual[6]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[7]=tp.CreateCycle(cycle, build, environ, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
			String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
			String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
			bp.waitForElement();
			actual[8]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			bp.waitForElement();
			actual[9]=tp.saveTestCycle();
			bp.waitForElement();
			
	    	String[] cycle1=new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",12,13);
			actual[10]=tp.navigateToCycle(cycle1);
			
			bp.waitForElement();
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",12,12);
			actual[11]=tp.addPhaseToCycle(phase);
			bp.waitForElement();
			String bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
			bp.waitForElement();
			actual[12]=tp.bulkAssignment(bulk_Type);
			actual[13]=tp.goBackToCycle();
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}     
	 }

	 @When("^User launch TestExecution execute testcase$")
	 public void user_launch_TestExecution_execute_testcase() throws Throwable {
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
		   actual[14]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		   String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",12,13);
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",12,12);
		    
		    bp.waitForElement();
		    tp=new TestPlanningPage(driver);
			actual[15]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[16]=exep.executeStatus(tcNo1[0], statusType1);
	   }
	   catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}     
	 }

	 @When("^User click on Create Defect button and enter the projectName and issueType$")
	 public void user_click_on_Create_Defect_button_and_enter_the_projectName_and_issueType() throws Throwable {
	 try
	   {
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		   String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		   actual[17]=exep.clickOnDefectButton(testcase);
		   dt=new DefectTracking(driver);
		   actual[18]=dt.createDefect(project, issuetype);
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}       
	 }

	 @When("^enter the summary and description and save the Defect$")
	 public void enter_the_summary_and_description_and_save_the_Defect() throws Throwable {
	 try
	   {
		    String[] fields=new String[11];
		    for(int i=0;i<=10;i++)
		    {
		      fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);	
		    }
		    String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
			String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		    actual[19]=dt.fileNewDefect(summary, fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
		    actual[20]=dt.saveDefect();
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}       
	 }

	 @When("^update all the available fields for the defect$")
	 public void update_all_the_available_fields_for_the_defect() throws Throwable {
	 try
	   {
		String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
		String components=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,19);
		String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,6);
		String fixVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,27);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		String labels=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		String descType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		String sprint=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		String env=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,22);
		String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,28);
		String affectsVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,27);
		String epicLink=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		String linkedIssue=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
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
	    actual[21]=dt.fileNewDefect(summary, components, descType,desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
	    actual[22]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	    actual[23]=dt.customDatePicker(syear, smonth, sday);
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}         
	 }

	 @Then("^should be able to update the defect$")
	 public void should_be_able_to_update_the_defect() throws Throwable {
	 try
	   {
		 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		 actual[24]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[25]=dt.updateDefect();
		 bp.waitForElement();
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

	 @When("^User search the defect in TestExecution page$")
	 public void user_search_the_defect_in_TestExecution_page() throws Throwable {
	 try
	   {
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,9);
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,30);
		 for(int i=0;i<=6;i++)
		 {
		 bp.waitForElement();
		 }
		 actual[26]=exep.defectSearch(selectSearch,defectID);
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}                   
	 }

	 @When("^Click on create Subtask button$")
	 public void click_on_create_Subtask_button() throws Throwable {
	 try
	  {
		 actual[27]=exep.clickOnSubtask();
	  }
	  catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}    
	 }

	 @When("^enter the defect subtask issue type$")
	 public void enter_the_defect_subtask_issue_type() throws Throwable {
	 try
	  {
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,31);
		 actual[28]=dt.createDefectSubtask(issuetype);
	  }
	  catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}    
	 }

	 @When("^enter the Summary and Description of Subtask and save the defect$")
	 public void enter_the_Summary_and_Description_of_Subtask_and_save_the_defect() throws Throwable {
	 try
	   {
		    String[] fields=new String[11];
		    for(int i=0;i<=10;i++)
		    {
		      fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);	
		    }
		    String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
			String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		    actual[29]=dt.fileNewDefect(summary, fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
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

	 @When("^Update all the available fields for defect subtask$")
	 public void update_all_the_available_fields_for_defect_subtask() throws Throwable {
	 try
	   {
		String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
		String components=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,19);
		String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,6);
		String fixVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,27);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		String labels=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		String descType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		String sprint=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		String env=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,28);
		String affectsVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		String epicLink=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		String linkedIssue=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
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
	    actual[31]=dt.fileNewDefect(summary, components, descType,desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
	    actual[32]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	    actual[33]=dt.customDatePicker(syear, smonth, sday);
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}          
	 }

	 @Then("^Should be able to Update the defect subtask$")
	 public void should_be_able_to_Update_the_defect_subtask() throws Throwable {
	 try
	   {
		 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,31);
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[34]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[35]=dt.updateDefect();
		 bp.waitForElement();
		 bp.waitForElement();
	     exep.clickOnCancelDefectWindow();
	     bp.waitForElement();
	     tp.doubleClickOnCycle(releaseName);
		 bp.waitForElement();

		 for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
				//soft.assertEquals(actual[k], true);
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
