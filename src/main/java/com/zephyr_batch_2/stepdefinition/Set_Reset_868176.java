package com.zephyr_batch_2.stepdefinition;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Set_Reset_868176 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tl;
	ExecutionPage epp;
	String fileName="Set_Reset_868176";
	boolean[] actual=new boolean[68];
	 SoftAssert soft=new SoftAssert();
	@Given("^user in repository phase to create phases$")
	public void user_in_repository_phase_to_create_phases() throws Throwable 
	{
		try
		   {
			   pp=new ProjectPage(driver);
			   //String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,0);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			   actual[0]=pp.selectProject(projectName);
			   bp=new BasePage();
			   bp.waitForElement();
			   actual[1]=pp.selectRelease(releaseName);
			   bp.waitForElement();
			   rp= new ReleasePage(driver);
			   actual[2]=rp.clickOnTestRep();
			   bp.waitForElement();
			   tr=new TestRepositoryPage(driver);
			   actual[3]=tr.doubleClickOnRelease(releaseName);
			   bp.waitForElement(); 
		   }
		   catch (Exception e) 
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

	@Given("^create four phases$")
	public void create_four_phases() throws Throwable 
	{
		try
		{
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 59, 0);
			String nodeDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 59, 1);
			actual[4]=tr.addNode(nodeName, nodeDesc);
			 bp.waitForElement();
			 
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			 actual[5]=tr.doubleClickOnRelease(releaseName);
			 bp.waitForElement();
			 String nodeName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 59, 2);
				String nodeDesc2=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 59, 3);
				actual[4]=tr.addNode(nodeName2, nodeDesc2);
				 bp.waitForElement();
				 
				 actual[5]=tr.doubleClickOnRelease(releaseName);
				 
				 String nodeName3=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 59, 4);
					String nodeDesc3=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 59, 5);
					actual[4]=tr.addNode(nodeName3, nodeDesc3);
					 bp.waitForElement();
				 
				 actual[5]=tr.doubleClickOnRelease(releaseName);
				 
				 String nodeName4=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 59, 6);
					String nodeDesc4=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 59, 7);
					actual[4]=tr.addNode(nodeName4, nodeDesc4);
					 bp.waitForElement();
		  }
		   catch (Exception e) 
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

	@When("^launch test planning crete cycle and add phase to cycle$")
	public void launch_test_planning_crete_cycle_and_add_phase_to_cycle() throws Throwable 
	{
		try
		{
				actual[35]=rp.clickOnTestPlanning();
			    bp.waitForElement();
			    
			    tl=new TestPlanningPage(driver);
			    actual[36]=tl.clickOnAddTestCycleSymbol();
			    bp.waitForElement();
			    //creating cicle 1
				String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 49, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 1);
				String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 2);
				String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
				actual[37]=tl.CreateCycle(cyclename, Build, Environment,hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
				String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
				String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
				actual[38]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				
				actual[39]=tl.saveTestCycle();
				bp.waitForElement();
				
			   String cyclename1[]=new String[1];
				cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 49, 0);
				actual[40]=tl.navigateToCycle(cyclename1);
				bp.waitForElement();
		  }
		   catch (Exception e) 
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

	@When("^search for phases which are in asending order$")
	public void search_for_phases_which_are_in_asending_order() throws Throwable 
	{
		try
		{
		   tl.options.click();
		   bp.waitForElement();
		   tl.addphase.click();
		   bp.waitForElement();
		  // tl.addPhaseToCycle(Phase);
		 }
		   catch (Exception e) 
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

	@Then("^All phases should be sorted in choose existing phase drop down while adding phase to cycle$")
	public void all_phases_should_be_sorted_in_choose_existing_phase_drop_down_while_adding_phase_to_cycle() throws Throwable 
	{
		try
		{
		  Select osel=new Select(tl.addphaseToCycle);
		   List<WebElement> list=osel.getOptions();
		   for(WebElement we:list)
		   {
			   System.out.println(we.getText());
		   }
		   driver.findElement(By.xpath("(//button[text()='Cancel'])[2]")).click();
		}
	   catch (Exception e) 
		{
		   lb=new LaunchBrowser();
	        lb.getScreenShot(fileName);
		   e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		} 
}}