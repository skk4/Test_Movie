package com.hddy.page.movie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hddy.util.Wait;

public class DivPage {
	
	private WebDriver driver;
	
	public DivPage(WebDriver driver){
		this.driver=driver;
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[starts-with(@id,'layui-layer') and @type='page']")));

	}
	
	public WebElement getPage(){
		return driver.findElement(By.xpath("//div[starts-with(@id,'layui-layer') and @type='page']"));
	}
	
	public String getContent(){
		WebElement e=this.getPage();
		return e.findElement(By.xpath("./div[@class='layui-layer-content']//div[@class='text']")).getText();
	}
	
	public void clickConfirm(){
		WebElement e=this.getPage();
		e.findElement(By.xpath("./div[@class='layui-layer-content']//button")).click();
		Wait.waitMilliSeconds(3000);
	}
	
}
