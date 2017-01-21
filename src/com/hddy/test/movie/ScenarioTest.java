package com.hddy.test.movie;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hddy.page.movie.DialogPage;
import com.hddy.page.movie.DivPage;
import com.hddy.page.movie.LoginMovie;
import com.hddy.page.movie.Scenario;
import com.hddy.util.WindowExchangeAssist;

public class ScenarioTest {
	private WebDriver driver;
	private Scenario scenario;
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
  @Parameters({"sc_style","sc_type","scene_name","movie_name","user_name"})
  public void createScenario(String sc_style,String sc_type,String scene_name,String movie_name,String user_name) {
	  this.scenario=new Scenario(driver);

	  this.scenario.chooseScStyle(sc_style);
	  this.scenario.chooseScType(sc_type);
	  
	  this.scenario.chooseScenario(scene_name);
	  
	  Assert.assertTrue(this.scenario.getCurrentSceneExist());
	  
	  this.scenario.clickAddTopScene();
	  
	  Assert.assertEquals(this.scenario.getTopSceneMovieName(), movie_name);
	  Assert.assertEquals(this.scenario.getTopSceneSubTitle(), "——副标题");
	  Assert.assertEquals(this.scenario.getTopSceneAuthor(), user_name);
	  
	  
	  this.scenario.clickAddEndScene();
	  Assert.assertEquals(this.scenario.getTopSceneMovieName(),"THANK  YOU");
	  Assert.assertEquals(this.scenario.getTopSceneSubTitle(), "鸣谢：");
	  
	  
  }
  
  @Test(alwaysRun=true)
  @Parameters({"scene_name","scene_pic"})
  public void selfDefScenario(String scene_name,String scene_pic){
	  this.scenario=new Scenario(driver);
	  this.scenario.clickSelfDefBtn();
	  Assert.assertTrue(this.scenario.getCustomBtns());
	  
	  this.scenario.clickAddCustomerScene();
	  
	  this.scenario.inputSceneName(scene_name);
	  this.scenario.uploadScenePic(scene_pic);
	  
	  this.scenario.clickUploadFile();
	  
	  DialogPage dialog=new DialogPage(driver);
	  Assert.assertEquals(dialog.getTip(), "操作成功");
	  dialog.confirm();
	  
	  
	  driver.switchTo().defaultContent();
	  
	  Assert.assertTrue(this.scenario.getCurrentSceneExist());
	  
	  
	  this.scenario.clickManageScene();
	  WindowExchangeAssist.exchangeDriverUseTitle(driver, "优芽我的云盘");
	  Assert.assertEquals(driver.getTitle(), "优芽我的云盘");
	  
	  driver.switchTo().defaultContent();
  }
  
  @Test(alwaysRun=true)
  @Parameters({"search_word"})
  public void searchScene(String search_word){
	  this.scenario=new Scenario(driver);
	  
	  this.scenario.clickSearchBtn();
	  this.scenario.inputSearchKeys(search_word);
	  this.scenario.chooseFirstScene();
	  this.scenario.clickConfirm();
	  driver.switchTo().defaultContent();
	  
	  Assert.assertTrue(this.scenario.getCurrentSceneExist());
	  
  }
  
  @Test(alwaysRun=true)
  public void newScenario(){
	  this.scenario=new Scenario(driver);
	  
	  //新建场景
	  this.scenario.operateFromScene("1", "1");
	  
	  Assert.assertTrue(this.scenario.leftSceneExist("2"));
	  
	  
  }
  
  @Test(alwaysRun=true)
  public void copyScenario(){
	  this.scenario=new Scenario(driver);
	  
	  this.scenario.chooseScenario("宽屏缩略图");
	  
	  Assert.assertTrue(this.scenario.getCurrentSceneExist());
	  
	  //复制场景
	  this.scenario.operateFromScene("1", "2");
	  
	  Assert.assertTrue(this.scenario.leftSceneExist("2"));
	  
	  this.scenario.clickLeftScene("2");
	  
	  Assert.assertTrue(this.scenario.getCurrentSceneExist());
	  
	  
  }
  
  @Test(alwaysRun=true)
  public void deleteScenario(){
	  this.scenario=new Scenario(driver);
	  
	  //删除场景
	  this.scenario.operateFromScene("1", "3");
	  
	  Assert.assertFalse(this.scenario.leftSceneExist("1"));
	  
	  
  }

  @Test(alwaysRun=true)
  @Parameters({"scene_name","scene_pic"})
  public void setScenarioBackgroud(String scene_name,String scene_pic){
	  this.scenario=new Scenario(driver);
	  this.scenario.operateFromScene("1", "4");
	  
	  this.scenario.inputSceneName(scene_name);
	  this.scenario.uploadScenePic(scene_pic);
	  this.scenario.clickUploadFile();
	  
	  
	  DialogPage dialog=new DialogPage(driver);
	  Assert.assertEquals(dialog.getTip(), "操作成功");
	  dialog.confirm();
	  
	  
	  driver.switchTo().defaultContent();
	  
	  Assert.assertTrue(this.scenario.getCurrentSceneExist());
  }
  
  
  /**
   * 普通用户只能创建5个场景
   */
  @Test(alwaysRun=true)
  public void triggerScenariosLimit(){
	  this.scenario=new Scenario(driver);
	  
	  //默认已经有一个场景
	  for(int i=1;i<=5;i++){
		  Assert.assertTrue(this.scenario.leftSceneExist(String.valueOf(i)));
		  this.scenario.clickNewScenario();
	  }
	  
	  DivPage page=new DivPage(driver);
	  Assert.assertEquals(page.getContent(), "权限不足，只能为您添加5个场景");
	  page.clickConfirm();
	  
  }
  
  

  
}
