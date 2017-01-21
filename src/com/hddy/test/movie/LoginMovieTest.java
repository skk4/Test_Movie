package com.hddy.test.movie;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hddy.page.login.LoginYoya;
import com.hddy.page.movie.LoginMovie;

public class LoginMovieTest {

  private WebDriver driver;	
	
  @BeforeTest
  @Parameters({"web_driver","host_url","user_name","pass_word","movie_title"})
  public void beforeTest(String web_driver,String host_url,String user_name,String pass_word,String movie_title) {
	  
	  LoginYoya yoya=new LoginYoya();
	  driver=yoya.login(web_driver, host_url, user_name, pass_word);

	  //输入电影名称，创建电影
	  LoginMovie movie=new LoginMovie(driver);
	  driver=movie.creatMovie(movie_title);
	  
  }
  

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  
  @Test(alwaysRun=true)
  public void createMovie(){
	  
  }
  
  

}
