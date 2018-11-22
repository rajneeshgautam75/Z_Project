package com.zephyr_batch_4.stepdefinition;


import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Execution_Backlog_44 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	DashBoardPage dp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	ExecutionPage ep;
	CreateCustomFieldsPage ccp;
	CreateTestCasePage ctc;
	boolean[] actual=new boolean[31];
	SoftAssert soft=new SoftAssert();
    String fileName="Execution_Backlog_44";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
   	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
   	@Given("^user logins as  TEST Managaer credentials$")
   	public void user_logins_as_TEST_Managaer_credentials() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			bp=new BasePage();
			lb=new LaunchBrowser();
			lp=new LoginPage(driver);
			dp=new DashBoardPage(driver);
		    bp.waitForElement();
		    pp.clickOnLogout();
			bp.waitForElement();
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Password_1");
			bp.waitForElement();
			actual[0]=lp.enterUname(uname);
			actual[1]=lp.enterPass(password);
			lp.clickOnLogin();
			
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
	    

	@When("^user is in test fields and creates custom field picklist type and assign it to sample project$")
	public void user_is_in_test_fields_and_creates_custom_field_picklist_type_and_assign_it_to_sample_project() throws Throwable {
	    try
	    {
	    	ccp=new CreateCustomFieldsPage(driver);
			ccp.moveToCustomFields();
			String customfieldName=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 4, 3);
			boolean res=ccp.checkAvailableCustomFields(customfieldName);
				if(res==false)
				{
				String customfieldDescription=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 2, 4);
				String dataType=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 1, 0);
				String piclistValues[]=new String[1];
				piclistValues[0]=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 4, 3);
				String allProject=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 100, 100);
				String projectName=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 1, 3);
				String searchableCheck=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 100, 100);
				String unique=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 100, 100);
				String mandatory=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 100, 100);
				bp.waitForElement();
				ccp.createCustomFields(customfieldName, customfieldDescription, dataType, piclistValues, allProject, projectName, searchableCheck, unique, mandatory);
				bp.waitForElement();
				ccp.closeCustomFieldWindow.click();
	            }
				else
				{
					bp.waitForElement();
					ccp.closeCustomFieldWindow.click();
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

	@When("^User create few Testcases and schedules and assign it to anyone$")
	public void user_create_few_Testcases_and_schedules_and_assign_it_to_anyone() throws Throwable {
		try
	    {
			tp=new TestPlanningPage(driver);
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			ep=new ExecutionPage(driver);
			ctc=new CreateTestCasePage(driver);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 7, 0);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 7, 1);
			pp.clickOnLogout();
			bp.waitForElement();
			bp.waitForElement();
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_1");
			bp.waitForElement();
			actual[2]=lp.enterUname(uname);
			actual[3]=lp.enterPass(password);
			System.out.println("UserName is"+uname);
			System.out.println("Password is"+password);
			lp.clickOnLogin();
			bp.waitForElement();
			actual[4]=pp.selectProject(project);
			actual[5]=pp.selectRelease(release);
			String [] navigation=new String [1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 7, 0);
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 14, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 1, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 1, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 3, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 5));
			String [] cycle1 =new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 14, 0);
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 7,0);
			String Bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 2, 0);
			String text=Excel_Lib.getData(INPUT_PATH_7,"CustomFields", 2, 5);
			String longText=Excel_Lib.getData(INPUT_PATH_7,"CustomFields", 2, 7);
			String number=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7,"CustomFields", 2, 8));
			String checkBox=Excel_Lib.getData(INPUT_PATH_7,"CustomFields", 3, 6);
			String pickupList=Excel_Lib.getData(INPUT_PATH_7,"CustomFields", 2, 6);
			String date=Excel_Lib.getData(INPUT_PATH_7,"CustomFields", 100, 100);
			bp.waitForElement();
			actual[6]=rp.clickOnTestRep();
			actual[7]=tr.clickOnRelease(release);
			tr.addNode(name, desc);
			bp.waitForElement();
		    tr.navigateToNode(release, navigation);
		    actual[8]=tr.addTestCase();
		    bp.waitForElement();
		    tr.clickDetailButton();
			bp.waitForElement();
			ctc.customFieldOption.click();
			actual[9]=ctc.enterCustomFields(text, longText, number, checkBox, pickupList, date);
			bp.waitForElement();
			for(int i=0;i<=1;i++)
			{
				actual[10]=tr.selectallTestCase();
				actual[11]=tr.cloneTestCase();
			}
			actual[12]=bp.waitForElement();
			rp.clickOnTestPlanning();
			actual[13]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[14]=tp.CreateCycle(cycle, Build, Environment, hide);
			bp.waitForElement();
			actual[15]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[16]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			actual[17]=tp.navigateToCycle(cycle1);
			bp.waitForElement();
			actual[18]=tp.addPhaseToCycle(Phase);
			bp.waitForElement();
			tp.bulkAssignment(Bulk_type);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",14,0 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",7,0 );
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			actual[19]=rp.clickOnTestExecution();
			bp.waitForElement();
			tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[20]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[21]=ep.changeMultiSelectedStatus(status);     	
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

	@When("^create Dashboard and add Execution backlog gadget and configure$")
	public void create_Dashboard_and_add_Execution_backlog_gadget_and_configure() throws Throwable {
		
			try
			{
				    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 0);
				    String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
				    String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
				    String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
				    String filterByName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 2);
			    	String values[]=new String[1];
			    	values[0]=Excel_Lib.getData(INPUT_PATH_7,"CustomFields", 4, 3);
			    	String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 6);
			    	String refreshrate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 7);
			    	bp.waitForElement();
			    	actual[22]=dp.clickOnManageDashboards();
			    	actual[23]=dp.clickOnAddDashBoardSymbol();
			    	actual[24]=dp.enterDashBoardDetails(name, description, layout, shareType);
			    	actual[25]=dp.selectDashboard(name);
					bp.waitForElement();
					actual[26]=dp.clickOnAddGadgetSymbol();
					bp.waitForElement();
					actual[27]=dp.addGadget(gadget);
					bp.waitForElement();
					actual[28]=dp.configureTraceabilityGadget(project, release, refreshrate);
					bp.waitForElement();
					bp.waitForElement();
					actual[29]=dp.filterBy(filterByName, values);
					dp.saveTraceabilityGadget();
					
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

	@Then("^should display customfields Properly$")
	public void should_display_customfields_Properly() throws Throwable {
		try
	    {
			String filterByName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 2);
			bp.waitForElement();
			actual[30]=dp.viewMsg(filterByName);
			bp.waitForElement();
			pp.backToProjectPage();
			for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		      System.out.println(actual[k]);
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
