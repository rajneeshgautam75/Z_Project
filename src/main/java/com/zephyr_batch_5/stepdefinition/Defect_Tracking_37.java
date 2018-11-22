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
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_37 extends LaunchBrowser {
	
	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	ExecutionPage exep;
	DefectTracking dt;
	ExternalJiraPage ejp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	ExecutionPage ep;
	boolean[] actual=new boolean[36];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_37";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	
	@Given("^user Logins to Jira$")
	public void user_Logins_to_Jira() throws Throwable {
		try
		{
			 pp=new ProjectPage(driver);
			 rp=new ReleasePage(driver);
			 bp=new BasePage();
			 lp=new LoginPage(driver);
			 dt=new DefectTracking(driver);
			 tr=new TestRepositoryPage(driver);
			 tp=new TestPlanningPage(driver);
			 ep=new ExecutionPage(driver);
			 exep=new ExecutionPage(driver);
			 String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
		     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
			 ejp=new ExternalJiraPage(driver);
			 actual[0]=pp.selectProject(project);
			 pp.clickOnLogout(); 
		     driver.navigate().to(jira_Url);
		     bp.waitForElement();
		     actual[1]=ejp.loginToExternalJira(Uname,Pwd);
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

	@When("^user Goes to administration and clicks on Issues$")
	public void user_Goes_to_administration_and_clicks_on_Issues() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 4, 0);
			String pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
			bp.waitForElement();
			actual[2]=ejp.launchJiraAdministration(name);
			bp.waitForElement();
			actual[3]=ejp.enterAdministratorAccessPassword(pwd);
			bp.waitForElement();
			actual[4]=ejp.navigateToCustomfields();	
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

	@When("^Goes to custom fields,Already added a custom field of type Select List adds new list of values$")
	public void goes_to_custom_fields_Already_added_a_custom_field_of_type_Select_List_adds_new_list_of_values() throws Throwable {
		try
		   {
			 String optionValue=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 6, 5);
			 String customFieldName=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 2, 0);
			 String configuration=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 3, 0);
			 actual[5]=ejp.editCustomFieldValue(customFieldName, configuration);
			 actual[6]=bp.waitForElement();
			 ejp.editOptions.click();
			 bp.waitForElement();
			 boolean res=ejp.checkAvailableCustomFieldOptions(optionValue);
			 if(res==false)
			 {
				ejp.addOptionInCustomField(optionValue);
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

	@Then("^should be able to add new list of values$")
	public void should_be_able_to_add_new_list_of_values() throws Throwable {
		try
	     {
		 String optionValue=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 6, 5);
		 String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");	 
	     actual[7]=ejp.checkAvailableCustomFieldOptions(optionValue);
		 bp.waitForElement();
	     actual[8]=ejp.logOutFromExternal_JIRA();
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

	@When("^user logins to zephyr as Manager credential$")
	public void user_logins_to_zephyr_as_Manager_credential() throws Throwable {
		try
	     {
	     String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
		 actual[9]=lp.enterUnameAndPassword(name, passWord);
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

	@When("^goes to administration$")
	public void goes_to_administration() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[10]=pp.launchAdministration();
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

	@When("^clicks on Defect Admin and clear the cashe timeout$")
	public void clicks_on_Defect_Admin_and_clear_the_cashe_timeout() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[11]=pp.launchDefectAdmin();
			bp.waitForElement();
			actual[12]=pp.clearCache();
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

	@When("^user Launches defect tracking Page,clicks On Create Defect$")
	public void user_Launches_defect_tracking_Page_clicks_On_Create_Defect() throws Throwable {
		try
	     {
	     String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
		 String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);	
		 actual[13]=pp.backToProjectPage();
		 bp.waitForElement();
		 actual[14]=pp.selectProject(project);
		 actual[15]=pp.selectRelease(release);
		 bp.waitForElement();
	 	 actual[16]=pp.clickOnDefectTracking();
	     bp.waitForElement();
	     actual[17]=dt.createDefect(projectType, issueType);
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

	@When("^Tries to view new added LOV of type select List$")
	public void tries_to_view_new_added_LOV_of_type_select_List() throws Throwable {
		try
	     {
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

	@Then("^should be able to see the new set of values$")
	public void should_be_able_to_see_the_new_set_of_values() throws Throwable {
		try
	     {
			String[] values=new String[12];
			for(int i=0;i<=values.length-1;i++)
		     {
			   
			   if(i!=2)
			   {
				   values[i]=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 6, 0);   
			   }
			   else
			   {
				   values[i]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "JiraPage", 6, 1));
			   }
		     }
			for(int i=0;i<=values.length-1;i++)
		     {
				
		     String all_Options=dt.allOptions.get(i).getText();
		     if(all_Options.equals(values[i]))
		     {
		    	 System.out.println("List of value validated Successfully");
		     }
		     else
		     {
		    	 System.out.println("List of New added values are not present");
		     }
		     }
			actual[18]=dt.clickOnCancelFileNewDefectButton();
			
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

	@When("^user Launches Test Execution page,selects testcases and executes with any status and clicks on D button$")
	public void user_Launches_Test_Execution_page_selects_testcases_and_executes_with_any_status_and_clicks_on_D_button() throws Throwable {
		try
		{
			
			bp.waitForElement();
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",18,4);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",18,4);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[19]=rp.clickOnTestExecution();
			actual[20]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[21]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[22]=ep.changeMultiSelectedStatus(status);
			bp.waitForElement();
			actual[23]=ep.clickOnDefectButton(testcase1);
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

	@Then("^defect window should be launched$")
	public void defect_window_should_be_launched() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[24]=ep.validateLinkDefectWindow();
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

	@When("^user clicks on Create Defect in test execution$")
	public void user_clicks_on_Create_Defect_in_test_execution() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			bp.waitForElement();
			actual[25]=dt.createDefect(projectType, issueType);
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

	@When("^User Tries to view New added LOV of type select List$")
	public void user_Tries_to_view_New_added_LOV_of_type_select_List() throws Throwable {
		 try
		    {
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

	@Then("^Should be able to view new added LOV of type select List$")
	public void should_be_able_to_view_new_added_LOV_of_type_select_List() throws Throwable {
		try
	     {
			String[] values=new String[12];
			for(int i=0;i<=values.length-1;i++)
		     {
			   
			   if(i!=2)
			   {
				   values[i]=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 6, 0);   
			   }
			   else
			   {
				   values[i]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "JiraPage", 6, 1));
			   }
			   
		     }
			for(int i=0;i<=values.length-1;i++)
		     {
				
		     String all_Options=dt.allOptions.get(i).getText();
		     
		     
		     if(all_Options.equals(values[i]))
		     {
		    	 System.out.println("List of value validated Successfully");
		     }
		     else
		     {
		    	 System.out.println("New Added List of values are Not Present");
		     }
		     }
			 String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
		     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		     String name=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 4, 0);
			 String pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
			 String optionValue=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 6, 5);
			 String customFieldName=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 2, 0);
			 String configuration=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 3, 0);
			 String zUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
		     String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
			 String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
		     actual[26]=dt.clickOnCancelFileNewDefectButton();
			 bp.waitForElement();
			 actual[27]=ep.clickOnCancelDefectWindow();
			 bp.waitForElement();
			 tp.doubleClickOnCycle(release);
			 actual[0]=pp.selectProject(project);
			 pp.clickOnLogout(); 
		     driver.navigate().to(jira_Url);
		     bp.waitForElement();
		     actual[28]=ejp.loginToExternalJira(Uname,Pwd);
		     bp.waitForElement();
			 actual[29]=ejp.launchJiraAdministration(name);
			 bp.waitForElement();
			 actual[30]=ejp.enterAdministratorAccessPassword(pwd);
			 bp.waitForElement();
			 actual[31]=ejp.navigateToCustomfields();
			 actual[32]=ejp.editCustomFieldValue(customFieldName, configuration);
			 bp.waitForElement();
			 ejp.editOptions.click();
			 bp.waitForElement();
			 boolean res=ejp.checkAvailableCustomFieldOptions(optionValue);
			 if(res==true)
			 {
				 actual[33]=ejp.deleteCustomFieldValue(optionValue);
			 } 	 	 
			 ejp.checkAvailableCustomFieldOptions(optionValue);
			 bp.waitForElement();
			 actual[34]=ejp.logOutFromExternal_JIRA();
			 bp.waitForElement();
			 driver.navigate().to(url);
			 actual[35]=lp.enterUnameAndPassword(zUname, passWord);
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
