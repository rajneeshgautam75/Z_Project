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

public class TestExecution_Sort_878789 extends LaunchBrowser {

LoginPage lp;
BasePage bp;
ProjectPage pp;
ReleasePage rp;
TestRepositoryPage tr;
CreateTestCasePage ctc;
TestPlanningPage tp;
ExecutionPage ep;
ExportPage epp;
 boolean [] actual=new boolean[153];
 SoftAssert soft=new SoftAssert();
 
 
 LaunchBrowser lb=new LaunchBrowser();
	String filename="TestExecution_Sort_878789";
 
 
 String Project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Normal_Project_1");
 String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
 String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 36,0);
 String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 36, 1);

	@Given("^Lead is in TestRepositorypage of Normal_Project$")
	public void lead_is_in_TestRepositorypage_of_Normal_Project() throws Throwable {
		try {
			pp=new ProjectPage(driver);
			rp=new ReleasePage(driver);
			bp=new BasePage();
			
			
			//pp=new ProjectPage(driver);
		     pp.clickOnLogout();
		     bp.waitForElement();
		lp=new LoginPage(driver);
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
		 String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
		 lp.enterUname(Uname);
		 lp.enterPass(Pass);
		 lp.clickOnLogin();
			
			
			actual[0]=pp.selectProject(Project);
			bp.waitForElement();
			actual[1]=pp.selectRelease(Release);
			bp.waitForElement();
			actual[2]=rp.clickOnTestRep();
			bp.waitForElement();
		     }
		catch (Exception e)
		{ lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	       }

	@When("^create new phase, add systems and subsystems to upto tenth level of Phase and add ten testcases with all details to each node$")
	public void create_new_phase_add_systems_and_subsystems_to_upto_tenth_level_of_Phase_and_add_ten_testcases_with_all_details_to_each_node() throws Throwable {
		try {
			tr=new TestRepositoryPage(driver);
			ctc=new CreateTestCasePage(driver);
			epp=new ExportPage(driver);
			String system1=Excel_Lib.getData(INPUT_PATH_5, "Phase", 36,4);
			String s1_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 36, 5);
			String sub_system01=Excel_Lib.getData(INPUT_PATH_5, "Phase", 37,4);
			String sub01_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 37, 5);
			String sub_system02=Excel_Lib.getData(INPUT_PATH_5, "Phase", 38,4);
			String sub02_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 38, 5);
			String sub_system03=Excel_Lib.getData(INPUT_PATH_5, "Phase", 39,4);
			String sub03_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 39, 5);
			String sub_system04=Excel_Lib.getData(INPUT_PATH_5, "Phase", 40,4);
			String sub04_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 40, 5);
			String sub_system05=Excel_Lib.getData(INPUT_PATH_5, "Phase", 41,4);
			String sub05_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 41, 5);
			String sub_system06=Excel_Lib.getData(INPUT_PATH_5, "Phase", 42,4);
			String sub06_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 42, 5);
			String sub_system07=Excel_Lib.getData(INPUT_PATH_5, "Phase", 43,4);
			String sub07_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 43, 5);
			String sub_system08=Excel_Lib.getData(INPUT_PATH_5, "Phase", 44,4);
			String sub08_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 44, 5);
			
			actual[3]=tr.doubleClickOnRelease(Release);
			bp.waitForElement();
			actual[4]=tr.addNode(Phase, Desc);
			bp.waitForElement();
		    String[] phase=new String[1];
			phase[0]=Phase;
			bp.waitForElement();
			tr=new TestRepositoryPage(driver);
		    tr.navigateToNode(Release, phase);
			bp.waitForElement();;
			actual[5]=tr.selectPhase(Phase);
			bp.waitForElement();
			actual[6]=tr.addTestCase();
			bp.waitForElement();
			actual[7]=tr.clickOnDetails();
			bp.waitForElement();
			String testcaseName=Excel_Lib.getData(INPUT_PATH_5, "TestRepository", 1, 2);
			String testcaseDesc=Excel_Lib.getData(INPUT_PATH_5,"TestRepository", 1, 3);
			actual[8]=ctc.enterTestCaseNameAndDesc(testcaseName, testcaseDesc);
			bp.waitForElement();
			String Priority=Excel_Lib.getData(INPUT_PATH_5, "TestRepository", 1, 9);
			String AltID=Excel_Lib.getData(INPUT_PATH_5, "TestRepository", 1, 4);
			String Comment=Excel_Lib.getData(INPUT_PATH_5, "TestRepository", 1, 5);
			actual[9]=ctc.enterTestCaseDetails(Priority, AltID, Comment);
			bp.waitForElement();
			String day=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestRepository", 1, 6));
			String hr=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestRepository", 1, 7));
			String mn=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestRepository", 1, 8));
			actual[10]=ctc.enterEstimatedTime(day, hr, mn);
			bp.waitForElement();
			actual[11]=tr.clickOnList();
			bp.waitForElement();
			String [] testcaseno=new String[1];
			testcaseno[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"TestRepository" , 1, 0));
			actual[12]=epp.selectMultipleTestCaseFromGrid(testcaseno);
			bp.waitForElement();
			actual[13]=tr.cloneTestCase();
			bp.waitForElement();
			actual[14]=tr.selectallTestCase();
			bp.waitForElement();
			for(int i=0;i<=3;i++)
			{
			actual[15]=tr.cloneTestCase();
			}
			bp.waitForElement();
			tr.clickOnRelease(Release);
			bp.waitForElement();
			actual[16]=tr.selectPhase(Phase);
			bp.waitForElement();
			actual[17]=tr.addNode(system1, s1_Desc);           //system1
			bp.waitForElement();
			tr.doubleClickOnRelease(Release);
			 bp.waitForElement();
			 String [] navigation72=new String[2];
			 navigation72[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 36, 0);
			 navigation72[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 36, 4);
			 tr.navigateToNode(Release, navigation72);
			 bp.waitForElement();
			actual[18]=tr.selectPhase(system1);
			bp.waitForElement();
			actual[19]=tr.addTestCase();
			bp.waitForElement();
			actual[20]=tr.clickOnDetails();
			bp.waitForElement();
			actual[21]=ctc.enterTestCaseNameAndDesc(testcaseName, testcaseDesc);
			bp.waitForElement();
			actual[22]=ctc.enterTestCaseDetails(Priority, AltID, Comment);
			bp.waitForElement();
			actual[23]=ctc.enterEstimatedTime(day, hr, mn);
			bp.waitForElement();
			actual[24]=tr.clickOnList();
			bp.waitForElement();
			actual[25]=epp.selectMultipleTestCaseFromGrid(testcaseno);
			bp.waitForElement();
			actual[26]=tr.cloneTestCase();
			bp.waitForElement();
			actual[27]=tr.selectallTestCase();
			bp.waitForElement();
			for(int i=0;i<=3;i++)
			{
			actual[28]=tr.cloneTestCase();
			}
			bp.waitForElement();
			tr.selectPhase(Phase);
			bp.waitForElement();
			actual[29]=tr.selectPhase(system1);
			bp.waitForElement();
			actual[30]=tr.addNode(sub_system01, sub01_Desc);       //subsystem01
			bp.waitForElement();
			tr.doubleClickOnRelease(Release);
			bp.waitForElement();
			 String [] navigation1=new String[3];
			 navigation1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 36, 0);
			 navigation1[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 36, 4);
			 navigation1[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 37, 4);
			 tr.navigateToNode(Release, navigation1);
			 bp.waitForElement();
			actual[31]=tr.selectPhase(sub_system01);
			bp.waitForElement();
			actual[32]=tr.addTestCase();
			bp.waitForElement();
			bp.waitForElement();
			actual[33]=tr.clickOnDetails();
			bp.waitForElement();
			actual[34]=ctc.enterTestCaseNameAndDesc(testcaseName, testcaseDesc);
			bp.waitForElement();
			actual[35]=ctc.enterTestCaseDetails(Priority, AltID, Comment);
			bp.waitForElement();
			actual[36]=ctc.enterEstimatedTime(day, hr, mn);
			bp.waitForElement();
			bp.waitForElement();
			actual[37]=tr.clickOnList();
			bp.waitForElement();
			testcaseno[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"TestRepository" , 1, 0));
			actual[38]=epp.selectMultipleTestCaseFromGrid(testcaseno);
			bp.waitForElement();
			actual[39]=tr.cloneTestCase();
			bp.waitForElement();
			actual[40]=tr.selectallTestCase();
			bp.waitForElement();
			for(int i=0;i<=3;i++)
			{
			actual[41]=tr.cloneTestCase();
			}
			bp.waitForElement();
			tr.selectPhase(system1);
			bp.waitForElement();
			actual[42]=tr.selectPhase(sub_system01);
			bp.waitForElement();
			actual[43]=tr.addNode(sub_system02, sub02_Desc);       //subsystem02
			bp.waitForElement();
			tr.doubleClickOnRelease(Release);
			bp.waitForElement();
			 String [] navigation2=new String[4];
			 navigation2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 36, 0);
			 navigation2[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 36, 4);
			 navigation2[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 37, 4);
			 navigation2[3]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 38, 4);
			 tr.navigateToNode(Release, navigation2);
			 bp.waitForElement();
			actual[44]=tr.selectPhase(sub_system02);
			bp.waitForElement();
			actual[45]=tr.addTestCase();
			bp.waitForElement();
			actual[46]=tr.clickOnDetails();
			bp.waitForElement();
			actual[47]=ctc.enterTestCaseNameAndDesc(testcaseName, testcaseDesc);
			bp.waitForElement();
			actual[48]=ctc.enterTestCaseDetails(Priority, AltID, Comment);
			bp.waitForElement();
			actual[49]=ctc.enterEstimatedTime(day, hr, mn);
			bp.waitForElement();
			bp.waitForElement();
			actual[50]=tr.clickOnList();
			bp.waitForElement();
			testcaseno[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"TestRepository" , 1, 0));
			actual[51]=epp.selectMultipleTestCaseFromGrid(testcaseno);
			bp.waitForElement();
			actual[52]=tr.cloneTestCase();
			bp.waitForElement();
			actual[53]=tr.selectallTestCase();
			bp.waitForElement();
			for(int i=0;i<=3;i++)
			{
			actual[54]=tr.cloneTestCase();
			}
			bp.waitForElement();
			tr.selectPhase(sub_system01);
			bp.waitForElement();
			actual[55]=tr.selectPhase(sub_system02);
			bp.waitForElement();
			actual[56]=tr.addNode(sub_system03, sub03_Desc);    //subsystem03
			bp.waitForElement();
			tr.doubleClickOnRelease(Release);
			bp.waitForElement();
			 String [] navigation3=new String[5];
			 navigation3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 36, 0);
			 navigation3[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 36, 4);
			 navigation3[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 37, 4);
			 navigation3[3]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 38, 4);
			 navigation3[4]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 39, 4);
			 tr.navigateToNode(Release, navigation3);
			 bp.waitForElement();
			actual[57]=tr.selectPhase(sub_system03);
			bp.waitForElement();
			actual[58]=tr.addTestCase();
			bp.waitForElement();
			actual[59]=tr.clickOnDetails();
			bp.waitForElement();
			actual[60]=ctc.enterTestCaseNameAndDesc(testcaseName, testcaseDesc);
			bp.waitForElement();
			actual[61]=ctc.enterTestCaseDetails(Priority, AltID, Comment);
			bp.waitForElement();
			actual[62]=ctc.enterEstimatedTime(day, hr, mn);
			bp.waitForElement();
			bp.waitForElement();
			actual[63]=tr.clickOnList();
			bp.waitForElement();
			testcaseno[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"TestRepository" , 1, 0));
			actual[64]=epp.selectMultipleTestCaseFromGrid(testcaseno);
			bp.waitForElement();
			actual[65]=tr.cloneTestCase();
			bp.waitForElement();
			actual[66]=tr.selectallTestCase();
			bp.waitForElement();
			for(int i=0;i<=3;i++)
			{
			actual[67]=tr.cloneTestCase();
			}
			bp.waitForElement();
			tr.selectPhase(sub_system02);
			bp.waitForElement();
			actual[68]=tr.selectPhase(sub_system03);
			bp.waitForElement();
			actual[69]=tr.addNode(sub_system04, sub04_Desc); //subsystem04
			bp.waitForElement();
			tr.doubleClickOnRelease(Release);
			bp.waitForElement();
			 String [] navigation4=new String[6];
			 navigation4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 36, 0);
			 navigation4[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 36, 4);
			 navigation4[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 37, 4);
			 navigation4[3]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 38, 4);
			 navigation4[4]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 39, 4);
			 navigation4[5]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 40, 4);
			 tr.navigateToNode(Release, navigation4);
			 bp.waitForElement();
			actual[70]=tr.selectPhase(sub_system04);
			bp.waitForElement();
			actual[71]=tr.addTestCase();
			bp.waitForElement();
			 actual[72]=tr.clickOnDetails();
			bp.waitForElement();
			actual[73]=ctc.enterTestCaseNameAndDesc(testcaseName, testcaseDesc);
			bp.waitForElement();
			actual[74]=ctc.enterTestCaseDetails(Priority, AltID, Comment);
			bp.waitForElement();
			actual[75]=ctc.enterEstimatedTime(day, hr, mn);
			bp.waitForElement();
			bp.waitForElement();
			actual[76]=tr.clickOnList();
			bp.waitForElement();
			testcaseno[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"TestRepository" , 1, 0));
			actual[77]=epp.selectMultipleTestCaseFromGrid(testcaseno);
			bp.waitForElement();
			actual[78]=tr.cloneTestCase();
			bp.waitForElement();
			actual[79]=tr.selectallTestCase();
			bp.waitForElement();
			for(int i=0;i<=3;i++)
			{
			actual[80]=tr.cloneTestCase();
			} 
			bp.waitForElement();
			tr.selectPhase(sub_system03);
			bp.waitForElement();
			actual[81]=tr.selectPhase(sub_system04);
			bp.waitForElement();
			actual[82]=tr.addNode(sub_system05, sub05_Desc);       //subsystem05
			bp.waitForElement();
			tr.doubleClickOnRelease(Release);
			bp.waitForElement();
			 String [] navigation5=new String[7];
			 navigation5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 36, 0);
			 navigation5[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 36, 4);
			 navigation5[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 37, 4);
			 navigation5[3]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 38, 4);
			 navigation5[4]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 39, 4);
			 navigation5[5]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 40, 4);
			 navigation5[6]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 41, 4);
			 tr.navigateToNode(Release, navigation5);
			 bp.waitForElement();
			actual[83]=tr.selectPhase(sub_system05);
			bp.waitForElement();
			actual[84]=tr.addTestCase();
			bp.waitForElement();
			actual[85]=tr.clickOnDetails();
			bp.waitForElement();
			actual[86]=ctc.enterTestCaseNameAndDesc(testcaseName, testcaseDesc);
			bp.waitForElement();
			actual[87]=ctc.enterTestCaseDetails(Priority, AltID, Comment);
			bp.waitForElement();
			actual[88]=ctc.enterEstimatedTime(day, hr, mn);
			bp.waitForElement();
			bp.waitForElement();
			actual[89]=tr.clickOnList();
			bp.waitForElement();
			testcaseno[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"TestRepository" , 1, 0));
			actual[90]=epp.selectMultipleTestCaseFromGrid(testcaseno);
			bp.waitForElement();
			actual[91]=tr.cloneTestCase();
			bp.waitForElement();
			actual[92]=tr.selectallTestCase();
			bp.waitForElement();
			for(int i=0;i<=3;i++)
			{
			actual[93]=tr.cloneTestCase();
			} 
			bp.waitForElement();
			tr.selectPhase(sub_system04);
			bp.waitForElement();
			actual[94]=tr.selectPhase(sub_system05);
			bp.waitForElement();
			actual[95]=tr.addNode(sub_system06, sub06_Desc);       //subsystem06
			bp.waitForElement();
			tr.doubleClickOnRelease(Release);
			bp.waitForElement();
			 String [] navigation6=new String[8];
			 navigation6[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 36, 0);
			 navigation6[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 36, 4);
			 navigation6[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 37, 4);
			 navigation6[3]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 38, 4);
			 navigation6[4]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 39, 4);
			 navigation6[5]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 40, 4);
			 navigation6[6]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 41, 4);
			 navigation6[7]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 42, 4);
			 tr.navigateToNode(Release, navigation6);
			 bp.waitForElement();
			actual[96]=tr.selectPhase(sub_system06);
			bp.waitForElement();
			actual[97]=tr.addTestCase();
			bp.waitForElement();
			actual[98]=tr.clickOnDetails();
			bp.waitForElement();
			actual[99]=ctc.enterTestCaseNameAndDesc(testcaseName, testcaseDesc);
			bp.waitForElement();
			actual[100]=ctc.enterTestCaseDetails(Priority, AltID, Comment);
			bp.waitForElement();
			actual[101]=ctc.enterEstimatedTime(day, hr, mn);
			bp.waitForElement();
			bp.waitForElement();
			actual[102]=tr.clickOnList();
			bp.waitForElement();
			testcaseno[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"TestRepository" , 1, 0));
			actual[103]=epp.selectMultipleTestCaseFromGrid(testcaseno);
			bp.waitForElement();
			actual[104]=tr.cloneTestCase();
			bp.waitForElement();
			actual[105]=tr.selectallTestCase();
			bp.waitForElement();
			for(int i=0;i<=3;i++)
			{
			actual[106]=tr.cloneTestCase();
			} 
			bp.waitForElement();
			tr.selectPhase(sub_system05);
			bp.waitForElement();
			actual[107]=tr.selectPhase(sub_system06);
			bp.waitForElement();
			actual[108]=tr.addNode(sub_system07, sub07_Desc);       //subsystem07
			bp.waitForElement();
			tr.doubleClickOnRelease(Release);
			bp.waitForElement();
			 String [] navigation7=new String[9];
			 navigation7[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 36, 0);
			 navigation7[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 36, 4);
			 navigation7[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 37, 4);
			 navigation7[3]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 38, 4);
			 navigation7[4]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 39, 4);
			 navigation7[5]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 40, 4);
			 navigation7[6]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 41, 4);
			 navigation7[7]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 42, 4);
			 navigation7[8]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 43, 4);
			 tr.navigateToNode(Release, navigation7);
			 bp.waitForElement();
			actual[109]=tr.selectPhase(sub_system07);
			bp.waitForElement();
			actual[110]=tr.addTestCase();
			bp.waitForElement();
			actual[111]=tr.clickOnDetails();
			bp.waitForElement();
			actual[112]=ctc.enterTestCaseNameAndDesc(testcaseName, testcaseDesc);
			bp.waitForElement();
			actual[113]=ctc.enterTestCaseDetails(Priority, AltID, Comment);
			bp.waitForElement();
			actual[114]=ctc.enterEstimatedTime(day, hr, mn);
			bp.waitForElement();
			bp.waitForElement();
			actual[115]=tr.clickOnList();
			bp.waitForElement();
			testcaseno[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"TestRepository" , 1, 0));
			actual[116]=epp.selectMultipleTestCaseFromGrid(testcaseno);
			bp.waitForElement();
			actual[117]=tr.cloneTestCase();
			bp.waitForElement();
			actual[118]=tr.selectallTestCase();
			bp.waitForElement();
			for(int i=0;i<=3;i++)
			{
			actual[119]=tr.cloneTestCase();
			} 
			bp.waitForElement();
			tr.selectPhase(sub_system06);
			bp.waitForElement();
			actual[120]=tr.selectPhase(sub_system07);
			bp.waitForElement();
			actual[121]=tr.addNode(sub_system08, sub08_Desc);       //subsystem08
			bp.waitForElement();
			tr.doubleClickOnRelease(Release);
			bp.waitForElement();
			 String [] navigation8=new String[10];
			 navigation8[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 36, 0);
			 navigation8[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 36, 4);
			 navigation8[2]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 37, 4);
			 navigation8[3]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 38, 4);
			 navigation8[4]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 39, 4);
			 navigation8[5]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 40, 4);
			 navigation8[6]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 41, 4);
			 navigation8[7]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 42, 4);
			 navigation8[8]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 43, 4);
			 navigation8[9]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 44, 4);
			 tr.navigateToNode(Release, navigation8);
			 bp.waitForElement();
			actual[122]=tr.selectPhase(sub_system08);
			bp.waitForElement();
			actual[123]=tr.addTestCase();
			bp.waitForElement();
			actual[124]=tr.clickOnDetails();
			bp.waitForElement();
			actual[125]=ctc.enterTestCaseNameAndDesc(testcaseName, testcaseDesc);
			bp.waitForElement();
			actual[126]=ctc.enterTestCaseDetails(Priority, AltID, Comment);
			bp.waitForElement();
			actual[127]=ctc.enterEstimatedTime(day, hr, mn);
			bp.waitForElement();
			bp.waitForElement();
			actual[128]=tr.clickOnList();
			bp.waitForElement();
			testcaseno[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"TestRepository" , 1, 0));
			actual[129]=epp.selectMultipleTestCaseFromGrid(testcaseno);
			bp.waitForElement();
			actual[130]=tr.cloneTestCase();
			bp.waitForElement();
			actual[131]=tr.selectallTestCase();
			bp.waitForElement();
			for(int i=0;i<=3;i++)
			{
			actual[132]=tr.cloneTestCase();
			} 
			bp.waitForElement();
			 String releaseName=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
				tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
	         }
	catch (Exception e)
	{
		lb.getScreenShot(filename);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
      }

	@When("^Launch Testplanning and create new cycle$")
	public void launch_Testplanning_and_create_new_cycle() throws Throwable {
		try {
			tp=new TestPlanningPage(driver);
			actual[133]=rp.clickOnTestPlanning();
			bp.waitForElement();
			actual[134]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",20, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
			String environ=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
			actual[135]=tp.CreateCycle(cycle, Build, environ, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1,1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1,4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
			actual[136]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[137]=tp.saveTestCycle();
			bp.waitForElement();
			
	        }
	catch (Exception e)
	{lb.getScreenShot(filename);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
      }

	@When("^Add phase to cycle and assign testcases to Tester$")
	public void add_phase_to_cycle_and_assign_testcases_to_Tester() throws Throwable {
		try {
			
			String cycle[]=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",20, 0);
			actual[138]=tp.navigateToCycle(cycle);
			bp.waitForElement();
			actual[139]=tp.addPhaseToCycle(Phase);
			bp.waitForElement();
			actual[140]=tp.cancelBulkAssign();
			bp.waitForElement();
			actual[141]=tr.selectPhase(Phase);
			bp.waitForElement();
			actual[142]=tp.bulkAssignTestcasesSelectedFolder();
			bp.waitForElement();
			String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
			String Check=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
			actual[143]=tp.assignAllUnassigned(assignee, Check);
			bp.waitForElement();
			tp.goBackToCycle();
			pp.clickOnLogout();
			
		     }
	catch (Exception e)
	{lb.getScreenShot(filename);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
      }

	@When("^Login as a Tester and Launch Test Execution$")
	public void login_as_a_Tester_and_Launch_Test_Execution() throws Throwable {
		try {
			
			lp=new LoginPage(driver);
			pp=new ProjectPage(driver);
			rp=new ReleasePage(driver);
			bp=new BasePage();
			ep=new ExecutionPage(driver);
			tp=new TestPlanningPage(driver);
			tr=new TestRepositoryPage(driver);
			String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Tester_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Password_1");
			actual[144]=lp.enterUname(userName);
			actual[145]=lp.enterPass(password);
			bp.waitForElement();
			actual[146]=lp.clickOnLogin();
			bp.waitForElement();
			actual[147]=pp.selectProject(Project);
			bp.waitForElement();
			actual[148]=pp.selectRelease(Release);
			bp.waitForElement();
			actual[149]=rp.clickOnTestExecution();
			bp.waitForElement();
			
			
	         }
	catch (Exception e)
	{lb.getScreenShot(filename);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
      }

	@When("^As Tester Sort Grids$")
	public void as_Tester_Sort_Grids() throws Throwable {
		try {
			String cycle[]=new String[3];
			cycle[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",20, 0);
			cycle[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 36,0);
			actual[150]=tp.navigateToCycle(cycle);
			bp.waitForElement();
			String ID[]=new String[1];
			ID[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 2, 7);
			actual[151]=ep.sort(ID);
			bp.waitForElement();
			
	        }
	catch (Exception e)
	{lb.getScreenShot(filename);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
      }

	@Then("^Grids should be sorted based on details$")
	public void grids_should_be_sorted_based_on_details() throws Throwable {
		try {
			String ID[]=new String[1];
			ID[0]="Test Case ID";
			//ID[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 2, 7);
			actual[152]=ep.validateSort(ID);
			bp.waitForElement();
			tp=new TestPlanningPage(driver);
			String [] Release=new String[1];
			Release[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			tp.navigateToCycle(Release);
			bp.waitForElement();
//			actual[77]=pp.clickOnLogout();
//		    pp.closeBrowser();
//			
			for(int k=0;k<=actual.length-1;k++)
			{
			  System.out.println("Actual["+k+"]="+actual[k]);	
			  soft.assertEquals(actual[k], true);
			}
			soft.assertAll();
	         }
	catch (Exception e)
	{lb.getScreenShot(filename);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
      }

	

}
