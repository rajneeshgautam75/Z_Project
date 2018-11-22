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

public class Defect_Tracking_250 extends LaunchBrowser{

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
	String fileName="Defect_Tracking_250";
	
	boolean[] actual=new boolean[109];
	SoftAssert soft=new SoftAssert();
	
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
	@Given("^User is in the External JIra page$")
	public void user_is_in_the_External_JIra_page() throws Throwable {
	try
	{
		 pp=new ProjectPage(driver);
		 rp=new ReleasePage(driver);
		 bp=new BasePage();
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

	@When("^User create a custom field of type URL$")
	public void user_create_a_custom_field_of_type_URL() throws Throwable {
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
//		 actual[7]=ejp.editCustomFieldValue(customFieldName,configuration);
//		 actual[8]=ejp.addFieldToScreen(name);
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

	@When("^User navigate to the defectTracking page$")
	public void user_navigate_to_the_defectTracking_page() throws Throwable {
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

	@When("^create a defect defect with only numbers in custom field of type URL$")
	public void create_a_defect_defect_with_only_numbers_in_custom_field_of_type_URL() throws Throwable {
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

	@Then("^Should be able to create a defect with only numbers in custom field of type URL$")
	public void should_be_able_to_create_a_defect_with_only_numbers_in_custom_field_of_type_URL() throws Throwable {
	try
	  {
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

	@When("^create a defect with UPPERCASE in custom field of type URL$")
	public void create_a_defect_with_UPPERCASE_in_custom_field_of_type_URL() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
			String ze_Url_Field_Uppercase=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,58);
		    actual[15]=dt.createDefect(project, issuetype);
			actual[16]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[17]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],ze_Url_Field_Uppercase,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[18]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with UPPERCASE in custom field of type URL$")
	public void should_be_able_to_create_a_defect_with_UPPERCASE_in_custom_field_of_type_URL() throws Throwable {
	try
	  {
		 actual[19]=dt.validateDefect(project, issuetype);
		 for(int i=0;i<=3;i++)
		 {
		 bp.waitForElement();
		 }
		 actual[20]=dt.updateDefect();
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

	@When("^create a defect with lowercase in custom field of type URL$")
	public void create_a_defect_with_lowercase_in_custom_field_of_type_URL() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
			String ze_Url_Field_Lowercase=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",5,58);
		    actual[21]=dt.createDefect(project, issuetype);
			actual[22]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[23]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],ze_Url_Field_Lowercase,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[24]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with lowercase in custom field of type URL$")
	public void should_be_able_to_create_a_defect_with_lowercase_in_custom_field_of_type_URL() throws Throwable {
	try
	  {
		 actual[25]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[26]=dt.updateDefect();
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

	@When("^create a defect with alphanumeric characters in custom field of type URL$")
	public void create_a_defect_with_alphanumeric_characters_in_custom_field_of_type_URL() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
			String ze_Url_Field_AlphaNumeric=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,58);
		    actual[27]=dt.createDefect(project, issuetype);
			actual[28]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[29]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],ze_Url_Field_AlphaNumeric,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[30]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with alphanumeric characters in custom field of type URL$")
	public void should_be_able_to_create_a_defect_with_alphanumeric_characters_in_custom_field_of_type_URL() throws Throwable {
	try
	  {
		 actual[31]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[32]=dt.updateDefect();
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

	@When("^create a defect with special characters in custom field of type URL$")
	public void create_a_defect_with_special_characters_in_custom_field_of_type_URL() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
			String ze_Url_Field_SpecialChar=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,58);
		    actual[33]=dt.createDefect(project, issuetype);
			actual[34]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[35]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],ze_Url_Field_SpecialChar,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[36]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with special characters in custom field of type URL$")
	public void should_be_able_to_create_a_defect_with_special_characters_in_custom_field_of_type_URL() throws Throwable {
	try
	  {
		 actual[37]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[38]=dt.updateDefect();
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

	@When("^create a defect with international characters in custom field of type URL$")
	public void create_a_defect_with_international_characters_in_custom_field_of_type_URL() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
			String ze_Url_Field_InternationalChar=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",8,58);
		    actual[39]=dt.createDefect(project, issuetype);
			actual[40]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[41]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],ze_Url_Field_InternationalChar,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[42]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with international characters in custom field of type URL$")
	public void should_be_able_to_create_a_defect_with_international_characters_in_custom_field_of_type_URL() throws Throwable {
	try
	  {
		 actual[43]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[44]=dt.updateDefect();
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

	@When("^create a defect with very long atleast five hundred and twelve characters in custom field of type URL$")
	public void create_a_defect_with_very_long_atleast_five_hundred_and_twelve_characters_in_custom_field_of_type_URL() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
			String ze_Url_Field_LongChar=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,58);
		    actual[45]=dt.createDefect(project, issuetype);
			actual[46]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[47]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],ze_Url_Field_LongChar,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[48]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with very long atleast five hundred and twelve characters in custom field$")
	public void should_be_able_to_create_a_defect_with_very_long_atleast_five_hundred_and_twelve_characters_in_custom_field() throws Throwable {
	try
	  {
		 actual[49]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[50]=dt.updateDefect();
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

	@When("^create a defect with supported protocol in custom field of type URL$")
	public void create_a_defect_with_supported_protocol_in_custom_field_of_type_URL() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
			String ze_Url_Field_LongChar=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",9,58);
		    actual[51]=dt.createDefect(project, issuetype);
			actual[52]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[53]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],ze_Url_Field_LongChar,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[54]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with supported protocol in custom field of type URL  of type URL$")
	public void should_be_able_to_create_a_defect_with_supported_protocol_in_custom_field_of_type_URL_of_type_URL() throws Throwable {
	try
	  {
		 actual[55]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[56]=dt.updateDefect();
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

	@When("^User navigate to the Test Execution to execute testcase$")
	public void user_navigate_to_the_Test_Execution_to_execute_testcase() throws Throwable {
	try
	   {
//	    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
//	    tr=new TestRepositoryPage(driver);
//		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,12);
//		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
//		bp.waitForElement();
//		actual[10]=rp.clickOnTestRep();
//		bp.waitForElement();
//		actual[11]=tr.clickOnRelease(releaseName);
//		bp.waitForElement();
//		actual[12]=tr.addNode(p_Name1,p_Desc1);  
//		String[] phase=new String[1];
//		phase[0]=p_Name1;
//		bp.waitForElement();
//		actual[13]=tr.navigateToNode(releaseName, phase);
//		for(int i=1;i<=2;i++)
//		{
//		tr.addTestCase();
//		}
//	
//	  bp.waitForElement();
//	  actual[14]=rp.clickOnTestPlanning();
//	  
//	    tp=new TestPlanningPage(driver);
//		String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,13);
//		String build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
//		String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
//		String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
//		actual[15]=tp.clickOnAddTestCycleSymbol();
//		bp.waitForElement();
//		actual[16]=tp.CreateCycle(cycle, build, environ, hide);
//		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
//		String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
//		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
//		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
//		String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
//		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
//		actual[17]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
//		bp.waitForElement();
//		actual[18]=tp.saveTestCycle();
//		bp.waitForElement();
//		
//    	String[] cycle1=new String[1];
//		cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 16, 13);
//		actual[19]=tp.navigateToCycle(cycle1);
//		
//		bp.waitForElement();
//		actual[20]=tp.addPhaseToCycle(phase[0]);
//		bp.waitForElement();
//		String bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
//		bp.waitForElement();
//		actual[21]=tp.bulkAssignment(bulk_Type);
//		actual[22]=tp.goBackToCycle();
		
		   bp.waitForElement();
		   actual[57]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,12 );
		    
		    bp.waitForElement();
			actual[58]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[59]=exep.executeStatus(tcNo1[0], statusType1);
		    actual[60]=exep.clickOnDefectButton(tcNo1[0]);
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

	@When("^create a defect defect with only numbers in custom field of type URL in TestExecution$")
	public void create_a_defect_defect_with_only_numbers_in_custom_field_of_type_URL_in_TestExecution() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
			String ze_Url_Field_Number=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,58);
		    actual[61]=dt.createDefect(project, issuetype);
			actual[62]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[63]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],ze_Url_Field_Number,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[64]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with only numbers in custom field of type URL in TestExecution$")
	public void should_be_able_to_create_a_defect_with_only_numbers_in_custom_field_of_type_URL_in_TestExecution() throws Throwable {
	try
	  {
		 actual[65]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[66]=dt.updateDefect();
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

	@When("^create a defect with UPPERCASE in custom field of type URL in TestExecution$")
	public void create_a_defect_with_UPPERCASE_in_custom_field_of_type_URL_in_TestExecution() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
			String ze_Url_Field_Uppercase=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,58);
		    actual[67]=dt.createDefect(project, issuetype);
			actual[68]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[69]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],ze_Url_Field_Uppercase,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[70]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with UPPERCASE in custom field of type URL in TestExecution$")
	public void should_be_able_to_create_a_defect_with_UPPERCASE_in_custom_field_of_type_URL_in_TestExecution() throws Throwable {
	try
	  {
		 actual[71]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[72]=dt.updateDefect();
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

	@When("^create a defect with lowercase in custom field of type URL in TestExecution$")
	public void create_a_defect_with_lowercase_in_custom_field_of_type_URL_in_TestExecution() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
			String ze_Url_Field_Lowercase=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",5,58);
		    actual[73]=dt.createDefect(project, issuetype);
			actual[74]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[75]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],ze_Url_Field_Lowercase,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[76]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with lowercase in custom field of type URL in TestExecution$")
	public void should_be_able_to_create_a_defect_with_lowercase_in_custom_field_of_type_URL_in_TestExecution() throws Throwable {
	try
	  {
		 actual[77]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[78]=dt.updateDefect();
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

	@When("^create a defect with alphanumeric characters in custom field of type URL in TestExecution$")
	public void create_a_defect_with_alphanumeric_characters_in_custom_field_of_type_URL_in_TestExecution() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
			String ze_Url_Field_AlphaNumeric=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,58);
		    actual[79]=dt.createDefect(project, issuetype);
			actual[80]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[81]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],ze_Url_Field_AlphaNumeric,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[82]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with alphanumeric characters in custom field of type URL in TestExecution$")
	public void should_be_able_to_create_a_defect_with_alphanumeric_characters_in_custom_field_of_type_URL_in_TestExecution() throws Throwable {
	try
	  {
		 actual[83]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[84]=dt.updateDefect();
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

	@When("^create a defect with special characters in custom field of type URL in TestExecution$")
	public void create_a_defect_with_special_characters_in_custom_field_of_type_URL_in_TestExecution() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
			String ze_Url_Field_SpecialChar=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,58);
		    actual[85]=dt.createDefect(project, issuetype);
			actual[86]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[87]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],ze_Url_Field_SpecialChar,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[88]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with special characters in custom field of type URL in TestExecution$")
	public void should_be_able_to_create_a_defect_with_special_characters_in_custom_field_of_type_URL_in_TestExecution() throws Throwable {
	try
	  {
		 actual[89]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[90]=dt.updateDefect();
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

	@When("^create a defect with international characters in custom field of type URL in TestExecution$")
	public void create_a_defect_with_international_characters_in_custom_field_of_type_URL_in_TestExecution() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
			String ze_Url_Field_InternationalChar=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",8,58);
		    actual[91]=dt.createDefect(project, issuetype);
			actual[92]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[93]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],ze_Url_Field_InternationalChar,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[94]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with international characters in custom field of type URL in TestExecution$")
	public void should_be_able_to_create_a_defect_with_international_characters_in_custom_field_of_type_URL_in_TestExecution() throws Throwable {
	try
	  {
		 actual[95]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[96]=dt.updateDefect();
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

	@When("^create a defect with very long atleast five hundred and twelve characters in custom field of type URL in TestExecution$")
	public void create_a_defect_with_very_long_atleast_five_hundred_and_twelve_characters_in_custom_field_of_type_URL_in_TestExecution() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
			String ze_Url_Field_LongChar=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,58);
		    actual[97]=dt.createDefect(project, issuetype);
			actual[98]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[99]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],ze_Url_Field_LongChar,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[100]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with very long atleast five hundred and twelve characters in custom field in TestExecution$")
	public void should_be_able_to_create_a_defect_with_very_long_atleast_five_hundred_and_twelve_characters_in_custom_field_in_TestExecution() throws Throwable {
	try
	  {
		 actual[101]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[102]=dt.updateDefect();
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

	@When("^create a defect with supported protocol in custom field of type URL in TestExecution$")
	public void create_a_defect_with_supported_protocol_in_custom_field_of_type_URL_in_TestExecution() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
			String ze_Url_Field_LongChar=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",9,58);
		    actual[103]=dt.createDefect(project, issuetype);
			actual[104]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[105]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],ze_Url_Field_LongChar,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[106]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with supported protocol in custom field of type URL  of type URL in TestExecution$")
	public void should_be_able_to_create_a_defect_with_supported_protocol_in_custom_field_of_type_URL_of_type_URL_in_TestExecution() throws Throwable {
	try
	  {
		 actual[107]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[108]=dt.updateDefect();
		 
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
