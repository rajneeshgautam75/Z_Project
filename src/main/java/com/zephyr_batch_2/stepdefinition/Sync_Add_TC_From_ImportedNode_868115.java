package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
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

public class Sync_Add_TC_From_ImportedNode_868115 extends LaunchBrowser
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
	String fileName="Sync_868115";
	
	boolean[] actual=new boolean[28];
	  SoftAssert soft=new SoftAssert();
	  
	  @Given("^Select the project For the TestPlanning$")
	  public void select_the_project_For_the_TestPlanning() throws Throwable 
	  {
	      try
	      {
	    	  pp=new ProjectPage(driver);
		    	 tr=new TestRepositoryPage(driver);
		    	 rp=new ReleasePage(driver);
		    	 ip=new ImportPage(driver);
		    	 ctc=new CreateTestCasePage(driver);
		    	 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		    	 actual[0]= pp.selectProject(projectName);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Click on relese in Release summary$")
	  public void click_on_relese_in_Release_summary() throws Throwable 
	  {
	      try
	      {
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		    	 actual[1]= pp.selectRelease(releaseName);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch TestRepository and create A phase$")
	  public void launch_TestRepository_and_create_A_phase() throws Throwable 
	  {
	      try
	      {
	    	  rp.clickOnTestRep();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  tr.doubleClickOnRelease(releaseName);
	    	  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",2,0);
	    	  String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",2,1);
	    	  actual[2]= tr.addNode(Name, Desc);
	    	  tr.doubleClickOnRelease(releaseName);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Navigate to Created phase and Add Testcase and Edit the Testcase Nmae and Description$")
	  public void navigate_to_Created_phase_and_Add_Testcase_and_Edit_the_Testcase_Nmae_and_Description() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
	    	  String navigation[]=new String[1];
	    	  navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",2,0);
	    	  actual[3]=tr.navigateToNode(releaseName, navigation);
	    	  actual[4]=tr.addTestCase();
	    	  
	    	  tr.clickDetailButton();
	    	  String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",2,0);
	    	  String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Testcase",2,1);
	    	  actual[5]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
	    	  bp.waitForElement();
	    	  tr.clickOnList();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Select the Added TestCase and Clone it$")
	  public void select_the_Added_TestCase_and_Clone_it() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  tr.selectallTestCase();
	    	  bp.waitForElement();
	    	  actual[6]=tr.cloneTestCase();
	    	  bp.waitForElement();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Launch TestPlanning and create Exicution Cycle$")
	  public void launch_TestPlanning_and_create_Exicution_Cycle() throws Throwable 
	  {
	     try
	     {
	    	 tp=new TestPlanningPage(driver);
	    	  BasePage bp=new BasePage();
	    	  actual[7]= rp.clickOnTestPlanning();
//	    	  bp.waitForElement();
//	    	  rp.clickOnTestPlanning();
	    	  bp.waitForElement();
	    	  actual[8]= tp.clickOnAddTestCycleSymbol();
	    	  bp.waitForElement();
	    	  String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",7,0);
	    	  String Build=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",7,1));
	    	  String environ=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",7,2);
	    	  String hide=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",7,100);
	    	  actual[9]=tp.CreateCycle(cycle, Build, environ, hide);
	    	  String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",7,3));
	    	  String smonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",7,4);
	    	  String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",7,5));
	    	  String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",7,6));
	    	  String emonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",7,7);
	    	  String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",7,8));
	    	  actual[10]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
	    	  bp.waitForElement();
	    	  tp.saveTestCycle();
	     }
	     catch(Exception e)
			{
	    	 lb=new LaunchBrowser();
	         lb.getScreenShot(fileName);	
	    	 driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Add a Phase in created Exicution Cycle, Choose Existing Phase, Save it and Choose 'Assign to Anyone'$")
	  public void add_a_Phase_in_created_Exicution_Cycle_Choose_Existing_Phase_Save_it_and_Choose_Assign_to_Anyone() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  bp.waitForElement();
	    	  String cycleName[]=new String[1];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",7,0);
	    	  actual[11]=tp.navigateToCycle(cycleName);
	    	  bp.waitForElement();
	    	  String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",2,0);
	    	  actual[12]= tp.addPhaseToCycle(Phase);
	    	  bp.waitForElement();
	    	  String Bulk_type=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",7,9);
	    	  actual[13]=tp.bulkAssignment(Bulk_type);
	    	  bp.waitForElement();
	    	  String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",2,0);
	    	  actual[14]=tp.getPhaseCount(phaseName);
	    	  bp.waitForElement();
	    	  
	    	  tp.goBackToCycle();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Launch TestRepository and Create Map$")
	  public void launch_TestRepository_and_Create_Map() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  actual[15]=rp.clickOnTestRep();
	    	  bp.waitForElement();
	    	  actual[16]=ip.clickOnImport();
	    	  bp.waitForElement();
	    	  String mapname=Excel_Lib.getData(INPUT_PATH, "Create_Map", 10, 0);
				int rownum=Excel_Lib.getNumberData(INPUT_PATH, "Create_Map", 10, 1);
				String[] ZephyrFields= new String[10];
				ZephyrFields[0]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 3);
				ZephyrFields[1]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 9);
				ZephyrFields[2]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 11);
				ZephyrFields[3]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 13);
				ZephyrFields[4]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 6);
				ZephyrFields[5]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 12);
				ZephyrFields[6]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 14);
				ZephyrFields[7]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 16);
				ZephyrFields[8]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 15);
				ZephyrFields[9]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 17);
//				ZephyrFields[10]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 19);
//				ZephyrFields[11]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 22);
//				ZephyrFields[12]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 23);
//				ZephyrFields[13]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 24);
//				ZephyrFields[14]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 25);
//				ZephyrFields[15]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 99);
//				ZephyrFields[16]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 18);
//				ZephyrFields[17]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 26);
//				ZephyrFields[18]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 20);
//				ZephyrFields[19]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 27);
//				ZephyrFields[20]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 28);
//				ZephyrFields[21]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 29);
				bp.waitForElement();
				actual[17]=ip.updateMap(mapname, rownum, ZephyrFields);
				bp.waitForElement();
	    	  
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Create a Import Job with Choosing File$")
	  public void create_a_Import_Job_with_Choosing_File() throws Throwable 
	  {
	      try
	      {
	    	  bp=new BasePage();
	    	  String jobname=Excel_Lib.getData(INPUT_PATH, "Import_Job", 12, 0);
			   String mapName=Excel_Lib.getData(INPUT_PATH, "Import_Job", 12, 1);
			   String path=Excel_Lib.getData(INPUT_PATH, "Import_Job", 11, 2);
			   bp.waitForElement();
			   actual[18]=ip.importTestCase(jobname, mapName, path);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Run the Import Job and View the Status Report$")
	  public void run_the_Import_Job_and_View_the_Status_Report() throws Throwable 
	  {
	      try
	      {
	    	  bp=new BasePage();
	    	  bp.waitForElement();
	    	  actual[19]=ip.runJob();
	    	  actual[20]=ip.ClickOKonStatusReport();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Navigate to Imported Folder Select the Imported File and Copy it$")
	  public void navigate_to_Imported_Folder_Select_the_Imported_File_and_Copy_it() throws Throwable 
	  {
	      try
	      {
	    	  bp=new BasePage();
	    	  String fileName=Excel_Lib.getData(INPUT_PATH,"Import_Job",11,3);
				String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
				actual[21]=ip.validateImport(fileName, releaseName);
				tr.options.click();
		    	bp.waitForElement();
		    	tr.copyImportedFile.click();
		    	bp.waitForElement();
		    	tr.doubleClickOnRelease(releaseName);
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @When("^Navigate to TestPlanning Release and Paste the Imported file in Created Phase$")
	  public void navigate_to_TestPlanning_Release_and_Paste_the_Imported_file_in_Created_Phase() throws Throwable 
	  {
	      try
	      {
	    	  String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
		    	String navigation[]=new String[1];
			    navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "TP_Phases", 2, 0);
			    tr.doubleClickOnRelease(releaseName);
			    bp.waitForElement();
			    actual[22]=tr.navigateToNode(releaseName, navigation);
			    actual[23]=tr.pasteNode();
			    bp.waitForElement();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Launch TestPlanning, naviagate to Created Phase and ContextClick, Choose Assign and Cancel the Popup$")
	  public void launch_TestPlanning_naviagate_to_Created_Phase_and_ContextClick_Choose_Assign_and_Cancel_the_Popup() throws Throwable 
	  {
	      try
	      {
	    	  BasePage bp=new BasePage();
	    	  actual[24]=rp.clickOnTestPlanning();
//	    	  bp.waitForElement();
//	    	  rp.clickOnTestPlanning();
//	    	  bp.waitForElement();
	    	  String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",7,0);
	    	  actual[25]=tp.doubleClickOnCycle(cycleName1);
	    	  String cycleName[]=new String[2];
	    	  cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",7,0);
	    	  cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases",2,0);
	    	  actual[26]=tp.navigateToCycle(cycleName);
	    	  bp.waitForElement();
	    	  tp.assignPhase();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Click on Sync button and view the Message$")
	  public void click_on_Sync_button_and_view_the_Message() throws Throwable 
	  {
	      try
	      {
	    	  String check=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",100,100);
	    	  actual[27]=tp.sync(check);
	    	  
	    	  tp.goBackToCycle();
	      }
	      catch(Exception e)
			{
	    	  lb=new LaunchBrowser();
	          lb.getScreenShot(fileName);
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

	  @Then("^Testcase added from imported node is Viewed Successfully$")
	  public void Testcase_added_from_imported_node_is_Viewed_Successfully() throws Throwable 
	  {
	      try
	      {
	    	  log.info("Pass - Testcase added from imported node is Viewed Successfully");
	    	  
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
	    	  driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  }

}
