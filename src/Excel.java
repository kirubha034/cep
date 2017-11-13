

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Excel {
		
	
	@Test(dataProvider="empLogin")
	public void test(String name, String ciscoAttendee, String s, String r, String t, String e, String y, String h, String o,String k, String l, String m){
		System.out.println("jjjjjj");
	}
	
	
	@DataProvider(name="empLogin")
	public Object[][] loginData() {
		Object[][] arrayObject = getExcelData("C:\\Users\\kirajama\\Desktop/Object.xlsx","Data");
		return arrayObject;
	}
	
	//String fileName="C:\\Users\\kirajama\\Desktop/Object.xlsx";
	
	String[][] arrayExcelData = null;
	
	
	public String[][] getExcelData(String fileName, String sheetName) {
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = WorkbookFactory.create(fs);
			Sheet sh = wb.getSheet(sheetName);

			int  totalNoOfRows= sh.getLastRowNum();
			int totalNoOFColms=sh.getRow(1).getLastCellNum();
			System.out.println(totalNoOfRows);
			System.out.println(totalNoOFColms);
			arrayExcelData = new String[totalNoOfRows][totalNoOFColms];
			
			for (int i= 0 ; i < totalNoOfRows; i++) {
				for (int j=0; j < totalNoOFColms; j++) {
					arrayExcelData[i][j] = sh.getRow(i).getCell(j).toString();
				}

			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}
}
