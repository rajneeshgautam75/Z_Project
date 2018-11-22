package com.zephyr_batch_3.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Requirement_3 extends LaunchBrowser {
	
	 LaunchBrowser lb=new LaunchBrowser();
	    String fileName="Requirement_3";
	    
		BasePage bp;
		ProjectPage pp;
		ReleasePage rrp;
		RequirementsPage rp;
		TestRepositoryPage tr;
		
		boolean actual[]=new boolean[19];
		SoftAssert soft=new SoftAssert();
		
		private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Normal_Project_1");
		private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
		private String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 3, 0);
		private String system=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 4, 0);
		private String testCaseNo=Excel_Lib.getData(INPUT_PATH_5,"Req", 1, 5);
		
	@Given("^User is in Requirement_Page of normal_Project$")
	public void user_is_in_Requirement_Page_of_normal_Project() throws Throwable {
		try
		{
			bp=new BasePage();
			pp=new ProjectPage(driver);
			rrp=new ReleasePage(driver);
			actual[0]=pp.selectProject(project);
			actual[1]=pp.selectRelease(release);
			actual[2]=rrp.clickOnRequirements();
			actual[3]=bp.waitForElement();	
		}
		catch(Exception e)
		{
		   e.printStackTrace();
		   lb.getScreenShot(fileName);
		   driver.close();
		   Relogin_TPE rl=new Relogin_TPE();
		   rl.reLogin();
		   throw e;
		}
		}

	@When("^As lead, create a phase and system in RequirementPage$")
	public void as_lead_create_a_phase_and_system_in_RequirementPage() throws Throwable {
	    try
	   {
	    	tr=new TestRepositoryPage(driver);
	    	rp=new RequirementsPage(driver);
		    actual[4]=tr.clickOnRelease(release);
		    actual[5]=rp.addNode(phase, phase);
		    bp.waitForElement();
			String [] node =new String[1];
			node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 3, 0);
		    actual[6]=tr.navigateToNode(release, node);
		    tr.selectPhase(phase);
		    actual[7]=rp.addNode(system, system);
		    bp.waitForElement();
	   }
	    catch(Exception e)
	  {
	      e.printStackTrace();
	      lb.getScreenShot(fileName);
	      driver.close();
	      Relogin_TPE rl=new Relogin_TPE();
	      rl.reLogin();
	      throw e;
	}
	}

	@When("^Add few requirements at different level of node$")
	public void add_few_requirements_at_different_level_of_node() throws Throwable {
		 try
		   {
			 tr=new TestRepositoryPage(driver);
			 String [] node =new String[1];
			 node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 3, 0);
			 actual[8]=tr.navigateToNode(release, node);
			 actual[9]=rp.addRequirement();
			 bp.waitForElement();
			 String [] system1 =new String[2];
			 system1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 3, 0);
			 system1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 4, 0);
			 actual[10]=tr.navigateToNode(release, system1);
			 actual[11]=rp.addRequirement();
			 bp.waitForElement();
		   }
		    catch(Exception e)
		  {
		      e.printStackTrace();
		      lb.getScreenShot(fileName);
		      driver.close();
		      Relogin_TPE rl=new Relogin_TPE();
		      rl.reLogin();
		      throw e;
		}  
	}

	@Then("^requirements should be added at different level of node$")
	public void requirements_should_be_added_at_different_level_of_node() throws Throwable {
		 try
		   {
			 String [] node =new String[1];
			 node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 3, 0);
			 actual[10]=tr.navigateToNode(release, node); 
			 actual[11]=rp.VerifyRequirementCount();
			 bp.waitForElement();
			 String [] system1 =new String[2];
			 system1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 3, 0);
			 system1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 4, 0);
			 actual[12]=tr.navigateToNode(release, system1);
			 actual[13]=rp.VerifyRequirementCount();
			 bp.waitForElement();
			 
		   }
		    catch(Exception e)
		  {
		      e.printStackTrace();
		      lb.getScreenShot(fileName);
		      driver.close();
		      Relogin_TPE rl=new Relogin_TPE();
		      rl.reLogin();
		      throw e;
		}   
	}

	@When("^Edit the requirements details by updating Link,priority,atl id details and save$")
	public void edit_the_requirements_details_by_updating_Link_priority_atl_id_details_and_save() throws Throwable {
		 try
		   {
			 String [] node =new String[1];
			 node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 3, 0);
			 actual[14]=tr.navigateToNode(release, node);
			 bp.waitForElement();
			 String [] testCase1=new String[1];
			 testCase1[0]=testCaseNo;
			 actual[15]=rp.selectMultipleRequirementFromGrids(testCase1);
			 bp.waitForElement();
			 tr.clickOnDetails();
			 String name =Excel_Lib.getData(INPUT_PATH_5, "Req", 100, 100);
			 String altID =Excel_Lib.getData(INPUT_PATH_5, "Req", 2, 14);
			 String link =Excel_Lib.getData(INPUT_PATH_5, "Req", 1, 15);
			 String priority =Excel_Lib.getData(INPUT_PATH_5, "Req", 5, 12);
			 String Description =Excel_Lib.getData(INPUT_PATH_5, "Req", 100, 100);
			 actual[16]=rp.enterRequirementDetails(name, altID, link, priority, Description);
			 bp.waitForElement();
			 tr.clickOnList();
			 String [] system1 =new String[2];
			 system1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 3, 0);
			 system1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 4, 0);
			 actual[10]=tr.navigateToNode(release, system1);
			 bp.waitForElement();
			 actual[17]=rp.selectMultipleRequirementFromGrids(testCase1);
			 bp.waitForElement();
			 tr.clickOnDetails();
			 actual[18]=rp.enterRequirementDetails(name, altID, link, priority, Description);
			 bp.waitForElement();
			 tr.clickOnList();
		   }
		    catch(Exception e)
		  {
		      e.printStackTrace();
		      lb.getScreenShot(fileName);
		      driver.close();
		      Relogin_TPE rl=new Relogin_TPE();
		      rl.reLogin();
		      throw e;
		}  
	}

	@Then("^requirements details should be updated$")
	public void requirements_details_should_be_updated() throws Throwable {
		 try
		   {
			System.out.println("Requirement details updated successfully");
		   }
		    catch(Exception e)
		  {
		      e.printStackTrace();
		      lb.getScreenShot(fileName);
		      driver.close();
		      Relogin_TPE rl=new Relogin_TPE();
		      rl.reLogin();
		      throw e;
		}   
	}

	@When("^Edit the requirements details by updating Link,priority,atl id details and click on cancel$")
	public void edit_the_requirements_details_by_updating_Link_priority_atl_id_details_and_click_on_cancel() throws Throwable {
		 try
		   {
			 tr=new TestRepositoryPage(driver);
			 rp=new RequirementsPage(driver);
			 String [] node =new String[1];
			 node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 3, 0);
			 actual[14]=tr.navigateToNode(release, node);
			 bp.waitForElement();
			 String [] testCase1=new String[1];
			 testCase1[0]=testCaseNo;
			 actual[15]=rp.selectMultipleRequirementFromGrids(testCase1);
			 bp.waitForElement();
			 tr.clickOnDetails();
			 String altID =Excel_Lib.getData(INPUT_PATH_5, "Req", 3, 14);
			 String link =Excel_Lib.getData(INPUT_PATH_5, "Req", 2, 15);
			 actual[16]=rp.cancelRequirementDetails(altID, link);
			 bp.waitForElement();
			 tr.clickOnList();
			 String [] system1 =new String[2];
			 system1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 3, 0);
			 system1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 4, 0);
			 actual[10]=tr.navigateToNode(release, system1);
			 bp.waitForElement();
			 actual[17]=rp.selectMultipleRequirementFromGrids(testCase1);
			 bp.waitForElement();
			 tr.clickOnDetails();
			 actual[18]=rp.cancelRequirementDetails(altID, link);
			 bp.waitForElement();
			 tr.clickOnList();
		   }
		    catch(Exception e)
		  {
		      e.printStackTrace();
		      lb.getScreenShot(fileName);
		      driver.close();
		      Relogin_TPE rl=new Relogin_TPE();
		      rl.reLogin();
		      throw e;
		}   
	}

	@Then("^requirement details should not be modified$")
	public void requirement_details_should_not_be_modified() throws Throwable {
		 try
		   {
			System.out.println("Requirement details were not modified");
			for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
				soft.assertEquals(actual[k], true);	
			}
			soft.assertAll();
		   }
		    catch(Exception e)
		  {
		      e.printStackTrace();
		      lb.getScreenShot(fileName);
		      driver.close();
		      Relogin_TPE rl=new Relogin_TPE();
		      rl.reLogin();
		      throw e;
		}   
	}	
	
	
}
