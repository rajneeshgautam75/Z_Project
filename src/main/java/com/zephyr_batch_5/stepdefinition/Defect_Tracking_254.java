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

public class Defect_Tracking_254 extends LaunchBrowser{

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
	String fileName="Defect_Tracking_254";
	
	boolean[] actual=new boolean[100];
	SoftAssert soft=new SoftAssert();

	String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
	String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
	String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
	String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
	String ze_Checkbox_Number=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,63);
	String ze_Checkbox_Uppercase=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,63);
	String ze_Checkbox_Lowercase=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,63);
	String ze_Checkbox_SpecialChar=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,63);
	String ze_Checkbox_InternationalChar=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",5,63);
	String ze_Checkbox_AlphaNum=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,63);
	String ze_Checkbox_LongChar=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,63);
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
	
	@Given("^User is the page External Jira$")
	public void user_is_the_page_External_Jira() throws Throwable {
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

	@When("^User Create the customField of type Checkbox$")
	public void user_Create_the_customField_of_type_Checkbox() throws Throwable {
	try
	   {
		 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,40);
		 String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		 String fieldType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,55);
		 String field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,56);
		 String customFieldName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,53);
		 String configuration=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,52);
		 String customDescription=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,53);
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
		 actual[5]=ejp.editCustomFieldValue(customFieldName,configuration);
		 
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

	@When("^create the List of values number,uppercase,lowercase,specialchar,international char and very long characters to the checkbox$")
	public void create_the_List_of_values_number_uppercase_lowercase_specialchar_international_char_and_very_long_characters_to_the_checkbox() throws Throwable {
	try
	   {
		 ejp.editOptions.click();
		 String[] optionValue=new String[7];
		 for(int i=0;i<=optionValue.length-1;i++)
		 {
		 optionValue[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",i+1,63); 
		 boolean res1=ejp.checkAvailableCustomFieldOptions(optionValue[i]);
		 if(res1==false)
		 {
			ejp.addOptionInCustomField(optionValue[i]) ;	
		 }
		 }
		 actual[6]=ejp.logOutFromExternal_JIRA();
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

	@When("^User Launch DefectTracking Page$")
	public void user_Launch_DefectTracking_Page() throws Throwable {
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
		 actual[7]=pp.selectProject(projectName);
		 actual[8]=pp.selectRelease(releaseName);
		 actual[9]=rp.clickOnDefectTracking();
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

	@When("^Create a defect with custom field of type checkbox option contains number$")
	public void create_a_defect_with_custom_field_of_type_checkbox_option_contains_number() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
		    actual[10]=dt.createDefect(project, issuetype);
			actual[11]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[12]=dt.enterDefectCustomFields(fields[0],fields[1],ze_Checkbox_Number,fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[13]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with custom field of type Checkbox option contains number$")
	public void should_be_able_to_create_a_defect_with_custom_field_of_type_Checkbox_option_contains_number() throws Throwable {
	try
	  {
		 actual[14]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[15]=dt.updateDefect();
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

	@When("^Create a defect with custom field of type checkbox option contains Uppercase$")
	public void create_a_defect_with_custom_field_of_type_checkbox_option_contains_Uppercase() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
		    actual[16]=dt.createDefect(project, issuetype);
			actual[17]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[18]=dt.enterDefectCustomFields(fields[0],fields[1],ze_Checkbox_Uppercase,fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[19]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with custom field of type Checkbox option contains Uppercase$")
	public void should_be_able_to_create_a_defect_with_custom_field_of_type_Checkbox_option_contains_Uppercase() throws Throwable {
	try
	  {
		 actual[20]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[21]=dt.updateDefect();
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

	@When("^Create a defect with custom field of type checkbox option contains lowercase$")
	public void create_a_defect_with_custom_field_of_type_checkbox_option_contains_lowercase() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
		    actual[22]=dt.createDefect(project, issuetype);
			actual[23]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[24]=dt.enterDefectCustomFields(fields[0],fields[1],ze_Checkbox_Lowercase,fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
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

	@Then("^Should be able to create a defect with custom field of type Checkbox option contains lowercase$")
	public void should_be_able_to_create_a_defect_with_custom_field_of_type_Checkbox_option_contains_lowercase() throws Throwable {
	try
	  {
		 actual[26]=dt.validateDefect(project, issuetype);
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

	@When("^Create a defect with custom field of type checkbox option contains alphanumeric character$")
	public void create_a_defect_with_custom_field_of_type_checkbox_option_contains_alphanumeric_character() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
		    actual[28]=dt.createDefect(project, issuetype);
			actual[29]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[30]=dt.enterDefectCustomFields(fields[0],fields[1],ze_Checkbox_AlphaNum,fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[31]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with custom field of type Checkbox option contains alphanumeric character$")
	public void should_be_able_to_create_a_defect_with_custom_field_of_type_Checkbox_option_contains_alphanumeric_character() throws Throwable {
	try
	  {
		 actual[32]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[33]=dt.updateDefect();
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

	@When("^Create a defect with custom field of type checkbox option contains special character$")
	public void create_a_defect_with_custom_field_of_type_checkbox_option_contains_special_character() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
		    actual[34]=dt.createDefect(project, issuetype);
			actual[35]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[36]=dt.enterDefectCustomFields(fields[0],fields[1],ze_Checkbox_SpecialChar,fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[37]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with custom field of type Checkbox option contains special character$")
	public void should_be_able_to_create_a_defect_with_custom_field_of_type_Checkbox_option_contains_special_character() throws Throwable {
	try
	  {
		 actual[38]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[39]=dt.updateDefect();
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

	@When("^Create a defect with custom field of type checkbox option contains international character$")
	public void create_a_defect_with_custom_field_of_type_checkbox_option_contains_international_character() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
		    actual[40]=dt.createDefect(project, issuetype);
			actual[41]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[42]=dt.enterDefectCustomFields(fields[0],fields[1],ze_Checkbox_InternationalChar,fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[43]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with custom field of type Checkbox option contains international character$")
	public void should_be_able_to_create_a_defect_with_custom_field_of_type_Checkbox_option_contains_international_character() throws Throwable {
	try
	  {
		 actual[44]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[45]=dt.updateDefect();
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

	@When("^Create a defect with custom field of type checkbox option contains very long character$")
	public void create_a_defect_with_custom_field_of_type_checkbox_option_contains_very_long_character() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
		    actual[46]=dt.createDefect(project, issuetype);
			actual[47]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[48]=dt.enterDefectCustomFields(fields[0],fields[1],ze_Checkbox_LongChar,fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[49]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with custom field of type Checkbox option contains very long character$")
	public void should_be_able_to_create_a_defect_with_custom_field_of_type_Checkbox_option_contains_very_long_character() throws Throwable {
	try
	  {
		 actual[50]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[51]=dt.updateDefect();
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

	@When("^Launch Test Execution page to create Defect$")
	public void launch_Test_Execution_page_to_create_Defect() throws Throwable {
	try
	   {
		   bp.waitForElement();
		   actual[52]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,12 );
		    
		    bp.waitForElement();
			actual[53]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[54]=exep.executeStatus(tcNo1[0], statusType1);
		    actual[55]=exep.clickOnDefectButton(tcNo1[0]);
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

	@When("^Create a defect with custom field of type checkbox option contains number in TestExecution$")
	public void create_a_defect_with_custom_field_of_type_checkbox_option_contains_number_in_TestExecution() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
		    actual[56]=dt.createDefect(project, issuetype);
			actual[57]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[58]=dt.enterDefectCustomFields(fields[0],fields[1],ze_Checkbox_Number,fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[59]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with custom field of type Checkbox option contains number in TestExecution$")
	public void should_be_able_to_create_a_defect_with_custom_field_of_type_Checkbox_option_contains_number_in_TestExecution() throws Throwable {
	try
	  {
		 actual[60]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[61]=dt.updateDefect();
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

	@When("^Create a defect with custom field of type checkbox option contains Uppercase in TestExecution$")
	public void create_a_defect_with_custom_field_of_type_checkbox_option_contains_Uppercase_in_TestExecution() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
		    actual[62]=dt.createDefect(project, issuetype);
			actual[63]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[64]=dt.enterDefectCustomFields(fields[0],fields[1],ze_Checkbox_Uppercase,fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[65]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with custom field of type Checkbox option contains Uppercase in TestExecution$")
	public void should_be_able_to_create_a_defect_with_custom_field_of_type_Checkbox_option_contains_Uppercase_in_TestExecution() throws Throwable {
	try
	  {
		 actual[66]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[67]=dt.updateDefect();
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

	@When("^Create a defect with custom field of type checkbox option contains lowercase in TestExecution$")
	public void create_a_defect_with_custom_field_of_type_checkbox_option_contains_lowercase_in_TestExecution() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
		    actual[68]=dt.createDefect(project, issuetype);
			actual[69]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[70]=dt.enterDefectCustomFields(fields[0],fields[1],ze_Checkbox_Lowercase,fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[71]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with custom field of type Checkbox option contains lowercase in TestExecution$")
	public void should_be_able_to_create_a_defect_with_custom_field_of_type_Checkbox_option_contains_lowercase_in_TestExecution() throws Throwable {
	try
	  {
		 actual[72]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[73]=dt.updateDefect();
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

	@When("^Create a defect with custom field of type checkbox option contains alphanumeric character in TestExecution$")
	public void create_a_defect_with_custom_field_of_type_checkbox_option_contains_alphanumeric_character_in_TestExecution() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
		    actual[74]=dt.createDefect(project, issuetype);
			actual[75]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[76]=dt.enterDefectCustomFields(fields[0],fields[1],ze_Checkbox_AlphaNum,fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[77]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with custom field of type Checkbox option contains alphanumeric character in TestExecution$")
	public void should_be_able_to_create_a_defect_with_custom_field_of_type_Checkbox_option_contains_alphanumeric_character_in_TestExecution() throws Throwable {
	try
	  {
		 actual[78]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[79]=dt.updateDefect();
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

	@When("^Create a defect with custom field of type checkbox option contains special character in TestExecution$")
	public void create_a_defect_with_custom_field_of_type_checkbox_option_contains_special_character_in_TestExecution() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
		    actual[80]=dt.createDefect(project, issuetype);
			actual[81]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[82]=dt.enterDefectCustomFields(fields[0],fields[1],ze_Checkbox_SpecialChar,fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[83]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with custom field of type Checkbox option contains special character in TestExecution$")
	public void should_be_able_to_create_a_defect_with_custom_field_of_type_Checkbox_option_contains_special_character_in_TestExecution() throws Throwable {
	try
	  {
		 actual[84]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[85]=dt.updateDefect();
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

	@When("^Create a defect with custom field of type checkbox option contains international character in TestExecution$")
	public void create_a_defect_with_custom_field_of_type_checkbox_option_contains_international_character_in_TestExecution() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
		    actual[86]=dt.createDefect(project, issuetype);
			actual[87]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[88]=dt.enterDefectCustomFields(fields[0],fields[1],ze_Checkbox_InternationalChar,fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[89]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with custom field of type Checkbox option contains international character in TestExecution$")
	public void should_be_able_to_create_a_defect_with_custom_field_of_type_Checkbox_option_contains_international_character_in_TestExecution() throws Throwable {
	try
	  {
		 actual[90]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[91]=dt.updateDefect();
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

	@When("^Create a defect with custom field of type checkbox option contains very long character in TestExecution$")
	public void create_a_defect_with_custom_field_of_type_checkbox_option_contains_very_long_character_in_TestExecution() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
		    actual[92]=dt.createDefect(project, issuetype);
			actual[93]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[94]=dt.enterDefectCustomFields(fields[0],fields[1],ze_Checkbox_LongChar,fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[95]=dt.saveDefect();
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

	@Then("^Should be able to create a defect with custom field of type Checkbox option contains very long character in TestExecution$")
	public void should_be_able_to_create_a_defect_with_custom_field_of_type_Checkbox_option_contains_very_long_character_in_TestExecution() throws Throwable {
	try
	  {
		 actual[96]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[97]=dt.updateDefect();
		 actual[98]=exep.clickOnCancelDefectWindow();
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
	     actual[99]=tp.doubleClickOnCycle(releaseName);
		    
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
