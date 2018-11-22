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
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_241 extends LaunchBrowser{
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
	private int beforeToDoCount;
	private int beforeDoneCount;
	private int afterToDoCount;
	private int afterDoneCount;
	boolean[] actual=new boolean[50];
	SoftAssert soft=new SoftAssert();
	String fileName="DefectTracking_241";

	@Given("^User is in Administration Page$")
	public void user_is_in_Administration_Page() throws Throwable {
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

	@When("^User set the dts to jira$")
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

	@Then("^Should be able to set the dts to jira$")
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
	@When("^User launch the TestExecution and click on D$")
	public void user_launch_the_TestExecution_and_click_on_D() throws Throwable {
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

@Then("^Should be Able to launch TestExecution$")
public void should_be_Able_to_launch_TestExecution() throws Throwable {
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

	@When("^User link one defect with status Done to execution$")
	public void user_link_one_defect_with_status_Done_to_execution() throws Throwable {
		try
	       {
		   ejp=new ExternalJiraPage(driver);
	       int switch_1=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 1);
	       int switch_0=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 0);	 
	       String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
		   String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");	 	 	 	 		  
		   String statusType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 11);	 	 
	       int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);	 
	       String defectId=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 10);
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
		   actual[19]=ejp.logOutFromExternal_JIRA();
		   bp.waitForElement();
		   driver.close();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.switchWindowTab(switch_0);
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[20]=ep.linkDefect();
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

	@Then("^Should be able to link the defect with status Done$")
	public void should_be_able_to_link_the_defect_with_status_Done() throws Throwable {
		 try
	       {
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);	 
		   String defectId=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 10);	 
		   actual[21]=ep.validateLinkedDefect(testcase, defectId);
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

	@When("^User Create the Dashboard$")
	public void user_Create_the_Dashboard() throws Throwable {
		try
	       {
		   dp=new DashBoardPage(driver);	
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);	 
		   String desc=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 1);
		   String layout=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 2);
		   String shareType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 3);
		   actual[22]=dp.clickOnManageDashboards(); 
		   bp.waitForElement();
		   actual[23]=dp.clickOnAddDashBoardSymbol();
		   bp.waitForElement();
		   actual[24]=dp.enterDashBoardDetails(name, desc, layout, shareType);
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

	@Then("^Should be able to Add Dashboard$")
	public void should_be_able_to_Add_Dashboard() throws Throwable {
		 try
	       {
		  String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);	 
		  actual[25]=dp.validateDashBoard(dashBoard);
		   }
	     catch(Exception e)
	       {
	       lb=new LaunchBrowser();	 
	       lb.getScreenShot(fileName);
	       e.printStackTrace();
	       driver.close();
	       Relogin_TPE rl=new Relogin_TPE();
	       rl.reLogin();
	       throw e; 
	       }
	}

	@When("^User Launch the Gadget$")
	public void user_Launch_the_Gadget() throws Throwable {
		 try
	       {
		   String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);		 	
		   actual[26]=dp.searchDashboard(dashboard);
		   bp.waitForElement();
		   actual[27]=dp.selectDashboard(dashboard);
		   bp.waitForElement();
		   actual[28]=dp.clickOnAddGadgetSymbol();
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

	@Then("^Should be able to launch Gadget$")
	public void should_be_able_to_launch_Gadget() throws Throwable {
		try
	       {
		   actual[29]=dp.verifyAddGadgetPage();
		   }
	     catch(Exception e)
	       {
	       lb=new LaunchBrowser();	 
	       lb.getScreenShot(fileName);
	       e.printStackTrace();
	       driver.close();
	       Relogin_TPE rl=new Relogin_TPE();
	       rl.reLogin();
	       throw e; 
	       }

	}

	@When("^User Add Overall Gadget$")
	public void user_Add_Overall_Gadget() throws Throwable {
		 try
	       {
		   String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		   String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		   String refreshRate=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 ,5 );
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 ,4 );
		   actual[30]=dp.addGadget(gadgetName);
		   bp.waitForElement();
		   actual[31]=dp.configureTestAutomationStatusGadget(project, release, refreshRate);
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

	@Then("^Should be able to Add Overall Gadget$")
	public void should_be_able_to_Add_Overall_Gadget() throws Throwable {
		 try
	       {
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 ,4 );	 
		   String defectStatusName_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 11);	
		   String defectStatusName_2=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 8);		
	       actual[32]=dp.validateGadget(gadgetName);
	       bp.waitForElement();
	       WebElement ele=driver.findElement(By.xpath(dp.defectStatus1+defectStatusName_1+dp.defectStatus2));
		   beforeDoneCount=Integer.parseInt(ele.getText());
		   WebElement ele1=driver.findElement(By.xpath(dp.defectStatus1+defectStatusName_2+dp.defectStatus2));
		   beforeToDoCount=Integer.parseInt(ele1.getText()); 
	       actual[33]=pp.backToProjectPage();
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

	@When("^User Search the linked defect in DefectTracking$")
	public void user_Search_the_linked_defect_in_DefectTracking() throws Throwable {
		try
	       {
		   dt=new DefectTracking(driver);	
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 10);	 
		   actual[34]=pp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[35]=dt.searchDefect(defectID);
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

	@Then("^Should be able to search the linked Defect$")
	public void should_be_able_to_search_the_linked_Defect() throws Throwable {
		try
	       {
		   String defectname=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 10);	 
		   actual[36]= dt.validateAdvancedSearch(defectname);
		   }
	     catch(Exception e)
	       {
	       lb=new LaunchBrowser();	 
	       lb.getScreenShot(fileName);
	       e.printStackTrace();
	       driver.close();
	       Relogin_TPE rl=new Relogin_TPE();
	       rl.reLogin();
	       throw e; 
	       }

	}

	@When("^User change the status from Done to TO DO$")
	public void user_change_the_status_from_Done_to_TO_DO() throws Throwable {
		 try
	       {
		   int switch_1=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 1);
		   int switch_0=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 4, 0);	 	 
		   String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
		   String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");	 	 	 	 		  		   String statusType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 8);
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 3, 10);	 
		   bp.waitForElement();
		   actual[37]=dp.searchAndSelectDefect(defectID);
		   bp.waitForElement();
		   bp.switchWindowTab(switch_1);
		   bp.waitForElement();
		   actual[38]=ejp.loginToExternalJira(username, password);
		   bp.waitForElement();
		   actual[39]=ejp.changeDefectStatusInExternalJira(statusType);
		   bp.waitForElement();
		   actual[40]=ejp.logOutFromExternal_JIRA();
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

	@Then("^Should be able to change the status from Done to TO DO$")
	public void should_be_able_to_change_the_status_from_Done_to_TO_DO() throws Throwable {
		 try
	       {
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);	 	 
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		   String phase1[]=new String[1];
		   phase1[0]=name;
		   actual[41]=rp.clickOnTestExecution();
		   bp.waitForElement();
		   actual[42]=tr.navigateToNode(releaseName,phase1);
		   bp.waitForElement();
		   actual[43]=ep.viewTooltip(testcase);
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

	@When("^User Refresh the added Overall Gadget$")
	public void user_Refresh_the_added_Overall_Gadget() throws Throwable {
		 try
	       {
		   String dashboard=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 0);		 	 
		   String value=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 7);		 	 
		   actual[44]=dp.clickOnManageDashboards();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[45]=dp.searchDashboard(dashboard);
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[46]=dp.selectDashboard(dashboard);
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
           actual[47]=dp.gadgetOperation(value);
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

	@Then("^Should be able to Refresh Overall Gadget$")
	public void should_be_able_to_Refresh_Overall_Gadget() throws Throwable {
		 try
	       {
		   String gadgetName=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 ,4 );	  
		   actual[48]=dp.validateGadget(gadgetName);
		   }
	     catch(Exception e)
	       {
	       lb=new LaunchBrowser();	 
	       lb.getScreenShot(fileName);
	       e.printStackTrace();
	       driver.close();
	       Relogin_TPE rl=new Relogin_TPE();
	       rl.reLogin();
	       throw e; 
	       }
	}

	@When("^view the defect count by status of TO Do$")
	public void view_the_defect_count_by_status_of_TO_Do() throws Throwable {
		 try
	       {
		//	String defectStatusName_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 11);	
			String defectStatusName_2=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking",3 , 8);		
//			WebElement ele=driver.findElement(By.xpath(dp.defectStatus1+defectStatusName_1+dp.defectStatus2));
//			afterDoneCount=Integer.parseInt(ele.getText());
		    WebElement ele1=driver.findElement(By.xpath(dp.defectStatus1+defectStatusName_2+dp.defectStatus2));
			afterToDoCount=Integer.parseInt(ele1.getText());
		   }
	     catch(Exception e)
	       {
	       lb=new LaunchBrowser();	 
	       lb.getScreenShot(fileName);
	       e.printStackTrace();
	       driver.close();
	       Relogin_TPE rl=new Relogin_TPE();
	       rl.reLogin();
	       throw e; 
	       }
	}

	@Then("^defect count show updated count with status of TO DO$")
	public void defect_count_show_updated_count_with_status_of_TO_DO() throws Throwable {
		 try
	       {
            if(beforeDoneCount==afterDoneCount-1 && beforeToDoCount==afterToDoCount+1)
            {
          	  System.out.println("Defect count updated successfully");  
            }
            actual[49]=pp.backToProjectPage();
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
