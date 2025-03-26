package test;

import java.text.ParseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import basic.ProjectBasicMethods;
import pages.ContactAddPage;
import pages.LoginPage;


public class TC_006AddInvalidContact extends ProjectBasicMethods {

    @BeforeTest
    public void setup() {
        sheetname = "InvalidContact";
        testName="Add invalid contact";
        testDescription="Testing the add contact functionality with negative cases";
        testAuthor="Sreeja";
        testCategory="Smoke Testing";
    }

    @Test(dataProvider = "readData")
    public void addInvalidContact(String email, String password, String fname, String lname, String dob,
                                  String addemail, String phone, String address1, String address2, String city, 
                                  String state, String postalCode, String country, String testType, 
                                  String expectedText) throws ParseException {



        // Login into the application
        LoginPage loginpage = new LoginPage(driver);
        loginpage.clickLogin(email, password);

        // Add invalid contact
        ContactAddPage contactaddpage = new ContactAddPage(driver);
        contactaddpage.addContact(fname, lname, dob, addemail, phone, address1, address2, city, state, postalCode, country);
        contactaddpage.contactValidation(testType, expectedText);
    }

 
}
