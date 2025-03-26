package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basic.ProjectBasicMethods;
import pages.HomePage;
import pages.LoginPage;

public class TC_004Invalidlogin extends ProjectBasicMethods{

	@BeforeTest
	public void setup() {
		sheetname="InvalidLogin";
		testName="InvalidLogin Test";
		testDescription="Testing the login functionality with negative cases";
		testAuthor="Sreeja";
		testCategory="Smoke Testing";
	}
	
	@Test(dataProvider="readData")
	public void invalidLoginText(String email,String password,String testType, String expectedText) {
		HomePage homepage=new HomePage(driver);
		homepage.checkLoginSubmit();
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginBtnRedirection(email, password);
		loginpage.loginValidation(testType, expectedText);
	}
	
}
