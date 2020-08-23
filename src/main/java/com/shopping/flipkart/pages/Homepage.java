package com.shopping.flipkart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopping.flipkart.base.BaseClass;

public class Homepage extends BaseClass {

	

	public Homepage(){
		PageFactory.initElements(driver, this);}
	
	@FindBy(xpath="/html/body/div[2]/div/div/button")
	WebElement searchtext;
	
	@FindBy(className="LM6RPg")
	WebElement searchtextbox;
	
	@FindBy(className="vh79eN")
	WebElement clickbutton;
	
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[1]/div/div[1]/div/section[2]/div[4]/div[3]/select")
	WebElement amountfilter;
	


	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[2]/div/div[1]/div/div[1]/div/section[4]/div[2]/div/div[3]/div/div/label/div[1]")
	WebElement ramfilter;
	
	
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[2]/div/div[1]/div/div[1]/div/section[16]/div")
	WebElement processorclick;
	

	@FindBy(xpath="//*[@id='container']/div/div[3]/div[2]/div/div[1]/div/div[1]/div/section[16]/div[2]/div/div[3]/div/div/label/div[1]")
	WebElement processorfilter;
	
	
	public WebElement Getsearch()
	   {
		return searchtext;
	   }
		
	public void Getsearchtextbox() throws InterruptedException
	{
		 searchtextbox.sendKeys("samsung");
		 List<WebElement> autoSuggest = driver.findElements(By.className("_3Wn9Gb"));
	        Thread.sleep(3000);
	        for (WebElement a : autoSuggest)
	        {
	        	System.out.println("Values are = " + a.getText());
	        	if (a.getText().equalsIgnoreCase("samsung mobiles"));
	        	a.click();
	        	Thread.sleep(3000);
	        	break;
	        }
	}
	public WebElement clickbutton()
		{
			return clickbutton;
		}
			
	public WebElement Amountfilter() 
		{
			return amountfilter;			
		}
		
	public WebElement Ramfilter()
		{
			return ramfilter;
		}
	public WebElement Getprocessorclick()
		{
			return processorclick;
		}
	public WebElement Getprocessorfilter()
		{
			return processorfilter;
		}
}
