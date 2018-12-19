package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class TestBaseCalls {
	public String getValue(String key) {
		String value = "";
		try {
			FileReader fr = new FileReader(
					"F:\\Interview Quesitons\\APIAutomtation\\src\\test\\resources\\Utility.properties");
			Properties p = new Properties();
			p.load(fr);

			value = p.getProperty(key);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return value;
	}

	public static CloseableHttpClient createHttpConnection() {
		return HttpClients.createDefault();
	}

	public String getURI(String getCallUrl) {
		String url = "";
		try {
			url = getValue("serverUrl") + getValue(getCallUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

	public void getStatusCode(String uri) {

	}

	public void getJSONResonse(String uri) {

	}

	public void getResponseHeaders(String uri) {

	}
}
