package com.zephyr.reusablemethods;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zephyr.common.AutomationConstants;
import com.zephyr.common.LaunchBrowser;
import com.zephyr.pom.ExportPage_POM;

public class ExportPage
{

	WebDriver driver;
	BasePage bp;
	public Logger log;
	public ExportPage(WebDriver driver)
	{
		//super(driver);
		this.driver = driver;
		PageFactory.initElements(LaunchBrowser.driver, this);
		log=Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
//		BasicConfigurator.configure();
		
	}
	/* ****************************************************
	   * Method Name   : clickOnNodeExport() 
	  * Purpose    : To click On Export option from node
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	////////////////////////////POM//////////////////////////
	@FindBy(xpath="//div[@class='contextMenuIcon fa fa-ellipsis-v']")
	public WebElement options;
	
	@FindBy(xpath="//h4[contains(.,'Customize and Export Reports')]")
	protected WebElement exportPage;
	
	@FindBy(xpath="//input[@id='zui-export-checkbox-select-all']")
	protected WebElement allselectFieldchkBox;
	
	@FindBy(xpath="//a[text()='Unselect All']")/////added////////////////////////////
	protected WebElement allunselectFieldchkBox;
	
	@FindBy(xpath="//div[@id='zui-scroll-heading-tcr_5-101']")
	protected WebElement coverageOption;
	
	@FindBy(xpath="//div[text()='Creation Date']")  //added/////////////////////////////////////////////////
	protected WebElement CreationDateOption;
	
	@FindBy(xpath="/html/body/zui-app/section/zee-test-repository/test-repository-component/div[2]/div[2]/div/div/div[1]/div/div/div/div[3]/div/zui-tcr-bulk-operations/div/zee-export-dialog/zui-export/zui-modal[1]/div/div/div/div[2]/zui-modal-body/div[2]/fieldset/div[2]/div[2]/div/div[2]/div/div/a/i")
	public WebElement startDate;
	
	@FindBy(xpath="/html/body/div[3]/div/datepicker/datepicker-inner/div/daypicker/table/tbody/tr[4]/td[6]")
	public WebElement selectDate;
	
	@FindBy(xpath="/html/body/zui-app/section/zee-test-repository/test-repository-component/div[2]/div[2]/div/div/div[1]/div/div/div/div[3]/div/zui-tcr-bulk-operations/div/zee-export-dialog/zui-export/zui-modal[1]/div/div/div/div[2]/zui-modal-body/div[2]/fieldset/div[2]/div[2]/div/div[3]/div/div/a")
	public WebElement Enddate;
	
	@FindBy(xpath="/html/body/div[3]/div/datepicker/datepicker-inner/div/daypicker/table/tbody/tr[4]/td[8]/button")
	public WebElement selectEndDate;
	
	@FindBy(xpath="//div[@id='zui-scroll-heading-tcr_5-103']")
	protected WebElement priorityOption;
	
	@FindBy(xpath="//div[@id='zui-scroll-heading-tcr_5-104']")
	protected WebElement creatorOption;
	
	@FindBy(xpath="//div[@id='zui-scroll-heading-tcr_5-105']")
	protected WebElement m_aOption;
	
	@FindBy(xpath="//input[@value='Testcase Report']")
	protected WebElement testCaseReportTitle;
	
	@FindBy(xpath=".//*[@id='zui-export-modal-tcr_5']/div/div/div[3]/zui-modal-footer/button[2]")
	public WebElement exportSave;
	
	@FindBy(xpath=".//*[@id='zui-export-modal-tcr_5-download']/div/div/div[3]/zui-modal-footer/button[2]")
	protected WebElement exportDownload;
	
	
	public String nodeExport="//*[@class='vakata-context jstree-contextmenu jstree-default-contextmenu']//a[contains(text(),'Export')]";
	
	public String exportfields="//*[@class='zui-export-label control-label']";
	
	public String selectfields1="//*[@value='";
	public String selectfields2="']";
			
	
	public String coverage1="//span[@for='zui-export-radio-binary-101-";
	public String coverage2="']";
	
	public String m_a1="//span[@for='zui-export-radio-binary-105-";
    public String m_a2="']";
    
    public String reportType1="(//*[@class='zui-export-label control-label'])[";
    public String reportType2="]";
    
    public String outputType1="(//*[@class='zui-export-label control-label'])[";
    public String outputType2="]";
    
    
    public String priorityField="//input[@placeholder='Select Filter Priority']";
    
    public String creatorField="//input[@placeholder='Select Filter Creator']";
    
	
	
	//Search And Export
	@FindBy(xpath=".//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[1]/div[2]/div[1]")
	public WebElement clickOnSearch;

	@FindBy(xpath=".//*[@id='zui-search-textarea']")
	public WebElement clickOnSearchTextArea;
	
	@FindBy(xpath="//zui-zephyr-search/div[1]/div[2]/div/button")
	public WebElement clickOnGoButton;
	
	//@FindBy(xpath=".//*[@id='zui-export-modal-trigger-tcr_5']")
	//public WebElement clickOnExportOption;
	
	@FindBy(xpath=".//*[@id='in-release']")
	protected WebElement inTheseReleaseOption;
	
	@FindBy(id="zui-export-modal-trigger-tcr_5")
	public WebElement export_TestCase;

	//Check Test Case from  Test Case grid
	public String checkTestCase1=".//*[@id='grid-table-tcr']/div[2]/div[";
	public String  checkTestCase2="]/div[1]/div/div/input";
	
	//checkTestCase from Search Grid
	public String checkSearchedTestCase1="//*[@id='grid-table-tcr']/div[2]/div[";
	public String checkSearchedTestCase2="]/div[1]/div/div/input";
	
	//For moving to phase
	protected String phasename1="//*[@data-name='";
	protected String phasename2="']";
	
	
	
	@FindBy(xpath=".//*[@id='zui-export-modal-trigger-tcr_5']")
	 public WebElement clickOnExportOption;
	@FindBy(xpath=".//*[@id='zui-export-modal-tcr_5']/div/div/div[3]/zui-modal-footer/button[2]")
	 public WebElement clickOnSave;

	 //@FindBy(xpath=".//*[@id='grid-table-tcr']/div[2]/div/div[1]/div/div/input")
	  @FindBy(xpath=".//*[@id='zui-export-modal-tcr_5-download']/div/div/div[3]/zui-modal-footer/button[2]")
	  public WebElement clickOnDownload;
	  
	  
	  @FindBy(xpath=".//*[@id='in-release']")
	  public WebElement clickOnRelease;
	  
	  
	 
		
		
		
		
//	public ExportPage_POM(WebDriver driver)
//	{
//		this.driver=driver;
//		PageFactory.initElements(LaunchBrowser.driver, this);
//		
//	}

    //For Export Page Verification
	protected String exportPageTitle="Customize and Export Reports";
	
	
	
	
	//Date_POMs
	@FindBy(xpath="//div[text()='Creation Date']")  //added/////////////////////////////////////////////////
	public WebElement dateFieldOption;
	 
	 @FindBy(id="zui-export-text-filter-dateRange-from")  //added/////////////////////////////////////////////////
	 protected WebElement startDateOption;
	 
	 @FindBy(id="zui-export-text-filter-dateRange-to")  //added/////////////////////////////////////////////////
	 protected WebElement endDateOption;
	 
	 
	 public String start_date11="(//span[text()='";
	 public String start_date22="'])[2]";
	 

	 public String end_date11="(//span[text()='";
    public String end_date22="'])[2]";
    
    @FindBy(xpath="//*[@id='zui-export-text-filter-dateRange-from']")  //added/////07-09-2017////////////////////////////////////////////
	 protected WebElement starDate1;
	 
	 @FindBy(xpath="//*[@id='zui-export-text-filter-dateRange-to']")  //added/////////////////////////////////////////////////
	 protected WebElement endDate1;
	 
	 
	 @FindBy(xpath="//div[text()='Defects']")  //added/////////////////////////////////////////////////
		public WebElement defectsOption;
	 
	 @FindBy(xpath="//div[text()='Execution Status']")  //added/////////////////////////////////////////////////
		public WebElement executionStatusOption;
	 
	 //@FindBy(xpath="//input[@placeholder='Select Filter Execution Status']")  //added/////////////////////////////////////////////////
		public String executionStatusField="//input[@placeholder='Select Filter Execution Status']";
		
		 /**************06/12/17****************/
		 @FindBy(xpath="//div[text()='Coverage'][1]")  //added/////////////////////////////////////////////////
			public WebElement reqcoverageOption;
		 
		 public String output1="//span[text()='";  //Note: * modified as span
			public String output2="']";
	
	public boolean clickOnNodeExport() throws Exception
	{
		try
		{
		bp=new BasePage();
		//bp.waitForElement();
	   options.click();
	   bp.waitForElement();
	   driver.findElement(By.xpath(nodeExport)).click();
	   bp.waitForElement();
	   
	   //Verification Page
	  
	   //String verifyexportPage=exportPage.getText();
	  //System.out.println(verifyexportPage);
	  //System.out.println(exportPageTitle);
	 
	   //  Assert.assertEquals(exportPageTitle,verifyexportPage); 
	     log.info("Successfully landed on Export page");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.info("You are not navigated to Export Page");
			throw e;
		}
	}
	
//	public void verifyclickOnNodeExport()
//	{
//		String expMsg="Customize and Export Reports";
//		String exportPage=driver.findElement(By.xpath("//h4[contains(.,'Customize and Export Reports')]")).getText();
//		Assert.assertEquals(expMsg, exportPage);
//	}
	
	/* ****************************************************
	   * Method Name   : selectAllSelectFields 
	  * Purpose    : To select All Select Fields
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean selectAllSelectFields() throws Exception
	{
		try
		{
		if(allselectFieldchkBox.isSelected()==false)
		{
		allselectFieldchkBox.click();
		log.info("All select fields is selected");
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
	   * Method Name   : unselectAllSelectFields 
	  * Purpose    : To unselect All Select Fields
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean unselectAllSelectFields() throws Exception//////////////added
	{
		try
		{
			if(allunselectFieldchkBox.isSelected()==true)
			{
			allunselectFieldchkBox.click();
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
	   * Method Name   : select Select Fields(String[] selectFieldsName)
	  * Purpose    : To select Select Fields from export page
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean selectSelectFields(String[] selectFieldsName) throws Exception
	{
		try
		{
		
		List<WebElement> allSelectFields=driver.findElements(By.xpath(exportfields));
		for(int k=0;k<=selectFieldsName.length-1;k++)
		{
			int i=101;
			
			for(int j=1;j<=16;j++)
		    {
		     String ch=allSelectFields.get(j).getText();
		     WebElement allSelectField=driver.findElement(By.xpath(selectfields1+i+selectfields2));
			 boolean check=allSelectField.isSelected();
			 System.out.println(ch);
		     System.out.println(check);
		     i++;
           
	       if(selectFieldsName[k].equals(ch))
	         {
		         if(check==false)
		          {
		    	    //System.out.println("Alt id selected");
				    allSelectField.click();
				    //log.info(message);
				  }
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
		
	
	
	/* ****************************************************
	   * Method Name   : selectFilterBy(String coverage,String creation_date,String[] priority,String[] creator,String M_A) 
	  * Purpose    : To select FilterBy from export page
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
public boolean selectFilterBy(String coverage,String creation_date,String[] priority,String[] creator,String M_A) throws Exception
	{
		
	try
	{
	  bp=new BasePage();
	  coverageOption.click();
		for(int i=0;i<=2;i++)
		{
            WebElement ele=driver.findElement(By.xpath(coverage1+i+coverage2));
			//System.out.println(ele);
			String ele1=ele.getText();
			System.out.println(ele1);
			
			if(coverage.equalsIgnoreCase(ele1))
			{
				bp=new BasePage();
				bp.waitForElement();
				ele.click();
			}
		 }
		
		
		
		if(priority[0]!=(""))
		{
	    priorityOption.click();
		bp.waitForElement();
	    //Thread.sleep(2000);
		driver.findElement(By.xpath(priorityField)).click();
		
		
		for(int k=0;k<=priority.length-1;k++)
		{
			Actions a1=new Actions(driver);
			System.out.println(priority[k]);
			a1.sendKeys(priority[k]).sendKeys(Keys.ENTER).perform();
			
			bp.waitForElement();
		}
		Actions a2=new Actions(driver);
		a2.sendKeys(Keys.ENTER).perform();
		a2.sendKeys(Keys.ENTER).perform();
		
		}
		
	if(creator[0]!="")///////Changed
		{
			creatorOption.click();
		
		bp.waitForElement();
		//Thread.sleep(2000);
		driver.findElement(By.xpath(creatorField)).click();
		//WebElement ele=driver.findElement(By.xpath(creatorField));
		String ele_1="//li[contains(@title,'";
		String ele_2="')]";
		Actions a3=new Actions(driver);
		
		for(int j=0;j<=creator.length-1;j++)
		{
			
			a3.pause(1000).sendKeys(creator[j]).pause(1000).sendKeys(Keys.ENTER).perform();
			bp.waitForElement();
		WebElement ele1=driver.findElement(By.xpath(ele_1+creator[j]+ele_2));
		String p=ele1.getAttribute("title");
		System.out.println(p);
		if(creator[j].equalsIgnoreCase(p))
		{
			System.out.println("Creator value entered-"+creator[j]);
			//ele1.click();
			//Actions a3=new Actions(driver);
			a3.sendKeys(Keys.SPACE).perform();
		}
		}
		
		
		Actions a4=new Actions(driver);
		a4.sendKeys(Keys.ENTER).perform();
}

		m_aOption.click();
		for(int l=0;l<=2;l++)
		{
		WebElement ele1=driver.findElement(By.xpath(m_a1+l+m_a2));
		
		String MorA=ele1.getText();
		System.out.println(MorA);
		
		if(M_A.equalsIgnoreCase(MorA))
		{ 
			bp.waitForElement();
			ele1.click();
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
	public void startDate() throws Exception
	{
		try
		{
		CreationDateOption.click();
		startDate.click();
		selectDate.click();
		bp.waitForElement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	public void startAndEndDate() throws Exception
	{
		try
		{
		CreationDateOption.click();
		startDate.click();
		selectDate.click();
		bp.waitForElement();
		Enddate.click();
		selectEndDate.click();
		bp.waitForElement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	
	/* ****************************************************
	   * Method Name   : reportType(String report_Type) 
	  * Purpose    : To select report type in export page
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean reportType(String report_Type) throws Exception 
	{
		try
		{
			bp=new BasePage();
			
			WebElement rType=driver.findElement(By.xpath(output1+report_Type+output2));
			
			String report=rType.getText();
		if(report_Type.equalsIgnoreCase(report))
		{
			bp.waitForElement();
			rType.click();
			//System.out.println(report_Type);
			log.info("Report Type Selected- "+report_Type);
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
	   * Method Name   :  outputType(String outputType) 
	  * Purpose    : To select output Type 
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean outputType(String outputType) throws Exception 
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		
		WebElement oType=driver.findElement(By.xpath(output1+outputType+output2));
		String output =oType.getText();
			oType.click();
			log.info("Output Type Selected-"+output);
			//log.info("Output Type- "+outputType);
	  
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	

	/* ****************************************************
	   * Method Name   : title(String titleName) 
	  * Purpose    : enter title name in export page
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean title(String titleName) throws Exception
	{
		try
		{
		//WebElement title=driver.findElement(By.xpath("//input[@value='Testcase Report']"));
		testCaseReportTitle.clear();
		testCaseReportTitle.sendKeys(titleName);
		
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/* ****************************************************
	   * Method Name   : saveAndDownload()
	  * Purpose    : To save And Download exported file
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean saveAndDownload() throws Exception
	{
		try
		{
		bp=new BasePage();
		Actions a1=new Actions(driver);
		a1.sendKeys(Keys.DOWN).perform();
		a1.sendKeys(Keys.DOWN).perform();
		bp.waitForElement();
		bp.waitForElement();
		//Thread.sleep(2000);
		exportSave.click();
		log.info("Save button is clicked sucessfully");
		
		bp.waitForElement();
		bp.waitForElement();
		WebDriverWait wait1 = new WebDriverWait(driver,AutomationConstants.MAX_EXPLICIT);
	    wait1.until(ExpectedConditions.elementToBeClickable(exportDownload));
		exportDownload.click();
		log.info("Export download button is clicked successfully");
		
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
	public String verifyExcelExport(String xlPath,String sheetName,int rowNum,int cellNum) throws Exception
	{
		try
		{
		FileInputStream fis=new FileInputStream(xlPath);
		Workbook w1=WorkbookFactory.create(fis);
		Sheet s1=w1.getSheet(sheetName);
		Row r1=s1.getRow(rowNum);
		Cell c1=r1.getCell(cellNum);
		String data=c1.getStringCellValue();
		//System.out.println(data);
		return data;
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
	public void verifyPDFExport() throws Exception
	{
	try 
	 {
	    PDDocument document = null;
	    document = PDDocument.load(new File("C:\\Users\\RAJNEESH\\Downloads\\TestcaseTreeExport__1499521034473.pdf"));
	    document.getClass();
	    if (!document.isEncrypted()) 
	    {
	    	
	        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
	        stripper.setSortByPosition(true);
	        PDFTextStripper Tstripper = new PDFTextStripper();
	        String st = Tstripper.getText(document);
	        
	        System.out.println("Text:" + st);
	        
	    }
	    
	    
	    
	} 
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}

	
	
	
	/* ****************************************************
	   * Method Name   : dnDForTestStepsDetails(int fromStepNum,int toStepNum) 
	  * Purpose    :  To select Multiple Test Case From Test Case Grid
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean selectMultipleTestCaseFromGrid(String[] testCaseNo) throws Exception
	{
		try
		{
		BasePage bp=new BasePage();
		bp.waitForElement();
		//int length=testCaseNo.length-1;
//		String s3=testcase1+testCaseName+testcase2;
//		driver.findElement(By.xpath(s3)).click();
		for(int i=0;i<=testCaseNo.length-1;i++)
		{
			bp.waitForElement();
		WebElement ele=driver.findElement(By.xpath(checkTestCase1+testCaseNo[i]+checkTestCase2));
		Actions a1=new Actions(driver);
		a1.moveToElement(ele).click().perform();
		bp.waitForElement();
		//driver.findElement(By.xpath(checkTestCase1+testCaseNo[i]+outputType2)).click();
	
		
		}
		log.info(testCaseNo.length+" Test Case Selected");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/* ****************************************************
	   * Method Name   :  
	  * Purpose    : To dnD the teststeps in Testcase Steps
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	// Search And Add Test Case
	public boolean searchTestCases(String searchOption) throws Exception
	{
		try
		{
			bp=new BasePage();
			//bp.explicitWait(clickOnSearch);
		bp.waitForElement();
		//clickOnSearch.click();
		
		clickOnSearchTextArea.clear();
		clickOnSearchTextArea.sendKeys(searchOption);
		bp.waitForElement();
		clickOnGoButton.click();
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
	   * Method Name   : dnDForTestStepsDetails(int fromStepNum,int toStepNum) 
	  * Purpose    : To dnD the teststeps in Testcase Steps
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean selectMultipleTestcasesfromSearch(String[] testCaseNo) throws Exception
	{
		try
		{
		bp=new BasePage();
		int length=testCaseNo.length-1;
		for(int i=0;i<=testCaseNo.length-1;i++)
		{
		bp.waitForElement();
		WebElement ele=driver.findElement(By.xpath(checkSearchedTestCase1+testCaseNo[i]+checkSearchedTestCase2));
		Actions act=new Actions(driver);
		act.moveToElement(ele).click().perform();
		}
		
		log.info(length+" Test Case Selected");
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
	public boolean clickOnExportTab() throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		export_TestCase.click();
		bp.waitForElement();
       log.info("Succesfully Landed on Export page");
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
	public boolean UnselectInTheseRelease() throws Exception
	{
		try
		{
			bp=new BasePage();
		boolean ele=inTheseReleaseOption.isSelected();
		if(ele==true)
		{
			inTheseReleaseOption.click();
			log.info("In these Release Opion is Uncheked");
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
//	public void moveTestCasesFromOneNodeToOtherNode(String srcNode,String destNode,String[] testCases)
//	{
//		for(int i=0;i<=testCases.length-1;i++)
//		{
//		testCases[i].click();
//		Actions a1=new Actions(driver);
//		
//		a1.dragAndDrop(srcNode, destNode)
//		
//	}
	
	/* ****************************************************
	   * Method Name   : dnDForTestStepsDetails(int fromStepNum,int toStepNum) 
	  * Purpose    : To dnD the teststeps in Testcase Steps
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
		public boolean clickOnPhase(String phaseName) throws Exception
		{	try
			{
            String releasename4=phasename1+phaseName+phasename2;
			
			WebElement nodeElement=driver.findElement(By.xpath(releasename4));
			Actions a1=new Actions(driver);
			a1.moveToElement(nodeElement).click().perform();
			log.info("Pass -"+phaseName+" node is selected");
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
		////////////////////////////////////
		public boolean searchAndAdd(String searchOption) throws Exception
		 {
			try
			{
		  clickOnSearch.click();
		  //advancedSearch.click();
		  
		  //clickOnSearchTextArea.click();
		  clickOnSearchTextArea.sendKeys(searchOption);
		  Thread.sleep(3000);
		  clickOnGoButton.click();
		  Thread.sleep(3000);
		  //clickOnRelease.click();
		  
		  return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		 }
		
		public boolean selectAndExport() throws Exception
		 {
		  
		  try
		  {
		  /*Thread.sleep(2000);
		  selecTestCaseChkBox.click();*/
		  Thread.sleep(5000);
		  clickOnExportOption.click();//
		  Thread.sleep(3000);//
		  clickOnSave.click();//
		  Thread.sleep(10000);//
		  clickOnDownload.click();//
		  
		  return true;
		  }
		  catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		  //clickOnSave.click();
		  //clickOnRelease.click();
		  
		  
		//  public void Release(String )
		//  {
		//   clickOnRelease.click();
		//  }
		//  //clickOnSaveButton.click();
		  
		  
		  //Thread.sleep(3000);
		  //clickOnDownloadButton.click();
		  
		  //WebElement ele=(driver.findElement(By.xpath(".//*[@id='zui-search-textarea']")));
		  //ele.click();
		  //Thread.sleep(3000);
		  //ele.sendKeys("testcase1");
		  
		  
		  
		 }
		public boolean selectallSelectFields() throws Exception
		 {
			try
			{
		  allselectFieldchkBox.click();
		  return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		 }
		
		
		/* ****************************************************
		 * Method Name   : Start adn End date
		* Purpose    : To select report type in export page
		* Author    : OPAL1
		* Date Created   : 10/08/17
		* Date Modified  :
		* Reviewed By   : Opal4
		* ******************************************************
		*/

		 public void startDate(int startdate) throws Exception
		 {
		  try
		  {
		   bp=new BasePage();
		   bp.waitForElement();
		   dateFieldOption.click();
		   startDateOption.click();
		  bp=new BasePage();
		  bp.waitForElement();
		  bp.waitForElement();
		  
		     String a="(//span[text()='";
		     String b="'])[2]";
		     String dateNum=a+startdate+b;
		     driver.findElement(By.xpath(dateNum)).click();
		//  startDate.click();
		//  selectDate.click();
		//  bp.waitForElement();
		//  Enddate.click();
		//  selectEndDate.click();
		//  bp.waitForElement();
		  }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		   throw e;
		  }
		 }
		 
		 public void endDate(int enddate) throws Exception
		 {
		  try
		  {
		  endDateOption.click();
		  bp=new BasePage();
		  bp.waitForElement();
		  bp.waitForElement();
		  
		     String a="(//span[text()='";
		     String b="'])[2]";
		     String dateNum=a+enddate+b;
		     driver.findElement(By.xpath(dateNum)).click();
		//  startDate.click();
		//  selectDate.click();
		//  bp.waitForElement();
		//  Enddate.click();
		//  selectEndDate.click();
		//  bp.waitForElement();
		  }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		   throw e;
		  }
		 }
		 
		 
		 public void startDate1(String date2) throws Exception
		 {
		  try
		  {
			  bp=new BasePage();
			  dateFieldOption.click();
			  bp.waitForElement();
			  
//				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
//
//				 //get current date time with Date()
//				 Date date = new Date();
//				 ///System.out.println(date);
//				 // Now format the date
//				 String date1= dateFormat.format(date);
//				  bp.waitForElement();
//			  int day;
//			  SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
//			  
//				 //get current date time with Date()
//				 Date date = new Date();
//				 day = date.getDay();
//				 day = day-5;
//				 date.setDate(day);
				 ///System.out.println(date);
				 // Now format the date
				// String date1= dateFormat.format(date);
			  
				 starDate1.click();
				  //starDate1.sendKeys(date1);
			  bp.waitForElement();
			  
			  WebElement ele=driver.findElement(By.xpath(start_date11+date2+start_date22));
			  bp.moveToElementAndClick(ele);
//		   bp=new BasePage();
		   bp.waitForElement();
//		   dateFieldOption.click();
//		   startDateOption.click();
//
		  }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		   throw e;
		  }
		 }
		 
		 @SuppressWarnings("deprecation")
		public void endDate1() throws Exception
		 {
		  try
		  {
			  bp=new BasePage();
			  dateFieldOption.click();
			  bp.waitForElement();
			  JavascriptExecutor js =((JavascriptExecutor) driver);
			    js.executeScript("arguments[0].scrollIntoView(true);", exportSave);
				bp.waitForElement();
//			  int day;
//			  SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
//			  
//				 //get current date time with Date()
//				 Date date = new Date();
//				 day = date.getDay();
//				 day = day+10;
//				 date.setDate(day);
//				 ///System.out.println(date);
//				 // Now format the date
//				 String date1= dateFormat.format(date);
//				  bp.waitForElement();
//			  endDate1.sendKeys(date1);
				  endDate1.click();
			  bp.waitForElement(); 
			 
			  bp.waitForElement(); 
			driver.findElement(By.xpath(end_date11+"25"+end_date22)).click();
			  bp.waitForElement(); 
//		  endDateOption.click();
//		  bp=new BasePage();
//		  bp.waitForElement();
//		  bp.waitForElement();
//		  
//		     String a="(//span[text()='";
//		     String b="'])[2]";
//		     String dateNum=a+enddate+b;
//		     driver.findElement(By.xpath(dateNum)).click();
		//  startDate.click();
		//  selectDate.click();
		//  bp.waitForElement();
		//  Enddate.click();
		//  selectEndDate.click();
		//  bp.waitForElement();
		  }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		   throw e;
		  }
		 }

		 
		 
		 /************************06/12/17***************************/
		 public boolean selectFilterBy(String defects,String[] executionStatus) throws Exception
			{
				
			try
			{
			  bp=new BasePage();
			  /*coverageOption.click();
				for(int i=0;i<=2;i++)
				{
		            WebElement ele=driver.findElement(By.xpath(coverage1+i+coverage2));
					//System.out.println(ele);
					String ele1=ele.getText();
					System.out.println(ele1);
					
					if(coverage.equalsIgnoreCase(ele1))
					{
						bp=new BasePage();
						bp.waitForElement();
						ele.click();
					}
				 }*/
				
				if(defects!=(""))
				{
					bp.waitForElement();
					defectsOption.click();
				}
				
				if(executionStatus[0]!=(""))
				{
			    executionStatusOption.click();
				bp.waitForElement();
			    //Thread.sleep(2000);
				driver.findElement(By.xpath(executionStatusField)).click();
				
				
				for(int k=0;k<=executionStatus.length-1;k++)
				{
					Actions a1=new Actions(driver);
					System.out.println(executionStatus[k]);
					a1.sendKeys(executionStatus[k]).sendKeys(Keys.ENTER).perform();
					
					bp.waitForElement();
				}
				/*Actions a2=new Actions(driver);
				a2.sendKeys(Keys.ENTER).perform();
				a2.sendKeys(Keys.ENTER).perform();*/
				
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
		   * Method Name   : coverageType(String report_Type) 
		  * Purpose    : To select report type in export page
		  * Author    : OPAL1
		  * Date Created   : 27/07/17
		  * Date Modified  :
		  * Reviewed By   : Opal4
		  * ******************************************************
		  */
		public boolean coverageType(String coverage_Type) throws Exception 
		{
			try
			{
				bp=new BasePage();
				reqcoverageOption.click();
				
				WebElement cType=driver.findElement(By.xpath(output1+coverage_Type+output2));
				
				String report=cType.getText();
			if(coverage_Type.equalsIgnoreCase(report))
			{
				bp.waitForElement();
				cType.click();
				//System.out.println(report_Type);
				log.info("Report Type Selected- "+coverage_Type);
			}	
		 
			
			
			return true;
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		

}

	
	

