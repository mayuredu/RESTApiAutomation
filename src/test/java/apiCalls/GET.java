package apiCalls;

import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import base.TestBaseCalls;

public class GET extends TestBaseCalls {
	public CloseableHttpResponse  response;
	
	public CloseableHttpResponse getCallResponse(String uri){
		this.response = null;
		try{
			HttpGet httpGet = new HttpGet(super.getURI(uri));
			this.response = super.createHttpConnection().execute(httpGet);
		}catch(Exception e){
			e.printStackTrace();
		}
		return this.response;
	}
	
	public void getStatusCode(String uri){
		try{
			int statusCode = this.getCallResponse(uri).getStatusLine().getStatusCode();
			System.out.println("Status Code: "+statusCode);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void getJSONResonse(String uri){
		try{
			String jsonString = EntityUtils.toString(this.getCallResponse(uri).getEntity(), "UTF-8");
			JSONObject jsonResponse = new JSONObject(jsonString);
			System.out.println("JSON Response: "+jsonResponse);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void getResponseHeaders(String uri){
		try{
			Header[] headers = this.getCallResponse(uri).getAllHeaders();
			HashMap<String, String> allHeaders = new HashMap<String, String>();
			for(Header header : headers){
				allHeaders.put(header.getName(), header.getValue());
			}
			
			System.out.println("All Headers: ");
			for(Entry<String, String> header : allHeaders.entrySet()){
				System.out.println(header.getKey()+" : "+header.getValue());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}