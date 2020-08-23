package com.shopping.flipkart.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;

	public BaseClass(){
		try {
		
			prop=new Properties();
			FileInputStream fis= new FileInputStream("D:\\Selenium WebDriver\\Flipkartautomation\\src\\main\\java\\com\\shopping\\flipkart\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

public static void launch(){
	String browsername=	prop.getProperty("browser");
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
		
}

}
	
		
	
	
