package com.hddy.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OperateElementWithJS {
	

	/**
	 * 可以实现不可见元素变成可见
	 * @param driver
	 * @param locator
	 */
	public static void modifyStyleBlock(WebDriver driver,By locator){
		JavascriptExecutor  executor = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(locator);
		executor.executeScript("arguments[0].style=arguments[1]",element,"display: block;");
	}
	
	
	/**
	 * 移除某个元素的属性
	 * @param driver
	 * @param locator
	 * @param attr_name
	 */
	public static void removeAttribute(WebDriver driver,By locator,String attr_name){
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		WebElement e=driver.findElement(locator);
		executor.executeScript("arguments[0].removeAttribute('"+attr_name+"')", e);
	}
}
