package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
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

public class Defect_Tracking_283 extends LaunchBrowser{
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	DashBoardPage dp;
	ExecutionPage ep;
	LaunchBrowser lb;
	LoginPage lp;
	DefectTracking dt;
	ExternalJiraPage ejp;
	CreateCustomFieldsPage ccp;
	boolean[] actual=new boolean[286];
	SoftAssert soft=new SoftAssert();
	String fileName="DefectTracking_283";
	
	@Given("^User In Administration Page$")
	public void user_In_Administration_Page() throws Throwable {
		 try
	     {
	     bp=new BasePage();
		 rp=new ReleasePage(driver);
	     lp=new LoginPage(driver);
		 pp=new ProjectPage(driver);
	     String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[0]=pp.clickOnLogout();
		 bp.waitForElement();
		 actual[1]=lp.enterUnameAndPassword(name, passWord);
	     bp.waitForElement();
	     actual[2]=pp.selectProject(projectName);
	     actual[3]=pp.selectRelease(releaseName);
	 	 bp.waitForElement();
	 	 actual[4]=pp.launchAdministration();
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

	@When("^User click on defect admin and set the preferences$")
	public void user_click_on_defect_admin_and_set_the_preferences() throws Throwable {
		try
	     {
		 ccp=new CreateCustomFieldsPage(driver);
	     String linkType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",24,0);	
	     String categoryName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",24,1);	
	     actual[5]=ccp.selectCategory(categoryName);
	     bp.waitForElement();
	 	 actual[6]=ccp.enableCustomFields(linkType);
	 	 bp.waitForElement();
	 	 actual[7]=pp.backToProjectPage();
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

	@When("^User create defect with customfield of type Textfield in Defecttracking$")
	public void user_create_defect_with_customfield_of_type_Textfield_in_Defecttracking() throws Throwable {
		 try
		   {
		   dt=new DefectTracking(driver); 
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",24,2);
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[8]=pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[9]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[10]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[11]=dt.enterDefectCustomFields(field, field, field, field, field_1, field, field_1, field,field,field, field_1, ze_Text_Field);
		   bp.waitForElement();
		   actual[12]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type Textfield in Defecttracking$")
	public void should_be_able_to_create_defect_with_customfield_of_type_Textfield_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[13]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[14]=dt.updateDefect();
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

	@When("^User create defect with customfield of type Textfield in Testexecution$")
	public void user_create_defect_with_customfield_of_type_Textfield_in_Testexecution() throws Throwable {
		  try
		    {	
		    tr=new TestRepositoryPage(driver);
		    tp=new TestPlanningPage(driver);
		    ep=new ExecutionPage(driver); 
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
		    String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);	 
	  	    String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		    String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		    String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		    String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		    String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		    String field_1[]=new String[1];
		    field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
	        String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",24,2);
	        int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);
		    String desc=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 18);
		    String build=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 20);
	  	    String environ=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 21);
		    String hide=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 22);
		    String bulk_type_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 23);
		    String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 0));
		    String smonth=Excel_Lib.getData(INPUT_PATH_6,"TestCycle", 1, 1);
		    String sdate=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 2));
		    String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 3));
		    String emonth=Excel_Lib.getData(INPUT_PATH_6,"TestCycle", 1, 4);
		    String edate=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 5));  
		    int[] defectNo=new int[1];
		    defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
		    String cyclename[]=new String[1];
		    cyclename[0]=cycle;
		    String phase1[]=new String[1];
		    phase1[0]=name;
		    String[] str=new String[2];
		    str[0]=cycle;
		    str[1]=phase;
		    actual[15]=rp.clickOnTestRep();
		    bp.waitForElement();
		    actual[16]=tr.clickOnRelease(releaseName);
		    bp.waitForElement();
		    actual[17]=tr.addNode(name, desc);
		    bp.waitForElement();
		    actual[18]=tr.doubleClickOnRelease(releaseName);
		    bp.waitForElement();
		    actual[19]=tr.navigateToNode(releaseName,phase1);
   	        bp.waitForElement();
		    actual[20]=tr.addTestCase();
		    actual[21]=tr.addTestCase();
		    bp.waitForElement();
		    actual[22]=rp.clickOnTestPlanning();
		    bp.waitForElement();
		    actual[23]=tp.clickOnAddTestCycleSymbol();
		    bp.waitForElement();
		    actual[24]=tp.CreateCycle(cycle, build, environ, hide);
		    bp.waitForElement();
		    actual[25]=tp.enterStartDatAndEndDate(syear, smonth, sdate, eyear, emonth, edate);
		    bp.waitForElement();
		    actual[26]=tp.saveTestCycle();
		    bp.waitForElement();
		    actual[27]=tp.navigateToCycle(cyclename);
		    bp.waitForElement();
		    actual[28]=tp.addPhaseToCycle(name);
		    bp.waitForElement();
		    actual[29]=tp.bulkAssignment(bulk_type_1);
		    bp.waitForElement();
		    actual[30]=tp.goBackToCycle();
		    bp.waitForElement();
		    actual[31]=rp.clickOnTestExecution();
		    bp.waitForElement();
		    actual[32]=ep.verifyExecutionPage();
		    bp.waitForElement();
		    actual[33]=tr.navigateToNode(releaseName, str);
		    bp.waitForElement();
		    actual[34]=ep.selectAndDeselectAllTestCase();
		    bp.waitForElement();
		    actual[35]=ep.changeMultiSelectedStatus(status);
		    bp.waitForElement();	
		    actual[36]=ep.clickOnDefectButton(testcase);
		    bp.waitForElement();
		    actual[37]=ep.createDefect(project, issuetype);
	  	    bp.waitForElement();
	  	    actual[38]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
			actual[39]=dt.enterDefectCustomFields(field, field, field, field, field_1, field, field_1, field,field,field, field_1, ze_Text_Field);
			bp.waitForElement();
		    actual[40]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type Textfield in Testexecution$")
	public void should_be_able_to_create_defect_with_customfield_of_type_Textfield_in_Testexecution() throws Throwable {
		 try
		   {	
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[41]=dt.validateDefect(project, issuetype); 
		   bp.waitForElement();
		   actual[42]=dt.updateDefect();
		   bp.waitForElement();
		   actual[43]=ep.clickOnCancelDefectWindow();
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

	@When("^User create defect with customfield of type Freetext in Defecttracking$")
	public void user_create_defect_with_customfield_of_type_Freetext_in_Defecttracking() throws Throwable {
		 try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",24,3);
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[44]=pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[45]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[46]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[47]=dt.enterDefectCustomFields(zeFreeTextField, field, field, field, field_1, field, field_1, field,field,field, field_1,field);
		   bp.waitForElement();
		   actual[48]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type Freetext in Defecttracking$")
	public void should_be_able_to_create_defect_with_customfield_of_type_Freetext_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[49]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[50]=dt.updateDefect();
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

	@When("^User create defect with customfield of type Freetext in Testexecution$")
	public void user_create_defect_with_customfield_of_type_Freetext_in_Testexecution() throws Throwable {
		 try
		    {	
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
		    String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);	 
	  	    String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		    String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		    String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		    String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		    String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
			String field_1[]=new String[1];
		    field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		    String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",24,3);
		    int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);
		    String cyclename[]=new String[1];
		    cyclename[0]=cycle;
		    String phase1[]=new String[1];
		    phase1[0]=name;
		    String[] str=new String[2];
		    str[0]=cycle;
		    str[1]=phase;
		    actual[51]=rp.clickOnTestExecution();
		    bp.waitForElement();
		    actual[52]=ep.verifyExecutionPage();
		    bp.waitForElement();
		    actual[53]=tr.navigateToNode(releaseName, str);
		    bp.waitForElement();
		    actual[54]=ep.selectAndDeselectAllTestCase();
		    bp.waitForElement();
		    actual[55]=ep.changeMultiSelectedStatus(status);
		    bp.waitForElement();	
		    actual[56]=ep.clickOnDefectButton(testcase);
		    bp.waitForElement();
		    actual[57]=ep.createDefect(project, issuetype);
	  	    bp.waitForElement();
	  	    actual[58]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
			actual[59]= actual[30]=dt.enterDefectCustomFields(zeFreeTextField, field, field, field, field_1, field, field_1, field,field,field, field_1,field);
			bp.waitForElement();
		    actual[60]=dt.saveDefect();
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


   @Then("^Should be able to create defect with customfield of type Freetext in Testexecution$")
   public void should_be_able_to_create_defect_with_customfield_of_type_Freetext_in_Testexecution() throws Throwable {
		try
		   {	
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[61]=dt.validateDefect(project, issuetype); 
		   bp.waitForElement();
		   actual[62]=dt.updateDefect();
		   bp.waitForElement();
		   actual[63]=ep.clickOnCancelDefectWindow();
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

	@When("^User create defect with customfield of type Select List in Defecttracking$")
	public void user_create_defect_with_customfield_of_type_Select_List_in_Defecttracking() throws Throwable {
		 try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",23,0);
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[64]=pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[65]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[66]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[67]=dt.enterDefectCustomFields(field, field, field, field, field_1,ze_Single_Select_Field, field_1, field,field,field, field_1,field);
		   bp.waitForElement();
		   actual[68]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type Select List in Defecttracking$")
	public void should_be_able_to_create_defect_with_customfield_of_type_Select_List_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[69]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[70]=dt.updateDefect();
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

	@When("^User create defect with customfield of type Select List in Testexecution$")
	public void user_create_defect_with_customfield_of_type_Select_List_in_Testexecution() throws Throwable {
         try
		    {	
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
		    String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);	 
	  	    String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		    String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		    String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		    String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		    String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
			String field_1[]=new String[1];
		    field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		    String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",23,0);
		    int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);
		    String cyclename[]=new String[1];
		    cyclename[0]=cycle;
		    String phase1[]=new String[1];
		    phase1[0]=name;
		    String[] str=new String[2];
		    str[0]=cycle;
		    str[1]=phase;
		    actual[71]=rp.clickOnTestExecution();
		    bp.waitForElement();
		    actual[72]=ep.verifyExecutionPage();
		    bp.waitForElement();
		    actual[73]=tr.navigateToNode(releaseName, str);
		    bp.waitForElement();
		    actual[74]=ep.selectAndDeselectAllTestCase();
		    bp.waitForElement();
		    actual[75]=ep.changeMultiSelectedStatus(status);
		    bp.waitForElement();	
		    actual[76]=ep.clickOnDefectButton(testcase);
		    bp.waitForElement();
		    actual[77]=ep.createDefect(project, issuetype);
	  	    bp.waitForElement();
	  	    actual[78]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
			actual[79]=dt.enterDefectCustomFields(field, field, field, field, field_1,ze_Single_Select_Field, field_1, field,field,field, field_1,field);
			bp.waitForElement();
		    actual[80]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type Select List in Testexecution$")
	public void should_be_able_to_create_defect_with_customfield_of_type_Select_List_in_Textexecution() throws Throwable {
		try
		   {	
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[81]=dt.validateDefect(project, issuetype); 
		   bp.waitForElement();
		   actual[82]=dt.updateDefect();
		   bp.waitForElement();
		   actual[83]=ep.clickOnCancelDefectWindow();
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

	@When("^User create defect with customfield of type Date Picker in Defecttracking$")
	public void user_create_defect_with_customfield_of_type_Date_Picker_in_Defecttracking() throws Throwable {
		 try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 0));
		   String smonth=Excel_Lib.getData(INPUT_PATH_6,"TestCycle", 1, 1);
		   String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 2));
		   actual[84]=pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[85]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[86]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[87]=dt.customDatePicker(syear, smonth, sday);
		   bp.waitForElement();
		   actual[88]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type Date Picker in Defecttracking$")
	public void should_be_able_to_create_defect_with_customfield_of_type_Date_Picker_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[89]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[90]=dt.updateDefect();
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

	@When("^User create defect with customfield of type Date Picker in Testexecution$")
	public void user_create_defect_with_customfield_of_type_Date_Picker_in_Textexecution() throws Throwable {
		 try
		    {	
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
		    String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);	 
	  	    String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		    String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		    String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		    String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		    String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
			String field_1[]=new String[1];
		    field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		    int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);
		    String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 3));
		    String smonth=Excel_Lib.getData(INPUT_PATH_6,"TestCycle", 1, 4);
		    String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 5));
		    String cyclename[]=new String[1];
		    cyclename[0]=cycle;
		    String phase1[]=new String[1];
		    phase1[0]=name;
		    String[] str=new String[2];
		    str[0]=cycle;
		    str[1]=phase;
		    actual[91]=rp.clickOnTestExecution();
		    bp.waitForElement();
		    actual[92]=ep.verifyExecutionPage();
		    bp.waitForElement();
		    actual[93]=tr.navigateToNode(releaseName, str);
		    bp.waitForElement();
		    actual[94]=ep.selectAndDeselectAllTestCase();
		    bp.waitForElement();
		    actual[95]=ep.changeMultiSelectedStatus(status);
		    bp.waitForElement();	
		    actual[96]=ep.clickOnDefectButton(testcase);
		    bp.waitForElement();
		    actual[97]=ep.createDefect(project, issuetype);
	  	    bp.waitForElement();
	  	    actual[98]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
			actual[99]=dt.customDatePicker(syear, smonth, sday);
			bp.waitForElement();
		    actual[100]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type Date Picker in Testexecution$")
	public void should_be_able_to_create_defect_with_customfield_of_type_Date_Picker_in_Textexecution() throws Throwable {
		try
		   {	
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[101]=dt.validateDefect(project, issuetype); 
		   bp.waitForElement();
		   actual[102]=dt.updateDefect();
		   bp.waitForElement();
		   actual[103]=ep.clickOnCancelDefectWindow();
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

	@When("^User create defect with customfield of type Number in Defecttracking$")
	public void user_create_defect_with_customfield_of_type_Number_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   String zeNumberField=Excel_Lib.getNumericValue(INPUT_PATH_6,"DefectTracking",20,0);
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[104]=pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[105]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[106]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[107]=dt.enterNumberCustomField(zeNumberField);
		   bp.waitForElement();
		   actual[108]=dt.saveDefect();
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


	@Then("^Should be able to create defect with customfield of type Number in Defecttracking$")
	public void should_be_able_to_create_defect_with_customfield_of_type_Number_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[109]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[110]=dt.updateDefect();
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

	@When("^User create defect with customfield of type Number in Testexecution$")
	public void user_create_defect_with_customfield_of_type_Number_in_Textexecution() throws Throwable {
		 try
		    {	
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
		    String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);	 
	  	    String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		    String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		    String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		    String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		    String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
			String field_1[]=new String[1];
		    field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		    String zeNumberField=Excel_Lib.getNumericValue(INPUT_PATH_6,"DefectTracking",20,0);
		    int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);
		    String cyclename[]=new String[1];
		    cyclename[0]=cycle;
		    String phase1[]=new String[1];
		    phase1[0]=name;
		    String[] str=new String[2];
		    str[0]=cycle;
		    str[1]=phase;
		    actual[111]=rp.clickOnTestExecution();
		    bp.waitForElement();
		    actual[112]=ep.verifyExecutionPage();
		    bp.waitForElement();
		    actual[113]=tr.navigateToNode(releaseName, str);
		    bp.waitForElement();
		    actual[114]=ep.selectAndDeselectAllTestCase();
		    bp.waitForElement();
		    actual[115]=ep.changeMultiSelectedStatus(status);
		    bp.waitForElement();	
		    actual[116]=ep.clickOnDefectButton(testcase);
		    bp.waitForElement();
		    actual[117]=ep.createDefect(project, issuetype);
	  	    bp.waitForElement();
	  	    actual[118]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
			actual[119]=dt.enterNumberCustomField(zeNumberField);
			bp.waitForElement();
		    actual[120]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type Number in Testexecution$")
	public void should_be_able_to_create_defect_with_customfield_of_type_Number_in_Textexecution() throws Throwable {
		try
		   {	
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[121]=dt.validateDefect(project, issuetype); 
		   bp.waitForElement();
		   actual[122]=dt.updateDefect();
		   bp.waitForElement();
		   actual[123]=ep.clickOnCancelDefectWindow();
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

	@When("^User create defect with customfield of type URL in Defecttracking$")
	public void user_create_defect_with_customfield_of_type_URL_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",21,4);
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[124]=pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[125]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[126]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[127]=dt.enterDefectCustomFields(field, field, field, ze_Url_Field, field_1, field, field_1, field,field,field, field_1,field);
		   bp.waitForElement();
		   actual[128]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type URL in Defecttracking$")
	public void should_be_able_to_create_defect_with_customfield_of_type_URL_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[129]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[130]=dt.updateDefect();
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

	@When("^User create defect with customfield of type URL in Testexecution$")
	public void user_create_defect_with_customfield_of_type_URL_in_Textexecution() throws Throwable {
		 try
		    {	
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
		    String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);	 
	  	    String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		    String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		    String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		    String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		    String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
			String field_1[]=new String[1];
		    field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
			String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",21,4);
		    int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);
		    String cyclename[]=new String[1];
		    cyclename[0]=cycle;
		    String phase1[]=new String[1];
		    phase1[0]=name;
		    String[] str=new String[2];
		    str[0]=cycle;
		    str[1]=phase;
		    actual[131]=rp.clickOnTestExecution();
		    bp.waitForElement();
		    actual[132]=ep.verifyExecutionPage();
		    bp.waitForElement();
		    actual[133]=tr.navigateToNode(releaseName, str);
		    bp.waitForElement();
		    actual[134]=ep.selectAndDeselectAllTestCase();
		    bp.waitForElement();
		    actual[135]=ep.changeMultiSelectedStatus(status);
		    bp.waitForElement();	
		    actual[136]=ep.clickOnDefectButton(testcase);
		    bp.waitForElement();
		    actual[137]=ep.createDefect(project, issuetype);
	  	    bp.waitForElement();
	  	    actual[138]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
			actual[139]=dt.enterDefectCustomFields(field, field, field, ze_Url_Field, field_1, field, field_1, field,field,field, field_1,field);
			bp.waitForElement();
		    actual[140]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type URL in Testexecution$")
	public void should_be_able_to_create_defect_with_customfield_of_type_URL_in_Textexecution() throws Throwable {
		try
		   {	
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[141]=dt.validateDefect(project, issuetype); 
		   bp.waitForElement();
		   actual[142]=dt.updateDefect();
		   bp.waitForElement();
		   actual[143]=ep.clickOnCancelDefectWindow();
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

	@When("^User create defect with customfield of type Checkbox in Defecttracking$")
	public void user_create_defect_with_customfield_of_type_Checkbox_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",21,3);
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[144]=pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[145]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[146]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[147]=dt.enterDefectCustomFields(field, field, zeCheckboxField, field, field_1, field, field_1, field,field,field, field_1,field);
		   bp.waitForElement();
		   actual[148]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type Checkbox in Defecttracking$")
	public void should_be_able_to_create_defect_with_customfield_of_type_Checkbox_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[149]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[150]=dt.updateDefect();
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

	@When("^User create defect with customfield of type Checkbox in Testexecution$")
	public void user_create_defect_with_customfield_of_type_Checkbox_in_Textexecution() throws Throwable {
		 try
		    {	
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
		    String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);	 
	  	    String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		    String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		    String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		    String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		    String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
			String field_1[]=new String[1];
		    field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		    String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",21,3);
		    int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);
		    String cyclename[]=new String[1];
		    cyclename[0]=cycle;
		    String phase1[]=new String[1];
		    phase1[0]=name;
		    String[] str=new String[2];
		    str[0]=cycle;
		    str[1]=phase;
		    actual[151]=rp.clickOnTestExecution();
		    bp.waitForElement();
		    actual[152]=ep.verifyExecutionPage();
		    bp.waitForElement();
		    actual[153]=tr.navigateToNode(releaseName, str);
		    bp.waitForElement();
		    actual[154]=ep.selectAndDeselectAllTestCase();
		    bp.waitForElement();
		    actual[155]=ep.changeMultiSelectedStatus(status);
		    bp.waitForElement();	
		    actual[156]=ep.clickOnDefectButton(testcase);
		    bp.waitForElement();
		    actual[157]=ep.createDefect(project, issuetype);
	  	    bp.waitForElement();
	  	    actual[158]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
			actual[159]=dt.enterDefectCustomFields(field, field, zeCheckboxField, field, field_1, field, field_1, field,field,field, field_1,field);
			bp.waitForElement();
		    actual[160]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type Checkbox in Testexecution$")
	public void should_be_able_to_create_defect_with_customfield_of_type_Checkbox_in_Textexecution() throws Throwable {
		try
		   {	
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[161]=dt.validateDefect(project, issuetype); 
		   bp.waitForElement();
		   actual[162]=dt.updateDefect();
		   bp.waitForElement();
		   actual[163]=ep.clickOnCancelDefectWindow();
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

	@When("^User create defect with customfield of type Multi Checkboxes in Defecttracking$")
	public void user_create_defect_with_customfield_of_type_Multi_Checkboxes_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",21,3);
		   String zeCheckboxField_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",24,4);
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[164]=pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[165]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[166]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[167]=dt.enterDefectCustomFields(field, field, zeCheckboxField, field, field_1, field, field_1, field,field,field, field_1,field);
		   actual[168]=dt.enterDefectCustomFields(field, field, zeCheckboxField_1, field, field_1, field, field_1, field,field,field, field_1,field);
		   bp.waitForElement();
		   actual[169]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type Multi Checkboxes in Defecttracking$")
	public void should_be_able_to_create_defect_with_customfield_of_type_Multi_Checkboxes_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[170]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[171]=dt.updateDefect();
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

	@When("^User create defect with customfield of type Multi Checkboxes in Testexecution$")
	public void user_create_defect_with_customfield_of_type_Multi_Checkboxes_in_Textexecution() throws Throwable {
		 try
		    {	
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
		    String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);	 
	  	    String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		    String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		    String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		    String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		    String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
			String field_1[]=new String[1];
		    field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		    String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",21,3);
		    String zeCheckboxField_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",24,4);
		    int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);
		    String cyclename[]=new String[1];
		    cyclename[0]=cycle;
		    String phase1[]=new String[1];
		    phase1[0]=name;
		    String[] str=new String[2];
		    str[0]=cycle;
		    str[1]=phase;
		    actual[172]=rp.clickOnTestExecution();
		    bp.waitForElement();
		    actual[173]=ep.verifyExecutionPage();
		    bp.waitForElement();
		    actual[174]=tr.navigateToNode(releaseName, str);
		    bp.waitForElement();
		    actual[175]=ep.selectAndDeselectAllTestCase();
		    bp.waitForElement();
		    actual[176]=ep.changeMultiSelectedStatus(status);
		    bp.waitForElement();	
		    actual[177]=ep.clickOnDefectButton(testcase);
		    bp.waitForElement();
		    actual[178]=ep.createDefect(project, issuetype);
	  	    bp.waitForElement();
	  	    actual[179]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
			actual[180]=dt.enterDefectCustomFields(field, field, zeCheckboxField, field, field_1, field, field_1, field,field,field, field_1,field);
			actual[181]=dt.enterDefectCustomFields(field, field, zeCheckboxField_1, field, field_1, field, field_1, field,field,field, field_1,field);
			bp.waitForElement();
		    actual[182]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type Multi Checkboxes in Testexecution$")
	public void should_be_able_to_create_defect_with_customfield_of_type_Multi_Checkboxes_in_Textexecution() throws Throwable {
		try
		   {	
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[183]=dt.validateDefect(project, issuetype); 
		   bp.waitForElement();
		   actual[184]=dt.updateDefect();
		   bp.waitForElement();
		   actual[185]=ep.clickOnCancelDefectWindow();
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

	@When("^User create defect with customfield of type MultiSelect in Defecttracking$")
	public void user_create_defect_with_customfield_of_type_MultiSelect_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String ze_Multiple_Select_Field[]=new String[2];
		   ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",20,1);
		   ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",20,2);
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[186]=pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[187]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[188]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[189]=dt.enterDefectCustomFields(field, field, field, field, ze_Multiple_Select_Field, field, field_1, field,field,field, field_1,field);
		   bp.waitForElement();
		   actual[190]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type MultiSelect in Defecttracking$")
	public void should_be_able_to_create_defect_with_customfield_of_type_MultiSelect_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[191]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[192]=dt.updateDefect();
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

	@When("^User create defect with customfield of type MultiSelect in Testexecution$")
	public void user_create_defect_with_customfield_of_type_MultiSelect_in_Textexecution() throws Throwable {
		 try
		    {	
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
		    String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);	 
	  	    String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		    String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		    String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		    String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		    String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
			String field_1[]=new String[1];
		    field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		    String ze_Multiple_Select_Field[]=new String[2];
			ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",20,1);
		    ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",20,2);
		    int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);
		    String cyclename[]=new String[1];
		    cyclename[0]=cycle;
		    String phase1[]=new String[1];
		    phase1[0]=name;
		    String[] str=new String[2];
		    str[0]=cycle;
		    str[1]=phase;
		    actual[193]=rp.clickOnTestExecution();
		    bp.waitForElement();
		    actual[194]=ep.verifyExecutionPage();
		    bp.waitForElement();
		    actual[195]=tr.navigateToNode(releaseName, str);
		    bp.waitForElement();
		    actual[196]=ep.selectAndDeselectAllTestCase();
		    bp.waitForElement();
		    actual[197]=ep.changeMultiSelectedStatus(status);
		    bp.waitForElement();	
		    actual[198]=ep.clickOnDefectButton(testcase);
		    bp.waitForElement();
		    actual[199]=ep.createDefect(project, issuetype);
	  	    bp.waitForElement();
	  	    actual[200]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
			actual[201]=dt.enterDefectCustomFields(field, field, field, field, ze_Multiple_Select_Field, field, field_1, field,field,field, field_1,field);
			bp.waitForElement();
		    actual[202]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type MultiSelect in Testexecution$")
	public void should_be_able_to_create_defect_with_customfield_of_type_MultiSelect_in_Textexecution() throws Throwable {
		try
		   {	
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[203]=dt.validateDefect(project, issuetype); 
		   bp.waitForElement();
		   actual[204]=dt.updateDefect();
		   bp.waitForElement();
		   actual[205]=ep.clickOnCancelDefectWindow();
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

	@When("^User create defect with customfield of type RadioButton in Defecttracking$")
	public void user_create_defect_with_customfield_of_type_RadioButton_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String zeRadioField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",19,1);
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[206]=pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[207]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[208]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[209]=dt.enterDefectCustomFields(field,  zeRadioField, field, field, field_1, field, field_1, field,field,field, field_1,field);
		   bp.waitForElement();
		   actual[210]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type RadioButton in Defecttracking$")
	public void should_be_able_to_create_defect_with_customfield_of_type_RadioButton_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[211]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[212]=dt.updateDefect();
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

	@When("^User create defect with customfield of type RadioButton in Testexecution$")
	public void user_create_defect_with_customfield_of_type_RadioButton_in_Textexecution() throws Throwable {
		 try
		    {	
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
		    String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);	 
	  	    String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		    String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		    String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		    String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		    String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
			String field_1[]=new String[1];
		    field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",19,1);
		    int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);
		    String cyclename[]=new String[1];
		    cyclename[0]=cycle;
		    String phase1[]=new String[1];
		    phase1[0]=name;
		    String[] str=new String[2];
		    str[0]=cycle;
		    str[1]=phase;
		    actual[213]=rp.clickOnTestExecution();
		    bp.waitForElement();
		    actual[214]=ep.verifyExecutionPage();
		    bp.waitForElement();
		    actual[215]=tr.navigateToNode(releaseName, str);
		    bp.waitForElement();
		    actual[216]=ep.selectAndDeselectAllTestCase();
		    bp.waitForElement();
		    actual[217]=ep.changeMultiSelectedStatus(status);
		    bp.waitForElement();	
		    actual[218]=ep.clickOnDefectButton(testcase);
		    bp.waitForElement();
		    actual[219]=ep.createDefect(project, issuetype);
	  	    bp.waitForElement();
	  	    actual[220]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
			actual[221]=dt.enterDefectCustomFields(field,  zeRadioField, field, field, field_1, field, field_1, field,field,field, field_1,field);
			bp.waitForElement();
		    actual[222]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type RadioButton in Testexecution$")
	public void should_be_able_to_create_defect_with_customfield_of_type_RadioButton_in_Textexecution() throws Throwable {
		try
		   {	
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[223]=dt.validateDefect(project, issuetype); 
		   bp.waitForElement();
		   actual[224]=dt.updateDefect();
		   bp.waitForElement();
		   actual[225]=ep.clickOnCancelDefectWindow();
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

	@When("^User create defect with customfield of type User Picker in Defecttracking$")
	public void user_create_defect_with_customfield_of_type_User_Picker_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",1 ,42);
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[226]=pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[227]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[228]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[229]=dt.enterDefectCustomFields(field, field, field, field, field_1, field, field_1, field,ze_User_Picker,field, field_1, field);
		   bp.waitForElement();
		   actual[230]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type User Picker in Defecttracking$")
	public void should_be_able_to_create_defect_with_customfield_of_type_User_Picker_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[231]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[232]=dt.updateDefect();
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

	@When("^User create defect with customfield of type User Picker in Testexecution$")
	public void user_create_defect_with_customfield_of_type_User_Picker_in_Textexecution() throws Throwable {
		 try
		    {	
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
		    String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);	 
	  	    String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		    String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		    String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		    String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		    String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
			String field_1[]=new String[1];
		    field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",1 ,42);
		    int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);
		    String cyclename[]=new String[1];
		    cyclename[0]=cycle;
		    String phase1[]=new String[1];
		    phase1[0]=name;
		    String[] str=new String[2];
		    str[0]=cycle;
		    str[1]=phase;
		    actual[233]=rp.clickOnTestExecution();
		    bp.waitForElement();
		    actual[234]=ep.verifyExecutionPage();
		    bp.waitForElement();
		    actual[235]=tr.navigateToNode(releaseName, str);
		    bp.waitForElement();
		    actual[236]=ep.selectAndDeselectAllTestCase();
		    bp.waitForElement();
		    actual[237]=ep.changeMultiSelectedStatus(status);
		    bp.waitForElement();	
		    actual[238]=ep.clickOnDefectButton(testcase);
		    bp.waitForElement();
		    actual[239]=ep.createDefect(project, issuetype);
	  	    bp.waitForElement();
	  	    actual[240]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
			actual[241]=dt.enterDefectCustomFields(field, field, field, field, field_1, field, field_1, field,ze_User_Picker,field, field_1, field);
			bp.waitForElement();
		    actual[242]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type User Picker in Testexecution$")
	public void should_be_able_to_create_defect_with_customfield_of_type_User_Picker_in_Textexecution() throws Throwable {
		try
		   {	
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[243]=dt.validateDefect(project, issuetype); 
		   bp.waitForElement();
		   actual[244]=dt.updateDefect();
		   bp.waitForElement();
		   actual[245]=ep.clickOnCancelDefectWindow();
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

	@When("^User create defect with customfield of type Multi User Picker in Defecttracking$")
	public void user_create_defect_with_customfield_of_type_Multi_User_Picker_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String ze_Multi_User_Picker[]=new String[2];
		   ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",1,42);
		   ze_Multi_User_Picker[1]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",2,42);
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[246]=pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[247]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[248]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[249]=dt.enterDefectCustomFields(field,field, field, field, field_1, field, ze_Multi_User_Picker, field, field,field, field_1, field);
		   bp.waitForElement();
		   actual[250]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type Multi User Picker in Defecttracking$")
	public void should_be_able_to_create_defect_with_customfield_of_type_Multi_User_Picker_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[251]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[252]=dt.updateDefect();
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

	@When("^User create defect with customfield of type Multi User Picker in Testexecution$")
	public void user_create_defect_with_customfield_of_type_Multi_User_Picker_in_Textexecution() throws Throwable {
		 try
		    {	
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
		    String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);	 
	  	    String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		    String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		    String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		    String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		    String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
			String field_1[]=new String[1];
		    field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		    String ze_Multi_User_Picker[]=new String[2];
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",1,42);
			ze_Multi_User_Picker[1]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",2,42);
		    int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);
		    String cyclename[]=new String[1];
		    cyclename[0]=cycle;
		    String phase1[]=new String[1];
		    phase1[0]=name;
		    String[] str=new String[2];
		    str[0]=cycle;
		    str[1]=phase;
		    actual[253]=rp.clickOnTestExecution();
		    bp.waitForElement();
		    actual[254]=ep.verifyExecutionPage();
		    bp.waitForElement();
		    actual[255]=tr.navigateToNode(releaseName, str);
		    bp.waitForElement();
		    actual[256]=ep.selectAndDeselectAllTestCase();
		    bp.waitForElement();
		    actual[257]=ep.changeMultiSelectedStatus(status);
		    bp.waitForElement();	
		    actual[258]=ep.clickOnDefectButton(testcase);
		    bp.waitForElement();
		    actual[259]=ep.createDefect(project, issuetype);
	  	    bp.waitForElement();
	  	    actual[260]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
			actual[261]=dt.enterDefectCustomFields(field,field, field, field, field_1, field, ze_Multi_User_Picker, field, field,field, field_1, field);
			bp.waitForElement();
		    actual[262]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type Multi User Picker in Testexecution$")
	public void should_be_able_to_create_defect_with_customfield_of_type_Multi_User_Picker_in_Textexecution() throws Throwable {
		try
		   {	
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[263]=dt.validateDefect(project, issuetype); 
		   bp.waitForElement();
		   actual[264]=dt.updateDefect();
		   bp.waitForElement();
		   actual[265]=ep.clickOnCancelDefectWindow();
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

	@When("^User create defect with customfield of type Single Version Picker in Defecttracking$")
	public void user_create_defect_with_customfield_of_type_Single_Version_Picker_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 18,0);
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[266]=pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[267]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[268]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[269]=dt.enterDefectCustomFields(field, field, field, field, field_1, field, field_1, ze_Version_Field, field,field, field_1, field);
		   bp.waitForElement();
		   actual[270]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type Single Version Picker in Defecttracking$")
	public void should_be_able_to_create_defect_with_customfield_of_type_Single_Version_Picker_in_Defecttracking() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[271]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[272]=dt.updateDefect();
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

	@When("^User create defect with customfield of type Single Version Picker in Testexecution$")
	public void user_create_defect_with_customfield_of_type_Single_Version_Picker_in_Textexecution() throws Throwable {
		 try
		    {	
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
		    String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);	 
	  	    String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		    String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		    String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		    String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		    String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
			String field_1[]=new String[1];
		    field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		    String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 18,0);
		    int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);
		    String cyclename[]=new String[1];
		    cyclename[0]=cycle;
		    String phase1[]=new String[1];
		    phase1[0]=name;
		    String[] str=new String[2];
		    str[0]=cycle;
		    str[1]=phase;
		    actual[273]=rp.clickOnTestExecution();
		    bp.waitForElement();
		    actual[274]=ep.verifyExecutionPage();
		    bp.waitForElement();
		    actual[275]=tr.navigateToNode(releaseName, str);
		    bp.waitForElement();
		    actual[276]=ep.selectAndDeselectAllTestCase();
		    bp.waitForElement();
		    actual[277]=ep.changeMultiSelectedStatus(status);
		    bp.waitForElement();	
		    actual[278]=ep.clickOnDefectButton(testcase);
		    bp.waitForElement();
		    actual[279]=ep.createDefect(project, issuetype);
	  	    bp.waitForElement();
	  	    actual[280]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
	  	    actual[281]=dt.enterDefectCustomFields(field, field, field, field, field_1, field, field_1, ze_Version_Field, field,field, field_1, field);
			bp.waitForElement();
		    actual[282]=dt.saveDefect();
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

	@Then("^Should be able to create defect with customfield of type Single Version Picker in Testexecution$")
	public void should_be_able_to_create_defect_with_customfield_of_type_Single_Version_Picker_in_Textexecution() throws Throwable {
		try
		   {	
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[283]=dt.validateDefect(project, issuetype); 
		   bp.waitForElement();
		   actual[284]=dt.updateDefect();
		   bp.waitForElement();
		   actual[285]=ep.clickOnCancelDefectWindow();
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
