package com.hddy.page.movie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.hddy.util.LocateIframe;
import com.hddy.util.Wait;

public class Role {
	private WebDriver driver;
	
	public Role(WebDriver driver){
		this.driver=driver;
	}
	
	public void clickVoiceOver(){
		driver.findElement(By.xpath("//li[@id='elfin11']/a")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	public void dragVoiceOver(){
		WebElement source=driver.findElement(By.xpath("//li[@id='elfin11']/a"));
		WebElement target=driver.findElement(By.id("movie_center"));
		Actions a=new Actions(driver);
		a.dragAndDrop(source, target).perform();
		Wait.waitMilliSeconds(3000);
	}
	
	public void dragRole(String role_name){
		WebElement source=driver.findElement(By.xpath("//div[contains(@class,'role_list')]/ul/li[@name='"+role_name+"']/a"));
		WebElement target=driver.findElement(By.id("movie_center"));
		Actions a=new Actions(driver);
		a.dragAndDrop(source, target).perform();
		Wait.waitMilliSeconds(3000);
	}
	
	public void clickRole(String role_name){
		driver.findElement(By.xpath("//div[contains(@class,'role_list')]/ul/li[@name='"+role_name+"']/a")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	public WebElement findRoleInScene(){
		Wait.waitMilliSeconds(3000);
		return driver.findElement(By.xpath("//div[@id='movie_center']/div/div/canvas"));
	}
	
	
	
	/**
	 * 新增角色
	 */
	public void clickAddRoleBtn(){
		driver.findElement(By.xpath("//li[@id='role_add']/a")).click();
		Wait.waitSeconds(3);
		LocateIframe.locateIframe(driver, "layui-layer-iframe");
	}
	
	/**
	 * 选择角色
	 */
	public void chooseRole(String role_type,String role_name){
		WebElement e=driver.findElement(By.id("role_typeList_src"));
		e.findElement(By.xpath("./li/a[text()='"+role_type+"']")).click();
		Wait.waitSeconds(5);
		
		WebElement we=driver.findElement(By.id("role_assList_src"));
		we.findElement(By.xpath("./li[@data-role_name='"+role_name+"']")).click();
		Wait.waitSeconds(5);
	}
	
	/**
	 * 输入角色的岗位名称
	 */
	public void inputRolePositionName(String position_name){
		WebElement e=driver.findElement(By.id("work_name"));
		e.clear();
		e.sendKeys(position_name);
		Wait.waitSeconds(5);
	}
	
	public void clickConfirm(){
		driver.findElement(By.id("sureBtn")).click();
		Wait.waitSeconds(5);
	}
	

	
	
}
