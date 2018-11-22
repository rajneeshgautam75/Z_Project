package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Search_176 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	TestRepositoryPage tr;
	ExecutionPage exep;
	TestPlanningPage tp;
	DefectTracking dt;
	String fileName="Defect_Tracking_Search_176";
	
	boolean[] actual=new boolean[25];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the Project Selection page$")
	public void user_is_in_the_Project_Selection_page() throws Throwable {
	try
	{
		 pp=new ProjectPage(driver);
		 rp=new ReleasePage(driver);
		 bp=new BasePage();
		 tr=new TestRepositoryPage(driver);
		 tp=new TestPlanningPage(driver);
		 exep=new ExecutionPage(driver);
		 dt=new DefectTracking(driver);
	     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 actual[0]=pp.selectProject(projectName);
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

	@When("^User launch the defect_Tracking Page$")
	public void user_launch_the_defect_Tracking_Page() throws Throwable {
	try
	{
	     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[1]=pp.selectRelease(releaseName);
		 actual[2]=rp.clickOnDefectTracking();
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

	@When("^filter assignees by full first name$")
	public void filter_assignees_by_full_first_name() throws Throwable {
	try
	{
	     String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,28);
		 actual[3]=dt.filterDefectAssignee(assignee);
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

	@Then("^dropdown menu should populate the matching users with assignees using first name$")
	public void dropdown_menu_should_populate_the_matching_users_with_assignees_using_first_name() throws Throwable {
	try
	{
	     actual[4]=dt.filterCreatorValues();
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

	@When("^User launch the Test Execution page to filter the assignee by full first name$")
	public void user_launch_the_Test_Execution_page_to_filter_the_assignee_by_full_first_name() throws Throwable {
	try
	   {
		   bp.waitForElement();
		   actual[5]=rp.clickOnTestExecution(); 
	       bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,12 );
		    String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,9);
			String value=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,51);
		    bp.waitForElement();
			actual[6]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    actual[7]=exep.executeStatus(tcNo1[0], statusType1);
		    actual[8]=exep.clickOnDefectButton(tcNo1[0]);
		    actual[9]=exep.defectSearch(selectSearch, value);
		    actual[10]=exep.clickOnDefectSearchButton();
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

	@Then("^dropdown menu should populate matching users with assignees using first name$")
	public void dropdown_menu_should_populate_matching_users_with_assignees_using_first_name() throws Throwable {
	try
	{
	     String defectType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",10,1);
	     String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,28);
	     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[11]=exep.validateSearchedDefect(defectType,assignee);
		 actual[12]=exep.clickOnCancelDefectWindow();
		 actual[13]=tp.doubleClickOnCycle(releaseName);
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

	@When("^User search a defect assignee by full first name in defect details window$")
	public void user_search_a_defect_assignee_by_full_first_name_in_defect_details_window() throws Throwable {
	try
	{
	     String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,28);
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,9);
		 String value=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,36);
		 bp.waitForElement();
		 actual[14]=rp.clickOnDefectTracking();
		 actual[15]=bp.waitForElement();
		 int[] defectNo=new int[1];
		 defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1,16);
		// actual[15]=dt.clickOnDefectAdvancedSearchButton();
		 actual[16]=dt.advancedSearch(selectSearch, value);
		 actual[17]=dt.selectSingleOrMultipleDefects(defectNo);
		 actual[18]=dt.filterDefectAssigneeInSearchGridView(assignee);
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

	@Then("^dropdown menu should populate the matching users with assignee by full first name in defect detail window$")
	public void dropdown_menu_should_populate_the_matching_users_with_assignee_by_full_first_name_in_defect_detail_window() throws Throwable {
	try
	{
	     actual[19]=dt.filterCreatorValues();
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

	@When("^User search a assignee by full first name in change multiple window$")
	public void user_search_a_assignee_by_full_first_name_in_change_multiple_window() throws Throwable {
	try
	{
	     String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,28);
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,14);
		 int[] defectNo=new int[8];
		 defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1,16);
		 defectNo[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",2,16);
		 defectNo[2]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",3,16);
		 defectNo[3]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",4,16);
		 defectNo[4]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",5,16);
		 defectNo[5]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",6,16);
		 defectNo[6]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",7,16);
		 defectNo[7]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",8,16);
		 actual[20]=dt.selectSingleOrMultipleDefects(defectNo);
		 actual[21]=dt.defectsOperation(defectValue);
		 actual[22]=dt.filterDefectAssigneeInChangeMultiple(assignee);
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

	@Then("^dropdown menu should populate the matching users with assignee by full first name in change multiple window$")
	public void dropdown_menu_should_populate_the_matching_users_with_assignee_by_full_first_name_in_change_multiple_window() throws Throwable {
	try
	{
	     actual[23]=dt.filterCreatorValues();
	     actual[24]=dt.clickOnCancelChangeMultipleWindow();
	     
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
	   lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
	}         
	}
}
