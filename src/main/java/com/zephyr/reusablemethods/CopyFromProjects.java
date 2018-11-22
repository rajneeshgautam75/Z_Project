package com.zephyr.reusablemethods;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zephyr.common.LaunchBrowser;

public class CopyFromProjects 
{

	WebDriver driver;
	BasePage bp;
	 public Logger log;
	 
	 
	
		@FindBy(xpath="//*[@data-name='Projects']")
		public WebElement project;
		
		//for selecting release
		public String release1="//a[@data-desc='";
		public String release2="' and text()='";
		public String release3="']";
		
		//for selecting node in localArea
		public String node1="(//a[text()='";
		public String node2="'])[1]";
		
		//for selecting test case in global
		public String globalTestCase1="//*[@id='grid-table-global']/div[2]/div[";
		public String globalTestCase2="]/div[1]/div/div/input";
		
		
		@FindBy(xpath="//h4[text()='Copy from Project Releases']")
		protected WebElement validateCopyFromProjectReleasesPage;

		//For Selecting Project From global Area
		public String globalProject1="//a[text()='";
		public String globalProject2="']";

		//for selecting node in GlobalArea from same release
			public String node3="(//a[text()='";
			
			public String node4="'])[1]";
		
			//for selecting node in GlobalArea from other release
			public String node5="//a[text()='";
			public String node6="']";
			
	        public String localRelease1="(//a[@data-name='";
			
			public String localRelease2="'])[2]";
			
			//TestCaseCount
			
			public String testCaseCount="//*[@id='zee-global-tcr-tree-modal']/div/div/div[2]/zui-modal-body/div/div[2]/div/div[3]/grid/div[2]/div/div[2]/b[2]";
			
			
			@FindBy(xpath="//*[@id='zee-global-tcr-tree-modal']/div/div/div[1]/div[2]/button")
			protected WebElement closeCopyFromProjectReleasesPage;
			


	     //Selecting node from;looooca area
			public String lnode1="//*[@id='zephyr-tree-localTree']/ul/li/ul//text()='";
			public String lnode2="']";
			
			
			
			public String localNode1="//*[@id='zephyr-tree-localTree']/ul//*[text()='";
			public String localNode2="']";
			
			public String globalNode1="//*[@class='tree-view global-tcr no-child js-global-wrapper expanded-on-hover tree-docked']//*[text()='";
			public String globalNode2="']";
			
			
			//14-08-17
		///////12-8-17
			 
			  
			public String globalIMportedNode1="((//a[text()='Imported'])[2]/following-sibling::ul//a[starts-with(@data-desc,'FileName : ";
		    public String globalIMportedNode2="')])[1]";
		
			
//			  public String globalIMportedNode1="//*[@class='tree-view global-tcr no-child js-global-wrapper']//*[text()='";
//			  public String globalIMportedNode2="']";
//			  
			  @FindBy(xpath="//*[@class='tree-view global-tcr no-child js-global-wrapper expanded-on-hover tree-docked']//*[text()='Imported']")
			  public WebElement doubleClickOnImported;
			  
			  @FindBy(xpath="//div[@class='contextMenuIcon fa fa-ellipsis-v']")
			  public WebElement options;
			  
			  @FindBy(xpath="//a[text()='Copy from Project Releases']")
			  protected WebElement copyFromProjectReleasesOption;
			  
			  public String expandNode="/..";

	 
	public CopyFromProjects(WebDriver driver)
	{

		this.driver = driver;
		PageFactory.initElements(LaunchBrowser.driver, this);
		log=Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);

	}


	
	
	
//	Methods 
	public boolean dragAndDropTestCase(WebElement ele,String node) throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		WebElement nodes=driver.findElement(By.xpath(localNode1+node+localNode2));
		String text=nodes.getText();
		System.out.println(text);
		Actions a1=new Actions(driver);
		a1.moveToElement(ele).clickAndHold(ele).perform();
		a1.release(nodes).perform();
		
		log.info("Test case moved to the node");
		
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
		
	}
	
	public boolean dragAndDropNodes(String nodeName1,String nodeName2) throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
		WebElement ele1=driver.findElement(By.xpath(globalNode1+nodeName1+globalNode2));
		WebElement ele2=driver.findElement(By.xpath(localNode1+nodeName2+localNode2));
		Actions a2=new Actions(driver);
		a2.dragAndDrop(ele1, ele2).perform();
		
		log.info("Nodes moved sucessfully");
		return true;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	public boolean copyFromProjectReleasesOption() throws Exception
	{
		 try
		   {
			   bp=new BasePage();
			   bp.waitForElement();
		   options.click();
		   copyFromProjectReleasesOption.click();
		   log.info("Copy from project release option is clicked");
		   bp.waitForElement();
		   return true;
		   }
		   catch(Exception e)
			{
	  	    e.printStackTrace();
	  	     throw e;
			}
	}
	
	public boolean verifyCopyFromProjectPage() throws Exception
	   {
		   try
		   {
			   bp=new BasePage();
			   bp.waitForElement();
			   
			   String validateCopyFromProjectReleasesPageTitle=validateCopyFromProjectReleasesPage.getText();
			   System.out.println(validateCopyFromProjectReleasesPageTitle);
			  if(validateCopyFromProjectReleasesPageTitle.equals("Copy from Project Releases"))
			  {
				  log.info("Pass-Successfully navigated to Copy From Project Releases Page");
			  }
			  else
			  {
				  log.info("Fail-You are not navigated to Copy From Project Releases Page");
			  }
			  
			  return true;
		   }
		   catch(Exception e)
			{
	 	    e.printStackTrace();
	 	     throw e;
			}
	   }
	
	public boolean selectProjectFromGlobalArea(String projectName) throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
		
		Actions a2=new Actions(driver);
		a2.doubleClick(project).build().perform();
		bp.waitForElement();
		String globalProject=globalProject1+projectName+globalProject2;
		WebElement ele=driver.findElement(By.xpath(globalProject));
		Actions act=new Actions(driver);
		act.doubleClick(ele).build().perform();
		
		log.info(projectName+" is selected from global Project Area");
		return true;
		}
		 catch(Exception e)
		{
 	    e.printStackTrace();
 	     throw e;
		}
		
	}
	
	public boolean selectNodeFromGlobalArea(String releaseName,String[] nodes) throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
		String globalRelease=globalNode1+releaseName+globalNode2;
		WebElement ele=driver.findElement(By.xpath(globalRelease));
		Actions act=new Actions(driver);
		act.doubleClick(ele).build().perform();
		
		log.info("Pass - Double click on'"+releaseName+"' Successfull");
		bp=new BasePage();
		bp.waitForElement();
		
		
		for(int i=0;i<=nodes.length-1;i++)
		{
			bp.waitForElement();
			String allnodes=globalNode1+nodes[i]+globalNode2;
			
			WebElement nodeElement=driver.findElement(By.xpath(allnodes));
			act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
			
			log.info("Pass - Double click on'"+nodes[i]+"' Successfull");
			
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
	public boolean selectMultipleTestCaseFromGlobalNode(String[] no) throws Exception
	{
		try
		{
			bp=new BasePage();
		for(int i=0;i<=no.length-1;i++)
		{
		bp.waitForElement();
		WebElement ele=driver.findElement(By.xpath(globalTestCase1+no[i]+globalTestCase2));
		ele.click();
		}
		
		System.out.println(no.length+"- testcases selected successfully");
		return true;
		} 
		catch(Exception e)
		{
	 	    e.printStackTrace();
	 	     throw e;
			}
	}
	
	

	public boolean selectingNodeFromLocalArea(String releaseName,String[] nodes) throws Exception
	{
		try
		{ 
			bp=new BasePage();
			bp.waitForElement();
		String localRelease=localNode1+releaseName+localNode2;
		WebElement ele=driver.findElement(By.xpath(localRelease));
		
		WebElement releaseExpandcheck=driver.findElement(By.xpath(localNode1+releaseName+localNode2+expandNode));
		   String text=releaseExpandcheck.getAttribute("aria-expanded");
		 //  String text=releaseExpand.getAttribute("aria-expanded");
		   Actions act = new Actions(driver);
		   System.out.println(text);
		   if(text.equals("false"))
		   {
		  
		   act.moveToElement(ele).doubleClick().perform();
		   bp.waitForElement();
		   System.out.println("Pass - double click on'" + releaseName + "' Successfull");
		   bp.waitForElement();}
		   else
		   {
		    bp=new BasePage();
		    //String releasename3 = releasename1 + releaseName + releasename2;
		     ele.click();
		    System.out.println("Release already in Expanded mode");
		    bp.waitForElement();

		   
		  }
		
		
		for(int i=0;i<=nodes.length-1;i++)
		{
			bp.waitForElement();
			String allnodes=localNode1+nodes[i]+localNode2;
			
			WebElement nodeElement=driver.findElement(By.xpath(allnodes));
			act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
			
			log.info("Pass - Double click on'"+nodes[i]+"' Successfull");
			//act.moveToElement(nodeElement).click().perform();
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

	public boolean testCaseCountInCopyfromProjectReleases() throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		String testCase=driver.findElement(By.xpath(testCaseCount)).getText();
		System.out.println("Total Test Case present in Node-"+testCase);
		
		return true;
		}
		 catch(Exception e)
		{
 	    e.printStackTrace();
 	     throw e;
		}
	}
  public boolean closeCopyFromProjectReleasesPage() throws Exception
  {
	  try
	  {
		  bp=new BasePage();
		  bp.waitForElement();
		  bp.waitForElement();
	      closeCopyFromProjectReleasesPage.click();
	      System.out.println("Copy from Project Release Page is closed");
	      bp.waitForElement();
	      
	  return true;
	  }
	  catch(Exception e)
		{
	    e.printStackTrace();
	     throw e;
		}
	  
  }

  public boolean selectingLocalRelease(String releaseName) throws Exception
  {
	  try
	  {
	    bp=new BasePage();
	    bp.waitForElement();
		String localRelease=localNode1+releaseName+localNode2;
		WebElement ele=driver.findElement(By.xpath(localRelease));
		Actions act=new Actions(driver);
		act.doubleClick(ele).build().perform();
		
		
		return true;
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
		  throw e;
	  }
  }
  
  //14-08-17
  public boolean selectNodeFromImportedArea(String[] nodes) throws Exception
  {
   bp=new BasePage();
   bp.waitForElement();
      Actions act=new Actions(driver);
    act.doubleClick(doubleClickOnImported).build().perform();
   try
   {
    
   
   bp.waitForElement();
   //bp.waitForElement();
   for(int i=0;i<=nodes.length-1;i++)
   {
    String allnodes=globalIMportedNode1+nodes[i]+globalIMportedNode2;
    
    WebElement nodeElement=driver.findElement(By.xpath(allnodes));
    
    act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
    
    
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
  
  public boolean dragAndDropNodes2(String nodeName1,String nodeName2,WebDriver driver2) throws Exception
	{
		try
		{
			this.driver=driver2;
			bp=new BasePage();
			bp.waitForElement();
			String globalNode1="//*[@class='tree-view global-tcr no-child js-global-wrapper expanded-on-hover tree-docked']//*[text()='";
			String globalNode2="']";
			String localNode1="//*[@id='zephyr-tree-localTree']/ul//*[text()='";
			String localNode2="']";
		WebElement ele1=driver.findElement(By.xpath(globalNode1+nodeName1+globalNode2));
		WebElement ele2=driver.findElement(By.xpath(localNode1+nodeName2+localNode2));
		Actions a2=new Actions(driver);
		a2.dragAndDrop(ele1, ele2).perform();
		
		log.info("Nodes moved sucessfully");
		return true;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
  
  public boolean selectProjectFromGlobalArea2(String projectName,WebDriver driver2) throws Exception
	{
		try
		{
			this.driver=driver2;
			bp=new BasePage();
			String globalProject1="//a[text()='";
			String globalProject2="']";
			bp.waitForElement();
		Actions a2=new Actions(driver);
		WebElement ele1=driver.findElement(By.xpath("//*[@data-name='Projects']"));
		
		
		//WebElement ele1=driver.findElement(By.xpath("(//*[@data-name='Projects']//preceding-sibling::i)[1]"));
		ele1.click();
		
		a2.doubleClick(ele1).build().perform();
		bp.waitForElement();
		
		String globalProject=globalProject1+projectName+globalProject2;
		WebElement ele=driver.findElement(By.xpath(globalProject));
		Actions act=new Actions(driver);
		act.doubleClick(ele).build().perform();
		
		log.info(projectName+" is selected");
		return true;
		}
		 catch(Exception e)
		{
	    e.printStackTrace();
	     throw e;
		}
		
	}
		
	
  
  public boolean selectNodeFromGlobalArea2(String releaseName,String[] nodes,WebDriver driver2) throws Exception
	{
		try
		{
			this.driver=driver2;
			bp=new BasePage();
			String globalNode1="//*[@class='tree-view global-tcr no-child js-global-wrapper expanded-on-hover tree-docked']//*[text()='";
			String globalNode2="']";
			bp.waitForElement();
		String globalRelease=globalNode1+releaseName+globalNode2;
		WebElement ele=driver.findElement(By.xpath(globalRelease));
		Actions act=new Actions(driver);
		act.doubleClick(ele).build().perform();
		
		log.info("Pass - Double click on'"+releaseName+"' Successfull");
		bp=new BasePage();
		bp.waitForElement();
		//bp.waitForElement();
		
		for(int i=0;i<=nodes.length-1;i++)
		{
			bp.waitForElement();
			
			String allnodes=globalNode1+nodes[i]+globalNode2;
			
			WebElement nodeElement=driver.findElement(By.xpath(allnodes));
			
			act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
			
			log.info("Pass - Double click on'"+nodes[i]+"' Successfull");
			
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
  public boolean closeCopyFromProjectReleasesPage2(WebDriver driver2) throws Exception
  {
	  try
	  {
		  this.driver=driver2;
		  bp=new BasePage();
		  bp.waitForElement();
		  bp.waitForElement();
		  driver.findElement(By.xpath("//*[@id='zee-global-tcr-tree-modal']/div/div/div[1]/div[2]/button")).click();
	      
	      bp.waitForElement();
	      
	  return true;
	  }
	  catch(Exception e)
		{
	    e.printStackTrace();
	     throw e;
		}
	  
	  
	  
  }
  
  

  public boolean dragAndDropImportedNodes(String nodeName1,String nodeName2) throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
		//WebElement ele1=driver.findElement(By.xpath(globalNode1+nodeName1+globalNode2));
			WebElement ele1=driver.findElement(By.xpath(globalIMportedNode1+nodeName1+globalIMportedNode2));
			WebElement ele2=driver.findElement(By.xpath(localNode1+nodeName2+localNode2));
		Actions a2=new Actions(driver);
		a2.clickAndHold(ele1).perform();
		a2.release(ele2).perform();
		
		//a2.dragAndDrop(ele1, ele2).perform();
		bp.waitForElement();
		log.info("Nodes moved sucessfully");
		return true;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
  
  

  public  boolean validateCopiedFile(String fileName) throws Exception
  {
	  try
	  {
		  bp=new BasePage();
			bp.waitForElement();
			String A="//*[starts-with(@data-desc,'FileName : ";
			String B="')]";
			String ImportedFile=A+fileName+B;
			driver.findElement(By.xpath(ImportedFile)).click();
			System.out.println("Imported File Copied to the local Node");
		  return true;
	  }
	  
	  catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
  }


	
}