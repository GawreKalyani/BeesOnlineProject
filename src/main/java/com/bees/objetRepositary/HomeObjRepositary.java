package com.bees.objetRepositary;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeObjRepositary {
	@FindBy(xpath="//img[@title='BEE']")
	public WebElement thirtybeesimg;
	
	@FindBy(xpath="//a[text()='Read More']")
	public List<WebElement>readMore;
	
	@FindBy(id="search_query_top")
	public WebElement search;
	
	@FindBy(xpath="//button[@name='submit_search']")
	public WebElement searchsymbol;
	
	@FindBy(xpath="//div[@class='alert alert-warning']")
	public WebElement searchNotFoundMsg;
	
	@FindBy(xpath="//a[@title='Coffee and Tea']")
	public WebElement coffeeAndTea;
	
	@FindBy(xpath="//span[contains(text(),'Our')]//following::img[1]")
	public WebElement ourcandle;
	@FindBy(xpath="//span[contains(text(),'Our')]//following::img[2]")
	public WebElement oursoap;
	@FindBy(xpath="//span[contains(text(),'Our')]//following::img[3]")
	public WebElement ourcoffee;
	@FindBy(xpath="//span[contains(text(),'Our')]//following::img[4]")
	public WebElement ourtincup;
	
	@FindBy(xpath="//button[text()='Shop now !']")
	public List<WebElement>shopNow;
	@FindBy(xpath="//h3[text()='Shop Tea']")
	public WebElement sliderShopTea;
	@FindBy(xpath="//h3[text()='Shop Gifts']")
	public WebElement sliderShopgift;
	@FindBy(xpath="//h3[text()='View All Soaps']")
	public WebElement sliderSoapView;
}
