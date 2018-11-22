package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Dashboard_9 extends LaunchBrowser{
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	DashBoardPage dbp;
	String fileName="Dashboard_9";
	
	boolean[] actual=new boolean[33];
	 SoftAssert soft=new SoftAssert();
	 	
//	@Given("^Manager is in administration page for creating projects$")
//	public void manager_is_in_administration_page_for_creating_projects() throws Throwable {
//		try
//	    {
//			bp=new BasePage();
//		 	 lb.preCond();
//		 	 String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"URL");
//		 	 lb.getUrl(url);
//		 	 lp=new LoginPage(driver);
//		 	 pp=new ProjectPage(driver);
//		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Manager_Username_1");
//		     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Manager_Password_1");
//		     lp.enterUname(Uname);
//		     lp.enterPass(Pass);
//		     lp.clickOnLogin();
//		     bp.waitForElement();
//		     
//		     actual[0]=pp.launchAdministration();
//	 	 	  bp.waitForElement();
//	 	 	  actual[1]=pp.launchManageprojects();
//	 	 	  bp.waitForElement();
//	 	 	  
//	 	 	boolean result1=pp.validateProject(project1);
//			  //System.out.println(result + " inside step definition");
//			  if(result1==false)
//			   {
//			  String typeName=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1, 9);
//			  actual[2]=pp.createProject(project1, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
//			  bp.waitForElement();
//				}
//			  
//			  boolean result2=pp.validateProject(project2);
//			  //System.out.println(result + " inside step definition");
//			  if(result2==false)
//			   {
	 
	 
	 
	 
	 //remove commented part
	 //ok i 'll do later
	 
//			  String typeName=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1, 9);
//			  actual[2]=pp.createProject(project2, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
//			  bp.waitForElement();
//				}
//			  boolean result3=pp.validateProject(project3);
//			  //System.out.println(result + " inside step definition");
//			  if(result3==false)
//			   {
//			  String typeName=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1, 9);
//			  actual[2]=pp.createProject(project3, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
//			  bp.waitForElement();
//				}
//			  boolean result4=pp.validateProject(project4);
//			  //System.out.println(result + " inside step definition");
//			  if(result4==false)
//			   {
//			  String typeName=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1, 9);
//			  actual[2]=pp.createProject(project4, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
//			  bp.waitForElement();
//				}
//	    }
//	    catch(Exception e)
//		{
//		   lb=new LaunchBrowser();
//		   lb.getScreenShot(fileName);
//		   e.printStackTrace();
//		   driver.close();
//	      	Relogin_TPE rl=new Relogin_TPE();
//	      	rl.reLogin();
//	      	throw e;
//		}
//	}
	 String lowerCaseProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_3");
	 String interNationalCaseProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4");
	 String specialCharProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_5");
	 String maxCharProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_6");
	 String minCharProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_7");
	 String upperCaseProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_8");
	 
	 String releaseName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
	 String releaseName2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
	 String releaseName3=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_6");
	 String releaseName4=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_7");
	 String releaseName5=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_8");
	 String releaseName6=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_9");
	 
	 //open feature file
	 String Hide=Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100,100);
 	 String Desc=Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100,100);
	 String MapexternalDefect=Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100,100);
 	 String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 2));
	 String smonth=Excel_Lib.getData(INPUT_PATH_3, "Projects", 0, 3);
	 String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 4));
	 String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 5));
	 String emonth=Excel_Lib.getData(INPUT_PATH_3, "Projects", 0, 6);
	 String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 7));
	 
 	@Given("^User create a releases for the projects in testRepository$")
 	public void user_create_a_releases_for_the_projects_in_testRepository() throws Throwable {
 		try
	    {
	    	dbp=new DashBoardPage(driver);
			bp=new BasePage();
			bp=new BasePage();
		    rp=new ReleasePage(driver);
		    pp=new ProjectPage(driver);

			   //boolean res1=rp.checkAvailableRelease(releaseName1);
				//boolean res2=rp.checkAvailableRelease(releaseName2);
				//boolean res3=rp.checkAvailableRelease(releaseName3);
				//boolean res4=rp.checkAvailableRelease(releaseName4);
				//boolean res5=rp.checkAvailableRelease(releaseName5);
				//boolean res6=rp.checkAvailableRelease(releaseName6);
		      // pp.backToProjectPage();
			   actual[0]=pp.selectProject(lowerCaseProject);
			   actual[1]=rp.clickOnManageRelease();
			   
			   boolean res1=rp.checkAvailableRelease(releaseName1);
				if(res1==false)
				{
		    	rp.addNewRelease(releaseName1, Desc, Hide, MapexternalDefect);
				rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
				rp.clickOnAdd();
				bp.waitForElement();
				}
				
					actual[0]=pp.selectProject(interNationalCaseProject);
				    actual[1]=rp.clickOnManageRelease();
				    bp.waitForElement();
				    boolean res2=rp.checkAvailableRelease(releaseName2);
					if(res2==false)
					{
			    	rp.addNewRelease(releaseName2, Desc, Hide, MapexternalDefect);
					rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
					rp.clickOnAdd();
					bp.waitForElement();
					}
					
					   actual[0]=pp.selectProject(specialCharProject);
				       actual[1]=rp.clickOnManageRelease();
					    bp.waitForElement();
					    boolean res3=rp.checkAvailableRelease(releaseName3);
						if(res3==false)
						{
				    	rp.addNewRelease(releaseName3, Desc, Hide, MapexternalDefect);
						rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
						rp.clickOnAdd();
						bp.waitForElement();
						}
				
						
						pp.selectProject(maxCharProject);
						actual[1]=rp.clickOnManageRelease();
						bp.waitForElement();
						boolean res4=rp.checkAvailableRelease(releaseName4);
							if(res4==false)
							{
					    	rp.addNewRelease(releaseName4, Desc, Hide, MapexternalDefect);
							rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
							rp.clickOnAdd();
							bp.waitForElement();
							}
							   
			
							   pp.selectProject(minCharProject);
							   actual[1]=rp.clickOnManageRelease();
							   bp.waitForElement();
							   boolean res5=rp.checkAvailableRelease(releaseName5);
								if(res5==false)
								{
						    	rp.addNewRelease(releaseName5, Desc, Hide, MapexternalDefect);
								rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
								rp.clickOnAdd();
								bp.waitForElement();
								}
							
							   pp.selectProject(upperCaseProject);
							   actual[1]=rp.clickOnManageRelease();
							   bp.waitForElement();
							   boolean res6=rp.checkAvailableRelease(releaseName6);	
								if(res6==false)
								{
						    	rp.addNewRelease(releaseName6, Desc, Hide, MapexternalDefect);
								rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
								rp.clickOnAdd();
								bp.waitForElement();
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

	 	
	
	@When("^User is in the DashBoard page$")
	public void user_is_in_the_DashBoard_page() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
			bp=new BasePage();
			actual[0]=dbp.clickOnManageDashboards();
			actual[1]=dbp.validateDashboards();
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

	@When("^User create a DashBoard$")
	public void user_create_a_DashBoard() throws Throwable {
		try
		{
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 9,2);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[2]=dbp.clickOnAddDashBoardSymbol();
		actual[3]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
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

	@When("^User add a Test Automation Status gadget and select project and release$")
	public void user_add_a_Test_Automation_Status_gadget_and_select_project_and_release() throws Throwable {
		try
	    {
	    	String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 9,2);
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_3"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8); 
			 actual[4]=dbp.selectDashboard(dashboardName);
	    	 actual[5]=dbp.clickOnAddGadgetSymbol();
	    	 actual[6]=dbp.addGadget(gadgetName);
			 actual[7]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
			 
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

	@Then("^GadgEt added successfully$")
	public void gadget_added_successfully() throws Throwable {
		try
		{
		     String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
		     actual[8]=dbp.validateGadget(gadgetName);
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

	@When("^User add a tEst Automation Status gadget and select a project and release name containing only lowercase char$")
	public void user_add_a_tEst_Automation_Status_gadget_and_select_a_project_and_release_name_containing_only_lowercase_char() throws Throwable {
		try
	    {
	    	
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_3"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8); 
			 actual[9]=dbp.clickOnAddGadgetSymbol();
			 actual[10]=dbp.addGadget(gadgetName);
			 actual[11]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
			 
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

	@Then("^gadget created successfully$")
	public void gadget_created_successfully() throws Throwable {
		try
		{
		     String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
		     actual[12]=dbp.validateGadget(gadgetName);
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

	@When("^User add a teSt Automation status gadget and select a project and release name containing only international char$")
	public void user_add_a_teSt_Automation_status_gadget_and_select_a_project_and_release_name_containing_only_international_char() throws Throwable {
		try
	    {
	    	
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");  
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8); 
			 actual[13]=dbp.clickOnAddGadgetSymbol();
			 actual[14]=dbp.addGadget(gadgetName);
			 bp.waitForElement();
			 actual[15]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
			 
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

	@Then("^Gadget is added successfully$")
	public void gadget_is_added_successfully() throws Throwable {
		try
		{
		     String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
		     actual[16]=dbp.validateGadget(gadgetName);
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

	@When("^User add a tesT automation status gadget and select a project and release name containing only special char$")
	public void user_add_a_tesT_automation_status_gadget_and_select_a_project_and_release_name_containing_only_special_char() throws Throwable {
		try
	    {
	    	
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_5"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_6"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8); 
			 actual[17]=dbp.clickOnAddGadgetSymbol();
			 actual[18]=dbp.addGadget(gadgetName);
			 actual[19]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
			 
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

	@Then("^gAdget is adDed successfully$")
	public void gadget_is_adDed_successfully() throws Throwable {
		try
		{
		     String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
		     actual[20]=dbp.validateGadget(gadgetName);
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

	@When("^User add a test Automation status gadget and select a project and release name with max char limit$")
	public void user_add_a_test_Automation_status_gadget_and_select_a_project_and_release_name_with_max_char_limit() throws Throwable {
		try
	    {
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_6"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_7"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8);
			 actual[21]=dbp.clickOnAddGadgetSymbol();
			 actual[22]=dbp.addGadget(gadgetName);
			 actual[23]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
			 
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

	@Then("^gadGet is addEd successfully$")
	public void gadget_is_addEd_successfully() throws Throwable {
		try
		{
		     String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
		     actual[24]=dbp.validateGadget(gadgetName);
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

	@When("^User add a test Automation status gadget and select a project and release name with min char limit$")
	public void user_add_a_test_Automation_status_gadget_and_select_a_project_and_release_name_with_min_char_limit() throws Throwable {
		try
	    {
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_7"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_8");  
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8); 
			 actual[25]=dbp.clickOnAddGadgetSymbol();
			 actual[26]=dbp.addGadget(gadgetName);
			 actual[27]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
			 
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

	@Then("^gadgeT is addeD successfully$")
	public void gadget_is_addeD_successfully() throws Throwable {
		try
		{
		     String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
		     actual[28]=dbp.validateGadget(gadgetName);
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

	@When("^User add a test AutoMation status gadget and select project and release name containing uppercase$")
	public void user_add_a_test_AutoMation_status_gadget_and_select_project_and_release_name_containing_uppercase() throws Throwable {
		try
	    {
	    	
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_8"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_9");  
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8); 
			 actual[29]=dbp.clickOnAddGadgetSymbol();
			 actual[30]=dbp.addGadget(gadgetName);
			 actual[31]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
			 
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

	@Then("^gadget is created successfully$")
	public void gadget_is_created_successfully() throws Throwable {
		try
		{
		     String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6);
//			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_8"); 
//			 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_9"); 
		     //actual[32]=dbp.validate(projectName, releaseName);
			 actual[32]=dbp.validateGadget(gadgetName);
		     bp.waitForElement();
		     
		     pp.backToProjectPage();
		     
		     for(int k=0;k<=actual.length-1;k++)
				{
					//System.out.println("Actual["+k+"]="+actual[k]);
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
