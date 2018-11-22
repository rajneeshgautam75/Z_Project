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

public class Search_Sort_868190 extends LaunchBrowser {

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
	String fileName="Search_868190";
	
	boolean[] actual=new boolean[27];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User Launches TestRepository$")
	public void user_Launches_TestRepository() throws Throwable {
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

	@When("^User creates Phase and Add testcase to the phase with all the available fields$")
	public void user_creates_Phase_and_Add_testcase_to_the_phase_with_all_the_available_fields() throws Throwable {
		try
	    {
					tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 13, 1);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 13, 4);
				
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
				/*bp.waitForElement();
				String[] tags1=new String[1];
				tags1[0]=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 2, 2);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[7]=ctc.enterMultipleTags(tags1);*/
				bp.waitForElement();
				ctc=new CreateTestCasePage(driver);
				String tcName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 2, 7);
				String tcDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
				bp.waitForElement();
				actual[8]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
				
				String Priority1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 1, 1);
				String AltID1=UNIQUE+Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "testcaseDetails", 2, 4));
				String Comment1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 2, 5);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[9]=ctc.enterTestCaseDetails(Priority1, AltID1, Comment1);
				bp.waitForElement();
				
				String[] stepDetail=new String[9];
				stepDetail[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 0);
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
				bp.waitForElement();
				actual[10]=ctc.enterTestCaseStepDetail(stepDetail);
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

	@When("^User Launches TestPlanning and Creates a cycle$")
	public void user_Launches_TestPlanning_and_Creates_a_cycle() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[11]=rp.clickOnTestPlanning();
			  bp.waitForElement();
//			  rp.clickOnTestPlanning();
//			  bp.waitForElement();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 7, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 7, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[12]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[13]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[14]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[15]=tp.saveTestCycle();
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

	@When("^User creates a new free form phase and save$")
	public void user_creates_a_new_free_form_phase_and_save() throws Throwable {
		try
	    {
			actual[16]=bp.waitForElement();
			//actual[16]=rp.clickOnTestPlanning();
			bp.waitForElement();
			
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 7, 0);
			bp.waitForElement();
			actual[17]=tp.navigateToCycle(cycle);
			bp.waitForElement();
			
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 7, 1);
			actual[18]=tp.createFreeFormPhase(phaseName);
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

	@When("^User clicks on Add testcase window,launch search window and search testcase with available fields and adds$")
	public void user_clicks_on_Add_testcase_window_launch_search_window_and_search_testcase_with_available_fields_and_adds() throws Throwable {
		try
		{
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",7 ,1 );
		     bp.waitForElement();
		     actual[19]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[20]=tp.clickOnAddTestcasesToFreeForm();
		     
		   /*String name1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",1 ,6 );
		     bp.waitForElement();
		     actual[21]=tp.quiksearch(name1);
		     
		     bp.waitForElement();
		     actual[22]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     //actual[40]=tp.clickOnCheckBoxSaveAllTestcases();
		     
		     bp.waitForElement();
		     actual[23]=tp.clickOnSaveAndOk();
		     
		     bp.waitForElement();
				actual[24]=tp.quickSearch();
		    	String name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",1 ,7 );
			     bp.waitForElement();
			     actual[25]=tp.quiksearch(name2);
			     
			     bp.waitForElement();
			     actual[26]=tp.selectAllFreeFormTestCases();
			     bp.waitForElement();
			     //actual[45]=tp.clickOnCheckBoxSaveAllTestcases
			     actual[27]=tp.clickOnSaveAndOk();
			     
			     bp.waitForElement();
					actual[28]=tp.quickSearch();
			    	String name3=UNIQUE+Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "FreeForm",1 ,8 ));
				     bp.waitForElement();
				     actual[29]=tp.quiksearch(name3);
				     
				     bp.waitForElement();
				     actual[30]=tp.selectAllFreeFormTestCases();
				     bp.waitForElement();
				     //actual[45]=tp.clickOnCheckBoxSaveAllTestcases
				     actual[31]=tp.clickOnSaveAndOk();*/
				     
				     bp.waitForElement();
						actual[21]=tp.quickSearch();
				    String name4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "StepDetails",1 ,0 );
					 bp.waitForElement();
					actual[22]=tp.quiksearch(name4);
					     
					bp.waitForElement();
					actual[23]=tp.selectAllFreeFormTestCases();
					bp.waitForElement();
					     //actual[45]=tp.clickOnCheckBoxSaveAllTestcases
					actual[24]=tp.clickOnSaveAndOk();
					     
					/*bp.waitForElement();
					actual[36]=tp.quickSearch();
					String name5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",1 ,10 );
					bp.waitForElement();
					actual[37]=tp.quiksearch(name5);
						     
				bp.waitForElement();
				actual[38]=tp.selectAllFreeFormTestCases();
				bp.waitForElement();
						     //actual[45]=tp.clickOnCheckBoxSaveAllTestcases
				actual[39]=tp.clickOnSaveAndOk();
						     
				bp.waitForElement();
				actual[40]=tp.quickSearch();
				String name6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",1 ,11 );
				bp.waitForElement();
				actual[41]=tp.quiksearch(name6);
							     
				 bp.waitForElement();
				 actual[42]=tp.selectAllFreeFormTestCases();
			     bp.waitForElement();
							     //actual[45]=tp.clickOnCheckBoxSaveAllTestcases
			     actual[43]=tp.clickOnSaveAndOk();*/
							     
					bp.waitForElement();
					actual[25]=tp.closeFreeFormPage();
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

	@When("^User sort the testcase with the available fields in table$")
	public void user_sort_the_testcase_with_the_available_fields_in_table() throws Throwable {
	    try
	    {
	    	bp.waitForElement();
	    	String[] sortName=new String[6];
			bp.waitForElement();
			//sortName[0]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 1, 2);
			sortName[0]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 2, 2);
			sortName[1]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 3, 2);
			//sortName[2]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 4, 2);
			sortName[2]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 5, 2);
			sortName[3]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 6, 2);
			sortName[4]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 7, 2);
			sortName[5]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 8, 2);
			
			bp.waitForElement();
			bp.waitForElement();
			actual[26]=tp.sort(sortName);
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

	@Then("^User successfully sort the testcases by available field columns$")
	public void user_successfully_sort_the_testcases_by_available_field_columns() throws Throwable {
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
