package ECommerce.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.cms.CMSVerifierCertificateNotValidException;

public class dataDrivenUsingExcel {
	

public ArrayList<String> getData(String testModuleName) throws IOException {
	ArrayList<String> a=new ArrayList<String>();
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\ECommerce\\data\\testData.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	int noOfSheets=workbook.getNumberOfSheets();
	for(int i=0;i<noOfSheets;i++) {
		if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
			XSSFSheet sheet=workbook.getSheetAt(i);
			Iterator<Row> rows=sheet.iterator();   //sheet is collection of rows
			Row firstRow=rows.next();
			Iterator<Cell> cell=firstRow.cellIterator();  //row is collection of cells
			int k=0;
			int column=0;
			while(cell.hasNext()) {
				Cell value=cell.next();
				if(value.getStringCellValue().equalsIgnoreCase("TestModules")) {
					column=k;
				} //end of if
				k++;
			} //end of while
			System.out.println(column);
			while(rows.hasNext()) {
				Row r=rows.next();
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testModuleName)) {
					Iterator<Cell> cv=r.cellIterator();
					while(cv.hasNext()) {
						Cell c=cv.next();
						if(c.getCellType()==CellType.STRING) {
							a.add(c.getStringCellValue());
						}
						else {
							a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						}
						
					}
						
					
				}//end of if
			} //end of while
			
		} //end of if
	
	} //end of for
	return a;
	

}



	public static void main(String[] args) throws IOException {
	}
	}
		

