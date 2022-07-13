package com.exam.main;

import java.util.Scanner;

import com.exam.adminusers.*;
import com.exam.students.*;
import com.exam.validator.*;

public class ApplicationStart {
	
	private void flowManager(){
		Scanner scanner=new Scanner(System.in);
			boolean isexite=true;
				while(isexite) {
				
					try {
					
						if(Adminlogin.resultPublished == true) {
							System.out.println();
							System.out.println("\t"+"\t"+"\t"+"\t"+" ** ");
							System.out.println("\t"+"\t"+"\t"+" !!!  STUDENT ALERT !!!");
							System.out.println("\t"+"\t"+"\t"+" !!! RESULT PUBLISHED !!!");
							System.out.println("\t"+"\t"+"\t"+"\t"+" ** ");
							System.out.println();
						}
						System.out.println("\t"+"\t"+"\t"+"************************************");
						System.out.println();
						System.out.println("\t"+"\t"+"\t"+"  ** WELCOME TO EXAM APPLICATION **");
						System.out.println();
						System.out.println("\t"+"\t"+"\t"+"             	HOMEPAGE              ");
						System.out.println();
						System.out.println("\t"+"\t"+"\t"+"\t"+"Enter your choice");
						System.out.println("\t"+"\t"+"\t"+"\t"+"`1 for Account creation ");
						System.out.println("\t"+"\t"+"\t"+"\t"+"`2 for Account login");
						System.out.println("\t"+"\t"+"\t"+"\t"+"`3 for exit");
						System.out.println("\t"+"\t"+"\t"+"************************************");
						System.out.println();

						byte choice=NumberBasedValidator.choiceChecker();
						
							switch(choice) {
						
							case 1 :{
								new AccountCreation().acountCreation();
								break;
							}
							case 2 :{
								new UserLogin().userLogin();
								break;
							}
							case 3 :{
								System.out.println("\t"+"\t"+"\t"+"\t"+"!!! THANK YOU !!!");
								isexite=false;
								break;
							}
							default :{
								System.out.println("\t"+"\t"+"\t"+" !!! SELECT A CORRECT OPTION !!!");
								break;
							}
						}
						
					} catch (Exception e) {
						System.out.println("\t"+"\t"+"\t"+" !!! INVALID INPUT !!!");
						System.out.println();	
						this.flowManager();
					}

				}
		}

	public static void main(String[] args) {
		
		new ApplicationStart().flowManager();

	}

}
