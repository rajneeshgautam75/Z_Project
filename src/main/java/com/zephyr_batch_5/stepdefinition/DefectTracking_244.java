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

public class DefectTracking_244 extends LaunchBrowser{
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
	private int beforeOpenCount;
	private int afterOpenCount;
	private int afterTotalCount;
	private int beforeTotalCount;
	boolean[] actual=new boolean[98];
	SoftAssert soft=new SoftAssert();
	String fileName="DefectTracking_244";

	@Given("^User Is in administration page$")
	public void user_Is_in_administration_page() throws Throwable {
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

	@When("^user set dts to Jira$")
	public void user_set_dts_to_Jira() throws Throwable {
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

	@Then("^should be able to set$")
	public void should_be_able_to_set() throws Throwable {
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

	@When("^user click on Requiremetns$")
	public void user_click_on_Requiremetns() throws Throwable {
		 try
	       {	 
		   actual[10]=rp.clickOnRequirements();
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

	@Then("^should be able to launch Requirements$")
	public void should_be_able_to_launch_Requirements() throws Throwable {
		 try
	       {
		   actual[11]=req.validateRequirementPage();
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

	@When("^user create a node and add Requirements$")
	public void user_create_a_node_and_add_Requirements() throws Throwable {
		 try
	       {
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 7,0);
		   String desc=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 18);
		   String altID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 100);
		   String link=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 100);
		   String priority=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",100, 100);
		   String description=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 100);
		   String reqName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 6,0 );
		   String reqName1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 6,1 );
		   String reqName2=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 6,2 );
		   String reqName3=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 6,3 );
		   String[] testcase=new String[4];
		   testcase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 5, 0));	 
		   testcase[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 5, 1));	 
		   testcase[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 5, 2));	 
		   testcase[3]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 5, 3));	 
		   String phase1[]=new String[1];
		   phase1[0]=name;
		   actual[12]=tr.clickOnRelease(releaseName); 
		   bp.waitForElement();
		   actual[13]=req.addNode(name, desc);
           bp.waitForElement();
           actual[14]=req.navigateToNode(releaseName,phase1);
           bp.waitForElement();
           actual[15]=req.addRequirement();
           actual[16]=req.addRequirement();
           actual[17]= req.addRequirement();
           actual[18]=req.addRequirement();
           bp.waitForElement();
           actual[19]=tr.clickOnDetails();
           bp.waitForElement();
           actual[20]=req.selectRequirement(testcase[0]);
           actual[21]=req.enterRequirementDetails(reqName, altID, link, priority, description);
           actual[22]=req.selectRequirement(testcase[1]);
           actual[23]=req.enterRequirementDetails(reqName1, altID, link, priority, description);
           actual[24]=req.selectRequirement(testcase[2]);
           actual[25]=req.enterRequirementDetails(reqName2,altID, link, priority, description);
           actual[26]=req.selectRequirement(testcase[3]);
           actual[27]=req.enterRequirementDetails(reqName3, altID, link, priority, description);
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

	@Then("^should be able to add Requirements$")
	public void should_be_able_to_add_Requirements() throws Throwable {
		 try
	       {
		   actual[28]=req.VerifyRequirementCount();
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

	@When("^user launch the Test repository$")
	public void user_launch_the_Test_repository() throws Throwable {
		 try
	       {
		   actual[29]=rp.clickOnTestRep();
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

	@Then("^should be able to launch the Test repository$")
	public void should_be_able_to_launch_the_Test_repository() throws Throwable {
		 try
	       {
		   actual[30]=tr.validateTestRepositoryPage();
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

	@When("^user create phase and add the testcases$")
	public void user_create_phase_and_add_the_testcases() throws Throwable {
		 try
	       {
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		    String desc=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 18);
		    String phase1[]=new String[1];
		    phase1[0]=name;
		    actual[31]=tr.clickOnRelease(releaseName); 
	      	bp.waitForElement();
	      	actual[32]=tr.addNode(name, desc);
	      	actual[33]=tr.navigateToNode(releaseName,phase1); 
	      	actual[34]=tr.addTestCase();
	      	actual[35]=tr.addTestCase();
	      	actual[36]=tr.addTestCase();
	      	actual[37]=tr.addTestCase();
	      	actual[38]=bp.waitForElement();   
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

	@Then("^should be able to add testcases$")
	public void should_be_able_to_add_testcases() throws Throwable {
		 try
	       {
		   actual[39]=tr.verifyPresentTestCase();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[40]=tr.selectallTestCase();
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

	@When("^user map testcases to requiremetns$")
	public void user_map_testcases_to_requiremetns() throws Throwable {
		 try
	       {
           String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");	 
           String[] testcase=new String[4];
		   testcase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 5, 0));	 
		   testcase[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 5, 1));	 
		   testcase[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 5, 2));	 
		   testcase[3]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 5, 3));	
           String phase1[]=new String[1];
		   phase1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",  7,0);
		   actual[41]=tr.clickOnMap();
		   bp.waitForElement(); 
		   actual[42]=req.ExpandRelease(releaseName);
		   bp.waitForElement(); 
		   actual[43]=tr.navigateNode(phase1);
		   bp.waitForElement();
		   actual[44]=tr.selectMultipleRequirementFromGrid(testcase);
		   bp.waitForElement();
		   bp.waitForElement();
		   req.clickOnSavejirareq1.click();
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

	@Then("^should be able to map$")
	public void should_be_able_to_map() throws Throwable {
		 try
	       {
			 int requirement=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 5, 0);
			 int[] testcase=new int[4];
			 for(int i=0;i<=testcase.length-1;i++)
			 {
			   testcase[i]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 5, i);
			  actual[45]= tr.validateMappedRequirementInList(testcase[i], requirement);
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

	@When("^user launch Test planning$")
	public void user_launch_Test_planning() throws Throwable {
		 try
	       {
		   actual[46]=rp.clickOnTestPlanning();
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

	@Then("^should be able to launch Test planning$")
	public void should_be_able_to_launch_Test_planning() throws Throwable {
		 try
	       {
		   actual[47]=tp.validateTestPlanningPage();
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

	@When("^user create cycle and assign phase to users$")
	public void user_create_cycle_and_assign_phase_to_users() throws Throwable {
		 try
	       {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		   String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		   String build=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 20);
		   String environ=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 21);
		   String hide=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 22);
		   String bulk_type_2=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 24);
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
		   actual[48]=tp.clickOnAddTestCycleSymbol();
	       bp.waitForElement();
	       actual[49]=tp.CreateCycle(cycle, build, environ, hide);
		   bp.waitForElement();
		   actual[50]=tp.enterStartDatAndEndDate(syear, smonth, sdate, eyear, emonth, edate);
		   bp.waitForElement();
		   actual[51]=tp.saveTestCycle();
		   bp.waitForElement();
		   actual[52]=tp.navigateToCycle(cyclename);
		   bp.waitForElement();
		   actual[53]=tp.addPhaseToCycle(name);
		   bp.waitForElement();
		   actual[54]=tp.bulkAssignment(bulk_type_2);  
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

	@Then("^should be able to assign testcases to users$")
	public void should_be_able_to_assign_testcases_to_users() throws Throwable {
		 try
	       {
		   int[] testcase=new int[4];
		   testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 5, 0);	 
		   testcase[1]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 5, 1);	 
		   testcase[2]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 5, 2);	 
		   testcase[3]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 5, 3);		 
		   String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		   actual[55]=tp.doubleClickOnCycle(name);
		   bp.waitForElement();
		   actual[56]=tp.validateAllAssigned(testcase, assignee);
		   bp.waitForElement();
		   actual[57]=tp.goBackToCycle();
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

	@When("^user launch Test execution$")
	public void user_launch_Test_execution() throws Throwable {
		 try
	       {
		   actual[58]=rp.clickOnTestExecution();
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

	@Then("^should be able to launch Test execution$")
	public void should_be_able_to_launch_Test_execution() throws Throwable {
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
		   actual[59]=ep.verifyExecutionPage();
		   bp.waitForElement();
		   actual[60]=tr.navigateToNode(releaseName, str);
		   bp.waitForElement();
		   actual[61]=ep.selectAndDeselectAllTestCase();
		   bp.waitForElement();
		   actual[62]=ep.changeMultiSelectedStatus(status);
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

	@When("^user link One defect with status Open to execution$")
	public void user_link_One_defect_with_status_Open_to_execution() throws Throwable {
		try
	       { 
	       int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);	 
	       String defectId=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 4, 10);
	       String[] priority=new String[3];
		   priority[0]=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 13);
	       actual[63]=ep.clickOnDefectButton(testcase);
		   bp.waitForElement();
		   actual[64]=ep.searchDefect(defectId);		
		   bp.waitForElement();
		   ep.linkDefects.click();
		   bp.waitForElement();
		   bp.waitForElement();
		   ep.cancelDefect.click();
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

	@Then("^should be able to link defect with status Open to execution$")
	public void should_be_able_to_link_defect_with_status_Open_to_execution() throws Throwable {
		 try
	       {
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);	 
		   String defectId=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 4, 10);	 
		   actual[65]=ep.validateLinkedDefect(testcase, defectId);
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

	@When("^user create dashBoards$")
	public void user_create_dashBoards() throws Throwable {
		 try
	       {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);	 
		   String desc=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 1);
		   String layout=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 2);
		   String shareType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 3);
		   actual[66]=dp.clickOnManageDashboards(); 
		   bp.waitForElement();
		   actual[67]=dp.clickOnAddDashBoardSymbol();
		   bp.waitForElement();
		   actual[68]=dp.enterDashBoardDetails(name, desc, layout, shareType);
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

	@Then("^should be able to create dashBoards$")
	public void should_be_able_to_create_dashBoards() throws Throwable {
		try
	       {
		   String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);	 
		   actual[69]=dp.validateDashBoard(dashBoard);
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

	@When("^user launch the Gadaget page$")
	public void user_launch_the_Gadaget_page() throws Throwable {
		 try
	     {
		   String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);		 	
		   actual[70]=dp.searchDashboard(dashboard);
		   bp.waitForElement();
		   actual[71]=dp.selectDashboard(dashboard);
		   bp.waitForElement();
		   actual[72]=dp.clickOnAddGadgetSymbol();
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

	@Then("^should be Able to launch the Gadget Page$")
	public void should_be_Able_to_launch_the_Gadget_Page() throws Throwable {
		try
	       {
		   actual[73]=dp.verifyAddGadgetPage();
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

	@When("^user add Traceability gadget$")
	public void user_add_Traceability_gadget() throws Throwable {
		try
	       {
		   String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		   String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		   String refreshRate=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 ,5);
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",4 ,12);
		   String requirement=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",6,0);
		   actual[74]=dp.addGadget(gadgetName);
		   bp.waitForElement();
		   actual[75]=dp.configureTraceabilityGadget(project, release, refreshRate);
		   bp.waitForElement(); 
		   actual[76]=dp.manageTraceability();
		   bp.waitForElement();
		   actual[77]=dp.traceabilityQuickSearch(requirement);
		   bp.waitForElement();
		   actual[78]=dp.selectAllRequirements();
		   bp.waitForElement();
		   actual[79]=dp.closeTraceabilityTable();
		   bp.waitForElement();
		   actual[80]=dp.saveTraceabilityGadget();
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

	@Then("^should be able to add Traceability gadget$")
	public void should_be_able_to_add_Traceability_gadget() throws Throwable {
		try
	       {
		   String requirement=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking",5,0));
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",4,12 );	
		   actual[81]=dp.validateTraceabilityGadget(gadgetName);
		   bp.waitForElement();
		   beforeTotalCount=dp.retrieveTotalDefectCountInTraceability(requirement);
		   beforeOpenCount=dp.retrieveOpenDefectCountInTraceability(requirement);
	       actual[82]=pp.backToProjectPage();
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

	@When("^user search that linked defect in DT app$")
	public void user_search_that_linked_defect_in_DT_app() throws Throwable {
		try
	       {
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 4, 10);	 
		   actual[83]=pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[84]=dt.searchDefect(defectID);
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

	@Then("^should be able to search that linked defect in DT app$")
	public void should_be_able_to_search_that_linked_defect_in_DT_app() throws Throwable {
		try
	       {
		   String defectname=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 4, 10);	 
		   actual[85]=dt.validateAdvancedSearch(defectname);
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

	@When("^user change status from Open to Inprogress$")
	public void user_change_status_from_Open_to_Inprogress() throws Throwable {
		 try
	       {
		   int switch_1=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 1);
		   int switch_0=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 0);	 	 
		   String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
		   String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");	 
		   String statusType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 6);
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 4, 10);	 
		   bp.waitForElement();
		   actual[86]=dp.searchAndSelectDefect(defectID);
		   bp.waitForElement();
		   bp.switchWindowTab(switch_1);
		   actual[87]=ejp.loginToExternalJira(username, password);
		   bp.waitForElement();
		   actual[88]=ejp.changeDefectStatusInExternalJira(statusType);
		   bp.waitForElement();
		   actual[89]=ejp.logOutFromExternal_JIRA();
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

	@Then("^should be able to change status from Open to Inprogress$")
	public void should_be_able_to_change_status_from_Open_to_Inprogress() throws Throwable {
		 try
	       {
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);	 	 
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		   String phase1[]=new String[1];
		   phase1[0]=name;
		   actual[90]=rp.clickOnTestExecution();
		   bp.waitForElement();
		   actual[91]=tr.navigateToNode(releaseName,phase1);
		   bp.waitForElement();
		   actual[92]=ep.viewTooltip(testcase);
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

	@When("^user refresh the added Traceability gadget$")
	public void user_refresh_the_added_Traceability_gadget() throws Throwable {
		try
	       {
		   String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);		 	 
		   String value=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 7);		 	 
		   actual[93]=dp.clickOnManageDashboards();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[94]=dp.searchDashboard(dashboard);
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[95]=dp.selectDashboard(dashboard);
		   bp.waitForElement();
           actual[96]=dp.gadgetOperation(value);
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

	@Then("^should be able to refresh the added Traceability gadget$")
	public void should_be_able_to_refresh_the_added_Traceability_gadget() throws Throwable {
		try
	       {
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",4 ,12);	  
		   actual[97]=dp.validateGadget(gadgetName);
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

	@When("^user view the total and open defect count$")
	public void user_view_the_total_and_open_defect_count() throws Throwable {
		 try
	       {
		   String requirement=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking",5,0));
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

	@Then("^defect count show updated count with status in added Traceability gadget$")
	public void defect_count_show_updated_count_with_status_in_added_Traceability_gadget() throws Throwable {
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
