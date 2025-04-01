package com.base;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.pages.CartPage;
import com.pages.CheckoutPage;
import com.pages.InventoryPage;
import com.pages.LoginPage;

public class PageInitializer {

	public static LoginPage loginPage;
	public static InventoryPage homePage;
	public static CartPage cartPage;
	public static CheckoutPage checkoutPage;
	
	public static void initializePages(WebDriver driver,ExtentTest test) {
		// TODO Auto-generated constructor stub
		loginPage = new LoginPage(driver, test);
		homePage = new InventoryPage(driver, test);
		cartPage = new CartPage(driver, test);
		checkoutPage= new CheckoutPage(driver, test);
	}

}
