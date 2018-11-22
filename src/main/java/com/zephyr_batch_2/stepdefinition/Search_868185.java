package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Search_868185 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	String fileName="Search_868185";
	
	boolean[] actual=new boolean[62];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in testRepository page$")
	public void user_is_in_testRepository_page() throws Throwable {
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

	@Given("^User creates a phase and creates a testcase under a phase$")
	public void user_creates_a_phase_and_creates_a_testcase_under_a_phase() throws Throwable {
		try
	    {
					tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 2, 1);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 2, 2);
				
				bp=new BasePage();
				actual[3]=tr.doubleClickOnRelease(releaseName);
				 bp.waitForElement();
				actual[4]=tr.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
				tr.doubleClickOnRelease(releaseName);
				String[] phase=new String[1];
				phase[0]=p_Name1;
				 bp.waitForElement();
				actual[5]=tr.navigateToNode(releaseName, phase);
				tr.addTestCase();
				
				actual[6]=tr.clickDetailButton();
				String Priority1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
				String AltID1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 2, 2);
				String Comment1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[7]=ctc.enterTestCaseDetails(Priority1, AltID1, Comment1);
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

	@When("^User creates a testcases with different characters in testcase altId$")
	public void user_creates_a_testcases_with_different_characters_in_testcase_altId() throws Throwable {
	   try
	   {
		   actual[8]=tr.clickOnList();
			bp.waitForElement();
			actual[9]=tr.addTestCase();
			bp.waitForElement();
			actual[10]=tr.clickDetailButton();
			String Priority2=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
			String AltID2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 2, 3);
			String Comment2=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			actual[11]=ctc.enterTestCaseDetails(Priority2, AltID2, Comment2);
			//ctc.enterTestCaseDetail(details)
			bp.waitForElement();
		   
		   actual[12]=tr.clickOnList();
			bp.waitForElement();
			actual[13]=tr.addTestCase();
			bp.waitForElement();
			actual[14]=tr.clickDetailButton();
			String Priority3=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
			String AltID3=UNIQUE+Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "testcaseDetails", 2, 4));
			String Comment3=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			actual[15]=ctc.enterTestCaseDetails(Priority3, AltID3, Comment3);
			bp.waitForElement();
			
			actual[16]=tr.clickOnList();
			bp.waitForElement();
			actual[17]=tr.addTestCase();
			bp.waitForElement();
			actual[18]=tr.clickDetailButton();
			String Priority4=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
			String AltID4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 2, 5);
			String Comment4=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			actual[19]=ctc.enterTestCaseDetails(Priority4, AltID4, Comment4);
			bp.waitForElement();
			
			actual[20]=tr.clickOnList();
			bp.waitForElement();
			actual[21]=tr.addTestCase();
			bp.waitForElement();
			actual[22]=tr.clickDetailButton();
			String Priority5=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
			String AltID5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 2, 6);
			String Comment5=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			actual[23]=ctc.enterTestCaseDetails(Priority5, AltID5, Comment5);
			bp.waitForElement();
			
			actual[24]=tr.clickOnList();
			bp.waitForElement();
			actual[25]=tr.addTestCase();
			bp.waitForElement();
			actual[26]=tr.clickDetailButton();
			String Priority6=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
			String AltID6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 2, 7);
			String Comment6=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			actual[27]=ctc.enterTestCaseDetails(Priority6, AltID6, Comment6);
			bp.waitForElement();
			tr.clickOnList();
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

	@When("^User Launches testPlanning and creates a cycle$")
	public void user_Launches_testPlanning_and_creates_a_cycle() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[28]=rp.clickOnTestPlanning();
			  bp.waitForElement();
//			  rp.clickOnTestPlanning();
//			  bp.waitForElement();
			  
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 2, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[29]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[30]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[31]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[32]=tp.saveTestCycle();
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

	@When("^User selects the cycle context menu and creates a new phase and save$")
	public void user_selects_the_cycle_context_menu_and_creates_a_new_phase_and_save() throws Throwable {
		try
	    {
			actual[33]=bp.waitForElement();
			//actual[33]=rp.clickOnTestPlanning();
			bp.waitForElement();
			
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 2, 0);
			bp.waitForElement();
			actual[34]=tp.navigateToCycle(cycle);
			
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 2, 1);
			bp.waitForElement();
			actual[35]=tp.createFreeFormPhase(phaseName);
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

	@When("^User clicks on Add Testcase window and search a testcase by testcase altid containing only lowercase characters$")
	public void user_clicks_on_Add_Testcase_window_and_search_a_testcase_by_testcase_altid_containing_only_lowercase_characters() throws Throwable {
		try
		{
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",2 ,1 );
		     bp.waitForElement();
		     actual[36]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[37]=tp.clickOnAddTestcasesToFreeForm();
		     
		     String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",1 ,6 );
		     bp.waitForElement();
		     actual[38]=tp.quiksearch(name);
		     
		     bp.waitForElement();
		     actual[39]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     //actual[40]=tp.clickOnCheckBoxSaveAllTestcases();
		     
		     bp.waitForElement();
		     actual[40]=tp.clickOnSaveAndOk();
		     
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

	@When("^User search a testcase by testcase altid containing only capital characters$")
	public void user_search_a_testcase_by_testcase_altid_containing_only_capital_characters() throws Throwable {
		try
	    {
	    	actual[41]=tp.quickSearch();
	    	String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",1 ,7 );
		     bp.waitForElement();
		     actual[42]=tp.quiksearch(name);
		     
		     bp.waitForElement();
		     actual[43]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		    // actual[45]=tp.clickOnCheckBoxSaveAllTestcases();
		     
		     bp.waitForElement();
		     actual[44]=tp.clickOnSaveAndOk();
		     
//		     bp.waitForElement();
//		     actual[46]=tp.closeFreeFormPage();
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

	@When("^User search a testcase by testcase altid containing only numbers$")
	public void user_search_a_testcase_by_testcase_altid_containing_only_numbers() throws Throwable {
		try
	    {
	    	actual[45]=tp.quickSearch();
	    	String name=UNIQUE+Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "FreeForm",1 ,8 ));
		     bp.waitForElement();
		     actual[46]=tp.quiksearch(name);
		     
		     bp.waitForElement();
		     actual[47]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     //actual[50]=tp.clickOnCheckBoxSaveAllTestcases();
		     
		     bp.waitForElement();
		     actual[48]=tp.clickOnSaveAndOk();
		     
//		     bp.waitForElement();
//		     actual[46]=tp.closeFreeFormPage();
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

	@When("^User search a testcase by testcase altid containing only alphanumeric characters and spaces$")
	public void user_search_a_testcase_by_testcase_altid_containing_only_alphanumeric_characters_and_spaces() throws Throwable {
		try
	    {
	    	actual[49]=tp.quickSearch();
	    	String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",2,5 );
		     bp.waitForElement();
		     actual[50]=tp.quiksearch(name);
		     
		     bp.waitForElement();
		     actual[51]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     //actual[55]=tp.clickOnCheckBoxSaveAllTestcases();
		     
		     bp.waitForElement();
		     actual[52]=tp.clickOnSaveAndOk();
		     
//		     bp.waitForElement();
//		     actual[46]=tp.closeFreeFormPage();
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

	@When("^User search a testcase by testcase altid containing only international characters$")
	public void user_search_a_testcase_by_testcase_altid_containing_only_international_characters() throws Throwable {
		try
	    {
	    	actual[53]=tp.quickSearch();
	    	String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",1 ,10 );
		     bp.waitForElement();
		     actual[54]=tp.quiksearch(name);
		     
		     bp.waitForElement();
		     actual[55]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     //actual[56]=tp.clickOnCheckBoxSaveAllTestcases();
		     
		     bp.waitForElement();
		     actual[56]=tp.clickOnSaveAndOk();
		     
//		     bp.waitForElement();
//		     actual[46]=tp.closeFreeFormPage();
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

	@When("^User search a testcase by testcase altid containing only long name$")
	public void user_search_a_testcase_by_testcase_altid_containing_only_long_name() throws Throwable {
		try
	    {
	    	actual[57]=tp.quickSearch();
	    	String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",1 ,11 );
		     bp.waitForElement();
		     actual[58]=tp.quiksearch(name);
		     
		     bp.waitForElement();
		     actual[59]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     //actual[65]=tp.clickOnCheckBoxSaveAllTestcases();
		     
		     bp.waitForElement();
		     actual[60]=tp.clickOnSaveAndOk();
		     
		     bp.waitForElement();
		     actual[61]=tp.closeFreeFormPage();
		     
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

	@Then("^User successfully search and add testcases with testcase atlId have different characters$")
	public void user_successfully_search_and_add_testcases_with_testcase_atlId_have_different_characters() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("User successfully search and add testcases with testcase contents have different characters");
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
