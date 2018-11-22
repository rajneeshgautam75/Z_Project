package com.zephyr_batch_5.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_20 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	ExecutionPage exep;
	DefectTracking dt;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	String fileName="Defect_Tracking_20";
	
	boolean[] actual=new boolean[36];
	SoftAssert soft=new SoftAssert();
	
	public String defectValue2;
	@Given("^User is in a DefectTracking page$")
	public void user_is_in_a_DefectTracking_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 pp=new ProjectPage(driver);
		 bp=new BasePage();
		 rp=new ReleasePage(driver);
		 pp.selectProject(projectName);
		 pp.selectRelease(releaseName);
		 actual[0]=pp.clickOnDefectTracking();
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

	@When("^User click on create defect and enter the projectName and issuetType$")
	public void user_click_on_create_defect_and_enter_the_projectName_and_issuetType() throws Throwable {
	try
	   {
		   dt=new DefectTracking(driver);
		   String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		   actual[1]=dt.createDefect(project, issuetype);
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

	@When("^enter all the fields and save$")
	public void enter_all_the_fields_and_save() throws Throwable {
	try
	   {
		    String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
			String components=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,19);
			String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,6);
			String fixVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,27);
			String desc=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,17);
			String labels=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String descType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String sprint=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String env=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,22);
			String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,4);
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,27);
			String epicLink=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String linkedIssue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String zeFreeTextField=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,23);
			String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,25);
			String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,26);
			String[] ze_Multiple_Select_Field=new String[2];
			ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,24);
			ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,24);
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,29);
			String[] ze_Multi_Version_field=new String[2];
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,27);
			ze_Multi_Version_field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,27);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,27);
			String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,28);
			String ze_Label_Field=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String[] ze_Multi_User_Picker=new String[2];
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,28);
			ze_Multi_User_Picker[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,28);
			String ze_Text_Field=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
			String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
		    actual[2]=dt.fileNewDefect(summary, components,descType, desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
		    actual[3]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
		    actual[4]=dt.customDatePicker(syear, smonth, sday);
		    actual[5]=dt.saveDefect();
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

	@Then("^Should be able to create a defect$")
	public void should_be_able_to_create_a_defect() throws Throwable {
	try
	  {
		 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		 String defectValue=driver.findElement(By.xpath("(//div/div/div[1]/div[1]/h4)[10]")).getText();
	     System.out.println(defectValue);
		 String[] defectVal=defectValue.split(": ");
		 for(int i=0;i<defectVal.length;i++)
		 {
			 System.out.println(defectVal[i]);
		 }
		 
		 defectValue2=defectVal[1];
		 actual[6]=dt.validateDefect(project, issuetype);
		 actual[7]=dt.updateDefect();
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

	@When("^search a defect and click on edit$")
	public void search_a_defect_and_click_on_edit() throws Throwable {
	try
	   {
		 //String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,30);
		 int[] defectNo=new int[1];
		 defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1,16);
		 dt=new DefectTracking(driver);
		 actual[8]=dt.searchDefect(defectValue2);
		 actual[9]=dt.selectSingleOrMultipleDefects(defectNo);
		 dt.defectEditButton.click();
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

	@When("^remove the non-mandatory Fields$")
	public void remove_the_non_mandatory_Fields() throws Throwable {
	try
	  {
		 exep=new ExecutionPage(driver);
		 Actions a1=new Actions(driver);
	     dt.defectComponent.click();
	     bp.waitForElement();
	     a1.sendKeys(Keys.BACK_SPACE).build().perform();
	     //dt.defectComponent.clear();
	     bp.waitForElement();
	     bp.waitForElement();
	     dt.fixVersionField.click();
	     bp.waitForElement();
	     //dt.fixVersionField.clear();
	     a1.sendKeys(Keys.BACK_SPACE).build().perform();
	     bp.waitForElement();
	     bp.waitForElement();
	     bp.waitForElement();
	     //dt.assignee.clear();
	     dt.clearAssigneeField.click();
	     bp.waitForElement();
	     bp.waitForElement();
	     bp.eraseText(dt.environment);
	     bp.waitForElement();
	     bp.waitForElement();
	     dt.labelField.click();
	     bp.waitForElement();
	     dt.labelField.clear();
	     bp.waitForElement();
	     bp.waitForElement();
	     Actions a2=new Actions(driver);
	     dt.affectsVersion.click();
	     bp.waitForElement();
	     a1.sendKeys(Keys.BACK_SPACE).build().perform();
	     bp.waitForElement();
	     bp.waitForElement();

	     WebDriverWait wait=new WebDriverWait(driver,60);
		  wait.until(ExpectedConditions.elementToBeClickable(dt.customZE_FreeText_Field));
		  bp.eraseText(dt.customZE_FreeText_Field);
		  bp.waitForElement();
		
		 bp.waitForElement();
		 String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,25);
		 if(zeCheckboxField!="")
		  {
			  WebElement ele=driver.findElement(By.xpath(dt.customZE_Checkbox_Field1+zeCheckboxField+dt.customZE_Checkbox_Field2));
			  wait.until(ExpectedConditions.elementToBeClickable(ele));
			  bp.waitForElement();
			  ele.click();
			}
			 bp.waitForElement();
			 
			  wait.until(ExpectedConditions.elementToBeClickable(dt.customZE_Url_Field));
			  dt.customZE_Url_Field.click();
			  bp.waitForElement();
			  dt.customZE_Url_Field.clear();
			  bp.waitForElement();
			  
				  //dt.customZE_Multiple_Select_Field.click();
				  bp.waitForElement();
				  
			 bp.waitForElement();
			 //ze_Single_Select_Field
				  wait.until(ExpectedConditions.elementToBeClickable(dt.clearCustomZE_Single_Select_Field));
				  bp.waitForElement();
				  dt.clearCustomZE_Single_Select_Field.click();
				  
			     bp.waitForElement();
//			 if(ze_Multi_Version_field[0]!="")
//			  {
//				  wait.until(ExpectedConditions.elementToBeClickable(customZE_Mult_Version_field));
//				  customZE_Mult_Version_field.click();
//				  bp.waitForElement();
//				  for(int i=0;i<=ze_Multi_Version_field.length-1;i++)
//				  {
//				    a1.pause(1800).sendKeys(ze_Multi_Version_field[i]).pause(3000).build().perform();
//				    a1.sendKeys(Keys.ENTER).build().perform();
//				    
//				  }
//				 
//				  //a1.sendKeys(Keys.ENTER).build().perform();
//				}
			 bp.waitForElement();
			 //ze_Version_Field
				  wait.until(ExpectedConditions.elementToBeClickable(dt.clearCustomZE_Version_Field));
				  dt.clearCustomZE_Version_Field.click();
				  bp.waitForElement();
				  
			 bp.waitForElement();
			 //ze_User_Picker
				  wait.until(ExpectedConditions.elementToBeClickable(dt.clearCustomZE_User_Picker_Field));
				  dt.clearCustomZE_User_Picker_Field.click();
				  bp.waitForElement();
				  
			 bp.waitForElement();
			 //ze_Label_Field
				  wait.until(ExpectedConditions.elementToBeClickable(dt.customZE_Label_Field));
				  dt.customZE_Label_Field.click();
				  bp.waitForElement();
				  dt.customZE_Label_Field.clear();
			     bp.waitForElement();
			     bp.waitForElement();
			 //ze_Multi_User_Picker
				  wait.until(ExpectedConditions.elementToBeClickable(dt.clearCustomZE_Multi_User_PickerField));
				  dt.clearCustomZE_Multi_User_PickerField.click();
				  bp.waitForElement();
			      bp.waitForElement();
			 //ze_Text_Field
				  wait.until(ExpectedConditions.elementToBeClickable(dt.customZE_Text_Field));
				  bp.eraseText(dt.customZE_Text_Field);
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

	@Then("^Should be able to remove the non-mandatory fields$")
	public void should_be_able_to_remove_the_non_mandatory_fields() throws Throwable {
	try
	  {
		 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		 actual[10]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[11]=dt.updateEditDefectWindow();
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

	@When("^User launch test repository to create a phase with testcases$")
	public void user_launch_test_repository_to_create_a_phase_with_testcases() throws Throwable {
	try
	   {
	     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");;
	     bp.waitForElement();
	     actual[12]=rp.clickOnTestRep();
	     tr=new TestRepositoryPage(driver);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",14,12);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		
		actual[13]=tr.clickOnRelease(releaseName);
		bp.waitForElement();
		actual[14]=tr.addNode(p_Name1,p_Desc1);  
		tr.doubleClickOnRelease(releaseName);
		String[] phase=new String[1];
		phase[0]=p_Name1;
		bp.waitForElement();
		actual[15]=tr.navigateToNode(releaseName, phase);
		tr.addTestCase();
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

	@When("^Launch test planning to create a cycle and add phase to the cycle$")
	public void launch_test_planning_to_create_a_cycle_and_add_phase_to_the_cycle() throws Throwable {
		try
		   {
			  bp.waitForElement();
			  actual[16]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",14,13);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[17]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				actual[18]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[19]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				bp.waitForElement();
				actual[20]=tp.saveTestCycle();
				bp.waitForElement();
				
		    	String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",14,13);
				actual[21]=tp.navigateToCycle(cycle1);
				
				bp.waitForElement();
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",14,12);
				actual[22]=tp.addPhaseToCycle(Phase);
				bp.waitForElement();
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
				bp.waitForElement();
				actual[23]=tp.bulkAssignment(Bulk_Type);
				actual[24]=tp.goBackToCycle();
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

	@When("^launch test execution to execute testcase$")
	public void launch_test_execution_to_execute_testcase() throws Throwable {
	try
	   {
		     /*pp=new ProjectPage(driver);//
			 bp=new BasePage();
			 rp=new ReleasePage(driver);
			 dt=new DefectTracking(driver);
			 tr=new TestRepositoryPage(driver);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			 pp.selectProject(projectName);
		     pp.selectRelease(releaseName);// */
		   
		   bp.waitForElement();
		   actual[25]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		   String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",14,13);
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",14,12);
		    
		    bp.waitForElement();
			actual[26]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[27]=exep.executeStatus(tcNo1[0], statusType1);
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

	@When("^click on D button and click on create defect button and enter projectName and issueType$")
	public void click_on_D_button_and_click_on_create_defect_button_and_enter_projectName_and_issueType() throws Throwable {
	try
	   {
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		   String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		   actual[28]=exep.clickOnDefectButton(testcase);
		   actual[29]=dt.createDefect(project,issuetype);
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


	@When("^Enter all the Fields and save$")
	public void enter_all_the_Fields_and_save() throws Throwable {
	try
	   {
		String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
		String components=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,19);
		String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,6);
		String fixVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,27);
		String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		String labels=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		String descType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		String sprint=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		String env=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,22);
		String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,28);
		String affectsVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,27);
		String epicLink=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		String linkedIssue=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		String zeFreeTextField=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		String zeRadioField=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,23);
		String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,25);
		String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,26);
		String[] ze_Multiple_Select_Field=new String[2];
		ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,24);
		ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,24);
		String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,29);
		String[] ze_Multi_Version_field=new String[2];
		ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,27);
		ze_Multi_Version_field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,27);
		String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,27);
		String ze_User_Picker=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,28);
		String ze_Label_Field=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		String[] ze_Multi_User_Picker=new String[2];
		ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,28);
		ze_Multi_User_Picker[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,28);
		String ze_Text_Field=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
		String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
	    actual[30]=dt.fileNewDefect(summary, components, descType,desc, fixVersion, priority, assignee, labels, sprint, env, epicLink, affectsVersion, linkedIssue);
	    actual[31]=dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_User_Picker, ze_Label_Field, ze_Multi_User_Picker, ze_Text_Field);
	    actual[32]=dt.customDatePicker(syear, smonth, sday);
	    actual[33]=dt.saveDefect();
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

	
	@When("^Remove The non-mandatory fields$")
	public void remove_The_non_mandatory_fields() throws Throwable {
	try
	  {
		exep=new ExecutionPage(driver);
		 Actions a1=new Actions(driver);
	     dt.defectComponent.click();
	     bp.waitForElement();
	     a1.sendKeys(Keys.BACK_SPACE).build().perform();
	     //dt.defectComponent.clear();
	     bp.waitForElement();
	     bp.waitForElement();
	     dt.fixVersionField.click();
	     bp.waitForElement();
	     //dt.fixVersionField.clear();
	     a1.sendKeys(Keys.BACK_SPACE).build().perform();
	     bp.waitForElement();
	     bp.waitForElement();
	     bp.waitForElement();
	     //dt.assignee.clear();
	     dt.clearAssigneeField.click();
	     bp.waitForElement();
	     bp.waitForElement();
	     bp.eraseText(dt.environment);
	     bp.waitForElement();
	     bp.waitForElement();
	     dt.labelField.click();
	     bp.waitForElement();
	     dt.labelField.clear();
	     bp.waitForElement();
	     bp.waitForElement();
	     Actions a2=new Actions(driver);
	     dt.affectsVersion.click();
	     bp.waitForElement();
	     a1.sendKeys(Keys.BACK_SPACE).build().perform();
	     bp.waitForElement();
	     bp.waitForElement();

	     WebDriverWait wait=new WebDriverWait(driver,60);
		  wait.until(ExpectedConditions.elementToBeClickable(dt.customZE_FreeText_Field));
		  bp.eraseText(dt.customZE_FreeText_Field);
		  bp.waitForElement();
		
		 bp.waitForElement();
		 String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,25);
		 if(zeCheckboxField!="")
		  {
			  WebElement ele=driver.findElement(By.xpath(dt.customZE_Checkbox_Field1+zeCheckboxField+dt.customZE_Checkbox_Field2));
			  wait.until(ExpectedConditions.elementToBeClickable(ele));
			  ele.click();
			  bp.waitForElement();
			}
			 bp.waitForElement();
			 
			  wait.until(ExpectedConditions.elementToBeClickable(dt.customZE_Url_Field));
			  dt.customZE_Url_Field.click();
			  bp.waitForElement();
			  dt.customZE_Url_Field.clear();
			  bp.waitForElement();
			  
				  //dt.customZE_Multiple_Select_Field.click();
				  bp.waitForElement();
				  
			 bp.waitForElement();
			 //ze_Single_Select_Field
				  wait.until(ExpectedConditions.elementToBeClickable(dt.clearCustomZE_Single_Select_Field));
				  bp.waitForElement();
				  dt.clearCustomZE_Single_Select_Field.click();
				  
			     bp.waitForElement();
//			 if(ze_Multi_Version_field[0]!="")
//			  {
//				  wait.until(ExpectedConditions.elementToBeClickable(customZE_Mult_Version_field));
//				  customZE_Mult_Version_field.click();
//				  bp.waitForElement();
//				  for(int i=0;i<=ze_Multi_Version_field.length-1;i++)
//				  {
//				    a1.pause(1800).sendKeys(ze_Multi_Version_field[i]).pause(3000).build().perform();
//				    a1.sendKeys(Keys.ENTER).build().perform();
//				    
//				  }
//				 
//				  //a1.sendKeys(Keys.ENTER).build().perform();
//				}
			 bp.waitForElement();
			 //ze_Version_Field
				  wait.until(ExpectedConditions.elementToBeClickable(dt.clearCustomZE_Version_Field));
				  dt.clearCustomZE_Version_Field.click();
				  bp.waitForElement();
				  
			 bp.waitForElement();
			 //ze_User_Picker
				  wait.until(ExpectedConditions.elementToBeClickable(dt.clearCustomZE_User_Picker_Field));
				  dt.clearCustomZE_User_Picker_Field.click();
				  bp.waitForElement();
				  
			 bp.waitForElement();
			 //ze_Label_Field
				  wait.until(ExpectedConditions.elementToBeClickable(dt.customZE_Label_Field));
				  dt.customZE_Label_Field.click();
				  bp.waitForElement();
				  dt.customZE_Label_Field.clear();
			     bp.waitForElement();
			     bp.waitForElement();
			 //ze_Multi_User_Picker
				  wait.until(ExpectedConditions.elementToBeClickable(dt.clearCustomZE_Multi_User_PickerField));
				  dt.clearCustomZE_Multi_User_PickerField.click();
				  bp.waitForElement();
			      bp.waitForElement();
			 //ze_Text_Field
				  wait.until(ExpectedConditions.elementToBeClickable(dt.customZE_Text_Field));
				  bp.eraseText(dt.customZE_Text_Field);
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

	@Then("^should be able to remove the non-mandatory Fields$")
	public void should_be_able_to_remove_the_non_mandatory_Fields() throws Throwable {
	try
	  {
		 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[34]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[35]=dt.updateDefect();
		 bp.waitForElement();
		 bp.waitForElement();
		/// exep.cancelDefect.click();
		 exep.clickOnCancelDefectWindow();
		 bp.waitForElement();
		 tp.doubleClickOnCycle(releaseName);
		 bp.waitForElement();
		 
		 for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
				//soft.assertEquals(actual[k], true);
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
