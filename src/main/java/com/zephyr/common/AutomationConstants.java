package com.zephyr.common;

import com.zephyr.generic.Property_Lib;

public interface AutomationConstants
{
	public static  final String CONFIG_PATH="./ConfigFiles/";
	public static  final String CONFIG_FILE="config.properties";
	public static  final String CONFIG_FILE_TPE="Config_TPE.properties";
	
	public static  final String CONFIG_FILE_REQ="Config_REQ.properties";
	public static  final String CONFIG_FILE_DASH="Config_DASH.properties";
	public static  final String CONFIG_FILE_DT="Config_DT.properties";
	
	public static  final String CONFIG_FILE2="config2.properties";
	
	public static  final String DRIVER_PATH="./Drivers/";
	public static  final String CHROME_FILE="chromedriver.exe";
	
	public static  final String GECKO_FILE="geckodriver.exe";
	public static  final String IE_FILE="IEDriverServer.exe";

	public static 	final String INPUT_PATH="./User_Input/inputs.xlsx";
	public static 	final String INPUT_PATH_1="./User_Input/inputs_1.xlsx";
	public static final String INPUT_PATH_2="./User_Input/inputs_2.xlsx";
	public static 	final String INPUT_PATH_3="./User_Input/Inputs_3.xlsx";
	public static 	final String INPUT_PATH_4="./User_Input/input_4.xlsx";
	public static 	final String INPUT_PATH_5="./User_Input/Inputs_5.xlsx";
	
	public static 	final String INPUT_PATH_6="./User_Input/input_6.xlsx";
	public static 	final String INPUT_PATH_7="./User_Input/input_7.xlsx";
	public static 	final String INPUT_PATH_8="./User_Input/input_8.xlsx";
	public static 	final String INPUT_PATH_9="./User_Input/input_9.xlsx";
	public static  final String CHROME_KEY="webdriver.chrome.driver";;
	public static  final String GECKO_KEY="webdriver.gecko.driver";
	
	public static  final String IE_KEY="webdriver.ie.driver";
	
	public static  final String CONFIG_PATH1="./ConfigFiles/config2.properties";
	 public static String UNIQUE="Auto_"+Property_Lib.getPropertyValue(CONFIG_PATH1,"Count");
	 public static final int EXPLICIT=Integer.parseInt(Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"EXPLICIT"));
	 public static final int MAX_EXPLICIT=Integer.parseInt(Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"MAXEXPLICIT"));

	 public static final String STATUS="./Status/status.xlsx";
	 
	 //E://Software//Driver.exe//IEDriverServer_Win32_3.4.0//IEDriverServer.exe
	
}











