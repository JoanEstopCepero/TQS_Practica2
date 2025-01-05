package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Duration;
import io.cucumber.java.en.Then;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class WomenDressSteps {
	WebDriver driver;
	@Given("the user is in the index page")
	public void theUserIsInTheIndexPage()
	{
		/*
		System.setProperty("webdriver.chrom.driver","Drivers/chromdriver.exe");
		
        String adBlockPath = "./Extensions/AdBlock.crx"; 
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(adBlockPath)); 
        driver = new ChromeDriver(options);
        driver.navigate().to("https://automationexercise.com");
        */
		System.setProperty("webdriver.chrom.driver","Drivers/chromdriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://automationexercise.com");
	}
	
	@When("the user accepts cookies")
	public void theUserAcceptsCookies() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
	    WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button")
	    ));
	    acceptButton.click();
	}
	
	@When("the user clicks the products option")
	public void theUserClicksTheProductsOption()
	{		
		WebElement produ = driver.findElement(By.partialLinkText("Products"));
		produ.click();
		closeAdIfPresent();
		produ.click();

	}
	
	@When("^the user enters (.*) in the search bar")
	public void theUserEntersDressInTheSearchBar(String article)
	{
		driver.findElement(By.id("search_product")).sendKeys(article);
	}
	
	@When("the user clicks the search button")
	public void theUserClicksTheSearchButton()
	{
		WebElement produsearch = driver.findElement(By.id("submit_search"));
		produsearch.click();
		closeAdIfPresent();
		produsearch.click();
	}
	
	@Then("^the (.*) list appears")
	public void theDressListAppears(String article)
	{
		String title = driver.findElement(By.className("features_items")).getText();
		Assert.assertTrue(title.contains("SEARCHED PRODUCTS"));
	}
	
	
	// ESCENARI 2
	@When("the user manages cookies")
	public void theUserManagesCookies() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
	    WebElement manageButton = wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector(".fc-button.fc-cta-manage-options.fc-secondary-button")
	    ));
	    manageButton.click();
	}
	 
	 @When("the user clicks accept all cookies")
		public void theUserClicksAcceptAllCookies()
		{		
			driver.findElement(By.cssSelector(".fc-button.fc-data-preferences-accept-all.fc-secondary-button")).click();
		}
	
	 @When("the user clicks more info cookie a")
		public void theUserClicksMoreInfo()
		{		
			driver.findElement(By.className("fc-purpose-feature-more-info")).click();
		}
	 
	 @When("the user finishes reading more info cookie a")
		public void theUserfinishesMoreInfo()
		{		
			driver.findElement(By.className("fc-help-dialog-close-button-label")).click();
		}
	 
	 @When("the user accepts cookie a")
		public void theUserAcceptsCookieA()
		{		
			driver.findElement(By.className("fc-slider-el")).click();
		}
	

	 @Then("the cookies popup should be closed")
	 public void theCookiesPopupShouldBeClosed() {
	     List<WebElement> cookiesPopup = driver.findElements(By.id("fc-dialog-container"));
	     
	     if (cookiesPopup.size() > 0) {
	         Assert.fail("The cookies popup is still visible.");
	     } else {
	         Assert.assertTrue(true, "The cookies popup was successfully closed.");
	     }
	 }

	
	//ESCENARI 3
	 @When("the user clicks the register option")
		public void theUserClicksTheRegisterOption()
		{		
			WebElement regi = driver.findElement(By.partialLinkText("Signup"));
			regi.click();
			closeAdIfPresent();
			regi.click();
		}
	 @Then("the signup button is displayed")
	 public void theSignupButtonIsDisplayed() {
	     WebElement signupButton = driver.findElement(By.cssSelector("[data-qa='signup-button']"));
	     
	     Assert.assertTrue(signupButton.isDisplayed(), "El botón de Signup no está visible.");
	 }
	 @When("the user enters {string} as name and {string} as email for signup")
	 public void theUserEntersNameAndEmailForSignup(String name, String email) {
	     WebElement nameField = driver.findElement(By.cssSelector("[data-qa='signup-name']"));
	     nameField.sendKeys(name);

	     WebElement emailField = driver.findElement(By.cssSelector("[data-qa='signup-email']"));
	     emailField.sendKeys(email);
	 }

	 @And("the user clicks the signup button")
	 public void theUserClicksTheSignupButton() {
	     WebElement signupButton = driver.findElement(By.cssSelector("[data-qa='signup-button']"));
	     signupButton.click();
		 closeAdIfPresent();
	     signupButton.click();
	 }
	 
	 @When("the user fills the registration form with valid data")
	 public void theUserFillsTheRegistrationFormWithValidData() {
	     WebElement titleMr = driver.findElement(By.cssSelector("#id_gender1"));
	     titleMr.click();

	     WebElement nameField = driver.findElement(By.cssSelector("#name"));
	     nameField.clear();
	     nameField.sendKeys("Joan Estop");

	     WebElement passwordField = driver.findElement(By.cssSelector("#password"));
	     passwordField.sendKeys("SecurePassword123!");

	     WebElement daysDropdown = driver.findElement(By.cssSelector("#days"));
	     daysDropdown.sendKeys("1");

	     WebElement monthsDropdown = driver.findElement(By.cssSelector("#months"));
	     monthsDropdown.sendKeys("January");

	     WebElement yearsDropdown = driver.findElement(By.cssSelector("#years"));
	     yearsDropdown.sendKeys("1990");

	     WebElement newsletterCheckbox = driver.findElement(By.cssSelector("#newsletter"));
	     newsletterCheckbox.click();

	     WebElement firstNameField = driver.findElement(By.cssSelector("#first_name"));
	     firstNameField.sendKeys("Joan");

	     WebElement lastNameField = driver.findElement(By.cssSelector("#last_name"));
	     lastNameField.sendKeys("Estop");

	     WebElement addressField = driver.findElement(By.cssSelector("#address1"));
	     addressField.sendKeys("123 Elm Street");

	     WebElement countryDropdown = driver.findElement(By.cssSelector("#country"));
	     countryDropdown.sendKeys("United States");

	     WebElement stateField = driver.findElement(By.cssSelector("#state"));
	     stateField.sendKeys("California");

	     WebElement cityField = driver.findElement(By.cssSelector("#city"));
	     cityField.sendKeys("Los Angeles");

	     WebElement zipcodeField = driver.findElement(By.cssSelector("#zipcode"));
	     zipcodeField.sendKeys("90001");

	     WebElement mobileField = driver.findElement(By.cssSelector("#mobile_number"));
	     mobileField.sendKeys("+1234567890");
	 }
	 
	 @And("the user submits the registration form")
	 public void theUserSubmitsTheRegistrationForm() {
	     WebElement createAccountButton = driver.findElement(By.cssSelector("[data-qa='create-account']"));
	     createAccountButton.click();
		 closeAdIfPresent();
	     createAccountButton.click();
	 }
	 
	 @And("the user clicks the continue button")
	 public void theUserClicksTheContinueButton() {
	     WebElement continueButton = driver.findElement(By.cssSelector("[data-qa='continue-button']"));
	     continueButton.click();
		 closeAdIfPresent();
	     continueButton.click();
	 }

	 @Then("the user is redirected to the homepage")
	 public void theUserIsRedirectedToTheHomepage() {
	     String currentUrl = driver.getCurrentUrl();
	     Assert.assertEquals(currentUrl, "https://automationexercise.com/", "El usuario no fue redirigido a la página principal.");
	 }
	 
	 //Escenari 4
	 @Then("an error message indicating the email already exists is displayed")
	 public void anErrorMessageIndicatingTheEmailAlreadyExistsIsDisplayed() {
		 List<WebElement> missatge = driver.findElements(By.cssSelector("#id_gender1"));
		 if (missatge.size() > 0) {
	         Assert.fail("No dona error");
	     }
	 }
	 
	 //Escenari 5
	 
	 @When("the user clicks the login option")
	 public void theUserClicksTheLoginOption() {
	     WebElement login = driver.findElement(By.partialLinkText("Login"));
	     login.click();
		 closeAdIfPresent();
		 login.click();
	 }

	 @Then("the login button is displayed")
	 public void theLoginButtonIsDisplayed() {
	     WebElement loginButton = driver.findElement(By.cssSelector("[data-qa='login-button']"));
	     Assert.assertTrue(loginButton.isDisplayed(), "El botón de Login no está visible.");
	 }

	 @When("the user enters {string} as email and {string} as password for login")
	 public void theUserEntersEmailAndPasswordForLogin(String email, String password) {
	     WebElement emailField = driver.findElement(By.cssSelector("[data-qa='login-email']"));
	     emailField.sendKeys(email);

	     WebElement passwordField = driver.findElement(By.cssSelector("[data-qa='login-password']"));
	     passwordField.sendKeys(password);
	 }

	 @And("the user clicks the login button")
	 public void theUserClicksTheLoginButton() {
	     WebElement loginButton = driver.findElement(By.cssSelector("[data-qa='login-button']"));
	     loginButton.click();
		 closeAdIfPresent();
		 loginButton.click();
	 }
	 
	 //Escenari 6
	 @Then("an error message indicating invalid name or password is displayed")
	 public void anErrorMessageIndicatingWrongNameDisplayed() {
		 String currentUrl = driver.getCurrentUrl();
	     Assert.assertNotSame(currentUrl, "https://automationexercise.com/", "El usuario fue redirigido a la página principal.");
	 }
	 
	 //Escenari 7
	 @When("the user clicks the logout option")
		public void theUserClicksTheLogOutOption()
		{		
			driver.findElement(By.partialLinkText("Logout")).click();
		}
	 @Then("go to login page")
	 public void goToLogInPage() {
		 String currentUrl = driver.getCurrentUrl();
	     Assert.assertNotSame(currentUrl, "https://automationexercise.com/login", "El usuario no fue redirigido a la página login.");
	 }

	 //Escenari 8
	 @When("the user clicks the delete account option")
		public void theUserClicksTheDeleteAccountOption()
		{		
			WebElement delete = driver.findElement(By.partialLinkText("Delete"));
			delete.click();
			closeAdIfPresent();
			delete.click();
		}
	 
	 //Escenari 9
	 @When("the user clicks the View Product button for product a")	 
	 public void theUserClicksTheViewProductButtonForProduct1() {
	     WebElement carrito = driver.findElement(By.cssSelector("a[href='/product_details/1']"));
	     carrito.click();
	     closeAdIfPresent();
	     carrito.click();

	 }
	 @And("the user clicks the Add to Cart button")
	 public void theUserClicksTheAddToCartButton() {
		 WebElement addcart = driver.findElement(By.cssSelector("button.btn.btn-default.cart"));
		 addcart.click();
		 closeAdIfPresent();
		 addcart.click();
	 }

	 @And("the user clicks the View Cart button")
	 public void theUserClicksTheViewCartButton() {
		 WebElement button = driver.findElement(By.xpath("//button[@data-dismiss='modal']"));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	 }
	 @And("the user clicks the Cart button")
	 public void theUserClicksTheCartButton() {
		 WebElement addcart = driver.findElement(By.partialLinkText("Cart"));
		 addcart.click();
		 closeAdIfPresent();
		 addcart.click();
	 }
	 @Then("go to cart page")
	 public void goToCartPage() {
		 String currentUrl = driver.getCurrentUrl();
	     Assert.assertNotSame(currentUrl, "https://automationexercise.com/view_cart", "El usuario no fue redirigido a la página carro.");
	 }
	 
	 

	 //Escenari 10
	 public void closeAdIfPresent() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
	}
	 
	 //Escenari 11
	 @When("the user enters {string} in the subscription bar")
		public void theUserEntersDressInTheSubscribeBar(String email)
		{
		 	JavascriptExecutor jse = (JavascriptExecutor) driver;
		 	jse.executeScript("window.scrollBy(0,11200)");
			driver.findElement(By.id("susbscribe_email")).sendKeys(email);
		}
		
	@When("the user clicks the subscribe button")
		public void theUserClicksTheGoButton()
		{
			driver.findElement(By.id("subscribe")).click();
		}
		




}
