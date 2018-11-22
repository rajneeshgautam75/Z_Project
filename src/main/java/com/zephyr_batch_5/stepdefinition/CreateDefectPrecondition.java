package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
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

public class CreateDefectPrecondition extends LaunchBrowser {
	
	LaunchBrowser lb;
    ProjectPage pp;
    LoginPage lp;
   ReleasePage rp;
   TestRepositoryPage tr;
   TestPlanningPage tp;
   ExecutionPage exe;
   DashBoardPage db;
   BasePage bp;
   ExternalJiraPage ext;
   CreateCustomFieldsPage ctp;
   DefectTracking dt;
   
   boolean[] actual=new boolean[25];
	SoftAssert soft=new SoftAssert();
   String fileName="CreateDefectPrecondition";
   
   
   
   

@Given("^Login as manager Credential$")
public void login_as_manager_Credential() throws Throwable {
	  try
	  {
		  pp=new ProjectPage(driver);
		   bp=new BasePage();

			pp.clickOnLogout();
		    lp=new LoginPage(driver);
		    String managerUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Manager_Username_1");
		    String managerPass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Manager_Password_1");
		    lp.enterUnameAndPassword(managerUname, managerPass);
		   
			String dtsType=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 1);
			  
			  
			  String url=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 2);
			  String userName=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 3);
			  String password=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 4);
				
			  pp.launchAdministration();
			  bp.waitForElement();
			  pp.clickOnDefectTracking();
			  bp.waitForElement();
//			  
			  ctp=new CreateCustomFieldsPage(driver);
			  ctp.setDTS(dtsType, url, userName, password);
			  
			  pp.clickOnLogout();
			    lp=new LoginPage(driver);
			    String leadUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_Username_1");
			    String leadPass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_Password_1");
			    lp.enterUnameAndPassword(leadUname, leadPass);
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
	

	
	@When("^User navigate to test repository page$")
	public void user_navigate_to_test_repository_page() throws Throwable {
	    
		try
		{
		rp=new ReleasePage(driver);
		
		  String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		  String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 
		pp.selectProject(projectName);
		pp.selectRelease(releaseName);
		
		rp.clickOnTestRep();
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

	@When("^add a node with name and description$")
	public void add_a_node_with_name_and_description() throws Throwable {
	  
		try
		{
		tr=new TestRepositoryPage(driver);
	  String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 2, 5);
	  String phaseDesc=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 2, 5);
	  String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
	  tr.clickOnRelease(releaseName);
	  tr.addNode(phaseName,phaseDesc );
	  
		} catch(Exception e)
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

	@Then("^node succesfully created$")
	public void node_succesfully_created() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			String[] nav=new String[1];
			nav[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 2, 5);
		tr.navigateToNode(releaseName, nav);
		
		} catch(Exception e)
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

	@When("^user add multiple testcase to the node$")
	public void user_add_multiple_testcase_to_the_node() throws Throwable {
	 try
	 {
		for(int i=1;i<6;i++)
	  {
		tr.addTestCase();
	  }
		
	 } catch(Exception e)
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

	@Then("^testcases should be added$")
	public void testcases_should_be_added() throws Throwable {
	  try
	  {
		tr.verifyPresentTestCase();
		
	  } catch(Exception e)
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

	@When("^user navigate to test planning page$")
	public void user_navigate_to_test_planning_page() throws Throwable {
	  try
	  {
		rp.clickOnTestPlanning();
		
	  } catch(Exception e)
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

	@When("^create a new cycle,add phase to the cycle and assign to the user$")
	public void create_a_new_cycle_add_phase_to_the_cycle_and_assign_to_the_user() throws Throwable {
	    try
	    {
		tp=new TestPlanningPage(driver);
		tp=new TestPlanningPage(driver);
		String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 2, 7);
		String build=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 2, 8);
		String environment=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 2, 9);
		
		String hide=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 2, 10);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 2, 11));
		String smonth=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 2, 12);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 2, 13));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 2, 14));
		String emonth=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 2, 15);
		
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 2, 16));
		
		 String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 2, 5);
		//String phaseName=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 5);
		String bulkType=Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 15);
		tp.clickOnAddTestCycleSymbol();
		tp.CreateCycle(cycleName, build, environment, hide);
		tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		tp.saveTestCycle();
		bp.waitForElement();
		
		String []cycle=new String [1];
		cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 2, 7);
		tp.navigateToCycle(cycle);
		
		// Rajneesh Execute now 
		
	    //tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday)
	    tp.addPhaseToCycle(phaseName);
	    bp.waitForElement();
	    System.out.println(bulkType);
	    tp.bulkAssignment(bulkType);
	    
	    bp.waitForElement();
	    
	    } catch(Exception e)
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

	@Then("^testcases successfully assigned to the the user$")
	public void testcases_successfully_assigned_to_the_the_user() throws Throwable {
	  try
	  {
		String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_1");
	   String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 2, 5);
	   int[] tcNo=new int[5];
	   for(int i=0;i<=4;i++)
	   {
		   tcNo[i]=i+1;
	   }
	   tp.doubleClickOnCycle(phaseName);
		tp.validateAllAssigned(tcNo, assignee);
		
	  } catch(Exception e)
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

	@When("^user navigate to test execution page$")
	public void user_navigate_to_test_execution_page() throws Throwable {
	    
		try
		{
		rp.clickOnTestExecution();
		
		} catch(Exception e)
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

	@When("^navigate to the assigned phase$")
	public void navigate_to_the_assigned_phase() throws Throwable {
	   
		try
		{
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			String[] phase=new String[2];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 2, 7);
			phase[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 2, 5);
		tr.navigateToNode(releaseName, phase);
		
		} catch(Exception e)
		{
			 lb=new LaunchBrowser();
            lb.getScreenShot(fileName);
			   e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			
		}
		//tr.navigateToNode(releaseName, navigation)
	}

	@When("^select first testcase and change the execution status to Pass$")
	public void select_first_testcase_and_change_the_execution_status_to_Pass() throws Throwable {
	  

		try
		{
		exe=new ExecutionPage(driver);
		int[] tcNo=new int[1];
		tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 1, 17);
		String status=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 18);
		exe.changeStatusOfTestCases(tcNo, status);
		
		} catch(Exception e)
		{
			 lb=new LaunchBrowser();
            lb.getScreenShot(fileName);
			   e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			
		}
		//exe.executeStatus(tcNo, statusType)
	}

	@Then("^execution status successfully chaged to Pass$")
	public void execution_status_successfully_chaged_to_Pass() throws Throwable {
	   
		try
		{
		int[] tcNo=new int[1];
		tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 1, 17);
		String status=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 18);
		exe.ValidateStatusOfTestCases(tcNo, status);
		
		} catch(Exception e)
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

	@When("^user click on defect button and update the login credential$")
	public void user_click_on_defect_button_and_update_the_login_credential() throws Throwable {
	  try
	  {
		int testcaseNo=Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 1, 17);
		exe.clickOnDefectButton(testcaseNo);
		
	  } catch(Exception e)
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

	@When("^create a new defect$")
	public void create_a_new_defect() throws Throwable {
		
		try
		{
		String defetID=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 20);
		String project=Excel_Lib.getData(INPUT_PATH_2, "Defects", 1, 7);
		String issueType=Excel_Lib.getData(INPUT_PATH_2, "Defects", 1, 8);
		boolean res=exe.searchDefect(defetID);
		
		dt=new DefectTracking(driver);
		if(res==false)
		{
		dt.createDefect(project,issueType);
		String summary=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 21);
		String component=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 99);
		
		String descType=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 23);
		String desc=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 24);
		String fixVersion=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 25);
		String priority=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 26);
		String assignee=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 27);
		String label=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 28);
		String sprint=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 29);
		String environment=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 30);
		String epicLink=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 31);
		String affectVersion=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 32);
		String linkedIssue=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1,33);
		
		//dt.fileNewDefect(summary,component,descType, desc,fixVersion,priority,assignee,label, sprint,environment, epicLink,affectVersion ,linkedIssue);
	    //exe.updateDefect();
		}
		
		} catch(Exception e)
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

	@Then("^defect should be created$")
	public void defect_should_be_created() throws Throwable {
	 
		try
		{
	   System.out.println("Defect Created sucessfuly");
	   
		} catch(Exception e)
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

	@When("^create seven more defect and read the Defect Id$")
	public void create_seven_more_defect_and_read_the_Defect_Id() throws Throwable {
		try
		{
		String project=Excel_Lib.getData(INPUT_PATH_2, "Defects", 1, 7);
		String issueType=Excel_Lib.getData(INPUT_PATH_2, "Defects", 1, 8); 
		for(int i=1;i<=7;i++)
		 {
			 
		String defetID=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", i+1, 20);
		 boolean res=exe.searchDefect(defetID);
		 if(res==false)
		 {
			 bp.waitForElement();
			  dt.createDefect(project,issueType);
			  String summary=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", i+1, 21);
			  String component=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 99);
				
				String descType=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 23);
				String desc=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 24);
				String fixVersion=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 25);
				String priority=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 26);
				String assignee=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 27);
				String label=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 28);
				String sprint=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 29);
				String environment=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 30);
				String epicLink=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 31);
				String affectVersion=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 32);
				String linkedIssue=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1,33);
				
//				exe.fileNewDefect(summary,component,descType, desc,fixVersion,priority,assignee,label, sprint,environment, epicLink,affectVersion ,linkedIssue); 
//	      
//		       exe.updateDefect();
		 }
	}

		} catch(Exception e)
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
	

	@When("^select the first defect in externa Jira and change status to Open$")
	public void select_the_first_defect_in_externa_Jira_and_change_status_to_Open() throws Throwable {
		
		try
		{
			ext=new ExternalJiraPage(driver);
	  String defetID=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 20);
	  String uname=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 3);
			  String password=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 4);
			  String defectStatus=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 19);
		exe.searchDefect(defetID);
		 exe.searchedDefect.click();
		 
		 
		 bp.switchWindowTab(1);
		 ext.loginToExternalJira(uname,password);
		 ext.changeDefectStatusInExternalJira(defectStatus);
		 
		 driver.close();
		 bp.switchWindowTab(0);
		 
		} catch(Exception e)
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

	@When("^select the second defect in externa Jira and change status to Open$")
	public void select_the_second_defect_in_externa_Jira_and_change_status_to_Open() throws Throwable {
		try
		{
		String defetID=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 2, 20);
		exe.searchDefect(defetID);
		 exe.searchedDefect.click();
		 bp.switchWindowTab(1);
		 String defectStatus=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 19);
		 //exe.loginToExternalJira(username, password);
		 ext.changeDefectStatusInExternalJira(defectStatus);
		
		 driver.close();
		 bp.switchWindowTab(0);
		 
		} catch(Exception e)
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

	@When("^select the third defect in externa Jira and change status to Open$")
	public void select_the_third_defect_in_externa_Jira_and_change_status_to_Open() throws Throwable {
		try
		{
		String defetID=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 3, 20);
		exe.searchDefect(defetID);
		 String defectStatus=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 19);
	
		 exe.searchedDefect.click();
		 bp.switchWindowTab(1);
		 //exe.loginToExternalJira(username, password);
		 ext.changeDefectStatusInExternalJira(defectStatus);
		 driver.close();
		 bp.switchWindowTab(0);
		 
		} catch(Exception e)
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

	@When("^select the fourth defect in externa Jira and change status to In Progress$")
	public void select_the_fourth_defect_in_externa_Jira_and_change_status_to_In_Progress() throws Throwable {
		try
		{
		String defetID=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 4, 20);
			exe.searchDefect(defetID);
			 String defectStatus=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 2, 19);
		
			 exe.searchedDefect.click();
			 bp.switchWindowTab(1);
			 //exe.loginToExternalJira(username, password);
			 ext.changeDefectStatusInExternalJira(defectStatus);
			 driver.close();
			 bp.switchWindowTab(0);
			 
		} catch(Exception e)
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

	@When("^select the fifth defect in externa Jira and change status to In Progress$")
	public void select_the_fifth_defect_in_externa_Jira_and_change_status_to_In_Progress() throws Throwable {
		try
		{
		String defetID=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 5, 20);
			exe.searchDefect(defetID);
			 String defectStatus=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 2, 19);
		
			 exe.searchedDefect.click();
			 bp.switchWindowTab(1);
			 //exe.loginToExternalJira(username, password);
			 ext.changeDefectStatusInExternalJira(defectStatus);
			 driver.close();
			 bp.switchWindowTab(0);
			 
		} catch(Exception e)
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

	@When("^select the sixth defect in externa Jira and change status to In Progress$")
	public void select_the_sixth_defect_in_externa_Jira_and_change_status_to_In_Progress() throws Throwable {
		try
		{
		String defetID=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 6, 20);
			exe.searchDefect(defetID);
			 String defectStatus=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 2, 19);
		
			 exe.searchedDefect.click();
			 bp.switchWindowTab(1);
			 //exe.loginToExternalJira(username, password);
			 ext.changeDefectStatusInExternalJira(defectStatus);
			 driver.close();
			 bp.switchWindowTab(0);
			 
		} catch(Exception e)
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

	@When("^select the seventh defect in externa Jira and change status to Done$")
	public void select_the_seventh_defect_in_externa_Jira_and_change_status_to_Done() throws Throwable {
		try
		{
		String defetID=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 7, 20);
			exe.searchDefect(defetID);
			 String defectStatus=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 3, 19);
		
			 exe.searchedDefect.click();
			 bp.switchWindowTab(1);
			 //exe.loginToExternalJira(username, password);
			 ext.changeDefectStatusInExternalJira(defectStatus);
			 driver.close();
			 bp.switchWindowTab(0);
			 
		} catch(Exception e)
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

	@When("^select the eighth defect in externa Jira and change status to Done$")
	public void select_the_eighth_defect_in_externa_Jira_and_change_status_to_Done() throws Throwable {
		try
		{
		String defetID=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 8, 20);
			exe.searchDefect(defetID);
			 String defectStatus=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 3, 19);
		
			 exe.searchedDefect.click();
			 bp.switchWindowTab(1);
			 //exe.loginToExternalJira(username, password);
			 ext.changeDefectStatusInExternalJira(defectStatus);
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 ext=new ExternalJiraPage(driver);
			 //ext.logOutFromExternal_JIRA();
			 driver.close();
			 bp.switchWindowTab(0);
			 bp.waitForElement();
			 bp.moveToElementAndClick(exe.cancelDefect);
			 bp.waitForElement();
			
			
		} catch(Exception e)
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
