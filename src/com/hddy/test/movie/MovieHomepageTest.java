package com.hddy.test.movie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hddy.page.movie.DivPage;
import com.hddy.page.movie.LoginMovie;
import com.hddy.page.movie.MovieHomepage;
import com.hddy.page.movie.Scenario;

public class MovieHomepageTest {
	private WebDriver driver;
	private MovieHomepage homepage;
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
  @Parameters({"scene_name"})
  public void saveMovie(String scene_name) {
	  Scenario scene=new Scenario(driver);
	  this.homepage=new MovieHomepage(driver);
	  scene.chooseScenario(scene_name);
	  
	  Assert.assertTrue(scene.getCurrentSceneExist());
	  
	  this.homepage.clickSaveBtn();
	  
	  DivPage page=new DivPage(driver);
	  Assert.assertEquals(page.getContent(), "嘿嘿~影片保存成功：）");
	  page.clickConfirm();
	  
	  this.homepage.clickMoviePlayBtn();
	  
	  this.homepage.closePlayMovie();
  }
  /**
   * 10 pixel 对应 8%
   */
  @Test(alwaysRun=true)
  public void sceneSizePercent(){
	  this.homepage=new MovieHomepage(driver);
	  
	  Assert.assertEquals(this.homepage.getSizePercent(), "100%");
	  
	  this.homepage.enlarge();
	  Assert.assertEquals(this.homepage.getSizePercent(), "105%");
	  
	  this.homepage.reduce();
	  Assert.assertEquals(this.homepage.getSizePercent(), "100%");
	  
	  
	  WebElement bar=this.homepage.getSlipBar();
	  Actions a=new Actions(driver);
	  //从中间100%拉到最顶部
	  a.dragAndDropBy(bar, 0, -50).perform();
	  Assert.assertEquals(this.homepage.getSizePercent(), "60%");
	  //从百分之40拉动最底部
	  a.dragAndDropBy(bar, 0, 100).perform();
	  Assert.assertEquals(this.homepage.getSizePercent(), "140%");
  }
  
  
  
  
}
