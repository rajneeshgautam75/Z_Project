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

public class Search_868214 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	String fileName="Search_868214";
	
	boolean[] actual=new boolean[173];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in a page testreposItory$")
	public void user_is_in_a_page_testreposItory() throws Throwable {
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
		   
		   }
		   catch(Exception e)
			{
			   lb=new LaunchBrowser();
               lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}  
	}

	@When("^User creates a phase and Creates testcases with tag containing different characters$")
	public void user_creates_a_phase_and_Creates_testcases_with_tag_containing_different_characters() throws Throwable {
		try
		   {
			   tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 18, 1);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 18, 2);
				
				bp=new BasePage();
				actual[3]=tr.doubleClickOnRelease(releaseName);
				 bp.waitForElement();
				actual[4]=tr.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
				actual[5]=tr.doubleClickOnRelease(releaseName);
				String[] phase=new String[1];
				phase[0]=p_Name1;
				 bp.waitForElement();
				actual[6]=tr.navigateToNode(releaseName, phase);
				tr.addTestCase();
				bp.waitForElement();
				String[] testCaseNo1=new String[1];
				testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"TestPlanning", 1, 8));
				ep=new ExportPage(driver);
				ep.selectMultipleTestCaseFromGrid(testCaseNo1);
				bp.waitForElement();
				actual[7]=tr.clickDetailButton();
				bp.waitForElement();
		
				//characters only
				String[] tags1=new String[1];
				tags1[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 12);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[8]=ctc.enterMultipletags(tags1);
				bp.waitForElement();
				
				//numbers only
				actual[9]=tr.clickOnList();
				bp.waitForElement();
				actual[10]=tr.addTestCase();
				bp.waitForElement();
				String[] testCaseNo2=new String[1];
				testCaseNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"TestPlanning", 2, 8));
				ep=new ExportPage(driver);
				ep.selectMultipleTestCaseFromGrid(testCaseNo2);
				bp.waitForElement();
				actual[11]=tr.clickDetailButton();
				String[] tags2=new String[1];
				tags2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "FreeForm", 1, 8));
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[12]=ctc.enterMultipletags(tags2);
				bp.waitForElement();
				
				//alphanumeric characters only
				actual[13]=tr.clickOnList();
				bp.waitForElement();
				actual[14]=tr.addTestCase();
				bp.waitForElement();
				String[] testCaseNo3=new String[1];
				testCaseNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"TestPlanning", 3, 8));
				ep=new ExportPage(driver);
				ep.selectMultipleTestCaseFromGrid(testCaseNo3);
				bp.waitForElement();
				actual[15]=tr.clickDetailButton();
				String[] tags3=new String[1];
				tags3[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 9);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[16]=ctc.enterMultipletags(tags3);
				bp.waitForElement();
				
				//uppercase only
				actual[17]=tr.clickOnList();
				bp.waitForElement();
				actual[18]=tr.addTestCase();
				bp.waitForElement();
				String[] testCaseNo4=new String[1];
				testCaseNo4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"TestPlanning", 4, 8));
				ep=new ExportPage(driver);
				ep.selectMultipleTestCaseFromGrid(testCaseNo4);
				bp.waitForElement();
				actual[19]=tr.clickDetailButton();
				String[] tags4=new String[1];
				tags4[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 4, 7);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[20]=ctc.enterMultipletags(tags4);
				bp.waitForElement();
				
				//lowercase only
				actual[21]=tr.clickOnList();
				bp.waitForElement();
				actual[22]=tr.addTestCase();
				bp.waitForElement();
				String[] testCaseNo5=new String[1];
				testCaseNo5[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"TestPlanning", 5, 8));
				ep=new ExportPage(driver);
				ep.selectMultipleTestCaseFromGrid(testCaseNo5);
				bp.waitForElement();
				actual[23]=tr.clickDetailButton();
				String[] tags5=new String[1];
				tags5[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 4, 6);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[24]=ctc.enterMultipletags(tags5);
				bp.waitForElement();
				
				//international characters only
				bp.waitForElement();
				actual[25]=tr.clickOnList();
				bp.waitForElement();
				actual[26]=tr.addTestCase();
				bp.waitForElement();
				String[] testCaseNo6=new String[1];
				testCaseNo6[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"TestPlanning", 6, 8));
				ep=new ExportPage(driver);
				ep.selectMultipleTestCaseFromGrid(testCaseNo6);
				bp.waitForElement();
				actual[27]=tr.clickDetailButton();
				String[] tags6=new String[1];
				tags6[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 10);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[28]=ctc.enterMultipletags(tags6);
				bp.waitForElement();
				
				//single characters only
				bp.waitForElement();
				actual[29]=tr.clickOnList();
				bp.waitForElement();
				actual[30]=tr.addTestCase();
				bp.waitForElement();
				String[] testCaseNo7=new String[1];
				testCaseNo7[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"TestPlanning", 7, 8));
				ep=new ExportPage(driver);
				ep.selectMultipleTestCaseFromGrid(testCaseNo7);
				bp.waitForElement();
				actual[31]=tr.clickDetailButton();
				String[] tags7=new String[1];
				tags7[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 13);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[32]=ctc.enterMultipletags(tags7);
				bp.waitForElement();
				
				//long characters only
				bp.waitForElement();
				actual[33]=tr.clickOnList();
				bp.waitForElement();
				actual[34]=tr.addTestCase();
				bp.waitForElement();
				String[] testCaseNo8=new String[1];
				testCaseNo8[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"TestPlanning", 8, 8));
				ep=new ExportPage(driver);
				ep.selectMultipleTestCaseFromGrid(testCaseNo8);
				bp.waitForElement();
				actual[35]=tr.clickDetailButton();
				String[] tags8=new String[1];
				tags8[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 14);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[36]=ctc.enterMultipletags(tags8);
				bp.waitForElement();
				tr.clickOnList();
				bp.waitForElement();
		   }
		catch(Exception e)
		{
			lb=new LaunchBrowser();
            lb.getScreenShot(fileName);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}  
		
	}

	@When("^User Launches TestPlanning and creaTes a cycle$")
	public void user_Launches_TestPlanning_and_creaTes_a_cycle() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[37]=rp.clickOnTestPlanning();
			  bp.waitForElement();
//			  rp.clickOnTestPlanning();
//			  bp.waitForElement();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 18, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[38]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[39]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[40]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[41]=tp.saveTestCycle();
		   }
		   catch(Exception e)
			{
			   lb=new LaunchBrowser();
               lb.getScreenShot(fileName);
			   e.printStackTrace();
				driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			} 
	}

	@When("^User creates a freeform phase across cycle context menu$")
	public void user_creates_a_freeform_phase_across_cycle_context_menu() throws Throwable {
		try
	    {
			actual[42]=bp.waitForElement();
			//actual[42]=rp.clickOnTestPlanning();
			
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 18, 0);
			bp.waitForElement();
			actual[43]=tp.navigateToCycle(cycle);
			
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 18, 1);
			actual[44]=tp.createFreeFormPhase(phaseName);
			bp.waitForElement();
			
			}
			catch(Exception e)
			{
				lb=new LaunchBrowser();
	               lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}
	}

	@When("^User launches a Add Testcase window and selects advanced search$")
	public void user_launches_a_Add_Testcase_window_and_selects_advanced_search() throws Throwable {
		try
		{
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",18 ,1 );
		     bp.waitForElement();
		     actual[45]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[46]=tp.clickOnAddTestcasesToFreeForm();
		     
		     bp.waitForElement();
			 actual[47]=tp.clickOnAdvanceSearch();
		    
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
            lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}   
	}

	@When("^User search a testcase tag with different operators and different characters$")
	public void user_search_a_testcase_tag_with_different_operators_and_different_characters() throws Throwable {
	    	 try
	 	    {
	 	    	String name1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,0 );
	 	    	String operator1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,1 );
	 	    	String value1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",2 ,12 );//characters only
	 	    	bp.waitForElement();
	 	    	actual[48]=tp.ZQLSearch1(name1, operator1, value1);
	 	    	actual[49]=tp.validateSearch();
	 	    	bp.waitForElement();
	 	    	actual[50]=tp.selectAllFreeFormTestCases();
	 		     bp.waitForElement();
	 		     //tp.clickOnCheckBoxSaveAllTestcases();
	 		     
	 		     bp.waitForElement();
	 		     actual[51]=tp.clickOnSaveAndOk();
	 		     
	 		     bp.waitForElement();
	 		 	actual[52]=tp.closeFreeFormPage();
	 	    
	 	    	//numbers only
	 		 	String[] cycleName2=new String[1];
	 		     cycleName2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",18 ,1 );
	 		     bp.waitForElement();
	 		     actual[53]=tp.navigateToCycle(cycleName2);
	 		     
	 		     bp.waitForElement();
	 		     actual[54]=tp.clickOnAddTestcasesToFreeForm();

	 		     bp.waitForElement();
	 		     actual[55]=tp.clickOnAdvanceSearch();
	 	    	
	 	    	String name2=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,0 );
	 	    	String operator2=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,1 );
	 	    	String value2=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",2 ,8 );
	 	    	bp.waitForElement();
	 	    	actual[56]=tp.ZQLSearch1(name2, operator2, value2);
	 	    	actual[57]=tp.validateSearch();
	 	    	bp.waitForElement();
	 	    	actual[58]=tp.selectAllFreeFormTestCases();
	 		     bp.waitForElement();
	 		     //tp.clickOnCheckBoxSaveAllTestcases();
	 		     
	 		     bp.waitForElement();
	 		     actual[59]=tp.clickOnSaveAndOk();
	 		     
	 		     bp.waitForElement();
	 		 	actual[60]=tp.closeFreeFormPage();
	 	    	
	 	    	//alphanumeric only
	 		 	String[] cycleName3=new String[1];
	 		     cycleName3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",18 ,1 );
	 		     bp.waitForElement();
	 		     actual[61]=tp.navigateToCycle(cycleName3);
	 		     
	 		     bp.waitForElement();
	 		     actual[62]=tp.clickOnAddTestcasesToFreeForm();
	 		     
	 		     bp.waitForElement();
	 		     actual[63]=tp.clickOnAdvanceSearch();
	 	    	String name3=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,0 );
	 	    	String operator3=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",10,1 );
	 	    	String value3=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",2,9);
	 	    	bp.waitForElement();
	 	    	actual[64]=tp.ZQLSearch1(name3, operator3, value3);
	 	    	actual[65]=tp.validateSearch();
	 	    	bp.waitForElement();
	 	    	actual[66]=tp.selectAllFreeFormTestCases();
	 		     bp.waitForElement();
	 		     
	 		     actual[67]=tp.clickOnSaveAndOk();
	 		     bp.waitForElement();
	 	    	actual[68]=tp.closeFreeFormPage();
	 	    	bp.waitForElement();
	 	    	
	 	    	//Uppercase Only
	 	    	String[] cycleName4=new String[1];
	 		     cycleName4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",18 ,1 );
	 		     bp.waitForElement();
	 		     actual[69]=tp.navigateToCycle(cycleName4);
	 		     
	 		     bp.waitForElement();
	 		     actual[70]=tp.clickOnAddTestcasesToFreeForm();
	 		     bp.waitForElement();
	 		     actual[71]=tp.clickOnAdvanceSearch();
	 	    	String name4=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,0 );
	 	    	String operator4=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,1 );
	 	    	String value4=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",4 ,7 );
	 	    	bp.waitForElement();
	 	    	actual[72]=tp.ZQLSearch1(name4, operator4, value4);
	 	    	actual[73]=tp.validateSearch();
	 	    	bp.waitForElement();
	 	    	actual[74]=tp.selectAllFreeFormTestCases();
	 		     
	 		     bp.waitForElement();
	 		     actual[75]=tp.clickOnSaveAndOk();
	 		     bp.waitForElement();
	 	    	actual[76]=tp.closeFreeFormPage();
	 	    	bp.waitForElement();
	 	    	
	 	    	
	 	    	String[] cycleName5=new String[1];
	 		     cycleName5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",18 ,1 );
	 		     bp.waitForElement();
	 		     actual[77]=tp.navigateToCycle(cycleName5);
	 		     
	 		     bp.waitForElement();
	 		     actual[78]=tp.clickOnAddTestcasesToFreeForm();
	 		     bp.waitForElement();
	 		     actual[79]=tp.clickOnAdvanceSearch();
	 	    	String name5=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,0 );
	 	    	String operator5=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,1 );
	 	    	String value5=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",3,6 );//lowercase only
	 	    	bp.waitForElement();
	 	    	actual[80]=tp.ZQLSearch1(name5, operator5, value5);
	 	    	actual[81]=tp.validateSearch();
	 	    	bp.waitForElement();
	 	    	actual[82]=tp.selectAllFreeFormTestCases();
	 		     bp.waitForElement();
	 		     
	 		     bp.waitForElement();
	 		     actual[83]=tp.clickOnSaveAndOk();
	 		     bp.waitForElement();
	 	    	actual[84]=tp.closeFreeFormPage();
	 	    	
	 	    	String[] cycleName6=new String[1];
	 		     cycleName6[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",18 ,1 );
	 		     bp.waitForElement();
	 		     actual[85]=tp.navigateToCycle(cycleName6);
	 		     
	 		     bp.waitForElement();
	 		     actual[86]=tp.clickOnAddTestcasesToFreeForm();
	 		     bp.waitForElement();
	 		     actual[87]=tp.clickOnAdvanceSearch();
	 	    	String name6=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,0 );
	 	    	String operator6=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,1 );
	 	    	String value6=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",2 ,10 );//international characters
	 	    	bp.waitForElement();
	 	    	actual[88]=tp.ZQLSearch1(name6, operator6, value6);
	 	    	actual[89]=tp.validateSearch();
	 	    	bp.waitForElement();
	 	    	actual[90]=tp.selectAllFreeFormTestCases();
	 		     bp.waitForElement();
	 		     
	 		     bp.waitForElement();
	 		     actual[91]=tp.clickOnSaveAndOk();
	 		     bp.waitForElement();
	 	    	actual[92]=tp.closeFreeFormPage();
	 	    	
	 	    	
	 	    	String[] cycleName7=new String[1];
	 		     cycleName7[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",18 ,1 );
	 		     bp.waitForElement();
	 		     actual[93]=tp.navigateToCycle(cycleName7);
	 		     
	 		     bp.waitForElement();
	 		     actual[94]=tp.clickOnAddTestcasesToFreeForm();
	 		     bp.waitForElement();
	 		     actual[95]=tp.clickOnAdvanceSearch();
	 	    	String name7=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,0 );
	 	    	String operator7=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,1 );
	 	    	String value7=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",2 ,13 );//single character
	 	    	bp.waitForElement();
	 	    	actual[96]=tp.ZQLSearch1(name7, operator7, value7);
	 	    	actual[97]=tp.validateSearch();
	 	    	bp.waitForElement();
	 	    	actual[98]=tp.selectAllFreeFormTestCases();
	 		     bp.waitForElement();
	 		     
	 		     bp.waitForElement();
	 		     actual[99]=tp.clickOnSaveAndOk();
	 		     bp.waitForElement();
	 	    	actual[100]=tp.closeFreeFormPage();
	 	    	
	 	    	String[] cycleName8=new String[1];
	 		     cycleName8[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",18 ,1 );
	 		     bp.waitForElement();
	 		     actual[101]=tp.navigateToCycle(cycleName8);
	 		     
	 		     bp.waitForElement();
	 		     actual[102]=tp.clickOnAddTestcasesToFreeForm();
	 		     bp.waitForElement();
	 		     actual[103]=tp.clickOnAdvanceSearch();
	 	    	String name8=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,0 );
	 	    	String operator8=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,1 );
	 	    	String value8=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",2 ,14 );
	 	    	bp.waitForElement();
	 	    	actual[104]=tp.ZQLSearch1(name8, operator8, value8);
	 	    	actual[105]=tp.validateSearch();
	 	    	bp.waitForElement();
	 	    	actual[106]=tp.selectAllFreeFormTestCases();
	 		     bp.waitForElement();
	 		     
	 		     actual[107]=tp.clickOnSaveAndOk();
	 		     bp.waitForElement();
	 	    	actual[108]=tp.closeFreeFormPage();
	 	    	bp.waitForElement();
	 	    	
	 	    	
	 	    	String[] cycleName9=new String[1];
			     cycleName9[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",18 ,1 );
			     bp.waitForElement();
			     actual[109]=tp.navigateToCycle(cycleName9);
			     
			     bp.waitForElement();
			     actual[110]=tp.clickOnAddTestcasesToFreeForm();
			     
			     bp.waitForElement();
				 actual[111]=tp.clickOnAdvanceSearch();
				 String name9=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,0 );
		 	    	String operator9=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",13 ,1 );
		 	    	String value9=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",2 ,12 );//characters only
		 	    	bp.waitForElement();
		 	    	actual[112]=tp.ZQLSearch1(name9, operator9, value9);
		 	    	actual[113]=tp.validateSearch();
		 	    	bp.waitForElement();
		 	    	actual[114]=tp.selectAllFreeFormTestCases();
		 		     bp.waitForElement();
		 		     //tp.clickOnCheckBoxSaveAllTestcases();
		 		     
		 		     bp.waitForElement();
		 		     actual[115]=tp.clickOnSaveAndOk();
		 		     
		 		     bp.waitForElement();
		 		 	actual[116]=tp.closeFreeFormPage();
		 	    
		 	    	//numbers only
		 		 	String[] cycleName10=new String[1];
		 		     cycleName10[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",18 ,1 );
		 		     bp.waitForElement();
		 		     actual[117]=tp.navigateToCycle(cycleName10);
		 		     
		 		     bp.waitForElement();
		 		     actual[118]=tp.clickOnAddTestcasesToFreeForm();

		 		     bp.waitForElement();
		 		     actual[119]=tp.clickOnAdvanceSearch();
		 	    	
		 	    	String name10=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,0 );
		 	    	String operator10=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",13 ,1 );
		 	    	String value10=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",2 ,8 );
		 	    	bp.waitForElement();
		 	    	actual[120]=tp.ZQLSearch1(name10, operator10, value10);
		 	    	actual[121]=tp.validateSearch();
		 	    	bp.waitForElement();
		 	    	actual[122]=tp.selectAllFreeFormTestCases();
		 		     bp.waitForElement();
		 		     
		 		     bp.waitForElement();
		 		     actual[123]=tp.clickOnSaveAndOk();
		 		     
		 		     bp.waitForElement();
		 		 	actual[124]=tp.closeFreeFormPage();
		 	    	
		 	    	//alphanumeric only
		 		 	String[] cycleName11=new String[1];
		 		     cycleName11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",18 ,1 );
		 		     bp.waitForElement();
		 		     actual[125]=tp.navigateToCycle(cycleName11);
		 		     
		 		     bp.waitForElement();
		 		     actual[126]=tp.clickOnAddTestcasesToFreeForm();
		 		     
		 		     bp.waitForElement();
		 		     actual[127]=tp.clickOnAdvanceSearch();
		 	    	String name11=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,0 );
		 	    	String operator11=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",10,1 );
		 	    	String value11=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",2,9 );
		 	    	bp.waitForElement();
		 	    	actual[128]=tp.ZQLSearch1(name11, operator11, value11);
		 	    	actual[129]=tp.validateSearch();
		 	    	bp.waitForElement();
		 	    	actual[130]=tp.selectAllFreeFormTestCases();
		 		     bp.waitForElement();
		 		     
		 		     actual[131]=tp.clickOnSaveAndOk();
		 		     bp.waitForElement();
		 	    	actual[132]=tp.closeFreeFormPage();
		 	    	bp.waitForElement();
		 	    	
		 	    	//Uppercase Only
		 	    	String[] cycleName12=new String[1];
		 		     cycleName12[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",18 ,1 );
		 		     bp.waitForElement();
		 		     actual[133]=tp.navigateToCycle(cycleName12);
		 		     
		 		     bp.waitForElement();
		 		     actual[134]=tp.clickOnAddTestcasesToFreeForm();
		 		     bp.waitForElement();
		 		     actual[135]=tp.clickOnAdvanceSearch();
		 	    	String name12=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,0 );
		 	    	String operator12=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",13 ,1 );
		 	    	String value12=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",4 ,7 );
		 	    	bp.waitForElement();
		 	    	actual[136]=tp.ZQLSearch1(name12, operator12, value12);
		 	    	actual[137]=tp.validateSearch();
		 	    	bp.waitForElement();
		 	    	actual[138]=tp.selectAllFreeFormTestCases();
		 		     
		 		     bp.waitForElement();
		 		     actual[139]=tp.clickOnSaveAndOk();
		 	    	actual[140]=tp.closeFreeFormPage();
		 	    	bp.waitForElement();
		 	    	
		 	    	
		 	    	String[] cycleName13=new String[1];
		 		     cycleName13[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",18 ,1 );
		 		     bp.waitForElement();
		 		     actual[141]=tp.navigateToCycle(cycleName13);
		 		     
		 		     bp.waitForElement();
		 		     actual[142]=tp.clickOnAddTestcasesToFreeForm();
		 		     bp.waitForElement();
		 		     actual[143]=tp.clickOnAdvanceSearch();
		 	    	String name13=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,0 );
		 	    	String operator13=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",13 ,1 );
		 	    	String value13=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",3,6 );//lowercase only
		 	    	bp.waitForElement();
		 	    	actual[144]=tp.ZQLSearch1(name13, operator13, value13);
		 	    	actual[145]=tp.validateSearch();
		 	    	bp.waitForElement();
		 	    	actual[146]=tp.selectAllFreeFormTestCases();
		 		     bp.waitForElement();
		 		     
		 		     bp.waitForElement();
		 		     actual[147]=tp.clickOnSaveAndOk();
		 		     bp.waitForElement();
		 	    	actual[148]=tp.closeFreeFormPage();
		 	    	
		 	    	String[] cycleName14=new String[1];
		 		     cycleName14[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",18 ,1 );
		 		     bp.waitForElement();
		 		     actual[149]=tp.navigateToCycle(cycleName14);
		 		     
		 		     bp.waitForElement();
		 		     actual[150]=tp.clickOnAddTestcasesToFreeForm();
		 		     bp.waitForElement();
		 		     actual[151]=tp.clickOnAdvanceSearch();
		 	    	String name14=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,0 );
		 	    	String operator14=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",13 ,1 );
		 	    	String value14=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",2 ,10 );//international characters
		 	    	bp.waitForElement();
		 	    	actual[152]=tp.ZQLSearch1(name14, operator14, value14);
		 	    	actual[153]=tp.validateSearch();
		 	    	bp.waitForElement();
		 	    	actual[154]=tp.selectAllFreeFormTestCases();
		 		     bp.waitForElement();
		 		     
		 		     bp.waitForElement();
		 		     actual[155]=tp.clickOnSaveAndOk();
		 		     bp.waitForElement();
		 	    	actual[156]=tp.closeFreeFormPage();
		 	    	
		 	    	
		 	    	String[] cycleName15=new String[1];
		 		     cycleName15[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",18 ,1 );
		 		     bp.waitForElement();
		 		     actual[157]=tp.navigateToCycle(cycleName15);
		 		     
		 		     bp.waitForElement();
		 		     actual[158]=tp.clickOnAddTestcasesToFreeForm();
		 		     bp.waitForElement();
		 		     actual[159]=tp.clickOnAdvanceSearch();
		 	    	String name15=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,0 );
		 	    	String operator15=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",13 ,1 );
		 	    	String value15=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",2 ,13 );//single character
		 	    	bp.waitForElement();
		 	    	actual[160]=tp.ZQLSearch1(name15, operator15, value15);
		 	    	actual[161]=tp.validateSearch();
		 	    	bp.waitForElement();
		 	    	actual[162]=tp.selectAllFreeFormTestCases();
		 		     bp.waitForElement();
		 		     
		 		     bp.waitForElement();
		 		     actual[163]=tp.clickOnSaveAndOk();
		 		     bp.waitForElement();
		 	    	actual[164]=tp.closeFreeFormPage();
		 	    	
		 	    	String[] cycleName16=new String[1];
		 		     cycleName16[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",18 ,1 );
		 		     bp.waitForElement();
		 		     actual[165]=tp.navigateToCycle(cycleName16);
		 		     
		 		     bp.waitForElement();
		 		     actual[166]=tp.clickOnAddTestcasesToFreeForm();
		 		     bp.waitForElement();
		 		     actual[167]=tp.clickOnAdvanceSearch();
		 	    	String name16=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",9 ,0 );
		 	    	String operator16=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails",13 ,1 );
		 	    	String value16=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",2 ,14 );
		 	    	bp.waitForElement();
		 	    	actual[168]=tp.ZQLSearch1(name16, operator16, value16);
		 	    	actual[169]=tp.validateSearch();
		 	    	bp.waitForElement();
		 	    	actual[170]=tp.selectAllFreeFormTestCases();
		 		     bp.waitForElement();
		 		     
		 		     actual[171]=tp.clickOnSaveAndOk();
		 		     bp.waitForElement();
		 	    	actual[172]=tp.closeFreeFormPage();
		 	    	bp.waitForElement();
		 	    	bp.waitForElement();
				 	tp.selectallTestCase();
				 	bp.waitForElement();
				 	String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
				 	tp.assignAllSelected(assignee);
				 	bp.waitForElement();
				 	bp.waitForElement();
				 	tp.goBackToCycle();
	    }
	    catch(Exception e)
		{
	    	lb=new LaunchBrowser();
            lb.getScreenShot(fileName);
	    	e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}  
	}

	@Then("^User Should be able to search Testcases by 'name' using ZQL with different operators and different characters and add it to free form phase$")
	public void user_Should_be_able_to_search_Testcases_by_name_using_ZQL_with_different_operators_and_different_characters_and_add_it_to_free_form_phase() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("User Should be able to search Testcases by 'name' using ZQL with different operators and different characters and add it to free form phase");
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
            lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}
}
