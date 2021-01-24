package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class excelGetData {
	public WebDriver driver;
	
	
	 
	public excelGetData() {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public ArrayList<String> getData(String Filepath,String Testcase) throws IOException  {
		ArrayList<String> Data= new ArrayList<String>();
		DataFormatter formatter = new DataFormatter(Locale.US);
		FileInputStream fis=new FileInputStream(Filepath);
		XSSFWorkbook wb =new XSSFWorkbook(fis);
		int sheets=wb.getNumberOfSheets();
		
		for(int i=0;i<sheets;i++)
		{
			if(wb.getSheetName(i).equalsIgnoreCase("Registration"))
			{
			XSSFSheet sheet =wb.getSheetAt(i);
			Iterator<Row> row =sheet.iterator();
			Row firtsrow=row.next();// getting the access to the first row
			Iterator<Cell> cell=firtsrow.cellIterator();//iterating throgh the first row's cell value using iterator
			int column=0;
			int k=0;
			while(cell.hasNext())
			{
				Cell value=cell.next();//moved to the column title
				
				if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
				{
					column=k;
				}
				k++;
			}
			System.out.println(column);
			while(row.hasNext())
			{
				Row r=row.next();
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase(Testcase))
				{
				Iterator<Cell> cv=r.cellIterator();
				
				while(cv.hasNext()) {
					
					//have to verify whther the cell value is string or not
				Cell c1=cv.next();
				if(c1.getCellTypeEnum()==CellType.STRING) {
					Data.add(cv.next().getStringCellValue());
					}
				else {
					//if its number then we are getting the no value and converting to string
					Data.add(NumberToTextConverter.toText(c1.getNumericCellValue()));
					
				}
				}
				}
			}
			}
		}
		
		
return Data;

	}

}
