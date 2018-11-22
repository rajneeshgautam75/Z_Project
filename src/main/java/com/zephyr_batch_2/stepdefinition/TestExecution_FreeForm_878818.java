package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_FreeForm_878818 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	ExportPage ep;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	RequirementsPage req;
	
	boolean[] actual=new boolean[152];
	SoftAssert soft=new SoftAssert();
	
	 String fileName="TestExecution_FreeForm_878818";
	 
	@Given("^User is in a paGe TestRepositorY$")
	public void user_is_in_a_paGe_TestRepositorY() throws Throwable {
		try
		   {
			lb=new LaunchBrowser();
			bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	 bp.waitForElement();
	    	 
	    	 pp=new ProjectPage(driver);
	         pp.clickOnLogout();
	    lp=new LoginPage(driver);
	     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
	     lp.enterUname(Uname);
	     lp.enterPass(Pass);
	     lp.clickOnLogin();
	    	 actual[0]=pp.selectProject(projectName);
	    	 actual[1]=pp.selectRelease(releaseName);
	    	 
	    	 rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[2]=rp.clickOnTestRep(); 
		   
		   }
		   catch(Exception e)
			{

               lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}  
	}

	@When("^User creates a phase and creates a two systems and ten subsystems and create testcase with teststeps to all nodes$")
	public void user_creates_a_phase_and_creates_a_two_systems_and_ten_subsystems_and_create_testcase_with_teststeps_to_all_nodes() throws Throwable {
		try
	    {
					tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 1);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 4);
				
				bp=new BasePage();
				actual[3]=tr.doubleClickOnRelease(releaseName);
				 bp.waitForElement();
				actual[4]=tr.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
				tr.doubleClickOnRelease(releaseName);
				String[] phase=new String[1];
				phase[0]=p_Name1;
				 bp.waitForElement();
				actual[5]=tr.navigateToNode(releaseName, phase);
				tr.addTestCase();
				
				actual[6]=tr.clickDetailButton();
				String[] stepDetail1=new String[3];
				stepDetail1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
				stepDetail1[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				stepDetail1[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[7]=ctc.enterTestCaseStepDetail(stepDetail1);
				bp.waitForElement();
				actual[8]=tr.clickOnList();
				bp.waitForElement();
				
				String[] nav1=new String[1];
				nav1[0]=p_Name1;
				
				actual[9]=tr.navigateToNode(releaseName, nav1);
				//tr.clickOnRelease(releaseName);
				String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 2);
				String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 5);
				bp.waitForElement();
				
				
				//actual[9]=tr.selectPhase(p_Name1);
				//bp.waitForElement();
				actual[10]=tr.addNode(s_Name1, s_Desc1);
				bp.waitForElement();
				String[] nav2=new String[2];
				nav2[0]=p_Name1;
				nav2[1]=s_Name1;
				
				actual[11]=tr.navigateToNode(releaseName, nav2);
				
				//actual[11]=tr.selectPhase(s_Name1);
				tr.addTestCase();
				bp.waitForElement();
				actual[12]=tr.clickDetailButton();
				String[] stepDetail2=new String[3];
				stepDetail2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
				stepDetail2[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				stepDetail2[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[13]=ctc.enterTestCaseStepDetail(stepDetail2);
				bp.waitForElement();
				actual[14]=tr.clickOnList();
				bp.waitForElement();
				
				bp.waitForElement();
				// tr.clickOnRelease(releaseName);
		    	 String s_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 2, 2);
		    	  String s_Desc2=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 5);
		    	  actual[15]=tr.navigateToNode(releaseName, nav2);
		    	  bp.waitForElement();
		    	  actual[16]=tr.addNode(s_Name2, s_Desc2);
		    	  bp.waitForElement();
		    	  String[] nav3=new String[3];
					nav3[0]=p_Name1;
					nav3[1]=s_Name1;
					nav3[2]=s_Name2;
					actual[17]=tr.navigateToNode(releaseName, nav3);
					
		    	  
		    	  
		    	 // actual[17]=tr.selectPhase(s_Name2);
		    	  tr.addTestCase();
					bp.waitForElement();
					actual[18]=tr.clickDetailButton();
					String[] stepDetail3=new String[3];
					stepDetail3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
					stepDetail3[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
					stepDetail3[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
					ctc=new CreateTestCasePage(driver);
					bp.waitForElement();
					actual[19]=ctc.enterTestCaseStepDetail(stepDetail3);
					bp.waitForElement();
					actual[20]=tr.clickOnList();
		    	  
		    	  bp.waitForElement();
					 //tr.clickOnRelease(releaseName);
			    	 String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 3);
			    	  String ss_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 6);
			    	  
			    	  
			    	  actual[21]=tr.navigateToNode(releaseName, nav2);
			    	  //actual[21]=tr.selectPhase(s_Name1);
			    	  bp.waitForElement();
			    	  actual[22]=tr.addNode(ss_Name1, ss_Desc1);
			    	  bp.waitForElement();
			    	  
			    	  String[] subsys1=new String[3];
			    	  subsys1[0]=p_Name1;
			    	  subsys1[1]=s_Name1;
			    	  subsys1[2]=ss_Name1;
						actual[23]=tr.navigateToNode(releaseName, subsys1);
						
			    	  
			    	  //actual[23]=tr.selectPhase(ss_Name1);
			    	  tr.addTestCase();
						bp.waitForElement();
						actual[24]=tr.clickDetailButton();
						String[] stepDetail4=new String[3];
						stepDetail4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
						stepDetail4[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
						stepDetail4[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
						ctc=new CreateTestCasePage(driver);
						bp.waitForElement();
						actual[25]=ctc.enterTestCaseStepDetail(stepDetail4);
						bp.waitForElement();
						actual[26]=tr.clickOnList();
						
						bp.waitForElement();
						 //tr.clickOnRelease(releaseName);
				    	 String ss_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 2, 3);
				    	  String ss_Desc2=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 6);
				    	  
				    	  actual[27]=tr.navigateToNode(releaseName, subsys1);
				    	  
				    	  //actual[27]=tr.selectPhase(ss_Name1);
				    	  bp.waitForElement();
				    	  actual[28]=tr.addNode(ss_Name2, ss_Desc2);
				    	  bp.waitForElement();
				    	  String[] subsys2=new String[4];
				    	  subsys2[0]=p_Name1;
				    	  subsys2[1]=s_Name1;
				    	  subsys2[2]=ss_Name1;
				    	  subsys2[3]=ss_Name2;
				    	  actual[29]= tr.navigateToNode(releaseName, subsys2);
				    	  //actual[29]=tr.selectPhase(ss_Name2);
				    	  tr.addTestCase();
							bp.waitForElement();
							actual[30]=tr.clickDetailButton();
							String[] stepDetail5=new String[3];
							stepDetail5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
							stepDetail5[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
							stepDetail5[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
							ctc=new CreateTestCasePage(driver);
							bp.waitForElement();
							actual[31]=ctc.enterTestCaseStepDetail(stepDetail5);
							bp.waitForElement();
							actual[32]=tr.clickOnList();
							
							bp.waitForElement();
							 //tr.clickOnRelease(releaseName);
					    	 String ss_Name3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 3, 3);
					    	  String ss_Desc3=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 6);
					    	  
					    	  actual[33]= tr.navigateToNode(releaseName, subsys2);
					    	  //actual[33]=tr.selectPhase(ss_Name2);
					    	  bp.waitForElement();
					    	  actual[34]=tr.addNode(ss_Name3, ss_Desc3);
					    	  bp.waitForElement();
					    	  
					    	  String[] subsys3=new String[5];
					    	  subsys3[0]=p_Name1;
					    	  subsys3[1]=s_Name1;
					    	  subsys3[2]=ss_Name1;
					    	  subsys3[3]=ss_Name2;
					    	  subsys3[4]=ss_Name3;
					    	  
					    	  actual[35]=tr.navigateToNode(releaseName, subsys3);
					    	  
					    	  //actual[35]=tr.selectPhase(ss_Name3);
					    	  tr.addTestCase();
								bp.waitForElement();
								actual[36]=tr.clickDetailButton();
								String[] stepDetail6=new String[3];
								stepDetail6[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
								stepDetail6[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
								stepDetail6[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
								ctc=new CreateTestCasePage(driver);
								bp.waitForElement();
								actual[37]=ctc.enterTestCaseStepDetail(stepDetail6);
								bp.waitForElement();
								actual[38]=tr.clickOnList();
								
								bp.waitForElement();
								 //tr.clickOnRelease(releaseName);
						    	 String ss_Name4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 4, 3);
						    	  String ss_Desc4=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 6);
						    	  actual[39]=tr.navigateToNode(releaseName, subsys3);
						    	  bp.waitForElement();
						    	  actual[40]=tr.addNode(ss_Name4, ss_Desc4);
						    	  bp.waitForElement();
						    	  
						    	  String[] subsys4=new String[6];
						    	  subsys4[0]=p_Name1;
						    	  subsys4[1]=s_Name1;
						    	  subsys4[2]=ss_Name1;
						    	  subsys4[3]=ss_Name2;
						    	  subsys4[4]=ss_Name3;
						    	  subsys4[5]=ss_Name4;
						    	  actual[41]=tr.navigateToNode(releaseName, subsys4);
						    	  

						    	  
						    	  //actual[41]=tr.selectPhase(ss_Name4);
						    	  tr.addTestCase();
									bp.waitForElement();
									actual[42]=tr.clickDetailButton();
									String[] stepDetail7=new String[3];
									stepDetail7[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
									stepDetail7[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
									stepDetail7[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
									ctc=new CreateTestCasePage(driver);
									bp.waitForElement();
									actual[43]=ctc.enterTestCaseStepDetail(stepDetail7);
									bp.waitForElement();
									actual[44]=tr.clickOnList();
									
									bp.waitForElement();
									 //tr.clickOnRelease(releaseName);
							    	 String ss_Name5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 5, 3);
							    	  String ss_Desc5=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 6);
							    	  actual[45]=tr.navigateToNode(releaseName, subsys4);
							    	  bp.waitForElement();
							    	  actual[46]=tr.addNode(ss_Name5, ss_Desc5);
							    	  bp.waitForElement();
							    	  
							    	  String[] subsys5=new String[7];
							    	  subsys5[0]=p_Name1;
							    	  subsys5[1]=s_Name1;
							    	  subsys5[2]=ss_Name1;
							    	  subsys5[3]=ss_Name2;
							    	  subsys5[4]=ss_Name3;
							    	  subsys5[5]=ss_Name4;
							    	  subsys5[6]=ss_Name5;
							    	  
							    	  actual[47]=tr.navigateToNode(releaseName, subsys5);
							    	  
							    	  
							    	  
							    	  
							    	  //actual[47]=tr.selectPhase(ss_Name5);
							    	  tr.addTestCase();
										bp.waitForElement();
										actual[48]=tr.clickDetailButton();
										String[] stepDetail8=new String[3];
										stepDetail8[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
										stepDetail8[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
										stepDetail8[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
										ctc=new CreateTestCasePage(driver);
										bp.waitForElement();
										actual[49]=ctc.enterTestCaseStepDetail(stepDetail8);
										bp.waitForElement();
										actual[50]=tr.clickOnList();
										
										bp.waitForElement();
										// tr.clickOnRelease(releaseName);
								    	 String ss_Name6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 6, 3);
								    	  String ss_Desc6=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 6);
								    	  actual[51]=tr.navigateToNode(releaseName, subsys5);
								    	  bp.waitForElement();
								    	  actual[52]=tr.addNode(ss_Name6, ss_Desc6);
								    	  bp.waitForElement();
								    	  
								    	  String[] subsys6=new String[8];
								    	  subsys6[0]=p_Name1;
								    	  subsys6[1]=s_Name1;
								    	  subsys6[2]=ss_Name1;
								    	  subsys6[3]=ss_Name2;
								    	  subsys6[4]=ss_Name3;
								    	  subsys6[5]=ss_Name4;
								    	  subsys6[6]=ss_Name5;
								    	  subsys6[7]=ss_Name6;
								    	  
								    	  actual[53]=tr.navigateToNode(releaseName, subsys6);
								    	  
								    	  
								    	  //actual[53]=tr.selectPhase(ss_Name6);
								    	  tr.addTestCase();
											bp.waitForElement();
											actual[54]=tr.clickDetailButton();
											String[] stepDetail9=new String[3];
											stepDetail9[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
											stepDetail9[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
											stepDetail9[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
											ctc=new CreateTestCasePage(driver);
											bp.waitForElement();
											actual[55]=ctc.enterTestCaseStepDetail(stepDetail9);
											bp.waitForElement();
											actual[56]=tr.clickOnList();
											
											bp.waitForElement();
											 //tr.clickOnRelease(releaseName);
									    	 String ss_Name7=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 7, 3);
									    	  String ss_Desc7=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 6);
									    	  actual[57]=tr.navigateToNode(releaseName, subsys6);
									    	  bp.waitForElement();
									    	  actual[58]=tr.addNode(ss_Name7, ss_Desc7);
									    	  bp.waitForElement();

									    	  String[] subsys7=new String[9];
									    	  subsys7[0]=p_Name1;
									    	  subsys7[1]=s_Name1;
									    	  subsys7[2]=ss_Name1;
									    	  subsys7[3]=ss_Name2;
									    	  subsys7[4]=ss_Name3;
									    	  subsys7[5]=ss_Name4;
									    	  subsys7[6]=ss_Name5;
									    	  subsys7[7]=ss_Name6;
									    	  subsys7[8]=ss_Name7;
									    	  
									    	  actual[59]=tr.navigateToNode(releaseName, subsys7);
									    	  
									    	  //actual[59]=tr.selectPhase(ss_Name7);
									    	  tr.addTestCase();
												bp.waitForElement();
												actual[60]=tr.clickDetailButton();
												String[] stepDetail10=new String[3];
												stepDetail10[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
												stepDetail10[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
												stepDetail10[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
												ctc=new CreateTestCasePage(driver);
												bp.waitForElement();
												actual[61]=ctc.enterTestCaseStepDetail(stepDetail10);
												bp.waitForElement();
												actual[62]=tr.clickOnList();
												
												bp.waitForElement();
												// tr.clickOnRelease(releaseName);
										    	 String ss_Name8=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 8, 3);
										    	  String ss_Desc8=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 6);
										    	  actual[63]=tr.navigateToNode(releaseName, subsys7);
										    	  bp.waitForElement();
										    	  actual[64]=tr.addNode(ss_Name8, ss_Desc8);
										    	  bp.waitForElement();
										    	  
										    	  String[] subsys8=new String[10];
										    	  subsys8[0]=p_Name1;
										    	  subsys8[1]=s_Name1;
										    	  subsys8[2]=ss_Name1;
										    	  subsys8[3]=ss_Name2;
										    	  subsys8[4]=ss_Name3;
										    	  subsys8[5]=ss_Name4;
										    	  subsys8[6]=ss_Name5;
										    	  subsys8[7]=ss_Name6;
										    	  subsys8[8]=ss_Name7;
										    	  subsys8[9]=ss_Name8;
										    	  
										    	  actual[65]=tr.navigateToNode(releaseName, subsys8);
										    	  
										    	  //actual[65]=tr.selectPhase(ss_Name8);
										    	  tr.addTestCase();
													bp.waitForElement();
													actual[66]=tr.clickDetailButton();
													String[] stepDetail11=new String[3];
													stepDetail11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
													stepDetail11[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
													stepDetail11[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
													ctc=new CreateTestCasePage(driver);
													bp.waitForElement();
													actual[67]=ctc.enterTestCaseStepDetail(stepDetail11);
													bp.waitForElement();
													actual[68]=tr.clickOnList();
													
													bp.waitForElement();
													// tr.clickOnRelease(releaseName);
											    	 String ss_Name9=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 9, 3);
											    	  String ss_Desc9=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 6);
											    	  actual[69]=tr.navigateToNode(releaseName, subsys8);
											    	  bp.waitForElement();
											    	  actual[70]=tr.addNode(ss_Name9, ss_Desc9);
											    	  bp.waitForElement();
											    	  
											    	  
											    	  String[] subsys9=new String[11];
											    	  subsys9[0]=p_Name1;
											    	  subsys9[1]=s_Name1;
											    	  subsys9[2]=ss_Name1;
											    	  subsys9[3]=ss_Name2;
											    	  subsys9[4]=ss_Name3;
											    	  subsys9[5]=ss_Name4;
											    	  subsys9[6]=ss_Name5;
											    	  subsys9[7]=ss_Name6;
											    	  subsys9[8]=ss_Name7;
											    	  subsys9[9]=ss_Name8;
											    	  subsys9[10]=ss_Name9;
											    	  
											    	  actual[71]=tr.navigateToNode(releaseName, subsys9);
											    	  
											    	  //actual[71]=tr.selectPhase(ss_Name9);
											    	  tr.addTestCase();
														bp.waitForElement();
														actual[72]=tr.clickDetailButton();
														String[] stepDetail12=new String[3];
														stepDetail12[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
														stepDetail12[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
														stepDetail12[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
														ctc=new CreateTestCasePage(driver);
														bp.waitForElement();
														actual[73]=ctc.enterTestCaseStepDetail(stepDetail12);
														bp.waitForElement();
														actual[74]=tr.clickOnList();
														
														bp.waitForElement();
														// tr.clickOnRelease(releaseName);
												    	 String ss_Name10=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 10, 3);
												    	  String ss_Desc10=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 6);
												    	  actual[75]=tr.navigateToNode(releaseName, subsys9);
												    	  bp.waitForElement();
												    	  actual[76]=tr.addNode(ss_Name10, ss_Desc10);
												    	  bp.waitForElement();
												    	  
												    	  String[] subsys10=new String[12];
												    	  subsys10[0]=p_Name1;
												    	  subsys10[1]=s_Name1;
												    	  subsys10[2]=ss_Name1;
												    	  subsys10[3]=ss_Name2;
												    	  subsys10[4]=ss_Name3;
												    	  subsys10[5]=ss_Name4;
												    	  subsys10[6]=ss_Name5;
												    	  subsys10[7]=ss_Name6;
												    	  subsys10[8]=ss_Name7;
												    	  subsys10[9]=ss_Name8;
												    	  subsys10[10]=ss_Name9;
												    	  subsys10[11]=ss_Name10;
												    	  
												    	  actual[77]=tr.navigateToNode(releaseName, subsys10);
												    	  
												    	 // actual[77]=tr.selectPhase(ss_Name10);
												    	  tr.addTestCase();
															bp.waitForElement();
															actual[78]=tr.clickDetailButton();
															String[] stepDetail13=new String[3];
															stepDetail13[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
															stepDetail13[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
															stepDetail13[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
															ctc=new CreateTestCasePage(driver);
															bp.waitForElement();
															actual[79]=ctc.enterTestCaseStepDetail(stepDetail13);
															bp.waitForElement();
															actual[80]=tr.clickOnList();
															bp.waitForElement();
														
				
	    }
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}

	@When("^User Launch TestPlanning and creates a cYcle$")
	public void user_Launch_TestPlanning_and_creates_a_cYcle() throws Throwable {
		try
		   {
            /*bp=new BasePage();
            tr=new TestRepositoryPage(driver);
            tp=new TestPlanningPage(driver);
            exep=new ExecutionPage(driver);
            rp=new ReleasePage(driver);
            pp=new ProjectPage(driver);
            pp.clickOnLogout();
			
			lp=new LoginPage(driver);
			
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_3");
			   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_3");
			   
			   lp.enterUname(Uname);
			   lp.enterPass(Pass);
			   lp.clickOnLogin();
			   
			   pp=new ProjectPage(driver);
			   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		    	 bp.waitForElement();
		    	 pp.selectProject(projectName);
		    	 pp.selectRelease(releaseName);*/   
			
			bp.waitForElement();
			  actual[81]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[82]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[83]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[84]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[85]=tp.saveTestCycle();
		   }
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}

	@When("^User creates a freeform phase to cycle and create two systems to phase and creates three subsystems to system node$")
	public void user_creates_a_freeform_phase_to_cycle_and_create_two_systems_to_phase_and_creates_three_subsystems_to_system_node() throws Throwable {
		try
	    {
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 0);
			actual[86]=tp.navigateToCycle(cycle);
			
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 1);
			actual[87]=tp.createFreeFormPhase(phaseName);
			bp.waitForElement();
			
			String[] cycle1=new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 1);
			actual[88]=tp.navigateToCycle(cycle1);
			
			String systemName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 2);
			String systemDesc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 5);
			actual[89]=tp.addNode(systemName1, systemDesc1);
			
			String[] cycle11=new String[1];
			cycle11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 1);
			bp.waitForElement();
			actual[90]=tp.navigateToCycle(cycle11);
			String systemName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 2);
			String systemDesc2=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 5);
			bp.waitForElement();
			actual[91]=tp.addNode(systemName2, systemDesc2);
			bp.waitForElement();
			
			String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 1);
			bp.waitForElement();
			actual[92]=tp.doubleClickOnCycle(cycleName);
			
			String[] cycle2=new String[2];
			cycle2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 1);
			cycle2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 2);
			bp.waitForElement();
			actual[93]=tp.navigateToCycle(cycle2);
			bp.waitForElement();
			
			String SubsystemName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 3);
			String SubsystemDesc1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 6);
			//tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			actual[94]=tp.addNode(SubsystemName1, SubsystemDesc1);
			
			String[] cycle22=new String[1];
			cycle22[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 2);
			bp.waitForElement();
			actual[95]=tp.navigateToCycle(cycle22);
			String SubsystemName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 3);
			String SubsystemDesc2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 6);
			//tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			actual[96]=tp.addNode(SubsystemName2, SubsystemDesc2);
			
			String[] cycle33=new String[1];
			cycle33[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 2);
			bp.waitForElement();
			actual[97]=tp.navigateToCycle(cycle33);
			String SubsystemName3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 28, 3);
			String SubsystemDesc3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 6);
			//tr=new TestRepositoryPage(driver);
			actual[98]=tp.addNode(SubsystemName3, SubsystemDesc3);
			bp.waitForElement();
			
			
			String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 1);
			bp.waitForElement();
			actual[99]=tp.doubleClickOnCycle(cycleName1);
			
			String[] cycle3=new String[2];
			cycle3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 1);
			cycle3[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 2);
			actual[100]=tp.navigateToCycle(cycle3);
			
			String SubsystemName4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 3);
			String SubsystemDesc4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 6);
			//tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			actual[101]=tp.addNode(SubsystemName4, SubsystemDesc4);
			
			String[] cycle44=new String[1];
			cycle44[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 2);
			bp.waitForElement();
			actual[102]=tp.navigateToCycle(cycle44);
			String SubsystemName5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 3);
			String SubsystemDesc5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 6);
			//tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			actual[103]=tp.addNode(SubsystemName5, SubsystemDesc5);
			
			String[] cycle55=new String[1];
			cycle55[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 2);
			bp.waitForElement();
			actual[104]=tp.navigateToCycle(cycle55);
			String SubsystemName6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 28, 3);
			String SubsystemDesc6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 6);
			//tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			actual[105]=tp.addNode(SubsystemName6, SubsystemDesc6);
	    }
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}

	@When("^User add testcases to freeform phase by using browse option and assign it to tester$")
	public void user_add_testcases_to_freeform_phase_by_using_browse_option_and_assign_it_to_tester() throws Throwable {
		try
	    {
	    	String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818",1 ,1 );
		     bp.waitForElement();
		     actual[106]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     bp.waitForElement();
		     actual[107]=tp.clickOnAddTestcasesToFreeForm();
		     
		     bp.waitForElement();
		    	actual[108]=tp.clickOnBrowse();
		    	
		    	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
		    	
		    	tp.doubleClickOnCycle(releaseName);
		    	//tr.doubleClickOnRelease(releaseName);
		    	
		    	String[] nodes=new String[12];
		    	nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 1);
		    	nodes[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 2);
		    	nodes[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 3);
		    	nodes[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 2, 3);
		    	nodes[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 3, 3);
		    	nodes[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 4, 3);
		    	nodes[6]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 5, 3);
		    	nodes[7]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 6, 3);
		    	nodes[8]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 7, 3);
		    	nodes[9]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 8, 3);
		    	nodes[10]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 9, 3);
		    	nodes[11]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 10, 3);
	
		    	tr=new TestRepositoryPage(driver);
		    	bp.waitForElement();
		    	actual[109]=tr.navigateNode(nodes);
		    	
		    	bp.waitForElement();
		    	actual[110]=tp.selectAllFreeFormTestCases();
		    	
		    	bp.waitForElement();
		    	actual[111]=tp.clickOnSaveAndOk();
				   bp.waitForElement();
				   
				   actual[112]=tp.closeFreeFormPage();
				   bp.waitForElement();
				   
				   bp.waitForElement();
				   actual[113]=tp.selectallTestCase();
				     
				     bp.waitForElement();
				     String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
				     actual[114]=tp.assignAllSelected(assignee);
				     bp.waitForElement();
				     
				     tp.goBackToCycle();
	    }
	    catch(Exception e)
		{
	    	lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}

	@When("^User Launches TestPlanning and creates a Cycle$")
	public void user_Launches_TestPlanning_and_creates_a_Cycle() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[115]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 2, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[116]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[117]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[118]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[119]=tp.saveTestCycle();
		   }
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}    
	}

	@When("^User creates a freeform phase and creates two systems to phase and creates three subsystems to system node$")
	public void user_creates_a_freeform_phase_and_creates_two_systems_to_phase_and_creates_three_subsystems_to_system_node() throws Throwable {
		try
	    {
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 2, 0);
			actual[120]=tp.navigateToCycle(cycle);
			
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 2, 1);
			actual[121]=tp.createFreeFormPhase(phaseName);
			bp.waitForElement();
			
			String[] cycle1=new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 2, 1);
			actual[122]=tp.navigateToCycle(cycle1);
			
			String systemName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 2);
			String systemDesc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 5);
			actual[123]=tp.addNode(systemName1, systemDesc1);
			
			String[] cycle11=new String[1];
			cycle11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 2, 1);
			bp.waitForElement();
			actual[124]=tp.navigateToCycle(cycle11);
			String systemName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 2);
			String systemDesc2=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 5);
			bp.waitForElement();
			actual[125]=tp.addNode(systemName2, systemDesc2);
			bp.waitForElement();
			
			String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 2, 1);
			bp.waitForElement();
			actual[126]=tp.doubleClickOnCycle(cycleName);
			
			String[] cycle2=new String[2];
			cycle2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 2, 1);
			cycle2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 2);
			bp.waitForElement();
			actual[127]=tp.navigateToCycle(cycle2);
			bp.waitForElement();
			
			String SubsystemName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 3);
			String SubsystemDesc1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 6);
			//tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			actual[128]=tp.addNode(SubsystemName1, SubsystemDesc1);
			
			String[] cycle22=new String[1];
			cycle22[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 2);
			bp.waitForElement();
			actual[129]=tp.navigateToCycle(cycle22);
			String SubsystemName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 3);
			String SubsystemDesc2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 6);
			//tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			actual[130]=tp.addNode(SubsystemName2, SubsystemDesc2);
			
			String[] cycle33=new String[1];
			cycle33[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 2);
			bp.waitForElement();
			actual[131]=tp.navigateToCycle(cycle33);
			String SubsystemName3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 28, 3);
			String SubsystemDesc3=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 6);
			//tr=new TestRepositoryPage(driver);
			actual[132]=tp.addNode(SubsystemName3, SubsystemDesc3);
			bp.waitForElement();
			
			
			String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 2, 1);
			bp.waitForElement();
			actual[133]=tp.doubleClickOnCycle(cycleName1);
			
			String[] cycle3=new String[2];
			cycle3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 2, 1);
			cycle3[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 2);
			actual[134]=tp.navigateToCycle(cycle3);
			
			String SubsystemName4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 3);
			String SubsystemDesc4=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 6);
			//tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			actual[135]=tp.addNode(SubsystemName4, SubsystemDesc4);
			
			String[] cycle44=new String[1];
			cycle44[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 2);
			bp.waitForElement();
			actual[135]=tp.navigateToCycle(cycle44);
			String SubsystemName5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 3);
			String SubsystemDesc5=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 6);
			//tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			actual[136]=tp.addNode(SubsystemName5, SubsystemDesc5);
			
			String[] cycle55=new String[1];
			cycle55[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 27, 2);
			bp.waitForElement();
			actual[137]=tp.navigateToCycle(cycle55);
			String SubsystemName6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 28, 3);
			String SubsystemDesc6=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 26, 6);
			//tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			actual[138]=tp.addNode(SubsystemName6, SubsystemDesc6);
	    }
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}   
	}

	@When("^User add testcases to freeform phase by using browse option and assign it to the tester$")
	public void user_add_testcases_to_freeform_phase_by_using_browse_option_and_assign_it_to_the_tester() throws Throwable {
		try
	    {
	    	String[] cycleName=new String[1];
		     cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818",2 ,1 );
		     bp.waitForElement();
		     actual[139]=tp.navigateToCycle(cycleName);
		     
		     bp.waitForElement();
		     actual[140]=tp.clickOnAddTestcasesToFreeForm();
		     
		     bp.waitForElement();
		    	actual[141]=tp.clickOnBrowse();
		    	
		    	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
		    	tp.doubleClickOnCycle(releaseName);
		    	
		    	String[] nodes=new String[12];
		    	nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 1);
		    	nodes[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 2);
		    	nodes[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 1, 3);
		    	nodes[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 2, 3);
		    	nodes[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 3, 3);
		    	nodes[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 4, 3);
		    	nodes[6]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 5, 3);
		    	nodes[7]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 6, 3);
		    	nodes[8]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 7, 3);
		    	nodes[9]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 8, 3);
		    	nodes[10]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 9, 3);
		    	nodes[11]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818", 10, 3);
		    	
		    	
		    	tr=new TestRepositoryPage(driver);
		    	bp.waitForElement();
		    	//actual[142]=tp.navigateToCycle(nodes);
		    	actual[142]=tr.navigateNode(nodes);
		    	
		    	bp.waitForElement();
		    	actual[143]=tp.selectAllFreeFormTestCases();
		    	
		    	bp.waitForElement();
		    	actual[144]=tp.clickOnSaveAndOk();
				   bp.waitForElement();
				   
				   actual[145]=tp.closeFreeFormPage();
				   bp.waitForElement();
				   
				   bp.waitForElement();
				   actual[146]=tp.selectallTestCase();
				     
				     bp.waitForElement();
				     String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
				     actual[147]=tp.assignAllSelected(assignee);
				     bp.waitForElement();
				     pp.clickOnLogout();
				     bp.waitForElement();
	    }
	    catch(Exception e)
		{
	    	lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}

	@Then("^User Launches TestExecution and views the all added assigned testcases to tester$")
	public void user_Launches_TestExecution_and_views_the_all_added_assigned_testcases_to_tester() throws Throwable {
		try
		   {
			/*bp=new BasePage();//
            tr=new TestRepositoryPage(driver);
            tp=new TestPlanningPage(driver);
            exep=new ExecutionPage(driver);
            rp=new ReleasePage(driver);
            pp=new ProjectPage(driver);
            pp.clickOnLogout();//*/
			
			lp=new LoginPage(driver);
			
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Username_1");
			   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Password_1");
			   
			   lp.enterUname(Uname);
			   lp.enterPass(Pass);
			   lp.clickOnLogin();
			   
			   pp=new ProjectPage(driver);
			   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		    	 bp.waitForElement();
		    	 pp.selectProject(projectName);
		    	 pp.selectRelease(releaseName);   
			
			bp.waitForElement();
				rp= new ReleasePage(driver);
				bp.waitForElement();
				   actual[148]=rp.clickOnTestExecution(); 
				   
				   String[] cycleName1=new String[3];
				    cycleName1[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
				    cycleName1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818",1 ,0 );
				    cycleName1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818",1 ,1 );
				    
				    bp.waitForElement();
				    tp=new TestPlanningPage(driver);
				    bp.waitForElement();
				    bp.waitForElement();
				    bp.waitForElement();
					actual[149]=tp.navigateToCycle(cycleName1);
					bp.waitForElement();
					tr=new TestRepositoryPage(driver);
					tr.verifyPresentTestCase();
					bp.waitForElement();
					tp.doubleClickOnCycle(cycleName1[0]);
					/*driver.navigate().refresh();
					bp.waitForElement();
					bp.waitForElement();*/
					
					String[] cycleName2=new String[3];
				    cycleName2[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
				    cycleName2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818",2 ,0 );
				    cycleName2[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_878818",2 ,1 );
				    
				    bp.waitForElement();
				    tp=new TestPlanningPage(driver);
				    bp.waitForElement();
				    bp.waitForElement();
				    bp.waitForElement();
					actual[150]=tp.navigateToCycle(cycleName2);
					
					bp.waitForElement();
					actual[151]=tr.verifyPresentTestCase();
					bp.waitForElement();
					
					tp.doubleClickOnCycle(cycleName2[0]);
					bp.waitForElement();
					
//					pp=new ProjectPage(driver);
//					pp.closeBrowser();
					for(int k=0;k<=actual.length-1;k++)
				     {
						System.out.println(actual[k]);
				      soft.assertEquals(actual[k], true);
				     }
				     soft.assertAll();
		   }
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
				
	}
}
