package com.bees.objetRepositary;



import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoffeeObjRepositary {
@FindBy(xpath="//select[@id='group_1']")
public WebElement flavour;

@FindBy(xpath="//td")
public List<WebElement>dataSheet;
}
