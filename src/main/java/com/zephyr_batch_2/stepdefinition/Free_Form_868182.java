package com.zephyr_batch_2.stepdefinition;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class Free_Form_868182 extends LaunchBrowser{

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
	String fileName="Free_Form_868182";
	
	boolean[] actual=new boolean[84];
	 SoftAssert soft=new SoftAssert();
	 
	@Given("^User Selects the Project For the TestPlanning$")
	public void user_Selects_the_Project_For_the_TestPlanning() throws Throwable {
		try
		   {
			bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		   actual[0]=pp.selectProject(projectName);
		   
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

	@When("^User Click on a rElease in release summary$")
	public void user_Click_on_a_rElease_in_release_summary() throws Throwable {
		try
	    {
	    	 String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
	    	 bp.waitForElement();
	    	 actual[1]=pp.selectRelease(releaseName);
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

	@When("^User Launch testRepository, Create Phase with Name and Description$")
	public void user_Launch_testRepository_Create_Phase_with_Name_and_Description() throws Throwable {
	    try
	    {
	    	rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[2]=rp.clickOnTestRep(); 
			   
					tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868182", 1, 1);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868182", 1, 3);
				
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
				ctc=new CreateTestCasePage(driver);
				String tcName1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868182", 1, 4);
				String tcDesc1=Excel_Lib.getData(INPUT_PATH_3,"FreeForm_868182" , 1, 5);
				actual[7]=ctc.enterTestCaseNameAndDesc(tcName1, tcDesc1);
				bp.waitForElement();
				actual[8]=tr.clickOnList();
				bp.waitForElement();
				actual[9]=tr.addTestCase();
				bp.waitForElement();
				String[] testCaseNo2=new String[1];
				testCaseNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"TestPlanning", 2, 8));
				ep=new ExportPage(driver);
				ep.selectMultipleTestCaseFromGrid(testCaseNo2);
				bp.waitForElement();
				actual[10]=tr.clickDetailButton();
				ctc=new CreateTestCasePage(driver);
				String tcName2=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868182", 2, 4);
				String tcDesc2=Excel_Lib.getData(INPUT_PATH_3,"FreeForm_868182" , 2, 5);
				actual[11]=ctc.enterTestCaseNameAndDesc(tcName2, tcDesc2);
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

	@Then("^User Navigate to Created Phase, Add Testcase with all the Fields$")
	public void user_Navigate_to_Created_Phase_Add_Testcase_with_all_the_Fields() throws Throwable {
	    try
	    {
	    	ctc=new CreateTestCasePage(driver);
	    	bp.waitForElement();
			String[] tags=new String[1];
			tags[0]=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 3, 1);
			bp.waitForElement();
			ctc.enterMultipleTags(tags);
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
			actual[12]=ctc.enterTestCaseStepDetail(stepDetail);
			bp.waitForElement();
			
		
			
			String[] Details=new String[4];
			Details[0]=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 6, 1);
			Details[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "testcaseDetails", 2, 1));
			//Details[1]=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 2, 1);
	 
			Details[2]=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
			Details[3]=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 4, 1);
			bp.waitForElement();
			actual[13]=ctc.enterTestCaseDetail(Details);
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

	@When("^User Launch TestPlanning, Create an Execution Cycle$")
	public void user_Launch_TestPlanning_Create_an_Execution_Cycle() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[14]=rp.clickOnTestPlanning();
			  bp.waitForElement();
			  //rp.clickOnTestPlanning();
			  //bp.waitForElement();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868182", 1, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[15]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[16]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[17]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[18]=tp.saveTestCycle();
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

	@When("^User performs ContextClick and selects 'Add Phase', Select 'Create new' in the Add new phase window and Create Phase, Save it$")
	public void user_performs_ContextClick_and_selects_Add_Phase_Select_Create_new_in_the_Add_new_phase_window_and_Create_Phase_Save_it() throws Throwable {
			try
		    {
				   /*bp=new BasePage();//
				   pp=new ProjectPage(driver);
				   rp=new ReleasePage(driver);
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
					   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
					   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
				    	 bp.waitForElement();
				    	 pp.selectProject(projectName);
				    	 pp.selectRelease(releaseName);// */
				
				bp.waitForElement();
				actual[19]=rp.clickOnTestPlanning();
				
		    	String[] cycle=new String[1];
				cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868182", 1, 0);
				bp.waitForElement();
				actual[20]=tp.navigateToCycle(cycle);
				
				String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868182", 1, 1);
				actual[21]=tp.createFreeFormPhase(phaseName);
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

	@When("^User Navigate to Created Phase and Adds testcase and Click On Search Icon, Select 'Quick' Search$")
	public void user_Navigate_to_Created_Phase_and_Adds_testcase_and_Click_On_Search_Icon_Select_Quick_Search() throws Throwable {
		try
		{
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868182",1 ,1 );
		     bp.waitForElement();
		     actual[22]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[23]=tp.clickOnAddTestcasesToFreeForm();
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

		@When("^User search testcase by testcase name and selects the testcase and save$")
	public void user_search_testcase_by_testcase_name_and_selects_the_testcase_and_save() throws Throwable {
		 try
		    {
			 
		    	 String name=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868182",1 ,4 );
			     bp.waitForElement();
			     actual[24]=tp.quiksearch(name);
			     bp.waitForElement();
			     
			     bp.waitForElement();
			     actual[25]=tp.selectAllFreeFormTestCases();
			     bp.waitForElement();
			     //actual[26]=tp.clickOnCheckBoxSaveAllTestcases();
			     actual[26]=bp.waitForElement();
			     
			     bp.waitForElement();
			     actual[27]=tp.clickOnSaveAndOk();
			     
			     bp.waitForElement();
			     actual[28]=tp.closeFreeFormPage();
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

	@When("^User search testcase by testcase contents and selects the testcase and save$")
	public void user_search_testcase_by_testcase_contents_and_selects_the_testcase_and_save() throws Throwable {
		 try
		    {
			 String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868182",1 ,1 );
		     bp.waitForElement();
		     actual[29]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[30]=tp.clickOnAddTestcasesToFreeForm();
	    	 
			String name=Excel_Lib.getData(INPUT_PATH_3, "StepDetails",1 ,0 );
		     bp.waitForElement();
		     actual[31]=tp.quiksearch(name);
		     bp.waitForElement();
		     
		     bp.waitForElement();
		     actual[32]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     //actual[33]=tp.clickOnCheckBoxSaveAllTestcases();
		     
		     bp.waitForElement();
		     actual[33]=tp.clickOnSaveAndOk();
		     
		     bp.waitForElement();
		     actual[34]=tp.closeFreeFormPage();	
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

	@When("^User search testcase by testcase priority and selects the testcase and save$")
	public void user_search_testcase_by_testcase_priority_and_selects_the_testcase_and_save() throws Throwable {
		 try
		    {
			 String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868182",1 ,1 );
		     bp.waitForElement();
		     actual[35]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[36]=tp.clickOnAddTestcasesToFreeForm();
	    	 
			String name=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",6 ,1 );
		     bp.waitForElement();
		     actual[37]=tp.quiksearch(name);
		     bp.waitForElement();
		     
		     bp.waitForElement(); 
		     actual[38]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     //actual[39]=tp.clickOnCheckBoxSaveAllTestcases();
		     
		     bp.waitForElement();
		     actual[39]=tp.clickOnSaveAndOk();
		     
		     bp.waitForElement();
		     actual[40]=tp.closeFreeFormPage();	
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

	@When("^User search testcase by testcase alt id and selects the testcase and save$")
	public void user_search_testcase_by_testcase_alt_id_and_selects_the_testcase_and_save() throws Throwable {
		 try
		    {
			 String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868182",1 ,1 );
		     bp.waitForElement();
		     actual[41]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[42]=tp.clickOnAddTestcasesToFreeForm();
	    	 
			String name=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "testcaseDetails",2 ,1 ));
		     bp.waitForElement();
		     actual[43]=tp.quiksearch(name);
		     bp.waitForElement();
		     
		     bp.waitForElement();
		     actual[44]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     //actual[46]=tp.clickOnCheckBoxSaveAllTestcases();
		     
		     bp.waitForElement();
		   
		     actual[45]=tp.clickOnSaveAndOk();
		     
		     bp.waitForElement();
		     actual[46]=tp.closeFreeFormPage();	
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

	@When("^User search testcase by testcase tag and selects the testcase and save$")
	public void user_search_testcase_by_testcase_tag_and_selects_the_testcase_and_save() throws Throwable {
		 try
		    {
			 String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868182",1 ,1 );
		     bp.waitForElement();
		     actual[47]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[48]=tp.clickOnAddTestcasesToFreeForm();
	    	 
			String name=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",3,1 );
		     bp.waitForElement();
		     actual[49]=tp.quiksearch(name);
		     bp.waitForElement();
		     
		     bp.waitForElement();
		     actual[50]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     //actual[51]=tp.clickOnCheckBoxSaveAllTestcases();
		     
		     bp.waitForElement();
		     actual[51]=tp.clickOnSaveAndOk();
		     
		     bp.waitForElement();
		     actual[52]=tp.closeFreeFormPage();	
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

	@When("^User search testcase by testcase comments and selects the testcase ans save$")
	public void user_search_testcase_by_testcase_comments_and_selects_the_testcase_ans_save() throws Throwable {
		 try
		    {
			 String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868182",1 ,1 );
		     bp.waitForElement();
		     actual[53]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[54]=tp.clickOnAddTestcasesToFreeForm();
	    	 
			String name=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",4 ,1 );
		     bp.waitForElement();
		     actual[55]=tp.quiksearch(name);
		     bp.waitForElement();
		     
		     bp.waitForElement();
		     actual[56]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     //actual[58]=tp.clickOnCheckBoxSaveAllTestcases();
		     
		     bp.waitForElement();
		     actual[57]=tp.clickOnSaveAndOk();
		     
		     bp.waitForElement();
		     actual[58]=tp.closeFreeFormPage();
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

	@When("^User search testcase by testcase creator first time and selects the testcase and save$")
	public void user_search_testcase_by_testcase_creator_first_time_and_selects_the_testcase_and_save() throws Throwable {
		 try
		    {
			 String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868182",1 ,1 );
		     bp.waitForElement();
		     actual[59]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[60]=tp.clickOnAddTestcasesToFreeForm();
	    	 
			String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		     bp.waitForElement();
		     actual[61]=tp.quiksearch(name);
		     bp.waitForElement();
		     
		     /*bp.waitForElement();
		     String[] testCaseNo=new String[3];
		     testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8 ));
		     testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8 ));
		     testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,8 ));
		     bp.waitForElement();
		     bp.waitForElement();
		     actual[66]=tp.selectMultipleTestCaseFromFreeForm(testCaseNo);*/
		     bp.waitForElement();
		     actual[62]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		    // actual[68]=tp.clickOnCheckBoxSaveAllTestcases();
		     
		     bp.waitForElement();
		     actual[63]=tp.clickOnSaveAndOk();
		     
		     bp.waitForElement();
		     actual[64]=tp.closeFreeFormPage();	
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

	@When("^User search testcase by testcase creator last time and selects the testcase and save$")
	public void user_search_testcase_by_testcase_creator_last_time_and_selects_the_testcase_and_save() throws Throwable {
		 try
		    {
			 String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868182",1 ,1 );
		     bp.waitForElement();
		     actual[65]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[66]=tp.clickOnAddTestcasesToFreeForm();
	    	 
			String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User5");
		     bp.waitForElement();
		     actual[67]=tp.quiksearch(name);
		     bp.waitForElement();
		     
		     /*bp.waitForElement();
		     String[] testCaseNo=new String[3];
		     testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8 ));
		     testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8 ));
		     testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,8 ));
		     bp.waitForElement();
		     actual[72]=tp.selectMultipleTestCaseFromFreeForm(testCaseNo);*/
		     bp.waitForElement();
		     actual[68]=tp.selectAllFreeFormTestCases();
		     //bp.waitForElement();
		     //actual[74]=tp.clickOnCheckBoxSaveAllTestcases();
		     
		     bp.waitForElement();
		     actual[69]=tp.clickOnSaveAndOk();
		     
		     bp.waitForElement();
		     actual[70]=tp.closeFreeFormPage();
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

	@When("^User search testcase by testcase release name and selects the testcase and save$")
	public void user_search_testcase_by_testcase_release_name_and_selects_the_testcase_and_save() throws Throwable {
		 try
		    {
			 String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868182",1 ,1 );
		     bp.waitForElement();
		     actual[71]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[72]=tp.clickOnAddTestcasesToFreeForm();
	    	 
			String name=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868182",2 ,4 );
		     bp.waitForElement();
		     actual[73]=tp.quiksearch(name);
		     bp.waitForElement();
		     
		     bp.waitForElement();
		     actual[74]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     //actual[79]=tp.clickOnCheckBoxSaveAllTestcases();
		     
		     bp.waitForElement();
		     actual[75]=tp.clickOnSaveAndOk();
		     
		     bp.waitForElement();
		     actual[76]=tp.closeFreeFormPage();	
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

	@When("^User performs search operation by clicking on Go$")
	public void user_performs_search_operation_by_clicking_on_Go() throws Throwable {
	    try
	    {
	    	 String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868182",1 ,1 );
		     bp.waitForElement();
		     actual[77]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[78]=tp.clickOnAddTestcasesToFreeForm();
	    	 
			String name=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868182",100 ,100 );
		     bp.waitForElement();
		     actual[79]=tp.quiksearch(name);
		     bp.waitForElement();
		     
		     bp.waitForElement();
		     actual[80]=tp.closeFreeFormPage();	
		     
		     String[] cycleName1=new String[1];
		     cycleName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868182",1 ,1 );
		     bp.waitForElement();
		     actual[81]=tp.navigateToCycle(cycleName1);
		     
		        bp.waitForElement();
			 	actual[82]=tp.selectallTestCase();
			 	bp.waitForElement();
			 	String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
			 	actual[83]=tp.assignAllSelected(assignee);
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

	@Then("^User successfully search testcases and add it to a free form phase$")
	public void user_successfully_search_testcases_and_add_it_to_a_free_form_phase() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("Phases with all the above mentioned Specifications are Created Successfully");
		}
		catch(Exception e)
		{
		   
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}
}
