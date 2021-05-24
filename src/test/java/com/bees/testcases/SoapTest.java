package com.bees.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.bees.base.Testbase;

import com.bees.pages.HomePg;
import com.bees.pages.SoapPage;

public class SoapTest extends Testbase{
	HomePg hp=null;
	SoapPage sp=null;
		
		@BeforeSuite
		public void setUp() throws Exception{
		driver=initialization("config.properties");	
		hp=new HomePg(driver);
		sp=hp.navigateToSoapPg();
		}
		
		@AfterSuite
		public void tearDown(){
			driver.quit();
		}
		
	@Test	
	public void soapDropBox()throws Exception{
		Assert.assertTrue(sp.soapPro());
	}
	@Test
	public void verifyDatasheet()throws Exception{
		Assert.assertTrue(sp.checkDatasheet());
	}
	
}
