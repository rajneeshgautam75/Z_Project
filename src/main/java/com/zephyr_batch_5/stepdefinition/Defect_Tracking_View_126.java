package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_View_126 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	LoginPage lp;
	DefectTracking dt;
	ExecutionPage exep;
	DashBoardPage dp;
	TestRepositoryPage tr;
	RequirementsPage req;
	TestPlanningPage tp;
	String fileName="Defect_Tracking_View_126";
	
	boolean[] actual=new boolean[142];
	SoftAssert soft=new SoftAssert();
	
	int[] tcNo1=new int[1];
	{
	tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
	}
    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
    String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
	String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
	String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
	String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
	String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
	String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
	
	String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
	String build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
	String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
	String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
	String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
	String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
	String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
	String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",7,6);
	String defectStatusName=Excel_Lib.getData(INPUT_PATH_3,"Defect Tracking",1,62);
	@Given("^User is in the uppercase project page$")
	public void user_is_in_the_uppercase_project_page() throws Throwable {
	try
	   {
		 dp=new DashBoardPage(driver);
		 bp=new BasePage();
		 rp=new ReleasePage(driver);
		 pp=new ProjectPage(driver);
		 String uppercaseProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_8");
		 actual[0]=pp.selectProject(uppercaseProject);
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

	@When("^User execute testcase in test execution$")
	public void user_execute_testcase_in_test_execution() throws Throwable {
	try
	   {
	    String upperCaseRelease=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_5");
	    tr=new TestRepositoryPage(driver);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",19,12);
		String p_Desc1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		actual[1]=bp.waitForElement();
		pp.selectRelease(upperCaseRelease);
		rp.clickOnTestRep();
		actual[2]=bp.waitForElement();
		tr.clickOnRelease(upperCaseRelease);
		actual[3]=bp.waitForElement();
		tr.addNode(p_Name1,p_Desc1);  
		String[] phase=new String[1];
		phase[0]=p_Name1;
		actual[4]=bp.waitForElement();
		tr.navigateToNode(upperCaseRelease, phase);
		for(int i=1;i<=2;i++)
		{
		tr.addTestCase();
		}
	
		actual[5]=bp.waitForElement();
	    rp.clickOnTestPlanning();
	  
	    tp=new TestPlanningPage(driver);
		tp.clickOnAddTestCycleSymbol();
		actual[6]=bp.waitForElement();
		tp.CreateCycle(cycle, build, environ, hide);
		tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		actual[7]=bp.waitForElement();
		tp.saveTestCycle();
		actual[8]=bp.waitForElement();
		
    	String[] cycle1=new String[1];
		cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		tp.navigateToCycle(cycle1);
		
		actual[9]=bp.waitForElement();
		tp.addPhaseToCycle(phase[0]);
		actual[10]=bp.waitForElement();
		String bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
		actual[11]=bp.waitForElement();
		tp.bulkAssignment(bulk_Type);
		tp.goBackToCycle();
		
		   actual[12]=bp.waitForElement();
		   rp.clickOnTestExecution(); 
           bp.waitForElement();
           actual[13]=bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    //String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",19,12);
		    
		    actual[14]=bp.waitForElement();
			tr.navigateToNode(upperCaseRelease, cycleName);
			actual[15]=bp.waitForElement();
			actual[16]=bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    exep.executeStatus(tcNo1[0], statusType1);
		    actual[17]=bp.waitForElement();
		    tp.doubleClickOnCycle(upperCaseRelease);
		    actual[18]=bp.waitForElement();
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

	@When("^User create a dashBoard and add daily pulse gadget for uppercase project$")
	public void user_create_a_dashBoard_and_add_daily_pulse_gadget_for_uppercase_project() throws Throwable {
	try
    {
    	dp=new DashBoardPage(driver);
		bp=new BasePage();
		pp=new ProjectPage(driver);
		actual[19]=dp.clickOnManageDashboards();
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,60);
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_8"); 
	    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_5");
	    String timeFrameRate=Excel_Lib.getData(INPUT_PATH_3,"Defect Tracking",2,61);
		actual[20]=dp.clickOnAddDashBoardSymbol();
		actual[21]=dp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
		actual[22]=dp.selectDashboard(dashboardName);
		bp.waitForElement();
		actual[23]=dp.clickOnAddGadgetSymbol();
		actual[24]=dp.addGadget(gadgetName);
		actual[25]=dp.configureDailyPulseGadget(projectName,releaseName,timeFrameRate);
		actual[26]=dp.saveTraceabilityGadget();
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

	@Then("^Should show defect count properly for uppercase project$")
	public void should_show_defect_count_properly_for_uppercase_project() throws Throwable {
	try
    {
		actual[27]=dp.defectStatusCount(defectStatusName);
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

	@When("^User select the special character project and execute testcase in test execution$")
	public void user_select_the_special_character_project_and_execute_testcase_in_test_execution() throws Throwable {
	try
	   {
		String specialCharProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_5");
	    String specialCharRelease=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_4");
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",19,12);
		String p_Desc1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		tr=new TestRepositoryPage(driver);
		actual[28]=bp.waitForElement();
		actual[29]=pp.backToProjectPage();
		actual[30]=pp.selectProject(specialCharProject);
		actual[31]=pp.selectRelease(specialCharRelease);
		actual[32]=rp.clickOnTestRep();
		actual[33]=bp.waitForElement();
		actual[34]=tr.clickOnRelease(specialCharRelease);
		actual[35]=bp.waitForElement();
		actual[36]=tr.addNode(p_Name1,p_Desc1);  
		String[] phase=new String[1];
		phase[0]=p_Name1;
		bp.waitForElement();
		actual[37]=tr.navigateToNode(specialCharRelease, phase);
		for(int i=1;i<=2;i++)
		{
		tr.addTestCase();
		}
	
	  bp.waitForElement();
	  actual[38]=rp.clickOnTestPlanning();
	  
	    tp=new TestPlanningPage(driver);
		actual[39]=tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		actual[40]=tp.CreateCycle(cycle, build, environ, hide);
		actual[41]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		bp.waitForElement();
		actual[42]=tp.saveTestCycle();
		bp.waitForElement();
		
    	String[] cycle1=new String[1];
		cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		actual[43]=tp.navigateToCycle(cycle1);
		
		bp.waitForElement();
		actual[44]=tp.addPhaseToCycle(phase[0]);
		bp.waitForElement();
		String bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
		bp.waitForElement();
		actual[45]=tp.bulkAssignment(bulk_Type);
		actual[46]=tp.goBackToCycle();
		
		   bp.waitForElement();
		   actual[47]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    //String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",19,12);
		    
		    bp.waitForElement();
			actual[48]=tr.navigateToNode(specialCharRelease, cycleName);
			bp.waitForElement();
		
//			int[] tcNo1=new int[1];
//			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
//		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[49]=exep.executeStatus(tcNo1[0], statusType1);
		    actual[50]=tp.doubleClickOnCycle(specialCharRelease);
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

	@When("^User create a dashBoard and add daily pulse gadget for special character project$")
	public void user_create_a_dashBoard_and_add_daily_pulse_gadget_for_special_character_project() throws Throwable {
		try
	    {
	    	dp=new DashBoardPage(driver);
			bp=new BasePage();
			pp=new ProjectPage(driver);
			actual[51]=dp.clickOnManageDashboards();
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,60);
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_5"); 
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_4");
		    String timeFrameRate=Excel_Lib.getData(INPUT_PATH_3,"Defect Tracking",2,61);
			actual[52]=dp.clickOnAddDashBoardSymbol();
			actual[53]=dp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
			actual[54]=dp.selectDashboard(dashboardName);
			actual[55]=dp.clickOnAddGadgetSymbol();
			actual[56]=dp.addGadget(gadgetName);
			actual[57]=dp.configureDailyPulseGadget(projectName,releaseName,timeFrameRate);
			actual[58]=dp.saveTraceabilityGadget();
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

	@Then("^Should show defect count properly for special character project$")
	public void should_show_defect_count_properly_for_special_character_project() throws Throwable {
	try
    {
		actual[59]=dp.defectStatusCount(defectStatusName);
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

	@When("^User select the number character project and execute testcase in test execution$")
	public void user_select_the_number_character_project_and_execute_testcase_in_test_execution() throws Throwable {
	try
	   {
		String numberCharProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_9");
	    String numberCharRelease=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_6");
	    tr=new TestRepositoryPage(driver);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",19,12);
		String p_Desc1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		actual[60]=bp.waitForElement();
		actual[61]=pp.backToProjectPage();
		actual[62]=pp.selectProject(numberCharProject);
		actual[63]=pp.selectRelease(numberCharRelease);
		actual[64]=rp.clickOnTestRep();
		bp.waitForElement();
		actual[65]=tr.clickOnRelease(numberCharRelease);
		bp.waitForElement();
		actual[66]=tr.addNode(p_Name1,p_Desc1);  
		String[] phase=new String[1];
		phase[0]=p_Name1;
		bp.waitForElement();
		actual[66]=tr.navigateToNode(numberCharRelease, phase);
		for(int i=1;i<=2;i++)
		{
		tr.addTestCase();
		}
	
	  bp.waitForElement();
	  actual[67]=rp.clickOnTestPlanning();
	  
	    tp=new TestPlanningPage(driver);
		actual[68]=tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		actual[69]=tp.CreateCycle(cycle, build, environ, hide);
		actual[70]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		bp.waitForElement();
		actual[71]=tp.saveTestCycle();
		bp.waitForElement();
		
    	String[] cycle1=new String[1];
		cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		actual[72]=tp.navigateToCycle(cycle1);
		
		bp.waitForElement();
		actual[73]=tp.addPhaseToCycle(phase[0]);
		bp.waitForElement();
		String bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
		bp.waitForElement();
		actual[74]=tp.bulkAssignment(bulk_Type);
		actual[75]=tp.goBackToCycle();
		
		   bp.waitForElement();
		   actual[76]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    //String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",19,12);
		    
		    bp.waitForElement();
			actual[77]=tr.navigateToNode(numberCharRelease, cycleName);
			bp.waitForElement();
		
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[78]=exep.executeStatus(tcNo1[0], statusType1);
		    tp.doubleClickOnCycle(numberCharRelease);
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

	@When("^User create a dashBoard and add daily pulse gadget for number character project$")
	public void user_create_a_dashBoard_and_add_daily_pulse_gadget_for_number_character_project() throws Throwable {
	try
    {
    	dp=new DashBoardPage(driver);
		bp=new BasePage();
		pp=new ProjectPage(driver);
		actual[79]=dp.clickOnManageDashboards();
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,60);
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_9"); 
	    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_6");
	    String timeFrameRate=Excel_Lib.getData(INPUT_PATH_3,"Defect Tracking",2,61);
		actual[80]=dp.clickOnAddDashBoardSymbol();
		actual[81]=dp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
		actual[82]=dp.selectDashboard(dashboardName);
		actual[83]=dp.clickOnAddGadgetSymbol();
		actual[84]=dp.addGadget(gadgetName);
		actual[85]=dp.configureDailyPulseGadget(projectName,releaseName,timeFrameRate);
		actual[86]=dp.saveTraceabilityGadget();
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

	@Then("^Should show defect count properly for number character project$")
	public void should_show_defect_count_properly_for_number_character_project() throws Throwable {
	try
    {
		actual[87]=dp.defectStatusCount(defectStatusName);
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

	@When("^User select the alpha numberic character project and execute testcase in test execution$")
	public void user_select_the_alpha_numberic_character_project_and_execute_testcase_in_test_execution() throws Throwable {
	try
	   {
		String alphaNumCharProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_10");
	    String alphaNumCharRelease=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_7");
	    tr=new TestRepositoryPage(driver);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",19,12);
		String p_Desc1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		bp.waitForElement();
		pp.backToProjectPage();
		actual[88]=pp.selectProject(alphaNumCharProject);
		actual[89]=pp.selectRelease(alphaNumCharRelease);
		actual[90]=rp.clickOnTestRep();
		bp.waitForElement();
		actual[91]=tr.clickOnRelease(alphaNumCharRelease);
		bp.waitForElement();
		actual[92]=tr.addNode(p_Name1,p_Desc1);  
		String[] phase=new String[1];
		phase[0]=p_Name1;
		bp.waitForElement();
		actual[93]=tr.navigateToNode(alphaNumCharRelease, phase);
		for(int i=1;i<=2;i++)
		{
		tr.addTestCase();
		}
	
	  bp.waitForElement();
	  actual[94]=rp.clickOnTestPlanning();
	  
	    tp=new TestPlanningPage(driver);
		actual[95]=tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		actual[96]=tp.CreateCycle(cycle, build, environ, hide);
		actual[97]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		bp.waitForElement();
		actual[98]=tp.saveTestCycle();
		bp.waitForElement();
		
    	String[] cycle1=new String[1];
		cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		actual[99]=tp.navigateToCycle(cycle1);
		
		bp.waitForElement();
		actual[100]=tp.addPhaseToCycle(phase[0]);
		bp.waitForElement();
		String bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
		bp.waitForElement();
		actual[101]=tp.bulkAssignment(bulk_Type);
		actual[102]=tp.goBackToCycle();
		
		   bp.waitForElement();
		   actual[103]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    //String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",19,12);
		    
		    bp.waitForElement();
			actual[104]=tr.navigateToNode(alphaNumCharRelease, cycleName);
			bp.waitForElement();
		
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[105]=exep.executeStatus(tcNo1[0], statusType1);
		    tp.doubleClickOnCycle(alphaNumCharRelease);
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

	@When("^User create a dashBoard and add daily pulse gadget for alpha numberic character project$")
	public void user_create_a_dashBoard_and_add_daily_pulse_gadget_for_alpha_numberic_character_project() throws Throwable {
	try
    {
    	dp=new DashBoardPage(driver);
		bp=new BasePage();
		pp=new ProjectPage(driver);
		actual[106]=dp.clickOnManageDashboards();
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,60);
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_10"); 
	    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_7");
	    String timeFrameRate=Excel_Lib.getData(INPUT_PATH_3,"Defect Tracking",2,61);
		actual[107]=dp.clickOnAddDashBoardSymbol();
		actual[108]=dp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
		actual[109]=dp.selectDashboard(dashboardName);
		actual[110]=dp.clickOnAddGadgetSymbol();
		actual[111]=dp.addGadget(gadgetName);
		actual[112]=dp.configureDailyPulseGadget(projectName,releaseName,timeFrameRate);
		actual[113]=dp.saveTraceabilityGadget();
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

	@Then("^Should show defect count properly for alpha numberic character project$")
	public void should_show_defect_count_properly_for_alpha_numberic_character_project() throws Throwable {
	try
    {
		actual[114]=dp.defectStatusCount(defectStatusName);
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

	@When("^User select the international character project and execute testcase in test execution$")
	public void user_select_the_international_character_project_and_execute_testcase_in_test_execution() throws Throwable {
	try
	   {
		String internationalCharProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_4");
	    String internationalCharRelease=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_3");
	    tr=new TestRepositoryPage(driver);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",19,12);
		String p_Desc1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		bp.waitForElement();
		pp.backToProjectPage();
		actual[115]=pp.selectProject(internationalCharProject);
		
		
		actual[116]=pp.selectRelease(internationalCharRelease);
		actual[117]=rp.clickOnTestRep();
		bp.waitForElement();
		actual[118]=tr.clickOnRelease(internationalCharRelease);
		bp.waitForElement();
		actual[119]=tr.addNode(p_Name1,p_Desc1);  
		String[] phase=new String[1];
		phase[0]=p_Name1;
		bp.waitForElement();
		actual[120]=tr.navigateToNode(internationalCharRelease, phase);
		for(int i=1;i<=2;i++)
		{
		tr.addTestCase();
		}
	
	  bp.waitForElement();
	  actual[121]=rp.clickOnTestPlanning();
	  
	    tp=new TestPlanningPage(driver);
		actual[122]=tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		actual[123]=tp.CreateCycle(cycle, build, environ, hide);
		actual[124]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		bp.waitForElement();
		actual[125]=tp.saveTestCycle();
		bp.waitForElement();
		
    	String[] cycle1=new String[1];
		cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		actual[126]=tp.navigateToCycle(cycle1);
		
		bp.waitForElement();
		actual[127]=tp.addPhaseToCycle(phase[0]);
		bp.waitForElement();
		String bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
		bp.waitForElement();
		actual[128]=tp.bulkAssignment(bulk_Type);
		actual[129]=tp.goBackToCycle();
		
		   bp.waitForElement();
		   actual[130]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    //String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",19,12);
		    
		    bp.waitForElement();
			actual[131]=tr.navigateToNode(internationalCharRelease, cycleName);
			bp.waitForElement();
		
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[132]=exep.executeStatus(tcNo1[0], statusType1);
		    tp.doubleClickOnCycle(internationalCharRelease);
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

	@When("^User create a dashBoard and add daily pulse gadget for international character project$")
	public void user_create_a_dashBoard_and_add_daily_pulse_gadget_for_international_character_project() throws Throwable {
	try
    {
    	dp=new DashBoardPage(driver);
		bp=new BasePage();
		pp=new ProjectPage(driver);
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,60);
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_4"); 
	    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_3");
	    String timeFrameRate=Excel_Lib.getData(INPUT_PATH_3,"Defect Tracking",2,61);
	    actual[133]=dp.clickOnManageDashboards();
	    actual[134]=dp.clickOnAddDashBoardSymbol();
		actual[135]=dp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
		actual[136]=dp.selectDashboard(dashboardName);
		actual[137]=dp.clickOnAddGadgetSymbol();
		actual[138]=dp.addGadget(gadgetName);
		actual[139]=dp.configureDailyPulseGadget(projectName,releaseName,timeFrameRate);
		actual[140]=dp.saveTraceabilityGadget();
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

	@Then("^Should show defect count properly for international character project$")
	public void should_show_defect_count_properly_for_international_character_project() throws Throwable {
	try
    {
		actual[141]=dp.defectStatusCount(defectStatusName);
		bp.waitForElement();
		pp.backToProjectPage();
		for(int k=0;k<=actual.length-1;k++)
		{
			System.out.println("Actual["+k+"]="+actual[k]);
			soft.assertEquals(actual[k], true);
		}
		soft.assertAll();
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
