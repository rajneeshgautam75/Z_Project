package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CopyFromProjects;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Sync_Add_TC_OtherNode_OtherProject_DiffUser_DiffBrowser_868121 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exp; 
	CopyFromProjects cfp;
	
	boolean[] actual=new boolean[46];
	  SoftAssert soft=new SoftAssert();
	  String filename="Sync_Add_TC_OtherNode_OtherProject_DiffUser_DiffBrowser_868121";
	  @Given("^Select the ProjectO For the TestPlanning$")
	  public void select_the_ProjectO_For_the_TestPlanning() throws Throwable 
	  {
	      try
	      {
	    	  bp=new BasePage();
	    	  pp=new ProjectPage(driver);
		    	 tr=new TestRepositoryPage(driver);
		    	 rp=new ReleasePage(driver);
		    	 ctc=new CreateTestCasePage(driver);
		    	 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		    	 actual[0]= pp.selectProject(projectName); 
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Click on rElese in relEase summary$")
	  public void click_on_rElese_in_relEase_summary() throws Throwable 
	  {
		  try
	      {
			  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		    	 actual[1]= pp.selectRelease(releaseName);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch TestRepository and Create a phaseOne$")
	  public void launch_TestRepository_and_Create_a_phaseOne() throws Throwable 
	  {
		  try
	      {
             rp=new ReleasePage(driver);
			  rp.clickOnTestRep();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  tr.doubleClickOnRelease(releaseName);
	    	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",18,0);
	    	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",18,1);
	    	  actual[2]= tr.addNode(Name, Desc);
	    	  tr.doubleClickOnRelease(releaseName);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Navigate to Created PhaseOne and Add Testcase and edit the Testcase Nmae and Description$")
	  public void navigate_to_Created_PhaseOne_and_Add_Testcase_and_edit_the_Testcase_Nmae_and_Description() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",18,0);
	    	  actual[3]=tr.navigateToNode(releaseName, navigation);
	    	  actual[4]=tr.addTestCase();
	    	  
	    	  tr.clickDetailButton();
	    	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",12,0);
	    	  String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",12,1);
	    	  actual[5]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
	    	  bp.waitForElement();
	    	  tr.clickOnList();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Select the ProjectT For the TestPlanning$")
	  public void select_the_ProjectT_For_the_TestPlanning() throws Throwable 
	  {
		  try
	      {
			  pp=new ProjectPage(driver);
		    	 tr=new TestRepositoryPage(driver);
		    	 rp=new ReleasePage(driver);
		    	 ctc=new CreateTestCasePage(driver);
		    	 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_2");
		    	 actual[6]= pp.selectProject(projectName); 
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Click on relese in releAse summary$")
	  public void click_on_relese_in_releAse_summary() throws Throwable 
	  {
		  try
	      {
			  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		    	 actual[7]= pp.selectRelease(releaseName);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch TestRepository and CrEate A phaseTwo$")
	  public void launch_TestRepository_and_CrEate_A_phaseTwo() throws Throwable 
	  {
		  try
	      {
			  rp.clickOnTestRep();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  tr.doubleClickOnRelease(releaseName);
	    	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",19,0);
	    	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",19,1);
	    	  actual[8]= tr.addNode(Name, Desc);
	    	  tr.doubleClickOnRelease(releaseName);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Navigate to Created PhaseTwo and Add Testcase and EDit the Testcase Nmae and Description$")
	  public void navigate_to_Created_PhaseTwo_and_Add_Testcase_and_EDit_the_Testcase_Nmae_and_Description() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",19,0);
	    	  actual[9]=tr.navigateToNode(releaseName, navigation);
	    	  actual[10]=tr.addTestCase();
	    	  
	    	  tr.clickDetailButton();
	    	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",13,0);
	    	  String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",13,1);
	    	  actual[11]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
	    	  bp.waitForElement();
	    	  tr.clickOnList();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch TestPlanning and Create Exicution cycle$")
	  public void launch_TestPlanning_and_Create_Exicution_cycle() throws Throwable 
	  {
		  try
	      {
			  tp=new TestPlanningPage(driver);
	    	  BasePage bp=new BasePage();
	    	  actual[12]= rp.clickOnTestPlanning();
	    	  bp.waitForElement();
	    	  actual[13]= tp.clickOnAddTestCycleSymbol();
	    	  bp.waitForElement();
	    	  String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",25,0);
	    	  String Build=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",25,1));
	    	  String environ=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",25,2);
	    	  String hide=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",25,100);
	    	  actual[14]=tp.CreateCycle(cycle, Build, environ, hide);
	    	  String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",25,3));
	    	  String smonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",25,4);
	    	  String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",25,5));
	    	  String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",25,6));
	    	  String emonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",25,7);
	    	  String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",25,8));
	    	  actual[15]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
	    	  bp.waitForElement();
	    	  tp.saveTestCycle();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Add a PhaseOne in CreatEd Exicution Cycle, Choose Existing Phase, Save it and Choose 'Assign to Anyone'$")
	  public void add_a_PhaseOne_in_CreatEd_Exicution_Cycle_Choose_Existing_Phase_Save_it_and_Choose_Assign_to_Anyone() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
	    	  bp.waitForElement();
	    	  String cycleName[]=new String[1];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",25,0);
	    	  actual[16]=tp.navigateToCycle(cycleName);
	    	  bp.waitForElement();
	    	  String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",19,0);
	    	  actual[17]= tp.addPhaseToCycle(Phase);
	    	  bp.waitForElement();
	    	  String Bulk_type=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",25,9);
	    	  actual[18]=tp.bulkAssignment(Bulk_type);
	    	  bp.waitForElement();
	    	  String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",19,0);
	    	  actual[19]=tp.getPhaseCount(phaseName);
	    	  bp.waitForElement();
	    	  
	    	  tp.goBackToCycle();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^In Other Browser login as Manager Launch TestRepository and Navigate to Created Phase and ConteXtClick Select 'copy from projects'$")
	  public void in_Other_Browser_login_as_Manager_Launch_TestRepository_and_Navigate_to_Created_Phase_and_ConteXtClick_Select_copy_from_projects() throws Throwable 
	  {
		  try
	      {
			  pp=new ProjectPage(driver);
		    	 tr=new TestRepositoryPage(driver);
		    	 rp=new ReleasePage(driver);
		    	 ctc=new CreateTestCasePage(driver);
		    	 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_2");
		    	 actual[20]= pp.selectProject(projectName); 
		    	 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		    	 actual[21]= pp.selectRelease(releaseName);
		    	 	
	      }
	      catch(Exception e)
			{ lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
	    	  driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Expand the Created Project and ReleasE Select a Phase and Drag it and Drop in the Selected Project$")
	  public void expand_the_Created_Project_and_ReleasE_Select_a_Phase_and_Drag_it_and_Drop_in_the_Selected_Project() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
	    	  actual[22]=rp.clickOnTestPlanning();
	    	  String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",25,0);
	    	  actual[23]=tp.doubleClickOnCycle(cycleName1);
	    	  String cycleName[]=new String[2];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",25,0);
	    	  cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",19,0);
	    	  actual[24]=tp.navigateToCycle(cycleName);
	    	  tp.assignPhase();
	    	 
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
	    	  driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^In first Browser Launch TestPlanning Naviagate to Dropped Phase and ContextClick Choose Assign and Cancel the Popup$")
	  public void in_first_Browser_Launch_TestPlanning_Naviagate_to_Dropped_Phase_and_ContextClick_Choose_Assign_and_Cancel_the_Popup() throws Throwable 
	  {
		  try
	      {
			  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",25,11);
	    	  actual[25]=tp.sync(check);
	    	  
	    	  tp.goBackToCycle();
	    	 
	    	 
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Click on Sync button and View the message$")
	  public void click_on_Sync_button_and_View_the_message() throws Throwable 
	  {
		  try
	      {
			  rp.clickOnTestRep();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  tr.clickOnRelease(releaseName);
	    	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",20,0);
	    	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",20,1);
	    	  actual[26]= tr.addNode(Name, Desc);
	    	  tr.doubleClickOnRelease(releaseName);
	    	  
	    	  BasePage bp=new BasePage();
	    	  //String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",20,0);
	    	  actual[27]=tr.navigateToNode(releaseName, navigation);
	    	  actual[28]=tr.addTestCase();
	    	  
	    	  tr.clickDetailButton();
	    	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",14,0);
	    	  String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",14,1);
	    	  actual[29]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
	    	  bp.waitForElement();
	    	  tr.clickOnList();
	    	  
	    	 
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Select 'Sample Project' in project DropDown and select Release in Release Summary$")
	  public void select_Sample_Project_in_project_DropDown_and_select_Release_in_Release_Summary() throws Throwable 
	  {
		  try
	      {
			  BasePage bp=new BasePage();
	    	  actual[30]=rp.clickOnTestPlanning();
	    	  String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",25,0);
	    	  actual[31]=tp.doubleClickOnCycle(cycleName1);
	    	  String cycleName[]=new String[2];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",25,0);
	    	  cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",19,0);
	    	  actual[32]=tp.navigateToCycle(cycleName);
	    	  tp.assignPhase();
	    	  
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch TestRepository Create a PhaseThree$")
	  public void launch_TestRepository_Create_a_PhaseThree() throws Throwable 
	  {
		  try
	      {
			  LaunchBrowser bt1=new LaunchBrowser();
	    	  actual[33]= bt1.preCond2("chromeBrowser");
	    		String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"URL");
	    		 bt1.getUrl2(url,driver2);
	    		LoginPage lpg=new LoginPage(driver2);
	    		String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Username_1");
	    		actual[34]= lpg.enterUname2(uname,driver2);
	    		actual[35]= lpg.enterPass2(uname,driver2);
	    		actual[36]= lpg.clickOnLogin2(driver2);
	    		
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Navigate to Created phaseThree Add Testcase and Edit its name and Description$")
	  public void navigate_to_Created_phaseThree_Add_Testcase_and_Edit_its_name_and_Description() throws Throwable 
	  {
		  try
	      {
			  ProjectPage pp1=new ProjectPage(driver2);
	    		String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    		actual[37]= pp1.selectProject2(project,driver2);
	    		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    		pp1.selectRelease2(releaseName,driver2);
	    		ReleasePage rp1=new ReleasePage(driver2);
	    		
	    		actual[38]= rp1.clickOnTestRep2(driver2);
	    		
	    		
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Launch TestPlanning Select PhaseOne ContextClick and select Assign$")
	  public void launch_TestPlanning_Select_PhaseOne_ContextClick_and_select_Assign() throws Throwable 
	  {
		  try
	      {
			  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
			  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		    	String navigation[]=new String[1];
		    	navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",18,0);
		    	actual[39]= tr1.navigateToNode2(releaseName, navigation, driver2);
		    	actual[40]=tr1.clickOnCopyFromProjects2(driver2);   
		    	
		    	 
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^In Other Browser login as Manager Launch TestRepository and Navigate to Created Phase and ContextClick, Select 'copy from projects'$")
	  public void in_Other_Browser_login_as_Manager_Launch_TestRepository_and_Navigate_to_Created_Phase_and_ContextClick_Select_copy_from_projects() throws Throwable 
	  {
		  try
	      {
			  cfp=new CopyFromProjects(driver2);
	    	  String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_2");
	    	  actual[41]=cfp.selectProjectFromGlobalArea2(projectName,driver2);
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String nodes[]=new String[1];
	    	  nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",19,0);
	    	  actual[42]=cfp.selectNodeFromGlobalArea2(releaseName, nodes, driver2);
	    	  String nodeName1=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",19,0);
	    	  String nodeName2=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",18,0);
	    	  actual[43]=cfp.dragAndDropNodes2(nodeName1, nodeName2,driver2);
	    	  
	      }
	      catch(Exception e)
			{
//	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  pp.clickOnLogout(driver2);
	    	  pp.closeBrowser();
//	    	  tr1.driverClose(driver2);
	    	  //tr1.driverClose(driver);
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Expand the Created Project and Release Select a Phase and drag it and Drop in the Selected Project$")
	  public void expand_the_Created_Project_and_Release_Select_a_Phase_and_drag_it_and_Drop_in_the_Selected_Project() throws Throwable 
	  {
		  try
	      {
			  actual[44]=cfp.closeCopyFromProjectReleasesPage2(driver2); 
			  
			  bp.waitForElement();
			  bp.waitForElement();
	    		ProjectPage pp1=new ProjectPage(driver2);
	    		pp1.clickOnLogout(driver2);
	      }
	      catch(Exception e)
			{
//	    	  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
	    	  pp.clickOnLogout(driver2);
	    	  pp.closeBrowser();
//	    	  tr1.driverClose(driver2);
	    	  //tr1.driverClose(driver);
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^In first Browser Click on Sync button and View the message$")
	  public void in_first_Browser_Click_on_Sync_button_and_View_the_message() throws Throwable 
	  {
		  try
	      {
			  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",25,11);
	    	  actual[45]=tp.sync(check);
	    	  
	    	  tp.goBackToCycle();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Sync is Successfull when other user adds Testcase in other node/projects$")
	  public void sync_is_Successfull_when_other_user_adds_Testcase_in_other_node_projects() throws Throwable 
	  {
		  try
	      {
			  bp.waitForElement();
			  bp.waitForElement();
			  pp.clickOnLogout();
			  pp.closeBrowser();
			  log.info("Pass - Sync is Successfull when other user adds Testcase in other node/projects");
	    	  for(int k=0;k<=actual.length-1;k++)
		       {
		        soft.assertEquals(actual[k], true);
		       }
		       soft.assertAll();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				driver.close();
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
			}
	  }
  
}
