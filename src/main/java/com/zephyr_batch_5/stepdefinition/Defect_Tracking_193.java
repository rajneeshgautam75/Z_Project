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

public class Defect_Tracking_193 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	ExecutionPage exep;
	DefectTracking dt;
	String fileName="Defect_Tracking_193";
	
	boolean[] actual=new boolean[19];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in Project Page$")
	public void user_is_in_Project_Page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 pp=new ProjectPage(driver);
		 bp=new BasePage();
		 dt=new DefectTracking(driver);
		 tr=new TestRepositoryPage(driver);
		 tp=new TestPlanningPage(driver);
		 rp=new ReleasePage(driver);
		 exep=new ExecutionPage(driver);
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

	@When("^User launch the Test Execution page$")
	public void user_launch_the_Test_Execution_page() throws Throwable {
	try
	   {
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[1]=pp.selectRelease(releaseName);
		 actual[2]=rp.clickOnTestExecution();
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

	@Then("^Should launch Test Execution page$")
	public void should_launch_Test_Execution_page() throws Throwable {
	try
	   {
		 actual[3]=exep.verifyExecutionPage();
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

	@When("^User execute the testcase$")
	public void user_execute_the_testcase() throws Throwable {
	try
	   {
			 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			 String[] cycleName=new String[2];
             cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,13 );
		     cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,12 );
		    
		    bp.waitForElement();
			actual[4]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[5]=exep.executeStatus(tcNo1[0], statusType1);
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

	@When("^User click on D button to launch link defect window$")
	public void user_click_on_D_button_to_launch_link_defect_window() throws Throwable {
	try
	   {
        int[] tcNo1=new int[1];
		tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
        actual[6]=exep.clickOnDefectButton(tcNo1[0]);
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

	@Then("^Should be able to launch the Link Defect window$")
	public void should_be_able_to_launch_the_Link_Defect_window() throws Throwable {
	try
	   {
		 actual[7]=exep.validateLinkDefectWindow();
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

	@When("^search a defect by ID$")
	public void search_a_defect_by_ID() throws Throwable {
	try
	  {
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",50,11);
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,9);
		 bp.waitForElement();
		 actual[8]=exep.defectSearch(selectSearch,defectID);
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

	@Then("^Should be able to search defect$")
	public void should_be_able_to_search_defect() throws Throwable {
	try
	  {
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",50,11);
		 bp.waitForElement();
		 actual[9]=dt.validateDefect(defectID);
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

	@When("^link the searched defect to the testcase$")
	public void link_the_searched_defect_to_the_testcase() throws Throwable {
	try
	   {
		 actual[10]=exep.linkDefect();
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

	@Then("^Should be able to link defect to Execution$")
	public void should_be_able_to_link_defect_to_Execution() throws Throwable {
	try
	   {
		 int tcNo1=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1,16);
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",50,11);
		 actual[11]=exep.validateLinkedDefect(tcNo1,defectID);
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

	@When("^select the linked defect in currently linked defect window and delete it$")
	public void select_the_linked_defect_in_currently_linked_defect_window_and_delete_it() throws Throwable {
	try
	   {
        int[] tcNo1=new int[1];
		tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		actual[12]=exep.clickOnDefectButton(tcNo1[0]);
        actual[13]=exep.deleteDefect(tcNo1);
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
	
	@Then("^Should be able to delete the defect on execution$")
	public void should_be_able_to_delete_the_defect_on_execution() throws Throwable {
	try
	   {
		 actual[14]=exep.validateCurrentlylinkedDefect();
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

	@When("^User search the same defect ID to link to the testcase$")
	public void user_search_the_same_defect_ID_to_link_to_the_testcase() throws Throwable {
	try
	  {
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",50,11);
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,9);
		 bp.waitForElement();
		 actual[15]=exep.defectSearch(selectSearch,defectID);
		 actual[16]=exep.linkDefect();
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

	@Then("^Should be able to link defect to the execution$")
	public void should_be_able_to_link_defect_to_the_execution() throws Throwable {
	try
	   {
		 int tcNo1=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1,16);
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",50,11);
		 actual[17]=exep.validateLinkedDefect(tcNo1,defectID);
		 actual[18]=tp.doubleClickOnCycle(releaseName);
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
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}      
	}
}
