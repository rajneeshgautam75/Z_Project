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
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_JiraPermission_249 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	DefectTracking dt;
	RequirementsPage req;
	ExternalJiraPage ejp;
	CreateCustomFieldsPage ccfp;
	String fileName="Defect_Tracking_JiraPermission_249";
	
	boolean[] actual=new boolean[31];
	SoftAssert soft=new SoftAssert();
	
	String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",5,0);
	String defectIssueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
	public String defectID;
	@Given("^User is in the External Jira Page$")
	public void user_is_in_the_External_Jira_Page() throws Throwable {
	try
	{
		 pp=new ProjectPage(driver);
		 rp=new ReleasePage(driver);
		 bp=new BasePage();
		 lp=new LoginPage(driver);
		 dt=new DefectTracking(driver);
		 req=new RequirementsPage(driver);
	     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 actual[0]=pp.selectProject(projectName);
		 ejp=new ExternalJiraPage(driver);
		 actual[1]=pp.clickOnLogout(); 
	     String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
	     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
	     driver.navigate().to(jira_Url);
	     actual[2]=bp.waitForElement();
	     actual[3]=ejp.loginToExternalJira(Uname,Pwd);
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

	@When("^User navigate to the user management and create four users$")
	public void user_navigate_to_the_user_management_and_create_four_users() throws Throwable {
	try
	   {
		 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,40);
		 String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		 actual[4]=ejp.launchJiraAdministration(issueType);
		 actual[5]=ejp.enterAdministratorAccessPassword(Pwd);
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
	
	@When("^create the users with the available fields and assign users to jira administrator group$")
	public void create_the_users_with_the_available_fields_and_assign_users_to_jira_administrator_group() throws Throwable {
	try
	   {
		 String email_Id=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,65);
		 String fullName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,66);
		 String email_Id2=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,65);
		 String fullName2=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,66);
		 String email_Id3=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,65);
		 String fullName3=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,66);
		 String email_Id4=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",5,65);
		 String fullName4=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",5,66);
		 String username=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,66);
		 String username2=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,66);
		 String username3=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,66);
		 String username4=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",5,66);
		 String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		 String jiraSoftwareStatus=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,68);
		 ejp.filterUser(username);
		 boolean user1=ejp.validateUsername(username);
		 if(user1==false)
		 {
		 actual[6]=ejp.createJiraUser(email_Id,fullName,username,password,jiraSoftwareStatus);
		 }
		 ejp.filterUser(username2);
		 boolean user2=ejp.validateUsername(username2);
		 if(user2==false)
		 {
		 actual[7]=ejp.createJiraUser(email_Id2,fullName2,username2,password,jiraSoftwareStatus);
		 }
		 ejp.filterUser(username3);
		 boolean user3=ejp.validateUsername(username3);
		 if(user3==false)
		 {
			 actual[8]=ejp.createJiraUser(email_Id3,fullName3,username3,password,jiraSoftwareStatus);
		 }
		 ejp.filterUser(username4);
		 boolean user4=ejp.validateUsername(username4);
		 if(user4==false)
		 {
			 actual[9]=ejp.createJiraUser(email_Id4,fullName4,username4,password,jiraSoftwareStatus);
		 }
		 
//			 ejp.filterUser(username);
//			 ejp.filterUser(username2);
//			 ejp.filterUser(username3);
//			 ejp.filterUser(username4);
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

	@When("^assign the created users to jira administrator group$")
	public void assign_the_created_users_to_jira_administrator_group() throws Throwable {
	try
	   {
		 String actionType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,68);
		 //String username=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",i+1,66);
		for(int i=0;i<=3;i++)
		{
		 String username=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",i+2,66);
		 String jiraUserSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,68);
		 actual[8]=ejp.filterUser(username);
		 ejp.assignUserToJiraAdministratorRole(actionType,jiraUserSearch);
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

	@When("^create a project in external jira using first created user$")
	public void create_a_project_in_external_jira_using_first_created_user() throws Throwable {
	try
	   {
		 String project_Type=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,69);
		 String project_Name=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",5,0);//
		 String leadName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,66);
		 String projectVariable=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,15);
		 ejp.selectExternalJiraProject(projectVariable);
		 actual[10]=ejp.searchExternalJiraProject(project_Name);
		 boolean res=ejp.checkAvailableJiraProject(project_Name);
		 if(res==false)
		 {
		 ejp.createJiraProject(project_Type,project_Name,leadName);
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

	@When("^components and version to the respective project$")
	public void components_and_version_to_the_respective_project() throws Throwable {
	try
	   {
		 String componentName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,19);
		 String componentDesc=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,64);
		 String componentAssignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,64);
		 String versionName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,27);
		 ejp.navigateToVersionsPage();
		 boolean res1=ejp.checkAvailableComponentOrVersion(versionName);
		 if(res1==false)
		 {
		 ejp.createVersion(versionName,componentDesc);
		 }
		 ejp.navigateToComponents();
		 boolean res2=ejp.checkAvailableComponentOrVersion(componentName);
		 if(res2==false)
		 {
		 ejp.createComponent(componentName,componentDesc,componentAssignee);
		 }
		 ejp.logOutFromExternal_JIRA();
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

	@When("^login as manager,set the DTS with first created user and refresh the page$")
	public void login_as_manager_set_the_DTS_with_first_created_user_and_refresh_the_page() throws Throwable {
	try
    {
		 String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     String manager_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String manager_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     driver.navigate().to(zephyr_Url);
	     actual[5]=lp.enterUname(manager_Uname);
	     actual[6]=lp.enterPass(manager_Pass);
	     actual[7]=lp.clickOnLogin();
	     actual[8]=pp.launchAdministration();
	     bp.waitForElement();
	     ccfp=new CreateCustomFieldsPage(driver);
	     String DTS=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 17);  
	     String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
		 String Uname=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,66);  
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		 actual[9]=pp.clickOnDefectTracking();
		 actual[11]=ccfp.editDTS(DTS,jira_Url,Uname,Pwd);
		 for(int i=0;i<=2;i++)
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

	@When("^navigate to the project setup page and create a project$")
	public void navigate_to_the_project_setup_page_and_create_a_project() throws Throwable {
	 try
 	    {
 	 	  actual[1]=pp.launchManageprojects();
 	 	  String project1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_11");
 	 	String description=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100, 100);
 		String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_1");
 		String mapDefectProject=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100);
 		String shareCheckbox=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100);
 		String typeName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 27);
 		
 		String [] startDate=new String [3];
 	 	startDate[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 18));
	 	startDate[1]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 19);
	 	startDate[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 20));
 	 	
 	 	String [] endDate=new String [3];
 	 	endDate[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 21));
	 	endDate[1]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 22);
	 	endDate[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 23));
 	 
 	 	boolean result1=pp.validateProject(project1);
		  
		  actual[2]=bp.waitForElement();
		  if(result1==false)
		   {
		  
		  actual[2]=pp.createProject(project1, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
		  bp.waitForElement();
		   }
 	    }
 	    catch(Exception e)
 	     {
 	      lb=new LaunchBrowser();
 	      e.printStackTrace();
 	      lb.getScreenShot(fileName);
 	      driver.close();
 	      Relogin_TPE rl=new Relogin_TPE();
 	      rl.reLogin();
 	      throw e;
 	    }      
	}

	@When("^map the external jira project to the above created project$")
	public void map_the_external_jira_project_to_the_above_created_project() throws Throwable {
	try
	   {
		 String uppercaseProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_11");
		 String jiraProjectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",5,0);
		 actual[2]=pp.selectProjectInProjectSetup(uppercaseProject);
		 actual[3]=pp.mapJiraProject(jiraProjectName);
		 pp.clickOnLogout();
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

	@When("^as a lead,launch the defect tracking page$")
	public void as_a_lead_launch_the_defect_tracking_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_11");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 String lead_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String lead_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     //driver.navigate().to(zephyr_Url);
	     actual[15]=lp.enterUname(lead_Uname);
	     actual[16]=lp.enterPass(lead_Pass);
	     actual[17]=lp.clickOnLogin();
		 actual[18]=pp.selectProject(projectName);
		 actual[19]=pp.selectRelease(releaseName);
		 actual[20]=rp.clickOnDefectTracking();
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

	@When("^login to the external dts with other user not with the setted dts user$")
	public void login_to_the_external_dts_with_other_user_not_with_the_setted_dts_user() throws Throwable {
	try
	   {
		 String Username=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,64);  
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		 actual[22]=req.dtsLoginDetail(Username,Pwd,Pwd);
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

	@When("^create a defect with all relevant values and assignee field$")
	public void create_a_defect_with_all_relevant_values_and_assignee_field() throws Throwable {
	try
	   {
		 String[] fields=new String[12];
		   for(int i=0;i<=11;i++)
		   {
		   fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
		   }
	     String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
		 String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		 String component=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,27);	
		 String fixversion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,19);	
		    actual[23]=dt.createDefect(project,defectIssueType);
			actual[24]=dt.fileNewDefect(summary,component,fields[0],desc,fixversion,fields[1],fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8]);
		    actual[25]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with other assignee$")
	public void should_be_able_to_create_a_defect_with_other_assignee() throws Throwable {
	try
	  {
		 defectID=dt.retrieveDefectId();
		 actual[26]=dt.validateDefect(project,defectIssueType);
		 bp.waitForElement();
		 actual[27]=dt.updateDefect();
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
	
	@When("^search the created defect to verify the assigned to field$")
	public void search_the_created_defect_to_verify_the_assigned_to_field() throws Throwable {
	try
	   {
		 int[] defectNo1=new int[1];
		 defectNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1,16);
		 actual[28]=dt.searchDefect(defectID);
		 actual[29]=dt.selectSingleOrMultipleDefects(defectNo1);
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

	@Then("^Should be able to validate the assignee$")
	public void should_be_able_to_validate_the_assignee() throws Throwable {
	try
	  {
		String aasignedTo=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,64);
		actual[30]=dt.validateDefectAssignee(aasignedTo);
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
