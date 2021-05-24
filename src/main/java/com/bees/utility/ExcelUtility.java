package com.bees.utility;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public static ArrayList<String> getExcelTableData(String fileNm,String sheetNm)throws Exception{
		ArrayList<String> expData=new ArrayList<String>();
		
		String path=System.getProperty("user.dir")+"/src/test/resources/"+fileNm;
		String value=null;
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetNm);
		int row=sh.getPhysicalNumberOfRows();
		for (int i = 0; i < row; i++) 
		{
			int col=sh.getRow(i).getLastCellNum();
			for (int j = 0; j <col; j++) 
			{
				Cell cell=sh.getRow(i).getCell(j);
				DataFormatter df=new DataFormatter();
				value=df.formatCellValue(cell);
				expData.add(value);
				System.out.print("    "+value);
			}
			System.out.println();
		}
		return expData;
	}
	
	
	public static ArrayList<String> getColumnData(String fileNm,String sheetNm,int colNo)throws Exception{
		ArrayList<String> expData=new ArrayList<String>();
		String value=null;
		String path=System.getProperty("user.dir")+"/src/test/resources/"+fileNm;
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetNm);
		int row=sh.getPhysicalNumberOfRows();
		for (int i =0; i <row; i++) 
		{
			Cell cell=sh.getRow(i).getCell(colNo);
				DataFormatter df=new DataFormatter();
				value=df.formatCellValue(cell);
				expData.add(value);
				System.out.println(value);
		}
		return expData;
	}

public static ArrayList<String> getDataOfAnyColumn(String fileNm,String sheetNm,int colNo)throws Exception{
	ArrayList<String> expData=new ArrayList<String>();
	String path=System.getProperty("user.dir")+"/src/test/resources/"+fileNm;
	String value=null;
	FileInputStream fis = new FileInputStream(path);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetNm);
	int row=sh.getPhysicalNumberOfRows();
	
	for (int i = 0; i < row; i++) 
	{
		int col=sh.getRow(i).getLastCellNum();
		for (int j = 0; j <col; j++) 
		{
			Cell cell=sh.getRow(i).getCell(colNo);
			DataFormatter df=new DataFormatter();
			value=df.formatCellValue(cell);
			expData.add(value);
		}
	}
	return expData;
}
}
