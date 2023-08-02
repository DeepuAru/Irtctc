package com.ctc.service;
import org.openqa.selenium.By;  
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

public class MyUtil {
	public static WebDriver chromeBrowser=null;

	public MyUtil(WebDriver chromeBrowser) {
	this.chromeBrowser = chromeBrowser;
	}

	public static void mouseHoverAndClick(String mouseHoverXpath, String clickXpath) {
		WebElement ele = chromeBrowser.findElement(By.xpath(mouseHoverXpath));
		//Creating object of an Actions class
		Actions action = new Actions(chromeBrowser);
		//Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		
		WebDriverWait wait = new WebDriverWait(chromeBrowser,10);
		
		chromeBrowser.findElement(By.xpath(clickXpath)).click();
	}
	
	public static void mouseHoverAndHoverAndClick(String mouseHoverXpath, String hoverXpath, String clickXpath) {
		WebElement ele = chromeBrowser.findElement(By.xpath(mouseHoverXpath));
		//Creating object of an Actions class
		Actions action = new Actions(chromeBrowser);
		//Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		
		WebDriverWait wait = new WebDriverWait(chromeBrowser,10);
		
		mouseHoverAndClick(hoverXpath, clickXpath);
	}
	
	
	public static void myWait(String waitXpath, int secs) {
		WebDriverWait wait = new WebDriverWait(chromeBrowser, secs);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(waitXpath)));
		((JavascriptExecutor)chromeBrowser).executeScript("arguments[0].click();", element);
	}
	
	public static void justWait(String xPath, int secs) {
		WebDriverWait wait = new WebDriverWait(chromeBrowser,secs);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
	}

	public static void scroll(String xpath) {
		JavascriptExecutor js = (JavascriptExecutor) chromeBrowser;
		WebElement scroleElement = chromeBrowser.findElement(By.xpath(xpath));		
        js.executeScript("arguments[0].scrollIntoView();", scroleElement);
        chromeBrowser.findElement(By.xpath(xpath)).click();
	}
}
