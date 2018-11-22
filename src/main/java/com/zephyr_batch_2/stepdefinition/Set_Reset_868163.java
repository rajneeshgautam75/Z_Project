package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Set_Reset_868163 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tl;
	ExecutionPage epp;
	String fileName="Set_Reset_868163";
	boolean[] actual=new boolean[55];
	SoftAssert soft=new SoftAssert();
	@Given("^user in Repository Page to create p/s/ss$")
	public void user_in_Repository_Page_to_create_p_s_ss() throws Throwable 
	{
		try
		   {
			   pp=new ProjectPage(driver);
			   //String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,0);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			   actual[0]=pp.selectProject(projectName);
			   bp=new BasePage();
			   bp.waitForElement();
			   actual[1]=pp.selectRelease(releaseName);
			   bp.waitForElement();
			   rp= new ReleasePage(driver);
			   actual[2]=rp.clickOnTestRep();
			   bp.waitForElement();
			   tr=new TestRepositoryPage(driver);
			   actual[3]=tr.doubleClickOnRelease(releaseName);
			   bp.waitForElement(); 
		   }
		   catch (Exception e) 
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

	@Given("^create p/s/ss and add testcases and add estimated time$")
	public void create_p_s_ss_and_add_testcases_and_add_estimated_time() throws Throwable 
	{
		try
		{
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 0);
			String nodeDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 1);
			actual[4]=tr.addNode(nodeName, nodeDesc);
			 bp.waitForElement();
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			 actual[5]=tr.doubleClickOnRelease(releaseName);
			   String[] phase=new String[1];
			   phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 58, 0);
			   actual[6]=tr.navigateToNode(releaseName, phase);
			   bp.waitForElement();
			   actual[7]=tr.addTestCase();
			   bp.waitForElement();
			   tr.clickOnDetails();
			   String day=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 1, 0));
			   String hr=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 1, 1));
			   String mn=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 1, 2));
			   ctc=new CreateTestCasePage(driver);
			   bp.waitForElement();
			   ctc.enterEstimatedTime(day, hr, mn);
			   bp.waitForElement();
			    tr.clickOnList();
			    
			   actual[8]=tr.addTestCase();
			   tr.clickOnDetails();
			   String day2=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 2, 0));
			   String hr2=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 2, 1));
			   String mn2=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 2, 2));
			   bp.waitForElement();
			   ctc.enterEstimatedTime(day2, hr2, mn2);
			   bp.waitForElement();
			   tr.clickOnList();
			  
			   actual[9]=tr.addTestCase();
			   tr.clickOnDetails();
			   String day3=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 3, 0));
			   String hr3=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 3, 1));
			   String mn3=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 3, 2));
			   bp.waitForElement();
			   ctc.enterEstimatedTime(day3, hr3, mn3);
			   bp.waitForElement();
			   tr.clickOnList();
			   
			   actual[10]=tr.addTestCase();
			   tr.clickOnDetails();
			   String day4=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 4, 0));
			   String hr4=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 4, 1));
			   String mn4=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 4, 2));
			   bp.waitForElement();
			   ctc.enterEstimatedTime(day4, hr4, mn4);
			   bp.waitForElement();
			
			   tr.clickOnList();
			   bp.waitForElement();
		   actual[11]=tr.doubleClickOnRelease(releaseName);
			 bp.waitForElement();
			String[] nnodeName1=new String[1];
			nnodeName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 0);
			actual[12]=tr.navigateToNode(releaseName, nnodeName1);
			String nodeName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 2);
			String nodeDesc1=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 3);
			actual[13]=tr.addNode(nodeName1, nodeDesc1);
			
			 //String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			actual[14]=tr.doubleClickOnRelease(releaseName);
			   bp.waitForElement();
			   String[] navigationsystem=new String[2];
			   navigationsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 58, 0);
			   navigationsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 58, 2);
			   actual[15]=tr.navigateToNode(releaseName, navigationsystem);
			   bp.waitForElement();
			   
			   actual[16]=tr.addTestCase();
			   tr.clickOnDetails();
			   String day5=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 5, 0));
			   String hr5=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 5, 1));
			   String mn5=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 5, 2));
			   bp.waitForElement();
			   ctc.enterEstimatedTime(day5, hr5, mn5);
			   bp.waitForElement();
			   
			   tr.clickOnList();
			   actual[17]=tr.addTestCase();
			   tr.clickOnDetails();
			   String day6=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 6, 0));
			   String hr6=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 6, 1));
			   String mn6=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 6, 2));
			   bp.waitForElement();
			   ctc.enterEstimatedTime(day6, hr6, mn6);
			   bp.waitForElement();
			   
			   tr.clickOnList();
			   actual[18]=tr.addTestCase();
			   tr.clickOnDetails();
			   String day7=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 7, 0));
			   String hr7=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 7, 1));
			   String mn7=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 7, 2));
			   bp.waitForElement();
			   ctc.enterEstimatedTime(day7, hr7, mn7);
			   bp.waitForElement();
			   
			   tr.clickOnList();
			   actual[19]=tr.addTestCase();
			   bp.waitForElement();
			   tr.clickOnDetails();
			   String day8=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 8, 0));
			   String hr8=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 8, 1));
			   String mn8=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 8, 2));
			   bp.waitForElement();
			   ctc.enterEstimatedTime(day8, hr8, mn8);
			   bp.waitForElement();
			   
			   tr.clickOnList();
			   bp.waitForElement();
			   actual[20]=tr.doubleClickOnRelease(releaseName);
			   String[] navigation1=new String[2];
			   navigation1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 0);
			   navigation1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 2);
			   actual[21]=tr.navigateToNode(releaseName, navigation1);
			   bp.waitForElement();
				String nodeName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 4);
				String nodeDesc2=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 5);
				actual[22]=tr.addNode(nodeName2, nodeDesc2);
				
				actual[23]=tr.doubleClickOnRelease(releaseName);
				   String[] navigationsubsystem=new String[3];
				   navigationsubsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 58, 0);
				   navigationsubsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 58, 2);
				   navigationsubsystem[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 58, 4);
				   actual[24]=tr.navigateToNode(releaseName, navigationsubsystem);
				   bp.waitForElement();
				
				   actual[25]=tr.addTestCase();
				   bp.waitForElement();
				   tr.clickOnDetails();
				   String day9=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 9, 0));
				   String hr9=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 9, 1));
				   String mn9=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 9, 2));
				   bp.waitForElement();
				   ctc.enterEstimatedTime(day9, hr9, mn9);
				   bp.waitForElement();
				   
				   tr.clickOnList();
				   actual[26]=tr.addTestCase();
				   tr.clickOnDetails();
				   String day10=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 10, 0));
				   String hr10=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 10, 1));
				   String mn10=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 10, 2));
				   bp.waitForElement();
				   ctc.enterEstimatedTime(day10, hr10, mn10);
				   bp.waitForElement();
				   
				   tr.clickOnList();
				   actual[27]=tr.addTestCase();
				   tr.clickOnDetails();
				   String day11=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 11, 0));
				   String hr11=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 11, 1));
				   String mn11=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 11, 2));
				   bp.waitForElement();
				   ctc.enterEstimatedTime(day11, hr11, mn11);
				   bp.waitForElement();
				   
				   tr.clickOnList();
				   actual[28]=tr.addTestCase();
				   actual[29]=tr.clickOnDetails();
				   String day12=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 12, 0));
				   String hr12=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 12, 1));
				   String mn12=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "EstimatedTime", 12, 2));
				   bp.waitForElement();
				   actual[30]=ctc.enterEstimatedTime(day12, hr12, mn12);
				   bp.waitForElement();
				   actual[31]=tr.clickOnList();
				   bp.waitForElement();
		 }
		   catch (Exception e) 
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

	@When("^launch test planning create cycle add phase to cycle$")
	public void launch_test_planning_create_cycle_add_phase_to_cycle() throws Throwable 
	{
		try
		{
			/*bp=new BasePage();
			   pp=new ProjectPage(driver);
			   bp.waitForElement();
		    	pp.clickOnLogout();
		    	bp.waitForElement();
		    	tl=new TestPlanningPage(driver);
		    	tr=new TestRepositoryPage(driver);
		    	epp=new ExecutionPage(driver);
		    	
		    	lp=new LoginPage(driver);
				
				String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_3");
				   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_3");
				   
				   lp.enterUname(Uname);
				   lp.enterPass(Pass);
				   lp.clickOnLogin();
				   
				   pp=new ProjectPage(driver);
				   rp=new ReleasePage(driver);
				   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
				   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			    	 bp.waitForElement();
			    	 pp.selectProject(projectName);
			    	 pp.selectRelease(releaseName);*/
			
			actual[35]=rp.clickOnTestPlanning();
		    bp.waitForElement();
		    
		    tl=new TestPlanningPage(driver);
		    actual[36]=tl.clickOnAddTestCycleSymbol();
		    bp.waitForElement();
		    //creating cicle 1
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 48, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
			actual[37]=tl.CreateCycle(cyclename, Build, Environment,hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
			bp.waitForElement();
			bp.waitForElement();
			actual[38]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			
			actual[39]=tl.saveTestCycle();
			bp.waitForElement();
			
		   String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 48, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 0);
			actual[41]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[42]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
		 }
		   catch (Exception e) 
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

	@When("^navigate to phase assign to different users$")
	public void navigate_to_phase_assign_to_different_users() throws Throwable 
	{
		try
		{
			String[] phase=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 0);
			actual[43]=tl.navigateToCycle(phase);
			bp.waitForElement();
			
			int[] tcname1=new int[1];
			tcname1[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "tcno", 1, 0);
			//String Assignee1=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 0);
			String manager=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User1");
			actual[44]=tl.individualAssinTo(tcname1, manager);
			bp.waitForElement();
			bp.waitForElement();
			int[] tcname2=new int[1];
			tcname2[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "tcno", 2, 0);
			String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
			actual[45]=tl.individualAssinTo(tcname2, lead);
			bp.waitForElement();
			
			int[] tcname3=new int[1];
			tcname3[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "tcno", 3, 0);
			String tester=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
			actual[46]=tl.individualAssinTo(tcname3, tester);
			bp.waitForElement();
		 }
		   catch (Exception e) 
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

	@When("^navigate to system and assign to diiferent users$")
	public void navigate_to_system_and_assign_to_diiferent_users() throws Throwable 
	{
		try
		{
			String[] system=new String[1];
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 2);
			actual[47]=tl.navigateToCycle(system);
			bp.waitForElement();
			
			int[] tcname1=new int[1];
			tcname1[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "tcno", 1, 0);
			//String Assignee1=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 1, 0);
			String manager=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User1");
			actual[48]=tl.individualAssinTo(tcname1, manager);
			bp.waitForElement();
			
			int[] tcname2=new int[1];
			tcname2[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "tcno", 2, 0);
			String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
			actual[49]=tl.individualAssinTo(tcname2, lead);
			bp.waitForElement();
			
			int[] tcname3=new int[1];
			tcname3[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "tcno", 3, 0);
			String tester=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
			actual[50]=tl.individualAssinTo(tcname3, tester);
			bp.waitForElement();
		 }
		   catch (Exception e) 
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

	@When("^navigate to susbsystem unassign the testcases$")
	public void navigate_to_susbsystem_unassign_the_testcases() throws Throwable 
	{
		try
		{
			String[] subsystem=new String[1];
			subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 4);
			actual[51]=tl.navigateToCycle(subsystem);
			bp.waitForElement();
			
			tl.selectallTestCase();
			bp.waitForElement();
			String Unassign=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 7, 0);
			tl.assignAllSelected(Unassign);
			bp.waitForElement();
			tl.goBackToCycle();
		 }
		   catch (Exception e) 
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

	@When("^launch test repository navigate to phase and sort the actual time$")
	public void launch_test_repository_navigate_to_phase_and_sort_the_actual_time() throws Throwable 
	{
		try
		{
			   /*bp=new BasePage();//
			   pp=new ProjectPage(driver);
			   bp.waitForElement();
		    	pp.clickOnLogout();
		    	bp.waitForElement();
		    	tl=new TestPlanningPage(driver);
		    	tr=new TestRepositoryPage(driver);
		    	epp=new ExecutionPage(driver);
		    	
		    	lp=new LoginPage(driver);
				
				String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
				   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
				   
				   lp.enterUname(Uname);
				   lp.enterPass(Pass);
				   lp.clickOnLogin();
				   
				   pp=new ProjectPage(driver);
				   rp=new ReleasePage(driver);
				   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
				   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			    	 bp.waitForElement();
			    	 pp.selectProject(projectName);
			    	 pp.selectRelease(releaseName); // */
			
			
			
			
			    actual[52]=rp.clickOnTestRep();
		 		bp.waitForElement();
		   
		 		String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
         		actual[53]=tr.doubleClickOnRelease(releaseName);
		 		String[] phase=new String[1];
		 		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 58, 0);
		 		actual[54]=tr.navigateToNode(releaseName, phase);
		 		bp.waitForElement();
			   
		 		String[] estimatedtime=new String[1];
		 		estimatedtime[0]=Excel_Lib.getData(INPUT_PATH_4, "EstimatedTime", 1, 4);
		 		//tl.sortingTestCase(estimatedtime);
		 		tr.sortingTestCase(estimatedtime);
		 		bp.waitForElement();
		 		bp.waitForElement();
		 }
		   catch (Exception e) 
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

	@Then("^Should be able to sort estimated time in descending or ascending order$")
	public void should_be_able_to_sort_estimated_time_in_descending_or_ascending_order() throws Throwable 
	{
		try
		{
			bp.waitForElement();
			driver.navigate().refresh();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			
			bp.waitForElement();
			ctc= new CreateTestCasePage(driver);
			ctc.estimatedTime1.click();
			bp.waitForElement();
			//bp.waitForElement();
			bp.moveToElementAndClick(ctc.sortEstimatedIcon);
			//ctc.sortEstimatedIcon.click();
			bp.waitForElement();
			bp.waitForElement();
			/*String[] tcname3=new String[4];
			tcname3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "tcno", 1, 0));
			tcname3[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "tcno", 2, 0));
			tcname3[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "tcno", 3, 0));
			tcname3[3]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "tcno", 4, 0));
			ctc.displaySortedEstimatedTime(tcname3);*/
		 }
		   catch (Exception e) 
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
