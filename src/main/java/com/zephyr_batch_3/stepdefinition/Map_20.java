package com.zephyr_batch_3.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Map_20 extends LaunchBrowser{
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestRepositoryPage tp;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	String fileName="Map_20";
	
	boolean[] actual=new boolean[22];
	 SoftAssert soft=new SoftAssert();
	 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_2");
	@Given("^User is in TestRepository page$")
	public void user_is_in_TestRepository_page() throws Throwable {
		try
		   {
			   pp=new ProjectPage(driver);
			   bp=new BasePage();
			   rp=new ReleasePage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Normal_Project_1");
			   //String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
			   actual[0]=pp.selectProject(projectName);
			   
			   actual[1]=pp.selectRelease(releaseName);
			//rp.clickOnManageRelease();
			//rp.addNewRelease(releaseName, Desc, Hide, MapexternalDefect)
			bp.waitForElement();
			   rp.clickOnTestRep();
			tr=new TestRepositoryPage(driver);
			
			/*//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 3, 0);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map", 3, 3);
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
			tr.addTestCase();*/
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

	@When("^User creates a phase and create testcases$")
	public void user_creates_a_phase_and_create_testcases() throws Throwable {
	    try
		{
	    	tr=new TestRepositoryPage(driver);
			//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 21, 0);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map", 21, 3);
			//tr.doubleClickOnRelease(releaseName);
			String[] phase= new String[1];
			//[0]=p_Name1;
			phase[0]=p_Name1;
			//tr=new TestRepositoryPage(driver);
			tr.clickOnRelease(releaseName);
			bp.waitForElement();
			tr.addNode(p_Name1,p_Desc1);
			bp.waitForElement();
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			tr.navigateToNode(releaseName,phase );
		    bp.waitForElement();
			for(int i=0;i<=2;i++)
			{
		    tr.addTestCase();
			}
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

	@When("^User is in Requirements page and create a phase with requirements$")
	public void user_is_in_Requirements_page_and_create_a_phase_with_requirements() throws Throwable {
	    try
		{
	    	bp.waitForElement();
			rp= new ReleasePage(driver);
		    actual[2]=rp.clickOnRequirements();
		    bp.waitForElement();
		    //String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		    String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Requirement", 1, 0);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Requirement", 1, 1);
			
			
			req=new RequirementsPage(driver);
			actual[3]=tr.clickOnRelease(releaseName);
			
			req.addNode(p_Name1,p_Desc1);
			bp.waitForElement();
			String[] phase=new String[1];
			phase[0]=p_Name1;
			tr=new TestRepositoryPage(driver);
			//actual[4]=tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			actual[4]=tr.navigateToNode(releaseName, phase);
			for(int i=0;i<=2;i++)
			{
			req.addRequirement();
			}
			
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

	@Then("^User map the single testcase and view the requirement coverage detail$")
	public void user_map_the_single_testcase_and_view_the_requirement_coverage_detail() throws Throwable {
	   try
	   {
		   bp.waitForElement();
		 	String[] testCaseNo1=new String[1];
			testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
			bp.waitForElement();
			actual[5]=req.selectMultipleRequirementFromGrids(testCaseNo1);
			bp.waitForElement();
			tr.clickOnDetails();
			req=new RequirementsPage(driver);
			actual[6]=req.MapTestCases();
			
			
			
			//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
	    	bp.waitForElement();
	    	actual[7]=req.ExpandRelease(releaseName);
	    	bp.waitForElement();
			
	    	String[] fields=new String[1];
		 	 
	    	
		 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
	    	fields[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 21, 0);
		 	//fields[1]=Excel_Lib.getData(INPUT_PATH_3, "Import", 4, 9);
		 	 bp.waitForElement();
		 	 bp.waitForElement();
		 	 actual[8]=tr.navigateNode(fields);
		 	 bp.waitForElement();
	    	
			String[] testCaseNo=new String[1];
			testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
			actual[9]=req.mapTestCasesToRequirementsFromGrids(testCaseNo);
			bp.waitForElement();
			req.clickOnSavejirareq.click();
			
			bp.waitForElement();
			int tcNo=Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 );
			actual[10]=req.requirementCoverageDetails(tcNo);
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

	@Then("^User map the multiple testcases and view the requirement coverage details$")
	public void user_map_the_multiple_testcases_and_view_the_requirement_coverage_details() throws Throwable {
		try
		   {
			   bp.waitForElement();
			 	String[] testCaseNo1=new String[1];
				testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
				bp.waitForElement();
				actual[11]=req.selectMultipleRequirementFromGrids(testCaseNo1);
				bp.waitForElement();
				
				req=new RequirementsPage(driver);
				actual[12]=req.MapTestCases();
				
				//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		    	bp.waitForElement();
		    	actual[13]=req.ExpandRelease(releaseName);
		    	bp.waitForElement();
				
		    	String[] fields=new String[1];
			 	 
			 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
		    	fields[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 21, 0);
			 	//fields[1]=Excel_Lib.getData(INPUT_PATH_3, "Import", 4, 9);
			 	 bp.waitForElement();
			 	 bp.waitForElement();
			 	 actual[14]=tr.navigateNode(fields);
			 	 bp.waitForElement();
		    	
				String[] testCaseNo=new String[2];
				testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
				testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
				actual[15]=req.mapTestCasesToRequirementsFromGrids(testCaseNo);
				bp.waitForElement();
				req.clickOnSavejirareq.click();
				
				bp.waitForElement();
				int tcNo=Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 );
				actual[16]=req.requirementCoverageDetails(tcNo);
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

	@Then("^User map the complete release level testcases and view all the details of testcases$")
	public void user_map_the_complete_release_level_testcases_and_view_all_the_details_of_testcases() throws Throwable {
		try
		   {
			   bp.waitForElement();
			 	String[] testCaseNo1=new String[1];
				testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
				bp.waitForElement();
				actual[17]=req.selectMultipleRequirementFromGrids(testCaseNo1);
				bp.waitForElement();
				
				req=new RequirementsPage(driver);
				actual[18]=req.MapTestCases();
				
				//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		    	bp.waitForElement();
		    	actual[19]=req.ExpandRelease(releaseName);
		    	bp.waitForElement();
				
		    	
		    	
		    	// String NodeName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1,0 );
				   actual[20]=req.clickOnChecKBox(releaseName);
					bp.waitForElement();
					bp.waitForElement();
					bp.waitForElement();
				   
		    	/*String[] fields=new String[1];
			 	 
			 	 //fields[0]=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 9);
		    	fields[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 21, 0);
			 	//fields[1]=Excel_Lib.getData(INPUT_PATH_3, "Import", 4, 9);
			 	 bp.waitForElement();
			 	 bp.waitForElement();
			 	 actual[20]=tr.navigateNode(fields);
			 	 bp.waitForElement();
		    	
				String[] testCaseNo=new String[1];
				testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
				actual[21]=req.mapTestCasesToRequirementsFromGrids(testCaseNo);*/
				bp.waitForElement();
				bp.waitTillElementIsVisible(req.clickOnSavejirareq);
				req.clickOnSavejirareq.click();
				
				bp.waitForElement();
				int tcNo=Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 );
				actual[21]=req.requirementCoverageDetails(tcNo);
				bp.waitForElement();
				bp.waitForElement();
				tr.clickOnList();
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


}
