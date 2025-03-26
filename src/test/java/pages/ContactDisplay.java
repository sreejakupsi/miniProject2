package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basic.ProjectBasicMethods;

public class ContactDisplay extends ProjectBasicMethods {

	
	WebDriver driver;
	@FindBy(xpath="//table/tr")
	List<WebElement> elementCount;
	
	@FindBy(xpath="//table/tr/td[5]")
	List<WebElement> phonenumberElements;
	
	@FindBy(xpath="//table/tr/td[2]")
	List<WebElement> lastNameElements;
	
	public ContactDisplay(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void contactDetailsDisplay() {
		System.out.println("Contact displayed: "+ elementCount.size());
	}
	
	  public boolean isLastNameSorted() {
		// Extract only last names by splitting since index value 2 indicates both firstname and lastname
	        List<String> lastNames = lastNameElements.stream()
	            .map(e -> {
	                String[] splitName = e.getText().split(" ");
	                return splitName.length > 1 ? splitName[1] : ""; 
	            })
	            .collect(Collectors.toList());

	        // Create a sorted copy of last names
	        List<String> sortedLastNames = lastNames.stream()
	            .sorted(String::compareToIgnoreCase)
	            .collect(Collectors.toList());

	        // Compare original and sorted lists
	        boolean isSorted = lastNames.equals(sortedLastNames);

	        System.out.println("Extracted Last Names: " + lastNames);
	        System.out.println("Sorted Last Names: " + sortedLastNames);
	        System.out.println("Check if the last name is sorted: " + isSorted);

	        return isSorted;
	    }
	  
	  public void phonenumberCheck() {
		  for(WebElement phoneElement : phonenumberElements) {
			  String phonenumber=phoneElement.getText().trim();
			  if(phonenumber.startsWith("+91")) {
				  System.out.println("The phone number is valid Indian number :"+ phonenumber);
			  }
			  else {
				  System.out.println("Not a valid number and it doest starts with +91");
			  }
		  }
	  }
}
