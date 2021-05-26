package com.bees.objetRepositary;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoffeeAndTeaObjRepo {
	@FindBy(xpath="//select[@id='selectProductSort']")
	public WebElement select;
	
	@FindBy(xpath="//span[@class='price product-price']")
	public List<WebElement>prices;
	
	@FindBy(xpath="//a[@class='product-name']") //7 actual5
	public List<WebElement>namesOfProduct;
	
	@FindBy(xpath="//h2[@class='page-heading']")
	public WebElement subcategories;
	
}

