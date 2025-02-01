package com.qspiders.genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qspider.objectrepository.HomePage;
import com.qspider.objectrepository.LoginPage;
import com.qspider.objectrepository.ShoppingCartPage;
import com.qspider.objectrepository.WelcomePage;

public class BaseClass {
	public static ExtentReports extentReport;
	public static WebDriver driver;
	public static ExtentTest test;
	
public JavaUtility jUtil=new JavaUtility();// object creation for calling the method from JavaUtility object creation
public WebDriverUtility wUtil=new WebDriverUtility();
public FileUtility fUtil=new FileUtility();
public ShoppingCartPage sp;
public WelcomePage wp;
public HomePage hp;
public LoginPage lp;

	@BeforeSuite
	public void configReport() {
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/extentreports"+jUtil.getSystemTime()+".html");
		extentReport=new ExtentReports();
		extentReport.attachReporter(spark);	
	}
	
	@org.testng.annotations.Parameters("Browser")
	@BeforeClass
	public void launchBrowser(@Optional("chrome") String browserName) throws IOException {
		if(browserName.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();	
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();	
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();	
		}
		driver.manage().window().maximize();
		wUtil.implycitWait(driver);
		driver.get(fUtil.getDataFromProperty("url"));
	}
	
	@BeforeMethod
	public void login() throws IOException {
		wp=new WelcomePage(driver);
		wp.getLoginLink().click();
		
		lp=new LoginPage(driver);
		lp.getEmailTextField().sendKeys(fUtil.getDataFromProperty("email"));
		lp.getPasswordTextField().sendKeys(fUtil.getDataFromProperty("password"));
		lp.getLoginButton().click();
		
	}
	@AfterMethod
	public void logout() {
		hp=new HomePage(driver);
		hp.getLogoutLink().click();
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	@AfterSuite
	public void reportBackup() {
		extentReport.flush();
	}
}
