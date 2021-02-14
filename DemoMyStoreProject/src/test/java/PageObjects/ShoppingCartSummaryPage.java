package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartSummaryPage extends BasePage {

	public ShoppingCartSummaryPage(WebDriver driver) {
		super(driver);

	}

	public ShoppingCartSummaryPage ProceedToAddress() throws Throwable {
		WebElement proceed = FindElement(By.xpath("//div[@id='center_column']//a[@title='Proceed to checkout']"));
		Assert.assertNotNull("Unable to locate Proceed to Checkout button on Summary Page", proceed);
		proceed.click();

		WaitForHeadingVisibility(1, "Addresses");

		return this;
	}

	public ShoppingCartSummaryPage ProceedToShipping() throws Throwable {
		WebElement proceed = FindElement(By.xpath("//button[@name='processAddress']"));
		Assert.assertNotNull("Unable to locate Proceed to Checkout button on Address Page", proceed);
		proceed.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(("//p[contains(text(),'Choose a shipping option for this address: My address')]"))));

		return this;
	}

	public ShoppingCartSummaryPage ProceedToPayment() throws Throwable {
		WebElement termsConditions = FindElement(By.id("cgv"));
		Assert.assertNotNull("Unable to locate T&C on Shipping Page", termsConditions);
		termsConditions.click();

		WebElement proceed = FindElement(By.xpath("//button[@name='processCarrier']"));
		Assert.assertNotNull("Unable to locate Proceed to Checkout button on Shipping Page", proceed);
		proceed.click();

		WaitForHeadingVisibility(1, "Please choose your payment method");

		return this;
	}

	public ShoppingCartSummaryPage ConfirmPaymentByWire() throws Throwable {
		WebElement paymentOption = FindElement(By.xpath("//a[@title='Pay by bank wire']"));
		Assert.assertNotNull("Unable to locate Pay by Bank wire option on Payments Page", paymentOption);
		paymentOption.click();

		WaitForHeadingVisibility(3, "Bank-wire payment");

		WebElement confirmationBtn = FindElement(By.xpath("//button/span[text()='I confirm my order']"));
		Assert.assertNotNull("Unable to locate Cofirmation Button on Payments Page", confirmationBtn);
		confirmationBtn.click();

		WaitForHeadingVisibility(1, "Order confirmation");

		return this;
	}
	
	public String GetOrderReferenceNumber()
	{
		String pageSource = driver.getPageSource();
		String referenceNumber = pageSource.substring(pageSource.indexOf("reference")+10, pageSource.indexOf("reference")+19);
		return referenceNumber;
		
		
	}

	public OrderHistoryPage GoToOrderHistory() throws Throwable {
		WebElement orderHistory = FindElement(By.xpath("//a[@title='Back to orders']"));
		Assert.assertNotNull("Unable to locate back to Orders link on Payment Confirmation page", orderHistory);

		orderHistory.click();

		WaitForHeadingVisibility(1, "Order history");

		return new OrderHistoryPage(driver);
	}
}
