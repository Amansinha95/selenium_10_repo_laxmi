package com.qspider.home;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qspider.objectrepository.HomePage;
import com.qspider.objectrepository.ShoppingCartPage;
import com.qspiders.genericutility.BaseClass;
import com.qspiders.genericutility.ListenerUtility;

@Listeners(ListenerUtility.class)

public class TC_DWS_003_Test extends BaseClass {
	@Test
	public void addToCart() throws IOException {
		hp = new HomePage(driver);
		sp=new ShoppingCartPage(driver);
		hp.getAddToCartButton().click();
		hp.getShoppingCartLink().click();
		wUtil.takeScreenshot(driver);
	//String text = sp.getProductName().getText();
		//String productName = driver.findElement(By.xpath("//a[@class='product-name']")).getText();
		Assert.assertEquals(sp.getProductName().getText(), "14.1-inch Laptop", "product failed to add");
		test.log(Status.PASS, "Product added");
	}
}
