package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Create_Cycle_868156 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	
	boolean[] actual=new boolean[53];
	 SoftAssert soft=new SoftAssert();
	 
	 String fileName="Create_Cycle_868156";
	 
	
	@Given("^User is in a Test planning page$")
	public void user_is_in_a_Test_planning_page() throws Throwable {
		try
		   {
			lb=new LaunchBrowser();
			bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[0]=pp.selectProject(projectName);
		   bp.waitForElement();
		   actual[1]=pp.selectRelease(releaseName);
		   
		   bp.waitForElement();
		   bp.waitForElement();
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestPlanning(); 
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

	@Given("^User creates a cycle with the available fields and check hide option and save$")
	public void user_creates_a_cycle_with_the_available_fields_and_check_hide_option_and_save() throws Throwable {
		try
		{
		bp=new BasePage();
		tp=new TestPlanningPage(driver);
		//String[] str=new String[4];
		String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 19, 11);
		String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
		String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
		String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 1, 27);
		tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		bp.waitForElement();
		actual[3]=tp.CreateCycle(cycle, Build, environ, hide);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
		String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
		String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
		bp.waitForElement();
		actual[4]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		bp.waitForElement();
		actual[5]=tp.saveTestCycle();
		
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

	@When("^User clicks on cycle context menu and clicks on clone option and save$")
	public void user_clicks_on_cycle_context_menu_and_clicks_on_clone_option_and_save() throws Throwable {
		try
		{
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",19 ,11 );
		     actual[6]=tp.navigateToCycle(cycleName);
		     
		     //bp.waitForElement();
		     //String testAssignment="";
				String hide="";
				 String cycle="";
					String Build="";
		     String duration="";
			String environ="";
			String testCaseAssignment="";
			bp.waitForElement();
			actual[7]=tp.cloneCycle(cycle, Build, duration, environ, hide, testCaseAssignment);
			bp.waitForElement();
			actual[8]=tp.saveTestCycle();
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

	@When("^User creates a test cycle with available fields and save$")
	public void user_creates_a_test_cycle_with_available_fields_and_save() throws Throwable {
		try
		{
		String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 20, 11);
		String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
		String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
		String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
		bp.waitForElement();
		actual[9]=tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		bp.waitForElement();
		actual[10]=tp.CreateCycle(cycle, Build, environ, hide);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
		String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
		String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
		bp.waitForElement();
		actual[11]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		bp.waitForElement();
		actual[12]=tp.saveTestCycle();
		
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

	@When("^User creates a phase by choosing an existing phase and save$")
	public void user_creates_a_phase_by_choosing_an_existing_phase_and_save() throws Throwable {
		try
		{
	    rp=new ReleasePage(driver);
	    bp.waitForElement();
	    bp.waitForElement();
	    actual[13]=rp.clickOnTestRep();
		tr=new TestRepositoryPage(driver);
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
		  String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 19, 12);
		  String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 19, 15);
		  
		  tr=new TestRepositoryPage(driver);
		  bp=new BasePage();
		  bp.waitForElement();
		  actual[14]=tr.doubleClickOnRelease(releaseName);
		  bp.waitForElement();
		 actual[4]= tr.addNode(p_Name1,p_Desc1);
			actual[15]=tr.doubleClickOnRelease(releaseName);
		 String[] phase1=new String[1];
		 phase1[0]=p_Name1;
		 actual[16]=tr.navigateToNode(releaseName, phase1);
		 tr.addTestCase();
		 tr.doubleClickOnRelease(releaseName);
		 
		 String p_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 20, 12);
		  String p_Desc2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 20, 15);
		  //tr.doubleClickOnRelease(releaseName);
		  bp.waitForElement();
		 actual[17]= tr.addNode(p_Name2,p_Desc2);
		 String[] phase2=new String[1];
		 phase2[0]=p_Name2;
		 tr.doubleClickOnRelease(releaseName);
		 actual[18]=tr.navigateToNode(releaseName, phase2);
		 tr.addTestCase();
		 
		 bp.waitForElement();
		actual[19]=rp.clickOnTestPlanning();
		tp=new TestPlanningPage(driver);
		
		String[] cycle=new String[1];
		cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 20, 11);
		actual[20]=tp.navigateToCycle(cycle);
		
		
		String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 19, 12);
		bp.waitForElement();
		actual[21]=tp.addPhaseToCycle(phase);
		
		String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
		bp.waitForElement();
		actual[22]=tp.bulkAssignment(Bulk_Type);
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

	@When("^User chooses assign individually and save$")
	public void user_chooses_assign_individually_and_save() throws Throwable {
	    try
	    {
			   String[] cycleName=new String[1];
			     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",19 ,12 );
			     actual[23]=tp.navigateToCycle(cycleName);
			     
			     int[] TestCaseNo=new int[1];
					TestCaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8);
					String Assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
					actual[24]=tp.individualAssinTo(TestCaseNo, Assignee);
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

	@When("^User navigates to a cycle and check hide option and save$")
	public void user_navigates_to_a_cycle_and_check_hide_option_and_save() throws Throwable {
		 try
		   {
			   actual[25]=tp.goBackToCycle();
			   
			   String[] cycleName=new String[1];
			     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",20 ,11 );
			     bp.waitForElement();
			     actual[26]=tp.navigateToCycle(cycleName);
			     
			     //String hide="";
				 String cycle="";
					String Build="";
		     String duration="";
			String environ="";
			String testCaseAssignment="";
			     //String testassign="";
				 String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 1, 27);
				 bp.waitForElement();
					actual[27]=tp.cloneCycle(cycle, Build, duration, environ, hide, testCaseAssignment);
					bp.waitForElement();
					actual[28]=tp.saveTestCycle();
			      
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

	@When("^User clicks on clone option and checks Also copy testcase assignments over and save$")
	public void user_clicks_on_clone_option_and_checks_Also_copy_testcase_assignments_over_and_save() throws Throwable {
		try
		   {
			   actual[29]=rp.clickOnTestPlanning();
			   
			   String[] cycleName=new String[1];
			     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",20 ,11 );
			     actual[30]=tp.navigateToCycle(cycleName);
			     
			     String testassign=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 27);
				 String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				 bp.waitForElement();
				 
				
				 String cycle="";
					String Build="";
		     String duration="";
			String environ="";
			
					actual[31]=tp.cloneCycle(cycle, Build, duration, environ, hide, testassign);
					bp.waitForElement();
					actual[32]=tp.saveTestCycle();
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

	@When("^User creates a cycle with available fields and save$")
	public void user_creates_a_cycle_with_available_fields_and_save() throws Throwable {
		try
		{
			actual[33]=rp.clickOnTestPlanning();
			
		String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 21, 11);
		String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
		String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
		String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
		bp.waitForElement();
		actual[34]=tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		bp.waitForElement();
		actual[35]=tp.CreateCycle(cycle, Build, environ, hide);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
		String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
		String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
		bp.waitForElement();
		actual[36]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		bp.waitForElement();
		actual[37]=tp.saveTestCycle();
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

	@When("^User creates a phase by choosing an existing phases$")
	public void user_creates_a_phase_by_choosing_an_existing_phases() throws Throwable {

		try
		{
			actual[38]=rp.clickOnTestPlanning();
		
		String[] cycle=new String[1];
		cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 21, 11);
		actual[39]=tp.navigateToCycle(cycle);
		
		
		String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 20, 12);
		bp.waitForElement();
		bp.waitForElement();
		actual[40]=tp.addPhaseToCycle(phase);
		
		String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
		bp.waitForElement();
		actual[41]=tp.bulkAssignment(Bulk_Type);
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

	@When("^User navigates to a cycle and check hide button and save$")
	public void user_navigates_to_a_cycle_and_check_hide_button_and_save() throws Throwable {
		try
		   {
			   actual[42]=tp.goBackToCycle();
			   
			   
			   String[] cycleName=new String[1];
			     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",21 ,11 );
			     actual[43]=tp.navigateToCycle(cycleName);
			     
			     String testassign="";
				 String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 1, 27);
				 bp.waitForElement();
				 String cycle="";
					String Build="";
		     String duration="";
			String environ="";
				 
				actual[44]=tp.cloneCycle(cycle, Build, duration, environ, hide, testassign);
				bp.waitForElement();
				actual[45]=tp.saveTestCycle();
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

	@When("^User clicks on clone and checks Also copy testcase assignments over and save$")
	public void user_clicks_on_clone_and_checks_Also_copy_testcase_assignments_over_and_save() throws Throwable {
		try
		   {
			   actual[46]=rp.clickOnTestPlanning();
			   
			   String[] cycleName=new String[1];
			     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",21 ,11 );
			     String no=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8 ));
			     actual[47]=tp.navigateToClonedCycle(cycleName, no);
			     String cycle="";
					String Build="";
		     String duration="";
			String environ="";
			     String testassign=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 27);
				 String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
					actual[48]=tp.cloneCycle(cycle, Build, duration, environ, hide, testassign);
					bp.waitForElement();
					actual[49]=tp.saveTestCycle();
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

	@When("^User clicks on context menu across cycle and click on clone and edit the fields and save$")
	public void user_clicks_on_context_menu_across_cycle_and_click_on_clone_and_edit_the_fields_and_save() throws Throwable {
		try
		   {
			bp.waitForElement();
			   actual[50]=rp.clickOnTestPlanning();
			   
			   String[] cycleName=new String[1];
			     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",21 ,11 );
			     bp.waitForElement();
			     actual[51]=tp.navigateToCycle(cycleName);
			     
			     String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",22 ,11 );
			     String Build=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,0 );
			     String environ=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,0 );
			     String hide=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,27 );
			     bp.waitForElement();
			     bp.waitForElement();
					actual[52]=tp.editCycle(cycle, Build, environ, hide);
					bp.waitForElement();
					tp.saveTestCycle();
			      
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

	@Then("^User successfully clone the cycle$")
	public void user_successfully_clone_the_cycle() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("User successfully clone the cycle");
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
