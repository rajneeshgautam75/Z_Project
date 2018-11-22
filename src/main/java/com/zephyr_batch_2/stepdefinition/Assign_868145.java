package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Assign_868145 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tl;
	boolean[] actual=new boolean[31];
	 SoftAssert soft=new SoftAssert();
	 String filename="Assign_868145";
	@Given("^logged in with manager user in repository page to create phase$")
	public void logged_in_with_manager_user_in_repository_page_to_create_phase() throws Throwable 
	{
		try
		   {
			   pp=new ProjectPage(driver);
			   //String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,0);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
			   actual[0]=pp.selectProject(projectName);
			   bp=new BasePage();
			   bp.waitForElement();
			   actual[1]=pp.selectRelease(releaseName);
			   bp.waitForElement();
			   rp= new ReleasePage(driver);
			   actual[2]=rp.clickOnTestRep();
			   bp.waitForElement();
			   tr=new TestRepositoryPage(driver);
			   actual[3]=tr.doubleClickOnRelease(releaseName);
			   bp.waitForElement();
		   }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
//			    Relogin_TPE rl=new Relogin_TPE();
//			    rl.reLogin();
			    throw e;
			}  
	}

	@Given("^create phase add sixteen testcases$")
	public void create_phase_add_sixteen_testcases() throws Throwable 
	{
		try
		{
			BasePage bp=new BasePage();
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases", 28, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH,"TP_Phases", 28, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			bp.waitForElement();
			String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
			actual[5]=tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases", 28, 0);
			actual[6]=tr.navigateToNode(releaseName, phase);
			 bp.waitForElement();
			actual[7]=tr.addTestCase();
			
			tr.clickDetailButton();
			 ctc=new CreateTestCasePage(driver);
			   String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH, "TP_Testcase", 23, 0);
			   String testCaseDesc=Excel_Lib.getData(INPUT_PATH, "TP_Testcase", 23, 1);
			   actual[8]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
			   bp.waitForElement();
			   tr.clickOnList();
			   actual[9]=tr.selectallTestCase();
			   bp.waitForElement();
			   actual[10]=tr.cloneTestCase();
			   bp.waitForElement();
			   actual[11]=tr.selectallTestCase();
			   bp.waitForElement();
			   actual[12]=tr.cloneTestCase();
			   bp.waitForElement();
			   actual[13]=tr.selectallTestCase();
			   bp.waitForElement();
			   actual[14]=tr.cloneTestCase();
			   bp.waitForElement();
			   actual[15]=tr.selectallTestCase();
			   bp.waitForElement();
			   actual[16]=tr.cloneTestCase();
			   bp.waitForElement();
		   }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
//			    Relogin_TPE rl=new Relogin_TPE();
//			    rl.reLogin();
			    throw e;
			} 
	}

	@When("^launch testplanning create cycle add phase to cycle and cancel bulkassign$")
	public void launch_testplanning_create_cycle_add_phase_to_cycle_and_cancel_bulkassign() throws Throwable 
	{
		try
		{
		actual[17]=rp.clickOnTestPlanning();
		bp.waitForElement();
		tl=new TestPlanningPage(driver);
		tl.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Exe Cycle",46,0);
  	  String Build=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",46,1));
  	  String environ=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",46,2);
  	  String hide=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",46,100);
  	  actual[18]=tl.CreateCycle(cycle, Build, environ, hide);
  	  String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",46,3));
  	  String smonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",46,4);
  	  String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",46,5));
  	  String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",46,6));
  	  String emonth=Excel_Lib.getData(INPUT_PATH,"Exe Cycle",46,7);
  	  String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Exe Cycle",46,8));
  	  actual[19]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
  	  bp.waitForElement();
  	  tl.saveTestCycle();
		bp.waitForElement();
		String cyclename1[]=new String[1];
		cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Exe Cycle", 46, 0);
		actual[20]=tl.navigateToCycle(cyclename1);
		bp.waitForElement();
		String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases", 28, 0);
		actual[21]=tl.addPhaseToCycle(nodeName);
	   bp.waitForElement();
	   bp.waitForElement();
	   actual[22]=tl.cancelBulkAssign();
	   bp.waitForElement();
		  }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
//			    Relogin_TPE rl=new Relogin_TPE();
//			    rl.reLogin();
			    throw e;
			}
	
	}

	@When("^navigate to phase select all testcases and assign to user and donot save$")
	public void navigate_to_phase_select_all_testcases_and_assign_to_user_and_donot_save() throws Throwable 
	{
		try
		{
		String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"TP_Phases", 28, 0);
		actual[23]=tl.navigateToCycle(phase);
		bp.waitForElement();
		tl.selectallTestCase();
		bp.waitForElement();
		String manager=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		tl.assignAllSelected(manager);
		 }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
//			    Relogin_TPE rl=new Relogin_TPE();
//			    rl.reLogin();
			    throw e;
			}
	}

	@When("^logged in with lead user in repository page to create phase$")
	public void logged_in_with_lead_user_in_repository_page_to_create_phase() throws Throwable 
	{
		try
		{
			LaunchBrowser bt1=new LaunchBrowser();
	    	actual[24]= bt1.preCond2("chromeBrowser");
	    	String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"URL");
	    	bt1.getUrl2(url,driver2);
	    	LoginPage lpg=new LoginPage(driver2);
	    	String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_2");
	    	actual[25]= lpg.enterUname2(uname,driver2);
	    	actual[26]= lpg.enterPass2(uname,driver2);
	    	actual[27]= lpg.clickOnLogin2(driver2);
		   }
		   catch (Exception e) 
			{
			  TestRepositoryPage tr1=new TestRepositoryPage(driver2);
			  lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
		    	  pp.clickOnLogout(driver2);
		    	  pp.closeBrowser();
		    	 // tr1.driverClose(driver2);
		    	  //tr1.driverClose(driver);
//					Relogin_TPE rl=new Relogin_TPE();
//					rl.reLogin();
					throw e;
			}  
	}

	@When("^create phase add sixteen Testcases$")
	public void create_phase_add_sixteen_Testcases() throws Throwable 
	{
		try
		{
			ProjectPage pp1=new ProjectPage(driver2);
    		String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
    		pp1.selectProject2(project,driver2);
    		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",5,0);
    		pp1.selectRelease2(releaseName,driver2);
    		ReleasePage rp1=new ReleasePage(driver2);
    		actual[28]= rp1.clickOnTestPlanning2(driver2);
		   }
		   catch (Exception e) 
			{
			   TestRepositoryPage tr1=new TestRepositoryPage(driver2);
			   lb.getScreenShot(filename);
		    	  pp.clickOnLogout(driver2);
		    	  pp.closeBrowser();
		    	  //tr1.driverClose(driver2);
		    	  //tr1.driverClose(driver);
					Relogin_TPE rl=new Relogin_TPE();
					rl.reLogin();
					throw e;
			} 
	}

	@When("^launch testplanning create Cycle add Phase to cycle and cancel bulkassign$")
	public void launch_testplanning_create_Cycle_add_Phase_to_cycle_and_cancel_bulkassign() throws Throwable 
	{
		try
		{
			BasePage bp=new BasePage();
			TestPlanningPage tp=new TestPlanningPage(driver2);
			//String cycleName2[]=new String[1];
			String cycleName2=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Exe Cycle", 46, 0);
			tl.doubleClickOnCycle2(cycleName2,driver2);
			String cyclename1[]=new String[2];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Exe Cycle", 46, 0);
			cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "TP_Phases", 28, 0);
			actual[29]=tl.navigateToCycle2(cyclename1,driver2);
			bp.waitForElement();
			tp.assignPhase2(driver2);
			bp.waitForElement();
		  }
		   catch (Exception e) 
			{
			   TestRepositoryPage tr1=new TestRepositoryPage(driver2);
			   lb.getScreenShot(filename);
		    	  pp.clickOnLogout(driver2);
		    	  pp.closeBrowser();
		    	  //tr1.driverClose(driver2);
		    	  //tr1.driverClose(driver);
//					Relogin_TPE rl=new Relogin_TPE();
//					rl.reLogin();
					throw e;
			}
	}

	@When("^navigate to phase select All testcases and assign to user and donot save$")
	public void navigate_to_phase_select_All_testcases_and_assign_to_user_and_donot_save() throws Throwable
	{
		try
		{
			BasePage bp=new BasePage();
			String cyclename[]=new String[1];
			cyclename[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "TP_Phases", 28, 0);
			actual[30]=tl.navigateToCycle2(cyclename,driver2);
			bp.waitForElement();
			tl.selectallTestCase2(driver2);
			bp.waitForElement();
			String manager=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User4");
			tl.assignAllSelectedWaitForOk2(manager,driver2);
			bp.waitForElement();
		 }
		   catch (Exception e) 
			{
			   TestRepositoryPage tr1=new TestRepositoryPage(driver2);
			   lb.getScreenShot(filename);
		    	  pp.clickOnLogout(driver2);
		    	  pp.closeBrowser();
		    	  //tr1.driverClose(driver2);
		    	  //tr1.driverClose(driver);
//					Relogin_TPE rl=new Relogin_TPE();
//					rl.reLogin();
					throw e;
			}
	}

	@When("^simultaniously click on save button$")
	public void simultaniously_click_on_save_button() throws Throwable 
	{
		try
		{
			BasePage bp=new BasePage();
//			tl.okForAssignSelected2(driver2);
			
			ProjectPage pp1=new ProjectPage(driver2);
    		pp1.clickOnLogout(driver2);
//			bp.waitForElement();
//			tl.okForAssignSelected2(driver2);
		}
		catch (Exception e) 
		{
			TestRepositoryPage tr1=new TestRepositoryPage(driver2);
			 lb.getScreenShot(filename);
	    	  pp.clickOnLogout(driver2);
	    	 pp.closeBrowser();
//	    	  tr1.driverClose(driver2);
//	    	  //tr1.driverClose(driver);
//				Relogin_TPE rl=new Relogin_TPE();
//				rl.reLogin();
				throw e;
		}
	}

	@Then("^only one Re-Assignment should be saved The user whose assignments are saved should get the confirmation$")
	public void only_one_Re_Assignment_should_be_saved_The_user_whose_assignments_are_saved_should_get_the_confirmation() throws Throwable 
	{
		try
		   {
//			  pp.clickOnLogout();
//			  pp.closeBrowser();
			   for(int k=0;k<=actual.length-1;k++)
			     {
			      soft.assertEquals(actual[k], true);
			     }
			    soft.assertAll();
		   }
		   catch (Exception e) 
			{
				e.printStackTrace();
			    driver.close();
//			    Relogin_TPE rl=new Relogin_TPE();
//			    rl.reLogin();
			    throw e;
			}
	}
}
