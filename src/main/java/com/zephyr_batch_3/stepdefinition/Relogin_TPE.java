package com.zephyr_batch_3.stepdefinition;

public class Relogin_TPE 
{
public void reLogin() throws Throwable
{
	Login_TPE l=new Login_TPE();
	l.user_Selects_the_Browser_Launches_it_and_Maximises_it_TPE();
	l.user_Navigates_to_the_URL_provided_TPE();
	l.user_Enters_Username_Password_and_clicks_on_login_TPE();
	l.user_should_be_Logged_in_into_Zephyr_Successfully_TPE();
}
}
