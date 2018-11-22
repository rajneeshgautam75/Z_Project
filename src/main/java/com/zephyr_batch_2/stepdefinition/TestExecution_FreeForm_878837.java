package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_FreeForm_878837 extends LaunchBrowser{
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	ExportPage ep;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	RequirementsPage req;
	
	boolean[] actual=new boolean[310];
	SoftAssert soft=new SoftAssert();

	 String fileName="TestExecution_FreeForm_878837";
	 
	@Given("^Lead is in TestRepository page to create a phase$")
	public void lead_is_in_TestRepository_page_to_create_a_phase() throws Throwable {
		try
		   {
			lb=new LaunchBrowser();
			bp=new BasePage();
		   pp=new ProjectPage(driver);
		   
		  
			pp.clickOnLogout();
			
			lp=new LoginPage(driver);
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
			String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
			lp.enterUname(Uname);
			lp.enterPass(Pass);
			lp.clickOnLogin();
			
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	 bp.waitForElement();
	    	 actual[0]=pp.selectProject(projectName);
	    	 actual[1]=pp.selectRelease(releaseName);
	    	 
	    	 rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[2]=rp.clickOnTestRep(); 
			   
			   tr=new TestRepositoryPage(driver);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 1);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 4);
				
				bp=new BasePage();
				actual[3]=tr.doubleClickOnRelease(releaseName);
				 bp.waitForElement();
				actual[4]=tr.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
				tr.doubleClickOnRelease(releaseName);
				String[] phase=new String[1];
				phase[0]=p_Name1;
				 bp.waitForElement();
				actual[5]=tr.navigateToNode(releaseName, phase);
				tr.addTestCase();
				
				actual[6]=tr.clickDetailButton();
				
				ctc=new CreateTestCasePage(driver);
				String tcName1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 17);
				String tcDesc1=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
				bp.waitForElement();
				actual[7]=ctc.enterTestCaseNameAndDesc(tcName1, tcDesc1);
				bp.waitForElement();
				
				String[] stepDetail1=new String[3];
				stepDetail1[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
				stepDetail1[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				stepDetail1[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[8]=ctc.enterTestCaseStepDetail(stepDetail1);
				bp.waitForElement();
				String Priority1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
				String AltID1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 15);
				String Comment1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 14);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[9]=ctc.enterTestCaseDetails(Priority1, AltID1, Comment1);
				bp.waitForElement();
				
				bp.waitForElement();
				ctc.customFieldOption.click();
				
				String text1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 16);
				String longText1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 100, 100);
				String number1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 100, 100);
				String checkBox1=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
				String pickupList1=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
				String date1=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
				bp.waitForElement();
				actual[10]=ctc.enterCustomFields(text1, longText1, number1, checkBox1, pickupList1, date1);
				bp.waitForElement();
				
				bp.waitForElement();
				String[] tags1=new String[1];
				tags1[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 18);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[11]=ctc.enterMultipletags(tags1);
				bp.waitForElement();
				bp.waitForElement();
				
				actual[12]=tr.clickOnList();
				actual[13]=bp.waitForElement();
			 // bp.waitForElement();
				String[] testcase=new String[1];
				testcase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 ));
				ep=new ExportPage(driver);
				actual[14]=ep.selectMultipleTestCaseFromGrid(testcase);
				bp.waitForElement();
				//actual[14]=tr.selectallTestCase();
				actual[15]=tr.cloneTestCase();
				bp.waitForElement();
				actual[16]=tr.selectallTestCase();
				actual[17]=tr.cloneTestCase();
				bp.waitForElement();
				actual[18]=tr.selectallTestCase();
				actual[19]=tr.cloneTestCase();
				bp.waitForElement();
				actual[20]=tr.selectallTestCase();
				actual[21]=tr.cloneTestCase();
				bp.waitForElement();
				actual[22]=tr.selectallTestCase();
				actual[23]=tr.cloneTestCase();
				bp.waitForElement();
				actual[24]=tr.selectallTestCase();
				actual[25]=tr.cloneTestCase();
				bp.waitForElement();
				actual[26]=tr.selectallTestCase();
				bp.waitForElement();
				actual[27]=tr.cloneTestCase();
				bp.waitForElement();
				/*actual[28]=tr.selectallTestCase();
				bp.waitForElement();
				actual[29]=tr.cloneTestCase();
				bp.waitForElement();
				tr.selectallTestCase();
				bp.waitForElement();
				tr.cloneTestCase();
				bp.waitForElement();
				actual[32]=tr.confirmCloneOperation();
				actual[33]=bp.waitForElement();
				actual[34]=bp.waitForElement();
				actual[35]=bp.waitForElement();
				//actual[33]bp.waitForElement();
//				actual[33]=tr.selectallTestCase();
//				bp.waitForElement();
//				actual[34]=tr.cloneTestCase();
//				bp.waitForElement();
//				actual[35]=tr.confirmCloneOperation();
//				bp.waitForElement();
//				bp.waitForElement();
//				bp.waitForElement();
//				
//				bp.waitForElement();
//				tr.selectallTestCase();
//				bp.waitForElement();
//				bp.waitForElement();
//				tr.selectallTestCase();
				
				/*bp.waitForElement();
				String[] testcase1=new String[24];
				int k1=1;
				for(int i=0;i<=23;i++)
				{
					
					testcase1[i]=Integer.toString(k1);
					k1++;
				}
				ep=new ExportPage(driver);
				actual[36]=ep.selectMultipleTestCaseFromGrid(testcase1);
				bp.waitForElement();
				bp.waitForElement();
				tr.deleteTestCase();
				bp.waitForElement();*/
				
				
		   
		   }
		   catch(Exception e)
			{
			   lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}  
	}

	@When("^User create a system and subsystems upto tenth level and add thousand testcases with all details to each node$")
	public void user_create_a_system_and_subsystems_upto_tenth_level_and_add_thousand_testcases_with_all_details_to_each_node() throws Throwable {
	    try
	    {
	    	bp.waitForElement();//
	    	String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
	    	bp.waitForElement();
			actual[28]=tr.clickOnRelease(releaseName);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 1);
			String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 2);
			String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 5);
			bp.waitForElement();
			actual[29]=tr.selectPhase(p_Name1);
			//bp.waitForElement();
			actual[30]=tr.addNode(s_Name1, s_Desc1);
			String[] str1=new String[2];
			str1[0]=p_Name1;
			str1[1]=s_Name1;
			actual[31]=tr.navigateToNode(releaseName, str1);
			tr.addTestCase();
			bp.waitForElement();
			actual[32]=tr.clickDetailButton();
			
			bp.waitForElement();
			ctc=new CreateTestCasePage(driver);
			String tcName2=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 17);
			String tcDesc2=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
			bp.waitForElement();
			actual[33]=ctc.enterTestCaseNameAndDesc(tcName2, tcDesc2);
			bp.waitForElement();
			
			String[] stepDetail2=new String[3];
			stepDetail2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
			stepDetail2[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
			stepDetail2[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			actual[34]=ctc.enterTestCaseStepDetail(stepDetail2);
			bp.waitForElement();
			
			bp.waitForElement();
			String Priority2=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
			String AltID2=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 15);
			String Comment2=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 14);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			actual[35]=ctc.enterTestCaseDetails(Priority2, AltID2, Comment2);
			bp.waitForElement();
			
			bp.waitForElement();
			ctc.customFieldOption.click();
			
			String text2=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 16);
			String longText2=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 2, 3);
			String number2=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Search_868221", 0, 3));
			String checkBox2=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
			String pickupList2=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
			String date2=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
			bp.waitForElement();
			actual[36]=ctc.enterCustomFields(text2, longText2, number2, checkBox2, pickupList2, date2);
			bp.waitForElement();
			String[] tags2=new String[1];
			tags2[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 18);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			actual[37]=ctc.enterMultipletags(tags2);
			bp.waitForElement();
			actual[38]=tr.clickOnList();
			bp.waitForElement();
			bp.waitForElement();
			actual[39]=tr.selectallTestCase();
			actual[40]=tr.cloneTestCase();
			bp.waitForElement();
			actual[41]=tr.selectallTestCase();
			actual[42]=tr.cloneTestCase();
			bp.waitForElement();
			actual[43]=tr.selectallTestCase();
			actual[44]=tr.cloneTestCase();
			bp.waitForElement();
			actual[45]=tr.selectallTestCase();
			actual[46]=tr.cloneTestCase();
			bp.waitForElement();
			actual[47]=tr.selectallTestCase();
			actual[48]=tr.cloneTestCase();
			bp.waitForElement();
			actual[49]=tr.selectallTestCase();
			actual[50]=tr.cloneTestCase();
			bp.waitForElement();
			actual[51]=tr.selectallTestCase();
			bp.waitForElement();
			actual[52]=tr.cloneTestCase();
			bp.waitForElement();
			/*actual[62]=tr.selectallTestCase();
			bp.waitForElement();
			actual[63]=tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			actual[64]=tr.confirmCloneOperation();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[65]=tr.selectallTestCase();
			bp.waitForElement();
			actual[66]=tr.cloneTestCase();
			bp.waitForElement();
			actual[67]=tr.confirmCloneOperation();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			
			bp.waitForElement();
			tr.selectallTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			bp.waitForElement();
			
			bp.waitForElement();
			String[] testcase2=new String[24];
			int k2=1;
			for(int i=0;i<=23;i++)
			{
				
				testcase2[i]=Integer.toString(k2);
				k2++;
			}
			actual[68]=ep.selectMultipleTestCaseFromGrid(testcase2);
			bp.waitForElement();
			bp.waitForElement();
			tr.deleteTestCase();
			bp.waitForElement();*/
	    	
	    	bp.waitForElement();
	    	  actual[53]=tr.clickOnRelease(releaseName);
		    	 String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 3);
		    	  String ss_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 6);
		    	  actual[54]=tr.selectPhase(s_Name1);
		    	  bp.waitForElement();
		    	  actual[55]=tr.addNode(ss_Name1, ss_Desc1);
		    	 // actual[72]=tr.selectPhase(ss_Name1);
		    	  String[] str2=new String[3];
					str2[0]=p_Name1;
					str2[1]=s_Name1;
					str2[2]=ss_Name1;
					actual[56]=tr.navigateToNode(releaseName, str2);
		    	  tr.addTestCase();
					bp.waitForElement();
					actual[57]=tr.clickDetailButton();
					
					bp.waitForElement();
					ctc=new CreateTestCasePage(driver);
					String tcName3=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 17);
					String tcDesc3=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
					bp.waitForElement();
					actual[58]=ctc.enterTestCaseNameAndDesc(tcName3, tcDesc3);
					bp.waitForElement();
					
					String[] stepDetail4=new String[3];
					stepDetail4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
					stepDetail4[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
					stepDetail4[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
					ctc=new CreateTestCasePage(driver);
					bp.waitForElement();
					actual[59]=ctc.enterTestCaseStepDetail(stepDetail4);
					bp.waitForElement();
					bp.waitForElement();
					String Priority3=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
					String AltID3=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 15);
					String Comment3=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 14);
					ctc=new CreateTestCasePage(driver);
					bp.waitForElement();
					actual[60]=ctc.enterTestCaseDetails(Priority3, AltID3, Comment3);
					bp.waitForElement();
					
					bp.waitForElement();
					ctc.customFieldOption.click();
					
					String text3=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 16);
					String longText3=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 3);
					String number3=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 3);
					String checkBox3=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
					String pickupList3=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
					String date3=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
					bp.waitForElement();
					actual[61]=ctc.enterCustomFields(text3, longText3, number3, checkBox3, pickupList3, date3);
					bp.waitForElement();
					bp.waitForElement();
					String[] tags3=new String[1];
					tags3[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 18);
					ctc=new CreateTestCasePage(driver);
					bp.waitForElement();
					actual[62]=ctc.enterMultipletags(tags3);
					bp.waitForElement();
					actual[63]=tr.clickOnList();
					bp.waitForElement();
					bp.waitForElement();
					tr.selectallTestCase();
					tr.cloneTestCase();
					bp.waitForElement();
					tr.selectallTestCase();
					tr.cloneTestCase();
					bp.waitForElement();
					tr.selectallTestCase();
					tr.cloneTestCase();
					bp.waitForElement();
					tr.selectallTestCase();
					tr.cloneTestCase();
					bp.waitForElement();
					tr.selectallTestCase();
					tr.cloneTestCase();
					bp.waitForElement();
					tr.selectallTestCase();
					tr.cloneTestCase();
					bp.waitForElement();
				    tr.selectallTestCase();
					bp.waitForElement();
					tr.cloneTestCase();
					bp.waitForElement();
					/*actual[94]=tr.selectallTestCase();
					bp.waitForElement();
					actual[95]=tr.cloneTestCase();
					bp.waitForElement();
					bp.waitForElement();
					tr.selectallTestCase();
					bp.waitForElement();
					tr.cloneTestCase();
					bp.waitForElement();
					bp.waitForElement();
					actual[96]=tr.confirmCloneOperation();
					bp.waitForElement();
					bp.waitForElement();
					bp.waitForElement();
					bp.waitForElement();
					actual[97]=tr.selectallTestCase();
					bp.waitForElement();
					actual[100]=tr.cloneTestCase();
					bp.waitForElement();
					actual[101]=tr.confirmCloneOperation();
					bp.waitForElement();
					bp.waitForElement();
					bp.waitForElement();
					
					bp.waitForElement();
					tr.selectallTestCase();
					bp.waitForElement();
					bp.waitForElement();
					tr.selectallTestCase();
					
					bp.waitForElement();
					String[] testcase3=new String[24];
					int k3=1;
					for(int i=0;i<=23;i++)
					{
						
						testcase3[i]=Integer.toString(k3);
						k3++;
					}
					actual[102]=ep.selectMultipleTestCaseFromGrid(testcase3);
					bp.waitForElement();
					bp.waitForElement();
					tr.deleteTestCase();
					bp.waitForElement();*/
					
					
					bp.waitForElement();
					actual[64]=tr.clickOnRelease(releaseName);
String ss_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 2, 3);
String ss_Desc2=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 6);
actual[65]=tr.selectPhase(ss_Name1);
bp.waitForElement();
actual[66]=tr.addNode(ss_Name2, ss_Desc2);
String[] str4=new String[4];
str4[0]=p_Name1;
str4[1]=s_Name1;
str4[2]=ss_Name1;
str4[3]=ss_Name2;
bp.waitForElement();
//actual[61]=tr.addNode(ss_Name2, ss_Desc2);
actual[67]=tr.navigateToNode(releaseName, str4);
//actual[106]=tr.selectPhase(ss_Name2);
tr.addTestCase();
bp.waitForElement();
actual[68]=tr.clickDetailButton();

bp.waitForElement();
ctc=new CreateTestCasePage(driver);
String tcName4=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 17);
String tcDesc4=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
bp.waitForElement();
actual[69]=ctc.enterTestCaseNameAndDesc(tcName4, tcDesc4);
bp.waitForElement();

String[] stepDetail5=new String[3];
stepDetail5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
stepDetail5[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
stepDetail5[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
ctc=new CreateTestCasePage(driver);
bp.waitForElement();
actual[70]=ctc.enterTestCaseStepDetail(stepDetail5);
bp.waitForElement();

bp.waitForElement();
String Priority4=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
String AltID4=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 15);
String Comment4=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 14);
ctc=new CreateTestCasePage(driver);
bp.waitForElement();
actual[71]=ctc.enterTestCaseDetails(Priority4, AltID4, Comment4);
bp.waitForElement();

bp.waitForElement();
ctc.customFieldOption.click();

String text4=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 16);
String longText4=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 2, 3);
String number4=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Search_868221", 0, 3));
String checkBox4=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
String pickupList4=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
String date4=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
bp.waitForElement();
ctc.enterCustomFields(text4, longText4, number4, checkBox4, pickupList4, date4);
bp.waitForElement();
bp.waitForElement();
String[] tags4=new String[1];
tags4[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 18);
ctc=new CreateTestCasePage(driver);
bp.waitForElement();
actual[72]=ctc.enterMultipletags(tags4);
bp.waitForElement();
actual[73]=tr.clickOnList();
bp.waitForElement();
bp.waitForElement();
//bp.waitForElement();
//bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
bp.waitForElement();
tr.cloneTestCase();
bp.waitForElement();
bp.waitForElement();
///*actual[128]=tr.selectallTestCase();
//bp.waitForElement();
//actual[129]=tr.cloneTestCase();
//bp.waitForElement();
//bp.waitForElement();
//tr.selectallTestCase();
//bp.waitForElement();
//bp.waitForElement();
//tr.cloneTestCase();
//bp.waitForElement();
//bp.waitForElement();
//actual[130]=tr.confirmCloneOperation();
//bp.waitForElement();
//bp.waitForElement();
//bp.waitForElement();
//bp.waitForElement();
//actual[131]=tr.selectallTestCase();
//bp.waitForElement();
//actual[132]=tr.cloneTestCase();
//bp.waitForElement();
//actual[133]=tr.confirmCloneOperation();
//bp.waitForElement();
//bp.waitForElement();
//bp.waitForElement();
//
//tr.selectallTestCase();
//bp.waitForElement();
//bp.waitForElement();
//tr.selectallTestCase();
//
//bp.waitForElement();
//String[] testcase4=new String[24];
//int k4=1;
//for(int i=0;i<=23;i++)
//{
//	
//	testcase4[i]=Integer.toString(k4);
//	k4++;
//}
//ep.selectMultipleTestCaseFromGrid(testcase4);
//bp.waitForElement();
//bp.waitForElement();
//tr.deleteTestCase();
//bp.waitForElement();*/
//
bp.waitForElement();
actual[74]=tr.clickOnRelease(releaseName);
String ss_Name3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 3, 3);
String ss_Desc3=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 6);
actual[75]=tr.selectPhase(ss_Name2);
bp.waitForElement();
actual[76]=tr.addNode(ss_Name3, ss_Desc3);
//actual[137]=tr.selectPhase(ss_Name3);
String[] str5=new String[5];
str5[0]=p_Name1;
str5[1]=s_Name1;
str5[2]=ss_Name1;
str5[3]=ss_Name2;
str5[4]=ss_Name3;
actual[77]=tr.navigateToNode(releaseName, str5);
tr.addTestCase();
bp.waitForElement();
actual[78]=tr.clickDetailButton();

bp.waitForElement();
ctc=new CreateTestCasePage(driver);
String tcName5=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 17);
String tcDesc5=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
bp.waitForElement();
actual[79]=ctc.enterTestCaseNameAndDesc(tcName5, tcDesc5);
bp.waitForElement();

String[] stepDetail6=new String[3];
stepDetail6[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
stepDetail6[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
stepDetail6[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
ctc=new CreateTestCasePage(driver);
bp.waitForElement();
actual[80]=ctc.enterTestCaseStepDetail(stepDetail6);
bp.waitForElement();

bp.waitForElement();
String Priority5=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
String AltID5=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 15);
String Comment5=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 14);
ctc=new CreateTestCasePage(driver);
bp.waitForElement();
actual[81]=ctc.enterTestCaseDetails(Priority5, AltID5, Comment5);
bp.waitForElement();


bp.waitForElement();
ctc.customFieldOption.click();

String text5=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 16);
String longText5=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 3);
String number5=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 3);
String checkBox5=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
String pickupList5=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
String date5=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
bp.waitForElement();
actual[82]=ctc.enterCustomFields(text5, longText5, number5, checkBox5, pickupList5, date5);
bp.waitForElement();
String[] tags5=new String[1];
tags5[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 18);
ctc=new CreateTestCasePage(driver);
bp.waitForElement();
actual[83]=ctc.enterMultipletags(tags5);
bp.waitForElement();

actual[84]=tr.clickOnList();
bp.waitForElement();
bp.waitForElement();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
bp.waitForElement();
tr.cloneTestCase();
bp.waitForElement();
/*actual[159]=tr.selectallTestCase();
bp.waitForElement();
actual[160]=tr.cloneTestCase();
bp.waitForElement();
bp.waitForElement();
tr.selectallTestCase();
bp.waitForElement();
bp.waitForElement();
tr.cloneTestCase();
bp.waitForElement();
actual[161]=tr.confirmCloneOperation();
bp.waitForElement();
bp.waitForElement();
bp.waitForElement();
bp.waitForElement();
actual[162]=tr.selectallTestCase();
bp.waitForElement();
actual[163]=tr.cloneTestCase();
bp.waitForElement();
actual[164]=tr.confirmCloneOperation();
bp.waitForElement();
bp.waitForElement();
bp.waitForElement();

tr.selectallTestCase();
bp.waitForElement();
bp.waitForElement();
tr.selectallTestCase();

bp.waitForElement();
String[] testcase5=new String[24];
int k5=1;
for(int i=0;i<=23;i++)
{
	
	testcase5[i]=Integer.toString(k5);
	k5++;
}
ep.selectMultipleTestCaseFromGrid(testcase5);
bp.waitForElement();
bp.waitForElement();
tr.deleteTestCase();
bp.waitForElement();*/

bp.waitForElement();
actual[85]=tr.clickOnRelease(releaseName);
String ss_Name4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 4, 3);
String ss_Desc4=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 6);
actual[86]=tr.selectPhase(ss_Name3);
bp.waitForElement();
actual[87]=tr.addNode(ss_Name4, ss_Desc4);
//actual[168]=tr.selectPhase(ss_Name4);
String[] str6=new String[6];
str6[0]=p_Name1;
str6[1]=s_Name1;
str6[2]=ss_Name1;
str6[3]=ss_Name2;
str6[4]=ss_Name3;
str6[5]=ss_Name4;
actual[88]=tr.navigateToNode(releaseName, str6);
tr.addTestCase();
bp.waitForElement();
actual[89]=tr.clickDetailButton();

bp.waitForElement();
ctc=new CreateTestCasePage(driver);
String tcName6=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 17);
String tcDesc6=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
bp.waitForElement();
actual[90]=ctc.enterTestCaseNameAndDesc(tcName6, tcDesc6);
bp.waitForElement();

String[] stepDetail7=new String[3];
stepDetail7[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
stepDetail7[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
stepDetail7[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
ctc=new CreateTestCasePage(driver);
bp.waitForElement();
actual[91]=ctc.enterTestCaseStepDetail(stepDetail7);
bp.waitForElement();

bp.waitForElement();
String Priority6=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
String AltID6=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 15);
String Comment6=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 14);
ctc=new CreateTestCasePage(driver);
bp.waitForElement();
actual[92]=ctc.enterTestCaseDetails(Priority6, AltID6, Comment6);
bp.waitForElement();


bp.waitForElement();
ctc.customFieldOption.click();

String text6=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 16);
String longText6=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 3);
String number6=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 3);
String checkBox6=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
String pickupList6=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
String date6=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
bp.waitForElement();
actual[93]=ctc.enterCustomFields(text6, longText6, number6, checkBox6, pickupList6, date6);
bp.waitForElement();
String[] tags6=new String[1];
tags6[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 18);
ctc=new CreateTestCasePage(driver);
bp.waitForElement();
actual[94]=ctc.enterMultipletags(tags6);
bp.waitForElement();
actual[95]=tr.clickOnList();
bp.waitForElement();
bp.waitForElement();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
bp.waitForElement();
tr.cloneTestCase();
bp.waitForElement();
/*actual[194]=tr.selectallTestCase();
bp.waitForElement();
actual[195]=tr.cloneTestCase();
bp.waitForElement();
bp.waitForElement();
tr.selectallTestCase();
bp.waitForElement();
bp.waitForElement();
tr.cloneTestCase();
bp.waitForElement();
actual[196]=tr.confirmCloneOperation();
bp.waitForElement();
bp.waitForElement();
bp.waitForElement();
bp.waitForElement();
actual[197]=tr.selectallTestCase();
bp.waitForElement();
actual[198]=tr.cloneTestCase();
bp.waitForElement();
actual[199]=tr.confirmCloneOperation();
bp.waitForElement();
bp.waitForElement();
bp.waitForElement();

tr.selectallTestCase();
bp.waitForElement();
bp.waitForElement();
tr.selectallTestCase();

bp.waitForElement();
String[] testcase6=new String[24];
int k6=1;
for(int i=0;i<=23;i++)
{
	
	testcase6[i]=Integer.toString(k6);
	k6++;
}
ep.selectMultipleTestCaseFromGrid(testcase6);
bp.waitForElement();
bp.waitForElement();
tr.deleteTestCase();
bp.waitForElement();*/

bp.waitForElement();
actual[96]=tr.clickOnRelease(releaseName);
String ss_Name5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 5, 3);
String ss_Desc5=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 6);
actual[97]=tr.selectPhase(ss_Name4);
bp.waitForElement();
actual[98]=tr.addNode(ss_Name5, ss_Desc5);
//actual[203]=tr.selectPhase(ss_Name5);
String[] str7=new String[7];
str7[0]=p_Name1;
str7[1]=s_Name1;
str7[2]=ss_Name1;
str7[3]=ss_Name2;
str7[4]=ss_Name3;
str7[5]=ss_Name4;
str7[6]=ss_Name5;
actual[99]=tr.navigateToNode(releaseName, str7);
tr.addTestCase();
bp.waitForElement();
actual[100]=tr.clickDetailButton();

bp.waitForElement();
ctc=new CreateTestCasePage(driver);
String tcName7=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 17);
String tcDesc7=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
bp.waitForElement();
actual[101]=ctc.enterTestCaseNameAndDesc(tcName7, tcDesc7);
bp.waitForElement();

String[] stepDetail8=new String[3];
stepDetail8[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
stepDetail8[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
stepDetail8[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
ctc=new CreateTestCasePage(driver);
bp.waitForElement();
actual[102]=ctc.enterTestCaseStepDetail(stepDetail8);
bp.waitForElement();

bp.waitForElement();
String Priority7=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
String AltID7=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 15);
String Comment7=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 17);
ctc=new CreateTestCasePage(driver);
bp.waitForElement();
actual[103]=ctc.enterTestCaseDetails(Priority7, AltID7, Comment7);
bp.waitForElement();

bp.waitForElement();
ctc.customFieldOption.click();

String text7=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 16);
String longText7=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 3);
String number7=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 3);
String checkBox7=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
String pickupList7=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
String date7=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
bp.waitForElement();
actual[104]=ctc.enterCustomFields(text7, longText7, number7, checkBox7, pickupList7, date7);

bp.waitForElement();
String[] tags7=new String[1];
tags7[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 18);
ctc=new CreateTestCasePage(driver);
bp.waitForElement();
actual[105]=ctc.enterMultipletags(tags7);
bp.waitForElement();
actual[106]=tr.clickOnList();
bp.waitForElement();
bp.waitForElement();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
bp.waitForElement();
tr.cloneTestCase();
bp.waitForElement();
/*actual[225]=tr.selectallTestCase();
bp.waitForElement();
actual[226]=tr.cloneTestCase();
bp.waitForElement();
bp.waitForElement();
tr.selectallTestCase();
bp.waitForElement();
bp.waitForElement();
tr.cloneTestCase();
bp.waitForElement();
actual[227]=tr.confirmCloneOperation();
bp.waitForElement();
bp.waitForElement();
bp.waitForElement();
bp.waitForElement();
actual[228]=tr.selectallTestCase();
bp.waitForElement();
actual[229]=tr.cloneTestCase();
bp.waitForElement();
actual[230]=tr.confirmCloneOperation();
bp.waitForElement();
bp.waitForElement();
bp.waitForElement();

tr.selectallTestCase();
bp.waitForElement();
bp.waitForElement();
tr.selectallTestCase();

bp.waitForElement();
String[] testcase7=new String[24];
int k7=1;
for(int i=0;i<=23;i++)
{
	
	testcase7[i]=Integer.toString(k7);
	k7++;
}
ep.selectMultipleTestCaseFromGrid(testcase7);
bp.waitForElement();
bp.waitForElement();
tr.deleteTestCase();
bp.waitForElement();*/

bp.waitForElement();
actual[107]=tr.clickOnRelease(releaseName);
String ss_Name6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 6, 3);
String ss_Desc6=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 6);
actual[108]=tr.selectPhase(ss_Name5);
bp.waitForElement();
actual[109]=tr.addNode(ss_Name6, ss_Desc6);
//actual[234]=tr.selectPhase(ss_Name6);
String[] str8=new String[8];
str8[0]=p_Name1;
str8[1]=s_Name1;
str8[2]=ss_Name1;
str8[3]=ss_Name2;
str8[4]=ss_Name3;
str8[5]=ss_Name4;
str8[6]=ss_Name5;
str8[7]=ss_Name6;
actual[110]=tr.navigateToNode(releaseName, str8);
tr.addTestCase();
bp.waitForElement();
actual[111]=tr.clickDetailButton();

bp.waitForElement();
ctc=new CreateTestCasePage(driver);
String tcName8=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 17);
String tcDesc8=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
bp.waitForElement();
actual[112]=ctc.enterTestCaseNameAndDesc(tcName8, tcDesc8);
bp.waitForElement();

String[] stepDetail9=new String[3];
stepDetail9[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
stepDetail9[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
stepDetail9[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
ctc=new CreateTestCasePage(driver);
bp.waitForElement();
actual[113]=ctc.enterTestCaseStepDetail(stepDetail9);
bp.waitForElement();
bp.waitForElement();
String Priority8=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
String AltID8=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 15);
String Comment8=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 14);
ctc=new CreateTestCasePage(driver);
bp.waitForElement();
actual[114]=ctc.enterTestCaseDetails(Priority8, AltID8, Comment8);
bp.waitForElement();

bp.waitForElement();
ctc.customFieldOption.click();

String text8=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 16);
String longText8=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 3);
String number8=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 3);
String checkBox8=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
String pickupList8=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
String date8=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
bp.waitForElement();
actual[115]=ctc.enterCustomFields(text8, longText8, number8, checkBox8, pickupList8, date8);


bp.waitForElement();
String[] tags8=new String[1];
tags8[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 18);
ctc=new CreateTestCasePage(driver);
bp.waitForElement();
actual[116]=ctc.enterMultipletags(tags8);
bp.waitForElement();
actual[117]=tr.clickOnList();
bp.waitForElement();
bp.waitForElement();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
tr.cloneTestCase();
bp.waitForElement();
tr.selectallTestCase();
bp.waitForElement();
tr.cloneTestCase();
bp.waitForElement();
/*actual[256]=tr.selectallTestCase();
bp.waitForElement();
actual[257]=tr.cloneTestCase();
bp.waitForElement();
bp.waitForElement();
tr.selectallTestCase();
bp.waitForElement();
bp.waitForElement();
tr.cloneTestCase();
bp.waitForElement();
actual[258]=tr.confirmCloneOperation();
bp.waitForElement();
bp.waitForElement();
bp.waitForElement();
bp.waitForElement();
actual[259]=tr.selectallTestCase();
bp.waitForElement();
actual[260]=tr.cloneTestCase();
bp.waitForElement();
actual[261]=tr.confirmCloneOperation();
bp.waitForElement();
bp.waitForElement();
bp.waitForElement();

bp.waitForElement();
tr.selectallTestCase();
bp.waitForElement();
bp.waitForElement();
tr.selectallTestCase();

bp.waitForElement();
String[] testcase8=new String[24];
int k8=1;
for(int i=0;i<=23;i++)
{
	
	testcase8[i]=Integer.toString(k8);
	k8++;
}
ep.selectMultipleTestCaseFromGrid(testcase8);
bp.waitForElement();
bp.waitForElement();
tr.deleteTestCase();
bp.waitForElement();*/

bp.waitForElement();
actual[118]=tr.clickOnRelease(releaseName);
String ss_Name7=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 7, 3);
String ss_Desc7=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 6);
actual[119]=tr.selectPhase(ss_Name6);
bp.waitForElement();
actual[120]=tr.addNode(ss_Name7, ss_Desc7);
//actual[265]=tr.selectPhase(ss_Name7);
String[] str9=new String[9];
str9[0]=p_Name1;
str9[1]=s_Name1;
str9[2]=ss_Name1;
str9[3]=ss_Name2;
str9[4]=ss_Name3;
str9[5]=ss_Name4;
str9[6]=ss_Name5;
str9[7]=ss_Name6;
str9[8]=ss_Name7;
actual[121]=tr.navigateToNode(releaseName, str9);
actual[122]=tr.addTestCase();
	bp.waitForElement();
	tr.clickDetailButton();
	
	bp.waitForElement();
	ctc=new CreateTestCasePage(driver);
	String tcName9=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 17);
	String tcDesc9=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
	bp.waitForElement();
	actual[123]=ctc.enterTestCaseNameAndDesc(tcName9, tcDesc9);
	bp.waitForElement();
	
	String[] stepDetail10=new String[3];
	stepDetail10[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
	stepDetail10[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
	stepDetail10[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
	ctc=new CreateTestCasePage(driver);
	bp.waitForElement();
	actual[124]=ctc.enterTestCaseStepDetail(stepDetail10);
	bp.waitForElement();
	
	bp.waitForElement();
	String Priority9=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
	String AltID9=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 15);
	String Comment9=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 14);
	ctc=new CreateTestCasePage(driver);
	bp.waitForElement();
	actual[125]=ctc.enterTestCaseDetails(Priority9, AltID9, Comment9);
	bp.waitForElement();
	
	bp.waitForElement();
	ctc.customFieldOption.click();
	
	String text9=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 16);
	String longText9=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 100);
	String number9=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 3);
	String checkBox9=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
	String pickupList9=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
	String date9=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
	bp.waitForElement();
	actual[126]=ctc.enterCustomFields(text9, longText9, number9, checkBox9, pickupList9, date9);
	
	bp.waitForElement();
	String[] tags9=new String[1];
	tags9[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 18);
	ctc=new CreateTestCasePage(driver);
	bp.waitForElement();
	actual[127]=ctc.enterMultipletags(tags9);
	bp.waitForElement();
	
	actual[128]=tr.clickOnList();
	bp.waitForElement();
	bp.waitForElement();
	bp.waitForElement();
	tr.selectallTestCase();
	tr.cloneTestCase();
	bp.waitForElement();
	tr.selectallTestCase();
	tr.cloneTestCase();
	bp.waitForElement();
	tr.selectallTestCase();
	tr.cloneTestCase();
	bp.waitForElement();
	tr.selectallTestCase();
	tr.cloneTestCase();
	bp.waitForElement();
	tr.selectallTestCase();
	tr.cloneTestCase();
	bp.waitForElement();
	tr.selectallTestCase();
	tr.cloneTestCase();
	bp.waitForElement();
    tr.selectallTestCase();
	bp.waitForElement();
	tr.cloneTestCase();
	bp.waitForElement();
	/*actual[288]=tr.selectallTestCase();
	bp.waitForElement();
	actual[289]=tr.cloneTestCase();
	bp.waitForElement();
	bp.waitForElement();
	bp.waitForElement();
	tr.selectallTestCase();
	bp.waitForElement();
	bp.waitForElement();
	tr.cloneTestCase();
	bp.waitForElement();
	actual[290]=tr.confirmCloneOperation();
	bp.waitForElement();
	bp.waitForElement();
	bp.waitForElement();
	bp.waitForElement();
	actual[291]=tr.selectallTestCase();
	bp.waitForElement();
	actual[292]=tr.cloneTestCase();
	bp.waitForElement();
	actual[293]=tr.confirmCloneOperation();
	bp.waitForElement();
	bp.waitForElement();
	bp.waitForElement();
	
	bp.waitForElement();
	tr.selectallTestCase();
	bp.waitForElement();
	bp.waitForElement();
	tr.selectallTestCase();
	
	bp.waitForElement();
	String[] testcase9=new String[24];
	int k9=1;
	for(int i=0;i<=23;i++)
	{
		
		testcase9[i]=Integer.toString(k9);
		k9++;
	}
	ep.selectMultipleTestCaseFromGrid(testcase9);
	bp.waitForElement();
	bp.waitForElement();
	tr.deleteTestCase();
	bp.waitForElement();*/
	
	bp.waitForElement();
	actual[129]=tr.clickOnRelease(releaseName);
	 String ss_Name8=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 8, 3);
	  String ss_Desc8=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 6);
	  actual[130]=tr.selectPhase(ss_Name7);
	  bp.waitForElement();
	  actual[131]=tr.addNode(ss_Name8, ss_Desc8);
	  //actual[297]=tr.selectPhase(ss_Name8);
	  String[] str10=new String[10];
	  str10[0]=p_Name1;
	  str10[1]=s_Name1;
	  str10[2]=ss_Name1;
	  str10[3]=ss_Name2;
	  str10[4]=ss_Name3;
	  str10[5]=ss_Name4;
	  str10[6]=ss_Name5;
	  str10[7]=ss_Name6;
	  str10[8]=ss_Name7;
	  str10[9]=ss_Name8;
	  actual[132]=tr.navigateToNode(releaseName, str10);
	  tr.addTestCase();
		bp.waitForElement();
		actual[133]=tr.clickDetailButton();
		
		bp.waitForElement();
		ctc=new CreateTestCasePage(driver);
		String tcName10=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 17);
		String tcDesc10=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
		bp.waitForElement();
		actual[134]=ctc.enterTestCaseNameAndDesc(tcName10, tcDesc10);
		bp.waitForElement();
		
		String[] stepDetail11=new String[3];
		stepDetail11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
		stepDetail11[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
		stepDetail11[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[135]=ctc.enterTestCaseStepDetail(stepDetail11);
		bp.waitForElement();
		
		bp.waitForElement();
		String Priority10=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 100, 100);
		String AltID10=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 15);
		String Comment10=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 14);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[136]=ctc.enterTestCaseDetails(Priority10, AltID10, Comment10);
		bp.waitForElement();
		
		bp.waitForElement();
		ctc.customFieldOption.click();
		
		String text10=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 16);
		String longText10=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 3);
		String number10=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 3);
		String checkBox10=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		String pickupList10=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		String date10=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		bp.waitForElement();
		actual[137]=ctc.enterCustomFields(text10, longText10, number10, checkBox10, pickupList10, date10);
		
		bp.waitForElement();
		String[] tags10=new String[1];
		tags10[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 18);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[138]=ctc.enterMultipletags(tags10);
		bp.waitForElement();
		
		
		actual[139]=tr.clickOnList();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		tr.selectallTestCase();
		tr.cloneTestCase();
		bp.waitForElement();
		tr.selectallTestCase();
		tr.cloneTestCase();
		bp.waitForElement();
		tr.selectallTestCase();
		tr.cloneTestCase();
		bp.waitForElement();
		tr.selectallTestCase();
		tr.cloneTestCase();
		bp.waitForElement();
		tr.selectallTestCase();
		tr.cloneTestCase();
		bp.waitForElement();
		tr.selectallTestCase();
		tr.cloneTestCase();
		bp.waitForElement();
	    tr.selectallTestCase();
		bp.waitForElement();
		tr.cloneTestCase();
		bp.waitForElement();
		/*actual[319]=tr.selectallTestCase();
		bp.waitForElement();
		actual[320]=tr.cloneTestCase();
		bp.waitForElement();
		bp.waitForElement();
		tr.selectallTestCase();
		bp.waitForElement();
		bp.waitForElement();
		tr.cloneTestCase();
		bp.waitForElement();
		bp.waitForElement();
		actual[321]=tr.confirmCloneOperation();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		actual[322]=tr.selectallTestCase();
		bp.waitForElement();
		actual[323]=tr.cloneTestCase();
		bp.waitForElement();
		actual[324]=tr.confirmCloneOperation();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		
		bp.waitForElement();
		tr.selectallTestCase();
		bp.waitForElement();
		bp.waitForElement();
		tr.selectallTestCase();
		
		bp.waitForElement();
		String[] testcase10=new String[24];
		int k10=1;
		for(int i=0;i<=23;i++)
		{
			
			testcase10[i]=Integer.toString(k10);
			k10++;
		}
		ep.selectMultipleTestCaseFromGrid(testcase10);
		bp.waitForElement();
		bp.waitForElement();
		tr.deleteTestCase();
		bp.waitForElement();*/
		
		bp.waitForElement();
		actual[140]=tr.clickOnRelease(releaseName);
  	 String ss_Name9=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 9, 3);
  	  String ss_Desc9=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 6);
  	  actual[141]=tr.selectPhase(ss_Name8);
  	  bp.waitForElement();
  	  actual[142]=tr.addNode(ss_Name9, ss_Desc9);
  	  //actual[327]=tr.selectPhase(ss_Name9);
  	String[] str11=new String[11];
	  str11[0]=p_Name1;
	  str11[1]=s_Name1;
	  str11[2]=ss_Name1;
	  str11[3]=ss_Name2;
	  str11[4]=ss_Name3;
	  str11[5]=ss_Name4;
	  str11[6]=ss_Name5;
	  str11[7]=ss_Name6;
	  str11[8]=ss_Name7;
	  str11[9]=ss_Name8;
	  str11[10]=ss_Name9;
	  actual[143]=tr.navigateToNode(releaseName, str11);
  	  tr.addTestCase();
			bp.waitForElement();
			actual[144]=tr.clickDetailButton();
			
			bp.waitForElement();
			ctc=new CreateTestCasePage(driver);
			String tcName11=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 17);
			String tcDesc11=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
			bp.waitForElement();
			actual[145]=ctc.enterTestCaseNameAndDesc(tcName11, tcDesc11);
			bp.waitForElement();
			
			String[] stepDetail12=new String[3];
			stepDetail12[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
			stepDetail12[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
			stepDetail12[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			actual[146]=ctc.enterTestCaseStepDetail(stepDetail12);
			bp.waitForElement();
			
			bp.waitForElement();
			String Priority11=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
			String AltID11=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 15);
			String Comment11=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 14);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			actual[147]=ctc.enterTestCaseDetails(Priority11, AltID11, Comment11);
			bp.waitForElement();
			
			bp.waitForElement();
			ctc.customFieldOption.click();
			
			String text11=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 16);
			String longText11=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 3);
			String number11=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 3);
			String checkBox11=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
			String pickupList11=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
			String date11=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
			bp.waitForElement();
			actual[148]=ctc.enterCustomFields(text11, longText11, number11, checkBox11, pickupList11, date11);
			
			bp.waitForElement();
			String[] tags11=new String[1];
			tags11[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 18);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			actual[149]=ctc.enterMultipletags(tags11);
			bp.waitForElement();
			
			actual[150]=tr.clickOnList();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			bp.waitForElement();
			tr.selectallTestCase();
			tr.cloneTestCase();
			bp.waitForElement();
		    tr.selectallTestCase();
			bp.waitForElement();
			tr.cloneTestCase();
			bp.waitForElement();
			/*actual[349]=tr.selectallTestCase();
			bp.waitForElement();
			actual[350]=tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.cloneTestCase();
			bp.waitForElement();
			bp.waitForElement();
			actual[351]=tr.confirmCloneOperation();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[352]=tr.selectallTestCase();
			bp.waitForElement();
			actual[353]=tr.cloneTestCase();
			bp.waitForElement();
			actual[354]=tr.confirmCloneOperation();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			
			bp.waitForElement();
			tr.selectallTestCase();
			bp.waitForElement();
			bp.waitForElement();
			tr.selectallTestCase();
			
			bp.waitForElement();
			String[] testcase11=new String[24];
			int k11=1;
			for(int i=0;i<=23;i++)
			{
				
				testcase11[i]=Integer.toString(k11);
				k11++;
			}
			ep.selectMultipleTestCaseFromGrid(testcase11);
			bp.waitForElement();
			bp.waitForElement();
			tr.deleteTestCase();
			bp.waitForElement();*/
			
	    	/*bp=new BasePage();
			   pp=new ProjectPage(driver);
			   bp.waitForElement();
		    	pp.clickOnLogout();
		    	bp.waitForElement();
		    	tp=new TestPlanningPage(driver);
		    	tr=new TestRepositoryPage(driver);
		    	exep=new ExecutionPage(driver);
		    	
		    	lp=new LoginPage(driver);
				
				String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
				   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
				   
				   lp.enterUname(Uname);
				   lp.enterPass(Pass);
				   lp.clickOnLogin();
				   
				   pp=new ProjectPage(driver);
				   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
				   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			    	 bp.waitForElement();
			    	 pp.selectProject(projectName);
			    	 pp.selectRelease(releaseName);
					
					bp.waitForElement();
					rp= new ReleasePage(driver);
			        rp.clickOnTestRep();
			        //bp.waitForElement();
	    	
	    	//String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
	    	tp.doubleClickOnCycle(releaseName);
	    	String[] navigation=new String[11];
	    	navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 1);
	    	navigation[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 2);
	    	navigation[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 3);
	    	navigation[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 2, 3);
	    	navigation[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 3, 3);
	    	navigation[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 4, 3);
	    	navigation[6]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 5, 3);
	    	navigation[7]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 6, 3);
	    	navigation[8]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 7, 3);
	    	navigation[9]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 8, 3);
	    	navigation[10]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 9, 3);
	    	bp.waitForElement();
	    	tp.navigateToCycle(navigation);*///
			
			bp.waitForElement();
			actual[151]=tr.clickOnRelease(releaseName);
			 //String ss_Name9=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 9, 3);
	    	 String ss_Name10=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 10, 3);
	    	  String ss_Desc10=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 6);
	    	  actual[152]=tr.selectPhase(ss_Name9);
	    	  bp.waitForElement();
	    	  actual[153]=tr.addNode(ss_Name10, ss_Desc10);
	    	  bp.waitForElement();
	    	  //actual[358]=tr.selectPhase(ss_Name10);
	    	  String[] str12=new String[12];
	    	  str12[0]=p_Name1;
	    	  str12[1]=s_Name1;
	    	  str12[2]=ss_Name1;
	    	  str12[3]=ss_Name2;
	    	  str12[4]=ss_Name3;
	    	  str12[5]=ss_Name4;
	    	  str12[6]=ss_Name5;
	    	  str12[7]=ss_Name6;
	    	  str12[8]=ss_Name7;
	    	  str12[9]=ss_Name8;
	    	  str12[10]=ss_Name9;
	    	  str12[11]=ss_Name10;
	    	  actual[154]=tr.navigateToNode(releaseName, str12);
	    	  tr.addTestCase();
				bp.waitForElement();
				actual[155]=tr.clickDetailButton();
				
				bp.waitForElement();
				ctc=new CreateTestCasePage(driver);
				String tcName12=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 17);
				String tcDesc12=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
				bp.waitForElement();
				actual[156]=ctc.enterTestCaseNameAndDesc(tcName12, tcDesc12);
				
				String[] stepDetail13=new String[3];
				stepDetail13[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
				stepDetail13[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				stepDetail13[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[157]=ctc.enterTestCaseStepDetail(stepDetail13);
				bp.waitForElement();
				bp.waitForElement();
				String Priority12=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
				String AltID12=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 15);
				String Comment12=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 14);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[158]=ctc.enterTestCaseDetails(Priority12, AltID12, Comment12);
				bp.waitForElement();
				
				bp.waitForElement();
				ctc.customFieldOption.click();
				
				String text12=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 16);
				String longText12=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 3);
				String number12=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 3);
				String checkBox12=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
				String pickupList12=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
				String date12=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
				bp.waitForElement();
				actual[159]=ctc.enterCustomFields(text12, longText12, number12, checkBox12, pickupList12, date12);
				
				bp.waitForElement();
				String[] tags12=new String[1];
				tags12[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 18);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[160]=ctc.enterMultipletags(tags12);
				bp.waitForElement();
				
				actual[161]=tr.clickOnList();
				bp.waitForElement();
				bp.waitForElement();
				
				
//				bp=new BasePage();
//				   pp=new ProjectPage(driver);
//				   rp=new ReleasePage(driver);
//				   bp.waitForElement();
//			    	pp.clickOnLogout();
//			    	bp.waitForElement();
//			    	tp=new TestPlanningPage(driver);
//			    	tr=new TestRepositoryPage(driver);
//			    	exep=new ExecutionPage(driver);
//			    	
//			    	lp=new LoginPage(driver);
//					
//					String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
//					   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
//					   
//					   lp.enterUname(Uname);
//					   lp.enterPass(Pass);
//					   lp.clickOnLogin();
//					   
//					   pp=new ProjectPage(driver);
//					  // String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
//					   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
//				    	 bp.waitForElement();
//				    	 pp.selectProject(projectName);
//				    	 pp.selectRelease(releaseName); 
//				    	 
//				    	 rp.clickOnTestRep();
//				    	 bp.waitForElement();
//				    	 
//				    	 String[] navigation=new String[12];
//					    	navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 1);
//					    	navigation[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 2);
//					    	navigation[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 3);
//					    	navigation[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 2, 3);
//					    	navigation[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 3, 3);
//					    	navigation[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 4, 3);
//					    	navigation[6]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 5, 3);
//					    	navigation[7]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 6, 3);
//					    	navigation[8]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 7, 3);
//					    	navigation[9]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 8, 3);
//					    	navigation[10]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 9, 3);
//					    	navigation[11]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 10, 3);
//					    	bp.waitForElement();
//					    	tr.navigateToNode(releaseName, navigation);
//				    	 //

				String[] testcase=new String[1];
				testcase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 ));
				ep=new ExportPage(driver);
				actual[162]=ep.selectMultipleTestCaseFromGrid(testcase);
				bp.waitForElement();
				//actual[365]=tr.selectallTestCase();
				tr.cloneTestCase();
				bp.waitForElement();
				tr.selectallTestCase();
				tr.cloneTestCase();
				bp.waitForElement();
				tr.selectallTestCase();
				tr.cloneTestCase();
				bp.waitForElement();
				tr.selectallTestCase();
				tr.cloneTestCase();
				bp.waitForElement();
				tr.selectallTestCase();
				tr.cloneTestCase();
				bp.waitForElement();
				tr.selectallTestCase();
				tr.cloneTestCase();
				bp.waitForElement();
				tr.selectallTestCase();
				bp.waitForElement();
				tr.cloneTestCase();
				bp.waitForElement();
				/*actual[379]=tr.selectallTestCase();
				bp.waitForElement();
				actual[380]=tr.cloneTestCase();
				bp.waitForElement();
				bp.waitForElement();
				tr.selectallTestCase();
				bp.waitForElement();
				bp.waitForElement();
				tr.cloneTestCase();
				bp.waitForElement();
				bp.waitForElement();
				actual[381]=tr.confirmCloneOperation();
				bp.waitForElement();
				bp.waitForElement();
				bp.waitForElement();
//				bp.waitForElement();
//				actual[382]=tr.selectallTestCase();
//				bp.waitForElement();
//				actual[383]=tr.cloneTestCase();
//				bp.waitForElement();
//				actual[384]=tr.confirmCloneOperation();
//				bp.waitForElement();
//				bp.waitForElement();
//				bp.waitForElement();
				
				bp.waitForElement();
				tr.selectallTestCase();
				bp.waitForElement();
				bp.waitForElement();
				tr.selectallTestCase();
				
				bp.waitForElement();
				String[] testcase12=new String[24];
				int k12=1;
				for(int i=0;i<=23;i++)
				{
					
					testcase12[i]=Integer.toString(k12);
					k12++;
				}
				ep=new ExportPage(driver);
				ep.selectMultipleTestCaseFromGrid(testcase12);
				bp.waitForElement();
				bp.waitForElement();
				tr.deleteTestCase();
				bp.waitForElement();*/
													
			
  }
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
    	Relogin_TPE rl=new Relogin_TPE();
    	rl.reLogin();
    	throw e;
	}	
	    
	}
	
	@When("^User Launch TestPlanning and create a cycle$")
	public void user_Launch_TestPlanning_and_create_a_cycle() throws Throwable {
		try
		   {
			  /*bp=new BasePage();//
			   pp=new ProjectPage(driver);
			   rp=new ReleasePage(driver);
			   bp.waitForElement();
		    	pp.clickOnLogout();
		    	bp.waitForElement();
		    	tp=new TestPlanningPage(driver);
		    	tr=new TestRepositoryPage(driver);
		    	exep=new ExecutionPage(driver);
		    	
		    	lp=new LoginPage(driver);
				
				String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
				   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
				   
				   lp.enterUname(Uname);
				   lp.enterPass(Pass);
				   lp.clickOnLogin();
				   
				   pp=new ProjectPage(driver);
				   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
				   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			    	 bp.waitForElement();
			    	 pp.selectProject(projectName);
			    	 pp.selectRelease(releaseName);// */
			bp=new BasePage();
			bp.waitForElement();
			rp=new ReleasePage(driver);
			actual[163]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[164]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				actual[165]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[166]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[167]=tp.saveTestCycle();
				bp.waitForElement();
		   }
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	    	Relogin_TPE rl=new Relogin_TPE();
	    	rl.reLogin();
	    	throw e;
		}	
	}

	@When("^add freeform phase to cycle and add a node to freeform phase$")
	public void add_freeform_phase_to_cycle_and_add_a_node_to_freeform_phase() throws Throwable {
		try
		{
		String[] cycle1=new String[1];
		cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 0);
		bp.waitForElement();
		actual[168]=tp.navigateToCycle(cycle1);
		
		String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 2, 1);
		bp.waitForElement();
		actual[169]=tp.createFreeFormPhase(phaseName);
		bp.waitForElement();
		
		String[] cycle11=new String[1];
		cycle11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 2, 1);
		actual[170]=tp.navigateToCycle(cycle11);
		
		String systemName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 2, 2);
		String systemDesc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 5);
		bp.waitForElement();
		actual[171]=tp.addNode(systemName1, systemDesc1);
		bp.waitForElement();
		//pp.clickOnLogout();
		//bp.waitForElement();
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	    	Relogin_TPE rl=new Relogin_TPE();
	    	rl.reLogin();
	    	throw e;
		}	
	}

	@When("^User add testcases to freeform phase using advanced search and set page size to twenty five and select pagination to six$")
	public void user_add_testcases_to_freeform_phase_using_advanced_search_and_set_page_size_to_twenty_five_and_select_pagination_to_six() throws Throwable {
	   try
	   {
		   String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",2 ,1 );
		     bp.waitForElement();
		     tp=new TestPlanningPage(driver);
		     actual[172]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[173]=tp.clickOnAddTestcasesToFreeForm();
		     
		 	bp.waitForElement();
		    actual[174]=tp.clickOnAdvanceSearch();
		    
		    String name1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",10 ,0 );
		    	String operator1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",11 ,1 );
		    	String value1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",2 ,17 );//summary only
		    	bp.waitForElement();
		    	actual[175]=tp.ZQLSearch1(name1, operator1, value1);
		    	actual[176]=tp.validateSearch();
		    	bp.waitForElement();
		    	actual[177]=tp.selectAllFreeFormTestCases();
			     bp.waitForElement();
			     
			     bp.waitForElement();
			     actual[178]=tp.clickOnSaveAndOk();
			     
			     bp.waitForElement();
			 	actual[179]=tp.closeFreeFormPage();
			 	bp.waitForElement();
		    
		    	//altid only
			 	String[] cycleName2=new String[1];
			     cycleName2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",2 ,1 );
			     bp.waitForElement();
			     actual[180]=tp.navigateToCycle(cycleName2);
			     
			     bp.waitForElement();
			     actual[181]=tp.clickOnAddTestcasesToFreeForm();

			     bp.waitForElement();
			     actual[182]=tp.clickOnAdvanceSearch();
		    	
		    	String name2=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",13 ,0 );
		    	String operator2=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",11 ,1 );
		    	String value2=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",2 ,15 );
		    	bp.waitForElement();
		    	actual[183]=tp.ZQLSearch1(name2, operator2, value2);
		    	actual[184]=tp.validateSearch();
		    	bp.waitForElement();
		    	actual[185]=tp.selectAllFreeFormTestCases();
			     bp.waitForElement();
			     //tp.clickOnCheckBoxSaveAllTestcases();
			     
			     bp.waitForElement();
			     actual[186]=tp.clickOnSaveAndOk();
			     
			     bp.waitForElement();
			 	actual[187]=tp.closeFreeFormPage();
			 	bp.waitForElement();
		    	
		    	//customtext only
			 	String[] cycleName3=new String[1];
			     cycleName3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",2 ,1 );
			     bp.waitForElement();
			     actual[188]=tp.navigateToCycle(cycleName3);
			     
			     bp.waitForElement();
			     actual[189]=tp.clickOnAddTestcasesToFreeForm();
			     
			     bp.waitForElement();
			     actual[190]=tp.clickOnAdvanceSearch();
		    	String name3=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",16 ,0 );
		    	String operator3=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",11 ,1 );
		    	String value3=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",2 ,16 );
		    	bp.waitForElement();
		    	actual[191]=tp.ZQLSearch1(name3, operator3, value3);
		    	actual[192]=tp.validateSearch();
		    	bp.waitForElement();
		    	actual[193]=tp.selectAllFreeFormTestCases();
			     bp.waitForElement();
			     
			     actual[194]=tp.clickOnSaveAndOk();
			     bp.waitForElement();
		    	actual[195]=tp.closeFreeFormPage();
		    	bp.waitForElement();
		    	
		    	//Comment Only
		    	String[] cycleName4=new String[1];
			     cycleName4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",2 ,1 );
			     bp.waitForElement();
			     actual[196]=tp.navigateToCycle(cycleName4);
			     
			     bp.waitForElement();
			     actual[197]=tp.clickOnAddTestcasesToFreeForm();
			     bp.waitForElement();
			     actual[198]=tp.clickOnAdvanceSearch();
		    	String name4=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",12 ,0 );
		    	String operator4=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",11 ,1 );
		    	String value4=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",2 ,14 );
		    	bp.waitForElement();
		    	actual[199]=tp.ZQLSearch1(name4, operator4, value4);
		    	actual[200]=tp.validateSearch();
		    	bp.waitForElement();
		    	actual[201]=tp.selectAllFreeFormTestCases();
			     
			     bp.waitForElement();
			     actual[202]=tp.clickOnSaveAndOk();
			     bp.waitForElement();
		    	actual[203]=tp.closeFreeFormPage();
		    	bp.waitForElement();
		    	
		    	
		    	String[] cycleName5=new String[1];
			     cycleName5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",2 ,1 );
			     bp.waitForElement();
			     actual[204]=tp.navigateToCycle(cycleName5);
			     
			     bp.waitForElement();
			     actual[205]=tp.clickOnAddTestcasesToFreeForm();
			     bp.waitForElement();
			     actual[206]=tp.clickOnAdvanceSearch();
		    	String name5=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,0 );
		    	String operator5=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,1 );
		    	String value5=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",2 ,18 );//tag only
		    	bp.waitForElement();
		    	actual[207]=tp.ZQLSearch1(name5, operator5, value5);
		    	actual[208]=tp.validateSearch();
		    	bp.waitForElement();
		    	actual[209]=tp.selectAllFreeFormTestCases();
			     bp.waitForElement();
			     
			     bp.waitForElement();
			     actual[210]=tp.clickOnSaveAndOk();
			     bp.waitForElement();
		    	 tp.closeFreeFormPage();
		    	bp.waitForElement();
		    	
		    	 bp.waitForElement();
			     actual[211]=tp.clickOnAddTestcasesToFreeForm();
			     
			     bp.waitForElement();
			    	actual[212]=tp.clickOnBrowse();
			    
			    	bp.waitForElement();
			    	tr=new TestRepositoryPage(driver);
			    	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
			    	bp.waitForElement();
			    	tp.doubleClickOnCycle(releaseName);
			    	bp.waitForElement();
			    	
			    	String[] nodes=new String[12];
			    	nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 1);
			    	nodes[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 2);
			    	nodes[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 3);
			    	nodes[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 2, 3);
			    	nodes[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 3, 3);
			    	nodes[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 4, 3);
			    	nodes[6]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 5, 3);
			    	nodes[7]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 6, 3);
			    	nodes[8]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 7, 3);
			    	nodes[9]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 8, 3);
			    	nodes[10]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 9, 3);
			    	nodes[11]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 10, 3);
			    	tr=new TestRepositoryPage(driver);
			    	bp.waitForElement();
			    	bp.waitForElement();
			    	bp.waitForElement();
			    	bp.waitForElement();
			    	tr.navigateNode(nodes);
			    	bp.waitForElement();
			    	
			    	tr=new TestRepositoryPage(driver);
					   String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 4, 3);
					   bp.waitForElement();
					   actual[213]=tr.selectPhase(p_Name1);
					   String NodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",4 ,3 );
					   actual[214]=tp.clickOnChecKBox(NodeName);
					   bp.waitForElement();
					   
					   actual[215]=tp.clickOnSaveAndOk();
					   bp.waitForElement();
					   
					   actual[216]=tp.closeFreeFormPage();
					   bp.waitForElement();  ////
					   bp.waitForElement(); 
					tp.selectallTestCase();
					bp.waitForElement();
					String assignee6=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
					tp.assignAllSelected(assignee6);
				    bp.waitForElement();
					   
					   pp=new ProjectPage(driver);
					   bp=new BasePage();
					   pp.clickOnLogout();
					   bp.waitForElement();
					  /* bp.waitForElement();
					     actual[217]=tp.clickOnAddTestcasesToFreeForm();
					     
					     bp.waitForElement();
					     actual[218]=tp.launchOtherCycles();
					     
					     
					     bp.waitForElement();
					     String cyclename1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",1 ,0 );
					     String Build1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,0 );
					     String Environment1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,0 );
					     bp.waitForElement();
					     actual[219]=tp.selectCycleInSearch(cyclename1, Build1, Environment1);
					     
					     bp.waitForElement();
					     String PhaseName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",1 ,1 );
					     actual[220]=tp.selectPhaseInSearch(PhaseName1);
					     bp.waitForElement();
					     
					     String Status1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
					     actual[221]=tp.filterByStatus(Status1);
					     
					     actual[222]=tp.clickOnGo();
					     
					     actual[223]=tp.validateRetrieveTestcases();
					     bp.waitForElement();
					     
					     actual[224]=tp.clickOnMaintainassignmentsoforiginalschedules();
					     bp.waitForElement();
					     
					     actual[225]=tp.selectAllFreeFormTestCases();
					     bp.waitForElement();
					     
					     actual[226]=tp.clickOnSaveAndOk();
					     bp.waitForElement();
					     
					     actual[227]=tp.closeFreeFormPage();
					     bp.waitForElement();
					     
					     actual[228]=tp.validateAddtestcaesToFreeForm();
					     bp.waitForElement();
					     
					     bp.waitForElement();
					     actual[229]=tp.clickOnAddTestcasesToFreeForm();
					     
					     bp.waitForElement();
					     actual[230]=tp.launchOtherCycles();
					     
					     bp.waitForElement();
					     String cyclename2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",1 ,0 );
					     String Build2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,0 );
					     String Environment2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,0 );
					     bp.waitForElement();
					     actual[231]=tp.selectCycleInSearch(cyclename2, Build2, Environment2);
					     
					     bp.waitForElement();
					     String PhaseName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",1 ,1 );
					     actual[232]=tp.selectPhaseInSearch(PhaseName2);
					     bp.waitForElement();
					     
					     String Status2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
					     actual[233]=tp.filterByStatus(Status2);
					     
					     actual[238]=tp.clickOnGo();
					     
					     actual[239]=tp.validateRetrieveTestcases();
					     bp.waitForElement();
					     
					     actual[240]=tp.clickOnMaintainassignmentsoforiginalschedules();
					     bp.waitForElement();
					     
					     actual[241]=tp.selectAllFreeFormTestCases();
					     bp.waitForElement();
					     
					     actual[243]=tp.clickOnSaveAndOk();
					     bp.waitForElement();
					     
					     actual[244]=tp.closeFreeFormPage();
					     bp.waitForElement();
					     
					     
					     actual[245]=tp.validateAddtestcaesToFreeForm();
					     bp.waitForElement();
					     
					     bp.waitForElement();
					     actual[246]=tp.clickOnAddTestcasesToFreeForm();
					     
					     bp.waitForElement();
					     actual[247]=tp.launchOtherCycles();
					     
					     bp.waitForElement();
					     String cyclename3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",1 ,0 );
					     String Build3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,0 );
					     String Environment3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,0 );
					     actual[248]=tp.selectCycleInSearch(cyclename3, Build3, Environment3);
					     bp.waitForElement();
					     
					     bp.waitForElement();
					     String PhaseName3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",1 ,1 );
					     actual[249]=tp.selectPhaseInSearch(PhaseName3);
					     bp.waitForElement();
					     
					     String Status3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
					     actual[250]=tp.filterByStatus(Status3);
					     
					     actual[251]=tp.clickOnGo();
					     
					     actual[252]=tp.validateRetrieveTestcases();
					     bp.waitForElement();
					     
					     actual[253]=tp.clickOnMaintainassignmentsoforiginalschedules();
					     bp.waitForElement();
					     
					     actual[254]=tp.selectAllFreeFormTestCases();
					     bp.waitForElement();
					     
					     actual[255]=tp.clickOnSaveAndOk();
					     bp.waitForElement();
					     
					     actual[256]=tp.closeFreeFormPage();
					     bp.waitForElement();
					     
					     actual[257]=tp.validateAddtestcaesToFreeForm();
					     bp.waitForElement();
					     
					     bp.waitForElement();
					     actual[258]=tp.clickOnAddTestcasesToFreeForm();
					     
					     bp.waitForElement();
					     actual[259]=tp.launchOtherCycles();
					     
					     bp.waitForElement();
					     String cyclename4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",1 ,0 );
					     String Build4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,0 );
					     String Environment4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,0 );
					     actual[260]=tp.selectCycleInSearch(cyclename4, Build4, Environment4);
					     bp.waitForElement();
					     
					     bp.waitForElement();
					     String PhaseName4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",1 ,1 );
					     actual[261]=tp.selectPhaseInSearch(PhaseName4);
					     bp.waitForElement();
					     
					     String Status4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
					     actual[262]=tp.filterByStatus(Status4);
					     
					     actual[263]=tp.clickOnGo();
					     
					     actual[264]=tp.validateRetrieveTestcases();
					     bp.waitForElement();
					     
					     actual[265]=tp.clickOnMaintainassignmentsoforiginalschedules();
					     bp.waitForElement();
					     
					     actual[266]=tp.selectAllFreeFormTestCases();
					     bp.waitForElement();
					     
					     actual[267]=tp.clickOnSaveAndOk();
					     bp.waitForElement();
					     
					     actual[268]=tp.closeFreeFormPage();
					     bp.waitForElement();
					     
					     actual[269]=tp.validateAddtestcaesToFreeForm();
					     bp.waitForElement();
						
					     
					    /* bp.waitForElement();
					     actual[484]=tp.clickOnAddTestcasesToFreeForm();
					     
					     bp.waitForElement();
					     actual[485]=tp.launchOtherCycles();
					     
					     bp.waitForElement();
					     String cyclename5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",1 ,0 );
					     String Build5=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,0 );
					     String Environment5=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,0 );
					     actual[486]=tp.selectCycleInSearch(cyclename5, Build5, Environment5);
					     bp.waitForElement();
					     
					     bp.waitForElement();
					     String PhaseName5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",1 ,1 );
					     actual[376]=tp.selectPhaseInSearch(PhaseName5);
					     bp.waitForElement();
					     
					     String Status5=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,18 );
					     actual[377]=tp.filterByStatus(Status5);
					     
					     actual[378]=tp.clickOnGo();
					     
					     actual[379]=tp.validateRetrieveTestcases();
					     bp.waitForElement();
					     
					     actual[380]=tp.clickOnMaintainassignmentsoforiginalschedules();
					     bp.waitForElement();
					     
					     actual[381]=tp.selectAllFreeFormTestCases();
					     bp.waitForElement();
					     
					     actual[382]=tp.clickOnSaveAndOk();
					     bp.waitForElement();
					     
					     actual[389]=tp.closeFreeFormPage();
					     bp.waitForElement();
					     
					     actual[390]=tp.validateAddtestcaesToFreeForm();
					     bp.waitForElement();
					     
					     
					     bp.waitForElement();
					     actual[391]=tp.clickOnAddTestcasesToFreeForm();
					     
					     bp.waitForElement();
					     actual[392]=tp.launchOtherCycles();
					     
					     bp.waitForElement();
					     String cyclename6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",1 ,0 );
					     String Build6=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,0 );
					     String Environment6=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,0 );
					     actual[393]=tp.selectCycleInSearch(cyclename6, Build6, Environment6);
					     
					     bp.waitForElement();
					     String PhaseName6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",1 ,1 );
					     actual[394]=tp.selectPhaseInSearch(PhaseName6);
					     bp.waitForElement();
					     
					     String Status6=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",8 ,18 );
					     actual[395]=tp.filterByStatus(Status6);
					     
					     actual[396]=tp.clickOnGo();
					     
					     actual[397]=tp.validateRetrieveTestcases();
					     bp.waitForElement();
					     
					     actual[398]=tp.clickOnMaintainassignmentsoforiginalschedules();
					     bp.waitForElement();
					     
					     actual[399]=tp.selectAllFreeFormTestCases();
					     bp.waitForElement();
					     
					     actual[400]=tp.clickOnSaveAndOk();
					     bp.waitForElement();
					     
					     actual[401]=tp.closeFreeFormPage();
					     bp.waitForElement();
					     
					     actual[402]=tp.validateAddtestcaesToFreeForm();
					     bp.waitForElement();*/
		    	
		    	/*bp.waitForElement(); ////
		    	tp.validateAddtestcaesToFreeForm();
		    	
		    	String[] cycleName6=new String[1];
			     cycleName6[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",2 ,1 );
			     bp.waitForElement();
			     actual[270]=tp.navigateToCycle(cycleName6);
		    	
		    	bp.waitForElement();
		    	tp.selectallTestCase();
		    	bp.waitForElement();
		   
		    	String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,9 );
		    	tp.assignAllSelected(assignee);
		    	bp.waitForElement();
		    	
		    	pp.clickOnLogout();
		    	bp.waitForElement();*/ ////
		    	
		        /*bp=new BasePage();// /* remove
		        pp=new ProjectPage(driver);
		        exep=new ExecutionPage(driver);
		        pp.clickOnLogout();
		        tp=new TestPlanningPage(driver); // */
		        
		    	
		    	lp=new LoginPage(driver);
				
				String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Username_1");
				   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Password_1");
				   
				   lp.enterUname(Uname);
				   lp.enterPass(Pass);
				   lp.clickOnLogin();
				   bp=new BasePage();
				   
				   pp=new ProjectPage(driver);
				   //String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
				   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			    	 bp.waitForElement();
			    	 pp.selectProject(projectName);
			    	 pp.selectRelease(releaseName);
				
				   bp.waitForElement();
					rp= new ReleasePage(driver);
					bp.waitForElement();
					   rp.clickOnTestExecution(); 
					   bp.waitForElement();
					   
					   String[] cycleName1=new String[3];
					    cycleName1[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
					    cycleName1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",1 ,0 );
					    cycleName1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",2 ,1 );
					    
					    bp.waitForElement();
					    tp=new TestPlanningPage(driver);
					    bp.waitForElement();
					    bp.waitForElement();
					    bp.waitForElement();
						tp.navigateToCycle(cycleName1);
						bp.waitForElement();
		    	
						bp=new BasePage();
						int[] tcNo1=new int[1];
						tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
					    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
					    bp.waitForElement();
					    bp.waitForElement();
					    exep=new ExecutionPage(driver);
					    actual[217]=exep.executeStatus(tcNo1[0], statusType1);
					    bp.waitForElement();
					    
					    int[] tcNo2=new int[1];
						tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
					    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
					    bp.waitForElement();
					    bp.waitForElement();
					    exep=new ExecutionPage(driver);
					    actual[218]=exep.executeStatus(tcNo2[0], statusType2);
					    bp.waitForElement();
					    
					    int[] tcNo3=new int[1];
						tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
					    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,18 );
					    bp.waitForElement();
					    bp.waitForElement();
					    exep=new ExecutionPage(driver);
					    actual[219]=exep.executeStatus(tcNo3[0], statusType3);
					    bp.waitForElement();
					    
					    int[] tcNo4=new int[1];
						tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
					    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
					    bp.waitForElement();
					    bp.waitForElement();
					    exep=new ExecutionPage(driver);
					    actual[220]=exep.executeStatus(tcNo4[0], statusType4);
					    bp.waitForElement();
					    
					    
					    int[] tcNo5=new int[1];
						tcNo5[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5 ,19 );
					    String statusType5=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",8 ,18 );
					    bp.waitForElement();
					    bp.waitForElement();
					    exep=new ExecutionPage(driver);
					    actual[221]=exep.executeStatus(tcNo5[0], statusType5);
					    bp.waitForElement();
					    
					    pp.clickOnLogout();
					    bp.waitForElement();
	   }
	   catch(Exception e)
		{
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	    	Relogin_TPE rl=new Relogin_TPE();
	    	rl.reLogin();
	    	throw e;
		}	
	}

	@When("^User add testcases to freeform phase using browse option,expands nodes and set page size to hundred and select pagination to six$")
	public void user_add_testcases_to_freeform_phase_using_browse_option_expands_nodes_and_set_page_size_to_hundred_and_select_pagination_to_six() throws Throwable {
	 try
	 {
		 /*bp=new BasePage(); // /*
	    	pp=new ProjectPage(driver);
	    	pp.clickOnLogout();
	    	bp.waitForElement();
	    	tp=new TestPlanningPage(driver);
	    	exep=new ExecutionPage(driver); //*/
		   
		 lp=new LoginPage(driver);
			
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
			   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
			   
			   lp.enterUname(Uname);
			   lp.enterPass(Pass);
			   lp.clickOnLogin();
			   bp=new BasePage();
			   
			   pp=new ProjectPage(driver);
			   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		    	 bp.waitForElement();
		    	 pp.selectProject(projectName);
		    	 bp.waitForElement();
		    	 pp.selectRelease(releaseName);
		    	 
					rp= new ReleasePage(driver);
					tp=new TestPlanningPage(driver);
					bp.waitForElement();
					actual[222]=rp.clickOnTestPlanning();
					bp.waitForElement();
					   
					   String[] cycleName1=new String[2];
					     cycleName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",1 ,0 );
					     cycleName1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",2 ,1 );
					     bp.waitForElement();
					     tp.doubleClickOnCycle(cycleName1[0]);
					     bp.waitForElement();
					     actual[223]=tp.navigateToCycle(cycleName1);
					     
					     actual[224]=tp.assignPhase();
					     
					     actual[225]=tp.doubleClickOnCycle(cycleName1[1]);
		 
		 bp.waitForElement();
	     actual[226]=tp.clickOnAddTestcasesToFreeForm();
	     
	     bp.waitForElement();
	    	actual[227]=tp.clickOnBrowse();
	    	
	    	//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
	    	tp.doubleClickOnCycle(releaseName);
	    	
	    	String[] nodes=new String[12];
	    	nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 1);
	    	nodes[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 2);
	    	nodes[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 1, 3);
	    	nodes[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 2, 3);
	    	nodes[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 3, 3);
	    	nodes[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 4, 3);
	    	nodes[6]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 5, 3);
	    	nodes[7]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 6, 3);
	    	nodes[8]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 7, 3);
	    	nodes[9]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 8, 3);
	    	nodes[10]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 9, 3);
	    	nodes[11]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 10, 3);
	    	tr=new TestRepositoryPage(driver);
	    	bp.waitForElement();
	    	actual[228]=tr.navigateNode(nodes);
	    	
	    	tr=new TestRepositoryPage(driver);
			   String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837", 4, 3);
			   bp.waitForElement();
			   actual[229]=tr.selectPhase(p_Name1);
			   String NodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",4 ,3 );
			   actual[230]=tp.clickOnChecKBox(NodeName);
			   bp.waitForElement();
			   
			   actual[231]=tp.clickOnSaveAndOk();
			   bp.waitForElement();
			   
			   actual[232]=tp.closeFreeFormPage();
			   bp.waitForElement();
			   
			   
	    	
	 }
	 catch(Exception e)
		{
		 lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	    	Relogin_TPE rl=new Relogin_TPE();
	    	rl.reLogin();
	    	throw e;
		}	
	}

	@When("^User add testcases to freeform phase using other cycle,select page size to ten and select pagination to two$")
	public void user_add_testcases_to_freeform_phase_using_other_cycle_select_page_size_to_ten_and_select_pagination_to_two() throws Throwable {
		try
		{
			/*lp=new LoginPage(driver); ////
			
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
			   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
			   
			   lp.enterUname(Uname);
			   lp.enterPass(Pass);
			   lp.clickOnLogin();
			   
			   pp=new ProjectPage(driver);
			   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		    	 bp.waitForElement();
		    	 pp.selectProject(projectName);
		    	 pp.selectRelease(releaseName);
			
			   bp.waitForElement();
				rp= new ReleasePage(driver);
				bp.waitForElement();
				   rp.clickOnTestPlanning();
				   bp.waitForElement();
				   
				   String[] cycleName1=new String[2];
				     cycleName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",1 ,0 );
				     cycleName1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",2 ,1 );
				     bp.waitForElement();
				     tp.doubleClickOnCycle(cycleName1[0]);
				     bp.waitForElement();
				     actual[319]=tp.navigateToCycle(cycleName1); //// */
			bp=new BasePage();
			tp=new TestPlanningPage(driver);
			
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",2 ,1 );
			tp.doubleClickOnCycle(phaseName);
		 bp.waitForElement();
	     actual[233]=tp.clickOnAddTestcasesToFreeForm();
	     
	     bp.waitForElement();
	     actual[234]=tp.launchOtherCycles();
	     
	     
	     bp.waitForElement();
	     String cyclename1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",1 ,0 );
	     String Build1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,0 );
	     String Environment1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,0 );
	     bp.waitForElement();
	     actual[235]=tp.selectCycleInSearch(cyclename1, Build1, Environment1);
	     
	     bp.waitForElement();
	     String PhaseName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",2 ,1 );
	     actual[236]=tp.selectPhaseInSearch(PhaseName1);
	     bp.waitForElement();
	     
	     String Status1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
	     actual[237]=tp.filterByStatus(Status1);
	     
	     actual[238]=tp.clickOnGo();
	     
	     actual[239]=tp.validateRetrieveTestcases();
	     bp.waitForElement();
	     
	     actual[240]=tp.clickOnMaintainassignmentsoforiginalschedules();
	     bp.waitForElement();
	     
	     actual[241]=tp.selectAllFreeFormTestCasesPhase();
	     bp.waitForElement();
	     
	     actual[242]=tp.clickOnSaveAndOk();
	     bp.waitForElement();
	     
	     actual[243]=tp.closeFreeFormPage();
	     bp.waitForElement();
	     
	     actual[244]=tp.validateAddtestcaesToFreeForm();
	     bp.waitForElement();
	     
	     bp.waitForElement();
	     actual[245]=tp.clickOnAddTestcasesToFreeForm();
	     
	     bp.waitForElement();
	     actual[246]=tp.launchOtherCycles();
	     
	     bp.waitForElement();
	     String cyclename2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",1 ,0 );
	     String Build2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,0 );
	     String Environment2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,0 );
	     bp.waitForElement();
	     actual[247]=tp.selectCycleInSearch(cyclename2, Build2, Environment2);
	     
	     bp.waitForElement();
	     String PhaseName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",2 ,1 );
	     actual[248]=tp.selectPhaseInSearch(PhaseName2);
	     bp.waitForElement();
	     
	     String Status2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
	     actual[249]=tp.filterByStatus(Status2);
	     
	     actual[250]=tp.clickOnGo();
	     
	     actual[251]=tp.validateRetrieveTestcases();
	     bp.waitForElement();
	     
	     actual[252]=tp.clickOnMaintainassignmentsoforiginalschedules();
	     bp.waitForElement();
	     
	     actual[253]=tp.selectAllFreeFormTestCasesPhase();
	     bp.waitForElement();
	     
	     actual[254]=tp.clickOnSaveAndOk();
	     bp.waitForElement();
	     
	     actual[255]=tp.closeFreeFormPage();
	     bp.waitForElement();
	     
	     
	     actual[256]=tp.validateAddtestcaesToFreeForm();
	     bp.waitForElement();
	     
	     bp.waitForElement();
	     actual[257]=tp.clickOnAddTestcasesToFreeForm();
	     
	     bp.waitForElement();
	     actual[258]=tp.launchOtherCycles();
	     
	     bp.waitForElement();
	     String cyclename3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",1 ,0 );
	     String Build3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,0 );
	     String Environment3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,0 );
	     actual[259]=tp.selectCycleInSearch(cyclename3, Build3, Environment3);
	     bp.waitForElement();
	     
	     bp.waitForElement();
	     String PhaseName3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",2 ,1 );
	     actual[260]=tp.selectPhaseInSearch(PhaseName3);
	     bp.waitForElement();
	     
	     String Status3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
	     actual[261]=tp.filterByStatus(Status3);
	     
	     actual[262]=tp.clickOnGo();
	     
	     actual[263]=tp.validateRetrieveTestcases();
	     bp.waitForElement();
	     
	     actual[264]=tp.clickOnMaintainassignmentsoforiginalschedules();
	     bp.waitForElement();
	     
	     actual[265]=tp.selectAllFreeFormTestCasesPhase();
	     bp.waitForElement();
	     
	     actual[266]=tp.clickOnSaveAndOk();
	     bp.waitForElement();
	     
	     actual[267]=tp.closeFreeFormPage();
	     bp.waitForElement();
	     
	     actual[268]=tp.validateAddtestcaesToFreeForm();
	     bp.waitForElement();
	     
	     bp.waitForElement();
	     tp.clickOnAddTestcasesToFreeForm();
	     
	     bp.waitForElement();
	     tp.launchOtherCycles();
	     
	     bp.waitForElement();
	     String cyclename4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",1 ,0 );
	     String Build4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,0 );
	     String Environment4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,0 );
	     actual[269]=tp.selectCycleInSearch(cyclename4, Build4, Environment4);
	     bp.waitForElement();
	     
	     bp.waitForElement();
	     String PhaseName4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",2 ,1 );
	     actual[270]=tp.selectPhaseInSearch(PhaseName4);
	     bp.waitForElement();
	     
	     String Status4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
	     actual[271]=tp.filterByStatus(Status4);
	     
	     actual[272]=tp.clickOnGo();
	     
	     actual[273]=tp.validateRetrieveTestcases();
	     bp.waitForElement();
	     
	     actual[274]=tp.clickOnMaintainassignmentsoforiginalschedules();
	     bp.waitForElement();
	     
	     actual[275]=tp.selectAllFreeFormTestCasesPhase();
	     bp.waitForElement();
	     
	     actual[276]=tp.clickOnSaveAndOk();
	     bp.waitForElement();
	     
	     tp.closeFreeFormPage();
	     bp.waitForElement();
	     
	     actual[277]=tp.validateAddtestcaesToFreeForm();
	     bp.waitForElement();
		
	     
	     bp.waitForElement();
	     actual[278]=tp.clickOnAddTestcasesToFreeForm();
	     
	     bp.waitForElement();
	     actual[279]=tp.launchOtherCycles();
	     
	     bp.waitForElement();
	     String cyclename5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",1 ,0 );
	     String Build5=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,0 );
	     String Environment5=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,0 );
	     actual[280]=tp.selectCycleInSearch(cyclename5, Build5, Environment5);
	     bp.waitForElement();
	     
	     bp.waitForElement();
	     String PhaseName5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",2 ,1 );
	     actual[281]=tp.selectPhaseInSearch(PhaseName5);
	     bp.waitForElement();
	     
	     String Status5=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
	     actual[282]=tp.filterByStatus(Status5);
	     
	     actual[283]=tp.clickOnGo();
	     
	     actual[284]=tp.validateRetrieveTestcases();
	     bp.waitForElement();
	     
	     actual[285]=tp.clickOnMaintainassignmentsoforiginalschedules();
	     bp.waitForElement();
	     
	     actual[286]=tp.selectAllFreeFormTestCasesPhase();
	     bp.waitForElement();
	     
	     actual[287]=tp.clickOnSaveAndOk();
	     bp.waitForElement();
	     
	     actual[288]=tp.closeFreeFormPage();
	     bp.waitForElement();
	     
	     actual[289]=tp.validateAddtestcaesToFreeForm();
	     bp.waitForElement();
	     
	     
	     bp.waitForElement();
	     actual[290]=tp.clickOnAddTestcasesToFreeForm();
	     
	     bp.waitForElement();
	     actual[291]=tp.launchOtherCycles();
	     
	     bp.waitForElement();
	     String cyclename6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",1 ,0 );
	     String Build6=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,0 );
	     String Environment6=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,0 );
	     actual[292]=tp.selectCycleInSearch(cyclename6, Build6, Environment6);
	     
	     bp.waitForElement();
	     String PhaseName6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",2 ,1 );
	     actual[293]=tp.selectPhaseInSearch(PhaseName6);
	     bp.waitForElement();
	     
	     String Status6=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",8 ,18 );
	     actual[294]=tp.filterByStatus(Status6);
	     
	     actual[295]=tp.clickOnGo();
	     
	     actual[296]=tp.validateRetrieveTestcases();
	     bp.waitForElement();
	     
	     actual[297]=tp.clickOnMaintainassignmentsoforiginalschedules();
	     bp.waitForElement();
	     
	     actual[298]=tp.selectAllFreeFormTestCasesPhase();
	     bp.waitForElement();
	     
	     actual[299]=tp.clickOnSaveAndOk();
	     bp.waitForElement();
	     
	     tp.closeFreeFormPage();
	     bp.waitForElement();
	     
	     actual[300]=tp.validateAddtestcaesToFreeForm();
	     bp.waitForElement();
		
		}
		 catch(Exception e)
		{
			 lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}

	@When("^User select sixth node and select checkbox Maintain assignment of original schedules and assign testcase to tester$")
	public void user_select_sixth_node_and_select_checkbox_Maintain_assignment_of_original_schedules_and_assign_testcase_to_tester() throws Throwable {
		try
		   {
//			   tr=new TestRepositoryPage(driver);
//			   String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 14, 1);
//			   bp.waitForElement();
//			   actual[346]=tr.selectPhase(p_Name1);
//			   String NodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",14 ,1 );
//			   actual[347]=tp.clickOnChecKBox(NodeName);
//			   bp.waitForElement();
//			   
//			   tp.clickOnSaveAndOk();
//			   bp.waitForElement();
//			   
//			   tp.closeFreeFormPage();
//			   bp.waitForElement();
			bp=new BasePage();
			   pp=new ProjectPage(driver);
			   pp.clickOnLogout();
				 bp.waitForElement();
		   }
		   catch(Exception e)
			{
			   lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}
	}

	@When("^Tester Launch TestExecution and expand release,cycle and select phase and execute testcases to pass/fail$")
	public void tester_Launch_TestExecution_and_expand_release_cycle_and_select_phase_and_execute_testcases_to_pass_fail() throws Throwable {
		try
		   {
			/*bp=new BasePage(); // /*
	    	pp=new ProjectPage(driver);
	    	pp.clickOnLogout();
	    	bp.waitForElement();
	    	tp=new TestPlanningPage(driver);
	    	exep=new ExecutionPage(driver); // */
			
				lp=new LoginPage(driver);
			
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Username_1");
			   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Password_1");
			   
			   lp.enterUname(Uname);
			   lp.enterPass(Pass);
			   lp.clickOnLogin();
			   
			   pp=new ProjectPage(driver);
			   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		    	 bp.waitForElement();
		    	 pp.selectProject(projectName);
		    	 pp.selectRelease(releaseName);
			
			   bp.waitForElement();
				rp= new ReleasePage(driver);
				bp.waitForElement();
				   actual[301]=rp.clickOnTestExecution();    
			
				   
				   String[] cycleName1=new String[3];
				    cycleName1[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
				    cycleName1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",1,0 );
				    cycleName1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878837",2 ,1 );
				    
				    bp.waitForElement();
				    tp=new TestPlanningPage(driver);
				    bp.waitForElement();
				    bp.waitForElement();
				    bp.waitForElement();
					actual[302]=tp.navigateToCycle(cycleName1);
					bp.waitForElement();
					
					int[] tcNo1=new int[1];
					tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
				    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[303]=exep.executeStatus(tcNo1[0], statusType1);
				    bp.waitForElement();
				    
				    int[] tcNo2=new int[1];
					tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
				    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[304]=exep.executeStatus(tcNo2[0], statusType2);
				    bp.waitForElement();
				    
				    int[] tcNo3=new int[1];
					tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
				    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[305]=exep.executeStatus(tcNo3[0], statusType3);
				    bp.waitForElement();
				    
				    int[] tcNo4=new int[1];
					tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
				    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[306]=exep.executeStatus(tcNo4[0], statusType4);
				    bp.waitForElement();
				    
				    
				    int[] tcNo5=new int[1];
					tcNo5[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5 ,19 );
				    String statusType5=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",8 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[307]=exep.executeStatus(tcNo5[0], statusType5);
				    bp.waitForElement();
		   }
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}

	@When("^User click on D button and search a defect and link a defect$")
	public void user_click_on_D_button_and_search_a_defect_and_link_a_defect() throws Throwable {
	    try
	    {
    	 int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8 );
    	 bp=new BasePage();
		 bp.waitForElement();
		 exep=new ExecutionPage(driver);
		 exep.clickOnDefectButton(testcase1);
		 bp.waitForElement();
	    	
	    String defectId=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
	    bp.waitForElement();
	    actual[308]=exep.linkDefect(defectId);
	    bp.waitForElement();
	    }
	    catch(Exception e)
		{
	    	lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}

	@Then("^User able to view added testcases in TCE$")
	public void user_able_to_view_added_testcases_in_TCE() throws Throwable {
		 try
		    {
			 int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8 );
			 bp=new BasePage();
			 exep=new ExecutionPage(driver);
			 actual[309]=exep.viewTooltip(testcase1);
			 bp.waitForElement();
			 for(int k=0;k<=actual.length-1;k++)
			     {
					System.out.println("Actual["+k+"]="+actual[k]);
			      soft.assertEquals(actual[k], true);
			     }
			     soft.assertAll();	
		    }
		    catch(Exception e)
			{
		    	lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}
	}
}
