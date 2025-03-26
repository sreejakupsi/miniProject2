package test;

import java.text.ParseException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basic.ProjectBasicMethods;
import pages.ContactAddPage;
import pages.HomePage;
import pages.LoginPage;
import utils.Utility;

public class TC_005AddValidContact extends ProjectBasicMethods {

    @BeforeTest
    public void setup() {
        sheetname = "ValidContact";
        testName="Add valid contact";
		testDescription="Testing the add contact functionality with positive cases";
		testAuthor="Sreeja";
		testCategory="Smoke Testing";
    }

    @Test(dataProvider = "readData")
    public void addValidContact(String email, String password, String fname, String lname, String dob, 
                                String addemail, String phone, String address1, String address2, 
                                String city, String state, String postalCode, String country)  {
        
    

        // Login to the application
        LoginPage loginpage = new LoginPage(driver);
        loginpage.clickLogin(email, password);

        // Pass informations
        ContactAddPage contactaddpage = new ContactAddPage(driver);
        contactaddpage.addContact(fname, lname, dob, addemail, phone, address1, address2, city, state, postalCode, country);
    }
}
