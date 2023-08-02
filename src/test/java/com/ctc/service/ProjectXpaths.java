package com.ctc.service;

import java.io.FileReader; 
import java.util.Properties;

public class ProjectXpaths {
	
		private static final String xpathFileLocation ="src/test/java/project_Xpaths.properties";
		private static Properties p = null;
		private static FileReader reader = null;
		
		public static String getXPath(String key) {
			
			try {
				if (p == null)
					p =new Properties();  
			    
				if (reader == null)
					reader =new FileReader(xpathFileLocation);  
			    
				p.load(reader); 
			} catch (Exception exp) {
				exp.printStackTrace();
			}
			System.out.println(p.getProperty(key));
			return p.getProperty(key);
		}
	}

