package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
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

public class Defect_Tracking_276 extends LaunchBrowser{
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	ExecutionPage ep;
	LaunchBrowser lb;
	LoginPage lp;
	DefectTracking dt;
	TestRepositoryPage tr;
	ExternalJiraPage ejp;
	CreateCustomFieldsPage ccp;
	boolean[] actual=new boolean[27];
	SoftAssert soft=new SoftAssert();
	String fileName="DefectTracking_276";
	
	@Given("^User Is In external jira page$")
	public void user_Is_In_external_jira_page() throws Throwable {
		try
	       {
		   bp=new BasePage();
		   rp=new ReleasePage(driver);
		   pp=new ProjectPage(driver);
		   ejp=new ExternalJiraPage(driver);
		   lp=new LoginPage(driver);
		   String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
		   String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");	 
		   String jira_url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");	 
           actual[0]=pp.clickOnLogout();
		   bp.waitForElement();
		   driver.navigate().to(jira_url);
		   bp.waitForElement();
		   actual[1]=ejp.loginToExternalJira(username, password);
		   bp.waitForElement();
//		   ejp.closeNotificationMsg();
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

  @When("^User create any type of customfield and associate to the resolve screen$")
  public void user_create_any_type_of_customfield_and_associate_to_the_resolve_screen() throws Throwable {
    	 try
	       {
		   String pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");	 
		   String name=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 22,1); 
		   String fieldType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 26,0); 
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 26,1); 
		   String customName=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 26,2); 
		   String customDescription=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 26,3); 
		   String fieldValue[]=new String[1];
		   fieldValue[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 26,4); 
		   String screen[]=new String[1];
		   screen[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 26,5); 
		   actual[2]=ejp.jiraAdministration(name);
	       bp.waitForElement();
	       actual[3]=ejp.enterAdministratorAccessPassword(pwd);
		   bp.waitForElement();
		   actual[4]=ejp.navigateToCustomfields();
		   boolean res=ejp.checkAvailableCustomFields(customName);
		   if(res==false)
		   {
		   bp.waitForElement();
		   ejp.clickOnAddCustomFieldSymbol();
		   bp.waitForElement();
		   ejp.closeNotificationMsg();
		   bp.waitForElement();
		   actual[5]=ejp.addCustomFields(fieldType, field, customName, customDescription, fieldValue);
		   bp.waitForElement();
		   actual[6]=ejp.closeNotificationMsg();
		   bp.waitForElement();
		   actual[7]=ejp.addFieldToScreen(screen);
		   bp.waitForElement();
		   }
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


	@Then("^Should be able to associate to the resolve screen$")
	public void should_be_able_to_associate_to_the_resolve_screen() throws Throwable {
		 try
	       {
		   ccp=new CreateCustomFieldsPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
		   String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");	 
		   String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
		   String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
		   actual[8]=ejp.logOutFromExternal_JIRA();
		   bp.waitForElement();
		   driver.navigate().to(url);
		   bp.waitForElement();
		   actual[9]=lp.enterUnameAndPassword(name, passWord);
		   bp.waitForElement();
		   actual[10]=pp.selectProject(projectName);
		   actual[11]=pp.selectRelease(releaseName);
		   bp.waitForElement();
		   actual[12]=pp.launchAdministration();
		   bp.waitForElement();
		   actual[13]=pp.launchDefectAdmin();
		   bp.waitForElement();
		   actual[14]=ccp.clearCache();
		   bp.waitForElement();
		   actual[15]=pp.backToProjectPage();
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

	@When("^User create the defect and view the created customfield in defecttracking$")
	public void user_create_the_defect_and_view_the_created_customfield_in_defecttracking() throws Throwable {
		try
	     {
	     dt=new DefectTracking(driver); 
		 String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
	     String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		 String field_1[]=new String[1];
		 field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
	     actual[16]=pp.clickOnDefectTracking();
	     bp.waitForElement();
	     actual[17]=dt.createDefect(project, issuetype);
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

	@Then("^Should be able to create the defect and view the created customfield in defecttracking$")
	public void should_be_able_to_create_the_defect_and_view_the_created_customfield_in_defecttracking() throws Throwable {
		try
	       {
		   String customFieldName=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 26,2); 
		   ejp.verifyPresentCustomFieldInFileNewDefectPage(customFieldName);
	       bp.waitForElement();
	       driver.navigate().refresh();
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

	@When("^User create the defect and view the created customfield in testexecution$")
	public void user_create_the_defect_and_view_the_created_customfield_in_testexecution() throws Throwable {
		 try
		    {	
			ep=new ExecutionPage(driver);
		    tr=new TestRepositoryPage(driver);
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
		    String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);	 
		    String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
	        String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
			String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
			int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);
		    String cyclename[]=new String[1];
		    cyclename[0]=cycle;
		    String phase1[]=new String[1];
		    phase1[0]=name;
		    String[] str=new String[2];
		    str[0]=cycle;
		    str[1]=phase;
		    actual[18]=rp.clickOnTestExecution();
		    bp.waitForElement();
		    actual[19]=ep.verifyExecutionPage();
		    bp.waitForElement();
		    actual[20]=tr.navigateToNode(releaseName, str);
		    bp.waitForElement();
		    actual[21]=ep.selectAndDeselectAllTestCase();
		    bp.waitForElement();
		    actual[22]=ep.changeMultiSelectedStatus(status);
		    bp.waitForElement();	
		    actual[23]=ep.clickOnDefectButton(testcase);
		    bp.waitForElement();
		    actual[24]=ep.createDefect(project, issuetype);
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

	@Then("^Should be able to create the defect and view the created customfield in testexecution$")
	public void should_be_able_to_create_the_defect_and_view_the_created_customfield_in_testexecution() throws Throwable {
		try
	       {
		   String customFieldName=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 26,2); 
	       ejp.verifyPresentCustomFieldInFileNewDefectPage(customFieldName);
	       bp.waitForElement();
	       actual[25]=ep.clickOnCancelFileNewDefectButton();
	       bp.waitForElement();
	       actual[26]=ep.clickOnCancelDefectWindow();
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
