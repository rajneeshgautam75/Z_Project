package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_878808 extends LaunchBrowser{
	LaunchBrowser lb=new LaunchBrowser();
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage epp;
	TestPlanningPage tp;
	ExecutionPage ep;
	String ad="TestExecution_878808";
    
	boolean actual[]=new boolean[295];
	SoftAssert soft=new SoftAssert();
	
	@Given("^Lead is in TestRepositoryPage of Normal_Project$")
	public void lead_is_in_TestRepositoryPage_of_Normal_Project() throws Throwable {
		try 
		 {
			 bp=new BasePage();
			
			 pp=new ProjectPage(driver);
			 rp=new ReleasePage(driver);
			 
			 //pp=new ProjectPage(driver);
		     pp.clickOnLogout();
		     bp.waitForElement();
		lp=new LoginPage(driver);
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
		 String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
		 lp.enterUname(Uname);
		 lp.enterPass(Pass);
		 lp.clickOnLogin();
		  bp.waitForElement();
			 String Project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Normal_Project_1");
			 String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases",1, 0);
		     actual[0]=pp.selectProject(Project);
		     actual[1]=pp.selectRelease(Release);
		     actual[2]=rp.clickOnTestRep();
		     bp.waitForElement();
		 }
		 catch (Exception e)
		 {
			 e.printStackTrace();
			
			 lb.getScreenShot(ad);
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;
		 }	
		
	  
	}

	@When("^Add a phase, add ten systems to phase, add two subsystems to each system and add testcases with teststeps to each node$")
	public void add_a_phase_add_ten_systems_to_phase_add_two_subsystems_to_each_system_and_add_testcases_with_teststeps_to_each_node() throws Throwable {
	  
		try 
		   {
			 tr=new TestRepositoryPage(driver);
			 ctc=new CreateTestCasePage(driver);
			 epp=new ExportPage(driver);
			 String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			 String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 1);
			 String system1=Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 4);
			 String s1_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 5);
			 String system2=Excel_Lib.getData(INPUT_PATH_5, "Phase", 27, 4);
			 String s2_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 27, 5);
			 String system3=Excel_Lib.getData(INPUT_PATH_5, "Phase", 28, 4);
			 String s3_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 28, 5);
			 String system4=Excel_Lib.getData(INPUT_PATH_5, "Phase", 29, 4);
			 String s4_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 29, 5);
			 String system5=Excel_Lib.getData(INPUT_PATH_5, "Phase", 30, 4);
			 String s5_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 30, 5);
			 String system6=Excel_Lib.getData(INPUT_PATH_5, "Phase", 31, 4);
			 String s6_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 31, 5);
			 String system7=Excel_Lib.getData(INPUT_PATH_5, "Phase", 32, 4);
			 String s7_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 32, 5);
			 String system8=Excel_Lib.getData(INPUT_PATH_5, "Phase", 33, 4);
			 String s8_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 33, 5);
			 String system9=Excel_Lib.getData(INPUT_PATH_5, "Phase", 34, 4);
			 String s9_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 34, 5);
			 String system91=Excel_Lib.getData(INPUT_PATH_5, "Phase", 35, 4);
			 String s91_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 35, 5);
			 
			 String sub_system11=Excel_Lib.getData(INPUT_PATH_5, "Phase", 2, 6);
			 String ss11_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase",2, 7);
			 String sub_system12=Excel_Lib.getData(INPUT_PATH_5, "Phase", 3, 6);
			 String ss12_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 3, 7);
			 
			 String sub_system21=Excel_Lib.getData(INPUT_PATH_5, "Phase", 4, 6);
			 String ss21_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 4, 7);
			 String sub_system22=Excel_Lib.getData(INPUT_PATH_5, "Phase", 5, 6);
			 String ss22_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 5, 7);
			 
			 String sub_system31=Excel_Lib.getData(INPUT_PATH_5, "Phase", 6, 6);
			 String ss31_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 6, 7);
			 String sub_system32=Excel_Lib.getData(INPUT_PATH_5, "Phase", 7, 6);
			 String ss32_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 7, 7);
			 
			 String sub_system41=Excel_Lib.getData(INPUT_PATH_5, "Phase", 8, 6);
			 String ss41_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 8, 7);
			 String sub_system42=Excel_Lib.getData(INPUT_PATH_5, "Phase", 9, 6);
			 String ss42_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 9, 7);
			 
			 String sub_system51=Excel_Lib.getData(INPUT_PATH_5, "Phase", 10, 6);
			 String ss51_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 10, 7);
			 String sub_system52=Excel_Lib.getData(INPUT_PATH_5, "Phase", 11, 6);
			 String ss52_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 11, 7);
			 
			 String sub_system61=Excel_Lib.getData(INPUT_PATH_5, "Phase", 12, 6);
			 String ss61_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 12, 7);
			 String sub_system62=Excel_Lib.getData(INPUT_PATH_5, "Phase", 13, 6);
			 String ss62_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 13, 7);
			 
			 String sub_system71=Excel_Lib.getData(INPUT_PATH_5, "Phase", 14, 6);
			 String ss71_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 14, 7);
			 String sub_system72=Excel_Lib.getData(INPUT_PATH_5, "Phase", 15, 6);
			 String ss72_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 15, 7);
			 
			 String sub_system81=Excel_Lib.getData(INPUT_PATH_5, "Phase", 16, 6);
			 String ss81_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 16, 7);
			 String sub_system82=Excel_Lib.getData(INPUT_PATH_5, "Phase", 17, 6);
			 String ss82_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 17, 7);
			 
			 String sub_system91=Excel_Lib.getData(INPUT_PATH_5, "Phase", 18, 6);
			 String ss91_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 18, 7);
			 String sub_system92=Excel_Lib.getData(INPUT_PATH_5, "Phase", 19, 6);
			 String ss92_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 19, 7);
			 
			 String sub_system911=Excel_Lib.getData(INPUT_PATH_5, "Phase", 20, 6);
			 String ss911_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 20, 7);
			 String sub_system912=Excel_Lib.getData(INPUT_PATH_5, "Phase", 21, 6);
			 String ss912_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 21, 7);
			 
			 actual[3]=tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 actual[4]=tr.addNode(Phase, Desc);
			 bp.waitForElement();
			    String[] phase=new String[1];
				phase[0]=Phase;
				bp.waitForElement();
			    tr.navigateToNode(Release, phase);
				bp.waitForElement();
			 actual[5]=tr.selectPhase(Phase);
			 bp.waitForElement();
			 actual[6]=tr.addTestCase();
			 bp.waitForElement();
			 actual[7]=tr.clickOnDetails();
			 bp.waitForElement();
			 String stepDetails[]=new String[3];
			 for (int i=0;i<=stepDetails.length-1;i++)
			 {
			  stepDetails[i]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, i);
			 }
			 actual[8]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[9]=tr.clickOnList();
			 bp.waitForElement();
			 String testcase[]=new String[1];
			 testcase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0));
			 actual[10]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[11]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.selectPhase(Release);
			 bp.waitForElement();
			actual[12]=tr.selectPhase(Phase);
			 bp.waitForElement();
			 
			 actual[13]=tr.addNode(system1, s1_Desc);        //system1
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation1=new String[2];
			 navigation1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation1[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 4);
			 actual[14]=tr.navigateToNode(Release, navigation1);
			 bp.waitForElement();
			 tr.selectPhase(system1);
			 actual[15]=tr.addTestCase();
			 bp.waitForElement();
			 actual[16]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[17]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[18]=tr.clickOnList();
			 bp.waitForElement();
			 actual[19]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[20]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.selectPhase(Phase);
			 bp.waitForElement();
			 actual[21]=tr.selectPhase(system1);
			 bp.waitForElement();
			 
			 actual[21]=tr.addNode(sub_system11, ss11_Desc);        //sub_system1
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation11=new String[3];
			 navigation11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation11[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 4);
			 navigation11[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 2, 6);
			 tr.navigateToNode(Release, navigation11);
			 actual[22]=bp.waitForElement();
			 actual[23]=tr.addTestCase();
			 bp.waitForElement();
			 actual[24]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[25]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[26]=tr.clickOnList();
			 bp.waitForElement();
			 actual[27]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[28]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.selectPhase(Phase);
			 bp.waitForElement();
			 actual[29]=tr.selectPhase(system1);
              bp.waitForElement();
			 
			 actual[30]=tr.addNode(sub_system12, ss12_Desc);        //sub_system2
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation12=new String[3];
			 navigation12[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation12[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 4);
			 navigation12[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 3, 6);
			 actual[31]= tr.navigateToNode(Release, navigation12);
			 bp.waitForElement();
			 //actual[31]=tr.selectPhase(sub_system12);
			 //bp.waitForElement();
			 actual[32]=tr.addTestCase();
			 bp.waitForElement();
			 actual[33]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[34]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[35]=tr.clickOnList();
			 bp.waitForElement();
			 actual[36]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[37]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.clickOnRelease(Release);
			 bp.waitForElement();
			 actual[38]=tr.selectPhase(Phase);
			 bp.waitForElement();
			 
			 actual[39]=tr.addNode(system2, s2_Desc);        //system2
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation2=new String[2];
			 navigation2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation2[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 27, 4);
			 actual[40]=tr.navigateToNode(Release, navigation2);
			 bp.waitForElement();
			 actual[41]=tr.addTestCase();
			 bp.waitForElement();
			 actual[42]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[43]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[44]=tr.clickOnList();
			 bp.waitForElement();
			 actual[45]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[46]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.selectPhase(system1);
			 bp.waitForElement();
			 actual[47]=tr.selectPhase(system2);
			 bp.waitForElement();
			 
			 actual[48]=tr.addNode(sub_system21, ss21_Desc);        //sub_system21
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation21=new String[3];
			 navigation21[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation21[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 27, 4);
			 navigation21[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 4, 6);
			 actual[49]=tr.navigateToNode(Release, navigation21);
			 bp.waitForElement();
			 actual[50]=tr.addTestCase();
			 bp.waitForElement();
			 actual[51]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[52]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[53]=tr.clickOnList();
			 bp.waitForElement();
			 actual[54]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[55]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.selectPhase(system1);
			 bp.waitForElement();
			 actual[56]=tr.selectPhase(system2);
              bp.waitForElement();
			 
			 actual[57]=tr.addNode(sub_system22, ss22_Desc);        //sub_system22
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation22=new String[3];
			 navigation22[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation22[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 27, 4);
			 navigation22[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 5, 6);
			 actual[58]=tr.navigateToNode(Release, navigation22);
			 bp.waitForElement();
			 actual[59]=tr.addTestCase();
			 bp.waitForElement();
			 actual[60]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[61]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[62]=tr.clickOnList();
			 bp.waitForElement();
			 actual[63]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[64]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.clickOnRelease(Release);
			 bp.waitForElement();
			 actual[65]=tr.selectPhase(Phase);
			 bp.waitForElement();
			 
			 actual[66]=tr.addNode(system3, s3_Desc);        //system3
			 bp.waitForElement();
			 actual[67]=tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation3=new String[2];
			 navigation3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation3[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 28, 4);
			 tr.navigateToNode(Release, navigation3);
			 bp.waitForElement();
			 actual[68]=tr.addTestCase();
			 bp.waitForElement();
			 actual[69]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[70]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[71]=tr.clickOnList();
			 bp.waitForElement();
			 actual[72]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[73]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.selectPhase(system2);
			 bp.waitForElement();
			 actual[74]=tr.selectPhase(system3);
			 bp.waitForElement();
			 
			 actual[75]=tr.addNode(sub_system31, ss31_Desc);        //sub_system31
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation31=new String[3];
			 navigation31[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation31[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 28, 4);
			 navigation31[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 6, 6);
			 actual[76]=tr.navigateToNode(Release, navigation31);
			 bp.waitForElement();
			 actual[77]=tr.addTestCase();
			 bp.waitForElement();
			 actual[78]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[79]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[80]=tr.clickOnList();
			 bp.waitForElement();
			 actual[81]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[82]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.selectPhase(system2);
			 bp.waitForElement();
			 actual[83]=tr.selectPhase(system3);
              bp.waitForElement();
			 
			 actual[84]=tr.addNode(sub_system32, ss32_Desc);        //sub_system32
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation32=new String[3];
			 navigation32[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation32[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 28, 4);
			 navigation32[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 7, 6);
			 actual[85]=tr.navigateToNode(Release, navigation32);
			 bp.waitForElement();
			 actual[86]=tr.addTestCase();
			 bp.waitForElement();
			 actual[87]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[88]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[89]=tr.clickOnList();
			 bp.waitForElement();
			 actual[90]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[91]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.clickOnRelease(Release);
			 bp.waitForElement();
			 actual[92]=tr.selectPhase(Phase);
			 bp.waitForElement();
			 
			 actual[93]=tr.addNode(system4, s4_Desc);        //system4
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation4=new String[2];
			 navigation4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation4[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 29, 4);
			 actual[94]=tr.navigateToNode(Release, navigation4);
			 bp.waitForElement();
			 actual[95]=tr.addTestCase();
			 bp.waitForElement();
			 actual[96]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[97]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[98]=tr.clickOnList();
			 bp.waitForElement();
			 actual[99]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[100]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.selectPhase(system3);
			 bp.waitForElement();
			 actual[101]=tr.selectPhase(system4);
			 bp.waitForElement();
			 
			 actual[102]=tr.addNode(sub_system41, ss41_Desc);        //sub_system41
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation41=new String[3];
			 navigation41[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation41[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 29, 4);
			 navigation41[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 8, 6);
			 actual[103]=tr.navigateToNode(Release, navigation41);
			 bp.waitForElement();
			 actual[104]=tr.addTestCase();
			 bp.waitForElement();
			 actual[105]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[106]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[107]=tr.clickOnList();
			 bp.waitForElement();
			 actual[108]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[109]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.selectPhase(system3);
			 bp.waitForElement();
			 actual[110]=tr.selectPhase(system4);
              bp.waitForElement();
			 
			 actual[111]=tr.addNode(sub_system42, ss42_Desc);        //sub_system42
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation42=new String[3];
			 navigation42[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation42[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 29, 4);
			 navigation42[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 9, 6);
			 actual[112]=tr.navigateToNode(Release, navigation42);
			 bp.waitForElement();
			 actual[113]=tr.addTestCase();
			 bp.waitForElement();
			 actual[114]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[115]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[116]=tr.clickOnList();
			 bp.waitForElement();
			 actual[117]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[118]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.clickOnRelease(Release);
			 bp.waitForElement();
			 actual[119]=tr.selectPhase(Phase);
			 bp.waitForElement();
			 
			 actual[120]=tr.addNode(system5, s5_Desc);        //system5
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation5=new String[2];
			 navigation5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation5[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 30, 4);
			 actual[121]=tr.navigateToNode(Release, navigation5);
			 bp.waitForElement();
			 actual[122]=tr.addTestCase();
			 bp.waitForElement();
			 actual[123]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[124]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[125]=tr.clickOnList();
			 bp.waitForElement();
			 actual[126]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[127]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.selectPhase(system4);
			 bp.waitForElement();
			 actual[128]=tr.selectPhase(system5);
			 bp.waitForElement();
			 
			 actual[129]=tr.addNode(sub_system51, ss51_Desc);        //sub_system51
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation51=new String[3];
			 navigation51[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation51[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 30, 4);
			 navigation51[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 10, 6);
			 actual[130]=tr.navigateToNode(Release, navigation51);
			 bp.waitForElement();
			 actual[131]=tr.addTestCase();
			 bp.waitForElement();
			 actual[132]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[133]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[134]=tr.clickOnList();
			 bp.waitForElement();
			 actual[135]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[136]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.selectPhase(system4);
			 bp.waitForElement();
			 actual[137]=tr.selectPhase(system5);
              bp.waitForElement();
			 
			 actual[138]=tr.addNode(sub_system52, ss52_Desc);        //sub_system52
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation52=new String[3];
			 navigation52[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation52[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 30, 4);
			 navigation52[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 11, 6);
			 actual[139]=tr.navigateToNode(Release, navigation52);
			 bp.waitForElement();
			 actual[140]=tr.addTestCase();
			 bp.waitForElement();
			 actual[141]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[142]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[143]=tr.clickOnList();
			 bp.waitForElement();
			 actual[144]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[145]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.clickOnRelease(Release);
			 bp.waitForElement();
			 actual[146]=tr.clickOnRelease(Phase);
			 bp.waitForElement();
			 
			 actual[147]=tr.addNode(system6, s6_Desc);        //system6
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation6=new String[2];
			 navigation6[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation6[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 31, 4);
			 actual[148]=tr.navigateToNode(Release, navigation6);
			 bp.waitForElement();
			 actual[149]=tr.addTestCase();
			 bp.waitForElement();
			 actual[150]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[151]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[152]=tr.clickOnList();
			 bp.waitForElement();
			 actual[153]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[154]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.selectPhase(system5);
			 bp.waitForElement();
			 actual[155]=tr.selectPhase(system6);
			 bp.waitForElement();
			 
			 actual[156]=tr.addNode(sub_system61, ss61_Desc);        //sub_system61
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation61=new String[3];
			 navigation61[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation61[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 31, 4);
			 navigation61[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 12, 6);
			 actual[157]=tr.navigateToNode(Release, navigation61);
			 bp.waitForElement();
			 actual[158]=tr.addTestCase();
			 bp.waitForElement();
			 actual[159]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[160]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[161]=tr.clickOnList();
			 bp.waitForElement();
			 actual[162]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[163]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.selectPhase(system5);
			 bp.waitForElement();
			 actual[164]=tr.selectPhase(system6);
              bp.waitForElement();
			 
			 actual[165]=tr.addNode(sub_system62, ss62_Desc);        //sub_system62
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation62=new String[3];
			 navigation62[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation62[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 31, 4);
			 navigation62[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 13, 6);
			 actual[166]=tr.navigateToNode(Release, navigation62);
			 bp.waitForElement();
			 actual[167]=tr.addTestCase();
			 bp.waitForElement();
			 actual[168]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[169]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[170]=tr.clickOnList();
			 bp.waitForElement();
			 actual[171]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[172]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.clickOnRelease(Release);
			 bp.waitForElement();
			 actual[173]=tr.selectPhase(Phase);
			 bp.waitForElement();
			 
			 actual[174]=tr.addNode(system7, s7_Desc);        //system7
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation7=new String[2];
			 navigation7[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation7[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 32, 4);
			 actual[175]=tr.navigateToNode(Release, navigation7);
			 bp.waitForElement();
			 actual[176]=tr.addTestCase();
			 bp.waitForElement();
			 actual[177]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[178]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[179]=tr.clickOnList();
			 bp.waitForElement();
			 actual[180]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[181]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.selectPhase(system6);
			 bp.waitForElement();
			 actual[182]=tr.selectPhase(system7);
			 bp.waitForElement();
			 
			 actual[183]=tr.addNode(sub_system71, ss71_Desc);        //sub_system71
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation71=new String[3];
			 navigation71[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation71[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 32, 4);
			 navigation71[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 14, 6);
			 actual[184]=tr.navigateToNode(Release, navigation71);
			 bp.waitForElement();
			 actual[185]=tr.addTestCase();
			 bp.waitForElement();
			 actual[186]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[187]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[188]=tr.clickOnList();
			 bp.waitForElement();
			 actual[189]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[190]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.selectPhase(system6);
			 bp.waitForElement();
			 actual[191]=tr.selectPhase(system7);
              bp.waitForElement();
			 
			 actual[192]=tr.addNode(sub_system72, ss72_Desc);        //sub_system72
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation72=new String[3];
			 navigation72[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation72[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 32, 4);
			 navigation72[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 15, 6);
			 actual[193]=tr.navigateToNode(Release, navigation72);
			 bp.waitForElement();
			 actual[194]=tr.addTestCase();
			 bp.waitForElement();
			 actual[195]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[196]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[197]=tr.clickOnList();
			 bp.waitForElement();
			 actual[198]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[199]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.clickOnRelease(Release);
			 bp.waitForElement();
			 actual[200]=tr.selectPhase(Phase);
			 bp.waitForElement();
			 
			 actual[201]=tr.addNode(system8, s8_Desc);        //system8
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation8=new String[2];
			 navigation8[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation8[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 33, 4);
			 actual[202]=tr.navigateToNode(Release, navigation8);
			 bp.waitForElement();
			 actual[203]=tr.addTestCase();
			 bp.waitForElement();
			 actual[204]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[205]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[206]=tr.clickOnList();
			 bp.waitForElement();
			 actual[207]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[208]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.selectPhase(system7);
			 bp.waitForElement();
			 actual[209]=tr.selectPhase(system8);
			 bp.waitForElement();
			 
			 actual[210]=tr.addNode(sub_system81, ss81_Desc);        //sub_system81
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation81=new String[3];
			 navigation81[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation81[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 33, 4);
			 navigation81[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 16, 6);
			 actual[211]=tr.navigateToNode(Release, navigation81);
			 bp.waitForElement();
			 actual[212]=tr.addTestCase();
			 bp.waitForElement();
			 actual[213]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[214]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[215]=tr.clickOnList();
			 bp.waitForElement();
			 actual[216]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[217]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.selectPhase(system7);
			 bp.waitForElement();
			 actual[218]=tr.selectPhase(system8);
              bp.waitForElement();
			 
			 actual[219]=tr.addNode(sub_system82, ss82_Desc);        //sub_system82
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation82=new String[3];
			 navigation82[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation82[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 33, 4);
			 navigation82[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 17, 6);
			 actual[220]=tr.navigateToNode(Release, navigation82);
			 bp.waitForElement();
			 actual[221]=tr.addTestCase();
			 bp.waitForElement();
			 actual[222]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[223]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[224]=tr.clickOnList();
			 bp.waitForElement();
			 actual[225]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[226]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.clickOnRelease(Release);
			 bp.waitForElement();
			 actual[227]=tr.selectPhase(Phase);
			 bp.waitForElement();
			 
			 actual[228]=tr.addNode(system9, s9_Desc);        //system9
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation9=new String[2];
			 navigation9[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation9[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 34, 4);
			 actual[229]=tr.navigateToNode(Release, navigation9);
			 bp.waitForElement();
			 actual[230]=tr.addTestCase();
			 bp.waitForElement();
			 actual[231]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[232]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[233]=tr.clickOnList();
			 bp.waitForElement();
			 actual[234]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[235]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.selectPhase(system8);
			 bp.waitForElement();
			 actual[236]=tr.selectPhase(system9);
			 bp.waitForElement();
			 
			 actual[237]=tr.addNode(sub_system91, ss91_Desc);        //sub_system91
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation91=new String[3];
			 navigation91[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation91[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 34, 4);
			 navigation91[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 18, 6);
			 actual[238]=tr.navigateToNode(Release, navigation91);
			 bp.waitForElement();
			 actual[239]=tr.addTestCase();
			 bp.waitForElement();
			 actual[240]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[241]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[242]=tr.clickOnList();
			 bp.waitForElement();
			 actual[243]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[244]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.selectPhase(system8);
			 bp.waitForElement();
			 actual[245]=tr.selectPhase(system9);
              bp.waitForElement();
			 
			 actual[246]=tr.addNode(sub_system92, ss92_Desc);        //sub_system92
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation92=new String[3];
			 navigation92[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation92[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 34, 4);
			 navigation92[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 19, 6);
			 actual[247]=tr.navigateToNode(Release, navigation92);
			 bp.waitForElement();
			 actual[248]=tr.addTestCase();
			 bp.waitForElement();
			 actual[249]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[250]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[251]=tr.clickOnList();
			 bp.waitForElement();
			 actual[252]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[253]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.clickOnRelease(Release);
			 bp.waitForElement();
			 actual[254]=tr.selectPhase(Phase);
			 bp.waitForElement();
			 
			 actual[255]=tr.addNode(system91, s91_Desc);        //system91
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation911=new String[2];
			 navigation911[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation911[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 35, 4);
			 actual[256]=tr.navigateToNode(Release, navigation911);
			 bp.waitForElement();
			 actual[257]=tr.addTestCase();
			 bp.waitForElement();
			 actual[258]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[259]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[260]=tr.clickOnList();
			 bp.waitForElement();
			 actual[261]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[262]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.selectPhase(system9);
			 bp.waitForElement();
			 actual[263]=tr.selectPhase(system91);
			 bp.waitForElement();
			 
			 actual[264]=tr.addNode(sub_system911, ss911_Desc);        //sub_system911
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation9111=new String[3];
			 navigation9111[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation9111[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 35, 4);
			 navigation9111[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 20, 6);
			 actual[265]=tr.navigateToNode(Release, navigation9111);
			 bp.waitForElement();
			 actual[266]=tr.addTestCase();
			 bp.waitForElement();
			 actual[267]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[268]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[269]=tr.clickOnList();
			 bp.waitForElement();
			 actual[270]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[271]=tr.cloneTestCase();
			 bp.waitForElement();
			 tr.selectPhase(system9);
			 bp.waitForElement();
			 actual[272]=tr.selectPhase(system91);
              bp.waitForElement();
			 
			 actual[273]=tr.addNode(sub_system912, ss912_Desc);        //sub_system912
			 bp.waitForElement();
			 tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation912=new String[3];
			 navigation912[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 navigation912[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 35, 4);
			 navigation912[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 21, 6);
			 actual[274]=tr.navigateToNode(Release, navigation912);
			 bp.waitForElement();
			 actual[275]=tr.addTestCase();
			 bp.waitForElement();
			 actual[276]=tr.clickOnDetails();
			 bp.waitForElement();
			 actual[277]=ctc.enterTestCaseStepDetail(stepDetails);
			 bp.waitForElement();
			 actual[278]=tr.clickOnList();
			 bp.waitForElement();
			 actual[279]=epp.selectMultipleTestCaseFromGrid(testcase);
			 bp.waitForElement();
			 actual[280]=tr.cloneTestCase();
			 bp.waitForElement();
			 String releaseName=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
				tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
			 
			 }
		catch(Exception e)
		{
			e.printStackTrace();
			 lb.getScreenShot(ad);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Launch Test Planning page and create new cycle$")
	public void launch_Test_Planning_page_and_create_new_cycle() throws Throwable {
		try 
		   {
			
			tp=new TestPlanningPage(driver);
			actual[281]=rp.clickOnTestPlanning();
			actual[282]=tp.clickOnAddTestCycleSymbol();
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 19, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle" , 1, 1);
			String environment=Excel_Lib.getData(INPUT_PATH_5,  "Create cycle", 1, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_5,  "Create cycle", 100, 100);
			actual[283]=tp.CreateCycle(cycle, Build, environment, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,  "Cycle Date", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,  "Cycle Date", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
			actual[284]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			actual[285]=tp.saveTestCycle();
			bp.waitForElement(); 
			
		    }
		catch(Exception e)
		{    lb.getScreenShot(ad);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}  
	}

	@When("^Add phase to created cycle and assign to Lead using BulkAssignment$")
	public void add_phase_to_created_cycle_and_assign_to_Lead_using_BulkAssignment() throws Throwable {
		try 
		   {
			String cycle[]=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 19, 0);
			actual[286]=tp.navigateToCycle(cycle);
			bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			actual[287]=tp.addPhaseToCycle(Phase);
			bp.waitForElement();
			String Bulk_type=Excel_Lib.getData(INPUT_PATH_5, "BulkAssignment", 1, 0);
			actual[288]=tp.bulkAssignment(Bulk_type);
			bp.waitForElement();
			tp.goBackToCycle();
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

	@When("^Launch TestExecution Page$")
	public void launch_TestExecution_Page() throws Throwable {
		try 
		   {
			
		    ep=new ExecutionPage(driver);
			actual[289]=rp.clickOnTestExecution();
			bp.waitForElement();
			
		    }
		catch(Exception e)
		{     lb.getScreenShot(ad);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		} 
	}

	@Then("^Expand All nodes By clicking one by one and Verify that only the clicked System/Sub system is Expanded$")
	public void expand_All_nodes_By_clicking_one_by_one_and_Verify_that_only_the_clicked_System_Sub_system_is_Expanded() throws Throwable {
		try 
		   {
			 String nodes[]=new String[3];
			 nodes[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			 nodes[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 19, 0);
			 nodes[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
			 actual[290]=ep.validateExecutions(nodes);
			 bp.waitForElement();
			 String system1=Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 4);
			 actual[291]=tr.selectPhase(system1);
			 String node[]=new String[30];
			 node[0]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 4);
			 node[1] =Excel_Lib.getData(INPUT_PATH_5, "Phase", 2, 6);
			 node[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 3, 6);
		
			 node[3]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 27, 4);
			 node[4] =Excel_Lib.getData(INPUT_PATH_5, "Phase", 4, 6);
			 node[5] =Excel_Lib.getData(INPUT_PATH_5, "Phase", 5, 6);
			
			 node[6]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 28, 4);
			 node[7]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 6, 6);
			 node[8] =Excel_Lib.getData(INPUT_PATH_5, "Phase", 7, 6);
			 
			 
			 node[9]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 29, 4);
			 node[10] =Excel_Lib.getData(INPUT_PATH_5, "Phase", 8, 6);
			 node[11]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 9, 6);
			 
			 node[12]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 30, 4);
			 node[13] =Excel_Lib.getData(INPUT_PATH_5, "Phase", 10, 6);
			 node[14] =Excel_Lib.getData(INPUT_PATH_5, "Phase", 11, 6);
			 
			 node[15]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 31, 4);
			 node[16] =Excel_Lib.getData(INPUT_PATH_5, "Phase", 12, 6);
			 node[17]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 13, 6);
			 
			 node[18]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 32, 4);
			 node[19]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 14, 6);
			 node[20]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 15, 6);
			
			 
			 
			 node[21]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 33, 4);
			 
			 node[22]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 16, 6);
			 node[23]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 17, 6);
			 
			 
			 node[24]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 34, 4);
			 node[25]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 18, 6);
			 node[26]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 19, 6);
			 
			 
			 
			 node[27]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 35, 4);
			 node[28]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 20, 6);
			 node[29]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 21, 6);
			 actual[292]=ep.validateExecutions(node);
			 bp.waitForElement();
		    }
		catch(Exception e)
		{    lb.getScreenShot(ad);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}  
	}

	@Then("^Collapse All nodes By clicking one by one and Verify that only the clicked System/Sub system is Expanded$")
	public void collapse_All_nodes_By_clicking_one_by_one_and_Verify_that_only_the_clicked_System_Sub_system_is_Expanded() throws Throwable {
		try 
		   {
			String node[]=new String[33];
			node[0]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 21, 6);
			node[1]= Excel_Lib.getData(INPUT_PATH_5, "Phase", 20, 6);
			node[2]= Excel_Lib.getData(INPUT_PATH_5, "Phase", 35, 4);
			String subsystem=Excel_Lib.getData(INPUT_PATH_5, "Phase", 21, 6);
			actual[293]=tr.selectPhase(subsystem);
			node[3]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 19, 6);
			node[4]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 18, 6);
			node[5]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 34, 4);
			node[6]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 17, 6);
			node[7]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 16, 6);
			node[8]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 33, 4);
			node[9]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 15, 6);
			node[10]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 14, 6);	
			node[11]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 32, 4);
			node[12]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 13, 6);
			node[13]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 12, 6);
			node[14]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 31, 4);
			node[15]= Excel_Lib.getData(INPUT_PATH_5, "Phase", 11, 6);
			node[16]= Excel_Lib.getData(INPUT_PATH_5, "Phase", 10, 6);
			node[17]= Excel_Lib.getData(INPUT_PATH_5, "Phase", 30, 4);
			node[18]= Excel_Lib.getData(INPUT_PATH_5, "Phase", 9, 6);
			node[19]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 8, 6);
			node[20]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 29, 4);
			node[21]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 7, 6);
			node[22]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 6, 6);
			node[23]= Excel_Lib.getData(INPUT_PATH_5, "Phase", 28, 4);
			node[24]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 5, 6);
			node[25]= Excel_Lib.getData(INPUT_PATH_5, "Phase", 4, 6);
			node[26]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 27, 4);
			node[27]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 3, 6);
			node[28]= Excel_Lib.getData(INPUT_PATH_5, "Phase", 2, 6);
			node[29]= Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 4);
			node[30]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 26, 0);
		    node[31]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 19, 0);
			node[32]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			actual[294]=ep.validateExecutions(node);
			bp.waitForElement();
			
			
			for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll(); 
			 
		    }
		catch(Exception e)
		{    lb.getScreenShot(ad);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}  
	}
	}
