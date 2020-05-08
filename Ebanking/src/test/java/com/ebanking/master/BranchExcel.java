package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BranchExcel {

	public static void main(String[] args) throws IOException, InterruptedException {

		Library lib = new Library();

		lib.OpenApp("http://183.82.100.55/ranford2/");

		lib.AdminLogin("Admin", "M1ndq");

		// To get testdata from excel file

		FileInputStream FIS = new FileInputStream(
				"//home//nebulaa-1//eclipse-workspace//Ebanking//src//test//java//com//ebanking//testdata//Role.xlsx");

		// Workbook

		XSSFWorkbook WB = new XSSFWorkbook(FIS);

		// sheet

		XSSFSheet WS = WB.getSheet("Bdata");

		// RowCount

		int Rcount = WS.getLastRowNum();

		System.out.println(Rcount);

		// Multiple iterations

		for (int i = 1; i <= Rcount; i++) {

			// Row

			XSSFRow WR = WS.getRow(i);

			// Cell

			XSSFCell WC = WR.getCell(0);

			XSSFCell WC1 = WR.getCell(1);

			XSSFCell WC2 = WR.getCell(2);

			XSSFCell WC3 = WR.getCell(3);

			XSSFCell WC4 = WR.getCell(4);

			XSSFCell WC5 = WR.getCell(5);

			XSSFCell WC6 = WR.getCell(6);

			XSSFCell WC7 = WR.createCell(7);

			// Cell values

			String Bname = WC.getStringCellValue();

			String Add1 = WC1.getStringCellValue();

			String area = WC2.getStringCellValue();

			String zip = WC3.getStringCellValue();

			String country = WC4.getStringCellValue();

			String state = WC5.getStringCellValue();

			String city = WC6.getStringCellValue();

			String Res = lib.BranchCreation(Bname, Add1, area, zip, country, state, city);

			System.out.println(Res);

			WC7.setCellValue(Res);

		}

		// Results

		FileOutputStream FOS = new FileOutputStream(
				"//home//nebulaa-1//eclipse-workspace//Ebanking//src//test//java//com//ebanking//results//Branch_Results.xlsx");

		WB.write(FOS);

		WB.close();
		
		lib.AdminLogout();
		
		lib.CloseApp();
		
	}

}
