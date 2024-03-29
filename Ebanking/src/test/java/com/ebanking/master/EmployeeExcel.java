package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EmployeeExcel {

	public static void main(String[] args) throws InterruptedException, IOException {

		Library lib = new Library();

		lib.OpenApp("http://183.82.100.55/ranford2/");

		lib.AdminLogin("Admin", "M1ndq");

		// To get testdata from excel file

		FileInputStream FIS = new FileInputStream(
				"//home//nebulaa-1//eclipse-workspace//Ebanking//src//test//java//com//ebanking//testdata//Role.xlsx");

		// Workbook

		XSSFWorkbook WB = new XSSFWorkbook(FIS);

		// sheet

		XSSFSheet WS = WB.getSheet("Edata");

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

			XSSFCell WC4 = WR.createCell(4);

			// Cell values

			String Ename = WC.getStringCellValue();

			String Lpwd = WC1.getStringCellValue();

			String Role = WC2.getStringCellValue();

			String Branch = WC3.getStringCellValue();

			String Res = lib.EmployeeCreation(Ename, Lpwd, Role, Branch);

			System.out.println(Res);

			WC4.setCellValue(Res);

		}

		// Results

		FileOutputStream FOS = new FileOutputStream(
				"//home//nebulaa-1//eclipse-workspace//Ebanking//src//test//java//com//ebanking//results//Employee_Results.xlsx");

		WB.write(FOS);

		WB.close();

		lib.AdminLogout();

		lib.CloseApp();

	}

}
