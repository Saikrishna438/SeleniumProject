package com.ebanking.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmployeeCreation extends Base {
	
	@Test(dataProvider = "Edata")
	public void employeeCreation(String en,String lgnpwd,String role, String bn) throws InterruptedException {
		
		lb.EmployeeCreation(en, lgnpwd, role, bn);
		
	}
	
	@DataProvider
	public Object [][] Edata(){
		
		Object [][] obj = new Object[3][4];
		
		obj[0][0] = "Krishna";
		obj[0][1] = "krishn43";
		obj[0][2] = "Tapas";
		obj[0][3] = "Alugunur";
		
		obj[1][0] = "Kumar";
		obj[1][1] = "kumar56";
		obj[1][2] = "Tester";
		obj[1][3] = "Alugunur";
		
		obj[2][0] = "Ramesh";
		obj[2][1] = "ramedh34";
		obj[2][2] = "medicalcoder";
		obj[2][3] = "abc";
	
		return obj;
		
	}
	
}
