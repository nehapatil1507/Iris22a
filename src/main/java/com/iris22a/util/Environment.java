package com.iris22a.util;

public class Environment {

	private static String filePath = "/src/main/resources/Environment.properties";
	public static String URL ;
	public static String appUser1 ;
	
	
	static {
		PropUtil prop = new PropUtil();
		String baseDir = System.getProperty("user.dir");
		URL =prop.getValue(baseDir + filePath, "app_url");
		appUser1= prop.getValue(baseDir+filePath, "app_user1");
		
	}

	
}
