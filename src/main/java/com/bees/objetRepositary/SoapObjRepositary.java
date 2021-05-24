package com.bees.objetRepositary;



import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SoapObjRepositary {
@FindBy(xpath="//select[@name='group_2']")
public WebElement soapProduct;

@FindBy(xpath="//td")
public List<WebElement>dataSheet;
}
