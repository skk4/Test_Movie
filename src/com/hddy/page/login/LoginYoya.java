package com.hddy.page.login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.hddy.util.WindowExchangeAssist;
import com.hddy.util.LocateIframe;
import com.hddy.util.Wait;
import com.hddy.util.WebDriverGenerator;

public class LoginYoya {
	
	private WebDriver driver;//登录页面
	private WebElement input_username; //用户名输入框
	private WebElement input_password; //密码输入框
	private WebElement login_button;   //登录按钮
	
	
	public LoginYoya(){
		
	}
	
/*	public LoginYoya(WebDriver driver){
		this.driver=driver;	
	}*/
	
	public void launchSite(String host_url){
		driver.get(host_url);
		driver.manage().window().maximize();
	}
	
	public void inputUsername(String user_name){
		//Wait.implicitlyWait(driver, 10);
		this.input_username=getInput_username();
		this.input_username.clear();
		this.input_username.sendKeys(user_name);
	}
	
	public void inputPassword(String pass_word){
		this.input_password=getInput_password();
		this.input_password.clear();
		this.input_password.sendKeys(pass_word);
	}
	public void clickLoginButton(){
		this.login_button=Wait.explicitlyWait(driver, 10, this.locateElementByid("_pop_user_login"));
		this.login_button.click();
		//等待登陆成功
		Wait.waitMilliSeconds(10000);
	}
	
	public void clickLoginPrompt(){
		WebElement yoya_login=Wait.explicitlyWait(driver, 10, this.locateElementByid("_yoya_login"));
		yoya_login.click();
		//等待登陆框
		Wait.waitMilliSeconds(5000);
	}		
	public void logout(){
		WebElement topheadimg=Wait.explicitlyWait(driver, 10, By.id("top_head_img"));
		Actions action=new Actions(driver);
		action.moveToElement(topheadimg).perform();
		//等待出现下拉菜单
		Wait.waitMilliSeconds(2000);
		driver.findElement(this.locateElementByid("top_ssoLogoutId")).click();
		//等待退出
		Wait.waitMilliSeconds(5000);
	}
	public By locateElementByid(String id){
		return By.id(id);
	}

	public WebElement getInput_username() {
		return driver.findElement(this.locateElementByid("_pop_user_name"));
	}

	public void setInput_username(WebElement input_username) {
		this.input_username = input_username;
	}

	public WebElement getInput_password() {
		return Wait.explicitlyWait(driver, 10, this.locateElementByid("_pop_password"));
	}

	public void setInput_password(WebElement input_password) {
		this.input_password = input_password;
	}
	
	/**
	 * 登陆主站
	 * @param web_driver
	 * @param host_url
	 * @param user_name
	 * @param pass_word
	 * @return
	 */
	public   WebDriver login(String web_driver,String host_url,String user_name,String pass_word ){
		driver=WebDriverGenerator.generateWebDriver(web_driver);
		this.launchSite(host_url);
		this.clickLoginPrompt();
		this.inputUsername(user_name);
		this.inputPassword(pass_word);
		this.clickLoginButton();
		
		//新建电影按钮
		driver.findElement(By.cssSelector("i.icon.icon-newly-built")).click();
		//刚进入制作页面有点慢，等待时间久一点
		Wait.waitMilliSeconds(5000);
		driver = WindowExchangeAssist.exchangeDriverUseTitle(driver, "制作互动电影");
		driver=LocateIframe.locateIframeTwo(driver, "layui-layer-iframe","doView");
		
		Wait.waitMilliSeconds(5000);

		return driver;
	}
	

	
	
	
	

	
}
