package com.bees.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.bees.base.Testbase;
import com.bees.pages.HomePg;

public class HomeTest extends Testbase {
	HomePg hp=null;
	
	@BeforeSuite
	public void setUp() throws Exception{
	driver=initialization("config.properties");	
	hp=new HomePg(driver);
	}
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void verifyTitle(){
		Assert.assertEquals(driver.getTitle(), "BEE");
	}
	@Test
	public void searchByValidDataGetTitle(){
		Assert.assertTrue(hp.verifyTitleAfterValidSearch());
	}

	@Test
	public void windowHandleForReadMore()throws Exception{
		Assert.assertTrue(hp.readMoreWindowHandle());
	}

}
