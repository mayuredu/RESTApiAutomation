package apiCalls;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import base.TestBaseCalls;

public class POST extends TestBaseCalls {

	public CloseableHttpResponse getResponse(String uri)
			throws ClientProtocolException, IOException {
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		
		String entityString = "{\"name\" : \"" + super.getValue("name") +"\", \"job\" : \""+super.getValue("job")+"\"}";
		//System.out.println("JSON String: "+entityString);
		
		CloseableHttpClient httpClient = super.createHttpConnection();
		HttpPost httpPost = new HttpPost(super.getURI(uri));
		httpPost.setEntity(new StringEntity(entityString));
		
		for(Entry<String, String> header : headerMap.entrySet()){
			httpPost.addHeader(header.getKey(), header.getValue());
		}
		
		return httpClient.execute(httpPost);
	}

	public void getStatusCode(String uri) {
		try{
			int statusCode = getResponse(uri).getStatusLine().getStatusCode();
			System.out.println("POST Status Code: "+statusCode);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void getJSONResonse(String uri) {
		try{
			String jsonResponseString = EntityUtils.toString(getResponse(uri).getEntity(), "UTF-8");
			JSONObject jsonResponse = new JSONObject(jsonResponseString);
			System.out.println("JSON Respose: "+jsonResponse);
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public void getResponseHeaders(String uri) {
		try{
			Header[] headers = getResponse(uri).getAllHeaders();
			HashMap<String, String> allHeaders = new HashMap<String, String>();
			
			for(Header header : headers){
				allHeaders.put(header.getName(), header.getValue());
			}
			
			System.out.println("All Headers: ");
			for(Map.Entry<String, String> header : allHeaders.entrySet()){
				System.out.println(header.getKey()+" : "+header.getValue());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
