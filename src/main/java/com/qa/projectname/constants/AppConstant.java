package com.qa.projectname.constants;

import java.util.List;

public class AppConstant {

	public static final int DEFAULT_TIMEOUT = 5;
	public static final int MEDIUM_TIMEOUT = 10;
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String HOME_PAGE_TITLE = "My Account";
	public static final String LOGIN_PAGE_FRACTION_URL = "route=account/login";
	public static final String HOME_PAGE_FRACTION_URL = "route=account/account";
	
	//when final is added then Capital naming convention to be followed below
	public static  List <String> expectedHeadersList = List.of("My Account", "My Orders", "My Affiliate Account", "Newsletter");      
	public static final String RESITER_SUCCESS_MSG = "Your Account Has Been Created!" ;
	
}
