package com.zephyr.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zephyr.common.LaunchBrowser;

public class DashBoardPage_POM {

	WebDriver driver = null;

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

//	@FindBy(xpath = "//a[text()='Manage Dashboards']")//Removed
//	public WebElement manageDashboards;

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

	
//	public String fields1="//span[text()='";
//	public String fields2="']";
	
	
	@FindBy(xpath ="(//zui-summary-box//span[1])[1]")
	public WebElement linkCountInGadgetPage;
	
	public String editDashBoard1="//*[text()='";
    public String editDashBoard2="']/../../../div[5]//span[1]/span";
    
	public DashBoardPage_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(LaunchBrowser.driver, this);
		

	}
	
	
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
      
}
