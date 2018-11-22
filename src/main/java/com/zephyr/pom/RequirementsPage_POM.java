package com.zephyr.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.reusablemethods.BasePage;

public class RequirementsPage_POM 
{

	WebDriver driver=null;
	public RequirementsPage_POM(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(LaunchBrowser.driver, this);
	}

	public Logger log;
	BasePage bp;	
		
//	@FindBy(xpath=".//*[@id='j24_1_anchor']/div")
//	public WebElement options;
	
	@FindBy(xpath="//*[@class='contextMenuIcon fa fa-ellipsis-v']")
	public WebElement options;
		
	@FindBy(xpath="html/body/ul/li[1]/a")
	public WebElement addNode;
	
	@FindBy(css="#addNodeName")
	public WebElement nodeName;
	
	@FindBy(css="#addNodeDescription")
	public WebElement nodeDesc;
	
	@FindBy(css="#reqAddNodeModalSave")
	public WebElement saveNode;
	
	@FindBy(xpath=".//*[@id='zui-modal-trigger-requirement_1']")
	public WebElement addRequirement;
	
	@FindBy(xpath=".//*[@id='zui-modal-trigger-import-requirements']")
	public WebElement import_Requirement;
	
	@FindBy(xpath=".//*[@id='zui-modal-trigger-requirement_2']")	
	public WebElement clone_Requirement;

	@FindBy(xpath=".//*[@id='zui-modal-trigger-requirement_4']")
	public WebElement delete_Requirement;
	
	@FindBy(xpath=".//*[@id='zui-modal-trigger-requirement_9']")
	public WebElement allocate_TestCase;
	
	@FindBy(xpath=".//*[@id='zui-export-modal-trigger-requirement_3']")
	public WebElement export_Requirement;
	
	@FindBy(xpath=".//*[@id='ze-main-app']/zee-test-requirements/test-requirements-component/div[1]/div[1]/div[2]/div[1]/a/span")
	public WebElement search_TestCase;
	
	@FindBy(xpath=".//*[@id='grid-table-tcr']/div[2]/div/div[3]/div/div")
	public WebElement clickOnTestCaseDetails;
	
	@FindBy(xpath=".//*[@id='testcase-fullscreen-resizer']/span")
	public WebElement clickOnExpander;
	
	@FindBy(xpath="//*[text()='Mapped Requirements']")
	public WebElement clickOnMapRequirements;
	
	@FindBy(xpath=".//*[@id='mapTest']")
	public WebElement clickOnMapReq;
	
	@FindBy(xpath=".//*[@id='j4_1_anchor']")
	public WebElement clickOnReleaseOption;
	
	@FindBy(xpath=".//*[@id='j4_24_anchor']")
	public WebElement clickOnPhaseOption;
	
	@FindBy(xpath=".//*[@id='grid-table-map_req']/div[2]/div[1]/div[1]/div/div/input")
	public WebElement selectTestCase;
	
	@FindBy(xpath=".//*[@id='zee-map-modal']/div/div/div[3]/zui-modal-footer/div/div/button[2]")
	public WebElement clickOnSave;
	
	@FindBy(xpath="//*[@class='page-track']/b[3]")
	public WebElement requirementCount;
	
	//For selecting Release in Phase
	protected String releasename1="//*[@data-name='";
	protected String releasename2="']";
	
	
	//For Mapping Requirements
		@FindBy(xpath="//span[contains(.,' Detail ')]")
		public WebElement detail_Tab;
		
		
		
		
		@FindBy(xpath="(//div[@class='row map-save']/div/button[text()='Save'])[3]")
		public WebElement clickSave;

		//For selecting Release in node
			protected String expandreleasename1="(//*[@data-name='";
			protected String expandreleasename2="'])[2]";
			
		//For Selecting Requirement
			//for selecting test Case
//			public String requirement1="//*[@id='grid-table-map_req']/div[2]/div[";
//			public String requirement2="]/div[1]/div/div/input";
//		
	/**************************09/08/17***************************************/
		//For click on import
			public String importtype1="//button[text()='";
			public String importtype2="']";
			
//			@FindBy(xpath=".//*[@id='zui-import-modal-choice']/div/div/div[2]/div/button[1]")
//			public WebElement chooseImportType;
			//selecting Jira requirements
			public String selectTestCase1=".//*[@id='grid-table-IMPORT_JIRA']/div[2]/div[";
			public String  selectTestCase2="]/div[1]/div/div/input";
			
			//selecting accessType
			public String accessType1=".//li[text()='";
			public String accessType2="']";
			
			//secting JQL querry
			public String selectquerry1=".//li[text()='";
			public String selectquerry2="']";
			
			//secting JQL querry
			public String selectFilter1=".//li[text()='";
			public String selectFilter2="']";
			
			//For selecting searchDefectsJQL
			@FindBy(xpath=".//*[@id='searchDefectsJQL']")
			public WebElement enterJiraSearchDefectsJQLQuerry;
			
			@FindBy(xpath=".//*[@id='rwalgn{']/span[3]/button")
			public WebElement clickjiraSearchButton;
			
			@FindBy(xpath=".//*[@id='select2-accessType-container']")
			public WebElement chooseAccessTypes;
			
			@FindBy(xpath=".//*[@id='fldrnm']")
			public WebElement clickjiraTopLevelFolderName;
			
			@FindBy(xpath=".//*[@id='zee-import-modal-requirement-jira']/div/div/div[3]/zui-modal-footer/div/button[2]")
			public WebElement clickOnImportSelected;
			
			@FindBy(xpath=".//*[@id='select2-searchChoice-container']")
			public WebElement searchChoiceContainer;
			
			
			//Check Test Case from  Test Case grid
//			public String checkTestCase1=".//*[@id='grid-table-IMPORT_JIRA']/div[2]/div[";
//			public String  checkTestCase2="]/div[1]/div/div/input";
			
			public String checkRequirement1=".//*[@id='grid-table-req']/div[2]/div[";
			public String checkRequirement2="]/div[1]/div/div/input";
			
			//for saving Jira map requirement
			@FindBy(xpath=".//*[@id='zee-map-modal']/div/div/div[3]/zui-modal-footer/div/div/button[2]")
			public WebElement clickOnSavejirareq;
			
			
			/***************************12/08/17****************************/
			//For Mapping TestCases
			@FindBy(xpath="//*[text()='Mapped TestCases']")
			public WebElement clickOnMappedTestCases;
			
			@FindBy(xpath="//*[@id='mapTest']")
			public WebElement clickOnMapTestCase;
			
			
			
			//@FindBy(xpath=".//*[@id='zee-import-modal-requirement-jira']/div/div/div[1]/div[2]/zui-modal-header-buttons/div/button")
			@FindBy(xpath="//span[text()='Reset User']")
			public WebElement clickOnResetUser;
			
			//@FindBy(xpath=".//*[@id='zee-import-modal-requirement-jira']/div/div/div[2]/zui-modal-body/zee-update-defect-user/div/form/div[1]/span[2]/input")
			@FindBy(xpath="(//input[@name='username'])")
			public WebElement username;
			
			//@FindBy(xpath=".//*[@id='zee-import-modal-requirement-jira']/div/div/div[2]/zui-modal-body[2]/zee-update-defect-user/div/form/div[2]/span[2]/input")
			@FindBy(xpath="(//input[@name='password'])")
			public WebElement password;
			
			//@FindBy(xpath=".//*[@id='zee-import-modal-requirement-jira']/div/div/div[2]/zui-modal-body[2]/zee-update-defect-user/div/form/div[3]/span[2]/input")
			@FindBy(xpath="(//input[@name='reEnterPassword'])")
			public WebElement reEnterPassword;
			
			@FindBy(xpath="(.//button[text()='Update'])[2]")//[3]->[2]
			public WebElement update;
			
			@FindBy(xpath="(.//button[text()='Update'])[2]")
			public WebElement updateUser;
			
			@FindBy(xpath=".//*[@id='zee-map-modal']/div/div/div[1]/div[2]/button")
			public WebElement closeInstructionWindow;
			
			@FindBy(xpath="//*[@id='zephyr-tree-requirement']/ul/li[1]")
			public WebElement releaseExpandInReq;
			
			public String releasename11="(//*[@data-name='";
			public String expandNode="']/..)";
			
			
			
			
			
			
			//06/12/17
			
			@FindBy(xpath="//*[@id='zee-delete-modal-requirement_4']//button[3]")
			public WebElement deleteButton;
			
			
			//NewlyAdded   07/12/17
			
			@FindBy(xpath="//*[text()='Deallocate']")
			public WebElement deallocateButton;
			
			@FindBy(xpath=" //*[@id='reqDeleteNodeModal']//button[2]")
			public WebElement deallocateNode;
			
			@FindBy(xpath=" //*[@id='reqDeleteNodeModal']//button[3]")
			public WebElement deleteNode1;
			
			@FindBy(xpath="//button[text()='Allocate']")
			public WebElement allocateReq;
			
			@FindBy(xpath="//a[text()='Allocate']")
			public WebElement allocateNode;
			
		
			
			@FindBy(xpath="//a[text()='Delete']")
			public WebElement deleteNode;
			
			//public String checkRequirement1=".//*[@id='grid-table-req']/div[2]/div[";
		     //public String checkRequirement2="]/div[1]/div/div/input";
		     
		     @FindBy(xpath="//button[text()='Go']")
		 	public WebElement goLinkButton;
		     
		     //Added By sri//08/12/17
		     public String coverage1="//*[@id='grid-table-req']/div[2]/div[";
		       public String coverage2="]/div[5]/div/div";
		       
		       @FindBy(xpath="(//*[@class='modal-body'])[26]")
		       public WebElement coverageMsg;
		       
		       @FindBy(xpath="(//button[text()='×'])[21]")
		       public WebElement closeRequirementCoverageDetails;
		       
		       @FindBy(xpath=".//*[@placeholder='Enter name']")
		       protected WebElement requirementName;
		       
		       @FindBy(xpath="//*[@placeholder='Enter priority']")
		           public WebElement requirementPriority;
		           
		           @FindBy(xpath="//*[@placeholder='Enter alt ID']")
		           public WebElement requirementAltID;
		           
		           @FindBy(xpath="//*[@placeholder='Enter Link']")
		           public WebElement requirementLink;
		           
		           @FindBy(xpath="//*[@id='tinymce']")
		           public WebElement requirementDescription;
		           
//		           @FindBy(id="editor_ifr") //previous xpath
//		           public WebElement frameDescription;
		           
		           @FindBy(id="editor-undefined_ifr")//updated on 29/07/18 previous(editor_ifr)
		           public WebElement frameDescription;
		           
		           @FindBy(xpath="(.//button[text()='Save'])[3]")
		           public WebElement saveRequirementDetail;

		           @FindBy(xpath="//div[@id='th-req_select_all']//input")
		           public WebElement selectAll;
		           
		           @FindBy(xpath="//*[@id='grid-table-req']/div[2]/div[1]/div[3]")
		           public WebElement srcReq;
		           
		           /**************************06/12/17***********************/
					
					
					public String ExportRequirements="//a[contains(.,' Export Requirements')]";
					
					@FindBy(xpath="//button[text()='Entire Traceability']")
					public WebElement entireTraceability;
					
					@FindBy(xpath="//button[text()='Requirement Only']")
					public WebElement requirementOnly;
					
					@FindBy(xpath="//h4[contains(.,'Customize and Export Reports')]")
					protected WebElement exportPage;
					
					//For Export Page Verification
					protected String exportPageTitle="Customize and Export Reports";
					
					//Requirements Only
					@FindBy(xpath="(.//div[text()='Priority'])[1]") //new
					protected WebElement priorityOption;
					
					@FindBy(xpath="(.//div[text()='Creator'])[1]") //new
					protected WebElement creatorOption;
					
					@FindBy(xpath="(//button[text()='Save'])[1]")
					protected WebElement exportSave;
					
					@FindBy(xpath=".//button[text()='Download']")
					protected WebElement exportDownload;
					
					
				     @FindBy(xpath=".//*[text()='Edit']")
				     public WebElement editJira;
				     
				     @FindBy(xpath="//input[@name='summary']")
				     public WebElement enterJiraSummary;
				     
				     @FindBy(xpath="//*[@id='labels-textarea']")
				     public WebElement enterJiraLabels;
				     
				     @FindBy(xpath="//*[@id='priority-field']")
				     public WebElement enterJiraPriority;
				     
				     @FindBy(xpath="//*[@name='issuelinks-linktype']")
				     public WebElement enterJiraLinkedIssues;
				     
				     @FindBy(xpath="//*[@id='issuelinks-issues-textarea']")
				     public WebElement enterJiraLinkedIssuesArea;
				     
				     @FindBy(xpath="//*[@id='assignee-field']")
				     public WebElement enterJiraAssignee;
				     
				     @FindBy(xpath="(//*[@class='wiki-edit-content'])[4]")
				     public WebElement enterJiraEditContent;
				     
				    // @FindBy(xpath=".//*[@name='Edit']")
				     public String enterJiraEditUpdate=".//*[@name='Edit']";
				     
				     @FindBy(id="summary-val")
				     public WebElement summaryValue;
				     
				     @FindBy(id="priority-val")
				     public WebElement priorityValue;
				     
				     @FindBy(xpath="//*[@class='labels-wrap value editable-field inactive']")
				     public WebElement labelsValue;
				     
				     //Import Jira 08/12/17
				     @FindBy(xpath=".//button[text()='Import All']")
				     public WebElement importAll;
				     
				     @FindBy(xpath="//*[@class='page-track']/b[3]")
				     public WebElement reqCount;
				     
				     
				     /*@FindBy(xpath="(.//div[text()='Coverage'])[1]")
				     public WebElement reqCoverage;*/
				     
				     @FindBy(xpath="(.//div[text()='Coverage'])[1]")
				     public WebElement reqCoverage;
				     
				     public String priorityField="//input[@placeholder='Select Filter Priority']";
				     
				     public String creatorField="//input[@placeholder='Select Filter Creator']";
		           
				     
				     @FindBy(xpath="//*[@id='select2-defectFiltersDropdown-container']")
						public WebElement selectJiraSearchDefectsFilterQuerry;
				     
				     	   	  
				     
				     public String map1="//*[@class='map-text']/..//a";
					   public String map2=" testcase']";
					   
					   public String mapTestCaseRequirement1=".//*[@id='grid-table-map_tc']/div[2]/div[";
					   public String mapTestCaseRequirement2="]/div[1]/div/div/input";	  
////					   
					   public String validateGridColumn1="//*[@id='grid-table-req']/div[2]/div[";
					    public String validateGridColumn2="]/div[";
					    public String validateGridColumn3="]/div/div";
						
					   
					    protected String check1="(//*[@class='jstree-container-ul jstree-children']//*[@data-name='";//updated on 02/08/18
				          protected String check2="']/i)[1]";
				          
				      	//StartDate and EndDate
				    		@FindBy(xpath="(.//div[@class='btn-group'])[1]")
				    		public WebElement startDateOption;
				    		
				    		@FindBy(xpath="(.//div[@class='btn-group'])[2]")
				    		public WebElement endDateOption;
				    		
				    		public String startDateHeader="(//button[@class='btn btn-default btn-secondary btn-sm'])[2]";
				    		 public String endDateHeader="(//button[@class='btn btn-default btn-secondary btn-sm'])[2]";
				    		 public String year1="//*[text()='";
				    		 public String year2="']";
				    		 
				    		 public String month1="//span[text()='";
				    		 public String month2="']";
				    		 
				    		 public String day1="(//span[text()='";
				    		 public String day2="'])[2]";
				    		 
				    		 public String day_1="(//span[text()='";
				    		 public String day_2="'])[2]";
				          
				       
				    		 @FindBy(xpath = "//h5[text()='Custom Fields']")
				    			public WebElement customFieldHeading;

				    		 //previous custom fields xpath
//				    			@FindBy(xpath = "//div/zee-custom-fields//strong[contains(@title, 'ReqText')]/following-sibling::span")
//				    			public WebElement customReqText;
//
//				    			@FindBy(xpath = "//div/zee-custom-fields//strong[contains(@title, 'ReqLongText')]/following-sibling::span")
//				    			public WebElement customReqLongText;
//
//				    			@FindBy(xpath = "//div/zee-custom-fields//strong[contains(@title, 'ReqCheckBox')]/following-sibling::span")
//				    			public WebElement customReqCheckbox;
//
//				    			@FindBy(xpath = "//div/zee-custom-fields//strong[contains(@title, 'ReqNumber')]/following-sibling::span")
//				    			public WebElement customReqNumber;
//
//				    			@FindBy(xpath = "//div/zee-custom-fields//strong[contains(@title, 'ReqDate')]/following-sibling::span")
//				    			public WebElement CustomReqDateField;
//
//				    			@FindBy(xpath = "(//div/zee-custom-fields//strong[contains(@title, 'ReqPicklist')]/following-sibling::span)")
//				    			public WebElement customReqPicklist;
				    		   
				    		 //Updated custom Fields xpath on 30/07/18
				    		    @FindBy(xpath = "//div/zee-custom-fields//span[contains(@title, 'ReqText')]/following-sibling::span")
				    			public WebElement customReqText;

				    			@FindBy(xpath = "//div/zee-custom-fields//span[contains(@title, 'ReqLongText')]/following-sibling::span")
				    			public WebElement customReqLongText;

				    			@FindBy(xpath = "//div/zee-custom-fields//span[contains(@title, 'ReqCheckBox')]/following-sibling::span")
				    			public WebElement customReqCheckbox;

				    			@FindBy(xpath = "//div/zee-custom-fields//span[contains(@title, 'ReqNumber')]/following-sibling::span")
				    			public WebElement customReqNumber;

				    			@FindBy(xpath = "//div/zee-custom-fields//span[contains(@title, 'ReqDate')]/following-sibling::span")
				    			public WebElement CustomReqDateField;

				    			@FindBy(xpath = "(//div/zee-custom-fields//span[contains(@title, 'ReqPicklist')]/following-sibling::span)")
				    			public WebElement customReqPicklist;
				    			
				    			@FindBy(xpath = "//*[@id='custom-field-error-modal']//span[3]")
				    			public WebElement customDuplicateOkMsg;
				    			@FindBy(xpath = "//*[@id='custom-field-error-modal']/div/div/div[3]/zui-modal-footer/button")
				    			public WebElement customDuplicateOkButton;
				    			
				    			
				    			
				    			@FindBy(xpath="//li[@class='next']")
				    			public WebElement clickOnNextRequirements;
				    			
				    			@FindBy(id="requirement-fullscreen-resizer")
				    			public WebElement detailIcon;
				    			//pagination
					 			@FindBy(xpath=".//*[@id='pagination-page-size-req']")
					 			public WebElement clickOnOptions;
					 			
					 			//for selecting page Number
					 			public String pagenumber1="(.//option[text()='";
					 			public String pagenumber2="'])";
					 			
					 			public String clickOnPages1="//*[@id='tcr-grid']/div/grid/div[2]/ul/span/li[";
					 			public String clickOnPages2="]";
					 			
					 			 @FindBy(xpath="//a[text()='Move']")
							       public WebElement moveNode;
						        
						          @FindBy(xpath="//a[text()='Copy']")
							       public WebElement copyNode;
						          
						          @FindBy(xpath="//a[text()='Paste']")
							       public WebElement pasteNode;


						          /*****************18/12/17 To Retrieve requirement ID'sadded by srikanth**********************/
						 			public String requirementID1="//*[@id='grid-table-req']/div[2]/div[";
						 			//public String requirementID2="]/div[2]/div/div";//previous
						 			public String requirementID2="]/div[3]/div/div";//updated 30/07/18
						 			
						 			//advanced search
						 			@FindBy(xpath="//*[text()='Advanced']")
						    		public WebElement advancedSearch;
						 			
						 			@FindBy(xpath=".//*[text()='Quick']")
							 		   public WebElement quickSearch;
						 			
						 			@FindBy(xpath="//*[@placeholder='Enter ZQL']")
						    		public WebElement enterZql;
						 			
						 			@FindBy(xpath="(.//*[text()='Go'])[1]")
						    		public WebElement clickOnGo;
						 			
						 			@FindBy(xpath="//button[@type='cancel']")
						 		    public WebElement Cancel;
						 			
						 			@FindBy(xpath="//*[@id='grid-table-map_tc']/div[2]/div[1]/div[3]/div/div")
						 		    public WebElement testcaseId;
						 			
						 			 @FindBy(xpath="//span[@title='Reset to Default View']")
								       public WebElement resetRequirementGrid;
							        
							          @FindBy(xpath="//test-requirements-component/div[1]//div/div[3]/i")
								       public WebElement dndName;
							          
							          @FindBy(xpath="//button[text()='Yes']")
								       public WebElement clickResetYes;
							          
							          @FindBy(xpath="//input[@id='req_select_all']")
						               public WebElement selectAllRequirements;
							          
							          
							          @FindBy(xpath="//*[@id='map-grid']/grid/div[2]/ul/li[3]/a/span")
								       public WebElement requirementNextButton;
							          
							          //////////////29/05/18 by srikanth////////////////
							          @FindBy(xpath="(//*[@class='page-track']/b[3])")
									    public WebElement searchCount;

									    @FindBy(xpath="//li[@class='next-page']//span")
									    public WebElement nextButton;
									    
									    @FindBy(xpath="//defects-advanced-search//b[3]")
										public WebElement serachRequirementCount;
									    
									    @FindBy(xpath="//*[@id='zee-map-modal-bulk']/div/div/div[3]/zui-modal-footer/div/div/button[2]")
										public WebElement clickOnSavejirareq1;
									    
									    @FindBy(xpath="(//button[text()='Cancel'])[17]")
										 public WebElement jiraCancelButton;
									    
									    @FindBy(xpath="(//button[text()='×'])[6]")
										 public WebElement cancelChangeMultipleWindow;
										 
										 @FindBy(xpath="//*[@id='select2-defect-bulk-edit-assignee-container']")
										 public WebElement enterAssignee;
										 
										 @FindBy(xpath=".//*[@id='grid-table-map_req']/div[2]/div/div[7]/div/div")
											public WebElement remoteLink;
											

						 			
}

	

