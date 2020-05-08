package com.ebanking.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class RoleCreation extends Base {
	
	@Test(dataProvider = "Rdata")
	public void roleCreation(String rn, String rt) throws InterruptedException {
		
		lb.RoleCreation(rn, rt);
		
	}
	
	@DataProvider
	public Object [][] Rdata(){
		
		Object [][] obj = new Object[3][2];
		
		obj[0][0] = "managerhdfc";
		obj[0][1] = "E";
		
		obj[1][0] = "manageraxis";
		obj[1][1] = "E";
		
		obj[2][0] = "managericici";
		obj[2][1] = "E";
		
		return obj;
		
	}

}
