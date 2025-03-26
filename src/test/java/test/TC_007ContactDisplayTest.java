package test;

import java.text.ParseException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basic.ProjectBasicMethods;
import pages.ContactAddPage;
import pages.ContactDisplay;
import pages.LoginPage;
import utils.Utility;

public class TC_007ContactDisplayTest extends ProjectBasicMethods {

	
	   @BeforeTest
	    public void setup() {
	        sheetname = "ValidLogin";
	        testName="Contact display test";
			testDescription="Testing the contact display functionality with positive cases";
			testAuthor="Sreeja";
			testCategory="Smoke Testing";
	    }

	
	@Test(dataProvider="readData")
	
	public void contactDisplay(String email,String password)  {
		 

        // Login to the application
        LoginPage loginpage = new LoginPage(driver);
        loginpage.clickLogin(email, password);


        
		ContactDisplay contactdisplay=new ContactDisplay(driver);
		contactdisplay.contactDetailsDisplay();
		contactdisplay.isLastNameSorted();
		contactdisplay.phonenumberCheck();
	}
}
