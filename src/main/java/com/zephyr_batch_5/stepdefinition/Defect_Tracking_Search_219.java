package com.zephyr_batch_5.stepdefinition;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Search_219 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestPlanningPage tp;
	TestRepositoryPage tr;
	ExecutionPage ep;
	CreateTestCasePage ctc;
	DefectTracking dt;
	RequirementsPage req;
	boolean[] actual=new boolean[89];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_Search_219";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");

	@Given("^user will launch defect Tracking Page$")
	public void user_will_launch_defect_Tracking_Page() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			lp=new LoginPage(driver);
			bp=new BasePage();
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			ep=new ExecutionPage(driver);
			req=new RequirementsPage(driver);
			dt=new DefectTracking(driver);
			actual[0]=pp.selectProject(project);
			actual[1]=pp.selectRelease(release);
			actual[2]=pp.clickOnDefectTracking();
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
	
	@When("^user searches Defects Using JQL by priority with = operator$")
	public void user_searches_Defects_Using_JQL_by_priority_with_operator() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 32, 5);
			bp.waitForElement();
		    actual[3]=dt.advancedSearch(jql, value);
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
	
	@Then("^should Able to search defects using JQL by priority$")
	public void should_Able_to_search_defects_using_JQL_by_priority() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[4]=req.verifySearchRequirementCount();
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
	
	@When("^In Test Execution,user searches the Defects using JQL by priority with = Operator$")
	public void in_Test_Execution_user_searches_the_Defects_using_JQL_by_priority_with_Operator() throws Throwable {
		try
		{
			
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 32, 5);
			bp.waitForElement();
			actual[5]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[6]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[7]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[8]=ep.changeMultiSelectedStatus(status); 
			bp.waitForElement();
			actual[9]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			bp.waitForElement();
		    actual[10]=ep.defectSearch(jql, value);
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
	
	@Then("^in Test Execution page,should able to search Defects using JQL by priority$")
	public void in_Test_Execution_page_should_able_to_search_Defects_using_JQL_by_priority() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[11]=ep.verifySearchedDefectCount();
			bp.waitForElement();
			actual[12]=ep.closeLinkedDefectWindow();
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
	
	@When("^In defect tracking,User searches defects using JQL by priority with != operator$")
	public void in_defect_tracking_User_searches_defects_using_JQL_by_priority_with_operator() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 33, 5);
			actual[13]=pp.clickOnDefectTracking();
			bp.waitForElement();
		    actual[14]=dt.advancedSearch(jql, value);
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
	
	@Then("^Defects should be searched Using jql by Priority$")
	public void defects_should_be_searched_Using_jql_by_Priority() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[15]=req.verifySearchRequirementCount();
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
	
	@When("^in test execution,search the defects using JQL by priority with != operator$")
	public void in_test_execution_search_the_defects_using_JQL_by_priority_with_operator() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 33, 5);
			actual[16]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[17]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[18]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[19]=ep.changeMultiSelectedStatus(status); 
			bp.waitForElement();
			actual[20]=ep.clickOnDefectButton(testcase1);
		    actual[21]=ep.defectSearch(jql, value);
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
	
	@Then("^defects should search using JQL by priority with != operator in Test Execution page$")
	public void defects_should_search_using_JQL_by_priority_with_operator_in_Test_Execution_page() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[22]=ep.verifySearchedDefectCount();
			bp.waitForElement();
			actual[23]=ep.closeLinkedDefectWindow();
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
	
	@When("^Search defects using JQL by priority with AND operator in Defect tracking page$")
	public void search_defects_using_JQL_by_priority_with_AND_operator_in_Defect_tracking_page() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 34, 5);
			actual[24]=pp.clickOnDefectTracking();
			bp.waitForElement();
		    actual[25]=dt.advancedSearch(jql, value);
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
	
	@Then("^should be able to search defects using JQL by priority in Defect tracking page$")
	public void should_be_able_to_search_defects_using_JQL_by_priority_in_Defect_tracking_page() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[26]=req.verifySearchRequirementCount();
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
	
	@When("^In Test Execution,search Defects using JQL by priority with AND operator$")
	public void in_Test_Execution_search_Defects_using_JQL_by_priority_with_AND_operator() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 34, 5);
			bp.waitForElement();
			actual[27]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[28]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[29]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[30]=ep.changeMultiSelectedStatus(status); 
			bp.waitForElement();
			actual[31]=ep.clickOnDefectButton(testcase1);
		    actual[32]=ep.defectSearch(jql, value);
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
	
	@Then("^should Able to Search defects using JQL by priority with AND operator$")
	public void should_Able_to_Search_defects_using_JQL_by_priority_with_AND_operator() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[33]=ep.verifySearchedDefectCount();
			bp.waitForElement();
			actual[34]=ep.closeLinkedDefectWindow();
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
	
	@When("^In defect tracking page,user Searches defects using JQL by priority with OR operator$")
	public void in_defect_tracking_page_user_Searches_defects_using_JQL_by_priority_with_OR_operator() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 35, 5);
			actual[35]=pp.clickOnDefectTracking();
			bp.waitForElement();
		    actual[36]=dt.advancedSearch(jql, value);
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
	
	@Then("^defects should search Using JQL by priority With OR Operator$")
	public void defects_should_search_Using_JQL_by_priority_With_OR_Operator() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[37]=req.verifySearchRequirementCount();
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
	
	@When("^In Test Execution,searches defects using JQL by priority with OR operator$")
	public void in_Test_Execution_searches_defects_using_JQL_by_priority_with_OR_operator() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[38]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[39]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[40]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[41]=ep.changeMultiSelectedStatus(status); 
			bp.waitForElement();
			actual[42]=ep.clickOnDefectButton(testcase1);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 35, 5);
		    actual[43]=ep.defectSearch(jql, value);
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
	
	@Then("^In test execution, defects should search using JQL by priority$")
	public void in_test_execution_defects_should_search_using_JQL_by_priority() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[44]=ep.verifySearchedDefectCount();
			bp.waitForElement();
			actual[45]=ep.closeLinkedDefectWindow();
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
	
	@When("^User searches defects using jql by fix version with IN operator in defect tracking$")
	public void user_searches_defects_using_jql_by_fix_version_with_IN_operator_in_defect_tracking() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 36, 5);
			actual[46]=pp.clickOnDefectTracking();
			bp.waitForElement();
		    actual[47]=dt.advancedSearch(jql, value);
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
	
	@Then("^Defects should search using jql by fix version with IN operator$")
	public void defects_should_search_using_jql_by_fix_version_with_IN_operator() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[48]=req.verifySearchRequirementCount();
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
	
	@When("^In test execution page,User searches Defects using jql by fix version with IN Operator$")
	public void in_test_execution_page_User_searches_Defects_using_jql_by_fix_version_with_IN_Operator() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 36, 5);
			bp.waitForElement();
			actual[49]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[50]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[51]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[52]=ep.changeMultiSelectedStatus(status); 
			bp.waitForElement();
			actual[53]=ep.clickOnDefectButton(testcase1);
		    actual[54]=ep.defectSearch(jql, value);
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
	
	@Then("^in test execution page Defects should be searched using JQL by fix version$")
	public void in_test_execution_page_Defects_should_be_searched_using_JQL_by_fix_version() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[55]=ep.verifySearchedDefectCount();
			bp.waitForElement();
			actual[56]=ep.closeLinkedDefectWindow();
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
	
	@When("^user search defects using jql by fix version With NOT IN operator in Defect tracking Page$")
	public void user_search_defects_using_jql_by_fix_version_With_NOT_IN_operator_in_Defect_tracking_Page() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 37, 5);
			actual[57]=pp.clickOnDefectTracking();
			bp.waitForElement();
		    actual[58]=dt.advancedSearch(jql, value);
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
	
	@Then("^Defects should be searched using JQL by fix version with NOT IN Operator$")
	public void defects_should_be_searched_using_JQL_by_fix_version_with_NOT_IN_Operator() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[59]=req.verifySearchRequirementCount();
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
	
	@When("^in Test execution page User searches Defects Using jql by fix version with NOT IN operator$")
	public void in_Test_execution_page_User_searches_Defects_Using_jql_by_fix_version_with_NOT_IN_operator() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 37, 5);
			bp.waitForElement();
			actual[60]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[61]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[62]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[63]=ep.changeMultiSelectedStatus(status); 
			bp.waitForElement();
			actual[64]=ep.clickOnDefectButton(testcase1);
		    actual[65]=ep.defectSearch(jql, value);
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
	
	@Then("^In test execution page, Defects to be able to search using jql by fix version$")
	public void in_test_execution_page_Defects_to_be_able_to_search_using_jql_by_fix_version() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[66]=req.verifySearchRequirementCount();
		ep.clickOnCancelDefectWindow();
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
	
	@When("^In defect tracking user searches defects Using jql by fix version with IS operator$")
	public void in_defect_tracking_user_searches_defects_Using_jql_by_fix_version_with_IS_operator() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 38, 5);
			actual[67]=pp.clickOnDefectTracking();
			bp.waitForElement();
		    actual[68]=dt.advancedSearch(jql, value);
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
	
	@Then("^defects should be searched using JQL By fix version with IS Operator$")
	public void defects_should_be_searched_using_JQL_By_fix_version_with_IS_Operator() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[69]=req.verifySearchRequirementCount();
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
	
	@When("^In Test execution,searches defects using JQL by fix version with IS operator$")
	public void in_Test_execution_searches_defects_using_JQL_by_fix_version_with_IS_operator() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 38, 5);
			bp.waitForElement();
			actual[70]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[71]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[72]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[73]=ep.changeMultiSelectedStatus(status); 
			bp.waitForElement();
			actual[74]=ep.clickOnDefectButton(testcase1);
		    actual[75]=ep.defectSearch(jql, value);
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
	
	@Then("^In Test execution Page, defects should search using JQL by fix version with IS Operator$")
	public void in_Test_execution_Page_defects_should_search_using_JQL_by_fix_version_with_IS_Operator() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[76]=ep.verifySearchedDefectCount();
			bp.waitForElement();
			actual[77]=ep.closeLinkedDefectWindow();
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
	
	@When("^In defect tracking Page,user will search defects using JQL by fix version With IS NOT Operator$")
	public void in_defect_tracking_Page_user_will_search_defects_using_JQL_by_fix_version_With_IS_NOT_Operator() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 39, 5);
			actual[78]=pp.clickOnDefectTracking();
			bp.waitForElement();
		    actual[79]=dt.advancedSearch(jql, value);
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
	
	@Then("^defects should Be searched using JQL by fix version with IS NOT Operator$")
	public void defects_should_Be_searched_using_JQL_by_fix_version_with_IS_NOT_Operator() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[80]=req.verifySearchRequirementCount();
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
	
	@When("^In test execution,searches defects using JQL by fix version with IS NOT operator$")
	public void in_test_execution_searches_defects_using_JQL_by_fix_version_with_IS_NOT_operator() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 39, 5);
			bp.waitForElement();
			actual[81]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[82]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[83]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[84]=ep.changeMultiSelectedStatus(status); 
			bp.waitForElement();
			actual[85]=ep.clickOnDefectButton(testcase1);
		    actual[86]=ep.defectSearch(jql, value);
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
	
	@Then("^In test execution,defects should Search Using JQL by fix version with IS NOT Operator$")
	public void in_test_execution_defects_should_Search_Using_JQL_by_fix_version_with_IS_NOT_Operator() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[87]=ep.verifySearchedDefectCount();
			bp.waitForElement();
			actual[88]=ep.closeLinkedDefectWindow();
			for(int k=0;k<=actual.length-1;k++)
			{
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
