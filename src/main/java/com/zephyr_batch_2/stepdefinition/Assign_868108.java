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

public class Assign_868108 extends LaunchBrowser
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
	 String filename="Assign_868108";
	@Given("^user in repository page to create P/S/SS add testcases$")
	public void user_in_repository_page_to_create_P_S_SS_add_testcases() throws Throwable 
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

	@Given("^create P/S/SS and add test cases and clone$")
	public void create_P_S_SS_and_add_test_cases_and_clone() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 14, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 14, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			actual[5]=tr.doubleClickOnRelease(releaseName);
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 14, 0);
			actual[6]=tr.navigateToNode(releaseName, phase);
			actual[7]=tr.addTestCase();
			 ctc=new CreateTestCasePage(driver);
			   String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 9, 0);
			   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 9, 1);
			   tr.clickOnDetails();
			   actual[8]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
			   bp.waitForElement();
			   tr.clickOnList();
			   bp.waitForElement();
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
//				String[] phase=new String[1];
//				//navigate to phase/////////////////////////////////////////////////////////////////////
//				phase[0]=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 14, 0);
			   actual[14]=tr.navigateToNode(releaseName, phase);
				bp.waitForElement();
				String systemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 14, 2);
				String systemDesc1=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 14, 3);
				actual[15]=tr.addNode(systemName, systemDesc1);
				
				actual[16]=tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
				String system[]=new String[2];
				system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 14, 0);
				system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 14, 2);
				actual[17]=tr.navigateToNode(releaseName, system);
				actual[18]=tr.addTestCase();
				 String testCaseName1=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 9, 2);
				   String testCaseDesc1=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 9, 3);
				   tr.clickOnDetails();
				   actual[19]=ctc.enterTestCaseNameAndDesc(testCaseName1, testCaseDesc1);
				   tr.clickOnList();
				   bp.waitForElement();
				   actual[20]=tr.selectallTestCase();
				   bp.waitForElement();
				   actual[21]=tr.cloneTestCase();
				   bp.waitForElement();
				   actual[22]=tr.selectallTestCase();
				   bp.waitForElement();
				   actual[23]=tr.cloneTestCase();
				   bp.waitForElement();
				   
				   actual[24]=tr.doubleClickOnRelease(releaseName);
				   String[] navigation=new String[2];
				   //navigate to system/////////////////////////////////////////////////////////////////////
				   navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 14, 0);
				   navigation[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 14, 2);
				   actual[25]=tr.navigateToNode(releaseName, navigation);
				   bp.waitForElement();
					String subsystemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 14, 4);
					String subsystemDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 14, 5);
					actual[26]=tr.addNode(subsystemName, subsystemDesc);
					
					actual[27]=tr.doubleClickOnRelease(releaseName);
					bp.waitForElement();
					String subsystem[]=new String[3];
					subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 14, 0);
					subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 14, 2);
					subsystem[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 14, 4);
					actual[28]=tr.navigateToNode(releaseName, system);
					
					actual[29]=tr.addTestCase();
					 String testCaseName2=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 9, 4);
					   String testCaseDesc2=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 9, 5);
					   tr.clickOnDetails();
					   actual[30]=ctc.enterTestCaseNameAndDesc(testCaseName2, testCaseDesc2);
					   bp.waitForElement();
					   tr.clickOnList();
					   actual[31]=tr.selectallTestCase();
					   bp.waitForElement();
					   actual[32]=tr.cloneTestCase();
					   bp.waitForElement();
					   actual[33]=tr.selectallTestCase();
					   bp.waitForElement();
					   actual[34]=tr.cloneTestCase();
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

	@When("^launch testplanning create cycle and add phase to cycle$")
	public void launch_testplanning_create_cycle_and_add_phase_to_cycle() throws Throwable 
	{
		try
		{
		actual[35]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		 tl=new TestPlanningPage(driver);
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 7, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 7, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 7, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
			actual[36]=tl.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[37]=tl.CreateCycle(cyclename, Build, Environment,hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
			actual[38]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[39]=tl.saveTestCycle();
			bp.waitForElement();
		   String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 7, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 14, 0);
			actual[41]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[42]=tl.bulkAssignment(Bulk_type);
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

	@When("^Select phase/bulk assign/assign all Unassigned/assign to lead/Donot seletect subfolder$")
	public void select_phase_bulk_assign_assign_all_Unassigned_assign_to_lead_Donot_seletect_subfolder() throws Throwable 
	{
		try
		{
		String[] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 14, 0);
		actual[43]=tl.navigateToCycle(phase);
		bp.waitForElement();
		actual[44]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		   // String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    actual[45]=tl.assignAllUnassigned(lead, Check);
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

	@When("^Select system/bulk assign/assign all Unassigned/assign to lead/Donot seletect subfolder$")
	public void select_system_bulk_assign_assign_all_Unassigned_assign_to_lead_Donot_seletect_subfolder() throws Throwable 
	{
		try
		{
//		String system[]=new String[2];
//		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 0);
//		system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 2);
//		actual[46]=tl.navigateToCycle(system);
//	    bp.waitForElement();
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 0);
			actual[46]=tl.navigateToCycle(phase);
			
			//String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 0);
			tl.navigateToCycle(phase);
			
			String system[]=new String[1];
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 2);
			actual[47]=tl.navigateToCycle(system);
		    bp.waitForElement();
				
		    actual[48]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		   // String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    actual[49]=tl.assignAllNotexecuted(lead, Check);
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

	@When("^Select subsystem/bulk assign/assign all Unassigned/assign to lead/Donot seletect subfolder$")
	public void select_subsystem_bulk_assign_assign_all_Unassigned_assign_to_lead_Donot_seletect_subfolder() throws Throwable 
	{
		try
		{
//		String subsystem[]=new String[3];
//		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 0);
//		subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 2);
//		subsystem[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 4);
//		actual[49]=tl.navigateToCycle(subsystem);
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 0);
			actual[50]=tl.navigateToCycle(phase);
			
			//String phase[]=new String[1];
			//phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 0);
			tl.navigateToCycle(phase);
			
			String system[]=new String[1];
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 2);
			actual[51]=tl.navigateToCycle(system);
		    bp.waitForElement();
				
			String subsystem[]=new String[1];
			subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 4);
			actual[52]=tl.navigateToCycle(subsystem);
				
		    bp.waitForElement();
		    actual[53]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		   // String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    actual[54]=tl.assignAllNotexecuted(lead, Check);
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

	@When("^Launch test planning and choose existing phase and save$")
	public void launch_test_planning_and_choose_existing_phase_and_save() throws Throwable 
	{
		try
		{
		actual[55]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		 String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 7, 0);
			actual[56]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 14, 0);
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

	@When("^Select phase/bulk assign/assign all Unassigned/assign to lead/seletect subfolder$")
	public void select_phase_bulk_assign_assign_all_Unassigned_assign_to_lead_seletect_subfolder() throws Throwable 
	{
		try
		{
		String[] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 0);
		actual[59]=tl.navigateToCycle(phase);
		bp.waitForElement();
		actual[60]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		   // String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
		    actual[61]=tl.assignAllNotexecuted(lead, Check);
		    bp.waitForElement();
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

	@When("^Launch test Planning and Choose existing phase and save$")
	public void launch_test_Planning_and_Choose_existing_phase_and_save() throws Throwable 
	{
		try
		{
		rp.clickOnTestPlanning();
		 bp.waitForElement();
		 String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 7, 0);
			tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 14, 0);
			tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[62]=tl.bulkAssignment(Bulk_type);
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

	@When("^Select system/bulk Assign/assign all Unassigned/assign to lead/seletect subfolder$")
	public void select_system_bulk_Assign_assign_all_Unassigned_assign_to_lead_seletect_subfolder() throws Throwable 
	{
		try
		{
//		String system[]=new String[2];
//		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 0);
//		system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 2);
//		actual[63]=tl.navigateToCycle(system);
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 0);
			actual[63]=tl.navigateToCycle(phase);
			bp.waitForElement();
			//String phase[]=new String[1];
			//phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 0);
			//tl.navigateToCycle(phase);
			bp.waitForElement();
			String system[]=new String[1];
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 2);
			actual[64]=tl.navigateToCycle(system);
		    bp.waitForElement();
				
		    bp.waitForElement();
		    actual[65]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
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

	@When("^Select subsystem/bulk Assign/assign all Unassigned/assign to lead/seletect subfolder$")
	public void select_subsystem_bulk_Assign_assign_all_Unassigned_assign_to_lead_seletect_subfolder() throws Throwable 
	{
		try
		{
//		String subsystem[]=new String[3];
//		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 0);
//		subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 2);
//		subsystem[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 4);
//		actual[66]=tl.navigateToCycle(subsystem);
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 0);
			actual[67]=tl.navigateToCycle(phase);
			
			//String phase[]=new String[1];
			//phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 0);
			//tl.navigateToCycle(phase);
			
			String system[]=new String[1];
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 2);
			actual[68]=tl.navigateToCycle(system);
		    bp.waitForElement();
				
			String subsystem[]=new String[1];
			subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 14, 4);
			actual[69]=tl.navigateToCycle(subsystem);
				
		    bp.waitForElement();
		    actual[70]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
		    actual[71]=tl.assignAllNotexecuted(lead, Check);
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

	@Then("^All the nodes including child nodes testcases should be Assigned to test\\.lead$")
	public void all_the_nodes_including_child_nodes_testcases_should_be_Assigned_to_test_lead() throws Throwable 
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
