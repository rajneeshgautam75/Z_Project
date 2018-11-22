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

public class Defect_Tracking_36 extends LaunchBrowser {
	
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
	boolean[] actual=new boolean[39];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_36";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^user logins to Jira$")
	public void user_logins_to_Jira() throws Throwable {
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

	@When("^user goes to administration and clicks on Issues$")
	public void user_goes_to_administration_and_clicks_on_Issues() throws Throwable {
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

	@When("^goes to custom fields,Already added a custom field of type Select List adds new list of values$")
	public void goes_to_custom_fields_Already_added_a_custom_field_of_type_Select_List_adds_new_list_of_values() throws Throwable {
		
			try
			   {
				 String optionValue=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 6, 5);
				 String customFieldName=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 2, 0);
				 String configuration=Excel_Lib.getData(INPUT_PATH_7, "JiraPage", 3, 0);
				 actual[5]=ejp.editCustomFieldValue(customFieldName, configuration);
				 bp.waitForElement();
				 ejp.editOptions.click();
				 bp.waitForElement();
				 boolean res=ejp.checkAvailableCustomFieldOptions(optionValue);
				 if(res==false)
				 {
					 actual[6]=ejp.addOptionInCustomField(optionValue);
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

	@Then("^should be able to add$")
	public void should_be_able_to_add() throws Throwable {
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

	@When("^user is in a defect tracking Page,clicks On Create Defect$")
	public void user_is_in_a_defect_tracking_Page_clicks_On_Create_Defect() throws Throwable {
		try
	     {
	     String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[9]=lp.enterUnameAndPassword(name, passWord);
	     bp.waitForElement();
	     actual[10]=pp.selectProject(projectName);
	     actual[11]=pp.selectRelease(releaseName);
	 	 bp.waitForElement();
	 	 actual[12]=pp.clickOnDefectTracking();
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

	@When("^Without  Cache timeout,try to  view new added LOV of type select List$")
	public void without_Cache_timeout_try_to_view_new_added_LOV_of_type_select_List() throws Throwable {
		try
	     {
	     String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
		 String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);	
	     bp.waitForElement();
	     actual[13]=dt.createDefect(projectType, issueType);
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

	@Then("^user needs to relogin to see the new sets of values$")
	public void user_needs_to_relogin_to_see_the_new_sets_of_values() throws Throwable {
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
				   values[i]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "JiraPage", 6, 0));
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
			actual[14]=dt.clickOnCancelFileNewDefectButton();
			
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

	@When("^user Is In a Page of TestRepository$")
	public void user_Is_In_a_Page_of_TestRepository() throws Throwable {
		try
		   {
				
				actual[15]=pp.selectProject(project);
				actual[16]=pp.selectRelease(release);
				bp.waitForElement();
				actual[17]=rp.clickOnTestRep();
				
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

	@When("^creates a phase and adds few TestCases$")
	public void creates_a_phase_and_adds_few_TestCases() throws Throwable {
		try
		{
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 18, 4);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 18, 5);
			String [] navigation=new String [1];
			navigation[0]=name;
		    bp.waitForElement();
			actual[18]=tr.clickOnRelease(release);
			actual[19]=tr.addNode(name, desc);
			bp.waitForElement();
			actual[20]=tr.navigateToNode(release, navigation);
			bp.waitForElement();
			for(int i=0;i<2;i++)
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

	@When("^user launch test planning page to create a cycle and assigns phase to cycle,assigns testcases to anyone$")
	public void user_launch_test_planning_page_to_create_a_cycle_and_assigns_phase_to_cycle_assigns_testcases_to_anyone() throws Throwable {
		
		try
		{
		
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 18, 4);
			String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 3, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 6, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 7, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 9, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 1);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 7, 2));
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 2, 0);
			String [] cycle1 =new String[1];
			cycle1[0]=cycle;
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 18,4);
			String phase_1[]=new String[1];
			phase_1[0]=phase;
			actual[21]=rp.clickOnTestPlanning();
			actual[22]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[23]=tp.CreateCycle(cycle, build, Environment, hide);
			bp.waitForElement();
			actual[24]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[25]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			actual[26]=tp.navigateToCycle(cycle1);
			bp.waitForElement();
			actual[27]=tp.addPhaseToCycle(phase);
			bp.waitForElement();
			actual[28]=tp.bulkAssignment(bulk_type);
			bp.waitForElement();
			actual[29]=tp.goBackToCycle();
		
		
		
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

	@When("^user goes to Test Execution page,selects testcases and executes with any status and clicks on D button$")
	public void user_goes_to_Test_Execution_page_selects_testcases_and_executes_with_any_status_and_clicks_on_D_button() throws Throwable {
		try
		{
			
			bp.waitForElement();
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",18,4);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",18,4);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[30]=rp.clickOnTestExecution();
			actual[31]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[32]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[33]=ep.changeMultiSelectedStatus(status);
			bp.waitForElement();
			actual[34]=ep.clickOnDefectButton(testcase1);
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

	@Then("^window of link defect should be launched$")
	public void window_of_link_defect_should_be_launched() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[35]=ep.validateLinkDefectWindow();
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

	@When("^user clicks on Create Defect and create defect$")
	public void user_clicks_on_Create_Defect_and_create_defect() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			bp.waitForElement();
			actual[36]=dt.createDefect(projectType, issueType);
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

	@When("^user Tries to view new added LOV of type select List$")
	public void user_Tries_to_view_new_added_LOV_of_type_select_List() throws Throwable {
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

	@Then("^Should not be able to view new added LOV of type select List$")
	public void should_not_be_able_to_view_new_added_LOV_of_type_select_List() throws Throwable {
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
				   values[i]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "JiraPage", 6, 0));
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
			actual[37]=dt.clickOnCancelFileNewDefectButton();
			bp.waitForElement();
			actual[38]=ep.clickOnCancelDefectWindow();
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
