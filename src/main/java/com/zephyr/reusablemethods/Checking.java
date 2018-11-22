package com.zephyr.reusablemethods;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;

public class Checking extends LaunchBrowser 
{
	
	public static void main(String[] args) throws Exception 
	{

//		for(int i=0;i<=0;i++)
//		{
//		 Excel_Lib.setData(STATUS, "Sheet1", i+1, 1, "P");
//		}
//		String name=Scenario.class.getName();
//		System.out.println();
		
		BasePage bp=new BasePage();
		String[] symbol=new String[1];
		symbol[0]=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 2, 1);
		System.out.println(symbol[0]);
		
//		String currentDate=bp.currentDate();
//		String[] date=currentDate.split("/");
//		System.out.println(currentDate);
//		String syear=date[2];
//		String smonth=date[0];
//		String sday=date[1];
//		System.out.println(syear);
//		System.out.println(smonth);
//		System.out.println(sday);
//		
		
//		 LaunchBrowser bt1=new LaunchBrowser();
//		 bt1.preCond();
//			String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"URL");
//			 bt1.getUrl(url);
//			LoginPage lpg=new LoginPage(driver);
//			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
//			lpg.enterUname(uname);
//			lpg.enterPass(uname);
//			 lpg.clickOnLogin();
//			 
//			 
//			 ProjectPage pp1=new ProjectPage(driver);
//			 pp1.selectProject("Sample Project");
//			 pp1.selectRelease("Release 1.0");
//			 
//			 ReleasePage rp=new ReleasePage(driver);
//			 
//			 rp.clickOnDefectTracking();
//			 
//			 driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
//				
//			 
//			 DefectTracking dt=new DefectTracking(driver);
////			 dt.defectSearch("Project", "AGILE KANBAN", "");
////			 driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
//			 
//			 pp1.selectProject("Sample Project");
//			 
////			 DashBoardPage dp=new DashBoardPage(driver);
////	 		String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
////	 		dp.clickOnManageDashboards();
////	 		String xpath1="//*[@id='grid-table-dashboard']/div[2]/div[";
////	 		String xpath2="]/div[5]/div/div[2]/span[2]/span";
////	 		
////	 		
////	 		for(int j=1;j<=20;j++)
////	 		{
////	 		for(int i=1;i<50;i++)
////	 		{
////	 			try
//	 			{
//	 		driver.findElement(By.xpath(xpath1+i+xpath2)).click();
//	 		Thread.sleep(1000);
//	 		driver.findElement(By.xpath("//*[@id='zui-dashboard-modal-delete']/div/div/div[3]/zui-modal-footer/button[2]")).click();
//	 		Thread.sleep(1000);
//	 			}
//	 			
//	 			catch(Exception e)
//	 			{
//	 				
//	 			}
//	         }

//	}
	}
	
	
}
