package com.bees.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.bees.base.Testbase;
import com.bees.pages.CoffeePage;
import com.bees.pages.HomePg;


public class CoffeeTest extends Testbase {
	HomePg hp=null;
	CoffeePage cop=null;
		
		@BeforeSuite
		public void setUp() throws Exception{
		driver=initialization("config.properties");	
		hp=new HomePg(driver);
		cop=hp.navigateToCoffeePg();
		}
		
		@AfterSuite
		public void tearDown(){
			driver.quit();
		}
		
	@Test	
	public void coffeeDropBox()throws Exception{
		Assert.assertTrue(cop.coffeeFlavour());
	}
	@Test
	public void verifyDatasheet()throws Exception{
		Assert.assertTrue(cop.checkDatasheet());
	}
}
