package com.db;

import java.util.List;

import com.db.convertor.DataBaseList;
import com.db.convertor.ExcelList;
import com.db.dboperators.InsertOperation;
import com.db.dboperators.UpdateOperation;
import com.db.divider.InsertAndUpdateDivider;
import com.db.entity.SesMilesDriven;
import com.db.excel.ExcelSheetGenerator;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	
    	
       List<SesMilesDriven> xlList =  ExcelList.getExcelList();
       List<SesMilesDriven> dbList = DataBaseList.getDatabaseList();
       System.out.println(InsertAndUpdateDivider.divideRecords(xlList, dbList));
       List<SesMilesDriven> updateList = InsertAndUpdateDivider.getUpdateList(); 
       List<SesMilesDriven> insertList = InsertAndUpdateDivider.getInsertList();
       
       UpdateOperation.updateRecords(updateList);
       InsertOperation.insertRecords(insertList);
       
       String updateStatus = ExcelSheetGenerator.generatePdf(updateList, "Updated_Records");
       System.out.println(updateStatus);
       
       String insertStatus = ExcelSheetGenerator.generatePdf(insertList, "Inserted_Records");
       System.out.println(insertStatus);
       System.out.println("End of Execution - completed successfully.");
    	
    }
}
