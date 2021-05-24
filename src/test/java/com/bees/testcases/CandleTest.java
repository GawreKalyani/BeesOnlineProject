package com.bees.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.bees.base.Testbase;
import com.bees.pages.CandlePage;
import com.bees.pages.HomePg;

public class CandleTest extends Testbase {
HomePg hp=null;
CandlePage cp=null;
	
	@BeforeSuite
	public void setUp() throws Exception{
	driver=initialization("config.properties");	
	hp=new HomePg(driver);
	cp=hp.navigateToCandlePg();
	}
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
	
@Test	
public void candleDropBox()throws Exception{
	Assert.assertTrue(cp.candleScent());
}
@Test
public void candleSize()throws Exception{
	Assert.assertTrue(cp.candleSize());
}
@Test
public void verifyDatasheet()throws Exception{
	Assert.assertTrue(cp.checkDatasheet());
}
}
