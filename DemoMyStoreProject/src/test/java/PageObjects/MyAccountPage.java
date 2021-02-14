package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BasePage {

	private String pageTitle="My account - My Store";

	public MyAccountPage(WebDriver driver) {
		super(driver);

	}

	public MyAccountPage AssertPageTitleIsCorrect() {
		Assert.assertTrue("Title Mismatch of MyAccounts Page", pageTitle.equals(driver.getTitle()));
		return this;
	}

	public ProductOrderPage OrderTshirt() throws Throwable {
		WebElement tshirtTab = FindElement(By.xpath(("//div[@id='block_top_menu']/ul/li/a[@title='T-shirts']")));
		Assert.assertNotNull("Unable to locate T shirt tab", tshirtTab);
		tshirtTab.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layered_block_left")));

		return new ProductOrderPage(driver);
	}
	
	public PersonalInformationPage GoToMyPersonalInformationPage() throws Throwable
	{
		WebElement infoBtn = FindElement(By.xpath(("//a[@title='Information']")));
		Assert.assertNotNull("Unable to locate My Personal Information tab", infoBtn);
		infoBtn.click();
		
		WaitForHeadingVisibility(1, "Your personal information");
		
		return new PersonalInformationPage(driver);
	}

}
