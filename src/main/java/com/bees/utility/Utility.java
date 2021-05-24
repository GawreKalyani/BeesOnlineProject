package com.bees.utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility {
	WebDriver driver;

	public static String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public static void sendkeys(WebElement element, String datatoEnter) {
		element.sendKeys(datatoEnter);
	}

	public static void selectBy(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	public static void clear(WebElement button) {
		button.clear();
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static String getText(WebElement element) {
		return element.getText();
	}
	public static ArrayList<String> getActualTableRowData(List<WebElement> tableData) {
		ArrayList<String> actHead = new ArrayList<String>();
		for (WebElement element : tableData) {
			String text = element.getText();
			actHead.add(text);
			System.out.println(text);
		}
		return actHead;
	}
	public static String alertHandle(WebDriver driver) {
		Alert al = driver.switchTo().alert();
		String alertmsg = al.getText();
		al.accept();
		return alertmsg;

	}
}
