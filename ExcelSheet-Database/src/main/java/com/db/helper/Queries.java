package com.db.helper;

public class Queries {
	
	public static final String SELECT="SELECT * FROM SES_MILES_DRIVEN";
	
	public static final String UPDATE="UPDATE SES_MILES_DRIVEN SET Miles_Driven =?, Source_System =?, SES_Load_Dt =?, Rea_Date =?, Reading =?, Miles_Driven_ORIG =? WHERE CostCtrId=? AND Reporting_Yr =? AND Reporting_Pd=? AND Reporting_Wk=? AND Asset_No=?";

	public static final String INSERT="INSERT INTO SES_MILES_DRIVEN (CostCtrId, Miles_Driven, Reporting_Yr, Reporting_Pd, Reporting_Wk, Source_System, SES_Load_Dt, Asset_No, Rea_Date, Reading, Miles_Driven_ORIG) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String SELECT_BATCH="SELECT * FROM SES_MILES_DRIVEN WHERE ROWNUM <= ? minus SELECT * FROM SES_MILES_DRIVEN WHERE ROWNUM <= ?";
}
