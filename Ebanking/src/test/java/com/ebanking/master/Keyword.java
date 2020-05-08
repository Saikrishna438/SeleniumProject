package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Keyword {

	public static void main(String[] args) throws InterruptedException, IOException {

		Library lb = new Library();

		String Res = null;

		String Kpath = "//home//nebulaa-1//eclipse-workspace//Ebanking//src//test//java//com//ebanking//testdata//keyword_data.xlsx";

		String Kout = "//home//nebulaa-1//eclipse-workspace//Ebanking//src//test//java//com//ebanking//results//keyword_result.xlsx";

		FileInputStream fis = new FileInputStream(Kpath);

		// Workbook

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Sheet

		XSSFSheet ws = wb.getSheet("TestCase");

		XSSFSheet ws1 = wb.getSheet("TestSteps");

		// Row count

		int tcRc = ws.getLastRowNum();

		System.out.println("TestCase RowCount : "+tcRc);

		int tsRc = ws1.getLastRowNum();

		System.out.println("TestStep RowCount : "+tsRc);

		// test cases

		for (int i = 1; i <= tcRc; i++) {

			String exe = ws.getRow(i).getCell(2).getStringCellValue();

			if (exe.equalsIgnoreCase("Y")) {

				String tcId = ws.getRow(i).getCell(0).getStringCellValue();

				//System.out.println("TestCase Id : "+tcId);

				// test steps

				for (int j = 1; j <= tsRc; j++) {

					String tsTcid = ws1.getRow(j).getCell(0).getStringCellValue();

					 //System.out.println("TestStep Id : "+tsTcid);

					if (tcId.equalsIgnoreCase(tsTcid)) {

						String key = ws1.getRow(j).getCell(3).getStringCellValue();

						System.out.println(key);

						switch (key) {

						case "RLanch":

							Res = lb.OpenApp("http://183.82.100.55/ranford2/");

							break;

						case "RLogin":

							Res = lb.AdminLogin("Admin", "M1ndq");

							break;

						case "RLogout":

							lb.AdminLogout();

							break;

						case "RBranch":

							Res = lb.BranchCreation("Alugunur", "Alugunur", "Alugunur", "56467", "INDIA", "GOA", "GOA");

							break;

						case "RRole":

							Res = lb.RoleCreation("Cashierhdfc", "E");

							break;

						case "RClose":

							lb.CloseApp();

							break;

						default:

							System.out.println("Pass a Valid Keyword");

							break;

						}

						// result updation in test steps sheet

						ws1.getRow(j).createCell(4).setCellValue(Res);

						// result updation in test case sheet

						if (ws1.getRow(j).getCell(4).getStringCellValue().equalsIgnoreCase("Pass")) {

							ws.getRow(i).createCell(3).setCellValue(Res);

						} else {

							ws.getRow(i).createCell(3).setCellValue("Fail");

						}

					}

				}

			} else {

				ws.getRow(i).createCell(3).setCellValue("BLOCKED");

			}

		}

		FileOutputStream fo = new FileOutputStream(Kout);

		wb.write(fo);

		wb.close();

	}

}
