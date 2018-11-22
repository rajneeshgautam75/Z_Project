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

public class Assign_868140 extends LaunchBrowser
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
	boolean[] actual=new boolean[102];
	 SoftAssert soft=new SoftAssert();
	 String filename="Assign_868140";
	@Given("^user in repository page to create p/s/ss$")
	public void user_in_repository_page_to_create_p_s_ss() throws Throwable 
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

	@Given("^create p/s/ss add testcases and clone$")
	public void create_p_s_ss_add_testcases_and_clone() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			
			String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			actual[5]=tr.doubleClickOnRelease(releaseName);
			
			//navigate to phase//
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 0);
			actual[6]=tr.navigateToNode(releaseName, phase);
			 bp.waitForElement();
			actual[7]=tr.addTestCase();
			 ctc=new CreateTestCasePage(driver);
			   String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 20, 0);
			   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 20, 1);
			   tr.clickOnDetails();
			   actual[8]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
			   bp.waitForElement();
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
		
			   actual[13]=tr.doubleClickOnRelease(releaseName);
				//navigate to phase/////////////////////////////////////////////////////////////////////
				phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 0);
				actual[14]=tr.navigateToNode(releaseName, phase);
				bp.waitForElement();
				String systemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 2);
				String systemDesc1=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 3);
				actual[15]=tr.addNode(systemName, systemDesc1);
				
				//navigate to system
				actual[16]=tr.doubleClickOnRelease(releaseName);
				String system[]=new String[2];
				system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 0);
				system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 2);
				actual[17]=tr.navigateToNode(releaseName, system);
				
				actual[18]=tr.addTestCase();
				 String testCaseName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 20, 2);
				   String testCaseDesc1=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 20, 3);
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
				   navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 0);
				   navigation[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 2);
				   actual[24]=tr.navigateToNode(releaseName, navigation);
				   bp.waitForElement();
					String subsystemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 4);
					String subsystemDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 5);
					actual[25]=tr.addNode(subsystemName, subsystemDesc);
					
					actual[26]=tr.doubleClickOnRelease(releaseName);
					String subsystem[]=new String[3];
					subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 0);
					subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 2);
					subsystem[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 4);
					actual[27]=tr.navigateToNode(releaseName, subsystem);
					bp.waitForElement();
					
					actual[28]=tr.addTestCase();
					 String testCaseName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 20, 4);
					   String testCaseDesc2=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 20, 5);
					   tr.clickOnDetails();
					   actual[29]=ctc.enterTestCaseNameAndDesc(testCaseName2, testCaseDesc2);
					   bp.waitForElement();
					   tr.clickOnList();
					   bp.waitForElement();
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

	@When("^launch test planning create Cycle and Add phase to cycle$")
	public void launch_test_planning_create_Cycle_and_Add_phase_to_cycle() throws Throwable 
	{
		try
		{
		actual[34]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		 tl=new TestPlanningPage(driver);
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 15, 0);
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
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 15, 0);
			actual[39]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 0);
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

	@When("^navigate phase assign select all testcases assign to anyone$")
	public void navigate_phase_assign_select_all_testcases_assign_to_anyone() throws Throwable 
	{
		try
		{
		String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 0);
		actual[42]=tl.navigateToCycle(phase);
		bp.waitForElement();
		
		actual[43]=tl.selectallTestCase();
		bp.waitForElement();
		
		String Anyone=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		actual[44]=tl.assignAllSelected(Anyone);
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

	@When("^navigate to system and subsystem select all testcases assign to manager$")
	public void navigate_to_system_and_subsystem_select_all_testcases_assign_to_manager() throws Throwable 
	{
		try
		{
		String system[]=new String[1];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 2);
		actual[45]=tl.navigateToCycle(system);
		bp.waitForElement();
		
		actual[46]=tl.selectallTestCase();
		bp.waitForElement();
		
		String manager=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User1");
		actual[47]=tl.assignAllSelected(manager);
		
		String subsystem[]=new String[1];
		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 2);
		actual[48]=tl.navigateToCycle(subsystem);
		bp.waitForElement();
		
		actual[49]=tl.selectallTestCase();
		bp.waitForElement();
		
		actual[50]=tl.assignAllSelected(manager);
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

	@When("^Navigate to p/s/ss bulkassinment select assign all unassigned but not-executed assign to Anyone$")
	public void navigate_to_p_s_ss_bulkassinment_select_assign_all_unassigned_but_not_executed_assign_to_Anyone() throws Throwable 
	{
		try
		{
		String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 0);
		actual[51]=tl.navigateToCycle(phase);
		bp.waitForElement();
		tl.bulkAssignTestcasesSelectedFolder();
		bp.waitForElement();
		String Anyone=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		String testerone=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		String check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
		actual[52]=tl.assignAllAssignedNotExecuted(Anyone, testerone, check);
		bp.waitForElement();
		tl.navigateToCycle(phase);
		String system[]=new String[1];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 2);
		actual[53]=tl.navigateToCycle(system);
		bp.waitForElement();
		tl.bulkAssignTestcasesSelectedFolder();
		bp.waitForElement();
		actual[54]=tl.assignAllAssignedNotExecuted(Anyone, testerone, check);
		bp.waitForElement();
		String subsystem[]=new String[1];
		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 4);
		actual[55]=tl.navigateToCycle(subsystem);
		bp.waitForElement();
		tl.bulkAssignTestcasesSelectedFolder();
		bp.waitForElement();
		actual[56]=tl.assignAllAssignedNotExecuted(Anyone, testerone, check);
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

	@When("^launch test plannig navigate to cycle add phase choose existing phase and save$")
	public void launch_test_plannig_navigate_to_cycle_add_phase_choose_existing_phase_and_save() throws Throwable 
	{
		try
		{
		actual[57]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		
		  String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 15, 0);
			actual[58]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 0);
			actual[59]=tl.addPhaseToCycle(phase);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[60]=tl.bulkAssignment(Bulk_type);
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

	@When("^navigate phase Assign select all Testcases assign to Anyone$")
	public void navigate_phase_Assign_select_all_Testcases_assign_to_Anyone() throws Throwable 
	{
		try
		{
		String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 0);
		actual[61]=tl.navigateToCycle(phase);
		bp.waitForElement();
		
		actual[62]=tl.selectallTestCase();
		bp.waitForElement();
		
		String Anyone=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		actual[63]=tl.assignAllSelected(Anyone);
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

	@When("^navigate to system and Subsystem select all testcases Assign to TesterOne$")
	public void navigate_to_system_and_Subsystem_select_all_testcases_Assign_to_TesterOne() throws Throwable 
	{
		try
		{
		String system[]=new String[1];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 2);
		actual[64]=tl.navigateToCycle(system);
		bp.waitForElement();
		
		actual[65]=tl.selectallTestCase();
		bp.waitForElement();
		
		String testerone=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		actual[66]=tl.assignAllSelected(testerone);
		
		String subsystem[]=new String[1];
		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 4);
		actual[67]=tl.navigateToCycle(subsystem);
		bp.waitForElement();
		
		actual[68]=tl.selectallTestCase();
		bp.waitForElement();
		
		actual[69]=tl.assignAllSelected(testerone);
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

	@When("^Navigate to phase bulkassinment select assign all unassigned but not-executed assign to Anyone$")
	public void navigate_to_phase_bulkassinment_select_assign_all_unassigned_but_not_executed_assign_to_Anyone() throws Throwable 
	{
		try
		{
		String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 0);
		actual[70]=tl.navigateToCycle(phase);
		bp.waitForElement();
		tl.bulkAssignTestcasesSelectedFolder();
		bp.waitForElement();
		String Anyone=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		String testerone=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		String check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
		actual[71]=tl.assignAllAssignedNotExecuted(Anyone, testerone, check);
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

	@When("^launch test Plannig navigate to Cycle add phase choose existing phase and save$")
	public void launch_test_Plannig_navigate_to_Cycle_add_phase_choose_existing_phase_and_save() throws Throwable 
	{
		try
		{
		actual[72]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		
		  String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 15, 0);
			actual[73]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 0);
			actual[74]=tl.addPhaseToCycle(phase);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[75]=tl.bulkAssignment(Bulk_type);
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

	@When("^navigate phase Assign select all Testcases assign to anyone$")
	public void navigate_phase_Assign_select_all_Testcases_assign_to_anyone() throws Throwable 
	{
		try
		{
		String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 0);
		actual[76]=tl.navigateToCycle(phase);
		bp.waitForElement();
		
		actual[77]=tl.selectallTestCase();
		bp.waitForElement();
		
		String Anyone=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		actual[78]=tl.assignAllSelected(Anyone);
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

	@When("^navigate to system and Tubsystem select all Testcases Assign To manager$")
	public void navigate_to_system_and_Tubsystem_select_all_Testcases_Assign_To_manager() throws Throwable 
	{
		try
		{
		String system[]=new String[1];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 2);
		actual[79]=tl.navigateToCycle(system);
		bp.waitForElement();
		
		actual[80]=tl.selectallTestCase();
		bp.waitForElement();
		
		String manager=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User1");
		actual[81]=tl.assignAllSelected(manager);
		bp.waitForElement();
		String subsystem[]=new String[1];
		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 4);
		actual[82]=tl.navigateToCycle(subsystem);
		bp.waitForElement();
		
		actual[83]=tl.selectallTestCase();
		bp.waitForElement();
		
		actual[84]=tl.assignAllSelected(manager);
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

	@When("^Navigate to system bulkassinment select assign all unassigned but not-executed assign to Anyone$")
	public void navigate_to_system_bulkassinment_select_assign_all_unassigned_but_not_executed_assign_to_Anyone() throws Throwable 
	{
		try
		{
		String system[]=new String[1];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 0);
		actual[85]=tl.navigateToCycle(system);
		bp.waitForElement();
		tl.bulkAssignTestcasesSelectedFolder();
		bp.waitForElement();
		String Anyone=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		String testerone=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		String check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
		actual[86]=tl.assignAllAssignedNotExecuted(Anyone, testerone, check);
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

	@When("^launch test Plannig navigate To Cycle Add phase Choose existing phase and save$")
	public void launch_test_Plannig_navigate_To_Cycle_Add_phase_Choose_existing_phase_and_save() throws Throwable 
	{
		try
		{
		actual[87]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		
		  String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 15, 0);
			actual[88]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 0);
			actual[89]=tl.addPhaseToCycle(phase);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[90]=tl.bulkAssignment(Bulk_type);
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

	@When("^navigate phase Assign select All Testcases Assign to AnyOne$")
	public void navigate_phase_Assign_select_All_Testcases_Assign_to_AnyOne() throws Throwable 
	{
		try
		{
		String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 0);
		actual[91]=tl.navigateToCycle(phase);
		bp.waitForElement();
		
		actual[92]=tl.selectallTestCase();
		bp.waitForElement();
		
		String Anyone=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		actual[93]=tl.assignAllSelected(Anyone);
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

	@When("^navigate to system and Subsystem Select all testcases Assign To TesterOne$")
	public void navigate_to_system_and_Subsystem_Select_all_testcases_Assign_To_TesterOne() throws Throwable 
	{
		try
		{
		String system[]=new String[1];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 2);
		actual[94]=tl.navigateToCycle(system);
		bp.waitForElement();
		
		actual[95]=tl.selectallTestCase();
		bp.waitForElement();
		
		String manager=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		actual[96]=tl.assignAllSelected(manager);
		bp.waitForElement();
		String subsystem[]=new String[1];
		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 2);
		actual[97]=tl.navigateToCycle(subsystem);
		bp.waitForElement();
		
		actual[98]=tl.selectallTestCase();
		bp.waitForElement();
		
		actual[99]=tl.assignAllSelected(manager);
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

	@When("^Navigate to subsystem bulkassinment select assign all unassigned but not-executed assign to Anyone$")
	public void navigate_to_subsystem_bulkassinment_select_assign_all_unassigned_but_not_executed_assign_to_Anyone() throws Throwable 
	{
		try
		{
		String subsystem[]=new String[1];
		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 25, 0);
		actual[100]=tl.navigateToCycle(subsystem);
		bp.waitForElement();
		tl.bulkAssignTestcasesSelectedFolder();
		bp.waitForElement();
		String Anyone=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		String testerone=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		String check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
		actual[101]=tl.assignAllAssignedNotExecuted(Anyone, testerone, check);
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

	@Then("^Should assign only assigned and not executed testcases at all levels from 'Anyone' user pool to a Specific tester$")
	public void should_assign_only_assigned_and_not_executed_testcases_at_all_levels_from_Anyone_user_pool_to_a_Specific_tester() throws Throwable 
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
