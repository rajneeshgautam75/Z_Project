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

public class Defect_Tracking_277 extends LaunchBrowser{

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
	String fileName="Defect_Tracking_277";
	
	boolean[] actual=new boolean[184];
	SoftAssert soft=new SoftAssert();
	 private String[] ze_Multiple_Select_Field=new String[2];
	  {
	   ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
	   ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
	  }
	   private String[] ze_Multi_User_Picker=new String[2];
	   {
	   ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
	   ze_Multi_User_Picker[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
	   }
	   String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,0);
	   String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,2);
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
	 String optionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",10,52);
	
	@Given("^defect user is in the external Jira Page$")
	public void defect_user_is_in_the_external_Jira_Page() throws Throwable {
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

	@When("^navigate to the Issues page$")
	public void navigate_to_the_Issues_page() throws Throwable {
	try
	   {
		 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,40);
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

	@When("^change custom fields from mandatory to non mandatoty$")
	public void change_custom_fields_from_mandatory_to_non_mandatoty() throws Throwable {
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
		 String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		 actual[6]=bp.waitForElement();
		 actual[7]=ejp.navigateToCustomFieldsConfiguration();
		 actual[8]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customTextField,optionValue);
		 actual[9]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customFreeTextField,optionValue);
		 actual[10]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customSingleSelect,optionValue);
		 actual[11]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customDatePicker,optionValue);
		 actual[12]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customNumberField,optionValue);
		 actual[13]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customUrlField,optionValue);
		 actual[14]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customCheckbox,optionValue);
		 actual[15]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customMultiSelect,optionValue);
		 actual[16]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customRadioButon,optionValue);
		 actual[17]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customUserPicker,optionValue);
		 actual[18]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customMultiUserPicker,optionValue);
		 actual[19]=ejp.changeCustomFieldsToMandatoryOrNonMandatory(customSingleVersionPicker,optionValue);
		 actual[20]=ejp.logOutFromExternal_JIRA();
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

	@When("^As the Manager,Launch the Administration page$")
	public void as_the_Manager_Launch_the_Administration_page() throws Throwable {
	try
    {
		 String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     String manager_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String manager_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     driver.navigate().to(zephyr_Url);
	     actual[21]=lp.enterUname(manager_Uname);
	     actual[22]=lp.enterPass(manager_Pass);
	     actual[23]=lp.clickOnLogin();
	     actual[24]=pp.launchAdministration();
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

	@When("^launch the defect admin to clear the Cache$")
	public void launch_the_defect_admin_to_clear_the_Cache() throws Throwable {
	try
	   {
		 actual[25]=pp.launchDefectAdmin();
		 actual[26]=pp.clearCache();
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

	@When("^As the Lead,launch the defect tracking page$")
	public void as_the_Lead_launch_the_defect_tracking_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 String lead_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String lead_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     //driver.navigate().to(zephyr_Url);
	     actual[27]=lp.enterUname(lead_Uname);
	     actual[28]=lp.enterPass(lead_Pass);
	     actual[29]=lp.clickOnLogin();
		 actual[30]=pp.selectProject(projectName);
		 actual[31]=pp.selectRelease(releaseName);
		 actual[32]=rp.clickOnDefectTracking();
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

	@When("^create a defect with text field$")
	public void create_a_defect_with_text_field() throws Throwable {
	try
	   {
			actual[33]=dt.createDefect(project,issueType);
			actual[34]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[35]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],fields[6],fields[7],ze_Multi_User_Picker,customTextField);
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

	@Then("^should be able to create defect with text field$")
	public void should_be_able_to_create_defect_with_text_field() throws Throwable {
	try
	  {
		 actual[37]=dt.validateDefect(project,issueType);
		 actual[38]=bp.waitForElement();
		 actual[39]=dt.updateDefect();
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

	@When("^create a defect with free text field$")
	public void create_a_defect_with_free_text_field() throws Throwable {
	try
	   {
			actual[40]=dt.createDefect(project,issueType);
			actual[41]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[42]=dt.enterDefectCustomFields(customFreeTextField,fields[0],fields[1],fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
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

	@Then("^should be able to create defect with free text field$")
	public void should_be_able_to_create_defect_with_free_text_field() throws Throwable {
	try
	  {
		 actual[44]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[45]=dt.updateDefect();
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

	@When("^create a defect with single select field$")
	public void create_a_defect_with_single_select_field() throws Throwable {
	try
	   {
			actual[46]=dt.createDefect(project,issueType);
			actual[47]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[48]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,customSingleSelect,ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
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

	@Then("^should be able to create defect with single select field$")
	public void should_be_able_to_create_defect_with_free_text_field_in_DT() throws Throwable {
	try
	  {
		 actual[50]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[51]=dt.updateDefect();
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

	@When("^create a defect with date picker field$")
	public void attempt_to_create_a_defect_with_date_picker_field() throws Throwable {
	try
	   {
			actual[52]=dt.createDefect(project,issueType);
			actual[53]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
		    actual[54]=dt.customDatePicker(syear,smonth,sday);
			actual[55]=dt.saveDefect();
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

	@Then("^should be able to create defect with date picker field$")
	public void should_be_able_to_create_defect_with_date_picker_field() throws Throwable {
	try
	  {
		 actual[56]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[57]=dt.updateDefect();
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

	@When("^create a defect with number field$")
	public void create_a_defect_with_number_field() throws Throwable {
	try
	   {
			actual[58]=dt.createDefect(project,issueType);
			actual[59]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],fields[6],fields[7],ze_Multi_User_Picker,fields[8]);
			actual[60]=dt.enterNumberCustomField(customNumberField);
			actual[61]=dt.saveDefect();
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

	@Then("^should be able to create defect with number field$")
	public void should_be_able_to_create_defect_with_number_field() throws Throwable {
	try
	  {
		 actual[62]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[63]=dt.updateDefect();
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

	@When("^create a defect with url field$")
	public void create_a_defect_with_url_field() throws Throwable {
	try
	   {
			actual[64]=dt.createDefect(project,issueType);
			actual[65]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[66]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],customUrlField,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
			actual[67]=dt.saveDefect();
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

	@Then("^should be able to create defect with url field$")
	public void should_be_able_to_create_defect_without_url_field() throws Throwable {
	try
	  {
		 actual[68]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[69]=dt.updateDefect();
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

	@When("^create a defect with checkbox field$")
	public void create_a_defect_with_checkbox_field() throws Throwable {
	try
	   {
			actual[70]=dt.createDefect(project,issueType);
			actual[71]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[72]=dt.enterDefectCustomFields(fields[0],fields[1],customCheckbox,fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
			actual[73]=dt.saveDefect();
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

	@Then("^should be able to create defect with checkbox field$")
	public void should_be_able_to_create_defect_with_checkbox_field() throws Throwable {
	try
	  {
		 actual[74]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[75]=dt.updateDefect();
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

	@When("^create a defect with multi select field$")
	public void create_a_defect_with_multi_select_field() throws Throwable {
	try
	   {
		    String[] ze_Multiple_Select_Field=new String[2];
		    ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,24);
		    ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,24);
			actual[76]=dt.createDefect(project,issueType);
			actual[77]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[78]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],fields[6],fields[7],ze_Multi_User_Picker,fields[8]);
			actual[79]=dt.saveDefect();
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

	@Then("^should be able to create defect with multi select field$")
	public void should_be_able_to_create_defect_with_multi_select_field() throws Throwable {
	try
	  {
		 actual[80]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[81]=dt.updateDefect();
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

	@When("^create a defect with radio button field$")
	public void create_a_defect_with_radio_button_field() throws Throwable {
	try
	   {
			actual[82]=dt.createDefect(project,issueType);
			actual[83]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[84]=dt.enterDefectCustomFields(fields[0],customRadioButon,fields[1],fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
			actual[85]=dt.saveDefect();
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

	@Then("^should be able to create defect with radio button field$")
	public void should_be_able_to_create_defect_with_radio_button_field() throws Throwable {
	try
	  {
		 actual[86]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[87]=dt.updateDefect();
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

	@When("^create a defect with user picker field$")
	public void create_a_defect_with_user_picker_field() throws Throwable {
	try
	   {
			actual[88]=dt.createDefect(project,issueType);
			actual[89]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[90]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],customUserPicker,fields[6],ze_Multi_User_Picker,fields[7]);
			actual[91]=dt.saveDefect();
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

	@Then("^should be able to create defect with user picker field$")
	public void should_be_able_to_create_defect_with_user_picker_field() throws Throwable {
	try
	  {
		 actual[92]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[93]=dt.updateDefect();
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

	@When("^create a defect with multi user picker field$")
	public void create_a_defect_with_multi_user_picker_field() throws Throwable {
	try
	   {
		    String[] ze_Multi_User_Picker=new String[2];
		    ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,28);
		    ze_Multi_User_Picker[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,28);
			actual[94]=dt.createDefect(project,issueType);
			actual[95]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[96]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],fields[6],fields[7],ze_Multi_User_Picker,fields[8]);
			actual[97]=dt.saveDefect();
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

	@Then("^should be able to create defect with multi user picker field$")
	public void should_be_able_to_create_defect_with_multi_user_picker_field() throws Throwable {
	try
	  {
		 actual[98]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[99]=dt.updateDefect();
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

	@When("^create a defect with single version picker field$")
	public void create_a_defect_with_single_version_picker_field() throws Throwable {
	try
	   {
			actual[100]=dt.createDefect(project,issueType);
			actual[101]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[102]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,customSingleVersionPicker,fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
			actual[103]=dt.saveDefect();
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

	@Then("^should be able to create defect with single version picker field$")
	public void should_be_able_to_create_defect_with_single_version_picker_field() throws Throwable {
	try
	  {
		 actual[104]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[105]=dt.updateDefect();
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

	@When("^launch the testExecution page to execute the testcase$")
	public void launch_the_testExecution_page_to_execute_the_testcase() throws Throwable {
	try
	   {
		   bp.waitForElement();
		   actual[106]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,12 );
		    
		    bp.waitForElement();
			actual[107]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[108]=exep.executeStatus(tcNo1[0], statusType1);
		    actual[109]=exep.clickOnDefectButton(tcNo1[0]);
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

	@When("^create a defect with text field in execution page$")
	public void create_a_defect_without_text_field_in_execution_page() throws Throwable {
	try
	   {
			actual[110]=dt.createDefect(project,issueType);
			actual[111]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[112]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],fields[6],fields[7],ze_Multi_User_Picker,customTextField);
			actual[113]=dt.saveDefect();
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

	@Then("^should be able to create defect with text field in execution page$")
	public void should_be_able_to_create_defect_with_text_field_in_execution_page() throws Throwable {
	try
	  {
		 actual[114]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[115]=dt.updateDefect();
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

	@When("^create a defect with free text field in execution page$")
	public void create_a_defect_with_free_text_field_in_execution_page() throws Throwable {
	try
	   {
			actual[116]=dt.createDefect(project,issueType);
			actual[117]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[118]=dt.enterDefectCustomFields(customFreeTextField,fields[0],fields[1],fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
			actual[119]=dt.saveDefect();
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

	@Then("^should be able to create defect with free text field in execution page$")
	public void should_be_able_to_create_defect_with_free_text_field_in_execution_page() throws Throwable {
	try
	  {
		 actual[120]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[121]=dt.updateDefect();
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

	@When("^create a defect with single select field in execution page$")
	public void create_a_defect_with_single_select_field_in_execution_page() throws Throwable {
	try
	   {
			actual[122]=dt.createDefect(project,issueType);
			actual[123]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[124]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,customSingleSelect,ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
			actual[125]=dt.saveDefect();
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

	@Then("^should be able to create defect with single select field in execution page$")
	public void should_be_able_to_create_defect_for_with_single_select_field_in_execution_page() throws Throwable {
	try
	  {
		 actual[126]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[127]=dt.updateDefect();
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

	@When("^create a defect with date picker field in execution page$")
	public void create_a_defect_with_date_picker_field_in_execution_page() throws Throwable {
	try
	   {
			actual[128]=dt.createDefect(project,issueType);
			actual[129]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
		    actual[130]=dt.customDatePicker(syear,smonth,sday);
			actual[131]=dt.saveDefect();
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

	@Then("^should be able to create defect with date picker field in execution page$")
	public void should_be_able_to_create_defect_with_date_picker_field_in_execution_page() throws Throwable {
	try
	  {
		 actual[132]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[133]=dt.updateDefect();
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

	@When("^create a defect with number field in execution page$")
	public void create_a_defect_with_number_field_in_execution_page() throws Throwable {
	try
	   {
			actual[134]=dt.createDefect(project,issueType);
			actual[135]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],fields[6],fields[7],ze_Multi_User_Picker,fields[8]);
			actual[136]=dt.enterNumberCustomField(customNumberField);
			actual[137]=dt.saveDefect();
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

	@Then("^should be able to create defect with number field in execution page$")
	public void should_be_able_to_create_defect_with_number_field_in_execution_page() throws Throwable {
	try
	  {
		 actual[138]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[139]=dt.updateDefect();
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

	@When("^create a defect with url field in execution page$")
	public void create_a_defect_with_url_field_in_execution_page() throws Throwable {
	try
	   {
			actual[140]=dt.createDefect(project,issueType);
			actual[141]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[142]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],customUrlField,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
			actual[143]=dt.saveDefect();
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

	@Then("^should be able to create defect with url field in execution page$")
	public void should_be_able_to_create_defect_with_url_field_in_execution_page() throws Throwable {
	try
	  {
		 actual[144]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[145]=dt.updateDefect();
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

	@When("^create a defect with checkbox field in execution page$")
	public void create_a_defect_with_checkbox_field_in_execution_page() throws Throwable {
	try
	   {
			actual[146]=dt.createDefect(project,issueType);
			actual[147]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[148]=dt.enterDefectCustomFields(fields[0],fields[1],customCheckbox,fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
			actual[149]=dt.saveDefect();
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

	@Then("^should be able to create defect with checkbox field in execution page$")
	public void should_be_able_to_create_defect_with_checkbox_field_in_execution_page() throws Throwable {
	try
	  {
		 actual[150]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[151]=dt.updateDefect();
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

	@When("^create a defect with multi select field in execution page$")
	public void create_a_defect_with_multi_select_field_in_execution_page() throws Throwable {
		try
		   {
			    String[] ze_Multiple_Select_Field=new String[2];
			    ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,24);
			    ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,24);
				actual[152]=dt.createDefect(project,issueType);
				actual[153]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
				actual[154]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],fields[6],fields[7],ze_Multi_User_Picker,fields[8]);
				actual[155]=dt.saveDefect();
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

	@Then("^should be able to create defect with multi select field in execution page$")
	public void should_be_able_to_create_defect_with_multi_select_field_in_execution_page() throws Throwable {
	try
	  {
		 actual[156]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[157]=dt.updateDefect();
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

	@When("^create a defect with radio button field in execution page$")
	public void create_a_defect_with_radio_button_field_in_execution_page() throws Throwable {
	try
	   {
			actual[158]=dt.createDefect(project,issueType);
			actual[159]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[160]=dt.enterDefectCustomFields(fields[0],customRadioButon,fields[1],fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
			actual[161]=dt.saveDefect();
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

	@Then("^should be able to create defect with radio button field in execution page$")
	public void should_be_able_to_create_defect_with_radio_button_field_in_execution_page() throws Throwable {
	try
	  {
		 actual[162]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[163]=dt.updateDefect();
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

	@When("^create a defect with user picker field in execution page$")
	public void create_a_defect_with_user_picker_field_in_execution_page() throws Throwable {
	try
	   {
			actual[164]=dt.createDefect(project,issueType);
			actual[165]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[166]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],customUserPicker,fields[6],ze_Multi_User_Picker,fields[7]);
			actual[167]=dt.saveDefect();
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

	@Then("^should be able to create defect with user picker field in execution page$")
	public void should_be_able_to_create_defect_with_user_picker_field_in_execution_page() throws Throwable {
	try
	  {
		 actual[168]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[169]=dt.updateDefect();
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

	@When("^create a defect with multi user picker field in execution page$")
	public void create_a_defect_with_multi_user_picker_field_in_execution_page() throws Throwable {
	try
	   {
		    String[] ze_Multi_User_Picker=new String[2];
		    ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,28);
		    ze_Multi_User_Picker[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,28);
			actual[170]=dt.createDefect(project,issueType);
			actual[171]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[172]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],fields[6],fields[7],ze_Multi_User_Picker,fields[8]);
			actual[173]=dt.saveDefect();
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

	@Then("^should be able to create defect with multi user picker field in execution page$")
	public void should_be_able_to_create_defect_with_multi_user_picker_field_in_execution_page() throws Throwable {
	try
	  {
		 actual[174]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[175]=dt.updateDefect();
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

	@When("^create a defect with single version picker field in execution page$")
	public void create_a_defect_with_single_version_picker_field_in_execution_page() throws Throwable {
	try
	   {
			actual[176]=dt.createDefect(project,issueType);
			actual[177]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[178]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,customSingleVersionPicker,fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
			actual[179]=dt.saveDefect();
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

	@Then("^should be able to create defect with single version picker field in execution page$")
	public void should_be_able_to_create_defect_with_single_version_picker_field_in_execution_page() throws Throwable {
	try
	  {
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[180]=dt.validateDefect(project,issueType);
		 bp.waitForElement();
		 actual[181]=dt.updateDefect();
		 bp.waitForElement();
		 actual[182]=exep.clickOnCancelDefectWindow();
		 actual[183]=tp.doubleClickOnCycle(releaseName);
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
