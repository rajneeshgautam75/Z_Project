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

public class Export_Requirements_40 extends LaunchBrowser{
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ExportPage ep;
	String fileName="Exports_Requirements_40";
	
	boolean[] actual=new boolean[20];
	 SoftAssert soft=new SoftAssert();

	@Given("^user is in the Requirements app page$")
	public void user_is_in_the_Requirements_app_page() throws Throwable {
		try
	    {
	    	bp=new BasePage();
	    	rp=new ReleasePage(driver);
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Normal_Project_1");
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
			   actual[0]=pp.selectProject(projectName);
			   bp.waitForElement();
			   actual[1]=pp.selectRelease(releaseName);
			   bp.waitForElement();
			   
			   bp.waitForElement();
			   rp.clickOnTestRep();
			tr=new TestRepositoryPage(driver);
			
			//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 14);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 15);
			//tr.doubleClickOnRelease(releaseName);
			String[] phase= new String[1];
			//[0]=p_Name1;
			phase[0]=p_Name1;
			//tr=new TestRepositoryPage(driver);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			tr.addNode(p_Name1,p_Desc1);
			bp.waitForElement();
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			tr.navigateToNode(releaseName,phase );
		    bp.waitForElement();
			tr.addTestCase();
			
			rp= new ReleasePage(driver);
			   rp.clickOnRequirements();
			   
			   String GlobalNode=Excel_Lib.getData(INPUT_PATH_3,"Releases",2,2);
			   tr.doubleClickOnRelease(GlobalNode);
			   
			   String G_PName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Requirement", 1, 17);
				String G_PDesc1=Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 15);
				//tr.doubleClickOnRelease(releaseName);
				String[] Gphase= new String[1];
				//[0]=G_Name1;
				Gphase[0]=G_PName1;
				//tr=new TestRepositoryPage(driver);
				//tr.doubleClickOnRelease(GlobalNode);
				bp.waitForElement();
				req=new RequirementsPage(driver);
				req.addNode(G_PName1,G_PDesc1);
				bp.waitForElement();
				tr.doubleClickOnRelease(GlobalNode);
				bp.waitForElement();
				tr.navigateToNode(GlobalNode,Gphase);
				for(int i=0;i<=4;i++)
				{
				req.addRequirement();
				}
				tr.navigateToNode(GlobalNode,Gphase);
				req.allocateRequirementNode();
				
			  
			   bp=new BasePage();
			   	//String releaseName1=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
				String p_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Requirement", 1, 14);
				String p_Desc2=Excel_Lib.getData(INPUT_PATH_3, "Requirement", 1, 15);
				
				req=new RequirementsPage(driver);
				
				req.doubleClickOnRelease(releaseName);
				bp.waitForElement();
				req.addNode(p_Name2,p_Desc2);
				bp.waitForElement();
				req.doubleClickOnRelease(releaseName);
				bp.waitForElement();
			   rp= new ReleasePage(driver);
			   req=new RequirementsPage(driver);
			   rp.clickOnRequirements();
			  // String p_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Requirement", 1, 14);
				String[] phase1=new String[1];
				phase1[0]=p_Name2;
				//req.doubleClickOnRelease(releaseName);
				bp.waitForElement();
				tr=new TestRepositoryPage(driver);
				tr.navigateToNode(releaseName, phase1);
				req.addRequirement();
				
				bp.waitForElement();
				req=new RequirementsPage(driver);
               tr.clickDetailButton();
				actual[2]=req.MapTestCases();
				
				actual[3]=req.ExpandRelease(releaseName);
				bp.waitForElement();
				bp.waitForElement();
				//String NodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 14);
				//req.clickOnChecKBox(NodeName);
				String[] fields=new String[1];
			 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
		    	fields[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 14);
			 	 bp.waitForElement();
			 	 bp.waitForElement();
			 	 actual[4]=tr.navigateNode(fields);
			 	 bp.waitForElement();
		    	
				String[] testCaseNo=new String[1];
				testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
				actual[5]=req.mapTestCasesToRequirementsFromGrids(testCaseNo);
				bp.waitForElement();
				
				actual[6]=req.saveJiraRequirement();
				
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

	@When("^user click on release and select the Export Requirements Option$")
	public void user_click_on_release_and_select_the_Export_Requirements_Option() throws Throwable {
		try
		   {
			   bp=new BasePage();
			   ep=new ExportPage(driver);
			   tr=new TestRepositoryPage(driver);
			   req=new RequirementsPage(driver);
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
			   tr.clickOnList();
			   actual[7]=req.minimizeFolderNode(releaseName);
			   bp.waitForElement();
			   tr.doubleClickOnRelease(releaseName);
			   /*String[] node=new String[1];
			   node[0]=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
			   actual[3]=tr.navigateNode(node);*/
			   actual[8]=ep.clickOnNodeExport();
			   bp.waitForElement();
			   String exportType=Excel_Lib.getData(INPUT_PATH_3,"Requirement",2,4);
			   actual[9]=req.chooseExportType(exportType);
			 
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

	@Then("^user perform export operation and execute data report to excel format and export$")
	public void user_perform_export_operation_and_execute_data_report_to_excel_format_and_export() throws Throwable {
		try
		  {
		      ep=new ExportPage(driver);
		      req=new RequirementsPage(driver);

			  String report_Type=Excel_Lib.getData(INPUT_PATH_3,"Requirement",1,5);
			  actual[10]=ep.reportType(report_Type);
			  req=new RequirementsPage(driver);
			  actual[11]=req.saveAndDownload();
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

	@Then("^User perform export operation and execute data report to summary format and export$")
	public void user_perform_export_operation_and_execute_data_report_to_summary_format_and_export() throws Throwable {
		try
	    {
	    	bp=new BasePage();
	    	req=new RequirementsPage(driver);
	    	tr=new TestRepositoryPage(driver);
			   ep=new ExportPage(driver);
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
			   tr.doubleClickOnRelease(releaseName);
			   actual[12]=ep.clickOnNodeExport();
			   bp.waitForElement();
			   String exportType=Excel_Lib.getData(INPUT_PATH_3,"Requirement",2,4);
			   actual[13]=req.chooseExportType(exportType);
				  String report_Type=Excel_Lib.getData(INPUT_PATH_3,"Requirement",2,5);
				  actual[14]=ep.reportType(report_Type);
				  
				  actual[15]=req.saveAndDownload();
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

	@Then("^User perform export operation and execute data report to detailed and export$")
	public void user_perform_export_operation_and_execute_data_report_to_detailed_and_export() throws Throwable {
		try
	    {
	    	bp=new BasePage();
	    	req=new RequirementsPage(driver);
	    	tr=new TestRepositoryPage(driver);
			   ep=new ExportPage(driver);
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
			   tr.doubleClickOnRelease(releaseName);
			   actual[16]=ep.clickOnNodeExport();
			   bp.waitForElement();
			   String exportType=Excel_Lib.getData(INPUT_PATH_3,"Requirement",2,4);
			   actual[17]=req.chooseExportType(exportType);
				  String report_Type=Excel_Lib.getData(INPUT_PATH_3,"Requirement",2,5);
				  actual[18]=ep.reportType(report_Type);
				  
				  actual[19]=req.saveAndDownload();
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
