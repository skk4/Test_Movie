package com.hddy.page.movie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.hddy.page.login.LoginYoya;
import com.hddy.util.Wait;

public class LoginMovie {
	
	private WebDriver driver;
	
	public LoginMovie(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void loginYoya(String web_driver,String host_url,String user_name,String pass_word){
		LoginYoya yoya=new LoginYoya();
		driver=yoya.login(web_driver, host_url, user_name, pass_word);
	}
	

	public WebDriver creatMovie(String movie_title){
		driver.findElement(By.id("movieName")).sendKeys(movie_title);
		
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//button[@id='newMovie']/span[@class='file-front']"))).perform();
		Wait.waitMilliSeconds(2000);
		driver.findElement(By.xpath("//button[@id='newMovie']/span[@class='file-back']")).click();
		Wait.waitMilliSeconds(5000);
		driver.switchTo().defaultContent();
		return driver;
	}
}
