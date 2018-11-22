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

public class DefectTracking_247 extends LaunchBrowser{
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	DashBoardPage dp;
	ExecutionPage ep;
	CreateTestCasePage ctc;
	LaunchBrowser lb;
	LoginPage lp;
	ExportPage ex;
	RequirementsPage req;
	DefectTracking dt;
	ExternalJiraPage ejp;
	public String defectId;
	private int beforeOpenCount;
	private int afterOpenCount;
	private int afterTotalCount;
	private int beforeTotalCount;
	boolean[] actual=new boolean[51];
	SoftAssert soft=new SoftAssert();
	String fileName="DefectTracking_247";
	
	@Given("^User Is In Administration Page$")
	public void user_Is_In_Administration_Page() throws Throwable {
		try
	     {
	     bp=new BasePage();
	     rp=new ReleasePage(driver);
	     pp=new ProjectPage(driver);
	     dt=new DefectTracking(driver);
	     ctc=new CreateTestCasePage(driver);
	     ep=new ExecutionPage(driver);
	     dp=new DashBoardPage(driver);
	     lp=new LoginPage(driver);
	     tr=new TestRepositoryPage(driver);
	     tp=new TestPlanningPage(driver);
	     ep=new ExecutionPage(driver); 
	     ejp=new ExternalJiraPage(driver);
	     req=new RequirementsPage(driver);
	     String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     actual[0]=pp.clickOnLogout();
	     bp.waitForElement();
	     actual[1]=lp.enterUnameAndPassword(name, passWord);
	     bp.waitForElement();
	     actual[2]=pp.launchAdministration();
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

	@When("^User set DTS to Jira$")
	public void user_set_DTS_to_Jira() throws Throwable {
		 try
	       {
		   String dts=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",2 , 0);	 
		   String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
		   String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
		   String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		   actual[3]=pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[4]=pp.setDTS(dts, url, username, password);
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

	@Then("^Should be able to Set DTS to Jira$")
	public void should_be_able_to_Set_DTS_to_Jira() throws Throwable {
		try
	       {
		   String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
		   String pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
		   actual[5]=pp.validateSetDTS();
		   bp.waitForElement();
		   actual[6]=pp.clickOnLogout();
		   bp.waitForElement();
		   lp.enterUname(name);
		   lp.enterPass(pass);
		   actual[7]=lp.clickOnLogin();
		  // actual[7]=lp.enterUnameAndPassword(name, pass);
		   bp.waitForElement();
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

	@When("^User launch TestExecution$")
	public void user_launch_TestExecution() throws Throwable {
		 try
	       {
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

	@Then("^Should be able to launch TestExecution$")
	public void should_be_able_to_launch_TestExecution() throws Throwable {
		try
	       {
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

	@When("^User link One defect with status ToDo to execution$")
	public void user_link_One_defect_with_status_ToDo_to_execution() throws Throwable {
		 try
	       {
		   tr=new TestRepositoryPage(driver);
	       rp=new ReleasePage(driver);
	       tp=new TestPlanningPage(driver);
	       ep=new ExecutionPage(driver);  
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   String summary_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 29);
	       String components=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 3);
		   String descType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 4);
		   String desc_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 28);
		   String fixVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 6);
		   String priority=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 7);
		   String assignee=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 8);
		   String labels=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 9);
		   String sprint=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 10);
		   String env=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 11);
		   String epicLink=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 12);
		   String affectsVersion=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 13);
		   String linkedIssue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 14);
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26); 
		   actual[15]=ep.clickOnDefectButton(testcase);
		   bp.waitForElement();
		   actual[16]=ep.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[17]=dt.fileNewDefect(summary_1, components, descType, desc_1, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		   bp.waitForElement();
		   actual[18]=dt.saveDefect();
		   bp.waitForElement();
		   defectId=ep.retrieveDefectId();
		   bp.waitForElement();
		   actual[19]=dt.updateDefect();
		   bp.waitForElement();
		   ep.cancelDefect.click();
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

	@Then("^should be able to link defect with status ToDo to execution$")
	public void should_be_able_to_link_defect_with_status_ToDo_to_execution() throws Throwable {
		try
	       {
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);	  
		   actual[20]=ep.validateLinkedDefect(testcase, defectId);
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

	@When("^User create the DashBoards$")
	public void user_create_the_DashBoards() throws Throwable {
		 try
	       {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);	 
		   String desc=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 1);
		   String layout=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 2);
		   String shareType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 3);
		   actual[21]=dp.clickOnManageDashboards(); 
		   bp.waitForElement();
		   actual[22]=dp.clickOnAddDashBoardSymbol();
		   bp.waitForElement();
		   actual[23]=dp.enterDashBoardDetails(name, desc, layout, shareType);
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

	@Then("^Should be able to create the DashBoards$")
	public void should_be_able_to_create_the_DashBoards() throws Throwable {
		try
	       {
		   String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);	 
		   actual[24]=dp.validateDashBoard(dashBoard);
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

	@When("^User launch the gadaget Page$")
	public void user_launch_the_gadaget_Page() throws Throwable {
		 try
	     {
		   String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);		 	
		   actual[25]=dp.searchDashboard(dashboard);
		   bp.waitForElement();
		   actual[26]=dp.selectDashboard(dashboard);
		   bp.waitForElement();
		   actual[27]=dp.clickOnAddGadgetSymbol();
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

	@Then("^Should be Able to launch the gadget Page$")
	public void should_be_Able_to_launch_the_gadget_Page() throws Throwable {
		try
	       {
		   actual[28]=dp.verifyAddGadgetPage();
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

	@When("^User add traceability gadget$")
	public void user_add_traceability_gadget() throws Throwable {
		try
	       {
		   String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		   String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		   String refreshRate=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 ,5);
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",4 ,12);
		   String requirement=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",6,3);
		   actual[29]=dp.addGadget(gadgetName);
		   bp.waitForElement();
		   actual[30]=dp.configureTraceabilityGadget(project, release, refreshRate);
		   bp.waitForElement(); 
		   actual[31]=dp.manageTraceability();
		   bp.waitForElement();
		   actual[32]=dp.traceabilityQuickSearch(requirement);
		   bp.waitForElement();
		   actual[33]=dp.selectAllRequirements();
		   bp.waitForElement();
		   actual[34]=dp.closeTraceabilityTable();
		   bp.waitForElement();
		   actual[35]=dp.saveTraceabilityGadget();
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

	@Then("^Should be able to add traceability gadget$")
	public void should_be_able_to_add_traceability_gadget() throws Throwable {
		try
	       {
		   String requirement=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking",5,3));	
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",4,12 );	
		   actual[36]=dp.validateTraceabilityGadget(gadgetName);
		   bp.waitForElement();
		   beforeTotalCount=dp.retrieveTotalDefectCountInTraceability(requirement);
		   beforeOpenCount=dp.retrieveOpenDefectCountInTraceability(requirement);
	       actual[37]=pp.backToProjectPage();
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

	@When("^User search that defect in JIRA and Delete it$")
	public void user_search_that_defect_in_JIRA_and_Delete_it() throws Throwable {
		 try
	       { 
		   int switch_1=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 1);
	       int switch_0=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 0);	 
		   String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
		   String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");	 	 	 	 	 
		   actual[38]=pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[39]=dt.searchDefect(defectId);
		   bp.waitForElement(); 
		   dt.clickOnDefectId.click();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.switchWindowTab(switch_1);
		   actual[40]=ejp.loginToExternalJira(username, password);
		   bp.waitForElement();
		   actual[41]=ejp.DeleteDefectInJira();
		   bp.waitForElement();
		   actual[42]=ejp.logOutFromExternal_JIRA();
		   bp.waitForElement();
		   driver.close();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.switchWindowTab(switch_0);
		   bp.waitForElement();
		   bp.waitForElement();	
		   }
	     catch(Exception e)
	       {
	       lb=new LaunchBrowser();	 
	       lb.getScreenShot(fileName);
	       e.printStackTrace();
	       driver.quit();
	       Relogin_TPE rl=new Relogin_TPE();
	       rl.reLogin();
	       throw e; 
	       }
	}

	@Then("^Should search that defect and delete$")
	public void should_search_that_defect_and_delete() throws Throwable {
		try
	       {
		   String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);	 
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 	 
		   String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26); 
		   String[] str=new String[2];
		   str[0]=cycle;
		   str[1]=phase;
		   actual[43]=rp.clickOnTestExecution();
		   bp.waitForElement();
		   actual[44]=tr.navigateToNode(releaseName, str);
		   bp.waitForElement();
		   actual[45]=ep.viewDeletedDefectStatus(testcase);
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

	@When("^User refresh the added traceability gadget$")
	public void user_refresh_the_added_traceability_gadget() throws Throwable {
		try
	       {
		   String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);		 	 
		   String value=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 7);		 	 
		   actual[46]=dp.clickOnManageDashboards();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[47]=dp.searchDashboard(dashboard);
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[48]=dp.selectDashboard(dashboard);
		   bp.waitForElement();
           actual[49]=dp.gadgetOperation(value);
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

	@Then("^Should be able to refresh the added traceability gadget$")
	public void should_be_able_to_refresh_the_added_traceability_gadget() throws Throwable {
		try
	       {
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",4 ,12);	  
		   actual[50]=dp.validateGadget(gadgetName);
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

	@When("^User view the Total and open defect count$")
	public void user_view_the_Total_and_open_defect_count() throws Throwable {
		 try
	       {
		   String requirement=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking",5,3));	
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

	@Then("^Defect count show updated count with status in Traceability gadget$")
	public void defect_count_show_updated_count_with_status_in_Traceability_gadget() throws Throwable {
		 try
	       {
			  if(beforeOpenCount==afterOpenCount-1 )
		       {
		       System.out.println("Defect count updated successfully");  
		       }  
			   for(int k=0;k<=actual.length-1;k++)
       	       {
       	       System.out.println("Actual["+k+"]="+actual[k]);
       	       soft.assertEquals(actual[k], true);
       	       }
       	       soft.assertAll();
       	       bp.waitForElement();
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
