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

public class Defect_Tracking_251 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	ExecutionPage exep;
	ExternalJiraPage ejp;
	DefectTracking dt;
	String fileName="Defect_Tracking_251";
	
	boolean[] actual=new boolean[31];
	SoftAssert soft=new SoftAssert();
	public String defectID;
	String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
	String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
	String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
	String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
	 private String[] ze_Multiple_Select_Field=new String[2];
	  {
	   ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	  }
	   private String[] ze_Multi_Version_field=new String[2];
	   {
	   ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   ze_Multi_Version_field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   }
	   private String[] ze_Multi_User_Picker=new String[2];
	   {
	   ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   ze_Multi_User_Picker[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   }
	@Given("^User is in the ExternalJira page$")
	public void user_is_in_the_ExternalJira_page() throws Throwable {
	try
	{
		 pp=new ProjectPage(driver);
		 rp=new ReleasePage(driver);
		 bp=new BasePage();
		 tr=new TestRepositoryPage(driver);
		 tp=new TestPlanningPage(driver);
		 lp=new LoginPage(driver);
		 ejp=new ExternalJiraPage(driver);
		 dt=new DefectTracking(driver);
	     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 actual[0]=pp.selectProject(projectName);
		 
		 pp.clickOnLogout(); 
	     String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
	     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
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

	@When("^User create the custom field of type URL$")
	public void user_create_the_custom_field_of_type_URL() throws Throwable {
	try
	   {
		 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,40);
		 String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		 String fieldType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,55);
		 String field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,56);
		 String customFieldName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,57);
		 String configuration=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",5,52);
		 String customDescription=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,57);
		 String[] name=new String[2];
		 name[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,59);
		 name[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,59);
		 String[] fieldValue=new String[1]; 
		 fieldValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,58);
		 ejp.closeNotificationMsg();
		 actual[2]=ejp.launchJiraAdministration(issueType);
		 actual[3]=ejp.enterAdministratorAccessPassword(Pwd);
		 actual[4]=ejp.navigateToCustomfields();
		 boolean res=ejp.checkAvailableCustomFields(customFieldName);
		 if(res==false)
		 {
		 ejp.clickOnAddCustomFieldSymbol();
		 ejp.addCustomFields(fieldType,field,customFieldName,customDescription,fieldValue);
		 }
		 actual[5]=ejp.logOutFromExternal_JIRA();
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

	@When("^User launch defectTracking$")
	public void user_launch_defectTracking() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     driver.navigate().to(zephyr_Url);
	     lp.enterUname(Uname);
	     lp.enterPass(Pass);
	     lp.clickOnLogin();
		 actual[6]=pp.selectProject(projectName);
		 actual[7]=pp.selectRelease(releaseName);
		 actual[8]=rp.clickOnDefectTracking();
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

	@When("^create a defect with only number in URL field$")
	public void create_a_defect_with_only_number_in_URL_field() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
			String ze_Url_Field_Number=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,58);
		    actual[9]=dt.createDefect(project, issuetype);
			actual[10]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[11]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],ze_Url_Field_Number,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[12]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with number in URL field$")
	public void should_be_able_to_create_a_defect_with_number_in_URL_field() throws Throwable {
	try
	  {
		 defectID=dt.retrieveDefectId();
		 actual[13]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[14]=dt.updateDefect();
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

	@When("^User search a defect in defect tracking and click on edit button$")
	public void user_search_a_defect_in_defect_tracking_and_click_on_edit_button() throws Throwable {
	try
	  {
		 int[] defectNo=new int[1];
		 defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1,16);
		 actual[15]=dt.searchDefect(defectID);
		 actual[16]=dt.selectSingleOrMultipleDefects(defectNo);
		 actual[17]=dt.clickOnEditDefectButton();
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

	@When("^update the custom field URL value$")
	public void update_the_custom_field_URL_value() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
			String ze_Url_Field_Number=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,58);
			actual[18]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],ze_Url_Field_Number,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
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

	@Then("^Should be able to edit a defect and change the value for custom field of type URL$")
	public void should_be_able_to_edit_a_defect_and_change_the_value_for_custom_field_of_type_URL() throws Throwable {
	try
	   {
            actual[19]=dt.validateDefect(project, issuetype);
		    actual[20]=dt.updateEditDefectWindow();
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

	@When("^launch test execution page$")
	public void launch_test_execution_page() throws Throwable {
	try
	   {
		   bp.waitForElement();
		   actual[21]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,12 );
		    
		    bp.waitForElement();
			actual[22]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[23]=exep.executeStatus(tcNo1[0], statusType1);
		    actual[24]=exep.clickOnDefectButton(tcNo1[0]);
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

	@When("^create a defect with minimum required fields and save$")
	public void create_a_defect_with_minimum_required_fields_and_save() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
			actual[25]=dt.createDefect(project, issuetype);
			actual[26]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[27]=dt.saveDefect();
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

	@Then("^Should update the custom field URL for the defect$")
	public void should_update_the_custom_field_URL_for_the_defect() throws Throwable {
	try
	   {
		 String[] fields=new String[11];
         for(int i=0;i<=10;i++)
         {
         	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
         }
	    String ze_Url_Field_Number=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,58);
	    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		actual[28]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],ze_Url_Field_Number,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
	    actual[29]=dt.validateDefect(project, issuetype);
	    bp.waitForElement();
	    actual[30]=dt.updateDefect();
	    exep.clickOnCancelDefectWindow();
	    tp.doubleClickOnCycle(releaseName);
	    
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
