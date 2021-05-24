package com.bees.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bees.objetRepositary.CandleObjRepositary;
import com.bees.utility.ExcelUtility;


public class CandlePage extends CandleObjRepositary{
WebDriver driver;

	public CandlePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean candleScent() throws Exception
		{
			ArrayList<String>actData=new ArrayList<String>();
			Select s=new Select(scent);
			List <WebElement> list = s.getOptions();
			for(WebElement ele:list){
				String text=ele.getText();
				actData.add(text);
				System.out.println(text);
			}
		ArrayList<String>expData=ExcelUtility.getColumnData("TestData.xlsx", "candleScent", 0);
		if(actData.equals(expData))
			return true;
		else
			return false;

}
public boolean candleSize() throws Exception{
	ArrayList<String>actData=new ArrayList<String>();
	Select s=new Select(size);
	List <WebElement> list = s.getOptions();
	for(WebElement ele:list){
		String text=ele.getText();
		actData.add(text);
	}
	ArrayList<String>expData=ExcelUtility.getDataOfAnyColumn("TestData.xlsx", "candleSize", 0);
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
	ArrayList<String>expData=ExcelUtility.getExcelTableData("TestData.xlsx", "candleDatasheet");
	if(actData.equals(expData))
		return true;
	else
		return false;
}
}
