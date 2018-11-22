package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Execution_Backlog_11 extends LaunchBrowser {
	
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Execution_Backlog_11";
	
	BasePage bp;
	LoginPage lp;
	ReleasePage rp;
	ProjectPage pp;
	ExecutionPage ep;
	DashBoardPage dp;
	TestPlanningPage tp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	CreateCustomFieldsPage ccf;
	
	boolean actual[]=new boolean[224];
	SoftAssert soft=new SoftAssert();
	
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	private String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 6, 4);
	
	
	String[] cycleName=new String[2]; 
	{
	 cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",48,0 );
	 cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase",71,0 );
	}
	
	@Given("^Login as a manager and create user of international character, max char limits, captial letters, alpha numberic and special characters and assign to normal project one$")
	public void login_as_a_manager_and_create_user_of_international_character_max_char_limits_captial_letters_alpha_numberic_and_special_characters_and_assign_to_normal_project_one() throws Throwable {
		try
		 {
			lp=new LoginPage(driver);
			bp=new BasePage();
			pp=new ProjectPage(driver);
			rp=new ReleasePage(driver);
			ccf=new CreateCustomFieldsPage(driver);
   	        actual[0]=pp.clickOnLogout();
		    String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Manager_Username_1");
			String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Manager_Password_1");
		    actual[1]=lp.enterUnameAndPassword(name, passWord);
		    bp.waitForElement();
		    actual[2]=pp.launchAdministration();
		    bp.waitForElement();
		    actual[3]=pp.launchManageUsers();
		    bp.waitForElement();
	        String Name1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_7");
	        String userName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_7");
	        boolean user1=pp.checkAvailableUser(Name1);
	        System.out.println(Name1 +  user1);
			String type=Excel_Lib.getData(INPUT_PATH, "User_Details", 1,0);
			String role=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 1);
			String email=Excel_Lib.getData(INPUT_PATH_5, "Url",0, 1);
			String title=Excel_Lib.getData(INPUT_PATH, "User_Details", 100,100);
			String location=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 4);
		    if(user1==false)
		    {
		    String[] fullName1=userName1.split("\\.");
			for(int i=0;i<fullName1.length;i++)
			{
			System.out.println(fullName1[i]);
			 }
			String firstName1=fullName1[0];
			String lastName1=fullName1[1];
		    ccf.createUser(firstName1, lastName1, type, role, email, title, location);   
		    } 
		    bp.waitForElement();
		    pp.selectUser(Name1);
		    pp.assignProject(project);	
		    String userName2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_8");
		    String Name2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_8");
			boolean user2=pp.checkAvailableUser(Name2);
			 System.out.println(Name2 +  user2);
			System.out.println(user2);
			if(user2==false)
			 {
			String[] fullName2=userName2.split("\\.");
			for(int i=0;i<fullName2.length;i++)
			{
			System.out.println(fullName2[i]);
			}
			String firstName2=fullName2[0];
		    String lastName2=fullName2[1];
			String email1=Excel_Lib.getData(INPUT_PATH_5, "Url",1, 1);
			ccf.createUser(firstName2, lastName2, type, role, email1, title, location);	   
			}
			bp.waitForElement();
			pp.selectUser(Name2);
			pp.assignProject(project); 
			String userName3=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_9");
			String Name3=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_9");
			boolean user3=pp.checkAvailableUser(Name3); 
			 System.out.println(Name3 +  user3);
			if(user3==false)
			{
			System.out.println("Name3" + Name3);
			String[] fullName3=userName3.split("\\.");
			for(int i=0;i<fullName3.length;i++)
			{
			System.out.println(fullName3[i]);
			}
			String firstName3=fullName3[0].toUpperCase();
			String lastName3=fullName3[1].toUpperCase();
			String email2=Excel_Lib.getData(INPUT_PATH_5, "Url",2, 1);
			ccf.createUser(firstName3, lastName3, type, role, email2, title, location);	   
			}
			bp.waitForElement();
			pp.selectUser(Name3);
			pp.assignProject(project);
			String userName4=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_10");
			String Name4=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_10");
			boolean user4=pp.checkAvailableUser(userName4);
			 System.out.println(Name4 +  user4);
			if(user4==false)
			  {
			String[] fullName4=userName4.split("\\.");
			for(int i=0;i<fullName4.length;i++)
		    {
		     System.out.println(fullName4[i]);
			}
			String firstName4=fullName4[0];
			String lastName4=fullName4[1];
			String email3=Excel_Lib.getData(INPUT_PATH_5, "Url",3, 1);
			ccf.createUser(firstName4, lastName4, type, role, email3, title, location);   
			}
			bp.waitForElement();
			pp.selectUser(Name4);
			pp.assignProject(project);	
			String userName5=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_11");
			String Name5=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_11");
			boolean user5=pp.checkAvailableUser(Name5);
			 System.out.println(Name5 +  user5);
			System.out.println(user5);
			if(user5==false)
			{
		    String[] fullName5=userName5.split("\\.");
		    for(int i=0;i<fullName5.length;i++)
			{
		    System.out.println(fullName5[i]);
			}
		    String firstName5=fullName5[0];
			String lastName5=fullName5[1];
		    String email5=Excel_Lib.getData(INPUT_PATH_5, "Url",4, 1);
			ccf.createUser(firstName5, lastName5, type, role, email5, title, location);	    
			}    
			bp.waitForElement();
			pp.selectUser(Name5);
			pp.assignProject(project);
			bp.waitForElement();    
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }    
	}
	@Given("^add Custom picklist of international character, max char limits, captial letters, alpha numberic and special characters$")
	public void add_Custom_picklist_of_international_character_max_char_limits_captial_letters_alpha_numberic_and_special_characters() throws Throwable {
		try
		 {
		     ccf=new CreateCustomFieldsPage(driver);
		     actual[4]=ccf.moveToCustomFields();
		     bp.waitForElement();
		     String [] piclistValues=new String[5];
		     for(int i=0;i<=4;i++)
		     {
		     piclistValues[i]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 2+i, 11);
		     }
		     String customName=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 9);
		     actual[5]=ccf.enterPicklistValues(customName, piclistValues);
		     bp.waitForElement();
		     actual[6]=ccf.saveCustomFeilds();
		     bp.waitForElement();
		     ccf.cancelCustomFields.click();
		     bp.waitForElement();
		     actual[7]=pp.clickOnLogout();
	   }
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }       
	    
	}

	@Given("^Login as a lead add testcases with tag and custom picklist names and assign one testcses to each lead$")
	public void login_as_a_lead_add_testcases_with_tag_and_custom_picklist_names_and_assign_one_testcses_to_each_lead() throws Throwable {
		try
		 {
			 rp=new ReleasePage(driver);
			 ctc=new CreateTestCasePage(driver);
			 tr=new TestRepositoryPage(driver);
			 String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_7");
			 String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_7");
			 actual[8]=lp.enterUnameAndPassword(name, passWord);
			 bp.waitForElement();
			 actual[9]=pp.selectProject(project);
			 actual[10]=pp.selectRelease(release);
			 bp.waitForElement(); 
			 actual[11]=rp.clickOnTestRep();
			 bp.waitForElement();
			 actual[12]=tr.clickOnRelease(release);
			 String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 71, 0);
			 String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 1);
			 actual[13]=tr.addNode(phase, Desc);
			 bp.waitForElement();
			 String navigation[]=new String [1];
			 navigation[0]=phase;
			 actual[14]=tr.navigateToNode(release, navigation);
			 for(int i=0;i<=4;i++)
			 {
			 actual[15]=tr.addTestCase();
			 bp.waitForElement();	
			 tr.clickOnDetails();
			 bp.waitForElement();
			 String tag[]=new String [1];
			 tag[0]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 2+i, 11);
			 actual[16]=ctc.enterMultipleTags(tag);
			 bp.waitForElement();	
			 String pickupList=Excel_Lib.getData(INPUT_PATH_5, "Phase", 2+i, 11);
			 System.out.println(pickupList + " picklist");
			 String text=Excel_Lib.getData(INPUT_PATH_5, "Phase", 100, 100);
			 String longText=Excel_Lib.getData(INPUT_PATH_5, "Phase", 100, 100);
			 String number=Excel_Lib.getData(INPUT_PATH_5, "Phase", 100, 100);
			 String checkBox=Excel_Lib.getData(INPUT_PATH_5, "Phase", 100, 100);
			 String date=Excel_Lib.getData(INPUT_PATH_5, "Phase", 100, 100);
			 ctc.customFieldOption.click();
			 bp.waitForElement();	
			 actual[17]=ctc.enterCustomFields(text, longText, number, checkBox, pickupList, date);
			 bp.waitForElement();	
			 ctc.customFieldOption.click(); 
			 bp.waitForElement();
			 actual[18]=tr.clickOnList();
			 bp.waitForElement(); 
		     }
			 tp=new TestPlanningPage(driver);
		     ep=new ExecutionPage(driver);
			 actual[19]=rp.clickOnTestPlanning();
			 actual[20]=tp.clickOnAddTestCycleSymbol();
			 bp.waitForElement();
			 String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 48, 0);
			 String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
			 String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
			 String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
			 actual[21]=tp.CreateCycle(cycle, Build, Environment, hide);
			 String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
			 String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
			 String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
			 String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
			 String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
			 String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
			 actual[22]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			 actual[23]=tp.saveTestCycle(); 
			 bp.waitForElement(); 
			 String [] cycle1 =new String[1];
			 cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 48, 0);
			 actual[24]=tp.navigateToCycle(cycle1);
			 actual[25]=tp.addPhaseToCycle(phase);
			 actual[26]=bp.waitForElement();
			 String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
			 actual[27]=tp.bulkAssignment(Bulk_type);
			 actual[28]=bp.waitForElement();
			 tr.selectPhase(phase);
			 int [] testCaseNo2=new int[1];
			 testCaseNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_5,"Execution", 2, 0);
			 actual[29]=tp.selectSingleMultipleTestcase(testCaseNo2);
			 String assignee2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_8");
			 actual[30]=tp.assignAllSelected(assignee2);
			 bp.waitForElement();
			 int [] testCaseNo3=new int[1];
			 testCaseNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_5,"Execution", 3, 0);
			 actual[29]=tp.selectSingleMultipleTestcase(testCaseNo3);
			 String assignee3=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_9");
			 actual[32]=tp.assignAllSelected(assignee3);
			 bp.waitForElement();
			 int [] testCaseNo4=new int[1];
			 testCaseNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_5,"Execution", 4, 0);
			 actual[29]=tp.selectSingleMultipleTestcase(testCaseNo4);
			 String assignee4=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_10");
			 actual[33]=tp.assignAllSelected(assignee4);
			 bp.waitForElement();
			 int [] testCaseNo5=new int[1];
			 testCaseNo5[0]=Excel_Lib.getNumberData(INPUT_PATH_5,"Execution", 5, 0);
			 actual[29]=tp.selectSingleMultipleTestcase(testCaseNo5);
			 String assignee5=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_11");
			 actual[35]=tp.assignAllSelected(assignee5);
			 bp.waitForElement();
			 actual[36]=tp.goBackToCycle();
			 bp.waitForElement(); 
			 actual[37]=rp.clickOnTestExecution();
			 actual[38]=bp.waitForElement();
			 actual[39]=tr.navigateToNode(release, cycleName);
			 bp.waitForElement(); 
			 String testCaseNo []=new String[1];
			 testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"Execution", 1, 0));
			 actual[40]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo);
			 bp.waitForElement();
			 String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
			 actual[41]=ep.changeMultiSelectedStatus(status);
			 bp.waitForElement();
			 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }     
	    
	}

	@When("^Login as International character lead, add dashboard, add Executions Backlog Gadget and select a project, release and custom field name with international char$")
	public void login_as_International_character_lead_add_dashboard_add_Executions_Backlog_Gadget_and_select_a_project_release_and_custom_field_name_with_international_char() throws Throwable {
		try
		 {
			  dp=new DashBoardPage(driver);
			  String dashBoardName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 38, 0);
			  String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
			  String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
			  String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
			  actual[42]=dp.clickOnManageDashboards();
			  dp.validateDashboards();
			  actual[43]=dp.clickOnAddDashBoardSymbol();
			  actual[44]=dp.enterDashBoardDetails(dashBoardName1, desc, layout, shareType);
			  bp.waitForElement(); 
			  actual[45]=dp.validateDashBoard(dashBoardName1);
			  actual[46]=dp.selectDashboard(dashBoardName1);
			  bp.waitForElement();
			  actual[47]=dp.clickOnAddGadgetSymbol();
			  actual[48]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[49]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[50]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			  String [] user=new String [1];
			  user[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_11");
			  actual[51]=dp.filterBy(filterBy, user);
			  actual[52]=dp.saveGadget();
			  bp.waitForElement();	 
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }      
	    
	}

	@Then("^Execution Backlog Gadget should be added for user with international char$")
	public void execution_Backlog_Gadget_should_be_added_for_user_with_international_char() throws Throwable {
		try
		 {
			actual[53]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			actual[54]=dp.viewMsg(filterBy);
			bp.waitForElement();
			
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }      
	    
	}

	@When("^Add Executions Backlog Gadget and select a project, release and tag name with international char$")
	public void add_Executions_Backlog_Gadget_and_select_a_project_release_and_tag_name_with_international_char() throws Throwable {
	    try
	   {
		  actual[55]=dp.clickOnAddGadgetSymbol();
		  actual[56]=dp.addGadget(gadget);
		  bp.waitForElement();
		  actual[57]=dp.validateGadget(gadget); 
		  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
		  actual[58]=dp.configureTraceabilityGadget(project, release, refreshRate); 
		  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 3, 7);
		  String [] tag=new String [1];
		  tag[0]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 2, 11);
		  actual[59]=dp.filterBy(filterBy, tag);
		  actual[60]=dp.saveGadget();
		  bp.waitForElement();	 
	    }
	
	 catch(Exception e)
	 {
	  e.printStackTrace();
	  lb.getScreenShot(fileName);
	  driver.close();
	  Relogin_TPE rl=new Relogin_TPE();
	  rl.reLogin();
	  throw e;
	 }      
	    
	}

	@Then("^Execution Backlog Gadget should be added for tag with international char$")
	public void execution_Backlog_Gadget_should_be_added_for_tag_with_international_char() throws Throwable {
		try
		 {
			actual[61]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 3, 7);
			actual[62]=dp.viewMsg(filterBy);
			bp.waitForElement();
			
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }      
	    
	}

	@When("^Add Executions Backlog Gadget and select a project, release and custom name with international char$")
	public void add_Executions_Backlog_Gadget_and_select_a_project_release_and_custom_name_with_international_char() throws Throwable {
		  try
		   {
			  actual[63]=dp.clickOnAddGadgetSymbol();
			  actual[64]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[65]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[66]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 5, 7);
			  String [] custom=new String [1];
			  custom[0]=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 9);
			  actual[67]=dp.filterBy(filterBy, custom);
			  actual[68]=dp.saveGadget();
			  bp.waitForElement();	 
		    }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }      
	    
	}

	@Then("^Execution Backlog Gadget should be added for custom name with international char$")
	public void execution_Backlog_Gadget_should_be_added_for_custom_name_with_international_char() throws Throwable {
		try
		 {
			actual[69]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 5, 7);
			actual[70]=dp.viewMsg(filterBy);
			bp.waitForElement();
			pp.clickOnLogout();
			
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }      
	    
	}

	@When("^Login as max char limits lead, add dashboard, add Executions Backlog Gadget and select a project, release and custom field name with max char limits$")
	public void login_as_max_char_limits_lead_add_dashboard_add_Executions_Backlog_Gadget_and_select_a_project_release_and_custom_field_name_with_max_char_limits() throws Throwable {
		try
		 {
			 String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_8");
		     String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Password_8");
			 actual[71]=lp.enterUnameAndPassword(name, passWord);
			 bp.waitForElement();
			 actual[72]=pp.selectProject(project);
			 actual[73]=pp.selectRelease(release);
			 bp.waitForElement();
			 actual[74]=rp.clickOnTestExecution();
			 actual[75]=bp.waitForElement();
			 actual[76]=tr.navigateToNode(release, cycleName);
			 bp.waitForElement(); 
			 String testCaseNo []=new String[1];
			 testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"Execution", 1, 0));
			 actual[77]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo);
			 bp.waitForElement();
			 String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 2, 2);
			 actual[78]=ep.changeMultiSelectedStatus(status);
			 bp.waitForElement();
			 String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
			 String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
			 String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
			 actual[79]=dp.clickOnManageDashboards();
			 dp.validateDashboards();
			 actual[80]=dp.clickOnAddDashBoardSymbol();
			 String dashBoardName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 39, 0);
			 actual[81]=dp.enterDashBoardDetails(dashBoardName2, desc, layout, shareType);
			 bp.waitForElement(); 
			 actual[82]=dp.validateDashBoard(dashBoardName2);
			 actual[83]=dp.selectDashboard(dashBoardName2);
			 bp.waitForElement();
			 actual[84]=dp.clickOnAddGadgetSymbol();
			 actual[85]=dp.addGadget(gadget);
			 bp.waitForElement();
			 actual[86]=dp.validateGadget(gadget); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			 actual[87]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			 String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			 String [] user=new String [1];
			 user[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_8");
			 actual[88]=dp.filterBy(filterBy, user);
			 actual[89]=dp.saveGadget();
			 bp.waitForElement();	 
			 
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }      
	    
	}

	@Then("^Execution Backlog Gadget should be added for user with max char limits$")
	public void execution_Backlog_Gadget_should_be_added_for_user_with_max_char_limits() throws Throwable {
		try
		 {
			actual[90]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			actual[91]=dp.viewMsg(filterBy);
			bp.waitForElement();
			
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }      
	    
	}

	@When("^Add Executions Backlog Gadget and select a project, release and tag name with max char limits$")
	public void add_Executions_Backlog_Gadget_and_select_a_project_release_and_tag_name_with_max_char_limits() throws Throwable {
		  try
		   {
			  actual[93]=dp.clickOnAddGadgetSymbol();
			  actual[94]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[95]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[96]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 3, 7);
			  String [] tag=new String [1];
			  tag[0]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 3, 11);
			  actual[97]=dp.filterBy(filterBy, tag);
			  actual[98]=dp.saveGadget();
			  bp.waitForElement();	 
		    }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }      
	    
	}

	@Then("^Execution Backlog Gadget should be added for tag with max char limits$")
	public void execution_Backlog_Gadget_should_be_added_for_tag_with_max_char_limits() throws Throwable {
		try
		 {
			actual[99]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 3, 7);
			actual[100]=dp.viewMsg(filterBy);
			bp.waitForElement();
			
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }      
	    
	}

	@When("^Add Executions Backlog Gadget and select a project, release and custom name with max char limits$")
	public void add_Executions_Backlog_Gadget_and_select_a_project_release_and_custom_name_with_max_char_limits() throws Throwable {
		 try
		   {
			  actual[101]=dp.clickOnAddGadgetSymbol();
			  actual[102]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[103]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[104]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 5, 7);
			  String [] custom=new String [1];
			  custom[0]=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 9);
			  actual[105]=dp.filterBy(filterBy, custom);
			  actual[106]=dp.saveGadget();
			  bp.waitForElement();	 
		    }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }      
	    
	}

	@Then("^Execution Backlog Gadget should be added for custom name with max char limits$")
	public void execution_Backlog_Gadget_should_be_added_for_custom_name_with_max_char_limits() throws Throwable {
		try
		 {
			actual[107]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 5, 7);
			actual[108]=dp.viewMsg(filterBy);
			bp.waitForElement();
			
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }         
	    
	}

	@When("^Login as captial letters lead, add dashboard, add Executions Backlog Gadget and select a project, release and custom field name with captial letters$")
	public void login_as_captial_letters_lead_add_dashboard_add_Executions_Backlog_Gadget_and_select_a_project_release_and_custom_field_name_with_captial_letters() throws Throwable {
		try
		 {
			 actual[109]=pp.clickOnLogout();
			 String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_9");
		     String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Password_9");
			 actual[110]=lp.enterUnameAndPassword(name, passWord);
			 bp.waitForElement();
			 bp.waitForElement();
			 pp.selectProject(project);
			 actual[111]=pp.selectRelease(release);
			 bp.waitForElement();
			 actual[112]=rp.clickOnTestExecution();
			 actual[113]=bp.waitForElement();
			 actual[114]=tr.navigateToNode(release, cycleName);
			 bp.waitForElement(); 
			 String testCaseNo []=new String[1];
			 testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"Execution", 1, 0));
			 actual[115]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo);
			 bp.waitForElement();
			 String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
			 actual[116]=ep.changeMultiSelectedStatus(status);
			 bp.waitForElement();
			 String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
			 String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
			 String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
			 actual[117]=dp.clickOnManageDashboards();
			 dp.validateDashboards();
			 actual[118]=dp.clickOnAddDashBoardSymbol();
			 String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 40, 0);
			 actual[119]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
			 bp.waitForElement(); 
			 actual[120]=dp.validateDashBoard(dashBoardName);
			 actual[121]=dp.selectDashboard(dashBoardName);
			 bp.waitForElement();
			 actual[122]=dp.clickOnAddGadgetSymbol();
			 actual[123]=dp.addGadget(gadget);
			 bp.waitForElement();
			 actual[124]=dp.validateGadget(gadget); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			 actual[125]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			 String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			 String [] user=new String [1];
			 user[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_9");
			 actual[126]=dp.filterBy(filterBy, user);
			 actual[127]=dp.saveGadget();
			 bp.waitForElement();	 
			 
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }        
	    
	}

	@Then("^Execution Backlog Gadget should be added for user with captial letters$")
	public void execution_Backlog_Gadget_should_be_added_for_user_with_captial_letters() throws Throwable {
		try
		 {
			actual[128]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			actual[129]=dp.viewMsg(filterBy);
			bp.waitForElement();
			
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }         
	    
	}

	@When("^Add Executions Backlog Gadget and select a project, release and tag name with captial letters$")
	public void add_Executions_Backlog_Gadget_and_select_a_project_release_and_tag_name_with_captial_letters() throws Throwable {
		  try
		   {
			  actual[130]=dp.clickOnAddGadgetSymbol();
			  actual[131]=dp.addGadget(gadget);
			  actual[132]=bp.waitForElement();
			  actual[133]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[134]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 3, 7);
			  String [] tag=new String [1];
			  tag[0]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 4, 11);
			  actual[135]=dp.filterBy(filterBy, tag);
			  actual[136]=dp.saveGadget();
			  bp.waitForElement();	 
		    }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }      
	    
	}

	@Then("^Execution Backlog Gadget should be added for tag with captial letters$")
	public void execution_Backlog_Gadget_should_be_added_for_tag_with_captial_letters() throws Throwable {
		try
		 {
			actual[137]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 3, 7);
			actual[138]=dp.viewMsg(filterBy);
			bp.waitForElement();
			
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }         
	    
	}

	@When("^Add Executions Backlog Gadget and select a project, release and custom name with captial letters$")
	public void add_Executions_Backlog_Gadget_and_select_a_project_release_and_custom_name_with_captial_letters() throws Throwable {
		 try
		   {
			  actual[139]=dp.clickOnAddGadgetSymbol();
			  actual[140]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[141]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[142]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 5, 7);
			  String [] custom=new String [1];
			  custom[0]=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 9);
			  actual[143]=dp.filterBy(filterBy, custom);
			  actual[144]=dp.saveGadget();
			  bp.waitForElement();	 
		    }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }      
	    
	}

	@Then("^Execution Backlog Gadget should be added for custom name with captial letters$")
	public void execution_Backlog_Gadget_should_be_added_for_custom_name_with_captial_letters() throws Throwable {
		try
		 {
			actual[145]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 5, 7);
			actual[146]=dp.viewMsg(filterBy);
			bp.waitForElement();
			
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }         
	    
	}

	@When("^Login as alpha numberic lead, add dashboard, add Executions Backlog Gadget and select a project, release and custom field name with alpha numberic$")
	public void login_as_alpha_numberic_lead_add_dashboard_add_Executions_Backlog_Gadget_and_select_a_project_release_and_custom_field_name_with_alpha_numberic() throws Throwable {
		try
		 {
			 actual[147]=pp.clickOnLogout();
			 String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_10");
		     String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Password_10");
			 actual[148]=lp.enterUnameAndPassword(name, passWord);
			 bp.waitForElement();
			 bp.waitForElement();
			 actual[149]=pp.selectProject(project);
			 actual[150]=pp.selectRelease(release);
			 bp.waitForElement();
			 actual[151]=rp.clickOnTestExecution();
			 actual[152]=bp.waitForElement();
			 actual[153]=tr.navigateToNode(release, cycleName);
			 bp.waitForElement(); 
			 String testCaseNo []=new String[1];
			 testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"Execution", 1, 0));
			 actual[154]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo);
			 bp.waitForElement();
			 String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
			 actual[155]=ep.changeMultiSelectedStatus(status);
			 bp.waitForElement();
			 String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 41, 0);
			 String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
			 String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
			 String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
			 actual[156]=dp.clickOnManageDashboards();
			 dp.validateDashboards();
			 actual[157]=dp.clickOnAddDashBoardSymbol();
			 actual[158]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
			 bp.waitForElement(); 
			 actual[159]=dp.validateDashBoard(dashBoardName);
			 actual[160]=dp.selectDashboard(dashBoardName);
			 bp.waitForElement();
			 actual[161]=dp.clickOnAddGadgetSymbol();
			 actual[162]=dp.addGadget(gadget);
			 bp.waitForElement();
			 actual[163]=dp.validateGadget(gadget); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			 actual[164]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			 String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			 String [] user=new String [1];
			 user[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_10");
			 actual[165]=dp.filterBy(filterBy, user);
			 actual[166]=dp.saveGadget();
			 bp.waitForElement();	 
			 
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }        
	    
	}

	@Then("^Execution Backlog Gadget should be added for user with alpha numberic$")
	public void execution_Backlog_Gadget_should_be_added_for_user_with_alpha_numberic() throws Throwable {
		try
		 {
			actual[167]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			actual[168]=dp.viewMsg(filterBy);
			bp.waitForElement();
			
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }        
	    
	}

	@When("^Add Executions Backlog Gadget and select a project, release and tag name with alpha numberic$")
	public void add_Executions_Backlog_Gadget_and_select_a_project_release_and_tag_name_with_alpha_numberic() throws Throwable {
		  try
		   {
			  actual[169]=dp.clickOnAddGadgetSymbol();
			  actual[170]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[171]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[172]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 3, 7);
			  String [] tag=new String [1];
			  tag[0]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 5, 11);
			  actual[173]=dp.filterBy(filterBy, tag);
			  actual[174]=dp.saveGadget();
			  bp.waitForElement();	 
		    }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }      
	    
	}

	@Then("^Execution Backlog Gadget should be added for tag with alpha numberic$")
	public void execution_Backlog_Gadget_should_be_added_for_tag_with_alpha_numberic() throws Throwable {
		try
		 {
			actual[175]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 3, 7);
			actual[176]=dp.viewMsg(filterBy);
			bp.waitForElement();
			
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }         
	    
	}

	@When("^Add Executions Backlog Gadget and select a project, release and custom name with alpha numberic$")
	public void add_Executions_Backlog_Gadget_and_select_a_project_release_and_custom_name_with_alpha_numberic() throws Throwable {
		 try
		   {
			  actual[177]=dp.clickOnAddGadgetSymbol();
			  actual[178]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[179]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[180]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 5, 7);
			  String [] custom=new String [1];
			  custom[0]=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 9);
			  actual[181]=dp.filterBy(filterBy, custom);
			  actual[182]=dp.saveGadget();
			  bp.waitForElement();	 
		    }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }      
	    
	}

	@Then("^Execution Backlog Gadget should be added for custom name with alpha numberic$")
	public void execution_Backlog_Gadget_should_be_added_for_custom_name_with_alpha_numberic() throws Throwable {
		try
		 {
			actual[183]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 5, 7);
			actual[184]=dp.viewMsg(filterBy);
			bp.waitForElement();
			
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }        
	    
	}

	@When("^Login as special characters lead, add dashboard, add Executions Backlog Gadget and select a project, release and custom field name with special characters$")
	public void login_as_special_characters_lead_add_dashboard_add_Executions_Backlog_Gadget_and_select_a_project_release_and_custom_field_name_with_special_characters() throws Throwable {
		try
		 {
			 actual[185]=pp.clickOnLogout();
			 String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Username_11");
		     String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_Password_11");
			 actual[186]=lp.enterUnameAndPassword(name, passWord);
			 bp.waitForElement();
			 bp.waitForElement();
			 actual[187]=pp.selectProject(project);
			 actual[188]=pp.selectRelease(release);
			 bp.waitForElement();
			 actual[189]=rp.clickOnTestExecution();
			 actual[190]=bp.waitForElement();
			 actual[191]=tr.navigateToNode(release, cycleName);
			 bp.waitForElement(); 
			 String testCaseNo []=new String[1];
			 testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"Execution", 1, 0));
			 actual[192]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo);
			 bp.waitForElement();
			 String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
			 actual[193]=ep.changeMultiSelectedStatus(status);
			 bp.waitForElement();
			 String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 42, 0);
			 String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
			 String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
			 String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
			 actual[194]=dp.clickOnManageDashboards();
			 dp.validateDashboards();
			 actual[195]=dp.clickOnAddDashBoardSymbol();
			 actual[196]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
			 bp.waitForElement(); 
			 actual[197]=dp.validateDashBoard(dashBoardName);
			 actual[198]=dp.selectDashboard(dashBoardName);
			 bp.waitForElement();
			 actual[199]=dp.clickOnAddGadgetSymbol();
			 actual[200]=dp.addGadget(gadget);
			 bp.waitForElement();
			 actual[201]=dp.validateGadget(gadget); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			 actual[202]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			 String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			 String [] user=new String [1];
			 user[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_11");
			 actual[203]=dp.filterBy(filterBy, user);
			 actual[204]=dp.saveGadget();
			 bp.waitForElement();	 
			 
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }       
	    
	}

	@Then("^Execution Backlog Gadget should be added for user with special characters$")
	public void execution_Backlog_Gadget_should_be_added_for_user_with_special_characters() throws Throwable {
		try
		 {
			actual[205]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			actual[206]=dp.viewMsg(filterBy);
			bp.waitForElement();
			
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }         
	    
	}

	@When("^Add Executions Backlog Gadget and select a project, release and tag name with special characters$")
	public void add_Executions_Backlog_Gadget_and_select_a_project_release_and_tag_name_with_special_characters() throws Throwable {
		  try
		   {
			  actual[207]=dp.clickOnAddGadgetSymbol();
			  actual[208]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[209]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[210]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 3, 7);
			  String [] tag=new String [1];
			  tag[0]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 6, 11);
			  actual[211]=dp.filterBy(filterBy, tag);
			  actual[212]=dp.saveGadget();
			  bp.waitForElement();	 
		    }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }      
	    
	}

	@Then("^Execution Backlog Gadget should be added for tag with special characters$")
	public void execution_Backlog_Gadget_should_be_added_for_tag_with_special_characters() throws Throwable {
		try
		 {
			actual[213]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 3, 7);
			actual[214]=dp.viewMsg(filterBy);
			bp.waitForElement();
			
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }         
	    
	}

	@When("^Add Executions Backlog Gadget and select a project, release and custom name with special characters$")
	public void add_Executions_Backlog_Gadget_and_select_a_project_release_and_custom_name_with_special_characters() throws Throwable {
	   
		 try
		   {
			  actual[215]=dp.clickOnAddGadgetSymbol();
			  actual[216]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[217]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[218]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 5, 7);
			  String [] custom=new String [1];
			  custom[0]=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 9);
			  actual[219]=dp.filterBy(filterBy, custom);
			  actual[220]=dp.saveGadget();
			  bp.waitForElement();	 
		    }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }      
	}

	@Then("^Execution Backlog Gadget should be added for custom name with special characters$")
	public void execution_Backlog_Gadget_should_be_added_for_custom_name_with_special_characters() throws Throwable {
		try
		 {
			actual[221]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 5, 7);
			actual[222]=dp.viewMsg(filterBy);
			bp.waitForElement();
			actual[223]=pp.backToProjectPage();
			for(int k=0;k<=actual.length-1;k++)
			{
			System.out.println("Actual["+k+"]="+actual[k]);
			soft.assertEquals(actual[k], true);
			}
		 }
		
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }         
	    
	}


}
