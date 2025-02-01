package com.qspider.book;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qspider.objectrepository.HomePage;
import com.qspiders.genericutility.BaseClass;
import com.qspiders.genericutility.ListenerUtility;

@Listeners(ListenerUtility.class)
public class TC_DWS_001_Test extends BaseClass {

	@Test
	public void clickOnBooks() {
		hp = new HomePage(driver);
		hp.getBooksLink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Books", "Books page is not displayed");
		test.log(Status.PASS, "Books page is displayed");
	}
}
