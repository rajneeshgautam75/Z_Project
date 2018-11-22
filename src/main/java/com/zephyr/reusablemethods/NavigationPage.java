package com.zephyr.reusablemethods;



import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.pom.NavigationaPage_POM;
public class NavigationPage
{
	BasePage bp;
  public Logger log;
	public WebDriver driver=null;
	 
	 public NavigationPage(WebDriver driver)
    {
		//super(driver);
		this.driver = LaunchBrowser.driver;
		PageFactory.initElements(LaunchBrowser.driver, this);
		log=Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
//		BasicConfigurator.configure();
	 }
	 
	 ////////////////////////////POM//////////////////////////
	 @FindBy(xpath=".//*[@id='pagination-page-size-tcr']")
	 public WebElement clickOnPageSize;

	 @FindBy(xpath=".//*[@id='pagination-page-size-tcr']")
	 public WebElement clickOnOptions;

	 @FindBy(xpath=".//*[@id='pagination-page-size-tcr']/option[1]")
	 public WebElement clickOnOption;

	 @FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/li[3]/a/span")
	 public WebElement clickOnNextButton;

	 @FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/li[2]/a/span")
	 public WebElement clickOnPrevButton;

	 @FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span")
	 public WebElement clickOnPageNumbers;

	 @FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li")
	 public WebElement clickOnPages;

	 @FindBy(xpath="//*[@class='breadcrumb zui-breadcrumb']")
	 public WebElement breadCrumbs;

	 @FindBy(xpath="//label[@class='zui-search-label']/span[contains(.,'Advanced')]")
	 //@FindBy(xpath="//span[contains(.,'Advanced')]")
	 public WebElement advancedSearch;

	 @FindBy(xpath="//*[text()='Go']")
	 public WebElement clickOnGo;

	 //@FindBy(xpath="//span")
	 @FindBy(xpath=".//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[1]/div[2]/div[1]")
	 public WebElement clickOnSearch;

	 @FindBy(xpath=".//*[@id='zui-search-textarea']")
	 public WebElement clickOnSearchTextArea;

	 @FindBy(xpath=".//*[@id='zql-search-input-tcr-search']")
	 public WebElement advancedSearchTextArea;


	 //*[@id="ze-main-app"]/zee-test-repository/test-repository-component/div[2]/div[2]/div/div[1]/section/div/zui-zephyr-search//select

	 @FindBy(xpath="//zui-zephyr-search//select")
	 public WebElement prevSearchDropDown;

	 @FindBy(xpath=".//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[2]/div[1]/section/div/zui-zephyr-search/div/zui-zql-search/div/div[2]/div/select/option")
	 public WebElement clickOnPreviousSearch;

	 @FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li[2]/a")
	 public WebElement clickOnPage2;

	 @FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li[3]/a")
	 public WebElement clickOnPage3;

	 @FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li[4]/a")
	 public WebElement clickOnPage4;

	 @FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li[5]/a")
	 public WebElement clickOnPage5;

	 @FindBy(xpath="//*[@class='zql-search-previous']")///////////////////////////////////added
	 public WebElement previousSearch;

	 @FindBy(xpath="//div[text()='100']")///////////////////////////////////added
	 public WebElement searchTestCaseText;

	 
		public boolean checkingBreadCrumbs(String[] Phases) throws Exception
		{
			

//		String[] Phase=new String[4];
//		Phase[0]="Release 1.0";
//		Phase[1]="ABA";
//		Phase[2]="System1";
//		Phase[3]="Subsystem1";
	try
			{
		BasePage bp=new BasePage();
		bp.waitForElement();
	 	String str2=breadCrumbs.getText();
	 	System.out.println(str2);
		
		String[] parts=str2.split(" > ");	
		boolean value=false;
		for(int i=0;i<=parts.length-1;i++)
		{
		      value=false;
			if(parts[i].equals(Phases[i]))
			{
				value=true;
			}
		}
		if(value==true)
		{
			System.out.println("BreadCrumbs are Verified");
		}
		else
		{
			System.out.println("BreadCrumbs are not Verified");
		}
		return true;
			}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
		
		}
	
		public boolean searchDropDown() throws Exception
		{
			try
			{
			bp=new BasePage();
			bp.waitForElement();
			prevSearchDropDown.click();
			bp.waitForElement();
			clickOnPreviousSearch.click();
			return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}


		public boolean navigatingPageNumbers() throws Exception
		{
			try
			{
			clickOnPage2.click();
			clickOnPage3.click();
			clickOnPage4.click();
			clickOnPage5.click();
			return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
			
		}
		
		public boolean searchAndAdd(String searchOption) throws Exception
		{
			try
			{
			bp=new BasePage();
			clickOnSearch.click();
			
			bp.waitForElement();
			bp.waitForElement();
			WebDriverWait wait=new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.elementToBeClickable(advancedSearch));
			advancedSearch.click();
			
			bp.waitForElement();
			WebDriverWait wait2=new WebDriverWait(driver, 100);
			wait2.until(ExpectedConditions.elementToBeClickable(advancedSearchTextArea));
			//clickOnSearchTextArea.click();
			advancedSearchTextArea.sendKeys(searchOption);
			bp.waitForElement();
			
			clickOnGo.click();
			bp.waitForElement();
			//clickOnRelease.click();
			return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
			
		}

	
	
///////////////added 26-7-2017/////////////////////	
	public boolean verifySearchResult(String zql) throws Exception
	{
		try
		{
		//priority verification		
		List<WebElement> all=driver.findElements(By.xpath("//*[@id='grid-table-tcr']/div[2]/div/div[9]/div/div"));
		boolean res=false;
		for(int i=0;i<all.size();i++)
		{
			res=false;
			if(zql.equalsIgnoreCase(all.get(i).getText()));
			{
				res=true;
			}
		}
	
		
		
		if(res==true)
		{
			log.info("elements are matching");
		}
		return true;
	}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		//String txt=searchTestCaseText.getText();
		//System.out.println(txt);
		
//		if(zql.equals(txt))
//		{
//			log.info("should generate detailed Filter by just creation start date with coverage");
//		}
		
	}
	
	///////////added//////
	public boolean quiksearch(String Priority) throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		clickOnSearch.click();
		bp.waitForElement();
		WebDriverWait wait=new WebDriverWait(driver, 100);
		//wait.until(ExpectedConditions.elementToBeClickable(clickOnSearch));
		clickOnSearchTextArea.sendKeys(Priority);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnSearchTextArea));
		bp.waitForElement();
		bp.explicitWait(clickOnGo);
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

	
	/*	****************************************************
	 * Method Name			: selectpreviousSearch(String operator,String zql)
	 * Purpose				: To Click on the previous search in the test repository page
	 * Author				: OPAL4
	 * Date Created			: 27/07/17
	 * Date Modified		:
	 * Reviewed By			: OPAL2
	 * ******************************************************
	*/
	public boolean selectpreviousSearch(String operator,String zql) throws Exception
	{
		try
		{
		//String value=operator+zql;
		bp=new BasePage();
		bp.waitForElement();
		prevSearchDropDown.click();
		bp.waitForElement();
		//clickOnPreviousSearch.click();
		 String expRes;
		
		if(operator.equals("id="))
		{
			String value1=operator+zql;
			Select sel= new Select(previousSearch);
			sel.selectByValue(value1);
		List<WebElement> all=driver.findElements(By.xpath(".//*[@id='grid-table-tcr']/div[2]/div/div[3]/div/div"));
		boolean res=false;
		for(int i=0;i<all.size();i++)
		{
			res=false;
			if(zql.equals(all.get(i)));
			{
				res=true;
			}
		}
		if(res==true)
		{
			log.info("elements are matching");
		}
		
		}
		
		
		
		if(operator.equals("creator="))
		{
		
			//System.out.println(zql);
			String p= "\"" + zql + "\"";
			//System.out.println(p);
			//String q= " \+"zql\+";
		    String value2=operator+p;
		    //System.out.println(value2);
		    Select sel= new Select(previousSearch);
			sel.selectByValue(value2);
		    if(zql.equals("test.lead"))
		    {
		     expRes="Test Lead";
		    	bp=new BasePage();
		    	bp.waitForElement();
		   List<WebElement> all=driver.findElements(By.xpath(".//*[@id='grid-table-tcr']/div[2]/div/div[11]/div/div"));
		  // System.out.println(all.get(0).getText());
		   
		   boolean res=false;
		  for(int i=0;i<=all.size()-1;i++)
		   {
			  String actRes=all.get(i).getText();
			  
			res=false;
			
			if(expRes.equals(actRes));
			{
				Actions a2=new Actions(driver);
				a2.sendKeys(Keys.DOWN).perform();
				res=true;
			}
		   }
		if(res==true)
		{
			log.info("elements are matching");
		}
		
		}
	}
		
		if(operator.equals("name~"))
		{
			String p= "\"" + zql + "\"";
			
		    String value3=operator+p;
		    System.out.println(value3);
		    Select sel= new Select(previousSearch);
			sel.selectByValue(value3);
		}
		return true;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
			
		}
		}
		
      
	
	public boolean sortInSearchResult(String[] sortName) throws Exception
	{
		try
		{
		bp=new BasePage();
		WebElement ele=driver.findElement(By.xpath("//div[@class='flex-header-item column-chooser-parent dont-sort custom-column-chooser']//a"));
	    Actions a1=new Actions(driver);
	    a1.moveToElement(ele).click().perform();
		bp.waitForElement();
		
		/*
		String sort1="//label[@title='";
		String sort2="']/..//input";*/
		for(int i=0;i<=sortName.length-1;i++)
		{
		WebElement ele1=driver.findElement(By.xpath("//label[@title='Priority']"));
		
		boolean res=ele1.isSelected();
		
		if(res==false)
		{
			a1.moveToElement(ele1).click().perform();
		}
		}
		bp.waitForElement();
		a1.moveToElement(ele).click().perform();
		bp.waitForElement();
		
		return true;
		
	
	}
	catch (Exception e) {
		e.printStackTrace();
		throw e;

	}
}

}



