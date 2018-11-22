package com.zephyr.reusablemethods;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.pom.ReleasePage_POM;

public class ReleasePage
{
	WebDriver driver;
	BasePage bp;
	
	public Logger log;
	public ReleasePage(WebDriver driver)
	{
		//super(driver);
		this.driver=driver;
		PageFactory.initElements(LaunchBrowser.driver,this);
		log=Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
//		BasicConfigurator.configure();
		
    }

///////////////////POM//////////////////////
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
//		@FindBy(xpath="//span[text()='Requirements']")//
//		 public WebElement requirements;//
		
//		 @FindBy(xpath="//span[text()='Requirements']")//
//		 public WebElement validateRequirements;
		
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
//		 @FindBy(id="applyDateShift")
//		 public WebElement applyDateShift;
		 
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
//		  @FindBy(xpath="//*[@id='ze-main-app']/release-setup//div[1]/div[2]/div[1]/div//select")
//		  public WebElement mapExternalDefect;
		  
		  /*****Release 6.1 x-Path*****/
		  @FindBy(xpath="(//select[@class='form-control ng-untouched ng-pristine ng-valid'])[2]")
		  public WebElement mapExternalDefect;
		  
		  @FindBy(xpath="//button[text()=' Add']")
		  public WebElement addRelease;
		  
		  @FindBy(xpath="(//div[@class='input-group-addon'])[1]")
			public WebElement startDateOption;
		  
		  public String startDateHeader="//*[@id='release-startdate']//table/thead/tr[1]/th[2]";
//		 public String endDateHeader="//*[@id='release-enddatee']//table/thead/tr[1]/th[2]";//**Release 6.0 x path**//
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
//				 public String release1="//*[text()='";
//			     public String release2="']";
			     
			     //*****Release 6.1 x-Path*****//
			     public String release1="(//div[text()='";
			     public String release2="'])";

//		public ReleasePage_POM(WebDriver driver) 
//		{
//			this.driver = driver;
//			PageFactory.initElements(LaunchBrowser.driver,this);
//			
//		}
		
		public String selRelease1="//div[text()='";
		public String selRelease2="']";
		
		@FindBy(xpath="//a[@title='Defect Tracking']")	
		public WebElement defectTracking;
		

	@FindBy(xpath="//h5[text()='Defects Linked to Execution']")
	public WebElement validateDefectTrackingPage;
	
	/* ****************************************************
	   * Method Name   : clickOnTestRep()
	  * Purpose    : To click On TestRepository
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean clickOnTestRep() throws Exception
	{
		try
		{
			try
			{
	boolean st3=testRepository.isDisplayed();
    boolean st2=testRepository.isEnabled();
	
	//System.out.println(st2);
	//System.out.println(st3);
	
	WebDriverWait wait1 = new WebDriverWait(driver, 30);
    wait1.until(ExpectedConditions.elementToBeClickable(testRepository));
    
		}
		
		catch(Exception e)
	    {
			 System.out.println("Inside Catch");
	    	driver.navigate().refresh();
	    	bp=new BasePage();
	        bp.waitForElement();
	        bp.waitForElement();
	        bp.waitForElement();
	    }
			WebDriverWait wait1 = new WebDriverWait(driver, 30);
		    wait1.until(ExpectedConditions.elementToBeClickable(testRepository));
    testRepository.click();
    bp=new BasePage();
    bp.waitForElement();
    log.info("Successfully clicked on Test Repository Page");
	
	
    String validate_TestRepository=validateRepository.getText();
    String expmsg="Test Repository";
    if(validate_TestRepository.equals(expmsg))
   {
    	log.info("Successfully Landed on Test Repository Page");
//    
	}
//    
    else
    {
   	   log.info("You are not in Test Repository Page");
   
    }
    return true;
	}
    catch(Exception e)
    {
    	e.printStackTrace();
    	log.info("Test Repository is not Clicked");
    	throw e;
    	
    }
}
	
	/* ****************************************************
	   * Method Name   : clickOnRequirements() 
	  * Purpose    : To click On Requirements
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean clickOnRequirements() throws Exception
	 {
		try
		{
			try
			{
	    boolean st4=requirements.isEnabled();
	 boolean st5=requirements.isDisplayed();
	 WebDriverWait wait1 = new WebDriverWait(driver, 30);
	    wait1.until(ExpectedConditions.elementToBeClickable(requirements));
			}
			
			catch(Exception e)
		    {
				 System.out.println("Inside Catch");
		    	driver.navigate().refresh();
		    	bp=new BasePage();
		        bp.waitForElement();
		        bp.waitForElement();
		        bp.waitForElement();
		    }
			 WebDriverWait wait1 = new WebDriverWait(driver, 30);
			    wait1.until(ExpectedConditions.elementToBeClickable(requirements));
	    requirements.click();
	    bp=new BasePage();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    log.info("Successfully Landed on Requirements Page");
	    return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	 
	}
	/* ****************************************************
	   * Method Name   : clickOntestplanning() 
	  * Purpose    : To click On testpalnning
	  * Author    : OPAL4
	  * Date Created   : 28/08/17
	  * Date Modified  :
	  * Reviewed By   : Opal1
	  * ******************************************************
	  */
	public boolean clickOnTestPlanning() throws Exception
	{
		try
		{
			bp=new BasePage();
			try
			{

			WebDriverWait wait1 = new WebDriverWait(driver, 30);
			wait1.until(ExpectedConditions.elementToBeClickable(testPlanning));
			
			testPlanning.click();
			bp.waitForElement();
			testPlanning.click();
			bp.waitForElement();
			
             }
			
			catch(TimeoutException e)
		    {
				 System.out.println("Inside Catch");
		    	driver.navigate().refresh();
		    	bp=new BasePage();
		        bp.waitForElement();
		        bp.waitForElement();
		        bp.waitForElement();
		    }
			
//			testPlanning.click();
//			bp.waitForElement();
//			bp.waitForElement();
//			try
//			{
//			TestPlanningPage tp=new TestPlanningPage(driver);
//			WebDriverWait wait=new WebDriverWait(driver,10);
//	 		wait.until(ExpectedConditions.elementToBeClickable(tp.backToCycle));
//	 		tp.backToCycle.click();
//	 		bp.waitForElement();
//			}
//			
//			catch(TimeoutException e)
//			{
//				System.out.println("Already in first page of test plnning page");
//			}

			System.out.println("Successfully Landed on Test Planning Page");
			bp.waitForElement();
	
	
			String validate_TestPlanning=validatetestPlanning.getText();
			String expmsg="Test Planning";
			if(validate_TestPlanning.equals(expmsg))
			{
				log.info("Successfully Landed on Test testPlanning Page");
				//    
			}  
			else
			{
				log.info("You are not in Test testPlanning Page");
 
			}
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.info("Test testPlanning is not Clicked");
			throw e;
		}
	}
	/* ****************************************************
	   * Method Name   : clickOntestExecution() 
	  * Purpose    : To click On testExecution
	  * Author    : OPAL4
	  * Date Created   : 28/08/17
	  * Date Modified  :
	  * Reviewed By   : Opal1
	  * ******************************************************
	  */
	public boolean clickOnTestExecution() throws Exception
	{
		try
		{
			try
			{
			boolean st2=testExecution.isEnabled();
			boolean st3=testExecution.isDisplayed();
			//System.out.println(st2);
			//System.out.println(st3);
			bp=new BasePage();
			WebDriverWait wait1 = new WebDriverWait(driver, 30);
			wait1.until(ExpectedConditions.elementToBeClickable(testExecution));
		}
			
			catch(TimeoutException e)
		    {
				 System.out.println("Inside Catch");
		    	driver.navigate().refresh();
		    	bp=new BasePage();
		        bp.waitForElement();
		        bp.waitForElement();
		        bp.waitForElement();
		    }
			WebDriverWait wait1 = new WebDriverWait(driver, 30);
			wait1.until(ExpectedConditions.elementToBeClickable(testExecution));
			testExecution.click();
			bp.waitForElement();
			log.info("Successfully Landed on Test testExecution Page");
	
	
			String validate_TestExecution=validatetestExecution.getText();
			String expmsg="Test Execution";
			if(validate_TestExecution.equals(expmsg))
			{
				log.info("Successfully Landed on Test testExecution Page");
				//    
			}  
			else
			{
				log.info("You are not in Test testExecution Page");
 
			}
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.info("Test testExecution is not Clicked");
			throw e;
		}
	}
	

	public boolean clickOnTestRep2(WebDriver driver2) throws Exception
	{
		try
		{
			this.driver=driver2;
    boolean st2=driver.findElement(By.xpath("//span[text()='Test Repository']")).isEnabled();
	boolean st3=driver.findElement(By.xpath("//span[text()='Test Repository']")).isDisplayed();
	//System.out.println(st2);
	//System.out.println(st3);
	
	WebDriverWait wait1 = new WebDriverWait(driver, 30);
    wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Test Repository']"))));
    driver.findElement(By.xpath("//span[text()='Test Repository']")).click();
    bp=new BasePage();
    bp.waitForElement();
    log.info("Successfully Landed on Test Repository Page");
	
	
    String validate_TestRepository=driver.findElement(By.xpath("//span[text()='Test Repository']")).getText();
    String expmsg="Test Repository";
    if(validate_TestRepository.equals(expmsg))
   {
    	log.info("Successfully Landed on Test Repository Page");
//    
	}
//    
    else
    {
   	   log.info("You are not in Test Repository Page");
   
    }
    return true;
	}
    catch(Exception e)
    {
    	e.printStackTrace();
    	log.info("Test Repository is not Clicked");
    	throw e;
    	
    }
}
	
	public boolean clickOnTestPlanning2(WebDriver driver2) throws Exception
	{
		try
		{
			this.driver=driver2;
			WebElement elem=driver.findElement(By.xpath("//span[text()='Test Planning']"));
			boolean st2=elem.isEnabled();
			boolean st3=elem.isDisplayed();
			//System.out.println(st2);
			//System.out.println(st3);
			bp=new BasePage();
			WebDriverWait wait1 = new WebDriverWait(driver, 30);
			wait1.until(ExpectedConditions.elementToBeClickable(testPlanning));
			elem.click();
			bp.waitForElement();
			log.info("Successfully Landed on Test Planning Page");
	
			WebElement elem1=driver.findElement(By.xpath("//span[text()='Test Planning']"));
			String validate_TestPlanning=elem1.getText();
			String expmsg="Test Planning";
			if(validate_TestPlanning.equals(expmsg))
			{
				log.info("Successfully Landed on Test testPlanning Page");
				//    
			}  
			else
			{
				log.info("You are not in Test testPlanning Page");
 
			}
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.info("Test testPlanning is not Clicked");
			throw e;
		}
	}
	
	public boolean clickOnTestExecution2(WebDriver driver2) throws Exception
	{
		try
		{
			this.driver=driver2;
			WebElement ele=driver.findElement(By.xpath("//span[text()='Test Execution']"));
			boolean st2=ele.isEnabled();
			boolean st3=ele.isDisplayed();
			//System.out.println(st2);
			//System.out.println(st3);
			bp=new BasePage();
			WebDriverWait wait1 = new WebDriverWait(driver, 30);
			wait1.until(ExpectedConditions.elementToBeClickable(testExecution));
			ele.click();
			bp.waitForElement();
			log.info("Successfully Landed on Test testExecution Page");
	
			WebElement ele2=driver.findElement(By.xpath("//span[text()='Test Execution']"));
			String validate_TestExecution=ele2.getText();
			String expmsg="Test Execution";
			if(validate_TestExecution.equals(expmsg))
			{
				log.info("Successfully Landed on Test testExecution Page");
				//    
			}  
			else
			{
				log.info("You are not in Test testExecution Page");
 
			}
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.info("Test testExecution is not Clicked");
			throw e;
		}
	}
	public void logout2(WebDriver driver2) throws Exception
	   {
	 	  try
	 	  {
	 	  this.driver=driver2;
	 	  BasePage bp=new BasePage();
	 	  /*******Previous X-Path 6.0******/
//	 	  driver.findElement(By.xpath("//i[@class='misc-image user-image']")).click();
	 	  /*********Modified Release 6.1 X-Path******/
	 	 driver.findElement(By.xpath("//i[@class='fa fa-user-circle-o']")).click();
	 	  bp.waitForElement();
	 	  //pp.user_option.click();
	 	  driver.findElement(By.xpath("//a[contains(.,'Logout')]")).click();
	 	  bp.waitForElement();
	 	 // pp.logout.click();
	 	  }
	 	  catch(Exception e)
	 	  {
	 		  e.printStackTrace();
	 		  throw e;
	 	  }
	   }
	
	
	
	public boolean cloneRelease(String[] a) throws Exception
	{
		try
		{
		bp=new BasePage();
		cloneReleaseIcon.click();
		bp.waitForElement();
		cloneRelease.click();
		bp.waitForElement();
//		driver.findElement(By.xpath("(//span[@title='Clone'])[1]")).click();
//		driver.findElement(By.xpath("//button[@value='CLONE_RELEASE']")).click();
		Actions a1=new Actions(driver);
		{
			a1.sendKeys(Keys.ARROW_DOWN).perform();
			a1.sendKeys(Keys.ARROW_DOWN).perform();
			a1.sendKeys(Keys.ARROW_DOWN).perform();
		}
		bp.waitForElement();
		if(a[0].equals("Clone Cycles"))
		{
			cycle.click();
			bp.waitForElement();
			
		}
		bp.waitForElement();
		if(a[1].equals("Apply 7 day offset to cycles to"))
		{
			
			
			a1.moveToElement(applyDateShift).click().perform();
			
		}
		bp.waitForElement();
		if(a[2].equals("Cycle Phase Assignments"))
		{
			a1.moveToElement(assignment).click().perform();
			
		}
		bp.waitForElement();
		if(a[3].equals("Clone Execution Results"))
		{
			a1.moveToElement(execution).click().perform();
			
		}
		bp.waitForElement();
		if(a[4].equals("Execution-Defect Mappings"))
		{
			a1.moveToElement(defectMap).click().perform();
			
		}
		bp.waitForElement();
		if(a[5].equals("Execution Comments"))
		{
			a1.moveToElement(executionComment).click().perform();
			
		}
		bp.waitForElement();
		if(a[6].equals("Execution Attachments"))
		{
			a1.moveToElement(executionAtt).click().perform();
			
		}
		bp.waitForElement();
		if(a[7].equals("Clone Step Execution Results"))
		{
			a1.moveToElement(stepExecution).click().perform();
			
		}
		bp.waitForElement();
		if(a[8].equals("Step Execution Comments"))
		{
			a1.moveToElement(stepExecutionComment).click().perform();
			
		}
		bp.waitForElement();
		if(a[9].equals("Step Execution Attachments"))
		{
			a1.moveToElement(stepExecutionAtt).click().perform();
			
		}
		bp.waitForElement();
		if(a[10].equals("Requirement Testcase Mapping"))
		{
			a1.moveToElement(reqTcMap).click().perform();
		}
		bp.waitForElement();
		cloneButton.click();
		bp.waitForElement();
		confirmClone.click();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		refershButton.click();
		bp.waitForElement();
		bp.waitForElement();
		okButton.click();
		bp.waitForElement();
		
		return true;
		}
		
		catch(Exception e)
	      {
	       e.printStackTrace();
	       throw e;
	      }
	}
	/* ****************************************************
	 * Method Name   : clickOnManageRelease
	* Purpose    : click on manage release to create release
	* Author    : OPAL4
	* Date Created   : 24/10/17
	* Date Modified  :
	* Reviewed By   : Opal4
	* ******************************************************
	*/
	public boolean clickOnManageRelease() throws Exception
	{
		try
		{
			bp=new BasePage();
			clickOnManageRelease.click();
			bp.waitForElement();	
//			String validate_TestExecution=clickOnManageRelease.getText();
//			String expmsg="Manage Release";
//			if(validate_TestExecution.equals(expmsg))
//			{
//				System.out.println("sucessfully clicked on Manage Release");  
//			}  
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Test testExecution is not Clicked");
			throw e;
		}
	}
	
	/* ****************************************************
	 * Method Name   : addNewRelease
	* Purpose    : to add new release
	* Author    : OPAL4
	* Date Created   : 24/10/17
	* Date Modified  :
	* Reviewed By   : Opal4
	* ******************************************************
	*/
	public boolean addNewRelease(String ReleaseName,String Desc,String Hide,String MapexternalDefect) throws Exception
	{
		try
		{
			bp=new BasePage();
			clickOnAddNewRelease.click();
			bp.waitForElement();
			System.out.println("sucessfully clicked on Add new Release"); 
			
			addNewReleaseContinue.click();
			bp.waitForElement();
			System.out.println("sucessfully clicked on Continue"); 
			
			enterReleaseName.sendKeys(ReleaseName);
			bp.waitForElement();
			System.out.println("Entered Release Name is : "+ReleaseName); 
			
			enterReleaseDescription.sendKeys(Desc);
			bp.waitForElement();
			System.out.println("Entered Desccription is : "+Desc);
			
			if(Hide!="")
			{
				boolean bol=releaseHide.isSelected();
				if(bol==false)
				{
					releaseHide.click();
					bp.waitForElement();
				}
			}
			if(MapexternalDefect!="")
			{
				Select sel=new Select(mapExternalDefect);
				sel.selectByVisibleText(MapexternalDefect);
				bp.waitForElement();
				System.out.println("Selected Defect is : "+MapexternalDefect); 
			}
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Test testExecution is not Clicked");
			throw e;
		}
	}
	
	/* ****************************************************
	 * Method Name   : enterStartDatAndEndDateInReleasepage
	* Purpose    :to enter start and end date for creating release
	* Author    : OPAL4
	* Date Created   : 24/10/17
	* Date Modified  :
	* Reviewed By   : Opal4
	* ******************************************************
	*/
	 public boolean enterStartDatAndEndDateForRelease(String syear,String smonth,String sday,String eyear,String emonth,String eday) throws Exception
	  {
	  try
	  {
	    bp=new BasePage();
	    startDateOption.click();
	    System.out.println("clicked on date option");
	    bp.waitForElement();
	    WebElement ele=driver.findElement(By.xpath(startDateHeader));
	    Actions a2=new Actions(driver);
	    a2.moveToElement(ele).doubleClick().perform();
	    driver.findElement(By.xpath(startDateHeader)).click();
	    //a2.moveToElement(ele).click().perform();
	    bp.waitForElement();
		  String []  startDate =new String[1];
		  String startYear=minYear.getText();
		  int Syear=Integer.parseInt(startYear);
		  int [] start=new int[1];
		  startDate[0]=syear;
		  start[0]=Integer.parseInt(startDate[0]);
			
			if(start[0] < Syear)
			{
				left.click();
				bp.waitForElement();
				
			}
			
			
			
	    
	    driver.findElement(By.xpath(year1+syear+year2)).click();
	    bp.waitForElement();
	    bp.waitForElement();
	    driver.findElement(By.xpath(month1+smonth+month2)).click();
	    bp.waitForElement();
	    bp.waitForElement();
	    driver.findElement(By.xpath(day1+sday+day2)).click();
	    bp.waitForElement();
	    bp.waitForElement();
	    
	    
	    endDateOption.click();
	    bp.waitForElement();
	    WebElement ele1=driver.findElement(By.xpath(endDateHeader));
	    Actions a3=new Actions(driver);
	    a3.moveToElement(ele1).click().perform();
	    bp.waitForElement();
	    bp.waitForElement();
	    driver.findElement(By.xpath(endDateHeader)).click();
	    bp.waitForElement();
	    bp.waitForElement();
	    String []  endDate =new String[1];
		  String endMin=minYear.getText();
			String endMax=maxYear.getText();
			int eMin=Integer.parseInt(endMin);
			int eMax=Integer.parseInt(endMax);
			int [] end=new int[1];
			endDate[0]=eyear;
			end[0]=Integer.parseInt(endDate[0]);
			
			if(end[0] < eMin)
			{
				left.click();
				bp.waitForElement();
			}
			else if(end[0] > eMax)	
			{
				right.click();
			    bp.waitForElement();
			}
	    
	    driver.findElement(By.xpath(year1+eyear+year2)).click();
	    bp.waitForElement();
	    bp.waitForElement();
	    
	    driver.findElement(By.xpath(month1+emonth+month2)).click();
	    bp.waitForElement();
	    bp.waitForElement();
	    driver.findElement(By.xpath(day_1+eday+day_2)).click();
	    bp.waitForElement();
	    return true;
	  }
	  
	 catch(Exception e)
	 {
	  e.printStackTrace();
	  System.out.println("Release Date is not enterd");
	  throw e;
	 }
	 } 
	
	public boolean clickOnAdd() throws Exception
	{
		try
		{
			bp=new BasePage();
			clickOnAdd.click();
			bp.waitForElement();
			System.out.println("Pass-Release Sucessfully Created");
//			String validate_TestExecution=clickOnManageRelease.getText();
//			String expmsg="Manage Release";
//			if(validate_TestExecution.equals(expmsg))
//			{
//				System.out.println("sucessfully clicked on Manage Release");  
//			}  
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Release not Created");
			throw e;
		}
	}
	
	public boolean checkAvailableRelease(String releaseName) throws Exception
	{
	try
		{
	      try
			{
	    	  ReleasePage rp=new ReleasePage(driver);
	   WebElement relaeseName_1=(new WebDriverWait(driver, 05))
	.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(rp.release1+releaseName+rp.release2)));
	  
	  //boolean res=relaeseName_1.isDisplayed();
	 
	  String relaeseNameText=relaeseName_1.getText();
	 
	  if(releaseName.equals(relaeseNameText))
	    {
		  System.out.println(releaseName+"- already present in project");
	    }
	  
	    }
	   
	    catch(TimeoutException e)
		{
			System.out.println(releaseName+" is not present");
			return false;
			
		}
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}


	}

	public boolean selectReleaseInManageRelease(String releaseName) throws Exception
	{
		try
		{
		bp=new BasePage();
		WebElement ele=driver.findElement(By.xpath(selRelease1+releaseName+selRelease2));
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
		bp.waitForElement();
		}
		catch(Exception e)
		{
		e.printStackTrace();
		throw e;
		}
		return true;
	}
	
	

public boolean clickOnDefectTracking() throws Exception
{
  try
	{
	bp=new BasePage();
	bp.waitForElement();
	WebDriverWait wait=new WebDriverWait(driver,60);
	wait.until(ExpectedConditions.elementToBeClickable(defectTracking));
	defectTracking.click();
	bp.waitForElement();
	bp.waitForElement();

	String text=validateDefectTrackingPage.getText();
	
	if(text.equals("Defects Linked to Execution"))
	{
		System.out.println("Suuccessfully navigated to Defect Tracking Page");
	}
	bp.waitForElement();
	
	
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
	return true;
}


}
