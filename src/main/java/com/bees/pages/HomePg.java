package com.bees.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.bees.objetRepositary.HomeObjRepositary;
import com.bees.utility.Utility;


public class HomePg extends HomeObjRepositary {
WebDriver driver;

	public HomePg(WebDriver driver) //constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public CoffeeAndTeaPage navigateToCoffeeAndTeaPg(){
		Utility.click(coffeeAndTea);
		return new CoffeeAndTeaPage(driver);
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
	
	
	public boolean invalidDatainSearch(){
		String ww="@2hhh$";
		Utility.sendkeys(search,ww );	
		Utility.click(searchsymbol);
		String actual=searchNotFoundMsg.getText();
	
		String expected="No results were found for your search \"@2hhh$\"";
		System.out.println(actual+"   Actual"+"   "+expected); 

		if(actual.equals(expected))
			return true;
		else
			return false;	
	}
}
