package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_242 extends LaunchBrowser{
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
	private int beforeMajorPriorityCount;
	private int minorPriorityCount;
	private int afterMajorPriorityCount;
	boolean[] actual=new boolean[49];
	SoftAssert soft=new SoftAssert();
	String fileName="Defect_Tracking_242";

	@Given("^user is in Administration Page$")
	public void user_is_in_Administration_Page() throws Throwable {
		try
	     {
	     bp=new BasePage();
	     rp=new ReleasePage(driver);
	     pp=new ProjectPage(driver);
	     lp=new LoginPage(driver);
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

	@When("^user set the dts to jira$")
	public void user_set_the_dts_to_jira() throws Throwable {
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

	@Then("^should be able to set the dts to jira$")
	public void should_be_able_to_set_the_dts_to_jira() throws Throwable {
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
		   actual[7]=lp.enterUnameAndPassword(name, pass);
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

	@When("^user Launch the testexecution$")
	public void user_Launch_the_testexecution() throws Throwable {
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

	@Then("^should be able to Launch the testexecution$")
	public void should_be_able_to_Launch_the_testexecution() throws Throwable {
	     try
	       {
	       tr=new TestRepositoryPage(driver);
		   ep=new ExecutionPage(driver); 
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

	@When("^user link one defect with status open to execution$")
	public void user_link_one_defect_with_status_open_to_execution() throws Throwable {
		try
	       {
		   ejp=new ExternalJiraPage(driver);
	       int switch_1=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 1);
	       int switch_0=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 0);	 
	       String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
		   String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");	 
		   String statusType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 8);	 	 
	       int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);	 
	       String defectId=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 10);
	       String[] priority=new String[3];
		   priority[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 13);
	       actual[15]=ep.clickOnDefectButton(testcase);
		   bp.waitForElement();
		   actual[16]=ep.searchDefect(defectId);		
		   bp.waitForElement();
		   ep.clickOnLinkDefectID.click();
		   bp.waitForElement();
		   bp.switchWindowTab(switch_1);
		   bp.waitForElement();
		   actual[17]=ejp.loginToExternalJira(username, password);
		   bp.waitForElement();
		   actual[18]=ejp.changeDefectStatusInExternalJira(statusType);
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[19]=ejp.enterPriority(priority);
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[20]=ejp.logOutFromExternal_JIRA();
		   bp.waitForElement();
		   driver.close();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.switchWindowTab(switch_0);
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[21]=ep.linkDefect();
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

	@Then("^should be able to link defect with status open to execution$")
	public void should_be_able_to_link_defect_with_status_open_to_execution() throws Throwable {
		 try
	       {
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);	 
		   String defectId=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 10);	 
		   actual[22]=ep.validateLinkedDefect(testcase, defectId);
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

	@When("^user create Dashboard$")
	public void user_create_Dashboard() throws Throwable {
		 try
	       {
		   dp=new DashBoardPage(driver);		 
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);	 
		   String desc=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 1);
		   String layout=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 2);
		   String shareType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 3);
		   actual[23]=dp.clickOnManageDashboards(); 
		   bp.waitForElement();
		   actual[24]=dp.clickOnAddDashBoardSymbol();
		   bp.waitForElement();
		   actual[25]=dp.enterDashBoardDetails(name, desc, layout, shareType);
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
	
	@Then("^should be able to create Dashboard$")
	public void should_be_able_to_create_Dashboard() throws Throwable {
		try
	       {
		  String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);	 
		  actual[26]=dp.validateDashBoard(dashBoard);
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
	@When("^user launch the Gadget Page$")
	public void user_launch_the_Gadget_Page() throws Throwable {
	 try
     {
	   String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);		 	
	   actual[27]=dp.searchDashboard(dashboard);
	   bp.waitForElement();
	   actual[28]=dp.selectDashboard(dashboard);
	   bp.waitForElement();
	   actual[29]=dp.clickOnAddGadgetSymbol();
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

	@Then("^should be able to launch the Gadget Page$")
	public void should_be_able_to_launch_the_Gadget_Page() throws Throwable {
		try
	       {
		   actual[30]=dp.verifyAddGadgetPage();
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

	@When("^user add the open gadget$")
	public void user_add_the_open_gadget() throws Throwable {
		 try
	       {
		   String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		   String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		   String refreshRate=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 ,5);
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 ,12);
		   actual[31]=dp.addGadget(gadgetName);
		   bp.waitForElement();
		   actual[32]=dp.configureTestAutomationStatusGadget(project, release, refreshRate);
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

	@Then("^should be able to add open gadget$")
	public void should_be_able_to_add_open_gadget() throws Throwable {
		 try
	       {
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 ,4 );	
		   String priorityName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 ,13 );
		   actual[33]=dp.validateGadget(gadgetName);
	       bp.waitForElement();
	       beforeMajorPriorityCount=dp.validatePriorityCount(priorityName);
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

	@When("^user search that linked defect in JIRA$")
	public void user_search_that_linked_defect_in_JIRA() throws Throwable {
		try
	       {
		   dt=new DefectTracking(driver);
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 10);	 
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

	@Then("^should be able to search the linked defecct in JIRA$")
	public void should_be_able_to_search_the_linked_defecct_in_JIRA() throws Throwable {
		try
	       {
		   String defectname=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 10);	 
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

	@When("^user change the priority of linked defect$")
	public void user_change_the_priority_of_linked_defect() throws Throwable {
		 try
	       {
		   int switch_1=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 1);
		   int switch_0=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 0);	 	 
		   String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
		   String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");	 
		   String[] priority=new String[3];
		   priority[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 14);
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 10);	 
		   bp.waitForElement();
		   actual[38]=dp.searchAndSelectDefect(defectID);
		   bp.waitForElement();
		   bp.switchWindowTab(switch_1);
		   bp.waitForElement();
		   actual[39]=ejp.loginToExternalJira(username, password);
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[40]=ejp.enterPriority(priority);
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
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

	@Then("^should be able to change priority of linked defect$")
	public void should_be_able_to_change_priority_of_linked_defect() throws Throwable {
		try
	       {
			String priority=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 14);	
			actual[42]=ejp.validatePriority(priority);
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

	@When("^user refresh the added open gadget$")
	public void user_refresh_the_added_open_gadget() throws Throwable {
		 try
	       {
		   String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);		 	 
		   String value=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 7);		 	 
		   actual[43]=dp.clickOnManageDashboards();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[44]=dp.searchDashboard(dashboard);
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[45]=dp.selectDashboard(dashboard);
		   bp.waitForElement();
           actual[46]=dp.gadgetOperation(value);
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

	@Then("^should be able to refresh the open gadget$")
	public void should_be_able_to_refresh_the_open_gadget() throws Throwable {
		 try
	       {
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 ,12 );	  
		   actual[47]=dp.validateGadget(gadgetName);
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

	@When("^user view the defect count by priority$")
	public void user_view_the_defect_count_by_priority() throws Throwable {
		 try
	       {
		   String priorityName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 ,13 );	
	       afterMajorPriorityCount=dp.validatePriorityCount(priorityName);
	   	   String priorityName_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 ,14 );	
		   minorPriorityCount=dp.validatePriorityCount(priorityName_1);
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

	@Then("^defect count show updated count with priority$")
	public void defect_count_show_updated_count_with_priority() throws Throwable {
		 try
	       {
            if(beforeMajorPriorityCount==afterMajorPriorityCount-1 )
            {
          	  System.out.println("Defect count updated successfully");  
            }
            actual[48]=pp.backToProjectPage();
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
