package com.zephyr_batch_3.stepdefinition;

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
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Export_Requirements_45 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ExportPage ep;
	String fileName="Exports_Requirements_45";
	
	boolean[] actual=new boolean[13];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the Requirements page App$")
	public void user_is_in_the_Requirements_page_App() throws Throwable {
		try
	    {
	    	bp=new BasePage();
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Normal_Project_1");
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
			   actual[0]=pp.selectProject(projectName);
			   bp.waitForElement();
			   actual[1]=pp.selectRelease(releaseName);
			   bp.waitForElement();
			   
			   rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[2]=rp.clickOnRequirements();
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

	@When("^User click on the Export Requirements button$")
	public void user_click_on_the_Export_Requirements_button() throws Throwable {
		try
		   {
			   bp=new BasePage();
			   ep=new ExportPage(driver);
			   tr=new TestRepositoryPage(driver);
			   req=new RequirementsPage(driver);
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
			   tr.doubleClickOnRelease(releaseName);
			   actual[3]=ep.clickOnNodeExport();
			   bp.waitForElement();
			   String exportType=Excel_Lib.getData(INPUT_PATH_3,"Requirement",1,4);
			   actual[4]=req.chooseExportType(exportType);
			 
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

	@Then("^User perform export operation using filter by coverage irrespective of status and execute report in summary view to any format$")
	public void user_perform_export_operation_using_filter_by_coverage_irrespective_of_status_and_execute_report_in_summary_view_to_any_format() throws Throwable {
		try
		  {
		      ep=new ExportPage(driver);
		      req=new RequirementsPage(driver);
			  String defects=Excel_Lib.getData(INPUT_PATH_3,"Requirement",1,6);
		      String[] executionStatus=new String[2];
		      executionStatus[0]=Excel_Lib.getData(INPUT_PATH_3,"Import",1,12);
		      executionStatus[1]=Excel_Lib.getData(INPUT_PATH_3,"Import",4,12);
			  actual[5]=ep.selectFilterBy(defects, executionStatus);
			  String report_Type=Excel_Lib.getData(INPUT_PATH_3,"Requirement",1,5);
			  actual[6]=ep.reportType(report_Type);
			  req=new RequirementsPage(driver);
			  actual[7]=req.saveAndDownload();
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

	@When("^User perform export operation using filter by coverage irrespective of status and execute report to data excel$")
	public void user_perform_export_operation_using_filter_by_coverage_irrespective_of_status_and_execute_report_to_data_excel() throws Throwable {
		 try
		    {
		    	bp=new BasePage();
		    	req=new RequirementsPage(driver);
		    	tr=new TestRepositoryPage(driver);
				   ep=new ExportPage(driver);
				   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
				   tr.doubleClickOnRelease(releaseName);
				   actual[8]=ep.clickOnNodeExport();
				   bp.waitForElement();
				   String exportType=Excel_Lib.getData(INPUT_PATH_3,"Requirement",1,4);
				   actual[9]=req.chooseExportType(exportType);
				   
				   String defects=Excel_Lib.getData(INPUT_PATH_3,"Requirement",1,6);
				      String[] executionStatus=new String[2];
				      executionStatus[0]=Excel_Lib.getData(INPUT_PATH_3,"Import",5,12);
				      executionStatus[1]=Excel_Lib.getData(INPUT_PATH_3,"Import",2,12);
					  actual[10]=ep.selectFilterBy(defects, executionStatus);
					  String report_Type=Excel_Lib.getData(INPUT_PATH_3,"Requirement",2,5);
					  actual[11]=ep.reportType(report_Type);
					  
					  //actual[12]=req.saveAndDownload();
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

	@Then("^should be Able to export the requirement$")
	public void should_be_Able_to_export_the_requirement() throws Throwable {
		try
	    {
	    	req=new RequirementsPage(driver);
	    	actual[12]=req.saveAndDownload();
	    	for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
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
