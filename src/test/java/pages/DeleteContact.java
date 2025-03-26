package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basic.ProjectBasicMethods;

public class DeleteContact extends ProjectBasicMethods{

	WebDriver driver;
	
	@FindBy(id="delete")
	WebElement deleteBtn;
	
	@FindBy(xpath="//table/tr")
	List<WebElement> elementCount;
	  
	public DeleteContact(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void contentCount() {
	
	    List<WebElement> elements = driver.findElements(By.xpath("//table/tr")); // Fetch dynamically
	    System.out.println("Contact displayed before deleting: " + elements.size());
	}

	public Alert deleteContent() {   
	    deleteBtn.click();
	    
	    Alert alert = driver.switchTo().alert();
	    String alertMsg = alert.getText();
	    System.out.println("Alert message after deleting the content: " + alertMsg);
	    alert.accept();

	    List<WebElement> elementsAfterDelete = driver.findElements(By.xpath("//table/tr")); // Fetch dynamically again
	    System.out.println("Contact displayed after deleting a content: " + elementsAfterDelete.size());
	    
	    return alert;
	}

}
