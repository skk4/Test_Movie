package com.hddy.test.movie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hddy.page.movie.DivPage;
import com.hddy.page.movie.GeneralAction;
import com.hddy.page.movie.LoginMovie;
import com.hddy.page.movie.MovieHomepage;
import com.hddy.page.movie.Role;
import com.hddy.page.movie.RoleAction;
import com.hddy.util.Wait;

public class RoleTest {
	private WebDriver driver;
	private Role role;
	
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
  @Parameters({"caption_content"})
  public void assertSpiritAvaible(String caption_content) {
	  MovieHomepage home=new MovieHomepage(driver);
	  home.enterTopNav("角色");
	  
	  this.role=new Role(driver);
	  this.role.dragVoiceOver();
	  
	  WebElement spirit=this.role.findRoleInScene();
	  spirit.click();
	  
	  RoleAction action=new RoleAction(driver);
	  action.clickAction("说话");
	  
	  action.inputCaptionContent(caption_content);
	  action.clickConfirm();
	  
	  //断言动作列表中脚本存在
	  Assert.assertEquals(home.getActionList("1"), "【说话】温馨白 说："+caption_content);
	  
	  
	  driver.switchTo().defaultContent();
	  action.clickAction("走路");
	  
	  DivPage page=new DivPage(driver);
	  Assert.assertEquals(page.getContent(), "您好，小精灵只能说话和执行通用动作哦。");
	  page.clickConfirm();
  }
  
  /**
   * 角色说话功能
   */
  @Test(alwaysRun=true)
  @Parameters({"caption_content"})
  public void assertRoleSaying(String caption_content){
	  MovieHomepage home=new MovieHomepage(driver);
	  home.enterTopNav("角色");
	  
	  this.role=new Role(driver);
	  this.role.dragRole("信多多");
	  
	  //场景中选择这个角色
	  WebElement e=this.role.findRoleInScene();
	  e.click();
	  //设置角色动作
	  RoleAction action=new RoleAction(driver);
	  action.clickAction("说话");
	  
	  action.inputCaptionContent(caption_content);
	  action.chooseAccompanyAction("写字");
	  
	  action.clickConfirm();
	  Assert.assertEquals(home.getActionList("1"), "【说话】信多多 说："+caption_content);

  }
  
  /**
   * 角色走路功能
   */
  @Test(alwaysRun=true)
  @Parameters({"caption_content"})
  public void assertRoleWalking(String caption_content){
	  MovieHomepage home=new MovieHomepage(driver);
	  home.enterTopNav("角色");
	  
	  this.role=new Role(driver);
	  this.role.dragRole("信多多");
	  
	  //场景中选择这个角色
	  WebElement e=this.role.findRoleInScene();
	  e.click();
	  //设置角色动作
	  RoleAction action=new RoleAction(driver);
	  action.clickAction("走路");
	  
	  action.chooseDirectionOfStanding("northeast");
	  //开启边走边说
	  action.setSayingWithWalk();
	  //输入配音内容
	  action.inputCaptionContent(caption_content);
	  action.clickConfirm();
	  Assert.assertEquals(home.getActionList("1"), "【走路说】信多多  "+caption_content);

  }
  
  /**
   *  转身功能
   */
  @Test(alwaysRun=true)
  public void assertRoleTurn(){
	  MovieHomepage home=new MovieHomepage(driver);
	  home.enterTopNav("角色");
	  
	  this.role=new Role(driver);
	  this.role.dragRole("信多多");
	  
	  //场景中选择这个角色
	  WebElement e=this.role.findRoleInScene();
	  e.click();
	  Wait.waitSeconds(5);
	  //设置角色动作
	  RoleAction action=new RoleAction(driver);
	  action.clickAction("转身");
	  
	  action.chooseDirectionOfTurning("north");
	  
	  action.clickConfirm();
	  
	  Assert.assertEquals(home.getActionList("1"), "【转身】信多多");
  }
  
  /**
   * 坐下和站起
   */
  @Test(alwaysRun=true)
  public void assertRoleSitAndStand(){
	  MovieHomepage home=new MovieHomepage(driver);
	  home.enterTopNav("角色");
	  
	  this.role=new Role(driver);
	  this.role.dragRole("信多多");
	  
	  //场景中选择这个角色
	  WebElement e=this.role.findRoleInScene();
	  e.click();
	  Wait.waitSeconds(5);
	  //设置角色动作
	  RoleAction action=new RoleAction(driver);
	  action.clickAction("坐下");
	  action.chooseDirectionOfTurning("north");
	  
	  action.clickConfirm();
	  
	  Assert.assertEquals(home.getActionList("1"), "【坐下】信多多");
	  
	  //站起
	  e=this.role.findRoleInScene();
	  e.click();
	  Wait.waitSeconds(5);
	  action.clickAction("站起");
	  action.chooseDirectionOfTurning("south");
	  action.clickConfirm();
	  Assert.assertEquals(home.getActionList("2"), "【站起】信多多");
	  
	  
  }
  
  
  /**
   * 角色姿势
   */
  @Test(alwaysRun=true)
  @Parameters({"posture_name"})
  public void assertRolePosture(String posture_name){
	  MovieHomepage home=new MovieHomepage(driver);
	  home.enterTopNav("角色");
	  
	  this.role=new Role(driver);
	  this.role.dragRole("信多多");
	  
	  //场景中选择这个角色
	  WebElement e=this.role.findRoleInScene();
	  e.click();
	  Wait.waitSeconds(5);
	  //设置角色动作
	  RoleAction action=new RoleAction(driver);
	  action.clickAction("姿势");
	  
	  action.setRolePosture(posture_name);
	  action.clickConfirm();
	  Assert.assertEquals(home.getActionList("1"), "【姿势 】"+posture_name+" - 信多多");
	  
  }
  /**
   * 表情动作
   */
  @Test(alwaysRun=true)
  @Parameters({"face_icon","face_name"})
  public void assertRoleFaceIcon(String face_icon,String face_name){
	  MovieHomepage home=new MovieHomepage(driver);
	  home.enterTopNav("动作");
	  
	  //设置表情
	  RoleAction action=new RoleAction(driver);
	  action.clickAction("表情");
	  action.chooseFaceIcon(face_icon);
	  Assert.assertEquals(home.getActionList("1"), "【表情】"+face_name+"    (展示3秒)");
  }
  
  /**
   * 角色的通用动作
   */
  @Test(alwaysRun=true)
  public void move(){
	  MovieHomepage home=new MovieHomepage(driver);
	  home.enterTopNav("角色");
	  
	  this.role=new Role(driver);
	  this.role.dragRole("信多多");
	  
	  //场景中选择这个角色
	  WebElement e=this.role.findRoleInScene();
	  e.click();
	  Wait.waitSeconds(5);
	  GeneralAction action=new GeneralAction(driver);
	  action.clickAction("移动");  
	  action.clickConfirm();
	  Assert.assertEquals(home.getActionList("1"), "【通用动作】移动-匀速");  
  }
  
  
  /**
   * 出现
   */
  @Test(alwaysRun=true)
  public void appear(){
	  MovieHomepage home=new MovieHomepage(driver);
	  home.enterTopNav("角色");
	  
	  this.role=new Role(driver);
	  this.role.dragRole("信多多");
	  
	  //场景中选择这个角色
	  WebElement e=this.role.findRoleInScene();
	  e.click();
	  Wait.waitSeconds(5);
	  GeneralAction action=new GeneralAction(driver);
	  action.clickAction("出现"); 
	  
	  action.appearType("浮入");
	  
	  action.clickConfirm();
	  
	  Assert.assertEquals(home.getActionList("1"), "【通用动作】出现-浮入");  
  }
  
  /**
   * 消失
   */
  @Test(alwaysRun=true)
  public void disappear(){
	  MovieHomepage home=new MovieHomepage(driver);
	  home.enterTopNav("角色");
	  
	  this.role=new Role(driver);
	  this.role.dragRole("信多多");
	  
	  //场景中选择这个角色
	  WebElement e=this.role.findRoleInScene();
	  e.click();
	  Wait.waitSeconds(5);
	  GeneralAction action=new GeneralAction(driver);
	  action.clickAction("消失"); 
	  
	  action.disappearType("擦除");
	  
	  action.clickConfirm();
	  
	  Assert.assertEquals(home.getActionList("1"), "【通用动作】消失-擦除");  
  }
  
  
  /**
   * 强调
   */
  @Test(alwaysRun=true)
  public void qiangdiao(){
	  MovieHomepage home=new MovieHomepage(driver);
	  home.enterTopNav("角色");
	  
	  this.role=new Role(driver);
	  this.role.dragRole("信多多");
	  
	  //场景中选择这个角色
	  WebElement e=this.role.findRoleInScene();
	  e.click();
	  Wait.waitSeconds(5);
	  GeneralAction action=new GeneralAction(driver);
	  action.clickAction("强调"); 
	  
	  action.qiangdiaoType("拉动");
	  
	  action.clickConfirm();
	  
	  Assert.assertEquals(home.getActionList("1"), "【通用动作】强调-拉动");  
  }
  
  
}
