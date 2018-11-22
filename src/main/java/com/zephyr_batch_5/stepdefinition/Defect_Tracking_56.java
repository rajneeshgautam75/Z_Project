package com.zephyr_batch_5.stepdefinition;

import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_56 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	DashBoardPage dp;
	ExecutionPage exep;
	ExternalJiraPage ejp;
	DefectTracking dt;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	CreateTestCasePage ctc;
	String fileName="Defect_Tracking_56";
	
	boolean[] actual=new boolean[27];
	SoftAssert soft=new SoftAssert();
	public String defectID;
	@Given("^User launch testRepository and create phase with testcase$")
	public void user_launch_testRepository_and_create_phase_with_testcase() throws Throwable {
	try
	   {
		 bp=new BasePage();
		 pp=new ProjectPage(driver);
		 dp=new DashBoardPage(driver);
		 rp=new ReleasePage(driver);
		 ejp=new ExternalJiraPage(driver);
		 dt=new DefectTracking(driver);
		 exep=new ExecutionPage(driver);
	     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
	     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[0]=pp.selectProject(projectName);
	     actual[1]=pp.selectRelease(releaseName);
	     bp.waitForElement();
	     actual[2]=rp.clickOnTestRep();
	     tr=new TestRepositoryPage(driver);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 6, 12);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		
		actual[3]=tr.clickOnRelease(releaseName);
		bp.waitForElement();
		actual[4]=tr.addNode(p_Name1,p_Desc1);  
		tr.doubleClickOnRelease(releaseName);
		String[] phase=new String[1];
		phase[0]=p_Name1;
		bp.waitForElement();
		actual[5]=tr.navigateToNode(releaseName, phase);
		for(int i=1;i<=4;i++)
		{
		tr.addTestCase();
		}
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

	@When("^User Launch TestPlanning to create cycle,add a phase to the cycle$")
	public void user_Launch_TestPlanning_to_create_cycle_add_a_phase_to_the_cycle() throws Throwable {
	try
	   {
		  bp.waitForElement();
		  actual[6]=rp.clickOnTestPlanning();
		  
		  tp=new TestPlanningPage(driver);
			//String[] str=new String[4];
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 6, 13);
			String build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
			String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
			String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
			actual[7]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			bp.waitForElement();
			actual[8]=tp.CreateCycle(cycle, build, environ, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
			String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
			String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
			bp.waitForElement();
			actual[9]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			bp.waitForElement();
			actual[10]=tp.saveTestCycle();
			bp.waitForElement();
			
			bp.waitForElement();
			actual[11]=rp.clickOnTestPlanning();
			
	    	String[] cycle1=new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 6, 13);
			actual[12]=tp.navigateToCycle(cycle1);
			
			bp.waitForElement();
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 6, 12);
			actual[13]=tp.addPhaseToCycle(phase);
			bp.waitForElement();
			String bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
			bp.waitForElement();
			actual[14]=tp.bulkAssignment(bulk_Type);
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

	@When("^User Launch testExecution$")
	public void user_Launch_testExecution() throws Throwable {
	try
	   {
		     /*pp=new ProjectPage(driver);//
			 bp=new BasePage();
			 rp=new ReleasePage(driver);
			 tr=new TestRepositoryPage(driver);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			 pp.selectProject(projectName);
		     pp.selectRelease(releaseName);// */
		   
		   bp.waitForElement();
		   actual[15]=rp.clickOnTestExecution(); 
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

	@Then("^Should be able to launch testExecution page$")
	public void should_be_able_to_launch_testExecution_page() throws Throwable {
	try
	   {
		actual[16]=exep.verifyExecutionPage();
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

	@When("^User navigate to the phase to execute testcase$")
	public void user_navigate_to_the_phase_to_execute_testcase() throws Throwable {
	try
	   {
		     /*pp=new ProjectPage(driver);//
			 bp=new BasePage();
			 rp=new ReleasePage(driver);
			 tp=new TestPlanningPage(driver);
			 dt=new DefectTracking(driver);
			 exep=new ExecutionPage(driver);
			 dp=new DashBoardPage(driver);
			 ejp=new ExternalJiraPage(driver);
			 tr=new TestRepositoryPage(driver);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			 pp.selectProject(projectName);
		     pp.selectRelease(releaseName);// */
		     
		     bp.waitForElement();
		   actual[17]=rp.clickOnTestExecution(); 
           bp.waitForElement();//
		   
		    String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6 ,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6 ,12 );
		    
		    bp.waitForElement();
		    tp=new TestPlanningPage(driver);
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
			actual[18]=tr.navigateToNode(releaseName, cycleName);
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

	@Then("^Should be able to execute testcases$")
	public void should_be_able_to_execute_testcases() throws Throwable {
	  try
	  {
		    int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[19]=exep.executeStatus(tcNo1[0], statusType1);
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

	@When("^User click on D button to link testcase$")
	public void user_click_on_D_button_to_link_testcase() throws Throwable {
	 try
	  {
		 int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1,19 );
		 actual[20]=exep.clickOnDefectButton(testcase1);
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

	@When("^search the defect and link defect to execution$")
	public void search_the_defect_and_link_defect_to_execution() throws Throwable {
	try
	  {
		String[] fields=new String[11];
        for(int i=0;i<=10;i++)
        {
        	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
        }
        String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,0);
	    String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
	    String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
		String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		for(int i=0;i<=4;i++)
		{
			bp.waitForElement();
		}
	    dt.createDefect(project, issuetype);
		dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
	    dt.saveDefect();
	    bp.waitForElement();
		defectID=exep.retrieveDefectId();
		bp.waitForElement();
		bp.waitForElement();
		dt.updateDefect();
		for(int i=0;i<=9;i++)
		{
			bp.waitForElement();
		}
		actual[21]=exep.searchDefect(defectID);
		bp.waitForElement();
		actual[22]=exep.linkDefect();
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
	
	@Then("^Should be able to link defect to execution$")
	public void should_be_able_to_link_defect_to_execution() throws Throwable {
	try
	  {
		int testcase=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1,19 );
		actual[23]=exep.viewTooltip(testcase);
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

	@When("^User search a linked defect in Defect Tracking page$")
	public void user_search_a_linked_defect_in_Defect_Tracking_page() throws Throwable {
	try
	  {
		for(int i=0;i<=3;i++)
		{
		bp.waitForElement();
		}
		rp.clickOnDefectTracking();
		bp.waitForElement();
		actual[24]=dp.searchAndSelectDefect(defectID);
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

	@Then("^Should be able to to delete the linked defect$")
	public void should_be_able_to_to_delete_the_linked_defect() throws Throwable {
	try
	  {
		   bp=new BasePage();
		   bp.switchWindowTab(1);
		   String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
		   System.out.println(Uname);
		   String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		   System.out.println(Pwd);
		   actual[25]=ejp.loginToExternalJira(Uname,Pwd);
		   actual[26]=ejp.DeleteDefectInJira();
		   bp.waitForElement();
		   ejp.logOutFromExternal_JIRA();
		   driver.close();
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

	@When("^User launch testExecution to check notification$")
	public void user_launch_testExecution_to_check_notification() throws Throwable {
	try
    {
		bp=new BasePage();
		bp.switchWindowTab(0);	
		rp.clickOnTestExecution();
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

	@Then("^Should be able to get notification$")
	public void should_be_able_to_get_notification() throws Throwable {
	try
    {
		bp=new BasePage();
		bp.switchWindowTab(0);
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

	@When("^User navigate to the notification$")
	public void user_navigate_to_the_notification() throws Throwable {
	try
    {
		Actions notification=new Actions(driver);
		notification.moveToElement(exep.moveToNotificationElement).perform();
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

	@Then("^Should be able to apply notification$")
	public void should_be_able_to_apply_notification() throws Throwable {
	try
    {
		Actions notification=new Actions(driver);
		boolean status=exep.applyNotification.isDisplayed();
		 System.out.println(status);
		 if(status==true)
		 {
		  bp.waitForElement();
		  notification.moveToElement(exep.applyNotification).click().perform();
		  bp.waitForElement();
		  String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		  tp.doubleClickOnCycle(releaseName);
		  bp.waitForElement();
		 }
		for(int k=0;k<=actual.length-1;k++)
		{
			System.out.println("Actual["+k+"]="+actual[k]);
			//soft.assertEquals(actual[k], true);
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
