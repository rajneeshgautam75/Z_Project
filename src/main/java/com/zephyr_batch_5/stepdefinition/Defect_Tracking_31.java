package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_31 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ReleasePage rp;
	TestRepositoryPage tr;
	BasePage bp;
	TestPlanningPage tl;
	ExecutionPage epp;
	DefectTracking dt;
	ProjectPage pp;
	boolean[] actual=new boolean[35];
	SoftAssert soft=new SoftAssert();
	String filename="Defect_Tracking_31";

	 public String idd;
	
	@Given("^User will be in Test Repository page$")
	public void user_will_be_in_Test_Repository_page() throws Throwable {
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
			actual[2]=rp.clickOnTestRep();
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

	@When("^user clicks on relase and create a node$")
	public void user_clicks_on_relase_and_create_a_node() throws Throwable {
		try
		  {
			tr=new TestRepositoryPage(driver);
	    	String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 5, 0);
	    	String descp=Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 1, 1);
	    	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			actual[3]=tr.clickOnRelease(releaseName);
			bp.waitForElement();
			bp.waitForElement();
			actual[4]=tr.addNode(name,descp);
			bp.waitForElement();
			bp.waitForElement();
			String[] phase=new String[1];
		    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 5, 0);
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

	@When("^user will add four testcase$")
	public void user_will_add_four_testcase() throws Throwable {
		try
		 {
			 for(int i=1;i<=4;i++)
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

	@Then("^testcase must be added successfully$")
	public void testcase_must_be_added_successfully() throws Throwable {
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

	@When("^user clicks on testplanning button and clicks on add cycle button$")
	public void user_clicks_on_testplanning_button_and_clicks_on_add_cycle_button() throws Throwable {
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

	@When("^user will fill the details$")
	public void user_will_fill_the_details() throws Throwable {
		try
		{
		     String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 2, 0);
		     String build=Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 1);
		  	 String environment=Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 2);
			 String hide=Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 11);
			 String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_8, "Release", 1, 4));
			 String smonth=Excel_Lib.getData(INPUT_PATH_8, "Release", 1, 5);
		 	 String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_8, "Release", 1, 6));
			 String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_8, "Release", 1, 7));
			 String emonth=Excel_Lib.getData(INPUT_PATH_8, "Release", 1, 8);
			 String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_8, "Release", 1, 9));
			 actual[10]=tl.CreateCycle(cyclename, build, environment,hide); 
			 actual[11]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			 bp.waitForElement();
			 actual[12]=tl.saveTestCycle();
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

	@Then("^test cycle has been created successfully$")
	public void test_cycle_has_been_created_successfully() throws Throwable {
		try
		{
			
	       actual[13]=tl.verifyAddTestCyclePage();
			
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

	@When("^user selects the cycle and adds the phase$")
	public void user_selects_the_cycle_and_adds_the_phase() throws Throwable {
		try
		{
			 String cyclename1[]=new String[1];
			 cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 2, 0);
			 String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 5, 0);		
			 actual[14]=tl.navigateToCycle(cyclename1);
			 bp.waitForElement();		
			 actual[15]=tl.addPhaseToCycle(nodeName);
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

	@When("^user will select the bulk assignment and assign to everyone$")
	public void user_will_select_the_bulk_assignment_and_assign_to_everyone() throws Throwable {
		try
		{
			String bulk_Type=Excel_Lib.getData(INPUT_PATH_8,"Create cycle", 2, 4);
			 actual[16]=tl.bulkAssignment(bulk_Type);
		     bp.waitForElement();
		     actual[17]=tl.goBackToCycle();
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

	@When("^user will click on testExecution button$")
	public void user_will_click_on_testExecution_button() throws Throwable {
		try
		{
		    	String cyclename1[]=new String[3];
			    cyclename1[0]=Excel_Lib.getData(INPUT_PATH_8,"TestExec",1,1);
				cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 2, 0);
				cyclename1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 5, 0);
				String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
				actual[18]=rp.clickOnTestExecution();
				bp.waitForElement();
				bp.waitForElement();
			    actual[19]=tr.navigateToNode(releaseName,cyclename1);
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

	@When("^user will selects a single testcase and changes the status$")
	public void user_will_selects_a_single_testcase_and_changes_the_status() throws Throwable {
		try
		{
			epp=new ExecutionPage(driver);
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
			String tcno=Integer.toString(tcNo[0]);
		    String statusType=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 2);
		    actual[20]=epp.changeStatusOfTestCases(tcNo, statusType);
		    bp.waitForElement();
		    idd=epp.retrieveTestCaseId(tcno);
		    System.out.println(idd);
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

	@Then("^status have been sucessfully changed of the testcase$")
	public void status_have_been_sucessfully_changed_of_the_testcase() throws Throwable {
		try
		{
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 2);
		    actual[21]=epp.ValidateStatusOfTestCases(tcNo, statusType);
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

	@When("^user will clicks the D icon button$")
	public void user_will_clicks_the_D_icon_button() throws Throwable {
		try
		{
			int tcno=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			actual[22]=epp.clickOnDefectButton(tcno);
		    bp.waitForElement(); 
		    bp.waitForElement();
		    actual[23]=epp.searchDefect(defectId);
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

	@When("^searches for the defect id and links the testcase$")
	public void searches_for_the_defect_id_and_links_the_testcase() throws Throwable {
		try
		{
            String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			
			actual[24]=epp.validateSearchedDefect(defectId);
			bp.waitForElement();
			actual[25]=epp.linkDefect();
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

	@Then("^testcase must be linked successfully$")
	public void testcase_must_be_linked_successfully() throws Throwable {
		try
		{
			int tcno=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			actual[26]=epp.validateLinkedDefect(tcno, defectId);
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

	@When("^user clicks on DefectTracking button$")
	public void user_clicks_on_DefectTracking_button() throws Throwable {
		try
		{
			actual[27]=pp.clickOnDefectTracking();
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

	@Then("^user will comes to Defecttracking page$")
	public void user_will_comes_to_Defecttracking_page() throws Throwable {
		try
		{
			dt=new DefectTracking(driver);
			actual[28]=dt.validateDefectTrackingPage();
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

	@When("^user searches for the defectId$")
	public void user_searches_for_the_defectId() throws Throwable {
		try
		{
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			actual[29]=dt.searchDefect(defectId);
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

	@Then("^defectid is validated successfully$")
	public void defectid_is_validated_successfully() throws Throwable {
		try
		{
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			actual[30]=dt.validateDefect(defectId);
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

	@When("^user clicks on the testcaseID of the defectID linked grid$")
	public void user_clicks_on_the_testcaseID_of_the_defectID_linked_grid() throws Throwable {
		try
		{
			actual[31]=dt.clickOnTestcaseID(idd);
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

	@Then("^Should be able to navigate to the testExecution search page with same TestcaseID$")
	public void should_be_able_to_navigate_to_the_testExecution_search_page_with_same_TestcaseID() throws Throwable {
		try
		{
			actual[32]=dt.validateClickOnTestcaseID(idd);
			bp.waitForElement();
			actual[33]=tr.clickOnList();
			bp.waitForElement();
			actual[34]=tr.clickedOnFolder();
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
