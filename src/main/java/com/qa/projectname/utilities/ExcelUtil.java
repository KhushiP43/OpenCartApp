package com.qa.projectname.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelUtil {
	
	public static final String UP_TEST_SHEET = ".src/test/resource/testdata/Username and Password.xlsx";
	
	public static void getTestData(String sheetName) {
		try {
			FileInputStream ip = new FileInputStream(UP_TEST_SHEET );
			Workbook
		}catch(FileNotFoundException e) {
			
		}
			
		}
}
