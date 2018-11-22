package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
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

public class Defect_Tracking_View_284 extends LaunchBrowser{
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	ExecutionPage ep;
	LaunchBrowser lb;
	LoginPage lp;
	DefectTracking dt;
	TestRepositoryPage tr;
	ExternalJiraPage ejp;
	boolean[] actual=new boolean[19];
	SoftAssert soft=new SoftAssert();
	String fileName="Defect_Tracking_View_284";
	
	@Given("^user is in external Jira Page$")
	public void user_is_in_external_Jira_Page() throws Throwable {
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

	@When("^user sort the values present in selectlist type of customfield$")
	public void user_sort_the_values_present_in_selectlist_type_of_customfield() throws Throwable {
		try
	       {
		   String pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");	 
		   String name=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 22,1); 
		   String customFieldName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 22,2); 
		   String configuration=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 22,3); 
           actual[2]=ejp.jiraAdministration(name);
	       bp.waitForElement();
	       actual[3]=ejp.enterAdministratorAccessPassword(pwd);
		   bp.waitForElement();
	       ejp.customfield.click();
		   bp.waitForElement();
		   actual[4]=ejp.editCustomFieldValue(customFieldName, configuration);
		   bp.waitForElement();
		   ejp.editOptions.click();
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

	@Then("^should be able to sort the values present in selectlist type of customfield$")
	public void should_be_able_to_sort_the_values_present_in_selectlist_type_of_customfield() throws Throwable {
		try
	     {
	     dt=new DefectTracking(driver);	
		 String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
		 ejp.sort_Jira.click();
		 bp.waitForElement();
		 String[] values=new String[12];
	     for(int i=0;i<=values.length-1;i++)
	      {
		  String all_sort=dt.allvalues.get(i).getText();
		  System.out.println(all_sort);
	      }
	     actual[5]=ejp.logOutFromExternal_JIRA();
		 bp.waitForElement();
		 driver.navigate().to(url);
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

	@When("^user login to zephyr as testmanager$")
	public void user_login_to_zephyr_as_testmanager() throws Throwable {
		try
	     {
	     String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[6]=lp.enterUnameAndPassword(name, passWord);
	     bp.waitForElement();
	     actual[7]=pp.selectProject(projectName);
	     actual[8]=pp.selectRelease(releaseName);
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

	@When("^user view the LOVs in selectlist customfield dropdown while creating defect in Defecttrackinng$")
	public void user_view_the_LOVs_in_selectlist_customfield_dropdown_while_creating_defect_in_Defecttrackinng() throws Throwable {
		try
	     {
	     dt=new DefectTracking(driver); 
		 String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
	     String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
	     actual[9]=pp.clickOnDefectTracking();
	     bp.waitForElement();
	     actual[10]=dt.createDefect(project, issuetype);
	     bp.waitForElement();
	     dt.customZE_Single_Select_Field.click();
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

	@Then("^should be able to view dropdown menu options for customfield of type selectlist in Defecttracking$")
	public void should_be_able_to_view_dropdown_menu_options_for_customfield_of_type_selectlist_in_Defecttracking() throws Throwable {
		try
	     {
			String[] values=new String[12];
			for(int i=0;i<=values.length-1;i++)
		     {
			 String all_sort=dt.allOptions.get(i).getText();
			 System.out.println(all_sort);
		     }
			dt.newDefectCancelButton.click();     
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

	@When("^user view the LOVs in selectlist customfield dropdown while creating defect in Testexecution$")
	public void user_view_the_LOVs_in_selectlist_customfield_dropdown_while_creating_defect_in_Testexecution() throws Throwable {
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
		    actual[11]=rp.clickOnTestExecution();
		    bp.waitForElement();
		    actual[12]=ep.verifyExecutionPage();
		    bp.waitForElement();
		    actual[13]=tr.navigateToNode(releaseName, str);
		    bp.waitForElement();
		    actual[14]=ep.selectAndDeselectAllTestCase();
		    bp.waitForElement();
		    actual[15]=ep.changeMultiSelectedStatus(status);
		    bp.waitForElement();	
		    actual[16]=ep.clickOnDefectButton(testcase);
		    bp.waitForElement();
		    actual[17]=ep.createDefect(project, issuetype);
	  	    bp.waitForElement();
	  	    dt.customZE_Single_Select_Field.click();
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

	@Then("^should be able to view dropdown menu options for customfield of type selectlist in Testexecution$")
	public void should_be_able_to_view_dropdown_menu_options_for_customfield_of_type_selectlist_in_Testexecution() throws Throwable {
		try
	     {
			String[] values=new String[12];
			for(int i=0;i<=values.length-1;i++)
		     {
			   
			   if(i!=2)
			   {
				   values[i]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 23,i);   
			   }
			   else
			   {
				   values[i]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 23,i));
			   }
			   //System.out.println("Excel-"+values[i]);

		     }
			for(int i=0;i<=values.length-1;i++)
		     {
				
		     String all_Options=dt.allOptions.get(i).getText();
		     //System.out.println("App-"+all_Options);
		     
		     if(all_Options.equals(values[i]))
		     {
		    	 System.out.println("List of value validated Successfully");
		     }
		     }
			ep.CancelUpdateButton.click();
			bp.waitForElement();
			actual[18]=ep.clickOnCancelDefectWindow();
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
