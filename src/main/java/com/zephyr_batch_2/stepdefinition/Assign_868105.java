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

public class Assign_868105 extends LaunchBrowser
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
	boolean[] actual=new boolean[68];
	 SoftAssert soft=new SoftAssert();
	 String filename="Assign_868105";
	@Given("^user in testrepository page to create P/S/SS$")
	public void user_in_testrepository_page_to_create_P_S_SS() throws Throwable 
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
	@Given("^create P/S/SS add test case and clone$")
	public void create_P_S_SS_add_test_case_and_clone() throws Throwable 
	{
		try
		{
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 11, 0);
			String nodeDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 11, 1);
			actual[4]=tr.addNode(nodeName, nodeDesc);
			 bp.waitForElement();
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			 actual[5]=tr.doubleClickOnRelease(releaseName);
			   String[] phase=new String[1];
			   phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 11, 0);
			   actual[6]=tr.navigateToNode(releaseName, phase);
			   bp.waitForElement();
			   actual[7]=tr.addTestCase();
			 ctc=new CreateTestCasePage(driver);
			   String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 6, 0);
			   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 6, 1);
			   tr.clickDetailButton();
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
		   
		   //String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
		   actual[13]=tr.doubleClickOnRelease(releaseName);
			 bp.waitForElement();
			String[] nnodeName1=new String[1];
			nnodeName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 11, 0);
			actual[14]=tr.navigateToNode(releaseName, nnodeName1);
			bp.waitForElement();
			String nodeName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 11, 2);
			String nodeDesc1=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 11, 3);
			actual[15]=tr.addNode(nodeName1, nodeDesc1);
			
			 //String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			actual[16]=tr.doubleClickOnRelease(releaseName);
			   bp.waitForElement();
			   String[] navigationsystem=new String[2];
			   navigationsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 11, 0);
			   navigationsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 11, 2);
			   actual[17]=tr.navigateToNode(releaseName, navigationsystem);
			   bp.waitForElement();
			   actual[18]=tr.addTestCase();
			  bp.waitForElement();
			  tr.clickOnDetails();
			 String testCaseName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 6, 2);
			   String testCaseDesc1=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 6, 3);
			   actual[19]=ctc.enterTestCaseNameAndDesc(testCaseName1, testCaseDesc1);
			   bp.waitForElement();
			   tr.clickOnList();
			   actual[20]=tr.selectallTestCase();
			   bp.waitForElement();
			   actual[21]=tr.cloneTestCase();
			   bp.waitForElement();
			   actual[22]=tr.selectallTestCase();
			   bp.waitForElement();
			   actual[23]=tr.cloneTestCase();
			   bp.waitForElement();
			   actual[24]=tr.doubleClickOnRelease(releaseName);
			   String[] navigation1=new String[2];
			   navigation1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 11, 0);
			   navigation1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 11, 2);
			   actual[25]=tr.navigateToNode(releaseName, navigation1);
			   bp.waitForElement();
				String nodeName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 11, 4);
				String nodeDesc2=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 11, 5);
				actual[26]=tr.addNode(nodeName2, nodeDesc2);
				
				actual[27]=tr.doubleClickOnRelease(releaseName);
				   String[] navigationsubsystem=new String[3];
				   navigationsubsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 11, 0);
				   navigationsubsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 11, 2);
				   navigationsubsystem[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 11, 4);
				   actual[28]=tr.navigateToNode(releaseName, navigationsubsystem);
				   bp.waitForElement();
				   actual[29]=tr.addTestCase();
				   tr.clickOnDetails();
				 String testCaseName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 6, 4);
				   String testCaseDesc2=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 6, 5);
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

	@When("^launch test planning and add phase$")
	public void launch_test_planning_and_add_phase() throws Throwable 
	{
		try
		{
		   actual[35]=rp.clickOnTestPlanning();
		   bp.waitForElement();
		   tl=new TestPlanningPage(driver);
		   actual[36]=tl.clickOnAddTestCycleSymbol();
		   bp.waitForElement();
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
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
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 11, 0);
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

	@When("^select phase/bulk assign/assign all notexecuted/assign to lead/donot seletect subfolder$")
	public void select_phase_bulk_assign_assign_all_notexecuted_assign_to_lead_donot_seletect_subfolder() throws Throwable 
	{
		try
		{
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 11, 0);
			actual[43]=tl.navigateToCycle(phase);
		    bp.waitForElement();
		    actual[44]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    actual[45]=tl.assignAllNotexecuted(lead, Check);
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

	@When("^select system/bulk assign/assign all notexecuted/assign to lead/donot seletect subfolder$")
	public void select_system_bulk_assign_assign_all_notexecuted_assign_to_lead_donot_seletect_subfolder() throws Throwable 
	{
		try
		{
	//			String releaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 11, 0);
	//			tr.doubleClickOnRelease(releaseName);
	//			tl.doubleClickOnCycle(cycleName);
			String phase[]=new String[1];
			//phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 11, 0);
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 11, 2);
			actual[46]=tl.navigateToCycle(phase);
		    bp.waitForElement();
		    actual[47]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    actual[48]=tl.assignAllNotexecuted(lead, Check);
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

	@Then("^select subsystem/bulk assign/assign all notexecuted/assign to lead/donot seletect subfolder$")
	public void select_subsystem_bulk_assign_assign_all_notexecuted_assign_to_lead_donot_seletect_subfolder() throws Throwable 
	{
		try
		{
			String phase[]=new String[1];
	//		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 11, 0);
	//		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 11, 2);
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 11, 4);
			actual[49]=tl.navigateToCycle(phase);
		    bp.waitForElement();
		    actual[50]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    actual[51]=tl.assignAllNotexecuted(lead, Check);
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

	@Then("^launch test planning  and choose existing phase$")
	public void launch_test_planning_and_choose_existing_phase() throws Throwable 
	{
		try
		{
			 tl.goBackToCycle();
			actual[52]=rp.clickOnTestPlanning();
			bp.waitForElement();
			String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 0);
			actual[53]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 11, 0);
			actual[54]=tl.addPhaseToCycle(nodeName);
			bp.waitForElement();
			String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
			actual[55]=tl.bulkAssignment(Bulk_type);
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

	@Then("^select phase/bulk assign/assign all notexecuted/assign to lead/seletect subfolder$")
	public void select_phase_bulk_assign_assign_all_notexecuted_assign_to_lead_seletect_subfolder() throws Throwable 
	{
		try
		{
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 11, 0);
			actual[56]=tl.navigateToCycle(phase);
		    bp.waitForElement();
		    actual[57]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
		    actual[58]=tl.assignAllNotexecuted(lead, Check);
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

	@Then("^select system/bulk assign/assign all notexecuted/assign to lead/seletect subfolder$")
	public void select_system_bulk_assign_assign_all_notexecuted_assign_to_lead_seletect_subfolder() throws Throwable 
	{
		try
		{
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 11, 0);
			actual[59]=tl.navigateToCycle(phase);
			bp.waitForElement();
			String system[]=new String[1];
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 11, 2);
			actual[60]=tl.navigateToCycle(system);
		    bp.waitForElement();
		    actual[61]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		   // String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
		    actual[62]=tl.assignAllNotexecuted(lead, Check);
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

	@Then("^select subsystem/bulk assign/assign all notexecuted/assign to lead/seletect subfolder$")
	public void select_subsystem_bulk_assign_assign_all_notexecuted_assign_to_lead_seletect_subfolder() throws Throwable 
	{
		try
		{
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 11, 0);
			actual[63]=tl.navigateToCycle(phase);
		
			String system[]=new String[1];
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 11, 2);
			actual[64]=tl.navigateToCycle(system);
		
	//		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 11, 2);
			String subsystem[]=new String[1];
			subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 11, 4);
			actual[65]=tl.navigateToCycle(subsystem);
		    bp.waitForElement();
		    actual[66]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
		    actual[67]=tl.assignAllNotexecuted(lead, Check);
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

	@Then("^should be assigned to test\\.lead, phase node should not get assigned$")
	public void should_be_assigned_to_test_lead_phase_node_should_not_get_assigned() throws Throwable 
	{
		try
		   {
			   for(int k=0;k<=actual.length-1;k++)
			     {
			      soft.assertEquals(actual[k], true);
			      System.out.println(actual[k]);
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
