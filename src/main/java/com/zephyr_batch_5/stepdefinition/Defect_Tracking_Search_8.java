package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Search_8 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	DefectTracking dt;
	TestRepositoryPage tr;
	String fileName="Defect_Tracking_Search_8";
	
	boolean[] actual=new boolean[33];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in Defect Tracking page$")
	public void user_is_in_Defect_Tracking_page() throws Throwable {
	   try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 pp=new ProjectPage(driver);
		 bp=new BasePage();
		 rp=new ReleasePage(driver);
		 tr=new TestRepositoryPage(driver);
		 dt=new DefectTracking(driver);
		 pp.selectProject(projectName);
		
		// pp.backToProjectPage();
		
		 
		 
		 
		 pp.selectRelease(releaseName);
		 actual[0]=pp.clickOnDefectTracking();
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

	@When("^User search a defect by entering project name$")
	public void user_search_a_defect_by_entering_project_name() throws Throwable {
		 try
		   {
			 String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,0);
			 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String filedBy=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String version=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 dt=new DefectTracking(driver);
			 actual[1]=dt.defectSearch(projectName, issueType, status, filedBy, version, priority, assignee);
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

	@Then("^Should be able to search the defect$")
	public void should_be_able_to_search_the_defect() throws Throwable {
		try
		   {
			 tr=new TestRepositoryPage(driver);
			 actual[2]=tr.verifyPresentTestCase();
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

	@When("^User search a defect by entering project name and issue type$")
	public void user_search_a_defect_by_entering_project_name_and_issue_type() throws Throwable {
		try
		   {
			 String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,0);
			 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
			 String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String filedBy=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String version=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 rp=new ReleasePage(driver);
			 rp.clickOnTestRep();
			 bp.waitForElement();
			 pp.clickOnDefectTracking();
			 actual[3]=dt.defectSearch(projectName, issueType, status, filedBy, version, priority, assignee);
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

	@Then("^Should be able to Search defect$")
	public void should_be_able_to_Search_defect() throws Throwable {
		try
		   {
			 tr.verifyPresentTestCase();
			 String bugName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 2);
			 actual[4]=dt.validateDefect(bugName);
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

	@When("^User search a defect by entering project name,issue type and status$")
	public void user_search_a_defect_by_entering_project_name_issue_type_and_status() throws Throwable {
		try
		   {
			String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,0);
			 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
			 String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,3);
			 String filedBy=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String version=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 rp.clickOnTestRep();
			 bp.waitForElement();
			 pp.clickOnDefectTracking();
			 actual[5]=dt.defectSearch(projectName, issueType, status, filedBy, version, priority, assignee);
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

	@Then("^Should be able to search a defect$")
	public void should_be_able_to_search_a_defect() throws Throwable {
		try
		   {
			 tr.verifyPresentTestCase();
			 String bugName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 2);
			 actual[6]=dt.validateDefect(bugName);
			 String statusName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 3);
			 actual[7]=dt.validateDefect(statusName);
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

	@When("^User search a defect by project name and version$")
	public void user_search_a_defect_by_project_name_and_version() throws Throwable {
		try
		   {
			 String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,0);
			 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String filedBy=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String version=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,5);
			 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 rp.clickOnTestRep();
			 bp.waitForElement();
			 pp.clickOnDefectTracking();
			 actual[8]=dt.defectSearch(projectName, issueType, status, filedBy, version, priority, assignee);
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

	@Then("^Should Be able to search$")
	public void should_Be_able_to_search() throws Throwable {
		try
		   {
			 actual[9]=tr.verifyPresentTestCase();
			 String versionName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 5);
			 //actual[9]=dt.validateDefect(versionName);
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

	@When("^User search a defect by selecting assignee from dropdown$")
	public void user_search_a_defect_by_selecting_assignee_from_dropdown() throws Throwable {
		try
		   {
			String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,00);
			 String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String filedBy=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String version=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,4);
			 rp.clickOnTestRep();
			 bp.waitForElement();
			 pp.clickOnDefectTracking();
			 actual[10]=dt.defectSearch(projectName, issueType, status, filedBy, version, priority, assignee);
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

	@Then("^Should be Able to search the defect$")
	public void should_be_Able_to_search_the_defect() throws Throwable {
		try
		   {
			 actual[11]=tr.verifyPresentTestCase();
			 String assigneeName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 5);
			 //dt.validateDefect(assigneeName);
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

	@When("^User search a defect by project name and priority$")
	public void user_search_a_defect_by_project_name_and_priority() throws Throwable {
		try
		   {
			String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,0);
			 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String filedBy=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String version=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,6);
			 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 rp.clickOnTestRep();
			 bp.waitForElement();
			 pp.clickOnDefectTracking();
			 bp.waitForElement();
			 actual[12]=dt.defectSearch(projectName, issueType, status, filedBy, version, priority, assignee);
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

	@Then("^Shoulb be aBle to search$")
	public void shoulb_be_aBle_to_search() throws Throwable {
		try
		   {
			 tr.verifyPresentTestCase();
			 String priorityName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 6);
			 actual[13]=dt.validateDefect(priorityName);
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

	@When("^User search a defect by the filed by$")
	public void user_search_a_defect_by_the_filed_by() throws Throwable {
		try
		   {
			String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String filedBy=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,4);
			 String version=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 rp.clickOnTestRep();
			 bp.waitForElement();
			 pp.clickOnDefectTracking();
			 bp.waitForElement();
			 actual[14]=dt.defectSearch(projectName, issueType, status, filedBy, version, priority, assignee);
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

	@Then("^Should be abLe to search$")
	public void should_be_abLe_to_search() throws Throwable {
		try
		   {
			 actual[15]=tr.verifyPresentTestCase();
			 String assigneeName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 5);
			 //dt.validateDefect(assigneeName);
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

	@When("^User search a defect by project name/issue type/status/version/assignee/priority/filed by$")
	public void user_search_a_defect_by_project_name_issue_type_status_version_assignee_priority_filed_by() throws Throwable {
		try
		   {
			String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,0);
			 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
			 String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,3);
			 String filedBy=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,4);
			 String version=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,5);
			 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,6);
			 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,5);
			 rp.clickOnTestRep();
			 bp.waitForElement();
			 pp.clickOnDefectTracking();
			 bp.waitForElement();
			 actual[16]=dt.defectSearch(projectName, issueType, status, filedBy, version, priority, assignee);
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

	@Then("^Should be ablE to search$")
	public void should_be_ablE_to_search() throws Throwable {
		try
		   {
			 actual[17]=tr.verifyPresentTestCase();
			 String issueTypeName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 2);
			 String statusName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 3);
			 String priorityName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 6);
			 actual[18]=dt.validateDefect(issueTypeName);
			 actual[19]=dt.validateDefect(statusName);
			 actual[20]=dt.validateDefect(priorityName);
			 
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

	@When("^User search a defect by jira id$")
	public void user_search_a_defect_by_jira_id() throws Throwable {
		try
		   {
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 7);
			 rp.clickOnTestRep();
			 bp.waitForElement();
			 pp.clickOnDefectTracking();
			 bp.waitForElement();
			 actual[21]=dt.searchDefect(defectID);
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

	@Then("^Should be able To search$")
	public void should_be_able_To_search() throws Throwable {
		try
		   {
			 tr.verifyPresentTestCase();
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2, 7);
			 actual[22]=dt.validateDefect(defectID);
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

	@When("^User attempt search a defect by jira id which is non existing$")
	public void user_attempt_search_a_defect_by_jira_id_which_is_non_existing() throws Throwable {
		try
		   {
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 8);
			 rp.clickOnTestRep();
			 bp.waitForElement();
			 pp.clickOnDefectTracking();
			 bp.waitForElement();
			 actual[23]=dt.searchDefect(defectID);
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

	@Then("^Should not be able to search$")
	public void should_not_be_able_to_search() throws Throwable {
		try
		{
			 actual[24]=tr.verifyPresentTestCase();
//			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 8);
//			 dt.validateDefect(defectID);
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

	@When("^User search a defect by its id using advanced search$")
	public void user_search_a_defect_by_its_id_using_advanced_search() throws Throwable {
		try
		{
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 9);
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 10);
		 rp=new ReleasePage(driver);//
		 tr=new TestRepositoryPage(driver);//
		 dt=new DefectTracking(driver);//
		 actual[25]=dt.advancedSearch(selectSearch, defectID);	
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

	@Then("^Should be able tO search$")
	public void should_be_able_tO_search() throws Throwable {
		try
		{
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2, 7);
		 actual[26]=dt.validateAdvancedSearch(defectID);	
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

	@When("^User search a defect by using JQL$")
	public void user_search_a_defect_by_using_JQL() throws Throwable {
		try
		{
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 9);
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 10);
		 rp.clickOnTestRep();
		 bp.waitForElement();
		 pp.clickOnDefectTracking();
		 bp.waitForElement();
		 actual[27]=dt.advancedSearch(selectSearch, defectID);	
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

	@Then("^Should be able to Search$")
	public void should_be_able_to_Search() throws Throwable {
		try
		{
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2, 7);
		 actual[28]=dt.validateAdvancedSearch(defectID);	
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

	@When("^search a defect by filter using advanced search$")
	public void search_a_defect_by_filter_using_advanced_search() throws Throwable {
		try
		{
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 9);
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 10);
		 rp.clickOnTestRep();
		 bp.waitForElement();
		 pp.clickOnDefectTracking();
		 bp.waitForElement();
		 actual[29]=dt.advancedSearch(selectSearch, defectID);	
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

	@Then("^Should be able to sEarch$")
	public void should_be_able_to_sEarch() throws Throwable {
		try
		{
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2, 7);
		 actual[30]=dt.validateAdvancedSearch(defectID);	
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

	@When("^search a non existing defect by using advanced search$")
	public void search_a_non_existing_defect_by_using_advanced_search() throws Throwable {
		try
		{
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 9);
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2, 10);
		 rp.clickOnTestRep();
		 bp.waitForElement();
		 pp.clickOnDefectTracking();
		 bp.waitForElement();
		 actual[31]=dt.advancedSearch(selectSearch, defectID);	
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
	
	@Then("^Should Not be able to search$")
	public void should_Not_be_able_to_search() throws Throwable {
		try
		{
			 actual[32]=tr.verifyPresentTestCase();
//			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 8);
//			 dt.validateDefect(defectID);
			 //pp.backToProjectPage();
			 for(int k=0;k<=actual.length-1;k++)
				{
					System.out.println("Actual["+k+"]="+actual[k]);
					//soft.assertEquals(actual[k], true);
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
