package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Project_Status_Gadget_16 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	DashBoardPage db;
	
	String fileName="Project_Status_Gadget_16";
	 boolean[] actual=new boolean[66];
		SoftAssert soft=new SoftAssert();
	
	
	@Given("^login as Manager Role$")
	public void login_as_Manager_Role() throws Throwable {
		try
		{
		   pp=new ProjectPage(driver);
		   lp=new LoginPage(driver);
		   String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Manager_Username_1");
		   String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Manager_Password_1");
		   
		   actual[0]=pp.clickOnLogout();
		   actual[1]=lp.enterUname(userName);
		   actual[2]=lp.enterPass(passWord);
		   actual[3]=lp.clickOnLogin();
		   
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}

	@When("^manager clicks on dashboard$")
	public void manager_clicks_on_dashboard() throws Throwable {
		try
		{
		db=new DashBoardPage(driver);
		actual[4]=db.clickOnManageDashboards();
		   
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }  
	}

	@Then("^Dashboard Page Should be_displayed$")
	public void dashboard_Page_Should_be_displayed() throws Throwable {
		try
		{
			actual[5]=db.validateDashboards();
		
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}

	@When("^Manager creates a new Dashboard$")
	public void manager_creates_a_new_Dashboard() throws Throwable {

		try
		{
		 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 40, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 40, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 40, 3);
		   String shareType=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 40, 4);
		   actual[6]=db.clickOnAddDashBoardSymbol();
		   actual[7]=db.enterDashBoardDetails(name, description, layout, shareType);
		
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}

	@Then("^Dashboard should be Created successfully$")
	public void dashboard_should_be_Created_successfully() throws Throwable {
		try
		{
		String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 40, 1);
		actual[8]=db.validateDashBoard(dashBoard);
		
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}

	@When("^Manager add project status gadget and save it$")
	public void manager_add_project_status_gadget_and_save_it() throws Throwable {
		try
		   {
				String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 40, 1);
				  String gadgetName=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 40, 5);
				  actual[9]=db.selectDashboard(dashBoard);
				  actual[10]=db.clickOnAddGadgetSymbol();
		 
		   
				  actual[11]=db.addGadget(gadgetName);
				  
				  String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
					actual[12]=db.configureProjectStatusGadget(projectName);
					actual[13]=db.saveGadget();
		   
		   }
			catch(Exception e)
		   {
		    lb=new LaunchBrowser();
		    e.printStackTrace();
		    lb.getScreenShot(fileName);
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		  }   
	}

	@Then("^Project status gadget should be saved$")
	public void project_status_gadget_should_be_saved() throws Throwable {
		try
		{
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
		actual[14]=db.validateSavedGadget(projectName);
		
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}
	

	@When("^manager edit the project status gadget by selecting another unassigned project$")
	public void manager_edit_the_project_status_gadget_by_selecting_another_unassigned_project() throws Throwable {
		try
		{
		String value=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 40, 12);
		actual[15]=db.gadgetOperation(value);
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_8");
		actual[16]=db.configureProjectStatusGadget(projectName);
		//db.saveGadget();
	
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }  
	}

	@Then("^should not be able to edit the project status gadget$")
	public void should_not_be_able_to_edit_the_project_status_gadget() throws Throwable {
		try
		{
		actual[17]=db.saveGadget();
		
		 }
		catch(Exception e)
	  {
	   lb=new LaunchBrowser();
	   e.printStackTrace();
	   lb.getScreenShot(fileName);
	   driver.close();
	   Relogin_TPE rl=new Relogin_TPE();
	   rl.reLogin();
	   throw e;
	 }   
		
	}

	@When("^Lead navigates to dashboard Page$")
	public void lead_navigates_to_dashboard_Page() throws Throwable {
		try
		  {
			  actual[18]=pp.clickOnLogout();
		   String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_1");
		   String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Password_1");
		   actual[19]=lp.enterUnameAndPassword(userName, passWord);
		   
		   actual[20]=db.clickOnManageDashboards();
		   
		  }
			catch(Exception e)
		  {
		   lb=new LaunchBrowser();
		   e.printStackTrace();
		   lb.getScreenShot(fileName);
		   driver.close();
		   Relogin_TPE rl=new Relogin_TPE();
		   rl.reLogin();
		   throw e;
		 }   
	}

	@Then("^Dashboard page Should be displayed$")
	public void dashboard_page_Should_be_displayed() throws Throwable {

		 try
		    {
		    	actual[21]=db.validateDashboards();
			
		    }
			catch(Exception e)
		    {
		     lb=new LaunchBrowser();
		     e.printStackTrace();
		     lb.getScreenShot(fileName);
		     driver.close();
		     Relogin_TPE rl=new Relogin_TPE();
		     rl.reLogin();
		     throw e;
		   }   
	}

	@When("^Lead creates a new dashboard$")
	public void lead_creates_a_new_dashboard() throws Throwable {
		try
		{
		 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 41, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 41, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 41, 3);
		   String shareType=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 41, 4);
		   actual[22]=db.clickOnAddDashBoardSymbol();
		   actual[23]=db.enterDashBoardDetails(name, description, layout, shareType);
		
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}

	@Then("^Dashboard should be Added Succesfully$")
	public void dashboard_should_be_Added_Succesfully() throws Throwable {
		try
		{
		 String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 41, 1);
		 actual[24]=db.validateDashBoard(dashBoard);
			
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}

	@When("^Lead add project status gadget and save it$")
	public void lead_add_project_status_gadget_and_save_it() throws Throwable {

		try
		{
			String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 41, 1);
			String gadgetName=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 41, 5);
			actual[25]=db.selectDashboard(dashBoard);
			actual[26]=db.clickOnAddGadgetSymbol();
			actual[27]=db.addGadget(gadgetName);
		
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
			   actual[28]=db.configureProjectStatusGadget(projectName);
			   actual[29]=db.saveGadget();
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   

	}

	@Then("^project status Gadget should be Saved$")
	public void project_status_Gadget_should_be_Saved() throws Throwable {
		try
		{
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
		actual[30]=db.validateSavedGadget(projectName);
		
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}

	@When("^lead edit the project status gadget by selecting another unassigned project$")
	public void lead_edit_the_project_status_gadget_by_selecting_another_unassigned_project() throws Throwable {
		try
		{
		String value=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 41, 12);
		actual[31]=db.gadgetOperation(value);
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_8");
		actual[32]=db.configureProjectStatusGadget(projectName);
		//db.saveGadget();
	
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }  
	}
	

	@Then("^Should not be able to Update the project status gadget$")
	public void should_not_be_able_to_Update_the_project_status_gadget() throws Throwable {
		try
		{
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_8");
		actual[33]=db.saveGadget();
		
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}

	@When("^tester navigates to Dashboard page$")
	public void tester_navigates_to_Dashboard_page() throws Throwable {
		try
		{
			actual[34]=pp.clickOnLogout();
		   String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Tester_Username_1");
		   String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Tester_Password_1");
		   actual[35]=lp.enterUnameAndPassword(userName, passWord);
		   
		   actual[36]=db.clickOnManageDashboards();
		   
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}
	

	@Then("^Dashboard page should_be Displayed$")
	public void dashboard_page_should_be_Displayed() throws Throwable {
		 try
		    {
		    	actual[37]=db.validateDashboards();
			
		    }
			catch(Exception e)
		    {
		     lb=new LaunchBrowser();
		     e.printStackTrace();
		     lb.getScreenShot(fileName);
		     driver.close();
		     Relogin_TPE rl=new Relogin_TPE();
		     rl.reLogin();
		     throw e;
		   }   
	}
	@When("^tester create a new Dashboard$")
	public void tester_create_a_new_Dashboard() throws Throwable {
		try
		{
		 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 42, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 42, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 42, 3);
		   String shareType=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 42, 4);
		   actual[38]=db.clickOnAddDashBoardSymbol();
		   actual[39]=db.enterDashBoardDetails(name, description, layout, shareType);
		
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}

	@Then("^dashboard should be added success_fully$")
	public void dashboard_should_be_added_success_fully() throws Throwable {
		try
		{
		String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 42, 1);
		actual[40]=db.validateDashBoard(dashBoard);
			
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   

	}

	@When("^tester add project status Gadget and save it$")
	public void tester_add_project_status_Gadget_and_save_it() throws Throwable {

		try
		{
			String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 42, 1);
			String gadgetName=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 42, 5);
			actual[41]=db.selectDashboard(dashBoard);
			actual[42]=db.clickOnAddGadgetSymbol();
			actual[43]=db.addGadget(gadgetName);
			
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
			actual[44]=db.configureProjectStatusGadget(projectName);
			actual[45]=db.saveGadget();
		
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   

	}

	@Then("^Project status Gadget should be Saved$")
	public void project_status_Gadget_should_be_Saved1() throws Throwable {
		try
		{
			
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
			actual[46]=db.validateSavedGadget(projectName);
		
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   
	}

	@When("^tester edit the project status gadget by selecting another unassigned project$")
	public void tester_edit_the_project_status_gadget_by_selecting_another_unassigned_project() throws Throwable {
		try
		{
		String value=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 42, 12);
		actual[47]=db.gadgetOperation(value);
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_8");
		actual[48]=db.configureProjectStatusGadget(projectName);
		
	
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }  

	}

	@Then("^should not be able to update the Project status gadget$")
	public void should_not_be_able_to_update_the_Project_status_gadget() throws Throwable {
		actual[49]=db.saveGadget();
	}

	@When("^Custom User navigates to Dashboard page$")
	public void custom_User_navigates_to_Dashboard_page() throws Throwable {
		try
		{
			actual[50]=pp.clickOnLogout();
		   String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_2");
		   String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Password_2");
		   actual[51]=lp.enterUnameAndPassword(userName, passWord);
		   
		   actual[52]=db.clickOnManageDashboards();
		   
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   

	}

	@Then("^dashboard Page should be_Displayed$")
	public void dashboard_Page_should_be_Displayed() throws Throwable {
		try
		{
			actual[53]=db.validateDashboards();	
				
		}
		catch(Exception e)
		{
		 lb=new LaunchBrowser();
		 e.printStackTrace();
		 lb.getScreenShot(fileName);
		 driver.close();
		 Relogin_TPE rl=new Relogin_TPE();
		 rl.reLogin();
		 throw e;
		}   
	
	}

	@When("^Custom user creates a new Dashboard$")
	public void custom_user_creates_a_new_Dashboard() throws Throwable {
		try
		{
		 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 43, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 43, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 43, 3);
		   String shareType=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 43, 4);
		   actual[54]=db.clickOnAddDashBoardSymbol();
		   actual[55]=db.enterDashBoardDetails(name, description, layout, shareType);
		}
		catch(Exception e)
		{
		 lb=new LaunchBrowser();
		 e.printStackTrace();
		 lb.getScreenShot(fileName);
		 driver.close();
		 Relogin_TPE rl=new Relogin_TPE();
		 rl.reLogin();
		 throw e;
		}   

	}

	@Then("^dashboard Should be Added Successfully$")
	public void dashboard_Should_be_Added_Successfully() throws Throwable {
		try
		{
		String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 43, 1);
		actual[56]=db.validateDashBoard(dashBoard);
		}
		catch(Exception e)
		{
		 lb=new LaunchBrowser();
		 e.printStackTrace();
		 lb.getScreenShot(fileName);
		 driver.close();
		 Relogin_TPE rl=new Relogin_TPE();
		 rl.reLogin();
		 throw e;
		}   

	}

	@When("^Custom user add project status gadget and save it$")
	public void custom_user_add_project_status_gadget_and_save_it() throws Throwable {
		try
		{
			String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 43, 1);
			String gadgetName=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 43, 5);
			actual[57]=db.selectDashboard(dashBoard);
			actual[58]=db.clickOnAddGadgetSymbol();
			actual[59]=db.addGadget(gadgetName);
			
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
			actual[60]=db.configureProjectStatusGadget(projectName);
			actual[61]=db.saveGadget();
		
		}
		catch(Exception e)
		{
		 lb=new LaunchBrowser();
		 e.printStackTrace();
		 lb.getScreenShot(fileName);
		 driver.close();
		 Relogin_TPE rl=new Relogin_TPE();
		 rl.reLogin();
		 throw e;
		}   

	}

	@Then("^Project Status gadget Should be Saved$")
	public void project_Status_gadget_Should_be_Saved() throws Throwable {
		try
		{
			
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
			actual[62]=db.validateSavedGadget(projectName);
		
		}
		catch(Exception e)
	    {
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }
	}
	
	@When("^Custom user edit the project status gadget by selecting another uassigned project$")
	public void custom_user_edit_the_project_status_gadget_by_selecting_another_uassigned_project() throws Throwable {
		try
		{
		String value=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 43, 12);
		actual[63]=db.gadgetOperation(value);
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_8");
		actual[64]=db.configureProjectStatusGadget(projectName);
		//db.saveGadget();
	
	}
	catch(Exception e)
    {
     lb=new LaunchBrowser();
     e.printStackTrace();
     lb.getScreenShot(fileName);
     driver.close();
     Relogin_TPE rl=new Relogin_TPE();
     rl.reLogin();
     throw e;
   }  
	}

	

	@Then("^Should not be able to Update the Project Status gadget$")
	public void should_not_be_able_to_Update_the_Project_Status_gadget() throws Throwable {
		try
		{
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_8");
		actual[65]=db.saveGadget();
		
		
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
	     lb=new LaunchBrowser();
	     e.printStackTrace();
	     lb.getScreenShot(fileName);
	     driver.close();
	     Relogin_TPE rl=new Relogin_TPE();
	     rl.reLogin();
	     throw e;
	   }   

	}
	
}
