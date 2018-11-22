package com.zephyr.reusablemethods;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.pom.ImportPage_POM;
import com.zephyr.pom.TestRepositoryPage_POM;

public class ImportPage
{
	WebDriver driver=null;
	   public Logger log;
	   BasePage bp;
	   TestRepositoryPage tr;

	public ImportPage(WebDriver driver)
	{
		//super(driver);
		this.driver=driver;
		PageFactory.initElements(LaunchBrowser.driver,this );
		log=Logger.getLogger(this.getClass());
	    Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
	}
	
	////////////////////////POM//////////////////////////
	@FindBy(xpath="//*[text()='Import']")
	public WebElement ImportIcon;
	
	@FindBy(xpath="(//*[@class='zui-btn zui-btn-primary' and @type='button' and text()='Next'])")
	public WebElement NextForMap;
	
	/*	****************************************************
	 * Method Name			: createMap()
	 * Purpose				: POM of CreateMap() method
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	@FindBy(xpath="(//*[text()='Add'])[3]")
	public WebElement add;
	
	@FindBy(xpath="//*[@id='addmap']")
	public WebElement mapName;
	
	@FindBy(xpath="//*[@id='update-savedMaps']/form/div[3]/span[2]/button")
	public WebElement saveMap;
	
	@FindBy(xpath="//*[@id='zee-import-modal-testcase']/div/div/div[3]/zui-modal-footer/div/button[2]")
	public WebElement nextForImport;
	
//	@FindBy(xpath="(//div[@title='MapTestCase'])[1]")
//	public WebElement selectMap;
	
	
	/*	****************************************************
	 * Method Name			: importTestCase()
	 * Purpose				: POM of ImportTestcase() method
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	@FindBy(xpath="//*[@id='job-name']")
	public WebElement importJobName;
	
	@FindBy(id="-wrap-maps-import-component")
	public WebElement mapSelection;
	
	@FindBy(xpath="(//*[@id='fromLocal']/div/attachments/div/div/p/span)[2]")
	public WebElement uploadFile;
	
	@FindBy(xpath="//*[@id='update-importJobs']/form/div[3]/span[2]/button")
	public WebElement saveImport;
	
//	@FindBy(xpath="(//*[@class='flex-data-item undefined ellipsis td-show' and @data-col-index='1'])[1]")
//	public WebElement selectImportJob;
	
	/*	****************************************************
	 * Method Name			: runJob()
	 * Purpose				: POM of runJob()
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	@FindAll({@FindBy(xpath="//*[@class='grid-action-icon fa fa-play-circle-o runJobs']")})             
	//public WebElement runJob;
	public List<WebElement> runJob;
	
	@FindBy(xpath="//*[@class='grid-action-icon fa fa-refresh reRunJobs']")
	public WebElement reRunJob;
	
	@FindBy(xpath="//*[@id='job-status-modal-importJob']/div/div/div[2]")
	public WebElement importHistory;
	
	/*	****************************************************
	 * Method Name			: ValidateImport()
	 * Purpose				: POM of runJob()
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	@FindBy(xpath="//*[@id='zee-import-modal-testcase']/div/div/div[3]/zui-modal-footer/div/button")
	public WebElement backToMap;
	
	@FindBy(xpath="//*[@id='zee-import-modal-testcase']/div/div/div[3]/zui-modal-footer/div/button[1]")
	public WebElement backToInstruction;
	
	@FindBy(xpath="//*[@id='zee-import-modal-testcase']/div/div/div[1]/div[2]/button")
	public WebElement closeInstruction;
	
	@FindBy(xpath="//*[@data-name='Imported']")
	public WebElement Imported;
	
	/*	****************************************************
	 * Method Name			: ClickOKonStatusReport()
	 * Purpose				: Run the Imported Job
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	@FindBy(xpath="//*[@id='job-status-modal-importJob']/div/div/div[3]/zui-modal-footer/button[1]")
	public WebElement OkButtonofStatusReport;
	
	/*	****************************************************
	 * Method Name			: DeleteImportJob()
	 * Purpose				: Run the Imported Job
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	@FindBy(xpath="//*[@class='grid-action-icon fa fa-trash deleteJobs']")
	public WebElement DeleteImportedJobIcon;
	
	@FindBy(xpath="//*[@id='zui-import-modal-job-delete']/div/div/div[3]/zui-modal-footer/button[1]")
	public WebElement DeleteButton;
	
	@FindBy(xpath="/html/body/div[2]")
	public WebElement ValidateDeleteImportJob;
	
	@FindBy(xpath="(//*[@class='flex-data-item undefined ellipsis td-show' and @data-col-index='1'])[1]")
	 public WebElement selectImportJob;
	
	@FindBy(xpath="(//*[@title='MapTestCase'])[1]")
	 public WebElement selectMap;
	
	@FindBy(xpath="/html/body/ul[2]/li[1]/a")
	 public WebElement renameButton;
	 
	 @FindBy(xpath="//*[@id='testcaseNodeName']")
	 public WebElement renameField;
	 
	 @FindBy(xpath="//*[@id='tcrRenameNodeModalSave']")
	 public WebElement confirmRename;
	 
	 @FindBy(xpath="/html/body/ul[2]/li[2]/a")
		public WebElement deleteImportedFile;
		
		@FindBy(xpath="/html/body/zui-app/section/zee-test-repository/test-repository-component/div[2]/div[2]/div/div/div[1]/div/div/div/div[1]/section/zui-tcr-tree/ng-component/zui-modal/div/div/div/div[3]/zui-modal-footer/button[2]")
		public WebElement yesToDeleteImportedFile;
		
			@FindBy(xpath="//*[@id='zee-testcase-details-module']/div[2]/zee-custom-fields/ul/li[2]/div/span/span/input")
	public WebElement checkBoxField;
			
	@FindBy(xpath="//div/zee-custom-fields//span[contains(@title, 'CustomCheckbox')]/following-sibling::span")
	public WebElement checkBoxField1;
		
			
			@FindBy(xpath="//*[@id='zee-import-modal-testcase']/div/div/div[1]/div[2]/button")
			public WebElement closeImportTestCasePage;
			
			@FindBy(xpath="//*[@id='zee-import-modal-testcase']//zui-modal-footer/div/button")
			public WebElement back;
			
			@FindBy(xpath="(//*[text()='Add'])[2]")
			public WebElement add1;
			
			@FindBy(xpath="//*[@id='zee-import-modal-requirement']/div/div/div[1]/div[2]/button")
			public WebElement closeImportPage;
			
			@FindBy(xpath="//*[@id='zee-import-modal-requirement']/div/div/div[3]/zui-modal-footer/div/button[2]")
			public WebElement nextToImportRequirment;
			
			@FindBy(xpath="(//*[text()='Add'])[2]")
			public WebElement addJob;
			
			@FindBy(id ="-wrap-maps-import-component")
			public WebElement select_Map;

			public String mapSelection1="(//li[text()='";
			public String mapSelection2="'])[1]";
			
			@FindBy(xpath="//*[@class='page-track']/b[3]")
			public WebElement validateRequirement;

			protected String validatemap1="//*[@id='grid-table-saved_maps']/div[2]//*[text()='";
			protected String validatemap2="']";
			
			@FindBy(xpath = "//*[@id='savedMaps-fieldsMapper']/div[10]/span[2]/input")
			public WebElement addCustomText;
			
			@FindBy(xpath="//*[@data-name='Imported']/..")
			public WebElement importedExpand;

	
	/*	****************************************************
	 * Method Name			: clickOnImport()
	 * Purpose				: clicks on the Import button
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	public boolean clickOnImport() throws Exception
	{
		try
		{
			bp=new BasePage();
			ImportIcon.click();
			bp.waitForElement();
			log.info("Pass - Clicked on Import Button Successfully");
			NextForMap.click();
			bp.waitForElement();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}
	
	/*	****************************************************
	 * Method Name			: createMap()
	 * Purpose				: Creates the Map for the testcase to be import
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	public boolean createMap(String mapname,int rownum,String descrimi,String desc,String name,String testSteps,String expResults,String extrID) throws Exception
	{
		try
		{
			bp=new BasePage();
			String rownumber=Integer.toString(rownum);
			bp.waitForElement();
			add.click();
			bp.waitForElement();
			log.info("Pass - Clicked on ADD button Successfully");
			mapName.sendKeys(mapname);
			bp.waitForElement();
			Actions act=new Actions(driver);
			act.sendKeys(Keys.TAB).sendKeys(rownumber).perform();
			if(descrimi.equalsIgnoreCase("By empty Row"))
			{
				act.sendKeys(Keys.TAB).perform();
			}
			else if(descrimi.equalsIgnoreCase("By ID Change"))
			{
				act.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).perform();
			}
			else if(descrimi.equalsIgnoreCase("By Testcase Name Change"))
			{
				act.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
			}
			//act.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).perform();
			act.sendKeys(Keys.TAB).sendKeys(desc).perform();
			act.sendKeys(Keys.TAB).sendKeys(name).perform();
			act.sendKeys(Keys.TAB).sendKeys(testSteps).perform();
			act.sendKeys(Keys.TAB).sendKeys(expResults).perform();
			act.sendKeys(Keys.TAB).sendKeys(extrID).perform();
			log.info("Pass - All Entered name successfully");
			bp.waitForElement();
			saveMap.click();
			bp.waitForElement();
			log.info("Pass - Clicked on Save successfully");
			nextForImport.click();
			bp.waitForElement();
			log.info("Pass - Clicked on next successfully");
			log.info("Pass - Map is created with valid Testcase values");
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}
	/*	****************************************************
	 * Method Name			: updateMap()
	 * Purpose				: Creates the Map for the testcase to be import
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	public boolean updateMap(String mapname, int rownum, String[] ZephyrFields) throws Exception
	{
		try
		{
			bp=new BasePage();
			String rownumber=Integer.toString(rownum);
			bp.waitForElement();
			add.click();
			bp.waitForElement();
			log.info("Pass - Clicked on ADD button Successfully");
			mapName.sendKeys(mapname);
			Actions act=new Actions(driver);
			act.sendKeys(Keys.TAB).sendKeys(rownumber).perform();
			act.sendKeys(Keys.TAB).perform();
			for(int i=0;i<=ZephyrFields.length-1;i++)
			{
				act.sendKeys(Keys.TAB).sendKeys(ZephyrFields[i]).perform();
			}
			log.info("Pass - All Entered name successfully");
			bp.waitForElement();
			saveMap.click();
			bp.waitForElement();
			log.info("Pass - Clicked on Save successfully");
			nextForImport.click();
			bp.waitForElement();
			log.info("Pass - Clicked on next successfully");
			log.info("Pass - Map is created with valid Testcase values");
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/*	****************************************************
	 * Method Name			: importTestCase()
	 * Purpose				: Import the testcase from the mapped testcase
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	
	
	
	
	public boolean importTestCase(String jobname,String mapName,String path) throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
			add.click();
			bp.waitForElement();
			log.info("Pass - Clicked on Add successfully");
			bp.waitForElement();
			importJobName.sendKeys(jobname);
			log.info("Pass - JobName entered successfully");
			WebElement SelectMap=mapSelection;
			mapSelection.click();
			bp.waitForElement();
			List <WebElement> allMaps=driver.findElements(By.xpath(mapSelection1+mapName+mapSelection2));
			allMaps.size();
			
			
			allMaps.get(allMaps.size()-1).click();
			
//			(//li[text()='MMapTestCase'])[1]
//			Select sel=new Select(SelectMap);
//			sel.selectByVisibleText(mapName);
			log.info("Pass -  Mapped Testcase name is selected for import successfully");
			uploadFile.click();
			bp.waitForElement();
			log.info("Pass - Clicked on choose file input option successfully");
			Runtime.getRuntime().exec(path);
			bp.waitForElement();
			log.info("Pass - Excel file is selected for the import");
			bp.waitForElement();
			saveImport.click();
			bp.waitForElement();
			log.info("Pass - Clicked on save successfully");
			log.info("Pass - Testcase is imported successfully");
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	
//	public boolean importTestCase(String jobname,String mapName,String path) throws Exception
//	{
//		try
//		{
//			bp=new BasePage();
//			bp.waitForElement();
//			add.click();
//			bp.waitForElement();
//			log.info("Pass - Clicked on Add successfully");
//			bp.waitForElement();
//			importJobName.sendKeys(jobname);
//			log.info("Pass - JobName entered successfully");
//			WebElement SelectMap=mapSelection;
//			Select sel=new Select(SelectMap);
//			sel.selectByVisibleText(mapName);
//			log.info("Pass -  Mapped Testcase name is selected for import successfully");
//			uploadFile.click();
//			bp.waitForElement();
//			log.info("Pass - Clicked on choose file input option successfully");
//			Runtime.getRuntime().exec(path);
//			bp.waitForElement();
//			log.info("Pass - Excel file is selected for the import");
//			bp.waitForElement();
//			saveImport.click();
//			bp.waitForElement();
//			log.info("Pass - Clicked on save successfully");
//			log.info("Pass - Testcase is imported successfully");
//			
//			return true;
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			throw e;
//		}
//	}
//	
	/*	****************************************************
	 * Method Name			: runJob()
	 * Purpose				: Run the Imported Job
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	public boolean runJob() throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
			bp.waitForElement();

			runJob.get(runJob.size()-1).click();

			 //runJob.click();
			 bp.waitForElement();
		     String History = importHistory.getText();
		     log.info(History);
		     
		     return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/*	****************************************************
	 * Method Name			: validateImport()
	 * Purpose				: Run the Imported Job
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	public boolean validateImport(String fileName,String releaseName) throws Exception
	{
		try
		{
			
		bp=new BasePage();
		String A="//*[starts-with(@data-desc,'FileName : ";
		String B="')]";
		String ImportedFile=A+fileName+B;
		bp.waitForElement();
		backToMap.click();
		bp.waitForElement();
		log.info("Pass - Clicked on back to navigate to Map");
		backToInstruction.click();
		bp.waitForElement();
		log.info("Pass - Clicked on back to navigate to InstructionPage");
		closeInstruction.click();
		bp.waitForElement();
		log.info("Pass - Closed the Instruction message page");
		tr=new TestRepositoryPage(driver);
	    tr.doubleClickOnRelease(releaseName);
	    bp.waitForElement();
	    
	    
		Actions act=new Actions(driver);
		String text=importedExpand.getAttribute("aria-expanded");
		 
		 if(text.equals("false"))
			   {
			  
			act.doubleClick(importedExpand).perform();
			log.info("Pass - DoubleClicked on Imported folder in TestRepositoryPage");
			//bp.waitForElement();
			   }
		
//		act.doubleClick(Imported).perform();
		bp.waitForElement();
		
		driver.findElement(By.xpath(ImportedFile)).click();
		bp.waitForElement();
		log.info("Pass - Clicked on the File we have Imported");
		String FileInfo=driver.findElement(By.xpath(ImportedFile)).getAttribute("data-desc");
		log.info(FileInfo);
		bp.waitForElement();
		log.info("Pass - Displayed the Info of Imported File");
		
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/*	****************************************************
	 * Method Name			: GotoImport()
	 * Purpose				: Run the Imported Job
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	public boolean GotoImport() throws Exception
	{
		try
		{
			bp=new BasePage();
			NextForMap.click();
			bp.waitForElement();
			//nextForImport.click();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/*	****************************************************
	 * Method Name			: ClickOKonStatusReport()
	 * Purpose				: Run the Imported Job
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	public boolean ClickOKonStatusReport() throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
			OkButtonofStatusReport.click();
			bp.waitForElement();
			
			return true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/*	****************************************************
	 * Method Name			: DeleteImportJob()
	 * Purpose				: Run the Imported Job
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	public boolean DeleteImportJob() throws Exception
	{
		try
		{
			bp=new BasePage();
			OkButtonofStatusReport.click();
			bp.waitForElement();
			DeleteImportedJobIcon.click();
			bp.waitForElement();
			DeleteButton.click();
			bp.waitForElement();
			String Deleted=ValidateDeleteImportJob.getText();
			log.info("Pass - "+Deleted+" Import Deleted Successfully");
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/* ****************************************************
	  * Method Name   : selectImportedFile(String fileName)
	  * Purpose    : Selects the Imported file
	  * Author    : OPAL
	  * Date Created   : 31/07/17
	  * Date Modified  :
	  * Reviewed By   : 
	  * ******************************************************
	  */
	 public boolean selectImportedFile(String fileName) throws Exception
	 {
	  try
	  {
	   bp=new BasePage();
	   String A="//*[starts-with(@data-desc,'FileName : ";
	   String B="')]";
	   String ImportedFile=A+fileName+B;
	   driver.findElement(By.xpath(ImportedFile)).click();
	   bp.waitForElement();
	   log.info("Pass - Clicked on the File we have Imported");
	   String FileInfo=driver.findElement(By.xpath(ImportedFile)).getAttribute("data-desc");
	   log.info(FileInfo);
	   bp.waitForElement();
	   log.info("Pass - Displayed the Info of Imported File"); 
	   
	   return true;
	  }
	  catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	 }
	 
	 
	 
	 
//	 /* ****************************************************
//	  * Method Name   : renameImportedFile(String fileName)
//	  * Purpose    : Rename the Imported file
//	  * Author    : OPAL
//	  * Date Created   : 31/07/17
//	  * Date Modified  :
//	  * Reviewed By   : 
//	  * ******************************************************
//	  */
//	 
//	 public boolean renameImportedFile() throws Exception
//	 {
//	  try
//	  {
//		 tr=new TestRepositoryPage(driver);
//	   bp=new BasePage();
//	   TestRepositoryPage_POM tp=new TestRepositoryPage_POM(driver);
//	   bp.waitForElement();
//	   tp.options.click();
//	   bp.waitForElement();
//	   renameButton.click();
//	   bp.waitForElement();
//	   bp.eraseText(renameField);
//	   bp.waitForElement();
//	   renameField.sendKeys("Renamed_the_file");
//	   bp.waitForElement();
//	   confirmRename.click();
//	    return true;
//	  }
//	  catch(Exception e)
//		{
//			e.printStackTrace();
//			throw e;
//		}
//	 }
//	 
	 /*	****************************************************
		 * Method Name			: DeleteImportfile()
		 * Purpose				: delete the impoeted file
		 * Author				: OPAL4
		 * Date Created			: 28/07/17
		 * Date Modified		:
		 * Reviewed By			: 
		 * ******************************************************
		 */
		
		public boolean deleteImportFile(String fileName) throws Exception
		{
			try
			{
				bp=new BasePage();
				tr=new TestRepositoryPage(driver);
				String A="//*[starts-with(@data-desc,'FileName : ";
				String B="')]";
				String ImportedFile=A+fileName+B;
				Actions act=new Actions(driver);
				act.doubleClick(Imported).perform();
				bp.waitForElement();
				driver.findElement(By.xpath(ImportedFile)).click();
				String FileInfo=driver.findElement(By.xpath(ImportedFile)).getAttribute("data-desc");
				log.info(FileInfo);
				bp.waitForElement();
				tr.options.click();
				//deleteImportedFile.click();
				bp.waitForElement();
				//yesToDeleteImportedFile.click();
				
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		 /*	****************************************************
		 * Method Name			: ValidateCheckBoxField()
		 * Purpose				: delete the impoeted file
		 * Author				: OPAL4
		 * Date Created			: 12/08/17
		 * Date Modified		:
		 * Reviewed By			: 
		 * ******************************************************
		 */
		
		public boolean ValidateCheckBoxField() throws Exception
		{
			try
			{
				bp=new BasePage();
				bp.waitForElement();
				bp.waitForElement();
				CreateTestCasePage ctc=new CreateTestCasePage(driver);
				ctc.clickOnCustomField.click();
				bp.waitForElement();
				log.info("Pass - Clicked on custom Field Successfully");
				String status=checkBoxField.getAttribute("disabled");
				log.info(status);
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
	
		
		
		
		
		
		
		public boolean importTestCase1(String jobname,String mapName,String path,String fileName) throws Exception
		{
			try
			{
				bp=new BasePage();
				add.click();
				bp.waitForElement();
				log.info("Pass - Clicked on Add successfully");
				bp.waitForElement();
				importJobName.sendKeys(jobname);
				log.info("Pass - JobName entered successfully");
				WebElement SelectMap=mapSelection;
				Select sel=new Select(SelectMap);
				sel.selectByVisibleText(mapName);
				log.info("Pass -  Mapped Testcase name is selected for import successfully");
				uploadFile.click();
				bp.waitForElement();
				log.info("Pass - Clicked on choose file input option successfully");
				Runtime.getRuntime().exec(path+" "+fileName);
				bp.waitForElement();
				log.info("Pass - Excel file is selected for the import");
				saveImport.click();
				bp.waitForElement();
				log.info("Pass - Clicked on save successfully");
				log.info("Pass - Testcase is imported successfully");
				
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		

		
		
		
		
		public boolean selectImportFile1(String fileName) throws Exception
		{
			try
			{
				bp=new BasePage();
				tr=new TestRepositoryPage(driver);
				String A="//*[starts-with(@data-desc,'FileName : ";
				String B="')]";
				String ImportedFile=A+fileName+B;
				Actions act=new Actions(driver);
				
			 //WebElement imported_Expand= driver.findElement(By.xpath(importedExpand));
			 String text=importedExpand.getAttribute("aria-expanded");
				 
			 if(text.equals("false"))
				   {
				  
				act.doubleClick(importedExpand).perform();
				//bp.waitForElement();
				   }
			 bp.waitForElement();
				driver.findElement(By.xpath(ImportedFile)).click();
				String FileInfo=driver.findElement(By.xpath(ImportedFile)).getAttribute("data-desc");
				log.info(FileInfo);
//				bp.waitForElement();
//				tr.options.click();
//				//deleteImportedFile.click();
//				bp.waitForElement();
//				//yesToDeleteImportedFile.click();
				log.info("selected imported file");
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		////////////added  18-08-2017
		public boolean draganddropImpotedtoPhase(String fileName ,String dstn) throws Exception
		{
			try
			{
				bp=new BasePage();
				tr=new TestRepositoryPage(driver);
				String A="//*[starts-with(@data-desc,'FileName : ";
				String B="')]";
				String ImportedFile=A+fileName+B;
				Actions act=new Actions(driver);
				act.doubleClick(Imported).perform();
				bp.waitForElement();
				WebElement src=driver.findElement(By.xpath(ImportedFile));
				String FileInfo=driver.findElement(By.xpath(ImportedFile)).getAttribute("data-desc");
				log.info(FileInfo);
				Actions a1=new Actions(driver);
				
				//WebElement src=driver.findElement(By.xpath(releasename1+srcNode+releasename2));
				WebElement dest=driver.findElement(By.xpath(tr.releasename1+dstn+tr.releasename2));
				a1.dragAndDrop(src, dest).perform();
				log.info("drag and dropped sucessfully");
//				bp.waitForElement();
//				tr.options.click();
//				//deleteImportedFile.click();
//				bp.waitForElement();
//				//yesToDeleteImportedFile.click();
				
				return true;
			}
			catch(Exception e)
			
			{
				e.printStackTrace();
				throw e;
			}
		}
		
		public boolean deleteImportFile1(String fileName) throws Exception
		{
			try
			{
				bp=new BasePage();
				tr=new TestRepositoryPage(driver);
				String A="//*[starts-with(@data-desc,'FileName : ";
				String B="')]";
				String ImportedFile=A+fileName+B;
				Actions act=new Actions(driver);
				act.doubleClick(Imported).perform();
				bp.waitForElement();
				driver.findElement(By.xpath(ImportedFile)).click();
				String FileInfo=driver.findElement(By.xpath(ImportedFile)).getAttribute("data-desc");
				log.info(FileInfo);
				bp.waitForElement();
				tr.options.click();
				bp.waitForElement();
				bp.waitForElement();
				//deleteImportedFile.click();
				driver.findElement(By.xpath("(//*[text()='Delete'])[4]")).click();
				bp.waitForElement();
				bp.waitForElement();
				yesToDeleteImportedFile.click();
				
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		
		
		 /* ****************************************************
		  * Method Name   : renameImportedFile(String fileName)
		  * Purpose    : Rename the Imported file
		  * Author    : OPAL
		  * Date Created   : 31/07/17
		  * Date Modified  :
		  * Reviewed By   : 
		  * ******************************************************
		  */
		 
		 public boolean renameImportedFile(String rename) throws Exception
		 {
		  try
		  {
			 tr=new TestRepositoryPage(driver);
		   bp=new BasePage();
		   TestRepositoryPage_POM tp=new TestRepositoryPage_POM(driver);
		   bp.waitForElement();
		   tp.options.click();
		   bp.waitForElement();
		   renameButton.click();
		   bp.waitForElement();
		   bp.eraseText(renameField);
		   bp.waitForElement();
		   renameField.sendKeys(rename);
		   bp.waitForElement();
		   confirmRename.click();
		    return true;
		  }
		  catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		 }
		
		 
		 /*	****************************************************
			 * Method Name			: updateMap()
			 * Purpose				: Creates the Map for the testcase to be import
			 * Author				: OPAL
			 * Date Created			: 10/07/17
			 * Date Modified		:
			 * Reviewed By			: 
			 * ******************************************************
			 */
			
			public boolean updateMap(String mapname, int rownum,String descrimi, String[] ZephyrFields) throws Exception
			{
				try
				{
					bp=new BasePage();
					String rownumber=Integer.toString(rownum);
					bp.waitForElement();
		        	WebDriverWait wait=new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.elementToBeClickable(add));
					add.click();
					bp.waitForElement();
						wait.until(ExpectedConditions.elementToBeClickable(mapName));
					
					log.info("Pass - Clicked on ADD button Successfully");
					mapName.sendKeys(mapname);
					Actions act=new Actions(driver);
					act.sendKeys(Keys.TAB).sendKeys(rownumber).perform();
					if(descrimi.equalsIgnoreCase("By empty Row"))
					{
						act.sendKeys(Keys.TAB).perform();
					}
					else if(descrimi.equalsIgnoreCase("By ID Change"))
					{
						act.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).perform();
					}
					else if(descrimi.equalsIgnoreCase("By Testcase Name Change"))
					{
						act.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
					}
					//act.sendKeys(Keys.TAB).perform();
					for(int i=0;i<=ZephyrFields.length-1;i++)
					{
						act.sendKeys(Keys.TAB).sendKeys(ZephyrFields[i]).perform();
						//bp.waitForElement();
					}
					log.info("Pass - All Entered name successfully");
					bp.waitForElement();
					wait.until(ExpectedConditions.elementToBeClickable(saveMap));
					saveMap.click();
					bp.waitForElement();
					//bp.waitForElement();
					log.info("Pass - Clicked on Save successfully");
					nextForImport.click();
					bp.waitForElement();
					log.info("Pass - Clicked on next successfully");
					log.info("Pass - Map is created with valid Testcase values");
					
					return true;
				}
				catch(Exception e)
				{
					e.printStackTrace();
					throw e;
				}
			}
			
			
			
			/*	****************************************************
			 * Method Name			: DeleteImportJob()
			 * Purpose				: Run the Imported Job
			 * Author				: OPAL
			 * Date Created			: 10/07/17
			 * Date Modified		:
			 * Reviewed By			: 
			 * ******************************************************
			 */
			
			public boolean deleteImportJob(String fileName) throws Exception
			{
				try
				{
					bp=new BasePage();
					OkButtonofStatusReport.click();
					bp.waitForElement();
					
					String delete1="//*[text()='";
					String delete2="']/../../../div[7]/div";
					
					
					List <WebElement> all=driver.findElements(By.xpath(delete1+fileName+delete2));
					all.get(all.size()-1).click();
					//DeleteImportedJobIcon.click();
					bp.waitForElement();
					DeleteButton.click();
					bp.waitForElement();
					String Deleted=ValidateDeleteImportJob.getText();
					log.info("Pass - "+Deleted+" Import Deleted Successfully");
					
					return true;
				}
				catch(Exception e)
				{
					e.printStackTrace();
					throw e;
				}
			}
			
			
			public boolean createMapForRequirement(String mapname,int rownum,String descrimi,String desc,String name,String testSteps,String expResults,String extrID) throws Exception
			{
				try
				{
					bp=new BasePage();
					String rownumber=Integer.toString(rownum);
					bp.waitForElement();
					add1.click();
					bp.waitForElement();
					System.out.println("Pass - Clicked on ADD button Successfully");
					mapName.sendKeys(mapname);
					bp.waitForElement();
					Actions act=new Actions(driver);
					act.sendKeys(Keys.TAB).sendKeys(rownumber).perform();
					//bp.waitForElement();
					if(descrimi.equalsIgnoreCase("By empty Row"))
					{
						act.sendKeys(Keys.TAB).perform();
						//bp.waitForElement();
					}
					
					else if(descrimi.equalsIgnoreCase("By ID Change"))
					{
						act.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).perform();
						//bp.waitForElement();
					}
					else if(descrimi.equalsIgnoreCase("By Requirement Name Change"))
					{
						act.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
						//bp.waitForElement();
					}
					//act.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).perform();
					act.sendKeys(Keys.TAB).sendKeys(desc).perform();
					//bp.waitForElement();
					act.sendKeys(Keys.TAB).sendKeys(name).perform();
					//bp.waitForElement();
					act.sendKeys(Keys.TAB).sendKeys(testSteps).perform();
					//bp.waitForElement();
					act.sendKeys(Keys.TAB).sendKeys(expResults).perform();
					//bp.waitForElement();
					act.sendKeys(Keys.TAB).sendKeys(extrID).perform();
					//bp.waitForElement();
					System.out.println("Pass - All Entered name successfully");
					//bp.waitForElement();
					bp.waitTillElementIsVisible(saveMap);
					saveMap.click();
					bp.waitForElement();
					System.out.println("Pass - Clicked on Save successfully");
					return true;
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					throw e;
				}
				
			}

			
			public boolean clickOnNextForMap() throws Exception
			{
				try
				{
					bp=new BasePage();
					bp.waitForElement();
					NextForMap.click();
					System.out.println("clicked on Next Sucessfully");
					bp.waitForElement();
					return true;
				}
				catch(Exception e)
				{
					e.printStackTrace();
					throw e;
				}
				
			}
			
			
			public boolean closeImportPage() throws Exception
			{
				try
				{
					bp=new BasePage();
					closeImportPage.click();
					System.out.println("Import Page closed Sucessfully");
					bp.waitForElement();
					return true;
				}
				catch(Exception e)
				{
					e.printStackTrace();
					throw e;
				}
				
			}
			
	
			
			public boolean clickOnNextForImport() throws Exception
			{
				try
				{
					bp=new BasePage();
					bp.waitForElement();
					nextToImportRequirment.click();
					System.out.println("clicked on Next Sucessfully");
					bp.waitForElement();
					return true;
				}
				catch(Exception e)
				{
					e.printStackTrace();
					throw e;
				}
				
			}
			
			
			public boolean importTestCaseRequirment(String jobname,String mapName,String path) throws Exception
			{
				try
				{
					bp=new BasePage();
					bp.waitForElement();
					addJob.click();
					bp.waitForElement();
					log.info("Pass - Clicked on Add successfully");
					bp.waitForElement();
					importJobName.sendKeys(jobname);
					log.info("Pass - JobName entered successfully");
					select_Map.click();
					bp.waitForElement();
					WebElement SelectMap=driver.findElement(By.xpath(mapSelection1+mapName+mapSelection2));
//					Select sel=new Select(SelectMap);
//					sel.selectByVisibleText(mapName);
					
					SelectMap.click();
					log.info("Pass -  Mapped Testcase name is selected for import successfully");
					uploadFile.click();
					bp.waitForElement();
					log.info("Pass - Clicked on choose file input option successfully");
					Runtime.getRuntime().exec(path);
					bp.waitForElement();
					log.info("Pass - Excel file is selected for the import");
					bp.waitForElement();
					saveImport.click();
					bp.waitForElement();
					log.info("Pass - Clicked on save successfully");
					log.info("Pass - Testcase is imported successfully");
					
					return true;
				}
				catch(Exception e)
				{
					e.printStackTrace();
					throw e;
				}
			//*[@id="grid-table-saved_maps"]/div[2]//*[text()='uto_112Map_30']
	}

			
			public boolean runJob1() throws Exception
			{
				try
				{
					bp=new BasePage();
					 //runJob.click();
					 bp.waitForElement();
						runJob.get(runJob.size()-1).click();
					 bp.waitForElement();
					 driver.findElement(By.xpath("//*[@id='job-status-modal-importJob']/div/div/div[3]/zui-modal-footer/button[1]")).click();
					 bp.waitForElement();
				     String History = importHistory.getText();
				     log.info(History);
				     bp.waitForElement();
				     return true;
				}
				catch(Exception e)
				{
					e.printStackTrace();
					throw e;
				}
			}


			
			public boolean validateImportRequirment(String fileName,String releaseName) throws Exception
			{
				try
				{
					
				bp=new BasePage();
				String A="//*[starts-with(@data-desc,'FileName : ";
				String B="')]";
				String ImportedFile=A+fileName+B;
				bp.waitForElement();
				tr=new TestRepositoryPage(driver);
			    tr.doubleClickOnRelease(releaseName);
			    bp.waitForElement();
				//Actions act=new Actions(driver);
				//act.doubleClick(Imported).perform();
				bp.waitForElement();
				System.out.println("Pass - DoubleClicked on Imported folder in Requirement Page");
				driver.findElement(By.xpath(ImportedFile)).click();
				bp.waitForElement();
				System.out.println("Pass - Clicked on the File we have Imported");
				String FileInfo=driver.findElement(By.xpath(ImportedFile)).getAttribute("data-desc");
				System.out.println(FileInfo);
				bp.waitForElement();
				System.out.println("Pass - Displayed the Info of Imported File");
				
				return true;
				}
				catch(Exception e)
				{
					e.printStackTrace();
					throw e;
				}
			}
			
			
			public boolean validateRequirement() throws Exception
			{
				try
				{
					boolean val=validateRequirement.isEnabled();
					if(val==true)
					{
						System.out.println("total No of Requirements in folder : "+validateRequirement.getText());
					}
					else
					{
						System.out.println("Fail to import Requirements");
					}
				}
				catch(Exception e)
				{
					System.out.println("Fail to import Requirements");
					e.printStackTrace();
					throw e;
				}
				return true;
				
			}
			
			
			
			public boolean validateMap(String MapName) throws Exception
			{
				try
				{
					bp=new BasePage();
					String value=driver.findElement(By.xpath(validatemap1+MapName+validatemap2)).getText();
					if(value==MapName)
					{
						System.out.println("Map sucessfully Created with name -"+value);
					}
					else
					{
						System.out.println("Map not created with "+value);
					}
					return true;
				}
				catch(Exception e)
				{
					e.printStackTrace();
					throw e;
				}
				
			}
			
			
			public boolean createMapForRequirementWithCustomField(String mapname,int rownum,String descrimi,String desc,String name,String testSteps,String expResults,String extrID,String[] customFields) throws Exception
			{
				try
				{
					bp=new BasePage();
					String rownumber=Integer.toString(rownum);
					bp.waitForElement();
					add1.click();
					bp.waitForElement();
					System.out.println("Pass - Clicked on ADD button Successfully");
					mapName.sendKeys(mapname);
					bp.waitForElement();
					Actions act=new Actions(driver);
					act.sendKeys(Keys.TAB).sendKeys(rownumber).perform();
					if(descrimi.equalsIgnoreCase("By empty Row"))
					{
						act.sendKeys(Keys.TAB).perform();
					}
					
					else if(descrimi.equalsIgnoreCase("By ID Change"))
					{
						act.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).perform();
					}
					else if(descrimi.equalsIgnoreCase("By Testcase Name Change"))
					{
						act.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
					}
					//act.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).perform();
					act.sendKeys(Keys.TAB).sendKeys(desc).perform();
					act.sendKeys(Keys.TAB).sendKeys(name).perform();
					act.sendKeys(Keys.TAB).sendKeys(testSteps).perform();
					act.sendKeys(Keys.TAB).sendKeys(expResults).perform();
					act.sendKeys(Keys.TAB).sendKeys(extrID).perform();
					
					
				
					//*[@id="savedMaps-fieldsMapper"]/div[10]/span[2]/input
					act.moveToElement(addCustomText).click().sendKeys(customFields[0]).perform();
					act.sendKeys(Keys.TAB).sendKeys(customFields[1]).perform();
					act.sendKeys(Keys.TAB).sendKeys(customFields[2]).perform();
					act.sendKeys(Keys.TAB).sendKeys(customFields[3]).perform();
					act.sendKeys(Keys.TAB).sendKeys(customFields[4]).perform();
					act.sendKeys(Keys.TAB).sendKeys(customFields[5]).perform();
					System.out.println("Pass - All Entered name successfully");
					bp.waitForElement();
					bp.waitForElement();
					saveMap.click();
					bp.waitForElement();
					System.out.println("Pass - Clicked on Save successfully");
					return true;
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					throw e;
				}
				
			}

			
}
	

