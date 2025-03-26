package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basic.ProjectBasicMethods;
import pages.HomePage;
import pages.LoginPage;

public class TC_003ValidLogin extends ProjectBasicMethods {

	@BeforeTest
	public void setup() {
		sheetname="ValidLogin";
		testName="Login Test";
		testDescription="Testing the login functionality with positive cases";
		testAuthor="Sreeja";
		testCategory="Smoke Testing";
	}
	
	@Test(dataProvider="readData")
	public void validLoginTest(String email,String password) {
		HomePage homepage=new HomePage(driver);
		homepage.checkLoginSubmit();
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginBtnRedirection(email, password);
	}
}
