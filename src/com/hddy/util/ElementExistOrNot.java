package com.hddy.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementExistOrNot {
	
	/**
	 * 判断页面上某个元素是否存在
	 * @param driver
	 * @param locator
	 * @return
	 */
	public static boolean elementExist(WebDriver driver,By locator){
		
		try{
			driver.findElement(locator);
			return true;
		}catch(NoSuchElementException  ex){
			return false;
		}		
	}
	
	/**
	 * 查找某个元素下定位方式是否存在某个元素
	 * @param e
	 * @param locator
	 * @return
	 */
	public static boolean elementExist(WebElement e,By locator){
		try{
			e.findElement(locator);
			return true;
		}catch(NoSuchElementException  ex){
			return false;
		}		
	}
	
	
	

}
