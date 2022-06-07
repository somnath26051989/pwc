package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class loginPopUP {
	
	/*
	 * WebDriver driver;
	 * 
	 * By closeIcon = By.xpath("//button[@class='_2KpZ6l _2doB4z']");
	 * 
	 * public loginPopUP(WebDriver driver) { PageFactory.initElements(driver, this);
	 * 
	 * }
	 * 
	 * public void clickOnCloseIcon() { driver.findElement(closeIcon).click(); }
	 */
	
	String closeIcon = "//button[@class='_2KpZ6l _2doB4z']";

	public String getCloseIcon() {
		return closeIcon;
	}

	public void setCloseIcon(String closeIcon) {
		this.closeIcon = closeIcon;
	}
	
}
