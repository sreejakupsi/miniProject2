package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import basic.ProjectBasicMethods;
import pages.ContactAddPage;
import pages.HomePage;
import pages.SignupPage;




public class TC_001ValidSignup extends ProjectBasicMethods {
	

	
	@BeforeTest
	public void setup() {
		sheetname="ValidSignup";
		testName="Signup Test";
		testDescription="Testing the signup functionality with positive cases";
		testAuthor="Sreeja";
		testCategory="Smoke Testing";
	}
	
	
	
	@Test(dataProvider="readData")
	public void validSignupTest(String firstname,String lastname,String email,String password) {
		HomePage obj=new HomePage(driver);
		obj.checkSignup();
		obj.signupBtnRedirection().clickSignup( firstname, lastname,email,password);
		

		
		
		
	}
}
