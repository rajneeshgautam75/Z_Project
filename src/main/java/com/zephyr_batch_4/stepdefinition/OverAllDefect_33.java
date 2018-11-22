package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OverAllDefect_33 extends LaunchBrowser{
	
   LaunchBrowser lb=new LaunchBrowser();
   String fileName="OverAllDefect_33";
   
    LoginPage lp;
    BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	DashBoardPage dp;
	ExecutionPage ep;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	
    boolean actual[]=new boolean[52];
    SoftAssert soft=new SoftAssert();
    
    String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
    String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
    
    private int defectCount;

    @Given("^Test Manager is in Test Repository Page$")
    public void test_Manager_is_in_Test_Repository_Page() throws Throwable {
          try
            {
            lp=new LoginPage(driver);
   	        bp=new BasePage();
   	        pp=new ProjectPage(driver);
   	        ep=new ExecutionPage(driver);
   	        rp=new ReleasePage(driver); 
            actual[0]=pp.clickOnLogout();
            actual[1]=bp.waitForElement();
   	        String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
   		    actual[2]=lp.enterUname(userName);
   		    String Password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Password_1");
   		    actual[3]=lp.enterPass(Password);
   		    bp.waitForElement();
   		    actual[4]=lp.clickOnLogin();
   		    bp.waitForElement();  
  			actual[1]=pp.selectProject(project);
  			actual[2]=pp.selectRelease(release);
  			bp.waitForElement();
  			actual[3]=rp.clickOnTestRep();
       		actual[4]=bp.waitForElement(); 
             }
           catch(Exception e)
           {
            e.printStackTrace();
            lb.getScreenShot(fileName);
            driver.close();
            Relogin_TPE rl=new Relogin_TPE();
            rl.reLogin();
            throw e; 
           }
        }

	@When("^Create a phase and add two testcases, launch Test planning and assign phase to cycle$")
	public void create_a_phase_and_add_two_testcases_launch_Test_planning_and_assign_phase_to_cycle() throws Throwable {
		 try
	        {
			 tr=new TestRepositoryPage(driver);
			 tp=new TestPlanningPage(driver);
			 actual[5]=tr.clickOnRelease(release);
	  		 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 50, 0);
	  		 String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 1);
	  		 actual[6]=tr.addNode(name, Desc);
	  		 bp.waitForElement();
	  		 String [] navigation=new String [1];
	  		 navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 50, 0);
	  		 actual[7]=tr.navigateToNode(release, navigation);
	  		 actual[8]=tr.addTestCase();
	  		 actual[9]=tr.addTestCase();
	  		 bp.waitForElement();   
	  		 actual[10]=rp.clickOnTestPlanning();
			 actual[11]=tp.clickOnAddTestCycleSymbol();
			 bp.waitForElement();
			 String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 24, 0);
			 String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
			 String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
			 String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
			 actual[12]=tp.CreateCycle(cycle, Build, Environment, hide);
			 String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
			 String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
			 String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
			 String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
			 String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
			 String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
			 actual[13]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			 actual[14]=tp.saveTestCycle(); 
			 bp.waitForElement(); 
			 String [] cycle1 =new String[1];
			 cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 24, 0);
			 actual[15]=tp.navigateToCycle(cycle1);
			 String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 50,0);
			 actual[16]=tp.addPhaseToCycle(Phase);
			 actual[17]=bp.waitForElement();
			 String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
		 	 actual[18]=tp.bulkAssignment(Bulk_type);
		 	 tp.goBackToCycle(); 
	         }
	       catch(Exception e)
	        {
	         e.printStackTrace();
	         lb.getScreenShot(fileName);
	         driver.close();
	         Relogin_TPE rl=new Relogin_TPE();
	         rl.reLogin();
	         throw e; 
	        }    
	}

	@When("^Launch Test Execution, execute testcases and link defects$")
	public void launch_Test_Execution_execute_testcases_and_link_defects() throws Throwable {
		 try
	        {
			 ep=new ExecutionPage(driver);
			 actual[19]=rp.clickOnTestExecution();
			 actual[20]=bp.waitForElement();
			 String[] cycleName=new String[2];           
			 cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",24,0 );
			 cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase",50,0 );
			 actual[44]=tr.navigateToNode(release, cycleName);
			 bp.waitForElement();
			 actual[22]=ep.selectAndDeselectAllTestCase();
			 bp.waitForElement();
			 String status12=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
			 actual[23]=ep.changeMultiSelectedStatus(status12);
			 bp.waitForElement();
			 int testcase1=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
			 actual[24]=ep.clickOnDefectButton(testcase1);
			 bp.waitForElement();
			 String defectId=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 6);
			 actual[25]=ep.linkDefect(defectId);
			 bp.waitForElement();
			 bp.waitForElement();
			 int testcase2=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 0);
			 actual[26]=ep.clickOnDefectButton(testcase2);
			 bp.waitForElement();
			 actual[27]=ep.linkDefect(defectId);
			 bp.waitForElement();
			 bp.waitForElement();
			 
	         }
	       catch(Exception e)
	        {
	         e.printStackTrace();
	         lb.getScreenShot(fileName);
	         driver.close();
	         Relogin_TPE rl=new Relogin_TPE();
	         rl.reLogin();
	         throw e; 
	        }   
	}

	@Then("^Defects should be linked to particular testcases$")
	public void defects_should_be_linked_to_particular_testcases() throws Throwable {
		 try
	        {
			 int testcase1=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
			 String defectId=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 6);
			 actual[28]=ep.validateLinkedDefect(testcase1, defectId);
			 bp.waitForElement();
			 int testcase2=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 0);
			 actual[29]=ep.validateLinkedDefect(testcase2, defectId);
			 bp.waitForElement();
			 
	         }
	       catch(Exception e)
	        {
	         e.printStackTrace();
	         lb.getScreenShot(fileName);
	         driver.close();
	         Relogin_TPE rl=new Relogin_TPE();
	         rl.reLogin();
	         throw e; 
	        }   
	}

	@When("^Launch DashBoards Page$")
	public void launch_DashBoards_Page() throws Throwable {
		 try
	        {
			 dp=new DashBoardPage(driver);
		     actual[30]=dp.clickOnManageDashboards();
			 bp.waitForElement();
	         }
	       catch(Exception e)
	        {
	         e.printStackTrace();
	         lb.getScreenShot(fileName);
	         driver.close();
	         Relogin_TPE rl=new Relogin_TPE();
	         rl.reLogin();
	         throw e; 
	        }   
	}

	@Then("^DashBoards window  page should be launched$")
	public void dashboards_window_page_should_be_launched() throws Throwable {
		 try
	        {
			 actual[31]=dp.validateDashboards();
	         }
	       catch(Exception e)
	        {
	         e.printStackTrace();
	         lb.getScreenShot(fileName);
	         driver.close();
	         Relogin_TPE rl=new Relogin_TPE();
	         rl.reLogin();
	         throw e; 
	        }   
	}

	@When("^Click on dashboard created$")
	public void click_on_dashboard_created() throws Throwable {
		 try
	        {
			 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 0);
			 String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
			 String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
			 String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
			 actual[32]=dp.clickOnAddDashBoardSymbol();
			 bp.waitForElement();
			 actual[33]=dp.enterDashBoardDetails(name, desc, layout, shareType);
			 bp.waitForElement();
			 actual[34]=dp.searchDashboard(name);
			 bp.waitForElement();
			 actual[35]=dp.selectDashboard(name);
			 bp.waitForElement();
	         }
	       catch(Exception e)
	        {
	         e.printStackTrace();
	         lb.getScreenShot(fileName);
	         driver.close();
	         Relogin_TPE rl=new Relogin_TPE();
	         rl.reLogin();
	         throw e; 
	        }   
	}

	@When("^Click on add gadget symbol and add Overall Defect gadget$")
	public void click_on_add_gadget_symbol_and_add_Overall_Defect_gadget() throws Throwable {
		 try
	        {
			 actual[36]=dp.clickOnAddGadgetSymbol();
			 bp.waitForElement();
		     String gadgetName=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 4);
			 actual[37]=dp.addGadget(gadgetName);
			 bp.waitForElement();
	         }
	       catch(Exception e)
	        {
	         e.printStackTrace();
	         lb.getScreenShot(fileName);
	         driver.close();
	         Relogin_TPE rl=new Relogin_TPE();
	         rl.reLogin();
	         throw e; 
	        }   
	}

	@Then("^Overall Defect gadget should be added to dashboard$")
	public void overall_Defect_gadget_should_be_added_to_dashboard() throws Throwable {
		 try
	        {
			 String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 4);
			 actual[38]=dp.validateGadget(gadget);
			 bp.waitForElement();
	         }
	       catch(Exception e)
	        {
	         e.printStackTrace();
	         lb.getScreenShot(fileName);
	         driver.close();
	         Relogin_TPE rl=new Relogin_TPE();
	         rl.reLogin();
	         throw e; 
	        }   
	}

	@When("^Configure gadget with project, release and refresh rate details$")
	public void configure_gadget_with_project_release_and_refresh_rate_details() throws Throwable {
		 try
	        {
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			 actual[39]=dp.configureTestAutomationStatusGadget(project, release, refreshRate);
			 bp.waitForElement();
	         }
	       catch(Exception e)
	        {
	         e.printStackTrace();
	         lb.getScreenShot(fileName);
	         driver.close();
	         Relogin_TPE rl=new Relogin_TPE();
	         rl.reLogin();
	         throw e; 
	        }  
	}

	@Then("^should show defects linked$")
	public void should_show_defects_linked() throws Throwable {
		 try
	        {
			defectCount=dp.linkCountInGadgetPage();
			bp.waitForElement();
			pp.backToProjectPage();
	         }
	       catch(Exception e)
	        {
	         e.printStackTrace();
	         lb.getScreenShot(fileName);
	         driver.close();
	         Relogin_TPE rl=new Relogin_TPE();
	         rl.reLogin();
	         throw e; 
	        }   
	}

	@When("^Launch test execution and De-link one defect from execution$")
	public void launch_test_execution_and_De_link_one_defect_from_execution() throws Throwable {
		 try
	        {
			 actual[41]=pp.selectProject(project);
	  		 actual[42]=pp.selectRelease(release);
	  		 bp.waitForElement();
	  		 actual[43]=rp.clickOnTestExecution();
	  		 bp.waitForElement();
	  		 String[] cycleName=new String[2];           
			 cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",24,0 );
			 cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase",50,0);
			 actual[44]=tr.navigateToNode(release, cycleName);
			 bp.waitForElement();
			 int testcase1=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
			 actual[45]=ep.clickOnDefectButton(testcase1);
			 bp.waitForElement();
			 int testcase[]=new int[1];
			 testcase[0]=testcase1;
			 actual[46]=ep.deleteDefect(testcase);
			 bp.waitForElement();
			 ep.clickOnCancelDefectWindow();
	         }
	       catch(Exception e)
	        {
	         e.printStackTrace();
	         lb.getScreenShot(fileName);
	         driver.close();
	         Relogin_TPE rl=new Relogin_TPE();
	         rl.reLogin();
	         throw e; 
	        }   
	}

	@When("^View Overall Defects Gadget after de-linking one defect from executions$")
	public void view_Overall_Defects_Gadget_after_de_linking_one_defect_from_executions() throws Throwable {
		 try
	        {
			 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 0);
			 actual[47]=dp.clickOnManageDashboards();
			 bp.waitForElement();
			 actual[48]=dp.validateDashboards();
			 actual[49]=dp.searchDashboard(name);
			 bp.waitForElement();
			 actual[50]=dp.selectDashboard(name);
			 bp.waitForElement();
	         }
	       catch(Exception e)
	        {
	         e.printStackTrace();
	         lb.getScreenShot(fileName);
	         driver.close();
	         Relogin_TPE rl=new Relogin_TPE();
	         rl.reLogin();
	         throw e; 
	        }    
	}

	@Then("^Should show total defect count reduced by one$")
	public void should_show_total_defect_count_reduced_by_one() throws Throwable {
		 try
	        {
			 int finalCount=dp.linkCountInGadgetPage();
			 if(defectCount>finalCount)
			 {
			   System.out.println("Validated- total defect-count reduced by 1");	 
			 }
			 actual[51]=pp.backToProjectPage();
			 for(int k=0;k<=actual.length-1;k++)
			 {
			 System.out.println("Actual["+k+"]=" + actual[k]);
			 soft.assertEquals(actual[k], true);
			 }
	         }
	       catch(Exception e)
	        {
	         e.printStackTrace();
	         lb.getScreenShot(fileName);
	         driver.close();
	         Relogin_TPE rl=new Relogin_TPE();
	         rl.reLogin();
	         throw e; 
	        }

	}
	

}
