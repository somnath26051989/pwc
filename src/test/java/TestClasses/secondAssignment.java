package TestClasses;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageClasses.ScreenShot;
import PageClasses.homePage;
import PageClasses.loginPopUP;
import lib.ConfigFileReader;

public class secondAssignment {
	Logger log = Logger.getLogger(secondAssignment.class);
	WebDriver driver;
	//String url = "https://www.flipkart.com/";
	homePage hp = new homePage();
	loginPopUP lp = new loginPopUP();
	ScreenShot sc = new ScreenShot();
	ConfigFileReader cfg = new ConfigFileReader();
	//homePage hp = PageFactory.initElements(this.driver, homePage.class);
	//loginPopUP lp = PageFactory.initElements(this.driver, loginPopUP.class);
	
	
@BeforeTest
@Parameters("browser")
public void setUp(String browser) {
	//In this assignment I have handled only Firefox browser
	if(browser.equalsIgnoreCase("firefox")) {
		//String firePath = "C:\\Users\\Som\\eclipse-workspace\\mypwc\\src\\main\\resources\\Driver\\geckodriver.exe"; 
		System.setProperty("webdriver.gecko.driver", cfg.getDriverPath());
		driver = new FirefoxDriver();
		
		//Maximize the browser 
		driver.manage().window().maximize();
		
		//Launch the application
		driver.get(cfg.getApplicationUrl());
		//driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	}
	
}

@Test
public void validateMobilePrice() throws InterruptedException {
	
	String tobeSearchedItem = "Mobile";
	
	log.info("Once application is launched then click on close icon from log in pop up");
	//lp.clickOnCloseIcon();
	driver.findElement(By.xpath(lp.getCloseIcon())).click();
	
	log.info("Type 'Mobile' in Search Input field");
	//hp.searchItem("Mobile");
	driver.findElement(By.xpath(hp.getSearchInput())).sendKeys(tobeSearchedItem);	
	
	log.info("Click on the Search Icon"); 
	driver.findElement(By.xpath(hp.getSearchIcon())).submit();
	Thread.sleep(1000);
	
	log.info("Select the 6th Product from result page");
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)");
	List <WebElement> listOfItems = driver.findElements(By.xpath(hp.getListOfResult()));
	int size = listOfItems.size();
	for(int i =1; i<=size; i++) {
		if(i == 6) {
		listOfItems.get(i).click();
		break;
		
		}
	}
	
	log.info("Switch to new window");
	String newWin = driver.getWindowHandle();
	Set <String> newWinList = driver.getWindowHandles();
	Iterator<String> itr = newWinList.iterator();
	while(itr.hasNext()) {
		String childWin = itr.next();
		driver.switchTo().window(childWin);	
		Thread.sleep(10000);
		
	}
	
	log.info("Validate that Focus has shifted to new window");
	Assert.assertTrue(driver.findElement(By.xpath(hp.getSelectedProductWindow())).isDisplayed());
	
	log.info("Get the price on Product Page");
	String actualDisplayedPrice = driver.findElement(By.xpath(hp.getDisplayedPrice())).getText();
	log.info("Displayed price on Product Page is:" +actualDisplayedPrice);
	
	log.info("Click on Add To Cart button");
	driver.findElement(By.xpath(hp.getAddCartButton())).click();
	Thread.sleep(10000);
	
	log.info("Validate that total amount would be differnt from actual Product pricr due other additional cost");
	String displayedTotalPrice = driver.findElement(By.xpath(hp.getActualPriceToBePaid())).getText();
	Assert.assertNotEquals(displayedTotalPrice,actualDisplayedPrice );
	
	log.info("Capture Screesnhot of Final Page before closing the browser");
	captureScreenshot(driver.getTitle());
	
	log.info("Close the Browser");
	driver.quit();
	
}


public void captureScreenshot(String pageTitle) {

	File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	try {
		FileHandler.copy(src, new File ("\\pwcProj\\src\\main\\resources\\Screenshots" + pageTitle + ".jpeg"));
	} catch (IOException e) {
		
		e.printStackTrace();
	}

	
}


}
