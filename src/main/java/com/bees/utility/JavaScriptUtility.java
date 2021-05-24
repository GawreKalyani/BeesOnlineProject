package com.bees.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.bees.base.Testbase;

public class JavaScriptUtility extends Testbase {

	
	public static void scrollDownFully()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	
	public static void scrollUpFully()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	}
	
	public static void scrollUptoElement(WebElement element){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//"arguments[0]" means first index of page starting at 0
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
