package com.hddy.page.movie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hddy.constant.Direction;
import com.hddy.util.ElementExistOrNot;
import com.hddy.util.LocateIframe;
import com.hddy.util.Wait;

public class RoleAction {
	private WebDriver driver;
	public RoleAction(WebDriver driver){
		this.driver=driver;
	}
	
	
	public void clickAction(String action_name){
		driver.findElement(By.xpath("//ul[@id='roleAction']/li//div[@class='title' and text()='"+action_name+"']")).click();
		Wait.waitMilliSeconds(5000);
		//有些动作有弹出新的iframe对话框，有些没有
		if(ElementExistOrNot.elementExist(driver, By.xpath("//iframe[starts-with(@id,'layui-layer-iframe')]"))){
			LocateIframe.locateIframe(driver, "layui-layer-iframe");
		}
		
	}
	
	/**
	 * 说话动作输入说话的内容
	 * @param caption
	 */
	public void inputCaptionContent(String caption){
		WebElement e=driver.findElement(By.id("myarea"));
		e.clear();
		e.sendKeys(caption);
		Wait.waitMilliSeconds(3000);
	}
	
	/**
	 * 说话伴随的动作
	 */
	public void chooseAccompanyAction(String action_name){
		driver.findElement(By.xpath("//ul[@id='role_motion']//li[contains(text(),'"+action_name+"')]")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	
	/**
	 * 走路完成之后站立的方向
	 */
	public void chooseDirectionOfStanding(String direction){
		WebElement e=driver.findElement(By.id("role_motion"));
		
		if(direction.equalsIgnoreCase(Direction.NORTH)){
			e.findElement(By.xpath(".//div[@id='direction_5']")).click();
		}else if(direction.equalsIgnoreCase(Direction.SOUTH)){
			e.findElement(By.xpath(".//div[@id='direction_1']")).click();
			
		}else if(direction.equalsIgnoreCase(Direction.WEST)){
			e.findElement(By.xpath(".//div[@id='direction_3']")).click();
		}else if(direction.equalsIgnoreCase(Direction.EAST)){
			e.findElement(By.xpath(".//div[@id='direction_7']")).click();
		}else if(direction.equalsIgnoreCase(Direction.NORTH_EAST)){
			
			e.findElement(By.xpath(".//div[@id='direction_6']")).click();
		}else if(direction.equalsIgnoreCase(Direction.NORTH_WEST)){
			e.findElement(By.xpath(".//div[@id='direction_4']")).click();
		}else if(direction.equalsIgnoreCase(Direction.SOUTH_EAST)){
			e.findElement(By.xpath(".//div[@id='direction_0']")).click();
		}else if(direction.equalsIgnoreCase(Direction.SOUTH_WEST)){
			e.findElement(By.xpath(".//div[@id='direction_2']")).click();
		}
		Wait.waitMilliSeconds(3000);
		
	}
	
	/**
	 * 走路的是否说话，边走边说
	 */
	public void setSayingWithWalk(){
		driver.findElement(By.id("isSound")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	/**
	 * 转身方向
	 */
	
	public void chooseDirectionOfTurning(String direction){
		WebElement e=driver.findElement(By.xpath("//div[@class='steering-wheel']"));
		
		if(direction.equalsIgnoreCase(Direction.NORTH)){
			e.findElement(By.xpath("./div[1]/div[2]/i")).click();
		}else if(direction.equalsIgnoreCase(Direction.SOUTH)){
			e.findElement(By.xpath("./div[3]/div[2]/i")).click();
			
		}else if(direction.equalsIgnoreCase(Direction.WEST)){
			e.findElement(By.xpath("./div[2]/div[1]/i")).click();
		}else if(direction.equalsIgnoreCase(Direction.EAST)){
			e.findElement(By.xpath("./div[2]/div[3]/i")).click();
		}else if(direction.equalsIgnoreCase(Direction.NORTH_EAST)){
			
			e.findElement(By.xpath("./div[1]/div[3]/i")).click();
		}else if(direction.equalsIgnoreCase(Direction.NORTH_WEST)){
			e.findElement(By.xpath("./div[1]/div[1]/i")).click();
		}else if(direction.equalsIgnoreCase(Direction.SOUTH_EAST)){
			e.findElement(By.xpath("./div[3]/div[3]/i")).click();
		}else if(direction.equalsIgnoreCase(Direction.SOUTH_WEST)){
			e.findElement(By.xpath("./div[3]/div[1]/i")).click();
		}
		
		Wait.waitMilliSeconds(3000);
	}
	
	/**
	 * 选择场景中的角色之后，出现的坐下和站起来的快捷操作
	 */
	public void clickSitAndStand(String action){	
		driver.findElement(By.xpath("//div[@id='roleDirectionControl']/div[@class='control-walk']/div[@class='btns']/a[text()='"+action+"']")).click();
		Wait.waitMilliSeconds(5000);
	}
	
	/**
	 * 设置角色的姿势
	 */
	public void setRolePosture(String posture_name){
		driver.findElement(By.xpath("//ul[@id='role_motion']//li[contains(text(),'"+posture_name+"')]")).click();
		Wait.waitMilliSeconds(3000);
	}
	
	
	/**
	 * 根据表情的名称添加表情
	 */
	public void chooseFaceIcon(String face_icon){
		driver.findElement(By.xpath("//ul[@id='faceIcon_list']/li[value='"+face_icon+"']")).click();
		Wait.waitMilliSeconds(3000);
	}
	

	public void clickConfirm(){
		driver.findElement(By.xpath("//div[@class='dlg-btns']/button[1]")).click();
		Wait.waitMilliSeconds(3000);
		driver.switchTo().defaultContent();
	}
	
	/**
	 * 选择制作场景中某个场景，然后右键单击该场景，设置动作
	 */
	public void rightClickRoleInScenario(String action_name){
		
	}
	
}
