package com.bees.objetRepositary;



import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CandleObjRepositary {
	
@FindBy(xpath="//select[@id='group_5']")
public WebElement scent;

@FindBy(xpath="//select[@id='group_4']")
public WebElement size;

@FindBy(xpath="//td")
public List<WebElement>dataSheet;





}
