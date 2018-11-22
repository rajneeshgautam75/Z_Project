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

public class DefectTracking_44 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestPlanningPage tp;
	TestRepositoryPage tr;
	ExecutionPage ep;
	DefectTracking dt;
	CreateCustomFieldsPage ccp;
	CreateTestCasePage ctc;
	boolean[] actual=new boolean[42];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_44";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^User is in a Page of Defect Tracking$")
	public void user_is_in_a_Page_of_Defect_Tracking() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			rp=new ReleasePage(driver);
			dt=new DefectTracking(driver);
			bp=new BasePage();
			actual[0]=pp.selectProject(project);
			actual[1]=pp.selectRelease(release);
			bp.waitForElement();
		    actual[2]=pp.clickOnDefectTracking();
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

	@When("^User searches Defect by any Attribute$")
	public void user_searches_Defect_by_any_Attribute() throws Throwable {
		try
		   {
			   String project=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			   String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			   String status=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			   String filedBy=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			   String version=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			   String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			   String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			   bp.waitForElement();
			   actual[3]=dt.defectSearch(project, issueType, status, filedBy, version, priority, assignee);
			   
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

	@When("^after search,Sort on Any Column Header of Defects$")
	public void after_search_Sort_on_Any_Column_Header_of_Defects() throws Throwable {
		try
		{
			ep=new ExecutionPage(driver);
			String headerName=Excel_Lib.getData(INPUT_PATH_7, "Defects", 6, 8);
			bp.waitForElement();
			actual[4]=ep.sortAnyHeaderListings(headerName);
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

	@When("^User launches Defect tracking app and search by Jql$")
	public void user_launches_Defect_tracking_app_and_search_by_Jql() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[5]=pp.clickOnDefectTracking();	
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

	@When("^after search,sort any column Header of Defect listings$")
	public void after_search_sort_any_column_Header_of_Defect_listings() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 8);
			String name=Excel_Lib.getData(INPUT_PATH_7, "Defects", 3, 8);
			bp.waitForElement();
			actual[6]=dt.advancedSearch(jql, name);	
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

	@Then("^Should be sorted Defects$")
	public void should_be_sorted_Defects() throws Throwable {
		try
		{
			String headerName=Excel_Lib.getData(INPUT_PATH_7, "Defects", 4, 7);
			bp.waitForElement();
			actual[7]=ep.sortAnyHeaderListings(headerName);	
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

	@When("^user launches defect tracking app and searches by MyFilter$")
	public void user_launches_defect_tracking_app_and_searches_by_MyFilter() throws Throwable {
		try
		{
			ep=new ExecutionPage(driver);
			bp.waitForElement();
			actual[8]=pp.clickOnDefectTracking();
			bp.waitForElement();
			actual[9]=dt.clickOnBasicSearch();
			
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

	@When("^sorts any column Header of Defect Listings$")
	public void sorts_any_column_Header_of_Defect_Listings() throws Throwable {
		try
		{
			String myFilter=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 8);
			String name=Excel_Lib.getData(INPUT_PATH_7, "Defects", 4, 8);
			bp.waitForElement();
			bp.waitForElement();
			actual[10]=dt.advancedSearch(myFilter, name);
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

	@Then("^Defect listings should be sorted$")
	public void defect_listings_should_be_sorted() throws Throwable {
		try
		{
			String headerName=Excel_Lib.getData(INPUT_PATH_7, "Defects", 6, 8);
			bp.waitForElement();
			actual[11]=ep.sortAnyHeaderListings(headerName);	
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

	@When("^user is in test execution page,executes testcase with any status and clicks on D button$")
	public void user_is_in_test_execution_page_executes_testcase_with_any_status_and_clicks_on_D_button() throws Throwable {
	   try
	   {
		    rp=new ReleasePage(driver);
			tp=new TestPlanningPage(driver);
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			ctc=new CreateTestCasePage(driver);
			ep=new ExecutionPage(driver);
			dt=new DefectTracking(driver);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 1, 5);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 1, 6);
			String [] navigation=new String [1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 1, 5);
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 4, 4);
			String Build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 3, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 7, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 6, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 6, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 6, 1);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 8, 5));
			String [] cycle1 =new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 4, 4);
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 1,5);
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 1, 0);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",4,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",1,5);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			String phase_1[]=new String[1];
			phase_1[0]=phase;
		    int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
		    String myFilter=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 8);
			String defect=Excel_Lib.getData(INPUT_PATH_7, "Defects", 5, 8);
			actual[12]=rp.clickOnTestRep();
			bp.waitForElement();
			actual[13]=tr.clickOnRelease(release);
			actual[14]=tr.addNode(name, desc);
			bp.waitForElement();
			actual[15]=tr.navigateToNode(release, navigation);
			actual[16]=tr.addTestCase();	
			bp.waitForElement();
			actual[17]=rp.clickOnTestPlanning();
			bp.waitForElement();
			actual[18]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[19]=tp.CreateCycle(cycle, Build, Environment, hide);
			bp.waitForElement();
			actual[20]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[21]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			actual[22]=tp.navigateToCycle(cycle1);
			bp.waitForElement();
			actual[23]=tp.addPhaseToCycle(phase);
			bp.waitForElement();
			actual[24]=tp.bulkAssignment(bulk_type);
			tp.goBackToCycle();
			actual[25]=rp.clickOnTestExecution();
			actual[26]=bp.waitForElement();
			actual[27]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[28]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[29]=ep.changeMultiSelectedStatus(status);
			actual[30]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			actual[31]=ep.defectSearch(myFilter, defect);
	    	
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

	@When("^user search by MyFilter and Sorts  on any column header of Defect Listings$")
	public void user_search_by_MyFilter_and_Sorts_on_any_column_header_of_Defect_Listings() throws Throwable {
		try
		{
			String headerName=Excel_Lib.getData(INPUT_PATH_7, "Defects", 4, 7);
			bp.waitForElement();
			actual[32]=ep.sortAnyHeaderListings(headerName);	
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

	@When("^Launch Test Execution,Execute testcase with any status and Click on D$")
	public void launch_Test_Execution_Execute_testcase_with_any_status_and_Click_on_D() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",4,4 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",1,5);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			bp.waitForElement();
			bp.waitForElement();
			ep.closeLinkedDefectWindow();
			bp.waitForElement();
			actual[33]=rp.clickOnTestExecution();
			actual[34]=bp.waitForElement();
			actual[35]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[36]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[37]=ep.changeMultiSelectedStatus(status);
			actual[38]=ep.clickOnDefectButton(testcase1);
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

	@When("^Search by JQL,Sort on any Column Header of Defect Listings$")
	public void search_by_JQL_Sort_on_any_Column_Header_of_Defect_Listings() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 8);
			String defect=Excel_Lib.getData(INPUT_PATH_7, "Defects", 3, 8);
			bp.waitForElement();
			actual[39]=ep.defectSearch(jql, defect);
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

	@Then("^Should be able to Perform Sort on any column header of Defect Listings$")
	public void should_be_able_to_Perform_Sort_on_any_column_header_of_Defect_Listings() throws Throwable {
		try
		{
			String headerName=Excel_Lib.getData(INPUT_PATH_7, "Defects", 4, 7);
			bp.waitForElement();
			actual[40]=ep.sortAnyHeaderListings(headerName);
			bp.waitForElement();
			bp.waitForElement();
			actual[41]=ep.closeLinkedDefectWindow();
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
