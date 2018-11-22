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

public class Export_Requirements_41 extends LaunchBrowser{
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ExportPage ep;
	String fileName="Exports_Requirements_41";
	
	boolean[] actual=new boolean[37];
	 SoftAssert soft=new SoftAssert();

	@Given("^user is in the requirements app page$")
	public void user_is_in_the_requirements_app_page() throws Throwable {
		try
	    {
	    	bp=new BasePage();
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Normal_Project_1");
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
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

	@When("^User allocates the nodes created in global node in different releases$")
	public void user_allocates_the_nodes_created_in_global_node_in_different_releases() throws Throwable {
	    try
	    {
	    	bp=new BasePage();
	    	tr=new TestRepositoryPage(driver);
	    	req=new RequirementsPage(driver);
	    	String GlobalNode=Excel_Lib.getData(INPUT_PATH_3,"Releases",2,2);
			   actual[3]=tr.doubleClickOnRelease(GlobalNode);
			   
			   String G_PName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 17);
				String G_PDesc1=Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 15);
				//tr.doubleClickOnRelease(releaseName);
				String[] Gphase= new String[1];
				//[0]=G_Name1;
				Gphase[0]=G_PName1;
				//tr=new TestRepositoryPage(driver);
				//tr.doubleClickOnRelease(GlobalNode);
				bp.waitForElement();
				req=new RequirementsPage(driver);
				actual[4]=req.addNode(G_PName1,G_PDesc1);
				bp.waitForElement();
				tr.doubleClickOnRelease(GlobalNode);
				bp.waitForElement();
				actual[5]=tr.navigateToNode(GlobalNode,Gphase);
				for(int i=0;i<=4;i++)
				{
				actual[6]=req.addRequirement();
				}
				tr.navigateToNode(GlobalNode,Gphase);
				actual[7]=req.allocateRequirementNode();
				bp.waitForElement();
				//pp.clickOnLogout(driver);
				bp=new BasePage();
				   pp=new ProjectPage(driver);
				   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Normal_Project_1");
				   String releaseName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
				   bp.waitForElement();
				   actual[8]=pp.selectProject(projectName);
				   bp.waitForElement();
				   actual[9]=pp.selectRelease(releaseName1);
				   bp.waitForElement();
				   
				   bp.waitForElement();
				   rp.clickOnTestRep();
				tr=new TestRepositoryPage(driver);
				
				//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Requirement", 4, 14);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 15);
				//tr.doubleClickOnRelease(releaseName);
				String[] phase= new String[1];
				//[0]=p_Name1;
				phase[0]=p_Name1;
				//tr=new TestRepositoryPage(driver);
				tr.doubleClickOnRelease(releaseName1);
				bp.waitForElement();
				tr.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
				tr.doubleClickOnRelease(releaseName1);
				bp.waitForElement();
				actual[10]=tr.navigateToNode(releaseName1,phase );
			    bp.waitForElement();
				for(int i=0;i<=3;i++)
				{
			    tr.addTestCase();
				}
				   
				   
				rp= new ReleasePage(driver);
				   bp.waitForElement();
				   actual[11]=rp.clickOnRequirements();
				   bp.waitForElement();
				   
				   String reqp_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Requirement", 3, 14);
					String reqp_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 15);
					//tr.doubleClickOnRelease(releaseName);
					String[] reqphase= new String[1];
					//[0]=p_Name1;
					reqphase[0]=reqp_Name1;
					//tr=new TestRepositoryPage(driver);
				   tr.doubleClickOnRelease(releaseName1);
				   actual[12]=req.addNode(reqp_Name1, reqp_Desc1);
				   bp.waitForElement();
				   tr.doubleClickOnRelease(releaseName1);
				   actual[13]=tr.navigateToNode(releaseName1, reqphase);
				   actual[14]=req.addRequirement();
				   tr.clickDetailButton();
				   actual[15]=req.MapTestCases();
					bp.waitForElement();
					
					actual[16]=req.ExpandRelease(releaseName1);
					bp.waitForElement();
					bp.waitForElement();
				
					String[] fields=new String[1];
			    	fields[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Requirement", 4, 14);
				 	 bp.waitForElement();
				 	 bp.waitForElement();
				 	 actual[17]=tr.navigateNode(fields);
				 	 bp.waitForElement();
			    	
					String[] testCaseNo=new String[3];
					testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
					testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
					testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
					actual[18]=req.mapTestCasesToRequirementsFromGrids(testCaseNo);
					bp.waitForElement();
					//req.clickOnSavejirareq.click();
					
					actual[19]=req.saveJiraRequirement();
					tr.clickOnList();
					req.minimizeFolderNode(releaseName1);
				   
				   //String GlobalNode=Excel_Lib.getData(INPUT_PATH_3,"Releases",2,2);
					
				   actual[20]=tr.doubleClickOnRelease(GlobalNode);
				   
				   String G_PName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Requirement", 3, 17);
					String G_PDesc2=Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 15);
					//tr.doubleClickOnRelease(releaseName);
					String[] Gphase2= new String[1];
					//[0]=G_Name1;
					Gphase2[0]=G_PName2;
					//tr=new TestRepositoryPage(driver);
					//tr.doubleClickOnRelease(GlobalNode);
					bp.waitForElement();
					req=new RequirementsPage(driver);
					actual[21]=req.addNode(G_PName2,G_PDesc2);
					bp.waitForElement();
					tr.doubleClickOnRelease(GlobalNode);
					bp.waitForElement();
					actual[22]=tr.navigateToNode(GlobalNode,Gphase2);
					for(int i=0;i<=4;i++)
					{
					req.addRequirement();
					}
					
					actual[23]=tr.navigateToNode(GlobalNode,Gphase2);
					actual[24]=req.allocateRequirementNode();
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

	@When("^user click on the release and select the Export Requirements Option$")
	public void user_click_on_the_release_and_select_the_Export_Requirements_Option() throws Throwable {
		try
		   {
			   bp=new BasePage();
			   ep=new ExportPage(driver);
			   tr=new TestRepositoryPage(driver);
			   req=new RequirementsPage(driver);
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
			   req.minimizeFolderNode(releaseName);
			   tr.doubleClickOnRelease(releaseName);
			   actual[25]=ep.clickOnNodeExport();
			   bp.waitForElement();
			   String exportType=Excel_Lib.getData(INPUT_PATH_3,"Requirement",2,4);
			   actual[26]=req.chooseExportType(exportType);
			 
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

	@Then("^user perform export operation and execute the excel report to any format$")
	public void user_perform_export_operation_and_execute_the_excel_report_to_any_format() throws Throwable {
		try
		  {
		      ep=new ExportPage(driver);
		      req=new RequirementsPage(driver);
			  String report_Type=Excel_Lib.getData(INPUT_PATH_3,"Requirement",3,7);
			  actual[27]=ep.reportType(report_Type);
			  req=new RequirementsPage(driver);
			  actual[28]=req.saveAndDownload();
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

	@Then("^User perform export operation and execute the summary report to any format$")
	public void user_perform_export_operation_and_execute_the_summary_report_to_any_format() throws Throwable {
		try
	    {
	    	bp=new BasePage();
	    	req=new RequirementsPage(driver);
	    	tr=new TestRepositoryPage(driver);
			   ep=new ExportPage(driver);
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
			   tr.doubleClickOnRelease(releaseName);
			   actual[29]=ep.clickOnNodeExport();
			   bp.waitForElement();
			   String exportType=Excel_Lib.getData(INPUT_PATH_3,"Requirement",2,4);
			   actual[30]=req.chooseExportType(exportType);
				  String report_Type=Excel_Lib.getData(INPUT_PATH_3,"Requirement",1,7);
				  actual[31]=ep.reportType(report_Type);
				  
				  actual[32]=req.saveAndDownload();
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

	@Then("^User perform export operation and execute the detailed report to any format$")
	public void user_perform_export_operation_and_execute_the_detailed_report_to_any_format() throws Throwable {
		try
	    {
	    	bp=new BasePage();
	    	req=new RequirementsPage(driver);
	    	tr=new TestRepositoryPage(driver);
			   ep=new ExportPage(driver);
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
			   tr.doubleClickOnRelease(releaseName);
			   actual[33]=ep.clickOnNodeExport();
			   bp.waitForElement();
			   String exportType=Excel_Lib.getData(INPUT_PATH_3,"Requirement",2,4);
			   actual[34]=req.chooseExportType(exportType);
				  String report_Type=Excel_Lib.getData(INPUT_PATH_3,"Requirement",2,7);
				  actual[35]=ep.reportType(report_Type);
				  
				  actual[36]=req.saveAndDownload();
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
