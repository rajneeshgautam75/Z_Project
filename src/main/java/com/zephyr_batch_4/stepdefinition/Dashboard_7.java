package com.zephyr_batch_4.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Dashboard_7 extends LaunchBrowser  {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	boolean[] actual=new boolean[23];
	SoftAssert soft=new SoftAssert();
	String fileName="Dashboard_7";
	
	@Given("^user is in a dashboard Page$")
	public void user_is_in_a_dashboard_Page() throws Throwable {
		try
		{
		pp=new ProjectPage(driver);
		dp=new DashBoardPage(driver);
		bp=new BasePage();
		actual[0]=bp.waitForElement();
		actual[1]=dp.clickOnManageDashboards();
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

	@When("^User adds a new dashboard$")
	public void user_adds_a_new_dashboard() throws Throwable {
		 try
		   {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
		   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
		   bp.waitForElement();
		   actual[2]=dp.clickOnAddDashBoardSymbol();
		   actual[3]=dp.enterDashBoardDetails(name, description, layout, shareType);
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

	@Then("^dashboard  should be added$")
	public void dashboard_should_be_added() throws Throwable {
		try
		  {
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 1);
		    actual[4]=dp.validateDashBoard(name);
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

	@When("^user select a dashboard and delete the dashboard on having permission to delete$")
	public void user_select_a_dashboard_and_delete_the_dashboard_on_having_permission_to_delete() throws Throwable {
		try
		{
			 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 1);
			 actual[5]=dp.deleteDashBoard(name);
			
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

	@Then("^should be able to delete a dashboard successfully$")
	public void should_be_able_to_delete_a_dashboard_successfully() throws Throwable {
	   
		try
		{
			 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 1);
			 actual[6]=dp.validateDashBoard(name);
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

	@When("^user adds the new Dashboard$")
	public void user_adds_the_new_Dashboard() throws Throwable {
		try
		   {
		   
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
		   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
		   bp.waitForElement();
		   actual[7]=dp.clickOnAddDashBoardSymbol();
		   actual[8]=dp.enterDashBoardDetails(name, description, layout, shareType);
		   
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

	@Then("^Dashboard Should be added$")
	public void dashboard_Should_be_added() throws Throwable {
		try
		  {
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 1);
		    actual[9]=dp.validateDashBoard(name);
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

	@When("^user select a dashboard have all type of gadgets in it and delete$")
	public void user_select_a_dashboard_have_all_type_of_gadgets_in_it_and_delete() throws Throwable {
		try
		{
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 1);
//		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		actual[10]=dp.selectDashboard(name);
		for(int i=0;i<12;i++)
		{
		String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
		String gadgetName_1=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1+i, 6);
		bp.waitForElement();
		actual[11]=dp.clickOnAddGadgetSymbol(); 
		actual[12]=dp.addGadget(gadgetName_1);
		bp.waitForElement();
		actual[13]=dp.layoutSelection(layout);
		bp.waitForElement();
		}
		bp.waitForElement();
		pp.navigateToProjectPage();
//		pp.selectProject(projectName);
		actual[14]=bp.waitForElement();
		actual[15]=dp.clickOnManageDashboards();
		bp.waitForElement();
		actual[16]=dp.searchDashboard(name);
		bp.waitForElement();
		actual[17]=dp.deleteDashBoard(name);
		
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

	@Then("^should be able to delete a dashboard$")
	public void should_be_able_to_delete_a_dashboard() throws Throwable {
		try
		{
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 1);
			actual[18]=dp.validateDashBoard(name);
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

	@When("^user add a new Dashboard$")
	public void user_add_a_new_Dashboard() throws Throwable {
		try
		   {
		   
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
		   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
		   bp.waitForElement();
		   actual[19]=dp.clickOnAddDashBoardSymbol();
		   actual[20]=dp.enterDashBoardDetails(name, description, layout, shareType);
		  
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

	@Then("^dashboard should be Added$")
	public void dashboard_should_be_Added() throws Throwable {
		try
		  {
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 1);
		    actual[21]=dp.validateDashBoard(name);
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

	@When("^user select a dashboard click on delete icon on confirmation popup click on cancel$")
	public void user_select_a_dashboard_click_on_delete_icon_on_confirmation_popup_click_on_cancel() throws Throwable {
		try{
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 1);
			WebElement ele=driver.findElement(By.xpath(dp.deleteDashBoard1+name+dp.deleteDashBoard2));
			bp.explicitWait(ele);
			Actions act=new Actions(driver);
			act.pause(1200).moveToElement(ele).click().perform();
			bp.waitForElement();
			dp.cancelDeleteDashBoard.click();	
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

	@Then("^deletion should be canceled$")
	public void deletion_should_be_canceled() throws Throwable {
		try
		{
			  String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 1);
			  actual[22]=dp.validateDashBoard(name);
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
