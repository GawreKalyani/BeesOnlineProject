package com.bees.pages;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.bees.objetRepositary.HomeObjRepositary;
import com.bees.utility.ExcelUtility;
import com.bees.utility.Utility;


public class HomePg extends HomeObjRepositary {
WebDriver driver;

	public HomePg(WebDriver driver) //constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public CandlePage navigateToCandlePg(){
		Utility.click(ourcandle);
		return new CandlePage(driver);
	}
	public SoapPage navigateToSoapPg(){
		Utility.click(oursoap);
		return new SoapPage(driver);
	}
	public CoffeePage navigateToCoffeePg(){
		Utility.click(ourcoffee);
		return new CoffeePage(driver);
	}
	public TincupPage navigateToTinCupPg(){
		Utility.click(ourtincup);
		return new TincupPage(driver);
	}
	
	public boolean verifyTitleAfterValidSearch(){
	Utility.sendkeys(search, "Candle");	
	Utility.click(searchsymbol);
	String actual=Utility.getTitle(driver);
	String expected="Search - BEE";
	if(actual.equals(expected))
		return true;
	else
		return false;
	}
	
	public boolean readMoreWindowHandle()throws Exception{
		ArrayList<String>actData=new ArrayList<String>();
		ArrayList<String>expData=ExcelUtility.getColumnData("TestData.xlsx", "windowTitle", 0);
		String parent=driver.getWindowHandle();
		for(WebElement e:readMore){
			e.click();
		}
		Set<String> allWindows = driver.getWindowHandles();
		for(String child:allWindows){
			if(!parent.equalsIgnoreCase(child)){
				driver.switchTo().window(child);
				String text=driver.getTitle();
				actData.add(text);
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		if(actData.equals(expData))
			return true;
		else
			return false;
	}
}
