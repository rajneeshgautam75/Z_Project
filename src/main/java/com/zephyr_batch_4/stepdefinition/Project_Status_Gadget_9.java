package com.zephyr_batch_4.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Project_Status_Gadget_9 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	DashBoardPage dbp;
	RequirementsPage req;
	String fileName="Project_Status_Gadget_9";
	
	boolean[] actual=new boolean[8];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^login as Lead,Launch DashBoard page$")
	public void login_as_Lead_Launch_DashBoard_page() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
			bp=new BasePage();
			actual[0]=dbp.clickOnManageDashboards();
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

	@When("^create a DashBoard by clicking on dashBoard plus symbol$")
	public void create_a_DashBoard_by_clicking_on_dashBoard_plus_symbol() throws Throwable {
		try
		{
		actual[1]=dbp.clickOnAddDashBoardSymbol();
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

	@When("^add the DashBoard with its required fields$")
	public void add_the_DashBoard_with_its_required_fields() throws Throwable {
		try
		{
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,37);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[2]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
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

	@When("^add a Project Status gadget by clicking on a add gadget plus symbol$")
	public void add_a_Project_Status_gadget_by_clicking_on_a_add_gadget_plus_symbol() throws Throwable {
		try
	    {
	    	String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,37);
	    	actual[3]=dbp.selectDashboard(dashboardName);
	    	actual[4]=dbp.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,6); 
			actual[5]=dbp.addGadget(gadgetName);
			actual[6]=dbp.validateGadget(gadgetName);
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

	@When("^delete the gadget by an attempt to click on close button$")
	public void delete_the_gadget_by_an_attempt_to_click_on_close_button() throws Throwable {
		try
	    {
			String value=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,13); 
			dbp.gadgetOption.click();
			bp.waitForElement();
			WebElement ele=driver.findElement(By.xpath(dbp.gadgetVal1+value+dbp.gadgetVal2));
			Actions a1=new Actions(driver);
			a1.pause(1200).moveToElement(ele).click().perform();
			bp.waitForElement();
			WebElement deleteConfirm=dbp.deleteConfirmationMsg;
			deleteConfirm.getText();
			System.out.println(deleteConfirm);
			dbp.deleteGadgetCloseButton.click();
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

	@Then("^should not able to delete project status gadget$")
	public void should_not_able_to_delete_project_status_gadget() throws Throwable {
		try
	    {
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,6); 
			actual[7]=dbp.validateGadget(gadgetName);
			
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
