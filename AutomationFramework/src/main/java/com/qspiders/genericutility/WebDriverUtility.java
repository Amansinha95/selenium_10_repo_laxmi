package com.qspiders.genericutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * @author Rajlaxmi
 */
public class WebDriverUtility {
 
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void clickAndHold(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();
	}
	
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions act=new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}
	
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
}
	
	public void selectDropdownByIndex(WebElement dropdownElement,int index) {
		Select sel=new Select(dropdownElement);
		sel.selectByIndex(index);
}
	
	public void selectDropdownByValue(WebElement dropdownElement,String value) {
		Select sel=new Select(dropdownElement);
		sel.selectByValue(value);
}
	
	public void selectDropdownByVisibleText(WebElement dropdownElement,String visibleText) {
		Select sel=new Select(dropdownElement);
		sel.selectByVisibleText(visibleText);
}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
}
	
	public void switchToFrame(WebDriver driver, WebElement frameEle) {
		driver.switchTo().frame(frameEle);
}
	public void switchToAlert(WebDriver driver) {
		driver.switchTo().alert();
	}
	
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToWindow(WebDriver driver,String expUrl) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String id:allWindowIds) {
			driver.switchTo().window(id);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(expUrl)) {
				break;
			}
		}
		
	}
	
	
	public void implycitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public WebDriverWait explycitWait(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		return wait;
	}
	
	public void takeScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		JavaUtility jUtil=new JavaUtility();//calling the JavaUtility method getSystemTime
		//String timeStamp = LocalDateTime.now().toString().replace(":", "-");
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshots/"+ jUtil.getSystemTime()+".png");
		FileHandler.copy(temp, dest);
		
	}

	
	
//	public void switchToAlert(WebDriver driver) {
//		Alert alt=new Alert() {
//			
//			@Override
//			public void sendKeys(String keysToSend) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public String getText() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//			@Override
//			public void dismiss() {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void accept() {
//				// TODO Auto-generated method stub
//				
//			}
//		};
//			
		
		}

