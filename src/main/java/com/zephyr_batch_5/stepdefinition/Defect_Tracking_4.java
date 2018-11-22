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

public class Defect_Tracking_4 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestPlanningPage tp;
	TestRepositoryPage tr;
	ExecutionPage ep;
	DefectTracking dt;
	boolean[] actual=new boolean[33];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_4";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	
	@Given("^Login as manager role Credential$")
	public void login_as_manager_role_Credential() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			lp=new LoginPage(driver);
			bp=new BasePage();
			lb=new LaunchBrowser();
			rp=new ReleasePage(driver);
			ep=new ExecutionPage(driver);
			dt=new DefectTracking(driver);
			tp=new TestPlanningPage(driver);
			tr=new TestRepositoryPage(driver);
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
			actual[0]=pp.clickOnLogout();
			bp.waitForElement();
			actual[1]=lp.enterUname(uname);
			actual[2]=lp.enterPass(password);        
			actual[3]=lp.clickOnLogin();  
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

	@When("^admin navigate to project setup page$")
	public void admin_navigate_to_project_setup_page() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			lp=new LoginPage(driver);
			bp=new BasePage();
			lb=new LaunchBrowser();
			rp=new ReleasePage(driver);
			ep=new ExecutionPage(driver);
			dt=new DefectTracking(driver);
			tp=new TestPlanningPage(driver);
			tr=new TestRepositoryPage(driver);
     		actual[0]=pp.launchAdministration();
			bp.waitForElement();
			actual[1]=pp.launchManageprojects();	
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

	@When("^map external defect project to zephyr project and save it$")
	public void map_external_defect_project_to_zephyr_project_and_save_it() throws Throwable {
		 try
		 {	
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String jiraProjectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Jira_Project_2");
		 actual[2]=pp.selectProjectInProjectSetup(projectName);
	  	 bp.waitForElement();
	  	 actual[3]=pp.mapJiraProject(jiraProjectName);
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

	@Then("^extenal defect project should be mapped to zephyr project$")
	public void extenal_defect_project_should_be_mapped_to_zephyr_project() throws Throwable {
		try
		{
			bp.waitForElement();
	
			actual[4]=pp.backToProjectPage();
			
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

	@When("^user launch defect tracking page$")
	public void user_launch_defect_tracking_page() throws Throwable {
		try
		{
 
			bp.waitForElement();
			actual[5]=pp.selectProject(project);
			bp.waitForElement();
			actual[6]=pp.selectRelease(release);
			bp.waitForElement();
		    actual[7]=pp.clickOnDefectTracking();
		    
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

	@When("^click on create defect symbol icon$")
	public void click_on_create_defect_symbol_icon() throws Throwable {
		try
		{
			bp.waitForElement();
			dt.createDefectButton.click();
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

	@Then("^view mapped project is pre-selected when filing a new defect$")
	public void view_mapped_project_is_pre_selected_when_filing_a_new_defect() throws Throwable {
		try
		{
			String mappedproject=dt.selectDefectProject.getText();
			String jiraProjectName=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			if(mappedproject.equals(jiraProjectName))
			{
				System.out.println("Project is Pre-Selected");
			}
			bp.waitForElement();
			dt.closeFileNewDefectPopUp.click();

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

	

@When("^user launch test repository pages$")
public void user_launch_test_repository_pages() throws Throwable {
	try
	{
		bp.waitForElement();
		actual[8]=rp.clickOnTestRep();	     
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

	


	@When("^create a phase ,add few testcases to the phase$")
	public void create_a_phase_add_few_testcases_to_the_phase() throws Throwable {
		try
		{
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 21, 4);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 21, 5);
			String [] navigation=new String [1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 21, 4);
			bp.waitForElement();
			actual[9]=tr.clickOnRelease(release);
			actual[10]=tr.addNode(name, desc);
			bp.waitForElement();
			actual[11]=tr.navigateToNode(release, navigation);
			for(int i=0;i<3;i++)
			{
			actual[12]=tr.addTestCase();	
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

	@Then("^testcases successfully added to the phase$")
	public void testcases_successfully_added_to_the_phase() throws Throwable {
		try
	    {
	    	bp.waitForElement();
	    	actual[13]=tr.verifyPresentTestCase();
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

	@When("^user launch test planning page$")
	public void user_launch_test_planning_page() throws Throwable {
		try
	    {
			bp.waitForElement();
			actual[14]=rp.clickOnTestPlanning();
	
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

	@When("^create a cycle, add phase to cycle and assign to manager$")
	public void create_a_cycle_add_phase_to_cycle_and_assign_to_manager() throws Throwable {
		try
	    {
	    	String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 19, 0);
			String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 1, 1);
			String environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 2, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 4, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 10, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 5));
			String [] cycle1 =new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 19, 0);
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 21,4);
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 1, 0);
			String phase_1[]=new String[1];
	    	phase_1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 21, 4);
	    	int testcase[]=new int[3];
	    	testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
	    	testcase[1]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 2, 0);
	    	testcase[2]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 3, 0);
//	    	String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Manager_1");
			bp.waitForElement();
			actual[15]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[16]=tp.CreateCycle(cycle, build, environment, hide);
			bp.waitForElement();
			actual[17]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[18]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			actual[19]=tp.navigateToCycle(cycle1);
			//bp.waitForElement();
			actual[20]=tp.addPhaseToCycle(phase);
			bp.waitForElement();
			actual[21]=tp.bulkAssignment(bulk_type);
			bp.waitForElement();
			actual[22]=tp.navigateToCycle(phase_1);
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

	@Then("^testcases successfully assigned to manager$")
	public void testcases_successfully_assigned_to_manager() throws Throwable {
		try
	    {
			int testcase[]=new int[3];
	    	testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
	    	testcase[1]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 2, 0);
	    	testcase[2]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 3, 0);
	    	String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Manager_1");
	    	actual[23]=bp.waitForElement();
	    	actual[24]=tp.validateAllAssigned(testcase, assignee);
	    	
	    	actual[25]=tp.goBackToCycle();
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

	@When("^user navigate to test Execution page$")
	public void user_navigate_to_test_Execution_page() throws Throwable {
		try
		{

			actual[26]=bp.waitForElement();
			actual[27]=rp.clickOnTestExecution();
			
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

	@When("^change the status of testcases and click on Defect button$")
	public void change_the_status_of_testcases_and_click_on_Defect_button() throws Throwable {
		try
		{
			
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",19,0 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",21,4 );
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			actual[28]=bp.waitForElement();
			tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[29]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[30]=ep.changeMultiSelectedStatus(status);
			actual[31]=ep.clickOnDefectButton(testcase1);
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

	@Then("^Link defect window should be launced$")
	public void link_defect_window_should_be_launced() throws Throwable {
		try
		{
			dt=new DefectTracking(driver);
			bp.waitForElement();
			actual[32]=ep.validateLinkDefectWindow();
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

	@When("^user click on create defect button$")
	public void user_click_on_create_defect_button() throws Throwable {
		try
		{
            bp.waitForElement();
			dt.createDefectButton.click();
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

	@Then("^view Mapped Project is pre-selected$")
	public void view_Mapped_Project_is_pre_selected() throws Throwable {
		try
	    {
			String mappedproject=dt.selectDefectProject.getText();
			String jiraProjectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Jira_Project_2");
			if(mappedproject.equals(jiraProjectName))
			{
				System.out.println("Project is Pre-Selected");
			}
			bp.waitForElement();
			dt.closeFileNewDefectPopUp.click();
			bp.waitForElement();
			
	    	
	    	 for(int k=0;k<=actual.length-1;k++)
				{
					
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
