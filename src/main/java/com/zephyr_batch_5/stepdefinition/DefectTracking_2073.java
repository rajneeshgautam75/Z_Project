package com.zephyr_batch_5.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefectTracking_2073 extends LaunchBrowser{
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	DashBoardPage dp;
	ExecutionPage ep;
	CreateTestCasePage ctc;
	LaunchBrowser lb;
	LoginPage lp;
	ExportPage ex;
	RequirementsPage req;
	DefectTracking dt;
	CreateTestCasePage ct;
	ExternalJiraPage ejp;
	private int beforeDefectsLinked;
	private int afterDefectsLinked;
	public String defectId;
	boolean[] actual=new boolean[58];
	SoftAssert soft=new SoftAssert();
	String fileName="DefectTracking_2073";

@Given("^User is In Administration Page$")
public void user_is_In_Administration_Page() throws Throwable {
	try
    {
    bp=new BasePage();
    rp=new ReleasePage(driver);
    pp=new ProjectPage(driver);
    dt=new DefectTracking(driver);
    ctc=new CreateTestCasePage(driver);
    ep=new ExecutionPage(driver);
    dp=new DashBoardPage(driver);
    lp=new LoginPage(driver);
    tr=new TestRepositoryPage(driver);
    tp=new TestPlanningPage(driver);
    ep=new ExecutionPage(driver); 
    ejp=new ExternalJiraPage(driver);
    req=new RequirementsPage(driver);
    String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
    String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
    actual[0]=pp.clickOnLogout();
    bp.waitForElement();
    actual[1]=lp.enterUnameAndPassword(name, passWord);
    bp.waitForElement();
    actual[2]=pp.launchAdministration();
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

@When("^User Set Dts to Jira$")
public void user_Set_Dts_to_Jira() throws Throwable {
	try
       {
	   String dts=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",2 , 0);	 
	   String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
	   String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
	   String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
	   actual[3]=pp.clickOnDefectTracking();
	   bp.waitForElement();
	   actual[4]=pp.setDTS(dts, url, username, password);
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

@Then("^Should be able to set Dts to jira$")
public void should_be_able_to_set_Dts_to_jira() throws Throwable {
   try
	 {	 
	 actual[5]=pp.validateSetDTS();
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

@When("^User launch project setup$")
public void user_launch_project_setup() throws Throwable {
   try
	 {
	 actual[6]=pp.launchManageprojects();
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


@When("^User map ZE project to jira project$")
public void user_map_ZE_project_to_jira_project() throws Throwable {
	 try
	 {	
	 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
	 String jiraProjectName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
	 actual[7]=pp.selectProjectInProjectSetup(projectName);
  	 bp.waitForElement();
  	 actual[8]=pp.mapJiraProject(jiraProjectName);
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

@Then("^Should be able to map ZE project to jira project$")
public void should_be_able_to_map_ZE_project_to_jira_project() throws Throwable {
  try
	 {	 
	 actual[9]=pp.backToProjectPage();
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

@When("^User launch the dashboard$")
public void user_launch_the_dashboard() throws Throwable {
   try
	 {	
	 actual[10]=dp.clickOnManageDashboards(); 	
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

@Then("^Should be able to launch the dashboard$")
public void should_be_able_to_launch_the_dashboard() throws Throwable {
   try
	 {	 
	 actual[11]=dp.validateDashboards();
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

@When("^User add the dashboard$")
public void user_add_the_dashboard() throws Throwable {
   try
	 {
	 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);	 
	 String desc=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 1);
     String layout=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 2);
     String shareType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 3);	
     String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);	
     actual[12]=dp.clickOnAddDashBoardSymbol();	
	 bp.waitForElement();
	 actual[13]=dp.enterDashBoardDetails(name, desc, layout, shareType);
	 bp.waitForElement();
	 actual[14]=dp.searchDashboard(dashboard);
	 bp.waitForElement();
	 actual[15]=dp.selectDashboard(dashboard);
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

@Then("^Should be able to add dashboard$")
public void should_be_able_to_add_dashboard() throws Throwable {
  try
    {
    String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);	 
    actual[16]=dp.validateDashBoard(dashBoard);
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

@When("^User add the dailypulse gadget$")
public void user_add_the_dailypulse_gadget() throws Throwable {
	 try
       {
       String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
	   String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1"); 
	   String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",5 ,12);
	   String timeFrameValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",8,0);
	   actual[17]=dp.clickOnAddGadgetSymbol();
	   bp.waitForElement();
	   bp.waitForElement();
	   actual[18]=dp.addGadget(gadgetName);
	   bp.waitForElement();
	   bp.waitForElement();
	   actual[19]=dp.checkProject(project);
	   bp.waitForElement();
	   actual[20]=dp.checkRelease(release);
	   bp.waitForElement();
	   actual[21]=dp.enterTimeFrame(timeFrameValue);
	   bp.waitForElement();
	   actual[22]=dp.saveGadget();
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

@Then("^Should be able to add dailypulse gadget$")
public void should_be_able_to_add_dailypulse_gadget() throws Throwable {
  try
    {
    String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",5 ,12);	
    actual[23]=dp.validateGadget(gadgetName);	
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

@When("^User view the defect count$")
public void user_view_the_defect_count() throws Throwable {
   try
	 {	 
	 String DefectsLinked=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",9 , 0);		
	 WebElement ele=driver.findElement(By.xpath(dp.defectStatus1+DefectsLinked+dp.defectStatus2));
	 beforeDefectsLinked=Integer.parseInt(ele.getText());
	 System.out.println("Current defects linked is = "+beforeDefectsLinked);
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

@Then("^Should show proper defect count$")
public void should_show_proper_defect_count() throws Throwable {
   try
	 {
	 actual[24]=pp.backToProjectPage();	
	 bp.waitForElement();
	 driver.navigate().refresh();
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

@When("^User create one more defect in mapped project$")
public void user_create_one_more_defect_in_mapped_project() throws Throwable {
	 try
       {
	   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
	   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 	 
	   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
	   String desc=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 18);
	   String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
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
	   String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);
	   String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17); 
	   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
	   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
	   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
       String components=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 3);
	   String descType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 4);
	   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
	   String fixVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 6);
	   String priority=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 7);
	   String assignee=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 8);
	   String labels=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 9);
	   String sprint=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 10);
	   String env=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 11);
	   String epicLink=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 12);
	   String affectsVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 13);
	   String linkedIssue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 14);
	   int[] defectNo=new int[1];
	   defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
	   int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26); 
	   String cyclename[]=new String[1];
	   cyclename[0]=cycle;
	   String phase1[]=new String[1];
	   phase1[0]=name;
	   String[] str=new String[2];
	   str[0]=cycle;
	   str[1]=phase;
	   bp.waitForElement();
	   actual[25]=pp.selectProject(projectName);
	   bp.waitForElement();
	   actual[26]=pp.selectRelease(releaseName);
	   bp.waitForElement();
	   actual[27]=rp.clickOnTestRep();
	   bp.waitForElement();
	   actual[28]=tr.clickOnRelease(releaseName);
	   bp.waitForElement();
	   actual[29]=tr.addNode(name, desc);
	   bp.waitForElement();
	   actual[30]=tr.doubleClickOnRelease(releaseName);
	   bp.waitForElement();
	   actual[31]=tr.navigateToNode(releaseName,phase1);
	   bp.waitForElement();
	   actual[32]=tr.addTestCase();
	   actual[33]=tr.addTestCase();
	   bp.waitForElement();
	   actual[34]=rp.clickOnTestPlanning();
	   bp.waitForElement();
	   actual[35]=tp.clickOnAddTestCycleSymbol();
	   bp.waitForElement();
	   actual[36]=tp.CreateCycle(cycle, build, environ, hide);
	   bp.waitForElement();
	   actual[37]=tp.enterStartDatAndEndDate(syear, smonth, sdate, eyear, emonth, edate);
	   bp.waitForElement();
	   actual[38]=tp.saveTestCycle();
	   bp.waitForElement();
	   actual[39]=tp.navigateToCycle(cyclename);
	   bp.waitForElement();
	   bp.waitForElement();
	   actual[40]=tp.addPhaseToCycle(name);
	   bp.waitForElement();
	   actual[41]=tp.bulkAssignment(bulk_type_1);
	   bp.waitForElement();
	   actual[42]=tp.goBackToCycle();
	   bp.waitForElement();
	   actual[43]=rp.clickOnTestExecution();
	   bp.waitForElement();
	   actual[44]=tr.navigateToNode(releaseName, str);
	   bp.waitForElement();
	   actual[45]=ep.selectAndDeselectAllTestCase();
	   bp.waitForElement();
	   actual[46]=ep.changeMultiSelectedStatus(status);
	   bp.waitForElement();	
	   actual[47]=ep.clickOnDefectButton(testcase);
	   bp.waitForElement();
	   actual[48]=ep.createDefect(project, issuetype);
	   bp.waitForElement();
	   actual[49]=dt.fileNewDefect(summary_1, components, descType, desc_1, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
	   bp.waitForElement();
	   actual[50]=dt.saveDefect();
	   bp.waitForElement();
	   defectId=ep.retrieveDefectId();
	   bp.waitForElement();
	   actual[51]=dt.updateDefect();
	   bp.waitForElement();
	   ep.cancelDefect.click();
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

@Then("^Should be able to create defect in mapped project$")
public void should_be_able_to_create_defect_in_mapped_project() throws Throwable {
	try
    {
    int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);	  
    actual[52]=ep.validateLinkedDefect(testcase, defectId);
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

@When("^User view defect count after creating defect in mapped project$")
public void user_view_defect_count_after_creating_defect_in_mapped_project() throws Throwable {
   try
	 {	
	 String value=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 7);		 	
	 String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);	
	 actual[53]=dp.clickOnManageDashboards(); 	
	 bp.waitForElement();
	 actual[54]=dp.searchDashboard(dashboard);
	 bp.waitForElement();
	 actual[55]=dp.selectDashboard(dashboard);
	 bp.waitForElement();
	 bp.waitForElement();
	 actual[56]=dp.gadgetOperation(value);
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

@Then("^should show proper defect count after creating defect in mapped Project$")
public void should_show_proper_defect_count_after_creating_defect_in_mapped_Project() throws Throwable {
	try
	 {	 
	 String DefectsLinked=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",9 , 0);		
 	 WebElement ele=driver.findElement(By.xpath(dp.defectStatus1+DefectsLinked+dp.defectStatus2));
 	 afterDefectsLinked=Integer.parseInt(ele.getText());
	 if(afterDefectsLinked==beforeDefectsLinked+1)
	 {
		 System.out.println("Defects Linked count updated successfully");  
     }
	 actual[57]=pp.backToProjectPage();
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
