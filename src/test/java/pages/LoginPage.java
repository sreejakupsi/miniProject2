package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basic.ProjectBasicMethods;

public class LoginPage extends ProjectBasicMethods{

	WebDriver driver;
	@FindBy(id="email")
	WebElement emailField;
	
	@FindBy(id="password")
	WebElement passwordField;
	
	@FindBy(id="submit")
	WebElement loginSubmit;
	
	@FindBy(id="error")
	WebElement errorMsg;
	
	//constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Verify login with valid details
	public void clickLogin(String email,String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		loginSubmit.click();
	}
	
	public String getValidationMessage() {
        // Explicit wait to ensure error message is visible before fetching text
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        return errorMsg.getText();
    }
    
    public LoginPage loginValidation(String testType,String expectedText) {
    	if(testType.equalsIgnoreCase("InvalidEmailInvalidPassword")) {
    		String actualText=getValidationMessage();
    		System.out.println("Error message:"+actualText);
    		Assert.assertEquals(actualText,expectedText);
    	}
    	else if(testType.equalsIgnoreCase("InvalidEmail")) {
    		String actualText=getValidationMessage();
    		System.out.println("Error message:"+actualText);
    		Assert.assertEquals(actualText,expectedText);
    	}
    	else if(testType.equalsIgnoreCase("InvalidPassword")) {
    		String actualText=getValidationMessage();
    		System.out.println("Error message:"+actualText);
    		Assert.assertEquals(actualText,expectedText);
    	}
    	return this;
    }
    
//	  //check login button is redirected to add user page
    public LoginPage loginBtnRedirection(String email,String password) {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        clickLogin( email, password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            // Check if an error message appears first
            if (errorMsg.isDisplayed()) {
                System.out.println("Login failed: " + errorMsg.getText());
                return this;
            }

            // Wait for URL to change
            boolean isRedirected = wait.until(ExpectedConditions.urlToBe("https://thinking-tester-contact-list.herokuapp.com/" + "contactList"));

            if (isRedirected) {
                System.out.println("URL changed and the page is redirected: Test Passed");
            } else {
                System.out.println("URL did not change and the page is not redirected: Test Failed");
            }
        } catch (Exception e) {
            System.out.println("Page not redirected");
        }

        System.out.println("Current URL after login: " + driver.getCurrentUrl());
        return this;
    }

		  
		  
		  
	  }
	  
	  
  

