package com.hddy.page.movie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hddy.util.LocateIframe;
import com.hddy.util.Wait;

public class GeneralAction {
	private WebDriver driver;
	public GeneralAction(WebDriver driver){
		this.driver=driver;
	}
	
	public void clickAction(String action_name){
		driver.findElement(By.xpath("//ul[@id='publicAction']/li//div[@class='title' and text()='"+action_name+"']")).click();
		Wait.waitMilliSeconds(5000);
		LocateIframe.locateIframe(driver, "layui-layer-iframe");
		//有些动作有弹出新的iframe对话框，有些没有
		/*if(ElementExistOrNot.elementExist(driver, By.xpath("//iframe[starts-with(@id,'layui-layer-iframe')]"))){
			LocateIframe.locateIframe(driver, "layui-layer-iframe");
		}*/
		
	}
	
	
	/**
	 * 移动-增加时间
	 */
	public void increseMoveTime(){
		WebElement e=driver.findElement(By.id("numberChange"));
		e.findElement(By.xpath("./../i[contains(@class,'icon-increase')]")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	/**
	 * 移动-减少时间
	 */
	public void reduceMoveTime(){
		WebElement e=driver.findElement(By.id("numberChange"));
		e.findElement(By.xpath("./../i[contains(@class,'icon-reduce')]")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	/**
	 * 出现形式
	 */
	public void appearType(String appear_style){
		driver.findElement(By.xpath("//div[@id='appearlist1']/ul/li/a/div[@class='title' and text()='"+appear_style+"']")).click();
		Wait.waitMilliSeconds(3000);

	}
	
	/**
	 * 消失形式
	 */
	public void disappearType(String disappear_style){
		driver.findElement(By.xpath("//div[@id='disappearlist1']/ul/li/a/div[@class='title' and text()='"+disappear_style+"']")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	/**
	 * 强调
	 */
	public void qiangdiaoType(String qd_style){
		driver.findElement(By.xpath("//div[@id='qiangdiao1list']/ul/li/a/div[@class='title' and text()='"+qd_style+"']")).click();
		Wait.waitMilliSeconds(3000);

	}
	
	
	
	/**
	 * 确认
	 */
	public void clickConfirm(){
		driver.findElement(By.xpath("//div[@class='dlg-btns']/button[1]")).click();
		Wait.waitMilliSeconds(3000);
		driver.switchTo().defaultContent();
	}
	
}
