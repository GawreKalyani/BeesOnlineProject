package com.bees.testcases;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.bees.base.Testbase;
import com.bees.pages.HomePg;


public class Prac extends Testbase {
HomePg hp=null;
	
	@BeforeSuite
	public void setUp() throws Exception{
	driver=initialization("config.properties");	
	}
	
	/*@AfterSuite
	public void tearDown(){
		driver.quit();
	}*/
	@Test
	public void test(){
		Assert.assertEquals(driver.getTitle(), "BEE");
	}
	@Test
	public void ttt(){
		ArrayList<String>actData=new ArrayList<String>();
		ArrayList<String>expData=new ArrayList<String>();
		expData.add("rgba(250, 214, 41, 1)");
		expData.add("rgba(0, 0, 0, 1)");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://javabykiran.in/Other/thbees/coffee-and-tea/tea/tin-cup");
		
		List<WebElement>c=driver.findElements(By.xpath("//a[contains(@id,'color')]"));
		for(WebElement ele:c){
			String text=ele.getCssValue("background-color");
			System.out.println(text);
			actData.add(text);
		}
	Assert.assertEquals(actData,expData);	
	}
	@Test
	public void sssReadMore(){
		ArrayList<String>actData=new ArrayList<String>();
		ArrayList<String>expData=new ArrayList<String>();
		expData.add("Organic Gifts - BEE");
		expData.add("Hand Picked Teas - BEE");
		expData.add("Organic Roasted Coffee - BEE");

		String parent= driver.getWindowHandle();
	/*	JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement element=driver.findElement(By.xpath("//a[contains(text(),'Organic Roasted ')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);*/
		
		List<WebElement>c=driver.findElements(By.xpath("//a[contains(text(),'Read')]"));	
		for(WebElement e:c){
			e.click();
		
		}

		Set<String> allWindows = driver.getWindowHandles();

		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				actData.add(driver.getTitle());
				System.out.println(driver.getTitle());
				//driver.close();
			}
		}
		driver.switchTo().window(parent);
		Assert.assertEquals(actData, expData);
	}
	
	
	@Test(enabled=true)
	public void validDtaInSearch(){
		WebElement search=driver.findElement(By.id("search_query_top"));
		search.sendKeys("candle");
		driver.findElement(By.xpath("//button[@name='submit_search']")).click();
		String actual=driver.getTitle();
	
		Assert.assertEquals(actual, "Search - BEE");
	}
	
		@Test
		public void getData() throws Exception{
			String value=null;
			String path=System.getProperty("user.dir")+"/src/test/resources/Template.xlsx";
			FileInputStream fis=new FileInputStream(path);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet("candleSize");
			int row=sh.getPhysicalNumberOfRows();
			for (int i = 0; i < row; i++) 
			{
				int col=sh.getRow(i).getLastCellNum();
				for (int j = 0; j <col; j++) 
				{
					Cell cell=sh.getRow(i).getCell(j);
					DataFormatter df=new DataFormatter();
					value=df.formatCellValue(cell);
					System.out.print("        "+value);
				}
				System.out.println();
			}
		
		}
		@Test
		public void oneReadMoreOfHomePgCheckingTitle()throws Exception{
			String parent = driver.getWindowHandle();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			
			WebElement element=driver.findElement(By.xpath("//a[contains(text(),'Organic Roasted ')]"));
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[text()='Read More']")).click();
			String expected="Organic Gifts - BEE";
			String actWindowTitle = null;
			Set<String> allWindows = driver.getWindowHandles();

			for (String child : allWindows) {
				if (!parent.equalsIgnoreCase(child)) {
					driver.switchTo().window(child);
					actWindowTitle = driver.getTitle();
					//driver.close();
				}
			}
			Assert.assertEquals(actWindowTitle, expected);
			driver.switchTo().window(parent);
		
		}
		@Test
		public void URLoneReadMoreOfHomePg()throws Exception{
			String expected="http://javabykiran.in/Other/thbees/blog/organic-gifts";
			
			String parent = driver.getWindowHandle();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			
			WebElement element=driver.findElement(By.xpath("//a[contains(text(),'Organic Roasted ')]"));
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[text()='Read More']")).click();
			
			String actWindowTitle = null;
			Set<String> allWindows = driver.getWindowHandles();

			for (String child : allWindows) {
				if (!parent.equalsIgnoreCase(child)) {
					driver.switchTo().window(child);
					actWindowTitle = driver.getCurrentUrl();
					//driver.close();
				}
			}
			Assert.assertEquals(actWindowTitle, expected);
			driver.switchTo().window(parent);
		
		}
	}
	

