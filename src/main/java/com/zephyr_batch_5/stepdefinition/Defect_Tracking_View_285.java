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

public class Defect_Tracking_View_285 extends LaunchBrowser{
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	ExecutionPage ep;
	LaunchBrowser lb;
	LoginPage lp;
	DefectTracking dt;
	TestRepositoryPage tr;
	ExternalJiraPage ejp;
	boolean[] actual=new boolean[21];
	SoftAssert soft=new SoftAssert();
	String fileName="Defect_Tracking_View_285";
	
	@Given("^User is in external jira page$")
	public void user_is_in_external_jira_page() throws Throwable {
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

	@When("^User add value into selectlist type of customfield$")
	public void user_add_value_into_selectlist_type_of_customfield() throws Throwable {
		try
	       {
		   String pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");	 
		   String name=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 22,1); 
		   String customFieldName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 22,2); 
		   String configuration=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 22,3); 
		   String optionValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 22,4); 
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
		   actual[5]=ejp.addOptionInCustomField(optionValue);
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

	@Then("^Should be able to add value into selectlist type of customfield$")
	public void should_be_able_to_add_value_into_selectlist_type_of_customfield() throws Throwable {
		try
	     {
	     String optionValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 22,4); 
		 String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");	 
	     actual[6]=ejp.checkAvailableCustomFieldOptions(optionValue);
		 bp.waitForElement();
		 
	     actual[7]=ejp.logOutFromExternal_JIRA();
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

	@When("^User login to Zephyr as testmanager$")
	public void user_login_to_Zephyr_as_testmanager() throws Throwable {
	   try
	     {
	     String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[8]=lp.enterUnameAndPassword(name, passWord);
	     bp.waitForElement();
	     actual[9]=pp.selectProject(projectName);
	     actual[10]=pp.selectRelease(releaseName);
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

	@When("^User view the LOVs in selectlist customfield dropdown while creating defect in defecttrackinng$")
	public void user_view_the_LOVs_in_selectlist_customfield_dropdown_while_creating_defect_in_defecttrackinng() throws Throwable {
		try
	     {
	     dt=new DefectTracking(driver); 
		 String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
	     String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
	     actual[11]=pp.clickOnDefectTracking();
	     bp.waitForElement();
	     actual[12]=dt.createDefect(project, issuetype);
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

	@Then("^Should be able to view dropdown menu options for customfield of type selectlist in defecttracking$")
	public void should_be_able_to_view_dropdown_menu_options_for_customfield_of_type_selectlist_in_defecttracking() throws Throwable {
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

	@When("^User view the LOVs in selectlist customfield dropdown while creating defect in testexecution$")
	public void user_view_the_LOVs_in_selectlist_customfield_dropdown_while_creating_defect_in_testexecution() throws Throwable {
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
		    actual[13]=rp.clickOnTestExecution();
		    bp.waitForElement();
		    actual[14]=ep.verifyExecutionPage();
		    bp.waitForElement();
		    actual[15]=tr.navigateToNode(releaseName, str);
		    bp.waitForElement();
		    actual[16]=ep.selectAndDeselectAllTestCase();
		    bp.waitForElement();
		    actual[17]=ep.changeMultiSelectedStatus(status);
		    bp.waitForElement();	
		    actual[18]=ep.clickOnDefectButton(testcase);
		    bp.waitForElement();
		    actual[19]=ep.createDefect(project, issuetype);
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

	@Then("^Should be able to view dropdown menu options for customfield of type selectlist in testexecution$")
	public void should_be_able_to_view_dropdown_menu_options_for_customfield_of_type_selectlist_in_testexecution() throws Throwable {
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
			actual[20]=ep.clickOnCancelDefectWindow();
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
