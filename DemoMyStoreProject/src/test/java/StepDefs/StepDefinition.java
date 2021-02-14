package StepDefs;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.HomePage;
import PageObjects.MyAccountPage;
import PageObjects.OrderHistoryPage;
import PageObjects.PersonalInformationPage;
import PageObjects.ShoppingCartSummaryPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {

	private String orderReference;
	public WebDriver driver;
	private HomePage homePage;
	private MyAccountPage myAccountPage;
	private ShoppingCartSummaryPage summaryPage;
	private PersonalInformationPage infoPage;
	
	
	private OrderHistoryPage orderHistoryPage;

	@Given("user launches AutomationPactice webapp")
	public void user_launches_AutomationPactice_webapp() {
		driver.get("http://automationpractice.com/index.php");
	}

	@When("user logs in with {string} and password {string}")
	public void user_logs_in_with_and_password(String user, String password) throws Throwable {
		homePage = new HomePage(driver);
		myAccountPage = homePage.GoToSignInPage().SignIn(user, password);

	}

	@When("orders a tshirt")
	public void orders_a_tshirt() throws Throwable {
		summaryPage = myAccountPage.AssertPageTitleIsCorrect().OrderTshirt().AddToCart().ProceedToCheckout().ProceedToAddress()
				.ProceedToShipping().ProceedToPayment().ConfirmPaymentByWire();
		
		orderReference= summaryPage.GetOrderReferenceNumber();
		System.out.println("Reference : " + summaryPage.GetOrderReferenceNumber());
		orderHistoryPage = summaryPage.GoToOrderHistory();
		
	}

	@Then("order should be visible in order history")
	public void order_should_be_visible_in_order_history() throws Throwable {
		orderHistoryPage.CheckOrderIsListed(orderReference).GoToHome().SignOut();
	}

	@When("user updates first name in Personal Information Page")
	public void user_updates_first_name_in_Personal_Information_Page() throws Throwable {
	   infoPage =  myAccountPage.AssertPageTitleIsCorrect()
	    .GoToMyPersonalInformationPage()
	    .ChangeFirstName().SetOldPassword()
	    .SubmitInformation();
	}

	@Then("user validates confirmation message")
	public void user_validates_confirmation_message() throws Throwable {
	   infoPage.ValidateSuccessMessage()
	   .GoToHome()
	   .SignOut();
	}
	
	@Before
	public void startUp() {

		System.setProperty("webdriver.chrome.driver", "D:\\RBS\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@After
	public void TearDown() {
		driver.quit();
	}
}