package com.hddy.page.movie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hddy.util.LocateIframe;
import com.hddy.util.Wait;

public class Help {
	private WebDriver driver;
	public Help(WebDriver driver){
		this.driver=driver;
	}
	
	
	public WebElement guidestep(String index){
		Wait.waitMilliSeconds(5000);
		return driver.findElement(By.xpath("//li[@id='guidestep"+index+"']//img"));
	}
	
	public void clickNext(String index){
		WebElement e=this.guidestep(index);
		e.findElement(By.xpath("./../a[@class='next']")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	
	public void clickClose(String index){
		WebElement e=this.guidestep(index);
		e.findElement(By.xpath("./../a[@class='close']")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	
	/**
	 * 取消导出
	 */
	public void clickCancelExport(){
		LocateIframe.locateIframe(driver, "layui-layer-iframe");
		driver.findElement(By.id("cle")).click();
		Wait.waitMilliSeconds(3000);
		driver.switchTo().defaultContent();
	}
	public void clickCancelWaterMark(){
		LocateIframe.locateIframe(driver, "layui-layer-iframe");
		driver.findElement(By.xpath("//div[@class='dlg-btns']/button[2]")).click();
		Wait.waitMilliSeconds(3000);
		driver.switchTo().defaultContent();
	}
	
	public void clickCloseSceneSet(){
		
		driver.findElement(By.xpath("//a[contains(@class,'layui-layer-close')]")).click();
		Wait.waitMilliSeconds(3000);
		
	}
	
	
	
	
}
