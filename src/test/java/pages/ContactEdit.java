package pages;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basic.ProjectBasicMethods;

public class ContactEdit extends ProjectBasicMethods {

    WebDriver driver;

    @FindBy(xpath = "//table/tr/td[2]")
    List<WebElement> nameElement;
    
    @FindBy(id="edit-contact")
    WebElement editContentBtn;
    
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
	
	@FindBy(id="contactDetails")
	WebElement displayDetails;

    public ContactEdit(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void pageRedirection() {
        if (!nameElement.isEmpty()) { // Ensure the list is not empty
            WebElement firstElement = nameElement.get(0); // Get the first element

            if (firstElement.isDisplayed() && firstElement.isEnabled()) {
                System.out.println("The first element is visible and clickable.");
                firstElement.click();
                System.out.println("Page redirection initiated.");

                // Optional: Check if redirection is successful
                if (driver.getCurrentUrl().contains("contactDetails")) { 
                    System.out.println("Redirection successful.");
                } else {
                    System.out.println("Redirection might have failed.");
                }
            } 
            
            else {
            	System.out.println("The first element is NOT visible and clickable");
            }
        } 
    }
    
    
    

    
    
    public void existingContentIsDisplayed() {
    	editContentBtn.click();
    	Map<String,WebElement> fields= new LinkedHashMap<String, WebElement>();
    	 fields.put("First Name", firstnameField);
         fields.put("Last Name", lastnameField);
         fields.put("DOB", birthdayField);
         fields.put("Email", emailField);
         fields.put("Phone Number", phoneField);
         fields.put("Address 1", address1Field);
         fields.put("Address 2", address2Field);
         fields.put("City", cityField);
         fields.put("State", stateField);
         fields.put("Postal Code", postalcodeField);
         fields.put("Country", countryField);
         
         for(Map.Entry<String,WebElement> field :fields.entrySet()) {
        	 WebElement element=field.getValue();
        	 String fieldName=field.getKey();
        	 
        	 if(element.isDisplayed()&& element.isEnabled()) {
        		 System.out.println(fieldName +" is displayed and can be edited");
        	 }
        	 else {
        		 System.out.println(fieldName +" is NOT displayed and cannot be edited");
        	 }
         }
    }
    
 public void currentDetails() {
    	
    	Map<String,WebElement> fields= new LinkedHashMap<String, WebElement>();
   	 	fields.put("First Name", firstnameField);
        fields.put("Last Name", lastnameField);
        fields.put("DOB", birthdayField);
        fields.put("Email", emailField);
        fields.put("Phone Number", phoneField);
        fields.put("Address 1", address1Field);
        fields.put("Address 2", address2Field);
        fields.put("City", cityField);
        fields.put("State", stateField);
        fields.put("Postal Code", postalcodeField);
        fields.put("Country", countryField);
        
        
        System.out.println("Current details before editing city field:");
        for (Map.Entry<String, WebElement> field : fields.entrySet()) {
            String fieldName = field.getKey();
            String fieldValue = field.getValue().getAttribute("value");
            System.out.println(fieldName + ": " + fieldValue);
        }   
    }
 
 
    
    public void editExistingContent() {
    	editContentBtn.click();
    	existingContentIsDisplayed();
    	
    	
    	currentDetails();
    	
    	
    	String currentCity=cityField.getAttribute("value");
    	System.out.println("Current city:"+currentCity);
    	
    	if(currentCity.equalsIgnoreCase("Coimbatore")) {
    		cityField.clear();
    		cityField.sendKeys("Hydrabad");
    		System.out.println("The city field is edited ");
    	}
    	else {
    		System.out.println("The city field cannot be edited");
    	}
    	submitField.click();
    	System.out.println("The changes are updated");
    }
    
    

    
    



    }
