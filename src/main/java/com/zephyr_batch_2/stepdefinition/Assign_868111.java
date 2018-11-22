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

public class Assign_868111 extends LaunchBrowser
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
	boolean[] actual=new boolean[117];
	 SoftAssert soft=new SoftAssert();
	 String filename="Assign_868111";
	@Given("^user in repository page to create P/S/SS$")
	public void user_in_repository_page_to_create_P_S_SS() throws Throwable 
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

	@Given("^create p/s/ss add testcase and clone$")
	public void create_p_s_ss_add_testcase_and_clone() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 17, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 17, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			actual[5]=tr.doubleClickOnRelease(releaseName);
			
			//navigate to phase//
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 17, 0);
			actual[6]=tr.navigateToNode(releaseName, phase);
			
			tr.addTestCase();
			 ctc=new CreateTestCasePage(driver);
			   String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 12, 0);
			   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 12, 1);
			   tr.clickOnDetails();
			   ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
			   bp.waitForElement();
			   tr.clickOnList();
			   tr.selectallTestCase();
			   bp.waitForElement();
			   actual[6]=tr.cloneTestCase();
			   bp.waitForElement();
			   tr.selectallTestCase();
			   bp.waitForElement();
			   actual[7]=tr.cloneTestCase();
			   bp.waitForElement();
			   
			 //navigate to phase///////////////////
				tr.doubleClickOnRelease(releaseName);
				//phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 17, 0);
				bp.waitForElement();
				tr.navigateToNode(releaseName, phase);
				bp.waitForElement();
				String systemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 17, 2);
				String systemDesc1=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 17, 3);
				tr.addNode(systemName, systemDesc1);
				
				//navigate to system
				actual[16]=tr.doubleClickOnRelease(releaseName);
				String system[]=new String[2];
				system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 17, 0);
				system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 17, 2);
				actual[17]=tr.navigateToNode(releaseName, system);
				
				tr.addTestCase();
				 String testCaseName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 12, 2);
				   String testCaseDesc1=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 12, 3);
				   tr.clickOnDetails();
				   ctc.enterTestCaseNameAndDesc(testCaseName1, testCaseDesc1);
				   bp.waitForElement();
				   tr.clickOnList();
				   tr.selectallTestCase();
				   bp.waitForElement();
				   actual[6]=tr.cloneTestCase();
				   bp.waitForElement();
				   tr.selectallTestCase();
				   bp.waitForElement();
				   actual[7]=tr.cloneTestCase();
				   bp.waitForElement();
				   
				   //navigate to system/////////////////////////
				   actual[8]=tr.doubleClickOnRelease(releaseName);
//				   String[] system=new String[2];
//				   system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 17, 0);
//				   system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 17, 2);
				   actual[9]=tr.navigateToNode(releaseName, system);
				   bp.waitForElement();
					String subsystemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 17, 4);
					String subsystemDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 17, 5);
					actual[10]=tr.addNode(subsystemName, subsystemDesc);
					//navigate to subsystem
					actual[11]=tr.doubleClickOnRelease(releaseName);
					String subsystem[]=new String[3];
					subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 17, 0);
					subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 17, 2);
					subsystem[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 17, 4);
					actual[12]=tr.navigateToNode(releaseName, subsystem);
					bp.waitForElement();
					actual[13]=tr.addTestCase();
					 String testCaseName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 12, 4);
					   String testCaseDesc2=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 12, 5);
					   tr.clickOnDetails();
					   actual[14]=ctc.enterTestCaseNameAndDesc(testCaseName2, testCaseDesc2);
					   bp.waitForElement();
					   tr.clickOnList();
					   actual[15]=tr.selectallTestCase();
					   bp.waitForElement();
					   actual[16]=tr.cloneTestCase();
					   bp.waitForElement();
					   actual[17]=tr.selectallTestCase();
					   bp.waitForElement();
					   actual[18]=tr.cloneTestCase();
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

	@When("^launch testplanning create cycle and add phase and save$")
	public void launch_testplanning_create_cycle_and_add_phase_and_save() throws Throwable 
	{
		try
		{
		actual[19]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		 tl=new TestPlanningPage(driver);
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 10, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 10, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 10, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
			actual[20]=tl.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[21]=tl.CreateCycle(cyclename, Build, Environment,hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
			actual[22]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[23]=tl.saveTestCycle();
			bp.waitForElement();
		   String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 10, 0);
			actual[24]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 17, 0);
			actual[25]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[26]=tl.bulkAssignment(Bulk_type);
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

	@When("^select P/S/SS and select All chekbox assign to Anyone/testmanager$")
	public void select_P_S_SS_and_select_All_chekbox_assign_to_Anyone_testmanager() throws Throwable 
	{
		try
		{
		String[] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 0);
		actual[27]=tl.navigateToCycle(phase);
		bp.waitForElement();
		actual[28]=tl.selectallTestCase();
		bp.waitForElement();
		String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		actual[29]=tl.assignAllSelected(Assignee);
		bp.waitForElement();
		actual[30]=tl.selectallTestCase();
		bp.waitForElement();
		//String Assignee1=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 3, 0);
		String manager=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User1");
		actual[31]=tl.assignAllSelected(manager);
		   bp.waitForElement();
		String system[]=new String[1];
		//system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 0);
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 2);
		   bp.waitForElement();
		   actual[32]=tl.navigateToCycle(system);
	    bp.waitForElement();
	    actual[33]= tl.selectallTestCase();
	    bp.waitForElement();
	    String Assigneesystem=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
	    actual[34]=tl.assignAllSelected(Assigneesystem);
	    bp.waitForElement();
	    actual[35]=tl.selectallTestCase();
	    bp.waitForElement();
	   // String Assigneemanager=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 3, 0);
	    actual[36]=tl.assignAllSelected(manager);
	    bp.waitForElement();
	    
	    String subsystem[]=new String[1];
//		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 0);
//		subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 2);
		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 4);
		actual[37]=tl.navigateToCycle(subsystem);
	    bp.waitForElement();
	    actual[38]=tl.selectallTestCase();
	    bp.waitForElement();
	    String Assignee2=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
	    actual[39]=tl.assignAllSelected(Assignee2);
	    bp.waitForElement();
	    actual[40]=tl.selectallTestCase();
	    bp.waitForElement();
	   // String Assigneeanyone=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 3, 0);
	    actual[41]=tl.assignAllSelected(manager);
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

	@When("^Select Phas/bulk assign/assign All notexecuted/assign To Lead/donot seletect subfolder$")
	public void select_Phas_bulk_assign_assign_All_notexecuted_assign_To_Lead_donot_seletect_subfolder() throws Throwable 
	{
		try
		{
		String[] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 0);
		actual[42]=tl.navigateToCycle(phase);
		bp.waitForElement();
		actual[43]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		   // String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    actual[44]=tl.assignAllNotexecuted(lead, Check);
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

	@When("^Select syste/bulk assign/assign All notexecuted/assign To Lead/donot seletect subfolder$")
	public void select_syste_bulk_assign_assign_All_notexecuted_assign_To_Lead_donot_seletect_subfolder() throws Throwable 
	{
		try
		{
		String system[]=new String[2];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 0);
		system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 2);
		actual[45]=tl.navigateToCycle(system);
	    bp.waitForElement();
	    actual[46]=tl.bulkAssignTestcasesSelectedFolder();
	    bp.waitForElement();
	    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
	    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
	    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
	    actual[47]=tl.assignAllNotexecuted(lead, Check);
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

	@When("^Select subsyste/bulk assign/assign All notexecuted/assign To Lead/donot seletect subfolder$")
	public void select_subsyste_bulk_assign_assign_All_notexecuted_assign_To_Lead_donot_seletect_subfolder() throws Throwable 
	{
		try
		{
		String subsystem[]=new String[1];
//		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 0);
//		subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 2);
		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 4);
		actual[48]=tl.navigateToCycle(subsystem);
	    bp.waitForElement();
	    actual[49]=tl.bulkAssignTestcasesSelectedFolder();
	    bp.waitForElement();
	    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
	    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
	    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 1);
	    actual[50]=tl.assignAllUnassigned(lead, Check);
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

	@When("^Launch Testplanning Selec existing phase and save$")
	public void launch_Testplanning_Selec_existing_phase_and_save() throws Throwable 
	{
		try
		{
		actual[51]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		 String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 10, 0);
			actual[52]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 17, 0);
			actual[53]=tl.addPhaseToCycle(nodeName);
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

	@When("^Select P/S/SS and Select All chekbox assign to Anyone/Tester\\.One$")
	public void select_P_S_SS_and_Select_All_chekbox_assign_to_Anyone_Tester_One() throws Throwable 
	{
		try
		{
		String[] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 0);
		actual[55]=tl.navigateToCycle(phase);
		bp.waitForElement();
		actual[56]=tl.selectallTestCase();
		bp.waitForElement();
		String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		actual[57]=tl.assignAllSelected(Assignee);
		bp.waitForElement();
		actual[58]=tl.selectallTestCase();
		bp.waitForElement();
		//String Assignee1=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 4, 0);
		String tester=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		actual[59]=tl.assignAllSelected(tester);
		
		String system[]=new String[1];
//		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 0);
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 2);
		actual[60]=tl.navigateToCycle(system);
	    bp.waitForElement();
	    actual[61]=tl.selectallTestCase();
	    bp.waitForElement();
	    String Assigneesystem=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
	    actual[62]=tl.assignAllSelected(Assigneesystem);
	    bp.waitForElement();
	    actual[63]=tl.selectallTestCase();
	    bp.waitForElement();
	    //String Assigneemanager=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 4, 0);
	    actual[64]=tl.assignAllSelected(tester);
	    bp.waitForElement();
	    
	    String subsystem[]=new String[1];
//		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 0);
//		subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 2);
		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 4);
		actual[65]=tl.navigateToCycle(subsystem);
	    bp.waitForElement();
	    actual[66]=tl.selectallTestCase();
	    bp.waitForElement();
	    String Assignee2=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
	    actual[67]=tl.assignAllSelected(Assignee2);
	    bp.waitForElement();
	    actual[68]=tl.selectallTestCase();
	    bp.waitForElement();
	    //String Assigneeanyone=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 4, 0);
	    actual[69]=tl.assignAllSelected(tester);
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

	@When("^Select Phas/bulk assin/assign All notexecute/assign To Lead/select subfolder$")
	public void select_Phas_bulk_assin_assign_All_notexecute_assign_To_Lead_select_subfolder() throws Throwable 
	{
		try
		{
		String[] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 0);
		actual[70]=tl.navigateToCycle(phase);
		bp.waitForElement();
		actual[71]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
		    actual[72]=tl.assignAllNotexecuted(lead, Check);
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

	@When("^Launch Testplanning Selec Existing phase and save$")
	public void launch_Testplanning_Selec_Existing_phase_and_save() throws Throwable 
	{
		try
		{
		actual[73]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		 String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 10, 0);
			actual[74]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 17, 0);
			actual[75]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[76]=tl.bulkAssignment(Bulk_type);
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

	@When("^Select P/S/SS and Select All Chekbox assig to Anyone/Tester\\.One$")
	public void select_P_S_SS_and_Select_All_Chekbox_assig_to_Anyone_Tester_One() throws Throwable 
	{
		try
		{
			String[] phase=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 0);
			actual[77]=tl.navigateToCycle(phase);
			bp.waitForElement();
			actual[78]=tl.selectallTestCase();
			bp.waitForElement();
			String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
			actual[79]=tl.assignAllSelected(Assignee);
			bp.waitForElement();
			actual[80]=tl.selectallTestCase();
			bp.waitForElement();
			//String Assignee1=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 4, 0);
			String tester=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
			actual[81]=tl.assignAllSelected(tester);
			
			String system[]=new String[1];
	//		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 0);
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 2);
			actual[82]=tl.navigateToCycle(system);
		    bp.waitForElement();
		    actual[83]=tl.selectallTestCase();
		    bp.waitForElement();
		    String Assigneesystem=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		    actual[84]=tl.assignAllSelected(Assigneesystem);
		    bp.waitForElement();
		    actual[85]=tl.selectallTestCase();
		    bp.waitForElement();
		    //String Assigneemanager=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 4, 0);
		    actual[86]=tl.assignAllSelected(tester);
		    bp.waitForElement();
		    
		    String subsystem[]=new String[1];
	//		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 0);
	//		subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 2);
			subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 4);
			actual[87]=tl.navigateToCycle(subsystem);
		    bp.waitForElement();
		    actual[88]=tl.selectallTestCase();
		    bp.waitForElement();
		    String Assignee2=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		    actual[89]=tl.assignAllSelected(Assignee2);
		    bp.waitForElement();
		    actual[90]=tl.selectallTestCase();
		    bp.waitForElement();
		    //String Assigneeanyone=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 4, 0);
		    actual[91]=tl.assignAllSelected(tester);
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

	@When("^Select system/bulk assin/assign All notexcuted/assig To Lead/select subfolder$")
	public void select_system_bulk_assin_assign_All_notexcuted_assig_To_Lead_select_subfolder() throws Throwable 
	{
		try
		{
			String[] system=new String[1];
	//		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 0);
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 2);
			actual[92]=tl.navigateToCycle(system);
			bp.waitForElement();
			actual[93]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
		    actual[94]=tl.assignAllNotexecuted(lead, Check);
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

	@When("^Launch Testplanning Selec Existing phas and Save$")
	public void launch_Testplanning_Selec_Existing_phas_and_Save() throws Throwable 
	{
		try
		{
			actual[95]=rp.clickOnTestPlanning();
			 bp.waitForElement();
			 String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 10, 0);
			actual[96]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 17, 0);
			actual[97]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[98]=tl.bulkAssignment(Bulk_type);
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

	@When("^Select P/S/SS and Select all Chekbox assig to Anyone/Tester\\.One$")
	public void select_P_S_SS_and_Select_all_Chekbox_assig_to_Anyone_Tester_One() throws Throwable 
	{
		try
		{
			String[] phase=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 0);
			actual[99]=tl.navigateToCycle(phase);
			bp.waitForElement();
			actual[100]=tl.selectallTestCase();
			bp.waitForElement();
			String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
			actual[101]=tl.assignAllSelected(Assignee);
			bp.waitForElement();
			actual[102]=tl.selectallTestCase();
			bp.waitForElement();
			//String Assignee1=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 4, 0);
			String tester=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
			actual[103]=tl.assignAllSelected(tester);
			
			String system[]=new String[1];
	//		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 0);
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 2);
			actual[104]=tl.navigateToCycle(system);
		    bp.waitForElement();
		    actual[105]=tl.selectallTestCase();
		    bp.waitForElement();
		    String Assigneesystem=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		    actual[106]=tl.assignAllSelected(Assigneesystem);
		    bp.waitForElement();
		    actual[107]=tl.selectallTestCase();
		    bp.waitForElement();
		    //String Assigneemanager=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 4, 0);
		    actual[108]=tl.assignAllSelected(tester);
		    bp.waitForElement();
		    
		    String subsystem[]=new String[1];
	//		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 0);
	//		subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 2);
			subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 4);
			actual[109]=tl.navigateToCycle(subsystem);
		    bp.waitForElement();
		    actual[110]=tl.selectallTestCase();
		    bp.waitForElement();
		    String Assignee2=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		    actual[111]=tl.assignAllSelected(Assignee2);
		    bp.waitForElement();
		    actual[112]=tl.selectallTestCase();
		    bp.waitForElement();
		    //String Assigneeanyone=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 4, 0);
		    actual[113]=tl.assignAllSelected(tester);
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

	@When("^Select subsystem/bulk assin/assign All notexecuted/assig To Lead/select subfolder$")
	public void select_subsystem_bulk_assin_assign_All_notexecuted_assig_To_Lead_select_subfolder() throws Throwable 
	{
		try
		{
			String[] system=new String[1];
	//		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 17, 4);
			actual[114]=tl.navigateToCycle(system);
			bp.waitForElement();
			actual[115]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		   // String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
		    actual[116]=tl.assignAllNotexecuted(lead, Check);
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

	@Then("^All the nodes including child nodes testcases should be asigned to test\\.lead$")
	public void all_the_nodes_including_child_nodes_testcases_should_be_asigned_to_test_lead() throws Throwable 
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
