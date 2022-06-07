package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	
	/*
	 * WebDriver driver;
	 * 
	 * By searchInput = By.xpath("//input[@class='_3704LK']"); By searchIcon =
	 * By.xpath("//button[@class='L0Z3Pu']");
	 * 
	 * public homePage(WebDriver driver) { this.driver = driver;
	 * PageFactory.initElements(driver, this); }
	 * 
	 * public void searchItem(String itemName) {
	 * driver.findElement(searchInput).click();
	 * driver.findElement(searchInput).sendKeys(itemName);
	 * driver.findElement(searchIcon).submit();
	 * 
	 * }
	 */
	
	String searchInput = "//input[@class='_3704LK']"; 
	public String getPriceOnCart() {
		return priceOnCart;
	}
	public void setPriceOnCart(String priceOnCart) {
		this.priceOnCart = priceOnCart;
	}
	public String getActualPriceToBePaid() {
		return actualPriceToBePaid;
	}
	public void setActualPriceToBePaid(String actualPriceToBePaid) {
		this.actualPriceToBePaid = actualPriceToBePaid;
	}
	String searchIcon = "//button[@class='L0Z3Pu']";
	String listOfResult = "//div[@class='_30jeq3 _1_WHN1']";
	String displayedPrice = "//div[@class='_30jeq3 _16Jk6d']";
	String addCartButton = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']";
	String selectedProductWindow = "//a[@class='_1_3w1N']";
	String priceOnCart = "//span[@class='_2-ut7f _1WpvJ7']";
	String actualPriceToBePaid = "//div[@class='_1dqRvU']//div[@class='_2npqm0']";
	
	public String getSelectedProductWindow() {
		return selectedProductWindow;
	}
	public void setSelectedProductWindow(String selectedProductWindow) {
		this.selectedProductWindow = selectedProductWindow;
	}
	public String getAddCartButton() {
		return addCartButton;
	}
	public void setAddCartButton(String addCartButton) {
		this.addCartButton = addCartButton;
	}
	public String getDisplayedPrice() {
		return displayedPrice;
	}
	public void setDisplayedPrice(String displayedPrice) {
		this.displayedPrice = displayedPrice;
	}
	public String getListOfResult() {
		return listOfResult;
	}
	public void setListOfResult(String listOfResult) {
		this.listOfResult = listOfResult;
	}
	public String getSearchInput() {
		return searchInput;
	}
	public void setSearchInput(String searchInput) {
		this.searchInput = searchInput;
	}
	public String getSearchIcon() {
		return searchIcon;
	}
	public void setSearchIcon(String searchIcon) {
		this.searchIcon = searchIcon;
	}
}
