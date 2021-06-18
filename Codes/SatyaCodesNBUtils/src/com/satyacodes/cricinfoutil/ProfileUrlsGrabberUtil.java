package com.satyacodes.cricinfoutil;

import java.io.FileWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ProfileUrlsGrabberUtil {

	public static void grabUrls(String url, String outputTxt, int maxPage) throws Exception {
		System.out.println(url);
		
	    FileWriter myWriter = new FileWriter(outputTxt);

		for (int i = 1; i <=maxPage; i++) {


			String pageStr = ";page=" + i + ";";
			String completeUrl = (url + pageStr);
			System.out.println(i + " : " + completeUrl);

			Document doc = Jsoup.connect(completeUrl).get();

			Elements links = doc.select("a[href]");

			// Iterate links and print link attributes.
			for (Element link : links) {
				String linkName = link.attr("href");
				if (linkName.contains("content/player")) {
					myWriter.write("https://stats.espncricinfo.com" + linkName+"\n");		     

				}
			}
		}
		myWriter.close();
	}
	
	

}
