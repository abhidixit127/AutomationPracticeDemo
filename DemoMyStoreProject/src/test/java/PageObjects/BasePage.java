package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}

	public WebElement FindElement(By identifier) throws Throwable {
		try {
			return driver.findElement(identifier);
		} catch (Exception e) {
			return null;
		}
	}

	public WebElement WaitForHeadingVisibility(int headingIndex, String heading) {
		String locator = "//h" + headingIndex + "[contains(text(),'" + heading + "')]";
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((locator))));
	}
}
