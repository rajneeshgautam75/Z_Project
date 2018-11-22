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

public class Project_Status_Gadget_15 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	DashBoardPage db;
	
	String fileName="Project_Status_Gadget_15";
	 boolean[] actual=new boolean[62];
		SoftAssert soft=new SoftAssert();
	

	
		@Given("^Login as Manager Role$")
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

		@When("^Manager Click on dashboard$")
		public void manager_Click_on_dashboard() throws Throwable {
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

		@Then("^dashboard Page Should be_displayed$")
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

		@When("^manager creates a new Dashboard$")
		public void manager_creates_a_new_Dashboard() throws Throwable {

			try
			{
			 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 36, 1);
			   String description=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 36, 2);
			   String layout=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 36, 3);
			   String shareType=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 36, 4);
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

		@Then("^dashboard should be Created successfully$")
		public void dashboard_should_be_Created_successfully() throws Throwable {
			try
			{
			String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 36, 1);
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

		@When("^manager add project status gadget and save it$")
		public void manager_add_project_status_gadget_and_save_it() throws Throwable {
			try
			   {
					String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 36, 1);
					  String gadgetName=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 36, 5);
					  actual[9]=db.selectDashboard(dashBoard);
					  actual[10]=db.clickOnAddGadgetSymbol();
			 
			   
					  actual[11]=db.addGadget(gadgetName);
					  
					  String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
						actual[12]=db.configureProjectStatusGadget(projectName);
						db.saveGadget();
			   
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

		@Then("^project status gadget should be saved$")
		public void project_status_gadget_should_be_saved() throws Throwable {
			try
			{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
			actual[13]=db.validateSavedGadget(projectName);
			
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

		@When("^manager edit the project status gadget by selecting another assigned project$")
		public void manager_edit_the_project_status_gadget_by_selecting_another_assigned_project() throws Throwable {
			try
			{
			String value=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 36, 12);
			actual[14]=db.gadgetOperation(value);
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
			actual[15]=db.configureProjectStatusGadget(projectName);
			db.saveGadget();
		
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

		@Then("^should be able to Update the project status gadget$")
		public void should_be_able_to_Update_the_project_status_gadget() throws Throwable {
			try
			{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
			actual[16]=db.validateSavedGadget(projectName);
			
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

		@When("^Lead navigates to Dashboard page$")
		public void lead_navigates_to_Dashboard_page() throws Throwable {
			 try
			  {
				  actual[17]=pp.clickOnLogout();
			   String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_1");
			   String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Password_1");
			   actual[18]=lp.enterUnameAndPassword(userName, passWord);
			   
			   actual[19]=db.clickOnManageDashboards();
			   
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

		@Then("^Dashboard page should be Displayed$")
		public void dashboard_page_should_be_Displayed() throws Throwable {
		    
			 try
			    {
			    	actual[20]=db.validateDashboards();
				
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

		@When("^lead creates a new dashboard$")
		public void lead_creates_a_new_dashboard() throws Throwable {
			try
			{
			 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 37, 1);
			   String description=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 37, 2);
			   String layout=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 37, 3);
			   String shareType=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 37, 4);
			   actual[21]=db.clickOnAddDashBoardSymbol();
			   actual[22]=db.enterDashBoardDetails(name, description, layout, shareType);
			
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

		@Then("^dashboard should be added Succesfully$")
		public void dashboard_should_be_added_Succesfully() throws Throwable {
			try
			{
			 String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 37, 1);
			 actual[23]=db.validateDashBoard(dashBoard);
				
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

		@When("^lead add project status gadget and save it$")
		public void lead_add_project_status_gadget_and_save_it() throws Throwable {

			try
			{
				String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 37, 1);
				String gadgetName=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 37, 5);
				actual[24]=db.selectDashboard(dashBoard);
				actual[25]=db.clickOnAddGadgetSymbol();
				actual[26]=db.addGadget(gadgetName);
			
				 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
				   actual[27]=db.configureProjectStatusGadget(projectName);
				   db.saveGadget();
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
		
		@Then("^Project Status Gadget should be Saved$")
		public void project_Status_Gadget_should_be_Saved() throws Throwable {
			try
			{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
			actual[28]=db.validateSavedGadget(projectName);
			
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

		@When("^lead edit the project status gadget by selecting another assigned project$")
		public void lead_edit_the_project_status_gadget_by_selecting_another_assigned_project() throws Throwable {
			try
			{
			String value=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 37, 12);
			actual[29]=db.gadgetOperation(value);
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
			actual[30]=db.configureProjectStatusGadget(projectName);
			db.saveGadget();
		
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

		@Then("^Should be able to Update the project status gadget$")
		public void should_be_able_to_Update_the_project_status_gadget1() throws Throwable {
			try
			{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
			actual[31]=db.validateSavedGadget(projectName);
			
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

		@When("^Tester navigates to Dashboard page$")
		public void tester_navigates_to_Dashboard_page() throws Throwable {
			try
			{
				actual[32]=pp.clickOnLogout();
			   String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Tester_Username_1");
			   String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Tester_Password_1");
			   actual[33]=lp.enterUnameAndPassword(userName, passWord);
			   
			   actual[34]=db.clickOnManageDashboards();
			   
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

		@Then("^dashboard Page should be Displayed$")
		public void dashboard_Page_should_be_Displayed() throws Throwable {
			 try
			    {
			    	actual[35]=db.validateDashboards();
				
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

		@When("^tester creates a new Dashboard$")
		public void tester_creates_a_new_Dashboard() throws Throwable {

			try
			{
			 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 38, 1);
			   String description=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 38, 2);
			   String layout=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 38, 3);
			   String shareType=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 38, 4);
			   actual[36]=db.clickOnAddDashBoardSymbol();
			   actual[37]=db.enterDashBoardDetails(name, description, layout, shareType);
			
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

		@Then("^dashboard should be Added Succesfully$")
		public void dashboard_should_be_Added_Succesfully() throws Throwable {
			try
			{
			String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 38, 1);
			actual[38]=db.validateDashBoard(dashBoard);
				
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
		
		@When("^tester add project status gadget and save it$")
		public void tester_add_project_status_gadget_and_save_it() throws Throwable {

			try
			{
				String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 38, 1);
				String gadgetName=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 38, 5);
				actual[39]=db.selectDashboard(dashBoard);
				actual[40]=db.clickOnAddGadgetSymbol();
				actual[41]=db.addGadget(gadgetName);
				
				String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
				actual[42]=db.configureProjectStatusGadget(projectName);
				db.saveGadget();
			
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


		@Then("^Project status gadget should be Saved$")
		public void project_status_gadget_should_be_Saved() throws Throwable {
			try
			{
				
				String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
				actual[43]=db.validateSavedGadget(projectName);
			
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

		@When("^tester edit the project status gadget by selecting another assigned project$")
		public void tester_edit_the_project_status_gadget_by_selecting_another_assigned_project() throws Throwable {
			try
			{
			String value=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 38, 12);
			actual[44]=db.gadgetOperation(value);
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
			actual[45]=db.configureProjectStatusGadget(projectName);
			db.saveGadget();
		
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

		@Then("^should be able to update the Project status gadget$")
		public void should_be_able_to_update_the_Project_status_gadget() throws Throwable {
			try
			{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
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
		
		
		@When("^custom user navigates to Dashboard page$")
		public void custom_user_navigates_to_Dashboard_page() throws Throwable {
			try
			{
				actual[47]=pp.clickOnLogout();
			   String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_2");
			   String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Password_2");
			   actual[48]=lp.enterUnameAndPassword(userName, passWord);
			   
			   actual[49]=db.clickOnManageDashboards();
			   
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

		@Then("^dash_board Page should be Displayed$")
		public void dash_board_Page_should_be_Displayed() throws Throwable {
			try
			{
				actual[50]=db.validateDashboards();	
					
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

		@When("^custom user creates a new Dashboard$")
		public void custom_user_creates_a_new_Dashboard() throws Throwable {
			try
			{
			 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 39, 1);
			   String description=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 39, 2);
			   String layout=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 39, 3);
			   String shareType=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 39, 4);
			   actual[51]=db.clickOnAddDashBoardSymbol();
			   actual[52]=db.enterDashBoardDetails(name, description, layout, shareType);
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

		@Then("^dashboard Should be Added Succesfully$")
		public void dashboard_Should_be_Added_Succesfully() throws Throwable {
			try
			{
			String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 39, 1);
			actual[53]=db.validateDashBoard(dashBoard);
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

		@When("^custom user add project status gadget and save it$")
		public void custom_user_add_project_status_gadget_and_save_it() throws Throwable {

			try
			{
				String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 39, 1);
				String gadgetName=Excel_Lib.getData(INPUT_PATH_2,"DashBoard", 39, 5);
				actual[54]=db.selectDashboard(dashBoard);
				actual[55]=db.clickOnAddGadgetSymbol();
				actual[56]=db.addGadget(gadgetName);
				
				String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
				actual[57]=db.configureProjectStatusGadget(projectName);
				db.saveGadget();
			
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

		
		@Then("^Project Status Gadget Should be Saved$")
		public void project_Status_Gadget_Should_be_Saved() throws Throwable {
			try
			{
				
				String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
				actual[58]=db.validateSavedGadget(projectName);
			
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

		@When("^custom user edit the project status gadget by selecting another assigned project$")
		public void custom_user_edit_the_project_status_gadget_by_selecting_another_assigned_project() throws Throwable {
			try
			{
			String value=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 39, 12);
			actual[59]=db.gadgetOperation(value);
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
			actual[60]=db.configureProjectStatusGadget(projectName);
			db.saveGadget();
		
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

		@Then("^Should be able to Update the Project Status gadget$")
		public void should_be_able_to_Update_the_Project_Status_gadget() throws Throwable {
			try
			{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
			actual[61]=db.validateSavedGadget(projectName);
			
			pp.backToProjectPage();
			
			
			
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
		     e.printStackTrace();
		     lb.getScreenShot(fileName);
		     driver.close();
		     Relogin_TPE rl=new Relogin_TPE();
		     rl.reLogin();
		     throw e;
		   }   
		}
}
