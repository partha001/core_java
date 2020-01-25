package com.partha.ds.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class G02WebCrawler {
	
	public static void main(String[] args) {
		WebCrawler crawler = new WebCrawler();
		String rooturl = "https://www.bbc.com";	
		crawler.discoverWeb(rooturl);
	}
	
	
	public static class WebCrawler {
		
		private Queue<String> queue;
		private List<String> discoveredWebsiteList;
		
		public WebCrawler() {
			super();
			this.queue = new LinkedList<>();
			this.discoveredWebsiteList = new ArrayList<String>();
		}
		
		public void discoverWeb(String root) {
			this.queue.add(root);
			this.discoveredWebsiteList.add(root);
			while(!queue.isEmpty()) {
				String vertex = queue.poll();
				String rawHtml = readUrl(vertex);
				String regexp = "https://(\\w+\\.)*(\\w+)";
				Pattern pattern = Pattern.compile(regexp);
				Matcher matcher = pattern.matcher(rawHtml);
				
				while(matcher.find()) {
					String actualUrl = matcher.group();
					if(!discoveredWebsiteList.contains(actualUrl)) {
						discoveredWebsiteList.add(actualUrl);
						System.out.println("website has been found with url "+actualUrl);
						queue.add(actualUrl);
					}
				}
			}
		}
		
		private String readUrl (String v) {
			String rawHtml ="";
			try {
				URL url = new URL(v);
				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
				String inputLine = "";
				while( (inputLine  = br.readLine())!= null) {
					rawHtml += inputLine;
				}
				br.close();
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			return rawHtml;
		}
		
		
	}

}
