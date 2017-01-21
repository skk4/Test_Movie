package com.hddy.page.movie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.hddy.util.ElementExistOrNot;
import com.hddy.util.LocateIframe;
import com.hddy.util.OperateElementWithJS;
import com.hddy.util.Wait;

public class Scenario {
	private WebDriver driver;
	public Scenario(WebDriver driver){
		this.driver=driver;
	}
	
	/**
	 * 新建场景
	 */
	public void clickNewScenario(){
		driver.findElement(By.id("addDidianBtn")).click();
		Wait.waitMilliSeconds(3000);
	}
	/**
	 * 添加片头
	 */
	public void clickAddTopScene(){
		driver.findElement(By.id("addTopDidianBtn")).click();
		Wait.waitMilliSeconds(3000);
	}
	/**
	 * 添加片尾
	 */
	public void clickAddEndScene(){
		driver.findElement(By.id("addEndDidianBtn")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	
	/**
	 * 选择风格
	 */
	public void chooseScStyle(String style_name){
		driver.findElement(By.xpath("//input[@p_classify_code='SFL001']")).click();
		Wait.waitMilliSeconds(2000);
		driver.findElement(By.xpath("//div[contains(@class,'sc_type')]/ul/li/a[text()='"+style_name+"']")).click();
		
		Wait.waitMilliSeconds(3000);
	}
	
	/**
	 * 类别
	 */
	public void chooseScType(String type_name){
		driver.findElement(By.xpath("//input[contains(@class,'sc_type_child_in')]")).click();
		Wait.waitMilliSeconds(2000);
		driver.findElement(By.xpath("//div[contains(@class,'sc_type_child')]/ul/li/a[text()='"+type_name+"']")).click();

	}
	
	/**
	 * 选择某个场景
	 */
	public void chooseScenario(String scenario_name){
		Actions a=new Actions(driver);
		
		WebElement e=driver.findElement(By.xpath("//div[@id='sc_div_SFL001']/ul/li/a/div[@class='title' and text()='"+scenario_name+"']"));
		a.moveToElement(e).perform();
		Wait.waitMilliSeconds(2000);
		e.findElement(By.xpath("./../div[@class='vcenter']")).click();
		
		Wait.waitMilliSeconds(5000);
	}
	
	/**
	 * 当前制作框中是否有存在图片
	 * @return
	 */
	public boolean getCurrentSceneExist(){
		return ElementExistOrNot.elementExist(driver, By.xpath("//div[@id='movie_center']/div/div[1]/img"));
		
	}
	
	/**
	 * 获取片头的电影名
	 * @return
	 */
	public String getTopSceneMovieName(){
		return driver.findElement(By.xpath("//div[@id='movie_center']/div/div/p[@align='LEFT']/label")).getText();
	}
	
	/**
	 * 获取片头的子标题
	 * @return
	 */
	public String getTopSceneSubTitle(){
		return driver.findElement(By.xpath("//div[@id='movie_center']/div/div[3]/p[@align='RIGHT']/label")).getText();


	}
	
	/**
	 * 获取片头的作者.
	 */
	public String getTopSceneAuthor(){
		return driver.findElement(By.xpath("//div[@id='movie_center']/div/div[4]/p[@align='RIGHT']/label")).getText();

	}
	
	/**
	 * 自定义场景按钮
	 */
	public void clickSelfDefBtn(){
		driver.findElement(By.xpath("//div[@class='res-btns']/button[contains(@class,'customBtn')]")).click();
		Wait.waitMilliSeconds(5000);
	}
	
	
	public boolean getCustomBtns(){
		return ElementExistOrNot.elementExist(driver, By.xpath("//div[@id='sc_div_SFL001']/div[@class='btns-custom']"));
	}
	
	/**
	 * 添加按钮
	 */
	public void clickAddCustomerScene(){
		driver.findElement(By.xpath("//div[@id='sc_div_SFL001']/div[@class='btns-custom']/button[contains(@class,'customAdd')]")).click();
		Wait.waitMilliSeconds(5000);
		LocateIframe.locateIframe(driver, "layui-layer-iframe");
	}
	
	public void inputSceneName(String scene_name){
		WebElement e=driver.findElement(By.id("sc_name"));
		e.clear();
		e.sendKeys(scene_name);
	}
	
	public void uploadScenePic(String scene_pic){
		OperateElementWithJS.modifyStyleBlock(driver, By.id("u_sc_url"));
		
		driver.findElement(By.id("u_sc_url")).sendKeys(scene_pic);
		Wait.waitMilliSeconds(5000);
	}
	
	
	public void clickUploadFile(){
		driver.findElement(By.id("upload_file")).click();
		Wait.waitMilliSeconds(5000);
	}
	
	/**
	 * 管理按钮
	 */
	public void clickManageScene(){
		driver.findElement(By.xpath("//div[@id='sc_div_SFL001']/div[@class='btns-custom']/button[contains(@class,'customManage')]")).click();
		Wait.waitMilliSeconds(5000);
	}
	
	
	/**
	 * 搜索按钮
	 */
	public void clickSearchBtn(){
		driver.findElement(By.xpath("//div[@class='res-btns']/button[contains(@class,'searchBtn')]")).click();
		Wait.waitMilliSeconds(5000);
		LocateIframe.locateIframe(driver, "layui-layer-iframe");
	}
	
	
	/**
	 * 输入搜索内容
	 */
	public void inputSearchKeys(String search_word){
		WebElement e=driver.findElement(By.xpath("//div[@class='input']/input"));
		e.clear();
		e.sendKeys(search_word);
		Wait.waitMilliSeconds(5000);
	}
	
	/**
	 * 点击搜素按钮
	 */
	public void clickSearchConfirm(){
		driver.findElement(By.xpath("//div[@class='form-input']/button[contains(@class,'icon-search')]")).click();
		Wait.waitMilliSeconds(5000);
	}
	/**
	 * 在素材搜素中选择第一个场景
	 */
	public void chooseFirstScene(){
		driver.findElement(By.xpath("//div[@id='scene_images_list']/li/a")).click();
		Wait.waitMilliSeconds(5000);
	}
	
	public void clickConfirm(){
		driver.findElement(By.xpath("//div[@class='alert-body']/div[@class='dlg-btns']/button[1]")).click();
		Wait.waitMilliSeconds(5000);
	}
	
	/**
	 * 从本场景开始预览
	 */
	public void previewFromCurScene(String index){
		WebElement e=driver.findElement(By.xpath("//ul[@id='edit_left_view']/li/div[@class='wrap-opts']/div[@class='num' and text()='"+index+"']"));
		e.findElement(By.xpath("./../../div[@class='wrap-items']/div[@class='wrap-btns']/button[contains(@class,'previewBtn')]")).click();
		Wait.waitMilliSeconds(5000);
	}
	
	/**
	 * 场景切换
	 */
	public void exchangeScene(String index){
		WebElement e=driver.findElement(By.xpath("//ul[@id='edit_left_view']/li/div[@class='wrap-opts']/div[@class='num' and text()='"+index+"']"));
		e.findElement(By.xpath("./../../div[@class='wrap-items']/div[@class='wrap-btns']/button[contains(@class,'sceneEffect')]")).click();
		Wait.waitMilliSeconds(5000);
	}
	
	
	
	/**
	 * 左侧场景右键操作
	 * @param index 表示第几个场景
	 */
	public void rightClickScene(String index){
		WebElement e=driver.findElement(By.xpath("//ul[@id='edit_left_view']/li/div[@class='wrap-opts']/div[@class='num' and text()='"+index+"']"));
		WebElement we=e.findElement(By.xpath("./../../div[@class='wrap-items']"));
		Actions  a=new Actions(driver);
		a.contextClick(we).perform();
		Wait.waitMilliSeconds(3000);	
	}
	
	

	/**
	 * 场景右键选项某个功能
	 * @param index 表示第几个场景
	 * @param function_index 选择某个场景之后，具体选择哪个右键功能
	 */
	public void operateFromScene(String index,String function_index){
		this.rightClickScene(index);
		
		driver.findElement(By.xpath("//div[@class='wgt-right-click-menu']/li["+function_index+"]/a")).click();
		Wait.waitMilliSeconds(3000);
		
		if(function_index.equalsIgnoreCase("4")){
			LocateIframe.locateIframe(driver, "layui-layer-iframe");
		}
		
	}
	
	
	/**
	 * 判断页面左侧的某个场景是否存在
	 * @param index
	 * @return
	 */
	public boolean leftSceneExist(String index){
		
		return ElementExistOrNot.elementExist(driver, By.xpath("//ul[@id='edit_left_view']/li/div[@class='wrap-opts']/div[@class='num' and text()='"+index+"']/../../div[@class='wrap-items']"));
	}
	
	
	
	/**
	 * 选择左侧场景
	 */
	public void clickLeftScene(String index){
		WebElement e=driver.findElement(By.xpath("//ul[@id='edit_left_view']/li/div[@class='wrap-opts']/div[@class='num' and text()='"+index+"']"));
		e.findElement(By.xpath("./../../div[@class='wrap-items']")).click();
		Wait.waitMilliSeconds(3000);
		
	}
	
	
}
