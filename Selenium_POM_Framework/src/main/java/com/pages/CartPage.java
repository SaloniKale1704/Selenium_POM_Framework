package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.utils.CommonFunctions;
import com.utils.ScreenshotUtil;

public class CartPage {

	private WebDriver driver;
	private ExtentTest test;
	private CommonFunctions commonFunctions;

	public CartPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		this.commonFunctions =  new CommonFunctions(driver, test);
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class,'shopping_cart_link')]")
	private WebElement cart;

	@FindBy(className = "cart_quantity")
	WebElement quantity;

	@FindBy(xpath = "//a[text()='CHECKOUT']")
	WebElement checkoutBtn;

	// Actions
	// Go to cart page
	public void goToCartPage() {
		commonFunctions.clickElement(cart, "Cart Button");
	}

	// Verify quantity
	public void verifyItemQty(String actualQty) {
		try {
			double actualQtyDouble = Double.parseDouble(actualQty);
			int actualQtyText = (int) actualQtyDouble;

			String expectedQty = quantity.getText();
			int expectedQtyText = Integer.parseInt(expectedQty);

			System.out.println("Purchased item quantity is "+expectedQty);

			if (expectedQtyText == actualQtyText) {
				test.pass("Quantity "+expectedQty+" verified");
			} else {
				System.out.println("Quantity is not as expected");
				test.fail("Quantity is not as expected.");
				String screenshotPath = ScreenshotUtil.takeScreenshot(driver, "verifyItemQtyError");
                test.addScreenCaptureFromPath(screenshotPath);
            }
        } 
		catch (Exception e) {
            test.fail("Failed to verify item quantity: " + e.getMessage());
            String screenshotPath = ScreenshotUtil.takeScreenshot(driver, "verifyItemQtyError");
            test.addScreenCaptureFromPath(screenshotPath);
		}
	}

	// Click on checkout button
	public void clickCheckoutBtn() {
		commonFunctions.clickElement(checkoutBtn, "Checkout Button");
	}
}