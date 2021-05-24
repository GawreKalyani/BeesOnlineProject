package com.bees.objetRepositary;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TincupObjRepositary {
	
	@FindBy(xpath="//a[contains(@id,'color')]")
	public List<WebElement>colors;
	
	@FindBy(xpath="//td")
	public List<WebElement>dataSheet;
}
