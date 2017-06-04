package projects;

import util.HttpManager;
import java.util.HashMap;

public class FinancialsGrepper {
	
	public static void main(String[] args) {
		
		
		String webpage = HttpManager.httpGet("https://en.wikipedia.org/wiki/Amazon.com");
		
//		System.out.println(webpage);
		
		HashMap<String, String> financials = new HashMap<>();

		financials.put("Revenue", "<a href=\"/wiki/Revenue\" title=\"Revenue\">Revenue</a>");
		financials.put("Net Income", "<a href=\"/wiki/Net_income\" title=\"Net income\">Net income</a>");;
		
		boolean lookForDollarAmount = false;
		
		String dollar = "US$";
		
		for(int i = 0; i < webpage.length(); i++) {
			
			for(String k : financials.keySet()) {
				
				if(i + financials.get(k).length() < webpage.length()) {
					
					if(webpage.substring(i, i + financials.get(k).length()).equals(financials.get(k))) {
						
						System.out.print(k + ": ");
						
						lookForDollarAmount = true;
					}
				}
				
			}
			
			if(lookForDollarAmount) {
				
				if(i + dollar.length() < webpage.length()) {
					
					if(webpage.substring(i, i + dollar.length()).equals(dollar)) {
						
						System.out.println(webpage.substring(i + dollar.length(), i + 10));
						
						lookForDollarAmount = false;
					}
				}
			}
		}

	}
	
	private static void log(String message) {
		
		System.out.println("[DEBUG] " + message);
	}
}
