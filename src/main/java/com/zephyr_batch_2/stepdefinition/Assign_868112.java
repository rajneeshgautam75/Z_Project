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

public class Assign_868112 extends LaunchBrowser
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
	boolean[] actual=new boolean[67];
	 SoftAssert soft=new SoftAssert();
	 String filename="Assign_868112";
	@Given("^user in repository page To create P/S/SS$")
	public void user_in_repository_page_To_create_P_S_SS() throws Throwable 
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

	@Given("^create P/S/SS Add Testcases Edit and clone$")
	public void create_P_S_SS_Add_Testcases_Edit_and_clone() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 18, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 18, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			
			String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			actual[5]=tr.doubleClickOnRelease(releaseName);
			
			//navigate to phase//
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 18, 0);
			actual[6]=tr.navigateToNode(releaseName, phase);
			
			actual[7]=tr.addTestCase();
			 ctc=new CreateTestCasePage(driver);
			   String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 13, 0);
			   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 13, 1);
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
				phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 18, 0);
				actual[14]=tr.navigateToNode(releaseName, phase);
				bp.waitForElement();
				String systemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 18, 2);
				String systemDesc1=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 18, 3);
				actual[15]=tr.addNode(systemName, systemDesc1);
				
				//navigate to system
				actual[16]=tr.doubleClickOnRelease(releaseName);
				String system[]=new String[2];
				system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 18, 0);
				system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 18, 2);
				actual[17]=tr.navigateToNode(releaseName, system);
				
				actual[18]=tr.addTestCase();
				 String testCaseName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 13, 2);
				   String testCaseDesc1=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 13, 3);
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
				   navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 18, 0);
				   navigation[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 18, 2);
				   actual[24]=tr.navigateToNode(releaseName, navigation);
				   bp.waitForElement();
					String subsystemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 18, 4);
					String subsystemDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 18, 5);
					actual[25]=tr.addNode(subsystemName, subsystemDesc);
					
					actual[26]=tr.doubleClickOnRelease(releaseName);
					String subsystem[]=new String[3];
					subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 18, 0);
					subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 18, 2);
					subsystem[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 18, 4);
					actual[27]=tr.navigateToNode(releaseName, subsystem);
					bp.waitForElement();
					
					actual[28]=tr.addTestCase();
					 String testCaseName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 13, 4);
					   String testCaseDesc2=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 13, 5);
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

	@When("^Launch Testplanning Create cycle add phase and save$")
	public void launch_Testplanning_Create_cycle_add_phase_and_save() throws Throwable 
	{
		try
		{
		actual[34]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		 tl=new TestPlanningPage(driver);
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 11, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 11, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 11, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
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
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 11, 0);
			actual[39]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 18, 0);
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

	@When("^select system select few testcases assign to Testmanager$")
	public void select_system_select_few_testcases_assign_to_Testmanager() throws Throwable 
	{
		try
		{
			String system[]=new String[2];
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 18, 0);
			system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 18, 2);
			actual[42]=tl.navigateToCycle(system);
		    bp.waitForElement();
		    int tcNo[]=new int[2];
		    tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames", 1, 0);
		    tcNo[1]=Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames", 2, 0);
		    actual[43]=tl.selectSingleMultipleTestcase(tcNo);
		    bp.waitForElement();
		    String manager=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 3, 0);
		    actual[44]=tl.assignAllSelected(manager);
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

	@When("^Select syste/bulk assin/assign All notexcuted/assig To Lead/select subfolder$")
	public void select_syste_bulk_assin_assign_All_notexcuted_assig_To_Lead_select_subfolder() throws Throwable 
	{
		try
		{
			String system[]=new String[1];
			//system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 18, 0);///////////
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 18, 2);
			actual[45]=tl.navigateToCycle(system);
		    bp.waitForElement();
		    actual[46]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 10, 0);
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
		    String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    actual[47]=tl.assignAllNotexecuted(assignee, Check);
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

	@When("^Launch Testplanning Select Existing phase and save$")
	public void launch_Testplanning_Select_Existing_phase_and_save() throws Throwable 
	{
		try
		{
			actual[48]=rp.clickOnTestPlanning();
			 bp.waitForElement();
			 String cyclename1[]=new String[1];
				cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 11, 0);
				actual[49]=tl.navigateToCycle(cyclename1);
				bp.waitForElement();
				String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 18, 0);
				actual[50]=tl.addPhaseToCycle(nodeName);
			   bp.waitForElement();
			   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
			   actual[51]=tl.bulkAssignment(Bulk_type);
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

	@Then("^select P/S/SS asssign all testcases to TestManager$")
	public void select_P_S_SS_asssign_all_testcases_to_TestManager() throws Throwable 
	{
		try
		{
			String[] phase=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 18, 0);
			actual[52]=tl.navigateToCycle(phase);
			bp.waitForElement();
			actual[53]=tl.selectallTestCase();
			bp.waitForElement();
			String Assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User1");
			//String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 3, 0);
			actual[54]=tl.assignAllSelected(Assignee);
			
			String system[]=new String[1];
			//system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 18, 0);//
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 18, 2);
			actual[55]=tl.navigateToCycle(system);
		    bp.waitForElement();
		    actual[56]=tl.selectallTestCase();
		    bp.waitForElement();
		    String Assigneesystem=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 3, 0);
		    actual[57]=tl.assignAllSelected(Assigneesystem);
		    bp.waitForElement();
		    
		    String subsystem[]=new String[1];
		    //subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 18, 0);//////////
		   // subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 18, 2);/////////////
		    subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 18, 4);
			tl.navigateToCycle(subsystem);
		    bp.waitForElement();
		    actual[56]=tl.selectallTestCase();
		    bp.waitForElement();
		    String Assigneesubsystem=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 3, 0);
		    tl.assignAllSelected(Assigneesubsystem);
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

	@When("^Select Phase/bilk assign/assign All notexecuted/assign To Lead/donot seletect subfolder$")
	public void select_Phase_bilk_assign_assign_All_notexecuted_assign_To_Lead_donot_seletect_subfolder() throws Throwable 
	{
		try
		{
			String[] phase=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 18, 0);
			actual[58]=tl.navigateToCycle(phase);
			bp.waitForElement();
			actual[59]=tl.bulkAssignTestcasesSelectedFolder();
			    bp.waitForElement();
			    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 10, 0);
			    String Assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
			    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
			    actual[60]=tl.assignAllNotexecuted(Assignee, Check);
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

	@When("^Select system/bilk assign/assign All notexecuted/assign To manager/donot seletect subfolder$")
	public void select_system_bilk_assign_assign_All_notexecuted_assign_To_manager_donot_seletect_subfolder() throws Throwable 
	{
		try
		{
			String system[]=new String[2];
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 18, 0);
			system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 18, 2);
			actual[61]=tl.navigateToCycle(system);
		    bp.waitForElement();
		    actual[62]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 3, 0);
		    String Assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User1");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 100);
		    actual[63]=tl.assignAllNotexecuted(Assignee, Check);
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

	@When("^Select subsystem/bilk assign/assign All notexecuted/assign To Tester/donot seletect subfolder$")
	public void select_subsystem_bilk_assign_assign_All_notexecuted_assign_To_Tester_donot_seletect_subfolder() throws Throwable 
	{
		try
		{
			String subsystem[]=new String[1];
			//subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 18, 0);///////
			//subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 18, 2);///////////
			subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 18, 2);
			actual[64]=tl.navigateToCycle(subsystem);
		    bp.waitForElement();
		    actual[65]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		   // String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 4, 0);
		    String Assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 100);
		    actual[66]=tl.assignAllNotexecuted(Assignee, Check);
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

	@Then("^Assign testcases and view if total and/ Unassigned count display correctly on selected node include sub-folders$")
	public void assign_testcases_and_view_if_total_and_Unassigned_count_display_correctly_on_selected_node_include_sub_folders() throws Throwable 
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
