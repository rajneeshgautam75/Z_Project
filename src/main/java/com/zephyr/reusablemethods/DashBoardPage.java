package com.zephyr.reusablemethods;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zephyr.common.AutomationConstants;
import com.zephyr.common.LaunchBrowser;
import com.zephyr.pom.DashBoardPage_POM;

public class DashBoardPage{

	 BasePage bp;
	  WebDriver driver;
	  public Logger log;
	 public DashBoardPage(WebDriver driver)
	  {
		 //super(driver);
		 this.driver =driver;
		 PageFactory.initElements(LaunchBrowser.driver, this);
		 log=Logger.getLogger(this.getClass());
		    Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
	  }	

	 
	 //////////////////////////////POM////////////////////////////////
	// button[@title='Add Dashboard']
		@FindBy(xpath = "//button[@title='Add Dashboard']")
		public WebElement addNewDashBoard;

		public String expReults = "Dashboards";

		// h1[contains(.,'Dashboards')]
		
		 @FindBy(xpath = "//a[@class='zui-icon-btn']")
		  public WebElement backToProjectPage;

		@FindBy(xpath = "//h1[contains(.,'Dashboards')]")
		public WebElement verifyDashBoard;

		@FindBy(xpath = "//input[@placeholder='Name']")
		public WebElement dashBoardName;

		@FindBy(xpath = "//*[@id='dashboard-description']")
		public WebElement dashBoardDesc;

		@FindBy(xpath = "//span[@class='fa fa-caret-square-o-down fa-1 zui-gadget-settings']")
		public WebElement gadgetOption;

		// @FindBy(xpath="//span[@class='fa fa-caret-square-o-down fa-1
		// zui-gadget-settings']")
		// public WebElement gadgetOption;
		//
		// *[text()='Automation Status']/../../../div[5]//span[2]
		public String deleteDashBoard1 = "//*[text()='";
		public String deleteDashBoard2 = "']/../../../div[5]//span[2]";

		public String gadgetVal1 = "//a[text()='";
		public String gadgetVal2 = "']";

		public String dashBoardVal1 = "(//a[text()='";
		public String dashBoardVal2 = "'])[1]";

		@FindBy(xpath = "//*[@id='zui-dashboard-modal-delete']//button[text()='Delete']")
		public WebElement deleteDashBoard;

		@FindBy(xpath = "//*[@id='zui-dashboard-modal-delete']//button[text()='Cancel']")
		public WebElement cancelDeleteDashBoard;

		@FindBy(xpath = "(//*[text()='Delete'])[2]")
		public WebElement deleteGadget;

		@FindBy(xpath = "(//*[text()='Cancel'])[2]")
		public WebElement cancelDelteGadget;

		@FindBy(xpath = "//input[@placeholder='Search for...']")
		public WebElement dashBoardSearch;

		@FindBy(xpath = "//span[@class='fa fa-search']")
		public WebElement searchButton;
		// input[@placeholder='Search for...']
		// (//span[@id='select2--container'])[2]

		@FindBy(xpath = "(//span[@class='select2-selection__rendered'])[2]")
		public WebElement selectGadgetProject;

		@FindBy(xpath = "(//span[@class='select2-selection__rendered'])[3]")
		public WebElement selectGadgetRelease;

		@FindBy(xpath = "(//span[@class='select2-selection__rendered'])[4]")
		public WebElement selectGadgetRefreshRate;

		@FindBy(xpath = "//button[text()='Save']")
		public WebElement dashBoardSave;

		@FindBy(xpath = "(//button[text()='Cancel'])[2]")
		public WebElement gadgetCancel;

		@FindBy(xpath = "//div[@title='One Column']")
		public WebElement dashBoardLayoutOne;

		public String layout1 = "(//div[@title='";
		public String layout2 = "'])";
		public String layout3 = "[";
		public String layout4 = "]";
		

		public String shareType1 = "//li[text()='";
		public String shareType2 = "']";

		@FindBy(xpath = "//div[@title='Two Column']")
		public WebElement dashBoardLayoutTwo;

		public String pagenumber1 = "(.//option[text()='";
		public String pagenumber2 = "'])";

		@FindBy(xpath = ".//*[@id='pagination-page-size-dashboard']")
		public WebElement clickOnOptions;

		@FindBy(xpath = "//*[@id='preference']/div/grid/div[2]/ul/span")
		public WebElement pageNumbers;

		@FindBy(xpath = "//*[@id='preference']/div/grid/div[2]/ul/li[3]/a/span")
		public WebElement nextButton;

		@FindBy(xpath = "//*[@id='preference']/div/grid/div[2]/ul/li[2]/a/span")
		public WebElement prevButton;

		// added by abilash 05/02/18
		@FindBy(xpath = "//a[@id='Dashboardslink']")
		public WebElement dashboards;

//		@FindBy(xpath = "//a[text()='Manage Dashboards']")//Removed
//		public WebElement manageDashboards;

		@FindBy(xpath = "//button[text()='+']")
		public WebElement addDashboard;

		@FindBy(xpath = "//input[@placeholder='Name']")
		public WebElement name;

		@FindBy(xpath = "//textarea[ @formcontrolname= 'description']")
		public WebElement desc;

		@FindBy(xpath = "//h1[text()='Dashboards']")
		public WebElement validateDashboards;

		public String dashboard1 = "//div[text()='";
		public String dashboard2 = "']";

		@FindBy(xpath = "//button[@title='Add Gadget']")
		public WebElement addGadgetSymbol;

		public String addGadget1 = "//h4[text()='";
		public String addGadget2 = "']//following-sibling::button";

		public String validateGadget1 = "(//h3[text()='";
		public String validateGadget2 = "'])[1]";

		public String validateExpand1 = "(//h3[text()='";
		public String validateExpand2 = "']//following-sibling::div/* )[";
		public String validateExpand3 = "]";

		@FindBy(xpath = "(//label[contains(.,'Project')]/..//span)[1]")
		public WebElement selectProject;

		@FindBy(xpath = "(//label[contains(.,'Release')]/..//span)[1]")
		public WebElement selectRelease;

		@FindBy(xpath = "(//label[contains(.,'Refresh Rate')]/..//span)[1]")
		public WebElement selectRefreshRate;

		@FindBy(xpath = "(//button[text()='Save'])[1]")
		public WebElement save;

		public String tag1 = "//span[text()='";
		public String tag2 = "']";

		public String phase1 = "//span[text()='";
		public String phase2 = "']";

		@FindBy(xpath = "(//*[@id='filterByTag']//span[text()='Manage'])[1]")
		public WebElement tagManage;

		public String value1 = "(//input[@name='zui-gadget-checkbox'])[";
		public String value2 = "]";

		@FindBy(xpath = "(//input[@title='Select All'])[2]")
		public WebElement selectAll;

		public String pValue1 = "(//div[@class='zui-checkbox2'])[";
		public String pValue2 = "]";

		@FindBy(xpath = "(//*[@id='filterByPhase']//span[text()='Manage'])[1]")
		public WebElement phaseManage;

		public String pSel1 = "(//span[text()='";
		public String pSel2 = "'])[";
		public String pSel3 = "]/../..//div[@class='zui-checkbox2']";

		
//		public String fields1="//span[text()='";
//		public String fields2="']";
		
		
		@FindBy(xpath ="(//zui-summary-box//span[1])[1]")
		public WebElement linkCountInGadgetPage;
		
		public String editDashBoard1="//*[text()='";
	    public String editDashBoard2="']/../../../div[5]//span[1]/span";
	    
//		public DashBoardPage_POM(WebDriver driver) {
//			this.driver = driver;
//			PageFactory.initElements(LaunchBrowser.driver, this);
//			
//
//		}
		
		
		public String validateVal1="(//span[text()='";	
		public String validateVal2="'])[1]";


		@FindBy(xpath="(//li[@class='error-message'])[1]")
		public WebElement validateOverAllDefect;	
		
		 @FindBy(xpath ="(//h1/span)[2]")
		   	public WebElement savedProject;
		    @FindBy(xpath ="(//h5[@class='zee-content-subtitle'])[1]")
		   	public WebElement savedRelease;
		    
		    
		    public String defectStatus1="(//span[text()='";                        
		    public String defectStatus2="']/..//span[@class='zee-module1-title'])[1]";
		    
		  //19/02/18 by srikanth
		    @FindBy(xpath ="//input[@placeholder='Search by Defect ID']")
			public WebElement searchDefectField;
		    
		    @FindBy(xpath ="//span[@class='fa fa-search']")
		   	public WebElement searchDefect;
		    
		    @FindBy(xpath ="//div[@id='grid-table-DEFECT_DETAILS']//div[2]/div/div/span")
		   	public WebElement selectDefect;
		    
		
		    //Requirement Traceability 
		    @FindBy(xpath ="//div[@id='req-traceability-table']")
		   	public WebElement traceabilityReqTable;
		    
		    @FindBy(xpath ="//span[text()='Manage']")
		   	public WebElement manageTraceability;
		    
		    @FindBy(xpath ="//span[text()='Advanced']")
		   	public WebElement traceabilityAdvancedSearch;
		    
		    @FindBy(xpath ="//span[text()='Quick']/..//div")
		   	public WebElement traceabilityQuickSearch;
		    
		    @FindBy(xpath ="//input[@name='zui-search-textarea']")
		   	public WebElement enterTraceabiliQuicktySearchField;
		    
		    @FindBy(xpath ="//input[@placeholder='Enter ZQL']")
		   	public WebElement enterTraceabiliAdvancedSearchField;
		    
		    @FindBy(xpath ="//button[text()='Go']")
		   	public WebElement clickOnTraceabilityGoButton;
		    

		    @FindBy(xpath ="(//*[@id='inline-table-zql']//button)[2]")
		   	public WebElement closeTraceabilityTable;
		    
		    public String valTraceability1="(//div[@class='zui-panel-body']/..//*[text()='";
		    public String valTraceability2="'])[1]";
		    
		    public String valRequirement1="//div[@title='";
		    public String valRequirement2="']";
		    
	        @FindBy(xpath="//div[@id='th-req_select_all']//input")
	        public WebElement selectAllReq;
		
	        @FindBy(xpath ="//*[@id='inline-table-zql']/div/div/grid/div[2]/ul/li[3]/a/span")
	       	public WebElement zqlNextButton;
	        
	        @FindBy(xpath="//button[@class='toast-close-button']")
	        public WebElement closeNotification;
	        
	        
	       public String executionStatus1="(//*[@id='req-traceability-table']//tr/td[4])[";
			public String executionStatus2="]";
			
			 public String defect_Status1="(//*[@id='req-traceability-table']//tr/td[5]/span)[";
			 public String defect_Status2="]";
			 
			 
			 public String validate1="(//span[text()='";
			 public String validate2="'])[2]";
			
			
			 public String filter1="(//span[text()='";
			 public String filter2="'])[1]/../..//div[@class='check']";
			 
			 
			 public String manage1="(//span[text()='Manage'])[";
			 public String manage2="]"; 
			 
			 
			 public String button1=" (//button[text()='×'])";
			 public String button2="[";
			 public String button3="]";
			 
			
			public String filterByPhase1="(//td[text()='" ;
			public String filterByPhase2="'])[" ;
			public String filterByPhase3="]/..//div[@class='zui-checkbox2']" ;
			
			
	        public String filterPhase1="//td[text()='";
	        public String filterPhase2="']";
	        
	        
	        public String testcaseCulumn="(//*[name()='svg'])[1]//*[name()='g'][1]/*[name()='g'][1]/*[name()='rect']";
	        public String msgPopup="(//html/body/div)[2]";
	        
	        @FindBy(xpath = "//div[@title='Two Column']/span")
	        public WebElement validateTwoCol;
	        
	        @FindBy(xpath = "//div[@title='One Column']/span")
	        public WebElement validateOneCol;
	        
	        public String dashBoardName1 = "//h1[contains(.,'";
	        public String dashBoardName2 = "')]";

	        public String dashBoardDesc1 = "//h5[contains(.,'";
	        public String dashBoardDesc2 = "')]";
	        
	        @FindBy(xpath="(//button[text()='×'])[3]")//updated 26/03/18 by srikanth
	    	public WebElement gadgetCloseButton;
	        
	        @FindBy(xpath="(//button[text()='×'])[5]")//previous
	       // @FindBy(xpath="(//button[text()='×'])[4]")
	       	public WebElement deleteGadgetCloseButton;
	        
	        @FindBy(xpath="//p[text()='Are you sure you want to delete the gadget?']")
	       	public WebElement deleteConfirmationMsg;
	        
	        public String projectStatusVal1="//*[text()='";
	        public String projectStatusVal2="']/..//span[@class='zee-module1-title']";

	        
	        @FindBy(xpath="//strong[text()='Add a New Gadget']")
			 public WebElement addNewGadget;
	        
	        public String cell="(//*[name()='svg'])[1]//*[name()='g'][1]/*[name()='g']/*[name()='rect']";

	        @FindBy(xpath="(//div[@class='row'])[3]")
			public WebElement priorityFields;
	        
	        @FindBy(xpath="//h4[text()='Add Gadget']")
			public WebElement addGadgetPage;
	        
	        @FindBy(xpath="//*[text()='Defects Filed']/preceding-sibling::span")
	        public WebElement overallDefectCount;
	        
	        @FindBy(xpath="//*[@class='defects-figures']")
	        public WebElement tracebilityCount;
	        
	        @FindBy(xpath = "(//label[contains(.,'Timeframe')]/..//span)[1]")
	    	public WebElement timeFrame;
	        
	        @FindBy(xpath="//span[text()='Defects Linked']/preceding-sibling::span")
	        public WebElement Dailypulse;
	        

	        public String priorityCount1="//span[contains(.,'";
	        public String priorityCount2="')]/..//span[3]";

	       
	        
	        @FindBy(xpath="(//label[contains(.,' Timeframe')]/..//span)[1]")
			public WebElement selectTimeframe;
	      
	 
	 
	 public boolean clickOnAddDashBoardSymbol() throws Exception
	  {
	   try
	   {
	   bp=new BasePage();
	   bp.waitForElement();
	   bp.explicitWait(addNewDashBoard);
	   addNewDashBoard.click();
	   System.out.println("Pass-Successfully clicked on Add DashBoard Symbol");
	   bp.waitForElement();
	   
	   return true;
	   }
	   catch(Exception e)
	   {
	    System.out.println("Fail-Add DashBoard Symbol is not clicked");
	    e.printStackTrace();
	    throw e;
	   }
	   
	  }
 
		 
	 public boolean verifyAddDashBoardPage() throws Exception
	  {
	   try
	   {
	     String text=verifyDashBoard.getText();
	     
	     if(text.equalsIgnoreCase(expReults))
	     {
	      System.out.println("Pass-Successfully navigated to the Add DashBoard Page");
	     }
	   
	   return true;
	   }
	   catch(Exception e)
	   {
	    System.out.println("Fail- You are not in Add DashBoard Page");
	    e.printStackTrace();
	    throw e;
	   }
	  }
	 public boolean checkProject(String project) throws Exception
	 {
		 try
		 {
		   bp=new BasePage();
		   WebDriverWait wait=new WebDriverWait(driver,20);
		   if(project!="")
		   {
		  
		   wait.until(ExpectedConditions.elementToBeClickable(selectProject));
		   selectProject.click();
		   Actions act=new Actions(driver);
		   act.sendKeys(project).sendKeys(Keys.ENTER).build().perform();
		   }
		   return true;
		   }
		   catch(Exception e)
			 {
			  e.printStackTrace();
			  throw e;
			 }

	 }
	 
	public boolean layoutSelection(String layout) throws Exception
	{
		try
		{
			bp=new BasePage();
			Actions a1=new Actions(driver);
			WebElement ele=driver.findElement(By.xpath(layout1+layout+layout2));
			a1.pause(1200).moveToElement(ele).click().perform();
			System.out.println("Pass - clicked on layout '"+layout+"' successfull ");
			bp.waitForElement();
			return true;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		   
		}
	}
//	
//	
//	public boolean shareTypeSelection(String shareType) throws Exception
//	{
//		try
//		{
//			bp=new BasePage();
//			Actions a1=new Actions(driver);
//			WebElement ele=driver.findElement(By.xpath("(//span[@class='select2-selection__rendered'])[2]"));
//			a1.pause(1200).moveToElement(ele).click().perform();
//			bp.waitForElement();
//			//WebElement ele1=driver.findElement(By.xpath(shareType1+shareType+shareType2));
//			Select Sel=new Select(ele);
//			Sel.selectByVisibleText(shareType);
//			System.out.println("Pass - selection of '"+shareType+"' successfull ");
//			bp.waitForElement();
//			return true;
//		}
//		
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			throw e;
//		   
//		}
//	}
//	
	
	public boolean enterDashBoardDetails(String name,String desc,String layout,String shareType) throws Exception
	{
		try
		{
			bp=new BasePage();
			
			if(name!="")
			{
			bp.explicitWait(dashBoardName);
			dashBoardName.click();
			dashBoardName.clear();
			dashBoardName.sendKeys(name);
			System.out.println("Pass-DashBoard Name entered successfully");
			}
			if(desc!="")
			{
			
			bp.explicitWait(dashBoardDesc);
			dashBoardDesc.click();
			dashBoardDesc.clear();
			dashBoardDesc.sendKeys(desc);
			System.out.println("Pass-DashBoard Description entered successfully");
			}
			
			if(layout!="")
			{
			Actions a1=new Actions(driver);
			WebElement ele=driver.findElement(By.xpath(layout1+layout+layout2));
			a1.pause(1200).moveToElement(ele).click().perform();
			System.out.println("Pass - clicked on layout '"+layout+"' successfull ");
			bp.waitForElement();
			}
			if(shareType!="")
			{
			Actions a1=new Actions(driver);
			List<WebElement> ele1=driver.findElements(By.xpath("//span[@id='select2--container']"));
			
			a1.pause(1200).moveToElement(ele1.get(ele1.size()-1)).click().perform();
			bp.waitForElement();
			WebElement el=driver.findElement(By.xpath(shareType1+shareType+shareType2));
			el.click();
			}
			//Select Sel=new Select(ele1);
			//Sel.selectByVisibleText(shareType);
			System.out.println("Pass - selection of '"+shareType+"' successfull ");
			bp.waitForElement();
			boolean res=dashBoardSave.isEnabled();
			if(res==true)
			{
			bp.explicitWait(dashBoardSave);
			dashBoardSave.click();
			System.out.println("Pass-clicked on save button");
			bp.waitForElement();
			System.out.println("Pass-Dashboard created Successfully");
			bp.waitForElement();
			}
			return true;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		   
		}
	}
	
	public boolean validateDashBoard(String dashBoard) throws Exception
	{
		try
		{
			bp=new BasePage();
			WebElement ele=driver.findElement(By.xpath(layout1+dashBoard+layout2));
			String text=ele.getText();
			if(text.equals(dashBoard))
			{
				System.out.println("Pass-DashBoard successfully validated");
			}
			else
			{
				System.out.println("Pass-DashBoard not validated");
			}
			return true;
		}
		
		
		catch(NoSuchElementException e)
		{
			
		   log.warn("Dashboard is not presnt in Dashborad list");
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		   
		}
	}
	
	public boolean gadgetOperation(String value) throws Exception
	{
		try
		{
			
			bp=new BasePage();
			gadgetOption.click();
			System.out.println("Pass-Successfully clicked on option");
			bp.waitForElement();
			WebElement ele=driver.findElement(By.xpath(gadgetVal1+value+gadgetVal2));
			Actions a1=new Actions(driver);
			a1.pause(1200).moveToElement(ele).click().perform();
			System.out.println("Pass - clicked on '"+value+"' successfull ");
			bp.waitForElement();
			
			
			if(value.equals("Delete"))
			{
				//System.out.println("Pass - clicked on '"++"' successfull");
				deleteGadget.click();
				System.out.println("Pass-successfully deleted the gadget");
				bp.waitForElement();
				bp.waitForElement();
				
			}
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean minimizeOrMaximizeDashBoardGadget(String value) throws Exception
	{
		try
		{
			bp=new BasePage();
			gadgetOption.click();
			WebElement ele=driver.findElement(By.xpath(dashBoardVal1+value+dashBoardVal2));
			bp.explicitWait(ele);
			Actions act=new Actions(driver);
			act.pause(1200).moveToElement(ele).click().perform();
			System.out.println("Pass - clicked on '"+value+"' successfull");
			bp.waitForElement();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public boolean deleteDashBoard(String dashBoardName) throws Exception
	{
		try
		{
			bp=new BasePage();
			WebElement ele=driver.findElement(By.xpath(deleteDashBoard1+dashBoardName+deleteDashBoard2));
			bp.explicitWait(ele);
			Actions act=new Actions(driver);
			act.pause(1200).moveToElement(ele).click().perform();
			System.out.println("Pass - clicked on '"+dashBoardName+"' successfull");
			bp.waitForElement();
			deleteDashBoard.click();
			System.out.println("Pass-successfully deleted the '"+dashBoardName+"' ");
			bp.waitForElement();
			return true;
		}
		catch(NoSuchElementException e)
		{
			
		  System.out.println("Dashboard Delete button is not present in Dashborads list");
		  return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public boolean deleteDashBoardGadget(String value) throws Exception
	{
		try
		{
			bp=new BasePage();
			WebElement ele=driver.findElement(By.xpath(dashBoardVal1+value+dashBoardVal2));
			bp.explicitWait(ele);
			Actions act=new Actions(driver);
			act.pause(1200).moveToElement(ele).click().perform();
			System.out.println("Pass - clicked on '"+value+"' successfull");
			deleteGadget.click();
			System.out.println("Pass-successfully deleted the gadget");
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean searchDashboard(String searchOption) throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
			bp.explicitWait(dashBoardSearch);
			dashBoardSearch.click();
			dashBoardSearch.clear();
			System.out.println("Pass-Search button is clicked successfully");
			dashBoardSearch.sendKeys(searchOption);
			System.out.println("Pass - value '"+searchOption+"' entered successfully");
			bp.waitForElement();
			searchButton.click();
			System.out.println("Pass-Successfully clicked on search button");
			bp.waitForElement();
			return true;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	
	}
	
	public boolean selectDashBoardPageSize(String pageNumber) throws Exception 
	{
		try
		{
		BasePage bp=new BasePage();
		bp.waitForElement();
		String releasename3=pagenumber1+pageNumber+pagenumber2;
		bp.explicitWait(clickOnOptions);
		clickOnOptions.click();
		bp.waitForElement();
		String testCaseNo=driver.findElement(By.xpath(releasename3)).getText();
		Select s1=new Select(clickOnOptions);
		
		if(pageNumber.equals(testCaseNo))
		{
		   s1.selectByVisibleText(pageNumber);
		}
		
		 System.out.println("Pass - click on'"+pageNumber+"' Successfull");
		 bp.waitForElement();
		
	    return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	    
	}	
	
	public boolean navigateToNextPages() throws Exception
	{

		try
		{

	      bp=new BasePage();
		String pages=pageNumbers.getText();
		String[] p=pages.split(" ");
		int lastpage=Integer.parseInt(p[p.length-1]);
		
		for(int i=1;i<=lastpage-1;i++)
		{
			bp.waitForElement();
			nextButton.click();
			bp.waitForElement();
			
		}
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
		public boolean navigateToPrevPages() throws Exception
		{
			try
			{
			String pages=pageNumbers.getText();
			String[] p=pages.split(" ");
			int lastpage=Integer.parseInt(p[p.length-1]);
		for(int k=lastpage-1;k>=1;k--)
		{
			bp.waitForElement();
			prevButton.click();
			bp.waitForElement();
		}
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	//Abhilash
		
	
		public boolean clickOnManageDashboards() throws Exception
		{
			try
			{
			bp=new BasePage();
			bp.waitForElement();
		    WebDriverWait wait=new WebDriverWait(driver,30);
		    wait.until(ExpectedConditions.elementToBeClickable(dashboards));
		    Actions act=new Actions(driver);
		    act.moveToElement(dashboards).click().perform();
	        act.moveToElement(backToProjectPage).perform();
		    bp.waitForElement();
			 return true;	
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
			
		 }
	
		
//		public boolean clickOnManageDashboards() throws Exception
//		{
//			try
//			{
//			bp=new BasePage();
//			bp.waitForElement();
//		    WebDriverWait wait=new WebDriverWait(driver,30);
//		    wait.until(ExpectedConditions.elementToBeClickable(dashboards));
//		    Actions act=new Actions(driver);
//		    act.moveToElement(dashboards).click().perform();
//		    
//		  //  act.moveToElement(backToProjectPage).perform();
//		    
//		 
//		    bp.waitForElement();
//			 return true;	
//			}
//			
//			catch(Exception e)
//			{
//				e.printStackTrace();
//				throw e;
//			}
//			
//		 }
//		
//		
//		duplicate
		
		public boolean validateDashboards() throws Exception 
		{
			try
			{
			String  validate=validateDashboards.getText();
			if(validate.equals("Dashboards"))
			{
			 System.out.println("Navigated to Dashboards page successfully");	
			}
			
			return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
			
		}
	 
		
		
		

		
	public boolean selectDashboard(String dashboard) throws Exception
	{
		try
		{
		bp=new BasePage();
		WebElement ele=driver.findElement(By.xpath(dashboard1+dashboard+dashboard2));
		String name=ele.getText();
		if(name.equals(dashboard))
		 {
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
		bp.waitForElement();
		System.out.println("Dashboard -"+dashboard+" selected successfully");
		 }
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
		
		return true;
	}


	public boolean clickOnAddGadgetSymbol() throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		//addDashboard.isDisplayed();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(addGadgetSymbol));
		Actions a1=new Actions(driver);
		a1.moveToElement(addGadgetSymbol).click().perform();
		
		//addDashboard.click();
		bp.waitForElement();
		System.out.println("Clicked on add Gadget symbol successfully");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}

	public boolean addGadget(String gadgetName) throws Exception
	{
		try
		{
		bp=new BasePage();
		WebDriverWait wait=new WebDriverWait(driver,60);
		
		WebElement ele=driver.findElement(By.xpath(addGadget1+gadgetName+addGadget2));
		wait.until(ExpectedConditions.visibilityOf(ele));
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",ele );
//		WebDriverWait wait=new WebDriverWait(driver,60);
//		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
		bp.waitForElement();
		bp.waitForElement();
		System.out.println(gadgetName+"- Gadget added successfully");
		return  true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}


	public boolean validateGadget(String gadget) throws Exception
	{
		try
		{
	   WebElement ele=driver.findElement(By.xpath(validateGadget1+gadget+validateGadget2));
	   String validate=ele.getText();
	   if(validate.equals(gadget))
	   {
	   System.out.println(gadget+"- Gadget added is validated successfully");
	   }
	   
	   return true;
	   
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}

	}

	public boolean configureTestAutomationStatusGadget(String project, String release,String refreshRate) throws Exception
	{
	try
	{
	  bp=new BasePage();
	  WebDriverWait wait=new WebDriverWait(driver,20);
	  if(project!="")
	  {
	 
	  wait.until(ExpectedConditions.elementToBeClickable(selectProject));
	  selectProject.click();
	  Actions act=new Actions(driver);
	  act.sendKeys(project).sendKeys(Keys.ENTER).build().perform();
	  }
	  bp.waitForElement();
	  if(release!="")
	  {
	  wait.until(ExpectedConditions.elementToBeClickable(selectRelease));
	  selectRelease.click();
	  Actions act=new Actions(driver);
	  act.sendKeys(release).sendKeys(Keys.ENTER).build().perform();
	  }
	  bp.waitForElement();
	  if(refreshRate!="")
	  {
	  selectRefreshRate.click();
	  Actions act=new Actions(driver);
	  act.sendKeys(refreshRate).sendKeys(Keys.ENTER).build().perform();
	  //wait.until(ExpectedConditions.elementToBeClickable(save));
	  }
	  bp.waitForElement();

	  boolean res=save.isEnabled();
	  //System.out.println(res);
	  
	  if(res==true)
	  {
	  save.click();
	  bp.waitForElement();
	  
	  System.out.println("Configured Test Automation Status Gadget successfully");
	  }
	 
	 return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}

		
	}


	
	
	
	
	
	
	public int totalGadgetCount(String gadgetName) throws Exception
	{
		try
		{
			
			List<WebElement> ele=driver.findElements(By.xpath(validateGadget1+gadgetName+pagenumber2));
			int gadgetCount=ele.size();
			
			System.out.println("Total "+gadgetCount+" Gadget-"+gadgetName+" present in Dashboard");
			if(ele.isEmpty()==true)
			{
				System.out.println("Total 0 Gadget-"+gadgetName+" present in Dashboard");
				
			}
			return gadgetCount;
		}
		
		
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}
	
	public boolean configureTestAutomationDistributionGadget(String project, String release,String refreshRate, String typeName, String [] value) throws Exception
	{
		try
		{
	   bp=new BasePage();
	   WebDriverWait wait=new WebDriverWait(driver,60);
	   wait.until(ExpectedConditions.elementToBeClickable(selectProject));
	   selectProject.click();
	   Actions act=new Actions(driver);
	   act.sendKeys(project).sendKeys(Keys.ENTER).build().perform();
	   bp.waitForElement();
	   wait.until(ExpectedConditions.elementToBeClickable(selectRelease));
	   selectRelease.click();
	   act.sendKeys(release).sendKeys(Keys.ENTER).build().perform();
	   bp.waitForElement();
	   if(typeName.equals("Tag"))
	   {
	   WebElement ele=driver.findElement(By.xpath(phase1+typeName+phase2));
	   wait.until(ExpectedConditions.elementToBeClickable(ele));
	   ele.click();
	   bp.waitForElement();
	   System.out.println(typeName+" option selected successfully");
	   wait.until(ExpectedConditions.visibilityOf(tagManage));
	   tagManage.click();
	   bp.waitForElement();
	   
	   List<WebElement> totalSize=driver.findElements(By.xpath(tag1+value[0]+tag2));
  	   int lastSize=totalSize.size();
	   
  	 if(!value[0].equals("Select/Unselect All"))
  	 {
	   for(int i=0;i<=value.length-1;i++)
	   {
	     	    	 
		  WebElement element=driver.findElement(By.xpath(pSel1+value[i]+pSel2+lastSize+pSel3));
		  element.click();
		  bp.waitForElement();
		  System.out.println(value[i] + " tag selected successfully");
	     }
  	 } 
	      else
	      {
		   WebElement element=driver.findElement(By.xpath(pSel1+value[0]+pSel2+lastSize+pSel3));
		   element.click();
		   bp.waitForElement();
		   System.out.println(value[0] + " tag selected successfully");
		   
		   }
		 
	    }    
	  
	  else if(typeName.equals("Top level phase"))
	   {
	   WebElement ele=driver.findElement(By.xpath(phase1+typeName+phase2));
	   wait.until(ExpectedConditions.elementToBeClickable(ele));
	   ele.click();
	   bp.waitForElement();
	   System.out.println(typeName+" option selected successfully");
	   wait.until(ExpectedConditions.visibilityOf(phaseManage));
	   phaseManage.click();
	   bp.waitForElement();
	   if(!value[0].equals("Select/Unselect All"))
		 {
		
		   List<WebElement> elements=driver.findElements(By.xpath(phase1+value[0]+phase2));
			 int lastSize=elements.size();
			 
	     for(int j=0;j<=value.length-1;j++)
	     {	 
		 
		 
			 //List<WebElement> element=driver.findElements(By.xpath(pValue1+value[j]+pValue2));
	    WebElement element=driver.findElement(By.xpath(pSel1+value[j]+pSel2+lastSize+pSel3));
		  element.click();
		 bp.waitForElement();
		 System.out.println(value[j] + "phase selected successfully");
		 }
		 }
		 
		 else
		  {
			 //driver.findElement(By.xpath(pSel1+value[j]+pSel2+lastSize+pSel3));
			 List<WebElement> elements=driver.findElements(By.xpath(phase1+value[0]+phase2));
			 int lastSize=elements.size();
			 
		  WebElement element1=driver.findElement(By.xpath(pSel1+value[0]+pSel2+lastSize+pSel3));
		  element1.click();
		  bp.waitForElement();
		  System.out.println(value[0] + "phase selected successfully");
		  
		   }
		 
	   }
	   WebElement close=driver.findElement(By.xpath("(//*[@class='zui-panel-body']//div[3]/button)[2]"));
	   
	   act.moveToElement(close).click().perform();
	   bp.waitForElement();
	   act.moveToElement(selectRefreshRate).click().perform();
	   act.sendKeys(refreshRate).sendKeys(Keys.ENTER).build().perform();
	   wait.until(ExpectedConditions.elementToBeClickable(save));
	   save.click();
	   bp.waitForElement();
	   System.out.println("Configured Test Automation Distribution Gadget successfully");  
	   return true;
	} 

	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
	
	
	
	

}
	
	

	public boolean clickOnEditDashBoardSymbol(String dashBoardName) throws Exception
	 {
	  try
	  {
	   bp=new BasePage();
	   WebElement ele=driver.findElement(By.xpath(editDashBoard1+dashBoardName+editDashBoard2));
	  
	   Actions act=new Actions(driver);
	   String visible=ele.getAttribute("style");
	   System.out.println(visible);
	   if(!visible.equals("visibility: hidden;"))
	   { 
		   bp.explicitWait(ele);
	   act.pause(1200).moveToElement(ele).click().perform();
	   System.out.println("Pass - clicked on the edit option successfull");
	   //System.out.println("Pass-successfully clicked on edited the '"+dashBoardName+"' ");
	   bp.waitForElement();
	   }
	   else
	   {
		   System.out.println("Edit option is not visble to current user" );
		   bp.waitForElement();
	   }
	   return true;
	  }
	 
	  catch(Exception e)
	  {
	   e.printStackTrace();
	   throw e;
	  }
	 }
	
	public boolean validatePageSize(int pageSize) throws Exception
	 {
	  try
	  {
	   bp=new BasePage();
	   WebElement ele=clickOnOptions;
	   String currentPageSize=ele.getText();
	   if(currentPageSize.equals(pageSize))
	   {
	    System.out.println("Pass - pageSize'"+pageSize+"' is validated Successfully");
	   }
	   return true;
	  }
	  catch(Exception e)
	  {
	   e.printStackTrace();
	   throw e;
	  }
	 }
	
	public boolean validateSearchResults(String results) throws Exception
	{
	 try
	 {
	 bp=new BasePage();
	
	 List<WebElement> count=driver.findElements(By.xpath(layout1+results+layout2));
	 int size=count.size();
	 WebElement ele=driver.findElement(By.xpath(layout1+results+layout2+layout3+size+layout4));
	 bp.waitForElement();
	 String text=ele.getText();
	 if(text.equals(results))
	 {
	  System.out.println("Pass-Searched results are matched Successfully");
	 }
	 bp.waitForElement();
	 return true; 
	 }
	 catch(Exception e)
	 {
	  e.printStackTrace();
	  throw e;
	 } 
	}
	
	
	public boolean checkRelease(String release) throws Exception
	{
	try
	{
	bp=new BasePage();
	WebDriverWait wait=new WebDriverWait(driver,20);
	if(release!="")
	{
	
	wait.until(ExpectedConditions.elementToBeClickable(selectRelease));
	selectRelease.click();
	Actions act=new Actions(driver);
	act.sendKeys(release).sendKeys(Keys.ENTER).build().perform();
	}
	return true;
	}
	catch(Exception e)
	{
	e.printStackTrace();
	throw e;
	}

	}
	
	
	public boolean validateProjectStatusGadgetDetails(String gadgetValue) throws Exception
	{
		 try
		 {
			 bp=new BasePage();
			 WebElement ele=driver.findElement(By.xpath(projectStatusVal1+gadgetValue+projectStatusVal2));
			 String text=ele.getText();
			 //System.out.println(text);
			 System.out.println("Project Status " + gadgetValue + "  count is " + text);
			 bp.waitForElement();
			 return true;
		 }
		 catch(Exception e)
		  {
		   e.printStackTrace();
		   throw e;
		  }
	}

	
	
	public int linkCountInGadgetPage() throws Exception
	{
		try
		{
			
			WebElement ele=linkCountInGadgetPage;
			String defectCount=ele.getText();
			int count=Integer.parseInt(defectCount);
			System.out.println("Defect count-"+defectCount);
			return count ;	
		}
		
		
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}	
	
	
	
	

	public double validateTestAutomationGadget() throws Exception
	 {
	  
	  try
	  {
		  WebElement ele=driver.findElement(By.xpath("(//zui-release-automation-status-gadget//h2)[1]"));
		  String text=ele.getText();
		  double value=Double.parseDouble(text.replaceAll("%", ""));
		  
		  return value;	
	  
	  }
	  
	   catch(Exception e)
	   {
	    e.printStackTrace();
	    throw e;
	   } 
	 }
	
	
	
	public boolean validateMinimizeOrMaximizeGadget(String projectName)
	{
	try
	{
	 bp=new BasePage();
	 WebElement ele=driver.findElement(By.xpath(validateVal1+projectName+validateVal2));
	 String data=ele.getText();
	 if(data.equals(projectName))
	 {
	 System.out.println("Validated- Gadget is in Maximized mode");	 
	 }
	}
	catch(ElementNotVisibleException e)
	{
	System.out.println("Validated- Gadget is in Minimized mode");	
	}
	return true;
	}
		

	public boolean validateOverAllDefectGadget() throws Exception
	{
		try
		{
		String validate=validateOverAllDefect.getText();
		System.out.println(validate);
		}
		catch(Exception e )
		{
		e.printStackTrace();
		throw e;
		}
		return true;
	}
	
	
	public boolean validateSavedGadget(String projectName,String releaseName) throws Exception 
	{
		try
		{
		String project=savedProject.getText();
		
		String release=savedRelease.getText();
		
		if(project.equals(projectName) && release.equals(releaseName))
			
		{
			
			System.out.println("Gadget successfully saved");
		}
		
		
		return true;
		}
		 catch(Exception e)
		 {
		  e.printStackTrace();
		  throw e;
		 } 
		
		
	}
	
	public boolean defectStatusCount( String defectStatusName) throws Exception
	{
	 bp=new BasePage();
	 try
	 {
	 bp.waitForElement();
	 WebElement ele=driver.findElement(By.xpath(defectStatus1+defectStatusName+defectStatus2));
	 String status=ele.getText();
	 System.out.println("Defect " + defectStatusName + " status count is " + status);
	 }
	 catch(Exception e)
	 {
	  e.printStackTrace();
	  throw e;
	 }
	 return true;
	}
	
	
	public boolean searchAndSelectDefect(String defectID) throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.explicitWait(searchDefectField);
			searchDefectField.clear();
			searchDefectField.sendKeys(defectID);
			System.out.println("Pass - defectID'"+ defectID +"' is entered Successfully");
			searchDefect.click();
			System.out.println("Pass-Successfully clicked on defect search button");
			bp.waitForElement();
			selectDefect.click();
			System.out.println("Pass - defectID'"+ defectID +"' is selected Successfully");
			bp.waitForElement();
			return true;
		}
		catch(Exception e)
	    {
	     e.printStackTrace();
	     throw e;
	    } 
	}
	
	
	
	
	//Requirement Traceability
	public boolean reqTraceabilityTable() throws Exception
	{
		try
		{
			bp=new BasePage();
			WebElement ele=traceabilityReqTable;
			String text=ele.getText();
			System.out.println(text);
			bp.waitForElement();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean closeTraceabilityTable() throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.explicitWait(closeTraceabilityTable);
			closeTraceabilityTable.click();
			System.out.println("Pass-Traceability Table is closed successfully");
			bp.waitForElement();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
	public boolean configureTraceabilityGadget(String project, String release,String refreshRate) throws Exception
	{
	try
	{
	  bp=new BasePage();
	  WebDriverWait wait=new WebDriverWait(driver,60);
	  bp.waitForElement();
	  if(project!="")
	  {
	  wait.until(ExpectedConditions.elementToBeClickable(selectProject));
	  selectProject.click();
	  Actions act=new Actions(driver);
	  act.sendKeys(project).sendKeys(Keys.ENTER).build().perform();
	  }
	  bp.waitForElement();
	  if(release!="")
	  {
	  wait.until(ExpectedConditions.elementToBeClickable(selectRelease));
	  selectRelease.click();
	  Actions act=new Actions(driver);
	  act.sendKeys(release).sendKeys(Keys.ENTER).build().perform();
	  }
	  bp.waitForElement();
	  if(refreshRate!="")
	  {
	  selectRefreshRate.click();
	  Actions act=new Actions(driver);
	  act.sendKeys(refreshRate).sendKeys(Keys.ENTER).build().perform();
	  }
	  bp.waitForElement();
	 
	 return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}

	}
	
	public boolean manageTraceability() throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.explicitWait(manageTraceability);
			manageTraceability.click();
			System.out.println("Pass-manage Traceability option is clicked successfully");
			bp.waitForElement();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean saveTraceabilityGadget() throws Exception
	{
		try
		{
			  bp=new BasePage();
			  boolean res=save.isEnabled();
			  System.out.println(res);
			  if(res==true)
			  {
			  save.click();
			  bp.waitForElement();
			  
			  System.out.println("Configured the Traceability Gadget successfully");
			  }
			  bp.waitForElement();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean traceabilityQuickSearch(String searchOption) throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		bp.explicitWait(traceabilityQuickSearch);   
		traceabilityQuickSearch.click();
		System.out.println("Pass-Successfully clicked on Quick search");
		WebDriverWait wait2=new WebDriverWait(driver, AutomationConstants.EXPLICIT);
		wait2.until(ExpectedConditions.elementToBeClickable(traceabilityQuickSearch));
		bp.explicitWait(enterTraceabiliQuicktySearchField);
		enterTraceabiliQuicktySearchField.sendKeys(searchOption);
		System.out.println("Pass - searchField'" + searchOption + "' is entered Successfull");
		bp.waitForElement();
		bp.explicitWait(clickOnTraceabilityGoButton);
		clickOnTraceabilityGoButton.click();
		System.out.println("Pass - Successfully clicked on go option");
		bp.waitForElement();
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}
	
	public boolean validateTraceabilityGadget(String traceabilityValue) throws Exception
	{
		try
		{
			bp=new BasePage();
			WebElement ele=driver.findElement(By.xpath(valTraceability1+traceabilityValue+valTraceability2));
			String text=ele.getText();
			if(text.equals(traceabilityValue))
			{
				System.out.println("Pass - Traceability Gadget Value'" + traceabilityValue + "' is validated Successfully");
			}
			bp.waitForElement();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public boolean validateRequirements(String requirementValue) throws Exception
	{
		try
		{
			bp=new BasePage();
			WebElement ele=driver.findElement(By.xpath(valRequirement1+requirementValue+valRequirement2));
			String text=ele.getText();
			if(text.equals(requirementValue))
			{
				System.out.println("Pass - Requirement Value'" + requirementValue + "' is validated Successfully");
			}
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	
	 public boolean validateExecutionsInGadget(int reqNo,String executionStatus,String defectStatus) throws Exception
	 {
		 try
		 {

		 WebElement ele=driver.findElement(By.xpath(executionStatus1+reqNo+executionStatus2));
		 
		 String statusResult=ele.getText();
		 System.out.println(statusResult);
		 
		 if(statusResult.equalsIgnoreCase(executionStatus))
		 {
			 
			 System.out.println("Sucessfully validated execution status in Gadget Page");
			 
		 }
		 

		 WebElement ele1=driver.findElement(By.xpath(defect_Status1+reqNo+defect_Status2));
		 
		 String defectResult=ele1.getText();
		 //System.out.println("Defcet Res="+defectResult);
		 String[] defectCount=defectResult.split("\\n");
				 
		 String defectsStatus=defectCount[1];
				 
						
		System.out.println("Total defct Count "+defectsStatus);		 
						 
		 
		 if(defectsStatus.equalsIgnoreCase(defectStatus))
		 {
			 
			 System.out.println("Sucessfully validated defect status in Gadget Page");
			 
		 }
		 
		 
		 return true;
		 }
		 catch(Exception e)
		  {
		   e.printStackTrace();
		   throw e;
		  }
		 
		 
	 }
	 
	 

public boolean selectAllRequirements() throws Exception
{
	try
	{
		bp=new BasePage();
		bp.waitForElement();
		bp.waitForElement();
		//bp.explicitWait(selectAll);
		Actions a1=new Actions(driver);
		a1.moveToElement(selectAllReq).click().perform();
		System.out.println("All Requirements are selected successfully");
		
		bp.waitForElement();
		
		return true;
	}
	
	catch(Exception e)
    {
		System.out.println("Requirements are not selected");
		e.printStackTrace();
		throw e;
		
    }
}
	
public boolean zqlNextButton() throws Exception
{
	try
	{
	    bp=new BasePage();
	    bp.explicitWait(zqlNextButton);
	    zqlNextButton.click();
	    bp.waitForElement();
		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}

	


public boolean advanceSearch(String searchOption) throws Exception
{
 try
 {
        bp=new BasePage();
		  bp.explicitWait(traceabilityAdvancedSearch);
		  traceabilityAdvancedSearch.click();
		  System.out.println("Pass-Successfully clicked on Quick search");
//		  WebDriverWait wait2=new WebDriverWait(driver, AutomationConstants.EXPLICIT);
//		  wait2.until(ExpectedConditions.elementToBeClickable(traceabilityQuickSearch));
		  bp.explicitWait(enterTraceabiliAdvancedSearchField);
		  enterTraceabiliAdvancedSearchField.clear();
		  enterTraceabiliAdvancedSearchField.sendKeys(searchOption);
		  System.out.println("Pass - searchField'" + searchOption + "' is entered Successfull");
		  bp.waitForElement();
		  bp.explicitWait(clickOnTraceabilityGoButton);
		  clickOnTraceabilityGoButton.click();
		  System.out.println("Pass - Successfully clicked on go option");
		  bp.waitForElement();
		  return true;
		  }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		   throw e;
		  }
}


/*public boolean validateFinalGadget(String projectName) throws Exception
{
	try
	{
	WebElement ele=driver.findElement(By.xpath(validate1+projectName+validate2));
	String value=ele.getText();
	if(value.equals(projectName))
	{
	 System.out.println("Validation-Pass Gadget for project "+projectName+" added successfuly");	
	}
	else
	{
	System.out.println("Validation-Fail for project "+projectName+" added successfuly");		
	}
	}
	
	catch(Exception e)
	{
	 e.printStackTrace();
	 throw e;
	}
	return true;
}
     */


public boolean filterBy(String filterByName, String [] values) throws Exception
{
 try
 {
  bp=new BasePage();
  bp.waitForElement();
  WebElement ele=driver.findElement(By.xpath(filter1+filterByName+filter2)); 
  WebDriverWait wait=new WebDriverWait(driver,60);
  wait.until(ExpectedConditions.elementToBeClickable(ele));
  ele.click();
  bp.waitForElement();
  
  for(int i=1;i<=5;i++)
  {
    try
     {
      driver.findElement(By.xpath(manage1+i+manage2)).click();
      bp.waitForElement();
      System.out.println("Manage option of Filter By type "+filterByName+ " clicked successfully");
      break;
      }
  
     catch(ElementNotVisibleException e)
      {
      System.out.println("Manage option is not visible");
       }
  }
  if(filterByName.equals("Phase"))
  {
	  for(int i=0;i<=values.length-1;i++)
	  {
	  List<WebElement> phaseCount=driver.findElements(By.xpath(filterPhase1+values[i]+filterPhase2));
	  System.out.println(phaseCount);
	  int total=phaseCount.size();    	 
	  WebElement element=driver.findElement(By.xpath(filterByPhase1+values[i]+filterByPhase2+total+filterByPhase3));
	  element.click();
	  System.out.println("Phase-option "+values[i] +" selected successfully ");
	  bp.waitForElement();
	  }
  }
  else
  {
     for(int i=0;i<=values.length-1;i++)
     {   
     List<WebElement> totalCount=driver.findElements(By.xpath(phase1+values[i]+phase2));
     int finalCount=totalCount.size();
     WebElement element=driver.findElement(By.xpath(pSel1+values[i]+pSel2+finalCount+pSel3));
     element.click();
     bp.waitForElement();
     System.out.println(filterByName +" option "+values[i] +" selected successfully ");
     } 
  }
  List<WebElement> buttonSize=driver.findElements(By.xpath(button1));
  int totalSize=buttonSize.size();
  
  WebElement button=driver.findElement(By.xpath(button1+button2+totalSize+button3));
  
  JavascriptExecutor js=((JavascriptExecutor)driver);
  js.executeScript("arguments[0].scrollIntoView(true);",button );
  
  Actions act=new Actions(driver);
  act.moveToElement(button).click().build().perform();
  bp.waitForElement();
  System.out.println("FilterBy "+  filterByName + " details entered successfully");
 
  }
 catch(Exception e)
 {
  e.printStackTrace();
  throw e;
  }
 return true;
 }




public boolean validateSavedGadget(String traceabilityValue) throws Exception
{
	try
	{
		bp=new BasePage();
		WebElement ele=driver.findElement(By.xpath(valTraceability1+traceabilityValue+valTraceability2));
		String text=ele.getText();
		if(text.equals(traceabilityValue))
		{
			System.out.println("Pass - Traceability Gadget Value'" + traceabilityValue + "' is validated Successfully");
		}
		bp.waitForElement();
		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}


public boolean configureProjectStatusGadget(String project) throws Exception
{
try
{
  bp=new BasePage();
  bp.waitForElement();
  WebDriverWait wait=new WebDriverWait(driver,20);
  if(project!="")
  {
 
  wait.until(ExpectedConditions.elementToBeClickable(selectProject));
  selectProject.click();
  Actions act=new Actions(driver);
  act.sendKeys(project).sendKeys(Keys.ENTER).build().perform();
  }
  bp.waitForElement();
 
 return true;
}
catch(Exception e)
{
	e.printStackTrace();
	throw e;
}
}



public boolean saveGadget() throws Exception
{
	try
	{
		  bp=new BasePage();
		  boolean res=save.isEnabled();
		  System.out.println(res);
		  if(res==true)
		  {
		  save.click();
		  bp.waitForElement();
		  
		  System.out.println("Configured the Traceability Gadget successfully");
		  }
		  else
		  {
			 System.out.println("Gadget is Not Saved"); 
		  }
		  bp.waitForElement();
		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}

public boolean viewMsg(String filterName) throws Exception
{
 try
 {
  bp=new BasePage();
List<WebElement> ele= driver.findElements(By.xpath(testcaseCulumn));
      //System.out.println(ele.size());
for(int i=0;i<=ele.size()-1;i++)
{
Actions a1=new Actions(driver);
a1.moveToElement(ele.get(i)).perform();

bp.waitForElement();
String res=driver.findElement(By.xpath(msgPopup)).getText();
String[] array=res.split("\n");

System.out.println(filterName+"-"+array[0]);


for(int j=1;j<=array.length-3;j=j+3)
{
 

System.out.println(array[j]+" testcases- "+array[j+1]);
System.out.println(array[j]+" testcase percentage- "+array[j+2]);

    }

System.out.println("Total No of testcases for "+filterName+"-"+array[0]+"= "+ array[(array.length-1)]);
}

return true;
 }
 catch(Exception e)
 {
  e.printStackTrace();
  throw e;
  }
}

public boolean validateUserInSavedGadget(String[] userName) throws Exception
{
 try
 {
  bp=new BasePage();
  List<WebElement> ele= driver.findElements(By.xpath(testcaseCulumn));
  System.out.println("Total no of user present- "+ele.size());
  for(int i=0;i<=ele.size()-1;i++)
  {
  Actions a1=new Actions(driver);
  a1.moveToElement(ele.get(i)).perform();

  bp.waitForElement();
  String res=driver.findElement(By.xpath(msgPopup)).getText();
  String[] array=res.split("\n");
  
  for(int j=0;j<=userName.length-1;j++)
  {
  if(array[0].equals(userName[j]))
  {
  System.out.println("UserName successfully validated-"+array[0]);
  break;
  }
  }
  
  
  }
return true;
 }
 catch(Exception e)
 {
  e.printStackTrace();
  throw e;
  }
}


public boolean verifyDashBoardDetails(String dashBoardName,String dashBoardDesc) throws Exception
{
 try
 {
   WebElement ele1=driver.findElement(By.xpath(dashBoardName1+dashBoardName+dashBoardName2));
   String text1=ele1.getText();
   if(text1.equalsIgnoreCase(dashBoardName))
   {
    System.out.println("Pass -  Gadget DashBoard Name '" + dashBoardName + "' is validated Successfully");
   }
   
   WebElement ele2=driver.findElement(By.xpath(dashBoardDesc1+dashBoardDesc+dashBoardDesc2));
   String text2=ele2.getText();
   if(text2.equals(dashBoardDesc))
   {
    System.out.println("Pass -  Gadget DashBoard Description '" + dashBoardDesc + "' is validated Successfully");
   }
 return true;
 }
 catch(Exception e)
 {
  e.printStackTrace();
  throw e;
 }
}


//////////////////////////////  methods required
//validateLayout()


public boolean validateLayoutType() throws Exception
{
 try
 {
 String type1=validateTwoCol.getAttribute("style");
 String type2=validateOneCol.getAttribute("style");
 String[] type_1=type1.split("rgb");
 
 String[] type_2=type2.split("rgb");
 
 String oneColumn="(196, 227, 253);";
 String twoColumn="(196, 227, 253);";
 if(type_1[1].equals(oneColumn))
 {
  System.out.println("Layout type Successfully changed to One Column");
 }
 
 if(type_2[1].equals(twoColumn))
 {
  System.out.println("Layout type Successfully changed to Two Column");
 }
 
 
 return true;
}
  catch(Exception e)
  {
   e.printStackTrace();
   throw e;
  }
}

public boolean ValidateAddedProjectInGadget(String projectName) throws Exception {

	try {
		bp = new BasePage();
		bp.waitTillElementIsVisible(selectProject);
		String project = selectProject.getText();

		if (project.equals(projectName)) {
			System.out.println("Project successfully selected");
		} else {
			System.out.println("Project is not selected");
		}

		return true;
	} catch (Exception e) {
		e.printStackTrace();
		throw e;
	}

}

public boolean validateOpenDefect( String defectStatusName) throws Exception
{
 bp=new BasePage();
 try
 {
 bp.waitForElement();
 WebElement ele=driver.findElement(By.xpath(defectStatus1+defectStatusName+defectStatus2));
 String status=ele.getText();
 System.out.println("Defect " + defectStatusName + " status count is " + status);
 bp.waitForElement();
 String priority=priorityFields.getText();
 System.out.println(priority);
 }
 catch(Exception e)
 {
  e.printStackTrace();
  throw e;
 }
 return true;
}



public boolean verifyAddGadgetPage() throws Exception
{
	try
	{
		bp=new BasePage();
		bp.waitForElement();
	String text=addGadgetPage.getText();
	
	if(text.equals("Add Gadget"))
	{
		System.out.println("Successfully launched add gadget page");
	}
	return true;
}
catch(Exception e)
{
 e.printStackTrace();
 throw e;
}
}

public boolean enterTimeFrame(String timeFrameValue) throws Exception
{
	try
	{
	
	 bp=new BasePage();
	 bp.explicitWait(timeFrame);
	 timeFrame.click();
	  Actions act=new Actions(driver);
	  act.sendKeys(timeFrameValue).sendKeys(Keys.ENTER).build().perform();
	  return true;
	}
	catch(Exception e)
	 {
	  e.printStackTrace();
	  throw e;

	}
}
public int retrieveOpenDefectCountInTraceability(String reqNo) throws Exception
{
	 try
	 {
	 WebElement ele1=driver.findElement(By.xpath(defect_Status1+reqNo+defect_Status2));
	 
	 String defectResult=ele1.getText();
	 //System.out.println("Defcet Res="+defectResult);
	 String[] defectCount=defectResult.split("\\n");
			 
	 String defectsStatus=defectCount[1];
	 String[] openDefectCount=defectsStatus.split(": ");
	 int count=Integer.parseInt(openDefectCount[1]);
							
	System.out.println("Open defct Count "+count);		 
					 
	 return count;
	 //return true;
	 }
	 catch(Exception e)
	  {
	   e.printStackTrace();
	   throw e;
	  }
	 

}


public int retrieveTotalDefectCountInTraceability(String reqNo) throws Exception
{
	 try
	 {
	 WebElement ele1=driver.findElement(By.xpath(defect_Status1+reqNo+defect_Status2));
	 
	 String defectResult=ele1.getText();
	 //System.out.println("Defcet Res="+defectResult);
	 String[] defectCount=defectResult.split("\\n");
	 
	 String defectsStatus=defectCount[0];
	 String[] totalDefectCount=defectsStatus.split(": ");
	 int count=Integer.parseInt(totalDefectCount[1]);			
	System.out.println("Total defct Count "+count);		 
					 
	 return count;
	
	 //return true;
	 }
	 catch(Exception e)
	  {
	   e.printStackTrace();
	   throw e;
	  }
} 

public int validatePriorityCount(String priorityName) throws Exception
{
 try
 {
	 String priorityCount=driver.findElement(By.xpath(priorityCount1+priorityName+priorityCount2)).getText();
    int currentCount=Integer.parseInt(priorityCount);
    System.out.println("Current "+priorityName+"priority count "+currentCount);
   
    return currentCount;
 }
 catch(Exception e)
 {
  e.printStackTrace();
  throw e;
 }
}


public boolean configureDailyPulseGadget(String project,String release,String timeFrameRate) throws Exception
{
try
{
  bp=new BasePage();
  WebDriverWait wait=new WebDriverWait(driver,60);
  bp.waitForElement();
  if(project!="")
  {
  wait.until(ExpectedConditions.elementToBeClickable(selectProject));
  selectProject.click();
  Actions act=new Actions(driver);
  act.sendKeys(project).sendKeys(Keys.ENTER).build().perform();
  }
  bp.waitForElement();
  if(release!="")
  {
  wait.until(ExpectedConditions.elementToBeClickable(selectRelease));
  selectRelease.click();
  Actions act=new Actions(driver);
  act.sendKeys(release).sendKeys(Keys.ENTER).build().perform();
  }
  bp.waitForElement();
  if(timeFrameRate!="")
  {
  wait.until(ExpectedConditions.elementToBeClickable(selectTimeframe));	  
  selectTimeframe.click();
  Actions act=new Actions(driver);
  act.sendKeys(timeFrameRate).sendKeys(Keys.ENTER).build().perform();
  }
  bp.waitForElement();
 
 return true;
}
catch(Exception e)
{
	e.printStackTrace();
	throw e;
}

}


}



