package basic;
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.Utility;

public class ProjectBasicMethods extends Utility {

	@BeforeSuite
	public void reportInitialization() {
		
		
		//to create report in the given location
		ExtentSparkReporter reporter= new ExtentSparkReporter("C:\\Users\\Kupsi\\eclipse-workspace\\contact-list\\reports\\ContactListReporter.html");
		reporter.config().setReportName("Contact list report");
		
		//to capture the test data
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		
		
	}
	
	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}
	
	@BeforeMethod
	public void launchBrowser() throws IOException{
		browserLaunch();
	}
	
	@AfterMethod
	public void closeBrowser() {
		browserClose();
	}
	
	   @DataProvider(name="readData")
	    public String[][] readData() throws IOException {
	    	String [] [] data=readFromExcel(sheetname);
	    	return data;
	    }
	
	   @AfterSuite
	   public void reportClose() {
		   extent.flush();//manatory to close the report else it results in error
	   }
}
