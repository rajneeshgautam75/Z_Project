package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Search_144 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	DefectTracking dt;
	ExecutionPage exep;
	TestRepositoryPage tr;
	RequirementsPage req;
	TestPlanningPage tp;
	String fileName="Defect_Tracking_Search_144";
	
	boolean[] actual=new boolean[30];
	SoftAssert soft=new SoftAssert();
	
	
	@Given("^User is in the defect Tracking$")
	public void user_is_in_the_defect_Tracking() throws Throwable {
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

	@When("^User search a issue with AND operator$")
	public void user_search_a_issue_with_AND_operator() throws Throwable {
	try
	   {
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,9);
		 String value=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 3,36);
		 exep=new ExecutionPage(driver);
		 actual[1]=dt.advancedSearch(selectSearch, value);
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

	@Then("^Should be search issues with AND operator$")
	public void should_be_search_issues_with_AND_operator() throws Throwable {
	try
	   {
		String defectType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,1); 
		String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,3);
		actual[2]=dt.validateSearchedDefect(defectType, defectValue);
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

	@When("^User launch requirements$")
	public void user_launch_requirements() throws Throwable {
	try
	   {
		 bp.waitForElement();
		 actual[3]=rp.clickOnRequirements();
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

	@When("^search a issue with AND operator$")
	public void search_a_issue_with_AND_operator() throws Throwable {
	try
	   {
		 bp.waitForElement();
		 String importType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,37);
		 req=new RequirementsPage(driver);
		 bp.waitForElement();
		 actual[4]=req.clickOnImport();
		 actual[5]=req.chooseImportType(importType);
		 String selectQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1,8 );
		 String enterQuerry=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,36 );
		 actual[6]=req.selectQuerry(selectQuerry, enterQuerry);
		 actual[7]=req.clickOnJiraSearchButton();
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

	@Then("^Should be able to search issue with AND operator$")
	public void should_be_able_to_search_issue_with_AND_operator() throws Throwable {
	try
	   {
		 String defectType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,1); 
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,3);
		 actual[8]=req.validateSearchedDefect(defectType, defectValue);
		 bp.waitForElement();
		 actual[9]=req.clickOnCancelJiraSearchWindow();
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

	@When("^User launch Test Execution to search Issue$")
	public void user_launch_Test_Execution_to_search_Issue() throws Throwable {
	try
	   {
	    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
	    tr=new TestRepositoryPage(driver);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,12);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		bp.waitForElement();
		actual[10]=rp.clickOnTestRep();
		bp.waitForElement();
		actual[11]=tr.clickOnRelease(releaseName);
		bp.waitForElement();
		actual[12]=tr.addNode(p_Name1,p_Desc1);  
		String[] phase=new String[1];
		phase[0]=p_Name1;
		bp.waitForElement();
		actual[13]=tr.navigateToNode(releaseName, phase);
		for(int i=1;i<=2;i++)
		{
		tr.addTestCase();
		}
	
	  bp.waitForElement();
	  actual[14]=rp.clickOnTestPlanning();
	  
	    tp=new TestPlanningPage(driver);
		String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,13);
		String build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
		String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
		String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
		actual[15]=tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		actual[16]=tp.CreateCycle(cycle, build, environ, hide);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
		String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
		String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
		actual[17]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		bp.waitForElement();
		actual[18]=tp.saveTestCycle();
		bp.waitForElement();
		
    	String[] cycle1=new String[1];
		cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 16, 13);
		actual[19]=tp.navigateToCycle(cycle1);
		
		bp.waitForElement();
		actual[20]=tp.addPhaseToCycle(phase[0]);
		bp.waitForElement();
		String bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
		bp.waitForElement();
		actual[21]=tp.bulkAssignment(bulk_Type);
		actual[22]=tp.goBackToCycle();
		
		   bp.waitForElement();
		   actual[23]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    //String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,12 );
		    
		    bp.waitForElement();
			actual[24]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[25]=exep.executeStatus(tcNo1[0], statusType1);
		    actual[26]=exep.clickOnDefectButton(tcNo1[0]);
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

	@When("^Search a issue with AND Operator$")
	public void search_a_issue_with_AND_Operator() throws Throwable {
	try
	   {
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,9);
		 String value=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,36);
		 actual[27]=exep.defectSearch(selectSearch, value);
		 //exep.clickOnDefectSearchButton();
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
	
	@Then("^Should be able to search a issue with AND operator$")
	public void should_be_able_to_search_a_issue_with_AND_operator() throws Throwable {
	try
	   {
		 String defectType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,1); 
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,3);
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[28]=exep.validateSearchedDefect(defectType, defectValue);
		 
		 bp.waitForElement();
		 actual[29]=exep.clickOnCancelDefectWindow();
		 tp.doubleClickOnCycle(releaseName);
		 
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
