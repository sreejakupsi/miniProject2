package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basic.ProjectBasicMethods;

public class LogoutPage extends ProjectBasicMethods {
   
	WebDriver driver;
	@FindBy(id="logout")
	WebElement logoutBtn;
	
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void logout() {
		logoutBtn.click();
		System.out.println("Logged out successfully");
	}
}
