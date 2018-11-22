package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_268 extends LaunchBrowser{
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	ExecutionPage ep;
	LaunchBrowser lb;
	LoginPage lp;
	DefectTracking dt;
	TestRepositoryPage tr;
	public String defectId;
	boolean[] actual=new boolean[94];
	SoftAssert soft=new SoftAssert();
	String fileName="DefectTracking_268";
	
	@Given("^User in Defecttracking Page$")
	public void user_in_Defecttracking_Page() throws Throwable {
		try
	       {
		   bp=new BasePage();
		   rp=new ReleasePage(driver);
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   bp.waitForElement();
		   actual[2]=pp.clickOnDefectTracking();
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

	@When("^User create a defect with custom field of type RadioButton if option values in numbers$")
	public void user_create_a_defect_with_custom_field_of_type_RadioButton_if_option_values_in_numbers() throws Throwable {
		try
		   {
		   dt=new DefectTracking(driver); 
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String zeRadioField=Excel_Lib.getNumericValue(INPUT_PATH_6,"DefectTracking", 19,0);
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[3]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[4]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[5]=dt.enterDefectCustomFields(field,zeRadioField, field, field, field_1, field,field_1, field, field,field, field_1, field);
		   bp.waitForElement();
		   actual[6]=dt.saveDefect();
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

	@Then("^Should be able to create defect if option values in numbers$")
	public void should_be_able_to_create_defect_if_option_values_in_numbers() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[7]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[8]=dt.updateDefect();
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

	@When("^User create defect if option values in uppercase$")
	public void user_create_defect_if_option_values_in_uppercase() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String zeRadioField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 19,1);
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[9]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[10]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[11]=dt.enterDefectCustomFields(field,zeRadioField, field, field, field_1, field,field_1, field, field,field, field_1, field);
		   bp.waitForElement();
		   actual[12]=dt.saveDefect();
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

	@Then("^Should be able to create defect if option values in uppercase$")
	public void should_be_able_to_create_defect_if_option_values_in_uppercase() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
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

	@When("^User create defect if option values in  lowercase$")
	public void user_create_defect_if_option_values_in_lowercase() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String zeRadioField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 19,2);
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[15]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[16]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[17]=dt.enterDefectCustomFields(field,zeRadioField, field, field, field_1, field,field_1, field, field,field, field_1, field);
		   bp.waitForElement();
		   actual[18]=dt.saveDefect();
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

	@Then("^Should be able to create defect if option values in lowercase$")
	public void should_be_able_to_create_defect_if_option_values_in_lowercase() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[19]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
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

	@When("^User create defect if option values contains alphanumeric characters and spaces$")
	public void user_create_defect_if_option_values_contains_alphanumeric_characters_and_spaces() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String zeRadioField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 19,3);
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[21]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[22]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[23]=dt.enterDefectCustomFields(field,zeRadioField, field, field, field_1, field,field_1, field, field,field, field_1, field);
		   bp.waitForElement();
		   actual[24]=dt.saveDefect();
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

	@Then("^Should be able to create defect if option values contains alphanumeric characters and spaces$")
	public void should_be_able_to_create_defect_if_option_values_contains_alphanumeric_characters_and_spaces() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
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

	@When("^User create defect if option values in special character$")
	public void user_create_defect_if_option_values_in_special_character() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String zeRadioField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 19,4);
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[27]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[28]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[29]=dt.enterDefectCustomFields(field,zeRadioField, field, field, field_1, field,field_1, field, field,field, field_1, field);
		   bp.waitForElement();
		   actual[30]=dt.saveDefect();
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

	@Then("^Should be able to create defect if option values in special character$")
	public void should_be_able_to_create_defect_if_option_values_in_special_character() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
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

	@When("^User create defect if option values contains international characters$")
	public void user_create_defect_if_option_values_contains_international_characters() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String zeRadioField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 19,5);
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[33]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[34]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[35]=dt.enterDefectCustomFields(field,zeRadioField, field, field, field_1, field,field_1, field, field,field, field_1, field);
		   bp.waitForElement();
		   actual[36]=dt.saveDefect();
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

	@Then("^Should be able to create defect if option values contains international characters$")
	public void should_be_able_to_create_defect_if_option_values_contains_international_characters() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
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

	@When("^User create defect if option values is very long$")
	public void user_create_defect_if_option_values_is_very_long() throws Throwable {
		try
		   {
			dt=new DefectTracking(driver); 
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String zeRadioField=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 19,6);
		   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[39]=dt.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[40]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[41]=dt.enterDefectCustomFields(field, zeRadioField, field, field, field_1, field, field_1, field, field,field, field_1, field);
		   bp.waitForElement();
		   actual[42]=dt.saveDefect();
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

	@Then("^Should be able to create defect if option values is very long$")
	public void should_be_able_to_create_defect_if_option_values_is_very_long() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
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

	@When("^User launch the Testexecution$")
	public void user_launch_the_Testexecution() throws Throwable {
		 try
		   {
		   actual[45]=rp.clickOnTestExecution();
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

	
	@Then("^Should be able to launch the Testexecution$")
	public void should_be_able_to_launch_the_Testexecution() throws Throwable {
	     try
		   {
           ep=new ExecutionPage(driver);	
		   actual[46]=ep.verifyExecutionPage();
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

	@When("^User create a defect with custom field of type radiobutton if option values in numbers$")
	public void user_create_a_defect_with_custom_field_of_type_radiobutton_if_option_values_in_numbers() throws Throwable {
		try
	    {	
	    tr=new TestRepositoryPage(driver);
	    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
	    String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);	 
	    String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
	    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
	    String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
        String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
	    String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
 	    String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
	    String zeRadioField=Excel_Lib.getNumericValue(INPUT_PATH_6,"DefectTracking", 19,0);
  	    String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
	    String field_1[]=new String[1];
	    field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
	    int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);
	    String cyclename[]=new String[1];
	    cyclename[0]=cycle;
	    String phase1[]=new String[1];
	    phase1[0]=name;
	    String[] str=new String[2];
	    str[0]=cycle;
	    str[1]=phase;
	    actual[47]=tr.navigateToNode(releaseName, str);
	    bp.waitForElement();
	    actual[48]=ep.selectAndDeselectAllTestCase();
	    bp.waitForElement();
	    actual[49]=ep.changeMultiSelectedStatus(status);
	    bp.waitForElement();	
	    actual[50]=ep.clickOnDefectButton(testcase);
	    bp.waitForElement();
	    actual[51]=ep.createDefect(project, issuetype);
  	    bp.waitForElement();
  	    actual[52]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
  	    actual[53]=dt.enterDefectCustomFields(field,zeRadioField, field, field, field_1, field,field_1, field, field,field, field_1, field);
	    bp.waitForElement();
	    actual[54]=dt.saveDefect();
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

	@Then("^Should be able to create defect if option values is in numbers$")
	public void should_be_able_to_create_defect_if_option_values_is_in_numbers() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[55]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[56]=dt.updateDefect();
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

	@When("^User create defect if option values is in uppercase$")
	public void user_create_defect_if_option_values_is_in_uppercase() throws Throwable {
		try
		   {
	       String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
	 	   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
	       String zeRadioField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 19,1);
	  	   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[57]=ep.createDefect(project, issuetype);
	       bp.waitForElement();
	       actual[58]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
	       actual[59]=dt.enterDefectCustomFields(field,zeRadioField, field, field, field_1, field,field_1, field, field,field, field_1, field);
	       bp.waitForElement();
	       actual[60]=dt.saveDefect();
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

	@Then("^Should be able to create defect if option values is in uppercase$")
	public void should_be_able_to_create_defect_if_option_values_is_in_uppercase() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[61]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[62]=dt.updateDefect();
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

	@When("^User create defect if option values is in lowercase$")
	public void user_create_defect_if_option_values_is_in_lowercase() throws Throwable {
		try
		   {
	       String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
	 	   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
	       String zeRadioField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 19,2);
	  	   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   actual[63]=ep.createDefect(project, issuetype);
	       bp.waitForElement();
	       actual[64]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
	       actual[65]=dt.enterDefectCustomFields(field,zeRadioField, field, field, field_1, field,field_1, field, field,field, field_1, field);
	       bp.waitForElement();
	       actual[66]=dt.saveDefect();
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

	@Then("^Should be able to create defect if option values is in lowercase$")
	public void should_be_able_to_create_defect_if_option_values_is_in_lowercase() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[67]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[68]=dt.updateDefect();
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

	@When("^User create defect if option values contains alphanumeric characters$")
	public void user_create_defect_if_option_values_contains_alphanumeric_characters() throws Throwable {
		try
		   {
	       String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
	 	   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
	       String zeRadioField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 19,3);
	  	   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);	
		   actual[69]=ep.createDefect(project, issuetype);
	       bp.waitForElement();
	       actual[70]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
	       actual[71]=dt.enterDefectCustomFields(field,zeRadioField, field, field, field_1, field,field_1, field, field,field, field_1, field);	       bp.waitForElement();
	       actual[72]=dt.saveDefect();
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

	@Then("^Should be able to create defect if option values contains alphanumeric characters$")
	public void should_be_able_to_create_defect_if_option_values_contains_alphanumeric_characters() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[73]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[74]=dt.updateDefect();
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

	@When("^User create defect if option values is in special character$")
	public void user_create_defect_if_option_values_is_in_special_character() throws Throwable {
		try
		   {
	       String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
	 	   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
	       String zeRadioField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 19,4);
	  	   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);	
		   actual[75]=ep.createDefect(project, issuetype);
	       bp.waitForElement();
	       actual[76]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
	       actual[77]=dt.enterDefectCustomFields(field,zeRadioField, field, field, field_1, field,field_1, field, field,field, field_1, field);	       bp.waitForElement();
	       bp.waitForElement();
	       actual[78]=dt.saveDefect();
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

	@Then("^Should be able to create defect if option values is in special character$")
	public void should_be_able_to_create_defect_if_option_values_is_in_special_character() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[79]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[80]=dt.updateDefect();
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

	@When("^User create defect if option values is in international characters$")
	public void user_create_defect_if_option_values_is_in_international_characters() throws Throwable {
		try
		   {
	       String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
	 	   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
	       String zeRadioField=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 19,5);
	  	   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);	
		   actual[81]=ep.createDefect(project, issuetype);
	       bp.waitForElement();
	       actual[82]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[83]=dt.enterDefectCustomFields(field,zeRadioField, field, field, field_1, field,field_1, field, field,field, field_1, field);
	       bp.waitForElement();
	       actual[84]=dt.saveDefect();
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

	@Then("^Should be able to create defect if option values is in international characters$")
	public void should_be_able_to_create_defect_if_option_values_is_in_international_characters() throws Throwable {
		try
		   {
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[85]=dt.validateDefect(project, issuetype); 
	       bp.waitForElement();
	       actual[86]=dt.updateDefect();
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

	@When("^User create defect if option values is Very long$")
	public void user_create_defect_if_option_values_is_Very_long() throws Throwable {
		try
		   {
			 dt=new DefectTracking(driver);
			 ep=new ExecutionPage(driver);
	       String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
	 	   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
	       String zeRadioField=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 19,6);
	  	   String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);
		   String field_1[]=new String[1];
		   field_1[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100,100);	
		   actual[87]=ep.createDefect(project, issuetype);
	       bp.waitForElement();
	       actual[88]=dt.fileNewDefect(summary_1, field, field, desc_1,field, field, field, field, field, field, field, field, field);
		   actual[89]=dt.enterDefectCustomFields(field,zeRadioField, field, field, field_1, field,field_1, field, field,field, field_1, field);
	       bp.waitForElement();
	       actual[90]=dt.saveDefect();
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

	@Then("^Should be able to create defect if option values is Very long$")
	public void should_be_able_to_create_defect_if_option_values_is_Very_long() throws Throwable {
		 try
		   {	
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);	
	       actual[91]=dt.validateDefect(project, issuetype); 
		   bp.waitForElement();
		   actual[92]=dt.updateDefect();
		   bp.waitForElement();
		   actual[93]=ep.clickOnCancelDefectWindow();
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
