package filereading;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readingoperation {

	
	@SuppressWarnings("unlikely-arg-type")
	public static  String reading(String value) {
		
		try {
			XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\SausthavNegi\\eclipse-workspace\\Verse\\Mail.xlsx");
			XSSFSheet spreadsheet = workbook.getSheet("Mail");
			
			Row firstrow = spreadsheet.getRow(0);
	        Row seconrow = spreadsheet.getRow(1);
	        
	        	        
	        int mincol =firstrow.getFirstCellNum();
	        int maxcol =firstrow.getLastCellNum();
			
	        Cell cell;
	        
	        for(int i=0; i<maxcol;i++) {
	        	
	        	if(value.equalsIgnoreCase(firstrow.getCell(i).toString())){
	        	cell =firstrow.getCell(i);
	        	if(cell!=null) 
	        		System.out.println(cell+"\t");
	        	
	        	cell=seconrow.getCell(i);
	        	if(cell!=null)
	        		System.out.println(cell+"\t");
	        	String cells=cell.toString();
	        	return cells;
	        	
	        	}
	      	        	
	        }
	        
		}catch(Exception e) {
			System.out.println("Exception : "+e);
			System.out.println("Exception in excel reading");
			
		}
		
		return "NA";	
	}
	
	
	
	
}
