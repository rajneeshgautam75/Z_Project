package com.zephyr.reusablemethods;


import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.pom.CreateTestCasePage_POM;




public class CreateTestCasePage
{
  BasePage bp;
  WebDriver driver;
  public Logger log;

  


  public CreateTestCasePage(WebDriver driver)
  {
	 //super(driver);
	 this.driver =driver;
	 PageFactory.initElements(LaunchBrowser.driver,this);
	 log=Logger.getLogger(this.getClass());
	Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
//	BasicConfigurator.configure();
	

    }	

//******* Release 6.1 ******//start
	@FindBy(xpath="//a[@title='Switch to detail view']")
	public WebElement Detail;
 //End
	
	@FindAll({@FindBy(xpath="//div[@class='zui-inline-edit zephyr-editable-field']")})
	public List<WebElement> l1;
	
	@FindBy(xpath="//span[@placeholder='Enter description']")
	public WebElement tcDesc;
	
	
	//@FindBy(xpath="//input[@class='form-control text js-zephyr-inline-edit-text ng-touched ng-pristine ng-valid']")
	@FindBy(xpath="//span[@placeholder='Enter name']")
	public WebElement tcname;
	
	
	//*****Release 6.0 ********Start
	//@FindBy(xpath="//h5[text()='Step Details']")
	//public WebElement stepDetail;
	//END

	// ******* Release 6.1 ******//start
	@FindBy(xpath="//h5[text()='Test Step']")
	public WebElement TestStep;
	
	@FindBy(xpath="//h5[text()='Test Step']")
	public WebElement stepDetail;
	 //End
	
	
	@FindBy(xpath="//button[contains(.,'+')]")
	public WebElement nextBtn;
	
	
   // ******* Release 6.0 ******//start
	//@FindBy(xpath="//h5[text()='Attachments']")
	//public WebElement attachements;
	 //End
    
	// ******* Release 6.1 ******//
	@FindBy(xpath="//h5[text()='Attachment']")
	public WebElement attachements;

	@FindBy(xpath="//span[@id='testcase-estimated-time']")
	public WebElement estimatedTime;
	
	@FindBy(xpath="//*[@id='testcase-estimated-time']/zephyr-inline-edit/div/div/span[1]/zui-estimated-time/div")
	public WebElement validateEstimateTime;
	//public String saveBtn="//button[contains(.,'+')]";
	
	 public String saveBtnInDetailView="(//*[@class='zui-btn zui-btn-primary' and text()='Save'])[2]";
			  
	 public String addTestStep="//textarea[@id='zee-add-step']";
	 public String browse="//span[contains(.,'Browse')]";
	 

	 public String days_1="(//input[@id='dayText'])[2]";
	 public String hour_1="(//input[@id='hourText'])[2]";
	 public String minute="(//input[@id='minuteText'])[2]";
	 
	 
	 //MultipleTestCaseEditField
	 
	 @FindBy(id="zui-modal-trigger-tcr_3")	
	 public WebElement edit_TestCase;
	 
	 @FindBy(xpath="//input[@id='release-externalid']")
	 protected WebElement altId;
	 
	 @FindBy(xpath="//textarea[@id='release-comments']")
	 protected WebElement comments;
	 
	 @FindBy(xpath="(//*[@class='select-control'])[1]")
	 protected WebElement tags;
	 
	 
	
	 
	 
	 @FindBy(xpath="//input[@id='release-automated']")
	 protected WebElement ChkAutomatedScript;
	 
	 @FindBy(xpath="//input[@id='release-scriptname']")
	 protected WebElement scriptName;
	 
	 @FindBy(xpath="//input[@id='release-scriptid']")
	 protected WebElement scriptId;
	 
	 @FindBy(xpath="//input[@id='release-scriptpath']")
	 protected WebElement scriptPath;
	 
	 @FindBy(xpath="//*[@id='tcr-bulk-priority-wrap-']/span/span[1]/span")
	 protected WebElement prioritySeection;
	 
	
	 
	 

	public String priority1=".//li[text()='";
	public String priority2="']";
	 
	public String SaveBtnInMultEdit="(//*[@type='submit'])[2]";
	 
//	 public CreateTestCasePage_POM(WebDriver driver) 
//		{
//			this.driver = driver;
//			PageFactory.initElements(LaunchBrowser.driver,this);
//			
//		}
	 
	 
	 //Newly Added to delete Attachement
	protected String attachFile1="(//span[@title='";
	protected String attachFile2="'])[1]";
	 
	 @FindBy(xpath="//span[@title='Click to delete this file']")
	 protected WebElement deleteAttachements;
	 
	 @FindBy(xpath="//button[@value='DELETE']")
	 protected WebElement deleteAttachBtn;
	 
	 @FindBy(xpath="//span[contains(@class,'clear')]")
	 protected WebElement eraseTags;
	 
	 

	  
	  // 6.0 @FindBy(xpath="//*[@id='zee-create-edit-modal-tcr_3']/div/div/div[2]/zui-modal-body/div/div/form/div[3]/button[2]")
	//public WebElement saveInAutoScript;
	  
	  // 6.1 version
	 @FindBy(xpath="//div[@class='modal-body']//div[3]//button[2]")
	  public WebElement saveInAutoScript;
	   
	  @FindBy(xpath="//*[@id='bulk-confirm-modal']/div/div/div[3]/zui-modal-footer/button[2]")
	public WebElement confirmSaveInAutoScript;
	  
	  //@FindBy(xpath="//*[text()='button'])[3]")
	  //protected WebElement saveMsgInEdit;
	 //*[text()='button'])[3]
	  
	  @FindBy(xpath="(//*[@class='select2-hidden-accessible'])[3]")
	  protected WebElement pickuplistField1;
	 
	 
	 @FindBy(xpath="//*[@id='zee-testcase-step-details-module']/div[2]/zephyr-inline-rows-edit/div[2]/button[2]")
	  public WebElement clickStepSave;
	 
	//stepDetail Delete purpose in CreateTestCasePage POM
	 
		 @FindBy(xpath="(//button[text()='Delete'])[3]")
		 protected WebElement deleteBtn;
		 
		 
		 
		 //Estimated Time in ascending order
		 public String etsimatedtime1="//*[@id='grid-table-tcr']/div[2]/div[";
			public String estimatedtime2="]/div[10]/div/div";
			
		
			/************************09/08/17***********************/
		//Estimated Time icon
			@FindBy(xpath=".//*[@id='th-tcr_est_time']/div/div")
			public WebElement EstimatedTimeIcon;
			
		//Estimated sort icon
		@FindBy(xpath=".//*[@id='th-tcr_est_time']/div/i")
		public WebElement sortEstimatedIcon;
		
		
		//modified by srikanth for enterTestCaseStepDetails method in ctc page
			
		 //Release 6.0*******START
		//public String saveBtnConfirm=" //*[@class='save-wrapper']//*[text( )='Save']";	
		//END
		 
//		 @FindBy(xpath="(//button[text()='Delete'])[3]")
//		   protected WebElement deleteBtn;
		   
		   @FindBy(xpath="(//*[@id='zee-testcase-details-module-heading']/h5)[6]")
		   public WebElement clickOnStepDetailHistory;
		   
		   @FindBy(xpath="//*[@id='zee-testcase-history-details-module']/div[2]")
		   public WebElement viewStepDetailHistory;
		   
//		   @FindBy(xpath="//*[@id='1019']/field-input/zephyr-inline-edit/div/div/span[1]")
//		   public WebElement clickOnCalender;
		   
		   @FindBy(xpath="//*[text()='                    ']")
		   public WebElement clickOnCalender;
		   
		   @FindBy(xpath="(//span[text()='22'])[3]")
		   public WebElement clickOnDate;
		   
		   @FindBy(xpath="//span[text()='                 List             ']")
		   public WebElement clickOnList;
		   
		   @FindBy(xpath="//*[@id='grid-table-tcr']/div[2]")
		   public WebElement clickOnListPage;
		   
		//   @FindBy(xpath="//*[@id='grid-table-tcr']/div[2]")
		//   public WebElement clickToGetTextInList;
		   
		   @FindBy(xpath="(//div[@class='flex-data-item undefined ellipsis td-show'])[9]")
		   public WebElement clickToGetTextInList;
		   
		  //6.0  @FindBy(xpath="(//*[@id='zee-testcase-details-module-heading']/h5)[2]")
		  // public WebElement customFieldOption;
		   
		  //6.1 version
		   @FindBy(xpath="//h5[text()='Test Detail']")
		   public WebElement customFieldOption;
		   
		   @FindBy(xpath="(//div[@class='zui-inline-dialog'])[2]")
		   public WebElement selectCeckBoxOption;
		   
		   @FindBy(xpath="/html/body/div[2]/div/ul/li[18]/div/label")
		   public WebElement selectDateCheckBox;
		   
		 
   //@FindBy(xpath="//*[@id='zee-create-edit-modal-tcr_3']/div/div/div[2]/zui-modal-body/div/div/form/div[1]/div[1]/div[3]/div/zee-select/span/span[1]/span")
   @FindBy(xpath="//*[@id='tcr-bulk-tag-wrap-']/span/span[1]/span")
   public WebElement tagsInBulkEdit;
	 
	 @FindBy(xpath="//*[@id=1014]/field-input/input")
	 public WebElement chk;
		 
		  @FindBy(xpath="//h5[text()='Test Detail']")
	   public WebElement clickOnCustomField;
	   
	   @FindBy(xpath="(//input[@type='checkbox'])[42]")
	   protected WebElement detailCheckboxField;
	   
	   @FindBy(xpath="//*[@id='dayText']")
	   protected WebElement estimatedTimeMultiedit;
	   
	   @FindBy(xpath="//*[@id='bulk-confirm-modal']/div/div/div[2]")
	   protected WebElement updatedTcInfo;
	   
	   @FindBy(xpath="//*[text()='Cancel' and @class='zui-btn zui-btn-tertiary']")
	   protected WebElement cancelStepDetails;
	   
	     // 6.0 @FindBy(xpath="//*[@id='1064']/field-input/zephyr-inline-edit/div/div/span[1]")
	   //protected WebElement dateField;
	     
	     //6.1 version
	   @FindBy(xpath="//div[@class='col-md-12 col-xs-12']//li[4]//input")
	     protected WebElement dateField;
	     
	     @FindBy(xpath="//h5[text()='Step Details History']")
	     public WebElement stepDetailsHistory;
	   
	     
	     //@FindBy(xpath="//input[@name='automated']")//previous
	     @FindBy(xpath="//*[@id='zui-automated-script-checkbox']")//
		 protected WebElement ChkAutomatedScriptInDetail;
	     
	     
	     
//	     @FindAll({@FindBy(xpath="//span[@class='zephyr-inline-field-name fourth']")})
//	 	public List<WebElement> automationfield;
	     @FindBy(xpath="//*[@title='Enter priority']")
	     public WebElement priority_1;
	     
	     @FindBy(xpath="//*[@title='Enter alt ID']")
	     public WebElement altID;
	     
	     @FindBy(xpath="//*[@title='Enter tags']")
	     public WebElement tag;
	     
	     @FindBy(xpath="//*[@title='Enter comment']")
	     public WebElement comment;
	     
//	     @FindBy(xpath="//span[@placeholder='Enter tags']")
//	     public WebElement enterTags;
	     
	   //Single test Case Custom
	     // 6.0 @FindBy(xpath="//div/zee-custom-fields//strong[contains(@title, 'CustomText')]/following-sibling::span")
	     //protected WebElement customText;
	     
	     // 6.1 version
	     @FindBy(xpath="//div//span[contains(@title, 'CustomText')]/following-sibling::span")
	     public WebElement customText;
	     
	      // 6.0 @FindBy(xpath="//div/zee-custom-fields//strong[contains(@title, 'CustomLongText')]/following-sibling::span")
	      //protected WebElement customLongText;
	       
	     //6.1 version
	     @FindBy(xpath="//div//span[contains(@title, 'CustomLongText')]/following-sibling::span") 
	      protected WebElement customLongText;
	     
	     
	      
	        //6.0  @FindBy(xpath="//div/zee-custom-fields//strong[contains(@title, 'CustomCheckbox')]/following-sibling::span")
	      //protected WebElement customCheckbox;
	         
	     //6.1 version
	     @FindBy(xpath="//div//span[contains(@title, 'CustomCheckbox')]/following-sibling::span//input")
	         protected WebElement customCheckbox;
	         
	        //6.0  @FindBy(xpath="//div/zee-custom-fields//strong[contains(@title, 'CustomNumber')]/following-sibling::span")
	      //protected WebElement customNumber;
	        
	         //6.1 version
	         @FindBy(xpath="//div//span[contains(@title, 'CustomNumber')]/following-sibling::span")
	         protected WebElement customNumber;
	         
	        //6.0  @FindBy(xpath="//div/zee-custom-fields//strong[contains(@title, 'CustomDate')]/following-sibling::span")
	     // protected WebElement customDate;
	       
	         // 6.1 version 
	         @FindBy(xpath="//div//span[contains(@title, 'CustomDate')]/following-sibling::span")
	         protected WebElement customDate;
	         
	       // 6.0   @FindBy(xpath="(//div/zee-custom-fields//strong[contains(@title, 'CustomPicklist')]/following-sibling::span)")
	     // protected WebElement customPicklist;
	         
	         //6.1 version 
	         @FindBy(xpath="//div//span[contains(@title, 'CustomPicklist')]/following-sibling::span")
	         protected WebElement customPicklist;
	         
	         
	         @FindBy(xpath="(//*[text()='Estimated Time'])[1]")
	     	public WebElement estimatedTime1;
	         
	         //17-10-2017
	         
	        // 6.0 protected String validateEstmated1="//*[@id='grid-table-tcr']/div[";
	        // protected String validateEstmated2="]/div[4]/div[10]/div";
	         
	        // 6.1 version
	         protected String validateEstmated1="//*[@id='grid-table-tcr']//div[@data-index='";
	         protected String validateEstmated2="']//div[12]/div/div";
	         
	         //ForMultiSelect
		    //6.0  @FindBy(xpath="//*[@id='zee-create-edit-modal-tcr_3']//ul/li[2]/div/span")
	        //protected WebElement customText1;
	         
	       //6.1 version
	         @FindBy(xpath="//label[@title='CustomText']/..//input")
	         protected WebElement customText1;
		        
		         // 6.0 @indBy(xpath="//*[@id='zee-create-edit-modal-tcr_3']//ul/li[3]/div/span")
		         // protected WebElement customlongText1;
		   
	       //6.1 version
	       @FindBy(xpath=" //label[@title='CustomLongText']/..//textarea")
	       protected WebElement customlongText1;
	       
		         //6.0  @FindBy(xpath="//*[@id='zee-create-edit-modal-tcr_3']//ul/li[5]/div/span/input")
		          //protected WebElement customChkbox1;
	    
		          //6.1 version 
		          @FindBy(xpath="//label[@title='CustomCheckbox']/..//input")
		          protected WebElement customChkbox1; 
		          
		          
		          //6.0 @FindBy(xpath="//*[@id='zee-create-edit-modal-tcr_3']//ul/li[6]/div/span")
		          //protected WebElement customNumber1;
		          
		          // 6.1 version
		          @FindBy(xpath="//*[@title='CustomNumber']/..//input")
		          protected WebElement customNumber1;
		             
		          @FindBy(xpath="//label[@title='CustomDate']/..//input")
		          protected WebElement customDate1;
		             
		         // 6.0  @FindBy(xpath="(//*[@class='zee-column-wrap']/span/select)[2]")
		         // protected WebElement customPicklist1;
		          
		          //6.1 version
		          @FindBy(xpath="//label[@title='CustomPicklist']/..//select")
		          protected WebElement customPicklist1;
		          
		          //Single testcase 
		          @FindBy(xpath="//span[@placeholder='Enter alt ID']")
		          protected WebElement enterAltID;
		             
		          @FindBy(xpath="//span[@placeholder='Enter priority']")
		          protected WebElement enterPriority;
		             
		          @FindBy(xpath="//span[@placeholder='Enter comment']")
		          protected WebElement enterComment;
		          
		          @FindBy(xpath="//span[@placeholder='Enter tags']/..")
		          protected WebElement enterTags;
	         
		          // 6.0 @FindBy(xpath="//span[@title='Enter name']")
		            //protected WebElement enterScriptName;
		            
		          //6.1 version
		          @FindBy(xpath="(//span[@placeholder='Enter name'])[2]")
		            protected WebElement enterScriptName;
		            
		            
		            // 6.0 @FindBy(xpath="//span[@title='Enter ID']")
		           // protected WebElement enterScriptID;
		            
		          //6.1 version 
		          @FindBy(xpath="//span[@placeholder='Enter ID']")
		            protected WebElement enterScriptID;
		            
		            // 6.0 @FindBy(xpath="//span[@title='Enter path']")
		            //protected WebElement enterScriptPath;
		            
		          // 6.1 version
		          @FindBy(xpath="//span[@placeholder='Enter path']")
		            protected WebElement enterScriptPath;
		          
		          //@6.1 version
		          @FindBy(xpath="//div//span[contains(@title, 'CustomDate')]/following-sibling::span")
		          protected WebElement dateField1;
  /* ****************************************************
   * Method Name   : enterTestCaseNameAndDesc(String testCaseName,String testCaseDesc) 
  * Purpose        : for entering test case name and description in detail view
  * Author         : OPAL1
  * Date Created   : 27/07/17
  * Date Modified  :
  * Reviewed By    : Opal4
  * ******************************************************
  */
   
   public boolean enterTestCaseNameAndDesc(String testCaseName,String testCaseDesc) throws Exception 
	{
	   try
	   {
		
		bp=new BasePage();
		bp.waitForElement();
		
		//Erasing the Field
		bp.eraseText(tcname);
		bp.waitForElement();
		//Entering the data to the field
		Actions a1=new Actions(driver);
		a1.sendKeys(testCaseName).perform();
		bp.waitForElement();
		a1.sendKeys(Keys.ENTER).perform();
		bp.waitForElement();
		
		//Erasing the field
        bp.eraseText(tcDesc);
        bp.waitForElement();
        //Entering Data to the Field
        Actions a2=new Actions(driver);
		a2.sendKeys(testCaseDesc).perform();
		a2.sendKeys(Keys.ENTER).perform();
		a2.sendKeys(Keys.TAB).perform();
		bp.waitForElement();
		
		//Validation
		String tcName= tcname.getText();
		String description=tcDesc.getText();
		
		
		if((testCaseName.equals(tcName))&&(testCaseDesc.equals(description)))
		{
			log.info("Pass-Successfully Test Case Name and Description is Added");
		
		}
		else
		{
			log.info("Name or Description is not Added");
			
		}
		
		
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		   
		}
	}
   
   
   /* ****************************************************
	   * Method Name   : enterTestCaseDetail(String[] details) 
	  * Purpose    : To enter Test Case Detail( priority,altId,tags,comment)
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	
	public boolean enterTestCaseDetail(String[] details) throws Exception
	{
		try
		{
			bp=new BasePage();

		//Entering Data to the Priority field
			
		Actions a1=new Actions(driver);
		a1.moveToElement(enterPriority).click().pause(2000).sendKeys(details[0]).sendKeys(Keys.ENTER).perform();
		
		
		
		//Entering Data to the AltID field
		
		a1.moveToElement(enterAltID).click().pause(2000).sendKeys(details[1]).perform();
		a1.sendKeys(Keys.ENTER).build().perform();
		a1.sendKeys(Keys.ENTER).build().perform();
	
		
		//bp.waitForElement();
		
		//Entering Data to the Tags field
        a1.moveToElement(enterTags).click().pause(2000).sendKeys(details[2]).perform();
		a1.sendKeys(Keys.ENTER).build().perform();
		a1.sendKeys(Keys.ENTER).build().perform();
		
		//bp.eraseText(l1.get(5));
		//bp.waitForElement();
		//Entering Data to the Comment field
		a1.moveToElement(enterComment).click().pause(2000).sendKeys(details[3]).perform();
		a1.sendKeys(Keys.ENTER).perform();
		a1.sendKeys(Keys.TAB).perform();
		
		//Validation
		bp.waitForElement();
		String priority=l1.get(2).getText();
		String altID=l1.get(3).getText();
		String tags=l1.get(4).getText();
		String comment=l1.get(5).getText();
		
		if((priority.equals(details[0]))&&(altID.equals(details[1]))&&(tags.equals(details[2]))&&(comment.equals(details[3])))
		{
			log.info("Pass- Priority and AltID and Tags and Comment is Added Succssfully");
		}
		else
		{
			log.info("Priority or AltID or Tags or Comment is not Added");	
		}
	   
//		
		return true;
//		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
			//return false;
		}
	}
		
	/* ****************************************************
	   * Method Name   : enterTestCaseStepDetail(String[] stepDetails )
	  * Purpose        :  To enter Test Case Step Detail
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean enterTestCaseStepDetail(String[] stepDetails ) throws Exception
	{
		bp=new BasePage();
		
	  Actions a3=new Actions(driver);
	  for(int i=1;i<=7;i++)
	  {
			a3.sendKeys(Keys.DOWN).perform();
	  }
	
         try
		{	
      //  bp.waitForElement();
		//bp.waitForElement();//
//		WebDriverWait wait=new WebDriverWait(driver,20);
//		wait.until(ExpectedConditions.elementToBeClickable(TestStep));
//		a3.moveToElement(TestStep).click().build().perform();
		bp.waitForElement();
		
		//addTestStep.click();
		WebElement addSteps=driver.findElement(By.xpath(addTestStep));
		
		
		
		
		
			
		for(int i=0;i<=stepDetails.length-1;i=i+3)
		{
		addSteps.sendKeys(stepDetails[i]);
		bp.waitForElement();
		
		Actions a1=new Actions(driver);
		a1.sendKeys(Keys.TAB).perform();
		a1.sendKeys(stepDetails[i+1]).perform();
		bp.waitForElement();
		
		a1.sendKeys(Keys.TAB).perform();
		a1.sendKeys(stepDetails[i+2]).perform();
		bp.waitForElement();
		
		nextBtn.click();
		bp.waitForElement();

		
		}
		
		bp.waitForElement();
		
		//driver.findElement(By.xpath(saveBtnConfirm)).click();
		bp.waitForElement();
		log.info("Test Case step details are entered successfully");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
			//e.printStackTrace();
			//return false;
		}
         
	}

	
	/* ****************************************************
	   * Method Name   : uploadAttachement(String[] filePath)
	  * Purpose    : To upload Attachement
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean uploadAttachement(String[] filePath) throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
			
			attachements.click();
			Actions a3=new Actions(driver);
			for(int i=1;i<=3;i++)
			  {
					a3.sendKeys(Keys.DOWN).perform();
			  }
		bp.waitForElement();
		for(int i=0;i<=filePath.length-1;i++)
		{
		
		driver.findElement(By.xpath(browse)).click();
		
		bp.waitForElement();
		Runtime.getRuntime().exec(filePath[i]);
		bp.waitForElement();
		}
		
		log.info("File Uploaded Successfully");
		
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.info("File is not Uploaded");
			throw e;
			//return false;
		}
		
		
	}
	/* ****************************************************
	   * Method Name   : enterEstimatedTime(String day,String hr,String mn) 
	  * Purpose    : To enter Estimated Time
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
//	public boolean enterEstimatedTime(String day,String hr,String mn) throws Exception
//	{
//		
//		try
//		{
//		
//	    estimatedTime.click();
//		WebElement days=driver.findElement(By.xpath(days_1));
//		days.clear();
//		Actions a1=new Actions(driver);
//		a1.sendKeys(day).perform();
//		WebElement hour=driver.findElement(By.xpath(hour_1));
//		hour.clear();
//		a1.sendKeys(hr).perform();
//		WebElement min=driver.findElement(By.xpath(minute));
//		min.clear();
//		a1.sendKeys(mn).perform();
//		
//		a1.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
//		
//		
//		
//		String validate_time=day+":"+hr+":"+mn;
////		System.out.println("time-"+validate_time);
//		bp.waitForElement();
//		String time=driver.findElement(By.xpath(".//*[@id='testcase-estimated-time']/zephyr-inline-edit/div/div/span[1]/zui-estimated-time/div")).getText();
////		System.out.println("validate_time-"+time);
////		log.info("Pass- Estimated Time Successfully Added");
//		
//		if(validate_time.equals(time))
//		{
//			log.info("Pass- Estimated Time Successfully Added");
//		}
//		
//		
//	   
//		
//		return true;
//		}	
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			throw e;
//			//return false;
//		
//		}	
//		
//	}
	public boolean enterEstimatedTime(String day,String hr,String mn) throws Exception
	{
		
		try
		{
		bp=new BasePage();
	    estimatedTime.click();
	    bp.waitForElement();
		WebElement days=driver.findElement(By.xpath(days_1));
		days.clear();
		Actions a1=new Actions(driver);
		a1.sendKeys(day).perform();
		a1.sendKeys(Keys.TAB).perform();
//		System.out.println("day");
		//WebElement hour=driver.findElement(By.xpath(hour_1));
		//hour.clear();
		a1.sendKeys(hr).perform();
		a1.sendKeys(Keys.TAB).perform();
		System.out.println("hr");
//		bp.waitForElement();
//		WebElement min=driver.findElement(By.xpath(minute));
//		min.clear();
		a1.sendKeys(mn).perform();
		System.out.println("mn");
		a1.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		
		
		
		String validate_time=day+":"+hr+":"+mn;
//		System.out.println("time-"+validate_time);
		bp.waitForElement();
		String time=driver.findElement(By.xpath(".//*[@id='testcase-estimated-time']/zephyr-inline-edit/div/div/span[1]/zui-estimated-time/div")).getText();
//		System.out.println("validate_time-"+time);
//		log.info("Pass- Estimated Time Successfully Added");
		
		if(validate_time.equals(time))
		{
			log.info("Pass- Estimated Time Successfully Added");
		}
		
		
	   
		
		return true;
		}	
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
			//return false;
		
		}	
		
	}
	
	/* ****************************************************
	   * Method Name   : enterMultipleTags(String[] tags)
	  * Purpose    : To enter Multiple Tags in Test Case Detail
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */

	public boolean enterMultipleTags(String[] tags) throws Exception
	{
		try
		{
		bp=new BasePage();
		Actions a1=new Actions(driver);
		for(int j=1;j<=2;j++)
		  {
				a1.sendKeys(Keys.DOWN).perform();
		  }
		bp.waitForElement();
		a1.moveToElement(enterTags).click().perform();
		
		for(int i=0;i<=tags.length-1;i++)
		{
			    bp.waitForElement();
			    a1.sendKeys(tags[i]).pause(3000).build().perform();
				a1.sendKeys(Keys.ENTER).build().perform();
				
		}
		bp.waitForElement();
		a1.pause(1200).sendKeys(Keys.ENTER).build().perform();
		bp.waitForElement();
		return true;
				}
	
	  catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
	}
	public void verifyStepDetailHistory()
	{
		
	}
	
	/* ****************************************************
	   * Method Name   : editTags(String[] tags) 
	  * Purpose    : To edit Tags in test case detail view
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	//Modified//27/7/2017////////
	//purpose-For editing tags in Test Case detail view
	
	public boolean editTags(String[] tags) throws Exception 
	{
		try
		{
			
		
		BasePage bp=new BasePage();
		bp.waitForElement();
		
		Actions a2=new Actions(driver);
		a2.moveToElement(l1.get(4)).click().perform();
	    a2.moveToElement(eraseTags).click().perform();
	  
	    //Entering Data to the Tags field
		for(int k=0;k<=tags.length-1;k++)
		{	
          a2.sendKeys(tags[k]).pause(2000).perform();
		  a2.sendKeys(Keys.ENTER).build().perform();
		}
		a2.sendKeys(Keys.ENTER).build().perform();	
		return true;
	}
		
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
	}
	
	/* ****************************************************
	   * Method Name   : edtitMultipleTestCase(String[] detailField,String[] automationField)
	  * Purpose    : To edit Multiple Selected Test Case fields
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	//Modified 26/7/2017//
	
	public boolean editMultipleTestCase(String[] detailField,String[] automationField) throws Exception
	{
		try
		{
		
		bp=new BasePage();
		bp.waitForElement();
		
		if(detailField[0]!="")
		{
		altId.clear();
		altId.sendKeys(detailField[0]);
		}
		if(detailField[1]!="")
		{
		comments.clear();
		comments.sendKeys(detailField[1]);
		}
//		//Newly tags Added
//		WebElement ele=driver.findElement(By.xpath(".//*[@id='zee-create-edit-modal-tcr_3']/div/div/div[2]/zui-modal-body/div/div/form/div[1]/div[1]/div[3]/div/zee-select/span/span[1]/span"));
//		Actions a2=new Actions(driver);
//		a2.moveToElement(ele).sendKeys(keysToSend)
//		
		if(detailField[2]!="")
		{
		bp.waitForElement();
		prioritySeection.click();
		bp.waitForElement();
		
		String validatePriority= driver.findElement(By.xpath(priority1+detailField[2]+priority2)).getText();
		//System.out.println(validatePriority);
		
		if(detailField[2].equalsIgnoreCase(validatePriority))
		{
			driver.findElement(By.xpath(priority1+detailField[2]+priority2)).isEnabled();
			//System.out.println(driver.findElement(By.xpath(priority1+detailField[2]+priority2)).isEnabled());
			driver.findElement(By.xpath(priority1+detailField[2]+priority2)).click();
		}
		
		}
		if(automationField[0].equalsIgnoreCase("Automated Script") && (automationField[0])!="" )
		{
			bp=new BasePage();
		  ChkAutomatedScript.click();
		  bp.waitForElement();
		
		 scriptName.clear();
		 scriptName.sendKeys(automationField[1]);
		 bp.waitForElement();
		 
		 scriptId.clear();
		 scriptId.sendKeys(automationField[2]);
		 bp.waitForElement();
		 
		 scriptPath.clear();
		 scriptPath.sendKeys(automationField[3]);
		 bp.waitForElement();
		 
		 
		}
		
		
		//driver.findElement(By.xpath(SaveBtnInMultEdit)).click();
		 return true;
		}
		 catch(Exception e)
		{
			 e.printStackTrace();
			 throw e;
		}
		 
		 
	}
	
	/* ****************************************************
	   * Method Name   : verifyEdtitMultipleTestCase(String[] detailField,String[] automationField) 
	  * Purpose    : To verify Edit Multiple Test Case fields
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean verifyEditMultipleTestCase(String[] detailField,String[] automationField) throws Exception
	{
		try
		{
		String verifyAltId=altId.getText();
		System.out.println(verifyAltId);
		String verifyComments=comments.getText();
		System.out.println(verifyComments);
		String verifyPriority=prioritySeection.getText();
		System.out.println(verifyPriority);
		
		if(detailField[0].equals(verifyAltId)||detailField[1].equals(verifyComments)||detailField[2].equals(verifyPriority))
		{
			log.info("Detail field edited Successfully");
		}
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	public boolean moveTestSteps(String srcNo,String destNo) throws Exception
	{
		try
		{
			TestStep.click();
		String step1=".//*[@id='zephyr-editable-row-";
		String step2="']/td[2]/div/div[1]";
		
		WebElement ele=driver.findElement(By.xpath(step1+srcNo+step2));
		System.out.println(ele);
		WebElement ele1=driver.findElement(By.xpath(step1+destNo+step2));
		Actions a1=new Actions(driver);
		a1.moveToElement(ele).perform();
		a1.clickAndHold(ele).perform();
		a1.release(ele1).perform();
		
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
		//a1.dragAndDrop(ele,ele1).perform();
		//WebElement ele1=driver.findElement(By.xpath(".//*[@class='fa fa-gear']"));
		//a1.moveToElement(ele1).perform();
		//a1.click().perform();
		
		//driver.findElement(By.xpath(".//*[@id='zephyr-editable-row-1']/td[2]/div/div[1]"))
	}
	
	
	/* ****************************************************
	   * Method Name   : deleteAttachement(String[] attachement_file)
	  * Purpose    : To delete Attachements
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	
	///Newly Added
	
	public boolean deleteAttachement(String[] attachement_file) throws Exception
	{
		try
		{
		attachements.click();
		
		BasePage bp=new BasePage();
		
		
		bp.waitForElement();
		for(int i=0;i<=attachement_file.length-1;i++)
		{
		WebElement Ele=driver.findElement(By.xpath(attachFile1+attachement_file[i]+attachFile2));
		Actions a1=new Actions(driver);
		a1.moveToElement(Ele).perform();
		a1.moveToElement(deleteAttachements).click().perform();
		bp.waitForElement();
		a1.moveToElement(deleteAttachBtn).click().perform();
		log.info("Attachement successfully deleted");
		}
		
		return true;
		}
		
		catch(Exception e)
		{
			log.info("Attachement File not present");
			throw e;
			//return false;
		}
	}
	
	/* ****************************************************
	   * Method Name   : enterAutomationScriptField(String script_Name,String script_Id,String script_Path) 
	  * Purpose    : To enter Automation Script Field
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean enterAutomationScriptField(String script_Name,String script_Id,String script_Path) throws Exception
	{
		try
		{
		 bp=new BasePage();
		  ChkAutomatedScript.click();
		
		 scriptName.clear();
		 scriptName.sendKeys(script_Name);
		 
		 scriptId.clear();
		 scriptId.sendKeys(script_Id);
		 
		 scriptPath.clear();
		 scriptPath.sendKeys(script_Path);
		 
		 bp.waitForElement();
		 saveInAutoScript.click();
		 bp.waitForElement();
		 confirmSaveInAutoScript.click();

		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}
	
	/* ****************************************************
	   * Method Name   : deleteTestSteps(String testStepNo)
	  * Purpose    : To delete Test Steps from test case
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean deleteTestSteps(String testStepNo) throws Exception
	{
		try
		{
		BasePage bp=new BasePage();
		TestStep.click();
		String step1=".//*[@id='zephyr-editable-row-";
	   String step2="']/td[1]";    //modified
	   String deleteOptions="//a[text()='Delete']";                        // ht//ml/body/div[2]/div/ul/li[1]"
		
		WebElement ele=driver.findElement(By.xpath(step1+testStepNo+step2));
		System.out.println("Test step selected");
		String option1="(//span[@class='fa fa-gear'])[";
		String option2="]";
		WebElement option=driver.findElement(By.xpath(option1+testStepNo+option2));
		
		bp.waitForElement();
		System.out.println("Moved to option");
		Actions a1=new Actions(driver);
		a1.moveToElement(ele).perform();
		bp.waitForElement();
		a1.moveToElement(option).click().perform();
		bp.waitForElement();
		
		WebElement deleteOption=driver.findElement(By.xpath(deleteOptions));
		a1.moveToElement(deleteOption).click().perform();
		bp.waitForElement();
		
		String delete_Button="(//li/a[text()='Delete'])[";
		
		// WebElement deleteBtn=driver.findElement(By.xpath("(//li/a[text()='Delete'])"));         // OLD 6.0 (/*[text()='Delete'])[5]
	   WebElement deleteBtn=driver.findElement(By.xpath(delete_Button+testStepNo+option2));
		 a1.moveToElement(deleteBtn).click().perform();
	     
	    return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}
	
	/* ****************************************************
	   * Method Name   : unselectAutomationCheckBox()
	  * Purpose    : To unselect Automation CheckBox in test case
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	//25/7/2017
	//Added 
	public boolean unselectAutomationCheckBox() throws Exception
	{
		try
		{
		if(ChkAutomatedScript.isSelected()==true)
		{
		  ChkAutomatedScript.click();
		}
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/* ****************************************************
	   * Method Name   : editTagsInMultipleTesCase(String[] multipleTags) 
	  * Purpose    : To edit Tags In Multiple Tes Case
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	//added 
	//creation date-26/07/2017
	//Purpose-For editing tags in Multiple test case Edit Window
	public boolean editTagsInMultipleTesCase(String[] multipleTags) throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		//eraseTags.click();
		Actions a2=new Actions(driver);
		a2.moveToElement(tags).click().perform();
//		a2.moveToElement(eraseTags).click().perform();
//		
		for(int k=0;k<=multipleTags.length-1;k++)
		{	
          a2.sendKeys(multipleTags[k]).pause(2000).perform();
		  a2.sendKeys(Keys.ENTER).build().perform();
		}
		
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	 /* ****************************************************
	   * Method Name   : dnDForTestStepsDetails(int fromStepNum,int toStepNum) 
	  * Purpose    : To dnD the teststeps in Testcase Steps
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	 
	 public boolean dnDForTestStepsDetails(int fromStepNum,int toStepNum) throws Exception
	 {
	  try
	  {
	   bp=new BasePage();
	   TestStep.click();
	   String Dnd1="//*[@id='zephyr-editable-row-";
	   String Dnd2="']";
	   String startPosition=Dnd1+fromStepNum+Dnd2;
	   String endPosition=Dnd1+toStepNum+Dnd2;
	   WebElement initStepNum=driver.findElement(By.xpath(startPosition));
	   Actions act=new Actions(driver);
	   act.clickAndHold(initStepNum).perform();
	   log.info("Pass - Step number '"+fromStepNum+"' is Selected and holded for DnD");
	   bp.waitForElement();
	   WebElement destStepNum=driver.findElement(By.xpath(endPosition));
	   act.release(destStepNum).perform();
	   log.info("Pass - TestStep is DnD to Step number '"+toStepNum+"' ");
	   
	   return true;
	  }
	  catch(Exception e)
	  {
	   e.printStackTrace();
	   throw e;
	  }
	 }
	 
	/* ****************************************************
	  * Method Name			: dragAndDrop(WebElement source,WebElement destination) 
	 * Purpose				: To dnD the teststeps in Testcase Steps
	 * Author				: OPAL1
	 * Date Created			: 27/07/17
	 * Date Modified		:
	 * Reviewed By			: Opal4
	 * ******************************************************
	 */
	
	public void dragAndDrop(WebElement source,WebElement destination)
	{
		try
		{
			bp=new BasePage();
			Actions act=new Actions(driver);
			act.clickAndHold(source).perform();
			bp.waitForElement();
			act.release(destination).perform();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	   
	 
	 public boolean editTestSteps(int stepNum,String edit[]) throws Exception
	 {
	  try
	  {
	   bp=new BasePage();
	   TestStep.click();
	   String Dnd1="//*[@id='zephyr-editable-row-";
	   String Dnd2="']/td[3]/div/div[1]";
	   String testStepNum=Dnd1+stepNum+Dnd2;
	   WebElement edit1=driver.findElement(By.xpath(testStepNum));
	   bp.waitForElement();
	   bp.eraseText(edit1);
			bp.waitForElement();
	   Actions act=new Actions(driver);
	   act.sendKeys(edit[0]).perform();
	   bp.waitForElement();
	   act.sendKeys(Keys.TAB).sendKeys(edit[1]).perform();
	   bp.waitForElement();
	   act.sendKeys(Keys.TAB).sendKeys(edit[2]).perform();
	   bp.waitForElement();
	   act.sendKeys(Keys.TAB).perform();
	   //clickStepSave.click();	
	   
	   return true;
	  }
	  catch(Exception e)
	  {
	   e.printStackTrace();
	   throw e;
	  }
	 }
     public void validate()
	{
		
			log.info("Fail - Testcase Modification Failed");
			prioritySeection.click();
			
	}
	 
	 /* ****************************************************
	   * Method Name   : editCustomFields(String text,String longText,String number,String checkBox,String pickupList,String date) 
	  * Purpose    : To edit Custom Fields of multi selected test cases
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	 public boolean editCustomFields(String text,String longText,String number,String checkBox,String pickupList,String date) throws Exception
	 {
	 try
		{
	  //edit_TestCase.click();
	  bp=new BasePage();
	  bp.waitForElement();
	  
	  if(text!="")
	  {
	   bp.eraseText(customText1);
	   Actions a1=new Actions(driver);
	   a1.sendKeys(text).perform();
	   //textField.sendKeys();
	  }
	  if(longText!="")
	  {
	   
	   bp.eraseText(customlongText1);
	   Actions a1=new Actions(driver);
	   a1.sendKeys(longText).perform();
	  }
	  if(number!="")
	  {
	   bp.eraseText(customNumber1);
	   Actions a1=new Actions(driver);
	     a1.sendKeys(number).perform();
	  }
	  if(checkBox!="")
	  {
		  System.out.println("Inside If statement- "+checkBox);
		  Actions a2=new Actions(driver);
		  a2.moveToElement(customChkbox1).click().perform();
	   //checkboxField.click();
	  }
	  if(pickupList!="")
	  {
	   Select s1=new Select(customPicklist1);
	   s1.selectByVisibleText(pickupList);
	   //pickuplistField.sendKeys(pickupList);
	  }
	   if(date!="")
	   {
		   dateField.click();
		   String a="(//span[text()='";
		   String b="'])[1]";
		   String dateNum=a+date+b;
		   driver.findElement(By.xpath(dateNum)).click();
	   }
	  return true;
		}
	 catch(Exception e)
	 {
		 e.printStackTrace();
		 throw e;
		// return false;
	 }
	  
	 }
	  
	 /* ****************************************************
	   * Method Name   : enterCustomFields(String text,String longText,String number,String checkBox,String pickupList,String date)
	  * Purpose    : To enter custom fields
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */

	
	/* ****************************************************
	   * Method Name   : verifyAttachementFile(String fileName) 
	  * Purpose    : To verify Attachement File
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
 //02/08/2017
	//Added
	public boolean verifyAttachementFile(String fileName) throws Exception
	{
        
		try
		{
		BasePage bp=new BasePage();
		
		
		bp.waitForElement();
		WebElement Ele=driver.findElement(By.xpath(attachFile1+fileName+attachFile2));
		String validateFile=Ele.getText();
		//Assert.assertEquals(fileName, validateFile);
		Actions a1=new Actions(driver);
		a1.moveToElement(Ele).perform();
		
		Assert.assertEquals(fileName, validateFile);
		

	
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/* ****************************************************
	   * Method Name   : saveMultipleTestCaseEdit() 
	  * Purpose    : To save Multiple Test Case Edit
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	
	public boolean saveMultipleTestCaseEdit() throws Exception
	{
		try
		{
		 bp=new BasePage();
		 saveInAutoScript.click();
	   bp.waitForElement();
	   String info=updatedTcInfo.getText();
	   System.out.println(info);
		 bp.waitForElement();
		 bp.waitForElement();
		 confirmSaveInAutoScript.click();
		 return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	
	////Verication methods
	
	
	public boolean verifyTestCaseName(String name) throws Exception
	{
		String tcName= l1.get(0).getText();
		//String description=l1.get(1).getText();
		try
		{
		   if((name.equals(tcName)))
		   {
			log.info("Pass-Successfully Test Case Name Added");
		   }
		  return true;
		}
          
		catch(Exception e)
          {
			
			  log.info("Fail-Test Case Name is not Added");
			  throw e;
        	  //return false;
          }
  
	}
	
//	public boolean verifyTestCaseDescription(String desc)
//	{
//		
//		
//		String description=l1.get(1).getText();
//		Assert.assertEquals(desc, description);
//		
//		return true;
//		
//		
//	}
//	
//	public boolean verifyPriority(String priority)
//	{
//		String actPriority=l1.get(2).getText();
//		Assert.assertEquals(priority, actPriority);
//		return true;
//	}

//public boolean verifyTestCaseDetail(String[] details))
//{
//	try
//	{
//	bp.waitForElement();
//	String priority=l1.get(2).getText();
//	String altID=l1.get(3).getText();
//	String tags=l1.get(4).getText();
//	String comment=l1.get(5).getText();
//	
//	if((priority.equals(details[0]))&&(altID.equals(details[1]))&&(tags.equals(details[2]))&&(comment.equals(details[3])))
//	{
//		log.info("Pass- Priority and AltID and Tags and Comment is Added Succssfully");
//	}
//	else
//	{
//		log.info("Fail-Priority or AltID or Tags or Comment is not Added");	
//	}
//   
//	
//	return true;
//	
//	}
//	catch(Exception e)
//	{
//		return false;
//	}
 
	
	//14-08-17
	public boolean editTeststep(int stepNum,String edit[]) throws Exception
	  {
	   try
	   {
	    bp=new BasePage();
	    TestStep.click();
	    String Dnd1="//*[@id='zephyr-editable-row-";
	    String Dnd2="']//td[3]/div/div[1]";                                      //6.0 "']/td[2]/div/div[1]";
	    String testStepNum=Dnd1+stepNum+Dnd2;
	    WebElement edit1=driver.findElement(By.xpath(testStepNum));
	    bp.waitForElement();
	    //bp.eraseText(edit1);
	    Actions act=new Actions(driver);
	    act.click(edit1).doubleClick().sendKeys(Keys.DELETE).sendKeys(Keys.TAB).perform();
	    bp.waitForElement();
	    act.doubleClick().sendKeys(Keys.DELETE).sendKeys(Keys.TAB).perform();
	    bp.waitForElement();
	    act.doubleClick().sendKeys(Keys.DELETE).sendKeys(Keys.TAB).perform();
	    bp.waitForElement();
	   // clickStepSave.click();
	    return true;
	   }
	   catch(Exception e)
	   {
	    e.printStackTrace();
	    throw e;
	   }
	  }
	
	/* ****************************************************
	  * Method Name			: .sendKeys(Keys.ENTER)(String[] tags)
	 * Purpose				: enters multiple tags
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	
	
	public boolean tagsInBulkEdit(String[] tags) throws Exception
	{
		try
		{
		Actions a1=new Actions(driver);
		a1.moveToElement(tagsInBulkEdit).click().perform();
		for(int i=0;i<=tags.length-1;i++)
		{
			    a1.sendKeys(tags[i]).pause(3000).build().perform();
				a1.sendKeys(Keys.ENTER).build().perform();
				
		}
		a1.sendKeys(Keys.ENTER).sendKeys(Keys.ENTER).build().perform();
	  
		return true;
				
		
		}
	
	  catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
	}
	
	
	/* ****************************************************
	  * Method Name			: editEstimatedTimeInMultiTc(String[] detailField,String[] automationField)
	 * Purpose				: edits the multiple tags
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	public boolean editEstimatedTimeInMultiTc(String day,String hour,String min)
	{
		try
		{
			estimatedTimeMultiedit.clear();
			Actions a1=new Actions(driver);
			a1.sendKeys(day).sendKeys(Keys.TAB).perform();
			a1.sendKeys(hour).sendKeys(Keys.TAB).perform();
			a1.sendKeys(min).perform();
			log.info("Pass- Estimated Time Successfully Added");
			return true;	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
	 /* ****************************************************
	  * Method Name			: resetTeststeps()
	 * Purpose				: To dnD the teststeps in Testcase Steps
	 * Author				: OPAL1
	 * Date Created			: 27/07/17
	 * Date Modified		:
	 * Reviewed By			: Opal4
	 * ******************************************************
	 */
	
	public boolean resetTeststeps(int stepNum,String edit[]) throws Exception
	{
		try
		{
			bp=new BasePage();
			TestStep.click();
			String Dnd1="//*[@id='zephyr-editable-row-";
			String Dnd2="']//td[3]/div/div[1]";                                   // 6.0 "']/td[2]/div/div[1]";
 			String testStepNum=Dnd1+stepNum+Dnd2;
			WebElement edit1=driver.findElement(By.xpath(testStepNum));
			bp.waitForElement();
			bp.eraseText(edit1);
			Actions act=new Actions(driver);
			act.sendKeys(edit[0]).perform();
			bp.waitForElement();
			act.sendKeys(Keys.TAB).sendKeys(edit[1]).perform();
			bp.waitForElement();
			act.sendKeys(Keys.TAB).sendKeys(edit[2]).perform();
			bp.waitForElement();
			//cancelStepDetails.click();
			log.info("Pass - clicked on Cancel to Restet the Step");
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	
	 public void selectdate() throws Exception
	 {
	  bp=new BasePage();
	     try {
	      
	    bp.waitForElement();
	      clickOnCalender.click();
	      bp.waitForElement();
	      clickOnDate.click();
	      
	  } catch(Exception e)
			{
			e.printStackTrace();
			throw e;
		}
	  
	 }
	 
	 
	 public boolean enterAutomationScriptFieldInTestCasePage(String check,String script_Name,String script_Id,String script_path) throws Exception
	  {
	   try
	   {
	   bp=new BasePage();
	   Actions a1=new Actions(driver);
	   bp.waitForElement();
	   if(check!="")
	   {
	   ChkAutomatedScriptInDetail.click();
	   bp.waitForElement();
	   
	   }
	   a1.moveToElement(enterScriptName).click().sendKeys(script_Name).pause(1200).sendKeys(Keys.ENTER).sendKeys(Keys.TAB).perform();
	   
	   a1.moveToElement(enterScriptID).click().sendKeys(script_Id).pause(1200).sendKeys(Keys.TAB).perform();

	   a1.moveToElement(enterScriptPath).click().sendKeys(script_path).pause(1200).sendKeys(Keys.TAB).perform();
	   bp.waitForElement();
	   
	   return true;
	   }
	   catch(Exception e)
	   {
	   e.printStackTrace();
	   throw e;
	  }
	   }
	 
	 
	 public boolean unselectAutomationField() throws Exception
	 {
		 try
		 {
		 ChkAutomatedScriptInDetail.click();
		 return true;
		 }
		 catch(Exception e)
			{
			e.printStackTrace();
			throw e;
			}
		 
		 
			}
		 
		
		 
		 public boolean enterCustomFieldInTestCasePage(String text,String longText,String number,String checkBox,String pickupList,String date) throws Exception
		 {
			 try
				{
				bp=new BasePage();
				 bp.waitForElement();
				if(text!="")
				{
					 bp.eraseText(customText);
					 Actions a1=new Actions(driver);
				     a1.sendKeys(text).sendKeys(Keys.TAB).perform();
				}
			  bp.waitForElement();
				if(longText!="")
				{
					bp.eraseText(customLongText);
					 Actions a1=new Actions(driver);
				      a1.sendKeys(longText).sendKeys(Keys.TAB).perform();
					//longTextField.sendKeys(longText);
				}
			  bp.waitForElement();
				if(number!="")
				{
					bp.eraseText(customNumber);
					 Actions a1=new Actions(driver);
				      a1.sendKeys(number).sendKeys(Keys.TAB).perform();
				   //numberField.sendKeys(number);
				}
			  bp.waitForElement();
				if(checkBox!="")
				{
					 Actions a1=new Actions(driver);
					 a1.moveToElement(customCheckbox).click().perform();
					
				}
			  bp.waitForElement();
				if(pickupList!="")
				{
					  Actions a1=new Actions(driver);
				   a1.moveToElement(customPicklist).click().sendKeys(pickupList).sendKeys(Keys.ENTER).perform();
					
					//pickuplistField.sendKeys(pickupList);
				}
				bp.waitForElement();
			  if(date!="")
			   {
				  dateField1.click();                                   // 6.0 dateField
			  String a="(//span[text()='";
				  String b="'])[1]";                                    // 6.0 "'])[3]";
				  String dateNum=a+date+b;
				  driver.findElement(By.xpath(dateNum)).click();    
			   }

				return true;
				
				}
			 
				catch(Exception e)
				{
					e.printStackTrace();
					throw e;
				}
		 }
		 
		 /***************************25/09/16
			 * @return 
			 * @throws Exception *****************************/
			 public boolean enterTestCaseDetails(String Priority,String AltID,String Comment) throws Exception
			 {
				 try
				 {
					 bp=new BasePage();
				 bp.waitForElement();
				 Actions a1=new Actions(driver);
				 a1.moveToElement(enterPriority).click().sendKeys(Priority).pause(1200).sendKeys(Keys.ENTER).perform();
				 //priority.sendKeys(Priority);
				 bp.waitForElement();
				 a1.moveToElement(enterAltID).click().pause(1200).sendKeys(AltID).pause(1200).sendKeys(Keys.ENTER).perform();
				//altID.sendKeys(AltID); 
				 bp.waitForElement();
				 a1.moveToElement(enterComment).click().pause(1200).sendKeys(Comment).pause(1200).sendKeys(Keys.ENTER).perform();
				//comment.sendKeys(Comment);
				 a1.sendKeys(Keys.TAB).perform();
				 bp.waitForElement();
				return true;
				 }
				 catch(Exception e)
					{
						e.printStackTrace();
						throw e;
					}
			 }
			 
			 
			//added on 27/09/17
			
			 public boolean enterMultipletags(String[] tags) throws Exception
			 {
			  try
			  {
			  Actions a1=new Actions(driver);
			  bp=new BasePage();
			  bp.waitForElement();
			  a1.moveToElement(enterTags).click().perform();
			  bp.waitForElement();
			  for(int i=0;i<=tags.length-1;i++)
			  {
			       a1.sendKeys(tags[i]).pause(3000).build().perform();
			    a1.sendKeys(Keys.ENTER).build().perform();
			    
			  }
			 
			  ////zephyr-inline-edit//button[2]
			  a1.pause(1200).sendKeys(Keys.ENTER).build().perform();
			  bp.waitForElement();
			  return true;
			    }
			 
			   catch(Exception e)
			 {
			  e.printStackTrace();
			  throw e;
			 }
			 }
			 
			 public boolean enterCustomFields(String text,String longText,String number,String checkBox,String pickupList,String date) throws Exception 
			 {
			  try
			  {
			  bp=new BasePage();
			   bp.waitForElement();
			  if(text!="")
			  {
			    bp.eraseText(customText);
			    Actions a1=new Actions(driver);
			       a1.pause(1200).sendKeys(text).sendKeys(Keys.TAB).perform();
			  }
			   bp.waitForElement();
			  if(longText!="")
			  {
			   bp.eraseText(customLongText);
			    Actions a1=new Actions(driver);
			        a1.pause(1200).sendKeys(longText).sendKeys(Keys.TAB).perform();
			   //longTextField.sendKeys(longText);
			  }
			   bp.waitForElement();
			  if(number!="")
			  {
			   bp.eraseText(customNumber);
			    Actions a1=new Actions(driver);
			        a1.pause(1200).sendKeys(number).sendKeys(Keys.TAB).perform();
			     //numberField.sendKeys(number);
			  }
			   bp.waitForElement();
			  if(checkBox!="")
			  {
			    Actions a1=new Actions(driver);
			    a1.moveToElement(customCheckbox).click().perform();
			   
			  }
			   bp.waitForElement();
			  if(pickupList!="")
			  {
			   
			   bp.waitForElement();
			     Actions a1=new Actions(driver);
			     a1.moveToElement(customPicklist).click().pause(1200).sendKeys(pickupList).sendKeys(Keys.ENTER).perform();
			   
			   //pickuplistField.sendKeys(pickupList);
			  }
			  bp.waitForElement();
			   if(date!="")
			    {
			    customDate.click();
			    String a="(//span[text()='";
			    String b="'])[1]";
			    String dateNum=a+date+b;
			    driver.findElement(By.xpath(dateNum)).click();    
			    }

			  return true;
			  
			  }
			  catch(Exception e)
			  {
			   e.printStackTrace();
			   throw e;
			  }
			 }
			 public boolean displaySortedEstimatedTime(String[] testCaseNo) throws Exception
				{
					try
					{
					BasePage bp=new BasePage();
					bp.waitForElement();
					//int length=testCaseNo.length-1;
					System.out.println("Sorted Estimated Time");
					for(int i=0;i<=testCaseNo.length-1;i++)
					{
							bp.waitForElement();
						WebElement ele=driver.findElement(By.xpath(validateEstmated1+testCaseNo[i]+validateEstmated2));
						System.out.println("time :"+ele.getText());
					}
					//System.out.println(testCaseNo.length+" Test Case Selected");
					return true;
					}
					catch(Exception e)
					{
						e.printStackTrace();
						throw e;
					}
				}
			 
			 /**************************23/10/17***********************************/ //added by srikanth
			 public boolean enterPriority(String[] priority) throws Exception
				 {
				  try
				  {
				  Actions a1=new Actions(driver);
				  bp=new BasePage();
				  enterPriority.click();
				  bp.waitForElement();
				  for(int i=0;i<=priority.length-1;i++)
				  {
				       a1.sendKeys(priority[i]).pause(3000).build().perform();
				    a1.sendKeys(Keys.ENTER).build().perform();
				    
				  }
				 
				  a1.sendKeys(Keys.ENTER).build().perform();
				   
				  return true;
				    }
				 
				   catch(Exception e)
				 {
				  e.printStackTrace();
				  throw e;
				 }
				 }
			 
			 
			 /* ****************************************************
			   * Method Name   : editCustomFields(String text,String longText,String number,String checkBox,String pickupList,String date) 
			  * Purpose    : To edit Custom Fields of multi selected test cases
			  * Author    : OPAL1
			  * Date Created   : 27/07/17
			  * Date Modified  :
			  * Reviewed By   : Opal4
			  * ******************************************************
			  */
			 
			 public boolean editCustomFieldsInMultipleTestCase(String text,String longText,String number,String checkBox,String pickupList,String date) throws Exception
			  {
			  try
			  {
			   //edit_TestCase.click();
			   bp=new BasePage();
			   bp.waitForElement();
			   
			   if(text!="")
			   {
			    bp.eraseText(customText1);
			    Actions a1=new Actions(driver);
			    a1.sendKeys(text).perform();
			    //textField.sendKeys();
			   }
			   if(longText!="")
			   {
			    
			    bp.eraseText(customlongText1);
			    Actions a1=new Actions(driver);
			    a1.sendKeys(longText).perform();
			   }
			   if(number!="")
			   {
			    bp.eraseText(customNumber1);
			    Actions a1=new Actions(driver);
			      a1.sendKeys(number).perform();
			   }
			   bp.waitForElement();
			   if(checkBox!="")
			   {
			    System.out.println("Inside If statement- "+checkBox);
			    Actions a2=new Actions(driver);
			    a2.moveToElement(customChkbox1).click().perform();
			    //checkboxField.click();
			    bp.waitForElement();
			   }
			   if(pickupList!="")
			   {
			    Select s1=new Select(customPicklist1);
			    s1.selectByVisibleText(pickupList);
			    //pickuplistField.sendKeys(pickupList);
			   }
			    if(date!="")
			    {
			     customDate1.click();
			     String a="(//span[text()='";
			     String b="'])[1]";
			     String dateNum=a+date+b;
			     driver.findElement(By.xpath(dateNum)).click();
			    }
			   return true;
			  }
			  catch(Exception e)
			  {
			   e.printStackTrace();
			   throw e;
			  // return false;
			  }
			   
			  }

				 
	 }


