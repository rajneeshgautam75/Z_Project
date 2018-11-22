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

public class Defect_Tracking_278 extends LaunchBrowser{

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
	String fileName="Defect_Tracking_278";
	
	boolean[] actual=new boolean[179];
	SoftAssert soft=new SoftAssert();
	 private String[] ze_Multiple_Select_Field=new String[2];
	  {
	   ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,24);
	   ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,24);
	  }
	   private String[] ze_Multi_User_Picker=new String[2];
	   {
	   ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,28);
	   ze_Multi_User_Picker[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,28);
	   }
	   String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,0);
	   String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,2);
	   String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,18);
	   String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
	 String customTextField=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",11,53);
	 String customFreeTextField=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",15,53);
	 String customSingleSelect=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,29);
	 String customDatePicker=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,53);
	 String customNumberField=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",18,54);
	 String customUrlField=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,26);
	 String customCheckbox=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,25);
	 String customMultiSelect=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,24);
	 String customRadioButon=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,23);
	 String customUserPicker=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,28);
	 String customMultiUserPicker=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,28);
	 String customSingleVersionPicker=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,27);
	   String[] fields=new String[11];
	   {
       for(int i=0;i<=10;i++)
       {
       	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
       }
	   }
	   private String[] ze_Multi_Version_field=new String[2];
	   {
	   ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   ze_Multi_Version_field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   }
	 String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
	 String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
	 String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
	 String optionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",9,52);
	@Given("^defect user is in the external jira Page$")
	public void defect_user_is_in_the_external_jira_Page() throws Throwable {
	try
	{
		 pp=new ProjectPage(driver);
		 rp=new ReleasePage(driver);
		 bp=new BasePage();
		 lp=new LoginPage(driver);
		 dt=new DefectTracking(driver);
		 tr=new TestRepositoryPage(driver);
		 tp=new TestPlanningPage(driver);
		 exep=new ExecutionPage(driver);
	     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 actual[0]=pp.selectProject(projectName);
		 ejp=new ExternalJiraPage(driver);
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

	@When("^navigate to the issues page$")
	public void navigate_to_the_issues_page() throws Throwable {
	try
	   {
		 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,40);
		 String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		 actual[2]=ejp.launchJiraAdministration(issueType);
		 actual[3]=bp.waitForElement();
		 actual[4]=ejp.enterAdministratorAccessPassword(Pwd);
		 //actual[4]=ejp.navigateToCustomFieldsConfiguration();
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

	@When("^change custom fields from non mandatory to mandatoty$")
	public void change_custom_fields_from_non_mandatory_to_mandatoty() throws Throwable {
	try
	   {
		 String customTextField=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",11,53);
		 String customFreeTextField=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",15,53);
		 String customSingleSelect=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,53);
		 String customDatePicker=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,53);
		 String customNumberField=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",18,53);
		 String customUrlField=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",17,53);
		 String customCheckbox=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,53);
		 String customMultiSelect=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,53);
		 String customRadioButon=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,53);
		 String customUserPicker=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",14,53);
		 String customMultiUserPicker=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",13,53);
		 String customSingleVersionPicker=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",5,53);
		 actual[5]=ejp.navigateToCustomFieldsConfiguration();
		 actual[6]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customTextField,optionValue);
		 actual[7]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customFreeTextField,optionValue);
		 actual[8]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customSingleSelect,optionValue);
		 actual[9]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customDatePicker,optionValue);
		 actual[10]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customNumberField,optionValue);
		 actual[11]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customUrlField,optionValue);
		 actual[12]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customCheckbox,optionValue);
		 actual[13]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customMultiSelect,optionValue);
		 actual[14]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customRadioButon,optionValue);
		 actual[15]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customUserPicker,optionValue);
		 actual[16]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customMultiUserPicker,optionValue);
		 actual[17]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customSingleVersionPicker,optionValue);
		 actual[18]=ejp.logOutFromExternal_JIRA();
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

	@When("^As the Manager,Launch the administration page$")
	public void as_the_Manager_Launch_the_administration_page() throws Throwable {
	try
    {
		 String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     String manager_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String manager_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     driver.navigate().to(zephyr_Url);
	     actual[19]=lp.enterUname(manager_Uname);
	     actual[20]=lp.enterPass(manager_Pass);
	     actual[21]=lp.clickOnLogin();
	     actual[22]=pp.launchAdministration();
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

	@When("^launch the defect admin to clear the cache$")
	public void launch_the_defect_admin_to_clear_the_cache() throws Throwable {
	try
	   {
		 actual[23]=pp.launchDefectAdmin();
		 actual[24]=pp.clearCache();
		 bp.waitForElement();
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

	@When("^As the Lead,Launch the defect tracking page$")
	public void as_the_Lead_Launch_the_defect_tracking_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 String lead_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String lead_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     //driver.navigate().to(zephyr_Url);
	     actual[25]=lp.enterUname(lead_Uname);
	     actual[26]=lp.enterPass(lead_Pass);
	     actual[27]=lp.clickOnLogin();
		 actual[28]=pp.selectProject(projectName);
		 actual[29]=pp.selectRelease(releaseName);
		 actual[30]=rp.clickOnDefectTracking();
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

	@When("^attempt to create a defect without text field$")
	public void attempt_to_create_a_defect_without_text_field() throws Throwable {
	try
	   {
		    //String customTextField=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
			actual[31]=dt.createDefect(project, issuetype);
			actual[32]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[33]=dt.enterDefectCustomFields(customFreeTextField,customRadioButon,customCheckbox,customUrlField,ze_Multiple_Select_Field,customSingleSelect,ze_Multi_Version_field,customSingleVersionPicker,customUserPicker,fields[0],ze_Multi_User_Picker,fields[1]);
		    actual[34]=dt.customDatePicker(syear, smonth, sday);
		    actual[35]=dt.enterNumberCustomField(customNumberField);    
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

	@Then("^should not be able to create defect for without text field$")
	public void should_not_be_able_to_create_defect_for_without_text_field() throws Throwable {
	try
	   {
		actual[36]=dt.saveDefect();
		 driver.navigate().refresh();
		for(int i=0;i<=1;i++)
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

	@When("^attempt to create a defect without free text field$")
	public void attempt_to_create_a_defect_without_free_text_field() throws Throwable {
	try
	   {
			actual[37]=dt.createDefect(project, issuetype);
			actual[38]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[39]=dt.enterDefectCustomFields(fields[0],customRadioButon,customCheckbox,customUrlField,ze_Multiple_Select_Field,customSingleSelect,ze_Multi_Version_field,customSingleVersionPicker,customUserPicker,fields[1],ze_Multi_User_Picker,customTextField);
		    actual[40]=dt.customDatePicker(syear, smonth, sday);
		    actual[41]=dt.enterNumberCustomField(customNumberField);
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

	@Then("^should not be able to create defect for without free text field$")
	public void should_not_be_able_to_create_defect_for_without_free_text_field() throws Throwable {
	try
	   {
		actual[42]=dt.saveDefect();
		 driver.navigate().refresh();
		 for(int i=0;i<=1;i++)
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

	@When("^attempt to create a defect without single select field$")
	public void attempt_to_create_a_defect_without_single_select_field() throws Throwable {
	try
	   {
			actual[43]=dt.createDefect(project, issuetype);
			actual[44]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[45]=dt.enterDefectCustomFields(customFreeTextField,customRadioButon,customCheckbox,customUrlField,ze_Multiple_Select_Field,fields[0],ze_Multi_Version_field,customSingleVersionPicker,customUserPicker,fields[1],ze_Multi_User_Picker,fields[1]);
		    actual[46]=dt.customDatePicker(syear, smonth, sday);
		    actual[47]=dt.enterNumberCustomField(customNumberField);
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

	@Then("^should not be able to create defect for without single select field$")
	public void should_not_be_able_to_create_defect_for_without_single_select_field() throws Throwable {
	try
	   {
		actual[48]=dt.saveDefect();
		 driver.navigate().refresh();
		 for(int i=0;i<=1;i++)
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

	@When("^attempt to create a defect without date picker field$")
	public void attempt_to_create_a_defect_without_date_picker_field() throws Throwable {
	try
	   {
			actual[49]=dt.createDefect(project, issuetype);
			actual[50]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[51]=dt.enterDefectCustomFields(customFreeTextField,customRadioButon,customCheckbox,customUrlField,ze_Multiple_Select_Field,customSingleSelect,ze_Multi_Version_field,customSingleVersionPicker,customUserPicker,fields[0],ze_Multi_User_Picker,customTextField);
		    actual[52]=dt.enterNumberCustomField(customNumberField);
		    actual[53]=bp.waitForElement();
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

	@Then("^should not be able to create defect for without date picker field$")
	public void should_not_be_able_to_create_defect_for_without_date_picker_field() throws Throwable {
	try
	   {
		 actual[54]=dt.saveDefect();
		 driver.navigate().refresh();
		 for(int i=0;i<=1;i++)
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

	@When("^attempt to create a defect without number field$")
	public void attempt_to_create_a_defect_without_number_field() throws Throwable {
	try
	   {
			actual[55]=dt.createDefect(project, issuetype);
			actual[56]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[57]=dt.enterDefectCustomFields(customFreeTextField,customRadioButon,customCheckbox,customUrlField,ze_Multiple_Select_Field,customSingleSelect,ze_Multi_Version_field,customSingleVersionPicker,customUserPicker,fields[0],ze_Multi_User_Picker,customTextField);
		    actual[58]=dt.customDatePicker(syear, smonth, sday);
		    actual[59]=dt.enterNumberCustomField(fields[0]);
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

	@Then("^should not be able to create defect for without number field$")
	public void should_not_be_able_to_create_defect_for_without_number_field() throws Throwable {
	try
	   {
		actual[60]=dt.saveDefect();
		 driver.navigate().refresh();
		 for(int i=0;i<=1;i++)
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

	@When("^attempt to create a defect without url field$")
	public void attempt_to_create_a_defect_without_url_field() throws Throwable {
	try
	   {
			actual[61]=dt.createDefect(project, issuetype);
			actual[62]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[63]=dt.enterDefectCustomFields(customFreeTextField,customRadioButon,customCheckbox,fields[0],ze_Multiple_Select_Field,customSingleSelect,ze_Multi_Version_field,customSingleVersionPicker,customUserPicker,fields[1],ze_Multi_User_Picker,customTextField);
		    actual[64]=dt.customDatePicker(syear, smonth, sday);
		    actual[65]=dt.enterNumberCustomField(customNumberField);
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

	@Then("^should not be able to create defect for without url field$")
	public void should_not_be_able_to_create_defect_for_without_url_field() throws Throwable {
	try
	   {
		actual[66]=dt.saveDefect();
		 driver.navigate().refresh();
		 for(int i=0;i<=1;i++)
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

	@When("^attempt to create a defect without checkbox field$")
	public void attempt_to_create_a_defect_without_checkbox_field() throws Throwable {
	try
	   {
			actual[67]=dt.createDefect(project, issuetype);
			actual[68]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[69]=dt.enterDefectCustomFields(customFreeTextField,customRadioButon,fields[0],customUrlField,ze_Multiple_Select_Field,customSingleSelect,ze_Multi_Version_field,customSingleVersionPicker,customUserPicker,fields[1],ze_Multi_User_Picker,customTextField);
		    actual[70]=dt.customDatePicker(syear, smonth, sday);
		    actual[71]=dt.enterNumberCustomField(customNumberField);
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

	@Then("^should not be able to create defect for without checkbox field$")
	public void should_not_be_able_to_create_defect_for_without_checkbox_field() throws Throwable {
	try
	   {
		actual[72]=dt.saveDefect();
		 driver.navigate().refresh();
		 for(int i=0;i<=1;i++)
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

	@When("^attempt to create a defect without multi select field$")
	public void attempt_to_create_a_defect_without_multi_select_field() throws Throwable {
	try
	   {
		   String[] ze_Multiple_Select_Field=new String[2];
		   ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		   ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
			actual[73]=dt.createDefect(project, issuetype);
			actual[74]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[75]=dt.enterDefectCustomFields(customFreeTextField,customRadioButon,customCheckbox,customUrlField,ze_Multiple_Select_Field,customSingleSelect,ze_Multi_Version_field,customSingleVersionPicker,customUserPicker,fields[0],ze_Multi_User_Picker,customTextField);
		    actual[76]=dt.customDatePicker(syear, smonth, sday);
		    actual[77]=dt.enterNumberCustomField(customNumberField);
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

	@Then("^should not be able to create defect for without multi select field$")
	public void should_not_be_able_to_create_defect_for_without_multi_select_field() throws Throwable {
	try
	   {
		actual[78]=dt.saveDefect();
		 driver.navigate().refresh();
		 for(int i=0;i<=1;i++)
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

	@When("^attempt to create a defect without radio button field$")
	public void attempt_to_create_a_defect_without_radio_button_field() throws Throwable {
	try
	   {
			actual[79]=dt.createDefect(project, issuetype);
			actual[80]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[81]=dt.enterDefectCustomFields(customFreeTextField,fields[0],customCheckbox,customUrlField,ze_Multiple_Select_Field,customSingleSelect,ze_Multi_Version_field,customSingleVersionPicker,customUserPicker,fields[1],ze_Multi_User_Picker,customTextField);
		    actual[82]=dt.customDatePicker(syear, smonth, sday);
		    actual[83]=dt.enterNumberCustomField(customNumberField);
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

	@Then("^should not be able to create defect for without radio button field$")
	public void should_not_be_able_to_create_defect_for_without_radio_button_field() throws Throwable {
	try
	   {
		 actual[84]=dt.saveDefect();
		 driver.navigate().refresh();
		 for(int i=0;i<=1;i++)
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

	@When("^attempt to create a defect without user picker field$")
	public void attempt_to_create_a_defect_without_user_picker_field() throws Throwable {
	try
	   {
			actual[85]=dt.createDefect(project, issuetype);
			actual[86]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[87]=dt.enterDefectCustomFields(customFreeTextField,customRadioButon,customCheckbox,customUrlField,ze_Multiple_Select_Field,customSingleSelect,ze_Multi_Version_field,customSingleVersionPicker,fields[0],fields[1],ze_Multi_User_Picker,customTextField);
		    actual[88]=dt.enterNumberCustomField(customNumberField);
			actual[89]=dt.customDatePicker(syear, smonth, sday);
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

	@Then("^should not be able to create defect for without user picker field$")
	public void should_not_be_able_to_create_defect_for_without_user_picker_field() throws Throwable {
	try
	   {
		actual[90]=dt.saveDefect();
		 driver.navigate().refresh();
		 for(int i=0;i<=1;i++)
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

	@When("^attempt to create a defect without multi user picker field$")
	public void attempt_to_create_a_defect_without_multi_user_picker_field() throws Throwable {
	try
	   {
		   String[] ze_Multi_User_Picker=new String[2];
		   ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		   ze_Multi_User_Picker[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		    actual[91]=dt.createDefect(project, issuetype);
			actual[92]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[93]=dt.enterDefectCustomFields(customFreeTextField,customRadioButon,customCheckbox,customUrlField,ze_Multiple_Select_Field,customSingleSelect,ze_Multi_Version_field,customSingleVersionPicker,customUserPicker,fields[0],ze_Multi_User_Picker,customTextField);
		    actual[94]=dt.customDatePicker(syear, smonth, sday);
			actual[95]=dt.enterNumberCustomField(customNumberField);
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

	@Then("^should not be able to create defect for without multi user picker field$")
	public void should_not_be_able_to_create_defect_for_without_multi_user_picker_field() throws Throwable {
	try
	   {
		actual[96]=dt.saveDefect();
		 driver.navigate().refresh();
		 for(int i=0;i<=1;i++)
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

	@When("^attempt to create a defect without single version picker field$")
	public void attempt_to_create_a_defect_without_single_version_picker_field() throws Throwable {
	try
	   {
			actual[97]=dt.createDefect(project, issuetype);
			actual[98]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[99]=dt.enterDefectCustomFields(customFreeTextField,customRadioButon,customCheckbox,customUrlField,ze_Multiple_Select_Field,customSingleSelect,ze_Multi_Version_field,fields[0],customUserPicker,fields[1],ze_Multi_User_Picker,customTextField);
		    actual[100]=dt.customDatePicker(syear, smonth, sday);
		    actual[101]=dt.enterNumberCustomField(customNumberField);
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

	@Then("^should not be able to create defect for without single version picker field$")
	public void should_not_be_able_to_create_defect_for_without_single_version_picker_field() throws Throwable {
	try
	   {
		 actual[102]=dt.saveDefect();
		 driver.navigate().refresh();
		 for(int i=0;i<=1;i++)
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

	@When("^launch the test execution page to execute the testcase$")
	public void launch_the_test_execution_page_to_execute_the_testcase() throws Throwable {
	try
	   {
		   bp.waitForElement();
		   actual[103]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,12 );
		    
		    bp.waitForElement();
			actual[104]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[105]=exep.executeStatus(tcNo1[0], statusType1);
		    actual[106]=exep.clickOnDefectButton(tcNo1[0]);
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

	@When("^attempt to create a defect without text field in execution page$")
	public void attempt_to_create_a_defect_without_text_field_in_execution_page() throws Throwable {
	try
	   {
		    //String customTextField=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
			actual[107]=dt.createDefect(project, issuetype);
			actual[108]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[109]=dt.enterDefectCustomFields(customFreeTextField,customRadioButon,customCheckbox,customUrlField,ze_Multiple_Select_Field,customSingleSelect,ze_Multi_Version_field,customSingleVersionPicker,customUserPicker,fields[0],ze_Multi_User_Picker,fields[1]);
		    actual[110]=dt.customDatePicker(syear, smonth, sday);
		    actual[111]=dt.enterNumberCustomField(customNumberField);
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

	@Then("^should not be able to create defect for without text field in execution page$")
	public void should_not_be_able_to_create_defect_for_without_text_field_in_execution_page() throws Throwable {
	try
	   {
		 actual[112]=dt.saveDefect();
		 dt.clickOnCancelFileNewDefectButton();
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

	@When("^attempt to create a defect without free text field in execution page$")
	public void attempt_to_create_a_defect_without_free_text_field_in_execution_page() throws Throwable {
	try
	   {
			actual[113]=dt.createDefect(project, issuetype);
			actual[114]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[115]=dt.enterDefectCustomFields(fields[0],customRadioButon,customCheckbox,customUrlField,ze_Multiple_Select_Field,customSingleSelect,ze_Multi_Version_field,customSingleVersionPicker,customUserPicker,fields[1],ze_Multi_User_Picker,customTextField);
		    actual[116]=dt.customDatePicker(syear, smonth, sday);
		    actual[117]=dt.enterNumberCustomField(customNumberField);
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

	@Then("^should not be able to create defect for without free text field in execution page$")
	public void should_not_be_able_to_create_defect_for_without_free_text_field_in_execution_page() throws Throwable {
	try
	   {
		actual[118]=dt.saveDefect();
		dt.clickOnCancelFileNewDefectButton();
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

	@When("^attempt to create a defect without single select field in execution page$")
	public void attempt_to_create_a_defect_without_single_select_field_in_execution_page() throws Throwable {
	try
	   {
			actual[119]=dt.createDefect(project, issuetype);
			actual[120]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[121]=dt.enterDefectCustomFields(customFreeTextField,customRadioButon,customCheckbox,customUrlField,ze_Multiple_Select_Field,fields[0],ze_Multi_Version_field,customSingleVersionPicker,customUserPicker,fields[1],ze_Multi_User_Picker,fields[1]);
		    actual[122]=dt.customDatePicker(syear, smonth, sday);
		    actual[123]=dt.enterNumberCustomField(customNumberField);
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

	@Then("^should not be able to create defect for without single select field in execution page$")
	public void should_not_be_able_to_create_defect_for_without_single_select_field_in_execution_page() throws Throwable {
	try
	   {
		 actual[124]=dt.saveDefect();
		 dt.clickOnCancelFileNewDefectButton();
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

	@When("^attempt to create a defect without date picker field in execution page$")
	public void attempt_to_create_a_defect_without_date_picker_field_in_execution_page() throws Throwable {
	try
	   {
			actual[125]=dt.createDefect(project, issuetype);
			actual[126]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[127]=dt.enterDefectCustomFields(customFreeTextField,customRadioButon,customCheckbox,customUrlField,ze_Multiple_Select_Field,fields[0],ze_Multi_Version_field,customSingleVersionPicker,customUserPicker,fields[1],ze_Multi_User_Picker,customTextField);
		    actual[128]=dt.customDatePicker(syear, smonth, sday);
		    actual[129]=dt.enterNumberCustomField(customNumberField);
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

	@Then("^should not be able to create defect for without date picker field in execution page$")
	public void should_not_be_able_to_create_defect_for_without_date_picker_field_in_execution_page() throws Throwable {
	try
	   {
		 actual[130]=dt.saveDefect();
		 dt.clickOnCancelFileNewDefectButton();
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

	@When("^attempt to create a defect without number field in execution page$")
	public void attempt_to_create_a_defect_without_number_field_in_execution_page() throws Throwable {
	try
	   {
		    //String customTextField=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
			actual[131]=dt.createDefect(project, issuetype);
			actual[132]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[133]=dt.enterDefectCustomFields(customFreeTextField,customRadioButon,customCheckbox,fields[0],ze_Multiple_Select_Field,fields[1],ze_Multi_Version_field,customSingleVersionPicker,customUserPicker,fields[1],ze_Multi_User_Picker,customTextField);
		    actual[134]=dt.customDatePicker(syear, smonth, sday);
		    actual[135]=dt.enterNumberCustomField(fields[0]);
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

	@Then("^should not be able to create defect for without number field in execution page$")
	public void should_not_be_able_to_create_defect_for_without_number_field_in_execution_page() throws Throwable {
	try
	   {
		actual[136]=dt.saveDefect();
		dt.clickOnCancelFileNewDefectButton();
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

	@When("^attempt to create a defect without url field in execution page$")
	public void attempt_to_create_a_defect_without_url_field_in_execution_page() throws Throwable {
	try
	   {
			actual[137]=dt.createDefect(project, issuetype);
			actual[138]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[139]=dt.enterDefectCustomFields(customFreeTextField,customRadioButon,customCheckbox,fields[0],ze_Multiple_Select_Field,fields[1],ze_Multi_Version_field,customSingleVersionPicker,customUserPicker,fields[1],ze_Multi_User_Picker,customTextField);
		    actual[140]=dt.customDatePicker(syear, smonth, sday);
		    actual[141]=dt.enterNumberCustomField(customNumberField);
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

	@Then("^should not be able to create defect for without url field in execution page$")
	public void should_not_be_able_to_create_defect_for_without_url_field_in_execution_page() throws Throwable {
	try
	   {
		 actual[142]=dt.saveDefect();
		 dt.clickOnCancelFileNewDefectButton();
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

	@When("^attempt to create a defect without checkbox field in execution page$")
	public void attempt_to_create_a_defect_without_checkbox_field_in_execution_page() throws Throwable {
	try
	   {
		    //String customTextField=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
			actual[143]=dt.createDefect(project, issuetype);
			actual[144]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[145]=dt.enterDefectCustomFields(customFreeTextField,customRadioButon,fields[0],customUrlField,ze_Multiple_Select_Field,fields[1],ze_Multi_Version_field,customSingleVersionPicker,customUserPicker,fields[1],ze_Multi_User_Picker,customTextField);
		    actual[146]=dt.customDatePicker(syear, smonth, sday);
		    actual[147]=dt.enterNumberCustomField(customNumberField);
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

	@Then("^should not be able to create defect for without checkbox field in execution page$")
	public void should_not_be_able_to_create_defect_for_without_checkbox_field_in_execution_page() throws Throwable {
	try
	   {
		actual[148]=dt.saveDefect();
		dt.clickOnCancelFileNewDefectButton();
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

	@When("^attempt to create a defect without multi select field in execution page$")
	public void attempt_to_create_a_defect_without_multi_select_field_in_execution_page() throws Throwable {
	try
	   {
		   String[] ze_Multiple_Select_Field=new String[2];
		   ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		   ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
			actual[149]=dt.createDefect(project, issuetype);
			actual[150]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[151]=dt.enterDefectCustomFields(customFreeTextField,customRadioButon,customCheckbox,customUrlField,ze_Multiple_Select_Field,customSingleSelect,ze_Multi_Version_field,customSingleVersionPicker,customUserPicker,fields[0],ze_Multi_User_Picker,customTextField);
		    actual[152]=dt.customDatePicker(syear, smonth, sday);
		    actual[153]=dt.enterNumberCustomField(customNumberField);
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

	@Then("^should not be able to create defect for without multi select field in execution page$")
	public void should_not_be_able_to_create_defect_for_without_multi_select_field_in_execution_page() throws Throwable {
	try
	   {
		actual[154]=dt.saveDefect();
		dt.clickOnCancelFileNewDefectButton();
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

	@When("^attempt to create a defect without radio button field in execution page$")
	public void attempt_to_create_a_defect_without_radio_button_field_in_execution_page() throws Throwable {
	try
	   {
			actual[155]=dt.createDefect(project, issuetype);
			actual[156]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[157]=dt.enterDefectCustomFields(customFreeTextField,fields[0],customCheckbox,customUrlField,ze_Multiple_Select_Field,customSingleSelect,ze_Multi_Version_field,customSingleVersionPicker,customUserPicker,fields[1],ze_Multi_User_Picker,customTextField);
		    actual[158]=dt.customDatePicker(syear, smonth, sday);
		    actual[159]=dt.enterNumberCustomField(customNumberField);
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

	@Then("^should not be able to create defect for without radio button field in execution page$")
	public void should_not_be_able_to_create_defect_for_without_radio_button_field_in_execution_page() throws Throwable {
	try
	   {
		actual[160]=dt.saveDefect();
		dt.clickOnCancelFileNewDefectButton();
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

	@When("^attempt to create a defect without user picker field in execution page$")
	public void attempt_to_create_a_defect_without_user_picker_field_in_execution_page() throws Throwable {
	try
	   {
			actual[161]=dt.createDefect(project, issuetype);
			actual[162]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[163]=dt.enterDefectCustomFields(customFreeTextField,customRadioButon,customCheckbox,customUrlField,ze_Multiple_Select_Field,customSingleSelect,ze_Multi_Version_field,customSingleVersionPicker,fields[0],fields[1],ze_Multi_User_Picker,customTextField);
		    actual[164]=dt.customDatePicker(syear, smonth, sday);
		    actual[165]=dt.enterNumberCustomField(customNumberField);
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

	@Then("^should not be able to create defect for without user picker field in execution page$")
	public void should_not_be_able_to_create_defect_for_without_user_picker_field_in_execution_page() throws Throwable {
	try
	   {
		actual[166]=dt.saveDefect();
		dt.clickOnCancelFileNewDefectButton();
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

	@When("^attempt to create a defect without multi user picker field in execution page$")
	public void attempt_to_create_a_defect_without_multi_user_picker_field_in_execution_page() throws Throwable {
	try
	   {
		   String[] ze_Multi_User_Picker=new String[2];
		   ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		   ze_Multi_User_Picker[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		    actual[167]=dt.createDefect(project, issuetype);
			actual[168]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[169]=dt.enterDefectCustomFields(customFreeTextField,customRadioButon,customCheckbox,customUrlField,ze_Multiple_Select_Field,customSingleSelect,ze_Multi_Version_field,customSingleVersionPicker,customUserPicker,fields[0],ze_Multi_User_Picker,customTextField);
		    actual[170]=dt.customDatePicker(syear, smonth, sday);
		    actual[171]=dt.enterNumberCustomField(customNumberField);
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

	@Then("^should not be able to create defect for without multi user picker field in execution page$")
	public void should_not_be_able_to_create_defect_for_without_multi_user_picker_field_in_execution_page() throws Throwable {
	try
	   {
		actual[172]=dt.saveDefect();
		dt.clickOnCancelFileNewDefectButton();
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

	@When("^attempt to create a defect without single version picker field in execution page$")
	public void attempt_to_create_a_defect_without_single_version_picker_field_in_execution_page() throws Throwable {
	try
	   {
			actual[173]=dt.createDefect(project, issuetype);
			actual[174]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[175]=dt.enterDefectCustomFields(customFreeTextField,customRadioButon,customCheckbox,customUrlField,ze_Multiple_Select_Field,customSingleSelect,ze_Multi_Version_field,fields[0],customUserPicker,fields[1],ze_Multi_User_Picker,customTextField);
		    actual[176]=dt.customDatePicker(syear, smonth, sday);
		    actual[177]=dt.enterNumberCustomField(customNumberField);
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

	@Then("^should not be able to create defect for without single version picker field in execution page$")
	public void should_not_be_able_to_create_defect_for_without_single_version_picker_field_in_execution_page() throws Throwable {
	try
	   {
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[178]=dt.saveDefect();;
		 driver.navigate().refresh();
		 for(int i=0;i<=2;i++)
		 {
			 bp.waitForElement();
		 }
		 actual[183]=tp.doubleClickOnCycle(releaseName);
		 for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();
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
