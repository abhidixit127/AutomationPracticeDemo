package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;

public class PersonalInformationPage extends BasePage {

	public PersonalInformationPage(WebDriver driver) {
		super(driver);

	}

	public PersonalInformationPage ChangeFirstName() throws Throwable {
		WebElement firstName = FindElement(By.id(("firstname")));
		Assert.assertNotNull("Unable to locate firstName textbox", firstName);

		String firstNameText = firstName.getText().trim();
		if (firstNameText.equals("abc")) {
			firstName.clear();
			firstName.sendKeys("def");
		} else {
			firstName.clear();
			firstName.sendKeys("abc");
		}
		return this;
	}

	public PersonalInformationPage SetOldPassword() throws Throwable {
		WebElement oldPwd = FindElement(By.id(("old_passwd")));
		Assert.assertNotNull("Unable to locate Old Password textbox", oldPwd);

		oldPwd.sendKeys("abc195");

		return this;
	}
	
	public PersonalInformationPage SubmitInformation() throws Throwable {
		WebElement submitBtn = FindElement(By.xpath(("//button[@name='submitIdentity']")));
		Assert.assertNotNull("Unable to locate Submit btn", submitBtn);

		submitBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your personal information has been successfully updated')]")));

		return this;
	}
	
	public PersonalInformationPage ValidateSuccessMessage()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your personal information has been successfully updated')]")));
		
		return this;
	}
	
	
	
	public HomePage GoToHome() throws Throwable {
		WebElement home = FindElement(By.xpath("(//a[@href='http://automationpractice.com/'])[3]"));
		Assert.assertNotNull("Unable to locate Home link on Order History Page", home);

		home.click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[@src='http://automationpractice.com/img/logo.jpg']")));

		return new HomePage(driver);
	}

}
