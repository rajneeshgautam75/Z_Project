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

public class Search_Browse_868192 extends LaunchBrowser{

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
	String fileName="Search_868192";
	
	boolean[] actual=new boolean[140];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in a page of tHe TestRepository$")
	public void user_is_in_a_page_of_tHe_TestRepository() throws Throwable {
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

	@When("^User creates a phase with all available fields$")
	public void user_creates_a_phase_with_all_available_fields() throws Throwable {
		try
	    {
				tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 1, 0);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 1, 3);
				
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
				tags1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 2, 2);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[8]=ctc.enterMultipletags(tags1);
				bp.waitForElement();
				
				ctc=new CreateTestCasePage(driver);
				String tcName=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 1, 0);
				String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"Search_868221" , 1, 1);
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
				stepDetail[0]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 1, 6);
				stepDetail[1]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 1, 7);
				stepDetail[2]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 1, 8);
				stepDetail[3]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 2, 6);
				stepDetail[4]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 2, 7);
				stepDetail[5]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 2, 8);
				stepDetail[6]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 3, 6);
				stepDetail[7]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 3, 7);
				stepDetail[8]=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 3, 8);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[11]=ctc.enterTestCaseStepDetail(stepDetail);
				bp.waitForElement();
				
				bp.waitForElement();
				ctc.customFieldOption.click();
				
				String text=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 1, 3);
				String longText=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 2, 3);
				String number=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Search_868221", 0, 3));
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

	@When("^User creates a phase p(\\d+) and create system and subsystem and add testcases in system and subsystem$")
	public void user_creates_a_phase_p_and_create_system_and_subsystem_and_add_testcases_in_system_and_subsystem(int arg1) throws Throwable {
	   try
	   {
		   bp.waitForElement();
		   tr.clickOnList();
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
		   bp.waitForElement();
		   actual[13]=tr.clickOnRelease(releaseName);
	    	 String p_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 2, 0);
	    	  String p_Desc2=Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 2, 3);
	    	  actual[14]=tr.addNode(p_Name2, p_Desc2);
	    	  tr.doubleClickOnRelease(releaseName);
	    	  actual[15]=tr.selectPhase(p_Name2);
	    	  
	    	  bp.waitForElement();
		    	 tr.clickOnRelease(releaseName);
		    	 String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 1, 1);
		    	  String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 1, 4);
		    	  actual[16]=tr.selectPhase(p_Name2);
		    	  actual[17]=tr.addNode(s_Name1, s_Desc1);
		    	  tr.doubleClickOnRelease(releaseName);
		    	  String[] str1=new String[2];
		    	  str1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 2,0 );
		    	  str1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 1, 1);
		    	  actual[18]=tr.navigateToNode(releaseName, str1);
		    	 tr.addTestCase();
		    	 
		    	 bp.waitForElement();
		    	 tr.clickOnRelease(releaseName);
		    	 String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 1, 2);
		    	  String ss_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 1, 5);
		    	  actual[19]=tr.selectPhase(s_Name1);
		    	  actual[20]=tr.addNode(ss_Name1, ss_Desc1);
		    	  tr.doubleClickOnRelease(releaseName);
		    	  //actual[21]=tr.selectPhase(ss_Name1);
		    	  String[] str2=new String[3];
		    	  str2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 2, 0);
		    	  str2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 1, 1);
		    	  str2[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 1, 2);
		    	  actual[21]=tr.navigateToNode(releaseName, str2);
		    	 tr.addTestCase();
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

	@When("^User Launch TestPlanning and creates a first cycle$")
	public void user_Launch_TestPlanning_and_creates_a_first_cycle() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[22]=rp.clickOnTestPlanning();
			  bp.waitForElement();
//				rp.clickOnTestPlanning();
//				bp.waitForElement();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 1, 6);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[23]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[24]=tp.CreateCycle(cycle1, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[25]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[26]=tp.saveTestCycle();
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

	@When("^User clicks on cycle context menu and creates a freefoRm phase$")
	public void user_clicks_on_cycle_context_menu_and_creates_a_freefoRm_phase() throws Throwable {
		try
	    {
			actual[27]=bp.waitForElement();
			//actual[27]=rp.clickOnTestPlanning();
			
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 1, 6);
			bp.waitForElement();
			actual[28]=tp.navigateToCycle(cycle);
			
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 2, 0);
			actual[29]=tp.createFreeFormPhase(phaseName);
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

	@When("^User clicks on Add testcase window and Launches a Browse window$")
	public void user_clicks_on_Add_testcase_window_and_Launches_a_Browse_window() throws Throwable {
		try
	    {
	    	String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192",2 ,0 );
		     bp.waitForElement();
		     actual[30]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[31]=tp.clickOnAddTestcasesToFreeForm();
		     
		     bp.waitForElement();
		     actual[32]=tp.clickOnBrowse();
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

	@When("^User expands release node upto subsystem and select checkbox at phase level and save$")
	public void user_expands_release_node_upto_subsystem_and_select_checkbox_at_phase_level_and_save() throws Throwable {
	    try
	    {
	    	//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
	    	tp=new TestPlanningPage(driver);
	    	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
	    	bp.waitForElement();
	    	tp.doubleClickOnCycle(releaseName);
	    	bp.waitForElement();
	    	
	    	String[] nodes=new String[3];
	    	nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 2, 0);
	    	nodes[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 1, 1);
	    	nodes[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 1, 2);
	    	tr=new TestRepositoryPage(driver);
	    	bp.waitForElement();
	    	bp.waitForElement();
	    	bp.waitForElement();
	    	actual[33]=tr.navigateNode(nodes);
	    	bp.waitForElement();
	    	
	    	tr=new TestRepositoryPage(driver);
			   String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 2, 0);
			   bp.waitForElement();
			   actual[34]=tr.selectPhase(p_Name1);
			   String NodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192",2 ,0 );
			   actual[35]=tp.clickOnChecKBox(NodeName);
			   bp.waitForElement();
			   
			   actual[36]=tp.clickOnSaveAndOk();
			   bp.waitForElement();
			   
			   actual[37]=tp.closeFreeFormPage();
			   bp.waitForElement();
			   bp.waitForElement();
			 	tp.selectallTestCase();
			 	bp.waitForElement();
			 	String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
			 	tp.assignAllSelected(assignee);
			 	bp.waitForElement();
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

	@When("^User Launch TestRepository and creates a phase$")
	public void user_Launch_TestRepository_and_creates_a_phase() throws Throwable {
	    try
	    {
	    	bp.waitForElement();
	    	rp.clickOnTestRep();
	    	
	    	tr=new TestRepositoryPage(driver);
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
			String p_Name3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 3, 0);
			String p_Desc3=Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 3, 3);
			
			bp=new BasePage();
			actual[38]=tr.doubleClickOnRelease(releaseName);
			 bp.waitForElement();
			actual[39]=tr.addNode(p_Name3,p_Desc3);
	    	
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

	@When("^User creates a multiple systems and add testcases at all levels$")
	public void user_creates_a_multiple_systems_and_add_testcases_at_all_levels() throws Throwable {
	    try
	    {
	    	bp.waitForElement();
			   String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
			   bp.waitForElement();
			   actual[40]=tr.doubleClickOnRelease(releaseName);
			   String p_Name3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192",3 , 0);
		    	 String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 2, 1);
		    	  String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 2, 4);
		    	  //actual[41]=tr.selectPhase(p_Name3);
		    	  String[] str1=new String[1];
		    	  str1[0]=p_Name3;
		    	  //str2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 1, 1);
		    	  //str2[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 1, 2);
		    	  actual[41]=tr.navigateToNode(releaseName, str1);
		    	  actual[42]=tr.addNode(s_Name1, s_Desc1);
		    	 actual[43]=tr.doubleClickOnRelease(releaseName);
		    	 String[] str2=new String[2];
		    	  str2[0]=p_Name3;
		    	  str2[1]=s_Name1;
		    	  actual[44]=tr.navigateToNode(releaseName, str2);
		    	 tr.addTestCase();
		    	 
		    	 bp.waitForElement();
		    	 tr.clickOnRelease(releaseName);
		    	 String s_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 3, 1);
		    	  String s_Desc2=Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 3, 4);
		    	  tr.selectPhase(s_Name1);
		    	  actual[45]=tr.addNode(s_Name2, s_Desc2);
		    	  tr.doubleClickOnRelease(releaseName);
		    	  String[] str3=new String[3];
		    	  str3[0]=p_Name3;
		    	  str3[1]=s_Name1;
		    	  str3[2]=s_Name2;
		    	  //tr.navigateToNode(releaseName, str2);
		    	  actual[46]=tr.navigateToNode(releaseName, str3);
		    	  //actual[46]=tr.selectPhase(s_Name2);
		    	 tr.addTestCase();
		    	 
		    	 bp.waitForElement();
		    	 tr.clickOnRelease(releaseName);
		    	 String s_Name3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 4, 1);
		    	  String s_Desc3=Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 4, 4);
		    	  actual[47]=tr.selectPhase(s_Name2);
		    	  actual[47]=tr.addNode(s_Name3, s_Desc3);
		    	  actual[48]=tr.doubleClickOnRelease(releaseName);
		    	  String[] str4=new String[4];
		    	  str4[0]=p_Name3;
		    	  str4[1]=s_Name1;
		    	  str4[2]=s_Name2;
		    	  str4[3]=s_Name3;
		    	  //tr.navigateToNode(releaseName, str2);
		    	  actual[49]=tr.navigateToNode(releaseName, str4);
		    	  //actual[49]=tr.selectPhase(s_Name3);
		    	 tr.addTestCase();
		    	 
		    	 bp.waitForElement();
		    	 tr.clickOnRelease(releaseName);
		    	 String s_Name4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 5, 1);
		    	  String s_Desc4=Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 5, 4);
		    	  tr.selectPhase(s_Name3);
		    	  actual[50]=tr.addNode(s_Name4, s_Desc4);
		    	  actual[51]=tr.doubleClickOnRelease(releaseName);
		    	  //actual[52]=tr.selectPhase(s_Name4);
		    	  String[] str5=new String[5];
		    	  str5[0]=p_Name3;
		    	  str5[1]=s_Name1;
		    	  str5[2]=s_Name2;
		    	  str5[3]=s_Name3;
		    	  str5[4]=s_Name4;
		    	  actual[52]=tr.navigateToNode(releaseName, str5);
		    	 tr.addTestCase();
		    	 
		    	 bp.waitForElement();
		    	 tr.clickOnRelease(releaseName);
		    	 String s_Name5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 6, 1);
		    	  String s_Desc5=Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 6, 4);
		    	 tr.selectPhase(s_Name4);
		    	  actual[53]=tr.addNode(s_Name5, s_Desc5);
		    	  actual[54]=tr.doubleClickOnRelease(releaseName);
		    	  String[] str6=new String[6];
		    	  str6[0]=p_Name3;
		    	  str6[1]=s_Name1;
		    	  str6[2]=s_Name2;
		    	  str6[3]=s_Name3;
		    	  str6[4]=s_Name4;
		    	  str6[5]=s_Name5;
		    	  //actual[55]=tr.selectPhase(s_Name5);
		    	  actual[55]=tr.navigateToNode(releaseName, str6);
		    	 tr.addTestCase();
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

	@When("^User Launch TestPlanning and creates a second cycle$")
	public void user_Launch_TestPlanning_and_creates_a_second_cycle() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[56]=rp.clickOnTestPlanning();
			  bp.waitForElement();
//				rp.clickOnTestPlanning();
//				bp.waitForElement();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 2, 6);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[57]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[58]=tp.CreateCycle(cycle2, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[59]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[60]=tp.saveTestCycle();
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

	@When("^User clicks on cycle context menu and creates a fReeform phase$")
	public void user_clicks_on_cycle_context_menu_and_creates_a_fReeform_phase() throws Throwable {
		try
	    {
			actual[61]=bp.waitForElement();
			//actual[61]=rp.clickOnTestPlanning();
			
	    	String[] cycle2=new String[1];
			cycle2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 2, 6);
			actual[62]=tp.navigateToCycle(cycle2);
			
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 3, 0);
			actual[63]=tp.createFreeFormPhase(phaseName);
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

	@When("^User clicks on Add testcase window and Launch Browse window$")
	public void user_clicks_on_Add_testcase_window_and_Launch_Browse_window() throws Throwable {
		try
	    {
	    	String[] cycleName2=new String[1];
		     cycleName2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192",3 ,0 );
		     bp.waitForElement();
		     actual[64]=tp.navigateToCycle(cycleName2);
		     
		     bp.waitForElement();
		     actual[65]=tp.clickOnAddTestcasesToFreeForm();
		     
		     bp.waitForElement();
		     actual[66]=tp.clickOnBrowse();
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

	@When("^User expands release node upto all the system levels and selects the checkbox at phase level and save$")
	public void user_expands_release_node_upto_all_the_system_levels_and_selects_the_checkbox_at_phase_level_and_save() throws Throwable {
		try
	    {
			tp=new TestPlanningPage(driver);
	    	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
	    	bp.waitForElement();
	    	tp.doubleClickOnCycle(releaseName);
	    	bp.waitForElement();
	    	
	    	String[] nodes=new String[6];
	    	nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 3, 0);
	    	nodes[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 2, 1);
	    	nodes[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 3, 1);
	    	nodes[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 4, 1);
	    	nodes[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 5, 1);
	    	nodes[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 6, 1);
	    	tr=new TestRepositoryPage(driver);
	    	bp.waitForElement();
	    	actual[67]=tr.navigateNode(nodes);	
	    	
	    	tr=new TestRepositoryPage(driver);
			   String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 3, 0);
			   bp.waitForElement();
			   actual[68]=tr.selectPhase(p_Name1);
			   String NodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192",3 ,0 );
			   actual[69]=tp.clickOnChecKBox(NodeName);
			   bp.waitForElement();
			   
			   actual[70]=tp.clickOnSaveAndOk();
			   bp.waitForElement();
			   
			   actual[71]=tp.closeFreeFormPage();
			   bp.waitForElement();
			   bp.waitForElement();
			 	tp.selectallTestCase();
			 	bp.waitForElement();
			 	String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
			 	tp.assignAllSelected(assignee);
			 	bp.waitForElement();
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

	@When("^User Launch TestRepository and creates a phase,system and multiple subsystems and add testcases at all levels$")
	public void user_Launch_TestRepository_and_creates_a_phase_system_and_multiple_subsystems_and_add_testcases_at_all_levels() throws Throwable {
		try
	    {
			bp.waitForElement();
			rp.clickOnTestRep();
			
	    	bp.waitForElement();
			   tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 4, 0);
				String p_Desc4=Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 4, 3);
				
				bp=new BasePage();
				actual[72]=tr.doubleClickOnRelease(releaseName);
				 bp.waitForElement();
				actual[73]=tr.addNode(p_Name4,p_Desc4);
				bp.waitForElement();
				tr.doubleClickOnRelease(releaseName);
				String[] str1=new String[1];
		    	  str1[0]=p_Name4;
		    	  actual[74]=tr.navigateToNode(releaseName, str1);
			   //actual[74]=tr.clickOnRelease(releaseName);
		    	 String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 7, 1);
		    	  String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 7, 3);
		    	  //actual[75]=tr.selectPhase(p_Name4);
		    	  actual[75]=tr.addNode(s_Name1, s_Desc1);
		    	  actual[76]=tr.doubleClickOnRelease(releaseName);
		    	  String[] str2=new String[2];
		    	  str2[0]=p_Name4;
		    	  str2[1]=s_Name1;
		    	  actual[77]=tr.navigateToNode(releaseName, str2);
		    	 //actual[77]=tr.selectPhase(s_Name1);
		    	 tr.addTestCase();
		    	 
		    	 bp.waitForElement();
		    	 tr.clickOnRelease(releaseName);
		    	 String ss_Name3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 4, 2);
		    	  String ss_Desc3=Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 4, 5);
		    	  actual[78]=tr.selectPhase(s_Name1);
		    	  actual[79]=tr.addNode(ss_Name3, ss_Desc3);
		    	  tr.doubleClickOnRelease(releaseName);
		    	  String[] str3=new String[3];
		    	  str3[0]=p_Name4;
		    	  str3[1]=s_Name1;
		    	  str3[2]=ss_Name3;
		    	  actual[80]=tr.navigateToNode(releaseName, str3);
		    	  //actual[80]=tr.selectPhase(ss_Name3);
		    	 tr.addTestCase();
		    	 
		    	 bp.waitForElement();
		    	 tr.clickOnRelease(releaseName);
		    	 String ss_Name4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 5, 2);
		    	  String ss_Desc4=Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 5, 5);
		    	  actual[81]=tr.selectPhase(ss_Name3);
		    	  //actual[81]=tr.doubleClickOnRelease(releaseName);
		    	  actual[82]=tr.addNode(ss_Name4, ss_Desc4);
		    	  String[] str4=new String[4];
		    	  str4[0]=p_Name4;
		    	  str4[1]=s_Name1;
		    	  str4[2]=ss_Name3;
		    	  str4[3]=ss_Name4;
		    	  actual[83]=tr.navigateToNode(releaseName, str4);
		    	  //actual[83]=tr.selectPhase(ss_Name4);
		    	 tr.addTestCase();
		    	 
		    	 bp.waitForElement();
		    	 tr.clickOnRelease(releaseName);
		    	 String ss_Name5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 6, 2);
		    	  String ss_Desc5=Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 6, 5);
		    	  tr.selectPhase(ss_Name4);
		    	  actual[84]=tr.addNode(ss_Name5, ss_Desc5);
		    	  actual[85]=tr.doubleClickOnRelease(releaseName);
		    	  String[] str5=new String[5];
		    	  str5[0]=p_Name4;
		    	  str5[1]=s_Name1;
		    	  str5[2]=ss_Name3;
		    	  str5[3]=ss_Name4;
		    	  str5[4]=ss_Name5;
		    	  actual[86]=tr.navigateToNode(releaseName, str5);
		    	 tr.addTestCase();
		    	 
		    	 bp.waitForElement();
		    	 tr.clickOnRelease(releaseName);
		    	 String ss_Name6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 7, 2);
		    	  String ss_Desc6=Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 7, 5);
		    	  tr.selectPhase(ss_Name5);
		    	  actual[87]=tr.addNode(ss_Name6, ss_Desc6);
		    	  actual[88]=tr.doubleClickOnRelease(releaseName);
		    	  String[] str6=new String[6];
		    	  str6[0]=p_Name4;
		    	  str6[1]=s_Name1;
		    	  str6[2]=ss_Name3;
		    	  str6[3]=ss_Name4;
		    	  str6[4]=ss_Name5;
		    	  str6[5]=ss_Name6;
		    	  actual[89]=tr.navigateToNode(releaseName, str6);
		    	 tr.addTestCase();
		    	 
		    	 bp.waitForElement();
		    	 tr.clickOnRelease(releaseName);
		    	 String ss_Name7=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 8, 2);
		    	  String ss_Desc7=Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 8, 5);
		    	  tr.selectPhase(ss_Name6);
		    	  actual[90]=tr.addNode(ss_Name7, ss_Desc7);
		    	  actual[91]=tr.doubleClickOnRelease(releaseName);
		    	  String[] str7=new String[7];
		    	  str7[0]=p_Name4;
		    	  str7[1]=s_Name1;
		    	  str7[2]=ss_Name3;
		    	  str7[3]=ss_Name4;
		    	  str7[4]=ss_Name5;
		    	  str7[5]=ss_Name6;
		    	  str7[6]=ss_Name7;
		    	  actual[92]=tr.navigateToNode(releaseName, str7);
		    	 tr.addTestCase();
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

	@When("^User Launch TestPlanning and creates a third cycle$")
	public void user_Launch_TestPlanning_and_creates_a_third_cycle() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[93]=rp.clickOnTestPlanning();
			  bp.waitForElement();
				bp.waitForElement();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 3, 6);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[94]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[95]=tp.CreateCycle(cycle3, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[96]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[97]=tp.saveTestCycle();
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

	@When("^User clicks on cycle context menu and creates a frEeform phase$")
	public void user_clicks_on_cycle_context_menu_and_creates_a_frEeform_phase() throws Throwable {
		try
	    {
			actual[98]=bp.waitForElement();
			//actual[98]=rp.clickOnTestPlanning();
			
	    	String[] cycle3=new String[1];
			cycle3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 3, 6);
			bp.waitForElement();
			actual[99]=tp.navigateToCycle(cycle3);
			
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 4, 0);
			actual[100]=tp.createFreeFormPhase(phaseName);
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
	
	@Given("^User clicks on Add testcase window and Launch Browse window option$")
	public void user_clicks_on_Add_testcase_window_and_Launch_Browse_window_option() throws Throwable {
		try
	    {
			String[] cycleName3=new String[1];
		     cycleName3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192",4 ,0 );
		     bp.waitForElement();
		     actual[101]=tp.navigateToCycle(cycleName3);
		     
		     bp.waitForElement();
		     actual[102]=tp.clickOnAddTestcasesToFreeForm();
		     
		     bp.waitForElement();
		    	actual[103]=tp.clickOnBrowse();
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

	@When("^User expands release node upto subsystem levels and selects the checkbox at phase level and save$")
	public void user_expands_release_node_upto_subsystem_levels_and_selects_the_checkbox_at_phase_level_and_save() throws Throwable {
		try
	    {
		    	
			tp=new TestPlanningPage(driver);
	    	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
	    	bp.waitForElement();
	    	tp.doubleClickOnCycle(releaseName);
	    	bp.waitForElement();
		    	
		    	String[] nodes=new String[7];
		    	nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 4, 0);
		    	nodes[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 7, 1);
		    	nodes[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 4, 2);
		    	nodes[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 5, 2);
		    	nodes[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 6, 2);
		    	nodes[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 7, 2);
		    	nodes[6]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 8, 2);
		    	tr=new TestRepositoryPage(driver);
		    	bp.waitForElement();
		    	actual[104]=tr.navigateNode(nodes);
		    	
				   String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 4, 0);
				   bp.waitForElement();
				   actual[105]=tr.selectPhase(p_Name1);
				   String NodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192",4 ,0 );
				   actual[106]=tp.clickOnChecKBox(NodeName);
				   bp.waitForElement();
				   
				   actual[107]=tp.clickOnSaveAndOk();
				   bp.waitForElement();
				   
				   actual[108]=tp.closeFreeFormPage();
				   bp.waitForElement();
				   bp.waitForElement();
				 	tp.selectallTestCase();
				 	bp.waitForElement();
				 	String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
				 	tp.assignAllSelected(assignee);
				 	bp.waitForElement();
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

	@When("^User Launch TestRepository and creates multiple phases and add testcases at all levels$")
	public void user_Launch_TestRepository_and_creates_multiple_phases_and_add_testcases_at_all_levels() throws Throwable {
		try
	    {
			bp.waitForElement();
			rp.clickOnTestRep();
			
	    	bp.waitForElement();
			   tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 6, 0);
				String p_Desc5=Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 6, 3);
				
				bp=new BasePage();
				actual[109]=tr.doubleClickOnRelease(releaseName);
				 bp.waitForElement();
				actual[110]=tr.addNode(p_Name5,p_Desc5);
				bp.waitForElement();
				String[] str1=new String[1];
		    	  str1[0]=p_Name5;
		    	  actual[111]=tr.navigateToNode(releaseName, str1);
			   //actual[111]=tr.clickOnRelease(releaseName);
		    	 String p_Name6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 7, 0);
		    	  String p_Desc6=Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 7, 3);
		    	 // actual[112]=tr.selectPhase(p_Name5);
		    	  //
		    	  actual[112]=tr.addNode(p_Name6, p_Desc6);
		    	  actual[113]=tr.doubleClickOnRelease(releaseName);
		    	  String[] str2=new String[2];
		    	  str2[0]=p_Name5;
		    	  str2[1]=p_Name6;
		    	  actual[114]=tr.navigateToNode(releaseName, str2);
		    	 //actual[114]=tr.selectPhase(p_Name6);
		    	 tr.addTestCase();
		    	 
		    	 bp.waitForElement();
		    	 tr.clickOnRelease(releaseName);
		    	 String p_Name7=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 8, 0);
		    	  String p_Desc7=Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 8, 3);
		    	  tr.selectPhase(p_Name6);
		    	  actual[115]=tr.addNode(p_Name7, p_Desc7);
		    	  actual[116]=tr.doubleClickOnRelease(releaseName);
		    	  String[] str3=new String[3];
		    	  str3[0]=p_Name5;
		    	  str3[1]=p_Name6;
		    	  str3[2]=p_Name7;
		    	  actual[117]=tr.navigateToNode(releaseName, str3);
		    	  //actual[117]=tr.selectPhase(p_Name7);
		    	 tr.addTestCase();
		    	 
		    	 bp.waitForElement();
		    	 tr.clickOnRelease(releaseName);
		    	 String p_Name8=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 9, 0);
		    	  String p_Desc8=Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 9, 3);
		    	  tr.selectPhase(p_Name7);
		    	  actual[118]=tr.addNode(p_Name8, p_Desc8);
		    	  actual[119]=tr.doubleClickOnRelease(releaseName);
		    	  String[] str4=new String[4];
		    	  str4[0]=p_Name5;
		    	  str4[1]=p_Name6;
		    	  str4[2]=p_Name7;
		    	  str4[3]=p_Name8;
		    	  actual[120]=tr.navigateToNode(releaseName, str4);
		    	  //actual[120]=tr.selectPhase(p_Name8);
		    	 tr.addTestCase();
		    	 
		    	 bp.waitForElement();
		    	 tr.clickOnRelease(releaseName);
		    	 String p_Name9=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 10, 0);
		    	  String p_Desc9=Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 10, 3);
		    	  tr.selectPhase(p_Name8);
		    	  actual[121]=tr.addNode(p_Name9, p_Desc9);
		    	  actual[122]=tr.doubleClickOnRelease(releaseName);
		    	  String[] str5=new String[5];
		    	  str5[0]=p_Name5;
		    	  str5[1]=p_Name6;
		    	  str5[2]=p_Name7;
		    	  str5[3]=p_Name8;
		    	  str5[4]=p_Name9;
		    	  actual[123]=tr.navigateToNode(releaseName, str5);
		    	  //actual[123]=tr.selectPhase(p_Name9);
		    	 tr.addTestCase();
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

	@When("^User Launch TestPlanning and creates a fourth cycle$")
	public void user_Launch_TestPlanning_and_creates_a_fourth_cycle() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[124]=rp.clickOnTestPlanning();
				bp.waitForElement();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 4, 6);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[125]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[126]=tp.CreateCycle(cycle4, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[127]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[128]=tp.saveTestCycle();
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

	@When("^User clicks on cycle context menu and creates a freeforM phase$")
	public void user_clicks_on_cycle_context_menu_and_creates_a_freeforM_phase() throws Throwable {
		try
	    {
			/*bp.waitForElement();
			actual[129]=rp.clickOnTestPlanning();
			//bp.waitForElement();
			//rp.clickOnTestPlanning();*/
			
	    	String[] cycle4=new String[1];
			cycle4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 4, 6);
			bp.waitForElement();
			actual[129]=tp.navigateToCycle(cycle4);
			
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 6, 0);
			actual[130]=tp.createFreeFormPhase(phaseName);
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
	
	@Given("^User clicks on the Add testcase window and Launch Browse window$")
	public void user_clicks_on_the_Add_testcase_window_and_Launch_Browse_window() throws Throwable {
	    try
	    {
	    	String[] cycleName4=new String[1];
		     cycleName4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192",6 ,0 );
		     bp.waitForElement();
		     actual[131]=tp.navigateToCycle(cycleName4);
		     
		     bp.waitForElement();
		     actual[132]=tp.clickOnAddTestcasesToFreeForm();
		     
		     bp.waitForElement();
		    	actual[133]=tp.clickOnBrowse();
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

	@When("^User expands release node upto all phases and selects the checkbox at phase level and save$")
	public void user_expands_release_node_upto_all_phases_and_selects_the_checkbox_at_phase_level_and_save() throws Throwable {
		try
		{
		    	
			tp=new TestPlanningPage(driver);
	    	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
	    	bp.waitForElement();
	    	actual[134]=tp.doubleClickOnCycle(releaseName);
	    	bp.waitForElement();
		    	
		    	String[] nodes=new String[5];
		    	nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 6, 0);
		    	nodes[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 7, 0);
		    	nodes[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 8, 0);
		    	nodes[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 9, 0);
		    	nodes[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 10, 0);
		  
		    	tr=new TestRepositoryPage(driver);
		    	bp.waitForElement();
		    	actual[135]=tr.navigateNode(nodes);
		    	
				   String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192", 6, 0);
				   bp.waitForElement();
				   actual[136]=tr.selectPhase(p_Name1);
				   String NodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search_868192",6 ,0 );
				   actual[137]=tp.clickOnChecKBox(NodeName);
				   bp.waitForElement();
				   
				   actual[138]=tp.clickOnSaveAndOk();
				   bp.waitForElement();
				   
				   actual[139]=tp.closeFreeFormPage();
				   bp.waitForElement();
				   
				   bp.waitForElement();
				 	tp.selectallTestCase();
				 	bp.waitForElement();
				 	String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
				 	tp.assignAllSelected(assignee);
				 	bp.waitForElement();
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

	@Then("^All the testcases should be added to the free form phase$")
	public void all_the_testcases_should_be_added_to_the_free_form_phase() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("All the testcases should be added to the free form phase");
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
