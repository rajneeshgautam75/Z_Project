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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Requirements_Search_47 extends LaunchBrowser {
	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ExportPage ep;
	TestPlanningPage tp;
	LaunchBrowser lb=new LaunchBrowser();
	String[] a = new String[1];
	String screen="Requirements_Search_47";
	
	boolean[] actual=new boolean[24];
	 SoftAssert soft=new SoftAssert();
	 
	@Given("^user in the requirements page$")
	public void user_in_the_requirements_page() throws Throwable {
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
	@When("^user add a node and add requirement to the node$")
public void user_add_a_node_and_add_requirement_to_the_node() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);
			req=new RequirementsPage(driver);
			String fileName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
			actual[3]=tr.clickOnRelease(fileName);
			//req.minimizeFolderNode(fileName);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"Requirements",2,1);
	    	String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"Requirements",2,2);
	    	actual[4]=req.addNode(name, desc);
			String navigation[]=new String[1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"Requirements",2,1);
			actual[5]=tr.navigateToNode(fileName, navigation);
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

@When("^enter user enter the requirement name,altId,link,priority$")
public void enter_user_enter_the_requirement_name_altId_link_priority() throws Throwable {
	try{
		bp=new BasePage();
		bp.waitForElement();
		tr.clickOnDetails();
		String text = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 1, 25);
		String longText = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 25);
		String number = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 100, 100);
		String checkBox = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 3, 25);
		String pickupList = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 100, 100);
		String date = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 100, 100);
		actual[8] = req.enterCustomFieldInRequirementPage(text, longText, number, checkBox, pickupList, date);
		
		String name=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 3, 5);
		String altId=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 2, 8);
		String link=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 2, 9);
		String priority=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 3, 4);
		String Description=Excel_Lib.getData(INPUT_PATH_7, "Requirements", 2, 6);
		actual[6]=req.enterRequirementDetails(name, altId, link, priority, Description);    
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

	@When("^user navigates to search folder$")
	public void user_navigates_to_search_folder() throws Throwable {
		try
		{ 
			bp.waitForElement();
			actual[7]=tr.clickOnSearch();
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
	

	@When("^search requirements by id in quick search$")
	public void search_requirements_by_id_in_quick_search() throws Throwable {
    try
    {
    	String id=a[0];
       np=new NavigationPage(driver);
       actual[8]=req.quickSearch();
       actual[9]=np.quiksearch(id);   
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

	@Then("^Should be able to retrieve requirements by Id$")
	public void should_be_able_to_retrieve_requirements_by_Id() throws Throwable {
		try
		{
		actual[10]=req.VerifyRequirementCount();
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

	@When("^search requirements by name in quick search$")
	public void search_requirements_by_name_in_quick_search() throws Throwable {
		try{
		  
			actual[11]=req.quickSearch();
		   String priority=Excel_Lib.getData(INPUT_PATH_7,"Requirements",3,5);
	 	   actual[12]=np.quiksearch(priority);
	   
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

	@Then("^Should be able to retrieve requirements by name$")
	public void should_be_able_to_retrieve_requirements_by_name() throws Throwable {
		try
		{
		actual[13]=req.VerifyRequirementCount();
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

	@When("^search requirements by details in quick search$")
	public void search_requirements_by_details_in_quick_search() throws Throwable {
		try{
			   bp.waitForElement();
			   actual[14]=req.quickSearch();
			   String priority=Excel_Lib.getData(INPUT_PATH_7,"Requirements",2,6);
		 	   actual[15]=np.quiksearch(priority);
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

	@Then("^Should be able to retrieve requirements by details$")
	public void should_be_able_to_retrieve_requirements_by_details() throws Throwable {
		try
		{
		actual[16]=req.VerifyRequirementCount();
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

	@When("^search requirements by AltId in quick search$")
	public void search_requirements_by_AltId_in_quick_search() throws Throwable {
		try{
			  
			   actual[17]=req.quickSearch();
			   String priority=Excel_Lib.getData(INPUT_PATH_7,"Requirements",2,8);
		 	   actual[18]=np.quiksearch(priority);
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

	@Then("^Should be able to retrieve requirements by AltId$")
	public void should_be_able_to_retrieve_requirements_by_AltId() throws Throwable {
		try
		{
		actual[19]=req.VerifyRequirementCount();
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

	@When("^search requirements by link in quick search$")
	public void search_requirements_by_link_in_quick_search() throws Throwable {
		try{
			  
			   actual[20]=req.quickSearch();
			   String priority=Excel_Lib.getData(INPUT_PATH_7,"Requirements",2,9);
		 	   actual[21]=np.quiksearch(priority);
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

	@Then("^Should be able to retrieve requirements by link$")
	public void should_be_able_to_retrieve_requirements_by_link() throws Throwable {
		try
		{
		actual[22]=req.VerifyRequirementCount();
		actual[23]=tr.clickedOnFolder();
		           bp.waitForElement();
		           tr.clickOnList();
		for(int i=0;i<=actual.length-1;i++)
		{
			System.out.println(actual[i]);
			soft.assertEquals(actual[i],true);
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
