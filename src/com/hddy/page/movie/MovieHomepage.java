package com.hddy.page.movie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.hddy.util.LocateIframe;
import com.hddy.util.Wait;

public class MovieHomepage {
	private WebDriver driver;
	
	public MovieHomepage(WebDriver driver){
		this.driver=driver;
	}
	
	/**
	 * 互动电影页面顶部菜单项
	 */
	public void enterTopNav(String nav_name){
		driver.findElement(By.xpath("//div[@class='nav-items']/ul/li/a/span[text()='"+nav_name+"']")).click();
		Wait.waitMilliSeconds(5000);
	}
	
	/**
	 * 保存影片
	 */
	public void clickSaveBtn(){
		driver.findElement(By.id("moviesave")).click();
		Wait.waitMilliSeconds(5000);
	}
	
	/**
	 * 播放影片
	 */
	public void clickMoviePlayBtn(){
		driver.findElement(By.id("movieplayer")).click();
		Wait.waitMilliSeconds(5000);
	}
	
	/**
	 * 关闭播放的影片
	 */
	public void closePlayMovie(){
		driver.findElement(By.xpath("//div[starts-with(@id,'layui-layer')]/span/a")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	
	/**
	 * 发布影片
	 */
	public void clickMovieReleaseBtn(){
		driver.findElement(By.id("movierelease")).click();
		Wait.waitMilliSeconds(5000);
	}

	/**
	 * 移动到问题，指引的图标，并进入某个选项
	 */
	public void reference(String index){
		Actions a=new Actions(driver);
		WebElement e=driver.findElement(By.xpath("//div[@class='quick-nav']//button[contains(@class,'icon-pg-doubt')]"));
		a.moveToElement(e).perform();
		Wait.waitMilliSeconds(3000);
		
		e.findElement(By.xpath("./../div/ul/li["+index+"]/a")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	
	/**
	 * 移动到设置，并进入某个选项
	 */
	public void set(String index){
		Actions a=new Actions(driver);
		WebElement e=driver.findElement(By.xpath("//div[@class='quick-nav']//button[contains(@class,'icon-pg-menu')]"));
		a.moveToElement(e).perform();
		Wait.waitMilliSeconds(3000);
		
		e.findElement(By.xpath("./../div/ul/li["+index+"]/a")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	/**
	 * 获取滑动条
	 */
	public WebElement getSlipBar(){
		return driver.findElement(By.xpath("//div[@class='canvas-ctrl']/div[@class='progress-bar']/i"));
	}
	
	
	/**
	 * 缩小
	 */
	public void reduce(){
		driver.findElement(By.xpath("//div[@class='canvas-ctrl']/button[contains(@class,'icon-pg-reduce')]")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	/**
	 * 放大
	 */
	public void enlarge(){
		driver.findElement(By.xpath("//div[@class='canvas-ctrl']/button[contains(@class,'icon-pg-enlarge')]")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	/**
	 * 获取场景百分比大小
	 */
	public String getSizePercent(){
		return driver.findElement(By.xpath("//div[@class='film-opts']/div[@class='canvas-ctrl']/div[@class='num']")).getText();
	}
	
	
	/**
	 * 图层列表
	 */
	public void layerList(){
		driver.findElement(By.xpath("//div[@class='wgt-film-script']/div/ul/li[2]/a")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	/**
	 * 动作列表
	 */
	public void actionList(){
		driver.findElement(By.xpath("//div[@class='wgt-film-script']/div/ul/li[1]/a")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	/**
	 * 图层上移
	 */
	public void clickLevelUp(){
		driver.findElement(By.xpath("//div[@class='level-ctrl']/button[contains(@class,'icon-pg-up')]")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	/**
	 * 图层向下
	 */
	public void clickLevelDown(){
		driver.findElement(By.xpath("//div[@class='level-ctrl']/button[contains(@class,'icon-pg-down')]")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	/**
	 * 添加镜头
	 */
	public void clickAddCamera(){
		driver.findElement(By.xpath("//div[@class='lens-ctrl']/button")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	/**
	 * 设置场景大小
	 */
	public void setSceneSize(){
		driver.findElement(By.xpath("//div[@class='screen-ctrl']/button")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	/**
	 * 从当前场景进行播放
	 */
	public void playFromCurrentScene(){
		driver.findElement(By.xpath("//div[@class='vcenter']/button")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	/**
	 * 作品发布
	 */
	public void movieRelease(String movie_type){
		LocateIframe.locateIframe(driver, "layui-layer-iframe");
		
	}
	
	
	/**
	 * 获取动作列表
	 */
	public String getActionList(String data_num){
		return driver.findElement(By.xpath("//div[@class='script-list']/ul/li[@data-num='"+data_num+"']//span[@class='effect']")).getText();
	}
	
	
	
}
