package com.zephyr_batch_3.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Requirement_39 extends LaunchBrowser{
	
	LaunchBrowser lb = new LaunchBrowser();
	String fileName = "Requirement_39";
	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	ImportPage ip;
	CreateCustomFieldsPage ccp;
	TestRepositoryPage tr;
	RequirementsPage req;
	BasePage bp;
	CreateTestCasePage ctc;

	boolean[] actual = new boolean[9];
	SoftAssert soft = new SoftAssert();

	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Normal_Project_2");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
	


	@When("^User click on import and choose Excel option$")
	public void user_click_on_import_and_choose_Excel_option() throws Throwable {
		try
		{
			 pp=new ProjectPage(driver);
			   rp=new ReleasePage(driver);
			   bp=new BasePage();
		   req=new RequirementsPage(driver);
		   ip=new ImportPage(driver);
		   tr=new TestRepositoryPage(driver);
		   String Excel=Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 1, 12);
		   actual[0]=req.clickOnImport();
		   actual[1]=req.chooseImportType(Excel);
		   actual[2]=ip.clickOnNextForMap();
		   bp.waitForElement();
		   
		}
		catch(Exception e)
		{
			 e.printStackTrace();
			 Relogin_TPE rl=new Relogin_TPE();
			 driver.close();
			 rl.reLogin();
			 throw e;
		}    
	}

	@When("^Create a map with custom fields rows$")
	public void create_a_map_with_custom_fields_rows() throws Throwable {
		try
		{
		    String mapname = Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 5, 0);
			int rownum = Excel_Lib.getNumberData(INPUT_PATH_2, "Create_Map", 5, 1);
			String descrimi = Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 5, 2);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 5, 3);
			String name = Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 5, 4);
			String testSteps = Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 5, 5);
			String expResults = Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 5, 6);
			String extrID = Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 5, 7);
			
			
			
		   
		    String[] customFields= new String[6];
		    for(int i=0;i<=5;i++)
			{
			customFields[i]=Excel_Lib.getData(INPUT_PATH_2, "Create_Map", 5, i+13);
			}
			actual[3] =ip.createMapForRequirementWithCustomField(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID, customFields);

			
		}
		catch(Exception e)
		{
			 e.printStackTrace();
			 Relogin_TPE rl=new Relogin_TPE();
			 driver.close();
			 rl.reLogin();
			 throw e;
		}    
	}

	

@Then("^map should be Created Sucessfully$")
public void map_should_be_Created_Sucessfully() throws Throwable {
	try
	{
		String valMapName = Excel_Lib.getData(INPUT_PATH_2, "Import_Job", 8, 1);
	   actual[4]=ip.validateMap(valMapName);
	   bp.waitForElement();
	}
	catch(Exception e)
	{
		 e.printStackTrace();
		 Relogin_TPE rl=new Relogin_TPE();
		 driver.close();
		 rl.reLogin();
		 throw e;
	}   
}

	
	@When("^user add a job with duplicate value for unique custom field in Excel and run it$")
	public void user_add_a_job_with_duplicate_value_for_unique_custom_field_in_Excel_and_run_it() throws Throwable {
		try
		{
			
				actual[8] =ip.clickOnNextForImport();
			String jobname = Excel_Lib.getData(INPUT_PATH_2, "Import_Job", 8, 0);
			String mapName = Excel_Lib.getData(INPUT_PATH_2, "Import_Job", 8, 1);
			String path = Excel_Lib.getData(INPUT_PATH_2, "Import_Job", 8, 2);
			actual[5] =ip.importTestCaseRequirment(jobname, mapName, path);
			actual[6] =ip.runJob();
			bp.waitForElement();
			actual[7] =ip.ClickOKonStatusReport();
			actual[8] =ip.closeImportPage();
			
		}
		catch(Exception e)
		{
			 e.printStackTrace();
			 Relogin_TPE rl=new Relogin_TPE();
			 driver.close();
			 rl.reLogin();
			 throw e;
		}	   
	}

	@Then("^should not be able to import with duplicate value for unique custom field$")
	public void should_not_be_able_to_import_with_duplicate_value_for_unique_custom_field() throws Throwable {
		try
		{
			
			log.warn("Import job Failed");
		for(int k=0;k<=actual.length-1;k++)
		{
		//System.out.println("Actual["+k+"]="+actual[k]);
		soft.assertEquals(actual[k], true);
		}
		soft.assertAll();	
		
		}
		catch(Exception e)
		{
			 e.printStackTrace();
			 Relogin_TPE rl=new Relogin_TPE();
			 driver.close();
			 rl.reLogin();
			 throw e;
		}  
	}

}
