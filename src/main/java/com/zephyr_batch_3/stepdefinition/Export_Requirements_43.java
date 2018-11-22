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

public class Export_Requirements_43 extends LaunchBrowser{
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ExportPage ep;
	String fileName="Exports_Requirements_43";
	
	boolean[] actual=new boolean[14];
	 SoftAssert soft=new SoftAssert();

	@Given("^User is In the Requirements App$")
	public void user_is_In_the_Requirements_App() throws Throwable {
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

	@When("^User select the Export Requirements button$")
	public void user_select_the_Export_Requirements_button() throws Throwable {
		 try
		   {
			   bp=new BasePage();
			   ep=new ExportPage(driver);
			   tr=new TestRepositoryPage(driver);
			   req=new RequirementsPage(driver);
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
			   bp.pageLoad();
			   tr.doubleClickOnRelease(releaseName);
			   bp.pageLoad();
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

	@Then("^User perform export operation on the partially executed to any status and execute data report to excel file and export$")
	public void user_perform_export_operation_on_the_partially_executed_to_any_status_and_execute_data_report_to_excel_file_and_export() throws Throwable {
		try
		  {
		    ep=new ExportPage(driver);
		    req=new RequirementsPage(driver);
			String defects=Excel_Lib.getData(INPUT_PATH_3,"Requirement",1,6);
		      String[] executionStatus=new String[2];
		      executionStatus[0]=Excel_Lib.getData(INPUT_PATH_3,"Import",1,12);
		      executionStatus[1]=Excel_Lib.getData(INPUT_PATH_3,"Import",2,12);
			  actual[5]=ep.selectFilterBy(defects, executionStatus);
			  String report_Type=Excel_Lib.getData(INPUT_PATH_3,"Requirement",2,5);
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

	@When("^User perform export operation based on the partially executed to any status and execute summary report to any format$")
	public void user_perform_export_operation_based_on_the_partially_executed_to_any_status_and_execute_summary_report_to_any_format() throws Throwable {
		 try
		    {
		    	bp=new BasePage();
		    	req=new RequirementsPage(driver);
				   ep=new ExportPage(driver);
				   tr=new TestRepositoryPage(driver);
				   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
				   tr.doubleClickOnRelease(releaseName);
				   actual[8]=ep.clickOnNodeExport();
				   bp.waitForElement();
				   String exportType=Excel_Lib.getData(INPUT_PATH_3,"Requirement",1,4);
				   actual[9]=req.chooseExportType(exportType);
				   
				      String defects=Excel_Lib.getData(INPUT_PATH_3,"Requirement",1,6);
				      String[] executionStatus=new String[2];
				      executionStatus[0]=Excel_Lib.getData(INPUT_PATH_3,"Import",1,12);
				      executionStatus[1]=Excel_Lib.getData(INPUT_PATH_3,"Import",2,12);
					  actual[10]=ep.selectFilterBy(defects, executionStatus);
					  String report_Type=Excel_Lib.getData(INPUT_PATH_3,"Requirement",1,5);
					  actual[11]=ep.reportType(report_Type);
					  String outputType=Excel_Lib.getData(INPUT_PATH_3,"Requirement",3,3);
					  actual[12]=ep.outputType(outputType);
					  
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

	@Then("^should be able to export the requirement$")
	public void should_be_able_to_export_the_requirement() throws Throwable {
		try
	    {
	    	req=new RequirementsPage(driver);
	    	actual[13]=req.saveAndDownload();
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
