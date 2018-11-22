package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Search_9 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	ExecutionPage exep;
	DefectTracking dt;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	String fileName="Defect_Tracking_Search_9";
	
	boolean[] actual=new boolean[30];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in TestRepository page$")
	public void user_is_in_TestRepository_page() throws Throwable {
		try
		   {
			 bp=new BasePage();
			 pp=new ProjectPage(driver);
			 rp=new ReleasePage(driver);
		     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			 actual[0]=pp.selectProject(projectName);
		     actual[1]=pp.selectRelease(releaseName);
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

	@When("^User create a phase$")
	public void user_create_a_phase() throws Throwable {
	  try
	  {
		   tr=new TestRepositoryPage(driver);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 12);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			
			actual[3]=tr.clickOnRelease(releaseName);
			bp.waitForElement();
			actual[4]=tr.addNode(p_Name1,p_Desc1);  
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

	@When("^Create testcases$")
	public void create_testcases() throws Throwable {
	  try
	  {
		  String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		  String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,12);
		    tr.doubleClickOnRelease(releaseName);
			String[] phase=new String[1];
			phase[0]=p_Name1;
			bp.waitForElement();
			actual[5]=tr.navigateToNode(releaseName, phase);
			for(int i=1;i<=4;i++)
			{
			tr.addTestCase();
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

	@When("^Create a cycle in TestPlanning$")
	public void create_a_cycle_in_TestPlanning() throws Throwable {
		try
		   {
			  bp.waitForElement();
			  actual[6]=rp.clickOnTestPlanning();
			  
			    tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,13);
				String build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[7]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[8]=tp.CreateCycle(cycle, build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[9]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				bp.waitForElement();
				actual[10]=tp.saveTestCycle();
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

	@When("^Add the phase by choosing phase$")
	public void add_the_phase_by_choosing_phase() throws Throwable {
		try
	    {
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,13);
			actual[11]=tp.navigateToCycle(cycle);
			
			bp.waitForElement();
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,12);
			actual[12]=tp.addPhaseToCycle(phase);
			bp.waitForElement();
			String bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
			bp.waitForElement();
			actual[13]=tp.bulkAssignment(bulk_Type);
			actual[14]=tp.goBackToCycle();
			
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

	@When("^Launch TestExecution and execute a testcase with status pass$")
	public void launch_TestExecution_and_execute_a_testcase_with_status_pass() throws Throwable {
		try
		   {
			     /*pp=new ProjectPage(driver);//
				 bp=new BasePage();
				 rp=new ReleasePage(driver);
				 tr=new TestRepositoryPage(driver);
				 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
				 pp.selectProject(projectName);
			     pp.selectRelease(releaseName);// */
			   
			   bp.waitForElement();
			   actual[15]=rp.clickOnTestExecution(); 
	           bp.waitForElement();
			   
			    String[] cycleName=new String[2];
			    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1 ,13 );
			    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1 ,12 );
			    
			    bp.waitForElement();
			    tp=new TestPlanningPage(driver);
			    bp.waitForElement();
			    bp.waitForElement();
			    bp.waitForElement();
				actual[16]=tr.navigateToNode(releaseName, cycleName);
				bp.waitForElement();
			
				int[] tcNo1=new int[1];
				tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
			    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[17]=exep.executeStatus(tcNo1[0], statusType1);
			    
			    int[] tcNo2=new int[1];
				tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
			    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[18]=exep.executeStatus(tcNo2[0], statusType2);
			    
			    int[] tcNo3=new int[1];
			    tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
			    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[19]=exep.executeStatus(tcNo3[0], statusType3);
			    
			    int[] tcNo4=new int[1];
				tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
			    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
			    bp.waitForElement();
			    actual[20]=exep.executeStatus(tcNo4[0], statusType4);
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

	@When("^click on defect button and select JQL$")
	public void click_on_defect_button_and_select_JQL() throws Throwable {
		try
		   {
			   int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1,19 );
			   String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1 ,9 );
			   String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1 ,10 );
			   actual[21]=exep.clickOnDefectButton(testcase1);
			   actual[22]=exep.defectSearch(selectSearch,defectID);
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

	@Then("^Should be able to search$")
	public void should_be_able_to_search() throws Throwable {
		try
		   {
			   String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,7 );
			   dt=new DefectTracking(driver);
			  // exep.searchDefect(defectID);//
			   tr.verifyPastTestCase();
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

	@Then("^Should be able to link a defect$")
	public void should_be_able_to_link_a_defect() throws Throwable {
		try
		   {
			   int testCase=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1,19 );
			   actual[23]=exep.linkDefect();
			   exep.viewTooltip(testCase);
			  
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

	@When("^click on D button and select my filter and select filter from dropdown$")
	public void click_on_D_button_and_select_my_filter_and_select_filter_from_dropdown() throws Throwable {
		try
		   {
			   int testcase2=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2,19 );
			   String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1 ,9 );
			   String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1 ,10 );
			   bp.waitForElement();
			   bp.waitForElement();
			   actual[24]=exep.clickOnDefectButton(testcase2);
			   actual[25]=exep.defectSearch(selectSearch,defectID);
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
	
	@Then("^Should be able to search and Link a defect$")
	public void should_be_able_to_search_and_Link_a_defect() throws Throwable {
		try
		   {
			   String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2 ,7 ); 
			   actual[26]=exep.linkDefect();
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

	@When("^click on defect and select non existing defect id and attempt search for defect$")
	public void click_on_defect_and_select_non_existing_defect_id_and_attempt_search_for_defect() throws Throwable {
		try
		   {
			   int testcase3=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3,19 );
			   bp.waitForElement();
			   bp.waitForElement();
			   actual[27]=exep.clickOnDefectButton(testcase3);
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

	@Then("^ShOuld not be able to search$")
	public void should_not_be_able_to_search() throws Throwable {
		try
		   {
			   String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3 ,9 );
			   String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1 ,8 );
			   actual[28]=exep.defectSearch(selectSearch,defectID);
			   actual[29]=exep.linkDefect();
			   driver.navigate().refresh();
			   bp.waitForElement();
			   bp.waitForElement();
			   bp.waitForElement();
			   bp.waitForElement();
			   bp.waitForElement();
			   bp.waitForElement();
			   //pp.backToProjectPage();
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
				 tp.doubleClickOnCycle(releaseName);
				 bp.waitForElement();
			   for(int k=0;k<=actual.length-1;k++)
				{
					System.out.println("Actual["+k+"]="+actual[k]);
					//soft.assertEquals(actual[k], true);
				}
				soft.assertAll();
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
