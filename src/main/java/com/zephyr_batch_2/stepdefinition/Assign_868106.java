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

public class Assign_868106 extends LaunchBrowser
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
	boolean[] actual=new boolean[63];
	 SoftAssert soft=new SoftAssert();
	 String filename="Assign_868106";
	@Given("^user in repository page to create P/S/SS (\\d+)th Level$")
	public void user_in_repository_page_to_create_P_S_SS_th_Level(int arg1) throws Throwable 
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

	@Given("^create a P/S/SS add test case upto (\\d+)th level$")
	public void create_a_P_S_SS_add_test_case_upto_th_level(int arg1) throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			 bp.waitForElement();
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			 actual[5]=tr.doubleClickOnRelease(releaseName);
			   String[] navigation=new String[1];
			   navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 12, 0);
			   actual[6]=tr.navigateToNode(releaseName, navigation);
			   bp.waitForElement();
			   actual[7]=tr.addTestCase();
			   tr.clickOnDetails();
			   ctc=new CreateTestCasePage(driver);
			   String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 0);
			   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 1);
			   actual[8]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
			   bp.waitForElement();
			   tr.clickOnList();
			   bp.waitForElement();
			  // String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			   actual[9]=tr.doubleClickOnRelease(releaseName);
				String[] phase=new String[1];
				//navigate to phase/////////////////////////////////////////////////////////////////////
				phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 0);
				actual[10]=tr.navigateToNode(releaseName, phase);
				bp.waitForElement();
				String systemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 2);
				String systemDesc1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 3);
				actual[11]=tr.addNode(systemName, systemDesc1);
				actual[12]=tr.addTestCase();
				tr.clickOnDetails();
				 String testCaseName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 2);
				   String testCaseDesc1=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 3);
				   actual[13]=ctc.enterTestCaseNameAndDesc(testCaseName1, testCaseDesc1);
				   tr.clickOnList();
				   bp.waitForElement();
				   actual[14]=tr.doubleClickOnRelease(releaseName);
				   String[] navigation1=new String[2];
				   //navigate to system/////////////////////////////////////////////////////////////////////
				   navigation1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 0);
				   navigation1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 2);
				   actual[15]=tr.navigateToNode(releaseName, navigation1);
				   bp.waitForElement();
					String subsystemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 4);
					String subsystemDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 5);
					actual[16]=tr.addNode(subsystemName, subsystemDesc);
					actual[17]=tr.addTestCase();
					tr.clickOnDetails();
					 String testCaseName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 4);
					   String testCaseDesc2=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 5);
					   actual[18]=ctc.enterTestCaseNameAndDesc(testCaseName2, testCaseDesc2);
					   bp.waitForElement();
					   tr.clickOnList();
					   bp.waitForElement();
					   actual[19]=tr.doubleClickOnRelease(releaseName);
					   String[] navigationss=new String[3];
					   //navigate to subsystem////////////////////////////////////////////////////////////
					   navigationss[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 0);
					   navigationss[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 2);
					   navigationss[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 4);
					   actual[20]=tr.navigateToNode(releaseName, navigationss);
					   bp.waitForElement();
						String fourthName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 6);
						String fourthDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 7);
						actual[21]=tr.addNode(fourthName, fourthDesc);
						actual[22]=tr.addTestCase();
						tr.clickOnDetails();
						 String testCaseName3=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 6);
						   String testCaseDesc3=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 7);
						   actual[23]=ctc.enterTestCaseNameAndDesc(testCaseName3, testCaseDesc3);
						   bp.waitForElement();
						   tr.clickOnList();
						   bp.waitForElement();
						   actual[24]=tr.doubleClickOnRelease(releaseName);
						   String[] navigation4=new String[4];
						   //navigate to fourth////////////////////////////////////////////////////////////
						   navigation4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 0);
						   navigation4[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 2);
						   navigation4[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 4);
						   navigation4[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 6);
						   actual[25]=tr.navigateToNode(releaseName, navigation4);
						   bp.waitForElement();
							String fifthName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 8);
							String fifthDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 9);
							actual[26]=tr.addNode(fifthName, fifthDesc);
							actual[27]=tr.addTestCase();
							tr.clickOnDetails();
							 String testCaseName4=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 8);
							   String testCaseDesc4=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 9);
							   actual[28]=ctc.enterTestCaseNameAndDesc(testCaseName4, testCaseDesc4);
							   bp.waitForElement();
							   tr.clickOnList();
							   bp.waitForElement();
							   actual[29]=tr.doubleClickOnRelease(releaseName);
							   String[] navigation5=new String[5];
							   //navigate to fifth////////////////////////////////////////////////////////////
							   navigation5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 0);
							   navigation5[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 2);
							   navigation5[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 4);
							   navigation5[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 6);
							   navigation5[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 8);
							   actual[30]=tr.navigateToNode(releaseName, navigation5);
							   bp.waitForElement();
								String sixthName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 10);
								String sixthDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 11);
								actual[31]=tr.addNode(sixthName, sixthDesc);
								actual[32]=tr.addTestCase();
								tr.clickOnDetails();
								 String testCaseName6=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 10);
								   String testCaseDesc6=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 11);
								   actual[33]=ctc.enterTestCaseNameAndDesc(testCaseName6, testCaseDesc6);
								   bp=new BasePage();
								   bp.waitForElement();
								   bp.waitForElement();
								   tr.clickOnList();
								   bp.waitForElement();
								   actual[34]=tr.doubleClickOnRelease(releaseName);
								   String[] navigation6=new String[6];
								   //navigate to sixth////////////////////////////////////////////////////////////
								   navigation6[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 0);
								   navigation6[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 2);
								   navigation6[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 4);
								   navigation6[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 6);
								   navigation6[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 8);
								   navigation6[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 10);
								   tr=new TestRepositoryPage(driver);
								   actual[35]= tr.navigateToNode(releaseName, navigation6);
								   bp.waitForElement();
									String seventhName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 12);
									String seventhdesc=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 13);
									actual[36]=tr.addNode(seventhName, seventhdesc);
									actual[37]=tr.addTestCase();
									tr.clickOnDetails();
									 String testCaseName7=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 12);
									   String testCaseDesc7=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 13);
									   actual[38]=ctc.enterTestCaseNameAndDesc(testCaseName7, testCaseDesc7);
									   bp.waitForElement();
									   tr.clickOnList();
									   bp.waitForElement();
									   actual[39]=tr.doubleClickOnRelease(releaseName);
									   String[] navigation7=new String[7];
									   //navigate to seventh////////////////////////////////////////////////////////////
									   navigation7[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 0);
									   navigation7[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 2);
									   navigation7[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 4);
									   navigation7[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 6);
									   navigation7[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 8);
									   navigation7[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 10);
									   navigation7[6]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 12);
									   actual[40]=tr.navigateToNode(releaseName, navigation7);
									   bp.waitForElement();
										String eightName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 14);
										String eightdesc=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 15);
										actual[41]=tr.addNode(eightName, eightdesc);
										actual[42]=tr.addTestCase();
										tr.clickOnDetails();
										 String testCaseName8=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 14);
										   String testCaseDesc8=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 15);
										   actual[43]=ctc.enterTestCaseNameAndDesc(testCaseName8, testCaseDesc8);
										   bp.waitForElement(); 
										   tr.clickOnList();
										   bp.waitForElement();
						}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}	
	}

	@When("^create a cycle and add phase to cycle created$")
	public void create_a_cycle_and_add_phase_to_cycle_created() throws Throwable 
	{
		try
		{
			tl=new TestPlanningPage(driver);
			bp.waitForElement();
			actual[44]=rp.clickOnTestPlanning();
			bp.waitForElement();
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 5, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 5, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 5, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
			actual[45]=tl.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[46]=tl.CreateCycle(cyclename, Build, Environment,hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
			actual[47]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[48]=tl.saveTestCycle();
			bp.waitForElement();
		   String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 5, 0);
			actual[49]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 0);
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

	@When("^select Third system/bulk assign/assign all notexecuted/assign to lead/donot seletect subfolder$")
	public void select_Third_system_bulk_assign_assign_all_notexecuted_assign_to_lead_donot_seletect_subfolder() throws Throwable 
	{
		try
		{
		String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 12, 0);
		actual[52]= tl.navigateToCycle(phase);
		bp.waitForElement();
		String system[]=new String[1];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 12, 2);
		actual[53]=tl.navigateToCycle(system);
		bp.waitForElement();
		String subsystem[]=new String[1];
		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 12, 4);
		actual[54]=tl.navigateToCycle(subsystem);
	   bp.waitForElement();
	   
	   actual[55]=tl.bulkAssignTestcasesSelectedFolder();
	    bp.waitForElement();
	   // String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
	    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
	    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 100, 0);
	    actual[56]=tl.assignAllNotexecuted(lead, Check);
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

	@When("^select Fourth system/bulk assign/assign all notexecuted/assign to lead/seletect subfolder$")
	public void select_Fourth_system_bulk_assign_assign_all_notexecuted_assign_to_lead_seletect_subfolder() throws Throwable 
	{
		try
		{
//		String fourth[]=new String[4];
//		fourth[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 12, 0);
//		fourth[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 12, 2);
//		fourth[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 12, 4);
//		fourth[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 12, 6);
//		actual[55]=tl.navigateToCycle(fourth);
		tl=new TestPlanningPage(driver);
		String phase[]=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 0);
		actual[57]=tl.navigateToCycle(phase);
		bp.waitForElement();
		
		String phase1[]=new String[1];
		phase1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 0);
		tl.navigateToCycle(phase1);
		bp.waitForElement();
		
		String system[]=new String[1];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 12, 2);
		actual[58]= tl.navigateToCycle(system);
		bp.waitForElement();
		
		String subsystem[]=new String[1];
		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 12, 4);
		actual[59]= tl.navigateToCycle(subsystem);
	   bp.waitForElement();
		
		String fourth[]=new String[1];
		fourth[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 12, 6);
		actual[60]=tl.navigateToCycle(fourth);
	   bp.waitForElement();
	   
	   actual[61]=tl.bulkAssignTestcasesSelectedFolder();
	    bp.waitForElement();
	    //String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 2, 0);
	    String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
	    String Check=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 1);
	    actual[62]=tl.assignAllNotexecuted(lead, Check);
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

	@Then("^All the nodes including child nodes testcases should be assigned to test\\.lead$")
	public void all_the_nodes_including_child_nodes_testcases_should_be_assigned_to_test_lead() throws Throwable 
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
