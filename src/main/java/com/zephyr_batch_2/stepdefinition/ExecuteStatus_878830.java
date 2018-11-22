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
import cucumber.api.java.en.When;

public class ExecuteStatus_878830 extends LaunchBrowser{

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
	
	boolean[] actual=new boolean[96];
	SoftAssert soft=new SoftAssert();	
	
	@Given("^Lead is in TestRepository and create a phase$")
	public void lead_is_in_TestRepository_and_create_a_phase() throws Throwable {
		try
		   {
			bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	 bp.waitForElement();
	    	 actual[0]=pp.selectProject(projectName);
	    	 actual[1]=pp.selectRelease(releaseName);
	    	 
	    	 rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[2]=rp.clickOnTestRep(); 
			   
			   tr=new TestRepositoryPage(driver);
				//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 20, 1);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 20, 4);
				
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
		   }
		catch(Exception e)
		{
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}  
	}

	@When("^create testcases with teststeps out of ten testcases,five should have high Priority P(\\d+),two should have Priority P(\\d+) and three should have Priority P(\\d+) and with all fields$")
	public void create_testcases_with_teststeps_out_of_ten_testcases_five_should_have_high_Priority_P_two_should_have_Priority_P_and_three_should_have_Priority_P_and_with_all_fields(int arg1, int arg2, int arg3) throws Throwable {
		try
		{
		bp.waitForElement();	
		tr.addTestCase();
		bp.waitForElement();
		
		actual[6]=tr.clickDetailButton();
		bp.waitForElement();
		ctc=new CreateTestCasePage(driver);
		String tcName1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 7, 17);
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
		
		String[] Priority1=new String[1];
		Priority1[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 20);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[9]=ctc.enterPriority(Priority1);
		bp.waitForElement();
		
		bp.waitForElement();
		ctc.customFieldOption.click();
		
		String text1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 7, 16);
		String longText1=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 100);
		String number1=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 100);
		String checkBox1=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		String pickupList1=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		String date1=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		bp.waitForElement();
		actual[10]=ctc.enterCustomFields(text1, longText1, number1, checkBox1, pickupList1, date1);
		bp.waitForElement();
		actual[11]=tr.clickOnList();
		bp.waitForElement();
		
		tr.addTestCase();
		actual[12]=tr.clickDetailButton();
		
		bp.waitForElement();
		ctc=new CreateTestCasePage(driver);
		String tcName2=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 8, 17);
		String tcDesc2=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
		bp.waitForElement();
		actual[13]=ctc.enterTestCaseNameAndDesc(tcName2, tcDesc2);
		bp.waitForElement();
		
		String[] stepDetail2=new String[3];
		stepDetail2[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
		stepDetail2[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
		stepDetail2[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[14]=ctc.enterTestCaseStepDetail(stepDetail2);
		bp.waitForElement();
		
		String[] Priority2=new String[1];
		Priority2[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 20);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[15]=ctc.enterPriority(Priority2);
		bp.waitForElement();
		
		bp.waitForElement();
		ctc.customFieldOption.click();
		
		String text2=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",8,16);
		String longText2=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 100);
		String number2=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 100);
		String checkBox2=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		String pickupList2=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		String date2=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		bp.waitForElement();
		actual[16]=ctc.enterCustomFields(text2, longText2, number2, checkBox2, pickupList2, date2);
		bp.waitForElement();
		actual[17]=tr.clickOnList();
		bp.waitForElement();
		
		tr.addTestCase();
		actual[18]=tr.clickDetailButton();
		
		bp.waitForElement();
		ctc=new CreateTestCasePage(driver);
		String tcName3=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 9, 17);
		String tcDesc3=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
		bp.waitForElement();
		actual[19]=ctc.enterTestCaseNameAndDesc(tcName3, tcDesc3);
		bp.waitForElement();
		
		String[] stepDetail3=new String[3];
		stepDetail3[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
		stepDetail3[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
		stepDetail3[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[20]=ctc.enterTestCaseStepDetail(stepDetail3);
		bp.waitForElement();
		
		String[] Priority3=new String[1];
		Priority3[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 20);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[21]=ctc.enterPriority(Priority3);
		bp.waitForElement();
		
		bp.waitForElement();
		ctc.customFieldOption.click();
		
		String text3=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 9, 16);
		String longText3=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 100);
		String number3=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 100);
		String checkBox3=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		String pickupList3=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		String date3=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		bp.waitForElement();
		actual[22]=ctc.enterCustomFields(text3, longText3, number3, checkBox3, pickupList3, date3);
		bp.waitForElement();
		actual[23]=tr.clickOnList();
		bp.waitForElement();
		
		tr.addTestCase();
		actual[24]=tr.clickDetailButton();
		
		bp.waitForElement();
		ctc=new CreateTestCasePage(driver);
		String tcName4=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 10, 17);
		String tcDesc4=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
		bp.waitForElement();
		actual[25]=ctc.enterTestCaseNameAndDesc(tcName4, tcDesc4);
		bp.waitForElement();
		
		String[] stepDetail4=new String[3];
		stepDetail4[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
		stepDetail4[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
		stepDetail4[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[26]=ctc.enterTestCaseStepDetail(stepDetail4);
		bp.waitForElement();
		
		String[] Priority4=new String[1];
		Priority4[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 20);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[27]=ctc.enterPriority(Priority4);
		bp.waitForElement();
		
		bp.waitForElement();
		ctc.customFieldOption.click();
		
		String text4=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 10, 16);
		String longText4=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 100);
		String number4=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 100);
		String checkBox4=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		String pickupList4=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		String date4=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		bp.waitForElement();
		actual[28]=ctc.enterCustomFields(text4, longText4, number4, checkBox4, pickupList4, date4);
		bp.waitForElement();
		actual[29]=tr.clickOnList();
		bp.waitForElement();
		
		tr.addTestCase();
		actual[30]=tr.clickDetailButton();
		
		bp.waitForElement();
		ctc=new CreateTestCasePage(driver);
		String tcName5=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 11, 17);
		String tcDesc5=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
		bp.waitForElement();
		actual[31]=ctc.enterTestCaseNameAndDesc(tcName5, tcDesc5);
		bp.waitForElement();
		
		String[] stepDetail5=new String[3];
		stepDetail5[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
		stepDetail5[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
		stepDetail5[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[32]=ctc.enterTestCaseStepDetail(stepDetail5);
		bp.waitForElement();
		
		String[] Priority5=new String[1];
		Priority5[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 20);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[33]=ctc.enterPriority(Priority5);
		bp.waitForElement();
		
		bp.waitForElement();
		ctc.customFieldOption.click();
		
		String text5=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 11, 16);
		String longText5=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 100);
		String number5=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 100);
		String checkBox5=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		String pickupList5=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		String date5=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		bp.waitForElement();
		actual[34]=ctc.enterCustomFields(text5, longText5, number5, checkBox5, pickupList5, date5);
		bp.waitForElement();
		actual[35]=tr.clickOnList();
		bp.waitForElement();
		
		tr.addTestCase();
		actual[36]=tr.clickDetailButton();
		
		bp.waitForElement();
		ctc=new CreateTestCasePage(driver);
		String tcName6=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 12, 17);
		String tcDesc6=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
		bp.waitForElement();
		actual[37]=ctc.enterTestCaseNameAndDesc(tcName6, tcDesc6);
		bp.waitForElement();
		
		String[] stepDetail6=new String[3];
		stepDetail6[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
		stepDetail6[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
		stepDetail6[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[38]=ctc.enterTestCaseStepDetail(stepDetail6);
		bp.waitForElement();
		
		String[] Priority6=new String[1];
		Priority6[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 2, 20);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[39]=ctc.enterPriority(Priority6);
		bp.waitForElement();
		
		bp.waitForElement();
		ctc.customFieldOption.click();
		
		String text6=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 12, 16);
		String longText6=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 100);
		String number6=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 100);
		String checkBox6=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		String pickupList6=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		String date6=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		bp.waitForElement();
		actual[40]=ctc.enterCustomFields(text6, longText6, number6, checkBox6, pickupList6, date6);
		bp.waitForElement();
		actual[41]=tr.clickOnList();
		bp.waitForElement();
		
		tr.addTestCase();
		actual[42]=tr.clickDetailButton();
		
		bp.waitForElement();
		ctc=new CreateTestCasePage(driver);
		String tcName7=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 13, 17);
		String tcDesc7=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
		bp.waitForElement();
		actual[43]=ctc.enterTestCaseNameAndDesc(tcName7, tcDesc7);
		bp.waitForElement();
		
		String[] stepDetail7=new String[3];
		stepDetail7[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
		stepDetail7[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
		stepDetail7[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[44]=ctc.enterTestCaseStepDetail(stepDetail7);
		bp.waitForElement();
		
		String[] Priority7=new String[1];
		Priority7[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 2, 20);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[45]=ctc.enterPriority(Priority7);
		bp.waitForElement();
		
		bp.waitForElement();
		ctc.customFieldOption.click();
		
		String text7=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 13, 16);
		String longText7=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 100);
		String number7=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 100);
		String checkBox7=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		String pickupList7=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		String date7=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		bp.waitForElement();
		actual[46]=ctc.enterCustomFields(text7, longText7, number7, checkBox7, pickupList7, date7);
		bp.waitForElement();
		actual[47]=tr.clickOnList();
		bp.waitForElement();
		
		tr.addTestCase();
		actual[48]=tr.clickDetailButton();
		
		bp.waitForElement();
		ctc=new CreateTestCasePage(driver);
		String tcName8=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 14, 17);
		String tcDesc8=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
		bp.waitForElement();
		actual[49]=ctc.enterTestCaseNameAndDesc(tcName8, tcDesc8);
		bp.waitForElement();
		
		String[] stepDetail8=new String[3];
		stepDetail8[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
		stepDetail8[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
		stepDetail8[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[50]=ctc.enterTestCaseStepDetail(stepDetail8);
		bp.waitForElement();
		
		String[] Priority8=new String[1];
		Priority8[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 3, 20);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[51]=ctc.enterPriority(Priority8);
		bp.waitForElement();
		
		bp.waitForElement();
		ctc.customFieldOption.click();
		
		String text8=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 14, 16);
		String longText8=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 100);
		String number8=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 100);
		String checkBox8=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		String pickupList8=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		String date8=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		bp.waitForElement();
		actual[52]=ctc.enterCustomFields(text8, longText8, number8, checkBox8, pickupList8, date8);
		bp.waitForElement();
		actual[53]=tr.clickOnList();
		bp.waitForElement();
		
		tr.addTestCase();
		actual[54]=tr.clickDetailButton();
		
		bp.waitForElement();
		ctc=new CreateTestCasePage(driver);
		String tcName9=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 15, 17);
		String tcDesc9=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
		bp.waitForElement();
		actual[55]=ctc.enterTestCaseNameAndDesc(tcName9, tcDesc9);
		bp.waitForElement();
		
		String[] stepDetail9=new String[3];
		stepDetail9[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
		stepDetail9[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
		stepDetail9[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[56]=ctc.enterTestCaseStepDetail(stepDetail9);
		bp.waitForElement();
		
		String[] Priority9=new String[1];
		Priority9[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 3, 20);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[57]=ctc.enterPriority(Priority9);
		bp.waitForElement();
		
		bp.waitForElement();
		ctc.customFieldOption.click();
		
		String text9=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 15, 16);
		String longText9=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 100);
		String number9=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 100);
		String checkBox9=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		String pickupList9=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		String date9=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		bp.waitForElement();
		actual[58]=ctc.enterCustomFields(text9, longText9, number9, checkBox9, pickupList9, date9);
		bp.waitForElement();
		actual[59]=tr.clickOnList();
		bp.waitForElement();
		
		tr.addTestCase();
		actual[60]=tr.clickDetailButton();
		
		bp.waitForElement();
		ctc=new CreateTestCasePage(driver);
		String tcName10=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 16, 17);
		String tcDesc10=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
		bp.waitForElement();
		actual[61]=ctc.enterTestCaseNameAndDesc(tcName10, tcDesc10);
		bp.waitForElement();
		
		String[] stepDetail10=new String[3];
		stepDetail10[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
		stepDetail10[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
		stepDetail10[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[62]=ctc.enterTestCaseStepDetail(stepDetail10);
		bp.waitForElement();
		
		String[] Priority10=new String[1];
		Priority10[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 3, 20);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[63]=ctc.enterPriority(Priority10);
		bp.waitForElement();
		
		bp.waitForElement();
		ctc.customFieldOption.click();
		
		String text10=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 16, 16);
		String longText10=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 100);
		String number10=Excel_Lib.getData(INPUT_PATH_3, "Search_868221", 100, 100);
		String checkBox10=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		String pickupList10=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		String date10=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
		bp.waitForElement();
		actual[64]=ctc.enterCustomFields(text10, longText10, number10, checkBox10, pickupList10, date10);
		bp.waitForElement();
		actual[65]=tr.clickOnList();
		bp.waitForElement();
	}
		catch(Exception e)
		{
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}  
	}

	@When("^Launch TestPlanning and create a cycle,create a phase and assign testcases to tester$")
	public void launch_TestPlanning_and_create_a_cycle_create_a_phase_and_assign_testcases_to_tester() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[66]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 20, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[67]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[68]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[69]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[70]=tp.saveTestCycle();
				
				String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 20, 0);
				bp.waitForElement();
				actual[71]=tp.navigateToCycle(cycle1);
				
				bp.waitForElement();
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 20, 1);
				actual[72]=tp.addPhaseToCycle(Phase);
				bp.waitForElement();
				
				bp.waitForElement();
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
				bp.waitForElement();
				actual[73]=tp.bulkAssignment(Bulk_Type);
				bp.waitForElement();
				
				String[] cycle2=new String[1];
				cycle2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 20, 1);
				bp.waitForElement();
				actual[74]=tp.navigateToCycle(cycle2);
				bp.waitForElement();
				
				actual[75]=tp.selectallTestCase();
				bp.waitForElement();
				
				String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 4, 9);
				actual[76]=tp.assignAllSelected(assignee);
				
				actual[77]=pp.clickOnLogout();
				bp.waitForElement();
		   }
		catch(Exception e)
		{
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}   
	}

	@When("^As a Tester,Launch TestExecution and executes testcases to custom status$")
	public void as_a_Tester_Launch_TestExecution_and_executes_testcases_to_custom_status() throws Throwable {
		 try
			{
			 /*bp=new BasePage();
		    	pp=new ProjectPage(driver);
		    	bp.waitForElement();
		    	pp.clickOnLogout();
		    	bp.waitForElement();
		    	tp=new TestPlanningPage(driver);
		    	exep=new ExecutionPage(driver);*/
			 
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
			actual[78]=rp.clickOnTestExecution();
			
			String[] cycleName1=new String[3];
		    cycleName1[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
		    cycleName1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",20 ,0 );
		    cycleName1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",20 ,1 );
		    bp.waitForElement();
		    tp=new TestPlanningPage(driver);
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
			actual[79]=tp.navigateToCycle(cycleName1);
			bp.waitForElement();
			
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",9 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[80]=exep.executeStatus(tcNo1[0], statusType1);
		    bp.waitForElement();
		    
		    int[] tcNo2=new int[1];
			tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
		    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",9 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[81]=exep.executeStatus(tcNo2[0], statusType2);
		    bp.waitForElement();
		    
		    int[] tcNo3=new int[1];
			tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
		    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",9 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[82]=exep.executeStatus(tcNo3[0], statusType3);
		    bp.waitForElement();
		    
		    int[] tcNo4=new int[1];
			tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
		    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",9 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[83]=exep.executeStatus(tcNo4[0], statusType4);
		    bp.waitForElement();
		    
		    int[] tcNo5=new int[1];
			tcNo5[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5 ,19 );
		    String statusType5=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",9 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[84]=exep.executeStatus(tcNo5[0], statusType5);
		    bp.waitForElement();
		    bp.waitForElement();
			}
	        catch(Exception e)
			{
			   e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}   
	}

	@When("^search a defect and link a defect$")
	public void search_a_defect_and_link_a_defect() throws Throwable {
	    try
	    {
	    	int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8 );
		    bp.waitForElement();
		    actual[85]=exep.clickOnDefectButton(testcase1);
		    bp.waitForElement();
		    
		    bp.waitForElement();
		    String defectId1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
		    bp.waitForElement();
		    actual[86]=exep.linkDefect(defectId1);
		    bp.waitForElement();
		    bp.waitForElement();
		    
		    bp.waitForElement();
		    int testcase2=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8 );
		    bp.waitForElement();
		    actual[87]=exep.clickOnDefectButton(testcase2);
		    bp.waitForElement();
		    
		    bp.waitForElement();
		    String defectId2=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
		    bp.waitForElement();
		    bp.waitForElement();
		    actual[88]=exep.linkDefect(defectId2);
		    bp.waitForElement();
		    bp.waitForElement();

		    bp.waitForElement();
		    int testcase3=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,8 );
		    bp.waitForElement();
		    actual[89]=exep.clickOnDefectButton(testcase3);
		    bp.waitForElement();
		    
		    bp.waitForElement();
		    String defectId3=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
		    bp.waitForElement();
		    bp.waitForElement();
		    actual[90]=exep.linkDefect(defectId3);
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();

		    bp.waitForElement();
		    int testcase4=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,8 );
		    bp.waitForElement();
		    actual[91]=exep.clickOnDefectButton(testcase4);
		    bp.waitForElement();
		    
		    bp.waitForElement();
		    String defectId4=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
		    bp.waitForElement();
		    bp.waitForElement();
		    actual[92]=exep.linkDefect(defectId4);
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();

		    
		    bp.waitForElement();
		    int testcase5=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5 ,8 );
		    bp.waitForElement();
		    actual[93]=exep.clickOnDefectButton(testcase5);
		    bp.waitForElement();
		    bp.waitForElement();
		    
		    bp.waitForElement();
		    String defectId5=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    actual[94]=exep.linkDefect(defectId5);
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();


	    }
	    catch(Exception e)
		{
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}  
	}

	@When("^perform sort on ID,Priority,Summary and custom field$")
	public void perform_sort_on_ID_Priority_Summary_and_custom_field() throws Throwable {
	   try
	   {
		   bp.waitForElement();
	    	String[] sortName=new String[3];
			bp.waitForElement();
			sortName[0]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 9, 0);
			sortName[1]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 5, 0);
			//sortName[2]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 1, 0);
			sortName[2]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 11, 2);
			/*sortName[4]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 5, 2);
			sortName[5]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 6, 2);
			sortName[6]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 7, 2);
			sortName[7]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 8, 2);*/
			
			bp.waitForElement();
			bp.waitForElement();
			//actual[95]=tp.sort(sortName);
			actual[95]=exep.sort(sortName);
			bp.waitForElement();
			
			exep.sortName.click();
			bp.waitForElement();
			
			
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
	   }
	   catch(Exception e)
		{
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}  
	}
}
