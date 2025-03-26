package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.microsoft.schemas.office.visio.x2012.main.TextType;

import basic.ProjectBasicMethods;

public class SignupPage extends ProjectBasicMethods {
	
	WebDriver driver;
	@FindBy(id="firstName")
	WebElement fnameField;
	
	@FindBy(id="lastName")
	WebElement lnameField;
	
	@FindBy(id="email")
	WebElement emailField;
	
	@FindBy(id="password")
	WebElement passwordField;
	
	@FindBy(id="submit")
	WebElement submitFiled;
	
	@FindBy(id="error")
	WebElement errorMsg;
	
	//constructor
    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    
    public void clickSignup(String firstname,String lastname,String email,String password) {
    	fnameField.sendKeys(firstname);
    	lnameField.sendKeys(lastname);
    	emailField.sendKeys(email);
    	passwordField.sendKeys(password);
    	submitFiled.click();
    }
      
    public String getValidationMessage() {
        // Explicit wait to ensure error message is visible before fetching text
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        return errorMsg.getText();
    }
    
    public SignupPage signupValidation(String testType,String expectedText) {
    	if(testType.equalsIgnoreCase("InvalidLastname")) {
    		String actualText=getValidationMessage();
    		System.out.println("InvalidLastName "+actualText);
    		Assert.assertEquals(actualText,expectedText);
    	}
    	else if(testType.equalsIgnoreCase("InvalidFirstname")) {
    		String actualText=getValidationMessage();
    		System.out.println("InvalidFirstname "+actualText);
    		Assert.assertEquals(actualText,expectedText);
    	}
    	else if(testType.equalsIgnoreCase("InvalidEmail")) {
    		String actualText=getValidationMessage();
    		System.out.println("InvalidEmail "+actualText);
    		Assert.assertEquals(actualText,expectedText);
    	}
    	else if(testType.equalsIgnoreCase("InvalidPassword")) {
    		String actualText=getValidationMessage();
    		System.out.println("InvalidPassword "+actualText);
    		Assert.assertEquals(actualText,expectedText);
    	}
    	return this;
    }
  

	
	
}
