package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderHistoryPage extends BasePage {

	public OrderHistoryPage(WebDriver driver) {
		super(driver);

	}

	public HomePage GoToHome() throws Throwable {
		WebElement home = FindElement(By.xpath("//span[contains(text(),'Home')]"));
		Assert.assertNotNull("Unable to locate Home link on Order History Page", home);

		home.click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[@src='http://automationpractice.com/img/logo.jpg']")));

		return new HomePage(driver);
	}
	
	public OrderHistoryPage CheckOrderIsListed(String orderReference) throws Throwable
	{
		WebElement order = FindElement(By.xpath("//table[@id='order-list']//tr[1]/td/a[contains(text(),'"+orderReference+"')]"));
		Assert.assertNotNull("Unable to locate ordered product on Order History Page", order);
		
		return this;
	}

}
