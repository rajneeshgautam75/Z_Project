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

public class Assign_868110 extends LaunchBrowser
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
	boolean[] actual=new boolean[132];
	 SoftAssert soft=new SoftAssert();
	 String filename="Assign_868110";
	@Given("^User in repository page to create P/S/SS$")
	public void user_in_repository_page_to_create_P_S_SS() throws Throwable 
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

	@Given("^create P/S/SS add Testcase and clone$")
	public void create_P_S_SS_add_Testcase_and_clone() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 16, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 16, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			actual[5]=tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			//navigate to phase//
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 16, 0);
			actual[6]=tr.navigateToNode(releaseName, phase);
			
			actual[7]=tr.addTestCase();
			 ctc=new CreateTestCasePage(driver);
			   String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 11, 0);
			   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 11, 1);
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
			   
			   actual[13]=tr.doubleClickOnRelease(releaseName);
			   bp.waitForElement();
				//String[] phase=new String[1];
				//navigate to phase/////////////////////////////////////////////////////////////////////
				phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 16, 0);
				actual[14]=tr.navigateToNode(releaseName, phase);
				bp.waitForElement();
				
				String systemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 16, 2);
				String systemDesc1=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 16, 3);
				actual[15]=tr.addNode(systemName, systemDesc1);
				bp.waitForElement();
				//navigate to system
				actual[16]=tr.doubleClickOnRelease(releaseName);
				String system[]=new String[2];
				system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 16, 0);
				system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 16, 2);
				actual[17]=tr.navigateToNode(releaseName, system);
				bp.waitForElement();
				actual[18]=tr.addTestCase();
				 String testCaseName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 11, 2);
				   String testCaseDesc1=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 11, 3);
				   tr.clickOnDetails();
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
				   String[] navigation=new String[2];
				   //navigate to system/////////////////////////////////////////////////////////////////////
				   navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 16, 0);
				   navigation[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 16, 2);
				   actual[25]=tr.navigateToNode(releaseName, navigation);
				   bp.waitForElement();
					String subsystemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 16, 4);
					String subsystemDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 16, 5);
					actual[26]=tr.addNode(subsystemName, subsystemDesc);
					//navigate to subsystem
					actual[27]=tr.doubleClickOnRelease(releaseName);
					String subsystem[]=new String[3];
					subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 16, 0);
					subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 16, 2);
					subsystem[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 16, 4);
					actual[28]=tr.navigateToNode(releaseName, subsystem);
					
					actual[29]=tr.addTestCase();
					 String testCaseName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 11, 4);
					   String testCaseDesc2=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 11, 5);
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

	@When("^launch testplanning create cycle and add phase To cycle and save$")
	public void launch_testplanning_create_cycle_and_add_phase_To_cycle_and_save() throws Throwable 
	{
		try
		{
		actual[35]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		 tl=new TestPlanningPage(driver);
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 9, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 9, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 9, 2);
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
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 9, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 16, 0);
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

	@When("^select P/S/SS and select All chekbox assign to Anyone$")
	public void select_P_S_SS_and_select_All_chekbox_assign_to_Anyone() throws Throwable 
	{
		try
		{
			String[] phase=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
			actual[43]=tl.navigateToCycle(phase);
			bp.waitForElement();
			actual[44]=tl.selectallTestCase();
			bp.waitForElement();
			String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
			actual[45]=tl.assignAllSelected(Assignee);
			
	//		String system[]=new String[2];
	//		system[0]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
	//		system[1]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 2);
	//	    tl.navigateToCycle(system);
			
			//String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
			actual[46]=tl.navigateToCycle(phase);
			
			//String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
			tl.navigateToCycle(phase);
				
			String system[]=new String[1];
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 2);
			actual[47]=tl.navigateToCycle(system);
			
		    bp.waitForElement();
		    actual[48]= tl.selectallTestCase();
		    bp.waitForElement();
		    String Assignee1=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		    actual[49]=tl.assignAllSelected(Assignee1);
		    bp.waitForElement();
		    
	//	    String subsystem[]=new String[3];
	//		subsystem[0]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
	//		subsystem[1]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 2);
	//		subsystem[2]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 4);
	//	    tl.navigateToCycle(subsystem);
		    
	//	    String phase[]=new String[1];
	//		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
			actual[50]=tl.navigateToCycle(phase);
			
			//String phase[]=new String[1];
			//phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
			tl.navigateToCycle(phase);
			
		//	String system[]=new String[1];
		//	system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 2);
			actual[51]=tl.navigateToCycle(system);
		    bp.waitForElement();
				
			String subsystem[]=new String[1];
			subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 4);
			actual[52]=tl.navigateToCycle(subsystem);
		    
		    bp.waitForElement();
		    actual[53]=tl.selectallTestCase();
		    bp.waitForElement();
		    String Assignee2=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		    actual[54]=tl.assignAllSelected(Assignee2);
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

	@When("^select Phase/bulk assign/assign All notexecuted/assign To Lead/donot seletect subfolder$")
	public void select_Phase_bulk_assign_assign_All_notexecuted_assign_To_Lead_donot_seletect_subfolder() throws Throwable 
	{
		try
		{
			String[] phase=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
			actual[55]=tl.navigateToCycle(phase);
			bp.waitForElement();
			actual[56]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
		    actual[57]=tl.assignAllNotexecuted(lead, Check);
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

	@When("^select system/bulk assign/assign All notexecuted/assign To Lead/donot seletect subfolder$")
	public void select_system_bulk_assign_assign_All_notexecuted_assign_To_Lead_donot_seletect_subfolder() throws Throwable 
	{
		try
		{
//		String system[]=new String[2];
//		system[0]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
//		system[1]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 2);
//	    tl.navigateToCycle(system);
		
		String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
		actual[58]=tl.navigateToCycle(phase);
				
//		//String phase[]=new String[1];
//		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
//		actual[59]=tl.navigateToCycle(phase);
				
		String system[]=new String[1];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 2);
		actual[59]=tl.navigateToCycle(system);
		
	    bp.waitForElement();
	    actual[60]=tl.bulkAssignTestcasesSelectedFolder();
	    bp.waitForElement();
	    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
	    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
	    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
	    actual[61]=tl.assignAllNotexecuted(lead, Check);
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

	@When("^select subsystem/bulk assign/assign All notexecuted/assign To Lead/donot seletect subfolder$")
	public void select_subsystem_bulk_assign_assign_All_notexecuted_assign_To_Lead_donot_seletect_subfolder() throws Throwable 
	{
		try
		{
	//		String subsystem[]=new String[3];
	//		subsystem[0]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
	//		subsystem[1]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 2);
	//		subsystem[2]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 4);
	//	    tl.navigateToCycle(subsystem);
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
			actual[62]=tl.navigateToCycle(phase);
			
			//String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
			actual[63]=tl.navigateToCycle(phase);
			
			String system[]=new String[1];
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 2);
			actual[64]=tl.navigateToCycle(system);
		    bp.waitForElement();
				
			String subsystem[]=new String[1];
			subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 4);
			actual[65]=tl.navigateToCycle(subsystem);
				
		    bp.waitForElement();
		    actual[66]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 1);
		    actual[67]=tl.assignAllUnassigned(lead, Check);
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

	@When("^Launch testplanning select existing phase and save$")
	public void launch_testplanning_select_existing_phase_and_save() throws Throwable 
	{
		try
		{
		actual[68]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		 String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 9, 0);
			actual[69]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 16, 0);
			actual[70]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[71]=tl.bulkAssignment(Bulk_type);
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

	@When("^Select P/S/SS and Select All chekbox assign to Anyone$")
	public void select_P_S_SS_and_Select_All_chekbox_assign_to_Anyone() throws Throwable 
	{
		try
		{
		String[] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
		bp.waitForElement();
		actual[72]=tl.navigateToCycle(phase);
		bp.waitForElement();
		actual[73]=tl.selectallTestCase();
		bp.waitForElement();
		String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		actual[74]=tl.assignAllSelected(Assignee);
		
//		String system[]=new String[2];
//		system[0]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
//		system[1]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 2);
//	    tl.navigateToCycle(system);
		
		//String phase[]=new String[1];
//		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
//		actual[75]=tl.navigateToCycle(phase);
//		//////////////////////////////////////////////////////////////////////////////////////
//		//String phase[]=new String[1];
//		//phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
//		tl.navigateToCycle(phase);
			
		String system[]=new String[1];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 2);
		actual[75]=tl.navigateToCycle(system);
		
	    bp.waitForElement();
	    actual[76]=tl.selectallTestCase();
	    bp.waitForElement();
	    String Assignee1=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
	    actual[77]=tl.assignAllSelected(Assignee1);
	    bp.waitForElement();
	    
//	    String subsystem[]=new String[3];
//		subsystem[0]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
//		subsystem[1]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 2);
//		subsystem[2]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 4);
//	    tl.navigateToCycle(subsystem);
	    
//	    String phase[]=new String[1];
//		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
		actual[78]=tl.navigateToCycle(phase);
		
		//String phase[]=new String[1];
		//phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
		actual[79]=tl.navigateToCycle(phase);
		
	//	String system[]=new String[1];
	//	system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 2);
		actual[80]=tl.navigateToCycle(system);
	    bp.waitForElement();
			
		String subsystem[]=new String[1];
		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 4);
		actual[81]=tl.navigateToCycle(subsystem);
	    
	    bp.waitForElement();
	    actual[82]=tl.selectallTestCase();
	    bp.waitForElement();
	    String Assignee2=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
	    actual[83]=tl.assignAllSelected(Assignee2);
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

	@When("^select Phase/bulk assin/assign All notexecuted/assign To Lead/select subfolder$")
	public void select_Phase_bulk_assin_assign_All_notexecuted_assign_To_Lead_select_subfolder() throws Throwable 
		{
		try
		{
			String[] phase=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
			actual[84]=tl.navigateToCycle(phase);
			bp.waitForElement();
			actual[85]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		   // String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
		    actual[86]=tl.assignAllNotexecuted(lead, Check);
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

	@When("^Launch testplanning Select existing phase and save$")
	public void launch_testplanning_Select_existing_phase_and_save() throws Throwable 
	{
		try
		{
			 actual[87]=rp.clickOnTestPlanning();
			 bp.waitForElement();
			 String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 9, 0);
			actual[88]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 16, 0);
			actual[89]=tl.addPhaseToCycle(nodeName);
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

	@When("^Select P/S/SS and Select All Chekbox assign to Anyone$")
	public void select_P_S_SS_and_Select_All_Chekbox_assign_to_Anyone() throws Throwable 
	{
		try
		{
			String[] phase=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
			actual[91]=tl.navigateToCycle(phase);
			bp.waitForElement();
			actual[92]=tl.selectallTestCase();
			bp.waitForElement();
			String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
			actual[93]=tl.assignAllSelected(Assignee);
			
	//		String system[]=new String[2];
	//		system[0]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
	//		system[1]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 2);
	//	    tl.navigateToCycle(system);
			
			//String phase[]=new String[1];
			//phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
			actual[94]=tl.navigateToCycle(phase);
			
			//String phase[]=new String[1];
			//phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
			tl.navigateToCycle(phase);
			
			String system[]=new String[1];
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 2);
			actual[95]=tl.navigateToCycle(system);
			
		    bp.waitForElement();
		    actual[96]=tl.selectallTestCase();
		    bp.waitForElement();
		    String Assignee1=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		    actual[97]=tl.assignAllSelected(Assignee1);
		    bp.waitForElement();
		    
	//	    String subsystem[]=new String[3];
	//		subsystem[0]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
	//		subsystem[1]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 2);
	//		subsystem[2]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 4);
	//	    tl.navigateToCycle(subsystem);
		    
	//	    String phase[]=new String[1];
	//		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
			actual[98]=tl.navigateToCycle(phase);
			
			//String phase[]=new String[1];
			//phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
			actual[99]=tl.navigateToCycle(phase);
				
		//	String system[]=new String[1];
		//	system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 2);
			actual[100]=tl.navigateToCycle(system);
		    bp.waitForElement();
				
			String subsystem[]=new String[1];
			subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 4);
			actual[101]=tl.navigateToCycle(subsystem);
		    
		    bp.waitForElement();
		    actual[102]=tl.selectallTestCase();
		    bp.waitForElement();
		    String Assignee2=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		    actual[103]=tl.assignAllSelected(Assignee2);
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

	@When("^select system/bulk assin/assign All Notexecuted/assign To Lead/select subfolder$")
	public void select_system_bulk_assin_assign_All_Notexecuted_assign_To_Lead_select_subfolder() throws Throwable 
	{
		try
		{
//		String[] system=new String[2];
//		system[0]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
//		system[1]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 2);
//		tl.navigateToCycle(system);
		
		String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
		actual[104]=tl.navigateToCycle(phase);
		
		//String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
		actual[105]=tl.navigateToCycle(phase);
			
		String system[]=new String[1];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 2);
		actual[106]=tl.navigateToCycle(system);
		
		bp.waitForElement();
		actual[107]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
		    actual[108]=tl.assignAllNotexecuted(lead, Check);
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

	@When("^Launch Testplanning Select existing phase and save$")
	public void launch_Testplanning_Select_existing_phase_and_save() throws Throwable 
	{
		try
		{
		actual[109]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		 String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 9, 0);
			actual[110]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 16, 0);
			actual[111]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[112]=tl.bulkAssignment(Bulk_type);
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

	@When("^Select P/S/Ss and Select All Chekbox assign to Anyone$")
	public void select_P_S_Ss_and_Select_All_Chekbox_assign_to_Anyone() throws Throwable 
	{
		try
		{
		String[] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
		actual[113]=tl.navigateToCycle(phase);
		bp.waitForElement();
		actual[114]=tl.selectallTestCase();
		bp.waitForElement();
		String Assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
		actual[115]=tl.assignAllSelected(Assignee);
		
//		String system[]=new String[2];
//		system[0]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
//		system[1]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 2);
//	    tl.navigateToCycle(system);
		
		//String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
		actual[116]=tl.navigateToCycle(phase);
		
		//String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
		actual[117]=tl.navigateToCycle(phase);
		
		String system[]=new String[1];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 2);
		actual[118]=tl.navigateToCycle(system);
		
	    bp.waitForElement();
	    actual[119]=tl.selectallTestCase();
	    bp.waitForElement();
	    String Assignee1=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
	    actual[120]=tl.assignAllSelected(Assignee1);
	    bp.waitForElement();
	    
//	    String subsystem[]=new String[3];
//		subsystem[0]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
//		subsystem[1]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 2);
//		subsystem[2]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 4);
//	    tl.navigateToCycle(subsystem);
	    
//	    String phase[]=new String[1];
//		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
		actual[121]=tl.navigateToCycle(phase);
		
		//String phase[]=new String[1];
		//phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 0);
		tl.navigateToCycle(phase);
			
	//	String system[]=new String[1];
	//	system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 15, 2);
		actual[122]=tl.navigateToCycle(system);
	    bp.waitForElement();
			
		String subsystem[]=new String[1];
		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 4);
		actual[123]=tl.navigateToCycle(subsystem);
	    
	    bp.waitForElement();
	    actual[124]=tl.selectallTestCase();
	    bp.waitForElement();
	    String Assignee2=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
	    actual[125]=tl.assignAllSelected(Assignee2);
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

	@When("^select subSystem/bulk assin/assign All Notexecuted/assign To Lead/select subfolder$")
	public void select_subSystem_bulk_assin_assign_All_Notexecuted_assign_To_Lead_select_subfolder() throws Throwable 
	{
		try
		{
	//		String[] subsystem=new String[2];
	//		subsystem[0]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
	//		subsystem[1]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 2);
	//		subsystem[1]=Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 4);
	//		tl.navigateToCycle(subsystem);
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
			actual[126]=tl.navigateToCycle(phase);
			
			//String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 0);
			actual[127]=tl.navigateToCycle(phase);
				
			String system[]=new String[1];
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 2);
			actual[128]=tl.navigateToCycle(system);
		    bp.waitForElement();
				
			String subsystem[]=new String[1];
			subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 16, 4);
			actual[129]=tl.navigateToCycle(subsystem);
			
			bp.waitForElement();
			actual[130]=tl.bulkAssignTestcasesSelectedFolder();
		    bp.waitForElement();
		   // String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
		    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
		    actual[131]= tl.assignAllNotexecuted(lead, Check);
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

	@Then("^All the nodes including child nodes testcases should be assigned to testLead$")
	public void all_the_nodes_including_child_nodes_testcases_should_be_assigned_to_testLead() throws Throwable 
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
