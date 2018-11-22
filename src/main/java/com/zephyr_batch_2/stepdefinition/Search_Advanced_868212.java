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

public class Search_Advanced_868212 extends LaunchBrowser {

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
	String fileName="Search_868212";
	
	boolean[] actual=new boolean[90];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in a page of an testrepOsitory$")
	public void user_is_in_a_page_of_an_testrepOsitory() throws Throwable {
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

	@When("^User creates a phase and creates a testcases with available priorities$")
	public void user_creates_a_phase_and_creates_a_testcases_with_available_priorities() throws Throwable {
	   try
	   {
		   tr=new TestRepositoryPage(driver);
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 16, 1);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 16, 2);
			
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
			
			String[] Priority1=new String[1];
			Priority1[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 20);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			actual[8]=ctc.enterPriority(Priority1);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			bp.waitForElement();
			
			actual[9]=tr.clickOnList();
			bp.waitForElement();
			actual[10]=tr.addTestCase();
			bp.waitForElement();
			actual[11]=tr.clickDetailButton();
			String[] Priority2=new String[1];
			Priority2[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 2, 20);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			actual[12]=ctc.enterPriority(Priority2);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			bp.waitForElement();
		   
		   actual[13]=tr.clickOnList();
			bp.waitForElement();
			actual[14]=tr.addTestCase();
			bp.waitForElement();
			actual[15]=tr.clickDetailButton();
			String[] Priority3=new String[1];
			Priority3[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 3, 20);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			actual[16]=ctc.enterPriority(Priority3);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			bp.waitForElement();
			
			actual[17]=tr.clickOnList();
			bp.waitForElement();
			actual[18]=tr.addTestCase();
			bp.waitForElement();
			actual[19]=tr.clickDetailButton();
			//ctc.enterTestCaseDetail(details);
			String[] Priority4=new String[1];
			Priority4[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 4, 20);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			actual[20]=ctc.enterPriority(Priority4);
			bp.waitForElement();
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

	@When("^User Launches a TEstPlanning and creates a cycle$")
	public void user_Launches_a_TEstPlanning_and_creates_a_cycle() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[21]=rp.clickOnTestPlanning();
			  bp.waitForElement();
//			  rp.clickOnTestPlanning();
//			  bp.waitForElement();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 16, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[22]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[23]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[24]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[25]=tp.saveTestCycle();
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

	@When("^User clicks on cycle context menu and creates a freeform phase$")
	public void user_clicks_on_cycle_context_menu_and_creates_a_freeform_phase() throws Throwable {
		try
	    {
			actual[26]=bp.waitForElement();
			//actual[26]=rp.clickOnTestPlanning();
			
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 16, 0);
			bp.waitForElement();
			actual[27]=tp.navigateToCycle(cycle);
			
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 16, 1);
			actual[28]=tp.createFreeFormPhase(phaseName);
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

	@When("^User Launches a Add Testcase window$")
	public void user_Launches_a_Add_Testcase_window() throws Throwable {
		try
		{
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",16 ,1 );
		     bp.waitForElement();
		     actual[29]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[30]=tp.clickOnAddTestcasesToFreeForm();
		    
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

	@When("^User selects advanced search$")
	public void user_selects_advanced_search() throws Throwable {
	    try
	    {
	    	bp.waitForElement();
	    actual[31]=tp.clickOnAdvanceSearch();	
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

	@When("^User search a testcases with supported operators$")
	public void user_search_a_testcases_with_supported_operators() throws Throwable {
	    try
	    {
	    	String name1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",14 ,0 );
	    	String operator1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,1 );
	    	String value1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",1 ,1 );
	    	bp.waitForElement();
	    	actual[32]=tp.ZQLSearch1(name1, operator1, value1);
	    	actual[33]=tp.validateSearch();
	    	bp.waitForElement();
	    	actual[33]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     //tp.clickOnCheckBoxSaveAllTestcases();
		     
		     bp.waitForElement();
		     actual[34]=tp.clickOnSaveAndOk();
		     
		     bp.waitForElement();
		 	actual[35]=tp.closeFreeFormPage();
	    
	    	
		 	String[] cycleName2=new String[1];
		     cycleName2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",16 ,1 );
		     bp.waitForElement();
		     actual[36]=tp.navigateToCycle(cycleName2);
		     
		     bp.waitForElement();
		     actual[37]=tp.clickOnAddTestcasesToFreeForm();

		     bp.waitForElement();
		     actual[38]=tp.clickOnAdvanceSearch();
	    	
	    	String name2=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",14 ,0 );
	    	String operator2=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,1 );
	    	String value2=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",1 ,2 );
	    	bp.waitForElement();
	    	actual[39]=tp.ZQLSearch1(name2, operator2, value2);
	    	actual[40]=tp.validateSearch();
	    	bp.waitForElement();
	    	actual[41]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     
		     bp.waitForElement();
		     actual[42]=tp.clickOnSaveAndOk();
		     
		     bp.waitForElement();
		 	actual[43]=tp.closeFreeFormPage();
	    	
	    	
		 	String[] cycleName3=new String[1];
		     cycleName3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",16 ,1 );
		     bp.waitForElement();
		     actual[44]=tp.navigateToCycle(cycleName3);
		     
		     bp.waitForElement();
		     actual[45]=tp.clickOnAddTestcasesToFreeForm();
		     
		     bp.waitForElement();
		     actual[46]=tp.clickOnAdvanceSearch();
	    	String name3=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",14 ,0 );
	    	String operator3=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,1 );
	    	String value3=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",1 ,3 );
	    	bp.waitForElement();
	    	actual[47]=tp.ZQLSearch1(name3, operator3, value3);
	    	actual[48]=tp.validateSearch();
	    	bp.waitForElement();
	    	actual[49]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     
		     actual[50]=tp.clickOnSaveAndOk();
		     bp.waitForElement();
	    	tp.closeFreeFormPage();
	    	bp.waitForElement();
	    	
	    	
	    	String[] cycleName4=new String[1];
		     cycleName4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",16 ,1 );
		     bp.waitForElement();
		     actual[51]=tp.navigateToCycle(cycleName4);
		     
		     bp.waitForElement();
		     actual[52]=tp.clickOnAddTestcasesToFreeForm();
		     bp.waitForElement();
		     actual[53]=tp.clickOnAdvanceSearch();
	    	String name4=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",14 ,0 );
	    	String operator4=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,1 );
	    	String value4=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",1 ,4 );
	    	bp.waitForElement();
	    	actual[54]=tp.ZQLSearch1(name4, operator4, value4);
	    	actual[55]=tp.validateSearch();
	    	bp.waitForElement();
	    	actual[56]=tp.selectAllFreeFormTestCases();
		     
		     bp.waitForElement();
		     actual[57]=tp.clickOnSaveAndOk();
	    	tp.closeFreeFormPage();
	    	bp.waitForElement();
	    	
	    	
	    	String[] cycleName5=new String[1];
		     cycleName5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",16 ,1 );
		     bp.waitForElement();
		     actual[58]=tp.navigateToCycle(cycleName5);
		     
		     bp.waitForElement();
		     actual[59]=tp.clickOnAddTestcasesToFreeForm();
		     bp.waitForElement();
		     actual[60]=tp.clickOnAdvanceSearch();
	    	String name5=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",14 ,0 );
	    	String operator5=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",13 ,1 );
	    	String value5=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",1 ,1 );
	    	bp.waitForElement();
	    	actual[61]=tp.ZQLSearch1(name5, operator5, value5);
	    	actual[62]=tp.validateSearch();
	    	bp.waitForElement();
	    	actual[63]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     
		     bp.waitForElement();
		     actual[64]=tp.clickOnSaveAndOk();
	    	actual[65]=tp.closeFreeFormPage();
	    	
	    	String[] cycleName6=new String[1];
		     cycleName6[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",16 ,1 );
		     bp.waitForElement();
		     actual[66]=tp.navigateToCycle(cycleName6);
		     
		     bp.waitForElement();
		     actual[67]=tp.clickOnAddTestcasesToFreeForm();
		     bp.waitForElement();
		     actual[68]=tp.clickOnAdvanceSearch();
	    	String name6=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",14 ,0 );
	    	String operator6=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",13 ,1 );
	    	String value6=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",1 ,2 );
	    	bp.waitForElement();
	    	actual[69]=tp.ZQLSearch1(name6, operator6, value6);
	    	actual[70]=tp.validateSearch();
	    	bp.waitForElement();
	    	actual[71]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     
		     bp.waitForElement();
		     actual[72]=tp.clickOnSaveAndOk();
	    	actual[73]=tp.closeFreeFormPage();
	    	
	    	
	    	String[] cycleName7=new String[1];
		     cycleName7[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",16 ,1 );
		     bp.waitForElement();
		     actual[74]=tp.navigateToCycle(cycleName7);
		     
		     bp.waitForElement();
		     actual[75]=tp.clickOnAddTestcasesToFreeForm();
		     bp.waitForElement();
		     actual[76]=tp.clickOnAdvanceSearch();
	    	String name7=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",14 ,0 );
	    	String operator7=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",13 ,1 );
	    	String value7=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",1 ,3 );
	    	bp.waitForElement();
	    	actual[77]=tp.ZQLSearch1(name7, operator7, value7);
	    	actual[78]=tp.validateSearch();
	    	bp.waitForElement();
	    	actual[79]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     
		     bp.waitForElement();
		     actual[80]=tp.clickOnSaveAndOk();
		     bp.waitForElement();
	    	actual[81]=tp.closeFreeFormPage();
	    	
	    	String[] cycleName8=new String[1];
		     cycleName8[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",16 ,1 );
		     bp.waitForElement();
		     actual[82]=tp.navigateToCycle(cycleName8);
		     
		     bp.waitForElement();
		     actual[83]=tp.clickOnAddTestcasesToFreeForm();
		     bp.waitForElement();
		     actual[84]=tp.clickOnAdvanceSearch();
	    	String name8=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",14 ,0 );
	    	String operator8=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",13 ,1 );
	    	String value8=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",1 ,4 );
	    	bp.waitForElement();
	    	actual[85]=tp.ZQLSearch1(name8, operator8, value8);
	    	actual[86]=tp.validateSearch();
	    	bp.waitForElement();
	    	actual[87]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     
		   
		     actual[88]=tp.clickOnSaveAndOk();
		     bp.waitForElement();
	    	actual[89]=tp.closeFreeFormPage();
	    	bp.waitForElement();
	    	bp.waitForElement();
		 	tp.selectallTestCase();
		 	bp.waitForElement();
		 	String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
		 	tp.assignAllSelected(assignee);
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

	@Then("^User successfully search a testcase with priority and add testcases to freeform phase$")
	public void user_successfully_search_a_testcase_with_priority_and_add_testcases_to_freeform_phase() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("User successfully search a testcase with priority and add testcases to freeform phase");
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
}
