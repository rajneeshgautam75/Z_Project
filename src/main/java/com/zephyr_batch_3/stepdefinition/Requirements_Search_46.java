package com.zephyr_batch_3.stepdefinition;

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

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Requirements_Search_46 extends LaunchBrowser{
   ProjectPage pp;
   ReleasePage rp;
   BasePage bp;
	LaunchBrowser lb;
	LoginPage lp;
	TestRepositoryPage tr;
	RequirementsPage req;
	NavigationPage np;
	ExportPage ep;
	String fileName="Requirements_Search_46";
	
	boolean[] actual=new boolean[41];
	SoftAssert soft=new SoftAssert();

@Given("^user is in requirement page$")
public void user_is_in_requirement_page() throws Throwable {
    try{
		 pp=new ProjectPage(driver);
         rp=new ReleasePage(driver);
				String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Normal_Project_1");
				  String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
				  actual[0]=pp.selectProject(projectName);
				  actual[1]=pp.selectRelease(releaseName);
				  bp=new BasePage();
				  bp.waitForElement();
				  actual[2]=rp.clickOnRequirements();
				  bp.waitForElement();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				lb=new LaunchBrowser();
				lb.getScreenShot(fileName);
				driver.close();
				Relogin_TPE re=new Relogin_TPE();
				re.reLogin();
				throw e;
			}
   
}

@When("^user create phase and add requirement with name in capital letters$")
public void user_create_phase_and_add_requirement_with_name_in_capital_letters() throws Throwable {
	try
	{
		tr=new TestRepositoryPage(driver);
		req=new RequirementsPage(driver);
		String nodeName=Excel_Lib.getData(INPUT_PATH_9, "Requirement", 2, 0);
		actual[3]=tr.clickOnRelease(nodeName);
		String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_9, "Requirement", 1, 1);
		String desc=Excel_Lib.getData(INPUT_PATH_9, "Requirement", 2, 1);
		actual[4]=req.addNode(phaseName, desc);

        String[] ph=new String[1];
        ph[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_9, "Requirement", 1, 1);
		actual[5]=tr.navigateToNode(nodeName,ph);
		actual[6]=req.addRequirement();
		tr.clickOnDetails();
		String name=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 1, 5);
	    String altID=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 1, 1);
	    String link=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 1, 2);
	    String priority=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 1, 3);
	    String Description=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 1, 4);
	    actual[7]=req.enterRequirementDetails(name, altID, link, priority, Description);
		bp.waitForElement();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE re=new Relogin_TPE();
		re.reLogin();
		throw e;
	}
}

@When("^Uncheck In this release checkbox in search of requirement page$")
public void uncheck_In_this_release_checkbox_in_search_of_requirement_page() throws Throwable {
	try
	{
		actual[8]=tr.clickOnSearch();
		ep= new ExportPage(driver);
		bp.waitForElement();
		actual[9]=ep.UnselectInTheseRelease();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE re=new Relogin_TPE();
		re.reLogin();
		throw e;
	}
}

@And("^Search by requirement name in capital letters$")
public void search_by_requirement_name_in_capital_letters() throws Throwable {
	try
	{
		String searchOption=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 1, 5);
		np=new NavigationPage(driver);
		actual[10]=np.quiksearch(searchOption);
			
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE re=new Relogin_TPE();
		re.reLogin();
		throw e;
	}
}

@Then("^view the search results$")
public void view_the_search_results() throws Throwable {
	try
	{
		actual[11]=req.VerifyRequirementCount();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE re=new Relogin_TPE();
		re.reLogin();
		throw e;
	}
}

@When("^user create requirements with name in Alphanumeric and spaces$")
public void user_create_requirements_with_name_in_Alphanumeric_and_spaces() throws Throwable {
	try
	{   
		tr.clickedOnFolder();
	    bp.waitForElement();
		actual[12]=req.addRequirement();
		bp.waitForElement();
		String name=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 2, 5);
	    String altID=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 2, 1);
	    String link=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 2, 2);
	    String priority=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 2, 3);
	    String Description=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 1, 4);
	    actual[13]=req.enterRequirementDetails(name, altID, link, priority, Description);
        bp.waitForElement();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE re=new Relogin_TPE();
		re.reLogin();
		throw e;
	}
}

@And("^search by requirement name Alphanumeric and spaces$")
public void search_by_requirement_name_Alphanumeric_and_spaces() throws Throwable {
	try
	{
		actual[14]=tr.clickOnSearch();
		String searchOption=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 2, 5);
		actual[15]=np.quiksearch(searchOption);
		bp.waitForElement();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE re=new Relogin_TPE();
		re.reLogin();
		throw e;
	}
}

@Then("^check the detail of searched requirement of alphanumeric and spaces$")
public void check_the_detail_of_searched_requirement_of_alphanumeric_and_spaces() throws Throwable {
	try
	{
		actual[16]=req.VerifyRequirementCount();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE re=new Relogin_TPE();
		re.reLogin();
		throw e;
	}
}

@When("^Create requirement name in only Numbers$")
public void create_requirement_name_in_only_Numbers() throws Throwable {
	try
	{
		tr.clickedOnFolder();
	    bp.waitForElement();
		actual[17]=req.addRequirement();
		bp.waitForElement();
		String name=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_9, "Req-Detail", 3, 5));
	    String altID=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 3, 1);
	    String link=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 3, 2);
	    String priority=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 3, 3);
	    String Description=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 1, 4);
	    actual[18]=req.enterRequirementDetails(name, altID, link, priority, Description);
	    bp.waitForElement();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE re=new Relogin_TPE();
		re.reLogin();
		throw e;
	}
}

@And("^Search by requirement name in numbers$")
public void search_by_requirement_name_in_numbers() throws Throwable {
	try
	{
		actual[19]=tr.clickOnSearch();
		String searchOption=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_9, "Req-Detail", 3, 5));
		actual[20]=np.quiksearch(searchOption);
		bp.waitForElement();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE re=new Relogin_TPE();
		re.reLogin();
		throw e;
	}
}

@Then("^check the detail of searched requirement of numbers$")
public void check_the_detail_of_searched_requirement_of_numbers() throws Throwable {
	try
	{
		actual[21]=req.VerifyRequirementCount();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE re=new Relogin_TPE();
		re.reLogin();
		throw e;
	}
}

@When("^Create requirement name with special characters$")
public void create_requirement_name_with_special_characters() throws Throwable {
	try
	{
		tr.clickedOnFolder();
	    bp.waitForElement();
		actual[22]=req.addRequirement();
		bp.waitForElement();
		String name=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 4, 5);
	    String altID=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 4, 1);
	    String link=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 2, 2);
	    String priority=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 4, 3);
	    String Description=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 1, 4);
	    actual[23]=req.enterRequirementDetails(name, altID, link, priority, Description);
	    bp.waitForElement();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE re=new Relogin_TPE();
		re.reLogin();
		throw e;
	}  
}

@And("^Search by requirement name in special characters$")
public void search_by_requirement_name_in_special_characters() throws Throwable {
	try
	{
		actual[24]=tr.clickOnSearch();
		String searchOption=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 4, 5);
		actual[25]=np.quiksearch(searchOption);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE re=new Relogin_TPE();
		re.reLogin();
		throw e;
	}
}

@Then("^check the detail of searched requirement of special characters$")
public void check_the_detail_of_searched_requirement_of_special_characters() throws Throwable {
	try
	{
		
		
		int c=req.requirementCount();
		if(c==0)
		{
			log.info("no search result found");
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE re=new Relogin_TPE();
		re.reLogin();
		throw e;
	}
}

@When("^Create requirements with Long name$")
public void create_requirements_with_Long_name() throws Throwable {
	try
	{
		tr.clickedOnFolder();
	    bp.waitForElement();
		actual[26]=req.addRequirement();
		bp.waitForElement();
		String name=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 5, 5);
	    String altID=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 5, 1);
	    String link=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 3, 2);
	    String priority=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 1, 3);
	    String Description=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 1, 4);
	    actual[27]=req.enterRequirementDetails(name, altID, link, priority, Description);
	    bp.waitForElement();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE re=new Relogin_TPE();
		re.reLogin();
		throw e;
	}
}

@And("^Search by requirement using long name$")
public void search_by_requirement_using_long_name() throws Throwable {
	try
	{
		actual[28]=tr.clickOnSearch();
		String searchOption=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 5, 5);
		actual[29]=np.quiksearch(searchOption);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE re=new Relogin_TPE();
		re.reLogin();
		throw e;
	}
}

@Then("^check the detail of searched requirement of long name$")
public void check_the_detail_of_searched_requirement_of_long_name() throws Throwable {
	try
	{
		actual[30]=req.VerifyRequirementCount();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE re=new Relogin_TPE();
		re.reLogin();
		throw e;
	}
}

@When("^Create requirements with minimum chars in name$")
public void create_requirements_with_minimum_chars_in_name() throws Throwable {
	try
	{
		tr.clickedOnFolder();
	    bp.waitForElement();
		req.addRequirement();
		bp.waitForElement();
		String name=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 6, 5);
	    String altID=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 2, 1);
	    String link=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 3, 2);
	    String priority=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 4, 3);
	    String Description=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 1, 4);
	    actual[31]=req.enterRequirementDetails(name, altID, link, priority, Description);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE re=new Relogin_TPE();
		re.reLogin();
		throw e;
	}
}

@And("^Search by minmum chars$")
public void search_by_minmum_chars() throws Throwable {
	try
	{
		actual[32]=tr.clickOnSearch();
		String searchOption=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 6, 5);
		actual[33]=np.quiksearch(searchOption);	
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE re=new Relogin_TPE();
		re.reLogin();
		throw e;
	}
  }

@Then("^check the detail of searched requirement of minimum chars$")
public void check_the_detail_of_searched_requirement_of_minimum_chars() throws Throwable {
	try
	{
		actual[34]=req.VerifyRequirementCount();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE re=new Relogin_TPE();
		re.reLogin();
		throw e;
	} 
}

@When("^Create requirements name of URL$")
public void create_requirements_name_of_URL() throws Throwable {
	try
	{
		tr.clickedOnFolder();
	    bp.waitForElement();
		actual[35]=req.addRequirement();
		bp.waitForElement();
		String name=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 7, 5);
	    String altID=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 3, 1);
	    String link=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 1, 2);
	    String priority=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 3, 3);
	    String Description=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 1, 4);
	    actual[36]=req.enterRequirementDetails(name, altID, link, priority, Description);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE re=new Relogin_TPE();
		re.reLogin();
		throw e;
	}
}

@And("^Search by name ofURL$")
public void search_by_name_ofURL() throws Throwable {
	try
	{
		actual[37]=tr.clickOnSearch();
		String searchOption=Excel_Lib.getData(INPUT_PATH_9, "Req-Detail", 7, 5);
		actual[38]=np.quiksearch(searchOption);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE re=new Relogin_TPE();
		re.reLogin();
		throw e;
	}
}

@Then("^check the detail of searched requirement of url$")
public void check_the_detail_of_searched_requirement_of_url() throws Throwable {
	try
	{
		actual[39]=req.VerifyRequirementCount();
		tr.clickOnList();
		actual[40]=tr.clickedOnFolder();
		for(int k=0;k<=actual.length-1;k++)
		  {
			   System.out.println(actual[k]);
			   soft.assertEquals(actual[k], true);
		   }
	   soft.assertAll();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin_TPE re=new Relogin_TPE();
		re.reLogin();
		throw e;
	}  
}
}
