package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basic.ProjectBasicMethods;
import pages.LoginPage;
import pages.LogoutPage;

public class TC_010LogoutTest extends ProjectBasicMethods {

	   @BeforeTest
	    public void setup() {
	        sheetname = "ValidLogin";
	        testName="Logout Test";
			testDescription="Testing the logout functionality with positive cases";
			testAuthor="Sreeja";
			testCategory="Smoke Testing";
	    }

	   
	   @Test(dataProvider="readData")
	   public void logoutTest(String email,String password) {
		   //login to the application
		   LoginPage loginpage= new LoginPage(driver);
		   loginpage.clickLogin(email,password);
		   
		   //logout the application
		   LogoutPage logout=new LogoutPage(driver);
		   logout.logout();
	   }
}

