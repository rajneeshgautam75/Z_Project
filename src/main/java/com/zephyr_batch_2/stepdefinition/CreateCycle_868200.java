package com.zephyr_batch_2.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class CreateCycle_868200 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tl;
	ExecutionPage epp;
	boolean[] actual=new boolean[36];
	 SoftAssert soft=new SoftAssert();
	 String fileName="CreateCycle_868200";
	 
	@Given("^launch testrepository page to create phase$")
	public void launch_testrepository_page_to_create_phase() throws Throwable 
	{
		try
		   {
			lb=new LaunchBrowser();
			   pp=new ProjectPage(driver);
			   //String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,0);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			   actual[0]=pp.selectProject(projectName);
			   bp=new BasePage();
			   bp.waitForElement();
			   actual[1]=pp.selectRelease(releaseName);
			   bp.waitForElement();
			   rp= new ReleasePage(driver);
			   actual[2]=rp.clickOnTestRep();
			   bp.waitForElement();
			   tr=new TestRepositoryPage(driver);
			   actual[3]=tr.doubleClickOnRelease(releaseName);
			   bp.waitForElement(); 
		   }
		   catch (Exception e) 
			{
			   lb.getScreenShot(fileName);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@Given("^create a phase and add testcases$")
	public void create_a_phase_and_add_testcases() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 54, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 54, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			 bp.waitForElement(); 
			String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			actual[5]=tr.doubleClickOnRelease(releaseName);
			//navigate to phase//
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 54, 0);
			actual[6]=tr.navigateToNode(releaseName, phase);
			
		   actual[7]=tr.addTestCase();
		   actual[8]=tr.selectallTestCase();
		   bp.waitForElement();
		   actual[9]=tr.cloneTestCase();
		   bp.waitForElement();
		   actual[10]=tr.selectallTestCase();
		   bp.waitForElement();
		   actual[11]=tr.cloneTestCase();
		   bp.waitForElement(); 
		   actual[12]=tr.selectallTestCase();
		   bp.waitForElement();
		   actual[13]=tr.cloneTestCase();
		   bp.waitForElement(); 
		}
		   catch (Exception e) 
			{
			   lb.getScreenShot(fileName);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^launch test planning create cycle and assign to Anyone$")
	public void launch_test_planning_create_cycle_and_assign_to_Anyone() throws Throwable 
	{
		try
		{
			actual[14]=rp.clickOnTestPlanning();
		    bp.waitForElement();
		    
		    tl=new TestPlanningPage(driver);
		    actual[15]=tl.clickOnAddTestCycleSymbol();
		    bp.waitForElement();
		    //creating cicle 1
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 44, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
			actual[16]=tl.CreateCycle(cyclename, Build, Environment,hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
			actual[17]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			
			actual[18]=tl.saveTestCycle();
			bp.waitForElement();
			
		   String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 44, 0);
			actual[19]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 54, 0);
			actual[20]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 2, 0);
		   actual[21]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
		   bp.waitForElement();
		   tl.goBackToCycle();
		 }
		   catch (Exception e) 
			{
			   lb.getScreenShot(fileName);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^launch test execution navigate to phase and execute the testcases$")
	public void launch_test_execution_navigate_to_phase_and_execute_the_testcases() throws Throwable 
	{
		try
		{
		    rp.clickOnTestExecution();
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    String cyclename1[]=new String[3];
		    cyclename1[0]=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 44, 0);
			cyclename1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 54, 0);
			actual[22]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
		    epp=new ExecutionPage(driver);
		    
		   
		    int tcNo=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_4, "status", 1, 0);
		    epp.executeStatus(tcNo, statusType);
		    bp.waitForElement();
		    
		    String statusType2=Excel_Lib.getData(INPUT_PATH_4, "status", 3, 0);
		    int tcNo2=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		    epp.executeStatus(tcNo2, statusType2);  
		    bp.waitForElement();
		    
		    
		    int tcNo3=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		    String statusType3=Excel_Lib.getData(INPUT_PATH_4, "status", 4, 0);
		    epp.executeStatus(tcNo3, statusType3);
		    bp.waitForElement();
		    String statusType4=Excel_Lib.getData(INPUT_PATH_4, "status", 5, 0);
		    int tcNo4=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		    epp.executeStatus(tcNo4, statusType4);
		    bp.waitForElement();
		 }
		   catch (Exception e) 
			{
			   lb.getScreenShot(fileName);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^link the Defect across the testcases$")
	public void link_the_Defect_across_the_testcases() throws Throwable 
	{
		try
		{
		    //link defect
			int tcNo=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		    epp.clickOnDefectButton(tcNo);
		    bp.waitForElement();
		    String defectId=Excel_Lib.getData(INPUT_PATH_4, "defect", 1, 0);
		    epp.linkDefect(defectId);
		    
		    //link defect
		    int tcNo2=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		    epp.clickOnDefectButton(tcNo2);
		    bp.waitForElement();
		    epp.linkDefect(defectId);
		    
		    //link defect
		    int tcNo3=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		    epp.clickOnDefectButton(tcNo3);
		    bp.waitForElement();
		    epp.linkDefect(defectId);
		    
		    //link defect
		    int tcNo4=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		    epp.clickOnDefectButton(tcNo4);
		    bp.waitForElement();
		    epp.linkDefect(defectId);
		    bp.waitForElement();
		    String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
		    tl.doubleClickOnCycle(releaseName);
		    bp.waitForElement();
		 }
		   catch (Exception e) 
			{
			   lb.getScreenShot(fileName);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^launch testplanning navihate to cycle and add freeform phase$")
	public void launch_testplanning_navihate_to_cycle_and_add_freeform_phase() throws Throwable 
	{
		try
		{
	
		actual[23]=rp.clickOnTestPlanning();
		 
	    bp.waitForElement();
	  
	    bp.waitForElement();
	    
	    String cyclename1[]=new String[1];
		cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 44, 0);
		actual[24]=tl.navigateToCycle(cyclename1);
		bp.waitForElement();
		//freeform1
		String freeFormName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 44, 4);
		tl.createFreeFormPhase(freeFormName);
		bp.waitForElement();
		}
		  catch (Exception e) 
		{
			  lb.getScreenShot(fileName);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^navigate to freeform phase launch add tesrcases and launch other cycles$")
	public void navigate_to_freeform_phase_launch_add_tesrcases_and_launch_other_cycles() throws Throwable 
	{
		try
		{
		String freeFormName1[]=new String[1];
		freeFormName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 44, 4);
		actual[25]=tl.navigateToCycle(freeFormName1);
		bp.waitForElement();
		
		tl.clickOnAddTestcasesToFreeForm();
		bp.waitForElement();
		
		 tl.launchOtherCycles();
		   bp.waitForElement();
		}
		  catch (Exception e) 
		{
			  lb.getScreenShot(fileName);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^select a phase and cycle with different status and add to freeform phase$")
	public void select_a_phase_and_cycle_with_different_status_and_add_to_freeform_phase() throws Throwable 
	{
		try
		{  
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 44, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 2);
		    tl.selectCycleInSearch(cyclename, Build, Environment);
		    bp.waitForElement();
		    int index=Excel_Lib.getNumberData(INPUT_PATH_4, "index", 1, 0);
		    tl.selectPhasebyIndexInSearch(index);
	//	    String PhaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 41, 0);
	//	    tl.selectPhaseInSearch(PhaseName);
		   // System.out.println(index);
		    String statusType=Excel_Lib.getData(INPUT_PATH_4, "status", 1, 0);
		    tl.filterByStatus(statusType);
		    bp.waitForElement();
		    tl.clickOnGo();
		    bp.waitForElement();
		 	tl.validateRetrieveTestcases();
		    bp.waitForElement();
		    tl.selectAllFreeFormTestCasesPhase();
		    bp.waitForElement();
		    tl.clickOnSaveAndOk();
		    bp.waitForElement();
		    
		    String statusType2=Excel_Lib.getData(INPUT_PATH_4, "status", 3, 0);
		    tl.filterByStatus(statusType2);
		    bp.waitForElement();
		    tl.clickOnGo();
		    bp.waitForElement();
		 	tl.validateRetrieveTestcases();
		    bp.waitForElement();
		    tl.selectAllFreeFormTestCasesPhase();
		    bp.waitForElement();
		    tl.clickOnSaveAndOk();
		    bp.waitForElement();
		    
		    String statusType3=Excel_Lib.getData(INPUT_PATH_4, "status", 4, 0);
		    tl.filterByStatus(statusType3);
		    bp.waitForElement();
		    tl.clickOnGo();
		    bp.waitForElement();
		 	tl.validateRetrieveTestcases();
		    bp.waitForElement();
//		    WebElement selectIcon=driver.findElement(By.xpath("(//*[@id='phase_testcase_select_all'])[1]"));
//		    selectIcon.click();
		    tl.selectAllFreeFormTestCasesPhase();
		   // tl.selectAllFreeFormTestCases();
		    bp.waitForElement();
		    tl.clickOnSaveAndOk();
		    bp.waitForElement();
		    
		    String statusType4=Excel_Lib.getData(INPUT_PATH_4, "status", 5, 0);
		    tl.filterByStatus(statusType4);
		    bp.waitForElement();
		    tl.clickOnGo();
		    bp.waitForElement();
		 	tl.validateRetrieveTestcases();
		    bp.waitForElement();
//		    tl.selectAllFreeFormTestCases();
		    tl.selectAllFreeFormTestCasesPhase();
		    bp.waitForElement();
		    tl.clickOnSaveAndOk();
		    bp.waitForElement();
		    
		    tl.closeFreeFormPage();
		    bp.waitForElement();
		    tl.validateAddtestcaesToFreeForm();
		    bp.waitForElement();
		    tl.goBackToCycle();
		}
		   catch (Exception e) 
			{
			   lb.getScreenShot(fileName);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@When("^launch testplanning navigate to cycle and add freeform phase$")
	public void launch_testplanning_navigate_to_cycle_and_add_freeform_phase() throws Throwable 
	{
		try
		{
		actual[26]=rp.clickOnTestPlanning();
	    bp.waitForElement();
	   // tl.navigateBacktoTestPlanning();
	    
	    String cyclename1[]=new String[1];
		cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 44, 0);
		actual[27]=tl.navigateToCycle(cyclename1);
		bp.waitForElement();
		//freeform2
		String freeFormName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 44, 5);
		tl.createFreeFormPhase(freeFormName);
		bp.waitForElement(); 
		}
		  catch (Exception e) 
		{
			  lb.getScreenShot(fileName);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^navigate to freeform phase launch add testcases launch browse$")
	public void navigate_to_freeform_phase_launch_add_testcases_launch_browse() throws Throwable 
	{
		try
		{
			tl=new TestPlanningPage(driver);
			String freeFormName1[]=new String[1];
			freeFormName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 44, 5);
			actual[28]=tl.navigateToCycle(freeFormName1);
			bp.waitForElement();
			
			tl.clickOnAddTestcasesToFreeForm();
			bp.waitForElement();
			
			tl.clickOnBrowse();
			bp.waitForElement();
			String phaseName[]=new String[2];
			 phaseName[0]=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			phaseName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 54, 0);			
			tl.navigateToCycle(phaseName);			
			bp.waitForElement();
			tl.selectAllFreeFormTestCases();
//			String[] tcNo=new String[1];
//			tcNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0));
//			//tl.selectSingleMultipleTestcase(tcNo);
//			tl.selectMultipleTestCaseFromFreeForm(tcNo);
			bp.waitForElement();
			
			tl.clickOnSaveAndOk();
			bp.waitForElement();
			
			tl.closeFreeFormPage();
			bp.waitForElement();
			
			
		}
		   catch (Exception e) 
			{
			   lb.getScreenShot(fileName);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@When("^select phase add test cases to freeform phase and assign to Anyone$")
	public void select_phase_add_test_cases_to_freeform_phase_and_assign_to_Anyone() throws Throwable 
	{
		try
		{
			tl.selectallTestCase();
			bp.waitForElement();
			
			String Anyone=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
			tl.assignAllSelected(Anyone);
			bp.waitForElement();
			tl.goBackToCycle();
		}
		   catch (Exception e) 
			{
			   lb.getScreenShot(fileName);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@When("^launch test execution navigate to second free form phase execute testcases$")
	public void launch_test_execution_navigate_to_second_free_form_phase_execute_testcases() throws Throwable 
	{
		try
		{
		    rp.clickOnTestExecution();
		    bp.waitForElement();
		    //second freeform phase
		    String cyclename1[]=new String[3];
		    cyclename1[0]=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 44, 0);
			cyclename1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Create cycle", 44, 5);
			actual[29]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
		    epp=new ExecutionPage(driver);
		    
		   
		    int tcNo=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_4, "status", 1, 0);
		    epp.executeStatus(tcNo, statusType);
		    bp.waitForElement();
		    
		    String statusType2=Excel_Lib.getData(INPUT_PATH_4, "status", 3, 0);
		    int tcNo2=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		    epp.executeStatus(tcNo2, statusType2);  
		    bp.waitForElement();
		    
		    
		    int tcNo3=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		    String statusType3=Excel_Lib.getData(INPUT_PATH_4, "status", 4, 0);
		    epp.executeStatus(tcNo3, statusType3);
		    bp.waitForElement();
		    String statusType4=Excel_Lib.getData(INPUT_PATH_4, "status", 5, 0);
		    int tcNo4=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		    epp.executeStatus(tcNo4, statusType4);
		    bp.waitForElement();
		 }
		   catch (Exception e) 
			{
			   lb.getScreenShot(fileName);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^launch testplanning navigate to cycle and click on edit check the hide option$")
	public void launch_testplanning_navigate_to_cycle_and_click_on_edit_check_the_hide_option() throws Throwable 
	{
		try
		{
			
		actual[30]=rp.clickOnTestPlanning();
	    bp.waitForElement();
	    //tl.navigateBacktoTestPlanning();
		
		   String cyclename1[]=new String[1];

			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 44, 0);
			actual[31]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String cycle=Excel_Lib.getData(INPUT_PATH_4, "status", 500, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "status", 500, 0);
			String environ=Excel_Lib.getData(INPUT_PATH_4, "status", 500, 0);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "status", 1, 1);
			System.out.println(hide);
			tl.editCycle(cycle, Build, environ, hide);
			bp.waitForElement();
			tl.saveTestCycle();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
		 }
		   catch (Exception e) 
			{
			   lb.getScreenShot(fileName);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^launch testplanning navigate to cycle and click on edit uncheck the hide option$")
	public void launch_testplanning_navigate_to_cycle_and_click_on_edit_uncheck_the_hide_option() throws Throwable 
	{
		try
		{
			rp.clickOnTestPlanning();
		    bp.waitForElement();
		    
			
			   String cyclename1[]=new String[1];
				cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 44, 0);
				actual[32]=tl.navigateToCycle(cyclename1);
				bp.waitForElement();
				String cycle=Excel_Lib.getData(INPUT_PATH_4, "status", 500, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_4, "status", 500, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_4, "status", 500, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_4, "status", 1, 1);
				tl.editCycle(cycle, Build, environ, hide);
				bp.waitForElement();
				tl.saveTestCycle();
				bp.waitForElement();
				bp.waitForElement();
				bp.waitForElement();
		 }
		   catch (Exception e) 
			{
			   lb.getScreenShot(fileName);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^launch testplanning navigate to cycle clone cycle$")
	public void launch_testplanning_navigate_to_cycle_clone_cycle() throws Throwable 
	{
		try
		{
			actual[33]=rp.clickOnTestPlanning();
		    bp.waitForElement();
		    
		    String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 44, 0);
			actual[34]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			tl.options.click();
			bp.waitForElement();
			tl.cloneCycle.click();
			bp.waitForElement();
			tl.saveTestCycle();
			bp.waitForElement();
		 }
		   catch (Exception e) 
			{
			   lb.getScreenShot(fileName);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@Then("^cycle should be cloned along with free form phases$")
	public void cycle_should_be_cloned_along_with_free_form_phases() throws Throwable 
	{
		try
		{
			String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 44, 0);
			actual[35]=tl.navigateToCycle(cyclename1);
			String no=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0));
		    tl.navigateToClonedCycle(cyclename1, no);
		    
		    
		    for (int k = 0; k <= actual.length - 1; k++) {
				System.out.println(actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();
		 }
		   catch (Exception e) 
			{
			   lb.getScreenShot(fileName);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}
}
