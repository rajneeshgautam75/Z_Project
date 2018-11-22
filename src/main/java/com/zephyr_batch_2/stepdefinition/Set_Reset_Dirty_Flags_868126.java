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
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Set_Reset_Dirty_Flags_868126 extends LaunchBrowser {


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
	String fileName="Set_Reset_868126";
	
	boolean[] actual=new boolean[74];
	SoftAssert soft=new SoftAssert();
@Given("^User is in a page of TestRepository page$")
public void user_is_in_a_page_of_TestRepository_page() throws Throwable {
	/*lb=new LaunchBrowser();
	   lb.preCond();
	   lp=new LoginPage(driver);
	   String Uname=Excel_Lib.getData(INPUT_PATH_3,"Login",0,1);
	   String Pass=Excel_Lib.getData(INPUT_PATH_3,"Login",1,1);
	   lp.enterUname(Uname);
	   lp.enterPass(Pass);
	   lp.clickOnLogin();*/
	   try
	   {
	   pp=new ProjectPage(driver);
	   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
	   actual[0]=pp.selectProject(projectName);
	   actual[1]=pp.selectRelease(releaseName);
	   
	   rp= new ReleasePage(driver);
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

@Given("^User creates a phase$")
public void user_creates_a_phase() throws Throwable {
	try
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
	  String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 14, 12);
	  String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 14, 15);
	  
	  tr=new TestRepositoryPage(driver);
	  bp=new BasePage();
	  bp.waitForElement();
	  actual[3]=tr.doubleClickOnRelease(releaseName);
	 // bp.waitForElement();
	  bp.waitForElement();
	 actual[4]= tr.addNode(p_Name1,p_Desc1);
	 tr.doubleClickOnRelease(releaseName);
	 String[] phase=new String[1];
	 phase[0]=p_Name1;
	 tr.navigateToNode(releaseName, phase);
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

@When("^User creates a testcase under the phase$")
public void user_creates_a_testcase_under_the_phase() throws Throwable {
	
	try
	{
		bp.waitForElement();
	actual[5]=tr.addTestCase(); 
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

@When("^User performs the edit operation on a created testcase$")
public void user_performs_the_edit_operation_on_a_created_testcase() throws Throwable {
	try
	{
	tr=new TestRepositoryPage(driver);
	bp.waitForElement();
	bp.waitForElement();
	actual[6]=tr.clickDetailButton();
	ctc=new CreateTestCasePage(driver);
	String tcName=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 1, 0);
	String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 0);
	
	actual[7]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
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

@When("^User selects a created testcase and clicks a clone button$")
public void user_selects_a_created_testcase_and_clicks_a_clone_button() throws Throwable {
	try
	{
		tr=new TestRepositoryPage(driver);
		bp.waitForElement();
		bp.waitForElement();
		actual[8]=tr.clickOnList();
		bp.waitForElement();
		actual[9]=tr.selectallTestCase();
		bp.waitForElement();
		actual[10]=tr.cloneTestCase();
		/*for(int i=0;i<=198;i++)
		{
		actual[8]=tp.cloneTestCase();
		}*/
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

@Then("^User is in a page of an TestPlanning$")
public void user_is_in_a_page_of_an_TestPlanning() throws Throwable {
	try
	{
		bp.waitForElement();
		rp= new ReleasePage(driver);
		bp.waitForElement();
	actual[11]=rp.clickOnTestPlanning();
	bp.waitForElement();
//	rp.clickOnTestPlanning();
//	bp.waitForElement();
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

@Then("^User clicks on plus symbol and enters the available fields$")
public void user_clicks_on_plus_symbol_and_enters_the_available_fields() throws Throwable {
	try
    {
    	tp=new TestPlanningPage(driver);
		//String[] str=new String[4];
		String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 14, 11);
		String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
		String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
		String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
		//int start_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
		//int end_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
		bp.waitForElement();
		tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		bp.waitForElement();
		actual[12]=tp.CreateCycle(cycle, Build, environ, hide);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
		String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
		String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		actual[13]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		bp.waitForElement();
		bp.waitForElement();
		actual[14]=tp.saveTestCycle();
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

@When("^User creates a phase p(\\d+) under a cycle$")
public void user_creates_a_phase_p_under_a_cycle(int arg1) throws Throwable {
	try
	{
		String[] cycleName=new String[1];
	     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",14 ,11 );
	     bp.waitForElement();
	     tp.navigateToCycle(cycleName);
		String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 14, 12);
		bp.waitForElement();
	actual[15]=tp.addPhaseToCycle(Phase);
	bp.waitForElement();
	String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
	actual[16]=tp.bulkAssignment(Bulk_Type);
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

@Then("^User assigns the testcase to an Anyone$")
public void user_assigns_the_testcase_to_an_Anyone() throws Throwable {
	try
	{
	
	String[] phaseName=new String[1];
    phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",14 ,12 );
    //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
    bp.waitForElement();
    bp.waitForElement();
	actual[17]=tp.navigateToCycle(phaseName);
	
	
	int[] TestCaseNo=new int[1];
	TestCaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8);
	String Assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
	 bp.waitForElement();
	 bp.waitForElement();
	actual[18]=tp.individualAssinTo(TestCaseNo, Assignee);
        /*String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 1,4 );
    actual[15]=tp.assignAllSelected(assignee);*/
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

@When("^User selects all testcases and clicks on the set flag icon$")
public void user_selects_all_testcases_and_clicks_on_the_set_flag_icon() throws Throwable {
	try
	{
	bp.waitForElement();
	actual[19]=tp.selectallTestCase();
	bp.waitForElement();
	 actual[20]=tp.setFlags();
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

@When("^User is in a page of a TestRepository$")
public void user_is_in_a_page_of_a_TestRepository() throws Throwable {
	try 
	{
		bp.waitForElement();
	rp= new ReleasePage(driver);
	bp.waitForElement();
	   actual[21]=rp.clickOnTestRep(); 
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

@When("^User creates a node s(\\d+) under an phase$")
public void user_creates_a_node_s_under_an_phase(int arg1) throws Throwable {
	try
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
	  String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 14, 13);
	  String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 14, 16);
	  
	  tr=new TestRepositoryPage(driver);
	  bp=new BasePage();
	  bp.waitForElement();
	 // tr.doubleClickOnRelease(releaseName);
	 tr.doubleClickOnRelease(releaseName);
	  String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 14, 12);
		 String[] phase=new String[1];
		 phase[0]=p_Name1;
		 bp.waitForElement();
		 actual[22]=tr.navigateToNode(releaseName, phase);
	 // bp.waitForElement();
	  bp.waitForElement();
	 actual[23]= tr.addNode(s_Name1,s_Desc1);
		
		tr.doubleClickOnRelease(releaseName);
		String[] system= new String[2];
		system[0]=p_Name1;
		system[1]=s_Name1;
		tr.navigateToNode(releaseName, system);
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

@When("^User creates a testcase on an newly created node$")
public void user_creates_a_testcase_on_an_newly_created_node() throws Throwable {
	try
	{
		bp.waitForElement();
		actual[24]=tr.addTestCase();
		
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

@When("^User performs the Edit operation on a created testcase$")
public void user_performs_the_Edit_operation_on_a_created_testcase() throws Throwable {
    try
    {
    	//bp.waitForElement();
		bp.waitForElement();
		tr.clickDetailButton();
		ctc=new CreateTestCasePage(driver);
		String tcName=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 1, 0);
		String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 0);
		
		actual[25]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
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


@When("^User selects a created testcase and clicks on a clone button$")
public void user_selects_a_created_testcase_and_clicks_on_a_clone_button() throws Throwable {
	try
	{
		bp.waitForElement();
		actual[27]=tr.clickOnList();
		bp.waitForElement();
		actual[26]=tr.selectallTestCase();
		bp.waitForElement();
		actual[27]=tr.cloneTestCase();
		
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

@When("^User is in a page of a TestPlanning$")
public void user_is_in_a_page_of_a_TestPlanning() throws Throwable {
	try
	{
		/*bp=new BasePage();
		   pp=new ProjectPage(driver);
		   bp.waitForElement();
	    	pp.clickOnLogout();
	    	bp.waitForElement();
	    	tp=new TestPlanningPage(driver);
	    	tr=new TestRepositoryPage(driver);
	    	exep=new ExecutionPage(driver);
	    	
	    	lp=new LoginPage(driver);
			
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_3");
			   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_3");
			   
			   lp.enterUname(Uname);
			   lp.enterPass(Pass);
			   lp.clickOnLogin();
			   
			   pp=new ProjectPage(driver);
			   rp=new ReleasePage(driver);
			   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		    	 bp.waitForElement();
		    	 pp.selectProject(projectName);
		    	 pp.selectRelease(releaseName);*/
		
		bp.waitForElement();//
		rp= new ReleasePage(driver);
	actual[28]=rp.clickOnTestPlanning();
	bp.waitForElement();
//	rp.clickOnTestPlanning();
//	bp.waitForElement();
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

@Then("^User selects a phase and chooses assign option$")
public void user_selects_a_phase_and_chooses_assign_option() throws Throwable {
	try
	{
		String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",14 ,11 );
		bp.waitForElement();
		tp.doubleClickOnCycle(cycleName1);
		
	String[] cycleName=new String[2];
    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",14 ,11 );
    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",14 ,12 );
    bp.waitForElement();
    bp.waitForElement();
    bp.waitForElement();
    actual[29]=tp.navigateToCycle(cycleName);
    bp.waitForElement();
    bp.waitForElement();
    actual[30]=tp.assignPhase();
    bp.waitForElement();
    String[] phaseName=new String[1];
    bp.waitForElement();
    phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",14 ,12 );
    //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
    bp.waitForElement();
    bp.waitForElement();
	actual[31]=tp.navigateToCycle(phaseName);
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

@When("^User clicks on sync button$")
public void user_clicks_on_sync_button() throws Throwable {
	 try
	 {
		 bp.waitForElement();
		 actual[32]=tp.synch();
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

@Then("^User selects a testcases in node s(\\d+) and sets the flag by clicking on a star icon$")
public void user_selects_a_testcases_in_node_s_and_sets_the_flag_by_clicking_on_a_star_icon(int arg1) throws Throwable {
	try
	{
	//ep=new ExportPage(driver);
   // String[] testCaseNo=new String[1];
		tp=new TestPlanningPage(driver);
		String[] phaseName1=new String[1];
		//phaseName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",14 ,12 );
		phaseName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",14 ,13 );
		bp.waitForElement();
		bp.waitForElement();
		actual[33]=tp.navigateToCycle(phaseName1);
		bp.waitForElement();
		
    
		int[] TestCaseNo=new int[1];
		TestCaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8);
		String Assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",7 ,9 );
		 bp.waitForElement();
		 bp.waitForElement();
		actual[34]=tp.individualAssinTo(TestCaseNo, Assignee);
	bp.waitForElement();
	actual[35]=tp.selectallTestCase();
	bp.waitForElement();
	bp.waitForElement();
    actual[36]=tp.setFlags();
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

@When("^User selects a testcases in node s(\\d+) and resets the flag by clicking on a star icon$")
public void user_selects_a_testcases_in_node_s_and_resets_the_flag_by_clicking_on_a_star_icon(int arg1) throws Throwable {
	try
	{
		bp.waitForElement();
		bp.waitForElement();
        actual[37]=tp.unSetFlags();
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

@Then("^User is in a page of an TestRepository$")
public void user_is_in_a_page_of_an_TestRepository() throws Throwable {
	try
	{
		bp.waitForElement();
	    bp.waitForElement(); 
	    rp= new ReleasePage(driver);
	   actual[38]=rp.clickOnTestRep(); 
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

@When("^User expands a phase node and selects a phase node s(\\d+)$")
public void user_expands_a_phase_node_and_selects_a_phase_node_s(int arg1) throws Throwable {
	try
	{
		tr=new TestRepositoryPage(driver);
	    bp=new BasePage();
		bp.waitForElement();
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 14, 12);
		String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 14, 13);
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		String[] system=new String[2];
		system[0]=p_Name1;
		system[1]=s_Name1;
		
		bp.waitForElement();
		actual[39]=tr.navigateToNode(releaseName,system );
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

@Then("^User creates a node s(\\d+) under a node s(\\d+)$")
public void user_creates_a_node_s_under_a_node_s(int arg1, int arg2) throws Throwable {
	try
	{
    tr=new TestRepositoryPage(driver);
    bp=new BasePage();
	//bp.waitForElement();
	/*String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
	String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 14, 12);
	String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 14, 13);
	actual[42]=tr.doubleClickOnRelease(releaseName);
	
	String[] system=new String[2];
	system[0]=p_Name1;
	system[0]=s_Name1;
	
	bp.waitForElement();
	actual[43]=tr.navigateToNode(releaseName,system );*/
	bp.waitForElement();
	bp.waitForElement();
	
	String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 14, 14);
	String ss_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 14, 17);
	actual[40]=tr.addNode(ss_Name1,ss_Desc1);
	
	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
	String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 14, 12);
	String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 14, 13);
	
	actual[41]=tr.doubleClickOnRelease(releaseName);
	
	String[] subsystem=new String[3];
	subsystem[0]=p_Name1;
	subsystem[1]=s_Name1;
	subsystem[2]=ss_Name1;
	
	bp.waitForElement();
	actual[42]=tr.navigateToNode(releaseName,subsystem );
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

@When("^User selects a testcase created and performs clone operation of a testcase$")
public void user_selects_a_testcase_created_and_performs_clone_operation_of_a_testcase() throws Throwable {
	try
	{
	bp.waitForElement();
	actual[43]=tr.addTestCase();
	bp.waitForElement();
	bp.waitForElement();
	// actual[44]=tr.clickOnDetails();
	//bp.waitForElement();
	//actual[45]=tr.clickOnList();
	bp.waitForElement();
	actual[44]=tr.selectallTestCase();
	bp.waitForElement();
	 actual[45]=tr.cloneTestCase();
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

@When("^User is in a page of an TestPlanning and navigates to phase p(\\d+) and chooses assign and then click sync button$")
public void user_is_in_a_page_of_an_TestPlanning_and_navigates_to_phase_p_and_chooses_assign_and_then_click_sync_button(int arg1) throws Throwable {
	try
	{
	bp.waitForElement();
	rp= new ReleasePage(driver);
	bp.waitForElement();
	   actual[46]=rp.clickOnTestPlanning();
	   bp.waitForElement();
//	   rp.clickOnTestPlanning();
//	   bp.waitForElement();
	   tp=new TestPlanningPage(driver);
	   
	   String cycleName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",14 ,11 );
		bp.waitForElement();
		actual[47]=tp.doubleClickOnCycle(cycleName2);
	   
	   String[] cycleName=new String[2];
	    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",14 ,11 );
	    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",14 ,12 );
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
		actual[48]=tp.navigateToCycle(cycleName);
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
	   actual[49]=tp.assignPhase();
	   bp.waitForElement();
	   bp.waitForElement();
	   String[] phaseName2=new String[1];
		phaseName2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",14 ,12 );
		bp.waitForElement();
		bp.waitForElement();
		actual[51]=tp.navigateToCycle(phaseName2);
		bp.waitForElement();
	   actual[50]=tp.synch();
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

@Then("^User selects the testcase in node s(\\d+) and sets the flag$")
public void user_selects_the_testcase_in_node_s_and_sets_the_flag(int arg1) throws Throwable {
	try
	{
		String[] phaseName2=new String[2];
		//phaseName2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",14 ,12 );
		phaseName2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",14 ,13 );
		phaseName2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",14 ,14 );
		bp.waitForElement();
		bp.waitForElement();
		actual[51]=tp.navigateToCycle(phaseName2);
		
		int[] TestCaseNo=new int[1];
		TestCaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8);
		String Assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",7 ,9 );
		 bp.waitForElement();
		 bp.waitForElement();
		actual[52]=tp.individualAssinTo(TestCaseNo, Assignee);
    bp.waitForElement();
    bp.waitForElement();
    actual[53]=tp.selectallTestCase();
    bp.waitForElement();
    bp.waitForElement();
    actual[54]=tp.setFlags();
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

@Then("^User again selects the testcase in node s(\\d+) and resets the flag$")
public void user_again_selects_the_testcase_in_node_s_and_resets_the_flag(int arg1) throws Throwable {
	try
	{
		bp.waitForElement();
		bp.waitForElement();
    actual[55]=tp.unSetFlags();
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

@When("^User is in a page of TestRepository and creates a node s(\\d+) after navigates node s(\\d+)$")
public void user_is_in_a_page_of_TestRepository_and_creates_a_node_s_after_navigates_node_s(int arg1, int arg2) throws Throwable {
	try
	{
		bp.waitForElement();
		rp= new ReleasePage(driver);
		   actual[56]=rp.clickOnTestRep();
		
	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
	bp=new BasePage();
	bp.waitForElement();
	bp.waitForElement();
	tr.doubleClickOnRelease(releaseName);
	String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 14, 12);
	String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 14, 13);
	String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 14, 14);
	
	
	String[] subsystem= new String[3];
	subsystem[0]=p_Name1;
	subsystem[1]=s_Name1;
	subsystem[2]=ss_Name1;
	//subsystem[1]=s_Name1;
	
	
	
	String sss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 14, 18);
	String sss_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 14, 19);
	bp.waitForElement();
	bp.waitForElement();
	actual[57]=tr.navigateToNode(releaseName, subsystem);
	bp.waitForElement();
	bp.waitForElement();
	actual[58]=tr.addNode(sss_Name1,sss_Desc1);
	bp.waitForElement();
	bp.waitForElement();
	actual[59]=tr.doubleClickOnRelease(releaseName);
	
	
	
	String[] subsubsystem= new String[4];
	subsubsystem[0]=p_Name1;
	subsubsystem[1]=s_Name1;
	subsubsystem[2]=ss_Name1;
	subsubsystem[3]=sss_Name1;
	bp.waitForElement();
	bp.waitForElement();
	actual[60]=tr.navigateToNode(releaseName, subsubsystem);
	
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

@Then("^User selects the testcase and performs clone operation$")
public void user_selects_the_testcase_and_performs_clone_operation() throws Throwable {
	try
	{
	bp.waitForElement();
	actual[61]=tr.addTestCase();
	bp.waitForElement();
	 //actual[62]=tr.clickOnDetails();
	bp.waitForElement();
	actual[62]=tr.selectallTestCase();
	bp.waitForElement();
	 actual[63]=tr.cloneTestCase();
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

@When("^User in a page of a TestPlanning and selects a phase p(\\d+) in a cycle and chooses assign and then click on sync button$")
public void user_in_a_page_of_a_TestPlanning_and_selects_a_phase_p_in_a_cycle_and_chooses_assign_and_then_click_on_sync_button(int arg1) throws Throwable {
	
	try
	{
		bp.waitForElement();
		rp= new ReleasePage(driver);
		bp.waitForElement();
		   actual[64]=rp.clickOnTestPlanning();
		   bp.waitForElement();
//		   rp.clickOnTestPlanning();
//		   bp.waitForElement();
		   tp=new TestPlanningPage(driver);
		   
		   String cycleName3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",14 ,11 );
			bp.waitForElement();
			actual[65]=tp.doubleClickOnCycle(cycleName3);
		   
		   String[] cycleName=new String[2];
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",14 ,11 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",14 ,12 );
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
			actual[66]=tp.navigateToCycle(cycleName);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
		   actual[67]=tp.assignPhase();
    bp.waitForElement();
	bp.waitForElement();
	 actual[68]=tp.synch();
	 
	 //String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
		//actual[69]=tp.bulkAssignment(Bulk_Type);
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

@When("^User selects a testcases in node s(\\d+) and sets the dirty flag$")
public void user_selects_a_testcases_in_node_s_and_sets_the_dirty_flag(int arg1) throws Throwable {
	try
	{
		String[] phaseName3=new String[4];
	    phaseName3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",14 ,12 );
	    phaseName3[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",14 ,13 );
	    phaseName3[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",14 ,14 );
	    phaseName3[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",14 ,18 );
	    //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
	    bp.waitForElement();
	    bp.waitForElement();
		actual[69]=tp.navigateToCycle(phaseName3);
		
		int[] TestCaseNo=new int[1];
		TestCaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8);
		String Assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",7 ,9 );
		 bp.waitForElement();
		 bp.waitForElement();
		actual[70]=tp.individualAssinTo(TestCaseNo, Assignee);
    bp.waitForElement();
    actual[71]=tp.selectallTestCase();
    bp.waitForElement();
    bp.waitForElement();
    actual[72]=tp.setFlags();
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

@Then("^User selects a testcases in node s(\\d+) and resets the dirty flag$")
public void user_selects_a_testcases_in_node_s_and_resets_the_dirty_flag(int arg1) throws Throwable {
	try
	{
    bp.waitForElement();
    bp.waitForElement();
    actual[73]=tp.unSetFlags();
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

@Then("^User set/resets the flags successfully$")
public void user_set_resets_the_flags_successfully() throws Throwable {
	try
	{
		for(int k=0;k<=actual.length-1;k++)
	     {
			System.out.println(actual[k]);
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();
	log.info("User set/resets the flags successfully");
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
