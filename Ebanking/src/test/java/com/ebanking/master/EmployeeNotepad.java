package com.ebanking.master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeeNotepad {

	public static void main(String[] args) throws IOException, InterruptedException {

		Library lib = new Library();

		lib.OpenApp("http://183.82.100.55/ranford2/");

		lib.AdminLogin("Admin", "M1ndq");

		String SD;

		// To get testdata file

		FileReader FR = new FileReader(
				"//home//nebulaa-1//eclipse-workspace//Ebanking//src//test//java//com//ebanking//testdata//Employee.txt");

		// To read the testdta file

		BufferedReader BR = new BufferedReader(FR);

		String Sread = BR.readLine();

		// To get Results file

		FileWriter FW = new FileWriter(
				"//home//nebulaa-1//eclipse-workspace//Ebanking//src//test//java//com//ebanking//results//Employee_Results.txt");

		// To write into the file

		BufferedWriter BW = new BufferedWriter(FW);

		BW.write(Sread);

		BW.newLine();

		// while loop

		while ((SD = BR.readLine()) != null) {

			System.out.println(SD);

			// split

			String SR[] = SD.split("###");

			String Ename = SR[0];

			String lgnpwd = SR[1];

			String Role = SR[2];

			String Branch = SR[3];

			String Res = lib.EmployeeCreation(Ename, lgnpwd, Role, Branch);

			// Results

			BW.write(SD + "$$$$" + Res);

			BW.newLine();

		}

		BW.close();

		BR.close();

		lib.AdminLogout();

		lib.CloseApp();
		

	}

}
