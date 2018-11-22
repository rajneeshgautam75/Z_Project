package com.zephyr_batch_5.stepdefinition;

import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_6 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	ExecutionPage exep;
	DefectTracking dt;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	String fileName="Defect_Tracking_6";
	
	boolean[] actual=new boolean[70];
	SoftAssert soft=new SoftAssert();
	
	private String[] fields=new String[12];
	{
	for(int i=0;i<=11;i++)
	{
		fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);	
	}
	}
	String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
	String components=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,19);
	String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,6);
	String fixVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,27);
	String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
	String labels=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
	String env=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,22);
	String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
	
	@Given("^User is in the defectTracking page$")
	public void user_is_in_the_defectTracking_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 pp=new ProjectPage(driver);
		 bp=new BasePage();
		 rp=new ReleasePage(driver);
		 dt=new DefectTracking(driver);
		 exep=new ExecutionPage(driver);
		 pp.selectProject(projectName);
		 pp.selectRelease(releaseName);
		 actual[0]=pp.clickOnDefectTracking();
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

	@When("^User click on create defect button and enter the projectName and issueType$")
	public void user_click_on_create_defect_button_and_enter_the_projectName_and_issueType() throws Throwable {
	try
	   {
		   dt=new DefectTracking(driver);
		   String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		   actual[1]=dt.createDefect(project, issuetype);
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

	@When("^enter the minimum required fields and save$")
	public void enter_the_minimum_required_fields_and_save() throws Throwable {
	try
	   {
	    actual[2]=dt.fileNewDefect(summary, fields[0],fields[1],desc,fields[2],priority,fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9]);
	    actual[3]=dt.saveDefect();
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

	@Then("^Should be able to Create defect$")
	public void should_be_able_to_Create_defect() throws Throwable {
	try
	  {
		 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		 actual[4]=dt.validateDefect(project,issuetype);
		 bp.waitForElement();
		 actual[5]=dt.updateDefect();
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

	@When("^search a defect and select the defect in defect tracking page$")
	public void search_a_defect_and_select_the_defect_in_defect_tracking_page() throws Throwable {
	try
	   {
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,30);
		 actual[6]=dt.searchDefect(defectID);
		 actual[7]=dt.selectAllDefects();
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

	@When("^Click on Create Subtask button and enter the issueType$")
	public void click_on_Create_Subtask_button_and_enter_the_issueType() throws Throwable {
	try
	  {
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,14);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,31);
		 actual[8]=dt.defectsOperation(defectValue);
		 actual[9]=dt.createDefectSubtask(issuetype);
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

	@When("^enter the minimum required fields and save the Subtask$")
	public void enter_the_minimum_required_fields_and_save_the_Subtask() throws Throwable {
	try
	   {
	    actual[10]=dt.fileNewDefect(summary, fields[0],fields[1],desc,fields[2],priority,fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9]);
	    actual[11]=dt.saveDefect();
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

	@Then("^Should be able to create defect Subtask$")
	public void should_be_able_to_create_defect_Subtask() throws Throwable {
	try
	  {
		 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,31);
		 actual[12]=dt.validateDefect(project,issuetype);
		 bp.waitForElement();
		 actual[13]=dt.updateDefect();
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

	@When("^Click on create defect button and enter the projectName and issueType$")
	public void click_on_create_defect_button_and_enter_the_projectName_and_issueType() throws Throwable {
	try
	   {
		   String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		   rp.clickOnTestRep();
		   bp.waitForElement();
		   bp.waitForElement();
		   pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[14]=dt.createDefect(project, issuetype);
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

	@When("^enter the mandatory fields and optional fields and save$")
	public void enter_the_mandatory_fields_and_optional_fields_and_save() throws Throwable {
		try
		   {
			    actual[15]=dt.fileNewDefect(summary, components,fields[0],desc, fixVersion, priority, assignee, labels,fields[1],env,fields[2],fields[3],fields[4]);
			    actual[16]=dt.saveDefect();
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

	@Then("^Should be able to create defect with mandatory and optional fields$")
	public void should_be_able_to_create_defect_with_mandatory_and_optional_fields() throws Throwable {
	try
	  {
		 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		 //String summary=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 actual[17]=dt.validateDefect(project,issuetype);
		 bp.waitForElement();
		// dt.fileNewDefect(summary, fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10],fields[11]);
		 bp.waitForElement();
		 Actions act=new Actions(driver);
		 act.moveToElement(dt.cancelUpdateDefect).pause(1200).click().build().perform();
		 //actual[18]=dt.updateDefect();
//		 driver.navigate().refresh();
         for(int i=0;i<=3;i++)
         {
        	 bp.waitForElement();
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

	@When("^Search a defect and select the defect in DefectTracking page$")
	public void search_a_defect_and_select_the_defect_in_DefectTracking_page() throws Throwable {
	try
	   {
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,30);
		 actual[18]=dt.searchDefect(defectID);
		 actual[19]=dt.selectAllDefects();
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

	@When("^Click on Create Subtask button and enter the IssueType$")
	public void click_on_Create_Subtask_button_and_enter_the_IssueType() throws Throwable {
	try
	  {
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,14);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,31);
		 actual[20]=dt.defectsOperation(defectValue);
		 actual[21]=dt.createDefectSubtask(issuetype);
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

	@When("^enter the mandatory and optional fields$")
	public void enter_the_mandatory_and_optional_fields() throws Throwable {
	try
	   {
		    actual[22]=dt.fileNewDefect(summary, components,fields[0],desc, fixVersion, priority, assignee, labels,fields[1],fields[2],fields[3],fields[4],fields[5]);
		    actual[23]=dt.saveDefect();
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

	@Then("^Should be able to create subtask with minimum required and optional fields$")
	public void should_be_able_to_create_subtask_with_minimum_required_and_optional_fields() throws Throwable {
	try
	  {
		 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,31);
		 actual[24]=dt.validateDefect(project,issuetype);
		 bp.waitForElement();
		 actual[25]=dt.updateDefect();
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

	@When("^launch TestRepository and create a phase with testcase$")
	public void launch_TestRepository_and_create_a_phase_with_testcase() throws Throwable {
	  try
	  {
		     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		     bp.waitForElement();
		     actual[26]=rp.clickOnTestRep();
		     tr=new TestRepositoryPage(driver);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 13, 12);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			
			actual[27]=tr.clickOnRelease(releaseName);
			bp.waitForElement();
			actual[28]=tr.addNode(p_Name1,p_Desc1);  
			tr.doubleClickOnRelease(releaseName);
			String[] phase=new String[1];
			phase[0]=p_Name1;
			bp.waitForElement();
			actual[29]=tr.navigateToNode(releaseName, phase);
			for(int i=1;i<=1;i++)
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

	@When("^launch TestPlanning to create a cycle and add phase to cycle$")
	public void launch_TestPlanning_to_create_a_cycle_and_add_phase_to_cycle() throws Throwable {
	try
	   {
		  bp.waitForElement();
		  actual[30]=rp.clickOnTestPlanning();
		  
		  tp=new TestPlanningPage(driver);
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 13, 13);
			String build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
			String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
			String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
			actual[31]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			bp.waitForElement();
			actual[32]=tp.CreateCycle(cycle, build, environ, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
			String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
			String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
			bp.waitForElement();
			actual[33]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			bp.waitForElement();
			actual[34]=tp.saveTestCycle();
			bp.waitForElement();
			
	    	String[] cycle1=new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 13, 13);
			actual[35]=tp.navigateToCycle(cycle1);
			
			bp.waitForElement();
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 13, 12);
			actual[36]=tp.addPhaseToCycle(phase);
			bp.waitForElement();
			String bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
			bp.waitForElement();
			actual[37]=tp.bulkAssignment(bulk_Type);
			actual[38]=tp.goBackToCycle();
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

	@When("^launch TestExecution to execute testcases$")
	public void launch_TestExecution_to_execute_testcases() throws Throwable {
	try
	   {
		     /*pp=new ProjectPage(driver);//
			 bp=new BasePage();
			 rp=new ReleasePage(driver);
			 dt=new DefectTracking(driver);
			 tr=new TestRepositoryPage(driver);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			 pp.selectProject(projectName);
		     pp.selectRelease(releaseName);// */
		   
		   bp.waitForElement();
		   actual[39]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",13,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",13,12 );
		    
		    bp.waitForElement();
		    tp=new TestPlanningPage(driver);
			actual[40]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[41]=exep.executeStatus(tcNo1[0], statusType1);
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

	@When("^click on D button and click on create defect button and enter the projectName and issueType$")
	public void click_on_D_button_and_click_on_create_defect_button_and_enter_the_projectName_and_issueType() throws Throwable {
		try
		   {
			   int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1,16 );
			   String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
			   String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
			   actual[42]=exep.clickOnDefectButton(testcase1);
			   actual[43]=dt.createDefect(project, issuetype);
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

	@When("^enter the minimum required fields to create a defect$")
	public void enter_the_minimum_required_fields_to_create_a_defect() throws Throwable {
	try
	   {
	    actual[44]=dt.fileNewDefect(summary, fields[0],fields[1],desc,fields[2],priority,fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9]);
	    actual[45]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with minimum required fields in TestExecution$")
	public void should_be_able_to_create_a_defect_with_minimum_required_fields_in_TestExecution() throws Throwable {
	try
	  {
		 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		 actual[46]=dt.validateDefect(project,issuetype);
		 bp.waitForElement();
		 actual[47]=dt.updateDefect();
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

	@When("^search a defect and click on Subtask icon$")
	public void search_a_defect_and_click_on_Subtask_icon() throws Throwable {
	try
	   {
		   int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1,19 );
		   String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3 ,9 );
		   String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,30 );
		   bp.waitForElement();
		   exep.cancelDefect.click();//
		   bp.waitForElement();
		   actual[48]=exep.clickOnDefectButton(testcase1);
		   actual[49]=exep.defectSearch(selectSearch,defectID);
		   bp.waitForElement();
		   actual[50]=exep.clickOnSubtask();
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

	@When("^enter the issuetype and minimum required fields$")
	public void enter_the_issuetype_and_minimum_required_fields() throws Throwable {
		try
		  {
			 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,31);
			 actual[51]=dt.createDefectSubtask(issuetype);
			 actual[52]=dt.fileNewDefect(summary, fields[0],fields[1],desc,fields[2],priority,fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9]);
			 actual[53]=dt.saveDefect();
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

	@Then("^Should be able to create defect Subtask with minimim required fields$")
	public void should_be_able_to_create_defect_Subtask_with_minimim_required_fields() throws Throwable {
	try
	  {
		 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,31);
		 actual[54]=dt.validateDefect(project,issuetype);
		 bp.waitForElement();
		 actual[55]=dt.updateDefect();
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

	@When("^Click on D button to create the defect$")
	public void click_on_D_button_to_create_the_defect() throws Throwable {
	try
	   {
		   int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1,19 );
		   bp.waitForElement();
		   exep.cancelDefect.click();
		   bp.waitForElement();
		   actual[56]=exep.clickOnDefectButton(testcase1);
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

	@When("^click on create defect and enter the mandatory and optional fields$")
	public void click_on_create_defect_and_enter_the_mandatory_and_optional_fields() throws Throwable {
	try
	   {
		   String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		   actual[57]=dt.createDefect(project, issuetype);
		   actual[58]=dt.fileNewDefect(summary, components,fields[0],desc, fixVersion, priority, assignee, labels,fields[1],env,fields[2],fields[3],fields[4]);
		   actual[59]=dt.saveDefect();      
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

	@Then("^Should be create a defect with mandatory and optional fields$")
	public void should_be_create_a_defect_with_mandatory_and_optional_fields() throws Throwable {
	try
	  {
		 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		 actual[60]=dt.validateDefect(project,issuetype);
		 bp.waitForElement();
		 actual[61]=dt.updateDefect();
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

	@When("^search a defect in test execution$")
	public void search_a_defect_in_test_execution() throws Throwable {
	try
	   {
		   String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3 ,9 );
		   String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,30 );
		   actual[62]=exep.defectSearch(selectSearch,defectID);
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

	@When("^click on Create Subtask icon and enter the issueType$")
	public void click_on_Create_Subtask_icon_and_enter_the_issueType() throws Throwable {
	try
	  {
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,31);
		 actual[63]=exep.clickOnSubtask();
		 actual[64]=dt.createDefectSubtask(issuetype);
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

	@When("^enter the mandatory and optional fields to create a defect$")
	public void enter_the_mandatory_and_optional_fields_to_create_a_defect() throws Throwable {
	try
	  {
		 actual[65]=dt.fileNewDefect(summary, components,fields[0],desc, fixVersion, priority, assignee, labels,fields[1],fields[2],fields[3],fields[4],fields[5]);
		 actual[66]=dt.saveDefect();
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

	@Then("^Should be able to create a defect subtask with mandatory and optional fields$")
	public void should_be_able_to_create_a_defect_subtask_with_mandatory_and_optional_fields() throws Throwable {
	try
	  {
		 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,31);
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[67]=dt.validateDefect(project,issuetype);
		 bp.waitForElement();
		 actual[68]=dt.updateDefect();
		 bp.waitForElement();
		 exep.cancelDefect.click();
		 bp.waitForElement();
		 actual[69]=tp.doubleClickOnCycle(releaseName);
		 bp.waitForElement();
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
