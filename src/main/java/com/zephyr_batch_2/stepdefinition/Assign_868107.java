package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Assign_868107 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tl;
	boolean[] actual=new boolean[94];
	 SoftAssert soft=new SoftAssert();
	 String filename="Assign_868107";
	@Given("^user in repository Page to create P/S/SS$")
	public void user_in_repository_Page_to_create_P_S_SS() throws Throwable 
	{
		 try
		   {
			   pp=new ProjectPage(driver);
			   //String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,0);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			   actual[0]=pp.selectProject(projectName);
			   bp=new BasePage();
			   bp.waitForElement();
			   actual[1]=pp.selectRelease(releaseName);
			   bp.waitForElement();
			   rp= new ReleasePage(driver);
			   actual[2]=rp.clickOnTestRep();
			   bp.waitForElement();
			   tr=new TestRepositoryPage(driver);
			   actual[3]=tr.doubleClickOnRelease(releaseName);
			   bp.waitForElement();
		   }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}  
	}

	@Given("^Create P/S/SS add test cases and clone$")
	public void create_P_S_SS_add_test_cases_and_clone() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 13, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 13, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 13, 0);
			tr.navigateToNode(releaseName, phase);
			bp.waitForElement();
			
			tr.addTestCase();
			 ctc=new CreateTestCasePage(driver);
			   String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 8, 0);
			   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 8, 1);
			   tr.clickOnDetails();
			   ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
			   bp.waitForElement();
			   tr.clickOnList();
			   actual[5]=tr.selectallTestCase();
			   bp.waitForElement();
			   actual[6]=tr.cloneTestCase();
			   bp.waitForElement();
			   tr.selectallTestCase();
			   bp.waitForElement();
			   actual[7]=tr.cloneTestCase();
			   bp.waitForElement();
			   //String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			   actual[8]=tr.doubleClickOnRelease(releaseName);
				//navigate to phase/////////////////////////////////////////////////////////////////////
				phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 13, 0);
				actual[9]=tr.navigateToNode(releaseName, phase);
				bp.waitForElement();
				String systemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 13, 2);
				String systemDesc1=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 13, 3);
				actual[10]=tr.addNode(systemName, systemDesc1);
				
				actual[11]=tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
				String system[]=new String[2];
				system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 13, 0);
				system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 13, 2);
				actual[12]=tr.navigateToNode(releaseName, system);
				bp.waitForElement();
				
				actual[13]=tr.addTestCase();
				 String testCaseName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 8, 2);
				   String testCaseDesc1=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 8, 3);
				   tr.clickOnDetails();
				   actual[14]=ctc.enterTestCaseNameAndDesc(testCaseName1, testCaseDesc1);
				   tr.clickOnList();
				   actual[15]=tr.selectallTestCase();
				   bp.waitForElement();
				   actual[16]=tr.cloneTestCase();
				   bp.waitForElement();
				   actual[17]= tr.selectallTestCase();
				   bp.waitForElement();
				   actual[18]=tr.cloneTestCase();
				   bp.waitForElement();
				   
				   actual[19]=tr.doubleClickOnRelease(releaseName);
				   String[] navigation=new String[2];
				   //navigate to system/////////////////////////////////////////////////////////////////////
				   navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 13, 0);
				   navigation[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 13, 2);
				   actual[20]=tr.navigateToNode(releaseName, navigation);
				   bp.waitForElement();
					String subsystemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 13, 4);
					String subsystemDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 13, 5);
					actual[21]=tr.addNode(subsystemName, subsystemDesc);
					
					actual[22]=tr.doubleClickOnRelease(releaseName);
					bp.waitForElement();
					String subsystem[]=new String[3];
					subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 13, 0);
					subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 13, 2);
					subsystem[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 13, 4);
					actual[23]=tr.navigateToNode(releaseName, subsystem);
					bp.waitForElement();
					
					actual[24]=tr.addTestCase();
					 String testCaseName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 8, 4);
					   String testCaseDesc2=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 8, 5);
					   tr.clickOnDetails();
					   actual[25]=ctc.enterTestCaseNameAndDesc(testCaseName2, testCaseDesc2);
					   bp.waitForElement();
					   tr.clickOnList();
					   actual[26]=tr.selectallTestCase();
					   bp.waitForElement();
					   actual[27]=actual[6]=tr.cloneTestCase();
					   bp.waitForElement();
					   actual[28]=tr.selectallTestCase();
					   bp.waitForElement();
					   actual[29]=tr.cloneTestCase();
					   bp.waitForElement();
			}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}  
	}

	@When("^launch test planning create cycle and add phase to cycle$")
	public void launch_test_planning_create_cycle_and_add_phase_to_cycle() throws Throwable 
	{
		try
		{
			tl=new TestPlanningPage(driver);
			actual[30]=rp.clickOnTestPlanning();
			bp.waitForElement();
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 6, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 6, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 6, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
			actual[31]=tl.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[32]=tl.CreateCycle(cyclename, Build, Environment,hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
			actual[33]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[34]=tl.saveTestCycle();
			bp.waitForElement();
		    String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 6, 0);
			actual[35]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 13, 0);
			actual[36]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[37]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@When("^select testcases and assign to different users$")
	public void select_testcases_and_assign_to_different_users() throws Throwable 
	{
		try
		{
		String[] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 13, 0);
		actual[38]=tl.navigateToCycle(phase);
		bp.waitForElement();
		int[] TestcaseNo=new int[1];
		TestcaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		//String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		String manager=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User1");
		actual[39]=tl.individualAssinTo(TestcaseNo, manager);
		bp.waitForElement();
		
		int[] TestcaseNo2=new int[1];
		TestcaseNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		//String Assigne2=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 3, 0);
		String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		actual[40]=tl.individualAssinTo(TestcaseNo2, lead);
		bp.waitForElement();
		
		int[] TestcaseNo3=new int[1];
		TestcaseNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		//String Assignee3=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 4, 0);
		String tester=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		actual[41]=tl.individualAssinTo(TestcaseNo3, tester);
		bp.waitForElement();
		
		int[] TestcaseNo4=new int[1];
		TestcaseNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		//String Assignee4=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		//String lead1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		actual[42]=tl.individualAssinTo(TestcaseNo4, lead);
		bp.waitForElement();
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
		
	}

	@When("^select Phase/bulk assign/assign all notexecuted/assign to tester/donot seletect subfolder$")
	public void select_Phase_bulk_assign_assign_all_notexecuted_assign_to_tester_donot_seletect_subfolder() throws Throwable 
	{
		try
		{
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 13, 0);
			actual[43]=tl.navigateToCycle(phase);
		    bp.waitForElement();
		    actual[44]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		   // String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 4, 0);
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    String tester=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		    actual[45]=tl.assignAllNotexecuted(tester, Check);
		    bp.waitForElement();
		 }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^select System/bulk assign/assign all notexecuted/assign to tester/donot seletect subfolder$")
	public void select_System_bulk_assign_assign_all_notexecuted_assign_to_tester_donot_seletect_subfolder() throws Throwable 
	{
		try
		{
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 13, 0);
			actual[46]=tl.navigateToCycle(phase);
			
			String system[]=new String[1];
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 13, 2);
			actual[47]=tl.navigateToCycle(system);
		    bp.waitForElement();
		    
		    actual[48]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		   // String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 4, 0);
		    String tester=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    actual[49]=tl.assignAllNotexecuted(tester, Check);
		    bp.waitForElement();
		 }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^select SubSystem/bulk assign/assign all notexecuted/assign to tester/donot seletect subfolder$")
	public void select_SubSystem_bulk_assign_assign_all_notexecuted_assign_to_tester_donot_seletect_subfolder() throws Throwable 
	{
		try
		{
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 13, 0);
			actual[50]=tl.navigateToCycle(phase);
			
			//String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 13, 0);
			tl.navigateToCycle(phase);
			
			String system[]=new String[1];
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 13, 2);
			actual[51]=tl.navigateToCycle(system);
		    bp.waitForElement();
				
			String subsystem[]=new String[1];
			subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 13, 4);
			actual[52]=tl.navigateToCycle(subsystem);
		    bp.waitForElement();
		    
		    actual[53]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 4, 0);
		    String tester=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    actual[54]=tl.assignAllNotexecuted(tester, Check);
		    bp.waitForElement();
		    
		    tl.goBackToCycle();
		 }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^Launch test planning and choose existing phase$")
	public void launch_test_planning_and_choose_existing_phase() throws Throwable 
	{
		try
		{
			actual[55]=rp.clickOnTestPlanning();
			 bp.waitForElement();
			 String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 6, 0);
			actual[56]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 13, 0);
			actual[57]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[58]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
		 
	}

	@When("^Select Testcases and assign to different users$")
	public void select_Testcases_and_assign_to_different_users() throws Throwable 
	{
		try
		{
		String[] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 13, 0);
		actual[59]=tl.navigateToCycle(phase);
		bp.waitForElement();
		int[] TestcaseNo=new int[1];
		TestcaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		//String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		 String manager=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User1");
		actual[60]=tl.individualAssinTo(TestcaseNo, manager);
		bp.waitForElement();
		
		int[] TestcaseNo2=new int[1];
		TestcaseNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		//String Assigne2=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 3, 0);
		 String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		actual[61]=tl.individualAssinTo(TestcaseNo2, lead);
		bp.waitForElement();
		
		int[] TestcaseNo3=new int[1];
		TestcaseNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		//String Assignee3=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 4, 0);
		 String tester=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		actual[62]=tl.individualAssinTo(TestcaseNo3, tester);
		bp.waitForElement();
		
		int[] TestcaseNo4=new int[1];
		TestcaseNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		//String Assignee4=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		actual[63]=tl.individualAssinTo(TestcaseNo4, tester);
		bp.waitForElement();
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@When("^Select phase/bulk assign/assign all notexecuted/assign to lead/seletect subfolder$")
	public void select_phase_bulk_assign_assign_all_notexecuted_assign_to_lead_seletect_subfolder() throws Throwable 
	{
		try
		{
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 13, 0);
			actual[64]=tl.navigateToCycle(phase);
		    bp.waitForElement();
		    actual[65]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    actual[66]=tl.assignAllNotexecuted(lead, Check);
		    bp.waitForElement();
		    tl.goBackToCycle();
		 }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^Launch Test planning and choose Existing phase$")
	public void launch_Test_planning_and_choose_Existing_phase() throws Throwable 
	{
		try
		{
			actual[67]=rp.clickOnTestPlanning();
			bp.waitForElement();
			String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 6, 0);
			actual[68]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 13, 0);
			actual[69]=tl.addPhaseToCycle(nodeName);
		    bp.waitForElement();
		    String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		    actual[70]=tl.bulkAssignment(Bulk_type);
		    bp.waitForElement();
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@When("^Select Testcases and assign to Different users$")
	public void select_Testcases_and_assign_to_Different_users() throws Throwable 
	{
		try
		{
		String[] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 13, 0);
		actual[71]=tl.navigateToCycle(phase);
		bp.waitForElement();
		int[] TestcaseNo=new int[1];
		TestcaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		//String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		 String tester=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		actual[72]=tl.individualAssinTo(TestcaseNo, tester);
		bp.waitForElement();
		
		int[] TestcaseNo2=new int[1];
		TestcaseNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		//String Assigne2=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 3, 0);
		 String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		actual[73]=tl.individualAssinTo(TestcaseNo2, lead);
		bp.waitForElement();
		
		int[] TestcaseNo3=new int[1];
		TestcaseNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		//String Assignee3=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 4, 0);
		 String manager=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User1");
		actual[74]=tl.individualAssinTo(TestcaseNo3, manager);
		bp.waitForElement();
		
		int[] TestcaseNo4=new int[1];
		TestcaseNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		//String Assignee4=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		actual[75]=tl.individualAssinTo(TestcaseNo4, manager);
		bp.waitForElement();
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@When("^Select system/bulk Assign/assign all notexecuted/assign to lead/seletect subfolder$")
	public void select_system_bulk_Assign_assign_all_notexecuted_assign_to_lead_seletect_subfolder() throws Throwable 
	{
		try
		{
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 13, 0);
			actual[76]=tl.navigateToCycle(phase);
			
			//String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 13, 0);
			tl.navigateToCycle(phase);
			
			String system[]=new String[1];
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 13, 2);
			actual[77]=tl.navigateToCycle(system);
		    bp.waitForElement();
		    
		    actual[78]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    actual[79]=tl.assignAllNotexecuted(lead, Check);
		    bp.waitForElement();
		    tl.goBackToCycle();
		 }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^Launch Test planning choose Existing phase$")
	public void launch_Test_planning_choose_Existing_phase() throws Throwable 
	{
		try
		{
		actual[80]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		 
		 String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 6, 0);
			actual[81]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 13, 0);
			actual[82]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[83]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@When("^Select Testcases and assign To Different Users$")
	public void select_Testcases_and_assign_To_Different_Users() throws Throwable 
	{
		try
		{
		String[] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 13, 0);
		actual[84]=tl.navigateToCycle(phase);
		bp.waitForElement();
		int[] TestcaseNo=new int[1];
		TestcaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		//String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		 String tester=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		actual[85]=tl.individualAssinTo(TestcaseNo, tester);
		bp.waitForElement();
		
		int[] TestcaseNo2=new int[1];
		TestcaseNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		//String Assigne2=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 3, 0);
		 String manager=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User1");
		actual[86]=tl.individualAssinTo(TestcaseNo2, manager);
		bp.waitForElement();
		
		int[] TestcaseNo3=new int[1];
		TestcaseNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		//String Assignee3=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 4, 0);
		 String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		actual[87]=tl.individualAssinTo(TestcaseNo3, lead);
		bp.waitForElement();
		
		int[] TestcaseNo4=new int[1];
		TestcaseNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		//String Assignee4=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		actual[88]=tl.individualAssinTo(TestcaseNo4, lead);
		bp.waitForElement();
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@When("^Select subsystem/bulk assign/Assign all notexecuted/assign to Lead/seletect subfolder$")
	public void select_subsystem_bulk_assign_Assign_all_notexecuted_assign_to_Lead_seletect_subfolder() throws Throwable 
	{
		try
		{
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 13, 0);
			actual[89]=tl.navigateToCycle(phase);
			
			//String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 13, 0);
			tl.navigateToCycle(phase);
			
			String system[]=new String[1];
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 13, 2);
			actual[90]=tl.navigateToCycle(system);
		    bp.waitForElement();
				
			String subsystem[]=new String[1];
			subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 13, 4);
			actual[91]=tl.navigateToCycle(subsystem);
		    
		    bp.waitForElement();
		    actual[92]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    
		    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
		    actual[93]=tl.assignAllNotexecuted(lead, Check);
		    bp.waitForElement();
		    tl.goBackToCycle();
		    bp.waitForElement();
		 }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@Then("^All the nodes including child nodes testcases should be assigned to tester\\.one$")
	public void all_the_nodes_including_child_nodes_testcases_should_be_assigned_to_tester_one() throws Throwable 
	{
		try
		   {
			   for(int k=0;k<=actual.length-1;k++)
			     {
			      soft.assertEquals(actual[k], true);
			     }
			    soft.assertAll();
		   }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
		
	}
}
