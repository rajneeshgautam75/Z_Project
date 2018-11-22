package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefectTracking_245 extends LaunchBrowser{
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	DashBoardPage dp;
	ExecutionPage ep;
	LaunchBrowser lb;
	LoginPage lp;
	DefectTracking dt;
	ExternalJiraPage ejp;
	private int beforeOpenCount;
	private int afterOpenCount;
	private int afterTotalCount;
	private int beforeTotalCount;
	boolean[] actual=new boolean[51];
	SoftAssert soft=new SoftAssert();
	String fileName="DefectTracking_245";

	@Given("^User Is In administration Page$")
	public void user_Is_In_administration_Page() throws Throwable {
		try
	     {
	     bp=new BasePage();
	     pp=new ProjectPage(driver);
	     lp=new LoginPage(driver);
	     String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
//	     actual[0]=pp.clickOnLogout();
//	     bp.waitForElement();
//	     actual[1]=lp.enterUnameAndPassword(name, passWord);
//	     bp.waitForElement();
//	     actual[2]=pp.launchAdministration();
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

	@When("^User set dts to Jira$")
	public void user_set_dts_to_Jira() throws Throwable {
		 try
	       {
		   String dts=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",2 , 0);	 
		   String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
		   String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
		   String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
//		   actual[3]=pp.clickOnDefectTracking();
//		   bp.waitForElement();
//		   actual[4]=pp.setDTS(dts, url, username, password);
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

	@Then("^Should be able to set$")
	public void should_be_able_to_set() throws Throwable {
		 try
	       {
		   String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
		   String pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
//		   actual[5]=pp.validateSetDTS();
//		   bp.waitForElement();
//		   actual[6]=pp.clickOnLogout();
//		   bp.waitForElement();
//		   actual[7]=lp.enterUnameAndPassword(name, pass);
//		   bp.waitForElement();
		   actual[8]=pp.selectProject(projectName);
		   actual[9]=pp.selectRelease(releaseName);
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

	@When("^user launch the Test execution$")
	public void user_launch_the_Test_execution() throws Throwable {
		 try
	       {
		   rp=new ReleasePage(driver);
		   actual[10]=rp.clickOnTestExecution();
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

	@Then("^should be able to launch the Test execution$")
	public void should_be_able_to_launch_the_Test_execution() throws Throwable {
		 try
	       {
	       ep=new ExecutionPage(driver);
		   tr=new TestRepositoryPage(driver);
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
		   String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);	 
		   String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		   String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		   String cyclename[]=new String[1];
		   cyclename[0]=cycle;
		   String phase1[]=new String[1];
		   phase1[0]=name;
		   String[] str=new String[2];
		   str[0]=cycle;
		   str[1]=phase;
		   actual[11]=ep.verifyExecutionPage();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[12]=tr.navigateToNode(releaseName, str);
		   bp.waitForElement();
		   actual[13]=ep.selectAndDeselectAllTestCase();
		   bp.waitForElement();
		   actual[14]=ep.changeMultiSelectedStatus(status);
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

	@When("^user link One defect with status Inprogress to execution$")
	public void user_link_One_defect_with_status_Inprogress_to_execution() throws Throwable {
		try
	       { 
	       int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);	 
	       String defectId=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 4, 10);
	       String[] priority=new String[3];
		   priority[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 13);
	       actual[15]=ep.clickOnDefectButton(testcase);
		   bp.waitForElement();
		   actual[16]=ep.searchDefect(defectId);		
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   ep.linkDefect();
		   bp.waitForElement();	
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

	@Then("^should be able to link defect with status Inprogress to execution$")
	public void should_be_able_to_link_defect_with_status_Inprogress_to_execution() throws Throwable {
		 try
	       {
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);	 
		   String defectId=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 4, 10);	 
		   actual[17]=ep.validateLinkedDefect(testcase, defectId);
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

	@When("^user create the dashBoards$")
	public void user_create_the_dashBoards() throws Throwable {
		 try
	       {
		   dp=new DashBoardPage(driver);
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);	 
		   String desc=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 1);
		   String layout=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 2);
		   String shareType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 3);
		   actual[18]=dp.clickOnManageDashboards(); 
		   bp.waitForElement();
		   actual[19]=dp.clickOnAddDashBoardSymbol();
		   bp.waitForElement();
		   actual[20]=dp.enterDashBoardDetails(name, desc, layout, shareType);
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

	@Then("^should be able to create the dashBoards$")
	public void should_be_able_to_create_the_dashBoards() throws Throwable {
		try
	       {
		  String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);	 
		  actual[21]=dp.validateDashBoard(dashBoard);
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

	@When("^user launch the Gadaget Page$")
	public void user_launch_the_Gadaget_Page() throws Throwable {
		 try
	       {
		   String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);		 	
		   actual[22]=dp.searchDashboard(dashboard);
		   bp.waitForElement();
		   actual[23]=dp.selectDashboard(dashboard);
		   bp.waitForElement();
		   actual[24]=dp.clickOnAddGadgetSymbol();
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

	@Then("^should Be able to launch the Gadget Page$")
	public void should_Be_able_to_launch_the_Gadget_Page() throws Throwable {
		try
	       {
		   actual[25]=dp.verifyAddGadgetPage();
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
	       }}

	@When("^user add Traceability Gadget$")
	public void user_add_Traceability_Gadget() throws Throwable {
		try
	       {
		   String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		   String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		   String refreshRate=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 ,5);
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",4 ,12);
		   String requirement=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",6,1);
		   actual[26]=dp.addGadget(gadgetName);
		   bp.waitForElement();
		   actual[27]=dp.configureTraceabilityGadget(project, release, refreshRate);
		   bp.waitForElement(); 
		   actual[28]=dp.manageTraceability();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[29]=dp.traceabilityQuickSearch(requirement);
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[30]=dp.selectAllRequirements();
		   bp.waitForElement();
		   actual[31]=dp.closeTraceabilityTable();
		   bp.waitForElement();
		   actual[32]=dp.saveTraceabilityGadget();
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

	@Then("^should be able to add Traceability Gadget$")
	public void should_be_able_to_add_Traceability_Gadget() throws Throwable {
		try
	       {
		   String requirement=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking",5,1));	
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",4,12 );	
		   actual[33]=dp.validateTraceabilityGadget(gadgetName);
	       bp.waitForElement();
		   beforeTotalCount=dp.retrieveTotalDefectCountInTraceability(requirement);
		   beforeOpenCount=dp.retrieveOpenDefectCountInTraceability(requirement);
		   bp.waitForElement();
	       actual[34]=pp.backToProjectPage();
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

	@When("^user search that linked defect in defecttracking$")
	public void user_search_that_linked_defect_in_defecttracking() throws Throwable {
		try
	       {
		   dt=new DefectTracking(driver);
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 4, 10);	 
		   actual[35]=pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[36]=dt.searchDefect(defectID);
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

	@Then("^should be able to search that linked defect in defecttracking$")
	public void should_be_able_to_search_that_linked_defect_in_defecttracking() throws Throwable {
		try
	       {
		   String defectname=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 4, 10);	 
		   actual[37]=dt.validateAdvancedSearch(defectname);
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

	@When("^user change status from Inprogress to Done$")
	public void user_change_status_from_Inprogress_to_Done() throws Throwable {
		 try
	       {
		   ejp=new ExternalJiraPage(driver);
		   int switch_1=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 1);
		   int switch_0=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 0);	 	 
		   String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
		   String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");	 
		   String statusType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 11);
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 4, 10);	 
		   bp.waitForElement();
		   actual[38]=dp.searchAndSelectDefect(defectID);
		   bp.waitForElement();
		   bp.switchWindowTab(switch_1);
		   actual[39]=ejp.loginToExternalJira(username, password);
		   bp.waitForElement();
		   actual[40]=ejp.changeDefectStatusInExternalJira(statusType);
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[41]=ejp.logOutFromExternal_JIRA();
		   bp.waitForElement();
		   driver.close();
		   bp.waitForElement();
		   bp.switchWindowTab(switch_0);
		   bp.waitForElement();
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

	@Then("^should be able to change status from Inprogress to Done$")
	public void should_be_able_to_change_status_from_Inprogress_to_Done() throws Throwable {
		 try
	       {
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);	 	 
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		   String phase1[]=new String[1];
		   phase1[0]=name;
		   actual[42]=rp.clickOnTestExecution();
		   bp.waitForElement();
		   actual[43]=tr.navigateToNode(releaseName,phase1);
		   bp.waitForElement();
		   actual[44]=ep.viewTooltip(testcase);
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

	@When("^user refresh the added Traceability Gadget$")
	public void user_refresh_the_added_Traceability_Gadget() throws Throwable {
		try
	       {
		   String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);		 	 
		   String value=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 7);		 	 
		   actual[45]=dp.clickOnManageDashboards();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[46]=dp.searchDashboard(dashboard);
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[47]=dp.selectDashboard(dashboard);
		   bp.waitForElement();
           actual[48]=dp.gadgetOperation(value);
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

	@Then("^should be able to refresh the added Traceability Gadget$")
	public void should_be_able_to_refresh_the_added_Traceability_Gadget() throws Throwable {
		try
	       {
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",4 ,12);	  
		   actual[49]=dp.validateGadget(gadgetName);
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

	@When("^user view the total and Open defect count$")
	public void user_view_the_total_and_Open_defect_count() throws Throwable {
		try
	       {
		   String requirement=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking",5,1));
		   afterTotalCount=dp.retrieveTotalDefectCountInTraceability(requirement);
		   afterOpenCount=dp.retrieveOpenDefectCountInTraceability(requirement);
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

	@Then("^defect count show updated count with status in added Traceability Gadget$")
	public void defect_count_show_updated_count_with_status_in_added_Traceability_Gadget() throws Throwable {
		 try
	       {
		    if(beforeOpenCount==afterOpenCount-1 )
		       {
		       System.out.println("Defect count updated successfully");  
		       } 
		     actual[50]=pp.backToProjectPage();
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
