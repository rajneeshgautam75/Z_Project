package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
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

public class Dashboard_14 extends LaunchBrowser{

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
	DashBoardPage dbp;
	String fileName="Dashboard_14";
	
	boolean[] actual=new boolean[38];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the Dashboard page$")
	public void user_is_in_the_Dashboard_page() throws Throwable {
		try
	    {
			  /* bp=new BasePage();
			   rp=new ReleasePage(driver);
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			   String releaseName5=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 7,0);
			   actual[0]=pp.selectProject(projectName);
			   actual[1]=pp.selectRelease(releaseName5);
			   rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[2]=rp.clickOnTestRep(); 
			   tr=new TestRepositoryPage(driver);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 14, 14);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 3);
				
				bp=new BasePage();
				actual[4]=tr.clickOnRelease(releaseName5);
				bp.waitForElement();
				actual[5]=tr.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
			   String[] str=new String[1];
			   str[0]=p_Name1;
			   actual[6]=tr.navigateToNode(releaseName5, str);*/
			
			dbp=new DashBoardPage(driver);
			pp=new ProjectPage(driver);
			bp=new BasePage();
			actual[0]=dbp.clickOnManageDashboards();
			actual[1]=bp.waitForElement();
			//actual[1]=dbp.validateDashboards();
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

	@When("^User create a dashboArd with the available fields$")
	public void user_create_a_dashboArd_with_the_available_fields() throws Throwable {
		try
		{
		actual[2]=dbp.clickOnAddDashBoardSymbol();
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,2);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[3]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
		actual[4]=dbp.validateDashBoard(dashboardName);
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

	@When("^User add a Test Automation Status gadget with project/release contains nine automated and ninty one manual testcases$")
	public void user_add_a_Test_Automation_Status_gadget_with_project_release_contains_nine_automated_and_ninty_one_manual_testcases() throws Throwable {
		try
	    {
	    	String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,2);
	    	actual[5]=dbp.selectDashboard(dashboardName);
	    	actual[6]=dbp.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 actual[7]=dbp.addGadget(gadgetName);
			 bp.waitForElement();
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[8]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
			 
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

	@Then("^gadget added successfully with nine automated and ninty one manual testcase information$")
	public void gadget_added_successfully_with_nine_automated_and_ninty_one_manual_testcase_information() throws Throwable {
		 try
			{
			     String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			     actual[9]=dbp.validateGadget(gadgetName);
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

	@When("^User add a Test Automation Status gadget with project/release contains hundred automated and nine hundred manual testcases$")
	public void user_add_a_Test_Automation_Status_gadget_with_project_release_contains_hundred_automated_and_nine_hundred_manual_testcases() throws Throwable {
		try
	    {
	    	//String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 8,2);
	    	//actual[5]=dbp.selectDashboard(dashboardName);
	    	actual[10]=dbp.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 actual[11]=dbp.addGadget(gadgetName);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[12]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
			 
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

	@Then("^gadget added successfully with hundred automated and nine hundred manual testcase information$")
	public void gadget_added_successfully_with_hundred_automated_and_nine_hundred_manual_testcase_information() throws Throwable {
		 try
			{
			     String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			     actual[13]=dbp.validateGadget(gadgetName);
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

	@When("^User add a Test Automation Status gadget with project/release contains thousand automated and thousand manual testcases$")
	public void user_add_a_Test_Automation_Status_gadget_with_project_release_contains_thousand_automated_and_thousand_manual_testcases() throws Throwable {
		try
	    {
//	    	String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 8,2);
//	    	actual[5]=dbp.selectDashboard(dashboardName);
	    	actual[14]=dbp.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 actual[15]=dbp.addGadget(gadgetName);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_6"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[16]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
			 
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

	@Then("^gadget added successfully with thousand automated and thousand manual testcase information$")
	public void gadget_added_successfully_with_thousand_automated_and_thousand_manual_testcase_information() throws Throwable {
		 try
			{
			     String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			     actual[17]=dbp.validateGadget(gadgetName);
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

	@When("^User add a Test Automation Status gadget with project/release contains five thousand automated and hundred manual testcases$")
	public void user_add_a_Test_Automation_Status_gadget_with_project_release_contains_five_thousand_automated_and_hundred_manual_testcases() throws Throwable {
		try
	    {
//	    	String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 8,2);
//	    	actual[18]=dbp.selectDashboard(dashboardName);
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_7"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[18]=dbp.clickOnAddGadgetSymbol();
			 actual[19]=dbp.addGadget(gadgetName);
			 actual[20]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
			 
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

	@Then("^gadget added successfully with five thousand automated and hundred manual testcase information$")
	public void gadget_added_successfully_with_five_thousand_automated_and_hundred_manual_testcase_information() throws Throwable {
		 try
			{
		     String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
		     actual[21]=dbp.validateGadget(gadgetName);
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

	@When("^User add a Test Automation Status gadget with project/release contains only five thousand automated testcases$")
	public void user_add_a_Test_Automation_Status_gadget_with_project_release_contains_only_five_thousand_automated_testcases() throws Throwable {
		try
	    {
//	    	String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 8,2);
//	    	actual[5]=dbp.selectDashboard(dashboardName);
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_9"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8);
			 actual[22]=dbp.clickOnAddGadgetSymbol();
			 actual[23]=dbp.addGadget(gadgetName);
			 actual[24]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
			 
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

	@Then("^gadget added successfully with only five thousand automated testcases$")
	public void gadget_added_successfully_with_only_five_thousand_automated_testcases() throws Throwable {
		 try
			{
		     String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6);
		     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_3");
		     actual[25]=dbp.validateGadget(gadgetName);
		     bp.waitForElement();
		     actual[26]=pp.backToProjectPage();
		     pp.selectProject(projectName);
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

	@When("^User add a Test Automation Status gadget with project/release contains ten automated and five thousand manual testcases$")
	public void user_add_a_Test_Automation_Status_gadget_with_project_release_contains_ten_automated_and_five_thousand_manual_testcases() throws Throwable {
		try
	    {
			   bp=new BasePage();
			   rp=new ReleasePage(driver);
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			   String releaseName5=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_9");
			   actual[27]=pp.selectProject(projectName);
			   actual[28]=pp.selectRelease(releaseName5);
			   rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[29]=rp.clickOnTestRep(); 
			   tr=new TestRepositoryPage(driver);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 14, 14);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 3);
				
				bp=new BasePage();
				actual[30]=tr.clickOnRelease(releaseName5);
				bp.waitForElement();
				actual[31]=tr.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
			    String[] str=new String[1];
			    str[0]=p_Name1;
			   actual[32]=tr.navigateToNode(releaseName5, str);
			   tr.addTestCase();
			   bp.waitForElement();
				actual[7]=tr.clickDetailButton();
				ctc=new CreateTestCasePage(driver);
				String check=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 9);
				String script_Name=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 10);
				String script_Id=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 11));
				String script_Path=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 12);
				actual[6]=ctc.enterAutomationScriptFieldInTestCasePage(check, script_Name, script_Id, script_Path);
				bp.waitForElement();
				tr.clickOnList();
				for(int i=0;i<=2;i++)
				{
				tr.selectallTestCase();
				tr.cloneTestCase();
				}
				tr.selectallTestCase();
				tr.selectallTestCase();
				ep=new ExportPage(driver);
				String[] testCaseNo1=new String[2];
				testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 15));
				testCaseNo1[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 2, 15));
				ep.selectMultipleTestcasesfromSearch(testCaseNo1);
				tr.cloneTestCase();
				bp.waitForElement();

			dbp.clickOnManageDashboards();
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,2);
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_9") ;
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			dbp.searchDashboard(dashboardName);   
	    	actual[33]=dbp.selectDashboard(dashboardName);
	    	actual[34]=dbp.clickOnAddGadgetSymbol();
			
			 actual[35]=dbp.addGadget(gadgetName);
			// String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 actual[36]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate); 
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

	@Then("^gadget added successfully with ten automated and five thousand manual testcase information$")
	public void gadget_added_successfully_with_ten_automated_and_five_thousand_manual_testcase_information() throws Throwable {
		 try
			{
		     String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6);
//			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
//			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_9") ;
		     actual[37]=dbp.validateGadget(gadgetName);
		     bp.waitForElement();
		     pp.backToProjectPage();
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
			   lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}  
		}
	}
