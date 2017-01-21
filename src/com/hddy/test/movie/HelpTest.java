package com.hddy.test.movie;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hddy.page.movie.Help;
import com.hddy.page.movie.LoginMovie;
import com.hddy.page.movie.MovieHomepage;
import com.hddy.util.WindowExchangeAssist;
import com.hddy.util.Wait;

public class HelpTest {
	
	private WebDriver driver;
	private Help help;
	  @BeforeTest
	  @Parameters({"web_driver","host_url","user_name","pass_word","movie_title"})
	  public void beforeTest(String web_driver,String host_url,String user_name,String pass_word,String movie_title) {
		  //登陆主站，输入电影名称，创建电影
		  LoginMovie movie=new LoginMovie(driver);
		  movie.loginYoya(web_driver, host_url, user_name, pass_word);
		  driver=movie.creatMovie(movie_title);
		  
	  }
	  

	  @AfterTest
	  public void afterTest() {
		  driver.quit();
	  }	
	
  @Test(alwaysRun=true)
  public void newHandguide() {
	  
	  MovieHomepage movie=new MovieHomepage(driver);
	  //新手指引
	  movie.reference("1");
	  
	  this.help=new Help(driver);
	  //第一步
	  Assert.assertNotNull(this.help.guidestep("1"));
	  this.help.clickNext("1");
	  
	  Assert.assertNotNull(this.help.guidestep("2"));
	  this.help.clickNext("2");
	  
	  Assert.assertNotNull(this.help.guidestep("3"));
	  this.help.clickNext("3");
	  
	  Assert.assertNotNull(this.help.guidestep("4"));
	  this.help.clickNext("4");
	  
	  Assert.assertNotNull(this.help.guidestep("5"));
	  this.help.clickNext("5");
	  
	  Assert.assertNotNull(this.help.guidestep("6"));
	  this.help.clickClose("6");
  }
  /**
   * 帮助中心,建议反馈
   */
  @Test(alwaysRun=true)
  public void helpcenter(){
	  MovieHomepage movie=new MovieHomepage(driver);
	  //帮助中心
	  movie.reference("2");
	  
	  String current_handle=driver.getWindowHandle();
	  
	  WindowExchangeAssist.exchangeDriverUseTitle(driver, "帮助中心-优芽网 www.yoya.com");
	  Assert.assertEquals(driver.getTitle(), "帮助中心-优芽网 www.yoya.com");
	  
	  driver.switchTo().window(current_handle);
	  
	  Wait.waitMilliSeconds(3000);
	  //意见反馈
	  movie.reference("3");
	  
	  WindowExchangeAssist.exchangeDriverUseTitle(driver, "优芽网 帮您更优秀- www.yoya.com");
	  Assert.assertEquals(driver.getTitle(), "优芽网 帮您更优秀- www.yoya.com");
	  
	  driver.switchTo().window(current_handle);
  }
  
  @Test(alwaysRun=true)
  public void checkSetAvaiable(){
	  MovieHomepage movie=new MovieHomepage(driver);
	  this.help=new Help(driver);
	  //导出
	  movie.set("1");
	  this.help.clickCancelExport();
	  
	  //水印设置
	  movie.set("2");
	  this.help.clickCancelWaterMark();
	  
	  //场景大小
	  movie.set("3");
	  this.help.clickCloseSceneSet();
	  
	  //退出
	  movie.set("4");
	  Alert alert=driver.switchTo().alert();
	  alert.accept();
	  
  }
  
  
}
