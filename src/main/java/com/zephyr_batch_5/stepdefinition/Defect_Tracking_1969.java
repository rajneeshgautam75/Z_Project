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

public class Defect_Tracking_1969 extends LaunchBrowser{
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
	public String defectId;
	private int beforeDefectsFiledCount;
	private int beforeToDoCount;
	private int afterDefectsFiledCount;
	private int afterToDoCount;
	boolean[] actual=new boolean[64];
	SoftAssert soft=new SoftAssert();
	String fileName="DefectTracking_1969";
	
	@Given("^user is in administration page$")
	public void user_is_in_administration_page() throws Throwable {
		try
	     {
		 lp=new LoginPage(driver);
		 pp=new ProjectPage(driver);
		 bp=new BasePage();
		 rp=new ReleasePage(driver);
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

	@When("^user set DTS to jira$")
	public void user_set_DTS_to_jira() throws Throwable {
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

	@Then("^should be able to set dts to jira$")
	public void should_be_able_to_set_dts_to_jira() throws Throwable {
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

	@When("^user launch the textexecution$")
	public void user_launch_the_textexecution() throws Throwable {
	     try
           {
		   tr=new TestRepositoryPage(driver);
	       tp=new TestPlanningPage(driver);
	       ep=new ExecutionPage(driver); 
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

	@Then("^should be able to launch the textexecution$")
	public void should_be_able_to_launch_the_textexecution() throws Throwable {
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

	@When("^user link one defect to execution$")
	public void user_link_one_defect_to_execution() throws Throwable {
		 try
	       {
		   dt=new DefectTracking(driver);
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
		   actual[31]=ep.clickOnDefectButton(testcase);
		   bp.waitForElement();
		   actual[32]=ep.createDefect(project, issuetype);
		   bp.waitForElement();
		   actual[33]=dt.fileNewDefect(summary_1, components, descType, desc_1, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		   bp.waitForElement();
		   actual[34]=dt.saveDefect();
		   bp.waitForElement();
		   defectId=ep.retrieveDefectId();
		   bp.waitForElement();
		   actual[35]=dt.updateDefect();
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

	@Then("^should be able to link the defect to execution$")
	public void should_be_able_to_link_the_defect_to_execution() throws Throwable {
		try
	       {
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);	  
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

	@When("^user create the dashboard$")
	public void user_create_the_dashboard() throws Throwable {
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

	@Then("^should be able to create dashboard$")
	public void should_be_able_to_create_dashboard() throws Throwable {
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

	@When("^user launch the gadget page$")
	public void user_launch_the_gadget_page() throws Throwable {
		try
	       {
		   dp=new DashBoardPage(driver);	
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

	@Then("^should be able to launch the gadget page$")
	public void should_be_able_to_launch_the_gadget_page() throws Throwable {
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

	@When("^user add the overall gadget$")
	public void user_add_the_overall_gadget() throws Throwable {
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

	@Then("^should be able to add overall gadget$")
	public void should_be_able_to_add_overall_gadget() throws Throwable {
		 try
	       {
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 ,4 );	 
		   actual[47]=dp.validateGadget(gadgetName);
	       bp.waitForElement();
	       String defectStatusName_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 8);	
		   String defectStatusName_2=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 9);		
	       WebElement ele=driver.findElement(By.xpath(dp.defectStatus1+defectStatusName_1+dp.defectStatus2));
		   beforeToDoCount=Integer.parseInt(ele.getText());
		   WebElement ele1=driver.findElement(By.xpath(dp.defectStatus1+defectStatusName_2+dp.defectStatus2));
		   beforeDefectsFiledCount=Integer.parseInt(ele1.getText()); 
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

	@When("^user search the linked defect in jira$")
	public void user_search_the_linked_defect_in_jira() throws Throwable {
		 try
	       { 
		   actual[49]=pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[50]=dt.searchDefect(defectId);
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

	@Then("^should be able to search the linked defect in jira$")
	public void should_be_able_to_search_the_linked_defect_in_jira() throws Throwable {
		try
	       { 
		   actual[51]=dt.validateAdvancedSearch(defectId);
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

	@When("^user delete the linked defect$")
	public void user_delete_the_linked_defect() throws Throwable {
		 try
	       {
		   ejp=new ExternalJiraPage(driver);	 
		   int switch_1=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 1);
	       int switch_0=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 0);	 
		   String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
		   String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");	 	 	 	 
		   dt.clickOnDefectId.click();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.switchWindowTab(switch_1);
		   actual[52]=ejp.loginToExternalJira(username, password);
		   bp.waitForElement();
		   actual[53]=ejp.DeleteDefectInJira();
		   bp.waitForElement();
		   actual[54]=ejp.logOutFromExternal_JIRA();
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
	       driver.close();
	       Relogin_TPE rl=new Relogin_TPE();
	       rl.reLogin();
	       throw e; 
	       }

	    	  
	}

	@Then("^should be able to delete the linked defect$")
	public void should_be_able_to_delete_the_linked_defect() throws Throwable {
		 try
	       {
		   String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);	 
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 	 
		   String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26); 
		   String[] str=new String[2];
		   str[0]=cycle;
		   str[1]=phase;
		   actual[55]=rp.clickOnTestExecution();
		   bp.waitForElement();
		   actual[56]=tr.navigateToNode(releaseName, str);
		   bp.waitForElement();
		   actual[57]=ep.viewDeletedDefectStatus(testcase);
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

	@When("^user refresh the added overall gadget$")
	public void user_refresh_the_added_overall_gadget() throws Throwable {
		try
	       {
		   String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);		 	 
		   String value=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 7);		 	 
		   actual[58]=dp.clickOnManageDashboards();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[59]=dp.searchDashboard(dashboard);
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[60]=dp.selectDashboard(dashboard);
		   bp.waitForElement();
           actual[61]=dp.gadgetOperation(value);
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

	@Then("^should be able to refresh the added overall gadget$")
	public void should_be_able_to_refresh_the_added_overall_gadget() throws Throwable {
		try
	       {
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 ,4 );	  
		   actual[62]=dp.validateGadget(gadgetName);
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

	@When("^user view the Defect count by status$")
	public void user_view_the_Defect_count_by_status() throws Throwable {
		 try
	       {
			String defectStatusName_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 8);	
			String defectStatusName_2=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 9);		
			WebElement ele=driver.findElement(By.xpath(dp.defectStatus1+defectStatusName_1+dp.defectStatus2));
			afterToDoCount=Integer.parseInt(ele.getText());
		    WebElement ele1=driver.findElement(By.xpath(dp.defectStatus1+defectStatusName_2+dp.defectStatus2));
			afterDefectsFiledCount=Integer.parseInt(ele1.getText());
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

	@Then("^Defect count show updated count with status$")
	public void defect_count_show_updated_count_with_status() throws Throwable {
		 try
	       {
            if(beforeDefectsFiledCount==afterDefectsFiledCount-1 && beforeToDoCount==afterToDoCount+1)
            {
          	  System.out.println("Defect count updated successfully");  
            }
            actual[63]=pp.backToProjectPage();
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
