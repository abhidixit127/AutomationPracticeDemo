package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);

	}

	public SignInPage GoToSignInPage() throws Throwable {
		WebElement signInLink = FindElement(By.xpath(("//a[contains(text(),'Sign in')]")));
		Assert.assertNotNull("Unable to locate sign in link", signInLink);
		signInLink.click();

		WaitForHeadingVisibility(1, "Authentication");

		return new SignInPage(driver);
	}
	
	public HomePage SignOut() throws Throwable
	{
		WebElement singOutLink = FindElement(By.xpath(("//div/a[contains(text(),'Sign out')]")));
		Assert.assertNotNull("Unable to locate sign in link", singOutLink);
		singOutLink.click();
		
		return this;
	}

}
