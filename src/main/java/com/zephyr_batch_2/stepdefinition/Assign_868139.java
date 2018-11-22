package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
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

public class Assign_868139 extends LaunchBrowser {

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
	
	boolean[] actual=new boolean[64];
	SoftAssert soft=new SoftAssert();
	String filename="Assign_868139";
	@Given("^User is in a page of the testRepository$")
	public void user_is_in_a_page_of_the_testRepository() throws Throwable {
		try
		   {
			bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   bp.waitForElement();
		   actual[0]=pp.selectProject(projectName);
		   bp.waitForElement();
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   bp.waitForElement();
		   actual[2]=rp.clickOnTestRep(); 
		   }
		   catch(Exception e)
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

	@Given("^User creates a phase under release node$")
	public void user_creates_a_phase_under_release_node() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 12, 12);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 12, 15);
		
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
			lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}   
		
	}

	@When("^User creates a testcase under the Phase$")
	public void user_creates_a_testcase_under_the_Phase() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[6]=tr.addTestCase();
		}
		catch(Exception e)
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

	@When("^User performs the edit operation to the testcase$")
	public void user_performs_the_edit_operation_to_the_testcase() throws Throwable {
		try
	    {
			bp.waitForElement();
			tr.clickDetailButton();
			ctc=new CreateTestCasePage(driver);
			String tcName=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 1, 0);
			String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 0);
			
			actual[7]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
			bp.waitForElement();
		
	    }
	    catch(Exception e)
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

	@When("^User performs clone operation of a testcase$")
	public void user_performs_clone_operation_of_a_testcase() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[8]=tr.clickOnList();
			bp.waitForElement();
			actual[9]=tr.selectallTestCase();
			bp.waitForElement();
			actual[10]=tr.cloneTestCase();
			
		}
		catch(Exception e)
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

	@When("^User creates a system under the phase$")
	public void user_creates_a_system_under_the_phase() throws Throwable {
		try
		{
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
			  String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 12, 13);
			  String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 12, 16);
			  
			  tr=new TestRepositoryPage(driver);
			  bp=new BasePage();
			  bp.waitForElement();
			 // tr.doubleClickOnRelease(releaseName);
			  tr.doubleClickOnRelease(releaseName);
			  String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 12, 12);
				 String[] phase=new String[1];
				 phase[0]=p_Name1;
				 actual[11]=tr.navigateToNode(releaseName, phase);
			 // bp.waitForElement();
			  bp.waitForElement();
			 actual[12]= tr.addNode(s_Name1,s_Desc1);
				
				tr.doubleClickOnRelease(releaseName);
				String[] system= new String[2];
				system[0]=p_Name1;
				system[1]=s_Name1;
				tr.navigateToNode(releaseName, system);
		}
		catch(Exception e)
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

	@When("^User creates a Testcase under phase$")
	public void user_creates_a_Testcase_under_phase() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[13]=tr.addTestCase();
		}
		catch(Exception e)
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

	@When("^User performs the edit operation of created testcase$")
	public void user_performs_the_edit_operation_of_created_testcase() throws Throwable {
		try
	    {
			bp.waitForElement();
			actual[14]=tr.clickDetailButton();
			ctc=new CreateTestCasePage(driver);
			String tcName=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 1, 0);
			String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 0);
			
			actual[15]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
			bp.waitForElement();
		
	    }
	    catch(Exception e)
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

	@When("^User performs the clone operation$")
	public void user_performs_the_clone_operation() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[16]=tr.clickOnList();
			bp.waitForElement();
			actual[17]=tr.selectallTestCase();
			bp.waitForElement();
			actual[18]=tr.cloneTestCase();
			
		}
		catch(Exception e)
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

	@When("^User creates a subsystem under the system$")
	public void user_creates_a_subsystem_under_the_system() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);
		    bp=new BasePage();
			bp.waitForElement();
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 12, 12);
			String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 12, 13);
			actual[19]=tr.doubleClickOnRelease(releaseName);
			
			String[] system=new String[2];
			system[0]=p_Name1;
			system[1]=s_Name1;
			
			bp.waitForElement();
			actual[20]=tr.navigateToNode(releaseName,system );
			
			bp.waitForElement();
			String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 12, 14);
			String ss_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 12, 17);
			actual[21]=tr.addNode(ss_Name1,ss_Desc1);
		}
		catch(Exception e)
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

	@When("^User creates a testcase and performs the edit operation on a testcase$")
	public void user_creates_a_testcase_and_performs_the_edit_operation_on_a_testcase() throws Throwable 
	{
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
		bp=new BasePage();
		bp.waitForElement();
		bp.waitForElement();
		//actual[56]=tr.doubleClickOnRelease(releaseName);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 12, 12);
		String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 12, 13);
		String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 12, 14);
		tr.doubleClickOnRelease(releaseName);
		
		
		String[] subsystem= new String[3];
		subsystem[0]=p_Name1;
		subsystem[1]=s_Name1;
		subsystem[2]=ss_Name1;
		//subsystem[1]=s_Name1;
	
		bp.waitForElement();
		bp.waitForElement();
		actual[22]=tr.navigateToNode(releaseName, subsystem);  
		bp.waitForElement();
		tr.addTestCase();
		bp.waitForElement();
		actual[23]=tr.clickDetailButton();
		ctc=new CreateTestCasePage(driver);
		String tcName=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 1, 0);
		String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 0);
		
		actual[24]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
		bp.waitForElement();
		}
		catch(Exception e)
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

	@When("^User performs the clone operation on testcase$")
	public void user_performs_the_clone_operation_on_testcase() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[25]=tr.clickOnList();
			bp.waitForElement();
			actual[26]=tr.selectallTestCase();
			bp.waitForElement();
			actual[27]=tr.cloneTestCase();
			
		}
		catch(Exception e)
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

	@When("^User is in the page TestPlanning$")
	public void user_is_in_the_page_TestPlanning() throws Throwable {
		try
		{
			bp.waitForElement();
			rp= new ReleasePage(driver);
			bp.waitForElement();
		actual[28]=rp.clickOnTestPlanning();
		}
		catch(Exception e)
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

	@When("^User creates a cycle and enters all available fields$")
	public void user_creates_a_cycle_and_enters_all_available_fields() throws Throwable {
		try
	    {
	    	tp=new TestPlanningPage(driver);
			//String[] str=new String[4];
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 12, 11);
			String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
			String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
			String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
		
			bp.waitForElement();
			actual[29]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			bp.waitForElement();
			actual[30]=tp.CreateCycle(cycle, Build, environ, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
			String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
			String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[31]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			bp.waitForElement();
			actual[32]=tp.saveTestCycle();
	    }
	    catch(Exception e)
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

	@When("^User creates a phase under test cycle$")
	public void user_creates_a_phase_under_test_cycle() throws Throwable {
		try
		{
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",12 ,11 );
		     bp.waitForElement();
		     actual[33]=tp.navigateToCycle(cycleName);
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 12, 12);
			bp.waitForElement();
		actual[34]=tp.addPhaseToCycle(Phase);
		String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
		actual[35]=tp.bulkAssignment(Bulk_Type);
		bp.waitForElement();
		}
		catch(Exception e)
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

	@When("^User assigns the testcases to different users from assign to drop down$")
	public void user_assigns_the_testcases_to_different_users_from_assign_to_drop_down() throws Throwable {
		try
		{
		String[] phaseName=new String[1];
	    phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",12 ,12 );
	    //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
	    bp.waitForElement();
	    bp.waitForElement();
		actual[36]=tp.navigateToCycle(phaseName);
		
		int[] TestCaseNo1=new int[1];
		TestCaseNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8);
		String Assignee1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
		 bp.waitForElement();
		 bp.waitForElement();
		actual[37]=tp.individualAssinTo(TestCaseNo1, Assignee1);
		
		int[] TestCaseNo2=new int[1];
		TestCaseNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8);
		String Assignee2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
		 bp.waitForElement();
		 bp.waitForElement();
		actual[38]=tp.individualAssinTo(TestCaseNo2, Assignee2);
		}
		catch(Exception e)
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

	@When("^User selects the system node and chooses Select All and assigns to test\\.manager$")
	public void user_selects_the_system_node_and_chooses_Select_All_and_assigns_to_test_manager() throws Throwable {
		try
		{
			bp.waitForElement();
			tp.selectallTestCase();
			String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,9 );
			bp.waitForElement();
			actual[39]=tp.assignAllSelected(assignee);
			
		/*String cycleName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",12 ,11 );
		bp.waitForElement();
		actual[40]=tp.doubleClickOnCycle(cycleName2);
	   
		String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 12, 12);
		bp.waitForElement();
	actual[40]=tp.addPhaseToCycle(Phase);
	String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
	actual[41]=tp.bulkAssignment(Bulk_Type);
	bp.waitForElement();*/
		}
		 catch(Exception e)
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

	@When("^User selects a phase node and clicks bulk assignment button$")
	public void user_selects_a_phase_node_and_clicks_bulk_assignment_button() throws Throwable {
	    try
	    {
	    	/*String[] phaseName=new String[1];
	        phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",12 ,12 );
	        //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
	        bp.waitForElement();
	        bp.waitForElement();
	    	actual[42]=tp.navigateToCycle(phaseName);*/
	    	
	    	bp.waitForElement();
			actual[40]=tp.bulkAssignTestcasesSelectedFolder();
	    }
	    catch(Exception e)
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

	@When("^User chooses Assign all unassigned testcases to user Anyone from drop down$")
	public void user_chooses_Assign_all_unassigned_testcases_to_user_Anyone_from_drop_down() throws Throwable {
		try
		{
		String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 7, 9);
		String Check=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 1);
		bp.waitForElement();
		actual[41]=tp.assignAllUnassigned(assignee, Check);
		bp.waitForElement();
		 tp.goBackToCycle();
		}
		catch(Exception e)
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

	@When("^User navigates back to TestPlanning and chooses a existing phase in cycle and save$")
	public void user_navigates_back_to_TestPlanning_and_chooses_a_existing_phase_in_cycle_and_save() throws Throwable {
		try
		{
		bp.waitForElement();
		   rp= new ReleasePage(driver);
			actual[42]=rp.clickOnTestPlanning();
			tp=new TestPlanningPage(driver);
			
			String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",12 ,11 );
			bp.waitForElement();
			bp.waitForElement();
			actual[43]=tp.doubleClickOnCycle(cycleName1);
			
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 12, 12);
			bp.waitForElement();
		actual[44]=tp.addPhaseToCycle(Phase);
			
			String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			actual[45]=tp.bulkAssignment(Bulk_Type);
			bp.waitForElement();
		}
		catch(Exception e)
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

	@When("^User assigns the testcases to different users from assign to drop down menu$")
	public void user_assigns_the_testcases_to_different_users_from_assign_to_drop_down_menu() throws Throwable {
	    try
	    {
	    	String[] phaseName=new String[1];
		    phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",12 ,12 );
		    //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
		    bp.waitForElement();
		    bp.waitForElement();
			actual[46]=tp.navigateToCycle(phaseName);
			
			int[] TestCaseNo1=new int[1];
			TestCaseNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8);
			String Assignee1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
			 bp.waitForElement();
			 bp.waitForElement();
			actual[47]=tp.individualAssinTo(TestCaseNo1, Assignee1);
			
			int[] TestCaseNo2=new int[1];
			TestCaseNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8);
			String Assignee2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
			 bp.waitForElement();
			 bp.waitForElement();
			actual[48]=tp.individualAssinTo(TestCaseNo2, Assignee2);
	    }
	    catch(Exception e)
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

	@When("^User selects the system node and chooses Select All and assigns to Anyone$")
	public void user_selects_the_system_node_and_chooses_Select_All_and_assigns_to_Anyone() throws Throwable {
		try
		{
		String[] systemName=new String[1];
		systemName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",12 ,13 );
	    //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
	    bp.waitForElement();
	    bp.waitForElement();
		actual[49]=tp.navigateToCycle(systemName);
		
		bp.waitForElement();
		tp.selectallTestCase();
		String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
		bp.waitForElement();
		actual[50]=tp.assignAllSelected(assignee);
		}
		catch(Exception e)
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

	@When("^User selects a system node and clicks bulk assignment button$")
	public void user_selects_a_system_node_and_clicks_bulk_assignment_button() throws Throwable {
	   try
	   {
		   bp.waitForElement();
		   actual[51]=tp.bulkAssignTestcasesSelectedFolder();
	   }
	   catch(Exception e)
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

	@When("^User chooses Assign all unassigned testcases to user Anyone from drop down and save$")
	public void user_chooses_Assign_all_unassigned_testcases_to_user_Anyone_from_drop_down_and_save() throws Throwable {
		try
		{
		String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 7, 9);
		String Check=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 1);
		bp.waitForElement();
		actual[52]=tp.assignAllUnassigned(assignee, Check);
		bp.waitForElement();
		 tp.goBackToCycle();
		}
		catch(Exception e)
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

	@When("^User navigates to TestPlanning and selects existing phase and save$")
	public void user_navigates_to_TestPlanning_and_selects_existing_phase_and_save() throws Throwable {
		try
		{
		bp.waitForElement();
		   rp= new ReleasePage(driver);
			actual[53]=rp.clickOnTestPlanning();
			tp=new TestPlanningPage(driver);
			
			String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",12 ,11 );
			bp.waitForElement();
			bp.waitForElement();
			actual[54]=tp.doubleClickOnCycle(cycleName1);
			
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 12, 12);
			bp.waitForElement();
		actual[55]=tp.addPhaseToCycle(Phase);
		
		String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
		actual[56]=tp.bulkAssignment(Bulk_Type);
		bp.waitForElement();
			
		
		}
		catch(Exception e)
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

	@When("^User assigns the few testcases to different users from assign drop down$")
	public void user_assigns_the_few_testcases_to_different_users_from_assign_drop_down() throws Throwable {
		try
	    {
	    	String[] phaseName=new String[3];
		    phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",12 ,12 );
		    phaseName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",12 ,13 );
		    phaseName[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",12 ,14 );
		    //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
		    bp.waitForElement();
		    bp.waitForElement();
			actual[57]=tp.navigateToCycle(phaseName);
			
			int[] TestCaseNo1=new int[1];
			TestCaseNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8);
			String Assignee1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
			 bp.waitForElement();
			 bp.waitForElement();
			actual[58]=tp.individualAssinTo(TestCaseNo1, Assignee1);
			
			int[] TestCaseNo2=new int[1];
			TestCaseNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8);
			String Assignee2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
			 bp.waitForElement();
			 bp.waitForElement();
			actual[59]=tp.individualAssinTo(TestCaseNo2, Assignee2);
	    }
	    catch(Exception e)
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

	@When("^User selects all testcase in subsystem using Select All and assign to Anyone$")
	public void user_selects_all_testcase_in_subsystem_using_Select_All_and_assign_to_Anyone() throws Throwable {
	    try
	    {
	    	actual[60]=tp.selectallTestCase();
	    	bp.waitForElement();
	    	String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
	    	actual[61]=tp.assignAllSelected(assignee);
	    }
	    catch(Exception e)
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

	@When("^User selects subsystem and clicks on bulk assignment button$")
	public void user_selects_subsystem_and_clicks_on_bulk_assignment_button() throws Throwable {
	    
		try
		{
		bp.waitForElement();
		actual[62]=tp.bulkAssignTestcasesSelectedFolder();
		}
		catch(Exception e)
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

	@When("^User chooses option Assign All unassigned testcases to Anyone and save$")
	public void user_chooses_option_Assign_All_unassigned_testcases_to_Anyone_and_save() throws Throwable {
		try
		{
			String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 7, 9);
			String Check=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 1);
			bp.waitForElement();
			actual[63]=tp.assignAllUnassigned(assignee, Check);
			bp.waitForElement();
			
			 tp.goBackToCycle();
				 bp.waitForElement();
		}
		catch(Exception e)
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

	@Then("^User successfully assigns the testcases to anyone at different levels$")
	public void user_successfully_assigns_the_testcases_to_anyone_at_different_levels() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("User successfully assigns the testcases to anyone at different levels");
		}
		catch(Exception e)
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
