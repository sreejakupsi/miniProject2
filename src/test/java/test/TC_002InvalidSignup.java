package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basic.ProjectBasicMethods;
import pages.HomePage;
import pages.SignupPage;

public class TC_002InvalidSignup extends ProjectBasicMethods {

	@BeforeTest
	public void setup() {
		sheetname="InvalidSignup";
		testName="InvalidSignup Test";
		testDescription="Testing the signup functionality with negative cases";
		testAuthor="Sreeja";
		testCategory="Smoke Testing";
	}
	
	@Test(dataProvider="readData")
	public void invalidSignupTest(String firstname,String lastname,String email,String password,String testType,String expectedText) {
		HomePage obj=new HomePage(driver);
		obj.signupBtnRedirection().clickSignup(firstname, lastname, email, password);
		
		SignupPage signup=new SignupPage(driver);
		signup.signupValidation(testType,expectedText);
	}
}
