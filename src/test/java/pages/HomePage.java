package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import basic.ProjectBasicMethods;

public class HomePage extends ProjectBasicMethods {

	WebDriver driver;
	@FindBy(id = "signup")
	WebElement signupBtn;

	@FindBy(id = "submit")
	WebElement loginSubmit;

	// constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Check signup button is visible and clickable
	public void checkSignup() {
		if (signupBtn.isDisplayed() && signupBtn.isEnabled()) {
			System.out.println("The signup button is visible and clickable");
		} else {
			System.out.println("The signup button is NOT visible and clickable");
		}
	}

	// check signup button is redirected to add user page
	public SignupPage signupBtnRedirection() {
		try {
			driver.get("https://thinking-tester-contact-list.herokuapp.com/");

			// Find and click the signup button
			WebElement signupButton = driver.findElement(By.id("signup"));
			signupButton.click();

			// Wait for the URL to change
			Thread.sleep(2000);

			// Check if the URL has changed
			if (driver.getCurrentUrl().contains("/addUser")) {
				System.out.println("URL changed and the page is redirected: Test Passed");
			} else {
				System.out.println("URL did not change and the page is not redirected: Test Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SignupPage(driver);
	}
	

	// check login submit button is visible or not

	public void checkLoginSubmit() {
		if (loginSubmit.isDisplayed() && loginSubmit.isEnabled()) {
			System.out.println("The login submit button is visible and clickable ");
		} else {
			System.out.println("The login sublit button is NOT visible and clickable");
		}
	}

}
