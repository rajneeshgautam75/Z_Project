package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_17 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	DefectTracking dt;
	String fileName="Defect_Tracking_17";
	
	boolean[] actual=new boolean[183];
	SoftAssert soft=new SoftAssert();
	 
	private String[] fields=new String[12];
	{
	   for(int i=0;i<=11;i++)
	   {
	   fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   }
	}
	private String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
	private String defectIssueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
	private String defectSubtaskIssueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,31);

	  private String[] ze_Multiple_Select_Field=new String[2];
	  {
	   ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	  }
	   private String[] ze_Multi_Version_field=new String[2];
	   {
	   ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   ze_Multi_Version_field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   }
	   private String[] ze_Multi_User_Picker=new String[2];
	   {
	   ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   ze_Multi_User_Picker[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   }
	   private int[] defectNo=new int[1];
	   {
	   defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1,16);
	   }
	   String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
	   String desc=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,17);
	@Given("^User is in the defect tracking page$")
	public void user_is_in_the_defect_tracking_page() throws Throwable {
		try
		   {
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			 pp=new ProjectPage(driver);
			 bp=new BasePage();
			 rp=new ReleasePage(driver);
			 dt=new DefectTracking(driver);
			 pp.selectProject(projectName);
			 pp.selectRelease(releaseName);
			 actual[0]=pp.clickOnDefectTracking();
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

	@When("^User search the defect and select the defect$")
	public void user_search_the_defect_and_select_the_defect() throws Throwable {
	try
	   {
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,30);
		
		 actual[1]=dt.searchDefect(defectID);
		 actual[2]=dt.selectSingleOrMultipleDefects(defectNo);
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

	@When("^click on edit and update the defect summary$")
	public void click_on_edit_and_update_the_defect_summary() throws Throwable {
	try
	   {
		 //String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
		
		 dt.defectEditButton.click();
		 bp.waitForElement();
		 actual[3]=dt.fileNewDefect(summary,fields[0],fields[1],fields[2],fields[3],fields[4], fields[5], fields[6],fields[7], fields[8], fields[9], fields[10], fields[11]);
		 bp.waitForElement();
		 actual[4]=dt.updateEditDefectWindow();
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
	
	@Then("^Should be able to update the defect summary$")
	public void should_be_able_to_update_the_defect_summary() throws Throwable {
	try
	   {
		 //String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
		
		 actual[5]=dt.validateDefectSummary(summary);
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

	@When("^User search the the defect and click on edit$")
	public void user_search_the_the_defect_and_click_on_edit() throws Throwable {
	try
	   {
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,30);
		
		 actual[6]=dt.searchDefect(defectID);
		 actual[7]=dt.selectSingleOrMultipleDefects(defectNo);
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

	@When("^enter the description field of a defect$")
	public void enter_the_description_field_of_a_defect() throws Throwable {
	try
	   {
		
		 dt.defectEditButton.click();
		 bp.waitForElement();
		 actual[8]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3], fields[4], fields[5],fields[6], fields[7], fields[8], fields[9], fields[10]);
		 actual[9]=dt.updateEditDefectWindow();
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

	@Then("^Should be able to update the defect description$")
	public void should_be_able_to_update_the_defect_description() throws Throwable {
	try
	   {
		 String desc=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,17);
		 String defectname=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,30);
		
		 actual[10]=dt.validateDefect(defectname);
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

	@When("^search the defect and enter the priority$")
	public void search_the_defect_and_enter_the_priority() throws Throwable {
	try
	   {
		 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,6);
		
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,30);
		
		 actual[11]=dt.searchDefect(defectID);
		 actual[12]=dt.selectSingleOrMultipleDefects(defectNo);
		 dt.defectEditButton.click();
		 bp.waitForElement();
		 actual[13]=dt.fileNewDefect(summary,fields[0],fields[1],fields[2],fields[3],priority,fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
		 actual[14]=dt.updateEditDefectWindow();
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

	@Then("^Should be able to update the defect priority$")
	public void should_be_able_to_update_the_defect_priority() throws Throwable {
	try
	   {
		 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 3,6);
		
		 actual[15]=dt.validateDefect(priority);
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

	@When("^search the defect and update the component$")
	public void search_the_defect_and_update_the_component() throws Throwable {
	try
	   {
		 String component=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,19);
		
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,30);
		
		 actual[16]=dt.searchDefect(defectID);
		 actual[17]=dt.selectSingleOrMultipleDefects(defectNo);
		 dt.defectEditButton.click();
		 bp.waitForElement();
		 actual[18]=dt.fileNewDefect(summary,component,fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6],fields[7], fields[8], fields[9], fields[10]);
		 actual[19]=dt.updateEditDefectWindow();
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

	@Then("^Should be able to update the defect component$")
	public void should_be_able_to_update_the_defect_component() throws Throwable {
	try
	   {
		 String component=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 3,19);
		
		 actual[20]=dt.validateDefectComponent(component);
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

	@When("^search the defect and update the version$")
	public void search_the_defect_and_update_the_version() throws Throwable {
	try
	   {
		 String affectsVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,27);
		
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,30);
		
		 actual[21]=dt.searchDefect(defectID);
		 dt.selectSingleOrMultipleDefects(defectNo);
		 dt.defectEditButton.click();
		 bp.waitForElement();
		 actual[22]=dt.fileNewDefect(summary,fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],affectsVersion,fields[10]);
		 dt.updateEditDefectWindow();
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

	@Then("^Should be able to update the defect version$")
	public void should_be_able_to_update_the_defect_version() throws Throwable {
	try
	   {
		 String affectsVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 3,19);
		
		 actual[23]=dt.validateDefectVersions(affectsVersion);
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

	@When("^search the defect and update the fixversion$")
	public void search_the_defect_and_update_the_fixversion() throws Throwable {
		try
		   {
			 String fixVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,27);
			
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,30);
			
			 actual[24]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[25]=dt.fileNewDefect(summary,fields[0],fields[1],fields[2],fixVersion,fields[3],fields[4],fields[5],fields[6], fields[7], fields[8], fields[9], fields[10]);
			 dt.updateEditDefectWindow();
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

	@Then("^Should be able to update the defect fixversion$")
	public void should_be_able_to_update_the_defect_fixversion() throws Throwable {
	try
	   {
		 String fixVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 3,19);
		
		 actual[26]=dt.validateDefectFixVersion(fixVersion);
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

	@When("^search the defect and update the label$")
	public void search_the_defect_and_update_the_label() throws Throwable {
	try
	   {
		 String label=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,27);
		
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,30);
		
		 actual[27]=dt.searchDefect(defectID);
		 dt.selectSingleOrMultipleDefects(defectNo);
		 dt.defectEditButton.click();
		 bp.waitForElement();
		 actual[28]=dt.fileNewDefect(summary,fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],label,fields[6], fields[7], fields[8], fields[9], fields[10]);
		 dt.updateEditDefectWindow();
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

	@Then("^Should be able to update the defect label$")
	public void should_be_able_to_update_the_defect_label() throws Throwable {
	try
	   {
		 String desc=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,17);
		 String defectname=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,30);
		
		 actual[29]=dt.validateDefect(defectname);
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

	@When("^search the defect and update the assignee$")
	public void search_the_defect_and_update_the_assignee() throws Throwable {
	try
	   {
		 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,28);
		
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,30);
		
		 actual[30]=dt.searchDefect(defectID);
		 dt.selectSingleOrMultipleDefects(defectNo);
		 dt.defectEditButton.click();
		 bp.waitForElement();
		 actual[31]=dt.fileNewDefect(summary,fields[0],fields[1],fields[2],fields[3],fields[4],assignee,fields[5],fields[6], fields[7], fields[8], fields[9], fields[10]);
		 dt.updateEditDefectWindow();
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

	@Then("^Should be able to update the defect assignee$")
	public void should_be_able_to_update_the_defect_assignee() throws Throwable {
	try
	   {
		 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,4);
		
		 actual[32]=dt.validateDefectAssignee(assignee);
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

	@When("^search the defect and update the environment$")
	public void search_the_defect_and_update_the_environment() throws Throwable {
	try
	   {
		 String environment=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,22);
		
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,30);
		
		 actual[33]=dt.searchDefect(defectID);
		 dt.selectSingleOrMultipleDefects(defectNo);
		 dt.defectEditButton.click();
		 bp.waitForElement();
		 actual[34]=dt.fileNewDefect(summary,fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],environment, fields[8], fields[9], fields[10]);
		 dt.updateEditDefectWindow();
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

	@Then("^Should be able to update the defect environment$")
	public void should_be_able_to_update_the_defect_environment() throws Throwable {
	try
	   {
		 String environment=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,22);
		
		 actual[35]=dt.validateDefectEnvironment(environment);
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

	@When("^search the defect and update the custom field text$")
	public void search_the_defect_and_update_the_custom_field_text() throws Throwable {
	try
	   {
		 String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,22);
		
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,30);
		
		 actual[36]=dt.searchDefect(defectID);
		 dt.selectSingleOrMultipleDefects(defectNo);
		 dt.defectEditButton.click();
		 bp.waitForElement();
		 actual[37]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],fields[6],fields[7],ze_Multi_User_Picker,ze_Text_Field);
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

	@Then("^Should be able to update the defect custom field text$")
	public void should_be_able_to_update_the_defect_custom_field_text() throws Throwable {
	try
	   {
		
		 actual[38]=dt.validateDefect(project, defectIssueType);
		 bp.waitForElement();
		 actual[39]=dt.updateEditDefectWindow();
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

	@When("^search the defect and update the custom field free text$")
	public void search_the_defect_and_update_the_custom_field_free_text() throws Throwable {
		try
		   {
			 String ze_Free_Text_Field=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
			
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,30);
			
			 actual[40]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[41]=dt.enterDefectCustomFields(ze_Free_Text_Field,fields[0],fields[1],fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
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

	@Then("^Should be able to update the defect custom field free text$")
	public void should_be_able_to_update_the_defect_custom_field_free_text() throws Throwable {
	try
	   {
		
		 actual[42]=dt.validateDefect(project,defectIssueType);
		 bp.waitForElement();
		 actual[43]=dt.updateEditDefectWindow();
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

	@When("^search the defect and update the custom field checkbox$")
	public void search_the_defect_and_update_the_custom_field_checkbox() throws Throwable {
		try
		   {
			 String ze_Checkbox=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,25);
			
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,30);
			
			 actual[44]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[45]=dt.enterDefectCustomFields(fields[0],fields[1],ze_Checkbox,fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
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

	@Then("^Should be able to update the defect custom field checkbox$")
	public void should_be_able_to_update_the_defect_custom_field_checkbox() throws Throwable {
	try
	   {
		
		 actual[46]=dt.validateDefect(project, defectIssueType);
		 bp.waitForElement();
		 actual[47]=dt.updateEditDefectWindow();
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

	@When("^search the defect and update the custom field radio button$")
	public void search_the_defect_and_update_the_custom_field_radio_button() throws Throwable {
		try
		   {
			 String ze_Radio_Field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,23);
//			 String[] fields=new String[9];
//			   for(int i=0;i<=8;i++)
//			   {
//			   fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
//			   }
			
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,30);
			
			 actual[48]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[49]=dt.enterDefectCustomFields(fields[0],ze_Radio_Field,fields[1],fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
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

	@Then("^Should be able to update the defect custom field radio button$")
	public void should_be_able_to_update_the_defect_custom_field_radio_button() throws Throwable {
	try
	   {
		
		 actual[50]=dt.validateDefect(project, defectIssueType);
		 bp.waitForElement();
		 actual[51]=dt.updateEditDefectWindow();
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

	@When("^search the defect and update the custom field Date picker$")
	public void search_the_defect_and_update_the_custom_field_Date_picker() throws Throwable {
		try
		   {
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
			String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));

			
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,30);
			
			 actual[52]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 
			 actual[53]=dt.customDatePicker(syear, smonth, sday);
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

	@Then("^Should be able to update the defect custom field Date picker$")
	public void should_be_able_to_update_the_defect_custom_field_Date_picker() throws Throwable {
	try
	   {
		
		 actual[54]=dt.validateDefect(project, defectIssueType);
		 bp.waitForElement();
		 actual[55]=dt.updateEditDefectWindow();
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

	@When("^search the defect and update the custom field URL$")
	public void search_the_defect_and_update_the_custom_field_URL() throws Throwable {
		try
		   {
			 String ze_URL_Field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,26);
			
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,30);
			
			 actual[56]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[57]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],ze_URL_Field,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
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

	@Then("^Should be able to update the defect custom field URL$")
	public void should_be_able_to_update_the_defect_custom_field_URL() throws Throwable {
	try
	   {
		
		 actual[58]=dt.validateDefect(project, defectIssueType);
		 bp.waitForElement();
		 actual[59]=dt.updateEditDefectWindow();
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

	@When("^search the defect and update the custom field single select$")
	public void search_the_defect_and_update_the_custom_field_single_select() throws Throwable {
		try
		   {
			 String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,29);
			
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,30);
			
			 actual[60]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[61]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,ze_Single_Select_Field,ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
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

	@Then("^Should be able to update the defect custom field single select$")
	public void should_be_able_to_update_the_defect_custom_field_single_select() throws Throwable {
	try
	   {
		
		 actual[62]=dt.validateDefect(project, defectIssueType);
		 bp.waitForElement();
		 actual[63]=dt.updateEditDefectWindow();
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

	@When("^search the defect and update the custom field multi select$")
	public void search_the_defect_and_update_the_custom_field_multi_select() throws Throwable {
		try
		   {
			   String[] ze_Multiple_Select_Field=new String[2];
			   ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,24 );
			   ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,24 );

			
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,30);
			
			 actual[64]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[65]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],fields[6],fields[7],ze_Multi_User_Picker,fields[8]);
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

	@Then("^Should be able to update the defect custom field multi select$")
	public void should_be_able_to_update_the_defect_custom_field_multi_select() throws Throwable {
	try
	   {
		
		 actual[66]=dt.validateDefect(project, defectIssueType);
		 bp.waitForElement();
		 actual[67]=dt.updateEditDefectWindow();
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

	@When("^search the defect and update the custom field version picker$")
	public void search_the_defect_and_update_the_custom_field_version_picker() throws Throwable {
		try
		   {
			 String ze_Single_Version_field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,27);
			
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,30);
			
			 actual[68]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,ze_Single_Version_field,fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
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

	@Then("^Should be able to update the defect custom field version picker$")
	public void should_be_able_to_update_the_defect_custom_field_version_picker() throws Throwable {
	try
	   {
		
		 actual[69]=dt.validateDefect(project, defectIssueType);
		 bp.waitForElement();
		 actual[70]=dt.updateEditDefectWindow();
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

	@When("^search the defect and update the custom field multiple version picker$")
	public void search_the_defect_and_update_the_custom_field_multiple_version_picker() throws Throwable {
		try
		   {
			   String[] ze_Multi_Version_field=new String[2];
			   ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,27 );
			   ze_Multi_Version_field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,27);
			   
			
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,30);
			
			 actual[71]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[72]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],fields[6],fields[7],ze_Multi_User_Picker,fields[8]);
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

	@Then("^Should be able to update the defect custom field multiple version picker$")
	public void should_be_able_to_update_the_defect_custom_field_multiple_version_picker() throws Throwable {
	try
	   {
		
		 actual[73]=dt.validateDefect(project, defectIssueType);
		 bp.waitForElement();
		 actual[74]=dt.updateEditDefectWindow();
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

	@When("^search the defect and update the custom field single user picker$")
	public void search_the_defect_and_update_the_custom_field_single_user_picker() throws Throwable {
		try
		   {
			 String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,28);
			
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,30);
			
			 actual[75]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[76]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],ze_User_Picker,fields[6],ze_Multi_User_Picker,fields[7]);
			 bp.waitForElement();
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

	@Then("^Should be able to update the defect custom field single user picker$")
	public void should_be_able_to_update_the_defect_custom_field_single_user_picker() throws Throwable {
	try
	   {
		
		 actual[77]=dt.validateDefect(project, defectIssueType);
		 bp.waitForElement();
		 actual[78]=dt.updateEditDefectWindow();
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

	@When("^search the defect and update the custom field multiple user picker$")
	public void search_the_defect_and_update_the_custom_field_multiple_user_picker() throws Throwable {
		try
		   {
			   String[] ze_Multi_User_Picker=new String[2];
			   ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,28);
			   ze_Multi_User_Picker[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,28);
			
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,30);
			
			 actual[79]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[80]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],fields[6],fields[7],ze_Multi_User_Picker,fields[8]);
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

	@Then("^Should be able to update the defect custom field multiple user picker$")
	public void should_be_able_to_update_the_defect_custom_field_multiple_user_picker() throws Throwable {
	try
	   {
		 actual[81]=dt.validateDefect(project, defectIssueType);
		 bp.waitForElement();
		 actual[82]=dt.updateEditDefectWindow();
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

	@When("^search the defect and update the custom field label$")
	public void search_the_defect_and_update_the_custom_field_label() throws Throwable {
		try
		   {
			 String ze_Label=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,22);
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,30);
			
			 actual[83]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[84]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],fields[6],ze_Label,ze_Multi_User_Picker,fields[7]);
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

	@Then("^Should be able to update the defect custom field label$")
	public void should_be_able_to_update_the_defect_custom_field_label() throws Throwable {
	try
	   {
		 actual[85]=dt.validateDefect(project, defectIssueType);
		 bp.waitForElement();
		 actual[86]=dt.updateEditDefectWindow();
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

	@When("^search the defect and update custom field single select list cascading parent/child$")
	public void search_the_defect_and_update_custom_field_single_select_list_cascading_parent_child() throws Throwable {
		try
		   {
			   String ze_MultiSelectListCascadingValue1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String ze_MultiSelectListCascadingValue2=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String ze_SingleSelectListCascadingValue1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,32);
			   String ze_SingleSelectListCascadingValue2=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,33);
			   
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,30);
			
			 actual[87]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[88]=dt.enterDefectCascadingDetails(ze_MultiSelectListCascadingValue1, ze_MultiSelectListCascadingValue2, ze_SingleSelectListCascadingValue1, ze_SingleSelectListCascadingValue2);
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

	@Then("^Should be able to update the defect custom field single select list cascading parent/child$")
	public void should_be_able_to_update_the_defect_custom_field_single_select_list_cascading_parent_child() throws Throwable {
	try
	   {
		 actual[89]=dt.validateDefect(project, defectIssueType);
		 bp.waitForElement();
		 actual[90]=dt.updateEditDefectWindow();
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

	@When("^search the defect and update custom field multiple select list cascading parent/child$")
	public void search_the_defect_and_update_custom_field_multiple_select_list_cascading_parent_child() throws Throwable {
		try
		   {
			   String ze_MultiSelectListCascadingValue1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,34);
			   String ze_MultiSelectListCascadingValue2=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,35);
			   String ze_SingleSelectListCascadingValue1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
			   String ze_SingleSelectListCascadingValue2=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
	
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 4,30);
			
			 actual[91]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[92]=dt.enterDefectCascadingDetails(ze_MultiSelectListCascadingValue1, ze_MultiSelectListCascadingValue2, ze_SingleSelectListCascadingValue1, ze_SingleSelectListCascadingValue2);
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

	@Then("^Should be able to update the defect custom field multiple select list cascading parent/child$")
	public void should_be_able_to_update_the_defect_custom_field_multiple_select_list_cascading_parent_child() throws Throwable {
	try
	   {
		 actual[93]=dt.validateDefect(project, defectIssueType);
		 bp.waitForElement();
		 actual[94]=dt.updateEditDefectWindow();
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

	@When("^search the defect subtask and enter the summary$")
	public void search_the_defect_subtask_and_enter_the_summary() throws Throwable {
		try
		   {
			   String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,31);
			  
			   actual[95]=dt.searchDefect(defectID);
			   dt.selectSingleOrMultipleDefects(defectNo);
			   dt.defectEditButton.click();
			   bp.waitForElement();
			 actual[96]=dt.fileNewDefect(summary,fields[0],fields[1],fields[2],fields[3],fields[4], fields[5], fields[6],fields[7], fields[8], fields[9], fields[10], fields[11]);
			 actual[97]=dt.updateEditDefectWindow();
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

	@Then("^Should be able to update the defect subtask summary$")
	public void should_be_able_to_update_the_defect_subtask_summary() throws Throwable {
		try
		   {
			 actual[98]=dt.validateDefectSummary(summary);
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
	
	@When("^search the defect subtask and enter the description$")
	public void search_the_defect_subtask_and_enter_the_description() throws Throwable {
		try
		   {
			 
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,31);
			
			 actual[99]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 bp.waitForElement();
			 actual[100]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3], fields[4], fields[5],fields[6], fields[7], fields[8], fields[9], fields[10]);
			 dt.updateEditDefectWindow();
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

	@Then("^Should be able to update the defect subtask description$")
	public void should_be_able_to_update_the_defect_subtask_description() throws Throwable {
	try
	   {
		 String defectname=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,31);
		 actual[101]=dt.validateDefect(defectname);
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

	@When("^search the defect subtask and enter the priority$")
	public void search_the_defect_subtask_and_enter_the_priority() throws Throwable {
	try
	   {
		 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,6);
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,31);
		
		 actual[102]=dt.searchDefect(defectID);
		 dt.selectSingleOrMultipleDefects(defectNo);
		 dt.defectEditButton.click();
		 bp.waitForElement();
		 actual[103]=dt.fileNewDefect(summary,fields[0],fields[1],fields[2],fields[3],priority, fields[4], fields[5],fields[6], fields[7], fields[8], fields[9], fields[10]);
		 dt.updateEditDefectWindow();
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

	@Then("^Should be able to update the defect subtask priority$")
	public void should_be_able_to_update_the_defect_subtask_priority() throws Throwable {
	try
	   {
		 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 3,6);
		 actual[104]=dt.validateDefect(priority);
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

	@When("^search the defect subtask and update the component$")
	public void search_the_defect_subtask_and_update_the_component() throws Throwable {
	try
	   {
		 String component=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,19);
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,31);
		
		 actual[105]=dt.searchDefect(defectID);
		 dt.selectSingleOrMultipleDefects(defectNo);
		 dt.defectEditButton.click();
		 bp.waitForElement();
		 actual[106]=dt.fileNewDefect(summary,component,fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6], fields[7], fields[8], fields[9], fields[10]);
		 dt.updateEditDefectWindow();
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

	@Then("^Should be able to update the defect subtask component$")
	public void should_be_able_to_update_the_defect_subtask_component() throws Throwable {
	try
	   {
		 String component=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,19);
		 actual[107]=dt.validateDefectComponent(component);
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

	@When("^search the defect  subtask and update the version$")
	public void search_the_defect_subtask_and_update_the_version() throws Throwable {
	try
	   {
		 String affectsVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,27);
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,31);
		
		 actual[108]=dt.searchDefect(defectID);
		 dt.selectSingleOrMultipleDefects(defectNo);
		 dt.defectEditButton.click();
		 bp.waitForElement();
		 actual[109]=dt.fileNewDefect(summary,fields[0],fields[1],fields[2],affectsVersion,fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
		 dt.updateEditDefectWindow();
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

	@Then("^Should be able to update the defect subtask version$")
	public void should_be_able_to_update_the_defect_subtask_version() throws Throwable {
	try
	   {
		 String affectsVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 3,19);
		 actual[110]=dt.validateDefectVersions(affectsVersion);
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

	@When("^search the defect subtask and update the fixversion$")
	public void search_the_defect_subtask_and_update_the_fixversion() throws Throwable {
	try
	   {
		 String fixVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,27);
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,31);
		 actual[111]=dt.searchDefect(defectID);
		 dt.selectSingleOrMultipleDefects(defectNo);
		 dt.defectEditButton.click();
		 bp.waitForElement();
		 actual[112]=dt.fileNewDefect(summary,fields[0],fields[1],fields[2],fixVersion,fields[3],fields[4],fields[5],fields[6], fields[7], fields[8], fields[9], fields[10]);
		 dt.updateEditDefectWindow();
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

	@Then("^Should be able to update the defect subtask fixversion$")
	public void should_be_able_to_update_the_defect_subtask_fixversion() throws Throwable {
	try
	   {
		 String fixVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 3,19);
		 actual[113]=dt.validateDefectFixVersion(fixVersion);
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

	@When("^search the defect subtask and update the label$")
	public void search_the_defect_subtask_and_update_the_label() throws Throwable {
	try
	   {
		 String label=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,27);
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,31);
		
		 actual[114]=dt.searchDefect(defectID);
		 dt.selectSingleOrMultipleDefects(defectNo);
		 dt.defectEditButton.click();
		 bp.waitForElement();
		 actual[115]=dt.fileNewDefect(summary,fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],label,fields[6], fields[7], fields[8], fields[9], fields[10]);
		 dt.updateEditDefectWindow();
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

	@Then("^Should be able to update the defect subtask label$")
	public void should_be_able_to_update_the_defect_subtask_label() throws Throwable {
	try
	   {
		 String defectname=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,31);
		 actual[116]=dt.validateDefect(defectname);
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

	@When("^search the defect subtask and update the assignee$")
	public void search_the_defect_subtask_and_update_the_assignee() throws Throwable {
	try
	   {
		String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,28);
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,31);
		 actual[117]=dt.searchDefect(defectID);
		 dt.selectSingleOrMultipleDefects(defectNo);
		 dt.defectEditButton.click();
		 bp.waitForElement();
		 actual[118]=dt.fileNewDefect(summary,fields[0],fields[1],fields[2],fields[3],fields[4],assignee,fields[5],fields[6], fields[7], fields[8], fields[9], fields[10]);
		 dt.updateEditDefectWindow();
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

	@Then("^Should be able to update the defect subtask assignee$")
	public void should_be_able_to_update_the_defect_subtask_assignee() throws Throwable {
	try
	   {
		 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,4);
		 actual[119]=dt.validateDefectAssignee(assignee);
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

	@When("^search the defect subtask and update the environment$")
	public void search_the_defect_subtask_and_update_the_environment() throws Throwable {
	try
	   {
		 String environment=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,22);
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,31);
		 actual[120]=dt.searchDefect(defectID);
		 dt.selectSingleOrMultipleDefects(defectNo);
		 dt.defectEditButton.click();
		 bp.waitForElement();
		 actual[121]=dt.fileNewDefect(summary,fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8], fields[9],fields[10],fields[11]);
		 dt.updateEditDefectWindow();
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

	@Then("^Should be able to update the defect subtask environment$")
	public void should_be_able_to_update_the_defect_subtask_environment() throws Throwable {
	try
	   {
		 String defectname=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,31);
		 actual[122]=dt.validateDefect(defectname);
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

	@When("^search the defect subtask and update the custom field text$")
	public void search_the_defect_subtask_and_update_the_custom_field_text() throws Throwable {
		try
		   {
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,22);
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,31);
			 actual[123]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[124]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],fields[6],fields[7],ze_Multi_User_Picker,ze_Text_Field);
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

	@Then("^Should be able to update the defect subtask custom field text$")
	public void should_be_able_to_update_the_defect_subtask_custom_field_text() throws Throwable {
	try
	   {
		 actual[125]=dt.validateDefect(project, defectSubtaskIssueType);
		 bp.waitForElement();
		 actual[126]=dt.updateEditDefectWindow();
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

	@When("^search the defect subtask and update the custom field free text$")
	public void search_the_defect_subtask_and_update_the_custom_field_free_text() throws Throwable {
		try
		   {
			String ze_Free_Text_Field=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,31);
			
			 actual[127]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[128]=dt.enterDefectCustomFields(ze_Free_Text_Field,fields[0],fields[1],fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
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

	@Then("^Should be able to update the defect subtask custom field free text$")
	public void should_be_able_to_update_the_defect_subtask_custom_field_free_text() throws Throwable {
	try
	   {
		 actual[129]=dt.validateDefect(project, defectSubtaskIssueType);
		 bp.waitForElement();
		 actual[130]=dt.updateEditDefectWindow();
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

	@When("^search the defect subtask and update the custom field checkbox$")
	public void search_the_defect_subtask_and_update_the_custom_field_checkbox() throws Throwable {
		try
		   {
			 String ze_Checkbox=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,25);
			
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,31);
			 actual[131]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[132]=dt.enterDefectCustomFields(fields[0],fields[1],ze_Checkbox,fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
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

	@Then("^Should be able to update the defect subtask custom field checkbox$")
	public void should_be_able_to_update_the_defect_subtask_custom_field_checkbox() throws Throwable {
	try
	   {
		 actual[133]=dt.validateDefect(project, defectSubtaskIssueType);
		 bp.waitForElement();
		 actual[134]=dt.updateEditDefectWindow();
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

	@When("^search the defect subtask and update the custom field radio button$")
	public void search_the_defect_subtask_and_update_the_custom_field_radio_button() throws Throwable {
		try
		   {
			 String ze_Radio_Field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,23);
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,31);
			
			 actual[135]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[136]=dt.enterDefectCustomFields(fields[0],ze_Radio_Field,fields[1],fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
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

	@Then("^Should be able to update the defect subtask custom field radio button$")
	public void should_be_able_to_update_the_defect_subtask_custom_field_radio_button() throws Throwable {
	try
	   {
		 actual[137]=dt.validateDefect(project, defectSubtaskIssueType);
		 bp.waitForElement();
		 actual[138]=dt.updateEditDefectWindow();
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

	@When("^search the defect subtask and update the custom field Date picker$")
	public void search_the_defect_subtask_and_update_the_custom_field_Date_picker() throws Throwable {
		try
		   {
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
			String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21)); 
			
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,31);
			
			 actual[139]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[140]=dt.customDatePicker(syear, smonth, sday);
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

	@Then("^Should be able to update the defect subtask custom field Date picker$")
	public void should_be_able_to_update_the_defect_subtask_custom_field_Date_picker() throws Throwable {
	try
	   {
		 actual[141]=dt.validateDefect(project, defectSubtaskIssueType);
		 bp.waitForElement();
		 actual[142]=dt.updateEditDefectWindow();
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

	@When("^search the defect subtask and update the custom field URL$")
	public void search_the_defect_subtask_and_update_the_custom_field_URL() throws Throwable {
		try
		   {
			String ze_URL_Field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,26);
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,31);
			
			 actual[143]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[144]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],ze_URL_Field,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
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

	@Then("^Should be able to update the defect subtask custom field URL$")
	public void should_be_able_to_update_the_defect_subtask_custom_field_URL() throws Throwable {
	try
	   {
		 actual[145]=dt.validateDefect(project, defectSubtaskIssueType);
		 bp.waitForElement();
		 actual[146]=dt.updateEditDefectWindow();
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

	@When("^search the defect subtask and update the custom field single select$")
	public void search_the_defect_subtask_and_update_the_custom_field_single_select() throws Throwable {
		try
		   {
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,29);
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,31);
			
			 actual[147]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[148]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,ze_Single_Select_Field,ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
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

	@Then("^Should be able to update the defect subtask custom field single select$")
	public void should_be_able_to_update_the_defect_subtask_custom_field_single_select() throws Throwable {
	try
	   {
		 actual[149]=dt.validateDefect(project, defectSubtaskIssueType);
		 bp.waitForElement();
		 actual[150]=dt.updateEditDefectWindow();
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

	@When("^search the defect subtask and update the custom field multi select$")
	public void search_the_defect_subtask_and_update_the_custom_field_multi_select() throws Throwable {
		try
		   {
			   String[] ze_Multiple_Select_Field=new String[2];
			   ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,24 );
			   ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,24 );
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,31);
			
			 actual[151]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[152]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],fields[6],fields[7],ze_Multi_User_Picker,fields[8]);
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

	@Then("^Should be able to update the defect subtask custom field multi select$")
	public void should_be_able_to_update_the_defect_subtask_custom_field_multi_select() throws Throwable {
	try
	   {
		 actual[153]=dt.validateDefect(project, defectSubtaskIssueType);
		 bp.waitForElement();
		 actual[154]=dt.updateEditDefectWindow();
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

	@When("^search the defect subtask and update the custom field version picker$")
	public void search_the_defect_subtask_and_update_the_custom_field_version_picker() throws Throwable {
		try
		   {
			String ze_Single_Version_field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,27);
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,31);
			
			 actual[155]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[156]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,ze_Single_Version_field,fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
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

	@Then("^Should be able to update the defect subtask custom field version picker$")
	public void should_be_able_to_update_the_defect_subtask_custom_field_version_picker() throws Throwable {
	try
	   {
		 actual[157]=dt.validateDefect(project, defectSubtaskIssueType);
		 bp.waitForElement();
		 actual[158]=dt.updateEditDefectWindow();
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

	@When("^search the defect subtask and update the custom field multiple version picker$")
	public void search_the_defect_subtask_and_update_the_custom_field_multiple_version_picker() throws Throwable {
		try
		   {
			   String[] ze_Multi_Version_field=new String[2];
			   ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,27 );
			   ze_Multi_Version_field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,27);
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,31);
			
			 actual[159]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[160]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],fields[6],fields[7],ze_Multi_User_Picker,fields[8]);
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

	@Then("^Should be able to update the defect subtask custom field multiple version picker$")
	public void should_be_able_to_update_the_defect_subtask_custom_field_multiple_version_picker() throws Throwable {
	try
	   {
		 actual[161]=dt.validateDefect(project, defectSubtaskIssueType);
		 bp.waitForElement();
		 actual[162]=dt.updateEditDefectWindow();
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

	@When("^search the defect subtask and update the custom field single user picker$")
	public void search_the_defect_subtask_and_update_the_custom_field_single_user_picker() throws Throwable {
		try
		   {
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,28);
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,31);
			
			 actual[163]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[164]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],ze_User_Picker,fields[6],ze_Multi_User_Picker,fields[7]);
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

	@Then("^Should be able to update the defect subtask custom field single user picker$")
	public void should_be_able_to_update_the_defect_subtask_custom_field_single_user_picker() throws Throwable {
	try
	   {
		 actual[165]=dt.validateDefect(project, defectSubtaskIssueType);
		 bp.waitForElement();
		 actual[166]=dt.updateEditDefectWindow();
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

	@When("^search the defect subtask and update the custom field multiple user picker$")
	public void search_the_defect_subtask_and_update_the_custom_field_multiple_user_picker() throws Throwable {
		try
		   {
			   String[] ze_Multi_User_Picker=new String[2];
			   ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,28);
			   ze_Multi_User_Picker[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,28);
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,31);
			
			 actual[167]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[168]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],fields[6],fields[7],ze_Multi_User_Picker,fields[8]);
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

	@Then("^Should be able to update the defect subtask custom field multiple user picker$")
	public void should_be_able_to_update_the_defect_subtask_custom_field_multiple_user_picker() throws Throwable {
	try
	   {
		 actual[169]=dt.validateDefect(project, defectSubtaskIssueType);
		 bp.waitForElement();
		 actual[170]=dt.updateEditDefectWindow();
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

	@When("^search the defect subtask and update the custom field label$")
	public void search_the_defect_subtask_and_update_the_custom_field_label() throws Throwable {
		try
		   {
			 String ze_Label=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,22);
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,31);
			
			 actual[171]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[172]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],fields[6],ze_Label,ze_Multi_User_Picker,fields[7]);
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

	@Then("^Should be able to update the defect subtask custom field label$")
	public void should_be_able_to_update_the_defect_subtask_custom_field_label() throws Throwable {
	try
	   {
		 actual[173]=dt.validateDefect(project, defectSubtaskIssueType);
		 bp.waitForElement();
		 actual[174]=dt.updateEditDefectWindow();
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

	@When("^search the defect subtask and update custom field single select list cascading parent/child$")
	public void search_the_defect_subtask_and_update_custom_field_single_select_list_cascading_parent_child() throws Throwable {
		try
		   {
			String ze_MultiSelectListCascadingValue1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
		    String ze_MultiSelectListCascadingValue2=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
		    String ze_SingleSelectListCascadingValue1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,32);
		    String ze_SingleSelectListCascadingValue2=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,33);  
			 
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,31);
			
			 actual[175]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[176]=dt.enterDefectCascadingDetails(ze_MultiSelectListCascadingValue1, ze_MultiSelectListCascadingValue2, ze_SingleSelectListCascadingValue1, ze_SingleSelectListCascadingValue2);
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

	@Then("^Should be able to update the defect subtask custom field single select list cascading parent/child$")
	public void should_be_able_to_update_the_defect_subtask_custom_field_single_select_list_cascading_parent_child() throws Throwable {
	try
	   {
		 actual[177]=dt.validateDefect(project,defectSubtaskIssueType);
		 bp.waitForElement();
		 actual[178]=dt.updateEditDefectWindow();
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

	@When("^search the defect subtask and update custom field multiple select list cascading parent/child$")
	public void search_the_defect_subtask_and_update_custom_field_multiple_select_list_cascading_parent_child() throws Throwable {
		try
		   {
			   String ze_MultiSelectListCascadingValue1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,34);
			   String ze_MultiSelectListCascadingValue2=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,35);
			   String ze_SingleSelectListCascadingValue1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
			   String ze_SingleSelectListCascadingValue2=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);

			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,31);
			
			 actual[179]=dt.searchDefect(defectID);
			 dt.selectSingleOrMultipleDefects(defectNo);
			 dt.defectEditButton.click();
			 bp.waitForElement();
			 actual[180]=dt.enterDefectCascadingDetails(ze_MultiSelectListCascadingValue1, ze_MultiSelectListCascadingValue2, ze_SingleSelectListCascadingValue1, ze_SingleSelectListCascadingValue2);
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

	@Then("^Should be able to update the defect subtask custom field multiple select list cascading parent/child$")
	public void should_be_able_to_update_the_defect_subtask_custom_field_multiple_select_list_cascading_parent_child() throws Throwable {
	try
	   {
		 actual[181]=dt.validateDefect(project,defectSubtaskIssueType);
		 bp.waitForElement();
		 actual[182]=dt.updateEditDefectWindow();
		 bp.waitForElement();
		 
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
