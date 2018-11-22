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

public class TestExecution_FreeForm_878834 extends LaunchBrowser{

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
	
	boolean[] actual=new boolean[285];
	SoftAssert soft=new SoftAssert();
	
	 String fileName="TestExecution_FreeForm_878834";

	 
	@Given("^Lead is in a page TestRepository$")
	public void lead_is_in_a_page_TestRepository() throws Throwable {
		try
		   {
			lb=new LaunchBrowser();
			bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	 bp.waitForElement();
	    	 
	    	 pp=new ProjectPage(driver);
	         pp.clickOnLogout();
	         bp.waitForElement();
	    lp=new LoginPage(driver);
	     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
	     lp.enterUname(Uname);
	     lp.enterPass(Pass);
	     lp.clickOnLogin();
	     bp.waitForElement();
	    	 actual[0]=pp.selectProject(projectName);
	    	 actual[1]=pp.selectRelease(releaseName);
	    	 
	    	 rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[2]=rp.clickOnTestRep(); 
		   
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

	@When("^User create a phase and create system and create subsystem upto tenth level and add ten testcases with all details to each node$")
	public void user_create_a_phase_and_create_system_and_create_subsystem_upto_tenth_level_and_add_ten_testcases_with_all_details_to_each_node() throws Throwable {
		try
	    {
					tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 43, 1);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 43, 4);
				
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
				String tcName1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 17);
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
				String AltID1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 15);
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
				tags1[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 18);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[11]=ctc.enterMultipletags(tags1);
				bp.waitForElement();
				bp.waitForElement();
				
				actual[12]=tr.clickOnList();
				bp.waitForElement();
				actual[13]=tr.selectallTestCase();
				actual[14]=tr.cloneTestCase();
				bp.waitForElement();
				actual[15]=tr.selectallTestCase();
				actual[16]=tr.cloneTestCase();
				bp.waitForElement();
				actual[17]=tr.selectallTestCase();
				actual[18]=tr.cloneTestCase();
				bp.waitForElement();
				String[] testCaseNo=new String[2];
				testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 8));
				testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 8));
				ep=new ExportPage(driver);
				bp.waitForElement();
				actual[19]=ep.selectMultipleTestCaseFromGrid(testCaseNo);
				bp.waitForElement();
				actual[20]=tr.cloneTestCase();
				bp.waitForElement();
				
				bp.waitForElement();
				actual[21]=tr.clickOnRelease(releaseName);
				String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 43, 2);
				String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 43, 5);
				bp.waitForElement();
				actual[22]=tr.selectPhase(p_Name1);
				//bp.waitForElement();
				actual[23]=tr.addNode(s_Name1, s_Desc1);
				String[] str1=new String[2];
				str1[0]=p_Name1;
				str1[1]=s_Name1;
				actual[24]=tr.navigateToNode(releaseName, str1);
				tr.addTestCase();
				bp.waitForElement();
				actual[25]=tr.clickDetailButton();
				
				bp.waitForElement();
				ctc=new CreateTestCasePage(driver);
				String tcName2=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 17);
				String tcDesc2=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
				bp.waitForElement();
				actual[26]=ctc.enterTestCaseNameAndDesc(tcName2, tcDesc2);
				bp.waitForElement();
				
				String[] stepDetail2=new String[3];
				stepDetail2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
				stepDetail2[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				stepDetail2[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[27]=ctc.enterTestCaseStepDetail(stepDetail2);
				bp.waitForElement();
				
				bp.waitForElement();
				String Priority2=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
				String AltID2=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 15);
				String Comment2=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 14);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[28]=ctc.enterTestCaseDetails(Priority2, AltID2, Comment2);
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
				actual[29]=ctc.enterCustomFields(text2, longText2, number2, checkBox2, pickupList2, date2);
				bp.waitForElement();
				String[] tags2=new String[1];
				tags2[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 18);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[30]=ctc.enterMultipletags(tags2);
				bp.waitForElement();
				actual[31]=tr.clickOnList();
				bp.waitForElement();
				actual[32]=tr.selectallTestCase();
				actual[33]=tr.cloneTestCase();
				bp.waitForElement();
				actual[34]=tr.selectallTestCase();
				actual[35]=tr.cloneTestCase();
				bp.waitForElement();
				actual[36]=tr.selectallTestCase();
				actual[37]=tr.cloneTestCase();
				bp.waitForElement();
				String[] testCaseNo2=new String[2];
				testCaseNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 8));
				testCaseNo2[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 8));
				ep=new ExportPage(driver);
				bp.waitForElement();
				actual[38]=ep.selectMultipleTestCaseFromGrid(testCaseNo2);
				bp.waitForElement();
				actual[39]=tr.cloneTestCase();
				bp.waitForElement();
	
		    	  bp.waitForElement();
		    	  actual[40]=tr.clickOnRelease(releaseName);
    	  String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 43, 3);
    	  String ss_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 43, 6);
    	  actual[41]=tr.selectPhase(s_Name1);
    	  String[] str2=new String[2];
    	  str2[0]=p_Name1;
    	  str2[1]=s_Name1;
    	  //actual[41]=tr.navigateToNode(releaseName, str2);
    	  bp.waitForElement();
    	  actual[42]=tr.addNode(ss_Name1, ss_Desc1);
    	  String[] str3=new String[3];
    	  str3[0]=p_Name1;
    	  str3[1]=s_Name1;
    	  str3[2]=ss_Name1;
    	  actual[43]=tr.navigateToNode(releaseName, str3);
    	  tr.addTestCase();
			bp.waitForElement();
			actual[44]=tr.clickDetailButton();
			
			bp.waitForElement();
			ctc=new CreateTestCasePage(driver);
			String tcName3=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 17);
			String tcDesc3=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
			bp.waitForElement();
			actual[45]=ctc.enterTestCaseNameAndDesc(tcName3, tcDesc3);
			bp.waitForElement();
			
			String[] stepDetail4=new String[3];
			stepDetail4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
			stepDetail4[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
			stepDetail4[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			actual[46]=ctc.enterTestCaseStepDetail(stepDetail4);
			bp.waitForElement();
			bp.waitForElement();
			String Priority3=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
			String AltID3=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 15);
			String Comment3=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 14);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			actual[47]=ctc.enterTestCaseDetails(Priority3, AltID3, Comment3);
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
			actual[48]=ctc.enterCustomFields(text3, longText3, number3, checkBox3, pickupList3, date3);
			bp.waitForElement();
			bp.waitForElement();
			String[] tags3=new String[1];
			tags3[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 18);
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			actual[49]=ctc.enterMultipletags(tags3);
			bp.waitForElement();
			actual[50]=tr.clickOnList();
			bp.waitForElement();
			actual[51]=tr.selectallTestCase();
			actual[52]=tr.cloneTestCase();
			bp.waitForElement();
			actual[53]=tr.selectallTestCase();
			actual[54]=tr.cloneTestCase();
			bp.waitForElement();
			actual[55]=tr.selectallTestCase();
			actual[56]=tr.cloneTestCase();
			bp.waitForElement();
			String[] testCaseNo3=new String[2];
			testCaseNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 8));
			testCaseNo3[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 8));
			ep=new ExportPage(driver);
			bp.waitForElement();
			actual[57]=ep.selectMultipleTestCaseFromGrid(testCaseNo3);
			bp.waitForElement();
			actual[58]=tr.cloneTestCase();
			bp.waitForElement();
			
			
			bp.waitForElement();
			actual[59]=tr.clickOnRelease(releaseName);
	    	 String ss_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 44, 3);
	    	  String ss_Desc2=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 43, 6);
	    	  actual[60]=tr.selectPhase(ss_Name1);
	    	  String[] str4=new String[4];
	    	  str4[0]=p_Name1;
	    	  str4[1]=s_Name1;
	    	  str4[2]=ss_Name1;
	    	  str4[3]=ss_Name2;
	    	  bp.waitForElement();
	    	  actual[61]=tr.addNode(ss_Name2, ss_Desc2);
	    	  actual[62]=tr.navigateToNode(releaseName, str4);
	    	  //actual[62]=tr.selectPhase(ss_Name2);
	    	  tr.addTestCase();
				bp.waitForElement();
				actual[63]=tr.clickDetailButton();
				
				bp.waitForElement();
				ctc=new CreateTestCasePage(driver);
				String tcName4=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 17);
				String tcDesc4=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
				bp.waitForElement();
				actual[64]=ctc.enterTestCaseNameAndDesc(tcName4, tcDesc4);
				bp.waitForElement();
				
				String[] stepDetail5=new String[3];
				stepDetail5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
				stepDetail5[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				stepDetail5[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[65]=ctc.enterTestCaseStepDetail(stepDetail5);
				bp.waitForElement();
				
				bp.waitForElement();
				String Priority4=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
				String AltID4=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 15);
				String Comment4=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 14);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[66]=ctc.enterTestCaseDetails(Priority4, AltID4, Comment4);
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
				actual[67]=ctc.enterCustomFields(text4, longText4, number4, checkBox4, pickupList4, date4);
				bp.waitForElement();
				bp.waitForElement();
				String[] tags4=new String[1];
				tags4[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 18);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[68]=ctc.enterMultipletags(tags4);
				bp.waitForElement();
				actual[69]=tr.clickOnList();
				bp.waitForElement();
				actual[70]=tr.selectallTestCase();
				actual[71]=tr.cloneTestCase();
				bp.waitForElement();
				actual[72]=tr.selectallTestCase();
				actual[73]=tr.cloneTestCase();
				bp.waitForElement();
				actual[74]=tr.selectallTestCase();
				actual[75]=tr.cloneTestCase();
				bp.waitForElement();
				String[] testCaseNo4=new String[2];
				testCaseNo4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 8));
				testCaseNo4[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 8));
				ep=new ExportPage(driver);
				bp.waitForElement();
				actual[76]=ep.selectMultipleTestCaseFromGrid(testCaseNo4);
				bp.waitForElement();
				actual[77]=tr.cloneTestCase();
				bp.waitForElement();
				
				
				bp.waitForElement();
				actual[78]=tr.clickOnRelease(releaseName);
		    	 String ss_Name3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 45, 3);
		    	  String ss_Desc3=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 43, 6);
		    	  actual[79]=tr.selectPhase(ss_Name2);
		    	  bp.waitForElement();
		    	  actual[80]=tr.addNode(ss_Name3, ss_Desc3);
		    	  String[] str5=new String[5];
		    	  str5[0]=p_Name1;
		    	  str5[1]=s_Name1;
		    	  str5[2]=ss_Name1;
		    	  str5[3]=ss_Name2;
		    	  str5[4]=ss_Name3;
		    	  actual[81]=tr.navigateToNode(releaseName, str5);
		    	  tr.addTestCase();
					bp.waitForElement();
					actual[82]=tr.clickDetailButton();
					
					bp.waitForElement();
					ctc=new CreateTestCasePage(driver);
					String tcName5=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 17);
					String tcDesc5=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
					bp.waitForElement();
					actual[83]=ctc.enterTestCaseNameAndDesc(tcName5, tcDesc5);
					bp.waitForElement();
					
					String[] stepDetail6=new String[3];
					stepDetail6[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
					stepDetail6[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
					stepDetail6[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
					ctc=new CreateTestCasePage(driver);
					bp.waitForElement();
					actual[84]=ctc.enterTestCaseStepDetail(stepDetail6);
					bp.waitForElement();
					
					bp.waitForElement();
					String Priority5=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
					String AltID5=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 15);
					String Comment5=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 14);
					ctc=new CreateTestCasePage(driver);
					bp.waitForElement();
					actual[85]=ctc.enterTestCaseDetails(Priority5, AltID5, Comment5);
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
					actual[86]=ctc.enterCustomFields(text5, longText5, number5, checkBox5, pickupList5, date5);
					bp.waitForElement();
					String[] tags5=new String[1];
					tags5[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 18);
					ctc=new CreateTestCasePage(driver);
					bp.waitForElement();
					actual[87]=ctc.enterMultipletags(tags5);
					bp.waitForElement();
					
					actual[88]=tr.clickOnList();
					bp.waitForElement();
					actual[89]=tr.selectallTestCase();
					actual[90]=tr.cloneTestCase();
					bp.waitForElement();
					actual[91]=tr.selectallTestCase();
					actual[92]=tr.cloneTestCase();
					bp.waitForElement();
					actual[93]=tr.selectallTestCase();
					actual[94]=tr.cloneTestCase();
					bp.waitForElement();
					String[] testCaseNo5=new String[2];
					testCaseNo5[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 8));
					testCaseNo5[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 8));
					ep=new ExportPage(driver);
					bp.waitForElement();
					actual[95]=ep.selectMultipleTestCaseFromGrid(testCaseNo5);
					bp.waitForElement();
					actual[96]=tr.cloneTestCase();
					bp.waitForElement();
					
					bp.waitForElement();
					actual[97]=tr.clickOnRelease(releaseName);
			    	 String ss_Name4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 46, 3);
			    	  String ss_Desc4=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 43, 6);
			    	  actual[98]=tr.selectPhase(ss_Name3);
			    	  bp.waitForElement();
			    	  actual[99]=tr.addNode(ss_Name4, ss_Desc4);
			    	  String[] str6=new String[6];
			    	  str6[0]=p_Name1;
			    	  str6[1]=s_Name1;
			    	  str6[2]=ss_Name1;
			    	  str6[3]=ss_Name2;
			    	  str6[4]=ss_Name3;
			    	  str6[5]=ss_Name4;
			    	  actual[100]=tr.navigateToNode(releaseName, str6);
			    	  tr.addTestCase();
						bp.waitForElement();
						actual[101]=tr.clickDetailButton();
						
						bp.waitForElement();
						ctc=new CreateTestCasePage(driver);
						String tcName6=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 17);
						String tcDesc6=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
						bp.waitForElement();
						actual[102]=ctc.enterTestCaseNameAndDesc(tcName6, tcDesc6);
						bp.waitForElement();
						
						String[] stepDetail7=new String[3];
						stepDetail7[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
						stepDetail7[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
						stepDetail7[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
						ctc=new CreateTestCasePage(driver);
						bp.waitForElement();
						actual[103]=ctc.enterTestCaseStepDetail(stepDetail7);
						bp.waitForElement();
						
						bp.waitForElement();
						String Priority6=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
						String AltID6=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 15);
						String Comment6=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 14);
						ctc=new CreateTestCasePage(driver);
						bp.waitForElement();
						actual[104]=ctc.enterTestCaseDetails(Priority6, AltID6, Comment6);
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
						actual[105]=ctc.enterCustomFields(text6, longText6, number6, checkBox6, pickupList6, date6);
						bp.waitForElement();
						String[] tags6=new String[1];
						tags6[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 18);
						ctc=new CreateTestCasePage(driver);
						bp.waitForElement();
						actual[106]=ctc.enterMultipletags(tags6);
						bp.waitForElement();
						actual[107]=tr.clickOnList();
						bp.waitForElement();
						actual[108]=tr.selectallTestCase();
						actual[109]=tr.cloneTestCase();
						bp.waitForElement();
						actual[110]=tr.selectallTestCase();
						actual[111]=tr.cloneTestCase();
						bp.waitForElement();
						actual[112]=tr.selectallTestCase();
						actual[113]=tr.cloneTestCase();
						bp.waitForElement();
						String[] testCaseNo6=new String[2];
						testCaseNo6[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 8));
						testCaseNo6[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 8));
						ep=new ExportPage(driver);
						bp.waitForElement();
						actual[114]=ep.selectMultipleTestCaseFromGrid(testCaseNo6);
						bp.waitForElement();
						actual[115]=tr.cloneTestCase();
						bp.waitForElement();
						
						bp.waitForElement();
						actual[116]=tr.clickOnRelease(releaseName);
				    	 String ss_Name5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 47, 3);
				    	 String ss_Desc5=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 43, 6);
				    	 actual[117]=tr.selectPhase(ss_Name4);
				    	 bp.waitForElement();
				    	 actual[118]=tr.addNode(ss_Name5, ss_Desc5);
				    	 String[] str7=new String[7];
				    	  str7[0]=p_Name1;
				    	  str7[1]=s_Name1;
				    	  str7[2]=ss_Name1;
				    	  str7[3]=ss_Name2;
				    	  str7[4]=ss_Name3;
				    	  str7[5]=ss_Name4;
				    	  str7[6]=ss_Name5;
				    	 actual[119]=tr.navigateToNode(releaseName, str7);
	    	    tr.addTestCase();
				bp.waitForElement();
				actual[120]=tr.clickDetailButton();
				
				bp.waitForElement();
				ctc=new CreateTestCasePage(driver);
				String tcName7=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 17);
				String tcDesc7=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
				bp.waitForElement();
				actual[121]=ctc.enterTestCaseNameAndDesc(tcName7, tcDesc7);
				bp.waitForElement();
				
				String[] stepDetail8=new String[3];
				stepDetail8[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
				stepDetail8[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				stepDetail8[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[122]=ctc.enterTestCaseStepDetail(stepDetail8);
				bp.waitForElement();
				
				bp.waitForElement();
				String Priority7=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
				String AltID7=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 15);
				String Comment7=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 17);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[123]=ctc.enterTestCaseDetails(Priority7, AltID7, Comment7);
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
				actual[124]=ctc.enterCustomFields(text7, longText7, number7, checkBox7, pickupList7, date7);
				
				bp.waitForElement();
				String[] tags7=new String[1];
				tags7[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 18);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[125]=ctc.enterMultipletags(tags7);
				bp.waitForElement();
				actual[126]=tr.clickOnList();
				bp.waitForElement();
				actual[127]=tr.selectallTestCase();
				actual[128]=tr.cloneTestCase();
				bp.waitForElement();
				actual[129]=tr.selectallTestCase();
				actual[130]=tr.cloneTestCase();
				bp.waitForElement();
				actual[131]=tr.selectallTestCase();
				actual[132]=tr.cloneTestCase();
				bp.waitForElement();
				String[] testCaseNo7=new String[2];
				testCaseNo7[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 8));
				testCaseNo7[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 8));
				ep=new ExportPage(driver);
				bp.waitForElement();
				actual[133]=ep.selectMultipleTestCaseFromGrid(testCaseNo7);
				bp.waitForElement();
				actual[134]=tr.cloneTestCase();
				bp.waitForElement();
				
				bp.waitForElement();
				actual[135]=tr.clickOnRelease(releaseName);
		    	 String ss_Name6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 48, 3);
		    	  String ss_Desc6=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 43, 6);
		    	  actual[136]=tr.selectPhase(ss_Name5);
		    	  bp.waitForElement();
		    	  actual[137]=tr.addNode(ss_Name6, ss_Desc6);
		    	  String[] str8=new String[8];
		    	  str8[0]=p_Name1;
		    	  str8[1]=s_Name1;
		    	  str8[2]=ss_Name1;
		    	  str8[3]=ss_Name2;
		    	  str8[4]=ss_Name3;
		    	  str8[5]=ss_Name4;
		    	  str8[6]=ss_Name5;
		    	  str8[7]=ss_Name6;
		    	  actual[138]=tr.navigateToNode(releaseName, str8);
		    	  tr.addTestCase();
					bp.waitForElement();
					actual[139]=tr.clickDetailButton();
					
					bp.waitForElement();
					ctc=new CreateTestCasePage(driver);
					String tcName8=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 17);
					String tcDesc8=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
					bp.waitForElement();
					actual[140]=ctc.enterTestCaseNameAndDesc(tcName8, tcDesc8);
					bp.waitForElement();
					
					String[] stepDetail9=new String[3];
					stepDetail9[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
					stepDetail9[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
					stepDetail9[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
					ctc=new CreateTestCasePage(driver);
					bp.waitForElement();
					actual[141]=ctc.enterTestCaseStepDetail(stepDetail9);
					bp.waitForElement();
					bp.waitForElement();
					String Priority8=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
					String AltID8=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 15);
					String Comment8=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 14);
					ctc=new CreateTestCasePage(driver);
					bp.waitForElement();
					actual[142]=ctc.enterTestCaseDetails(Priority8, AltID8, Comment8);
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
					actual[143]=ctc.enterCustomFields(text8, longText8, number8, checkBox8, pickupList8, date8);
					
					
					bp.waitForElement();
					String[] tags8=new String[1];
					tags8[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 18);
					ctc=new CreateTestCasePage(driver);
					bp.waitForElement();
					actual[144]=ctc.enterMultipletags(tags8);
					bp.waitForElement();
					actual[145]=tr.clickOnList();
					bp.waitForElement();
					actual[146]=tr.selectallTestCase();
					actual[147]=tr.cloneTestCase();
					bp.waitForElement();
					actual[148]=tr.selectallTestCase();
					actual[149]=tr.cloneTestCase();
					bp.waitForElement();
					actual[150]=tr.selectallTestCase();
					actual[151]=tr.cloneTestCase();
					bp.waitForElement();
					String[] testCaseNo8=new String[2];
					testCaseNo8[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 8));
					testCaseNo8[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 8));
					ep=new ExportPage(driver);
					bp.waitForElement();
					actual[152]=ep.selectMultipleTestCaseFromGrid(testCaseNo8);
					bp.waitForElement();
					actual[153]=tr.cloneTestCase();
					bp.waitForElement();
					
					bp.waitForElement();
					actual[154]=tr.clickOnRelease(releaseName);
			    	 String ss_Name7=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 49, 3);
			    	  String ss_Desc7=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 43, 6);
			    	  actual[155]=tr.selectPhase(ss_Name6);
			    	  bp.waitForElement();
			    	  actual[156]=tr.addNode(ss_Name7, ss_Desc7);
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
			    	  actual[157]=tr.navigateToNode(releaseName, str9);
			    	  actual[158]=tr.addTestCase();
						bp.waitForElement();
						actual[159]=tr.clickDetailButton();
						
						bp.waitForElement();
						ctc=new CreateTestCasePage(driver);
						String tcName9=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 17);
						String tcDesc9=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
						bp.waitForElement();
						actual[160]=ctc.enterTestCaseNameAndDesc(tcName9, tcDesc9);
						bp.waitForElement();
						
						String[] stepDetail10=new String[3];
						stepDetail10[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
						stepDetail10[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
						stepDetail10[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
						ctc=new CreateTestCasePage(driver);
						bp.waitForElement();
						actual[161]=ctc.enterTestCaseStepDetail(stepDetail10);
						bp.waitForElement();
						
						bp.waitForElement();
						String Priority9=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
						String AltID9=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 15);
						String Comment9=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 14);
						ctc=new CreateTestCasePage(driver);
						bp.waitForElement();
						actual[162]=ctc.enterTestCaseDetails(Priority9, AltID9, Comment9);
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
						actual[163]=ctc.enterCustomFields(text9, longText9, number9, checkBox9, pickupList9, date9);
						
						bp.waitForElement();
						String[] tags9=new String[1];
						tags9[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 18);
						ctc=new CreateTestCasePage(driver);
						bp.waitForElement();
						actual[164]=ctc.enterMultipletags(tags9);
						bp.waitForElement();
						
						actual[165]=tr.clickOnList();
						bp.waitForElement();
						actual[166]=tr.selectallTestCase();
						actual[167]=tr.cloneTestCase();
						bp.waitForElement();
						actual[168]=tr.selectallTestCase();
						actual[169]=tr.cloneTestCase();
						bp.waitForElement();
						actual[170]=tr.selectallTestCase();
						actual[171]=tr.cloneTestCase();
						bp.waitForElement();
						String[] testCaseNo9=new String[2];
						testCaseNo9[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 8));
						testCaseNo9[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 8));
						ep=new ExportPage(driver);
						bp.waitForElement();
						actual[172]=ep.selectMultipleTestCaseFromGrid(testCaseNo9);
						bp.waitForElement();
						actual[173]=tr.cloneTestCase();
						bp.waitForElement();
						bp.waitForElement();
						bp.waitForElement();
						actual[174]=tr.clickOnRelease(releaseName);
				    	 String ss_Name8=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 50, 3);
				    	  String ss_Desc8=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 43, 6);
				    	  actual[175]=tr.selectPhase(ss_Name7);
				    	  bp.waitForElement();
				    	  actual[176]=tr.addNode(ss_Name8, ss_Desc8);
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
				    	  actual[177]=tr.navigateToNode(releaseName, str10);
				    	  tr.addTestCase();
							bp.waitForElement();
							actual[178]=tr.clickDetailButton();
							
							bp.waitForElement();
							ctc=new CreateTestCasePage(driver);
							String tcName10=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 17);
							String tcDesc10=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
							bp.waitForElement();
							actual[179]=ctc.enterTestCaseNameAndDesc(tcName10, tcDesc10);
							bp.waitForElement();
							
							String[] stepDetail11=new String[3];
							stepDetail11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
							stepDetail11[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
							stepDetail11[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
							ctc=new CreateTestCasePage(driver);
							bp.waitForElement();
							actual[180]=ctc.enterTestCaseStepDetail(stepDetail11);
							bp.waitForElement();
							
							bp.waitForElement();
							String Priority10=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 100, 100);
							String AltID10=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 15);
							String Comment10=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 14);
							ctc=new CreateTestCasePage(driver);
							bp.waitForElement();
							actual[181]=ctc.enterTestCaseDetails(Priority10, AltID10, Comment10);
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
							actual[182]=ctc.enterCustomFields(text10, longText10, number10, checkBox10, pickupList10, date10);
							
							bp.waitForElement();
							String[] tags10=new String[1];
							tags10[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 18);
							ctc=new CreateTestCasePage(driver);
							bp.waitForElement();
							actual[183]=ctc.enterMultipletags(tags10);
							bp.waitForElement();
							bp.waitForElement();
							
							actual[184]=tr.clickOnList();
							bp.waitForElement();
							actual[185]=tr.selectallTestCase();
							actual[186]=tr.cloneTestCase();
							bp.waitForElement();
							actual[187]=tr.selectallTestCase();
							actual[188]=tr.cloneTestCase();
							bp.waitForElement();
							actual[189]=tr.selectallTestCase();
							actual[190]=tr.cloneTestCase();
							bp.waitForElement();
							String[] testCaseNo10=new String[2];
							testCaseNo10[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 8));
							testCaseNo10[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 8));
							ep=new ExportPage(driver);
							bp.waitForElement();
							actual[191]=ep.selectMultipleTestCaseFromGrid(testCaseNo10);
							bp.waitForElement();
							actual[192]=tr.cloneTestCase();
							bp.waitForElement();
							
							bp.waitForElement();
							actual[193]=tr.clickOnRelease(releaseName);
					    	 String ss_Name9=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 51, 3);
					    	  String ss_Desc9=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 43, 6);
					    	  actual[194]=tr.selectPhase(ss_Name8);
					    	  bp.waitForElement();
					    	  actual[195]=tr.addNode(ss_Name9, ss_Desc9);
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
					    	  actual[196]=tr.navigateToNode(releaseName, str11);
					    	  tr.addTestCase();
								bp.waitForElement();
								actual[197]=tr.clickDetailButton();
								
								bp.waitForElement();
								ctc=new CreateTestCasePage(driver);
								String tcName11=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 17);
								String tcDesc11=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
								bp.waitForElement();
								actual[198]=ctc.enterTestCaseNameAndDesc(tcName11, tcDesc11);
								bp.waitForElement();
								
								String[] stepDetail12=new String[3];
								stepDetail12[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
								stepDetail12[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
								stepDetail12[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
								ctc=new CreateTestCasePage(driver);
								bp.waitForElement();
								actual[199]=ctc.enterTestCaseStepDetail(stepDetail12);
								bp.waitForElement();
								
								bp.waitForElement();
								String Priority11=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
								String AltID11=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 15);
								String Comment11=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 14);
								ctc=new CreateTestCasePage(driver);
								bp.waitForElement();
								actual[200]=ctc.enterTestCaseDetails(Priority11, AltID11, Comment11);
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
								actual[201]=ctc.enterCustomFields(text11, longText11, number11, checkBox11, pickupList11, date11);
								
								bp.waitForElement();
								String[] tags11=new String[1];
								tags11[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 18);
								ctc=new CreateTestCasePage(driver);
								bp.waitForElement();
								actual[202]=ctc.enterMultipletags(tags11);
								bp.waitForElement();
								
								actual[203]=tr.clickOnList();
								bp.waitForElement();
								actual[204]=tr.selectallTestCase();
								actual[205]=tr.cloneTestCase();
								bp.waitForElement();
								actual[206]=tr.selectallTestCase();
								actual[207]=tr.cloneTestCase();
								bp.waitForElement();
								actual[208]=tr.selectallTestCase();
								actual[209]=tr.cloneTestCase();
								bp.waitForElement();
								String[] testCaseNo11=new String[2];
								testCaseNo11[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 8));
								testCaseNo11[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 8));
								ep=new ExportPage(driver);
								bp.waitForElement();
								actual[210]=ep.selectMultipleTestCaseFromGrid(testCaseNo11);
								bp.waitForElement();
								actual[211]=tr.cloneTestCase();
								bp.waitForElement();
								
								bp.waitForElement();
								actual[212]=tr.clickOnRelease(releaseName);
						    	 String ss_Name10=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 52, 3);
						    	  String ss_Desc10=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 43, 6);
						    	  actual[213]=tr.selectPhase(ss_Name9);
						    	  bp.waitForElement();
						    	  actual[214]=tr.addNode(ss_Name10, ss_Desc10);
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
						    	  actual[215]=tr.navigateToNode(releaseName, str12);
						    	  tr.addTestCase();
									bp.waitForElement();
									actual[216]=tr.clickDetailButton();
									
									bp.waitForElement();
									ctc=new CreateTestCasePage(driver);
									String tcName12=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 17);
									String tcDesc12=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
									bp.waitForElement();
									actual[217]=ctc.enterTestCaseNameAndDesc(tcName12, tcDesc12);
									
									String[] stepDetail13=new String[3];
									stepDetail13[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
									stepDetail13[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
									stepDetail13[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
									ctc=new CreateTestCasePage(driver);
									bp.waitForElement();
									actual[218]=ctc.enterTestCaseStepDetail(stepDetail13);
									bp.waitForElement();
									bp.waitForElement();
									String Priority12=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
									String AltID12=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 15);
									String Comment12=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 14);
									ctc=new CreateTestCasePage(driver);
									bp.waitForElement();
									actual[219]=ctc.enterTestCaseDetails(Priority12, AltID12, Comment12);
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
									actual[220]=ctc.enterCustomFields(text12, longText12, number12, checkBox12, pickupList12, date12);
									
									bp.waitForElement();
									String[] tags12=new String[1];
									tags12[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 4, 18);
									ctc=new CreateTestCasePage(driver);
									bp.waitForElement();
									actual[221]=ctc.enterMultipletags(tags12);
									bp.waitForElement();
									
									actual[222]=tr.clickOnList();
									bp.waitForElement();
									actual[223]=tr.selectallTestCase();
									actual[224]=tr.cloneTestCase();
									bp.waitForElement();
									actual[225]=tr.selectallTestCase();
									actual[226]=tr.cloneTestCase();
									bp.waitForElement();
									tr.selectallTestCase();
									tr.cloneTestCase();
									bp.waitForElement();
									String[] testCaseNo12=new String[2];
									testCaseNo12[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 8));
									testCaseNo12[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 8));
									ep=new ExportPage(driver);
									bp.waitForElement();
									bp.waitForElement();
									bp.waitForElement();
									actual[227]=ep.selectMultipleTestCaseFromGrid(testCaseNo12);
									tr.cloneTestCase();
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

	@When("^User Launch TestPlanning and create the cycle and create a freeform phase and add a node to freeform phase$")
	public void user_Launch_TestPlanning_and_create_the_cycle_and_create_a_freeform_phase_and_add_a_node_to_freeform_phase() throws Throwable {
	   try
	   {
		   bp.waitForElement();
			rp= new ReleasePage(driver);
		actual[228]=rp.clickOnTestPlanning();
		  
		  tp=new TestPlanningPage(driver);
			//String[] str=new String[4];
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 43, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
			String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
			String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
			actual[229]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			bp.waitForElement();
			actual[230]=tp.CreateCycle(cycle, Build, environ, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
			String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
			String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
			bp.waitForElement();
			actual[231]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[232]=tp.saveTestCycle();
			
		
		String[] cycle1=new String[1];
		cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 43, 0);
		bp.waitForElement();
		actual[233]=tp.navigateToCycle(cycle1);
		
		String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 43, 1);
		bp.waitForElement();
		actual[234]=tp.createFreeFormPhase(phaseName);
		bp.waitForElement();
		
		String[] cycle11=new String[1];
		cycle11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 43, 1);
		actual[235]=tp.navigateToCycle(cycle11);
		
		String systemName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 44, 2);
		String systemDesc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 44, 5);
		actual[236]=tp.addNode(systemName1, systemDesc1);
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

	@When("^User add a testcases to freeform phase using advanced search and assign to an tester$")
	public void user_add_a_testcases_to_freeform_phase_using_advanced_search_and_assign_to_an_tester() throws Throwable {
		try
		{
		String[] cycleName=new String[1];
	     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",43 ,1 );
	     bp.waitForElement();
	     actual[237]=tp.navigateToCycle(cycleName);
	     
	     bp.waitForElement();
	     actual[238]=tp.clickOnAddTestcasesToFreeForm();
	     
	 	bp.waitForElement();
	    actual[239]=tp.clickOnAdvanceSearch();
	    
	    String name1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",10 ,0 );
	    	String operator1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",11 ,1 );
	    	String value1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",5 ,17 );//summary only
	    	bp.waitForElement();
	    	actual[240]=tp.ZQLSearch1(name1, operator1, value1);
	    	actual[241]=tp.validateSearch();
	    	bp.waitForElement();
	    	actual[242]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     
		     bp.waitForElement();
		     actual[243]=tp.clickOnSaveAndOk();
		     
		     bp.waitForElement();
		 	actual[244]=tp.closeFreeFormPage();
	    
	    	//altid only
		 	String[] cycleName2=new String[1];
		     cycleName2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",43 ,1 );
		     bp.waitForElement();
		     actual[245]=tp.navigateToCycle(cycleName2);
		     
		     bp.waitForElement();
		     actual[246]=tp.clickOnAddTestcasesToFreeForm();

		     bp.waitForElement();
		     actual[247]=tp.clickOnAdvanceSearch();
	    	
	    	String name2=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",13 ,0 );
	    	String operator2=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",11 ,1 );
	    	String value2=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",5 ,15 );
	    	bp.waitForElement();
	    	actual[248]=tp.ZQLSearch1(name2, operator2, value2);
	    	actual[249]=tp.validateSearch();
	    	bp.waitForElement();
	    	actual[250]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     //tp.clickOnCheckBoxSaveAllTestcases();
		     
		     bp.waitForElement();
		     actual[251]=tp.clickOnSaveAndOk();
		     
		     bp.waitForElement();
		 	actual[252]=tp.closeFreeFormPage();
	    	
	    	//customtext only
		 	String[] cycleName3=new String[1];
		     cycleName3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",43 ,1 );
		     bp.waitForElement();
		     actual[253]=tp.navigateToCycle(cycleName3);
		     
		     bp.waitForElement();
		     actual[254]=tp.clickOnAddTestcasesToFreeForm();
		     
		     bp.waitForElement();
		     actual[255]=tp.clickOnAdvanceSearch();
	    	String name3=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",16 ,0 );
	    	String operator3=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",11 ,1 );
	    	String value3=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",2 ,16 );
	    	bp.waitForElement();
	    	actual[256]=tp.ZQLSearch1(name3, operator3, value3);
	    	actual[257]=tp.validateSearch();
	    	bp.waitForElement();
	    	actual[258]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     
		     actual[259]=tp.clickOnSaveAndOk();
		     bp.waitForElement();
	    	actual[260]=tp.closeFreeFormPage();
	    	bp.waitForElement();
	    	
	    	//Priority Only
	    	String[] cycleName4=new String[1];
		     cycleName4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",43 ,1 );
		     bp.waitForElement();
		     actual[261]=tp.navigateToCycle(cycleName4);
		     
		     bp.waitForElement();
		     actual[262]=tp.clickOnAddTestcasesToFreeForm();
		     bp.waitForElement();
		     actual[263]=tp.clickOnAdvanceSearch();
	    	String name4=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",14 ,0 );
	    	String operator4=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,1 );
	    	String value4=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",2 ,20 );
	    	bp.waitForElement();
	    	actual[264]=tp.ZQLSearch1(name4, operator4, value4);
	    	actual[265]=tp.validateSearch();
	    	bp.waitForElement();
	    	actual[266]=tp.selectAllFreeFormTestCases();
		     
		     bp.waitForElement();
		     actual[267]=tp.clickOnSaveAndOk();
		     bp.waitForElement();
	    	actual[268]=tp.closeFreeFormPage();
	    	bp.waitForElement();
	    	
	    	
	    	String[] cycleName5=new String[1];
		     cycleName5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",43 ,1 );
		     bp.waitForElement();
		     actual[269]=tp.navigateToCycle(cycleName5);
		     
		     bp.waitForElement();
		     actual[270]=tp.clickOnAddTestcasesToFreeForm();
		     bp.waitForElement();
		     actual[271]=tp.clickOnAdvanceSearch();
	    	String name5=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,0 );
	    	String operator5=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,1 );
	    	String value5=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",5 ,18 );//tag only
	    	bp.waitForElement();
	    	actual[272]=tp.ZQLSearch1(name5, operator5, value5);
	    	actual[273]=tp.validateSearch();
	    	bp.waitForElement();
	    	actual[274]=tp.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     
		     bp.waitForElement();
		     actual[275]=tp.clickOnSaveAndOk();
		     bp.waitForElement();
	    	actual[276]=tp.closeFreeFormPage();
	    	
	    	bp.waitForElement();
	    	actual[277]=tp.selectallTestCase();
	    	
	    	String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,9 );
	    	bp.waitForElement();
	    	actual[278]=tp.assignAllSelected(assignee);
	    	
	    	bp.waitForElement();
	    	actual[279]=pp.clickOnLogout();
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

	@When("^Tester Launch TestExecution and expand Release,cycle and navigate to the phase$")
	public void tester_Launch_TestExecution_and_expand_Release_cycle_and_navigate_to_the_phase() throws Throwable {
		try
		   {
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
		    	 actual[280]=pp.selectProject(projectName);
		    	 actual[281]=pp.selectRelease(releaseName);
			
			   bp.waitForElement();
				rp= new ReleasePage(driver);
				bp.waitForElement();
				   actual[282]=rp.clickOnTestExecution(); 
			
			   bp.waitForElement();
				rp= new ReleasePage(driver);
				bp.waitForElement();
				   actual[283]=rp.clickOnTestExecution(); 
				   
				   String[] cycleName1=new String[3];
				    cycleName1[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
				    cycleName1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",43 ,0 );
				    cycleName1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",43 ,1 );
				    
				    bp.waitForElement();
				    tp=new TestPlanningPage(driver);
				    bp.waitForElement();
				    bp.waitForElement();
				    bp.waitForElement();
					actual[284]=tp.navigateToCycle(cycleName1);
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

	@Then("^User check assignments in TCE$")
	public void user_check_assignments_in_TCE() throws Throwable {
	    try
	    {
	    	for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
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
