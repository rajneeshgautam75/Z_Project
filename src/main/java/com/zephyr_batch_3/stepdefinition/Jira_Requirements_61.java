package com.zephyr_batch_3.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Jira_Requirements_61 extends LaunchBrowser {
	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ExportPage ep;
	LaunchBrowser lb=new LaunchBrowser();
	String screen="Jira_Requirements_61";
	
	
	 boolean[] actual=new boolean[10];
	 SoftAssert soft=new SoftAssert();
	 
	@Given("^user launch the requirement app$")
	public void user_launch_the_requirement_app() throws Throwable {
		try
		{
		
		   bp=new BasePage();
		   pp=new ProjectPage(driver);
		   rp= new ReleasePage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Normal_Project_1");
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   bp.waitForElement(); 
		   actual[2]=rp.clickOnRequirements();
		   bp.waitForElement();
		}
		catch(Exception e)
		 {
		  e.printStackTrace();
		  lb.getScreenShot(screen);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }
	   
	}

	@When("^user clicks on import button$")
	public void user_clicks_on_import_button() throws Throwable {
		try
	    {
			req=new RequirementsPage(driver);
			bp.waitForElement();
			req.clickOnImport();
			bp.waitForElement();
			String importType=Excel_Lib.getData(INPUT_PATH_7, "Import",1 , 5 );
			actual[3]=req.chooseImportType(importType);
			bp.waitForElement();
	    }
	    catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(screen);
	    	driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	   
	}

	@When("^select a jira option$")
	public void select_a_jira_option() throws Throwable {
		try
		{
		String selectQuerry=Excel_Lib.getData(INPUT_PATH_7, "Import",1,8);
		String enterQuerry=Excel_Lib.getData(INPUT_PATH_7, "Import",2 ,6);
		actual[4]=req.selectQuerry(selectQuerry, enterQuerry);
        String accessType=Excel_Lib.getData(INPUT_PATH_7, "Import",7 ,7);
        bp.waitForElement();
	    String folderName=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Releases",1 ,6);
	    actual[5]=req.selectAccessTypeAndFolderName(accessType, folderName);
        req.clickjiraSearchButton.click();
        for(int i=1;i<=3;i++){
		bp.waitForElement();}
		}
	    catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(screen);
	    	driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
		
	    
	}

	@When("^user import all requirements$")
	public void user_import_all_requirements() throws Throwable {
		try
		{
		actual[6]=req.importAllJiraRequirements();
		bp.waitForElement();
		bp.waitForElement();
		
		tr=new TestRepositoryPage(driver);
		String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		WebElement ele1=driver.findElement(By.xpath(tr.releasename1+releaseName+tr.releasename2));
	    WebDriverWait wait=new WebDriverWait(driver,200);
	    wait.until(ExpectedConditions.elementToBeClickable(ele1));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(screen);
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}  
	   
	}

	@Then("^user checks the sub folder under the imported node$")
	public void user_checks_the_sub_folder_under_the_imported_node() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);
			String importedName=Excel_Lib.getData(INPUT_PATH_7,"Releases",1,2);
			actual[7]=tr.doubleClickOnRelease(importedName);
			String a[]=new String[1];	
			a[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"Releases",1,6);
			actual[8]=tr.navigateToNode(importedName, a);
			String[] node=new String[3];
			node[0]=Excel_Lib.getData(INPUT_PATH_7,"Import",1,11);
			node[1]=Excel_Lib.getData(INPUT_PATH_7,"Import",2,11);
			node[2]=Excel_Lib.getData(INPUT_PATH_7,"Import",3,11);
			//node[3]=Excel_Lib.getData(INPUT_PATH_7,"Import",4,11);
			//node[4]=Excel_Lib.getData(INPUT_PATH_7,"Import",5,11);
			actual[9]=tr.navigateNode(node);	
			
			bp.waitForElement();
			//actual[10]=pp.clickOnLogout();
			for(int i=0;i<=actual.length-1;i++)
			{
				System.out.println(actual[i]);
				soft.assertEquals(actual[i],true);
			}
	       soft.assertAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(screen);
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 
		}  
		
    
	}


}
