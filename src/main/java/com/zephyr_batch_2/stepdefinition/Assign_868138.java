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

public class Assign_868138 extends LaunchBrowser
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
	 String filename="Assign_868138";
	@Given("^To create P/S/SS user in repository page$")
	public void to_create_P_S_SS_user_in_repository_page() throws Throwable 
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

	@Given("^create P/S/SS add testcases and clone the testcases$")
	public void create_P_S_SS_add_testcases_and_clone_the_testcases() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			
			String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			actual[5]=tr.doubleClickOnRelease(releaseName);
			
			//navigate to phase//
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 0);
			actual[6]=tr.navigateToNode(releaseName, phase);
			 bp.waitForElement();
			actual[7]=tr.addTestCase();
			 ctc=new CreateTestCasePage(driver);
			   String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 19, 0);
			   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 19, 1);
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
				phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 0);
				actual[14]=tr.navigateToNode(releaseName, phase);
				bp.waitForElement();
				String systemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 2);
				String systemDesc1=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 3);
				actual[15]=tr.addNode(systemName, systemDesc1);
				
				//navigate to system
				actual[16]=tr.doubleClickOnRelease(releaseName);
				String system[]=new String[2];
				system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 0);
				system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 2);
				actual[17]=tr.navigateToNode(releaseName, system);
				
				actual[18]=tr.addTestCase();
				 String testCaseName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 19, 2);
				   String testCaseDesc1=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 19, 3);
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
				   navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 0);
				   navigation[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 2);
				   actual[24]=tr.navigateToNode(releaseName, navigation);
				   bp.waitForElement();
					String subsystemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 4);
					String subsystemDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 5);
					actual[25]=tr.addNode(subsystemName, subsystemDesc);
					bp.waitForElement();
					actual[26]=tr.doubleClickOnRelease(releaseName);
					String subsystem[]=new String[3];
					subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 0);
					subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 2);
					subsystem[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 4);
					actual[27]=tr.navigateToNode(releaseName, subsystem);
					bp.waitForElement();
					
					actual[28]=tr.addTestCase();
					 String testCaseName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 19, 4);
					   String testCaseDesc2=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 19, 5);
					   tr.clickOnDetails();
					   actual[29]=ctc.enterTestCaseNameAndDesc(testCaseName2, testCaseDesc2);
					   bp.waitForElement();
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

	@When("^launch testplanning create cycle and ad phase to cycle$")
	public void launch_testplanning_create_cycle_and_ad_phase_to_cycle() throws Throwable 
	{
		try
		{
		actual[34]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		 tl=new TestPlanningPage(driver);
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 14, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 14, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 14, 2);
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
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 14, 0);
			actual[39]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 0);
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

	@When("^navigate to phase select bulkassign UnAssigned to Anyone$")
	public void navigate_to_phase_select_bulkassign_UnAssigned_to_Anyone() throws Throwable 
	{
		try
		{
		String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 0);
		actual[42]=tl.navigateToCycle(phase);
		
		  actual[43]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    actual[44]=tl.assignAllUnassigned(assignee, Check);
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

	@When("^navigate to system select bulkassign UnAssigned to Anyone$")
	public void navigate_to_system_select_bulkassign_UnAssigned_to_Anyone() throws Throwable 
	{
		try
		{
		String system[]=new String[1];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 2);
		actual[45]=tl.navigateToCycle(system);
		bp.waitForElement();
		  actual[46]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    actual[47]=tl.assignAllUnassigned(assignee, Check);
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

	@When("^navigate to subsystem select bulkassign UnAssigned to Anyone$")
	public void navigate_to_subsystem_select_bulkassign_UnAssigned_to_Anyone() throws Throwable 
	{
		try
		{
		String subsystem[]=new String[1];
		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 4);
		actual[48]=tl.navigateToCycle(subsystem);
		
		  actual[49]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    actual[50]=tl.assignAllUnassigned(assignee, Check);
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

	@When("^launch Testplanning Add phase to cycle$")
	public void launch_Testplanning_Add_phase_to_cycle() throws Throwable 
	{
		try
		{
		actual[51]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		
		  String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 14, 0);
			actual[52]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 0);
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

	@When("^navigate to Phase select bulkassign UnAssigned to Anyone$")
	public void navigate_to_Phase_select_bulkassign_UnAssigned_to_Anyone() throws Throwable 
	{
		try
		{
		String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 0);
		actual[55]=tl.navigateToCycle(phase);
		
		  actual[56]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    actual[57]=tl.assignAllUnassigned(assignee, Check);
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

	@When("^Launch testplanning Add phase to cycle$")
	public void launch_testplanning_Add_phase_to_cycle() throws Throwable 
	{
		try
		{
		actual[58]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		
		  String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 14, 0);
			actual[59]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 0);
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

	@When("^navigate to system Select bulkassign UnAssigned to Anyone$")
	public void navigate_to_system_Select_bulkassign_UnAssigned_to_Anyone() throws Throwable 
	{
		try
		{
		String system[]=new String[2];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 0);
		system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 2);
		actual[62]=tl.navigateToCycle(system);
		
		  actual[63]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    actual[64]=tl.assignAllUnassigned(assignee, Check);
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

	@When("^launch testplanning Add phase To cycle$")
	public void launch_testplanning_Add_phase_To_cycle() throws Throwable 
	{
		try
		{
		actual[65]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		
		  String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 14, 0);
			actual[66]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 0);
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

	@When("^navigate to subsystem select Bulkassign UnAssigned to Anyone$")
	public void navigate_to_subsystem_select_Bulkassign_UnAssigned_to_Anyone() throws Throwable 
	{
		try
		{
		String subsystem[]=new String[3];
		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 0);
		subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 2);
		subsystem[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 24, 4);
		actual[69]=tl.navigateToCycle(subsystem);
		
		  actual[70]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    actual[71]=tl.assignAllUnassigned(assignee, Check);
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

	@Then("^Should assign only Unassigned testcases in Phase node including sub-folders$")
	public void should_assign_only_Unassigned_testcases_in_Phase_node_including_sub_folders() throws Throwable 
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
