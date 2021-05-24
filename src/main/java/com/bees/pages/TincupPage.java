package com.bees.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.bees.objetRepositary.TincupObjRepositary;
import com.bees.utility.ExcelUtility;

public class TincupPage extends TincupObjRepositary{
WebDriver driver;

public TincupPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public boolean checkColorsOfTinCup(){
	
	ArrayList<String>expData=new ArrayList<String>();
	expData.add("rgba(250, 214, 41, 1)");
	expData.add("rgba(0, 0, 0, 1)");
	
	ArrayList<String>actData=new ArrayList<String>();
	for(WebElement ele:colors)
	{
		String text=ele.getCssValue("background-color");
		System.out.println(text);
		actData.add(text);
	}
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
	ArrayList<String>expData=ExcelUtility.getExcelTableData("TestData.xlsx", "tincupDatasheet");
	if(actData.equals(expData))
		return true;
	else
		return false;
}


}
