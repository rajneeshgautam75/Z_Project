package com.zephyr.reusablemethods;

public class UserDefinedException extends Throwable
{

	private static final long serialVersionUID = 1L;
		String str1; 
		public UserDefinedException(String str2) 
		{
			str1=str2;
		  }
	
	
		public String toString()
	   { 
		
		return ("MyException Occurred: "+str1) ;
	   }
	
}

