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

public class TestExecution_878809 extends LaunchBrowser{

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
	
	boolean[] actual=new boolean[50];
	SoftAssert soft=new SoftAssert();
	
	 String fileName="TestExecution_878809";
	 
	@Given("^As a Lead,Launch TestRepositOry$")
	public void as_a_Lead_Launch_TestRepositOry() throws Throwable {
		try
		   {

            lb=new LaunchBrowser();
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
			   lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}  
	}

	@When("^User creates a phase,create testcases with teststeps to phase and creates two systems under phase$")
	public void user_creates_a_phase_create_testcases_with_teststeps_to_phase_and_creates_two_systems_under_phase() throws Throwable {
		try
	    {
					tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 1);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 4);
				
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
				bp.waitForElement();
				actual[6]=tr.clickDetailButton();
				String[] stepDetail1=new String[3];
				stepDetail1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
				stepDetail1[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				stepDetail1[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[7]=ctc.enterTestCaseStepDetail(stepDetail1);
				bp.waitForElement();
				actual[8]=tr.clickOnList();
				bp.waitForElement();
				
				ep=new ExportPage(driver);
				String[] testcase=new String[1];
				
				testcase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 ));
				actual[9]=ep.selectMultipleTestcasesfromSearch(testcase);
				
				
				//actual[9]=tr.selectallTestCase();
				actual[10]=tr.cloneTestCase();
				bp.waitForElement();
				actual[11]=tr.selectallTestCase();
				actual[12]=tr.cloneTestCase();
				bp.waitForElement();
				actual[13]=tr.navigateToNode(releaseName, phase);
				String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 2);
				String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 5);
				bp.waitForElement();
				tr.selectPhase(p_Name1);
				actual[14]=tr.addNode(s_Name1, s_Desc1);
				bp.waitForElement();
				tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
				
				String[] nav2=new String[2];
				nav2[0]=p_Name1;
				nav2[1]=s_Name1;
				
				actual[15]=tr.navigateToNode(releaseName, nav2);
				
				
				
				 //tr.clickOnRelease(releaseName);
		    	 String s_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 2);
		    	  String s_Desc2=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 5);
		    	  //actual[15]=tr.selectPhase(p_Name1);
		    	  bp.waitForElement();
		    	  actual[16]=tr.addNode(s_Name2, s_Desc2);
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

	@When("^User Launch TestPlanning and creates a cycLe$")
	public void user_Launch_TestPlanning_and_creates_a_cycLe() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[17]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[18]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[19]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[20]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[21]=tp.saveTestCycle();
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

	@When("^User creates a freeform phase and creates two system nodes to phase and creates three subsystem nodes to system and add testcases to freeform phase$")
	public void user_creates_a_freeform_phase_and_creates_two_system_nodes_to_phase_and_creates_three_subsystem_nodes_to_system_and_add_testcases_to_freeform_phase() throws Throwable {
		try
	    {
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 0);
			actual[22]=tp.navigateToCycle(cycle);
			
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 1);
			actual[23]=tp.createFreeFormPhase(phaseName);
			bp.waitForElement();
			
			String[] cycle1=new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 1);
			actual[24]=tp.navigateToCycle(cycle1);
			
			String systemName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 2);
			String systemDesc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 5);
			actual[25]=tp.addNode(systemName1, systemDesc1);
			
			String[] cycle11=new String[1];
			cycle11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 1);
			bp.waitForElement();
			tp.navigateToCycle(cycle11);
			String systemName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 2);
			String systemDesc2=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 5);
			bp.waitForElement();
			actual[26]=tp.addNode(systemName2, systemDesc2);
			bp.waitForElement();
			
			String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 1);
			bp.waitForElement();
			tp.doubleClickOnCycle(cycleName);
			
			String[] cycle2=new String[2];
			cycle2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 1);
			cycle2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 2);
			bp.waitForElement();
			actual[27]=tp.navigateToCycle(cycle2);
			bp.waitForElement();
			
			String SubsystemName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 3);
			String SubsystemDesc1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 6);
			//tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			actual[28]=tp.addNode(SubsystemName1, SubsystemDesc1);
			
			String[] cycle22=new String[1];
			cycle22[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 2);
			bp.waitForElement();
			tp.navigateToCycle(cycle22);
			String SubsystemName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 3);
			String SubsystemDesc2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 6);
			//tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			actual[29]=tp.addNode(SubsystemName2, SubsystemDesc2);
			
			String[] cycle33=new String[1];
			cycle33[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 2);
			bp.waitForElement();
			tp.navigateToCycle(cycle33);
			String SubsystemName3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 28, 3);
			String SubsystemDesc3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 6);
			//tr=new TestRepositoryPage(driver);
			actual[30]=tp.addNode(SubsystemName3, SubsystemDesc3);
			bp.waitForElement();
			
			
			String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 1);
			bp.waitForElement();
			tp.doubleClickOnCycle(cycleName1);
			
			String[] cycle3=new String[2];
			cycle3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 1);
			cycle3[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 2);
			actual[31]=tp.navigateToCycle(cycle3);
			
			String SubsystemName4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 3);
			String SubsystemDesc4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 6);
			//tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			actual[32]=tp.addNode(SubsystemName4, SubsystemDesc4);
			
			String[] cycle44=new String[1];
			cycle44[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 2);
			bp.waitForElement();
			tp.navigateToCycle(cycle44);
			String SubsystemName5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 3);
			String SubsystemDesc5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 6);
			//tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			actual[33]=tp.addNode(SubsystemName5, SubsystemDesc5);
			
			String[] cycle55=new String[1];
			cycle55[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 2);
			bp.waitForElement();
			tp.navigateToCycle(cycle55);
			String SubsystemName6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 28, 3);
			String SubsystemDesc6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 6);
			//tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			actual[34]=tp.addNode(SubsystemName6, SubsystemDesc6);
			
			String[] cycle4=new String[1];
			cycle4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 1);
			actual[35]=tp.navigateToCycle(cycle4);
			
			 bp.waitForElement();
		     actual[36]=tp.clickOnAddTestcasesToFreeForm();
		     
		     String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",1 ,6 );
		     bp.waitForElement();
		     actual[37]=tp.quiksearch(name);	
		     
		     bp.waitForElement();
		     actual[38]=tp.selectAllFreeFormTestCases();
		     
		     bp.waitForElement();
		     actual[39]=tp.clickOnSaveAndOk();
		     
		     bp.waitForElement();
		     actual[40]=tp.closeFreeFormPage();
		     
		     bp.waitForElement();
		     tp.selectallTestCase();
		     
		     bp.waitForElement();
		     String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
		     tp.assignAllSelected(assignee);
		     bp.waitForElement();
		     tp.goBackToCycle();
		   
		     
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

	@When("^As a Tester,Launch TestExecution and executes the testcases to pass/fail/wip/blocked$")
	public void as_a_Tester_Launch_TestExecution_and_executes_the_testcases_to_pass_fail_wip_blocked() throws Throwable {
		try
		   {
			/*bp=new BasePage();//
			rp=new ReleasePage(driver);
	    	pp=new ProjectPage(driver);
	    	bp.waitForElement();
	    	pp.clickOnLogout();
	    	bp.waitForElement();
	    	tr=new TestRepositoryPage(driver);
	    	tp=new TestPlanningPage(driver);
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
		    	 pp.selectRelease(releaseName);*///
			
			    bp.waitForElement();
				rp= new ReleasePage(driver);
				bp.waitForElement();
				   actual[41]=rp.clickOnTestExecution(); 
				   
				   String[] cycleName=new String[3];
				    cycleName[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
				    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",26 ,0 );
				    cycleName[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",26 ,1 );
				    
				    bp.waitForElement();
				    tp=new TestPlanningPage(driver);
				    bp.waitForElement();
				    bp.waitForElement();
				    bp.waitForElement();
					actual[42]=tp.navigateToCycle(cycleName);
					bp.waitForElement();
				
					int[] tcNo1=new int[1];
					tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
				    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[43]=exep.executeStatus(tcNo1[0], statusType1);
				    
				    int[] tcNo2=new int[1];
					tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
				    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[44]=exep.executeStatus(tcNo2[0], statusType2);
				    
				    int[] tcNo3=new int[1];
					tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
				    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[45]=exep.executeStatus(tcNo3[0], statusType3);
				    
				    int[] tcNo4=new int[1];
					tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
				    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[46]=exep.executeStatus(tcNo4[0], statusType4);
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

	@When("^User change the actual execution time of a testcase after execution$")
	public void user_change_the_actual_execution_time_of_a_testcase_after_execution() throws Throwable {
		try
		{
			exep=new ExecutionPage(driver);
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
			 String[] tcNo1=new String[1];
			tcNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 ));
			tr.clickOnDetails();
			exep.selectMultipleTestCaseFromExecutionGrid(tcNo1);
			bp.waitForElement();
				
		String day1=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 6,7 );
		String hour1=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 7,7 );
		String min1=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 8,7 );
		actual[47]=exep.actualTime(day1, hour1, min1);
		bp.waitForElement();
		tr.clickOnList();
    	/*bp.waitForElement();
    	driver.navigate().refresh();
    	bp.waitForElement();
    	bp.waitForElement();
    	bp.waitForElement();*/
    	//tp.doubleClickOnCycle(cycleName);
    	String[] cycleName1=new String[3];
	    cycleName1[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
	    cycleName1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",26 ,0 );
	    cycleName1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",26 ,1 );
	    bp.waitForElement();
	    tp=new TestPlanningPage(driver);
	    tp.doubleClickOnCycle(cycleName1[0]);
	   
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
		actual[48]=tr.navigateToNode(releaseName,cycleName1);
		bp.waitForElement();
		//String[] sortName=new String[3];
//		sortName[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",1 ,31 );
//		exep.sort(sortName);
		tr.clickOnDetails();
		/*String day1=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 6,7 );
		String hour1=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 7,7 );
		String min1=Excel_Lib.getData(INPUT_PATH_3, "ExecutionTime", 8,7 );*/
		actual[49]=exep.validateActualTime(day1, hour1, min1);
		bp.waitForElement();
		tr.clickOnList();
		
		tp.doubleClickOnCycle( cycleName1[0]);
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

	@Then("^User successfully executes the testcases$")
	public void user_successfully_executes_the_testcases() throws Throwable {
		try
		{
			
			pp=new ProjectPage(driver);
//			pp.clickOnLogout();
//			pp.closeBrowser();
			
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("User successfully executes the testcases");
		}
		catch(Exception e)
		{lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}   
	}
}
