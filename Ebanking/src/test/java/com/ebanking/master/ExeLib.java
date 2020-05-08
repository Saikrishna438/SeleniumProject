package com.ebanking.master;

import java.io.IOException;

public class ExeLib {

	public static void main(String[] args) throws InterruptedException, IOException {

		Library lib = new Library();
		
		lib.OpenApp("http://183.82.100.55/ranford2/");
		
		lib.AdminLogin("Admin","M1ndq");
		
		lib.BranchCreation("Hydfrab","Hyderabad 3-78/3","Aepet","50745","INDIA","Andhra Pradesh","Hyderabad");
		
		lib.RoleCreation("Tedehtr","E");
		
		lib.EmployeeCreation("Saderhgish","saikrishna","kamal","abc");
		
		lib.HomeLink();
		
		lib.AdminLogout();
		
		String rval = lib.CloseApp();
		
		System.out.println(rval);
		
	}

}
