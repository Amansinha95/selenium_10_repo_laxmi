package com.qspider.electronics;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qspider.objectrepository.HomePage;
import com.qspiders.genericutility.BaseClass;
import com.qspiders.genericutility.ListenerUtility;
@Listeners(ListenerUtility.class)
public class TC_DWS_002_Test extends BaseClass {
@Test
public void clickOnElectronics() {
	
	hp=new HomePage(driver);
	hp.getComputersLink().click();
	Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Electronics","Electronics page is not displayed");
	test.log(Status.PASS, "Electronics page is displayed");
}
}
