package com.ecomotto.request;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.ecomotto.request.Param;

public class App 
{
	
    public static void main( String[] args ) throws JSONException, IOException
    {
    	printOption();
    	
    	int flag = 0;
    	while(flag == 0){
    		try{
        	    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        	    String str = bufferRead.readLine();
        	    int selection = Integer.parseInt(str);
        	    switch(selection){
        	    	case 1:
        	    		login();
        	    		printOption();
        	    		break;
        	    	case 2:
        	    		logout();
        	    		printOption();
        	    		break;
        	    	case 3:
        	    		post();
        	    		printOption();
        	    		break;
        	    	case 4:
        	    		flag = 1;
        	    		System.out.println("Exiting...");
        	    		break;
        	    	default:
        	    		printOption();
        	    		break;
        	    }
        	    
        	    //System.out.println(s);
        	}
        	catch(IOException e)
        	{
        		e.printStackTrace();
        	}
    	}
    }
    public static void login() throws JSONException, IOException{
    	JSONObject json = new JSONObject();
    	
    	//Param.fillZip();
    	//JSONObject test = new JSONObject();
    	json.put("email", Param.email);
    	json.put("password", Param.password);
    	//json.put("query", Param.query);
    	//json.put("zip", Param.zip);
    	//json.put("username", Param.username);
    	
    	CloseableHttpClient httpClient = HttpClients.createDefault();
    	List<NameValuePair> params = new ArrayList<NameValuePair>();
    	params.add(new BasicNameValuePair("data",json.toString()));
    	//System.out.println("Request JSON: "+json.toString());
    	try {

    	    HttpPost request = new HttpPost(Param.apiLoginURL);
    	    
    	    request.setEntity(new UrlEncodedFormEntity(params));
    	    System.out.println("Execute the login request to URL: "+Param.apiLoginURL);
    	    HttpResponse response = httpClient.execute(request);
    	    BufferedReader rd = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));
            String line = "";
            while ((line = rd.readLine()) != null) {
               //Parse our JSON response               
               System.out.println("results from server: "+line);
            }
    	// handle response here...
    	} catch (Exception ex) {
    	    // handle exception here
    	} finally {
    		httpClient.close();
    	}
    }
    
    public static void logout() throws JSONException, IOException{
    	JSONObject json = new JSONObject();
    	
    	//Param.fillZip();
    	//JSONObject test = new JSONObject();
    	json.put("email", Param.email);
    	//json.put("password", Param.password);
    	//json.put("query", Param.query);
    	//json.put("zip", Param.zip);
    	//json.put("username", Param.username);
    	
    	CloseableHttpClient httpClient = HttpClients.createDefault();
    	List<NameValuePair> params = new ArrayList<NameValuePair>();
    	params.add(new BasicNameValuePair("data",json.toString()));
    	//System.out.println("Request JSON: "+json.toString());
    	try {

    	    HttpPost request = new HttpPost(Param.apiLogoutURL);
    	    
    	    request.setEntity(new UrlEncodedFormEntity(params));
    	    System.out.println("Execute the logout request to URL: "+Param.apiLogoutURL);
    	    HttpResponse response = httpClient.execute(request);
    	    BufferedReader rd = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));
            String line = "";
            while ((line = rd.readLine()) != null) {
               //Parse our JSON response               
               System.out.println("results from server: "+line);
            }
    	// handle response here...
    	} catch (Exception ex) {
    	    // handle exception here
    	} finally {
    		httpClient.close();
    	}
    }
    
    public static void post() throws JSONException, IOException{
    	JSONObject json = new JSONObject();
    	
    	Param.fillZip();
    	//JSONObject test = new JSONObject();
    	json.put("email", Param.email);
    	//json.put("password", Param.password);
    	//json.put("query", Param.query);
    	json.put("zip", Param.zip);
    	//json.put("username", Param.username);
    	
    	CloseableHttpClient httpClient = HttpClients.createDefault();
    	List<NameValuePair> params = new ArrayList<NameValuePair>();
    	params.add(new BasicNameValuePair("data",json.toString()));
    	//System.out.println("Request JSON: "+json.toString());
    	try {

    	    HttpPost request = new HttpPost(Param.apiURL);
    	    
    	    request.setEntity(new UrlEncodedFormEntity(params));
    	    System.out.println("Execute the post request to URL: "+Param.apiURL);
    	    HttpResponse response = httpClient.execute(request);
    	    BufferedReader rd = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));
            String line = "";
            while ((line = rd.readLine()) != null) {
               //Parse our JSON response               
               System.out.println("results from server: "+line);
            }
    	// handle response here...
    	} catch (Exception ex) {
    	    // handle exception here
    	} finally {
    		httpClient.close();
    	}
    }
    
    public static void printOption(){
    	System.out.println("1. Login");
    	System.out.println("2. Logout");
    	System.out.println("3. Submit Query");
    	System.out.println("4. Exit Application");
    	System.out.println("Please make selection by entering the number:");
    }
}
