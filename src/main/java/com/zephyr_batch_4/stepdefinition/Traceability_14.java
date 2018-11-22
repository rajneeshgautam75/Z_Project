package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Traceability_14 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	DashBoardPage dbp;
	RequirementsPage req;
	String fileName="Traceability_14";
	
	boolean[] actual=new boolean[43];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^As a Lead,Launch Requirement page$")
	public void as_a_Lead_Launch_Requirement_page() throws Throwable {
	    try
	    {
	    	   bp=new BasePage();
			   rp=new ReleasePage(driver);
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			   String projectName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");

				String Hide = Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100, 100);
				String Desc = Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100, 100);
				String MapexternalDefect = Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100, 100);
				String syear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 2));
				String smonth = Excel_Lib.getData(INPUT_PATH_3, "Projects", 0, 3);
				String sday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 4));
				String eyear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 5));
				String emonth = Excel_Lib.getData(INPUT_PATH_3, "Projects", 0, 6);
				String eday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 7));

				bp.waitForElement();
			    pp.selectProject(projectName1);
			    actual[0]=pp.selectProject(projectName);
			     rp.clickOnManageRelease();
			     boolean res1 = rp.checkAvailableRelease(releaseName);
				if (res1 == false) {

					rp.addNewRelease(releaseName, Desc, Hide, MapexternalDefect);

					rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);

					rp.clickOnAdd();
					bp.waitForElement();
				}
			   pp.selectProject(projectName);
			   actual[1]=pp.selectRelease(releaseName);
			   rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[2]=rp.clickOnRequirements();
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

	@When("^create a node and add requirement names with different characters$")
	public void create_a_node_and_add_requirement_names_with_different_characters() throws Throwable {
	   try
	   {
		   req=new RequirementsPage(driver);
		   tr=new TestRepositoryPage(driver);
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 35);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 36);
			
			actual[3]=tr.clickOnRelease(releaseName);
			bp.waitForElement();
			actual[4]=req.addNode(p_Name1,p_Desc1);
			bp.waitForElement();
		    String[] str=new String[1];
		    str[0]=p_Name1;
		    actual[5]=tr.navigateToNode(releaseName, str);
		    for(int i=0;i<=7;i++)
		    {
		    req.addRequirement();
		    }
		    String[] requirementNum1=new String[1];
		    requirementNum1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 15));
		    tr.clickOnDetails();
		    req.selectMultipleRequirementFromGrids(requirementNum1);
		    
		    
		    String name1=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",18,0);
	    	String altID=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
	    	String link=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
	    	String priority=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
	    	String Description=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
		    actual[6]=req.enterRequirementDetails(name1, altID, link, priority, Description);
		    //tr.clickOnList();
		    
		    String[] requirementNum2=new String[1];
		    requirementNum2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 2, 15));
		    //tr.clickOnDetails();
		    req.selectMultipleRequirementFromGrids(requirementNum2);
		    String name2=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",19,0);
		    actual[7]=req.enterRequirementDetails(name2, altID, link, priority, Description);
		    //tr.clickOnList();
		    
		    String[] requirementNum3=new String[1];
		    requirementNum3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 3, 15));
		    req.selectMultipleRequirementFromGrids(requirementNum3);
		    //tr.clickOnDetails();
		    String name3=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"DashBoards",20,0));
		    actual[8]=req.enterRequirementDetails(name3, altID, link, priority, Description);
		    //tr.clickOnList();
		    
		    String[] requirementNum4=new String[1];
		    requirementNum4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 4, 15));
		    req.selectMultipleRequirementFromGrids(requirementNum4);
		    //tr.clickOnDetails();
		    String name4=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",11,0);
		    actual[9]=req.enterRequirementDetails(name4, altID, link, priority, Description);
		    //tr.clickOnList();
		    
		    String[] requirementNum5=new String[1];
		    requirementNum5[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 5, 15));
		    req.selectMultipleRequirementFromGrids(requirementNum5);
		    //tr.clickOnDetails();
		    String name5=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",10,0);
		    actual[10]=req.enterRequirementDetails(name5, altID, link, priority, Description);
		    //tr.clickOnList();
		    
		    String[] requirementNum6=new String[1];
		    requirementNum6[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 6, 15));
		    req.selectMultipleRequirementFromGrids(requirementNum6);
		    //tr.clickOnDetails();
		    String name6=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",10,0);
		    actual[11]=req.enterRequirementDetails(name6, altID, link, priority, Description);
		    //tr.clickOnList();
		    
		    String[] requirementNum7=new String[1];
		    requirementNum7[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 7, 15));
		    req.selectMultipleRequirementFromGrids(requirementNum7);
		    //tr.clickOnDetails();
		    String name7=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",12,0);
		    actual[12]=req.enterRequirementDetails(name7, altID, link, priority, Description);
		    bp.waitForElement();
		    bp.waitForElement();
		    //tr.clickOnList();
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

	@When("^Launch the DashBoard page$")
	public void launch_the_DashBoard_page() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
			bp=new BasePage();
			actual[13]=dbp.clickOnManageDashboards();
			actual[14]=dbp.validateDashboards();
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

	@When("^Add a DsahBoard with available fields$")
	public void add_a_DsahBoard_with_available_fields() throws Throwable {
		try
		{
		actual[15]=dbp.clickOnAddDashBoardSymbol();
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,35);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[16]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
		actual[17]=dbp.validateDashBoard(dashboardName);
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

	@When("^Click on add gadget symbol and add a Traceability gadget$")
	public void click_on_add_gadget_symbol_and_add_a_Traceability_gadget() throws Throwable {
		try
	    {
	    	String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,35);
	    	actual[18]=dbp.selectDashboard(dashboardName);
	    	actual[19]=dbp.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
			 actual[20]=dbp.addGadget(gadgetName);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[21]=dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 
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

	@When("^search a requirement name with lowercase character$")
	public void search_a_requirement_name_with_lowercase_character() throws Throwable {
		try
	    {
	    	 actual[22]=dbp.manageTraceability();
	    	 driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 //dbp.gadgetOperation(value);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
	    	 String searchOption=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 18,0); 
	    	 actual[23]=dbp.traceabilityQuickSearch(searchOption);
	    	 
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

	@Then("^Should be able to search requirement$")
	public void should_be_able_to_search_requirement() throws Throwable {
	    try
	    {
	    	 req=new RequirementsPage(driver);
	    	 String requirementValue=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 18,0);
	    	 actual[24]= dbp.validateRequirements(requirementValue);
	    	 actual[25]=req.selectAllRequirements();
	    	 dbp.closeTraceabilityTable();
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

	@When("^search a requirement name with uppercase character$")
	public void search_a_requirement_name_with_uppercase_character() throws Throwable {
		try
	    {
			actual[26]=dbp.manageTraceability();
			driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 //dbp.gadgetOperation(value);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();

	    	 String searchOption=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 19,0); 
	    	 actual[27]=dbp.traceabilityQuickSearch(searchOption);
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

	@Then("^shOuld be able to search the requirement$")
	public void should_be_able_to_search_the_requirement() throws Throwable {
		try
	    {
	    	 String requirementValue=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 19,0);
	    	 actual[28]=dbp.validateRequirements(requirementValue);
	    	 req.selectAllRequirements();
	    	 dbp.closeTraceabilityTable();
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

	@When("^search a requirement name with number$")
	public void search_a_requirement_name_with_number() throws Throwable {
		try
	    {
			actual[29]=dbp.manageTraceability();
			driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 //dbp.gadgetOperation(value);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();

	    	 String searchOption=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 20,0)); 
	    	 dbp.traceabilityQuickSearch(searchOption);
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

	@Then("^shoUld be able to search The requirement$")
	public void should_be_able_to_search_The_requirement() throws Throwable {
		try
	    {
	    	 String requirementValue=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 20,0));
	    	 actual[30]=dbp.validateRequirements(requirementValue);
	    	 req.selectAllRequirements();
	    	 dbp.closeTraceabilityTable();
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

	@When("^search a requirement name with special character$")
	public void search_a_requirement_name_with_special_character() throws Throwable {
		try
	    {
			actual[31]=dbp.manageTraceability();
			driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 //dbp.gadgetOperation(value);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();

	    	 String searchOption=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 11,0); 
	    	 actual[32]=dbp.traceabilityQuickSearch(searchOption);
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

	@Then("^shouLd be able to search tHe requirement$")
	public void should_be_able_to_search_tHe_requirement() throws Throwable {
		try
	    {
			actual[33]=req.VerifyRequirementCount();
			bp.waitForElement();
			dbp.traceabilityQuickSearch.click();
			bp.waitForElement();
			dbp.traceabilityAdvancedSearch.click();
			bp.waitForElement();
			dbp.closeTraceabilityTable();
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

	@When("^search requirement name with international character$")
	public void search_requirement_name_with_international_character() throws Throwable {
		try
	    {
			actual[34]=dbp.manageTraceability();
			driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 //dbp.gadgetOperation(value);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();

	    	 String searchOption=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 10,0); 
	    	 actual[35]=dbp.traceabilityQuickSearch(searchOption);
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

	@Then("^shoulD be able to search thE requirement$")
	public void should_be_able_to_search_thE_requirement() throws Throwable {
		try
	    {
	    	 String requirementValue=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 10,0);
	    	 actual[36]=dbp.validateRequirements(requirementValue);
	    	 req.selectAllRequirements();
	    	 dbp.closeTraceabilityTable();
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

	@When("^search a requirements created with same name$")
	public void search_a_requirements_created_with_same_name() throws Throwable {
		try
	    {
			actual[37]=dbp.manageTraceability();
			driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 //dbp.gadgetOperation(value);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();

	    	 String searchOption=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 10,0); 
	    	 actual[38]=dbp.traceabilityQuickSearch(searchOption);
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

	@Then("^should be able to Search requirement$")
	public void should_be_able_to_Search_requirement() throws Throwable {
		try
	    {
	    	 String requirementValue=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 10,0);
	    	 actual[39]=dbp.validateRequirements(requirementValue);
	    	 req.selectAllRequirements();
	    	 dbp.closeTraceabilityTable();
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

	@When("^search a requirement name with long name$")
	public void search_a_requirement_name_with_long_name() throws Throwable {
		try
	    {
			actual[40]=dbp.manageTraceability();
			driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 //dbp.gadgetOperation(value);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();

	    	 String searchOption=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 12,0); 
	    	 actual[41]=dbp.traceabilityQuickSearch(searchOption);
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

	@Then("^Should be able to search Requirement$")
	public void should_be_able_to_search_Requirement() throws Throwable {
		try
	    {
	    	 String requirementValue=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 12,0);
	    	 actual[42]=dbp.validateRequirements(requirementValue);
	    	 req.selectAllRequirements();
	    	 dbp.closeTraceabilityTable();
			 bp.waitForElement();
			 dbp.saveGadget();
			 bp.waitForElement();
			 pp.backToProjectPage();
			 
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
