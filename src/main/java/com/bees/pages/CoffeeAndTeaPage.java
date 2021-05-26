package com.bees.pages;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bees.objetRepositary.CoffeeAndTeaObjRepo;
import com.bees.utility.ExcelUtility;
import com.bees.utility.Utility;

public class CoffeeAndTeaPage extends CoffeeAndTeaObjRepo {

	WebDriver driver;

	public CoffeeAndTeaPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean productSortDropDown() throws Exception {
		ArrayList<String> actData = new ArrayList<String>();
		Select s = new Select(select);
		List<WebElement> list = s.getOptions();
		for (WebElement ele : list) {
			String text = ele.getText();
			actData.add(text);
			System.out.println(text);
		}
		ArrayList<String> expData = ExcelUtility.getColumnData("TestData.xlsx", "sortBy", 0);
		if (actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean sortProductPrices() throws Exception {
		Utility.selectBy(select, "Price: Lowest first");
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement e : prices) {
			String text = e.getText();
			actData.add(text);
		}
		Collections.sort(actData);
		System.out.println(actData);

		ArrayList<String> expData = ExcelUtility.getColumnData("TestData.xlsx", "ascendingPrices", 0);

		if (actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean sortProductPricesInDescOrder() throws Exception {
		
		Utility.selectBy(select, "Price: Highest first");
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement e : prices) {
			String text = e.getText();
			actData.add(text);
		}
		Collections.sort(actData,Collections.reverseOrder());
		System.out.println(actData);

		ArrayList<String> expData = ExcelUtility.getColumnData("TestData.xlsx", "descPrices", 0);

		if (actData.equals(expData))
			return true;
		else
			return false;
	}
	
	public boolean sortingAlphabetically()throws Exception{
		Utility.selectBy(select, "Product Name: A to Z");
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement e : namesOfProduct) {
			String text = e.getText();
			actData.add(text);
		}
		Collections.sort(actData);
		System.out.println(actData);

		ArrayList<String> expData = ExcelUtility.getColumnData("TestData.xlsx", "aToz", 0);

		if (actData.equals(expData))
			return true;
		else
			return false;	
	}
	public boolean reverseAlphabetically()throws Exception{
		Utility.selectBy(select, "Product Name: Z to A");
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement e : namesOfProduct) {
			String text = e.getText();
			actData.add(text);
		}
		Collections.sort(actData,Collections.reverseOrder());
		System.out.println(actData);

		ArrayList<String> expData = ExcelUtility.getColumnData("TestData.xlsx", "zToa", 0);

		if (actData.equals(expData))
			return true;
		else
			return false;	
	}
}
