package ECommerce.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadUnamePwdFromExcel {
DataFormatter formatter=new DataFormatter();
@Test(dataProvider = "readfromexcel")
public void ReadFromExcel(String Email, String Password) {
	System.out.println(Email+" "+Password);
}

@DataProvider(name="readfromexcel")
public Object[][] getData() throws IOException {
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\ECommerce\\data\\MOCK_DATA.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fis); //get path to excel file
	XSSFSheet sheet=workbook.getSheetAt(0); //locate sheet that contains data to be read
	int rowCount=sheet.getPhysicalNumberOfRows(); //total rows
	XSSFRow r=sheet.getRow(0); //get first row in r
	int colCount=r.getLastCellNum(); //total columns in rth row
	
	Object data[][]=new Object[rowCount-1][colCount]; //create a data object to return from data provider 
	
	for(int i=0;i<rowCount-1;i++) {
		XSSFRow row=sheet.getRow(i+1);
		for(int j=0;j<colCount;j++) {
			XSSFCell cell=row.getCell(j);
			
			data[i][j]=formatter.formatCellValue(cell);
		} //end of inner for loop
	} //end of outer for loop
	
	return data;
}
}
