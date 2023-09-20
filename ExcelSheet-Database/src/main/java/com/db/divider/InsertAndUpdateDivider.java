package com.db.divider;

import java.util.ArrayList;
import java.util.List;

import com.db.comparor.CompareRecords;
import com.db.entity.SesMilesDriven;

public class InsertAndUpdateDivider {

	private static List<SesMilesDriven> updateList = new ArrayList<>();
	private static List<SesMilesDriven> insertList = new ArrayList<>();
    //divide all the excel sheet objects into insert list and update list
	public static String divideRecords(List<SesMilesDriven> excelList,List<SesMilesDriven> dbList) {
		for(SesMilesDriven smd1:excelList) {
			boolean foundMatch=false;
			for(SesMilesDriven smd2:dbList) {
				if(CompareRecords.check(smd1, smd2)) {
					updateList.add(smd1);
					foundMatch=true;
					break;
				}
			}//end of inner loop
			if(!foundMatch)
				insertList.add(smd1);
		}//end of outer loop
		
		return updateList.size()+" records needs Updation.\n"+insertList.size()+" records needs Insertion.";
		
	}//end of method

	public static List<SesMilesDriven> getUpdateList() {
		return updateList;
	}

	public static List<SesMilesDriven> getInsertList() {
		return insertList;
	}
	
}
