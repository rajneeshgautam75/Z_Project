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

public class Search_868189 extends LaunchBrowser{

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
	String fileName="Search_868189";
	
	boolean[] actual=new boolean[43];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in a page of TestRepositoRy$")
	public void user_is_in_a_page_of_TestRepositoRy() throws Throwable {
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

	@When("^User creates a phasE and creates a testcase with the available fields$")
	public void user_creates_a_phasE_and_creates_a_testcase_with_the_available_fields() throws Throwable {
		try
	    {
				tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 15, 1);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 15, 2);
				
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
				tags1[0]=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 2, 2);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[8]=ctc.enterMultipletags(tags1);
				bp.waitForElement();
				ctc=new CreateTestCasePage(driver);
				String tcName=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 2, 7);
				String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
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
				stepDetail[0]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 0);
				stepDetail[1]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 1);
				stepDetail[2]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 2);
				stepDetail[3]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 0);
				stepDetail[4]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 1);
				stepDetail[5]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 2);
				stepDetail[6]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 0);
				stepDetail[7]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 1);
				stepDetail[8]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 2);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[11]=ctc.enterTestCaseStepDetail(stepDetail);
				bp.waitForElement();
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

	@When("^User Launches TestPlaNning and creates a cycle$")
	public void user_Launches_TestPlaNning_and_creates_a_cycle() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[12]=rp.clickOnTestPlanning();
			  bp.waitForElement();
			  //rp.clickOnTestPlanning();
			  bp.waitForElement();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 15, 0);
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
				actual[16]=tp.saveTestCycle();
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

	@When("^User clicks on cycle context menu and creates a FrEeform phase and save$")
	public void user_clicks_on_cycle_context_menu_and_creates_a_FrEeform_phase_and_save() throws Throwable {
		try
	    {
			actual[17]=bp.waitForElement();
			//actual[17]=rp.clickOnTestPlanning();
			
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 15, 0);
			bp.waitForElement();
			actual[18]=tp.navigateToCycle(cycle);
			
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 15, 1);
			actual[19]=tp.createFreeFormPhase(phaseName);
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

	@When("^User clicks on Add testCase window and selects quick search radio button$")
	public void user_clicks_on_Add_testCase_window_and_selects_quick_search_radio_button() throws Throwable {
		try
	    {
	    	String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",15 ,1 );
		     bp.waitForElement();
		     actual[20]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[21]=tp.clickOnAddTestcasesToFreeForm();
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

	@When("^User search a testcase with the available fields$")
	public void user_search_a_testcase_with_the_available_fields() throws Throwable {
		try
		{		     
		     String name1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",1 ,6 );
		     bp.waitForElement();
		     actual[22]=tp.quiksearch(name1);
		     tp.validateSearch();
		     
		     bp.waitForElement();
		     actual[23]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     
		     bp.waitForElement();
		     actual[24]=tp.clickOnSaveAndOk();
		     
/*		     bp.waitForElement();
				actual[25]=tp.quickSearch();
		    	String name2=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",1 ,7 );
			     bp.waitForElement();
			     actual[26]=tp.quiksearch(name2);
			     tp.validateSearch();
			     
			     bp.waitForElement();
			     actual[27]=tp.selectAllFreeFormTestCases();
			     bp.waitForElement();
			     actual[28]=tp.clickOnSaveAndOk();
			     
			     bp.waitForElement();
				 actual[29]=tp.quickSearch();
			     String name3=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "FreeForm",1 ,8 ));
				 bp.waitForElement();
				 actual[30]=tp.quiksearch(name3);
				 tp.validateSearch();
				     
				 bp.waitForElement();
				 actual[31]=tp.selectAllFreeFormTestCases();
				 bp.waitForElement();

				 actual[32]=tp.clickOnSaveAndOk();
				     
				 bp.waitForElement();
			     actual[33]=tp.quickSearch();
				 String name4=Excel_Lib.getData(INPUT_PATH_3, "StepDetails",1 ,0 );
			     bp.waitForElement();
			     actual[34]=tp.quiksearch(name4);
			     tp.validateSearch();
					     
				 bp.waitForElement();
				 actual[35]=tp.selectAllFreeFormTestCases();
				 bp.waitForElement();
	
				 actual[36]=tp.clickOnSaveAndOk();
					     
				 bp.waitForElement();
				 actual[37]=tp.quickSearch();
				 String name5=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",1 ,10 );
				 bp.waitForElement();
				actual[38]=tp.quiksearch(name5);
				tp.validateSearch();
				
				bp.waitForElement();
				actual[39]=tp.selectAllFreeFormTestCases();
				bp.waitForElement();
			
				actual[40]=tp.clickOnSaveAndOk();
						     
				bp.waitForElement();
				actual[41]=tp.quickSearch();
				String name6=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",1 ,11 );
				bp.waitForElement();
				actual[42]=tp.quiksearch(name6);
							     
				 bp.waitForElement();
				 actual[43]=tp.selectAllFreeFormTestCases();
			     bp.waitForElement();
	
			     actual[44]=tp.clickOnSaveAndOk();
							     
				 bp.waitForElement();
				 actual[45]=tp.closeFreeFormPage();
				 bp.waitForElement();
				 tp.validateAddtestcaesToFreeForm();
				 
				 bp.waitForElement();
				 	tp.selectallTestCase();
				 	bp.waitForElement();
				 	String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
				 	actual[46]=tp.assignAllSelected(assignee);
				 	bp.waitForElement();
		    	    bp.waitForElement();*/
			 actual[25]=tp.closeFreeFormPage();
			 bp.waitForElement();
			 actual[26]=tp.validateAddtestcaesToFreeForm();
			 bp.waitForElement();
		 	tp.selectallTestCase();
		 	bp.waitForElement();
		 	String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
		 	tp.assignAllSelected(assignee);
		 	bp.waitForElement();
		    tp.goBackToCycle();
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

	@When("^User Launches a testRepository and edit the available values for a testcase$")
	public void user_Launches_a_testRepository_and_edit_the_available_values_for_a_testcase() throws Throwable {
		 try
		    {
		    	bp.waitForElement();
				rp.clickOnTestRep();
				bp.waitForElement();
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				tr.doubleClickOnRelease(releaseName);
				
				
		    	String[] nodes=new String[1];
		    	nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 15, 1);
		    	bp.waitForElement();
		    	actual[27]=tr.navigateToNode(releaseName, nodes);
		    	
		    	bp.waitForElement();
				actual[28]=tr.clickDetailButton();
				bp.waitForElement();
				String[] tags1=new String[1];
				tags1[0]=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 3, 2);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[29]=ctc.enterMultipletags(tags1);
				bp.waitForElement();
				ctc=new CreateTestCasePage(driver);
				String tcName=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 3, 6);
				String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 3, 3);
				bp.waitForElement();
				actual[30]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
				bp.waitForElement();
				
				int stepNum=Excel_Lib.getNumberData(INPUT_PATH_3,"Requirements" , 1, 0);
				String[] edit=new String[1];
				edit[0]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 0);
				//edit[1]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 0);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[31]=ctc.editTeststep(stepNum, edit);
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

	@When("^User Launch a testPlanning and selects the freeform phase created$")
	public void user_Launch_a_testPlanning_and_selects_the_freeform_phase_created() throws Throwable {
		try
	    {
			bp.waitForElement();
			actual[32]=rp.clickOnTestPlanning();
			bp.waitForElement();
			//rp.clickOnTestPlanning();
			bp.waitForElement();
			
			String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 15, 0);
			bp.waitForElement();
			actual[33]=tp.doubleClickOnCycle(cycleName);
			
	    	String[] cycle=new String[2];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 15, 0);
			cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 15, 1);
			bp.waitForElement();
			actual[34]=tp.navigateToCycle(cycle);
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

	@When("^User launches assign window and search for the modified values,selects the testcases and save$")
	public void user_launches_assign_window_and_search_for_the_modified_values_selects_the_testcases_and_save() throws Throwable {
		 try
		    {
		    	bp.waitForElement();
		    	actual[35]=tp.assignPhase();
		    	bp.waitForElement();
		    	
		    	//bp.waitForElement();
		    	//actual[56]=tp.cancelBulkAssign();
		    	
		    	String[] cycleName=new String[1];
			     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",15 ,1 );
			     bp.waitForElement();
			     actual[36]=tp.navigateToCycle(cycleName);
			     
			     bp.waitForElement();
			     actual[37]=tp.clickOnAddTestcasesToFreeForm();
			     
			     String name1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 3, 6);
			     bp.waitForElement();
			     actual[38]=tp.quiksearch(name1);
			     tp.validateSearch();
			     
		     bp.waitForElement();
			     actual[39]=tp.selectAllFreeFormTestCases();
			     bp.waitForElement();
			     
			     bp.waitForElement();
			     actual[40]=tp.clickOnSaveAndOk();
					     
/*					 bp.waitForElement();
				     actual[62]=tp.quickSearch();
					 String name3=Excel_Lib.getData(INPUT_PATH_3, "StepDetails",1 ,0 );
				     bp.waitForElement();
				     actual[63]=tp.quiksearch(name3);
				     tp.validateSearch();
						     
					 bp.waitForElement();
					 actual[64]=tp.selectAllFreeFormTestCases();
					 bp.waitForElement();
		
					 actual[65]=tp.clickOnSaveAndOk();
						     
					 bp.waitForElement();
					 actual[66]=tp.quickSearch();
					 String name4=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",2 ,11 );
					 bp.waitForElement();
					actual[67]=tp.quiksearch(name4);
					tp.validateSearch();
					
					bp.waitForElement();
					actual[68]=tp.selectAllFreeFormTestCases();
					bp.waitForElement();
				
					actual[69]=tp.clickOnSaveAndOk();*/
							     
					 bp.waitForElement();
					 actual[41]=tp.closeFreeFormPage();
					 bp.waitForElement();
					 actual[42]=tp.validateAddtestcaesToFreeForm();
					 bp.waitForElement();
				 	tp.selectallTestCase();
				 	bp.waitForElement();
				 	String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
				 	tp.assignAllSelected(assignee);
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

	@Then("^User successfully search a testcase with newly modified values$")
	public void user_successfully_search_a_testcase_with_newly_modified_values() throws Throwable {
		try
		{
			tp.goBackToCycle();
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("User successfully search a testcase with newly modified values");
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
