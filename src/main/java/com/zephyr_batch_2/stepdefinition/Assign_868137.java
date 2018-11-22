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

public class Assign_868137 extends LaunchBrowser
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
	boolean[] actual=new boolean[72];
	 SoftAssert soft=new SoftAssert();
	 String filename="Assign_868137";
	@Given("^User in Repository page to create P/S/SS$")
	public void user_in_Repository_page_to_create_P_S_SS() throws Throwable 
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

	@Given("^create P/S/SS and add testcase and clone$")
	public void create_P_S_SS_and_add_testcase_and_clone() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			
			String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			actual[5]=tr.doubleClickOnRelease(releaseName);
			
			//navigate to phase//
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 0);
			actual[6]=tr.navigateToNode(releaseName, phase);
			
			actual[7]=tr.addTestCase();
			 ctc=new CreateTestCasePage(driver);
			   String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 18, 0);
			   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 18, 1);
			   tr.clickOnDetails();
			   actual[8]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
			   bp.waitForElement();
			   tr.clickOnList();
			   actual[9]=tr.selectallTestCase();
			   bp.waitForElement();
			   actual[10]=tr.cloneTestCase();
			   bp.waitForElement();
			   actual[11]=tr.selectallTestCase();
			   bp.waitForElement();
			   actual[12]=tr.cloneTestCase();
			   bp.waitForElement();
			  // String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			   
			   actual[13]=tr.doubleClickOnRelease(releaseName);
				//navigate to phase/////////////////////////////////////////////////////////////////////
				phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 0);
				actual[14]=tr.navigateToNode(releaseName, phase);
				bp.waitForElement();
				String systemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 2);
				String systemDesc1=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 3);
				actual[15]=tr.addNode(systemName, systemDesc1);
				
				//navigate to system
				actual[16]=tr.doubleClickOnRelease(releaseName);
				String system[]=new String[2];
				system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 0);
				system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 2);
				actual[17]=tr.navigateToNode(releaseName, system);
				
				actual[18]=tr.addTestCase();
				 String testCaseName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 18, 2);
				   String testCaseDesc1=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 18, 3);
				   tr.clickOnDetails();
				   actual[19]=ctc.enterTestCaseNameAndDesc(testCaseName1, testCaseDesc1);
				   bp.waitForElement();
				   tr.clickOnList();
				   tr.selectallTestCase();
				   bp.waitForElement();
				   actual[20]=tr.cloneTestCase();
				   bp.waitForElement();
				   actual[21]=tr.selectallTestCase();
				   bp.waitForElement();
				   actual[22]=tr.cloneTestCase();
				   bp.waitForElement();
				   
				   actual[23]=tr.doubleClickOnRelease(releaseName);
				   String[] navigation=new String[2];
				   //navigate to system/////////////////////////////////////////////////////////////////////
				   navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 0);
				   navigation[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 2);
				   actual[24]=tr.navigateToNode(releaseName, navigation);
				   bp.waitForElement();
					String subsystemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 4);
					String subsystemDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 5);
					actual[25]=tr.addNode(subsystemName, subsystemDesc);
					
					actual[26]=tr.doubleClickOnRelease(releaseName);
					String subsystem[]=new String[3];
					subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 0);
					subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 2);
					subsystem[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 4);
					actual[27]=tr.navigateToNode(releaseName, subsystem);
					bp.waitForElement();
					
					actual[28]=tr.addTestCase();
					 String testCaseName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 18, 4);
					   String testCaseDesc2=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 18, 5);
					   tr.clickOnDetails();
					   actual[29]=ctc.enterTestCaseNameAndDesc(testCaseName2, testCaseDesc2);
					   bp.waitForElement();
					   tr.clickOnList();
					   actual[30]=tr.selectallTestCase();
					   bp.waitForElement();
					   actual[31]=tr.cloneTestCase();
					   bp.waitForElement();
					   actual[32]=tr.selectallTestCase();
					   bp.waitForElement();
					   actual[33]=tr.cloneTestCase();
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

	@When("^launch testplanning and create cycle and add phase to cycle$")
	public void launch_testplanning_and_create_cycle_and_add_phase_to_cycle() throws Throwable 
	{
		try
		{
		actual[34]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		 tl=new TestPlanningPage(driver);
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 13, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 13, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 13, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 110);
			actual[35]=tl.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[36]=tl.CreateCycle(cyclename, Build, Environment,hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
			actual[37]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[38]=tl.saveTestCycle();
			bp.waitForElement();
		   String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 13, 0);
			actual[39]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 0);
			actual[40]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[41]=tl.bulkAssignment(Bulk_type);
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

	@When("^Navigate to phase select bulkassignment assign to Anyone$")
	public void navigate_to_phase_select_bulkassignment_assign_to_Anyone() throws Throwable 
	{
		try
		{
		String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 0);
		actual[42]=tl.navigateToCycle(phase);
		
		  actual[43]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    actual[44]=tl.assignAllNotexecuted(assignee, Check);
		    bp.waitForElement();
		    
		    int testcaNo[]=new int[4];
		    testcaNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		    testcaNo[1]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		    testcaNo[2]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		    testcaNo[3]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		    tl.validateAllAssigned(testcaNo, assignee);
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

	@When("^Navigate to system select bulkassignment assign to Anyone$")
	public void navigate_to_system_select_bulkassignment_assign_to_Anyone() throws Throwable 
	{
		try
		{
		String system[]=new String[1];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 2);
		actual[45]=tl.navigateToCycle(system);
		
		  actual[46]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    actual[47]=tl.assignAllNotexecuted(assignee, Check);
		    bp.waitForElement();
		    
		    int testcaNo[]=new int[4];
		    testcaNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		    testcaNo[1]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		    testcaNo[2]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		    testcaNo[3]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		    tl.validateAllAssigned(testcaNo, assignee);
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

	@When("^Navigate to subsystem select bulkassignment Assign to Anyone$")
	public void navigate_to_subsystem_select_bulkassignment_Assign_to_Anyone() throws Throwable 
	{
		try
		{
		String subsystem[]=new String[1];
		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 4);
		actual[48]=tl.navigateToCycle(subsystem);
		
		  actual[49]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    actual[50]=tl.assignAllNotexecuted(assignee, Check);
		    bp.waitForElement();
		    
		    int testcaNo[]=new int[4];
		    testcaNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		    testcaNo[1]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		    testcaNo[2]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		    testcaNo[3]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		    tl.validateAllAssigned(testcaNo, assignee);
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

	@When("^launch testplanning Add Existing phase to cycle$")
	public void launch_testplanning_Add_Existing_phase_to_cycle() throws Throwable 
	{
		try
		{
		actual[51]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		
		  String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 13, 0);
			actual[52]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 0);
			actual[53]=tl.addPhaseToCycle(phase);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[54]=tl.bulkAssignment(Bulk_type);
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

	@When("^Navigate to Phase select bulkassignment Assign to Anyone$")
	public void navigate_to_Phase_select_bulkassignment_Assign_to_Anyone() throws Throwable 
	{
		try
		{
		String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 0);
		actual[55]=tl.navigateToCycle(phase);
		
		  actual[56]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    actual[57]=tl.assignAllNotexecuted(assignee, Check);
		    bp.waitForElement();
		    
		    int testcaNo[]=new int[4];
		    testcaNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		    testcaNo[1]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		    testcaNo[2]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		    testcaNo[3]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		    tl.validateAllAssigned(testcaNo, assignee);
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

	@When("^launch Testplanning add Existing phase to cycle$")
	public void launch_Testplanning_add_Existing_phase_to_cycle() throws Throwable 
	{
		try
		{
		actual[58]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		
		  String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 13, 0);
			actual[59]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 0);
			actual[60]=tl.addPhaseToCycle(phase);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[61]=tl.bulkAssignment(Bulk_type);
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

	@When("^Navigate to system select Bulkassignment assign to Anyone$")
	public void navigate_to_system_select_Bulkassignment_assign_to_Anyone() throws Throwable 
	{
		try
		{
		String system[]=new String[2];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 0);
		system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 2);
		actual[62]=tl.navigateToCycle(system);
		
		  actual[63]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    actual[64]=tl.assignAllNotexecuted(assignee, Check);
		    bp.waitForElement();
		    
		    int testcaNo[]=new int[4];
		    testcaNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		    testcaNo[1]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		    testcaNo[2]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		    testcaNo[3]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		    tl.validateAllAssigned(testcaNo, assignee);
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

	@When("^launch testplanning add Existing phase to cycle$")
	public void launch_testplanning_add_Existing_phase_to_cycle() throws Throwable 
	{
		try
		{
		actual[65]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		
		  String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 13, 0);
			actual[66]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 0);
			actual[67]=tl.addPhaseToCycle(phase);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[68]=tl.bulkAssignment(Bulk_type);
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

	@When("^Navigate to subsystem select Bulkassignment assign to Anyone$")
	public void navigate_to_subsystem_select_Bulkassignment_assign_to_Anyone() throws Throwable 
	{
		try
		{
		String subsystem[]=new String[3];
		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 0);
		subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 2);
		subsystem[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 23, 4);
		actual[69]=tl.navigateToCycle(subsystem);
		
		  actual[70]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    actual[71]=tl.assignAllNotexecuted(assignee, Check);
		    bp.waitForElement();
		    
		    int testcaNo[]=new int[4];
		    testcaNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		    testcaNo[1]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		    testcaNo[2]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		    testcaNo[3]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		    tl.validateAllAssigned(testcaNo, assignee);
		    
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

	@Then("^Should Assign all 'Not Executed' testcases at sub-folders to 'Anyone' user$")
	public void should_Assign_all_Not_Executed_testcases_at_sub_folders_to_Anyone_user() throws Throwable 
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
