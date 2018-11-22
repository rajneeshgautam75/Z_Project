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

public class Traceability_16 extends LaunchBrowser{

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
	String fileName="Traceability_16";
	
	boolean[] actual=new boolean[51];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^As the Lead,Launch Requirements page$")
	public void as_the_Lead_Launch_Requirements_page() throws Throwable {
		try
	    {
	    	   bp=new BasePage();
			   rp=new ReleasePage(driver);
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			   String projectName4=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4");
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			   //pp.backToProjectPage();
			   pp.selectProject(projectName4);
			   actual[0]=pp.selectProject(projectName);
			   actual[1]=pp.selectRelease(releaseName);
			   rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[2]=rp.clickOnRequirements();
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

	@When("^Add nodes upto tenth level with requirements$")
	public void add_nodes_upto_tenth_level_with_requirements() throws Throwable {
		try
		   {
			   req=new RequirementsPage(driver);
			   tr=new TestRepositoryPage(driver);
			    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			
				actual[3]=tr.clickOnRelease(releaseName);
				bp.waitForElement();
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 17, 35);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 36);
				actual[4]=req.addNode(p_Name1,p_Desc1);
				//tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
			    String[] a=new String[1];
			    a[0]=p_Name1;
			    actual[5]=tr.navigateToNode(releaseName, a);
			    req.addRequirement();
			    req.addRequirement();
			    tr.clickOnDetails();
			    String[] requirementNum1=new String[1];
			    requirementNum1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 15));
			    req.selectMultipleRequirementFromGrids(requirementNum1);
			    
			    String name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"DashBoards",5,34);
		    	String altID=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
		    	String link=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
		    	String priority=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
		    	String Description=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
			    actual[6]=req.enterRequirementDetails(name1, altID, link, priority, Description);
			    
			    String[] requirementNum2=new String[1];
			    requirementNum2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 2, 15));
			    //req.selectRequirementsFromGrids(requirementNum2);
			    //tr.clickOnList();
			    req.selectMultipleRequirementFromGrids(requirementNum2);
			    //tr.clickOnDetails();
			    
			    String name11=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"DashBoards",5,34);
			    actual[7]=req.enterRequirementDetails(name11, altID, link, priority, Description);
			    bp.waitForElement();
			    tr.clickOnList();
				
			    //2nd phase
			    String p_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 18, 35);
				String p_Desc2=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 36);
				tr.clickOnRelease(releaseName);
				actual[8]=tr.selectPhase(p_Name1);
				actual[9]=req.addNode(p_Name2,p_Desc2);
				tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
			    String[] str2=new String[2];
			    str2[0]=p_Name1;
			    str2[1]=p_Name2;
			    actual[10]=tr.navigateToNode(releaseName, str2);
			    req.addRequirement();
			    req.addRequirement();
			    tr.clickOnDetails();
			    req.selectMultipleRequirementFromGrids(requirementNum1);
			    
			    actual[11]=req.enterRequirementDetails(name1, altID, link, priority, Description);
			    //tr.clickOnList();
			    req.selectMultipleRequirementFromGrids(requirementNum2);
			    //tr.clickOnDetails();
			    actual[12]=req.enterRequirementDetails(name11, altID, link, priority, Description);
			    bp.waitForElement();
			    tr.clickOnList();
			    
			  //3rd phase
			    String p_Name3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 19, 35);
			    tr.clickOnRelease(releaseName);
				actual[13]=tr.selectPhase(p_Name2);
				actual[14]=req.addNode(p_Name3,p_Desc1);
				tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
			    String[] str3=new String[3];
			    str3[0]=p_Name1;
			    str3[1]=p_Name2;
			    str3[2]=p_Name3;
			    actual[15]=tr.navigateToNode(releaseName, str3);
			    req.addRequirement();
			    req.addRequirement();
			    tr.clickOnDetails();
			    req.selectMultipleRequirementFromGrids(requirementNum1);
			    actual[16]=req.enterRequirementDetails(name1, altID, link, priority, Description);
			    //tr.clickOnList();
			    req.selectMultipleRequirementFromGrids(requirementNum2);
			    //tr.clickOnDetails();
			    actual[17]=req.enterRequirementDetails(name11, altID, link, priority, Description);
			    tr.clickOnList();
			    
			  //4th phase phase
			    String p_Name4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 20, 35);
			    tr.clickOnRelease(releaseName);
				actual[18]=tr.selectPhase(p_Name3);
				actual[19]=req.addNode(p_Name4,p_Desc1);
				tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
			    String[] str4=new String[4];
			    str4[0]=p_Name1;
			    str4[1]=p_Name2;
			    str4[2]=p_Name3;
			    str4[3]=p_Name4;
			    actual[20]=tr.navigateToNode(releaseName, str4);
			    req.addRequirement();
			    req.addRequirement();
			    tr.clickOnDetails();
			    req.selectMultipleRequirementFromGrids(requirementNum1);
			    actual[21]=req.enterRequirementDetails(name1, altID, link, priority, Description);
			    //tr.clickOnList();
			  
			    req.selectMultipleRequirementFromGrids(requirementNum2);
			   // tr.clickOnDetails();
			    actual[22]=req.enterRequirementDetails(name11, altID, link, priority, Description);
			   // tr.clickOnList();
			    
			  //5th phase phase
			    String p_Name5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 21, 35);
			    tr.clickOnList();
			    tr.clickOnRelease(releaseName);
			    bp.waitForElement();
				actual[23]=tr.selectPhase(p_Name4);
				actual[24]=req.addNode(p_Name5,p_Desc1);
				tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
			    String[] str5=new String[5];
			    str5[0]=p_Name1;
			    str5[1]=p_Name2;
			    str5[2]=p_Name3;
			    str5[3]=p_Name4;
			    str5[4]=p_Name5;
			    actual[25]=tr.navigateToNode(releaseName, str5);
			    req.addRequirement();
			    req.addRequirement();
			    tr.clickOnDetails();
			    req.selectMultipleRequirementFromGrids(requirementNum1);
			    
			    actual[26]=req.enterRequirementDetails(name1, altID, link, priority, Description);
			    //tr.clickOnList();
			    
			    req.selectMultipleRequirementFromGrids(requirementNum2);
			    //tr.clickOnDetails();
			    actual[27]=req.enterRequirementDetails(name11, altID, link, priority, Description);
			    tr.clickOnList();
			    
			    /*String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 17, 35);
			    String p_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 18, 35);
			    String p_Name3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 19, 35);
			    String p_Name4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 20, 35);
			    String p_Name5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 21, 35);
			    String[] navigation=new String[5];
			    navigation[0]=p_Name1;
			    navigation[1]=p_Name2;
			    navigation[2]=p_Name3;
			    navigation[3]=p_Name4;
			    navigation[4]=p_Name5;
			    String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 36);
			    tr.navigateToNode(releaseName, navigation);*/
			    
			  //6th phase phase
			    /*String p_Name6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 22, 35);
			    tr.clickOnRelease(releaseName);
				actual[28]=tr.selectPhase(p_Name5);
				actual[29]=req.addNode(p_Name6,p_Desc1);
				tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
			    String[] str6=new String[6];
			    str6[0]=p_Name1;
			    str6[1]=p_Name2;
			    str6[2]=p_Name3;
			    str6[3]=p_Name4;
			    str6[4]=p_Name5;
			    str6[5]=p_Name6;
			    actual[30]=tr.navigateToNode(releaseName, str6);
			    req.addRequirement();
			    req.addRequirement();
			    req.selectRequirementsFromGrids(requirementNum1);
			    actual[31]=req.enterRequirementDetails(name1, altID, link, priority, Description);
			    
			    req.selectRequirementsFromGrids(requirementNum2);
			    actual[32]=req.enterRequirementDetails(name11, altID, link, priority, Description);
			    
			    
			  //7th phase phase
			    String p_Name7=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 23, 35);
			    tr.clickOnRelease(releaseName);
				actual[33]=tr.selectPhase(p_Name6);
				actual[34]=req.addNode(p_Name7,p_Desc1);
				tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
			    String[] str7=new String[7];
			    str7[0]=p_Name1;
			    str7[1]=p_Name2;
			    str7[2]=p_Name3;
			    str7[3]=p_Name4;
			    str7[4]=p_Name5;
			    str7[5]=p_Name6;
			    str7[6]=p_Name7;
			    actual[35]=tr.navigateToNode(releaseName, str7);
			    req.addRequirement();
			    req.addRequirement();
			    req.selectRequirementsFromGrids(requirementNum1);
			    actual[36]=req.enterRequirementDetails(name1, altID, link, priority, Description);
			    
			    req.selectRequirementsFromGrids(requirementNum2);
			    actual[37]=req.enterRequirementDetails(name11, altID, link, priority, Description);
			    
			    
			  //8th phase phase
			    String p_Name8=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 24, 35);
			    tr.clickOnRelease(releaseName);
				actual[38]=tr.selectPhase(p_Name7);
				actual[39]=req.addNode(p_Name8,p_Desc1);
				tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
			    String[] str8=new String[8];
			    str8[0]=p_Name1;
			    str8[1]=p_Name2;
			    str8[2]=p_Name3;
			    str8[3]=p_Name4;
			    str8[4]=p_Name5;
			    str8[5]=p_Name6;
			    str8[6]=p_Name7;
			    str8[7]=p_Name8;
			    actual[40]=tr.navigateToNode(releaseName, str8);
			    req.addRequirement();
			    req.addRequirement();
			    req.selectRequirementsFromGrids(requirementNum1);
			    actual[41]=req.enterRequirementDetails(name1, altID, link, priority, Description);
			    
			    req.selectRequirementsFromGrids(requirementNum2);
			    actual[42]=req.enterRequirementDetails(name11, altID, link, priority, Description);
			    
			    
			  //9th phase phase
			    String p_Name9=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 25, 35);
			    tr.clickOnRelease(releaseName);
				actual[43]=tr.selectPhase(p_Name8);
				actual[44]=req.addNode(p_Name9,p_Desc1);
				tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
			    String[] str9=new String[9];
			    str9[0]=p_Name1;
			    str9[1]=p_Name2;
			    str9[2]=p_Name3;
			    str9[3]=p_Name4;
			    str9[4]=p_Name5;
			    str9[5]=p_Name6;
			    str9[6]=p_Name7;
			    str9[7]=p_Name8;
			    str9[8]=p_Name9;
			    actual[45]=tr.navigateToNode(releaseName, str9);
			    req.addRequirement();
			    req.addRequirement();
			    req.selectRequirementsFromGrids(requirementNum1);
			    actual[46]=req.enterRequirementDetails(name1, altID, link, priority, Description);
			    
			    req.selectRequirementsFromGrids(requirementNum2);
			    actual[47]=req.enterRequirementDetails(name11, altID, link, priority, Description);
			    
			    
			  //10th phase phase
			    String p_Name10=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 26, 35);
			    tr.clickOnRelease(releaseName);
				actual[48]=tr.selectPhase(p_Name9);
				actual[49]=req.addNode(p_Name10,p_Desc1);
				tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
			    String[] str10=new String[10];
			    str10[0]=p_Name1;
			    str10[1]=p_Name2;
			    str10[2]=p_Name3;
			    str10[3]=p_Name4;
			    str10[4]=p_Name5;
			    str10[5]=p_Name6;
			    str10[6]=p_Name7;
			    str10[7]=p_Name8;
			    str10[8]=p_Name9;
			    str10[9]=p_Name10;
			    actual[50]=tr.navigateToNode(releaseName, str10);
			    req.addRequirement();
			    req.addRequirement();
			    req.selectRequirementsFromGrids(requirementNum1);
			    actual[51]=req.enterRequirementDetails(name1, altID, link, priority, Description);
			    
			    req.selectRequirementsFromGrids(requirementNum2);
			    actual[52]=req.enterRequirementDetails(name11, altID, link, priority, Description);*/
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

	@When("^Launch The DashBoard Page and create a dashBoard$")
	public void launch_The_DashBoard_Page_and_create_a_dashBoard() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
			bp=new BasePage();
			actual[28]=dbp.clickOnManageDashboards();
			actual[29]=dbp.clickOnAddDashBoardSymbol();
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 17,35);
			String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
			String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
			String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
			actual[30]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
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

	@When("^add a gadge and configure and save the gadget$")
	public void add_a_gadge_and_configure_and_save_the_gadget() throws Throwable {
		try
	    {
			req=new RequirementsPage(driver);
			dbp=new DashBoardPage(driver);
	    	String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 17,35);
	    	actual[31]=dbp.selectDashboard(dashboardName);
	    	actual[32]=dbp.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
			actual[33]=dbp.addGadget(gadgetName);
			
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[34]=dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 String searchOption=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,34);
//			 String searchOption2=a[0];
			 actual[35]=dbp.traceabilityQuickSearch(searchOption);
			 req.selectAllRequirements();
			 dbp.closeTraceabilityTable();
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

	@When("^minimize and maximize the saved report gadget$")
	public void minimize_and_maximize_the_saved_report_gadget() throws Throwable {
		try
		{
			 actual[36]=dbp.saveGadget();
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

	@Then("^gadget minimized and maximized successfully$")
	public void gadget_minimized_and_maximized_successfully() throws Throwable {
		try
		{
		     String mimimizeGadget=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,13); 
		     actual[37]=dbp.gadgetOperation(mimimizeGadget);
		     bp.waitForElement();
		     
		     String maxmizeGadget=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,13); 
		     actual[38]=dbp.gadgetOperation(maxmizeGadget);
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

	@When("^minimize and maximize the unsaved report gadget$")
	public void minimize_and_maximize_the_unsaved_report_gadget() throws Throwable {
	  try
	  {
		  dbp.clickOnAddGadgetSymbol();
		  
		  String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6);
		  actual[39]=dbp.addGadget(gadgetName);
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

	@Then("^gadget should be minimized and maximized$")
	public void gadget_should_be_minimized_and_maximized() throws Throwable {
		 try
		  {
			  String mimimizeGadget=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,13); 
			  actual[40]=dbp.gadgetOperation(mimimizeGadget);
			  
			  String maxmizeGadget=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,13); 
			  actual[41]=dbp.gadgetOperation(maxmizeGadget);
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

	@When("^delete a saved report gadget$")
	public void delete_a_saved_report_gadget() throws Throwable {
		try
		  {
			  String deleteGadget1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,13); 
			  actual[42]=dbp.gadgetOperation(deleteGadget1);
			  bp.waitForElement();
			  String deleteGadget=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,13); 
			  actual[43]=dbp.gadgetOperation(deleteGadget);
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

	@Then("^should be able to add gadget$")
	public void should_be_able_to_add_gadget() throws Throwable {
		 try
		  {
			 dbp.clickOnAddGadgetSymbol();
			 
			 String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6);
			 actual[44]=dbp.addGadget(gadgetName);
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

	@When("^delete a unsaved report gadget$")
	public void delete_a_unsaved_report_gadget() throws Throwable {
		try
		  {  
			 String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
			  actual[45]=dbp.validateGadget(gadgetName);
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

	@Then("^unsaved report gadget deleted successfully$")
	public void unsaved_report_gadget_deleted_successfully() throws Throwable {
	  try
	  {
		  String deleteGadget=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,13); 
		  actual[46]=dbp.gadgetOperation(deleteGadget);
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

	@When("^delete a selected requirement from requirement app after saving gadget$")
	public void delete_a_selected_requirement_from_requirement_app_after_saving_gadget() throws Throwable {
		try
		  {
			dbp.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
			dbp.addGadget(gadgetName);
			
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[47]=dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 String searchOption=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,34);
			 dbp.traceabilityQuickSearch(searchOption);
			 req.selectAllRequirements();
			 dbp.closeTraceabilityTable(); 
			 dbp.saveGadget();
			
			    pp=new ProjectPage(driver);//
				 bp=new BasePage();
				 rp=new ReleasePage(driver);
				 tr=new TestRepositoryPage(driver);
				 String projectName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_3");
			     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			     pp.backToProjectPage();
			     pp.selectProject(projectName1);
				 pp.selectProject(projectName);
			     pp.selectRelease(releaseName);
			     rp.clickOnRequirements();
			
			     tr.clickOnRelease(releaseName);
			     String[] navigation=new String[1];
			     navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 17, 35);
			     tr.navigateToNode(releaseName, navigation);
		        ep=new ExportPage(driver);
			    String[] testCaseNo=new String[2];
			    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 15));
			    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 2, 15));
			    //actual[71]=ep.selectMultipleTestCaseFromGrid(testCaseNo);
		        actual[48]=req.selectMultipleRequirementFromGrids(testCaseNo);
		        bp.waitForElement();
		        bp.waitForElement();
                   bp.waitForElement();

		        String type=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4, 13);
			    actual[49]=req.deleteOrDeallocateRequirements(type);
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

	@Then("^gadget should be update and remove the deleted requirement$")
	public void gadget_should_be_update_and_remove_the_deleted_requirement() throws Throwable {
		try
		  { 
			dbp.clickOnManageDashboards();
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 17,35);
			dbp.searchDashboard(dashboardName);
			dbp.selectDashboard(dashboardName);
			//actual[73]=dbp.reqTraceabilityTable();
			actual[50]=req.VerifyRequirementCount();
			bp.waitForElement();
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
