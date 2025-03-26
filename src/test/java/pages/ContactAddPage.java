package pages;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basic.ProjectBasicMethods;
import bsh.ParseException;

public class ContactAddPage extends ProjectBasicMethods {

	WebDriver driver;
	
	@FindBy(id="add-contact")
	WebElement addcontact;
	
	@FindBy(id="firstName")
	WebElement firstnameField;
	
	@FindBy(id="lastName")
	WebElement lastnameField;
	
	@FindBy(id="birthdate")
	WebElement birthdayField;
	
	@FindBy(id="email")
	WebElement emailField;
	
	@FindBy(id="phone")
	WebElement phoneField;
	
	@FindBy(id="street1")
	WebElement address1Field;
	
	@FindBy(id="street2")
	WebElement address2Field;
	
	@FindBy(id="city")
	WebElement cityField;
	
	@FindBy(id="stateProvince")
	WebElement stateField;
	
	@FindBy(id="postalCode")
	WebElement postalcodeField;
	
	@FindBy(id="country")
	WebElement countryField;
	
	@FindBy(id="submit")
	WebElement submitField;
	
	@FindBy(id="error")
	WebElement errorMsg;
	
	public ContactAddPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void addContact(String fname,String lname,String dob,String email,String phone,String address1,String address2,String city,String state,String postalCode,String country)  {
		addcontact.click();
		firstnameField.sendKeys(fname);
		lastnameField.sendKeys(lname);
		birthdayField.sendKeys(dob);
		emailField.sendKeys(email);
		phoneField.sendKeys(phone);
		address1Field.sendKeys(address1);
		address2Field.sendKeys(address2);
		cityField.sendKeys(city);
		stateField.sendKeys(state);
		postalcodeField.sendKeys(postalCode);
		countryField.sendKeys(country);
		submitField.click();
	}
	
	

	
	public String getValidationMessage() {
        // Explicit wait to ensure error message is visible before fetching text
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        return errorMsg.getText();
    }
	
    
    public ContactAddPage contactValidation(String testType,String expectedText) {
    	if(testType.equalsIgnoreCase("InvalidLastname")) {
    		String actualText=getValidationMessage();
    		System.out.println("Error message:"+actualText);
    		Assert.assertEquals(actualText,expectedText);
    	}
    	else if(testType.equalsIgnoreCase("InvalidFirstname")) {
    		String actualText=getValidationMessage();
    		System.out.println("Error message:"+actualText);
    		Assert.assertEquals(actualText,expectedText);
    	}
    	else if(testType.equalsIgnoreCase("InvalidEmail")) {
    		String actualText=getValidationMessage();
    		System.out.println("Error message:"+actualText);
    		Assert.assertEquals(actualText,expectedText);
    	}
    	else if(testType.equalsIgnoreCase("InvalidDOB")) {
    		String actualText=getValidationMessage();
    		System.out.println("Error message:"+actualText);
    		Assert.assertEquals(actualText,expectedText);
    	}
    	else if(testType.equalsIgnoreCase("EmptyFields")) {
    		String actualText=getValidationMessage();
    		System.out.println("The app doesnt allows  to save empty fields");
    		Assert.assertEquals(actualText,expectedText);
    	}
    	return this;
    }
    
    
    
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  