package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Create_Projects extends LaunchBrowser{
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Create_Projects";
	
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	
	boolean [] actual =new boolean[3];
	SoftAssert soft=new SoftAssert();
	
	private String project1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
	private String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Isolated_Project_1");
	private String project3=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Isolated_Project_2");
	private String project4=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Restricted_Project_1");
	private String project5=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Restricted_Project_2");
	private String description=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1, 0);
	private String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_1");
	private String mapDefectProject=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1,1);
	
	private String [] startDate=new String [3];
 	{
 	startDate[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Project_Data", 1, 3));
 	startDate[1]=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1, 4);
 	startDate[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Project_Data", 1, 5));
 	}
 	
 	private String [] endDate=new String [3];
 	{
 	endDate[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Project_Data", 1, 6));
 	endDate[1]=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1, 7);
 	endDate[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Project_Data", 1, 8));
 	}
 	
 	private String shareCheckbox=Excel_Lib.getData(INPUT_PATH, "Project_Data", 100, 100);
	
 	@Given("^Login as a Test manager$")
 	public void login_as_a_Test_manager() throws Throwable {
 	 try
 	 {
 		 bp=new BasePage();
	 	 lb.preCond();
	 	 String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"URL");
	 	 lb.getUrl(url);
	 	 lp=new LoginPage(driver);
	 	 pp=new ProjectPage(driver);
	     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Password_1");
	     lp.enterUname(Uname);
	     lp.enterPass(Pass);
	     lp.clickOnLogin();
	     bp.waitForElement();
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

 	@Given("^navigate to Manage Projects page$")
 	public void navigate_to_Manage_Projects_page() throws Throwable {
 		 try
 	    {
 	 	  actual[0]=pp.launchAdministration();
 	 	  bp.waitForElement();
 	 	  actual[1]=pp.launchManageprojects();
 	 	  bp.waitForElement();
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

	

@When("^Create seven normal project$")
public void create_seven_normal_project() throws Throwable {
   

//	@When("^Create One normal project$")
//	public void create_One_normal_project() throws Throwable {
		try
		{
		  boolean result1=pp.validateProject(project1);
		  
		  actual[2]=bp.waitForElement();
		  if(result1==false)
		   {
		  String typeName=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1, 9);
		  actual[2]=pp.createProject(project1, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
		  bp.waitForElement();
		   }
		  
		  String lowerCaseProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_3");
		  boolean result2=pp.validateProject(lowerCaseProject);
		 
		  if(result2==false)
		   {
		  String typeName=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1, 9);
		  actual[2]=pp.createProject(lowerCaseProject, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
		  bp.waitForElement();
		   }
		  String interNationalCaseProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_4");
		  boolean result3=pp.validateProject(interNationalCaseProject);
		  //System.out.println(result + " inside step definition");
		  if(result3==false)
		   {
		  String typeName=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1, 9);
		  actual[2]=pp.createProject(interNationalCaseProject, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
		  bp.waitForElement();
		   }
		  String specialCaseProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_5");
		  boolean result4=pp.validateProject(specialCaseProject);
		 
		  if(result4==false)
		   {
		  String typeName=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1, 9);
		  actual[2]=pp.createProject(specialCaseProject, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
		  bp.waitForElement();
		   }
		  String maxCharCaseProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_6");
		  boolean result5=pp.validateProject(maxCharCaseProject);
		  
		  if(result5==false)
		   {
		  String typeName=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1, 9);
		  actual[2]=pp.createProject(maxCharCaseProject, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
		  bp.waitForElement();
		   }
		  
		  String minCharCaseProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_7");
		  boolean result6=pp.validateProject(minCharCaseProject);
		
		  if(result6==false)
		   {
		  String typeName=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1, 9);
		  actual[2]=pp.createProject(minCharCaseProject, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
		  bp.waitForElement();
		   }
			
		  String upperCaseProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_8");
		  boolean result7=pp.validateProject(upperCaseProject);
		
		  if(result7==false)
		   {
		  String typeName=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1, 9);
		  actual[2]=pp.createProject(upperCaseProject, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
		  bp.waitForElement();
		   }
			
		  String numberCharacter=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_9");
		  boolean result8=pp.validateProject(numberCharacter);
		
		  if(result8==false)
		   {
		  String typeName=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1, 9);
		  actual[2]=pp.createProject(numberCharacter, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
		  bp.waitForElement();
		   }
		 	
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		}   
	}

	@When("^Create two isolated projects$")
	public void create_two_isolated_projects() throws Throwable {
		try
		{
		  String typeName=Excel_Lib.getData(INPUT_PATH, "Project_Data", 2, 9);
		  boolean result=pp.validateProject(project2);
		  if(result==false)
			{
		 
		  pp.createProject(project2, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
		  bp.waitForElement();
			 }
		  boolean result1=pp.validateProject(project3);
		  if(result1==false)
		   {
		  pp.createProject(project3, description, typeName,lead, mapDefectProject, startDate, endDate, shareCheckbox);
		  bp.waitForElement();
		    } 
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		}   
	}

	@When("^Create two restricted projects$")
	public void create_two_restricted_projects() throws Throwable {
		try
		{
		  String typeName=Excel_Lib.getData(INPUT_PATH, "Project_Data", 3, 9);
		  boolean result=pp.validateProject(project4);
		  if(result==false)
		   {
		  pp.createProject(project4, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
		  bp.waitForElement();
		   }
		  boolean result1=pp.validateProject(project5);
		  if(result1==false)
			{
		  pp.createProject(project5, description, typeName,lead, mapDefectProject, startDate, endDate, shareCheckbox);
		  bp.waitForElement();
			}
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		}   
	}

	@Then("^Projects should be created successfully$")
	public void projects_should_be_created_successfully() throws Throwable {
		try
		{
		 System.out.println("All projects created successfully");	
		 
			for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();	
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		}   
	}


}
