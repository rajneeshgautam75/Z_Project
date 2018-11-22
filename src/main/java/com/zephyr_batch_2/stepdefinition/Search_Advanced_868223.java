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

public class Search_Advanced_868223 extends LaunchBrowser{

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
	String fileName="Search_Advanced_868223";
	
	boolean[] actual=new boolean[82];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User Is in a page TestRepository$")
	public void user_Is_in_a_page_TestRepository() throws Throwable {
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

	@When("^User creates a phase and creates a testcase with available fields$")
	public void user_creates_a_phase_and_creates_a_testcase_with_available_fields() throws Throwable {
		try
	    {
				tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 22, 1);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 22, 2);
				
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
				String[] testCaseNo1=new String[1];
				testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"TestPlanning", 1, 8));
				ep=new ExportPage(driver);
				ep.selectMultipleTestCaseFromGrid(testCaseNo1);
				bp.waitForElement();
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
				String tcName=Excel_Lib.getData(INPUT_PATH_3, "Search_868223", 1, 0);
				String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"Search_868223" , 1, 1);
				bp.waitForElement();
				actual[9]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
				
				String Priority1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",6,1);
				String AltID1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "testcaseDetails", 2, 4));
				String Comment1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 2, 5);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[10]=ctc.enterTestCaseDetails(Priority1, AltID1, Comment1);
				bp.waitForElement();
				
				String[] stepDetail=new String[9];
				stepDetail[0]=Excel_Lib.getData(INPUT_PATH_3, "Search_868223", 1, 6);
				stepDetail[1]=Excel_Lib.getData(INPUT_PATH_3, "Search_868223", 1, 7);
				stepDetail[2]=Excel_Lib.getData(INPUT_PATH_3, "Search_868223", 1, 8);
				stepDetail[3]=Excel_Lib.getData(INPUT_PATH_3, "Search_868223", 2, 6);
				stepDetail[4]=Excel_Lib.getData(INPUT_PATH_3, "Search_868223", 2, 7);
				stepDetail[5]=Excel_Lib.getData(INPUT_PATH_3, "Search_868223", 2, 8);
				stepDetail[6]=Excel_Lib.getData(INPUT_PATH_3, "Search_868223", 3, 6);
				stepDetail[7]=Excel_Lib.getData(INPUT_PATH_3, "Search_868223", 3, 7);
				stepDetail[8]=Excel_Lib.getData(INPUT_PATH_3, "Search_868223", 3, 8);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[11]=ctc.enterTestCaseStepDetail(stepDetail);
				bp.waitForElement();
				
				bp.waitForElement();
				ctc.customFieldOption.click();
				
				String text=Excel_Lib.getData(INPUT_PATH_3, "Search_868223", 1, 3);
				String longText=Excel_Lib.getData(INPUT_PATH_3, "Search_868223", 2, 3);
				String number=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Search_868223", 0, 3));
				String checkBox=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
				String pickupList=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
				String date=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
				bp.waitForElement();
				actual[12]=ctc.enterCustomFields(text, longText, number, checkBox, pickupList, date);
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

	@When("^User clones the testcases upto ten$")
	public void user_clones_the_testcases_upto_ten() throws Throwable {
		try
		   {
			bp.waitForElement();
			actual[13]=tr.clickOnList();
			bp.waitForElement();
			actual[14]=tr.selectallTestCase();
			actual[15]=tr.cloneTestCase();
			bp.waitForElement();
			actual[16]=tr.selectallTestCase();
			actual[17]=tr.cloneTestCase();
			bp.waitForElement();
			actual[18]=tr.selectallTestCase();
			actual[19]=tr.cloneTestCase();
			bp.waitForElement();
			String[] testCaseNo=new String[2];
			testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 3, 8));
			testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 4, 8));
			bp.waitForElement();
			ep=new ExportPage(driver);
			ep.selectMultipleTestCaseFromGrid(testCaseNo);
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

	@When("^User Launch a tesTplanning and creates a cycle$")
	public void user_Launch_a_tesTplanning_and_creates_a_cycle() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[20]=rp.clickOnTestPlanning();
			  bp.waitForElement();
//			  rp.clickOnTestPlanning();
//			  bp.waitForElement();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 22, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[21]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[22]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[23]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[24]=tp.saveTestCycle();
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

	@When("^User clicks on cycle context menu and creates a freeForm phase$")
	public void user_clicks_on_cycle_context_menu_and_creates_a_freeForm_phase() throws Throwable {
		try
	    {
			actual[25]=bp.waitForElement();
			//actual[25]=rp.clickOnTestPlanning();
			
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 22, 0);
			bp.waitForElement();
			actual[26]=tp.navigateToCycle(cycle);
			
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 22, 1);
			actual[27]=tp.createFreeFormPhase(phaseName);
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

	@When("^User clicks on Add Testcase and selects advanced search$")
	public void user_clicks_on_Add_Testcase_and_selects_advanced_search() throws Throwable {
		try
	    {
	    	String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",22 ,1 );
		     bp.waitForElement();
		     actual[28]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[29]=tp.clickOnAddTestcasesToFreeForm();
		     
		     bp.waitForElement();
		     actual[30]=tp.clickOnAdvanceSearch();
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

	@When("^User search a testcase with the available fields and add it to freeform phase$")
	public void user_search_a_testcase_with_the_available_fields_and_add_it_to_freeform_phase() throws Throwable {
		try
 	    {
 	    	String name1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",10 ,0 );
 	    	String operator1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",11 ,1 );
 	    	String value1=Excel_Lib.getData(INPUT_PATH_3, "Search_868223",2 ,0 );//long characters only
 	    	bp.waitForElement();
 	    	actual[31]=tp.ZQLSearch1(name1, operator1, value1);
 	    	actual[32]=tp.validateSearch();
 	    	bp.waitForElement();
 	    	actual[33]=tp.selectAllFreeFormTestCases();
 		     bp.waitForElement();
 		     
 		     bp.waitForElement();
 		     actual[34]=tp.clickOnSaveAndOk();
 		     
 		     bp.waitForElement();
 		 	actual[35]=tp.closeFreeFormPage();
 	    
 	    	//customnumber only
 		 	String[] cycleName2=new String[1];
 		     cycleName2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",22 ,1 );
 		     bp.waitForElement();
 		     actual[36]=tp.navigateToCycle(cycleName2);
 		     
 		     bp.waitForElement();
 		     actual[37]=tp.clickOnAddTestcasesToFreeForm();

 		     bp.waitForElement();
 		     actual[38]=tp.clickOnAdvanceSearch();
 	    	
 	    	String name2=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",18 ,0 );
 	    	String operator2=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",14 ,1 );
 	    	String value2=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Search_868223",0 ,3 ));
 	    	bp.waitForElement();
 	    	actual[39]=tp.ZQLSearch1(name2, operator2, value2);
 	    	actual[40]=tp.validateSearch();
 	    	bp.waitForElement();
 	    	actual[41]=tp.selectAllFreeFormTestCases();
 		     bp.waitForElement();
 		     //tp.clickOnCheckBoxSaveAllTestcases();
 		     
 		     bp.waitForElement();
 		     actual[42]=tp.clickOnSaveAndOk();
 		     
 		     bp.waitForElement();
 		 	actual[43]=tp.closeFreeFormPage();
 	    	
 	    	//customtext only
 		 	String[] cycleName3=new String[1];
 		     cycleName3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",22 ,1 );
 		     bp.waitForElement();
 		     actual[44]=tp.navigateToCycle(cycleName3);
 		     
 		     bp.waitForElement();
 		     actual[45]=tp.clickOnAddTestcasesToFreeForm();
 		     
 		     bp.waitForElement();
 		     actual[46]=tp.clickOnAdvanceSearch();
 	    	String name3=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",16 ,0 );
 	    	String operator3=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",11 ,1 );
 	    	String value3=Excel_Lib.getData(INPUT_PATH_3, "Search_868223",1 ,4 );
 	    	bp.waitForElement();
 	    	actual[47]=tp.ZQLSearch1(name3, operator3, value3);
 	    	actual[48]=tp.validateSearch();
 	    	bp.waitForElement();
 	    	actual[49]=tp.selectAllFreeFormTestCases();
 		     bp.waitForElement();
 		     
 		     actual[50]=tp.clickOnSaveAndOk();
 		     bp.waitForElement();
 	    	actual[51]=tp.closeFreeFormPage();
 	    	bp.waitForElement();
 	    	
 	    	//Uppercase Only
 	    	String[] cycleName4=new String[1];
 		     cycleName4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",22 ,1 );
 		     bp.waitForElement();
 		     actual[52]=tp.navigateToCycle(cycleName4);
 		     
 		     bp.waitForElement();
 		     actual[53]=tp.clickOnAddTestcasesToFreeForm();
 		     bp.waitForElement();
 		     actual[54]=tp.clickOnAdvanceSearch();
 	    	String name4=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",10 ,0 );
 	    	String operator4=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",12 ,1 );
 	    	String value4=Excel_Lib.getData(INPUT_PATH_3, "Search_868223",2 ,1 );
 	    	bp.waitForElement();
 	    	actual[55]=tp.ZQLSearch1(name4, operator4, value4);
 	    	actual[56]=tp.validateSearch();
 	    	bp.waitForElement();
 	    	actual[57]=tp.selectAllFreeFormTestCases();
 		     
 		     bp.waitForElement();
 		     actual[58]=tp.clickOnSaveAndOk();
 		     bp.waitForElement();
 	    	actual[59]=tp.closeFreeFormPage();
 	    	bp.waitForElement();
 	    	
 	    	
 	    	String[] cycleName5=new String[1];
 		     cycleName5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",22 ,1 );
 		     bp.waitForElement();
 		     actual[60]=tp.navigateToCycle(cycleName5);
 		     
 		     bp.waitForElement();
 		     actual[61]=tp.clickOnAddTestcasesToFreeForm();
 		     bp.waitForElement();
 		     actual[62]=tp.clickOnAdvanceSearch();
 	    	String name5=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",11 ,0 );
 	    	String operator5=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",11 ,1 );
 	    	String value5=Excel_Lib.getData(INPUT_PATH_3, "Search_868223",6 ,8 );//stepdetail
 	    	bp.waitForElement();
 	    	actual[63]=tp.ZQLSearch1(name5, operator5, value5);
 	    	actual[64]=tp.validateSearch();
 	    	bp.waitForElement();
 	    	actual[65]=tp.selectAllFreeFormTestCases();
 		     bp.waitForElement();
 		     
 		     bp.waitForElement();
 		     actual[66]=tp.clickOnSaveAndOk();
 		     bp.waitForElement();
 	    	actual[67]=tp.closeFreeFormPage();
 	    	
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

	@When("^User Launches TestRepository and selects the testcases in phase and performs delete$")
	public void user_Launches_TestRepository_and_selects_the_testcases_in_phase_and_performs_delete() throws Throwable {
		try
	    {
	    	bp.waitForElement();
			actual[68]=rp.clickOnTestRep();
			bp.waitForElement();
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			
			
	    	String[] nodes=new String[1];
	    	nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 22, 1);
	    	bp.waitForElement();
	    	actual[69]=tr.navigateToNode(releaseName, nodes);
	    	bp.waitForElement();
	    	actual[70]=tr.selectallTestCase();
	    	bp.waitForElement();
	    	actual[71]=tr.deleteTestCase();
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

	@When("^User Launch TestPlanning and selects the freeform phase created$")
	public void user_Launch_TestPlanning_and_selects_the_freeform_phase_created() throws Throwable {
		try
	    {
			/*bp=new BasePage();
			   pp=new ProjectPage(driver);
			   bp.waitForElement();
		    	pp.clickOnLogout();
		    	bp.waitForElement();
		    	tp=new TestPlanningPage(driver);
		    	tr=new TestRepositoryPage(driver);
		    	exep=new ExecutionPage(driver);
		    	
		    	lp=new LoginPage(driver);
				
				String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_3");
				   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_3");
				   
				   lp.enterUname(Uname);
				   lp.enterPass(Pass);
				   lp.clickOnLogin();
				   
				   pp=new ProjectPage(driver);
				   rp=new ReleasePage(driver);
				   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
				   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			    	 bp.waitForElement();
			    	 pp.selectProject(projectName);
			    	 bp.waitForElement();
			    	 pp.selectRelease(releaseName);*/
			
			tp=new TestPlanningPage(driver);
	    	tr=new TestRepositoryPage(driver);
	    	exep=new ExecutionPage(driver);
	    	
	    	lp=new LoginPage(driver);
			bp.waitForElement();
			actual[72]=rp.clickOnTestPlanning();
			bp.waitForElement();
//			rp.clickOnTestPlanning();
//			bp.waitForElement();
			
			
			String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 22, 0);
			bp.waitForElement();
			actual[73]=tp.doubleClickOnCycle(cycleName);
			
	    	String[] cycle=new String[2];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 22, 0);
			cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 22, 1);
			actual[74]=tp.navigateToCycle(cycle);
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

	@When("^User Launches a assign window and attempt to search for modified values$")
	public void user_Launches_a_assign_window_and_attempt_to_search_for_modified_values() throws Throwable {
	    try
	    {
	    	actual[75]=tp.assignPhase();
	    	
	    	actual[76]=bp.waitForElement();
	    	//actual[76]=tp.cancelBulkAssign();
	    	
	    	String[] cycleName1=new String[1];
		     cycleName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",22 ,1 );
		     bp.waitForElement();
		     actual[77]=tp.navigateToCycle(cycleName1);
		     
		     bp.waitForElement();
		     actual[78]=tp.clickOnAddTestcasesToFreeForm();

		     bp.waitForElement();
		     actual[79]=tp.clickOnAdvanceSearch();

		    String name1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",10 ,0 );
	    	String operator1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",11 ,1 );
	    	String value1=Excel_Lib.getData(INPUT_PATH_3, "Search_868223",2 ,0 );//long characters only
	    	bp.waitForElement();
	    	actual[80]=tp.ZQLSearch1(name1, operator1, value1);
	    	bp.waitForElement();
	    	//bp.waitForElement();
	    	actual[81]=tp.validateSearch();
	        bp.waitForElement();
	    	tp.closeFreeFormPage();
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

	@Then("^User should not be able to search for values of fields when the testcase is deleted$")
	public void user_should_not_be_able_to_search_for_values_of_fields_when_the_testcase_is_deleted() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		     tp.goBackToCycle();
		log.info("User successfully search a testcases with edited values");
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
