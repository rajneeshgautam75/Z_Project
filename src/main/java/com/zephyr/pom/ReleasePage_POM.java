package com.zephyr.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zephyr.common.LaunchBrowser;

public class ReleasePage_POM
{
	WebDriver driver=null;
	
	//Modified
	@FindBy(xpath="//span[text()='Test Repository']")      
	public WebElement testRepository;
	//@FindBy(xpath="//*[@id='sidr']/ul/li[2]/a/span[2]")
	//public WebElement testRepository;
	
	//Modifed
	@FindBy(xpath="//span[text()='Test Repository']") 
	public WebElement validateRepository;
	//@FindBy(xpath="//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[1]/div[1]/h3/b")
	//public WebElement validateRepository;
	
	//*****Previous Release 6.0 X-Path*******/
//	@FindBy(xpath="//span[text()='Requirements']")//
//	 public WebElement requirements;//
	
//	 @FindBy(xpath="//span[text()='Requirements']")//
//	 public WebElement validateRequirements;
	
	//*****Modified Release 6.1*******/
	@FindBy(xpath="//a[@title='Requirements']")//
	 public WebElement requirements;
	 
	 @FindBy(xpath="//a[@title='Requirements']")//
	 public WebElement validateRequirements;
	 
	 //Modified
	 @FindBy(xpath="//span[text()='Test Planning']")    
	  public WebElement testPlanning;
	 // @FindBy(xpath="//*[@id='sidr']/ul/li[3]/a/span[2]")
	 // public WebElement testPlanning;
	  
	 //Modified
	 @FindBy(xpath="//span[text()='Test Planning']")
	  public WebElement validatetestPlanning;
	 // @FindBy(xpath="//*[@id='ze-main-app']/testcase-eas/testcase-eas-cycle/div/div/section/div/h3/b")
	  //public WebElement validatetestPlanning;
	  
	 //Modified
	 @FindBy(xpath="//span[text()='Test Execution']")  
	  public WebElement testExecution;
	  //@FindBy(xpath="//*[@id='sidr']/ul/li[4]/a/span[2]")
	  //public WebElement testExecution;
	  
	 //Modified
	 @FindBy(xpath="//span[text()='Test Execution']")
	  public WebElement validatetestExecution;
	  //@FindBy(xpath="//*[@id='ze-main-app']/testcase-execution/div/div/section/div[1]/h3/b")//
	  //public WebElement validatetestExecution;
	 
	 //for Release Cloning
	 
	 @FindBy(xpath="(//span[@title='Clone'])[1]")
	 public WebElement cloneReleaseIcon;
	 
	 @FindBy(xpath="//button[@value='CLONE_RELEASE']")
	 public WebElement cloneRelease;
//	 @FindBy(id="applyDateShift")
//	 public WebElement applyDateShift;
	 
	 @FindBy(id="cycle")
	 public WebElement cycle;
	 
	 @FindBy(id="applyDateShift")
	 public WebElement applyDateShift;
	 @FindBy(id="assignment")
	 public WebElement assignment;
	 @FindBy(id="execution")
	 public WebElement execution;
	 @FindBy(id="defectMap")
	 public WebElement defectMap;
	 @FindBy(id="executionComment")
	 public WebElement executionComment;
	 @FindBy(id="executionAtt")
	 public WebElement executionAtt;
	 @FindBy(id="stepExecution")
	 public WebElement stepExecution;
	 @FindBy(id="stepExecutionComment")
	 public WebElement stepExecutionComment;
	 @FindBy(id="stepExecutionAtt")
	 public WebElement stepExecutionAtt;
	 @FindBy(id="reqTcMap")
	 public WebElement reqTcMap;
	 @FindBy(xpath="//*[text()='Clone']")
	 public WebElement cloneButton;
	 
	 @FindBy(xpath="//*[@value='CLONE_RELEASE_CONFIRMED']")
	 public WebElement confirmClone;
	 
	 @FindBy(xpath="//button[text()='Refresh']")
	 public WebElement refershButton;
	 
	 @FindBy(xpath="(//clone-release//button[text()='Ok'])")
	 public WebElement okButton;
	 
	 //24-10-2017
	  @FindBy(xpath="//span[text()='Manage Release']")
	  public WebElement clickOnManageRelease;
	 
	  @FindBy(xpath="//span[@title='Add New Release']")
	  public WebElement clickOnAddNewRelease;
	  
	  @FindBy(xpath="(//button[text()='Continue'])[4]")
	  public WebElement addNewReleaseContinue;
	  
	  @FindBy(xpath="//input[@placeholder='Enter name']")
	  public WebElement enterReleaseName;
	  
	  @FindBy(xpath="//textarea[@placeholder='Enter description']")
	  public WebElement enterReleaseDescription;
	  
	  @FindBy(xpath="//input[@name='status']")
	  public WebElement releaseHide;
	  
	 //*****Release 6.0 x-Path*****/
//	  @FindBy(xpath="//*[@id='ze-main-app']/release-setup//div[1]/div[2]/div[1]/div//select")
//	  public WebElement mapExternalDefect;
	  
	  /*****Release 6.1 x-Path*****/
	  @FindBy(xpath="(//select[@class='form-control ng-untouched ng-pristine ng-valid'])[2]")
	  public WebElement mapExternalDefect;
	  
	  @FindBy(xpath="//button[text()=' Add']")
	  public WebElement addRelease;
	  
	  @FindBy(xpath="(//div[@class='input-group-addon'])[1]")
		public WebElement startDateOption;
	  
	  public String startDateHeader="//*[@id='release-startdate']//table/thead/tr[1]/th[2]";
//	 public String endDateHeader="//*[@id='release-enddatee']//table/thead/tr[1]/th[2]";//**Release 6.0 x path**//
	//**Release 6.1 X Path**//
	  public String endDateHeader="//*[@id='release-enddate']//table/thead/tr[1]/th[2]";
		 public String year1="//*[text()='";
		 public String year2="']";
		 
		 public String month1="//*[text()='";
		 public String month2="']";
		 
		 public String day1="(//span[text()='";
		 public String day2="'])[1]";
		 
		 public String day_1="(//span[text()='";
		 public String day_2="'])[1]";
		 
		 @FindBy(xpath="(//div[@class='input-group-addon'])[2]")
			public WebElement endDateOption;
	//27-10-2017
		 //click on admin dropdown
		 
		 @FindBy(xpath="//button[contains(.,'Add')]") 
			public WebElement clickOnAdd;
	 
		 
		 @FindBy(xpath = "//span[@class='text-info']")
			public WebElement minYear;

			@FindBy(xpath = "//button[@class='btn btn-default btn-sm pull-left']")
			public WebElement left;

			@FindBy(xpath = "//datepicker-inner/div/yearpicker/table/tbody/tr[4]/td[5]")
			public WebElement maxYear;

			@FindBy(xpath = "//button[@class='btn btn-default btn-sm pull-right']")
			public WebElement right;
			
			//*****Release 6.0 x-Path*****//
//			 public String release1="//*[text()='";
//		     public String release2="']";
		     
		     //*****Release 6.1 x-Path*****//
		     public String release1="(//div[text()='";
		     public String release2="'])";

	public ReleasePage_POM(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(LaunchBrowser.driver,this);
		
	}
	
	public String selRelease1="//div[text()='";
	public String selRelease2="']";
	
	@FindBy(xpath="//a[@title='Defect Tracking']")	
	public WebElement defectTracking;
	

@FindBy(xpath="//h5[text()='Defects Linked to Execution']")
public WebElement validateDefectTrackingPage;
}
