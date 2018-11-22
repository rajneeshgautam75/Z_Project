package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
//import com.zephyr.reusablemethods.ExecutioPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Assign_868135 extends LaunchBrowser{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage epp;
	boolean[] actual=new boolean[38];
	SoftAssert soft=new SoftAssert();
	
	String filename="Assign_868135";
	
	@Given("^User is in  TestRepository page$")
	public void user_is_in_TestRepository_page() throws Throwable {
		/*lb=new LaunchBrowser();
		   lb.preCond();
		   lp=new LoginPage(driver);
		   String Uname=Excel_Lib.getData(INPUT_PATH_3,"Login",2,0);
		   String Pass=Excel_Lib.getData(INPUT_PATH_3,"Login",2,1);
		   lp.enterUname(Uname);
		   lp.enterPass(Pass);
		   lp.clickOnLogin();*/
		 try
		   {
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_5,"Releases",6,0);
		   actual[0]=pp.selectProject(projectName);
		   bp=new BasePage();
		   bp.waitForElement();
		  
		   actual[1]=pp.selectRelease(releaseName);
		   bp.waitForElement();
		   //bp.waitForElement();
		   rp= new ReleasePage(driver);
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
		
	   
	

	@Given("^User creates new phase under release$")
	public void user_creates_new_phase_under_release() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_5, "Releases", 6, 0);
		  String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "TestPlanning", 2, 12);
		  String p_Desc1=Excel_Lib.getData(INPUT_PATH_5, "Phases", 2, 15);
		  
		  tr=new TestRepositoryPage(driver);
		  bp=new BasePage();
		 // bp.waitForElement();
		  actual[3]=tr.doubleClickOnRelease(releaseName);
		 // bp.waitForElement();
		  bp.waitForElement();
		 actual[4]= tr.addNode(p_Name1,p_Desc1);
		actual[5]= tr.doubleClickOnRelease(releaseName);
		 String[] phase=new String[1];
		 phase[0]=p_Name1;
		 actual[6]=tr.navigateToNode(releaseName, phase);
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

//	@When("^User creates a testcase under Phase$")
//	public void user_creates_a_testcase_under_Phase() throws Throwable {
//		
//		
//			try
//			{
//				bp.waitForElement();
//				actual[7]=tr.addTestCase();
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//				driver.close();
//		      	Relogin_TPE rl=new Relogin_TPE();
//		      	rl.reLogin();
//		      	throw e;
//		   	 
//			} 
//		
//		
//		
//		
//	   
//	}

	@When("^User performs  edit operation in testcase$")
	public void user_performs_edit_operation_in_testcase() throws Throwable {
		
		try
	    {
		actual[8]=tr.clickDetailButton();
		ctc=new CreateTestCasePage(driver);
		String tcName=Excel_Lib.getData(INPUT_PATH_5, "TestCases", 1, 0);
		String tcDesc=Excel_Lib.getData(INPUT_PATH_5,"TestCases" , 2, 0);
		
		actual[9]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
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
	   	 
		}   }

	@When("^User clones testcase by clicking on clone button$")
	public void user_clones_testcase_by_clicking_on_clone_button() throws Throwable {
		
		try
		{
			bp.waitForElement();
			actual[10]=tr.clickOnList();
			bp.waitForElement();
			tr.selectallTestCase();
			actual[11]=tr.cloneTestCase();
			bp.waitForElement();
			//tr.selectallTestCase();
			//bp.waitForElement();
			//tr.cloneTestCase();
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
	   	 
		}}

	@Then("^User is in a page of a Testplanning page$")
	public void user_is_in_a_page_of_a_Testplanning_page() throws Throwable {
		
		try
		{
			actual[12]=bp.waitForElement();
			rp= new ReleasePage(driver);
		actual[13]=rp.clickOnTestPlanning();
		bp.waitForElement();
		//bp.waitForElement();
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
	   	 
		}  }

	@Then("^User clicks on  cycle and enter all available fields$")
	public void user_clicks_on_cycle_and_enter_all_available_fields() throws Throwable {
		
		try {
			tp=new TestPlanningPage(driver);
			//String[] str=new String[4];
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "TestPlanning", 6, 11);
			String Build=Excel_Lib.getData(INPUT_PATH_5, "TestPlanning", 2, 0);
			String environ=Excel_Lib.getData(INPUT_PATH_5, "TestPlanning", 3, 0);
			String hide =Excel_Lib.getData(INPUT_PATH_5, "TestPlanning", 100, 100);
			//int start_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
			//int end_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1)
			bp.waitForElement();
			tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[14]=tp.CreateCycle(cycle, Build, environ, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 1, 23));
			String smonth=Excel_Lib.getData(INPUT_PATH_5, "TestPlanning", 10, 22);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 1, 21));
			bp.waitForElement();
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 1, 26));
			String emonth=Excel_Lib.getData(INPUT_PATH_5, "TestPlanning", 8, 25);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 1, 24));
			bp.waitForElement();
			
			bp.waitForElement();
			tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			tp.saveTestCycle();
			bp.waitForElement();
			//bp.waitForElement();
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

	@When("^User add existing   phase under a cycle$")
	public void user_add_existing_phase_under_a_cycle() throws Throwable {
		try
		{
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "TestPlanning",6 ,11 );
		     bp.waitForElement();
		     //bp.waitForElement();
		     tp.navigateToCycle(cycleName);
		     bp.waitForElement();
		    // bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "TestPlanning", 2, 12);
			bp.waitForElement();
		actual[15]=tp.addPhaseToCycle(Phase);
		bp.waitForElement();
		String Bulk_Type=Excel_Lib.getData(INPUT_PATH_5, "BulkAssignment", 1, 0);
		actual[16]=tp.bulkAssignment(Bulk_Type);
		bp.waitForElement();
		//bp.waitForElement();
	     //bp.waitForElement();
	     
	     
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

	@Then("^User is in TestExecution Page$")
	public void user_is_in_TestExecution_Page() throws Throwable {
		try
			{
				bp.waitForElement();
			rp= new ReleasePage(driver);
			bp.waitForElement();
			   actual[17]=rp.clickOnTestExecution(); 
			   bp.waitForElement();
			  // bp.waitForElement();
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

	@Then("^User execute testcases by selecting status across testcase$")
	public void user_execute_testcases_by_selecting_status_across_testcase() throws Throwable {
		try
		{
			epp=new ExecutionPage(driver);
		String[] cycleName=new String[3];
	    cycleName[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases",6 ,0 );
	    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "TestPlanning",6 ,11 );
	    cycleName[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "TestPlanning",2 ,12 );
	    
	    bp.waitForElement();
	    tp=new TestPlanningPage(driver);
	    bp.waitForElement();
	   // bp.waitForElement();
		actual[18]=tp.navigateToCycle(cycleName);
		bp.waitForElement();
		
		/*int[] testCaseNo=new int[1];
	    ;
	    testCaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,5 );
	    tp.selectSingleMultipleTestcase(testCaseNo);*/
	    
	    //status selection method should be implement here
		int statusDropDownType=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning",1 ,19 );
	    String statusType=Excel_Lib.getData(INPUT_PATH_5, "TestPlanning",1 ,18 );
	    bp.waitForElement();
	    bp.waitForElement();
	    
	    actual[19]=epp.executeStatus(statusDropDownType, statusType);
	    bp.waitForElement();
	    int statusDropDownType1=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning",2 ,19 );
	    String statusType1=Excel_Lib.getData(INPUT_PATH_5, "TestPlanning",2 ,18 );
	    bp.waitForElement();
	   // bp.waitForElement();
	    
	    actual[20]=epp.executeStatus(statusDropDownType1, statusType1);
	    bp.waitForElement();
	   // bp.waitForElement();
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

	@When("^User is in TestPlanning page$")
	public void user_is_in_TestPlanning_page() throws Throwable {
		try
		{
			rp= new ReleasePage(driver);
		actual[21]=rp.clickOnTestPlanning();
	   bp.waitForElement();
		bp.waitForElement();}
		 catch (Exception e) 
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

	@When("^User select phase and clicks on Assign$")
	public void user_select_phase_and_clicks_on_Assign() throws Throwable {
		try
		{	rp= new ReleasePage(driver);
			//bp.waitForElement();
		
		
		   actual[22]=bp.waitForElement();
		   tp=new TestPlanningPage(driver);
		   
		   bp.waitForElement();
		   String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "TestPlanning",6 ,11 );
		   tp.doubleClickOnCycle(cycleName1);
		   String[] cycleName=new String[2];
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "TestPlanning",6 ,11 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "TestPlanning",2 ,12 );
		    bp.waitForElement();
		   // bp.waitForElement();
		   // bp.waitForElement();
		   // bp.waitForElement();
		    
		    //bp.waitForElement();
			actual[23]=tp.navigateToCycle(cycleName);
			bp.waitForElement();
			//bp.waitForElement();
			//bp.waitForElement();
		   actual[24]=tp.assignPhase();
		   bp.waitForElement();
			//bp.waitForElement();
			//bp.waitForElement();
			String[] phaseName=new String[1];
		     phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "TestPlanning",2 ,12 );
		     bp.waitForElement();
		     //bp.waitForElement();
		     tp.navigateToCycle(phaseName);
		     bp.waitForElement();
		     //bp.waitForElement();
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
		
	

	@Then("^User selects single testcase and clicks on delete$")
	public void user_selects_single_testcase_and_clicks_on_delete() throws Throwable {
		try
		{   
	    int[] tcNo=new int[1];
	    tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 1, 19);
	    actual[25]=tp.selectSingleMultipleTestcase(tcNo);
	    bp.waitForElement();
	    actual[26]=tp.deleteAllSelectedTestCases();
	    bp.waitForElement();
		 }
		   catch (Exception e) 
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
	   
	

	@When("^User is in TestPLanning Page$")
	public void user_is_in_TestPLanning_Page() throws Throwable {
		log.info("User Successfully landed in TestPlanning page");
	   
	}

	@When("^User selects same cycle and adds same phase$")
	public void user_selects_same_cycle_and_adds_same_phase() throws Throwable {
		try
		
		{ rp= new ReleasePage(driver);
		 bp.waitForElement();
		tp=new TestPlanningPage(driver);
		 bp.waitForElement();
		actual[27]=rp.clickOnTestPlanning();
			
		    bp.waitForElement();
		   // bp.waitForElement();
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "TestPlanning",6 ,11 );
		     System.out.println(cycleName[0]);
		     bp.waitForElement();
		    // bp.waitForElement();
		     tp.navigateToCycle(cycleName);
		     bp.waitForElement();
		    // bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "TestPlanning", 2, 12);
			 bp.waitForElement();
		   //  bp.waitForElement();
		actual[28]=tp.addPhaseToCycle(Phase);
		bp.waitForElement();
		// bp.waitForElement();
		String Bulk_Type=Excel_Lib.getData(INPUT_PATH_5, "BulkAssignment", 1, 0);
		bp.waitForElement();
		actual[29]=tp.bulkAssignment(Bulk_Type);
		bp.waitForElement();
		//bp.waitForElement();
	    
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

	@Then("^User is in TestExecution page$")
	public void user_is_in_TestExecution_page() throws Throwable {
		try
		{
			bp.waitForElement();
		rp= new ReleasePage(driver);
		bp.waitForElement();
		   actual[30]=rp.clickOnTestExecution(); 
		   bp.waitForElement();
		  // bp.waitForElement();
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

	@Then("^User executes testcase by selecting selecting options across testcase status dropdown$")
	public void user_executes_testcase_by_selecting_selecting_options_across_testcase_status_dropdown() throws Throwable {
		
		try
		{
		String[] cycleName=new String[3];
	    cycleName[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases",6 ,0 );
	    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "TestPlanning",6 ,11 );
	    cycleName[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "TestPlanning",2 ,12 );
	    bp.waitForElement();
	   // bp.waitForElement();
	    tp=new TestPlanningPage(driver);
	    bp.waitForElement();
	   // bp.waitForElement();
		actual[31]=tp.navigateToCycle(cycleName);
		bp.waitForElement();
		//bp.waitForElement();
		/*int[] testCaseNo=new int[1];
	    ;
	    testCaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,5 );
	    tp.selectSingleMultipleTestcase(testCaseNo);*/
	    
	    //status selection method should be implement here
		int  statusDropDownType1=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning",1 ,19 );
	    String statusType1=Excel_Lib.getData(INPUT_PATH_5, "TestPlanning",1 ,18 );
	    bp.waitForElement();
	   // bp.waitForElement();
	    actual[32]=epp.executeStatus(statusDropDownType1, statusType1);
	    bp.waitForElement();
	   // bp.waitForElement();
	    int statusDropDownType2=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning",2,19 );
	    String statusType2=Excel_Lib.getData(INPUT_PATH_5, "TestPlanning",2 ,18 );
	    bp.waitForElement();
	    //bp.waitForElement();
	    actual[33]=epp.executeStatus(statusDropDownType2, statusType2);
	    actual[33]=bp.waitForElement();
	    bp.waitForElement();
	   /* String statusDropDownType3=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 ));
	    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,18 );
	    bp.waitForElement();
	    bp.waitForElement();
	    actual[31]=tp.statusDropDown(statusDropDownType3, statusType3);
	    bp.waitForElement();
	    bp.waitForElement();
	    String statusDropDownType4=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4,19 ));
	    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
	    bp.waitForElement();
	    bp.waitForElement();
	    actual[31]=tp.statusDropDown(statusDropDownType4, statusType4);
	    bp.waitForElement();
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

	@When("^User clicks on context  menu across  phase and  clicks on assign$")
	public void user_clicks_on_context_menu_across_phase_and_clicks_on_assign() throws Throwable {
		try
		{rp= new ReleasePage(driver);
		//bp.waitForElement();
		
		
		   bp.waitForElement();
		   tp=new TestPlanningPage(driver);
		   
		   bp.waitForElement();
		   String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "TestPlanning",6 ,11 );
		   tp.doubleClickOnCycle(cycleName1);
		   String[] cycleName=new String[2];
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "TestPlanning",6 ,11 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "TestPlanning",2 ,12 );
		    bp.waitForElement();
		   // bp.waitForElement();
		   // bp.waitForElement();
		    //bp.waitForElement();
		    
		    //bp.waitForElement();
			actual[34]=tp.navigateToCycle(cycleName);
			bp.waitForElement();
			//bp.waitForElement();
			//bp.waitForElement();
		   actual[35]=tp.assignPhase();
		   bp.waitForElement();
			//bp.waitForElement();
			//bp.waitForElement();
			String[] phaseName=new String[1];
		     phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "TestPlanning",2 ,12 );
		     bp.waitForElement();
		    // bp.waitForElement();
		     tp.navigateToCycle(phaseName);
		     bp.waitForElement();
		    // bp.waitForElement();
		    
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

	@When("^User selects all test cases and clicks on delete$")
	public void user_selects_all_test_cases_and_clicks_on_delete() throws Throwable {
		try
		{
			
			
		actual[36]=tp.selectallTestCase();
	    bp.waitForElement();
	    actual[37]=tp.deleteAllSelectedTestCases();
	    bp.waitForElement();
		 }
		   catch (Exception e) 
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

	@Then("^User succesfull deletes the testcases assigned to anyone$")
	public void user_succesfull_deletes_the_testcases_assigned_to_anyone() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("User successfully assigns the testcase");
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      
	   	 
		}
	   
	}

	
}
