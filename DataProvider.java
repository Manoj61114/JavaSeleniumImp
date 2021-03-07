package Selenium_Program_Class;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataProvider {
	//static String sheetname = "PKB Details";
	//static String filePath = "D:\\Gopal Kumawat Rewasa.xlsx";
	static FileInputStream file1; 
	
		
	@Test
	public void test() throws Exception {
		File file = new File("D:\\\\Gopal Kumawat Rewasa.xlsx");
		file1 = new FileInputStream(file);		
		XSSFWorkbook book = new XSSFWorkbook(file1);
		XSSFSheet sheet = book.getSheet("Payment Details");
			
		int rowCount = sheet.getLastRowNum();
		System.out.println("Row Count : "+rowCount);
		int colCount = sheet.getRow(0).getLastCellNum();
		System.out.println("ColCount : "+colCount);
		
		
		for(int i =0;i<rowCount; i++) {
			
			for(int j = 0; j<colCount;j++) {
				
				Object obj = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(obj);
				
			}
			
		}
		
		
		System.out.println("Run Test method");
		
	}
}

