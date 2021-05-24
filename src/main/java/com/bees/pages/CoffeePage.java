package com.bees.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bees.objetRepositary.CoffeeObjRepositary;
import com.bees.utility.ExcelUtility;

public class CoffeePage extends CoffeeObjRepositary {
	WebDriver driver;

	public CoffeePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean coffeeFlavour() throws Exception{
		Select s=new Select(flavour);
		List <WebElement> list = s.getOptions();
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement ele:list){
			String text=ele.getText();
			actData.add(text);
			System.out.println(text);
		}
		ArrayList<String>expData=ExcelUtility.getColumnData("TestData.xlsx", "coffeeFlavour", 0);
	if(actData.equals(expData))
		return true;
	else
		return false;

	}
	public boolean checkDatasheet() throws Exception{
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement ele:dataSheet){
			String text=ele.getText();
			actData.add(text);
			System.out.println(text);
		}
		ArrayList<String>expData=ExcelUtility.getExcelTableData("TestData.xlsx", "coffeeDatasheet");
		if(actData.equals(expData))
			return true;
		else
			return false;
	}
}
