package com.ctc.launch;

	import org.openqa.selenium.By; 
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.Test;

	import com.ctc.service.MyUtil;
	import com.ctc.service.XpathConstants;

	import io.github.bonigarcia.wdm.WebDriverManager;
	import static com.ctc.service.XpathConstants.*;
	/* 
	  IMPORT STATIC IS A NEW METHOD IN JAVA WHICH HELPS US IN
	  DIRECTLY CALLING THE FUNCTION WITH OUT CLASS NAME...
	 */
	public class LaunchWebsite {
		
		public static WebDriver chromeBrowser=null;
		public static MyUtil myUtil = null;
		private static String url = WEBSITE_URL;
		
		@BeforeSuite
		public void openBrowser() {
				WebDriverManager.chromedriver().setup();
				chromeBrowser = new ChromeDriver();
				chromeBrowser.manage().window().maximize();
				chromeBrowser.get(url);
		}
	}
		
