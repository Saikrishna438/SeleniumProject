package com.ebanking.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BranchCreation extends Base {
	
	@Test(dataProvider = "Bdata")
	public void branchCreation(String bn,String ad1,String area,String zip,String cry,String st,String city) throws InterruptedException {
		
		lb.BranchCreation(bn, ad1, area, zip, cry, st, city);
		
	}
	
	@DataProvider
	public Object [][] Bdata(){
		
		Object [][] obj = new Object[2][7];
		
		obj[0][0] = "jublihills";
		obj[0][1] = "jublihills";
		obj[0][2] = "Madhapur";
		obj[0][3] = "45633";
		obj[0][4] = "INDIA";
		obj[0][5] = "GOA";
		obj[0][6] = "GOA";
		
		obj[1][0] = "Yousufguda";
		obj[1][1] = "yousufguda";
		obj[1][2] = "Basti";
		obj[1][3] = "45890";
		obj[1][4] = "INDIA";
		obj[1][5] = "Andhra Pradesh";
		obj[1][6] = "Hyderabad";
	
		return obj;
		
	}

}
