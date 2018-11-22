package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Search_868205 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	ExportPage ep;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	RequirementsPage req;
	String fileName="Search_868205";
	
	boolean[] actual=new boolean[26];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in A page TestRepository$")
	public void user_is_in_A_page_TestRepository() throws Throwable {
		try
		   {
			bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	 bp.waitForElement();
	    	 actual[0]=pp.selectProject(projectName);
	    	 actual[1]=pp.selectRelease(releaseName);
	    	 
	    	 rp= new ReleasePage(driver);
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

	@When("^User creates a phase with testcases with all the availble fields$")
	public void user_creates_a_phase_with_testcases_with_all_the_availble_fields() throws Throwable {
		try
	    {
				tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 23, 1);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 23, 2);
				
				bp=new BasePage();
				actual[3]=tr.doubleClickOnRelease(releaseName);
				 bp.waitForElement();
				actual[4]=tr.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
				actual[5]=tr.doubleClickOnRelease(releaseName);
				String[] phase=new String[1];
				phase[0]=p_Name1;
				 bp.waitForElement();
				actual[6]=tr.navigateToNode(releaseName, phase);
				tr.addTestCase();
				bp.waitForElement();
				actual[7]=tr.clickDetailButton();
				bp.waitForElement();
				String[] tags1=new String[1];
				tags1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 2, 2);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[8]=ctc.enterMultipletags(tags1);
				bp.waitForElement();
				
				ctc=new CreateTestCasePage(driver);
				String tcName=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 1, 0);
				String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"Search_868221" , 1, 1);
				bp.waitForElement();
				actual[9]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
				
				String Priority1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 1, 1);
				String AltID1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "testcaseDetails", 2, 4));
				String Comment1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 2, 5);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[10]=ctc.enterTestCaseDetails(Priority1, AltID1, Comment1);
				bp.waitForElement();
				
				String[] stepDetail=new String[9];
				stepDetail[0]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 1, 6);
				stepDetail[1]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 1, 7);
				stepDetail[2]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 1, 8);
				stepDetail[3]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 2, 6);
				stepDetail[4]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 2, 7);
				stepDetail[5]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 2, 8);
				stepDetail[6]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 3, 6);
				stepDetail[7]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 3, 7);
				stepDetail[8]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 3, 8);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[11]=ctc.enterTestCaseStepDetail(stepDetail);
				bp.waitForElement();
				
				bp.waitForElement();
				ctc.customFieldOption.click();
				
				String text=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 1, 3);
				String longText=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 2, 3);
				String number=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Search_868221", 0, 3));
				String checkBox=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
				String pickupList=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
				String date=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
				bp.waitForElement();
				actual[12]=ctc.enterCustomFields(text, longText, number, checkBox, pickupList, date);
				bp.waitForElement();
				tr.clickOnList();
				bp.waitForElement();
				tr.selectallTestCase();
				bp.waitForElement();
				tr.cloneTestCase();
				bp.waitForElement();
				tr.selectallTestCase();
				bp.waitForElement();
				tr.cloneTestCase();
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

	@When("^User Launch TestPlanning and creates a cycle$")
	public void user_Launch_TestPlanning_and_creates_a_cycle() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[13]=rp.clickOnTestPlanning();
			  bp.waitForElement();
				//rp.clickOnTestPlanning();
				bp.waitForElement();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 23, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[14]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[15]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[16]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[17]=tp.saveTestCycle();
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

	@When("^User clicks on cycle context menu and creates the freeform phase$")
	public void user_clicks_on_cycle_context_menu_and_creates_the_freeform_phase() throws Throwable {
		try
	    {
			actual[18]=bp.waitForElement();
			//actual[18]=rp.clickOnTestPlanning();
			
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 23, 0);
			actual[19]=tp.navigateToCycle(cycle);
			
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 23, 1);
			actual[20]=tp.createFreeFormPhase(phaseName);
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

	@When("^User Launch Add testcase window and selects the advanced search$")
	public void user_Launch_Add_testcase_window_and_selects_the_advanced_search() throws Throwable {
		try
	    {
	    	String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",23 ,1 );
		     bp.waitForElement();
		     actual[21]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[22]=tp.clickOnAddTestcasesToFreeForm();
		     
		     bp.waitForElement();
		     actual[23]=tp.clickOnAdvanceSearch();
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

	@When("^User search testcases and performs sort operation for all the available parameters$")
	public void user_search_testcases_and_performs_sort_operation_for_all_the_available_parameters() throws Throwable {
		try
	    {
			String name1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",10 ,0 );
 	    	String operator1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",11 ,1 );
 	    	String value1=Excel_Lib.getData(INPUT_PATH_3, "Search_868221",2 ,0 );//long characters only
 	    	bp.waitForElement();
 	    	actual[24]=tp.ZQLSearch1(name1, operator1, value1);
 	    	bp.waitForElement();
			
	    	bp.waitForElement();
	    	String[] sortName=new String[14];
			bp.waitForElement();
			sortName[0]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 1, 4);
			sortName[1]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 2, 4);
			sortName[2]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 3, 4);
			sortName[3]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 4, 4);
			sortName[4]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 5, 4);
			sortName[5]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 6, 4);
			sortName[6]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 7, 4);
			sortName[7]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 8, 4);
			sortName[8]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 9, 4);
			sortName[9]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 10, 4);
			sortName[10]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 11, 4);
			sortName[11]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 12, 4);
			sortName[12]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 13, 4);
			sortName[13]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 14, 4);
			
			bp.waitForElement();
			bp.waitForElement();
			actual[25]=tp.zqlSort(sortName);
			bp.waitForElement();
			bp.waitForElement();
			tp.sortzqlIDs.click();
			bp.waitForElement();
			tp.closeFreeFormPage();
			bp.waitForElement();
			
			bp.waitForElement();
		 	tp.selectallTestCase();
		 	bp.waitForElement();
		 	String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
		 	tp.assignAllSelected(assignee);
		 	bp.waitForElement();
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

	@Then("^User should be able to sort by columns successfully in ZQL search results$")
	public void user_should_be_able_to_sort_by_columns_successfully_in_ZQL_search_results() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("User should be able to sort by columns successfully in ZQL search results");
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
