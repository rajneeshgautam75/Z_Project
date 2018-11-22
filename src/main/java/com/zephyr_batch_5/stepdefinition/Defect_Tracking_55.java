package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Defect_Tracking_55  extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ReleasePage rp;
	TestRepositoryPage tr;
	BasePage bp;
	ExecutionPage epp;
	DashBoardPage dp;
	DefectTracking dt;
	ExternalJiraPage ejp;
	ProjectPage pp;
	boolean[] actual=new boolean[23];
	SoftAssert soft=new SoftAssert();
	String filename="Defect_Tracking_55";
	

	
	public String defectValue2;
	
@Given("^User in the Home_Page$")
public void user_in_the_Home_Page() throws Throwable {
	try
	{
		pp=new ProjectPage(driver);
		bp=new BasePage();
		rp= new ReleasePage(driver);
		dt=new DefectTracking(driver);
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		actual[0]=pp.selectProject(projectName);
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		String statusType=Excel_Lib.getData(INPUT_PATH_8, "Createdefect", 1, 0);
		String issuetype=Excel_Lib.getData(INPUT_PATH_8, "Createdefect", 1, 1);
		String summary=Excel_Lib.getData(INPUT_PATH_8, "Createdefect", 1, 2);
		String components=Excel_Lib.getData(INPUT_PATH_8, "Createdefect", 100, 100); 
		String descType=Excel_Lib.getData(INPUT_PATH_8, "Createdefect", 100, 100); 
		String desc=Excel_Lib.getData(INPUT_PATH_8, "Createdefect",  1, 3);
		String fixVersion=Excel_Lib.getData(INPUT_PATH_8, "Createdefect",100, 100);
		String priority=Excel_Lib.getData(INPUT_PATH_8, "Createdefect", 100, 100);
		String Assignee=Excel_Lib.getData(INPUT_PATH_8, "Createdefect", 100, 100);
		String labels=Excel_Lib.getData(INPUT_PATH_8, "Createdefect", 100, 100);
		String Sprint=Excel_Lib.getData(INPUT_PATH_8, "Createdefect",100, 100);
		String env=Excel_Lib.getData(INPUT_PATH_8, "Createdefect", 100, 100);
		String EpicLink=Excel_Lib.getData(INPUT_PATH_8, "Createdefect", 100, 100);
		String AffectsVersion=Excel_Lib.getData(INPUT_PATH_8, "Createdefect", 100, 100);
		String linkedIssue=Excel_Lib.getData(INPUT_PATH_8, "Createdefect", 100, 100);
		bp.waitForElement();
		actual[1]=pp.selectRelease(releaseName);
		bp.waitForElement();
		pp.clickOnDefectTracking();
		bp.waitForElement();
		bp.waitForElement();
		dt.createDefect(statusType, issuetype);
		bp.waitForElement();
		bp.waitForElement();
		dt.fileNewDefect(summary, components, descType, desc, fixVersion, priority, Assignee, labels, Sprint, env, EpicLink, AffectsVersion, linkedIssue);
		bp.waitForElement();
		bp.waitForElement();
		dt.saveDefect();
		bp.waitForElement();
		bp.waitForElement();
//		String defectValue=driver.findElement(By.xpath("(//div/div/div[1]/div[1]/h4)[10]")).getText();
//	     System.out.println(defectValue);
//	   String[] defectVal=defectValue.split(": ");
//	   for(int i=0;i<defectVal.length;i++)
//	   {
//	    System.out.println(defectVal[i]);
//	   }
//	  defectValue2=defectVal[1];
	  defectValue2=dt.retrieveDefectId();
	  bp.waitForElement();
	  bp.waitForElement();
	  dt.updateDefect();
	  bp.waitForElement();
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

@When("^user will clicks on TextExecution page and navigated to the selected node$")
public void user_will_clicks_on_TextExecution_page_and_navigated_to_the_selected_node() throws Throwable {
	try
	{
		tr=new TestRepositoryPage(driver);
		String cyclename1[]=new String[3];
		cyclename1[0]=Excel_Lib.getData(INPUT_PATH_8,"TestExec",1,1);
	    cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 0);
		cyclename1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 1, 0);
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		actual[2]=rp.clickOnTestExecution();
		bp.waitForElement(); 
		bp.waitForElement(); 
		bp.waitForElement(); 
		bp.waitForElement();
		bp.waitForElement();
		actual[3]=tr.navigateToNode(releaseName,cyclename1);
		bp.waitForElement();  
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

@When("^user changes the status of the related Testcase$")
public void user_changes_the_status_of_the_related_Testcase() throws Throwable {
	try
	{
		epp=new ExecutionPage(driver);
		int tcNo[]=new int[1];
		tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 4, 0);
	    String statusType=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 2);
	    actual[4]=epp.changeStatusOfTestCases(tcNo, statusType);
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

@Then("^Status should be changed sucessfully$")
public void status_should_be_changed_sucessfully() throws Throwable {
	try
	{
		int tcNo[]=new int[1];
		tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 4, 0);
	    String statusType=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 2);
	    actual[5]=epp.ValidateStatusOfTestCases(tcNo, statusType);
	    bp.waitForElement();
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

@When("^user click on the D button$")
public void user_click_on_the_D_button() throws Throwable {
	try
	{
		int tcno=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 4, 0);
		actual[6]=epp.clickOnDefectButton(tcno);
		bp.waitForElement(); 
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

@When("^user will search for the defect and link that defect$")
public void user_will_search_for_the_defect_and_link_that_defect() throws Throwable {
	try
	{
		
		
		actual[7]=epp.searchDefect(defectValue2);
	    bp.waitForElement();
    	actual[8]=epp.validateSearchedDefect(defectValue2);
	    bp.waitForElement();
		actual[9]=epp.linkDefect();
	    bp.waitForElement();
	    bp.waitForElement(); 
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

@Then("^defect must linked to Execution sucessfully$")
public void defect_must_linked_to_Execution_sucessfully() throws Throwable {
	try
	{
		int tcno=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 4, 0);
		actual[10]=epp.validateLinkedDefect(tcno, defectValue2);
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

@When("^user goes to DefectTracking page$")
public void user_goed_to_DefectTracking_page() throws Throwable {
	try
	{
		actual[11]=pp.clickOnDefectTracking();
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

@When("^user search the Defect and clicks on it$")
public void user_search_the_Defect_and_clicks_on_it() throws Throwable {
	try
	{
		dp=new DashBoardPage(driver);
	
		actual[12]=dt.searchDefect(defectValue2);
		bp.waitForElement();
		actual[13]=dt.validateDefect(defectValue2);
		bp.waitForElement();
		dp.selectDefect.click();
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

@Then("^Jira will open the page$")
public void jira_will_open_the_page() throws Throwable {
	try
	{
		ejp=new ExternalJiraPage(driver);
		int switchtcNo=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 2, 5);
		bp.switchWindowTab(switchtcNo);
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

@When("^user fills the Credentials$")
public void user_fills_the_Credentials() throws Throwable {
	try
	{
		String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
		String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		actual[14]=ejp.loginToExternalJira(username, password);
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

@When("^will moved the linked defect to another project$")
public void will_moved_the_linked_defect_to_another_project() throws Throwable {
	try
	{
		String newProject=Excel_Lib.getData(INPUT_PATH_8,"Jira", 1 , 4);
		actual[15]=ejp.MoveDefectToOtherProject(newProject);
		bp.waitForElement();
		bp.waitForElement();
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

@Then("^defect must move Sucessfully to another project$")
public void defect_must_move_Sucessfully_to_another_project() throws Throwable {
	try
	{
		ejp=new ExternalJiraPage(driver);
		String newProject=Excel_Lib.getData(INPUT_PATH_8,"Jira", 1 , 4);
		actual[16]=ejp.ValidateMoveDefectToOtherProject(newProject);
		bp.waitForElement();
		actual[17]=ejp.logOutFromExternal_JIRA();
		driver.close();
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

@When("^user comes back to Application page$")
public void user_comes_back_to_Application_page() throws Throwable {
	try
	{
		int switchbacktcNo=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 5);
		bp.switchWindowTab(switchbacktcNo);
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

@When("^user will clicks on the textExecution button$")
public void user_will_clicks_on_the_textExecution_button() throws Throwable {
	try
	{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		String cyclename1[]=new String[3];
	    cyclename1[0]=Excel_Lib.getData(INPUT_PATH_8,"TestExec",1,1);
		cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 0);
		cyclename1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 1, 0);
		actual[18]=rp.clickOnTestExecution();
		bp.waitForElement();
		actual[19]=tr.clickOnRelease(releaseName);
		bp.waitForElement();
		actual[20]=tr.navigateToNode(releaseName,cyclename1);
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

@When("^user clicks on the Apply Notification button and selects apply$")
public void user_clicks_on_the_Apply_Notification_button_and_selects_apply() throws Throwable {
	try
	{
		actual[21]=epp.applyNotification();
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

@Then("^user would be able to view new Defect-ID on execution grid$")
public void user_would_be_able_to_view_new_Defect_ID_on_execution_grid() throws Throwable {
	try
	{

		int tcNo=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 4, 0);
		actual[22]=epp.viewTooltip(tcNo);		
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
	   lb.getScreenShot(filename);
		e.printStackTrace();
	   driver.close();
      	Relogin_TPE rl=new Relogin_TPE();
      	rl.reLogin();
      	throw e; 	 
	}  
   
}


	
}