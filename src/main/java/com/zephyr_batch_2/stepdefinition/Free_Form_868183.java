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

public class Free_Form_868183 extends LaunchBrowser {

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
	String fileName="Free_Form_868183";
	
	boolean[] actual=new boolean[77];
	 SoftAssert soft=new SoftAssert();

	
	@Given("^User is in a page testRepository$")
	public void user_is_in_a_page_testRepository() throws Throwable {
		try
		   {
			bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   bp.waitForElement();
		   actual[0]=pp.selectProject(projectName);
		   bp.waitForElement();
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

	@Given("^User creates a phase with all the given fields$")
	public void user_creates_a_phase_with_all_the_given_fields() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183", 1, 1);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183", 1, 3);
		
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
		String tcName1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183", 1, 4);
		String tcDesc1=Excel_Lib.getData(INPUT_PATH_3,"FreeForm_868183" , 1, 5);
		bp.waitForElement();
		actual[7]=ctc.enterTestCaseNameAndDesc(tcName1, tcDesc1);
		
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
		actual[8]=ctc.enterTestCaseStepDetail(stepDetail);
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

	@Given("^User creates a testcases with different characters in testcase name$")
	public void user_creates_a_testcases_with_different_characters_in_testcase_name() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			bp.waitForElement();
			actual[9]=tr.clickOnList();
			bp.waitForElement();
			actual[10]=tr.addTestCase();
			bp.waitForElement();
			String[] testCaseNo2=new String[1];
			testCaseNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"TestPlanning", 2, 8));
			ep=new ExportPage(driver);
			ep.selectMultipleTestCaseFromGrid(testCaseNo2);
			bp.waitForElement();
			actual[11]=tr.clickDetailButton();
			ctc=new CreateTestCasePage(driver);
			String tcName2=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183", 2, 4);
			String tcDesc2=Excel_Lib.getData(INPUT_PATH_3,"FreeForm_868183" , 2, 5);
			actual[12]=ctc.enterTestCaseNameAndDesc(tcName2, tcDesc2);
			
			bp.waitForElement();
			actual[13]=tr.clickOnList();
			bp.waitForElement();
			actual[14]=tr.addTestCase();
			bp.waitForElement();
			String[] testCaseNo3=new String[1];
			testCaseNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"TestPlanning", 3, 8));
			ep=new ExportPage(driver);
			ep.selectMultipleTestCaseFromGrid(testCaseNo3);
			bp.waitForElement();
			actual[15]=tr.clickDetailButton();
			bp.waitForElement();
			ctc=new CreateTestCasePage(driver);
			String tcName3=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183", 3, 4);
			String tcDesc3=Excel_Lib.getData(INPUT_PATH_3,"FreeForm_868183" , 3, 5);
			actual[16]=ctc.enterTestCaseNameAndDesc(tcName3, tcDesc3);
			bp.waitForElement();
			
			actual[17]=tr.clickOnList();
			bp.waitForElement();
			actual[18]=tr.addTestCase();
			String[] testCaseNo4=new String[1];
			testCaseNo4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"TestPlanning", 4, 8));
			ep=new ExportPage(driver);
			ep.selectMultipleTestCaseFromGrid(testCaseNo4);
			bp.waitForElement();
			actual[19]=tr.clickDetailButton();
			ctc=new CreateTestCasePage(driver);
			String tcName4=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "FreeForm_868183", 4, 4));
			String tcDesc4=Excel_Lib.getData(INPUT_PATH_3,"FreeForm_868183" , 4, 5);
			actual[20]=ctc.enterTestCaseNameAndDesc(tcName4, tcDesc4);
			
			bp.waitForElement();
			actual[21]=tr.clickOnList();
			bp.waitForElement();
			actual[22]=tr.addTestCase();
			String[] testCaseNo5=new String[1];
			testCaseNo5[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"TestPlanning", 5, 8));
			ep=new ExportPage(driver);
			ep.selectMultipleTestCaseFromGrid(testCaseNo5);
			bp.waitForElement();
			actual[23]=tr.clickDetailButton();
			ctc=new CreateTestCasePage(driver);
			String tcName5=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183", 5, 4);
			String tcDesc5=Excel_Lib.getData(INPUT_PATH_3,"FreeForm_868183" , 5, 5);
			actual[24]=ctc.enterTestCaseNameAndDesc(tcName5, tcDesc5);
			
			
			actual[25]=tr.clickOnList();
			bp.waitForElement();
			actual[26]=tr.addTestCase();
			String[] testCaseNo6=new String[1];
			testCaseNo6[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"TestPlanning", 6, 8));
			ep=new ExportPage(driver);
			ep.selectMultipleTestCaseFromGrid(testCaseNo6);
			bp.waitForElement();
			actual[27]=tr.clickDetailButton();
			ctc=new CreateTestCasePage(driver);
			String tcName6=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183", 6, 4);
			String tcDesc6=Excel_Lib.getData(INPUT_PATH_3,"FreeForm_868183" , 6, 5);
			actual[28]=ctc.enterTestCaseNameAndDesc(tcName6, tcDesc6);
			
			actual[29]=tr.clickOnList();
			bp.waitForElement();
			actual[30]=tr.addTestCase();
			String[] testCaseNo7=new String[1];
			testCaseNo7[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"TestPlanning", 7, 8));
			ep=new ExportPage(driver);
			ep.selectMultipleTestCaseFromGrid(testCaseNo7);
			bp.waitForElement();
			actual[31]=tr.clickDetailButton();
			ctc=new CreateTestCasePage(driver);
			String tcName7=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183", 7, 4);
			String tcDesc7=Excel_Lib.getData(INPUT_PATH_3,"FreeForm_868183" , 7, 5);
			actual[32]=ctc.enterTestCaseNameAndDesc(tcName7, tcDesc7);
			
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

	@When("^User launches testPlanning and creates a cycle$")
	public void user_launches_testPlanning_and_creates_a_cycle() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[33]=rp.clickOnTestPlanning();
			  bp.waitForElement();
//			  rp.clickOnTestPlanning(); 
//			  bp.waitForElement();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183", 1, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[34]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[35]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[36]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[37]=tp.saveTestCycle();
			   
			      
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

	@When("^User creates a phase by selecting context menu create new option and save$")
	public void user_creates_a_phase_by_selecting_context_menu_create_new_option_and_save() throws Throwable {
			try
		    {
				bp.waitForElement();
				actual[38]=rp.clickOnTestPlanning();
				
		    	String[] cycle=new String[1];
				cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183", 1, 0);
				actual[39]=tp.navigateToCycle(cycle);
				
				String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183", 1, 1);
				bp.waitForElement();
				actual[40]=tp.createFreeFormPhase(phaseName);
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
	
	@When("^User navigates to created phase and click on add testcases$")
	public void user_navigates_to_created_phase_and_click_on_add_testcases() throws Throwable {
		try
		{
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183",1 ,1 );
		     bp.waitForElement();
		     actual[41]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[42]=tp.clickOnAddTestcasesToFreeForm();
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

	@When("^User search testcase with testcase name containing only lowercase characters$")
	public void user_search_testcase_with_testcase_name_containing_only_lowercase_characters() throws Throwable {
		try
	    {
	    	 String name=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183",1 ,4 );
		     bp.waitForElement();
		     actual[43]=tp.quiksearch(name);	
		     
		     bp.waitForElement();
		     actual[44]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     //tp.clickOnCheckBoxSaveAllTestcases();
		     
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

	@When("^User search testcase with testcase name contains only capital characters$")
	public void user_search_testcase_with_testcase_name_contains_only_capital_characters() throws Throwable {
		try
	    {
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183",1 ,1 );
		     bp.waitForElement();
		     actual[47]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[48]=tp.clickOnAddTestcasesToFreeForm();
			
			String name=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183",2 ,4 );
		     bp.waitForElement();
		     actual[49]=tp.quiksearch(name);	
		     
		     bp.waitForElement();
		     actual[50]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     //tp.clickOnCheckBoxSaveAllTestcases();
		     
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

	@When("^User search testcase with testcase name contains only special characters$")
	public void user_search_testcase_with_testcase_name_contains_only_special_characters() throws Throwable {
		try
	    {
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183",1 ,1 );
		     bp.waitForElement();
		     tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     tp.clickOnAddTestcasesToFreeForm();
			
	    	 String name=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183",3 ,4 );
		     bp.waitForElement();
		     tp.quiksearch(name);
		     
		     bp.waitForElement();
		     tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     //tp.clickOnCheckBoxSaveAllTestcases();
		     
		     bp.waitForElement();
		     tp.clickOnSaveAndOk();
		     
		     bp.waitForElement();
		     tp.closeFreeFormPage();
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

	@When("^User search testcase with testcase name contains only numbers$")
	public void user_search_testcase_with_testcase_name_contains_only_numbers() throws Throwable {
		try
	    {
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183",1 ,1 );
		     bp.waitForElement();
		     tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     tp.clickOnAddTestcasesToFreeForm();
			
			String name=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "FreeForm_868183",4 ,4 ));
		     bp.waitForElement();
		     actual[53]=tp.quiksearch(name);
		     
		     bp.waitForElement();
		     actual[54]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     //tp.clickOnCheckBoxSaveAllTestcases();
		     
		     bp.waitForElement();
		     actual[55]=tp.clickOnSaveAndOk();
		     
		     bp.waitForElement();
		     actual[56]=tp.closeFreeFormPage();
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

	@When("^User search testcase with testcase name contains only alphanumeric and special characters$")
	public void user_search_testcase_with_testcase_name_contains_only_alphanumeric_and_special_characters() throws Throwable {
		try
	    {
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183",1 ,1 );
		     bp.waitForElement();
		     actual[57]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[58]=tp.clickOnAddTestcasesToFreeForm();
			
			String name=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183",5 ,4 );
		     bp.waitForElement();
		     actual[59]=tp.quiksearch(name);
		     
		     bp.waitForElement();
		     actual[60]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     //tp.clickOnCheckBoxSaveAllTestcases();
		     
		     bp.waitForElement();
		     actual[61]=tp.clickOnSaveAndOk();
		     
		     bp.waitForElement();
		     actual[62]=tp.closeFreeFormPage();
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

	@When("^User search testcase with testcase name contains only international characters$")
	public void user_search_testcase_with_testcase_name_contains_only_international_characters() throws Throwable {
		try
	    {
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183",1 ,1 );
		     bp.waitForElement();
		     actual[63]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[64]=tp.clickOnAddTestcasesToFreeForm();
	    	 
			String name=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183",6 ,4 );
		     bp.waitForElement();
		     actual[65]=tp.quiksearch(name);
		     
		     bp.waitForElement();
		     actual[66]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     //tp.clickOnCheckBoxSaveAllTestcases();
		     
		     bp.waitForElement();
		     actual[67]=tp.clickOnSaveAndOk();
		     
		     bp.waitForElement();
		     actual[68]=tp.closeFreeFormPage();
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

	@When("^User search testcase with testcase name containing long name$")
	public void user_search_testcase_with_testcase_name_containing_long_name() throws Throwable {
		try
	    {
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183",1 ,1 );
		     bp.waitForElement();
		     actual[69]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[70]=tp.clickOnAddTestcasesToFreeForm();
			
			String name=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868183",7 ,4 );
		     bp.waitForElement();
		     actual[71]=tp.quiksearch(name);
		     
		     bp.waitForElement();
		     actual[72]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     //tp.clickOnCheckBoxSaveAllTestcases();
		     
		     bp.waitForElement();
		     actual[73]=tp.clickOnSaveAndOk();
		     
		     bp.waitForElement();
		     actual[74]=tp.closeFreeFormPage();
		     
		     bp.waitForElement();
		     actual[75]=tp.selectallTestCase();
			 	bp.waitForElement();
			 	String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
			 	actual[76]=tp.assignAllSelected(assignee);
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

	@Then("^User successfully search testcase name with different characters$")
	public void user_successfully_search_testcase_name_with_different_characters() throws Throwable {
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
