package com.db.dboperators;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.db.entity.SesMilesDriven;
import com.db.helper.DBConnection;
import com.db.helper.Queries;

public class InsertOperation {

	private static int k = 0;

	// Insert all the insert record objects to the database table with a batch size of 1000
	public static void insertRecords(List<SesMilesDriven> insertRecords) throws Exception {
		Connection con = DBConnection.getCon();
		PreparedStatement psInsert = con.prepareStatement(Queries.INSERT);

		int batchSize = 1000;
		int count = 0;

		for (SesMilesDriven smd : insertRecords) {
			psInsert.setString(1, smd.getCostctrid());
			psInsert.setDouble(2, smd.getMiles_driven());
			psInsert.setString(3, smd.getReporting_yr());
			psInsert.setInt(4, smd.getReporting_pd());
			psInsert.setInt(5, smd.getReporting_wk());
			psInsert.setString(6, smd.getSource_system());
			psInsert.setDate(7, smd.getSes_load_dt());
			psInsert.setString(8, smd.getAsset_no());
			psInsert.setDate(9, smd.getRea_date());
			psInsert.setDouble(10, smd.getReading());
			psInsert.setDouble(11, smd.getMiles_driven_orig());

			psInsert.addBatch();

			count++;

			if (count % batchSize == 0) {
				// Execute the batch update
				int[] updateCounts = psInsert.executeBatch();

				// Calculate the total updated records count
				for (int updateCount : updateCounts) {
					k += updateCount;
				}

				// Clear the batch
				psInsert.clearBatch();
			}
		} // end of for loop

		// Execute the remaining batch (if any)
		int[] updateCounts = psInsert.executeBatch();

		// Calculate the total updated records count
		for (int updateCount : updateCounts) {
			k += updateCount;
		}

		System.out.println((k / -2) + " records inserted.");
	}

}
