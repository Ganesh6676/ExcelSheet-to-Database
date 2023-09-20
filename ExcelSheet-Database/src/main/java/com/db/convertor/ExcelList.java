package com.db.convertor;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.db.entity.SesMilesDriven;
import com.db.helper.DateConverter;

public class ExcelList {

	public static List<SesMilesDriven> excelList = new ArrayList<>();
	//converts all the records from Excel sheet to list objects
	public static List<SesMilesDriven> getExcelList() throws Exception{	
		Set<SesMilesDriven> uniqueList = new HashSet<>();
		File file = new File("C:\\Users\\HP\\Downloads\\test.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheetAt(0);
		Row row = null;		
		int i=1;
		SesMilesDriven smd = null;
		while(sheet.getRow(i)!=null) {
			smd = new SesMilesDriven();
			row = sheet.getRow(i);
			
			if(row.getCell(0)==null)
			{
				break;
			}
			Cell c0=row.getCell(0);
			Cell c1=row.getCell(1);
			Cell c2=row.getCell(2);
			Cell c3=row.getCell(3);
			Cell c4=row.getCell(4);
			Cell c5=row.getCell(5);
			Cell c6=row.getCell(6);
			Cell c7=row.getCell(7);
			Cell c8=row.getCell(8);
			Cell c9=row.getCell(9);
			Cell c10=row.getCell(10);

			String costCtrId=null;
			if((c0==null))
				costCtrId="NULL";
			else
				if(c0.getCellType().toString().equals("STRING"))
					costCtrId = c0.getStringCellValue();
				else
					costCtrId = String.valueOf((int)c0.getNumericCellValue()); 


			smd.setCostctrid(costCtrId.trim());
			smd.setMiles_driven((double)c1.getNumericCellValue());
			smd.setReporting_yr(String.valueOf((int)c2.getNumericCellValue()).trim());
			smd.setReporting_pd((int)c3.getNumericCellValue());
			smd.setReporting_wk((int)c4.getNumericCellValue());
			smd.setSource_system(c5.getStringCellValue().trim());
			String date = String.valueOf(c6.getDateCellValue());
			Date dbdate =  new DateConverter().getDate(date);
			smd.setSes_load_dt(new java.sql.Date(dbdate.getTime()));
			
			
			
			if(c0.getCellType().toString().equals("STRING"))
				smd.setAsset_no(c7.getStringCellValue().trim());
			else
				smd.setAsset_no(String.valueOf((int)c0.getNumericCellValue())); 
			
			String date1 = c8.getStringCellValue();
			if(!date1.equals("NULL") ) {
				Date dbdate1 =  new DateConverter().getDate(date1);
				smd.setRea_date(new java.sql.Date(dbdate1.getTime()));
			}
			else {
				smd.setRea_date(null);
			}
			if(!date1.equals(c9.getStringCellValue()) )
				smd.setReading((Double.parseDouble(c9.getStringCellValue())));
			else
				smd.setReading(0.0);;
				if(!date1.equals(c10.getStringCellValue()))
					smd.setMiles_driven_orig((Double.parseDouble(c10.getStringCellValue())));
				else
					smd.setMiles_driven_orig(0.0);
				uniqueList.add(smd);
				i++;
		}//end of while loop
		excelList.addAll(uniqueList);
		return excelList;
	}//end of method
}
