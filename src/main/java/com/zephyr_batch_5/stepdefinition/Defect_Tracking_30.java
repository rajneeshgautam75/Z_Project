package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_30 extends LaunchBrowser{
	
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	ExportPage ex;
	LaunchBrowser lb;
	LoginPage lp;
	DefectTracking dt;
	TestRepositoryPage tr;
	boolean[] actual=new boolean[81];
	SoftAssert soft=new SoftAssert();
	String fileName="DefectTracking_30";

	@Given("^User is in defectTracking page$")
	public void user_is_in_defectTracking_page() throws Throwable {
		try
	       {
		   bp=new BasePage();
		   rp=new ReleasePage(driver);
		   pp=new ProjectPage(driver);
		   dt=new DefectTracking(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   bp.waitForElement();
		   actual[2]=pp.clickOnDefectTracking();
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


	@When("^User click on basic and serach by jiraId and select single defect and export defect into excel format$")
	public void user_click_on_basic_and_serach_by_jiraId_and_select_single_defect_and_export_defect_into_excel_format() throws Throwable {
		try
	       {	
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 16);
		   String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 31);
		   int[] defectNo=new int[1];
		   defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
		   actual[3]=dt.searchDefect(defectID);
		   bp.waitForElement();
		   actual[4]=dt.selectSingleOrMultipleDefects(defectNo);
		   bp.waitForElement();
		   dt.defectsOperation(defectValue);
		   bp.waitForElement();
		   actual[5]=dt.downloadExportFile();
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

	@Then("^Should be able to export the single defect into Excel format$")
	public void should_be_able_to_export_the_single_defect_into_Excel_format() throws Throwable {
		try
	    {
	    System.out.println("Export file is downloaded successfully");
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

	

	@When("^User serach by jiraId and select multiple defect and export defects into excel format$")
	public void user_serach_by_jiraId_and_select_multiple_defect_and_export_defects_into_excel_format() throws Throwable {
		try
	       {
		   String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 31);
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 16);
		   actual[6]=rp.clickOnTestRep();
		   bp.waitForElement();
		   actual[7]=rp.clickOnDefectTracking();
		   bp.waitForElement();
		   actual[8]=dt.searchDefect(defectID);
		   bp.waitForElement();
		   actual[9]=dt.selectAllDefects();
		   bp.waitForElement();
		   dt.defectsOperation(defectValue);
		   bp.waitForElement();
		   actual[10]=dt.downloadExportFile();
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


	@Then("^Should be able to export the multiple defects into Excel format$")
	public void should_be_able_to_export_the_multiple_defects_into_Excel_format() throws Throwable {
		try
	    {
	    System.out.println("Export file is downloaded successfully");
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

	@When("^User select project and issuetype and select single defect and export into excel format$")
	public void user_select_project_and_issuetype_and_select_single_defect_and_export_into_excel_format() throws Throwable {
		  try
	        {  
		    String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
	        String issueType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
	        String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 6);
		    int[] defectNo=new int[1];
		    defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
		    String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 31);
		    actual[11]=rp.clickOnTestRep();
			bp.waitForElement();
			actual[12]=rp.clickOnDefectTracking();  
			bp.waitForElement();
		    actual[13]=dt.defectSearch(project, issueType,field, field,field, field, field);
		    bp.waitForElement();
		    actual[14]=dt.selectSingleOrMultipleDefects(defectNo);
		    bp.waitForElement();
		    dt.defectsOperation(defectValue);
		    bp.waitForElement();
		    actual[15]=dt.downloadExportFile();
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

	@Then("^Should be able to export the single defect into excel format$")
	public void should_be_able_to_export_the_single_defect_into_excel_format() throws Throwable {
		try
	    {
	    System.out.println("Export file is downloaded successfully");
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

	@When("^User select project and issuetype and select multiple defects and export into excel format$")
	public void user_select_project_and_issuetype_and_select_multiple_defects_and_export_into_excel_format() throws Throwable {
		 try
	        {
		    String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
	        String issueType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
	        String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 6);
		    String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 31);
            actual[16]=rp.clickOnTestRep();
		    bp.waitForElement();
		    actual[17]=rp.clickOnDefectTracking(); 
		    bp.waitForElement();
		    actual[18]=dt.defectSearch(project, issueType,field,field,field, field,field);
		    bp.waitForElement();
		    actual[19]=dt.selectAllDefects();
		    bp.waitForElement();
		    dt.defectsOperation(defectValue);
		    bp.waitForElement();
		    actual[20]=dt.downloadExportFile();
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

	@Then("^Should be able to export the multiple defects into excel format$")
	public void should_be_able_to_export_the_multiple_defects_into_excel_format() throws Throwable {
		try
	    {
	    System.out.println("Export file is downloaded successfully");
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

	@When("^User select project and issuetype and status and serch single defect and export into excel format$")
	public void user_select_project_and_issuetype_and_status_and_serch_single_defect_and_export_into_excel_format() throws Throwable {
		 try
	        {
		    String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
	        String issueType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
	        String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 6);
			String status_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 38);
		    int[] defectNo=new int[1];
		    defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
		    String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 31);
		    actual[21]=rp.clickOnTestRep();
			bp.waitForElement();
			actual[22]=rp.clickOnDefectTracking();
			bp.waitForElement();
		    actual[23]=dt.defectSearch(project, issueType,status_1, field, field, field,field);
		    bp.waitForElement();
		    actual[24]=dt.selectSingleOrMultipleDefects(defectNo);
		    bp.waitForElement();
		    dt.defectsOperation(defectValue);
		    bp.waitForElement();
		    actual[25]=dt.downloadExportFile();
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

	@Then("^Should be able to export the single Defect into excel format$")
	public void should_be_able_to_export_the_single_Defect_into_excel_format() throws Throwable {
		try
	    {
	    System.out.println("Export file is downloaded successfully");
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

	@When("^User select project and issuetype and status and select multiple defects and export into excel format$")
	public void user_select_project_and_issuetype_and_status_and_select_multiple_defects_and_export_into_excel_format() throws Throwable {
		 try
	        {
		    String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
	        String issueType=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
	        String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 6);
			String status_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 38);
	        String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 31);
			actual[26]=rp.clickOnTestRep();
			bp.waitForElement();
			actual[27]=rp.clickOnDefectTracking(); 
			bp.waitForElement();
		    actual[28]=dt.defectSearch(project, issueType,status_1,field,field,field,field);
		    bp.waitForElement();
		    actual[29]=dt.selectAllDefects();
	        bp.waitForElement();
	        dt.defectsOperation(defectValue);
		    bp.waitForElement();
		    actual[30]=dt.downloadExportFile();
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

	@Then("^Should be able to export the multiple Defects into excel format$")
	public void should_be_able_to_export_the_multiple_Defects_into_excel_format() throws Throwable {
		try
	    {
	    System.out.println("Export file is downloaded successfully");
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

	@When("^User select assignee and select single defect and export into excel format$")
	public void user_select_assignee_and_select_single_defect_and_export_into_excel_format() throws Throwable {
		try
        {
	    String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 0);
		String assignee=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 8);
	    int[] defectNo=new int[1];
	    defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
	    String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 31);
	    actual[31]=rp.clickOnTestRep();
		bp.waitForElement();
		actual[32]=rp.clickOnDefectTracking();	
		bp.waitForElement();
	    actual[33]=dt.defectSearch(field, field,field,field, field,field, assignee);
	    bp.waitForElement();
	    actual[34]=dt.selectSingleOrMultipleDefects(defectNo);
	    bp.waitForElement();
	    dt.defectsOperation(defectValue);
	    bp.waitForElement();
	    actual[35]=dt.downloadExportFile();
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

	@Then("^Should be able to export single defecct into excel format$")
	public void should_be_able_to_export_single_defecct_into_excel_format() throws Throwable {
		try
	    {
	    System.out.println("Export file is downloaded successfully");
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

	@When("^User select assignee and select multiple defects and export into excel format$")
	public void user_select_assignee_and_select_multiple_defects_and_export_into_excel_format() throws Throwable {
		 try
	        { 
		    String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 0);
			String assignee=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 8);
		    String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 31);
			actual[36]=rp.clickOnTestRep();
			bp.waitForElement();
			actual[37]=rp.clickOnDefectTracking();
		    bp.waitForElement();
			actual[38]=dt.defectSearch(field,field,field,field,field,field,assignee);
		    bp.waitForElement();
		    actual[39]=dt.selectAllDefects();
		    bp.waitForElement();
		    dt.defectsOperation(defectValue);
		    bp.waitForElement();
		    actual[40]=dt.downloadExportFile();
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


	@Then("^Should be able to export multiple defects into Excel format$")
	public void should_be_able_to_export_multiple_defects_into_Excel_format() throws Throwable {
		try
	    {
	    System.out.println("Export file is downloaded successfully");
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

	@When("^User select Filedby and select single defect and export into excel format$")
	public void user_select_Filedby_and_select_single_defect_and_export_into_excel_format() throws Throwable {
		try
        {
	    String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 0);
	    String filedBy=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 37);
	    int[] defectNo=new int[1];
	    defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
	    String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 31);
	    actual[41]=rp.clickOnTestRep();
		bp.waitForElement();
	    actual[42]=rp.clickOnDefectTracking();	
	    bp.waitForElement();
	    actual[43]=dt.defectSearch(field,field,field, filedBy,field,field,field);
	    bp.waitForElement();
	    actual[44]=dt.selectSingleOrMultipleDefects(defectNo);
	    bp.waitForElement();
	    dt.defectsOperation(defectValue);
	    bp.waitForElement();
	    actual[45]=dt.downloadExportFile();
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

	@Then("^Should be able to export single defect into excel format in filedby$")
	public void should_be_able_to_export_single_defect_into_excel_format_in_filedby() throws Throwable {
		try
	    {
	    System.out.println("Export file is downloaded successfully");
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

	@When("^User select Filedby and select multiple defects and export into excel format$")
	public void user_select_Filedby_and_select_multiple_defects_and_export_into_excel_format() throws Throwable {
		 try
	        {
		    String field=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 0);
		    String filedBy=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 37);
		    String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 31);
		    actual[46]=rp.clickOnTestRep();
			bp.waitForElement();
			actual[47]=rp.clickOnDefectTracking(); 
		    bp.waitForElement();
			actual[48]=dt.defectSearch(field,field, field, filedBy,field,field,field);
		    bp.waitForElement();
		    actual[49]=dt.selectAllDefects();
		    bp.waitForElement();
		    dt.defectsOperation(defectValue);
		    bp.waitForElement();
		    actual[50]=dt.downloadExportFile();
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
	

	@Then("^Should be able to export multiple defect into excel format in filedby$")
	public void should_be_able_to_export_multiple_defect_into_excel_format_in_filedby() throws Throwable {
		try
	    {
	    System.out.println("Export file is downloaded successfully");
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

	@When("^User click on Advance and select single defect and export into excel format$")
	public void user_click_on_Advance_and_select_single_defect_and_export_into_excel_format() throws Throwable {
		try
	       {
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 16);
		   int[] defectNo=new int[1];
		   defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
		   String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 31);
		   actual[51]=rp.clickOnTestRep();
		   bp.waitForElement();
		   actual[52]=rp.clickOnDefectTracking();	
		   bp.waitForElement();
		   dt.Advance.click();
		   bp.waitForElement();
		   actual[53]=dt.searchDefect(defectID);
		   bp.waitForElement();
		   actual[54]=dt.selectSingleOrMultipleDefects(defectNo);
		   bp.waitForElement();
		   dt.defectsOperation(defectValue);
		   bp.waitForElement();
		   actual[55]=dt.downloadExportFile();
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


	@Then("^Should be able to export single defect and export into excel format in advance search$")
	public void should_be_able_to_export_single_defect_and_export_into_excel_format_in_advance_search() throws Throwable {
		try
	    {
	    System.out.println("Export file is downloaded successfully");
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

	@When("^User select multiple defects and export into excel format$")
	public void user_select_multiple_defects_and_export_into_excel_format() throws Throwable {
		try
	       {
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 16);
		   String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 31);
		   actual[56]=rp.clickOnTestRep();
		   bp.waitForElement();
		   actual[57]=rp.clickOnDefectTracking();	
		   bp.waitForElement();
		   dt.Advance.click();
		   bp.waitForElement();
		   actual[58]=dt.searchDefect(defectID);
		   bp.waitForElement();
		   actual[59]=dt.selectAllDefects();
		   bp.waitForElement();
		   dt.defectsOperation(defectValue);
		   bp.waitForElement();
		   actual[60]=dt.downloadExportFile();
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


	@Then("^Should be able to export multiple defects and export into excel format in advance search$")
	public void should_be_able_to_export_multiple_defects_and_export_into_excel_format_in_advance_search() throws Throwable {
		try
	    {
	    System.out.println("Export file is downloaded successfully");
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

	@When("^User select JQL and select single defect and export into excel format$")
	public void user_select_JQL_and_select_single_defect_and_export_into_excel_format() throws Throwable {
		try
        {
	    String selectSearch=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 33);
		String name=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 34);  	
		int[] defectNo=new int[1];
		defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
	    String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 31);
		actual[61]=rp.clickOnTestRep();
	    bp.waitForElement();
	    actual[62]=rp.clickOnDefectTracking();	
	    bp.waitForElement();
		actual[63]=dt.advancedSearch(selectSearch, name);
	    bp.waitForElement();
	    actual[64]=dt.selectSingleOrMultipleDefects(defectNo);
	    bp.waitForElement();
	    dt.defectsOperation(defectValue);
	    bp.waitForElement();
	    actual[65]=dt.downloadExportFile();
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

	@Then("^Should be able to export single defect into excel format while selecting JQL$")
	public void should_be_able_to_export_single_defect_into_excel_format_while_selecting_JQL() throws Throwable {
		try
	    {
	    System.out.println("Export file is downloaded successfully");
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

	@When("^User select JQL and select multiple defects and export into excel format$")
	public void user_select_JQL_and_select_multiple_defects_and_export_into_excel_format() throws Throwable {
		try
        {
	    String selectSearch=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 33);
		String name=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 34);  	
	    String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 31);
		actual[66]=rp.clickOnTestRep();
	    bp.waitForElement();
	    actual[67]=rp.clickOnDefectTracking();	
	    bp.waitForElement();
		actual[68]=dt.advancedSearch(selectSearch, name);
	    bp.waitForElement();
	    actual[69]=dt.selectAllDefects();
	    bp.waitForElement();
	    dt.defectsOperation(defectValue);
	    bp.waitForElement();
	    actual[70]=dt.downloadExportFile();
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

	@Then("^Should be able to export multiple defects into excel format while selecting JQL$")
	public void should_be_able_to_export_multiple_defects_into_excel_format_while_selecting_JQL() throws Throwable {
		try
	    {
	    System.out.println("Export file is downloaded successfully");
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

	@When("^User select Filters and select single defect and export into excel format$")
	public void user_select_Filters_and_select_single_defect_and_export_into_excel_format() throws Throwable {
		try
        {
	    String selectSearch_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1,39);
		String name=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 34);  	
		int[] defectNo=new int[1];
		defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
	    String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 31);
		actual[71]=rp.clickOnTestRep();
	    bp.waitForElement();
	    actual[72]=rp.clickOnDefectTracking();	
	    bp.waitForElement();
		actual[73]=dt.advancedSearch(selectSearch_1, name);
	    bp.waitForElement();
	    actual[74]=dt.selectSingleOrMultipleDefects(defectNo);
	    bp.waitForElement();
	    dt.defectsOperation(defectValue);
	    bp.waitForElement();
	    actual[75]=dt.downloadExportFile();
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

	

	@Then("^Should be able to export single defect into excel format while selecting filters$")
	public void should_be_able_to_export_single_defect_into_excel_format_while_selecting_filters() throws Throwable {
		try
	    {
	    System.out.println("Export file is downloaded successfully");
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

	@When("^User select Filters and select multiple defect and export into excel format$")
	public void user_select_Filters_and_select_multiple_defect_and_export_into_excel_format() throws Throwable {
		try
        {
	    String selectSearch_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1,39 );
		String name=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 34);  	
	    String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 31);
		actual[76]=rp.clickOnTestRep();
	    bp.waitForElement();
	    actual[77]=rp.clickOnDefectTracking();	
	    bp.waitForElement();
		actual[78]=dt.advancedSearch(selectSearch_1, name);
	    bp.waitForElement();
	    actual[79]=dt.selectAllDefects();
	    bp.waitForElement();
	    dt.defectsOperation(defectValue);
	    bp.waitForElement();
	    actual[80]=dt.downloadExportFile();
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

	@Then("^Should be able to export multiple defect into excel format while selecting filters$")
	public void should_be_able_to_export_multiple_defect_into_excel_format_while_selecting_filters() throws Throwable {
		try
	    {
	    System.out.println("Export file is downloaded successfully");
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
