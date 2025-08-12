package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelFileDataReader {
	public XSSFWorkbook xssfWorkbook;
	Object data[][]=null;
	@DataProvider(name="TestData")
	public Object readData()
	{
		File file=new File(System.getProperty("user.dir") +"\\TestData\\InvalidCredentials.xlsx" );
		try
		{
			FileInputStream fileInputStream=new FileInputStream(file);
			xssfWorkbook=new XSSFWorkbook(fileInputStream);
			int rows=xssfWorkbook.getSheet("Sheet1").getPhysicalNumberOfRows();
			int cols=xssfWorkbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells();
			data=new Object[rows-1][cols];
			for(int i=1;i<rows;i++)
			{
				for(int j=0;j<cols;j++)
				{
					data[i-1][j]=xssfWorkbook.getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue();
				}
			}
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			System.out.println("File not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		return data;
	}
}
