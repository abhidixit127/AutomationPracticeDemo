package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductOrderPage extends BasePage {

	public ProductOrderPage(WebDriver driver) {
		super(driver);
	}

	public ProductOrderPage AddToCart() throws Throwable {
		Actions action = new Actions(driver);

		WebElement productContainer = FindElement(By.xpath("//div[@class='product-image-container']"));
		Assert.assertNotNull("Unable to locate product container", productContainer);
		action.moveToElement(productContainer).perform();

		WebElement addToCart = FindElement(By.xpath("//span[text()='Add to cart']"));
		Assert.assertNotNull("Unable to locate add To Cart button", addToCart);
		addToCart.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Proceed to checkout']")));

		return this;
	}

	public ShoppingCartSummaryPage ProceedToCheckout() throws Throwable {
		WebElement proceed = FindElement(By.xpath("//a[@title='Proceed to checkout']"));
		Assert.assertNotNull("Unable to locate Proceed to Checkout button", proceed);
		proceed.click();

		WaitForHeadingVisibility(1, "Shopping-cart summary");

		return new ShoppingCartSummaryPage(driver);
	}
}
