package com.bees.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.bees.base.Testbase;
import com.bees.pages.HomePg;
import com.bees.pages.TincupPage;

public class TincupTest extends Testbase {
	HomePg hp=null;
	TincupPage tcp=null;
	
	@BeforeSuite
	public void setUp() throws Exception{
	driver=initialization("config.properties");	
	hp=new HomePg(driver);
	tcp=hp.navigateToTinCupPg();
	}
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void verifyTincupColors(){
		Assert.assertTrue(tcp.checkColorsOfTinCup());
	}
	@Test
	public void verifyDatasheet()throws Exception{
		Assert.assertTrue(tcp.checkDatasheet());
	}
	
}
