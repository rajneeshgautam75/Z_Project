package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Dashboard_27 extends LaunchBrowser {

	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	DashBoardPage db;
	BasePage bp;
	CreateTestCasePage ctc;
	ExportPage ep;
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Dashboard_27";
	
	boolean[] actual=new boolean[26];
	 SoftAssert soft=new SoftAssert();
	 
	@When("^creates a Phase with Name and Description$")
	public void creates_a_Phase_with_Name_and_Description() throws Throwable {
	   
		try
		{
	
			pp=new ProjectPage(driver);
			bp=new BasePage();
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
	 
			
	 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	 String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 9);
	 String phaseDesc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 10);
	
	 actual[0]=tr.clickOnRelease(releaseName);
	 actual[1]=tr.addNode(phaseName, phaseDesc);
		
		}
		catch(Exception e)
		{

		lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^phase should be created Successfully$")
	public void phase_should_be_created_Successfully() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		 String[] phase=new String[1];
		 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 9);
	   
		 actual[2]=tr.navigateToNode(releaseName, phase);
		 
		}
		catch(Exception e)
		{

		lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
		
	}

	@When("^user add a testcase with multiple tags$")
	public void user_add_a_testcase_with_multiple_tags() throws Throwable {
		try
		{
		ctc=new CreateTestCasePage(driver); 
		String[] tags1=new String[20];
		 for(int i=0;i<=tags1.length-1;i++)
		 {
		 tags1[i]=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", i+1, 11);
		 }
		  for(int i=1;i<=5;i++)
		  {
		   actual[3]=tr.addTestCase();
		  }
		   bp.waitForElement();
		   tr.clickDetailButton();
		   bp.waitForElement();
		   
		   
		   ep=new ExportPage(driver);
		   
		   String[] testcaseNo=new String[1];
			
			testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 1, 14));
		   ep.selectMultipleTestCaseFromGrid(testcaseNo);
		   
		   actual[4]=ctc.enterMultipletags(tags1);
		   
		   String[] tags2=new String[20];
			 for(int i=0;i<=tags1.length-1;i++)
			 {
			 tags2[i]=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", i+21, 11);
			 }
			 
			 String[] testcaseNo2=new String[1];
				
				testcaseNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 2, 14));
			   ep.selectMultipleTestCaseFromGrid(testcaseNo2);
			   ctc.enterMultipletags(tags2);
			   
			 String[] tags3=new String[20];
			 for(int i=0;i<=tags1.length-1;i++)
			 {
			 tags3[i]=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", i+41, 11);
			 }
			 
			 String[] testcaseNo3=new String[1];
				
				testcaseNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 3, 14));
			   ep.selectMultipleTestCaseFromGrid(testcaseNo3);
			   ctc.enterMultipletags(tags3);
			 
			 String[] tags4=new String[20];
			 for(int i=0;i<=tags1.length-1;i++)
			 {
			 tags4[i]=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", i+61, 11);
			 }
			 String[] testcaseNo4=new String[1];
				
				testcaseNo4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 4, 14));
			   ep.selectMultipleTestCaseFromGrid(testcaseNo4);
			   ctc.enterMultipletags(tags4);
			 
			 String[] tags5=new String[20];
			 for(int i=0;i<=tags1.length-1;i++)
			 {
			 tags5[i]=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", i+81, 11);
			 }
			 String[] testcaseNo5=new String[1];
				
				testcaseNo5[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 5, 14));
			   ep.selectMultipleTestCaseFromGrid(testcaseNo5);
			   ctc.enterMultipletags(tags5);
			 
		   
		  
		   
		   
		 }
		   catch(Exception e)
			{
		 
		    lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		 	Relogin_TPE rl=new Relogin_TPE();
		 	rl.reLogin();
		 	throw e;
			}  
	}

	@Then("^testcase should be Added with multiple tags$")
	public void testcase_should_be_Added_with_multiple_tags() throws Throwable {
		try
		{
		actual[5]=tr.verifyPresentTestCase();
		tr.clickOnList();
		
		 }
		   catch(Exception e)
			{
		 
		    lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		 	Relogin_TPE rl=new Relogin_TPE();
		 	rl.reLogin();
		 	throw e;
			}
	}

	@When("^user creates a new Dash_board$")
	public void user_creates_a_new_Dash_board() throws Throwable {
		try
		  {
			db=new DashBoardPage(driver);
			 
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 1);
		    String desc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 2);
		    String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 3);
		    String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 4);
		    actual[6]=db.clickOnAddDashBoardSymbol();
		    actual[7]=db.enterDashBoardDetails(name, desc, layout, shareType);
		}
		  catch(Exception e)
			{
		  
		     lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		  	Relogin_TPE rl=new Relogin_TPE();
		  	rl.reLogin();
		  	throw e;
			}  
	}
	
	@Then("^dashboard should be created Successfully$")
	public void dashboard_should_be_created_Successfully() throws Throwable {
		 try
		   {
			   String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 1);
			   actual[8]= db.validateDashBoard(dashBoard);
		   }
		   catch(Exception e)
			{
		 
		    lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		 	Relogin_TPE rl=new Relogin_TPE();
		 	rl.reLogin();
		 	throw e;
			}  
	}

	@When("^user add Test Automation Distribution Gadget by selecting one tag$")
	public void user_add_Test_Automation_Distribution_Gadget_by_selecting_one_tag() throws Throwable {
		try
		{
	    String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 1);
	  
	  //gadget fields
	    String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 5);
	   String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 6);
	  String typeName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 7);
	  String[] value=new String[1];
	  
	  value[0]=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 11);
	  
	    actual[9]=db.selectDashboard(dashBoard);
	    actual[10]= db.clickOnAddGadgetSymbol();
	    actual[11]=db.addGadget(gadgetName);
	    
	    actual[12]=db.configureTestAutomationDistributionGadget(project, release, refreshRate, typeName, value);
	    
		}
		  catch(Exception e)
			{
		  
		     lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		  	Relogin_TPE rl=new Relogin_TPE();
		  	rl.reLogin();
		  	throw e;
			}  
	}
	

	@Then("^Test Automation Distribution Gadget by tag added successfully$")
	public void test_Automation_Distribution_Gadget_by_tag_added_successfully() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 5);
		actual[13]=db.validateGadget(gadgetName);
		}
		catch(Exception e)
		{

		lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}  
	}

	@When("^user add Test Automation Distribution Gadget by selecting ten tag$")
	public void user_add_Test_Automation_Distribution_Gadget_by_selecting_ten_tag() throws Throwable {
		try
		{
	    //String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 1);
	  
	  //gadget fields
	    String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 5);
	   String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 6);
	  String typeName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 7);
	  String[] value=new String[10];
	  for(int i=0;i<=value.length-1;i++)
	  {
	  value[i]=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", i+1, 11);
	  }
	    //actual[21]=db.selectDashboard(dashBoard);
	    actual[14]= db.clickOnAddGadgetSymbol();
	    actual[15]=db.addGadget(gadgetName);
	    
	    actual[16]=db.configureTestAutomationDistributionGadget(project, release, refreshRate, typeName, value);
	    
		}
		  catch(Exception e)
			{
		  
		     lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		  	Relogin_TPE rl=new Relogin_TPE();
		  	rl.reLogin();
		  	throw e;
			}  
	}
	
	

	@Then("^Test Automation Distribution Gadget by tag Added successfully$")
	public void test_Automation_Distribution_Gadget_by_tag_Added_successfully() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 5);
		actual[17]=db.validateGadget(gadgetName);
		}
		catch(Exception e)
		{

		lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}  
	}
	@When("^user add Test Automation Distribution Gadget by selecting fifty tag$")
	public void user_add_Test_Automation_Distribution_Gadget_by_selecting_fifty_tag() throws Throwable {
		try
		{
	  //  String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 1);
	  
	  //gadget fields
	    String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 5);
	   String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 6);
	  String typeName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 7);
	  String[] value=new String[50];
	  for(int i=0;i<=value.length-1;i++)
	  {
	  value[i]=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", i+1, 11);
	  }
	   ///actual[21]=db.selectDashboard(dashBoard);
	    actual[18]= db.clickOnAddGadgetSymbol();
	    actual[19]=db.addGadget(gadgetName);
	    
	    actual[20]=db.configureTestAutomationDistributionGadget(project, release, refreshRate, typeName, value);
	    
		}
		  catch(Exception e)
			{
		  
		     lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		  	Relogin_TPE rl=new Relogin_TPE();
		  	rl.reLogin();
		  	throw e;
			}  
	}
	
	@Then("^Test Automation Distribution Gadget by Tag added successfully$")
	public void test_Automation_Distribution_Gadget_by_Tag_added_successfully() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 5);
		actual[21]=db.validateGadget(gadgetName);
		}
		catch(Exception e)
		{

		lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}  
	}

	@When("^user add Test Automation Distribution Gadget by selecting hundered tag$")
	public void user_add_Test_Automation_Distribution_Gadget_by_selecting_hundered_tag() throws Throwable {
		try
		{
	    //String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 1);
	  
	  //gadget fields
	    String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 5);
	   String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 6);
	  String typeName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 7);
	  String[] value=new String[100];
	  for(int i=0;i<=value.length-1;i++)
	  {
	  value[i]=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", i+1, 11);
	  }
	   // actual[21]=db.selectDashboard(dashBoard);
	    actual[22]= db.clickOnAddGadgetSymbol();
	    actual[23]=db.addGadget(gadgetName);
	    
	    actual[24]=db.configureTestAutomationDistributionGadget(project, release, refreshRate, typeName, value);
	    
		}
		  catch(Exception e)
			{
		  
		     lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		  	Relogin_TPE rl=new Relogin_TPE();
		  	rl.reLogin();
		  	throw e;
			}  
	}
	
	@Then("^Test Automation Distribution Gadget by Tag Added successfully$")
	public void test_Automation_Distribution_Gadget_by_Tag_Added_successfully() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 9, 5);
		actual[25]=db.validateGadget(gadgetName);
		
		
		pp.backToProjectPage();
		for(int k=0;k<=actual.length-1;k++)
		{
			//System.out.println("Actual["+k+"]="+actual[k]);
			soft.assertEquals(actual[k], true);
		}
		soft.assertAll();	
		}
		catch(Exception e)
		{

		lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}  
	}
}
