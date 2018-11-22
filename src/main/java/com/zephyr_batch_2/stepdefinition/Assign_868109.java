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

public class Assign_868109 extends LaunchBrowser
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
	boolean[] actual=new boolean[86];
	 SoftAssert soft=new SoftAssert();
	 String filename="Assign_868109";
	@Given("^User in repository page to create p/s/ss$")
	public void user_in_repository_page_to_create_p_s_ss() throws Throwable 
	{
		try
		   {
			   pp=new ProjectPage(driver);
			  // String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,0);
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
	@Given("^crate p/s/ss add test case and clone$")
	public void crate_p_s_ss_add_test_case_and_clone() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 15, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 15, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			actual[5]=tr.doubleClickOnRelease(releaseName);
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 15, 0);
			actual[6]=tr.navigateToNode(releaseName, phase);
			
			actual[7]=tr.addTestCase();
			 ctc=new CreateTestCasePage(driver);
			   String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 10, 0);
			   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 10, 1);
			   tr.clickOnDetails();
			   actual[8]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
			   bp.waitForElement();
			   tr.clickOnList();
			   tr.selectallTestCase();
			   bp.waitForElement();
			   actual[9]=tr.cloneTestCase();
			   bp.waitForElement();
			   tr.selectallTestCase();
			   bp.waitForElement();
			   actual[10]=tr.cloneTestCase();
			   bp.waitForElement();
			  // String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			   actual[11]=tr.doubleClickOnRelease(releaseName);
				//String[] phase=new String[1];
				//navigate to phase/////////////////////////////////////////////////////////////////////
				//phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 15, 0);
			   actual[12]=tr.navigateToNode(releaseName, phase);
				bp.waitForElement();
				String systemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 15, 2);
				String systemDesc1=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 15, 3);
				actual[13]=tr.addNode(systemName, systemDesc1);
				
				actual[14]=tr.doubleClickOnRelease(releaseName);
				String system[]=new String[2];
				system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 15, 0);
				system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 15, 2);
				actual[15]=tr.navigateToNode(releaseName, system);
				
				actual[16]=tr.addTestCase();
				 String testCaseName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 10, 2);
				   String testCaseDesc1=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 10, 3);
				   tr.clickOnDetails();
				   actual[17]=ctc.enterTestCaseNameAndDesc(testCaseName1, testCaseDesc1);
				   bp.waitForElement();
				   tr.clickOnList();
				   actual[18]=tr.selectallTestCase();
				   bp.waitForElement();
				   actual[19]=tr.cloneTestCase();
				   bp.waitForElement();
				   actual[20]=tr.selectallTestCase();
				   bp.waitForElement();
				   actual[21]=tr.cloneTestCase();
				   bp.waitForElement();
				   
				   actual[22]=tr.doubleClickOnRelease(releaseName);
				   String[] navigation=new String[2];
				   //navigate to system/////////////////////////////////////////////////////////////////////
				   navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 15, 0);
				   navigation[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 15, 2);
				   actual[23]=tr.navigateToNode(releaseName, navigation);
				   bp.waitForElement();
					String subsystemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 15, 4);
					String subsystemDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 15, 5);
					actual[24]=tr.addNode(subsystemName, subsystemDesc);
					
					actual[25]=tr.doubleClickOnRelease(releaseName);
					String subsystem[]=new String[3];
					subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 15, 0);
					subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 15, 2);
					subsystem[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 15, 4);
					actual[26]=tr.navigateToNode(releaseName, subsystem);
					
					actual[27]=tr.addTestCase();
					 String testCaseName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 10, 4);
					   String testCaseDesc2=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 10, 5);
					   tr.clickOnDetails();
					   actual[28]=ctc.enterTestCaseNameAndDesc(testCaseName2, testCaseDesc2);
					   bp.waitForElement();
					   tr.clickOnList();
					   actual[29]=tr.selectallTestCase();
					   bp.waitForElement();
					   actual[30]=tr.cloneTestCase();
					   bp.waitForElement();
					   actual[31]=tr.selectallTestCase();
					   bp.waitForElement();
					   actual[32]=tr.cloneTestCase();
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
	@When("^Launch testplanning create Cycle and addd phase$")
	public void launch_testplanning_create_Cycle_and_addd_phase() throws Throwable 
	{
		try
		{
			actual[33]=rp.clickOnTestPlanning();
			bp.waitForElement();
			tl=new TestPlanningPage(driver);
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 8, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 8, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 8, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
			actual[34]=tl.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[35]=tl.CreateCycle(cyclename, Build, Environment,hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
			actual[36]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[37]=tl.saveTestCycle();
			bp.waitForElement();
		   String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 8, 0);
			actual[38]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 15, 0);
			actual[39]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[40]=tl.bulkAssignment(Bulk_type);
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

	@When("^Select phase assign testcase to different users$")
	public void select_phase_assign_testcase_to_different_users() throws Throwable 
	{
		try
		{
		String[] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
		actual[41]=tl.navigateToCycle(phase);
		bp.waitForElement();
		int[] TestcaseNo=new int[1];
		TestcaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		//String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		actual[42]=tl.individualAssinTo(TestcaseNo,lead);
		bp.waitForElement();
		
		int[] TestcaseNo2=new int[1];
		TestcaseNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		//String Assigne2=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 3, 0);
		String manager=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User1");
		actual[43]=tl.individualAssinTo(TestcaseNo2, manager);
		bp.waitForElement();
		
		int[] TestcaseNo3=new int[1];
		TestcaseNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		//String Assignee3=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 4, 0);
		String tester=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		actual[44]=tl.individualAssinTo(TestcaseNo3, tester);
		bp.waitForElement();
		
		int[] TestcaseNo4=new int[1];
		TestcaseNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		String Assignee4=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		actual[45]=tl.individualAssinTo(TestcaseNo4, Assignee4);
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

	@When("^select system assin all to Anyone$")
	public void select_system_assin_all_to_Anyone() throws Throwable 
	{
		try
		{
//		String system[]=new String[2];
//		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
//		system[1]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 2);
//		actual[46]=tl.navigateToCycle(system);
		
		String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
		actual[46]=tl.navigateToCycle(phase);
		
		//String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
		tl.navigateToCycle(phase);
		
		String system[]=new String[1];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 2);
		actual[47]=tl.navigateToCycle(system);
		
	    bp.waitForElement();
	    actual[48]=tl.selectallTestCase();
	    bp.waitForElement();
	    String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
	    actual[49]=tl.assignAllSelected(Assignee);
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

	@When("^Select Phase/bulk assign/assign all Unassigned/assign to lead/seletect subfolder$")
	public void select_Phase_bulk_assign_assign_all_Unassigned_assign_to_lead_seletect_subfolder() throws Throwable 
	{
		try
		{
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
			actual[50]=tl.navigateToCycle(phase);
		    bp.waitForElement();
		    actual[51]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1,1);
		    actual[52]=tl.assignAllUnassigned(lead, Check);
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

	@When("^Launch testplanning add phase existing phase and save$")
	public void launch_testplanning_add_phase_existing_phase_and_save() throws Throwable 
	{
		try
		{
		actual[53]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		 String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 8, 0);
			actual[54]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 15, 0);
			actual[55]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[56]=tl.bulkAssignment(Bulk_type);
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

	@When("^Select Phase assign testcase to different users$")
	public void select_Phase_assign_testcase_to_different_users() throws Throwable 
	{
		try
		{
		String[] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
		actual[57]=tl.navigateToCycle(phase);
		bp.waitForElement();
		int[] TestcaseNo=new int[1];
		TestcaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		//String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		actual[58]=tl.individualAssinTo(TestcaseNo, lead);
		bp.waitForElement();
		
		int[] TestcaseNo2=new int[1];
		TestcaseNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		//String Assigne2=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 3, 0);
		String tester=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		actual[59]=tl.individualAssinTo(TestcaseNo2, tester);
		bp.waitForElement();
		
		int[] TestcaseNo3=new int[1];
		TestcaseNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		//String Assignee3=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 4, 0);
		String manager=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User1");
		actual[60]=tl.individualAssinTo(TestcaseNo3, manager);
		bp.waitForElement();
		
		int[] TestcaseNo4=new int[1];
		TestcaseNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		//String Assignee4=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		//String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		actual[61]=tl.individualAssinTo(TestcaseNo4, lead);
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

	@When("^select System Assign all to Anyone$")
	public void select_System_Assign_all_to_Anyone() throws Throwable 
	{
		try
		{
//		String system[]=new String[2];
//		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
//		system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 2);
//		actual[61]=tl.navigateToCycle(system);
		
		String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
		actual[62]=tl.navigateToCycle(phase);
		
		//String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
		tl.navigateToCycle(phase);
		
	String system[]=new String[1];
	system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 2);
	actual[63]=tl.navigateToCycle(system);
		
	    bp.waitForElement();
	    actual[64]=tl.selectallTestCase();
	    bp.waitForElement();
	    String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
	    actual[65]=tl.assignAllSelected(Assignee);
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

	@When("^Select system/bulk assign/assign all Unassigned/assign to lead/Seletect subfolder$")
	public void select_system_bulk_assign_assign_all_Unassigned_assign_to_lead_Seletect_subfolder() throws Throwable 
	{
		try
		{
//		String system[]=new String[2];
//		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
//		system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 2);
//		actual[64]=tl.navigateToCycle(system);
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
			actual[66]=tl.navigateToCycle(phase);
			
			//String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
			tl.navigateToCycle(phase);
			
			String system[]=new String[1];
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 2);
			actual[67]=tl.navigateToCycle(system);
				
		    bp.waitForElement();
		    actual[65]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		   // String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
		    actual[68]=tl.assignAllUnassigned(lead, Check);
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

	@When("^Launch testplanning add phase Existing phase and save$")
	public void launch_testplanning_add_phase_Existing_phase_and_save() throws Throwable 
	{
		try
		{
		actual[69]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		 String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 8, 0);
			actual[70]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 15, 0);
			actual[71]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[72]=tl.bulkAssignment(Bulk_type);
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

	@When("^Select Phase assign testcase to Different users$")
	public void select_Phase_assign_testcase_to_Different_users() throws Throwable 
	{
		try
		{
		String[] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
		actual[73]=tl.navigateToCycle(phase);
		bp.waitForElement();
		
		//String[] phase=new String[1];
		//phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
		actual[73]=tl.navigateToCycle(phase);
		
		tl.navigateToCycle(phase);
		int[] TestcaseNo=new int[1];
		TestcaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		//String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		actual[74]=tl.individualAssinTo(TestcaseNo, lead);
		bp.waitForElement();
		
		int[] TestcaseNo2=new int[1];
		TestcaseNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		//String Assigne2=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 3, 0);
		//String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		actual[75]=tl.individualAssinTo(TestcaseNo2, lead);
		bp.waitForElement();
		
		int[] TestcaseNo3=new int[1];
		TestcaseNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		//String Assignee3=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 4, 0);
		String tester=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		actual[76]=tl.individualAssinTo(TestcaseNo3, tester);
		bp.waitForElement();
		
		int[] TestcaseNo4=new int[1];
		TestcaseNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		//String Assignee4=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		String manager=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		actual[77]=tl.individualAssinTo(TestcaseNo4, manager);
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

	@When("^select System Assign All to Anyone$")
	public void select_System_Assign_All_to_Anyone() throws Throwable 
	{
		try
		{
//		String system[]=new String[2];
//		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
//		system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 2);
//		actual[76]=tl.navigateToCycle(system);
		
		String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
		actual[78]=tl.navigateToCycle(phase);
		
		//String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
		tl.navigateToCycle(phase);
		
		String system[]=new String[1];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 2);
		actual[79]=tl.navigateToCycle(system);
		bp.waitForElement();	
		tl.selectallTestCase();
	    bp.waitForElement();
	    String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
	    actual[80]=tl.assignAllSelected(Assignee);
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

	@When("^Select subsystem/bulk assign/assign all Unassigned/assign to lead/Seletect subfolder$")
	public void select_subsystem_bulk_assign_assign_all_Unassigned_assign_to_lead_Seletect_subfolder() throws Throwable 
	{
		try
		{
//		String subsystem[]=new String[3];
//		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
//		subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 2);
//		subsystem[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 4);
//		actual[78]=tl.navigateToCycle(subsystem);
			
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
			actual[81]=tl.navigateToCycle(phase);
			
			//String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
			tl.navigateToCycle(phase);
			
			String system[]=new String[1];
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 2);
			actual[82]=tl.navigateToCycle(system);
		    bp.waitForElement();
				
			String subsystem[]=new String[1];
			subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 4);
			actual[83]=tl.navigateToCycle(subsystem);
				
		    bp.waitForElement();
		    actual[84]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
		    actual[85]=tl.assignAllUnassigned(lead, Check);
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

	@Then("^only testcases at subsystem should be assigned to TestLead$")
	public void only_testcases_at_subsystem_should_be_assigned_to_TestLead() throws Throwable 
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
