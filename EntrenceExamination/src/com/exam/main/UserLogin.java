package com.exam.main;

import com.exam.validator.*;
import com.exam.adminusers.*;
import com.exam.students.*;

public class UserLogin {
	
	
	public void userLogin() {
		
		boolean isExit=true;
		while(isExit) {
			
			try {
				
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"  ** WELCOME TO LOGIN MENU **");
				System.out.println("\t"+"\t"+"\t"+"\t"+"Enter your choice :");
				System.out.println("\t"+"\t"+"\t"+"\t"+"1 for Admin Login");
				System.out.println("\t"+"\t"+"\t"+"\t"+"2 for student Login");
				System.out.println("\t"+"\t"+"\t"+"\t"+"3 for exit");
				System.out.println();
					
					byte choice=NumberBasedValidator.choiceChecker();
					
					switch(choice) {
					case 1 :{
						new Adminlogin().adminLogin();
						break;
						}
					case 2 :{
						new StudentLogin().studentLogin();
						break;
						}
					case 3 :{
						System.out.println("\t"+"\t"+"\t"+"  !!! REDIRECTING TO HOMEPAGE !!!");
						System.out.println("\t"+"\t"+"\t"+"************************************");
						System.out.println();
						isExit=false;
						break;
					}
					default :{
						System.out.println("\t"+"\t"+"\t"+"\t"+" !!! ENTER THE GIVEN CHOICES !!!");
						System.out.println();
						break;
					}
				}

			} catch (Exception e) {
				System.out.println("\t"+"\t"+"\t"+"\t"+" !!! INVALID INPUT !!!");
				System.out.println();
				break;

			}
			
			
			
		}
		
	
	
}

}
