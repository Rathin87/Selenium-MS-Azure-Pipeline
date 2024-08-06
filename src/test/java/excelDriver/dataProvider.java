package excelDriver;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {

	//ExcelDatabase db= new ExcelDatabase();

	@Test(dataProvider="ExcelData",dataProviderClass =ExcelDatabase.class)
	public void PracticeExcel(String P1, String P2, String P3, String P4) throws IOException {
		
		
		System.out.println(P1 +P2 + P3+ P4);
	

	}

	
	/*
	 * public Object[][] getData() { Object[][] data = { { "Test1", "Test2", "Test3"
	 * }, { "Test4", "Test5", "Test6" }, { "Test7", "Test8", "Test9" } }; return
	 * data; }
	 */
}
