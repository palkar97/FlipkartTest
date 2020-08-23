package com.shopping.flipkart.testcases;


import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.shopping.flipkart.base.BaseClass;
import com.shopping.flipkart.pages.Homepage;


public class HomePagetc extends BaseClass

{
String xlFilePath="D:\\Selenium WebDriver\\AMLOCK\\Testdata.xlsx";
String sheetName="Sheet1";

ReadExceldata eat=null;
//WebDriver driver=null;
int LastRow = 1;

@BeforeClass
public void init() throws InterruptedException
{
	launch();
	Homepage hp=new Homepage();
hp.Getsearch().click();
driver.manage().deleteAllCookies();
hp.Getsearchtextbox();
}

@Test(dataProvider = "userData")
public void fillUserForm(String Mobile,String Price, String Ram,String Processor) throws InterruptedException, IOException
{
String p=Price;
System.out.println("Get Mobile" +p);
Thread.sleep(10000);
Homepage hp=new Homepage();
Select s= new Select(hp.Amountfilter());
s.selectByValue(Price);
Thread.sleep(10000);
if(Ram.equals("2GB"));
{
	WebElement xyz=hp.Ramfilter();
	Actions ac1 = new Actions(driver);
	ac1.moveToElement(xyz).perform(); 
	ac1.click().build().perform();
}
Thread.sleep(10000);
if(Processor.equals("Snapdragon"));
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1500)");
    hp.Getprocessorclick().click();
	Thread.sleep(10000);
Actions a = new Actions(driver);
a.moveToElement(hp.Getprocessorfilter()).perform();
a.click().build().perform();
}

Thread.sleep(10000);

File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(src,new File("D:\\Selenium WebDriver\\Flipkartautomation\\Screenshots\\screenshot.png"));
}
@DataProvider(name="userData")
public Object[][] userFormData() throws Exception
{
Object[][] data=testData(xlFilePath,sheetName);
System.out.println("data"+data.toString());
return data;
}
public Object[][] testData(String xlFilePath,String sheetName) throws Exception
{

Object[][] excelData=null;
eat= new ReadExceldata(xlFilePath);
int rows=eat.getRowCount(sheetName);
int columns=eat.getColumnCount(sheetName);
excelData = new Object[rows-1][columns];
for(int i=1;i<rows;i++)
{
for(int j=0;j<columns;j++)
{
excelData[i-1][j]=eat.getCellData(sheetName,j,i);
}
}
return excelData;
}
}


 



