package com.exam.main;

import java.util.Scanner;

import com.exam.students.*;
import com.exam.adminusers.*;
import com.exam.validator.*;

public class AccountCreation {
	
	public void acountCreation() {
		Scanner scanner=new Scanner(System.in);
			boolean isExit=true;
			while(isExit) {
				try {
					
					System.out.println();
					System.out.println("\t"+"\t"+"\t"+"  ** WELCOME TO ACCOUNT CREATION **          ");
					System.out.println();
					System.out.println("\t"+"\t"+"\t"+"\t"+"`Enter your choice :");
					System.out.println("\t"+"\t"+"\t"+"\t"+"`1 for Admin Account creation");
					System.out.println("\t"+"\t"+"\t"+"\t"+"`2 for student Account creation");
					System.out.println("\t"+"\t"+"\t"+"\t"+"`3 back to HomePage");
					System.out.println();
					
					byte choice=NumberBasedValidator.choiceChecker();
						
						switch(choice) {
						case 1:{
							new AdminCreation().adminCreation();
							break;
							}
						case 2 :{
							new StudentCreation().studentCreation();
							break;
							}
						case 3 :{
							System.out.println("\t"+"\t"+"\t"+"  ** REDIRECTING TO HOMEPAGE **");
							System.out.println("\t"+"\t"+"\t"+"************************************");
							System.out.println();
							isExit=false;
							break;
						}
						default :{
							System.out.println("\t"+"\t"+"\t"+"!!! INVALID INPUT !!!");
							this.acountCreation();
							break;
						}
						}
					
					
				} catch (Exception e) {
					System.out.println("\t"+"\t"+"\t"+"!!! INVALID INPUT !!!");
					this.acountCreation();
					break;
				}
				
				
			}
		
	}

}
