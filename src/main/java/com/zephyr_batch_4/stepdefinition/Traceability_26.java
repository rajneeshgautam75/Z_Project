package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Traceability_26 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	DashBoardPage dbp;
	RequirementsPage req;
	String fileName="Traceability_26";
	
	boolean[] actual=new boolean[56];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^As a Lead,Launch DashBoard Page$")
	public void as_a_Lead_Launch_DashBoard_Page() throws Throwable {
		try
	    {
			   bp=new BasePage();
			   rp=new ReleasePage(driver);
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			   String projectName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
			   String projectName11=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_3");
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_8");
			   String releaseName7=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_7");
			   String releaseName11=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			   //pp.backToProjectPage();
			   pp.selectProject(projectName1);
			   pp.selectProject(projectName);
			   pp.selectRelease(releaseName);
			   rp= new ReleasePage(driver);
			   bp.waitForElement();
			   rp.clickOnRequirements();
			   
			   req=new RequirementsPage(driver);
			   tr=new TestRepositoryPage(driver);
			    //String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100, 100);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 36);
				
				tr.clickOnRelease(releaseName);
				bp.waitForElement();
				req.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
			    String[] str=new String[1];
			    str[0]=p_Name1;
			    tr.navigateToNode(releaseName, str);
			    for(int i=0;i<=1;i++)
			    {
			    req.addRequirement();
			    }
			    pp.selectProject(projectName1);
			    pp.selectProject(projectName);
			    String releaseName6=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_6");
			    pp.selectRelease(releaseName6);
			    bp.waitForElement();
				rp.clickOnRequirements();
				tr.clickOnRelease(releaseName6);
			    req.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
			    String[] str1=new String[1];
			    str1[0]=p_Name1;
			    tr.navigateToNode(releaseName6, str1);
			    for(int i=0;i<=1;i++)
			    {
			    req.addRequirement();
			    }
			    pp.selectProject(projectName);
			    pp.selectRelease(releaseName11);
			    bp.waitForElement();
				rp.clickOnRequirements();
				tr.clickOnRelease(releaseName11);
			    req.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
			    String[] str11=new String[1];
			    str11[0]=p_Name1;
			    tr.navigateToNode(releaseName11, str11);
			    for(int i=0;i<=1;i++)
			    {
			    req.addRequirement();
			    }
			    
			    pp.selectProject(projectName);
			    pp.selectRelease(releaseName7);
			    bp.waitForElement();
				rp.clickOnRequirements();
				tr.clickOnRelease(releaseName7);
			    req.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
			    String[] str7=new String[1];
			    str7[0]=p_Name1;
			    tr.navigateToNode(releaseName7, str7);
			    for(int i=0;i<=1;i++)
			    {
			    req.addRequirement();
			    }
			
			dbp=new DashBoardPage(driver);
			bp=new BasePage();
			actual[0]=dbp.clickOnManageDashboards();
			actual[1]=dbp.validateDashboards();
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

	@When("^create a multiple DashBoards$")
	public void create_a_multiple_DashBoards() throws Throwable {
		try
		{
		for(int i=2;i<12;i++)
		{
		actual[2]=dbp.clickOnAddDashBoardSymbol();
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", i+1,35);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[3]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
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

	@When("^create traceability gadgets with same project/release$")
	public void create_traceability_gadgets_with_same_project_release() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
			bp=new BasePage();
			for(int i=2;i<7;i++)
			{
			dbp.clickOnManageDashboards();	
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",i+1,35);
			actual[4]=dbp.searchDashboard(dashboardName);
			actual[5]=dbp.selectDashboard(dashboardName);
			actual[6]=dbp.clickOnAddGadgetSymbol();
			String gadgetName= Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6);
			actual[7]=dbp.addGadget(gadgetName);
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_8");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[8]=dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 actual[9]=dbp.manageTraceability();
//			 dbp.closeTraceabilityTable();
//			 dbp.manageTraceability();
			 driver.navigate().refresh();
			 bp.waitForElement();
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 String searchOption=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,34);
			 dbp.manageTraceability();
			 actual[10]=dbp.traceabilityQuickSearch(searchOption);
			 req=new RequirementsPage(driver);
			 actual[11]=req.selectAllRequirements();
			 dbp.closeTraceabilityTable();
			 bp.waitForElement();
			 actual[12]=dbp.saveGadget();
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

	@Then("^traceability Gadget is added successfully$")
	public void traceability_Gadget_is_added_successfully() throws Throwable {
	   try
	   {
	     String gadgetName= Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6);
	     actual[13]=dbp.validateGadget(gadgetName);   
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

	@When("^create traceability gadgets with different project/release$")
	public void create_traceability_gadgets_with_different_project_release() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
			bp=new BasePage();
//			for(int i=7;i<13;i++)
//			{
			dbp.clickOnManageDashboards();	
			String dashboardName6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",8,35);
			actual[14]=dbp.searchDashboard(dashboardName6);
			actual[15]=dbp.selectDashboard(dashboardName6);
			actual[16]=dbp.clickOnAddGadgetSymbol();
			String gadgetName= Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6);
			actual[17]=dbp.addGadget(gadgetName);
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			//String release= Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2+i1,0);
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[18]=dbp.configureTraceabilityGadget(projectName, release1, refreshRate);
			 actual[19]=dbp.manageTraceability();
			 //dbp.closeTraceabilityTable();
//			 dbp.manageTraceability();
			 driver.navigate().refresh();
			     bp.waitForElement();
			     bp.waitForElement();
			     bp.waitForElement();
			     bp.waitForElement();
			     bp.waitForElement();
			     actual[20]=dbp.configureTraceabilityGadget(projectName, release1, refreshRate);
				 String searchOption=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,34);
				 dbp.manageTraceability();
				 actual[21]=dbp.traceabilityQuickSearch(searchOption);
				 req=new RequirementsPage(driver);
				 req.selectAllRequirements();
				 dbp.closeTraceabilityTable();
				 bp.waitForElement();
				 actual[22]=dbp.saveGadget();
			 //dbp.configureTraceabilityGadget(projectName, release, refreshRate);
//			 String searchOption=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,34);
//			 dbp.manageTraceability();
//			 actual[10]=dbp.traceabilityQuickSearch(searchOption);
//			 req=new RequirementsPage(driver);
//			 req.selectAllRequirements();
//			 dbp.closeTraceabilityTable();
//			 bp.waitForElement();
//			 dbp.saveGadget();
				 
			    dbp.clickOnManageDashboards();	
				String dashboardName7=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",9,35);
				actual[23]=dbp.searchDashboard(dashboardName7);
				actual[24]=dbp.selectDashboard(dashboardName7);
				actual[25]=dbp.clickOnAddGadgetSymbol();
				actual[26]=dbp.addGadget(gadgetName);
				//String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
				 String release2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
				 actual[27]=dbp.configureTraceabilityGadget(projectName, release2, refreshRate);
				 actual[28]=dbp.manageTraceability();
				 //dbp.closeTraceabilityTable();
				 driver.navigate().refresh();
				 bp.waitForElement();
				 bp.waitForElement();
				 bp.waitForElement();
				 bp.waitForElement();
				 bp.waitForElement();
				 actual[29]=dbp.configureTraceabilityGadget(projectName, release2, refreshRate);
				 //String searchOption=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,34);
				 dbp.manageTraceability();
				 actual[30]=dbp.traceabilityQuickSearch(searchOption);
				 req=new RequirementsPage(driver);
				 req.selectAllRequirements();
				 dbp.closeTraceabilityTable();
				 bp.waitForElement();
				 actual[31]=dbp.saveGadget();
				 
				 
			    dbp.clickOnManageDashboards();	
				String dashboardName8=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",10,35);
				actual[32]=dbp.searchDashboard(dashboardName8);
				actual[33]=dbp.selectDashboard(dashboardName8);
				actual[34]=dbp.clickOnAddGadgetSymbol();
				actual[35]=dbp.addGadget(gadgetName);
				 String release3=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_6");
				 actual[36]=dbp.configureTraceabilityGadget(projectName, release3, refreshRate);
				 actual[37]=dbp.manageTraceability();
				 //dbp.closeTraceabilityTable();
				 driver.navigate().refresh();
				 bp.waitForElement();
				 bp.waitForElement();
				 bp.waitForElement();
				 bp.waitForElement();
				 bp.waitForElement();
				 actual[38]=dbp.configureTraceabilityGadget(projectName, release3, refreshRate);
				 dbp.manageTraceability();
				 //String value=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,34);
				 actual[39]=dbp.traceabilityQuickSearch(searchOption);
				 req=new RequirementsPage(driver);
				 req.selectAllRequirements();
				 dbp.closeTraceabilityTable();
				 bp.waitForElement();
				 actual[40]=dbp.saveGadget();
				 
				 
				 dbp.clickOnManageDashboards();	
					String dashboardName9=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",11,35);
					actual[41]=dbp.searchDashboard(dashboardName9);
					actual[42]=dbp.selectDashboard(dashboardName9);
					actual[43]=dbp.clickOnAddGadgetSymbol();
					actual[44]=dbp.addGadget(gadgetName);
					 String release4=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_7");
					 dbp.configureTraceabilityGadget(projectName, release4, refreshRate);
					 dbp.manageTraceability();
					// dbp.closeTraceabilityTable();
					 driver.navigate().refresh();
					 bp.waitForElement();
					 bp.waitForElement();
					 bp.waitForElement();
					 bp.waitForElement();
					 bp.waitForElement();
					 actual[45]=dbp.configureTraceabilityGadget(projectName, release4, refreshRate);
					 dbp.manageTraceability();
					 actual[46]=dbp.traceabilityQuickSearch(searchOption);
					 req=new RequirementsPage(driver);
					 req.selectAllRequirements();
					 dbp.closeTraceabilityTable();
					 bp.waitForElement();
					 actual[47]=dbp.saveGadget();
					 
					 
					   dbp.clickOnManageDashboards();	
						String dashboardName10=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",12,35);
						actual[48]=dbp.searchDashboard(dashboardName10);
						actual[49]=dbp.selectDashboard(dashboardName10);
						actual[50]=dbp.clickOnAddGadgetSymbol();
						actual[51]=dbp.addGadget(gadgetName);
						 String release5=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_8");
						 dbp.configureTraceabilityGadget(projectName, release5, refreshRate);
						 dbp.manageTraceability();
						 //dbp.closeTraceabilityTable();
						 driver.navigate().refresh();
						 bp.waitForElement();
						 bp.waitForElement();
						 bp.waitForElement();
						 bp.waitForElement();
						 bp.waitForElement();
						 actual[52]=dbp.configureTraceabilityGadget(projectName, release5, refreshRate);
						 dbp.manageTraceability();
						 actual[53]=dbp.traceabilityQuickSearch(searchOption);
						 req=new RequirementsPage(driver);
						 req.selectAllRequirements();
						 dbp.closeTraceabilityTable();
						 bp.waitForElement();
						 actual[54]=dbp.saveGadget();
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

	@Then("^Traceability gadget is added successfully$")
	public void traceability_gadget_is_added_successfully() throws Throwable {
		try
		   {
		     String gadgetName= Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6);
		     actual[55]=dbp.validateGadget(gadgetName);
		     
		     pp.backToProjectPage();
		     for(int k=0;k<=actual.length-1;k++)
				{
					System.out.println("Actual["+k+"]="+actual[k]);
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
