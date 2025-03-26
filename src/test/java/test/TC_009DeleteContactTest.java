package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basic.ProjectBasicMethods;
import pages.ContactEdit;
import pages.DeleteContact;
import pages.LoginPage;

public class TC_009DeleteContactTest extends ProjectBasicMethods {

	
	   @BeforeTest
	    public void setup() {
	        sheetname = "ValidLogin";
	        testName="Delete contact Test";
			testDescription="Testing the delete contact functionality with positive cases";
			testAuthor="Sreeja";
			testCategory="Smoke Testing";
	    }

	   @Test(dataProvider="readData")
	   public void deleteContent(String email,String password) {
			// Login to the application
	        LoginPage loginpage = new LoginPage(driver);
	        loginpage.clickLogin(email, password);
	        
	        DeleteContact deletecontent=new DeleteContact(driver);
	        deletecontent.contentCount();
	        
	        ContactEdit contactedit = new ContactEdit(driver);
	        contactedit.pageRedirection();
	        
	   
	        deletecontent.deleteContent();
	        
	   }
}
