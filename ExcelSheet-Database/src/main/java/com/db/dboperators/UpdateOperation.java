package com.db.dboperators;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.db.entity.SesMilesDriven;
import com.db.helper.DBConnection;
import com.db.helper.Queries;

public class UpdateOperation {
	
	private static int k = 0;
	//update all the update record objects to database table with batch size of 1000
	public static void updateRecords(List<SesMilesDriven> updateRecords) throws Exception {
		
		Connection con = DBConnection.getCon();
		PreparedStatement psUpdate = con.prepareStatement(Queries.UPDATE);
		
		int batchSize = 1000;
		int count = 0;
		
		for(SesMilesDriven smd:updateRecords) {
			psUpdate.setString(7, smd.getCostctrid());
			psUpdate.setDouble(1, smd.getMiles_driven());
			psUpdate.setString(8, smd.getReporting_yr());
			psUpdate.setInt(9, smd.getReporting_pd());
			psUpdate.setInt(10, smd.getReporting_wk());
			psUpdate.setString(2, smd.getSource_system());
			psUpdate.setDate(3, smd.getSes_load_dt());
			psUpdate.setString(11, smd.getAsset_no());
			psUpdate.setDate(4, smd.getRea_date());
			psUpdate.setDouble(5, smd.getReading());
			psUpdate.setDouble(6, smd.getMiles_driven_orig());
			 // Add the current statement to the batch
	        psUpdate.addBatch();
	        
	        count++;

			if (count % batchSize == 0) {
				// Execute the batch update
				int[] updateCounts = psUpdate.executeBatch();

				// Calculate the total updated records count
				for (int updateCount : updateCounts) {
					k += updateCount;
				}

				// Clear the batch
				psUpdate.clearBatch();
			}
	        
	    } // end of for loop

		// Execute the remaining batch (if any)
	    int[] updateCounts = psUpdate.executeBatch();

	    // Calculate the total updated records count
	    for (int updateCount : updateCounts) {
	        k += updateCount;
	    }

	    System.out.println((k/-2) + " records updated.");
	}
}
