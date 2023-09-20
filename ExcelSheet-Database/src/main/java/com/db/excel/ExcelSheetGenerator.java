package com.db.excel;

import java.io.FileOutputStream;
import java.util.List;
import com.db.entity.SesMilesDriven;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetGenerator {
    //generate excel sheet based on the received values either insert sheet or update sheet
	public static String generatePdf(List<SesMilesDriven> records, String head) throws Exception{

		String outputPath = "D:\\web\\" + head + ".xlsx";

		try {
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("Data");

			// Create styles for header and normal cells
			CellStyle headerStyle = workbook.createCellStyle();
			headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerStyle.setFont(headerFont);

			CellStyle normalStyle = workbook.createCellStyle();
			Font normalFont = workbook.createFont();
			normalStyle.setFont(normalFont);

			// Add headers to the sheet
			Row headerRow = sheet.createRow(0);
			String[] headers = {
					"COSTCTRID", "MILES_DRIVEN", "REPORTING_YR", "REPORTING_PD", "REPORTING_WK",
					"SOURCE_SYSTEM", "SES_LOAD_DT", "ASSET_NO", "REA_DATE", "READING", "MILES_DRIVEN_ORIG"
			};

			for (int i = 0; i < headers.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(headers[i]);
				cell.setCellStyle(headerStyle);
			}

			// Add data to the sheet
			int rowNum = 1;
			for (SesMilesDriven smd : records) {
				Row row = sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(smd.getCostctrid());
				row.createCell(1).setCellValue(smd.getMiles_driven().toString());
				row.createCell(2).setCellValue(smd.getReporting_yr().toString());
				row.createCell(3).setCellValue(smd.getReporting_pd().toString());
				row.createCell(4).setCellValue(smd.getReporting_wk().toString());
				row.createCell(5).setCellValue(smd.getSource_system());
				row.createCell(6).setCellValue(smd.getSes_load_dt().toString());
				row.createCell(7).setCellValue(smd.getAsset_no().toString());
				if (smd.getRea_date() != null)
					row.createCell(8).setCellValue(smd.getRea_date().toString());
				else
					row.createCell(8).setCellValue("NULL");
				row.createCell(9).setCellValue(smd.getReading().toString());
				row.createCell(10).setCellValue(smd.getMiles_driven_orig().toString());
			}

			// Auto-size columns for better visibility
			for (int i = 0; i < headers.length; i++) {
				sheet.autoSizeColumn(i);
			}

			// Write the workbook to the output path
			try (FileOutputStream outputStream = new FileOutputStream(outputPath)) {
				workbook.write(outputStream);
			}

			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return head + " Excel sheet is generated successfully..";

	}
}
