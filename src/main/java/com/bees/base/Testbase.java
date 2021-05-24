package com.bees.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class Testbase {
	public static WebDriver driver;
	Properties prop;
	public static Logger log = Logger.getLogger(Testbase.class);
	public WebDriver initialization(String propertyfileName) throws Exception {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
		//System.getProperty("user.dir") + "/src/main/resources/config.properties");
				System.getProperty("user.dir") + "/src/main/resources/"+propertyfileName);		
		prop.load(fis);
		// String browserName=System.getProperty("browser");
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			log.info("initializing browser");
			log.warn("chromedriver file should be at specific location");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
			
			log.info("chrome browser opened");
			driver = new ChromeDriver();
		} 
		else if (browserName.equals("firefox")) {
			log.info("initializing browser");
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\geckodriver.exe");
			
			log.info("mozilla firefox browser opened");
			driver = new FirefoxDriver();
		} 
		else if (browserName.equals("IE")) {
			log.info("initializing browser");
			System.setProperty("webdriver.ie.driver", "C:\\Program Files\\IEDriverServer.exe");
			
			log.info("Internet explorer browser opened");
			driver = new InternetExplorerDriver();
		}
		
		log.info("JBK Offline application is launched");
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("maximizing browser window");
		driver.manage().window().maximize();
		return driver;
	}
}
