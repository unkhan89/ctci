package util;

import java.net.*;
import java.io.*;

public class HttpManager {
	
	public static String httpGet(String url) {

		URL urlObj;
		
		String responseBody = "";

		try {

			urlObj = new URL(url);

			URLConnection connection = urlObj.openConnection();

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String responseLine;

			while ((responseLine = in.readLine()) != null) {

				responseBody += responseLine;
			}

			in.close();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return responseBody;
	}
}
