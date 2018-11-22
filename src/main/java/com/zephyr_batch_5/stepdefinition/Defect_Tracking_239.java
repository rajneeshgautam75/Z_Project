package com.zephyr_batch_5.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_239 extends LaunchBrowser{
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	DashBoardPage dp;
	ExecutionPage ep;
	LaunchBrowser lb;
	LoginPage lp;
	DefectTracking dt;
	ExternalJiraPage ejp;
	private int beforeToDoCount;
	private int beforeInProgressCount;
	private int afterToDoCount;
	private int afterInProgressCount;
	boolean[] actual=new boolean[65];
	SoftAssert soft=new SoftAssert();
	String fileName="DefectTracking_239";

	@Given("^User is in administration page$")
	public void user_is_in_administration_page() throws Throwable {
	   try
	     {
	     bp=new BasePage();
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

	@When("^User set the DTS to JIRA$")
	public void user_set_the_DTS_to_JIRA() throws Throwable {
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

	@Then("^Should be able to set the DTS to JIRA$")
	public void should_be_able_to_set_the_DTS_to_JIRA() throws Throwable {
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

	@When("^User launch the testexecution$")
	public void user_launch_the_testexecution() throws Throwable {
	        try
	          {
			   tr=new TestRepositoryPage(driver);
			   rp=new ReleasePage(driver);
		       ep=new ExecutionPage(driver); 
		       tp=new TestPlanningPage(driver);
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
			   String desc=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 18);
			   String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
			   String build=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 20);
			   String environ=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 21);
			   String hide=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 22);
			   String bulk_type_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 23);
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			   String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 0));
			   String smonth=Excel_Lib.getData(INPUT_PATH_6,"TestCycle", 1, 1);
			   String sdate=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 2));
			   String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 3));
			   String emonth=Excel_Lib.getData(INPUT_PATH_6,"TestCycle", 1, 4);
			   String edate=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 5));  
			   int[] defectNo=new int[1];
			   defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
			   String cyclename[]=new String[1];
			   cyclename[0]=cycle;
			   String phase1[]=new String[1];
			   phase1[0]=name;
			   actual[10]=rp.clickOnTestRep();
			   bp.waitForElement();
			   actual[11]=tr.clickOnRelease(releaseName);
			   bp.waitForElement();
			   actual[12]=tr.addNode(name, desc);
			   bp.waitForElement();
			   actual[13]=tr.doubleClickOnRelease(releaseName);
			   bp.waitForElement();
			   actual[14]=tr.navigateToNode(releaseName,phase1);
			   bp.waitForElement();
			   actual[15]=tr.addTestCase();
			   actual[16]=tr.addTestCase();
			   bp.waitForElement();
			   actual[17]=rp.clickOnTestPlanning();
			   bp.waitForElement();
			   actual[18]=tp.clickOnAddTestCycleSymbol();
			   bp.waitForElement();
			   actual[19]=tp.CreateCycle(cycle, build, environ, hide);
			   bp.waitForElement();
			   actual[20]=tp.enterStartDatAndEndDate(syear, smonth, sdate, eyear, emonth, edate);
			   bp.waitForElement();
			   actual[21]=tp.saveTestCycle();
			   bp.waitForElement();
			   actual[22]=tp.navigateToCycle(cyclename);
			   bp.waitForElement();
			   actual[23]=tp.addPhaseToCycle(name);
			   bp.waitForElement();
			   actual[24]=tp.bulkAssignment(bulk_type_1);
			   bp.waitForElement();
			   actual[25]=tp.goBackToCycle();
			   bp.waitForElement();
    		   actual[26]=rp.clickOnTestExecution();
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

	@Then("^Should be able to launch testexecution$")
	public void should_be_able_to_launch_testexecution() throws Throwable {
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
		   actual[27]=ep.verifyExecutionPage();
		   bp.waitForElement();
		   actual[28]=tr.navigateToNode(releaseName, str);
		   bp.waitForElement();
		   actual[29]=ep.selectAndDeselectAllTestCase();
		   bp.waitForElement();
		   actual[30]=ep.changeMultiSelectedStatus(status);
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

	@When("^User link one defect with status open to execution$")
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
	       actual[31]=ep.clickOnDefectButton(testcase);
		   bp.waitForElement();
		   actual[32]=ep.searchDefect(defectId);		
		   bp.waitForElement();
		   ep.clickOnLinkDefectID.click();
		   bp.waitForElement();
		   bp.switchWindowTab(switch_1);
		   bp.waitForElement();
		   actual[33]=ejp.loginToExternalJira(username, password);
		   bp.waitForElement();
		   actual[34]=ejp.changeDefectStatusInExternalJira(statusType);
		   bp.waitForElement();
		   actual[35]=ejp.logOutFromExternal_JIRA();
		   bp.waitForElement();
		   driver.close();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.switchWindowTab(switch_0);
		   bp.waitForElement();
		   bp.waitForElement();
//		   ep.linkDefects.click();
//		   bp.waitForElement();
//		   bp.waitForElement();
//		   ep.cancelDefect.click();
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

	@Then("^Should be able to link the defect$")
	public void should_be_able_to_link_the_defect() throws Throwable {
		 try
	       {
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);	 
		   String defectId=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 10);	 
		   actual[36]=ep.validateLinkedDefect(testcase, defectId);
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

	@When("^User create the dashboards$")
	public void user_create_the_dashboards() throws Throwable {
		 try
	       {
		   dp=new DashBoardPage(driver);
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);	 
		   String desc=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 1);
		   String layout=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 2);
		   String shareType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 3);
		   actual[37]=dp.clickOnManageDashboards(); 
		   bp.waitForElement();
		   actual[38]=dp.clickOnAddDashBoardSymbol();
		   bp.waitForElement();
		   actual[39]=dp.enterDashBoardDetails(name, desc, layout, shareType);
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

	@Then("^Should be able to add dashboards$")
	public void should_be_able_to_add_dashboards() throws Throwable {
		 try
	       {
		   String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);	 
		   actual[40]=dp.validateDashBoard(dashBoard);
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

	@When("^User launch the gadget$")
	public void user_launch_the_gadget() throws Throwable {
		 try
	       {
		   String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);		 	
		   actual[41]=dp.searchDashboard(dashboard);
		   bp.waitForElement();
		   actual[42]=dp.selectDashboard(dashboard);
		   bp.waitForElement();
		   actual[43]=dp.clickOnAddGadgetSymbol();
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

	@Then("^Should be able to launch the gadget$")
	public void should_be_able_to_launch_the_gadget() throws Throwable {
		 try
	       {
		   actual[44]=dp.verifyAddGadgetPage();
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

	@When("^User add overall gadget$")
	public void user_add_overall_gadget() throws Throwable {
		 try
	       {
		   String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		   String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		   String refreshRate=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 ,5 );
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 ,4 );
		   actual[45]=dp.addGadget(gadgetName);
		   bp.waitForElement();
		   actual[46]=dp.configureTestAutomationStatusGadget(project, release, refreshRate);
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

	@Then("^Should be able to add overall gadget$")
	public void should_be_able_to_add_overall_gadget() throws Throwable {
		 try
	       {
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 ,4 );	 
	       String defectStatusName_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 8);	
		   String defectStatusName_2=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 9);		
		   actual[47]=dp.validateGadget(gadgetName);
	       bp.waitForElement();
		   WebElement ele=driver.findElement(By.xpath(dp.defectStatus1+defectStatusName_1+dp.defectStatus2));
		   beforeToDoCount=Integer.parseInt(ele.getText());
		   WebElement ele1=driver.findElement(By.xpath(dp.defectStatus1+defectStatusName_2+dp.defectStatus2));
		   beforeInProgressCount=Integer.parseInt(ele1.getText()); 
	       actual[48]=pp.backToProjectPage();
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

	@When("^User search that linked defect in DefectTracking$")
	public void user_search_that_linked_defect_in_DefectTracking() throws Throwable {
		 try
	       {
		   dt=new DefectTracking(driver);
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 10);	 
		   actual[49]=pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[50]=dt.searchDefect(defectID);
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

	@Then("^Should be able to search that linked defect$")
	public void should_be_able_to_search_that_linked_defect() throws Throwable {
		 try
	       {
		   String defectname=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 10);	 
		   actual[51]=dt.validateAdvancedSearch(defectname);
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

	@When("^User change the status from open to inprogress$")
	public void user_change_the_status_from_open_to_inprogress() throws Throwable {
		 try
	       {
		   ejp=new ExternalJiraPage(driver);
		   int switch_1=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 1);
		   int switch_0=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 0);	 	 
		   String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
		   String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");	 
		   String statusType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 6);
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 10);	 
		   bp.waitForElement();
		   actual[52]=dp.searchAndSelectDefect(defectID);
		   bp.waitForElement();
		   bp.switchWindowTab(switch_1);
		   bp.waitForElement();
		   actual[53]=ejp.loginToExternalJira(username, password);
		   bp.waitForElement();
		   actual[54]=ejp.changeDefectStatusInExternalJira(statusType);
		   bp.waitForElement();
		   actual[55]=ejp.logOutFromExternal_JIRA();
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

	@Then("^Should be able to change the status$")
	public void should_be_able_to_change_the_status() throws Throwable {
		 try
	       {
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);	 	 
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		   String phase1[]=new String[1];
		   phase1[0]=name;
		   actual[56]=rp.clickOnTestExecution();
		   bp.waitForElement();
		   actual[57]=tr.navigateToNode(releaseName,phase1);
		   bp.waitForElement();
		   actual[58]=ep.viewTooltip(testcase);
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

	@When("^User refresh the added overall gadget$")
	public void user_refresh_the_added_overall_gadget() throws Throwable {
		 try
	       {
		   String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);		 	 
		   String value=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 7);		 	 
		   actual[59]=dp.clickOnManageDashboards();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[60]=dp.searchDashboard(dashboard);
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[61]=dp.selectDashboard(dashboard);
		   bp.waitForElement();
           actual[62]=dp.gadgetOperation(value);
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

	@Then("^Should be able to refresh the overall gadget$")
	public void should_be_able_to_refresh_the_overall_gadget() throws Throwable {
		 try
	       {
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 ,4 );	  
		   actual[63]=dp.validateGadget(gadgetName);
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

	@When("^view the defect count by status$")
	public void view_the_defect_count_by_status() throws Throwable {
		 try
	       {
			String defectStatusName_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 8);	
			String defectStatusName_2=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 9);		
			WebElement ele=driver.findElement(By.xpath(dp.defectStatus1+defectStatusName_1+dp.defectStatus2));
			afterToDoCount=Integer.parseInt(ele.getText());
		    WebElement ele1=driver.findElement(By.xpath(dp.defectStatus1+defectStatusName_2+dp.defectStatus2));
			afterInProgressCount=Integer.parseInt(ele1.getText());
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

	@Then("^defect count show updated count with status$")
	public void defect_count_show_updated_count_with_status() throws Throwable {
		 try
	       {
              if(beforeToDoCount==afterToDoCount-1 && beforeInProgressCount==afterInProgressCount+1)
              {
            	  System.out.println("Defect count updated successfully");  
              }
              actual[64]=pp.backToProjectPage();
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
