package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ProjectPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Project_Status_Gadget_1 extends LaunchBrowser {
	
	     ProjectPage pp;
	     DashBoardPage db1;
	     BasePage bp;
	     LaunchBrowser lb;
	     boolean[] actual=new boolean[12];
	     SoftAssert soft=new SoftAssert();
	     String fileName="Project_Status_Gadget_1";
	 
	
	 @Given("^User is in Dashboard page$")
	 public void user_is_in_Dashboard_page() throws Throwable {
		 try
	       {
	       db1=new DashBoardPage(driver);
		   bp=new BasePage();
		   actual[0]=db1.clickOnManageDashboards();	
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

	
	@When("^User add a dashBoard by clicking on plus button$")
	public void user_add_a_dashBoard_by_clicking_on_plus_button() throws Throwable {
		 try
		   {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"NewDashboard", 1, 0);
		   String description=Excel_Lib.getData(INPUT_PATH_6,"NewDashboard", 1, 1);
		   String layout=Excel_Lib.getData(INPUT_PATH_6,"NewDashboard", 1, 2);
		   String shareType=Excel_Lib.getData(INPUT_PATH_6,"NewDashboard", 1, 3);
		   bp.waitForElement();
		   actual[1]=db1.clickOnAddDashBoardSymbol();
		   actual[2]=db1.enterDashBoardDetails(name, description, layout, shareType);
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

	@Then("^Should be able to add a new dashboard$")
	public void should_be_able_to_add_a_new_dashboard() throws Throwable {
		  try
		    {
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"NewDashboard", 1, 0);
			actual[3]=db1.validateDashBoard(name);
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
	
	@When("^Click on plus button to add a new gadget$")
	public void click_on_plus_button_to_add_a_new_gadget() throws Throwable {
		  try
	        {
	    	String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6, "NewDashboard",1,0);
	    	actual[4]=db1.selectDashboard(name);
	    	bp.waitForElement();
	    	actual[5]=db1.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_6, "NewDashboard", 1,4); 
			actual[6]=db1.addGadget(gadgetName);
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

	@Then("^plus button should be clickable and gadget page should be opened$")
	public void plus_button_should_be_clickable_and_gadget_page_should_be_opened() throws Throwable {
             
		  try
		    {
		    String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"NewDashboard", 1, 4);
			actual[7]=db1.validateGadget(gadgetName);
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

	@When("^select Project and save the gadget$")
	public void select_Project_and_save_the_gadget() throws Throwable {
	       try
	         {
		     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
		     actual[8]=db1.configureProjectStatusGadget(projectName);
		     bp.waitForElement();
		     db1.saveGadget();
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
	@Then("^Project status gadget should get added$")
	public void project_status_gadget_should_get_added() throws Throwable {
		 try
		   {
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
			actual[9]=db1.validateSavedGadget(projectName);
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
	
	@When("^Add Project status Gadget on Default dashboard layout$")
	public void add_Project_status_Gadget_on_Default_dashboard_layout() throws Throwable{
	       try
	         {
	    	 String layout=Excel_Lib.getData(INPUT_PATH_6,"NewDashboard", 1, 2);
	         actual[10]=db1.layoutSelection(layout);
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
	 @Then("^Should be able to add Project status Gadget on default dashboard layout$")
	 public void should_be_able_to_add_Project_status_Gadget_on_default_dashboard_layout() throws Throwable {
             try
               { 
            	pp=new ProjectPage(driver);
    	        String layout=Excel_Lib.getData(INPUT_PATH_6,"NewDashboard", 1, 2);
    	        actual[11]=db1.layoutSelection(layout); 
    	        for(int k=0;k<=actual.length-1;k++)
    	        {
    		    System.out.println("Actual["+k+"]="+actual[k]);
    		    soft.assertEquals(actual[k], true);
    	        }
    	        pp.backToProjectPage();
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

