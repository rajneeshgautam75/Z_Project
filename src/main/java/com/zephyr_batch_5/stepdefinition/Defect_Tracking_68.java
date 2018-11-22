package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_68 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestPlanningPage tl;
	BasePage bp;
	ExecutionPage epp;
	RequirementsPage req;
	DefectTracking dt;
	DashBoardPage dp;
	ProjectPage pp;
	boolean[] actual=new boolean[56];
	SoftAssert soft=new SoftAssert();
	String filename="Defect_Tracking_68";
	
	
	@Given("^User is in Requirement page$")
	public void user_is_in_Requirement_page() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			bp=new BasePage();
			rp= new ReleasePage(driver);
			bp.waitForElement();
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			actual[0]=pp.selectProject(projectName);
			bp.waitForElement();
			bp.waitForElement();
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			actual[1]=pp.selectRelease(releaseName);
			bp.waitForElement();
			 rp.clickOnRequirements();
			 bp.waitForElement();
		}
		   catch(Exception e)
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e; 	 
			}  
	     
	}

	@When("^user will create a node and add requirements$")
	public void user_will_create_a_node_and_add_requirements() throws Throwable {
		try
		   {
			   req=new RequirementsPage(driver);
			   tr=new TestRepositoryPage(driver);
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 1, 5);
		    	String descp=Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 1, 6);
		    	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
				actual[2]=tr.clickOnRelease(releaseName);
				bp.waitForElement();
				bp.waitForElement();
				bp.waitForElement();
				actual[3]=req.addNode(name,descp);
				bp.waitForElement();
			    String[] str=new String[1];
			    str[0]=name;
			    actual[4]=tr.navigateToNode(releaseName, str);
			    bp.waitForElement();
			    actual[5]=req.addRequirement();
			    bp.waitForElement();
			    actual[6]=tr.clickOnDetails();
			    bp.waitForElement();
		   }
		 catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}           
	     
	}

	@Then("^requirement added successfully$")
	public void requirement_added_successfully() throws Throwable {
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 1, 7);
			String altID=Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 100, 100);
			String link=Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 100, 100);
			String priority=Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 100, 100);
			String description=Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 100, 100);
			 actual[7]=req.enterRequirementDetails(name, altID, link, priority, description);
			 bp.waitForElement();
			 actual[8]=tr.clickOnList();
			 bp.waitForElement();
		}
		
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}   
	     
	}

	@Then("^user clicks on the resporitory page$")
	public void user_clicks_on_the_resporitory_page() throws Throwable {
		try
	    {
			
			actual[9]=rp.clickOnTestRep();
	    	bp.waitForElement();
	    	bp.waitForElement();
	    	bp.waitForElement();
	    }
	    catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
   
	 
	}

	@Then("^user will click on release and create a node$")
	public void user_will_click_on_release_and_create_a_node() throws Throwable {
		try
		  {

		    	String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 3, 0);
		    	String descp=Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 3, 1);
		    	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
				actual[10]=tr.clickOnRelease(releaseName);
				bp.waitForElement();
				bp.waitForElement();
				bp.waitForElement();
				actual[11]=tr.addNode(name,descp);
				bp.waitForElement();
				
				bp.waitForElement();
				
				
		  }
			  catch(Exception e)
				{
				   lb=new LaunchBrowser();
				   lb.getScreenShot(filename);
					e.printStackTrace();
				   driver.close();
			      	Relogin_TPE rl=new Relogin_TPE();
			      	rl.reLogin();
			      	throw e; 	 
				}
		
	    
	}

	@Then("^user will add testcases$")
	public void user_will_add_testcases() throws Throwable {
		try
		  {
			    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			    String[] phase=new String[1];
			    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 3, 0);
			    actual[12]=tr.navigateToNode(releaseName, phase);
			    bp.waitForElement();
			    for(int i=1;i<=3;i++)
				{
				 actual[13]=tr.addTestCase();
				}
			 bp.waitForElement();
		  }
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	   
	}

	@Then("^testcases must be added successfully$")
	public void testcases_must_be_added_successfully() throws Throwable {
		try
		{
			actual[14]=tr.verifyPresentTestCase();
			bp.waitForElement();
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
		
	    
	}

	@When("^user will map the testcase to requirement node$")
	public void user_will_map_the_testcase_to_requirement_node() throws Throwable {
		try
		{
			
			String[] node=new String[1];
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 1, 5);
			String[] requireTestno= new String[1];
			requireTestno[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_8, "Defect_Tracking", 1, 8));
			bp.waitForElement();
			actual[15]=tr.selectallTestCase();
			bp.waitForElement();
			actual[16]=tr.clickOnMap();
			bp.waitForElement(); 
			actual[17]=req.ExpandRelease(releaseName);
			bp.waitForElement(); 
			actual[18]=tr.navigateNode(node);
			bp.waitForElement();
			actual[19]=tr.selectMultipleRequirementFromGrid(requireTestno);
			bp.waitForElement();
			req.clickOnSavejirareq1.click();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	   
	}

	@Then("^testcase should be sucessfully mapped$")
	public void testcase_should_be_sucessfully_mapped() throws Throwable {
		try
		{
			
			int[] testno=new int[3];
			testno[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
			testno[1]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 2, 0);
			testno[2]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 3, 0);
			int requirement=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);		
			for(int i=0;i<=testno.length-1;i++)
			{
				actual[20]=tr.validateMappedRequirementInList(testno[i], requirement);
			    bp.waitForElement();
			}
			 bp.waitForElement();
			 bp.waitForElement();
		}
		
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	   
	}

	@When("^user clicks on testplanning page$")
	public void user_clicks_on_testplanning_page() throws Throwable {
		try 
		{
			
		 actual[21]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		 

	 }
	 catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
		
	   
	}

	@When("^user will click on add symbol to create cycle$")
	public void user_will_click_on_add_symbol_to_create_cycle() throws Throwable {
		try 
		{
	   tl=new TestPlanningPage(driver);
		 actual[22]=tl.clickOnAddTestCycleSymbol();
		 bp.waitForElement();
		 

	 }
	 catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
		
	    
	}

	@When("^user will fill all the details$")
	public void user_will_fill_all_the_details() throws Throwable {
		try
		{
		     String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 0);
		     String build=Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 1);
		  	 String environment=Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 2);
			 String hide=Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 11);
			 String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_8, "Release", 1, 4));
			 String smonth=Excel_Lib.getData(INPUT_PATH_8, "Release", 1, 5);
		 	 String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_8, "Release", 1, 6));
			 String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_8, "Release", 1, 7));
			 String emonth=Excel_Lib.getData(INPUT_PATH_8, "Release", 1, 8);
			 String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_8, "Release", 1, 9));
			 String cyclename1[]=new String[1];
			 cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 0);
			 actual[23]=tl.CreateCycle(cyclename, build, environment,hide); 
			 bp.waitForElement();
			 actual[24]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			 bp.waitForElement();
			 actual[25]=tl.saveTestCycle();
			 bp.waitForElement();
			
		     
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	   
	}

	@Then("^test planning cycle is created successfully$")
	public void test_planning_cycle_is_created_successfully() throws Throwable {
		try
		{
			
	       actual[26]=tl.verifyAddTestCyclePage();
			
			 bp.waitForElement();  
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	  
	}

	@When("^user will navigate and add phase to the cycle$")
	public void user_will_navigate_and_add_phase_to_the_cycle() throws Throwable {
		try
		{
			 String cyclename1[]=new String[1];
			 cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 0);
			 String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 3, 0);		
			 actual[27]=tl.navigateToCycle(cyclename1);
			 bp.waitForElement();		
			 actual[28]=tl.addPhaseToCycle(nodeName);
			 bp.waitForElement();  
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	 
	}

	@When("^user will assign testcase to user$")
	public void user_will_assign_testcase_to_user() throws Throwable {
		try
		{
			// String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_1");
			 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 3, 0);
			 String bulk_Type=Excel_Lib.getData(INPUT_PATH_8,"Create cycle", 1, 4);
			 actual[29]=tl.bulkAssignment(bulk_Type);
		     bp.waitForElement();
		     actual[30]=tl.doubleClickOnCycle(name);
		     bp.waitForElement();
//		     actual[31]=tl.selectallTestCase();
//		     bp.waitForElement();
//		     actual[32]=tl.assignAllSelected(assignee);
		    bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	   
	}

	@Then("^testcase successfully assigned to user$")
	public void testcase_successfully_assigned_to_user() throws Throwable {
		try
		{
			String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_1");
			 int tcNo[]=new int[3];
		     tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
		     tcNo[1]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
		     tcNo[2]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
		     bp.waitForElement();
		     actual[31]=tl.validateAllAssigned(tcNo, assignee);
		     bp.waitForElement();
		     actual[32]=tl.goBackToCycle();
		     bp.waitForElement();    
		     bp.waitForElement();
		     bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	 
	}

	@When("^user clicks on testExecution page$")
	public void user_clicks_on_testExecution_page() throws Throwable {
		try
		{
			String cyclename1[]=new String[3];
		    cyclename1[0]=Excel_Lib.getData(INPUT_PATH_8,"TestExec",1,1);
			cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 0);
			cyclename1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 3, 0);
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			actual[33]=rp.clickOnTestExecution();
			bp.waitForElement();
			bp.waitForElement();
		    actual[34]=tr.navigateToNode(releaseName,cyclename1);
			bp.waitForElement();  
			bp.waitForElement();  
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	 
	}

	@When("^user will be change the status of the testcase$")
	public void user_will_be_change_the_status_of_the_testcase() throws Throwable {
		try
		{
			epp=new ExecutionPage(driver);
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 2);
		    actual[35]=epp.changeStatusOfTestCases(tcNo, statusType);
		    bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	     
	}

	@Then("^Status should be able to change successfully$")
	public void status_should_be_able_to_change_successfully() throws Throwable {
		try
		{
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 2);
		    actual[36]=epp.ValidateStatusOfTestCases(tcNo, statusType);
		    bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	     
	}

	@When("^user will click on D button and search for the mutiple defect and link it$")
	public void user_will_click_on_D_button_and_search_for_the_mutiple_defect_and_link_it() throws Throwable {
		try
		{
			int tcno=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
			String[] defectId=new String[3];
			defectId[0]=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 9);
			defectId[1]=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 2, 9);
			defectId[2]=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 9);
			String selectSearch=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 6);
			actual[37]=epp.clickOnDefectButton(tcno);
		    bp.waitForElement(); 
		    bp.waitForElement();
			for(int i=0;i<=defectId.length-1;i++)
			{
		    actual[38]=epp.defectSearch(selectSearch, defectId[i]);
			epp.linkDefects.click();
			}
			//actual[7]=epp.multipleDefectSearch(selectSearch, defectId);
			bp.waitForElement(); 
			epp.cancelDefect.click();
			bp.waitForElement(); 
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}    
	 
	}

	@Then("^multiple defect must be linked successfully$")
	public void multiple_defect_must_be_linked_successfully() throws Throwable {
		try
		{
			int tcno=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
			actual[39]=epp.viewTooltip(tcno);
			bp.waitForElement();

			bp.waitForElement();
			bp.waitForElement(); 
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}   
	   
	}

	@When("^user will click on the dashboard button$")
	public void user_will_click_on_the_dashboard_button() throws Throwable {
		try
		{
		     dp=new DashBoardPage(driver);
			actual[40]=dp.clickOnManageDashboards();
			bp.waitForElement(); 
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}   
	  
	}

	@Then("^Dashboard page must be validate sucessfully$")
	public void dashboard_page_must_be_validate_sucessfully() throws Throwable {
		try
		{
			actual[41]=dp.validateDashboards();
			bp.waitForElement(); 
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}   
	   
	}

	@When("^user clicks on add dashboard button$")
	public void user_clicks_on_add_dashboard_button() throws Throwable {
		try
		{
			actual[42]=dp.clickOnAddDashBoardSymbol();
			bp.waitForElement(); 
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}   
	    
	}

	@When("^users enters the fields to create dashboard$")
	public void users_enters_the_fields_to_create_dashboard() throws Throwable {
		try
		{
			 String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 6, 1);
	    	 String description=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 2);
	    	 String layout=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 4);
	    	 String shareType=Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 1, 3);
	    	 actual[43]=dp.enterDashBoardDetails(dashboard, description, layout, shareType);
	    	 bp.waitForElement(); 
	    	 bp.waitForElement(); 
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}   
	    
	}

	@Then("^dashboard must created successfully$")
	public void dashboard_must_created_successfully() throws Throwable {
		try
		{
			String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_8,"AddDashboard", 6, 1);
			actual[44]=dp.validateDashBoard(dashboard);
			bp.waitForElement(); 
			actual[45]=dp.selectDashboard(dashboard);
			bp.waitForElement(); 
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}   
	    
	}

	@When("^user adds the Traceability gadget$")
	public void user_adds_the_Traceability_gadget() throws Throwable {
		try
		{
			String gadgetName=Excel_Lib.getData(INPUT_PATH_8, "AddDashboard", 4, 5);
			actual[46]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement(); 
			bp.waitForElement();
			actual[47]=dp.addGadget(gadgetName);
			bp.waitForElement(); 
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}   
	   
	}

	@Then("^gadget must be able to added successfully$")
	public void gadget_must_be_able_to_added_successfully() throws Throwable {
		try
		{
			String gadgetName=Excel_Lib.getData(INPUT_PATH_8, "AddDashboard", 4, 5);
			actual[48]=dp.validateGadget(gadgetName);
			bp.waitForElement(); 
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}   
	   
	}

	@When("^user will selects project,release and refreshrate$")
	public void user_will_selects_project_release_and_refreshrate() throws Throwable {
		try
		{
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			String refreshRate=Excel_Lib.getData(INPUT_PATH_8, "Gadget", 1, 2);
			
			actual[49]=dp.configureTraceabilityGadget(project,release,refreshRate);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}   
	   
	}

	@When("^user will clicks on manage button and search for the mapped requirement$")
	public void user_will_clicks_on_manage_button_and_search_for_the_mapped_requirement() throws Throwable {
		try{
			
			String searchOption=Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 1, 7);
			dp.manageTraceability();
			bp.waitForElement();
			bp.waitForElement();
			 actual[50]=dp.traceabilityQuickSearch(searchOption);
			bp.waitForElement();
			 actual[51]=dp.selectAllRequirements();
			bp.waitForElement();
			 actual[52]=dp.closeTraceabilityTable();
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		} 
	  
	}

	@When("^user will click on save button$")
	public void user_will_click_on_save_button() throws Throwable {
		try
		{
			actual[53]=dp.saveGadget();
			bp.waitForElement(); 
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		} 
	   
	}

	@Then("^gadget must be added sucessfully and view the total open defect count and count by priority$")
	public void gadget_must_be_added_sucessfully_and_view_the_total_open_defect_count_and_count_by_priority() throws Throwable {
		try
		{
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			actual[54]=dp.validateSavedGadget(project);
			bp.waitForElement(); 
			String count=dp.tracebilityCount.getText();
			System.out.println(count);
			actual[55]=pp.backToProjectPage();
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
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}   
	   
	}
	
	

}
