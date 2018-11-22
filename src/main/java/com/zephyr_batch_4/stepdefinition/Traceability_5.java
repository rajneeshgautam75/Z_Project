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

public class Traceability_5 extends LaunchBrowser{

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
	String fileName="Traceability_5";
	
	boolean[] actual=new boolean[75];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^As the Lead,Launch Requirements$")
	public void as_the_Lead_Launch_Requirements() throws Throwable {
		try
	    {
	    	   bp=new BasePage();
			   rp=new ReleasePage(driver);
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			   String projectName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_6");
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

	@When("^add a requirements with a nodes$")
	public void add_a_requirements_with_a_nodes() throws Throwable {
	  try
	  {
		  req=new RequirementsPage(driver);
		   tr=new TestRepositoryPage(driver);
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_6");
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 20, 14);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 36);
			
			actual[3]=tr.clickOnRelease(releaseName);
			bp.waitForElement();
			actual[4]=req.addNode(p_Name1,p_Desc1);
			bp.waitForElement();
		    String[] str=new String[1];
		    str[0]=p_Name1;
		    actual[5]=tr.navigateToNode(releaseName, str);
		    req.addRequirement();
		    tr.clickOnDetails();
		    String name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"DashBoards",19,34);
	    	String altID=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
	    	String link=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
	    	String priority=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
	    	String Description=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
		    actual[6]=req.enterRequirementDetails(name1, altID, link, priority, Description);
		    bp.waitForElement();
		    tr.clickOnList();
		    for(int i=0;i<=7;i++)
		    {
		     req.selectAllRequirements();
		     req.cloneRequirement();
		     bp.waitForElement();
		    }
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    
		    tr.clickOnRelease(releaseName);
		    String p_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 21, 14);
		    actual[7]=req.addNode(p_Name2, p_Desc1);
		    bp.waitForElement();
		    String[] str2=new String[1];
		    str2[0]=p_Name2;
		    actual[8]=tr.navigateToNode(releaseName, str2);
		    req.addRequirement();
		    tr.clickOnDetails();
		    String name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"DashBoards",20,34);
		    actual[9]=req.enterRequirementDetails(name2, altID, link, priority, Description);
		    tr.clickOnList();
		    for(int i=0;i<=2;i++)
		    {
		     req.selectAllRequirements();
		     req.cloneRequirement();
		     bp.waitForElement();
		    }
		    req.selectAllRequirements();
		    req.selectAllRequirements();
		    bp.waitForElement();
		    bp.waitForElement();
		    
		    String[] requirementNum1=new String[2];
		    requirementNum1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 15));
		    requirementNum1[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 2, 15));
		    req.selectMultipleRequirementFromGrids(requirementNum1);
		    req.cloneRequirement();
		    
		    bp.waitForElement();
		    req.cloneRequirement();
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

	@When("^Launch testRepository,create testcases$")
	public void launch_testRepository_create_testcases() throws Throwable {
		try
		   {
			   /*bp=new BasePage();//
			   rp=new ReleasePage(driver);
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_6");
			   actual[0]=pp.selectProject(projectName);
			   actual[1]=pp.selectRelease(releaseName);//*/
			
			   bp.waitForElement();
			   actual[10]=rp.clickOnTestRep();
			   
			   tr=new TestRepositoryPage(driver);
		       String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_6");
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 22, 14);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 36);
				
				actual[11]=tr.clickOnRelease(releaseName);
				bp.waitForElement();
				actual[12]=tr.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
			    String[] str=new String[1];
			    str[0]=p_Name1;
			    actual[13]=tr.navigateToNode(releaseName, str);
			    for(int i=0;i<=5;i++)
			    {
			    tr.addTestCase();
			    }
			    ep=new ExportPage(driver);
			    String[] testCaseNo=new String[1];
			    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 15));
			    tr.clickOnDetails();
			    actual[14]=ep.selectMultipleTestCaseFromGrid(testCaseNo);
			    req=new RequirementsPage(driver);
			    //tr.clickOnDetails();
			    req.MapRequirements(); 
				 //String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
				 actual[15]=req.ExpandRelease(releaseName);
				 bp.waitForElement();
//				 bp.waitForElement();
//				 bp.waitForElement();
				 String[] str1=new String[1];
				 str1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 20, 14);
				 actual[16]=tr.navigateNode(str1);
				 //tr.navigateToNode(releaseName, str);
				 //String[] requirementNum1=new String[1];
//				 String requirementNum1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 15));
//				 actual[18]=req.selectRequirement(requirementNum1);
				 
				 String[] testCaseNo1=new String[50];
				 
				 int k7=1;
				 for(int k=0;k<=49;k++)
				 {
				 	
					 testCaseNo1[k]=Integer.toString(k7);
				 	k7++;
				 	System.out.println(k7);
				 }
				 bp.waitForElement();
				 bp.waitForElement();
				 tr.selectMultipleRequirementFromGrid(testCaseNo1);//
				 //req.selectAllRequirementsFormGrid();
				 actual[17]=req.saveJiraRequirement();
				 bp.waitForElement();
				 //tr.clickOnList();
				 
				    ep=new ExportPage(driver);
				    String[] testCaseNo2=new String[1];
				    testCaseNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 2, 15));
				    actual[18]=ep.selectMultipleTestCaseFromGrid(testCaseNo2);
				    req.MapRequirements(); 
					 //String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
					 actual[19]=req.ExpandRelease(releaseName);
//					 bp.waitForElement();
//					 bp.waitForElement();
					 String[] str2=new String[1];
					 str2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 20, 14);
					 actual[20]=tr.navigateNode(str2);
					 //tr.navigateToNode(releaseName, str);
					 //String[] requirementNum1=new String[1];
//					 String requirementNum2=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 2, 15));
//					 actual[23]=req.selectRequirement(requirementNum2);
					 req.requirementNextButton.click();
					 bp.waitForElement();
					 String[] testCaseNo22=new String[50];
					 int k8=1;
					 for(int i=0;i<=49;i++)
					 {
					 	
						 testCaseNo22[i]=Integer.toString(k8);
					 	k8++;
					 }
					 bp.waitForElement();
					 
					 tr.selectMultipleRequirementFromGrid(testCaseNo22);
					 bp.waitForElement();
					 //req.selectAllRequirementsFormGrid();
					 actual[21]=req.saveJiraRequirement();
					 //tr.clickOnList();//
			 
			   ep=new ExportPage(driver);
			    String[] testCaseNo3=new String[1];
			    testCaseNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 3, 15));
			    actual[22]=ep.selectMultipleTestCaseFromGrid(testCaseNo3);
			    //tr.clickOnDetails();
			    req.MapRequirements(); 
				 //String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
				 actual[23]=req.ExpandRelease(releaseName);
//						 bp.waitForElement();
//						 bp.waitForElement();
				 String[] str3=new String[1];
				 str3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 20, 14);
				 actual[24]=tr.navigateNode(str3);
				 //tr.navigateToNode(releaseName, str);
				 //String[] requirementNum1=new String[1];
//				 String requirementNum3=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 3, 15));
//				 actual[28]=req.selectRequirement(requirementNum3);
				 req.requirementNextButton.click();
				 bp.waitForElement();
				 String[] testCaseNo33=new String[50];
				 int k9=1;
				 for(int i=0;i<=49;i++)
				 {
				 	
					 testCaseNo33[i]=Integer.toString(k9);
				 	k9++;
				 }
				 bp.waitForElement();
				 
				 tr.selectMultipleRequirementFromGrid(testCaseNo33);
				 bp.waitForElement();
				 //req.selectAllRequirementsFormGrid();
				 actual[25]=req.saveJiraRequirement();
				 //tr.clickOnList();
				 
				    ep=new ExportPage(driver);
				    String[] testCaseNo4=new String[1];
				    testCaseNo4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 4, 15));
				    actual[26]=ep.selectMultipleTestCaseFromGrid(testCaseNo4);
				    //tr.clickOnDetails();
				    req.MapRequirements(); 
					 //String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
					 actual[27]=req.ExpandRelease(releaseName);
//							 bp.waitForElement();
//							 bp.waitForElement();
					 String[] str4=new String[1];
					 str4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 20,14);
					 actual[28]=tr.navigateNode(str4);
					 //tr.navigateToNode(releaseName, str);
					 //String[] requirementNum1=new String[1];
//					 String requirementNum4=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 4, 15));
//					 actual[33]=req.selectRequirement(requirementNum4);
					 req.requirementNextButton.click();
					 bp.waitForElement();
					 String[] testCaseNo44=new String[50];
					 int k10=1;
					 for(int i=0;i<=49;i++)
					 {
					 	
						 testCaseNo44[i]=Integer.toString(k10);
					 	k10++;
					 }
					 bp.waitForElement();
					 
					 tr.selectMultipleRequirementFromGrid(testCaseNo44);
					 bp.waitForElement();
					 //req.selectAllRequirementsFormGrid();
					 actual[29]=req.saveJiraRequirement();
					 //tr.clickOnList();
					 
					    ep=new ExportPage(driver);
					    String[] testCaseNo5=new String[1];
					    testCaseNo5[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 5, 15));
					    actual[30]=ep.selectMultipleTestCaseFromGrid(testCaseNo5);
					    //tr.clickOnDetails();
					    req.MapRequirements(); 
						 //String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
						 actual[31]=req.ExpandRelease(releaseName);
//								 bp.waitForElement();
						 String[] str5=new String[1];
						 str5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 20,14);
						 actual[32]=tr.navigateNode(str5);
						 //tr.navigateToNode(releaseName, str);
						 //String[] requirementNum1=new String[1];
//						 String requirementNum5=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 5, 15));
//						 actual[38]=req.selectRequirement(requirementNum5);
						 req.requirementNextButton.click();
						 bp.waitForElement();
						 String[] testCaseNo55=new String[50];
						 int k11=1;
						 for(int i=0;i<=49;i++)
						 {
						 	
							 testCaseNo55[i]=Integer.toString(k11);
						 	k11++;
						 }
						 bp.waitForElement();
						 
						 tr.selectMultipleRequirementFromGrid(testCaseNo55);
						 bp.waitForElement();
						 //req.selectAllRequirementsFormGrid();
						 actual[33]=req.saveJiraRequirement();
						 //tr.clickOnList();
						 
						 
						    ep=new ExportPage(driver);
						    String[] testCaseNo6=new String[1];
						    testCaseNo6[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 6, 15));
						    actual[34]=ep.selectMultipleTestCaseFromGrid(testCaseNo6);
						   // tr.clickOnDetails();
						    req.MapRequirements(); 
							 //String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
							 actual[35]=req.ExpandRelease(releaseName);
//									 bp.waitForElement();
							 String[] str6=new String[1];
							 str6[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 21,14);
							 actual[36]=tr.navigateNode(str6);
							 //tr.navigateToNode(releaseName, str);
							 //String[] requirementNum1=new String[1];
//							 String requirementNum5=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 5, 15));
//							 actual[38]=req.selectRequirement(requirementNum5);
							 String[] testCaseNo66=new String[10];
							 int k12=1;
							 for(int i=0;i<=9;i++)
							 {
							 	
								 testCaseNo66[i]=Integer.toString(k12);
							 	k12++;
							 }
							 bp.waitForElement();
							 
							 tr.selectMultipleRequirementFromGrid(testCaseNo66);
							 bp.waitForElement();
							 //req.selectAllRequirementsFormGrid();
							 actual[37]=req.saveJiraRequirement();
							 bp.waitForElement();
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

	@When("^Launch testPlanning page,create a cycle$")
	public void launch_testPlanning_page_create_a_cycle() throws Throwable {
		try
		   {
			  bp.waitForElement();
			  rp.clickOnTestPlanning();
			  
			    tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 19, 30);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[38]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				bp.waitForElement();
				actual[39]=tp.saveTestCycle();
				bp.waitForElement();
				
				bp.waitForElement();
				rp.clickOnTestPlanning();
				
		    	String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 19, 30);
				tp.navigateToCycle(cycle1);
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

	@When("^choose a phase to the cycle$")
	public void choose_a_phase_to_the_cycle() throws Throwable {
		try
		   {	
				bp.waitForElement();
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 22, 14);
				actual[40]=tp.addPhaseToCycle(Phase);
				bp.waitForElement();
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
				bp.waitForElement();
				actual[41]=tp.bulkAssignment(Bulk_Type);
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

	@When("^Launch Test Execution and execute testcases,link defects$")
	public void launch_Test_Execution_and_execute_testcases_link_defects() throws Throwable {
		try
		   {
			     /*pp=new ProjectPage(driver);//
				 bp=new BasePage();
				 rp=new ReleasePage(driver);
				 tr=new TestRepositoryPage(driver);
				 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_6");
				 pp.selectProject(projectName);
			     pp.selectRelease(releaseName);// */
			   
			   bp.waitForElement();
			   rp.clickOnTestExecution(); 
	           bp.waitForElement();
			   
			   String[] cycleName=new String[2];
			    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_6");
			    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",19 ,30 );
			    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",22 ,14 );
			    bp.waitForElement();
			    tp=new TestPlanningPage(driver);
			    bp.waitForElement();
				actual[42]=tr.navigateToNode(releaseName, cycleName);
				bp.waitForElement();
			
				int[] tcNo1=new int[1];
				tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
			    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[43]=exep.executeStatus(tcNo1[0], statusType1);
			    
			    int[] tcNo2=new int[1];
				tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
			    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[44]=exep.executeStatus(tcNo2[0], statusType2);	
			    
			    int[] tcNo3=new int[1];
			    tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
			    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[45]=exep.executeStatus(tcNo3[0], statusType3);
			    
			    int[] tcNo4=new int[1];
				tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
			    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
			    bp.waitForElement();
			    actual[46]=exep.executeStatus(tcNo4[0], statusType4);
			    
			    int[] tcNo5=new int[1];
				tcNo5[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5 ,19 );
			    String statusType5=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
			    bp.waitForElement();
			    actual[47]=exep.executeStatus(tcNo5[0], statusType5);
			    
			    int[] tcNo6=new int[1];
				tcNo6[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",6 ,19 );
			    String statusType6=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
			    bp.waitForElement();
			    actual[48]=exep.executeStatus(tcNo6[0], statusType6);
			    
			    int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1,19 );
				exep.clickOnDefectButton(testcase1);
				   
				  String defectId1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",1 ,31 );
				  actual[49]=exep.linkDefect(defectId1);
				  
				  int testcase2=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2,19 );
					exep.clickOnDefectButton(testcase2);
					exep.linkDefect(defectId1);
					
					int testcase3=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3,19 );
					exep.clickOnDefectButton(testcase3);
					exep.linkDefect(defectId1);
					
					int testcase4=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4,19 );
					exep.clickOnDefectButton(testcase4);
					exep.linkDefect(defectId1);	
					
					int testcase5=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5,19 );
					exep.clickOnDefectButton(testcase5);
					exep.linkDefect(defectId1);
					
					int testcase6=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",6,19 );
					exep.clickOnDefectButton(testcase6);
					exep.linkDefect(defectId1);
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

	@When("^add the DashBoard and add the traceability gadget$")
	public void add_the_DashBoard_and_add_the_traceability_gadget() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
			bp=new BasePage();
			actual[50]=dbp.clickOnManageDashboards();
			actual[51]=dbp.clickOnAddDashBoardSymbol();
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 20,30);
			String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
			String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
			String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
			actual[52]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
			
			//String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 17,30);
	    	actual[53]=dbp.selectDashboard(dashboardName);
	    	actual[54]=dbp.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
			actual[55]=dbp.addGadget(gadgetName);
			
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_6");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[56]=dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 String searchOption=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 20,34);
//			 String searchOption2=a[0];
			 driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 //dbp.gadgetOperation(value);
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();

			 actual[57]=dbp.traceabilityQuickSearch(searchOption);
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
	
	@Then("^should be able to add the Gadget$")
	public void should_be_able_to_add_the_Gadget() throws Throwable {
		 try
		  {
			  actual[58]=dbp.saveGadget();
			  String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
			  actual[59]=dbp.validateGadget(gadgetName);
			  
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
	
	@When("^add traceability gadget with hundred requirements mapped to different testcases and executions linked to defect$")
	public void add_traceability_gadget_with_hundred_requirements_mapped_to_different_testcases_and_executions_linked_to_defect() throws Throwable {
		try
		  {
			    dbp.clickOnAddGadgetSymbol();
				String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
				actual[60]=dbp.addGadget(gadgetName);
				
				String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
				 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_6");
				 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
				 actual[61]=dbp.configureTraceabilityGadget(projectName, release, refreshRate);
				 dbp.manageTraceability();
				 driver.navigate().refresh();
				 bp.waitForElement();
				 bp.waitForElement();
				 bp.waitForElement();
				 bp.waitForElement();
				 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
				 dbp.manageTraceability();
				 String searchOption=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 19,34);
//				 String searchOption2=a[0];
				 actual[62]=dbp.traceabilityQuickSearch(searchOption);
				 dbp.zqlNextButton();
				 bp.waitForElement();
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

	@Then("^Should be able to view the mapped data in the gadget$")
	public void should_be_able_to_view_the_mapped_data_in_the_gadget() throws Throwable {
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

	@When("^add traceability gadget with thousand requirements mapped to different testcases and executions linked to defect$")
	public void add_traceability_gadget_with_thousand_requirements_mapped_to_different_testcases_and_executions_linked_to_defect() throws Throwable {
		try
		  {
			    dbp.clickOnAddGadgetSymbol();
				String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
				actual[65]=dbp.addGadget(gadgetName);
				driver.navigate().refresh();
				for(int i=1;i<=5;i++)
				{bp.waitForElement();}
				 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
				 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_6");
				 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
				 actual[66]=dbp.configureTraceabilityGadget(projectName, release, refreshRate);
				 dbp.manageTraceability();
				 driver.navigate().refresh();
				 bp.waitForElement();
				 bp.waitForElement();
				 bp.waitForElement();
				 bp.waitForElement();
				 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
				 dbp.manageTraceability();
				 String searchOption=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 19,34);
//				 String searchOption2=a[0];
				 actual[67]=dbp.traceabilityQuickSearch(searchOption);
				 dbp.zqlNextButton();
				 bp.waitForElement();
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

	@Then("^Should be able to view the mapped data and defect in the gadget$")
	public void should_be_able_to_view_the_mapped_data_and_defect_in_the_gadget() throws Throwable {
		try
		  {
			  actual[68]=dbp.saveGadget();
			  String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
			  actual[69]=dbp.validateGadget(gadgetName);
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

	@When("^Add Traceability gadget with one thousand requirements mapped to different testcases and executions linked to defect$")
	public void add_Traceability_gadget_with_one_thousand_requirements_mapped_to_different_testcases_and_executions_linked_to_defect() throws Throwable {
		try
		  {
			    dbp.clickOnAddGadgetSymbol();
				String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
				actual[70]=dbp.addGadget(gadgetName);
				driver.navigate().refresh();
				for(int i=1;i<=5;i++)
				{bp.waitForElement();}
				bp.waitForElement();
				
				String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
				 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_6");
				 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
				 actual[71]=dbp.configureTraceabilityGadget(projectName, release, refreshRate);
				 dbp.manageTraceability();
				 driver.navigate().refresh();
				 bp.waitForElement();
				 bp.waitForElement();
				 bp.waitForElement();
				 bp.waitForElement();
				 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
				 dbp.manageTraceability();
				 String searchOption=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 19,34);
//				 String searchOption2=a[0];
				 actual[72]=dbp.traceabilityQuickSearch(searchOption);
				 dbp.zqlNextButton();
				 bp.waitForElement();
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

	@Then("^Should be able to view the Mapped data and Defect in the gadget$")
	public void should_be_able_to_view_the_Mapped_data_and_Defect_in_the_gadget() throws Throwable {
		try
		  {
			  actual[73]=dbp.saveGadget();
			  String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
			  actual[74]=dbp.validateGadget(gadgetName);
			  
//			  int reqNo=Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 3,6);
//			  String executionStatus=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
//			  String defectStatus=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
//			  dbp.validateExecutionsInGadget(reqNo, executionStatus, defectStatus);
			  
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
