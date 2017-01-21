package com.hddy.page.movie;

import org.openqa.selenium.WebDriver;

import com.hddy.util.LocateIframe;

public class InsertResource {
	private WebDriver driver;
	public InsertResource(WebDriver driver){
		this.driver=driver;
		//插入功能，所有的功能都会弹出一个新的页面，所以在这里要做一个iframe定位
		LocateIframe.locateIframe(driver, "layui-layer-iframe");
	}
	
	
	/**
	 * 提示
	 */
	public void remind(){
		
	}
	
	
	/**
	 * 插入视频
	 */
	public void video(){
		
	}
	
}
