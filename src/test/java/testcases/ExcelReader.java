package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader
{
	public static Object[][] ReadTestData(String filePath, String fileName, String sheetName) throws IOException
	{
		Object[][] data;
		
		FileInputStream fin = new FileInputStream(new File(filePath+"/"+fileName));
		
		Workbook testData = new XSSFWorkbook(fin);
		Sheet sheet = testData.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		data = new Object[rowCount][1];
		
		Hashtable<String, String> rec;
		Row keyRow = sheet.getRow(0);
		
		for(int r = 1; r <= rowCount; r++)
		{
			rec = new Hashtable<String, String>();
			Row dataRow = sheet.getRow(r);
			
			for(int c = 0; c < dataRow.getLastCellNum(); c++)
			{
				String key = keyRow.getCell(c).getStringCellValue();
				String value = dataRow.getCell(c).getStringCellValue();
				rec.put(key, value);
			}
			data[r-1][0] = rec;
		}
		testData.close();
		return data;
	}
}

