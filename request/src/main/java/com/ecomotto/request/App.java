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
    	App http = new App();
        http.post();
    }
    
    public void post() throws JSONException, IOException{
    	JSONObject json = new JSONObject();
    	JSONObject test = new JSONObject();
    	json.put("email", Param.email);
    	json.put("password", Param.password);
    	json.put("query", Param.query);
    	
    	CloseableHttpClient httpClient = HttpClients.createDefault();
    	List<NameValuePair> params = new ArrayList<NameValuePair>();
    	params.add(new BasicNameValuePair("data",json.toString()));

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
}
