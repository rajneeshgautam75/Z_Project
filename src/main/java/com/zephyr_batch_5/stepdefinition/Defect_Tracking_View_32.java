package com.zephyr_batch_5.stepdefinition;

import org.openqa.selenium.JavascriptExecutor;
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

public class Defect_Tracking_View_32 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ReleasePage rp;
	TestRepositoryPage tr;
	BasePage bp;
	TestPlanningPage tl;
	ExecutionPage epp;
	DefectTracking dt;
	ProjectPage pp;
	boolean[] actual=new boolean[31];
	SoftAssert soft=new SoftAssert();
	String filename="Defect_Tracking_View_32";
	
	@Given("^user will be in a testRepository page$")
	public void user_will_be_in_a_testRepository_page() throws Throwable {
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

	@When("^user clicks on the release and creates a node$")
	public void user_clicks_on_the_release_and_creates_a_node() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);
	    	String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 6, 0);
	    	String descp=Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 1, 1);
	    	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			actual[3]=tr.clickOnRelease(releaseName);
			bp.waitForElement();
			bp.waitForElement();
			actual[4]=tr.addNode(name,descp);
			bp.waitForElement();
			bp.waitForElement();
			String[] phase=new String[1];
		    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 6, 0);
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

	@When("^user will add three testcase$")
	public void user_will_add_three_testcase() throws Throwable {
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

	@Then("^three testcase will be successfully added$")
	public void three_testcase_will_be_successfully_added() throws Throwable {
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

	@When("^user will comes to testplanning page$")
	public void user_will_comes_to_testplanning_page() throws Throwable {
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

	@When("^user will creates a testcycle$")
	public void user_will_creates_a_testcycle() throws Throwable {
		try
		{
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 3, 0);
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

	@Then("^testcycle must be created successfully$")
	public void testcycle_must_be_created_successfully() throws Throwable {
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

	@When("^user comes to testExecution page$")
	public void user_comes_to_testExecution_page() throws Throwable {
		try
		{
			String cyclename1[]=new String[1];
			 cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 3, 0);
			 String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 6, 0);		
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

	@When("^selects the first testcase and change the status$")
	public void selects_the_first_testcase_and_change_the_status() throws Throwable {
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

	@Then("^first testcase status changes successfully$")
	public void first_testcase_status_changes_successfully() throws Throwable {
		try
		{
			String cyclename1[]=new String[3];
		    cyclename1[0]=Excel_Lib.getData(INPUT_PATH_8,"TestExec",1,1);
			cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 3, 0);
			cyclename1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 6, 0);
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

	@When("^user clicks on the first testcase D button$")
	public void user_clicks_on_the_first_testcase_D_button() throws Throwable {
		try
		{
			epp=new ExecutionPage(driver);
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 2);
		    actual[20]=epp.changeStatusOfTestCases(tcNo, statusType);
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

	@When("^user will search for the defect-Id and links the testcase$")
	public void user_will_search_for_the_defect_Id_and_links_the_testcase() throws Throwable {
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

	@Then("^testcase must linked successfully and show the name of the defectID$")
	public void testcase_must_linked_successfully_and_show_the_name_of_the_defectID() throws Throwable {
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

	@When("^DefectTracking button is clicked by user$")
	public void defecttracking_button_is_clicked_by_user() throws Throwable {
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

	@Then("^user will navigate to defectTracking page$")
	public void user_will_navigate_to_defectTracking_page() throws Throwable {
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

	@When("^user enter the defectId and clicks on search button$")
	public void user_enter_the_defectId_and_clicks_on_search_button() throws Throwable {
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

	@Then("^defectID will be successfully searched$")
	public void defectid_will_be_successfully_searched() throws Throwable {
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

	@When("^user selects the defectID in grid$")
	public void user_selects_the_defectID_in_grid() throws Throwable {
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

	@Then("^user Should be able to View the DETAILS Info of a Defect in details of SEARCH view$")
	public void user_Should_be_able_to_View_the_DETAILS_Info_of_a_Defect_in_details_of_SEARCH_view() throws Throwable {
		try
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			int defectNo[]=new int[1];
			defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
			actual[30]=dt.selectSingleOrMultipleDefects(defectNo);	
			bp.waitForElement();
			js.executeScript("window.scrollBy(0,50000)");
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
