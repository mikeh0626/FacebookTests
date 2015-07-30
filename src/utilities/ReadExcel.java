package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class ReadExcel {

	private static XSSFWorkbook t ;
	private static XSSFSheet sheet;
	private static File file;
	private static XSSFCell Cell;

	
	/*
	 * @IOException thrown
	 * 	must catch explictly
	 */
	
	public static Object[][] ReadExcesl(String fileP) throws Exception{
		String[][] resultSet = null;
		try{	
			file = new File("C:\\Users\\mikeh_000\\Desktop\\java\\ATTTestSuit\\src\\utilities\\Book1.xlsx");
			//create input stream to input 
			FileInputStream excelFile = new FileInputStream(file);

			//get Workbook
			t = new XSSFWorkbook(excelFile);
		
			sheet = t.getSheetAt(0);
			
			int startRow = 1;
			int startCol = 1;
			int ci, cj;

			
			int totalRows = sheet.getLastRowNum();
			int totalCol = 2;
			
			resultSet = new String[totalRows][totalCol];

			
			ci=0;
			for(int i = startRow; i<= totalRows; i++, ci++)
			{
				cj=0;
				for(int j = startCol; j <= startCol; j++, cj++){
				resultSet[ci][cj]= getCellData(ci,cj);
				System.out.println(resultSet[ci][cj]);
				}
			}
			System.out.println("rows="+totalRows);
		}catch(Exception e){
			e.printStackTrace();
		}
		return(resultSet);
	}
	
	public static String getCellData(int RowNum, int ColNum){
		Cell = sheet.getRow(RowNum).getCell(ColNum);
		int dataType = Cell.getCellType();
		System.out.println(dataType);
		return "";
	}
}
