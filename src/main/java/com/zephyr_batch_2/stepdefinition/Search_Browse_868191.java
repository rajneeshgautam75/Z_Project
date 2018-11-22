package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Search_Browse_868191 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	ExportPage ep;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	RequirementsPage req;
	String fileName="Search_868191";
	
	boolean[] actual=new boolean[51];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User Launches testRepository$")
	public void user_Launches_testRepository() throws Throwable {
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

	@When("^User creates a phase and creates a testcase with the available fields under phase$")
	public void user_creates_a_phase_and_creates_a_testcase_with_the_available_fields_under_phase() throws Throwable {
		try
	    {
					tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 1);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 9);
				
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
				
				/*String[] tags4=new String[1];
				tags4[0]=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 2, 3);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[8]=ctc.enterMultipleTags(tags4);
				bp.waitForElement();*/
				
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

	@When("^User creates a system under thE phase and Adds testcase$")
	public void user_creates_a_system_under_thE_phase_and_Adds_testcase() throws Throwable {
	    try
	    {	bp.waitForElement();
	    	actual[11]=tr.clickOnList();
	    	bp.waitForElement();
	    	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
	    	 actual[12]=tr.clickOnRelease(releaseName);
	    	 bp.waitForElement();
	    	 String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 1);
	    	 String s_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 2);
	    	  String s_Desc2=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 10);
	    	  bp.waitForElement();
	    	  actual[13]=tr.selectPhase(p_Name1);
	    	  bp.waitForElement();
	    	  actual[14]=tr.addNode(s_Name2, s_Desc2);
	    	  bp.waitForElement();
	    	  String[] sys=new String[2];
	    	  sys[0]=p_Name1;
	    	  sys[1]=s_Name2;
	    	  actual[15]=tr.navigateToNode(releaseName, sys);
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

	@When("^User creates a phases upto (\\d+)th deep level and Adds testcases at all levels$")
	public void user_creates_a_phases_upto_th_deep_level_and_Adds_testcases_at_all_levels(int arg1) throws Throwable {
	   try
	   {	bp.waitForElement();
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0); 
		   actual[16]=tr.clickOnRelease(releaseName);
		   bp.waitForElement();
		   String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 1);
	    	 String s_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 2);
	    	 String s_Name3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 3);
	    	  String s_Desc3=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 11);
	    	  actual[17]=tr.selectPhase(s_Name2);
	    	  actual[18]=tr.addNode(s_Name3, s_Desc3);
	    	  bp.waitForElement();
	    	  String[] sys2=new String[3];
	    	  sys2[0]=p_Name1;
	    	  sys2[1]=s_Name2;
	    	  sys2[2]=s_Name3;
	    	  actual[19]=tr.navigateToNode(releaseName, sys2);
	    	 //actual[19]=tr.selectPhase(s_Name3);
	    	 tr.addTestCase();
	    	 
	    	 bp.waitForElement();
	    	 tr.clickOnRelease(releaseName);
	    	 String s_Name4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 4);
	    	  String s_Desc4=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 12);
	    	  actual[20]=tr.selectPhase(s_Name3);
	    	  actual[21]=tr.addNode(s_Name4, s_Desc4);
	    	  bp.waitForElement();
	    	  String[] sys3=new String[4];
	    	  sys3[0]=p_Name1;
	    	  sys3[1]=s_Name2;
	    	  sys3[2]=s_Name3;
	    	  sys3[3]=s_Name4;
	    	  actual[22]=tr.navigateToNode(releaseName, sys3);
	    	 tr.addTestCase();
	    	 
	    	 bp.waitForElement();
	    	 tr.clickOnRelease(releaseName);
	    	 String s_Name5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 5);
	    	  String s_Desc5=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 13);
	    	  actual[23]=tr.selectPhase(s_Name4);
	    	  actual[24]=tr.addNode(s_Name5, s_Desc5);
	    	  bp.waitForElement();
	    	  String[] sys4=new String[5];
	    	  sys4[0]=p_Name1;
	    	  sys4[1]=s_Name2;
	    	  sys4[2]=s_Name3;
	    	  sys4[3]=s_Name4;
	    	  sys4[4]=s_Name5;
	    	  actual[25]=tr.navigateToNode(releaseName, sys4);
	    	 tr.addTestCase();
	    	 
	    	 bp.waitForElement();
	    	 tr.clickOnRelease(releaseName);
	    	 String s_Name6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 6);
	    	  String s_Desc6=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 14);
	    	  actual[26]=tr.selectPhase(s_Name5);
	    	  actual[27]=tr.addNode(s_Name6, s_Desc6);
	    	  bp.waitForElement();
	    	  String[] sys5=new String[6];
	    	  sys5[0]=p_Name1;
	    	  sys5[1]=s_Name2;
	    	  sys5[2]=s_Name3;
	    	  sys5[3]=s_Name4;
	    	  sys5[4]=s_Name5;
	    	  sys5[5]=s_Name6;
	    	  actual[28]=tr.navigateToNode(releaseName, sys5);
	    	 tr.addTestCase();
	    	 
	    	 bp.waitForElement();
	    	 tr.clickOnRelease(releaseName);
	    	 String s_Name7=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 7);
	    	  String s_Desc7=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 15);
	    	  actual[29]=tr.selectPhase(s_Name6);
	    	  actual[30]=tr.addNode(s_Name7, s_Desc7);
	    	  bp.waitForElement();
	    	  String[] sys6=new String[7];
	    	  sys6[0]=p_Name1;
	    	  sys6[1]=s_Name2;
	    	  sys6[2]=s_Name3;
	    	  sys6[3]=s_Name4;
	    	  sys6[4]=s_Name5;
	    	  sys6[5]=s_Name6;
	    	  sys6[6]=s_Name7;
	    	  actual[31]=tr.navigateToNode(releaseName, sys6);
	    	 tr.addTestCase();
	    	 
	    	 bp.waitForElement();
	    	 tr.clickOnRelease(releaseName);
	    	 String s_Name8=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 8);
	    	  String s_Desc8=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 16);
	    	  actual[32]=tr.selectPhase(s_Name7);
	    	  actual[33]=tr.addNode(s_Name8, s_Desc8);
	    	  bp.waitForElement();
	    	  String[] sys7=new String[8];
	    	  sys7[0]=p_Name1;
	    	  sys7[1]=s_Name2;
	    	  sys7[2]=s_Name3;
	    	  sys7[3]=s_Name4;
	    	  sys7[4]=s_Name5;
	    	  sys7[5]=s_Name6;
	    	  sys7[6]=s_Name7;
	    	  sys7[7]=s_Name8;
	    	  actual[34]=tr.navigateToNode(releaseName, sys7);
	    	 tr.addTestCase();  
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

	@When("^User launches testpLanning and creates a cycle$")
	public void user_launches_testpLanning_and_creates_a_cycle() throws Throwable {
		try
		   {
			bp=new BasePage();
			bp.waitForElement();
			  actual[35]=rp.clickOnTestPlanning();
			  bp.waitForElement();
//			  rp.clickOnTestPlanning();
//			  bp.waitForElement();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[36]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[37]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[38]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[39]=tp.saveTestCycle();
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

	@When("^User clicks on context menu across cycle and creates a new free form phase and save$")
	public void user_clicks_on_context_menu_across_cycle_and_creates_a_new_free_form_phase_and_save() throws Throwable {
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
			
			actual[40]=bp.waitForElement();
			//actual[40]=rp.clickOnTestPlanning();
			bp.waitForElement();
			
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 0);
			bp.waitForElement();
			actual[41]=tp.navigateToCycle(cycle);
			
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 1);
			actual[42]=tp.createFreeFormPhase(phaseName);
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

	@When("^User clicks on Add testCase window and launches a search operation$")
	public void user_clicks_on_Add_testCase_window_and_launches_a_search_operation() throws Throwable {
	    try
	    {
	    	String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",14 ,1 );
		     bp.waitForElement();
		     actual[43]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[44]=tp.clickOnAddTestcasesToFreeForm();
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

	@When("^User launches Browse window and expands release upto (\\d+)th level$")
	public void user_launches_Browse_window_and_expands_release_upto_th_level(int arg1) throws Throwable {
	    try
	    {	bp.waitForElement();
	    	actual[45]=tp.clickOnBrowse();
	    	bp.waitForElement();
	    	
	    	tr=new TestRepositoryPage(driver);
	    	tp=new TestPlanningPage(driver);
	    	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
	    	bp.waitForElement();
	    	tp.doubleClickOnCycle(releaseName);
	    	bp.waitForElement();
	    	
	    	String[] nodes=new String[8];
	    	nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 1);
	    	nodes[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 2);
	    	nodes[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 3);
	    	nodes[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 4);
	    	nodes[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 5);
	    	nodes[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 6);
	    	nodes[6]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 7);
	    	nodes[7]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 8);
	    	bp.waitForElement();
	    	bp.waitForElement();
	    	bp.waitForElement();
	    	actual[46]=tr.navigateNode(nodes);
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

	@When("^User selects all the testcases by checking select all checkbox at phase level$")
	public void user_selects_all_the_testcases_by_checking_select_all_checkbox_at_phase_level() throws Throwable {
	   try
	   {
		   tr=new TestRepositoryPage(driver);
		   String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 1);
		   bp.waitForElement();
		   actual[47]=tr.selectPhase(p_Name1);
		   String NodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",14 ,1 );
		   actual[48]=tp.clickOnChecKBox(NodeName);
		   bp.waitForElement();
		   
		   actual[49]=tp.clickOnSaveAndOk();
		   bp.waitForElement();
		   
		   actual[50]=tp.closeFreeFormPage();
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

	@Then("^User successfully adds testcases to the free form phase from any level$")
	public void user_successfully_adds_testcases_to_the_free_form_phase_from_any_level() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("User successfully adds testcases to the free form phase from any level");
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
