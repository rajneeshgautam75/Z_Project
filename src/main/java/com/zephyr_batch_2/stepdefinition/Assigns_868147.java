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

public class Assigns_868147 extends LaunchBrowser {

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
	String filename="Assigns_868147";
	boolean[] actual=new boolean[35];
	SoftAssert soft=new SoftAssert();
	@Given("^User launches a TCC$")
	public void user_launches_a_TCC() throws Throwable 
	{
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

	@When("^User creates a Phase,system and subsystem and creates a testcases in all the nodes$")
	public void user_creates_a_Phase_system_and_subsystem_and_creates_a_testcases_in_all_the_nodes() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 1, 12);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 1, 15);
			
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
			
			//bp.waitForElement();
			//actual[5]=tr.doubleClickOnRelease(releaseName);
			
			//String[] phase1=new String[1];
			//phase1[0]=p_Name1;
			String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 1, 13);
			String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 1, 16);
			bp.waitForElement();
			//actual[6]=tr.navigateToNode(releaseName,phase);
			actual[6]=tr.navigateNode(phase);
			bp.waitForElement();
			bp.waitForElement();
			actual[7]=tr.addNode(s_Name1,s_Desc1);
			bp.waitForElement();
			
			
			bp.waitForElement();
			String[] system= new String[2];
			system[0]=p_Name1;
			system[1]=s_Name1;
			
			String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 1, 14);
			String ss_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 1, 17);
			bp.waitForElement();
			actual[8]=tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			actual[9]=tr.navigateToNode(releaseName, system);
			bp.waitForElement();
			tr.addTestCase();
			
			tr.doubleClickOnRelease(releaseName);
			tr.navigateToNode(releaseName, system);
			//tr.navigateNode(system);
			actual[10]=tr.addNode(ss_Name1,ss_Desc1);
			bp.waitForElement();
			
			String[] subsystem= new String[3];
			subsystem[0]=p_Name1;
			subsystem[1]=s_Name1;
			subsystem[2]=ss_Name1;
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			tr.navigateToNode(releaseName, subsystem);
			
			actual[11]=tr.addTestCase();
		
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

	@When("^User launches EAS and creates a cycle$")
	public void user_launches_EAS_and_creates_a_cycle() throws Throwable {
		try
		{
			 bp.waitForElement();
			rp= new ReleasePage(driver);
			 bp.waitForElement();
			 actual[12]=rp.clickOnTestPlanning();
		
			tp=new TestPlanningPage(driver);
			//String[] str=new String[4];
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 5, 11);
			String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
			String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
			String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
			bp.waitForElement();
			tp.clickOnAddTestCycleSymbol();
			//int start_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
			//int end_date=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 1);
			bp.waitForElement();
			bp.waitForElement();
			actual[13]=tp.CreateCycle(cycle, Build, environ, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
			String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
			String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
			bp.waitForElement();
			bp.waitForElement();
			actual[14]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			bp.waitForElement();
			actual[15]=tp.saveTestCycle();
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

	@When("^User creates a phase under an cycle$")
	public void user_creates_a_phase_under_an_cycle() throws Throwable {
		try
		{
			String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",5 ,11 );
		     bp.waitForElement();
		     bp.waitForElement();
		     actual[16]=tp.navigateToCycle(cycleName);
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 1, 12);
			bp.waitForElement();
		actual[17]=tp.addPhaseToCycle(Phase);
		
		bp.waitForElement();
		String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
		actual[18]=tp.bulkAssignment(Bulk_Type);
		
		String[] phaseName=new String[1];
	     phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,12 );
	     //phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,13 );
	     //phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,14 );
	     //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
	     bp.waitForElement();
	     bp.waitForElement();
		actual[19]=tp.navigateToCycle(phaseName);
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

	@When("^User clicks on the bulk assign button$")
	public void user_clicks_on_the_bulk_assign_button() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[20]=tp.bulkAssignTestcasesSelectedFolder();
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

	@Then("^User selects assign all unassigned testcases and selects user from the list and check apply to sub folder option and save$")
	public void user_selects_assign_all_unassigned_testcases_and_selects_user_from_the_list_and_check_apply_to_sub_folder_option_and_save() throws Throwable {
		try
		{
			String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 7, 9);
			String Check=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 1);
			bp.waitForElement();
			actual[21]=tp.assignAllUnassigned(assignee, Check);
			bp.waitForElement();
			actual[22]=pp.clickOnLogout();
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

	@Then("^As a Lead selects a subsystem in same phase$")
	public void as_a_Lead_selects_a_subsystem_in_same_phase() throws Throwable {
		try
		{
				lb=new LaunchBrowser();
				bp=new BasePage();
				bp.waitForElement();
			   //lb.preCond();
			   bp.waitForElement();
			   String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"URL");
			   lb.getUrl(url);
			   bp.waitForElement();
			   lp=new LoginPage(driver);
			   bp.waitForElement();
			   String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_2");
			   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_2");
		   
		   actual[23]=lp.enterUname(Uname);
		   actual[24]=lp.enterPass(Pass);
		   actual[25]=lp.clickOnLogin();
		   bp.waitForElement();
		   bp.waitForElement();
		   pp=new ProjectPage(driver);
		   
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   actual[26]=pp.selectProject(projectName);
		   bp.waitForElement();
		   actual[27]=pp.selectRelease(releaseName);
		
		   bp.waitForElement();
		   rp= new ReleasePage(driver);
			actual[28]=rp.clickOnTestPlanning();
			tp=new TestPlanningPage(driver);
			
			String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",5 ,11 );
			bp.waitForElement();
			bp.waitForElement();
			actual[29]=tp.doubleClickOnCycle(cycleName1);
			
		String[] cycleName=new String[2];
	    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",5 ,11 );
	    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,12 );
	    //cycleName[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,13 );
	    //cycleName[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,14 );
	    bp.waitForElement();
//	    bp.waitForElement();
//	    bp.waitForElement();
	    actual[30]=tp.navigateToCycle(cycleName);
	    bp.waitForElement();
	    bp.waitForElement();
	    actual[31]=tp.assignPhase();
	    
	    String[] phaseName=new String[3];
	     phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,12 );
	     phaseName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,13 );
	     phaseName[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,14 );
	     //cycleName[1]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,0 );
	     bp.waitForElement();
	     bp.waitForElement();
		actual[32]=tp.navigateToCycle(phaseName);
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

	@Then("^User click on bulk assign$")
	public void user_click_on_bulk_assign() throws Throwable {
		try
		{
			bp.waitForElement();
		actual[33]=tp.bulkAssignTestcasesSelectedFolder();
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

	@When("^User selects assign all unassigned testcases and selects user from the list$")
	public void user_selects_assign_all_unassigned_testcases_and_selects_user_from_the_list() throws Throwable {
		try
	    {
			String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 6, 9);
			String Check=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 1);
			bp.waitForElement();
			actual[34]=tp.assignAllUnassigned(assignee, Check);
			
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

	@Then("^Manager and Lead successfully clicks the confirmation box$")
	public void manager_and_Lead_successfully_clicks_the_confirmation_box() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("User views the flags across testcases successfully");
		pp.clickOnLogout();
		pp.closeBrowser();
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
