package com.db.convertor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.entity.SesMilesDriven;
import com.db.helper.DBConnection;
import com.db.helper.Queries;

public class DataBaseList {

	static List<SesMilesDriven> dbList = new ArrayList<>();
	//converts all the records from database table to list objects
	public static List<SesMilesDriven> getDatabaseList() throws Exception{

		Connection con = DBConnection.getCon();
		PreparedStatement ps = con.prepareStatement(Queries.SELECT);
		ResultSet rs = ps.executeQuery();
		SesMilesDriven smd = null;
		while(rs.next()) {
			smd = new SesMilesDriven();
			smd.setCostctrid(rs.getString(1));
			smd.setMiles_driven(rs.getDouble(2));
			smd.setReporting_yr(rs.getString(3));
			smd.setReporting_pd(rs.getInt(4));
			smd.setReporting_wk(rs.getInt(5));
			smd.setSource_system(rs.getString(6));
			smd.setSes_load_dt(rs.getDate(7)); 
			smd.setAsset_no(rs.getString(8));
			smd.setRea_date(rs.getDate(9));
			smd.setReading(rs.getDouble(10));
			smd.setMiles_driven_orig(rs.getDouble(11));
			dbList.add(smd);
		}//end of loop
		return dbList;
	}//end of method

}
