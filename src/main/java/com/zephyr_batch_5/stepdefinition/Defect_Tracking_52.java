package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_52  extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ReleasePage rp;
	TestRepositoryPage tr;
	BasePage bp;
	TestPlanningPage tl;
	ExecutionPage epp;
	DashBoardPage dp;
	DefectTracking dt;
	ExternalJiraPage ejp;
	ProjectPage pp;
	boolean[] actual=new boolean[36];
	SoftAssert soft=new SoftAssert();
	String filename="Defect_Tracking_52";
	
	
	@Given("^User is in the main page$")
	public void user_is_in_the_main_page() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			bp=new BasePage();
			rp= new ReleasePage(driver);
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			actual[0]=pp.selectProject(projectName);
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			actual[1]=pp.selectRelease(releaseName);
			bp.waitForElement();
			
		}
		   catch(Exception e)
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e; 	 
			}  
	    
	}

	@When("^User will click on the respository button and right click on release$")
	public void user_will_click_on_the_respository_button_and_right_click_on_release() throws Throwable {
		 try
		    {
				bp.waitForElement();
				actual[2]=rp.clickOnTestRep();
		    	bp.waitForElement();
		    	bp.waitForElement();
		    	bp.waitForElement();
		    }
		    catch(Exception e)
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e; 	 
			}  
	   
	}

	@When("^user will add the test node$")
	public void user_will_add_the_test_node() throws Throwable {
		try
		  {
			    tr=new TestRepositoryPage(driver);
		    	String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 1, 0);
		    	String descp=Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 1, 1);
		    	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
				actual[3]=tr.clickOnRelease(releaseName);
				bp.waitForElement();
				bp.waitForElement();
				actual[4]=tr.addNode(name,descp);
				bp.waitForElement();
//				actual[5]=tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
				
				
		  }
			  catch(Exception e)
				{
				   lb=new LaunchBrowser();
				   lb.getScreenShot(filename);
					e.printStackTrace();
				   driver.close();
			      	Relogin_TPE rl=new Relogin_TPE();
			      	rl.reLogin();
			      	throw e; 	 
				}
		  
	   
	}

	@Then("^user test node addded successfully$")
	public void user_test_node_addded_successfully() throws Throwable {
		try
		  {
			    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			    String[] phase=new String[1];
			    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 1, 0);
			    actual[5]=tr.navigateToNode(releaseName, phase);
			    bp.waitForElement();
		  }
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
		
	  
	}

	@When("^User will add  testcases$")
	public void user_will_add_three_testcases() throws Throwable {
		try
		 {
			 for(int i=0;i<=15;i++)
				{
				 actual[6]=tr.addTestCase();
				}
			 bp.waitForElement();
			 
		 }
		 catch(Exception e)
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e; 	 
			}
	   
	}

	@Then("^testcases added successfully$")
	public void three_testcases_added_successfully() throws Throwable {
		try
		{
			actual[7]=tr.verifyPresentTestCase();
			bp.waitForElement();
			
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	}

	@When("^user clicks on test Planning page and click on add test cycle$")
	public void user_clicks_on_test_Planning_page_and_click_on_add_test_cycle() throws Throwable {
		try 
		{
			
		 tl=new TestPlanningPage(driver);
		 actual[8]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		 actual[9]=tl.clickOnAddTestCycleSymbol();
		 bp.waitForElement();
		 

	 }
	 catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}

		
	
	}

	@When("^create a cycle and add the created phase to the cycle and assign to everyone$")
	public void create_a_cycle_and_add_the_created_phase_to_the_cycle_and_assign_to_everyone() throws Throwable {
		try
		{
		     String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 0);
		     String build=Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 1);
		  	 String environment=Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 2);
			 String hide=Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 11);
			 String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_8, "Release", 1, 4));
			 String smonth=Excel_Lib.getData(INPUT_PATH_8, "Release", 1, 5);
		 	 String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_8, "Release", 1, 6));
			 String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_8, "Release", 1, 7));
			 String emonth=Excel_Lib.getData(INPUT_PATH_8, "Release", 1, 8);
			 String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_8, "Release", 1, 9));
			 String cyclename1[]=new String[1];
			 cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 0);
			 String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 1, 0);		
			 actual[10]=tl.CreateCycle(cyclename, build, environment,hide); 
			 actual[11]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			 bp.waitForElement();
			 actual[12]=tl.saveTestCycle();
			 bp.waitForElement();
			 actual[13]=tl.navigateToCycle(cyclename1);
			 bp.waitForElement();		
			 actual[14]=tl.addPhaseToCycle(nodeName);
			 bp.waitForElement();  
		     
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	  
	}

	@Then("^testcases should be assigned to everyone$")
	public void testcases_should_be_assigned_to_everyone() throws Throwable {
		try
		{
			 String bulk_Type=Excel_Lib.getData(INPUT_PATH_8,"Create cycle", 2, 4);
			 actual[15]=tl.bulkAssignment(bulk_Type);
		     bp.waitForElement();
		     actual[16]=tl.goBackToCycle();
		     bp.waitForElement();    
		     bp.waitForElement();
		     bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
		
	  
	}

	@When("^user will click on testexecution button and navigate to related node$")
	public void user_will_click_on_testexecution_button_and_navigate_to_related_node() throws Throwable {
		try
		{
			String cyclename1[]=new String[3];
		    cyclename1[0]=Excel_Lib.getData(INPUT_PATH_8,"TestExec",1,1);
			cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 0);
			cyclename1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 1, 0);
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			actual[17]=rp.clickOnTestExecution();
			bp.waitForElement();
			bp.waitForElement();
		    actual[18]=tr.navigateToNode(releaseName,cyclename1);
			bp.waitForElement();  
			bp.waitForElement();  
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	 
	}

	@When("^user will execute the testcase to pass status$")
	public void user_will_execute_the_testcase_to_pass_status() throws Throwable {
		try
		{
			epp=new ExecutionPage(driver);
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 2);
		    actual[19]=epp.changeStatusOfTestCases(tcNo, statusType);
		    bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	 
	}

	@Then("^status should be changed to pass$")
	public void status_should_be_changed_to_pass() throws Throwable {
		try
		{
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 2);
		    actual[20]=epp.ValidateStatusOfTestCases(tcNo, statusType);
		    bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	   
	}

	@When("^tester will click on the D button and search the defect by id$")
	public void tester_will_click_on_the_D_button_and_search_the_defect_by_id() throws Throwable {
		try
		{
			int tcno=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			actual[21]=epp.clickOnDefectButton(tcno);
		    bp.waitForElement(); 
		    bp.waitForElement();
		    actual[22]=epp.searchDefect(defectId);
		    bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}    
	 
	}

	@Then("^defect should be successfully searched$")
	public void defect_should_be_successfully_searched() throws Throwable {
		try
		{
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			
			actual[23]=epp.validateSearchedDefect(defectId);
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}   
	
	}

	@When("^user linked the searched defect$")
	public void user_linked_the_searched_defect() throws Throwable {
		try
		{
			actual[24]=epp.linkDefect();
			bp.waitForElement();
			bp.waitForElement(); 
			bp.waitForElement(); 
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}   
	 
	}

	@Then("^should be able to link defect to execution successfully$")
	public void should_be_able_to_link_defect_to_execution_successfully() throws Throwable {
		try
		{
			int tcno=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			actual[25]=epp.validateLinkedDefect(tcno, defectId);
			bp.waitForElement();
			bp.waitForElement(); 
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}   
	 
	}

	@When("^User click on defect Tracking page$")
	public void user_click_on_defect_Tracking_page() throws Throwable {
		try
		{
			actual[26]=pp.clickOnDefectTracking();
			bp.waitForElement();
			bp.waitForElement();
			
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	 
	}

	@When("^search for that defect ID$")
	public void search_for_that_defect_ID() throws Throwable {
		try
		{
			dt=new DefectTracking(driver);
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			actual[27]=dt.searchDefect(defectId);
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	
	}

	@Then("^searched defect will be shown in search page$")
	public void searched_defect_will_be_shown_in_search_page() throws Throwable {
		try
		{
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			actual[28]=dt.validateDefect(defectId);
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	 
	}

	@When("^user click on that defect Id$")
	public void user_click_on_that_defect_Id() throws Throwable {
		try
		{
			dp=new DashBoardPage(driver);
			dp.selectDefect.click();
			bp.waitForElement();
	
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	
	}

	@Then("^Jira page will open$")
	public void jira_page_will_open() throws Throwable {
		try
		{
			int switchtcNo=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 2, 5);
			bp.switchWindowTab(switchtcNo);
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	
	}

	@When("^user fill up the jira credential and click on login$")
	public void user_fill_up_the_jira_credential_and_click_on_login() throws Throwable {
		try
		{
			ejp=new ExternalJiraPage(driver);
			String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
			actual[29]=ejp.loginToExternalJira(username, password);
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	  
	}

	@When("^user will change the status of that defect in jira$")
	public void user_will_change_the_status_of_that_defect_in_jira() throws Throwable {
		try
		{
			String statusType=Excel_Lib.getData(INPUT_PATH_8, "Jira", 2, 0);
			actual[30]=ejp.changeDefectStatusInExternalJira(statusType);
		    for (int j=0;j<=10;j++)
	        	{
			       bp.waitForElement();
		        }
		    actual[31]=ejp.logOutFromExternal_JIRA();
		    driver.close();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	
	}

	@When("^user will open test execution and search for that defect id$")
	public void user_will_open_test_execution_and_search_for_that_defect_id() throws Throwable {
		try
		{
			
			int switchbacktcNo=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 5);
			bp.switchWindowTab(switchbacktcNo);
			bp.waitForElement();
			actual[32]=rp.clickOnTestExecution();
			bp.waitForElement();
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	 
	}

	@Then("^the status of that defect has been changed to new Updated status$")
	public void the_status_of_that_defect_has_been_changed_to_new_Updated_status() throws Throwable {
		try
		{

			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			int tcNo=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
			String cyclename1[]=new String[3];
		    cyclename1[0]=Excel_Lib.getData(INPUT_PATH_8,"TestExec",1,1);
			cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 0);
			cyclename1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 1, 0);
		//	actual[33]=tr.clickOnRelease(releaseName);
			bp.waitForElement();
			actual[33]=tr.navigateToNode(releaseName,cyclename1);
			bp.waitForElement();
			actual[34]=epp.applyNotification();
			bp.waitForElement();
			actual[35]=epp.viewTooltip(tcNo);		
			bp.waitForElement();	
			
			for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();	
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	 
	}


}
