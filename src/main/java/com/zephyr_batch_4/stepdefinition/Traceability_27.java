package com.zephyr_batch_4.stepdefinition;

import org.openqa.selenium.By;
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

public class Traceability_27 extends LaunchBrowser{

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
	String fileName="Traceability_27";
	
	String[] a=new String[1];
	boolean[] actual=new boolean[42];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^As a Lead,Launch the Requirements Page$")
	public void as_a_Lead_Launch_the_Requirements_Page() throws Throwable {
		 try
		    {
		    	   bp=new BasePage();
				   rp=new ReleasePage(driver);
				   pp=new ProjectPage(driver);
				   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
				   String projectName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
				   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
				   //pp.backToProjectPage();
				   pp.selectProject(projectName1);
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

	@When("^create a node and add the requirements$")
	public void create_a_node_and_add_the_requirements() throws Throwable {
		try
		   {
			   req=new RequirementsPage(driver);
			   tr=new TestRepositoryPage(driver);
			    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 14, 35);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 36);
				
				actual[3]=tr.clickOnRelease(releaseName);
				bp.waitForElement();
				actual[4]=req.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
			    String[] str=new String[1];
			    str[0]=p_Name1;
			    actual[5]=tr.navigateToNode(releaseName, str);
			    for(int i=0;i<=7;i++)
			    {
			    req.addRequirement();
			    }
			    String[] requirementNum1=new String[1];
			    requirementNum1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 15));
			    tr.clickOnDetails();
			    req.selectMultipleRequirementFromGrids(requirementNum1);
			    
			    String name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"DashBoards",3,34);
		    	String altID=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
		    	String link=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
		    	String priority=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
		    	String Description=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
			    actual[6]=req.enterRequirementDetails(name1, altID, link, priority, Description);
			    //tr.clickOnList();
//			    int k = 0;
//			    for (int i = 1; i <= 1; i++) {
//
//			     a[k] = driver.findElement(
//			       By.xpath(req.requirementID1 + i + req.requirementID2))
//			       .getText();
//			     System.out.println(a[k]);
//			     k++;
//			    }
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

	@When("^launch Test Repository page$")
	public void launch_Test_Repository_page() throws Throwable {
	   try
	   {
		   bp.waitForElement();
		   actual[6]=rp.clickOnTestRep();
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

	@When("^create a node with testcases$")
	public void create_a_node_with_testcases() throws Throwable {
	 try
	 {
		    tr=new TestRepositoryPage(driver);
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 15, 35);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 36);
			
			actual[7]=tr.clickOnRelease(releaseName);
			bp.waitForElement();
			actual[8]=tr.addNode(p_Name1,p_Desc1);
			bp.waitForElement();
		    String[] str=new String[1];
		    str[0]=p_Name1;
		    actual[9]=tr.navigateToNode(releaseName, str);
		    for(int i=0;i<=3;i++)
		    {
		    tr.addTestCase();
		    }
		    ep=new ExportPage(driver);
		    String[] testCaseNo=new String[1];
		    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 15));
		    tr.clickOnDetails();
		    actual[10]=ep.selectMultipleTestCaseFromGrid(testCaseNo);
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

	@When("^map requirement to the testcase$")
	public void map_requirement_to_the_testcase() throws Throwable {
	  try
	  {
		 req=new RequirementsPage(driver);
		 req.MapRequirements(); 
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
		 actual[11]=req.ExpandRelease(releaseName);
//		 bp.waitForElement();
//		 bp.waitForElement();
		 String[] str=new String[1];
		 str[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 14, 35);
		 actual[12]=tr.navigateNode(str);
		 //tr.navigateToNode(releaseName, str);
		 //String[] requirementNum1=new String[1];
		 String requirementNum1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 15));
		 actual[13]=req.selectRequirement(requirementNum1);
		 actual[14]=req.saveJiraRequirement();
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

	@When("^launch TestPlanning,create a cycle$")
	public void launch_TestPlanning_create_a_cycle() throws Throwable {
		try
		   {
			  bp.waitForElement();
			  actual[15]=rp.clickOnTestPlanning();
			  
			    tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 14, 30);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[16]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[17]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[18]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				bp.waitForElement();
				actual[19]=tp.saveTestCycle();
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

	@When("^add phase to the cycle by choosing an existing phase$")
	public void add_phase_to_the_cycle_by_choosing_an_existing_phase() throws Throwable {
		try
	    {
			actual[20]=bp.waitForElement();
			//actual[20]=rp.clickOnTestPlanning();
			
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 14, 30);
			actual[21]=tp.navigateToCycle(cycle);
			
			bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 15, 35);
			actual[22]=tp.addPhaseToCycle(Phase);
			bp.waitForElement();
			String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
			bp.waitForElement();
			actual[23]=tp.bulkAssignment(Bulk_Type);
			tp.goBackToCycle();
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

	@When("^launch Test Execution to execute the testcases$")
	public void launch_Test_Execution_to_execute_the_testcases() throws Throwable {
		try
		   {
			     /*pp=new ProjectPage(driver);//
				 bp=new BasePage();
				 rp=new ReleasePage(driver);
				 tr=new TestRepositoryPage(driver);
				 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
				 String projectName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4");
			     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			     pp.selectProject(projectName1);
				 pp.selectProject(projectName);
			     pp.selectRelease(releaseName);// */
			   
			   bp.waitForElement();
			   actual[24]=rp.clickOnTestExecution(); 
	           bp.waitForElement();
			   
			   String[] cycleName=new String[2];
			    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");//
			    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",14 ,30 );
			    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",15 ,35 );
			    
			    bp.waitForElement();
			    tp=new TestPlanningPage(driver);
			    bp.waitForElement();
			    bp.waitForElement();
			    bp.waitForElement();
				actual[25]=tr.navigateToNode(releaseName, cycleName);
				bp.waitForElement();
			
				int[] tcNo1=new int[1];
				tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
			    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[26]=exep.executeStatus(tcNo1[0], statusType1);
			    
			    int[] tcNo2=new int[1];
				tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
			    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[27]=exep.executeStatus(tcNo2[0], statusType2);
			    
			    int[] tcNo3=new int[1];
			    tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
			    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[28]=exep.executeStatus(tcNo3[0], statusType3);
			    
			    int[] tcNo4=new int[1];
				tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
			    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
			    bp.waitForElement();
			    actual[29]=exep.executeStatus(tcNo4[0], statusType4);
			    
//			    int[] tcNo5=new int[1];
//				tcNo5[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5 ,19 );
//			    String statusType5=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
//			    bp.waitForElement();
//			    actual[25]=exep.executeStatus(tcNo5[0], statusType5);
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

	@When("^launch the dashBoard page$")
	public void launch_the_dashBoard_page() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
			bp=new BasePage();
			actual[30]=dbp.clickOnManageDashboards();
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

	@When("^add a dashBoard by clicking on the plus symbol$")
	public void add_a_dashBoard_by_clicking_on_the_plus_symbol() throws Throwable {
		try
		{
		actual[31]=dbp.clickOnAddDashBoardSymbol();
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 14,35);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[32]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
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

	@When("^add a traceability gadget by clicking on the add gadget symbol$")
	public void add_a_traceability_gadget_by_clicking_on_the_add_gadget_symbol() throws Throwable {
		try
	    {
	    	String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 14,35);
	    	actual[33]=dbp.selectDashboard(dashboardName);
	    	actual[34]=dbp.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
			actual[35]=dbp.addGadget(gadgetName);
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

	@When("^configure the gadget by selecting the project,release and the refresh rate$")
	public void configure_the_gadget_by_selecting_the_project_release_and_the_refresh_rate() throws Throwable {
	  try
	  {
		     req=new RequirementsPage(driver);
		     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[36]=dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 String searchOption=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,34);
//			 String searchOption2=a[0];
			 driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 //dbp.gadgetOperation(value);
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 actual[37]=dbp.traceabilityQuickSearch(searchOption);
			 req.selectAllRequirements();
			 dbp.closeTraceabilityTable();
			 actual[38]=dbp.saveGadget();
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

	@Then("^able to see the project,release,requirement,status,proper mapping with testcase and defect status in the gadget$")
	public void able_to_see_the_project_release_requirement_status_proper_mapping_with_testcase_and_defect_status_in_the_gadget() throws Throwable {
		try
	    {
		  String traceabilityProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 	
	      actual[39]=dbp.validateSavedGadget(traceabilityProject);
	      
	      String traceabilityRelease=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4"); 	
	      actual[40]=dbp.validateSavedGadget(traceabilityRelease);
	      
	      String traceabilityRequirement=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,34);
	      actual[41]=dbp.validateSavedGadget(traceabilityRequirement);
	      
	      pp.backToProjectPage();
//	      String traceabilityStatus=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,18);	
//	      dbp.validateTraceabilityGadget(traceabilityStatus);
//	      
//	      String traceabilityDefectStatus=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8);	
//	      dbp.validateTraceabilityGadget(traceabilityDefectStatus);
	      
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
