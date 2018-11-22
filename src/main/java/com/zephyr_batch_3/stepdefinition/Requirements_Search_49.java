package com.zephyr_batch_3.stepdefinition;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Requirements_Search_49 extends LaunchBrowser {
	//LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	TestPlanningPage tp;
	LaunchBrowser lb=new LaunchBrowser();
	String[] a = new String[1];
	ExportPage ep;
	String screen="Requirements_Search_49";

	boolean[] actual=new boolean[25];
	SoftAssert soft=new SoftAssert();
	 
	@Given("^user in the Requirements page$")
	public void user_in_the_Requirements_page() throws Throwable {
		try
		{
			   bp=new BasePage();
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Normal_Project_2");
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
			   actual[0]=pp.selectProject(projectName);
			   actual[1]=pp.selectRelease(releaseName);
			   bp.waitForElement(); 
			   rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[2]=rp.clickOnRequirements();
			}
			catch(Exception e)
			 {
			  e.printStackTrace();
			  lb.getScreenShot(screen);
			  driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			  rl.reLogin();
			  throw e;
			 }
	}

	@When("^user adds a node and add requirement to the node$")
	public void user_adds_a_node_and_add_requirement_to_the_node() throws Throwable {
		try
		{
		 bp=new BasePage();
			String fileName=Excel_Lib.getData(INPUT_PATH_7,"Releases",1,0);
			tr=new TestRepositoryPage(driver);
			actual[3]=tr.clickOnRelease(fileName);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"Requirements",1,1);
	    	String desc=Excel_Lib.getData(INPUT_PATH_7,"Requirements",1,2);
	    	req=new RequirementsPage(driver);
	    	actual[4]=req.addNode(name, desc);
	    	actual[5]=tr.doubleClickOnRelease(fileName);
	    	//String fileName1=Excel_Lib.getData(INPUT_PATH_7,"Releases",1,0);
			String navigation[]=new String[1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"Requirements",1,1);
			bp.waitForElement();
			actual[6]=tr.navigateToNode(fileName, navigation);
			req.addRequirement();
			int k = 0;
		    for (int i = 1; i <= 1; i++) {

		     a[k] = driver.findElement(
		       By.xpath(req.requirementID1 + i + req.requirementID2))
		       .getText();
		     System.out.println(a[k]);
		     k++;
		    }
		
		}
		catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(screen);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }
	    
	}
	
	@When("^user enter the requirement name,altId,link,priority and few custom fields$")
	public void user_enter_the_requirement_name_altId_link_priority_and_few_custom_fields() throws Throwable {
		try{
			bp=new BasePage();
			bp.waitForElement();
			req=new RequirementsPage(driver);
			tr.clickOnDetails();
			String text=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 1, 15);
			String longText=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 2, 15);
			String number=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 100, 100);
			String checkBox=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 100, 100);
			String pickupList=Excel_Lib.getData(INPUT_PATH_7, "Requirements",3, 15);
			String date=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 100, 100);
			actual[7]=req.enterCustomFieldInRequirementPage(text, longText, number, checkBox, pickupList, date);
			bp.waitForElement();
			
			String name=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 1, 5);
			String altId=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 2, 8);
			String link=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 1, 9);
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 1, 4);
			String details=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 3, 6);
			actual[8]=req.enterRequirementDetails(name, altId, link, priority, details);   
			bp.waitForElement();
		
		}
		    catch(Exception e)
			{
				e.printStackTrace();
				 lb.getScreenShot(screen);
				  driver.close();
				 Relogin_TPE rl=new Relogin_TPE();
				  rl.reLogin();
				  throw e;
				
			}
	    
	}


	@When("^user Navigates to search view$")
	public void user_Navigates_to_search_view() throws Throwable {
		try
		{
		tr=new TestRepositoryPage(driver);
		bp.waitForElement();
		actual[9]=tr.clickOnSearch();
		bp.pageLoad();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(screen);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE(); 
			rl.reLogin();
			throw e;	
		}
	   
	}

	@When("^search requirements by altid, creator, details, and id, using ZQL$")
	public void search_requirements_by_altid_creator_details_and_id_using_ZQL() throws Throwable {
		try
		{
			tp=new TestPlanningPage(driver);
			bp.waitForElement();
			actual[10]=tp.clickOnAdvanceSearch();
			bp.pageLoad();
			req=new RequirementsPage(driver);
			String searchRes1=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 4,6);
		      String creator=Property_Lib.getPropertyValue(CONFIG_PATH
		     + CONFIG_FILE_REQ, "Lead_Username_1");
		      String searchRes2=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 5,6);
		      String id=a[0];
		      String finalSearch=searchRes1+creator+searchRes2+id;
			//String requirements=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 4, 6);
			actual[11]=req.searchAndAdd(finalSearch);

			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(screen);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	    
	}

	@Then("^should able to retrieve matching rows in requirement$")
	public void should_able_to_retrieve_matching_rows_in_requirement() throws Throwable {
		try
		{
			actual[12]=req.VerifyRequirementCount();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(screen);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	    
	}

	@When("^Search requirements by creator, details and name, using ZQL$")
	public void search_requirements_by_creator_details_and_name_using_ZQL() throws Throwable {
		try
		{
			
			actual[13]=tp.clickOnAdvanceSearch();
			bp.pageLoad();
			String searchRes1=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 7,6);
		      String creator=Property_Lib.getPropertyValue(CONFIG_PATH
		     + CONFIG_FILE_REQ, "Lead_Username_1");
		      String searchRes2=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 8,6);
		      String finalSearch=searchRes1+creator+searchRes2;
			actual[14]=req.searchAndAdd(finalSearch);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(screen);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^Should be able to retrieve matching rows in requirement$")
	public void should_be_able_to_retrieve_matching_rows_in_requirement() throws Throwable {
		try
		{
			actual[15]=req.VerifyRequirementCount();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(screen);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	    
	}

	@When("^Search requirements by details, name and priority, using ZQL$")
	public void search_requirements_by_details_name_and_priority_using_ZQL() throws Throwable {
		try
		{

			actual[16]=tp.clickOnAdvanceSearch();
			bp.pageLoad();
			String requirements=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 10, 6);
			actual[17]=req.searchAndAdd(requirements);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(screen);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	    
	}

	@Then("^Should be able to retrieve matching rows$")
	public void should_be_able_to_retrieve_matching_rows() throws Throwable {
		try
		{
			actual[18]=req.VerifyRequirementCount();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(screen);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	    
	    
	}
	
	@When("^Search requirements by name, priority, project and url, using ZQL$")
	public void search_requirements_by_name_priority_project_and_url_using_ZQL() throws Throwable {
		try
		{
			
			actual[19]=tp.clickOnAdvanceSearch();
			bp.pageLoad();
			String searchRes1=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 15,6);
		      String projectName=Property_Lib.getPropertyValue(CONFIG_PATH
		     + CONFIG_FILE_REQ, "Normal_Project_2");
		      String searchRes2=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 16,6);
		      String finalSearch=searchRes1+projectName+searchRes2;
			actual[20]=req.searchAndAdd(finalSearch);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(screen);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^should be Able to retrieve matching rows$")
	public void should_be_Able_to_retrieve_matching_rows() throws Throwable {
		try
		{
			actual[21]=req.VerifyRequirementCount();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(screen);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Search requirements by altid, creator, details, name, priority, project, url, text, long text and picklist,using ZQL$")
	public void search_requirements_by_altid_creator_details_name_priority_project_url_text_long_text_and_picklist_using_ZQL() throws Throwable {
		try
		{
			
			actual[22]=tp.clickOnAdvanceSearch();
			bp.pageLoad();
			String searchRes11=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 4,6);
			String searchRes1=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 18,6);
			 String creator1=Property_Lib.getPropertyValue(CONFIG_PATH
				     + CONFIG_FILE_REQ, "Lead_Username_1");
		      String creator=Property_Lib.getPropertyValue(CONFIG_PATH
		     + CONFIG_FILE_REQ, "Normal_Project_2");
		      String searchRes2=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 19,6);
		      String finalSearch=searchRes11+creator1+searchRes1+creator+searchRes2;
			actual[23]=req.searchAndAdd(finalSearch);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(screen);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^should be Able to retrieve the matching rows$")
	public void should_be_Able_to_retrieve_the_matching_rows() throws Throwable {
		try
		{
			actual[24]=req.VerifyRequirementCount();
			tr.clickedOnFolder();
			bp.waitForElement();
			tr.clickOnList();
			 for(int k=0;k<=actual.length-1;k++)
		     {
		      System.out.println("Actual["+k+"]="+actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(screen);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

}
