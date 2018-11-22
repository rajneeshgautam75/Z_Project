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

public class Traceability_4 extends LaunchBrowser{

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
	String fileName="Traceability_4";
	
	boolean[] actual=new boolean[89];
	 SoftAssert soft=new SoftAssert();
	 
	 @Given("^As the Lead,Launch Requirements and add requirements$")
	 public void as_the_Lead_Launch_Requirements_and_add_requirements() throws Throwable {
		 try
		    {
		    	   bp=new BasePage();
				   rp=new ReleasePage(driver);
				   pp=new ProjectPage(driver);
				   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
				   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
				   //pp.backToProjectPage();
				   actual[0]=pp.selectProject(projectName);
				   actual[1]=pp.selectRelease(releaseName);
				   rp= new ReleasePage(driver);
				   bp.waitForElement();
				   actual[2]=rp.clickOnRequirements();
				   
				   req=new RequirementsPage(driver);
				   tr=new TestRepositoryPage(driver);
				    //String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
					String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 17, 14);
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
				    tr.clickOnDetails();
				    String[] requirementNum1=new String[1];
				    requirementNum1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 15));
				    req.selectMultipleRequirementFromGrids(requirementNum1);
				    
				    String name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"DashBoards",7,34);
			    	String altID=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
			    	String link=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
			    	String priority=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
			    	String Description=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
				    actual[6]=req.enterRequirementDetails(name1, altID, link, priority, Description);
				    
				    String[] requirementNum2=new String[1];
				    requirementNum2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 2, 15));
				    //tr.clickOnList();
				    req.selectMultipleRequirementFromGrids(requirementNum2);
				    //tr.clickOnDetails();
				    String name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"DashBoards",8,34);
				    actual[7]=req.enterRequirementDetails(name2, altID, link, priority, Description);
				    
				    String[] requirementNum3=new String[1];
				    requirementNum3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 3, 15));
				    //tr.clickOnList();
				    req.selectMultipleRequirementFromGrids(requirementNum3);
				    //tr.clickOnDetails();
				    String name3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"DashBoards",9,34);
				    actual[8]=req.enterRequirementDetails(name3, altID, link, priority, Description);
				    
				    String[] requirementNum4=new String[1];
				    requirementNum4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 4, 15));
				    //tr.clickOnList();
				    req.selectMultipleRequirementFromGrids(requirementNum4);
				    //tr.clickOnDetails();
				    String name4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"DashBoards",10,34);
				    actual[9]=req.enterRequirementDetails(name4, altID, link, priority, Description);
				    
				    String[] requirementNum5=new String[1];
				    requirementNum5[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 5, 15));
				    //tr.clickOnList();
				    req.selectMultipleRequirementFromGrids(requirementNum5);
				    //tr.clickOnDetails();
				    String name5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"DashBoards",11,34);
				    actual[10]=req.enterRequirementDetails(name5, altID, link, priority, Description);
				    //tr.clickOnList();
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

	 @When("^add testcases in Test Repository and map requirements$")
	 public void add_testcases_in_Test_Repository_and_map_requirements() throws Throwable {
	   try
	   {
		   bp.waitForElement();
		   actual[11]=rp.clickOnTestRep();
		   
		   tr=new TestRepositoryPage(driver);
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 18, 14);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 36);
			
			actual[12]=tr.clickOnRelease(releaseName);
			bp.waitForElement();
			actual[13]=tr.addNode(p_Name1,p_Desc1);
			bp.waitForElement();
		    String[] str=new String[1];
		    str[0]=p_Name1;
		    actual[14]=tr.navigateToNode(releaseName, str);
		    for(int i=0;i<=5;i++)
		    {
		    tr.addTestCase();
		    }
		    tr.clickOnDetails();
		    ep=new ExportPage(driver);
		    String[] testCaseNo=new String[1];
		    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 15));
		    actual[15]=ep.selectMultipleTestCaseFromGrid(testCaseNo);
		    req.MapRequirements(); 
			 //String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			 actual[16]=req.ExpandRelease(releaseName);
//			 bp.waitForElement();
//			 bp.waitForElement();
			 String[] str1=new String[1];
			 str1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 17, 14);
			 actual[17]=tr.navigateNode(str1);
			 //tr.navigateToNode(releaseName, str);
			 //String[] requirementNum1=new String[1];
			 String requirementNum1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 15));
			 actual[18]=req.selectRequirement(requirementNum1);
			 actual[19]=req.saveJiraRequirement();
			 
			 ep=new ExportPage(driver);
			    String[] testCaseNo2=new String[1];
			    testCaseNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 2, 15));
			    actual[20]=ep.selectMultipleTestCaseFromGrid(testCaseNo2);
			    //tr.clickOnDetails();
			    req.MapRequirements(); 
				 //String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
				 actual[21]=req.ExpandRelease(releaseName);
//				 bp.waitForElement();
//				 bp.waitForElement();
				 String[] str2=new String[1];
				 str2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 17, 14);
				 actual[22]=tr.navigateNode(str2);
				 //tr.navigateToNode(releaseName, str);
				 //String[] requirementNum1=new String[1];
				 String requirementNum2=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 2, 15));
				 actual[23]=req.selectRequirement(requirementNum2);
				 actual[24]=req.saveJiraRequirement();
				 //tr.clickOnList();
				 
				   ep=new ExportPage(driver);
				    String[] testCaseNo3=new String[1];
				    testCaseNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 3, 15));
				    actual[25]=ep.selectMultipleTestCaseFromGrid(testCaseNo3);
				   // tr.clickOnDetails();
				    req.MapRequirements(); 
					 //String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
					 actual[26]=req.ExpandRelease(releaseName);
//					 bp.waitForElement();
//					 bp.waitForElement();
					 String[] str3=new String[1];
					 str3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 17, 14);
					 actual[27]=tr.navigateNode(str3);
					 //tr.navigateToNode(releaseName, str);
					 //String[] requirementNum1=new String[1];
					 String requirementNum3=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 3, 15));
					 actual[28]=req.selectRequirement(requirementNum3);
					 actual[29]=req.saveJiraRequirement();
					 //tr.clickOnList();
					 
					 ep=new ExportPage(driver);
					    String[] testCaseNo4=new String[1];
					    testCaseNo4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 4, 15));
					    actual[30]=ep.selectMultipleTestCaseFromGrid(testCaseNo4);
					   // tr.clickOnDetails();
					    req.MapRequirements(); 
						 //String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
						 actual[31]=req.ExpandRelease(releaseName);
//						 bp.waitForElement();
//						 bp.waitForElement();
						 String[] str4=new String[1];
						 str4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 17,14);
						 actual[32]=tr.navigateNode(str4);
						 //tr.navigateToNode(releaseName, str);
						 //String[] requirementNum1=new String[1];
						 String requirementNum4=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 4, 15));
						 actual[33]=req.selectRequirement(requirementNum4);
						 actual[34]=req.saveJiraRequirement();
						 //tr.clickOnList();
						 
						 ep=new ExportPage(driver);
						    String[] testCaseNo5=new String[1];
						    testCaseNo5[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 5, 15));
						    actual[35]=ep.selectMultipleTestCaseFromGrid(testCaseNo5);
						   // tr.clickOnDetails();
						    req.MapRequirements(); 
							 //String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
							 actual[36]=req.ExpandRelease(releaseName);
//							 bp.waitForElement();
							 String[] str5=new String[1];
							 str5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 17,14);
							 actual[37]=tr.navigateNode(str5);
							 //tr.navigateToNode(releaseName, str);
							 //String[] requirementNum1=new String[1];
							 String requirementNum5=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 5, 15));
							 actual[38]=req.selectRequirement(requirementNum5);
							 actual[39]=req.saveJiraRequirement();
							 //tr.clickOnList();
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
	
	@When("^Launch TEstPlanning,create cycle and add a phase$")
	public void launch_TEstPlanning_create_cycle_and_add_a_phase() throws Throwable {
		try
		   {
			  bp.waitForElement();
			  rp.clickOnTestPlanning();
			  
			    tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 16, 30);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[40]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[41]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				bp.waitForElement();
				actual[42]=tp.saveTestCycle();
				bp.waitForElement();
				
				bp.waitForElement();
				//rp.clickOnTestPlanning();
				
				
		    	String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 16, 30);
				tp.navigateToCycle(cycle1);
				
				bp.waitForElement();
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 18, 14);
				actual[43]=tp.addPhaseToCycle(Phase);
				bp.waitForElement();
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
				bp.waitForElement();
				actual[44]=tp.bulkAssignment(Bulk_Type);
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

	@When("^Launch Test Execution,execute testcases and link to defect$")
	public void launch_Test_Execution_execute_testcases_and_link_to_defect() throws Throwable {
		try
		   {
			    /* pp=new ProjectPage(driver);//
				 bp=new BasePage();
				 rp=new ReleasePage(driver);
				 tr=new TestRepositoryPage(driver);
				 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
				 pp.selectProject(projectName);
			     pp.selectRelease(releaseName);// */
			   
			   bp.waitForElement();
			   rp.clickOnTestExecution(); 
	           bp.waitForElement();
			   
			   String[] cycleName=new String[2];
			    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
			    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",16 ,30 );
			    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",18 ,14 );
			    bp.waitForElement();
			    tp=new TestPlanningPage(driver);
			    bp.waitForElement();
				actual[45]=tr.navigateToNode(releaseName, cycleName);
				bp.waitForElement();
			
				int[] tcNo1=new int[1];
				tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
			    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[46]=exep.executeStatus(tcNo1[0], statusType1);
			    
			    int[] tcNo2=new int[1];
				tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5 ,19 );
			    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[47]=exep.executeStatus(tcNo2[0], statusType2);
			    
			    int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5,19 );
				exep.clickOnDefectButton(testcase1);
				   
				  String defectId1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",11 ,32 );////
				  actual[48]=exep.linkDefect(defectId1);		
			    
//			    int[] tcNo3=new int[1];
//			    tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
//			    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,18 );
//			    bp.waitForElement();
//			    exep=new ExecutionPage(driver);
//			    actual[28]=exep.executeStatus(tcNo3[0], statusType3);
//			    
//			    int[] tcNo4=new int[1];
//				tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
//			    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
//			    bp.waitForElement();
//			    actual[29]=exep.executeStatus(tcNo4[0], statusType4);
			    
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

	@When("^Launches  DashBoard page$")
	public void launches_DashBoard_page() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
			bp=new BasePage();
			actual[49]=dbp.clickOnManageDashboards();
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

	@When("^add a DashBoard with available fields$")
	public void add_a_DashBoard_with_available_fields() throws Throwable {
		try
		{
		actual[50]=dbp.clickOnAddDashBoardSymbol();
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 17,30);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[51]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
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

	@When("^add a traceability gadget with release contains only unmapped requirements$")
	public void add_a_traceability_gadget_with_release_contains_only_unmapped_requirements() throws Throwable {
		try
	    {
	    	String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 17,30);
	    	actual[52]=dbp.selectDashboard(dashboardName);
	    	actual[53]=dbp.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
			actual[54]=dbp.addGadget(gadgetName);
			
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[55]=dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 String searchOption=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,34);
//			 String searchOption2=a[0];
			 actual[56]=dbp.traceabilityQuickSearch(searchOption);
			 req=new RequirementsPage(driver);
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

	@Then("^should be able to add the gadget$")
	public void should_be_able_to_add_the_gadget() throws Throwable {
	  try
	  {
		  actual[57]=dbp.saveGadget();
		  String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
			actual[58]=dbp.validateGadget(gadgetName);
		  
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

	@When("^add a traceability gadget with requirements mapped to testcases not scheduled for executions$")
	public void add_a_traceability_gadget_with_requirements_mapped_to_testcases_not_scheduled_for_executions() throws Throwable {
		try
	    {
	    	actual[59]=dbp.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
			actual[60]=dbp.addGadget(gadgetName);
			
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[61]=dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			
			 String searchOption=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 7,34);
//			 String searchOption2=a[0];
			 actual[62]=dbp.traceabilityQuickSearch(searchOption);
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

	@Then("^should be able to add traceability gadget$")
	public void should_be_able_to_add_traceability_gadget() throws Throwable {
		 try
		  {
			  actual[63]=dbp.saveGadget();
			  String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
			  actual[64]=dbp.validateGadget(gadgetName);
			  
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

	@When("^add a traceability gadget with requirements mapped to testcases scheduled but not assigned$")
	public void add_a_traceability_gadget_with_requirements_mapped_to_testcases_scheduled_but_not_assigned() throws Throwable {
		try
	    {
	    	actual[65]=dbp.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
			actual[66]=dbp.addGadget(gadgetName);
			
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[67]=dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			
			 String searchOption=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 8,34);
//			 String searchOption2=a[0];
			 actual[68]=dbp.traceabilityQuickSearch(searchOption);
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

	@Then("^should be able To add traceability gadget$")
	public void should_be_able_To_add_traceability_gadget() throws Throwable {
		 try
		  {
			  actual[69]=dbp.saveGadget();
			  String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
				actual[70]=dbp.validateGadget(gadgetName);
			  
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

	@When("^add a traceability gadget with requirements mapped to testcases assigned but not executed$")
	public void add_a_traceability_gadget_with_requirements_mapped_to_testcases_assigned_but_not_executed() throws Throwable {
		try
	    {
	    	actual[71]=dbp.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
			actual[72]=dbp.addGadget(gadgetName);
			
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[73]=dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 
			 String searchOption=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 9,34);
//			 String searchOption2=a[0];
			 actual[74]=dbp.traceabilityQuickSearch(searchOption);
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

	@Then("^should be able to add the traceability gadget$")
	public void should_be_able_to_add_the_traceability_gadget() throws Throwable {
		 try
		  {
			  actual[75]=dbp.saveGadget();
			  String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
				actual[76]=dbp.validateGadget(gadgetName);
			  
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

	@When("^add a traceability gadget with requirements mapped to testcases executed but not linked to defect$")
	public void add_a_traceability_gadget_with_requirements_mapped_to_testcases_executed_but_not_linked_to_defect() throws Throwable {
		try
	    {
	    	actual[77]=dbp.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
			actual[78]=dbp.addGadget(gadgetName);
			
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[79]=dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 
			 String searchOption=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 10,34);
//			 String searchOption2=a[0];
			 actual[80]=dbp.traceabilityQuickSearch(searchOption);
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

	@Then("^Should be able to add gadget$")
	public void should_be_able_to_add_gadget() throws Throwable {
		 try
		  {
			  actual[81]=dbp.saveGadget();
			  String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
				actual[82]=dbp.validateGadget(gadgetName);
			  
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

	@When("^add a traceability gadget with requirements mapped to testcases executed and linked to defect$")
	public void add_a_traceability_gadget_with_requirements_mapped_to_testcases_executed_and_linked_to_defect() throws Throwable {
		try
	    {
	    	actual[83]=dbp.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
			actual[84]=dbp.addGadget(gadgetName);
			
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[85]=dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			
			 String searchOption=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 11,34);
//			 String searchOption2=a[0];
			 actual[86]=dbp.traceabilityQuickSearch(searchOption);
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

	@Then("^Should Be able to add gadget$")
	public void should_Be_able_to_add_gadget() throws Throwable {
		 try
		  {
			  actual[87]=dbp.saveGadget();
			  String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
			  actual[88]=dbp.validateGadget(gadgetName);
			  
				for(int k=0;k<=actual.length-1;k++)
				{
					System.out.println("Actual["+k+"]="+actual[k]);
					soft.assertEquals(actual[k], true);
				}
				soft.assertAll();
				pp.backToProjectPage();
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
