package com.zephyr_batch_2.stepdefinition;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Search_868213 extends LaunchBrowser
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
	boolean[] actual=new boolean[94];
	String fileName="Search_868213";
	String[] ids=new String[2];
	@Given("^user select the project and click on manage release$")
	public void user_select_the_project_and_click_on_manage_release() throws Throwable 
	{
		try
		   {
			   pp=new ProjectPage(driver);
			   //String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,0);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			   //String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			   actual[0]=pp.selectProject(projectName);
			   bp=new BasePage();
			   bp.waitForElement();
			  
//			   actual[1]=pp.selectRelease(releaseName);
//			   bp.waitForElement();
//			   rp= new ReleasePage(driver);
//			   actual[2]=rp.clickOnTestRep();
//			   bp.waitForElement();
//			   tr=new TestRepositoryPage(driver);
//			   actual[3]=tr.doubleClickOnRelease(releaseName);
//			   bp.waitForElement();
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

	@Given("^add different releases with name containing different characters$")
	public void add_different_releases_with_name_containing_different_characters() throws Throwable 
	{
		try
		{
			 rp=new ReleasePage(driver);
			   rp.clickOnManageRelease();
			   bp.waitForElement();
			String release1=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 1, 0);
			String Desc1=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 1, 1);
			String Hide=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 100,100);
			String MapexternalDefect=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 100,100);
			rp.addNewRelease(release1, Desc1, Hide, MapexternalDefect);
			
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
			rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			rp.clickOnAdd();
			bp.waitForElement();
			
			String release2=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 2, 0);
			String Desc2=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 2, 1);
			rp.addNewRelease(release2, Desc2, Hide, MapexternalDefect);
			rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			rp.clickOnAdd();
			bp.waitForElement();
			
			String release3=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "AddReleases", 3, 0));
			String Desc3=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 3, 1);
			rp.addNewRelease(release3, Desc3, Hide, MapexternalDefect);
			rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			rp.clickOnAdd();
			bp.waitForElement();
			
			String release4=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 4, 0);
			String Desc4=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 4, 1);
			rp.addNewRelease(release4, Desc4, Hide, MapexternalDefect);
			rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			rp.clickOnAdd();
			bp.waitForElement();
			
			/*String release5=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 5, 0);
			String Desc5=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 5, 1);
			rp.addNewRelease(release5, Desc5, Hide, MapexternalDefect);
			rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			rp.clickOnAdd();
			bp.waitForElement();*/
			
			String release6=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 6, 0);
			String Desc6=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 6, 1);
			rp.addNewRelease(release6, Desc6, Hide, MapexternalDefect);
			rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			rp.clickOnAdd();
			bp.waitForElement();
			
			String release7=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 7, 0);
			String Desc7=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 7, 1);
			rp.addNewRelease(release7, Desc7, Hide, MapexternalDefect);
			rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			rp.clickOnAdd();
			bp.waitForElement();
			
			String release8=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 8, 0);
			String Desc8=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 8, 1);
			rp.addNewRelease(release8, Desc8, Hide, MapexternalDefect);
			rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			rp.clickOnAdd();
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

	@When("^launch all the releses and create phase and add test cases$")
	public void launch_all_the_releses_and_create_phase_and_add_test_cases() throws Throwable 
	{
		try
		{
			   //select the project//////////////////////////////////////////////////////////////////////////////////
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			   actual[0]=pp.selectProject(projectName);
			   //select the release
			   String release1=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 1, 0);
			   actual[1]=pp.selectRelease(release1);
			   bp.waitForElement();
			   //click on test repository
			   rp= new ReleasePage(driver);
			   actual[2]=rp.clickOnTestRep();
			   bp.waitForElement();
			   tr=new TestRepositoryPage(driver);
			   //double click on relelease
			   actual[3]=tr.clickOnRelease(release1);
			   bp.waitForElement();
			   //add node		   
			   String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 65, 0);
				String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 65, 1);
				actual[4]=tr.addNode(phaseName, phaseDesc);
				 //double click on relelease				tr.navigateToNode(release1, phase);

				tr.doubleClickOnRelease(release1);
				bp.waitForElement();
				//Navigate to node
				String phase[]=new String[1];
				phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 65, 0);
				tr.navigateToNode(release1, phase);
				bp.waitForElement();
				//add testcases
				for(int i=0;i<=3;i++)
				{
					tr.addTestCase();
				}
				
				////////////////////////////////////////////////////////////////////////////////////////////////
				//select the project
				   actual[0]=pp.selectProject(projectName);
				   //select the release
				   String release2=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 2, 0);
				   actual[1]=pp.selectRelease(release2);
				   bp.waitForElement();
				   //click on test repository
				   rp= new ReleasePage(driver);
				   actual[2]=rp.clickOnTestRep();
				   bp.waitForElement();
				   tr=new TestRepositoryPage(driver);
				   //double click on relelease
				   actual[3]=tr.clickOnRelease(release2);
				   bp.waitForElement();
				   //add node		   
				   String phaseName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 65, 2);
					String phaseDesc2=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 38, 1);
					actual[4]=tr.addNode(phaseName2, phaseDesc2);
					 //double click on relelease
					tr.doubleClickOnRelease(release2);
					bp.waitForElement();
					//Navigate to node
					String phase2[]=new String[1];
					phase2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 65, 2);
					tr.navigateToNode(release2, phase2);
					bp.waitForElement();
					//add testcases
					for(int i=0;i<=3;i++)
					{
						tr.addTestCase();
					}
				   ///////////////////////////////////////////////////////////////////////////
					//select the project
					   actual[0]=pp.selectProject(projectName);
					   //select the release
					   bp.waitForElement();
					   String release3=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "AddReleases", 3, 0));
					   actual[1]=pp.selectRelease(release3);
					   bp.waitForElement();
					   //click on test repository
					   rp= new ReleasePage(driver);
					   actual[2]=rp.clickOnTestRep();
					   bp.waitForElement();
					   tr=new TestRepositoryPage(driver);
					   //double click on relelease
					   actual[3]=tr.clickOnRelease(release3);
					   bp.waitForElement();
					   //add node		   
					   String phaseName3=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 65, 4);
						String phaseDesc3=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 38, 1);
						actual[4]=tr.addNode(phaseName3, phaseDesc3);
						 //double click on relelease
						tr.doubleClickOnRelease(release3);
						bp.waitForElement();
						//Navigate to node
						String phase3[]=new String[1];
						phase3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 65, 4);
						tr.navigateToNode(release3, phase3);
						bp.waitForElement();
						//add testcases
						for(int i=0;i<=3;i++)
						{
							tr.addTestCase();
						}
						////////////////////////////////////////////////////////////////////////////////////
						//select the project
						   actual[0]=pp.selectProject(projectName);
						   //select the release
						   String release4=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 4, 0);
						   actual[1]=pp.selectRelease(release4);
						   bp.waitForElement();
						   //click on test repository
						   rp= new ReleasePage(driver);
						   actual[2]=rp.clickOnTestRep();
						   bp.waitForElement();
						   tr=new TestRepositoryPage(driver);
						   //double click on relelease
						   actual[3]=tr.clickOnRelease(release4);
						   bp.waitForElement();
						   //add node		   
						   String phaseName4=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 65, 6);
							String phaseDesc4=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 38, 1);
							actual[4]=tr.addNode(phaseName4, phaseDesc4);
							 //double click on relelease
							tr.doubleClickOnRelease(release4);
							bp.waitForElement();
							//Navigate to node
							String phase4[]=new String[1];
							phase4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 65, 6);
							tr.navigateToNode(release4, phase4);
							bp.waitForElement();
							//add testcases
							for(int i=0;i<=3;i++)
							{
								tr.addTestCase();
							}
							///////////////////////////////////////////////////////////////////////////////////
							//select the project
//							   actual[0]=pp.selectProject(projectName);
//							   //select the release
//							   String release5=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 5, 0);
//							   actual[1]=pp.selectRelease(release5);
//							   bp.waitForElement();
//							   //click on test repository
//							   rp= new ReleasePage(driver);
//							   actual[2]=rp.clickOnTestRep();
//							   bp.waitForElement();
//							   tr=new TestRepositoryPage(driver);
//							   //double click on relelease
//							   actual[3]=tr.doubleClickOnRelease(release5);
//							   bp.waitForElement();
//							   //add node		   
//							   String phaseName5=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 65, 8);
//								String phaseDesc5=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 38, 1);
//								actual[4]=tr.addNode(phaseName5, phaseDesc5);
//								 //double click on relelease
//								tr.doubleClickOnRelease(release5);
//								bp.waitForElement();
//								//Navigate to node
//								String phase5[]=new String[1];
//								phase5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 65, 8);
//								tr.navigateToNode(release5, phase5);
//								bp.waitForElement();
//								//add testcases
//								for(int i=0;i<=3;i++)
//								{
//									tr.addTestCase();
//								}
								////////////////////////////////////////////////////////////////////////////
								//select the project
								   actual[0]=pp.selectProject(projectName);
								   //select the release
								   String release6=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 6, 0);
								   actual[1]=pp.selectRelease(release6);
								   bp.waitForElement();
								   //click on test repository
								   rp= new ReleasePage(driver);
								   actual[2]=rp.clickOnTestRep();
								   bp.waitForElement();
								   tr=new TestRepositoryPage(driver);
								   //double click on relelease
								   actual[3]=tr.clickOnRelease(release6);
								   bp.waitForElement();
								   //add node		   
								   String phaseName6=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 65, 10);
									String phaseDesc6=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 38, 1);
									actual[4]=tr.addNode(phaseName6, phaseDesc6);
									 //double click on relelease
									tr.doubleClickOnRelease(release6);
									bp.waitForElement();
									//Navigate to node
									String phase6[]=new String[1];
									phase6[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 65, 10);
									tr.navigateToNode(release6, phase6);
									bp.waitForElement();
									//add testcases
									for(int i=0;i<=3;i++)
									{
										tr.addTestCase();
									}
									/////////////////////////////////////////////////////////////////////////////////
									//select the project
									   actual[0]=pp.selectProject(projectName);
									   //select the release
									   String release7=Excel_Lib.getData(INPUT_PATH_4, "AddReleases",7, 0);
									   actual[1]=pp.selectRelease(release7);
									   bp.waitForElement();
									   //click on test repository
									   rp= new ReleasePage(driver);
									   actual[2]=rp.clickOnTestRep();
									   bp.waitForElement();
									   tr=new TestRepositoryPage(driver);
									   //double click on relelease
									   actual[3]=tr.clickOnRelease(release7);
									   bp.waitForElement();
									   //add node		   
									   String phaseName7=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 65, 12);
										String phaseDesc7=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 38, 1);
										actual[4]=tr.addNode(phaseName7, phaseDesc7);
										 //double click on relelease
										tr.doubleClickOnRelease(release7);
										bp.waitForElement();
										//Navigate to node
										String phase7[]=new String[1];
										phase7[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 65, 12);
										tr.navigateToNode(release7, phase7);
										bp.waitForElement();
										//add testcases
										for(int i=0;i<=3;i++)
										{
											tr.addTestCase();
										}
										///////////////////////////////////////////////////////////////////////////////////
										//select the project
										   actual[0]=pp.selectProject(projectName);
										   //select the release
										   String release8=Excel_Lib.getData(INPUT_PATH_4, "AddReleases",8, 0);
										   actual[1]=pp.selectRelease(release8);
										   bp.waitForElement();
										   //click on test repository
										   rp= new ReleasePage(driver);
										   actual[2]=rp.clickOnTestRep();
										   bp.waitForElement();
										   tr=new TestRepositoryPage(driver);
										   //double click on relelease
										   actual[3]=tr.clickOnRelease(release8);
										   bp.waitForElement();
										   //add node		   
										   String phaseName8=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 65, 14);
											String phaseDesc8=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 38, 1);
											actual[4]=tr.addNode(phaseName8, phaseDesc8);
											 //double click on relelease
											tr.doubleClickOnRelease(release8);
											bp.waitForElement();
											//Navigate to node
											String phase8[]=new String[1];
											phase8[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 65, 14);
											tr.navigateToNode(release8,phase8);
											bp.waitForElement();
											//add testcases
											for(int i=0;i<=3;i++)
											{
												tr.addTestCase();
											}
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

	@When("^Launch Testplanning Create cycle add Free Form Phase$")
	public void launch_Testplanning_Create_cycle_add_Free_Form_Phase() throws Throwable 
	{
		try
		{
			tl=new TestPlanningPage(driver);
			actual[30]=rp.clickOnTestPlanning();
			 bp.waitForElement();
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 55, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 6, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 6, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
			actual[31]=tl.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[32]=tl.CreateCycle(cyclename, Build, Environment,hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
			actual[33]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[34]=tl.saveTestCycle();
			bp.waitForElement();
		   String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 55, 0);
			actual[35]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String freeFormName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 55, 4);
			tl.createFreeFormPhase(freeFormName1);
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

	@When("^select Freeform and click on add testcase and Click on Advance search$")
	public void select_Freeform_and_click_on_add_testcase_and_Click_on_Advance_search() throws Throwable 
	{
		try
		{
			String[] freeform1=new String[1];
			freeform1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 55, 4);
			bp.waitForElement();
			tl.navigateToCycle(freeform1);
		    tl.clickOnAddTestcasesToFreeForm();
		    bp.waitForElement();
		    tl.clickOnAdvanceSearch();
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

	@Then("^search Testcases by releases with different charecters and add to free form$")
	public void search_Testcases_by_releases_with_different_charecters_and_add_to_free_form() throws Throwable 
	{
		try
		{
		String name=Excel_Lib.getData(INPUT_PATH_4, "zql", 13, 0);
		String operator=Excel_Lib.getData(INPUT_PATH_4, "zql", 11, 1);
		//String value1=ids[0];
		String release1=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 8, 4);
	    tl.ZQLSearch1(name, operator, release1);
	    bp.waitForElement();
	    tl.validateSearch();
	    bp.waitForElement();
	    tl.selectAllFreeFormTestCases();
	    bp.waitForElement();
	    tl.clickOnSaveAndOk();
	    bp.waitForElement();
	    tl.closeFreeFormPage();
	    bp.waitForElement();
	    tl.validateAddtestcaesToFreeForm();
	    bp.waitForElement();
	    rp.clickOnTestPlanning();
		 bp.waitForElement();
		 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		   actual[0]=pp.selectProject(projectName);
		   String release2=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 2, 0);
		   actual[1]=pp.selectRelease(release2);
		   rp.clickOnTestPlanning();
			 bp.waitForElement();
			 ////////create cycle
				String cyclename2=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 55, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 6, 1);
				String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 6, 2);
				String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
				actual[31]=tl.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				actual[32]=tl.CreateCycle(cyclename2, Build, Environment,hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
				String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
				String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
				actual[33]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[34]=tl.saveTestCycle();
				bp.waitForElement();
			 
			  String cyclename22[]=new String[1];
				cyclename22[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 55, 0);
				actual[35]=tl.navigateToCycle(cyclename22);
				bp.waitForElement();
				String freeFormName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 55, 4);
				tl.createFreeFormPhase(freeFormName2);
				String[] freeform2=new String[1];
				freeform2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 55, 4);
				bp.waitForElement();
				tl.navigateToCycle(freeform2);
			    tl.clickOnAddTestcasesToFreeForm();
			    bp.waitForElement();
			    tl.clickOnAdvanceSearch();
			    bp.waitForElement();
				//String value1=ids[0];
			    String release22=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 2, 4);
			    tl.ZQLSearch1(name, operator, release22);
			    bp.waitForElement();
			    tl.validateSearch();
			    bp.waitForElement();
			    tl.selectAllFreeFormTestCases();
			    bp.waitForElement();
			    tl.clickOnSaveAndOk();
			    bp.waitForElement();
			    tl.closeFreeFormPage();
			    bp.waitForElement();
			    tl.validateAddtestcaesToFreeForm();
			    bp.waitForElement();
			    rp.clickOnTestPlanning();
				 bp.waitForElement();
				 //////////////////////////////////////////////////////////////////////////////////////
				   actual[0]=pp.selectProject(projectName);
				   String release3=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "AddReleases", 3, 0));
				   actual[1]=pp.selectRelease(release3);
				   rp.clickOnTestPlanning();
					 bp.waitForElement();
					 ////////create cycle
						String cyclename3=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 55, 0);
						actual[31]=tl.clickOnAddTestCycleSymbol();
						bp.waitForElement();
						actual[32]=tl.CreateCycle(cyclename3, Build, Environment,hide);
						actual[33]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
						bp.waitForElement();
						actual[34]=tl.saveTestCycle();
						bp.waitForElement();
					 
					  String cyclename33[]=new String[1];
						cyclename33[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 55, 0);
						actual[35]=tl.navigateToCycle(cyclename33);
						bp.waitForElement();
						String freeFormName3=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 55, 4);
						tl.createFreeFormPhase(freeFormName3);
						String[] freeform3=new String[1];
						freeform3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 55, 4);
						bp.waitForElement();
						tl.navigateToCycle(freeform3);
					    tl.clickOnAddTestcasesToFreeForm();
					    bp.waitForElement();
					    tl.clickOnAdvanceSearch();
					    bp.waitForElement();
						//String value1=ids[0];
					    String release33=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 3, 4);
					    tl.ZQLSearch1(name, operator, release33);
					    bp.waitForElement();
					    tl.validateSearch();
					    bp.waitForElement();
					    tl.selectAllFreeFormTestCases();
					    bp.waitForElement();
					    tl.clickOnSaveAndOk();
					    bp.waitForElement();
					    tl.closeFreeFormPage();
					    bp.waitForElement();
					    tl.validateAddtestcaesToFreeForm();
					    bp.waitForElement();
					    rp.clickOnTestPlanning();
						 bp.waitForElement();
						 //////////////////////////////////////////////////////////////////////////////////////
						 actual[0]=pp.selectProject(projectName);
						 String release4=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 4, 0);
						   actual[1]=pp.selectRelease(release4);/////////
						   rp.clickOnTestPlanning();
							 bp.waitForElement();
							 ////////create cycle
								String cyclename4=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 55, 0);
								actual[31]=tl.clickOnAddTestCycleSymbol();
								bp.waitForElement();
								actual[32]=tl.CreateCycle(cyclename4, Build, Environment,hide);
								actual[33]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
								bp.waitForElement();
								actual[34]=tl.saveTestCycle();
								bp.waitForElement();
							 
							  String cyclename44[]=new String[1];
								cyclename44[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 55, 0);
								actual[35]=tl.navigateToCycle(cyclename44);
								bp.waitForElement();
								String freeFormName4=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 55, 4);
								tl.createFreeFormPhase(freeFormName4);
								String[] freeform4=new String[1];
								freeform4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 55, 4);
								bp.waitForElement();
								tl.navigateToCycle(freeform4);
							    tl.clickOnAddTestcasesToFreeForm();
							    bp.waitForElement();
							    tl.clickOnAdvanceSearch();
							    bp.waitForElement();
								//String value1=ids[0];
							    String release44=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 4, 4);
							    tl.ZQLSearch1(name, operator, release44);
							    bp.waitForElement();
							    tl.validateSearch();
							    bp.waitForElement();
							    tl.selectAllFreeFormTestCases();
							    bp.waitForElement();
							    tl.clickOnSaveAndOk();
							    bp.waitForElement();
							    tl.closeFreeFormPage();
							    bp.waitForElement();
							    /*tl.validateAddtestcaesToFreeForm();
							    bp.waitForElement();
							    rp.clickOnTestPlanning();
								 bp.waitForElement();*/
								 //////////////////////////////////////////////////////////////////////////////////////
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

	@Then("^Should be able to search Testcases by different Releases and add it to free form phase$")
	public void should_be_able_to_search_Testcases_by_different_Releases_and_add_it_to_free_form_phase() throws Throwable 
	{
		try
		{
			tl=new TestPlanningPage(driver);
			bp=new BasePage();
			tl.validateAddtestcaesToFreeForm();
		    bp.waitForElement();
		    //rp.clickOnTestPlanning();*/
			//bp.waitForElement();
			/*pp=new ProjectPage(driver);
			String release1=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 1, 0);
			String Project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			pp.deleteRelease(Project, release1);
			 
			String release2=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 2, 0);
			pp.deleteRelease(Project, release2);
			
			String release3=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "AddReleases", 3, 0));
			pp.deleteRelease(Project, release3);
			
			//String release8=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 8, 0);
			//pp.deleteRelease(Project, release8);
			
			String release4=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 4, 0);
			pp.deleteRelease(Project, release4);
			
			String release6=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 6, 0);
			pp.deleteRelease(Project, release6);
			
			String release7=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 7, 0);
			pp.deleteRelease(Project, release7);
			
			String release8=Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 8, 0);
			pp.deleteRelease(Project, release8);*/
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
