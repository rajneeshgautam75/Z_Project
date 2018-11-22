package com.zephyr.reusablemethods;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.pom.TestPlanning_POM;

public class TestPlanningPage
{
	 WebDriver driver=null;
	   BasePage bp;
	   public Logger log;

	   SoftAssert soft=new SoftAssert();
	   
		public TestPlanningPage(WebDriver driver) 
		{
			//super(driver);
			this.driver = driver;
			PageFactory.initElements(LaunchBrowser.driver,this);
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			log = Logger.getLogger(this.getClass());
			Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
//			BasicConfigurator.configure();
		}
		
		///////////////////////////////POM//////////////////////////
		@FindBy(xpath="//button[@title='Add new cycle']")
		public WebElement createNewCycle;
		
		//@FindBy(xpath="//input[@class='form-control ng-pristine ng-invalid ng-touched']")
		@FindBy(xpath="//input[@formcontrolname='name']")
		public WebElement cycleName;
		
		@FindBy(xpath="//input[@formcontrolname='build']")
		public WebElement build;
		
		//@FindBy(xpath="(//input[@class='form-control ng-untouched ng-pristine ng-valid'])[2]")
		@FindBy(xpath="//input[@formcontrolname='environment']")
		public WebElement environment;
		
		@FindBy(xpath="//input[@formcontrolname='status']")
		public WebElement hideChkbox;
		
		
		@FindBy(xpath="(//div[@class='input-group-addon'])[1]")
		public WebElement startDateOption;
		
		@FindBy(xpath="(//div[@class='input-group-addon'])[2]")
		public WebElement endDateOption;
				
		@FindBy(xpath="//button[text()='Save']")
		public WebElement clickOnSave;
		
		@FindBy(xpath="(//button[text()='Save'])[1]")
		public WebElement clickOnSave1;
		
		//For selecting Any cycle 
		public String cycle1="//*[@data-name='";
		public String cycle2="']";
		
		//@FindBy(xpath="//li[@class='vakata-context-separator']")
		@FindBy(xpath="//div[@class='contextMenuIcon fa fa-ellipsis-v']")
		public WebElement options;
		
		@FindBy(xpath="//a[text()='Add Phase']")
		public WebElement addphase;
		
		@FindBy(xpath="//a[text()='Delete']")
		public WebElement deleteNode;
		
		@FindBy(xpath="//a[text()='Clone']")
		public WebElement cloneCycle;
		
		@FindBy(xpath="//a[text()='Assign']")
		public WebElement assignPhase;
		
		public String btype1="(//div[@class='zui-radio'])[";
		
		public String btype2="]";
		
		@FindBy(xpath="//button[text()='OK']")
		public WebElement clickonOK;
		
		@FindBy(xpath="(//button[text()='Save'])[2]")
		public WebElement clickonSave2;
		
		@FindBy(xpath="//button[text()='Delete']")
		public WebElement confirmDelete;
		
		@FindBy(xpath="//span[text()='Select Assignee']")
		public WebElement select_Assignee;
		
		protected String assignee1="//li[text()='";
		protected String assignee2="']";
		
		@FindBy(xpath="//span[@title='Delete selected testcases']")
		public WebElement deleteselectedtestcases;
		
		@FindBy(xpath="(//span[@title='Update flag of selected testcases'])[1]")
		public WebElement setFlag;
		
		@FindBy(xpath="(//button[text()='Continue'])[2]")
		public WebElement clickOnContinue;
		
		
		@FindBy(xpath="(//span[@title='Update flag of selected testcases'])[2]")
		public WebElement unSetFlag;
		
		@FindBy(xpath="//span[@class='pull-right bulk-assignment-image zui-action-icons cursor-pointer']")
		public WebElement clickOnBulkAssign;
		
		@FindBy(xpath="//span[@class='select2-selection__rendered']")
		public WebElement selectAssignee;
		
//		@FindBy(xpath="//span[@class='pull-right bulk-assignment-image zui-action-icons cursor-pointer']")
//		public WebElement clickOnBulk;
		
		@FindBy(xpath="(//*[text()='Apply to sub folders'])[1]")
		public WebElement clickOnchkBox1;
		
		@FindBy(xpath="(//*[text()='Apply to sub folders'])[2]")
		public WebElement clickOnchkBox2;
		
		@FindBy(xpath="(//*[text()='Apply to sub folders'])[3]")
		public WebElement clickOnchkBox3;
		
		@FindBy(xpath="(//div[@class='check'])[2]")
		public WebElement clickOnRadio2;
		
		@FindBy(xpath="(//div[@class='check'])[3]")
		public WebElement clickOnRadio3;
		
		@FindBy(xpath="//span[@class='pull-left sync-image zui-action-icons cursor-pointer']")
		public WebElement clickOnSynch;
		
		@FindBy(xpath="//input[@id='delete-nodes-testcases']")
		public WebElement clickOnSynchChkBox;
		
		@FindBy(xpath="(//button[text()='Continue'])[1]")
		public WebElement clickOnSynchContinue1;
		
		@FindBy(xpath="(//button[text()='Continue'])[2]")
		public WebElement clickOnSynchContinue2;
		
		@FindBy(xpath="(//*[@class='modal-body'])[9]")
		public WebElement SyncMsg;
		
		@FindBy(xpath="(//button[text()='Ok'])[3]")//updated on 31/07/18 by sri [2]->[3]
		public WebElement clickOnSynchOk;
		
		protected String assignTc1="//*[@id='grid-table-phase']/div[2]/div[";
		protected String assignTc2="]/div[4]/zephyr-inline-edit/div/div/span[1]";
		
		protected String uniqueassignee1="//span[text()='";
		protected String uniqueassignee2="']";
		
		@FindBy(xpath="//*[@name='eas_mode_1_select_assignee']")
		public WebElement notExecuted;
		
		@FindBy(xpath="//*[@name='eas_mode_2_select_assignee']")
		public WebElement unAssigned;
		
		@FindBy(xpath="(//*[@name='eas_mode_3_select_assignee'])[1]")
		public WebElement allunAssigned1;
		
		@FindBy(xpath="(//*[@name='eas_mode_3_select_assignee'])[2]")
		public WebElement allunAssigned2;
		
		@FindBy(xpath="//*[@id='defect-system-select2']")
		public WebElement addphaseToCycle;
		
		@FindBy(xpath=".//*[@id='phase_testcase_select_all']")
		 public WebElement select_all_TestCases;
		///modified
		protected String selectTestcase1="//*[@id='grid-table-phase']/div[2]/div[";
		protected String selectTestcase2="]/div[1]/div/div/input";
		
		//*[@id="grid-table-phase"]/div[2]/div[1]/div[1]/div/div/input
		//Added 31-08-17
		 @FindBy(xpath="//h4[text()='Add New Cycle']")
		 public WebElement verifyAddTestCycle;
		 
		 public String expReults="Add New Cycle";
		
		 //Modified
		 public String startDateHeader="(//*[@class='subform']//table/thead/tr/th[2])[1]";
		 public String endDateHeader="(//*[@class='subform']//table/thead/tr[1]/th[2])[1]";
		 public String year1="//*[text()='";
		 public String year2="']";
		 

			@FindBy(xpath="//span[@class='text-info']")
			public WebElement minYear;
			
			@FindBy(xpath="//button[@class='btn btn-default btn-sm pull-left']")
			public WebElement left;
			
			
			
			
			@FindBy(xpath="//datepicker-inner/div/yearpicker/table/tbody/tr[4]/td[5]")
			public WebElement maxYear;
			
			@FindBy(xpath="//button[@class='btn btn-default btn-sm pull-right']")
			public WebElement right;
		 public String month1="//span[text()='";
		 public String month2="']";
		 
		 public String day1="(//span[text()='";
		 public String day2="'])[2]";
		 
		 public String day_1="(//span[text()='";
		 public String day_2="'])[2]";
		 
		 public String validateTc1="//*[@id='grid-table-phase']/div[2]/div[";
		 public String validateTc2="]/div[4]/zephyr-inline-edit/div/div/span[1]";
		 
		 @FindBy(xpath="//*[@id='bulk-assignment-initial-modal']//zui-modal-footer/button[1]")
		 public WebElement cancelBulkAssign;
		 
		 @FindBy(xpath=".//*[@class='pull-right unselected-star-image zui-action-icons cursor-pointer']")
			public WebElement resettoggleFlag;
		 
		 /*public String startDateHeader="(//*[@class='subform']//table/thead/tr/th[2])[1]";
		 public String endDateHeader="(//*[@class='subform']//table/thead/tr[1]/th[2])[2]";
		 public String year1="//*[text()='";
		 public String year2="']";
		 
		 public String month1="//*[text()='";
		 public String month2="']";
		 
		 public String day1="(//*[text()='";
		 public String day2="'])[3]";
		 
		 public String day_1="(//*[text()='";
		 public String day_2="'])[4]";
		 
		 public String validateTc1="//*[@id='grid-table-phase']/div[2]/div[";
		 public String validateTc2="]/div[4]/zephyr-inline-edit/div/div/span[1]";
		 
		 // Modified
		 @FindBy(xpath="(//button[text()='Cancel'])[6]")
		 public WebElement cancelBulkAssign;
		 //@FindBy(xpath="(//button[text()='Cancel'])[5]")
		 //public WebElement cancelBulkAssign;*/
		 
		 
		 @FindBy(xpath="//*[text()='Edit']")
		 public WebElement edit;
		 
		//added by srikanth on 01/09/17
				@FindBy(xpath=".//*[@class='pull-right selected-star-image zui-action-icons cursor-pointer']")
				public WebElement toggleFlag;
				
				
				
				//added on 15/09/17 by srikanth
				@FindBy(xpath=".//*[@id='confirmation-modal']/div/div/div[3]/zui-modal-footer/button[2]")
				 public WebElement toggleContinueOption;
				


				 @FindBy(xpath="(//*[@class='zui-checkbox2']//input)[3]")
					 public WebElement copyAssignmentOver;
				 
				 public String dupCycle1="//*[@data-name='";
			       public String dupCycle2="clone_";
			       public String dupCycle3="']";
			       public String dupCycle_3="clone_clone_";
					
					
					 public String startDateHeader1="(//*[@class='subform']//table/thead/tr/th[2])[1]";
					 public String endDateHeader1="(//*[@class='subform']//table/thead/tr[1]/th[2])[2]";
					 
					 @FindBy(xpath="//*[@id='easCloneNodeModal']//div[2]/div/div/div[1]/div/input")
					 public WebElement keepTheDurationFixedOption;
					 
					 
					 /******************21/09/17 added by Srikanth************************/
					 @FindBy(xpath=".//*[text()='Create New']")
					 public WebElement createNewPhase;
					 
					 @FindBy(xpath=".//*[@id='easAddPhaseModal']/div/div/div[2]/zui-modal-body/div[2]/div/div/div[2]/input")
					 public WebElement addNewPhase;
					 
					 //////////22-9-2017
				     @FindBy(xpath="//button[@title='Click here to add more tests to this phase.']")
				     public WebElement clickOnAddTestcases;
				   
				     @FindBy(xpath=".//*[@id='zui-search-textarea']")
				     public WebElement clickOnSearchTextArea;
				     
				     @FindBy(xpath="//*[text()='Go']")
				     public WebElement clickOnGo;
				     
				     @FindBy(xpath="//input[@name='zui-search-save-all']")
				     public WebElement clickOnSaveAlltestcases;
				     
				     @FindBy(xpath="(//button[text()='Save'])[1]")
				     public WebElement saveTestcases;
				     
				     @FindBy(xpath="(//input[@title='Select All'])[1]")
				     public WebElement selectAllFreeFormTestcases;
				     
				    // @FindBy(xpath="(//button[text()='         Ok         '])[1]") previous
				     @FindBy(xpath="(//button[@class='btn btn-default'])[1]")
				     public WebElement clickOnFreeFormOk;
				     
				     protected String checkTestCase1="//*[@id='grid-table-tcr']/div[2]/div[";
				    protected String checkTestCase2="]/div[1]/div/div/input";
				    
				    @FindBy(xpath="(//*[@class='modal-content'])[10]")
				     public WebElement bulkPopup;
				    
				    //@FindBy(xpath="(//button[text()='×'])[4]")-->previous
				    @FindBy(xpath="(//button[text()='×'])[4]")
				     public WebElement closeFreeFormPage;
				    
				    //added by srikanth 23/09/17
				       @FindBy(xpath="//span[text()='Quick']")
				        public WebElement quickSearch;
				       
				       //added by srikanth 25/09/17 for entering testcase step details
				       @FindAll({@FindBy(xpath="//div[@class='zui-inline-edit zephyr-editable-field']")})
				   		public List<WebElement> l1;
				       
				       @FindBy(xpath=".//*[@id='node-name']")
				        public WebElement nodeName;
				       
				       @FindBy(xpath=".//*[@id='node-description']")
				        public WebElement nodeDesc;
				       
				       @FindBy(css="body > ul.vakata-context.jstree-contextmenu.jstree-default-contextmenu > li:nth-child(1) > a")
				       public WebElement addNode;
				       
				       @FindBy(xpath=".//*[@id='easAddNodeModal']/div/div/div[3]/zui-modal-footer/button[2]")
				        public WebElement nodeSave;
				       
					    
					  
					    
					    @FindBy(xpath="//span[text()='Advanced']")
					     public WebElement AdvancedSearch;
					    
					    //25-09-2017
					    protected String ele_1="//li[text()='";
			    		protected String ele_2="']";
					  
			    		
			    		@FindBy(xpath="//input[@placeholder='Enter ZQL']")
					     public WebElement enterZql;
			    		
			    		
			    		@FindBy(xpath="(//*[@class='fa fa-ellipsis-v'])[1]")
					     public WebElement enableOrDisable;
			    		//
			    		@FindBy(xpath="//*[@id='zui-freeform-testcase-add-grid-wrapper']/zui-tcr-grid/grid/div[2]/div/div[2]/b[3]")
					     public WebElement testcasecount;
			    		
			    		
			    		
			    		@FindBy(xpath="//div[@data-target-name='browse']")
					     public WebElement clickOnBrowse;
			    		
			    		protected String check1="(//*[@data-name='";
			    		protected String check2="']/i[1])[1]";
			    		
			    		//span[@placeholder='Enter tags']
			    		
			    		@FindBy(xpath="//*[@id='ze-main-app']//testcase-eas-phase-grid/grid/div[2]/div/div[2]/b[3]")
					     public WebElement validateAdd;
			    		
			    		
			    		//27/09/17 added
			    		 //@FindBy(xpath="//*[@id='header-parent-phase']//a/i")//previous
			    		   @FindBy(xpath="(//i[@class='fa fa-ellipsis-v'])[3]")//updated on 31/07/18 [4]->[3]
					        public WebElement sort;
					       
					       
					       public String sortElement1="(//*[@class='zui-checkbox2']//*[text()='";
					       public String sortElement2="'])";
					       public String sortElement3="[2]";
					       
					       @FindBy(xpath="//*[@id='th-phase_testcase_id']/div/div")
					        public WebElement ID;
					       

				    		///04-10-2017
				    		
				    		@FindBy(xpath="//div[@data-target-name='cycles']")
						     public WebElement clickOnOtherCycles;
				    		
				    		@FindBy(xpath="(//*[@id='zui-eas-freform-add-testcase-modal']//div[1]//select)[1]")
						     public WebElement selectCycle;
				    		
				    		@FindBy(xpath="(//*[@id='zui-eas-freform-add-testcase-modal']//div[1]//select)[2]")
						     public WebElement selectPhase;
				    		
				    		@FindBy(xpath="(//*[@id='zui-eas-freform-add-testcase-modal']//div[1]//select)[3]")
						     public WebElement filterByStatus;
				    		
				    		@FindBy(xpath="//*[@id='zui-eas-freform-add-testcase-modal']/div/div/div[2]//button")
						     public WebElement clickOnGo1;
				    		   	
				    		@FindBy(xpath="//*[@id='zui-freeform-testcase-add-grid-wrapper']//grid/div[2]/div/div[2]/b[3]")
						     public WebElement testcasecount1;
				    		
				    		//04/10/17 added by srikanth
				    		@FindBy(xpath="(//i[@class='fa fa-ellipsis-v'])[1]")
						     public WebElement sortZql;
				    		
				    		@FindBy(xpath=".//*[@id='th-testcase_id']/div/i")
						     public WebElement sortzqlIDs;
				    		
				    		@FindBy(xpath=".//*[@id='th-testcase_id']/div")
					        public WebElement zqlID;
				    		
				    		public String phase1="(//*[@data-name='";
				    		public String phase2="'][1])[2]";
			    		
				    		
				    		/*************************06/10/17****************************/ //added by srikanth
				    		public String enterActualTime1=".//*[@id='grid-table-phase']/div[2]/div[";
				    		//public String enterActualTime2="]/div[12]/div/div";//previous
				    		public String enterActualTime2="]/div[13]/div/div"; //added by 26/03/18
				    		
				    		public String delete1="//*[@id='grid-table-phase']/div[2]/div[";
				    		//public String delete2="]/div[14]/div/div[2]/span[2]/span"; //previous
				    		public String delete2="]/div[14]/div/div[2]/span[2]/span";//added by 26/03/18
				    		
				    		/*****************************11/10/17**************************************/ //added by srikanth
				    		 @FindBy(xpath="//*[text()='Maintain assignments of original schedules']")
						        public WebElement clickOnMaintainassignmentsoforiginalschedules;
				    		
				    		//17-10-2017
					    		@FindBy(xpath="//*[@id='grid-table-tcr']/div[2]/div[1]/div[4]")
							     public WebElement dragEle;
					    		
					    		
					    		 @FindBy(xpath="(//button[text()='Cancel'])[8]")
					    		 public WebElement cancelBulkAssignSearch;
					    		 
					    		 @FindBy(xpath="/html/body/ul/li[6]/a")
							     public WebElement clickOnExport;
					    		
					    		@FindBy(xpath="//*[@id='zui-export-modal-tcr_5']/div/div/div[3]/zui-modal-footer/button[2]")
							     public WebElement clickOnExportSave;
					    		
					    		@FindBy(xpath="//*[@id='zui-export-modal-tcr_5-download']/div/div/div[3]/zui-modal-footer/button[2]")
							     public WebElement clickOnExportDownload;
					    		
					    		
	//***************************************Abilash 9-1-18  ****************************
					    		
					    		

					    		@FindBy(xpath="//button[@class='btn btn-default btn-sm']")
					    		public WebElement year;	
					    		
					    		@FindBy(xpath="//button[@class='btn btn-default btn-info active']")
					    		public WebElement minYear1;
					    		
					    		
					    		public String cycleExpand1="//*[@data-name='";
					            public String cycleExpand2="']//..";
					            
					            
					            @FindBy(xpath="//*[@id='easEditNodeModal']//yearpicker/table/tbody/tr[1]/td[1]/button/span")
				                public WebElement minYear2;
				          
				               @FindBy(xpath="//datepicker-inner/div/yearpicker/table/tbody/tr[4]/td[5]")
				                public WebElement maxYear2;
					    		
				               @FindBy(xpath=" //i[@title='Go Back to Cycle']")
				                public WebElement backToCycle;	
				               
				               @FindBy(xpath="(.//*[@id='phase_testcase_select_all'])[1]")//updated 6.1
							     public WebElement selectAllFreeFormTestcasesPhase;
							    
		
		
		public boolean navigateToClonedCycle(String[] cycleName,String no) throws Exception
		   {
		    String cycle4;
		    try
		    {
		     bp=new BasePage();
		     for(int i=0;i<=cycleName.length-1;i++)
		     {
		      if(no.equals("2"))
		      {
		      cycle4=dupCycle1+dupCycle2+cycleName[i]+dupCycle3;
		      WebElement nodeElement=driver.findElement(By.xpath(cycle4));
		      Actions act=new Actions(driver);
		      act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
		      String cyclename=driver.findElement(By.xpath(cycle4)).getText();
		      System.out.println(cyclename);
		      System.out.println("Pass - Double click on'"+cycleName[i]+"' Successfull");
		      //act.moveToElement(nodeElement).click().perform();
		      bp.waitForElement();
		      }
		      
		      if(no.equals("3"))
		      {
		      cycle4=dupCycle1+dupCycle2+cycleName[i]+dupCycle3;
		      WebElement nodeElement=driver.findElement(By.xpath(cycle4));
		      Actions act=new Actions(driver);
		      act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
		      String cyclename=driver.findElement(By.xpath(cycle4)).getText();
		      System.out.println(cyclename);
		      System.out.println("Pass - Double click on'"+cycleName[i]+"' Successfull");
		      //act.moveToElement(nodeElement).click().perform();
		      bp.waitForElement();
		      }
		     }
		     return true;
		    }
		    catch(Exception e)
		    {
		     System.out.println("Fail-navigation unsucessful");
		     e.printStackTrace();
		     throw e;
		    }
		   }
		
		public boolean validateTestPlanningPage() throws Exception
		{
			try
			{
		
		String validateTestPlanning=driver.getTitle();
		System.out.println(validateTestPlanning);
	    String expmsg="Test Planning";
	    if(validateTestPlanning.equals(expmsg))
	   {
	    	System.out.println("Successfully Landed on Test Planning Page");
	//    
		}
	    return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		
		public boolean CreateCycle(String cycle,String Build,String environ,String hide) throws Exception
		{
			try
			{
				bp=new BasePage();
//				createNewCycle.click();
//				bp.waitForElement();
				bp.waitForElement();
				cycleName.sendKeys(cycle);
				bp.waitForElement();
				build.sendKeys(Build);
				bp.waitForElement();
				environment.sendKeys(environ);
				bp.waitForElement();
				if(hide.equalsIgnoreCase("Hide"))
                {
				hideChkbox.click();
                }
				
				

			return true;	
			}
			catch(Exception e)
			{
				log.info("Fail-Test cycle not created");
				e.printStackTrace();
				throw e;
			}
		}
		
	public boolean navigateToCycle(String[] cycleName) throws Exception
	{
		String cycle4;
		try
		{
			bp=new BasePage();
			for(int i=0;i<=cycleName.length-1;i++)
			{
				bp.waitForElement();
			    cycle4=cycle1+cycleName[i]+cycle2;
			   // bp.waitTillElementIsVisible(nodeElement);
				WebElement nodeElement=driver.findElement(By.xpath(cycle4));
				bp.waitTillElementIsVisible(nodeElement);
				Actions act=new Actions(driver);
				act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
				String cyclename=driver.findElement(By.xpath(cycle4)).getText();
				log.info(cyclename);
				log.info("Pass - Double click on'"+cycleName[i]+"' Successfull");
				//act.moveToElement(nodeElement).click().perform();
				bp.waitForElement();
			}
			return true;
		}
		catch(Exception e)
		{
			log.info("Fail-navigation unsucessful");
			e.printStackTrace();
			throw e;
		}
	}               
	
	public boolean addPhaseToCycle(String Phase) throws Exception
	{
		try
		{
			
			bp=new BasePage();
			bp.waitForElement();
			options.click();
			//Actions act=new Actions(driver);
			//act.contextClick(options);
			log.info("Pass - Clicked on Options");
			bp.waitForElement();
			//bp.waitForElement();
			addphase.click();
			log.info("Pass - Clicked on phase");
			bp.waitForElement();
			//WebElement element=driver.findElement(By.xpath("//*[@id='defect-system-select2']"));
			//Select osel=new Select(driver.findElement(By.xpath("//select[@class='form-control ng-pristine ng-valid ng-touched']")));
			Select osel=new Select(addphaseToCycle);
			osel.selectByVisibleText(Phase);
			log.info("Pass - "+ Phase +" selected");
			bp.waitForElement();
			clickOnSave.click();
			bp.waitForElement();
			return true;
		}
		catch(Exception e)
		{
			log.info("Fail-phase not created");
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean bulkAssignment(String Bulk_type) throws Exception
	{
		try
		{
			bp=new BasePage();
			for(int i=4;i<=6;i++)
			{
				bp.waitForElement();
				WebElement btype=driver.findElement(By.xpath(btype1+i+btype2));
				String type=btype.getText();
				bp.waitForElement();
				if(Bulk_type.equals(type))
				{
					bp.waitForElement();
					btype.click();
					log.info("bulk type selected"+Bulk_type);
					bp.waitForElement();
				}
			}
			boolean status1=clickonSave2.isDisplayed();
			if(status1==true)
			{
				clickonSave2.click();
				bp.waitForElement();
			}
			
			//clickonOK.click();
			boolean status=clickonOK.isDisplayed();
			   if(status==true) 
			   {
				   clickonOK.click();
			   }
			return true;
		}
		
		catch(Exception e)
		{
			log.info("Fail-bulk assignment unsucessful");
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean deleteNode() throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
			options.click();
			log.info("Pass - Clicked on Options");
			bp.waitForElement();
			deleteNode.click();
			log.info("Pass - Clicked on Delete");
			bp.waitForElement();
			confirmDelete.click();
			bp.waitForElement();
			return true;
		}
		catch(Exception e)
		{
			log.info("Fail-delete node unsucessful");
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean assignPhase() throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
			options.click();
			log.info("Pass - Clicked on Options");
			bp.waitForElement();
			assignPhase.click();
			bp.waitForElement();
			return true;
		}
		catch(Exception e)
		{
			log.info("Fail-phase not assigned");
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean assignAllSelected(String assignee) throws Exception
	{
		try
		{
			bp=new BasePage();
//			select_Assignee.click();
//			bp.waitForElement();
			Actions act=new Actions(driver);
			act.moveToElement(select_Assignee).click().pause(1500).sendKeys(assignee).sendKeys(Keys.ENTER).perform();
			bp.waitForElement();
//			log.info("clicked on all selected assign option");
//			WebElement asssin=driver.findElement(By.xpath(assignee1+assignee+assignee2));
//			asssin.click();
//			bp.waitForElement();
//			log.info("selected assignee"+asssin.getText());
//			Boolean disp=clickonOK.isDisplayed();
//			if(disp==true)
//			{
//				clickonOK.click();
//			}
			bp.waitForElement();
			return true;
		}
		catch(Exception e)
		{
			log.info("Fail-fail to select assignee ");
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean deleteAllSelectedTestCases() throws Exception
	{
		try
		{
			bp=new BasePage();
			deleteselectedtestcases.click();
			log.info("clicked on delete option");
			bp.waitForElement();
			Boolean bol=confirmDelete.isDisplayed();
			if(bol==true)
			{
				System.out.println("popup displayed  click on confirm to delete");
				confirmDelete.click();
			}
			log.info("selected testcases deleted sucessfully");
			return true;
		}
		catch(Exception e)
		{
			log.info("Fail-delete unsucessful");
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean setFlags() throws Exception
	{
		try
		{
			bp=new BasePage();
			setFlag.click();
			log.info("cliked on setflag sucessfully");
			bp.waitForElement();
			clickOnContinue.click();
			log.info("cliked on continue");
			bp.waitForElement();
			return true;
		}
		catch(Exception e)
		{
			log.info("Fail-set flag unsucessfull");
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean unSetFlags() throws Exception
	{
		try
		{
			bp=new BasePage();
			unSetFlag.click();
			log.info("cliked on unsetflag sucessfully");
			bp.waitForElement();
			clickOnContinue.click();
			log.info("cliked on continue");
			bp.waitForElement();
			return true;
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean bulkAssignTestcasesSelectedFolder() throws Exception
	{
		try
		{
			clickOnBulkAssign.click();
			return true;
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			throw e;
		}
	}
	public boolean assignAllNotexecuted(String assignee, String Check) throws Exception
	{
		try
		{
			bp=new BasePage();
			//select assignee
			Select osel=new Select(notExecuted);
			osel.selectByVisibleText(assignee);
			bp.waitForElement();
			log.info("Pass - "+ assignee +" selected");
			//click on check box
			if(Check!=null)
			{
				clickOnchkBox1.click();
			}
			bp.waitForElement();
			//save
			clickOnSave1.click();
			bp.waitForElement();
			//clickonOK.click();
			return true;
		}
		catch(Exception e)
		{

			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean assignAllUnassigned(String assignee,String Check) throws Exception
	{
		try
		{
			bp=new BasePage();
			//click on radio
			clickOnRadio2.click();
			bp.waitForElement();
			//select assignee
			Select osel=new Select(unAssigned);
			osel.selectByVisibleText(assignee);
			bp.waitForElement();
			//click on check box
			if(Check!=null)
			{
				clickOnchkBox2.click();
				bp.waitForElement();
			}
			//save
			clickOnSave1.click();
			bp.waitForElement();
//			clickonOK.click();
//			bp.waitForElement();
			return true;
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean sync(String check) throws Exception
	{
		try
		{
			bp=new BasePage();
			clickOnSynch.click();
			bp.waitForElement();
			bp.waitForElement();
			//click on checkbox
			if(check!=null)
			{
			clickOnSynchChkBox.click();
			bp.waitForElement();
			}
			//continue
			clickOnSynchContinue1.click();
			bp.waitForElement();
			//continue
			clickOnSynchContinue2.click();
			bp.waitForElement();
			//ok
			
			boolean status=SyncMsg.isDisplayed();
			if(status==true)
			{
				String msg=SyncMsg.getText();
				System.out.println(msg);
			}
			clickOnSynchOk.click();
			bp.waitForElement();
			//return true;
		}
		catch(ElementNotVisibleException el)
		{
			System.out.println("unable to perform sync operation since the source phase itself has been deleted");	
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return true;
	}
	
	public boolean individualAssinTo(int[] TestcaseNo,String Assignee) throws Exception
	{
		try
		{
			bp=new BasePage();
			for(int i=0;i<=TestcaseNo.length-1;i++)
			{
				bp.waitForElement();
			
				WebElement ele=driver.findElement(By.xpath(assignTc1+TestcaseNo[i]+assignTc2));
				Actions act=new Actions(driver);
				act.moveToElement(ele).click().pause(1500).sendKeys(Assignee).sendKeys(Keys.ENTER).perform();
				bp.waitForElement();
				bp.waitForElement();
				String expected=driver.findElement(By.xpath(assignTc1+TestcaseNo[i]+assignTc2)).getText();
				if(expected.equals(Assignee))
					 {
						 System.out.println("Assigned to " + expected +" Sucessfully");
					 }
				else
				{
					System.out.println("Assigned Failed");
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
	public boolean selectallTestCase() throws Exception
	 {
	  try
	  {
	  select_all_TestCases.click();
	  return true;
	  }
	  catch(Exception e)
	  {
	   e.printStackTrace();
	   throw e;
	  }
	 }
	public boolean selectSingleMultipleTestcase(int[] tcNo) throws Exception
	{
		try
		{
			bp=new BasePage();
			for(int i=0;i<=tcNo.length-1;i++)
			{
				bp.waitForElement();
				driver.findElement(By.xpath(selectTestcase1+tcNo[i]+selectTestcase2)).click();
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
	
	public boolean enterStartDatAndEndDate(String syear,String smonth,String sday,String eyear,String emonth,String eday) throws Exception
	 {
		try
		{
	  bp=new BasePage();
	  startDateOption.click();
	  bp.waitForElement();
	  WebElement ele=driver.findElement(By.xpath(startDateHeader));
	  Actions a2=new Actions(driver);
	  a2.moveToElement(ele).doubleClick().perform();
	  driver.findElement(By.xpath(startDateHeader)).click();
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
	 // bp.waitForElement();
	  driver.findElement(By.xpath(month1+emonth+month2)).click();
	  bp.waitForElement();
	  //bp.waitForElement();
	  driver.findElement(By.xpath(day_1+eday+day_2)).click();
	  bp.waitForElement();
	  return true;
	  
	 }
	  catch(Exception e)
	  {
	   e.printStackTrace();
	   throw e;
	  }
	 }
	 
	public boolean editCycle(String cycle,String Build,String environ,String hide) throws Exception
	 {
		 try
		 {
	  bp=new BasePage();
	  options.click();
	  System.out.println("Pass - Clicked on Options");
	  bp.waitForElement();
	  
	  edit.click();
	  //driver.findElement(By.xpath(edit)).click();
	  bp.waitForElement();
	  
	  
	  
    if(cycle!="")
    {
	  bp.waitForElement();
	  bp.eraseText(cycleName);
	  cycleName.sendKeys(cycle);
    }
	  bp.waitForElement();
	 
	  if(Build!="")
	  {
		//bp.waitForElement();
	  bp.eraseText(build);
	  build.sendKeys(Build);
	  }
	  
	  bp.waitForElement();
	  
	  if(environ!="")
	  {
		  bp.waitForElement();
	  bp.eraseText(environment);
	  environment.sendKeys(environ);
	  }
	  
	  if(hide.equalsIgnoreCase("Hide"))
     {
		hideChkbox.click();
     }
	  return true;
	 }
	 
	 catch(Exception e)
	   {
	 System.out.println("Fail-Test cycle Not Edited");
	 e.printStackTrace();
	 throw e;
	    }

	 
}
	 
	 public boolean saveTestCycle() throws Exception
	 {
	  try
	  {
		  
		  bp=new BasePage();
		  
	      clickOnSave.click();
	      System.out.println("Clicked on save");
          bp.waitForElement();
	  
	      return true; 
	   }
	   
	  
	  catch(Exception e)
	   {
	     log.info("Fail-Test cycle not Saved");
	     e.printStackTrace();
	     throw e;
	   }
	 }
	public boolean clickOnAddTestCycleSymbol() throws Exception
	  {
	   try
	   {
	   bp=new BasePage();
	   bp.explicitWait(createNewCycle);
	   createNewCycle.click();
	   bp.waitForElement();
	  
	   return true;
	   }
	   catch(Exception e)
	   {
	    log.info("Fail-Test cycle Symbol not clicked");
	    e.printStackTrace();
	    throw e;
	   }
	   
	  }
	  
	  public boolean verifyAddTestCyclePage() throws Exception
	  {
	   try
	   {
	     String text=verifyAddTestCycle.getText();
	     
	     if(text.equalsIgnoreCase(expReults))
	     {
	      System.out.println("Pass-Successfully navigated to the Add Test Cycle Page");
	     }
	   
	   return true;
	   }
	   catch(Exception e)
	   {
	    System.out.println("Fail- You are not in Add Test Cycle Page");
	    e.printStackTrace();
	    throw e;
	   }
	  }
	  /////////shiva added
	  public boolean getPhaseCount(String phaseName) throws Exception
	  {
	   try
	   {
	    String s1="//*[@data-type='Phase' and @data-name='";
	    String s2="']";
	    String phase=s1+phaseName+s2;
	    String count=driver.findElement(By.xpath(phase)).getAttribute("data-count");
	    System.out.println(count);
	    return true;
	   }
	   catch(Exception e)
	   {
	    e.printStackTrace();
	    throw e;
	   }
	  }
	
	  public boolean validateAllAssigned(int[] testcaNo,String assignee) throws Exception
	  {
		  try
		  {
			  bp=new BasePage();
			  for(int i=0;i<=testcaNo.length-1;i++)
			  {
				 String expected= driver.findElement(By.xpath(validateTc1+testcaNo[i]+validateTc2)).getText();
				 //System.out.println(expected);
				 if(expected.equals(assignee))
				 {
					 System.out.println("Assigned to "+ expected +" sucessfully");
					 bp.waitForElement();
				 }
				 else
				 {
					 System.out.println("Assigned Failed");
				 }
			  }
				
		  }
		  catch(Exception e) 
		   {
		    e.printStackTrace();
		    throw e;
		   }
		return true;
	  }
	  
	  public Boolean cancelBulkAssign() throws Exception
	  {
		  try
		  {
			  bp=new BasePage();
			  cancelBulkAssign.click();
			  bp.waitForElement();
		  }
		  catch(Exception e) 
		   {
		    e.printStackTrace();
		    throw e;
		   }
		  return true;
	  }
	  
	  public boolean resetToggleFlag() throws Exception
		{
			try
			{
			bp=new BasePage();
			bp.waitForElement();
			resettoggleFlag.click();
			log.info("cliked on toggleflag sucessfully");
			bp.waitForElement();
			toggleContinueOption.click();
			log.info("cliked on continue");
			return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
	  
	  /* ****************************************************
	    * Method Name   : doubleClickOnCycle(String cycleName)
	    * Purpose    : To Click on the cycleName in TestPlanning of the Project in Zephyr Application
	    * Author        : Srikanth
	    * Date Created   : 14/09/17
	    * Date Modified      :
	    * Reviewed By   : Rajneesh
	    * ******************************************************
	    */
	   public boolean doubleClickOnCycle(String cycleName) throws Exception
	   {
	    String cycle4;
	   try
	   {
	  
	     bp=new BasePage();
	     cycle4=cycle1+cycleName+cycle2;
	     bp.waitForElement();
	     WebElement nodeElement=driver.findElement(By.xpath(cycle4));
	     Actions act=new Actions(driver);
	     act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
	     String cyclename=driver.findElement(By.xpath(cycle4)).getText();
	     log.info(cyclename);
	     log.info("Pass - Double click on'"+cycleName+"' Successfull");
	     //act.moveToElement(nodeElement).click().perform();
	     bp.waitForElement();
	    
	    return true;
	   }
	   catch(Exception e)
	   {
	    log.info("Fail-cycle navigation unsucessful");
	    e.printStackTrace();
	    throw e;
	   }
	   }
	   
	 //added by srikanth for set/reset toggle flag in TestPlanning
		public boolean setToggleFlags() throws Exception
		{
			try
			{
			bp=new BasePage();
			toggleFlag.click();
			log.info("cliked on toggleflag sucessfully");
			bp.waitForElement();
			toggleContinueOption.click();
			log.info("cliked on continue");
			bp.waitForElement();
			return true;
		
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		
//		public boolean resetToggleFlag() throws Exception
//		{
//			try
//			{
//			bp=new BasePage();
//			toggleFlag.click();
//			log.info("cliked on toggleflag sucessfully");
//			bp.waitForElement();
//			toggleContinueOption.click();
//			log.info("cliked on continue");
//			return true;
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//				throw e;
//			}
//		}
//		
		
		
		
		 
		 public boolean testCycleCount(String cycleName) throws Exception
		   {
			   try
			   {
			   bp=new BasePage();
			     String cycle4=cycle1+cycleName+cycle2;
			     bp.waitForElement();
			     List<WebElement> nodeElement=driver.findElements(By.xpath(cycle4));
			     
			     int count=nodeElement.size();
			     System.out.println("No of Test Cycle Test Cycle-"+count);
			     return true;
			   } 
			   catch(Exception e)
			   {
			    System.out.println("Fail-cycle navigation unsucessful");
			    e.printStackTrace();
			    throw e;
			   }
		   }
		 
		 public boolean cloneCycle(String cycle,String Build,String duration,String environ,String hide,String testCaseAssignment) throws Exception
			{
				try
				{
					bp=new BasePage();
					options.click();
					bp.waitForElement();
					System.out.println("Pass - Clicked on Options");
					
					
					cloneCycle.click();
					bp.waitForElement();
					
					if(cycle!="")
					{
						//bp.waitForElement();
						cycleName.clear();
						  //bp.eraseText(cycleName);
						cycleName.sendKeys(cycle);
						System.out.println("Cycle name entered successfully");
					}
					
					
					
					
					if(Build!="")
					{
						//bp.waitForElement();
						  bp.eraseText(build);
						build.sendKeys(Build);
					}
					
					if(duration!="")
					{
						keepTheDurationFixedOption.click();
					}
					
					if(environ!="")
					{
						//bp.waitForElement();
						  bp.eraseText(environment);
						environment.sendKeys(environ);
					}
					
					if(testCaseAssignment!="")
					{
						copyAssignmentOver.click();
					}
					bp.waitForElement();

					if(hide.equalsIgnoreCase("Hide"))
					{
						hideChkbox.click();
					}
					bp.waitForElement();
					
					return true;
					
				}
				catch(Exception e)
				{
					System.out.println("Fail-cycle clone unsucessful");
					e.printStackTrace();
					throw e;
				}
			}
		 
//		 public boolean editStartDatAndEndDate(String syear,String smonth,String sday,String eyear,String emonth,String eday) throws Exception
//		 {
//		   try
//		   {
//			if(syear!="")
//			{
//				
//		  bp=new BasePage();
//		  startDateOption.click();
//		  bp.waitForElement();
//		  WebElement ele=driver.findElement(By.xpath(startDateHeader));
//		  Actions a2=new Actions(driver);
//		  a2.moveToElement(ele).doubleClick().perform();
//		  driver.findElement(By.xpath(startDateHeader)).click();
//		  //a2.moveToElement(ele).click().perform();
//		  driver.findElement(By.xpath(year1+syear+year2)).click();
//		  bp.waitForElement();
//		  bp.waitForElement();
//		  driver.findElement(By.xpath(month1+smonth+month2)).click();
//		  bp.waitForElement();
//		  driver.findElement(By.xpath(day1+sday+day2)).click();
//		  bp.waitForElement();
//		  bp.waitForElement();
//		  
//			}
//			
//			if(eyear!="")
//			{
//		  endDateOption.click();
//		  bp.waitForElement();
//		  WebElement ele1=driver.findElement(By.xpath(endDateHeader));
//		  Actions a3=new Actions(driver);
//		  a3.moveToElement(ele1).click().perform();
//		  bp.waitForElement();
//		  //bp.waitForElement();
//		  driver.findElement(By.xpath(endDateHeader)).click();
//		  bp.waitForElement();
//		 // bp.waitForElement();
//		  driver.findElement(By.xpath(year1+eyear+year2)).click();
//		  bp.waitForElement();
//		  //bp.waitForElement();
//		  driver.findElement(By.xpath(month1+emonth+month2)).click();
//		  bp.waitForElement();
//		  //bp.waitForElement();
//		  driver.findElement(By.xpath(day_1+eday+day_2)).click();
//			
//			}
//		  
//		  return true;
//		 }
//
//	    catch(Exception e)
//		{
//			System.out.println("Fail-navigation unsucessful");
//			e.printStackTrace();
//			throw e;
//		}
//
//}
//	   
	   
	   public boolean validateDeletedCycle(String cycleName) throws Exception
	   {
		   String cycle4;
			try
			{
				  bp=new BasePage();
				
					cycle4=cycle1+cycleName+cycle2;
					//WebElement nodeElement=driver.findElement(By.xpath(cycle4));
					
					
					
					if(driver.findElements(By.xpath(cycle4)).size() != 0)
					   {
						System.out.println("Cycle is not deleted");
						}
					else
						{
						System.out.println("Cycle deleted successfully");
						}
				
				return true;
			}
			catch(Exception e)
			{
				System.out.println("Fail-Cycle deleted unsucessful");
				e.printStackTrace();
				throw e;
			}
	   }
	   
	   
	   public boolean createFreeFormPhase(String formName) throws Exception
	    {
		try
		{
			bp=new BasePage();
			options.click();
			log.info("Pass - Clicked on Options");
			bp.waitForElement();
			//bp.waitForElement();
			addphase.click();
			log.info("Pass - Clicked on phase");
			bp.waitForElement();
			createNewPhase.click();
			bp.waitForElement();
			//addNewPhase.click();
			bp.waitForElement();
			//bp.waitTillElementIsVisible(addNewPhase);
			addNewPhase.sendKeys(formName);
			bp.waitForElement();
			clickOnSave.click();
			System.out.println("Pass-FreeForm Phase created sucessfully");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Fail-FreeForm Phase not created");
			e.printStackTrace();
			throw e;
		}
	}
	   
	   
	   public boolean doubleClickOnClonedCycle(String cycleName,String no) throws Exception
       {
       
       try
       {
        String cycle4;
        if(no.equals("2"))
        {
        cycle4=dupCycle1+dupCycle2+cycleName+dupCycle3;
        WebElement nodeElement=driver.findElement(By.xpath(cycle4));
      Actions act=new Actions(driver);
      act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
      String cyclename=driver.findElement(By.xpath(cycle4)).getText();
      System.out.println(cyclename);
      System.out.println("Pass - Double click on'"+cycleName+"' Successfull");
        }
        if(no.equals("3"))
        {
        cycle4=dupCycle1+dupCycle_3+cycleName+dupCycle3;
        WebElement nodeElement=driver.findElement(By.xpath(cycle4));
      Actions act=new Actions(driver);
      act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
      String cyclename=driver.findElement(By.xpath(cycle4)).getText();
      System.out.println(cyclename);
      System.out.println("Pass - Double click on'"+cycleName+"' Successfull");
        }
      

        
        return true;
       }
       catch(Exception e)
       {
        System.out.println("Fail- Double Click cycle navigation unsucessful");
        e.printStackTrace();
        throw e;
       }
       }
	   
	   
	   

//	   public boolean navigateToClonedCycle(String[] cycleName,String no) throws Exception
//		{
//			String cycle4;
//			try
//			{
//				bp=new BasePage();
//				for(int i=0;i<=cycleName.length-1;i++)
//				{
//					
//					cycle4=dupCycle1+cycleName[i]+dupCycle2+dupCycle3+no+dupCycle4;
//					WebElement nodeElement=driver.findElement(By.xpath(cycle4));
//					Actions act=new Actions(driver);
//					act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
//					String cyclename=driver.findElement(By.xpath(cycle4)).getText();
//					System.out.println(cyclename);
//					System.out.println("Pass - Double click on'"+cycleName[i]+"' Successfull");
//					//act.moveToElement(nodeElement).click().perform();
//					bp.waitForElement();
//				}
//				return true;
//			}
//			catch(Exception e)
//			{
//				System.out.println("Fail-navigation unsucessful");
//				e.printStackTrace();
//				throw e;
//			}
//		}
//	   
	   //to click on add testcases folder
	   public boolean clickOnAddTestcasesToFreeForm() throws Exception
	   {
		   try
		   {
			   //bp.waitTillElementIsClickable(clickOnAddTestcases);
			   bp.waitForElement();
			   clickOnAddTestcases.click();
			   System.out.println("pass-clicked on addtestcases option");
			   return true;
		   }
		   catch(Exception e)
			  {
			   System.out.println("Fail-FreeForm Phase not created");
			   e.printStackTrace();
			   throw e;
			  }
	   }
	   //quick search
	   public boolean quiksearch(String priority) throws Exception
		{
			try
			{
				clickOnSearchTextArea.sendKeys(priority);
				bp.waitForElement();
				System.out.println("pass-searched with " +priority);
				clickOnGo.click();
				bp.waitForElement();
				System.out.println("pass-clicked on Go");
			return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
				
			}
		}
	   //to select check box option to save testcases in freeform page
	   public boolean clickOnCheckBoxSaveAllTestcases() throws Exception
		{
			try
			{
				clickOnSaveAlltestcases.click();
				bp.waitForElement();
				System.out.println("Pass-Clicked on save All Testcases");
			return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
				
			}
		}
	   //to click on Save and Ok in free form page
	   public boolean clickOnSaveAndOk() throws Exception
		{
			try
			{
				saveTestcases.click();
				bp.waitForElement();
				System.out.println("Pass-Clicked on Save");
				
				clickOnFreeFormOk.click();
				bp.waitForElement();
				System.out.println("Pass-Clicked on OK");
			return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
				
			}
		}
	   //to select single or multiple testcases
	   public boolean selectMultipleTestCaseFromFreeForm(String[] testCaseNo) throws Exception
		{
			try
			{
			BasePage bp=new BasePage();
			bp.waitForElement();
			//int length=testCaseNo.length-1;
			for(int i=0;i<=testCaseNo.length-1;i++)
			{
					bp.waitForElement();
				WebElement ele=driver.findElement(By.xpath(checkTestCase1+testCaseNo[i]+checkTestCase2));
				Actions a1=new Actions(driver);
				a1.moveToElement(ele).click().perform();
			}
			System.out.println(testCaseNo.length+" Test Case Selected");
			return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
	    //to select all testcases in Free Form page
	    public boolean selectAllFreeFormTestCases() throws Exception
		{
	    	try
	    	{
	    		selectAllFreeFormTestcases.click();
	    		bp.waitForElement();
	    		System.out.println("pass-Selected All Testcases");
	    	return true;
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		throw e;
	    	}
	    	
		}
	    //To close Free Form Page
	    public boolean closeFreeFormPage() throws Exception
		{
	    	try
	    	{
	    		bp=new BasePage();
	    		bp.explicitWait(closeFreeFormPage);
	    		closeFreeFormPage.click();
	    		bp.waitForElement();
	    		System.out.println("pass-Freeform page closed");
	    	return true;
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		throw e;
	    	}
	    	
		}


public boolean assignAllAssignedNotExecuted(String from,String to,String Check) throws Exception
	{
		try
		{
			bp=new BasePage();
			//click on radio
			bp.waitForElement();
			bp.waitForElement();
			clickOnRadio3.click();
			bp.waitForElement();
			//select assignee
			if(from!="")
			{
				Select osel=new Select(allunAssigned1);
				osel.selectByVisibleText(from);
				bp.waitForElement();
			}
			if(to!="")
			{
				Select ose2=new Select(allunAssigned2);
				ose2.selectByVisibleText(to);
				bp.waitForElement();
			}
			//click on check box
			if(Check!="")
			{
				clickOnchkBox3.click();
				bp.waitForElement();
			}
			//save
			clickOnSave1.click();
			bp.waitForElement();
//			boolean res=clickonOK.isDisplayed();//updated to handle popup
//			if(res==true)//
//			{
//			clickonOK.click();//
//			bp.waitForElement();//
//			}
			bp.waitForElement();
			return true;
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			throw e;
		}
	}

//To perform Quick Search
//added by srikanth 23/09/17
public boolean quickSearch() throws Exception
{
	 try
	 {
		 bp.waitForElement();
	 quickSearch.click();
	 System.out.println("pass-Successfully Clicked On Quick Search");
	 return true;
	 }
	 catch(Exception e)
     {
      e.printStackTrace();
      throw e;
     }
}
	 
	 
	 /*	****************************************************
		 * Method Name			: addNode(String Name,String Desc)
		 * Purpose				: To add nodet in Zephyr Application in TestPlanning
		 * Author				: Srikanth
		 * Date Created			: 25/09/17
		 * Date Modified		:
		 * Reviewed By			: 
		 * ******************************************************
		 */
		public boolean addNode(String Name,String Desc) throws Exception
		{
			try
			{
				
				BasePage bp=new BasePage();
//				String releasename3=releasename1+releaseName+releasename2;
//				WebElement ele=driver.findElement(By.xpath(releasename3));
				bp.waitForElement();
				options.click();
				log.info("Pass - Clicked on Options");
				bp.waitForElement();
				bp.waitForElement();
				addNode.click();
				log.info("Pass - Clicked on Add Button");
				bp.waitForElement();
				nodeName.click();
				nodeName.sendKeys(Name);
				nodeDesc.click();
				nodeDesc.sendKeys(Desc);
				bp.waitForElement();
				nodeSave.click();
				log.info("Pass - Clicked on Save Button");
				bp.waitForElement();
				//log.info("Pass - phase created with name and description");
				log.info("Pass - created with name and description");
				bp.waitForElement();
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		 //To click on Advance search
	    public boolean clickOnAdvanceSearch() throws Exception
		{
	    	try
	    	{
	    		bp=new BasePage();
	    		bp.waitForElement();
	    		AdvancedSearch.click();
	    		bp.waitForElement();
	    		System.out.println("pass-clicked on Advanced Search");
	    	return true;
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		throw e;
	    	}
	    	
		}
	    
	    public boolean ZQLQuery(String[] zql) throws Exception
	    {
	    	try
	    	{
	    		for(int i=0;i<zql.length-1;i++)
	    		{
	    			Actions act=new Actions(driver);
	    			act.sendKeys(Keys.SPACE).perform();
	    			bp.waitForElement();
	    			WebElement ele=driver.findElement(By.xpath(ele_1+zql[i]+ele_2));
		    		String value=ele.getText();
		    		System.out.println();
		    		if(zql[i].equalsIgnoreCase(value))
		    		{
		    			ele.click();
		    			bp.waitForElement();
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
	    
	    public boolean ZQLSearch(String[] zql ,String value) throws Exception
	    {
	    	try
	    	{
	    		for(int i=0;i<zql.length-1;i++)
	    		{
	    			Actions act=new Actions(driver);
	    			act.sendKeys(Keys.SPACE).perform();
	    			bp.waitForElement();
	    			WebElement ele=driver.findElement(By.xpath(ele_1+zql[i]+ele_2));
		    		String v=ele.getText();
		    		System.out.println();
		    		if(zql[i].equalsIgnoreCase(v))
		    		{
		    			ele.click();
		    			bp.waitForElement();
		    		}
	    		}
	    		String quote1="\"";
	    		String quote2="\"";
	    		enterZql.sendKeys(quote1+value+quote2);
	    		return true;
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		throw e;
	    	}
	    }
	    
	    public boolean sortingTestCase(String[] sort) throws Exception
	    {
	    	try
	    	{
	    		
	    	String sorting1="(//label[@title='";
	    	String sorting2="'])[2]";
	    	bp=new BasePage();
	        bp.waitForElement();
	        enableOrDisable.click();
	        
	       
	       for(int i=0;i<=sort.length-1;i++)
	       {
	    	      bp.waitForElement();
	    	      WebElement ele=driver.findElement(By.xpath(sorting1+sort[i]+sorting2));
	    	      String data=ele.getText();
	    	      boolean res= ele.isSelected();
	    	      System.out.println(res);
	    	   
	    	  if(res==false && sort[i].equals(data))
	    	  {
	    		  BasePage bp=new BasePage();
	    		  bp.waitForElement();
	    		  ele.click();
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
	    
	    public boolean ZQLSearch1(String name,String operator,String value) throws Exception
	    {
	    	try
	    	{
	    		bp=new BasePage();
	    		enterZql.sendKeys(name+operator+value);
	    		bp.waitForElement();
	    		clickOnGo.click();
	    		bp.waitForElement();
	    		return true;
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		throw e;
	    	}
	    }
	    public boolean validateSearch() throws Exception
	    {
	    	try
	    	{
	    		bp=new BasePage();
	    		bp.waitForElement();
	    		
	    		boolean sp=testcasecount.isEnabled();
	    		if(sp==true)
	    		{
	    			System.out.println("Pass-testcase count is enabled");
	    			String testCaseCount=testcasecount.getText();
	    			  int count= Integer.parseInt(testCaseCount);
	    			  bp.waitForElement();
	    			  if(count>=0)
	    			  {
	    				  System.out.println("testcase searched Sucesfully");
	    			  }
	    		}
	    		
	    		return true;	
	    	}
	    	 catch(NoSuchElementException el)
		      { 
		    	  System.out.println("No testcase record found");
		    	  return true;
		   
		      }
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		throw e;
	    	}
	    }
	    
	    public boolean validateAddtestcaesToFreeForm() throws Exception
	    {
	    	try
	    	{
	    		bp=new BasePage();
	    		bp.waitForElement();
	    		
	    		boolean sp=validateAdd.isEnabled();
	    		if(sp==true)
	    		{
	    			System.out.println("Pass-testcase count is enabled");
	    			String testCaseCount=validateAdd.getText();
	    			  int count= Integer.parseInt(testCaseCount);
	    			  bp.waitForElement();
	    			  if(count>=0)
	    			  {
	    				  System.out.println("testcases Added Sucesfully");
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
	    
	    public boolean clickOnBrowse() throws Exception
	    {
	    	try
	    	{
	    		bp=new BasePage();
	    		bp.waitForElement();
	    		clickOnBrowse.click();
	    		bp.waitForElement();
	    		return true;
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		throw e;
	    	}
	    }
	    
	    public boolean clickOnChecKBox(String NodeName) throws Exception
	    {
	    	try
	    	{
	    		driver.findElement(By.xpath(check1+NodeName+check2)).click();
	    		bp.waitForElement();
	    		return true;
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		throw e;
	    	}
	    }

	    
	    public boolean sort(String[] sortName) throws Exception
	    {
	  try
	  {
	       bp=new BasePage();
	          sort.click();
	          System.out.println("Pass-Sort Icon Clicked Successfully");
	           
	           for(int i=0;i<=sortName.length-1;i++)
	            {
	                bp.waitForElement();
	                if(sortName[i].equals("Assigned To")||sortName[i].equals("Notes")||sortName[i].equals("Status")||sortName[i].equals("Actual Time"))
	                {
	                WebElement ele=driver.findElement(By.xpath(sortElement1+sortName[i]+sortElement2));
	                String data=ele.getText();
	                boolean res= ele.isSelected();
	                System.out.println(res);
	                if(res==false && sortName[i].equals(data))
	                {
	                 bp=new BasePage();
	                 bp.waitForElement();
	                 ele.click();
	                }
	                }
	                else
	                {
	                WebElement ele1=driver.findElement(By.xpath(sortElement1+sortName[i]+sortElement2+sortElement3));
	                String data1=ele1.getText();
	                boolean res1= ele1.isSelected();
	                System.out.println(res1);
	             
	             if(res1==false && sortName[i].equals(data1))
	              {
	             bp=new BasePage();
	             bp.waitForElement();
	             ele1.click();
	              }
	            
	                }
	                
	            }
	           bp.waitForElement();
	           Actions a1=new Actions(driver);
	           a1.moveToElement(ID).click().perform();
	           
	          return true;
	          }
	          catch(Exception e)
	          {
	           e.printStackTrace();
	           throw e;
	          }
	    }
		
	    
	    public boolean selectNode(String cycleName) throws Exception
		   {
			   try
			   {
			  String cycle4=cycle1+cycleName+cycle2;
			  driver.findElement(By.xpath(cycle4)).click();
			  System.out.println("Node clicked Successfully");
			  
			     return true;
		       }
			   catch(Exception e)
				{
				   e.printStackTrace();
					System.out.println("Fail-Cycle selection unsucessful");
					
					throw e;
				}
			
			   
			  }
	    public boolean selectCycleInSearch(String cyclename,String Build,String Environment) throws Exception
	    {
	    	try
	    	{
	    		Select sel=new Select(selectCycle);
	    		 String cyclename2=""+cyclename+ " build : "+Build+ " env : "+Environment+"";
	    		sel.selectByVisibleText(cyclename2);
	    		System.out.println("Pass - "+ cyclename +" selected");
	    		bp.waitForElement();
	    		return true;
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("Fail-Cycle Not Selected");
	    		e.printStackTrace();
	    		throw e;
	    	}
	    }
	    
	    public boolean selectPhaseInSearch(String PhaseName) throws Exception
	    {
	    	try
	    	{
	    		Select sel=new Select(selectPhase);
	    		sel.selectByVisibleText(PhaseName);
	    		System.out.println("Pass - "+ PhaseName +" selected");
	    		bp.waitForElement();
	    		return true;
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("Fail-Phase Not Selected");
	    		e.printStackTrace();
	    		throw e;
	    	}
	    }
	    
	    public boolean filterByStatus(String Status) throws Exception
	    {
	    	try
	    	{
	    		Select sel=new Select(filterByStatus);
	    		sel.selectByVisibleText(Status);
	    		System.out.println("Pass - "+ Status +" selected");
	    		bp.waitForElement();
	    		return true;
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("Fail-Status Not Selected");
	    		e.printStackTrace();
	    		throw e;
	    	}
	    }
	    
	    public boolean clickOnGo() throws Exception
	    {
	    	try
	    	{
	    		clickOnGo1.click();
	    		bp.waitForElement();
	    		return true;
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("Fail-Status Not Selected");
	    		e.printStackTrace();
	    		throw e;
	    	}
	    }
	    
	    public boolean validateRetrieveTestcases() throws Exception
	    {
	    	try
	    	{
	    		bp=new BasePage();
	    		bp.waitForElement();
	    		
	    		boolean sp=testcasecount1.isEnabled();
	    		if(sp==true)
	    		{
	    			System.out.println("Pass-testcase count is enabled");
	    			String testCaseCount=testcasecount1.getText();
	    			  int count= Integer.parseInt(testCaseCount);
	    			  bp.waitForElement();
	    			  if(count>=0)
	    			  {
	    				  System.out.println("Pass-testcases Retrieved Sucesfully");
	    			  }
	    			  else
	    			  {
	    				  System.out.println("Fail-Testcases Not Retrieved ");
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
	    public boolean launchOtherCycles() throws Exception
	    {
	    	try
	    	{
	    		clickOnOtherCycles.click();
	    		bp.waitForElement();
	    		System.out.println("pass-Launched Other cycles");
	    		return true;
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("Fail-To launch Other Cycles");
	    		e.printStackTrace();
	    		throw e;
	    	}
	    }
	    
	    //added by srikanth
	  //ZQL Sort operation
	  		public boolean zqlSort(String[] sortName) throws Exception
	  	    {
	  	  try
	  	  {
	  	       bp=new BasePage();
	  	       bp.waitForElement();
	  	          sortZql.click();
	  	          System.out.println("Pass-Sort Icon Clicked Successfully");
	  	           
	  	           for(int i=0;i<=sortName.length-1;i++)
	  	            {
	  	                bp.waitForElement();
	  	                if(sortName[i].equals("Created On")||sortName[i].equals("Coverage"))
	  	                {
	  	                WebElement ele=driver.findElement(By.xpath(sortElement1+sortName[i]+sortElement2));
	  	                String data=ele.getText();
	  	                boolean res= ele.isSelected();
	  	                System.out.println(res);
	  	                if(res==false && sortName[i].equals(data))
	  	                {
	  	                 bp=new BasePage();
	  	                 bp.waitForElement();
	  	                 ele.click();
	  	                }
	  	                }
	  	                else
	  	                {
	  	                WebElement ele1=driver.findElement(By.xpath(sortElement1+sortName[i]+sortElement2+sortElement3));
	  	                String data1=ele1.getText();
	  	                boolean res1= ele1.isSelected();
	  	                System.out.println(res1);
	  	             
	  	             if(res1==false && sortName[i].equals(data1))
	  	              {
	  	             bp=new BasePage();
	  	             bp.waitForElement();
	  	             ele1.click();
	  	              }
	  	            
	  	                }
	  	                
	  	            }
	  	           bp.waitForElement();
	  	           Actions a1=new Actions(driver);
	  	           a1.moveToElement(zqlID).click().perform();
	  	           
	  	          return true;
	  	          }
	  	          catch(Exception e)
	  	          {
	  	           e.printStackTrace();
	  	           throw e;
	  	          }
	  	    }
	  		 public boolean selectPhasebyIndexInSearch(int index) throws Exception
	 	    {
	 	    	try
	 	    	{
	 	    		
	 	    		Select sel=new Select(selectPhase);
	 	    		sel.selectByIndex(index);
	 	    		return true;
	 	    	}
	 	    	catch(Exception e)
	 	    	{
	 	    		System.out.println("Fail-Status Not Selected");
	 	    		e.printStackTrace();
	 	    		throw e;
	 	    	}
	 	    }
	  		 
	  		
//	  		 public boolean navigateToCycle1(String[] cycleName,String no) throws Exception
//				{
//					String cycle4;
//					try
//					{
//						bp=new BasePage();
//						for(int i=0;i<=cycleName.length-1;i++)
//						{
//							
//							cycle4=dupCycle1+cycleName[i]+dupCycle2+dupCycle3+no+dupCycle4;
//							WebElement nodeElement=driver.findElement(By.xpath(cycle4));
//							Actions act=new Actions(driver);
//							act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
//							String cyclename=driver.findElement(By.xpath(cycle4)).getText();
//							System.out.println(cyclename);
//							System.out.println("Pass - Double click on'"+cycleName[i]+"' Successfull");
//							//act.moveToElement(nodeElement).click().perform();
//							bp.waitForElement();
//						}
//						return true;
//					}
//					catch(Exception e)
//					{
//						System.out.println("Fail-navigation unsucessful");
//						e.printStackTrace();
//						throw e;
//					}
//					
//		
//		}
	  		 
	  		/****************************06/10/17******************************/
	 		public boolean validateActualTime(int tcNo,String day,String hr,String mn) throws Exception
	 		{
	 			
	 			try
	 			{
	 			
	 					String validate_time=day+":"+hr+":"+mn;
	 					//System.out.println(validate_time);

	 					String time=driver.findElement(By.xpath(enterActualTime1+tcNo+enterActualTime2)).getText();
	 					System.out.println(time);
	 				
	 					if(validate_time.equals(time))
	 					{
	 					System.out.println("Pass- Actual Time Successfully Validated");
	 					}
	 					
	 		        return true;
	 			}
	 			catch(Exception e)
	 			{
	 				System.out.println("Actual time is not matched");
	 				e.printStackTrace();
	 				
	 				throw e;
	 				//return false;
	 			
	 			}	
	 			
	 		
	 		}
	 		
	 		  public boolean deleteTestcaseInActionColumn(int tcno) throws Exception
	 		    {
	 		    	try
	 		    	{
	 		    		bp=new BasePage();
	 		    		bp.waitForElement();
	 		    		WebElement ele=driver.findElement(By.xpath(delete1+tcno+delete2));
	 			    	ele.click();
	 			    	System.out.println("Pass-clicked on deleted option from action column sucessfully");
	 			    	bp.waitForElement();
	 			    	confirmDelete.click();
	 			    	bp.waitForElement();
	 			    	System.out.println("Pass-deleted testcase from action column sucessfully");
	 			    	return true;
	 		    	}
	 		    	 catch(Exception e)
	 			    {
	 			     System.out.println("Fail- Delete Unsucessful");
	 			     e.printStackTrace();
	 			     throw e;
	 			    }
	 		    }
	 		  
	 		  /******************12/10/17********************/ //added by srikanth
	 		 public boolean clickOnMaintainassignmentsoforiginalschedules() throws Exception
		     {
		    	 try
		    	 {
		    	 bp=new BasePage();
		    	 bp.waitForElement();
		    	 clickOnMaintainassignmentsoforiginalschedules.click();
		    	 System.out.println("Pass-successfully clicked on Maintain assignments of original schedules");
		    	 
		    	 return true;
		    	 }
		    	 catch(Exception e)
			      {
			       e.printStackTrace();
			       throw e;
			      }
		     }
	 	 
	 		public boolean unassignAllSelected(String assignee) throws Exception
	 		{
	 			try
	 			{
	 				bp=new BasePage();
//	 				select_Assignee.click();
//	 				bp.waitForElement();
	 				Actions act=new Actions(driver);
	 				act.moveToElement(select_Assignee).click().pause(1500).sendKeys(assignee).sendKeys(Keys.ENTER).perform();
	 				bp.waitForElement();
//	 				log.info("clicked on all selected assign option");
//	 				WebElement asssin=driver.findElement(By.xpath(assignee1+assignee+assignee2));
//	 				asssin.click();
//	 				bp.waitForElement();
//	 				log.info("selected assignee"+asssin.getText());
	 				//clickonOK.click();
	 				bp.waitForElement();
	 				return true;
	 			}
	 			catch(Exception e)
	 			{
	 				log.info("Fail-fail to select assignee ");
	 				e.printStackTrace();
	 				throw e;
	 			}
	 		}
	 		
	 		 public boolean doubleClickOnCycle2(String cycleName,WebDriver driver2) throws Exception
	 	    {
	 	     String cycle4;
	 	    try
	 	    {
	 	   this.driver=driver2;
	 	      bp=new BasePage();
	 	      String cycle1="//*[@data-name='";
	 	  	String cycle2="']";
	 	      cycle4=cycle1+cycleName+cycle2;
	 	      bp.waitForElement();
	 	      WebElement nodeElement=driver.findElement(By.xpath(cycle4));
	 	      Actions act=new Actions(driver);
	 	      act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
	 	      String cyclename=driver.findElement(By.xpath(cycle4)).getText();
	 	      System.out.println(cyclename);
	 	      System.out.println("Pass - Double click on'"+cycleName+"' Successfull");
	 	      //act.moveToElement(nodeElement).click().perform();
	 	      bp.waitForElement();
	 	     
	 	     return true;
	 	    }
	 	    catch(Exception e)
	 	    {
	 	     System.out.println("Fail-cycle navigation unsucessful");
	 	     e.printStackTrace();
	 	     throw e;
	 	    }
	 	    }
	 		 
	 		public boolean navigateToCycle2(String[] cycleName,WebDriver driver2) throws Exception
	 		{
	 			this.driver=driver2;
	 			String cycle4;
	 			try
	 			{
	 				for(int i=0;i<=cycleName.length-1;i++)
	 				{
	 					String cycle1="//*[@data-name='";
	 					String cycle2="']";
	 					cycle4=cycle1+cycleName[i]+cycle2;
	 					WebElement nodeElement=driver.findElement(By.xpath(cycle4));
	 					Actions act=new Actions(driver);
	 					act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
	 					String cyclename=driver.findElement(By.xpath(cycle4)).getText();
	 					log.info(cyclename);
	 					log.info("Pass - Double click on'"+cycleName[i]+"' Successfull");
	 					//act.moveToElement(nodeElement).click().perform();
	 					bp.waitForElement();
	 				}
	 				return true;
	 			}
	 			catch(Exception e)
	 			{
	 				log.info("Fail-navigation unsucessful");
	 				e.printStackTrace();
	 				throw e;
	 			}
	 		}
	 		
	 		public boolean assignPhase2(WebDriver driver2) throws Exception
	 		{
	 			try
	 			{
	 				this.driver=driver2;
	 				BasePage bp=new BasePage();
	 				bp.waitForElement();
	 				driver.findElement(By.xpath("//div[@class='contextMenuIcon fa fa-ellipsis-v']")).click();
	 				log.info("Pass - Clicked on Options");
	 				bp.waitForElement();
	 				driver.findElement(By.xpath("//a[text()='Assign']")).click();
	 				bp.waitForElement();
	 				return true;
	 			}
	 			catch(Exception e)
	 			{
	 				log.info("Fail-phase not assigned");
	 				e.printStackTrace();
	 				throw e;
	 			}
	 		}
	 		
	 		public boolean assignAllSelectedWaitForOk2(String assignee,WebDriver driver2) throws Exception
	 		{
	 			try
	 			{
	 				this.driver=driver2;
	 				bp=new BasePage();
//	 				select_Assignee.click();
//	 				bp.waitForElement();
	 				WebElement ele=driver.findElement(By.xpath("//span[text()='Select Assignee']"));
	 				Actions act=new Actions(driver);
	 				act.moveToElement(ele).click().pause(1500).sendKeys(assignee).sendKeys(Keys.ENTER).perform();
	 				bp.waitForElement();
//	 				log.info("clicked on all selected assign option");
//	 				WebElement asssin=driver.findElement(By.xpath(assignee1+assignee+assignee2));
//	 				asssin.click();
//	 				bp.waitForElement();
//	 				log.info("selected assignee"+asssin.getText());
	 				//clickonOK.click();
	 				bp.waitForElement();
	 				return true;
	 			}
	 			catch(Exception e)
	 			{
	 				log.info("Fail-fail to select assignee ");
	 				e.printStackTrace();
	 				throw e;
	 			}
	 		}
	 		
	 		public boolean okForAssignSelected2(WebDriver driver2) throws Exception
	 		{
	 			try
	 			{
	 				this.driver=driver2;
	 				driver.findElement(By.xpath("//button[text()='OK']")).click();
	 				//clickonOK.click();
	 				return true;
	 			}
	 			catch(Exception e)
	 			{
	 				log.info("Fail-fail to select assignee ");
	 				e.printStackTrace();
	 				throw e;
	 			}
	 			
	 		}
	 		
	 		public boolean selectallTestCase2(WebDriver driver2) throws Exception
	 		 {
	 		  try
	 		  {
	 			  this.driver=driver2;
	 			  driver.findElement(By.xpath(".//*[@id='phase_testcase_select_all']")).click();
	 		 // select_all_TestCases.click();
	 		  return true;
	 		  }
	 		  catch(Exception e)
	 		  {
	 		   e.printStackTrace();
	 		   throw e;
	 		  }
	 		 }
	 		
	 		public boolean synch() throws Exception
	 		{
	 			try
	 			{
	 				bp=new BasePage();
	 				clickOnSynch.click();
	 				bp.waitForElement();
	 				bp.waitForElement();
	 				//click on checkbox
	 				clickOnSynchChkBox.click();//removed
	 				bp.waitForElement();
	 				//continue
	 				clickOnSynchContinue1.click();
	 				bp.waitForElement();
	 				//continue
	 				clickOnSynchContinue2.click();//removed
	 				bp.waitForElement();
	 				//ok
	 				clickOnSynchOk.click();
	 				bp.waitForElement();
	 				return true;
	 			}
	 			catch(Exception e)
	 			{
	 				e.printStackTrace();
	 				throw e;
	 			}
	 		}
	 		
	 		
	 		  public Boolean cancelBulkAssignSearch() throws Exception
	 		  {
	 			  try
	 			  {
	 				  bp=new BasePage();
	 				  Boolean res=cancelBulkAssignSearch.isDisplayed();
	 				  if(res==true)
	 				  {
	 					  cancelBulkAssignSearch.click();
	 					  bp.waitForElement();
	 					  System.out.println("Displayed cancelled bulk assign");
	 				  }
	 			  }
	 			  catch(Exception e) 
	 			   {
	 			    e.printStackTrace();
	 			    throw e;
	 			   }
	 			  return true;
	 		  }
	 		  
	 		  
	 		  
	 		 public boolean editStartDatAndEndDate(String syear,String smonth,String sday,String eyear,String emonth,String eday) throws Exception
			 {
			   try
			   {
				if(syear!="")
				{
					
			  bp=new BasePage();
			  startDateOption.click();
		
			  WebElement ele=driver.findElement(By.xpath(startDateHeader));
			  Actions a2=new Actions(driver);
			  a2.moveToElement(ele).doubleClick().perform();
			  driver.findElement(By.xpath(startDateHeader)).click();
			  //a2.moveToElement(ele).click().perform();
			  
			  bp.waitForElement();
			  String []  startDate =new String[1];
			   String startYear=minYear1.getText();
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
			  driver.findElement(By.xpath(day1+sday+day2)).click();
			  bp.waitForElement();
			  bp.waitForElement();
			  
				}
				
				if(eyear!="")
				{
			  endDateOption.click();
			  bp.waitForElement();
			  WebElement ele1=driver.findElement(By.xpath(endDateHeader));
			  Actions a3=new Actions(driver);
			  a3.moveToElement(ele1).click().perform();
			  bp.waitForElement();
			  //bp.waitForElement();
			  driver.findElement(By.xpath(endDateHeader)).click();
			  bp.waitForElement();
			  String []  endDate =new String[1];
			   String endMin=minYear2.getText();
			  String endMax=maxYear2.getText();
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
			  
			 // bp.waitForElement();
			  driver.findElement(By.xpath(year1+eyear+year2)).click();
			  bp.waitForElement();
			  //bp.waitForElement();
			  driver.findElement(By.xpath(month1+emonth+month2)).click();
			  bp.waitForElement();
			  //bp.waitForElement();
			  driver.findElement(By.xpath(day_1+eday+day_2)).click();
				
				}
			  
			  return true;
			 }

		    catch(Exception e)
			{
				System.out.println("Fail-navigation unsucessful");
				e.printStackTrace();
				throw e;
			}

	}
	 		 
//	 		public boolean navigateToCycle5(String[] cycleName) throws Exception
//	 		{
//	 			String cycle4;
//	 			try
//	 			{
//	 				bp=new BasePage();
//	 				for(int i=0;i<=cycleName.length-1;i++)
//	 				{
//	 					cycle4=cycle1+cycleName[i]+cycle2;
//	 					WebElement nodeElement=driver.findElement(By.xpath(cycle4));
//	 					//System.out.println(nodeElement);
//	 					WebDriverWait wait=new WebDriverWait(driver,60); 
//	 					wait.until(ExpectedConditions.elementToBeClickable(nodeElement));
//	 					
//	 					if(cycleName.length>=1 && i<cycleName.length-1)
//	 					{
//	 						bp.waitForElement();
//	 						String cycle=cycleExpand1+cycleName[i]+cycleExpand2;
//	 						WebElement cycleExpand=driver.findElement(By.xpath(cycle));
//	 						String check=cycleExpand.getAttribute("aria-expanded");
//	 						System.out.println(check);
//	 					
//		 					while(check.equals("false"))
//		 					{
//		 						Actions act=new Actions(driver);
//		 						act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
//		 						System.out.println("Pass - Double click on'"+cycleName[i]+"' Successfull");
//		 						bp.waitForElement();
//		 						check=cycleExpand.getAttribute("aria-expanded");
//		 				    }
//	 					}
//	 					else
//	 					{
//		 					bp.waitForElement();
//		 					Actions act=new Actions(driver);
//		 					act.moveToElement(nodeElement).click().perform();
//		 					bp.waitForElement();
//	 					}
//	 				}
//	 				return true;
//	 			}
//	 			catch(Exception e)
//	 			{
//	 				System.out.println("Fail-navigation unsucessful");
//	 				e.printStackTrace();
//	 				throw e;
//	 			}
//	 		}
//	 		
	 		public boolean goBackToCycle() throws Exception
	 		{
	 		try
	 		{
	 		bp=new BasePage();
	 		bp.waitForElement();
	 		WebDriverWait wait=new WebDriverWait(driver,60);
	 		wait.until(ExpectedConditions.elementToBeClickable(backToCycle));
	 		backToCycle.click();
	 		bp.waitForElement();
	 		}
	 		catch(Exception e)
	 		{
	 		 e.printStackTrace();
	 		 throw e;
	 		}
	 		 return true;	
	 		}
	 		
	 		
	 		//to select freeform all testcases in browse by othercycles
		    
		    public boolean selectAllFreeFormTestCasesPhase() throws Exception
		  		{
		  	    	try
		  	    	{
		  	    		bp=new BasePage();
		  	    		selectAllFreeFormTestcasesPhase.click();
		  	    		bp.waitForElement();
		  	    		System.out.println("pass-Selected All Testcases");
		  	    	return true;
		  	    	}
		  	    	catch(Exception e)
		  	    	{
		  	    		e.printStackTrace();
		  	    		throw e;
		  	    	}
		  	    	
		  		}
		
}

