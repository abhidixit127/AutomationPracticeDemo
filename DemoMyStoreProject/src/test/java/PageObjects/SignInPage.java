package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage extends BasePage {

	public SignInPage(WebDriver driver) {
		super(driver);

	}

	public MyAccountPage SignIn(String user, String password) throws Throwable {
		WebElement userName = FindElement(By.id("email"));
		Assert.assertNotNull("Unable to locate user textfield with the locator", userName);
		userName.sendKeys(user);

		WebElement passWd = FindElement(By.id("passwd"));
		Assert.assertNotNull("Unable to locate password textfield with the locator", passWd);
		passWd.sendKeys(password);

		WebElement submitBtn = FindElement(By.id("SubmitLogin"));
		Assert.assertNotNull("Unable to locate Submit Login Btn  with the locator", submitBtn);
		submitBtn.click();

		WaitForHeadingVisibility(1, "My account");

		return new MyAccountPage(driver);
	}

}
