package com.zephyr_batch_2.stepdefinition;

import org.openqa.selenium.By;
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

public class Search_Advanced_868222 extends LaunchBrowser{

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
	String[] a=new String[3];
	String fileName="Search_868222";
	
	boolean[] actual=new boolean[37];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in a pAge TestRepository$")
	public void user_is_in_a_pAge_TestRepository() throws Throwable {
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

	@When("^User creates a phase with testcases$")
	public void user_creates_a_phase_with_testcases() throws Throwable {
		try
	    {
				tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 20, 1);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 20, 2);
				
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
				tr.addTestCase();
				tr.addTestCase();
				//TestRepositoryPage_POM tpom=new TestRepositoryPage_POM(driver);
				int k=0;
				for(int i=1;i<=3;i++)
				{
					
					a[k]=driver.findElement(By.xpath(tr.testcaseID1+i+tr.testcaseID2)).getText();
					System.out.println(a[k]);
					k++;
				}
				
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

	@When("^User Launches tEstPlanning and creates a cycle$")
	public void user_Launches_tEstPlanning_and_creates_a_cycle() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[7]=rp.clickOnTestPlanning();
			  bp.waitForElement();
//			  rp.clickOnTestPlanning();
//			  bp.waitForElement();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 20, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[8]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[9]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[10]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[11]=tp.saveTestCycle();
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

	@When("^User clicks on cycle context menu and creates a new freeform phase$")
	public void user_clicks_on_cycle_context_menu_and_creates_a_new_freeform_phase() throws Throwable {
		try
	    {
			actual[12]=bp.waitForElement();
			//actual[12]=rp.clickOnTestPlanning();
			
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 20, 0);
			bp.waitForElement();
			actual[13]=tp.navigateToCycle(cycle);
			
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 20, 1);
			actual[14]=tp.createFreeFormPhase(phaseName);
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

	@When("^User clicks on Add testcase and selects advanced search$")
	public void user_clicks_on_Add_testcase_and_selects_advanced_search() throws Throwable {
		try
		{
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",20 ,1 );
		     bp.waitForElement();
		     actual[15]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[16]=tp.clickOnAddTestcasesToFreeForm();
		     
		     bp.waitForElement();
			 actual[17]=tp.clickOnAdvanceSearch();	
		    
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

	@When("^User search a testcase with id using operator '='$")
	public void user_search_a_testcase_with_id_using_operator1() throws Throwable {
		try
		{
		String name1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",17 ,0 );
    	String operator1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,1 );
    	String value1=a[0];
    	bp.waitForElement();
    	actual[18]=tp.ZQLSearch1(name1, operator1, value1);
    	actual[19]=tp.validateSearch();
    	bp.waitForElement();
    	actual[20]=tp.selectAllFreeFormTestCases();
	     bp.waitForElement();
	     //tp.clickOnCheckBoxSaveAllTestcases();
	     
	     bp.waitForElement();
	     actual[21]=tp.clickOnSaveAndOk();
	     
	     bp.waitForElement();
	 	actual[22]=tp.closeFreeFormPage();
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

	@When("^User search a testcase with id using '!=' operator$")
	public void user_search_a_testcase_with_id_using_operator() throws Throwable {
	   try
	   {
		   bp.waitForElement();
		    actual[23]=tp.clickOnAddTestcasesToFreeForm();
		     
		     bp.waitForElement();
			 actual[24]=tp.clickOnAdvanceSearch();	
			 
			 String name1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",17 ,0 );
		    	String operator1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",10 ,1 );
		    	String value1=a[1];
		    	bp.waitForElement();
		    	actual[25]=tp.ZQLSearch1(name1, operator1, value1);
		    	actual[26]=tp.validateSearch();
		    	bp.waitForElement();
		    	actual[27]=tp.selectAllFreeFormTestCases();
			     bp.waitForElement();
			     //tp.clickOnCheckBoxSaveAllTestcases();
			     
			     bp.waitForElement();
			     actual[28]=tp.clickOnSaveAndOk();
			     
			     bp.waitForElement();
			 	actual[29]=tp.closeFreeFormPage();
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

	@When("^User search a testcase with id using operator 'in'$")
	public void user_search_a_testcase_with_id_using_operator_in() throws Throwable {
		 try
		   {
			   bp.waitForElement();
			    actual[30]=tp.clickOnAddTestcasesToFreeForm();
			     
			     bp.waitForElement();
				 actual[31]=tp.clickOnAdvanceSearch();	
				 
				 String name1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",17 ,0 );
			    	String operator1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",14 ,1 );
			    	String value1=a[2];
			    	bp.waitForElement();
			    	actual[32]=tp.ZQLSearch1(name1, operator1, value1);
			    	actual[33]=tp.validateSearch();
			    	bp.waitForElement();
			    	actual[34]=tp.selectAllFreeFormTestCases();
				     bp.waitForElement();
				     //tp.clickOnCheckBoxSaveAllTestcases();
				     
				     bp.waitForElement();
				     actual[35]=tp.clickOnSaveAndOk();
				     
				     bp.waitForElement();
				 	actual[36]=tp.closeFreeFormPage();
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

	@Then("^User successfully search a testcases by id with different operators$")
	public void user_successfully_search_a_testcases_by_id_with_different_operators() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("User successfully search a testcases by id with different operators");
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
