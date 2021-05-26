package com.bees.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.bees.base.Testbase;

import com.bees.pages.CoffeeAndTeaPage;
import com.bees.pages.HomePg;

public class CoffeeAndTeaTest extends Testbase {
	HomePg hp=null;
	CoffeeAndTeaPage cat=null;
		
		@BeforeSuite
		public void setUp() throws Exception{
		driver=initialization("config.properties");	
		hp=new HomePg(driver);
		cat=hp.navigateToCoffeeAndTeaPg();
		}
		
		@AfterSuite
		public void tearDown(){
			driver.quit();
		}
		@Test	
		public void priceSortDropDownList()throws Exception{
			Assert.assertTrue(cat.productSortDropDown());
		}
		@Test
		public void sortingByPrice()throws Exception{
			Assert.assertTrue(cat.sortProductPrices());
		}
		@Test
		public void descSortProductPrices()throws Exception{
			Assert.assertTrue(cat.sortProductPricesInDescOrder());
		}
		@Test
		public void aToZsorting()throws Exception{
			Assert.assertTrue(cat.sortingAlphabetically());
		}
		@Test
		public void zToAFiltering()throws Exception{
			Assert.assertTrue(cat.reverseAlphabetically());
		}
}
