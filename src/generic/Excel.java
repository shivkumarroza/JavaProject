package generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static String getData(String xl_path, String sheet, int row, int column)
	{
		String v="";
		Workbook wb;
		try {
			wb=WorkbookFactory.create(new FileInputStream(xl_path));
			v=wb.getSheet(sheet).getRow(row).getCell(column).toString();
		}catch(Exception e)
		{
			
		}
		
		return v;
		
	}
	
	public static int rowCount(String xl_path, String sheet)
	{
		int row_count=0;
		Workbook wb;
		try {
			wb=WorkbookFactory.create(new FileInputStream(xl_path));
			row_count=wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {
		}
		return row_count;
	}
	
	public static int coloumnCount(String xl_path, String sheet, int row)
	{
		int column_Count=0;
		Workbook wb;
		try {
			wb=WorkbookFactory.create(new FileInputStream(xl_path));
			column_Count=wb.getSheet(sheet).getRow(row).getLastCellNum();
		} catch (Exception e) {
		}
		return column_Count;
	}

}
