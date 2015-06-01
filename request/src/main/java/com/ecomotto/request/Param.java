package com.ecomotto.request;

import org.json.JSONException;
import org.json.JSONObject;

public class Param 
{
	//public static String apiURL = "http://162.222.179.107:8899/api/query";
	//public static String apiURL = "http://localhost:8080/api/query";
	//public static String apiURL = "http://localhost:8080/api/zipQuery";
	//public static String apiLoginURL = "http://localhost:8080/api/loginQuery";
	//public static String apiLogoutURL = "http://localhost:8080/api/logoutQuery";
	public static String apiURL = "http://169.54.208.180:8899/api/zipQuery";
	public static String apiLoginURL = "http://169.54.208.180:8899/api/loginQuery";
	public static String apiLogoutURL = "http://169.54.208.180:8899/api/logoutQuery";
	//public static String apiURL = "http://104.197.0.240:8899/api/query";
	
	public static String username = "test";
	public static String email = "jaSON.toddson@ecoMOtto.com";
	public static String password = "123";
	//public static String query = "select product from PROD_MATRIX where STATE = 'TX'";
	//public static String query = "select product from PROD_MATRIX where STATE = 'TX' order by fake_column";
	public static String query = "select * from nrg_bu";
	public static JSONObject zip = new JSONObject();
	
	public static void fillZip() throws JSONException{
		Param.zip.put("zip1", "75080");
		Param.zip.put("zip2", "75081");
	}
	//public static String query = "select ID from USERS where FIRST_NAME='nrg'"; 
}
