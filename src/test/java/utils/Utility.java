package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Utility {

	public static WebDriver driver;
	public String sheetname;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName,testDescription,testCategory,testAuthor;
	
	
	public void browserLaunch() throws IOException {
		driver=new ChromeDriver();
		driver.get("https://thinking-tester-contact-list.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
	}
	
	public void browserClose() {
		driver.quit();
	}
	
	public static String[][] readFromExcel(String sheetname) throws IOException {
	    FileInputStream fil= new FileInputStream("C:\\Users\\Kupsi\\eclipse-workspace\\contact-list\\data\\ContactListDetails.xlsx");
	    try (XSSFWorkbook book = new XSSFWorkbook(fil)) {
	        XSSFSheet sheet = book.getSheet(sheetname);
	        
	        if (sheet == null) {
	            throw new IllegalArgumentException("Sheet " + sheetname + " does not exist in the Excel file.");
	        }

	        int rowCount = sheet.getLastRowNum();
	        short columnCount = sheet.getRow(0).getLastCellNum();
	        
	        String[][] data = new String[rowCount][columnCount];

	        // Iterate through rows and columns
	        for (int i = 0; i < rowCount; i++) { // Start from 0 instead of 1
	            XSSFRow row = sheet.getRow(i + 1); // Skipping the header row
	            if (row == null) continue;

	            for (int j = 0; j < columnCount; j++) { // Start from 0 instead of 1
	                XSSFCell cell = row.getCell(j);
	                data[i][j] = getCellValue(cell); 
	            }
	        }
	        return data;
	    }
	}

	
	 public static String getCellValue(Cell cell) {
	        if (cell == null) {
	            return "";  // Avoid NullPointerException
	        }
	        switch (cell.getCellType()) {
	            case STRING:
	                return cell.getStringCellValue();
	            case NUMERIC:
	                if (DateUtil.isCellDateFormatted(cell)) {
	                    return cell.getDateCellValue().toString(); // Convert date to string
	                } else {
	                    return String.valueOf((long) cell.getNumericCellValue()); // Convert number to string
	                }
	            case BOOLEAN:
	                return String.valueOf(cell.getBooleanCellValue());
	            case FORMULA:
	                return cell.getCellFormula();
	            default:
	                return "";
	        }
	    }
	 	  
	   public static String screenshort(String name) throws IOException {
	    	String path="C:\\Users\\Kupsi\\eclipse-workspace\\contact-list\\screenshort\\"+name+".png";
	    	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	File dest= new File(path);
	    	FileUtils.copyFile(src, dest);
	    	return path;
	    }

}
