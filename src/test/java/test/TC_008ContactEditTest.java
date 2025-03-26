package test;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basic.ProjectBasicMethods;
import pages.ContactEdit;
import pages.LoginPage;

public class TC_008ContactEditTest extends ProjectBasicMethods{


	   @BeforeTest
	    public void setup() {
	        sheetname = "ValidLogin";
	        testName="Contact edit test";
			testDescription="Testing the contact edit functionality with positive cases";
			testAuthor="Sreeja";
			testCategory="Smoke Testing";
	    }

	
	@Test(dataProvider="readData")
	
	public void contactEdit(String email,String password) {
		// Login to the application
        LoginPage loginpage = new LoginPage(driver);
        loginpage.clickLogin(email, password);
        
        //check if the page is redirected to edit page
        ContactEdit contactedit = new ContactEdit(driver);
        contactedit.pageRedirection();
        contactedit.editExistingContent();;
       
       

	}
	
}
