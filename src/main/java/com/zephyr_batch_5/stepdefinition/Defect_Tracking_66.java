package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_66 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ReleasePage rp;
	TestRepositoryPage tr;
	BasePage bp;
	ExecutionPage epp;
	DefectTracking dt;
	DashBoardPage dp;
	ProjectPage pp;
	boolean[] actual=new boolean[21];
	SoftAssert soft=new SoftAssert();
	String filename="Defect_Tracking_66";
	
	
	@Given("^Users Comes into TestExecution Page$")
	public void users_Comes_into_TestExecution_Page() throws Throwable {
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
			actual[2]=rp.clickOnTestExecution();
			bp.waitForElement(); 
			bp.waitForElement(); 
			bp.waitForElement(); 
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
	
	@When("^user will goes to the selected node by navigating$")
	public void user_will_goes_to_the_selected_node_by_navigating() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			String cyclename1[]=new String[3];
			cyclename1[0]=Excel_Lib.getData(INPUT_PATH_8,"TestExec",1,1);
		    cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 0);
			cyclename1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 1, 0);
			actual[3]=tr.navigateToNode(releaseName,cyclename1);
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

	@When("^user selects the testcase and change the status of the selected testcase$")
	public void user_selects_the_testcase_and_change_the_status_of_the_selected_testcase() throws Throwable {
		try
		{
			epp=new ExecutionPage(driver);
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 13, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 2);
		    actual[4]=epp.changeStatusOfTestCases(tcNo, statusType);
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

	@Then("^testcase status must be changed sucessfully$")
	public void testcase_status_must_be_changed_sucessfully() throws Throwable {
		try
		{
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 13, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 2);
		    actual[5]=epp.ValidateStatusOfTestCases(tcNo, statusType);
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

	@When("^user clicks on the D icon$")
	public void user_clicks_on_the_D_icon() throws Throwable {
		try
		{
			int tcno=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 13, 0);
			actual[6]=epp.clickOnDefectButton(tcno);
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

	@When("^user will search multiple defect and links it to testcase$")
	public void user_will_search_multiple_defect_and_links_it_to_testcase() throws Throwable {
		try
		{
			String[] defectId=new String[3];
			defectId[0]=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 9);
			defectId[1]=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 2, 9);
			defectId[2]=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 9);
			String selectSearch=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 6);
			for(int i=0;i<=defectId.length-1;i++)
			{
		    actual[7]=epp.defectSearch(selectSearch, defectId[i]);
			epp.linkDefects.click();
			}
			//actual[7]=epp.multipleDefectSearch(selectSearch, defectId);
			bp.waitForElement(); 
			epp.cancelDefect.click();
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

	@Then("^user must sucessfully linked all multiple defect to that testcase$")
	public void user_must_sucessfully_linked_all_multiple_defect_to_that_testcase() throws Throwable {
		try
		{
			int tcno=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 13, 0);
			actual[8]=epp.viewTooltip(tcno);
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
	  

	@When("^user clicks on the dashboard button$")
	public void user_clicks_on_the_dashboard_button() throws Throwable {
		try
		{
		     dp=new DashBoardPage(driver);
			actual[9]=dp.clickOnManageDashboards();
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

	@Then("^user must sucessfully comes to dashboard page$")
	public void user_must_sucessfully_comes_to_dashboard_page() throws Throwable {
		try
		{
			actual[10]=dp.validateDashboards();
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

	@When("^user will click on AddDashboard Symbol$")
	public void user_will_click_on_AddDashboard_Symbol() throws Throwable {
		try
		{
			actual[11]=dp.clickOnAddDashBoardSymbol();
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

	@When("^user will enters all the details and click on save$")
	public void user_will_enters_all_the_details_and_click_on_save() throws Throwable {
		try
		{
			 String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 2, 1);
	    	 String description=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 2);
	    	 String layout=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 4);
	    	 String shareType=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 3);
	    	 actual[12]=dp.enterDashBoardDetails(dashboard, description, layout, shareType);
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

	@Then("^dashboard must be sucessfully saved$")
	public void dashboard_must_be_sucessfully_saved() throws Throwable {
		try
		{
			String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 2, 1);
			actual[13]=dp.validateDashBoard(dashboard);
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

	@When("^user clicks on dashboard which is created$")
	public void user_clicks_on_dashboard_which_is_created() throws Throwable {
		try
		{
			String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 2, 1);
			actual[14]=dp.selectDashboard(dashboard);
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

	@When("^user will click on the plus button to add the overall defects gadget$")
	public void user_will_click_on_the_plus_button_to_add_the_overall_defects_gadget() throws Throwable {
		try
		{
			String gadgetName=Excel_Lib.getData(INPUT_PATH_8, "AddDashboard", 3, 5);
			actual[15]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement(); 
			bp.waitForElement();
			
			actual[16]=dp.addGadget(gadgetName);
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

	@Then("^sucessfully gadget must be added$")
	public void sucessfully_gadget_must_be_added() throws Throwable {
		try
		{
			String gadgetName=Excel_Lib.getData(INPUT_PATH_8, "AddDashboard", 3, 5);
			actual[17]=dp.validateGadget(gadgetName);
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

	@When("^user selects the project name and release and refreshrate and save the gadget$")
	public void user_selects_the_project_name_and_release_and_refreshrate_and_save_the_gadget() throws Throwable {
		try
		{
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			String refreshRate=Excel_Lib.getData(INPUT_PATH_8, "Gadget", 1, 2);
			actual[18]=dp.configureTestAutomationStatusGadget(project,release,refreshRate);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
		//	actual[19]=dp.saveGadget();
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

	@Then("^gadget must be sucessfully saved and View the total defect count and count by status$")
	public void gadget_must_be_sucessfully_saved_and_View_the_total_defect_count_and_count_by_status() throws Throwable {
		try
		{
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			actual[19]=dp.validateSavedGadget(project);
			bp.waitForElement(); 
			String Count=dp.overallDefectCount.getText();
			System.out.println(Count);
			actual[20]=pp.backToProjectPage();
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
