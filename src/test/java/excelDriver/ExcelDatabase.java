package excelDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDatabase {
	DataFormatter df = new DataFormatter();

	
	@DataProvider(name = "ExcelData")
	public Object[][] Getdata() throws IOException {
		ArrayList<String> ar = new ArrayList<String>();
		String testDataFile  = System.getProperty("user.dir");
		//File src = new File(testDataFile)
		FileInputStream Fis = new FileInputStream(testDataFile+"\\ExcelHandlling.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(Fis);
		XSSFSheet sheetname = book.getSheetAt(0);
		int rowCount = sheetname.getPhysicalNumberOfRows();
		XSSFRow row = sheetname.getRow(0);
		int colcount = row.getLastCellNum();
		Object data[][] = new Object[rowCount - 1][colcount];
		for (int i = 0; i < colcount; i++) {
			row = sheetname.getRow(i + 1);
			System.out.println("Value of Row is " + row );
			for (int j = 0; j < colcount; j++) {
				if (row != null) {
					// Access cells safely
					XSSFCell cell = row.getCell(j);
					data[i][j] = df.formatCellValue(cell);
				}

				// Further processing
				else
					// Handle case where row is null
					System.out.println("Null is displaying which is not expected");
					System.out.println("Row is null");

			}
			
		}
		return data;
	}
}
	


