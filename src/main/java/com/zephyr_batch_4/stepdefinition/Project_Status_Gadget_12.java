package com.zephyr_batch_4.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.pom.DashBoardPage_POM;
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

public class Project_Status_Gadget_12 extends LaunchBrowser{

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
	String fileName="Project_Status_Gadget_12";
	
	boolean[] actual=new boolean[15];
	 SoftAssert soft=new SoftAssert();
	 
	 String[] str=new String[5];
	 String[] str2=new String[5];
	@Given("^As an Lead,Launch DashBoard window$")
	public void as_an_Lead_Launch_DashBoard_window() throws Throwable {
		try
	    {
			 pp=new ProjectPage(driver);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			 pp.backToProjectPage();//
			 pp.selectProject(projectName);
			 
			   dbp=new DashBoardPage(driver);
			   String projectReleases=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,38);
			   WebElement ele=driver.findElement(By.xpath(dbp.projectStatusVal1+projectReleases+dbp.projectStatusVal2));
			   String text1=ele.getText();
			   String projectInprogress=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,38);
			   WebElement ele2=driver.findElement(By.xpath(dbp.projectStatusVal1+projectInprogress+dbp.projectStatusVal2));
			   String text2=ele2.getText();
			   
			   String projectTestCases=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,38);
			   WebElement ele3=driver.findElement(By.xpath(dbp.projectStatusVal1+projectTestCases+dbp.projectStatusVal2));
			   String text3=ele3.getText();
			   
			   String projectExecutions=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,38);
			   WebElement ele4=driver.findElement(By.xpath(dbp.projectStatusVal1+projectExecutions+dbp.projectStatusVal2));
			   String text4=ele4.getText();
			   
			   String projectMembers=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,38);
			   WebElement ele5=driver.findElement(By.xpath(dbp.projectStatusVal1+projectMembers+dbp.projectStatusVal2));
			   String text5=ele5.getText();
			  
			   str[0]=text1;
			   str[1]=text2;
			   str[2]=text3;
			   str[3]=text4;
			   str[4]=text5;
			   for(int i=0;i<str.length;i++)
			   {
			   System.out.println(str[i]);
			   }
			 
			 
			dbp=new DashBoardPage(driver);
			bp=new BasePage();
			actual[0]=dbp.clickOnManageDashboards();
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

	@When("^create a DashBoard by clicking on dashboard add symbol$")
	public void create_a_DashBoard_by_clicking_on_dashboard_add_symbol() throws Throwable {
		try
		{
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
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

	@When("^Add DashBoard with given fields$")
	public void add_DashBoard_with_given_fields() throws Throwable {
		try
		{
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,37);
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

	@When("^Add Project Status Gadget by clicking on plus add gadget plus symbol$")
	public void add_Project_Status_Gadget_by_clicking_on_plus_add_gadget_plus_symbol() throws Throwable {
		try
	    {
	    	String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,37);
	    	actual[3]=dbp.selectDashboard(dashboardName);
	    	actual[4]=dbp.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,6); 
			actual[5]=dbp.addGadget(gadgetName);
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

	@Then("^Should be able validate the project status gadget$")
	public void should_be_able_validate_the_project_status_gadget() throws Throwable {
		try
	    {
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,6); 
			actual[6]=dbp.validateGadget(gadgetName);
			
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			actual[7]=dbp.configureProjectStatusGadget(projectName);
			
			dbp.saveGadget();
			
			String gadgetReleases=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,38); 
			actual[8]=dbp.validateProjectStatusGadgetDetails(gadgetReleases);
			
			String gadgetInprogress=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,38); 
			actual[9]=dbp.validateProjectStatusGadgetDetails(gadgetInprogress);
			
			String gadgetTestCases=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,38); 
			actual[10]=dbp.validateProjectStatusGadgetDetails(gadgetTestCases);
			
			String gadgetExecutions=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,38); 
			actual[11]=dbp.validateProjectStatusGadgetDetails(gadgetExecutions);
			
			String gadgetMembers=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,38); 
			actual[12]=dbp.validateProjectStatusGadgetDetails(gadgetMembers);
			
			   dbp=new DashBoardPage(driver);
			   WebElement ele=driver.findElement(By.xpath(dbp.projectStatusVal1+gadgetReleases+dbp.projectStatusVal2));
			   String text11=ele.getText();

			   WebElement ele2=driver.findElement(By.xpath(dbp.projectStatusVal1+gadgetInprogress+dbp.projectStatusVal2));
			   String text22=ele2.getText();
			   
			   WebElement ele3=driver.findElement(By.xpath(dbp.projectStatusVal1+gadgetTestCases+dbp.projectStatusVal2));
			   String text33=ele3.getText();
			   
			   WebElement ele4=driver.findElement(By.xpath(dbp.projectStatusVal1+gadgetExecutions+dbp.projectStatusVal2));
			   String text44=ele4.getText();
			   
			   WebElement ele5=driver.findElement(By.xpath(dbp.projectStatusVal1+gadgetMembers+dbp.projectStatusVal2));
			   String text55=ele5.getText();
			  
			   str2[0]=text11;
			   str2[1]=text22;
			   str2[2]=text33;
			   str2[3]=text44;
			   str2[4]=text55;
			   for(int k=0;k<str2.length;k++)
			   {
			   System.out.println(str2[k]);
			   }
			
			if(str2[0].equals(str[0]) && str2[1].equals(str[1]) && str2[2].equals(str[2]) && str2[3].equals(str[3]) || str2[4].equals(str[4]))
			{
				System.out.println("Pass-Release,InProgress,Testcases,Executions,Members are matched and verified");
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
	
	@When("^click on project status gadget$")
	public void click_on_project_status_gadget() throws Throwable {
		try
		{
		 String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,6);	
	     WebElement ele=driver.findElement(By.xpath(dbp.validateGadget1+gadgetName+dbp.validateGadget2));	
		 ele.click();
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

	@Then("^project status gadget icon is not clickable$")
	public void project_status_gadget_icon_is_not_clickable() throws Throwable {
		try
		{
		 dbp=new DashBoardPage(driver);	
		 String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,6);	
		 actual[13]=dbp.validateGadget(gadgetName);
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

	@When("^view and verify,project status gadget name and description$")
	public void view_and_verify_project_status_gadget_name_and_description() throws Throwable {
		try
		{
		 String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,37);
		 String dashBoardDesc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
	     dbp.verifyDashBoardDetails(dashBoardName, dashBoardDesc);
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

	@Then("^name and description of project status gadget should be proper$")
	public void name_and_description_of_project_status_gadget_should_be_proper() throws Throwable {
		try
		{
		 String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,37);
		 String dashBoardDesc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",1,3);
	     actual[14]=dbp.verifyDashBoardDetails(dashBoardName, dashBoardDesc);
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
