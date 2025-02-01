package com.qspiders.computers;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qspider.objectrepository.HomePage;
import com.qspiders.genericutility.BaseClass;
import com.qspiders.genericutility.ListenerUtility;
@Listeners(ListenerUtility.class)
public class TC_DWS_010_Test extends BaseClass {
	@Test
	public void clickOnComputres(){
		
		hp=new HomePage(driver);
		hp.getComputersLink().click();
	Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Computer","Computers page is not displayed");
	test.log(Status.PASS, "Computers page is displayed");
	}
	}
