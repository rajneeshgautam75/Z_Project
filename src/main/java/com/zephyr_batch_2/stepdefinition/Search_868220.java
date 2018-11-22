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

public class Search_868220 extends LaunchBrowser{

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
	String fileName="Search_868220";
	
	boolean[] actual=new boolean[112];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in a paGe TestRepository$")
	public void user_is_in_a_paGe_TestRepository() throws Throwable {
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

	@When("^User creates a phaSe and creates testcases with the available fields$")
	public void user_creates_a_phaSe_and_creates_testcases_with_the_available_fields() throws Throwable {
		try
	    {
				tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 19, 1);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 19, 2);
				
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
				
				String Priority1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 6, 1);
				String AltID1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "testcaseDetails", 2, 4));
				String Comment1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 2, 5);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[9]=ctc.enterTestCaseDetails(Priority1, AltID1, Comment1);
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
				bp.waitForElement();
				actual[10]=ctc.enterTestCaseStepDetail(stepDetail);
				bp.waitForElement();
				
				ctc=new CreateTestCasePage(driver);
				String tcName=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 2, 7);
				String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
				bp.waitForElement();
				actual[11]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
				
				bp.waitForElement();
				ctc.customFieldOption.click();
				
				String text=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 0, 23);
				String longText=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 23);
				String number=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "FreeForm", 2, 23));
				String checkBox=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
				String pickupList=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
				String date=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
				bp.waitForElement();
				ctc.enterCustomFields(text, longText, number, checkBox, pickupList, date);
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

	@When("^User clones the testcases upto thousand five hundred$")
	public void user_clones_the_testcases_upto_thousand_five_hundred() throws Throwable {
	   try
	   {
		bp.waitForElement();
		tr.clickOnList();
		bp.waitForElement();
		tr.selectallTestCase();
		tr.cloneTestCase();
		bp.waitForElement();
		tr.selectallTestCase();
		tr.cloneTestCase();
		bp.waitForElement();
		tr.selectallTestCase();
		tr.cloneTestCase();
		bp.waitForElement();
		tr.selectallTestCase();
		tr.cloneTestCase();
		bp.waitForElement();
		tr.selectallTestCase();
		tr.cloneTestCase();
		bp.waitForElement();
		tr.selectallTestCase();
		tr.cloneTestCase();
		bp.waitForElement();
		bp.waitForElement();
	/*	tr.selectallTestCase();
		bp.waitForElement();
		tr.cloneTestCase();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		tr.selectallTestCase();
		bp.waitForElement();
		bp.waitForElement();
		tr.cloneTestCase();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		tr.selectallTestCase();
		bp.waitForElement();
		tr.cloneTestCase();
		bp.waitForElement();
		tr.confirmCloneOperation();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		tr.selectallTestCase();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		tr.cloneTestCase();
		bp.waitForElement();
		tr.confirmCloneOperation();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();*/
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

	@When("^User Launch a TestPlanning and creates a cyCle$")
	public void user_Launch_a_TestPlanning_and_creates_a_cyCle() throws Throwable {
		try
		   {
			bp.waitForElement();  
			bp.waitForElement();
			  actual[12]=rp.clickOnTestPlanning();
			  bp.waitForElement();
//			  rp.clickOnTestPlanning();
//			  bp.waitForElement();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 19, 0);
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

	@When("^User clicks on cycle context menu and creates a Freeform phase$")
	public void user_clicks_on_cycle_context_menu_and_creates_a_Freeform_phase() throws Throwable {
		try
	    {
//			bp=new BasePage();
//			   pp=new ProjectPage(driver);
//			   bp.waitForElement();
//		    	pp.clickOnLogout();
//		    	bp.waitForElement();
//		    	tp=new TestPlanningPage(driver);
//		    	tr=new TestRepositoryPage(driver);
//		    	exep=new ExecutionPage(driver);
//		    	
//		    	lp=new LoginPage(driver);
//				
//				String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_3");
//				   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_3");
//				   
//				   lp.enterUname(Uname);
//				   lp.enterPass(Pass);
//				   lp.clickOnLogin();
//				   
//				   pp=new ProjectPage(driver);
//				   rp=new ReleasePage(driver);
//				   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
//				   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
//			    	 bp.waitForElement();
//			    	 pp.selectProject(projectName);
//			    	 pp.selectRelease(releaseName);
			
			actual[17]=bp.waitForElement();
			//actual[17]=rp.clickOnTestPlanning();
			
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 19, 0);
			bp.waitForElement();
			actual[18]=tp.navigateToCycle(cycle);
			
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 19, 1);
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

	@When("^User launch a Add Testcase window and selects advanced search$")
	public void user_launch_a_Add_Testcase_window_and_selects_advanced_search() throws Throwable {
		try
	    {
	    	String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",19 ,1 );
		     bp.waitForElement();
		     actual[20]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[21]=tp.clickOnAddTestcasesToFreeForm();
		     
		     bp.waitForElement();
		     actual[22]=tp.clickOnAdvanceSearch();
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

	@When("^User search a testcase with available fields$")
	public void user_search_a_testcase_with_available_fields() throws Throwable {
		 try
	 	    {
	 	    	String name1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",10 ,0 );
	 	    	String operator1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",11 ,1 );
	 	    	String value1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",0 ,11 );//long characters only
	 	    	bp.waitForElement();
	 	    	actual[23]=tp.ZQLSearch1(name1, operator1, value1);
	 	    	actual[24]=tp.validateSearch();
	 	    	bp.waitForElement();
	 	    	actual[25]=tp.selectAllFreeFormTestCases();
	 		     bp.waitForElement();
	 		     
	 		     bp.waitForElement();
	 		     actual[26]=tp.clickOnSaveAndOk();
	 		     
	 		     bp.waitForElement();
	 		 	actual[27]=tp.closeFreeFormPage();
	 	    
	 	    	//customnumber only
	 		 	String[] cycleName2=new String[1];
	 		     cycleName2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",19 ,1 );
	 		     bp.waitForElement();
	 		     actual[28]=tp.navigateToCycle(cycleName2);
	 		     
	 		     bp.waitForElement();
	 		     actual[29]=tp.clickOnAddTestcasesToFreeForm();

	 		     bp.waitForElement();
	 		     actual[30]=tp.clickOnAdvanceSearch();
	 	    	
	 	    	String name2=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",18 ,0 );
	 	    	String operator2=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",14 ,1 );
	 	    	String value2=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "FreeForm",2 ,24 ));
	 	    	bp.waitForElement();
	 	    	actual[31]=tp.ZQLSearch1(name2, operator2, value2);
	 	    	actual[32]=tp.validateSearch();
	 	    	bp.waitForElement();
	 	    	actual[33]=tp.selectAllFreeFormTestCases();
	 		     bp.waitForElement();
	 		     //tp.clickOnCheckBoxSaveAllTestcases();
	 		     
	 		     bp.waitForElement();
	 		     actual[34]=tp.clickOnSaveAndOk();
	 		     
	 		     bp.waitForElement();
	 		 	actual[35]=tp.closeFreeFormPage();
	 	    	
	 	    	//customtext only
	 		 	String[] cycleName3=new String[1];
	 		     cycleName3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",19 ,1 );
	 		     bp.waitForElement();
	 		     actual[36]=tp.navigateToCycle(cycleName3);
	 		     
	 		     bp.waitForElement();
	 		     actual[37]=tp.clickOnAddTestcasesToFreeForm();
	 		     
	 		     bp.waitForElement();
	 		     actual[38]=tp.clickOnAdvanceSearch();
	 	    	String name3=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",19,0 );
	 	    	String operator3=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",16 ,1 );
	 	    	String value3=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",0 ,24 );
	 	    	bp.waitForElement();
	 	    	actual[39]=tp.ZQLSearch1(name3, operator3, value3);
	 	    	actual[40]=tp.validateSearch();
	 	    	bp.waitForElement();
	 	    	actual[41]=tp.selectAllFreeFormTestCases();
	 		     bp.waitForElement();
	 		     
	 		     actual[42]=tp.clickOnSaveAndOk();
	 		     bp.waitForElement();
	 	    	actual[43]=tp.closeFreeFormPage();
	 	    	bp.waitForElement();
	 	    	
	 	    	//Uppercase Only
	 	    	String[] cycleName4=new String[1];
	 		     cycleName4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",19 ,1 );
	 		     bp.waitForElement();
	 		     actual[44]=tp.navigateToCycle(cycleName4);
	 		     
	 		     bp.waitForElement();
	 		     actual[45]=tp.clickOnAddTestcasesToFreeForm();
	 		     bp.waitForElement();
	 		     actual[46]=tp.clickOnAdvanceSearch();
	 	    	String name4=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",10 ,0 );
	 	    	String operator4=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",12 ,1 );
	 	    	String value4=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",4 ,7 );
	 	    	bp.waitForElement();
	 	    	actual[47]=tp.ZQLSearch1(name4, operator4, value4);
	 	    	actual[48]=tp.validateSearch();
	 	    	bp.waitForElement();
	 	    	actual[49]=tp.selectAllFreeFormTestCases();
	 		     
	 		     bp.waitForElement();
	 		     actual[50]=tp.clickOnSaveAndOk();
	 		     bp.waitForElement();
	 	    	actual[51]=tp.closeFreeFormPage();
	 	    	bp.waitForElement();
	 	    	
	 	    	
	 	    	String[] cycleName5=new String[1];
	 		     cycleName5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",19 ,1 );
	 		     bp.waitForElement();
	 		     actual[52]=tp.navigateToCycle(cycleName5);
	 		     
	 		     bp.waitForElement();
	 		     actual[53]=tp.clickOnAddTestcasesToFreeForm();
	 		     bp.waitForElement();
	 		     actual[54]=tp.clickOnAdvanceSearch();
	 	    	String name5=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",11 ,0 );
	 	    	String operator5=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",11 ,1 );
	 	    	String value5=Excel_Lib.getData(INPUT_PATH_3, "StepDetails",6 ,0 );//stepdetail
	 	    	bp.waitForElement();
	 	    	actual[55]=tp.ZQLSearch1(name5, operator5, value5);
	 	    	actual[56]=tp.validateSearch();
	 	    	bp.waitForElement();
	 	    	actual[57]=tp.selectAllFreeFormTestCases();
	 		     bp.waitForElement();
	 		     
	 		     bp.waitForElement();
	 		     actual[58]=tp.clickOnSaveAndOk();
	 		     bp.waitForElement();
	 	    	actual[59]=tp.closeFreeFormPage();
	 	    	
	 	    	bp.waitForElement();
	 	    	tp.navigateToCycle(cycleName5);
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

	@When("^User Launch TestRepository and modifies the values in previously created phase with testcases$")
	public void user_Launch_TestRepository_and_modifies_the_values_in_previously_created_phase_with_testcases() throws Throwable {
		try
	    {
			tr=new TestRepositoryPage(driver);
	    	bp.waitForElement();
			actual[60]=rp.clickOnTestRep();
			
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
			bp.waitForElement();
			tr.doubleClickOnRelease(releaseName);
	    	String[] nodes=new String[1];
	    	nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 19, 1);
	    	bp.waitForElement();
	    	actual[61]=tr.navigateToNode(releaseName, nodes);
	    	
	    	bp.waitForElement();
			actual[62]=tr.clickDetailButton();
			bp.waitForElement();
			String[] tags1=new String[1];
			tags1[0]=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 3, 2);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			actual[63]=ctc.enterMultipletags(tags1);
			bp.waitForElement();
			
			int stepNum=Excel_Lib.getNumberData(INPUT_PATH_3,"Requirements" , 1, 0);
			String[] edit=new String[1];
			edit[0]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 0);
			//edit[1]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 0);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			actual[64]=ctc.editTeststep(stepNum, edit);
			bp.waitForElement();
			
			ctc=new CreateTestCasePage(driver);
			String tcName=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 3, 7);
			String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 3, 3);
			bp.waitForElement();
			actual[65]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
			bp.waitForElement();
			
			bp.waitForElement();
			ctc.customFieldOption.click();
			
			String text=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 0, 25);
			String longText=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 25);
			String number=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "FreeForm", 3, 23));
			String checkBox=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
			String pickupList=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
			String date=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
			bp.waitForElement();
			actual[66]=ctc.enterCustomFields(text, longText, number, checkBox, pickupList, date);
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

	@When("^User Launch a testPlanning and selects the Freeform phase created and launches assign window$")
	public void user_Launch_a_testPlanning_and_selects_the_Freeform_phase_created_and_launches_assign_window() throws Throwable {
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
			    	 pp.selectRelease(releaseName);*/
			tp=new TestPlanningPage(driver);
			bp.waitForElement();
			actual[67]=rp.clickOnTestPlanning();
			bp.waitForElement();
			bp.waitForElement();
			
			String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 19, 0);
			bp.waitForElement();
			actual[68]=tp.doubleClickOnCycle(cycleName);
			bp.waitForElement();
			
	    	String[] cycle=new String[2];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 19, 0);
			cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 19, 1);
			actual[69]=tp.navigateToCycle(cycle);
			bp.waitForElement();
			
	    	actual[70]=tp.assignPhase();
	    	bp.waitForElement();
	    	
	    	actual[71]=bp.waitForElement();
	    	//actual[71]=tp.cancelBulkAssign();
			
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

	@When("^User search a testcases with the modified values and add it freeform phase$")
	public void user_search_a_testcases_with_the_modified_values_and_add_it_freeform_phase() throws Throwable {
		try
 	    {
			String[] cycleName1=new String[1];
		     cycleName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",19 ,1 );
		     bp.waitForElement();
		     actual[72]=tp.navigateToCycle(cycleName1);
		     
		     bp.waitForElement();
 		     actual[73]=tp.clickOnAddTestcasesToFreeForm();

 		     bp.waitForElement();
 		     actual[74]=tp.clickOnAdvanceSearch();
			
 		    String name1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",10 ,0 );
 	    	String operator1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",11 ,1 );
 	    	String value1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",3 ,11 );//long characters only
 	    	bp.waitForElement();
 	    	actual[75]=tp.ZQLSearch1(name1, operator1, value1);
 	    	actual[76]=tp.validateSearch();
 	    	bp.waitForElement();
 	    	actual[77]=tp.selectAllFreeFormTestCases();
 		     bp.waitForElement();
 		     //tp.clickOnCheckBoxSaveAllTestcases();
 		     
 		     bp.waitForElement();
 		     actual[78]=tp.clickOnSaveAndOk();
 		     
 		     bp.waitForElement();
 		 	actual[79]=tp.closeFreeFormPage();
 	    
 	    	//customnumber only
 		 	String[] cycleName2=new String[1];
 		     cycleName2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",19 ,1 );
 		     bp.waitForElement();
 		     actual[80]=tp.navigateToCycle(cycleName2);
 		     
 		     bp.waitForElement();
 		     actual[81]=tp.clickOnAddTestcasesToFreeForm();

 		     bp.waitForElement();
 		     actual[82]=tp.clickOnAdvanceSearch();
 	    	
 	    	String name2=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",18 ,0 );
 	    	String operator2=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",14 ,1 );
 	    	String value2=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "FreeForm",3 ,23 ));
 	    	bp.waitForElement();
 	    	actual[83]=tp.ZQLSearch1(name2, operator2, value2);
 	    	actual[84]=tp.validateSearch();
 	    	bp.waitForElement();
 	    	actual[85]=tp.selectAllFreeFormTestCases();
 		     bp.waitForElement();
 		     //tp.clickOnCheckBoxSaveAllTestcases();
 		     
 		     bp.waitForElement();
 		     actual[86]=tp.clickOnSaveAndOk();
 		     
 		     bp.waitForElement();
 		 	actual[87]=tp.closeFreeFormPage();
 	    	
 	    	//customtext only
 		 	String[] cycleName3=new String[1];
 		     cycleName3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",19 ,1 );
 		     bp.waitForElement();
 		     actual[88]=tp.navigateToCycle(cycleName3);
 		     
 		     bp.waitForElement();
 		     actual[89]=tp.clickOnAddTestcasesToFreeForm();
 		     
 		     bp.waitForElement();
 		     actual[90]=tp.clickOnAdvanceSearch();
 	    	String name3=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",19 ,0 );
 	    	String operator3=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",12 ,1 );
 	    	String value3=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",0 ,26 );
 	    	bp.waitForElement();
 	    	actual[91]=tp.ZQLSearch1(name3, operator3, value3);
 	    	actual[92]=tp.validateSearch();
 	    	bp.waitForElement();
 	    	actual[93]=tp.selectAllFreeFormTestCases();
 		     bp.waitForElement();
 		     
 		     actual[94]=tp.clickOnSaveAndOk();
 		     bp.waitForElement();
 	    	actual[95]=tp.closeFreeFormPage();
 	    	bp.waitForElement();
 	    	
 	    	//Uppercase Only
 	    	String[] cycleName4=new String[1];
 		     cycleName4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",19 ,1 );
 		     bp.waitForElement();
 		     actual[96]=tp.navigateToCycle(cycleName4);
 		     
 		     bp.waitForElement();
 		     actual[97]=tp.clickOnAddTestcasesToFreeForm();
 		     bp.waitForElement();
 		     actual[98]=tp.clickOnAdvanceSearch();
 	    	String name4=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",10 ,0 );
 	    	String operator4=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",12 ,1 );
 	    	String value4=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",5 ,7 );
 	    	bp.waitForElement();
 	    	actual[99]=tp.ZQLSearch1(name4, operator4, value4);
 	    	actual[100]=tp.validateSearch();
 	    	bp.waitForElement();
 	    	actual[101]=tp.selectAllFreeFormTestCases();
 		     
 		     bp.waitForElement();
 		     actual[102]=tp.clickOnSaveAndOk();
 		     bp.waitForElement();
 	    	actual[103]=tp.closeFreeFormPage();
 	    	bp.waitForElement();
 	    	
 	    	String[] cycleName5=new String[1];
		     cycleName5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",19 ,1 );
		     bp.waitForElement();
		     actual[104]=tp.navigateToCycle(cycleName5);
		     bp.waitForElement();
		     
		     actual[105]=tp.clickOnAddTestcasesToFreeForm();
		     bp.waitForElement();
		     actual[106]=tp.clickOnAdvanceSearch();
	    	String name5=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",11 ,0 );
	    	String operator5=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",11 ,1 );
	    	String value5=Excel_Lib.getData(INPUT_PATH_3, "StepDetails",6 ,0 );//stepdetail
	    	bp.waitForElement();
	    	actual[107]=tp.ZQLSearch1(name5, operator5, value5);
	    	actual[108]=tp.validateSearch();
	    	bp.waitForElement();
	    	actual[109]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     
		     bp.waitForElement();
		     actual[110]=tp.clickOnSaveAndOk();
		     bp.waitForElement();
	    	actual[111]=tp.closeFreeFormPage();
	    	
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

	@Then("^User successfully search a testcases with edited values$")
	public void user_successfully_search_a_testcases_with_edited_values() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
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
