package com.db.comparor;

import com.db.entity.SesMilesDriven;

public class CompareRecords {
	//check the four data fields are same or not
	public static boolean check(SesMilesDriven smd1,SesMilesDriven smd2) {
		if(smd1.getCostctrid().equals(smd2.getCostctrid())&&
				smd1.getReporting_pd()==smd2.getReporting_pd()&&
				smd1.getReporting_wk()==smd2.getReporting_wk()&&
				smd1.getAsset_no().equals(smd2.getAsset_no())&&
				smd1.getReporting_yr().equals(smd2.getReporting_yr()))
			return true;
		else
			return false;
		
	}

}
