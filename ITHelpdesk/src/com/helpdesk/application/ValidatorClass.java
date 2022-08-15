package com.helpdesk.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.helpdesk.dbconnection.DBConnection;

public class ValidatorClass {

	static Connection connection;

	public static byte getValidatedChoice() {
		Scanner scanner = new Scanner(System.in);
		StringBuilder s1 = new StringBuilder();
		boolean isExite = true;
		while (isExite) {
			System.out.println("Enter a choice");
			s1.append(scanner.nextLine());
			if (s1.length() == 1 && Character.isDigit(s1.charAt(0))) {
				isExite = false;
			} else {
				s1.setLength(0);
				System.out.println("\t" + "\t" + "\t" + " !!! INVALID INPUT !!!");
				System.out.println();
			}
		}

		return Byte.parseByte(s1.toString());

	}

	public static String getValidatedName() {

		Scanner scanner = new Scanner(System.in);

		System.out.println();
		System.out.println("A-Z and a-z and 0-9 are only accepted and length less than 30");
		System.out.println();
		StringBuilder builder = new StringBuilder();

		while (true) {
			System.out.println("Enter a User Name");
			builder.append(scanner.nextLine());

			int letterCount = 0;
			int digitCount = 0;

			for (int i = 0; i < builder.length(); i++) {

				if (Character.isDigit(builder.charAt(i))) {
					digitCount++;
				} else if (Character.isAlphabetic(builder.charAt(i))) {
					letterCount++;
				} else {
					System.out.println();
					builder.setLength(0);
					System.out.println("!!! User name only have Alpha-Numberic Character!!!");
					System.out.println();
					break;
				}

			}

			if (digitCount > letterCount && builder.length() != 0) {
				System.out.println();
				builder.setLength(0);
				System.out.println("User name must conatain more alpa characters than numeric character");
				System.out.println();
			}

			else if (builder.length() < 30 && builder.length() != 0) {
				break;
			}

		}

		return builder.toString();
	}

	public static int getValidatedTicketNumberandAdminId(int choice) {

		Scanner scanner = new Scanner(System.in);

		System.out.println();
		System.out.println("!!! 0-9 are accepted !!!");
		System.out.println();
		StringBuilder builder = new StringBuilder();

		while (true) {
			if (choice == 1) {
				System.out.println("Enter a Ticket number");
			} else {
				System.out.println("Enter a Admin ID");
			}
			builder.append(scanner.nextLine());
			boolean validator = Pattern.compile("^[0-9]+$").matcher(builder.toString()).find();

			if (validator) {
				break;
			} else {
				System.out.println();
				builder.setLength(0);
				System.out.println("!!! Enter a valid User name !!!");
				System.out.println();
			}

		}

		return Integer.parseInt(builder.toString());

	}

	public static String getValidPassWord() {
		Scanner scanner = new Scanner(System.in);

		System.out.println();
		System.out.println("!!!A-Z or A-z or '_' or '@' 0-9 are accepted and length less than 30 !!!");
		System.out.println();
		StringBuilder builder = new StringBuilder();

		while (true) {
			System.out.println("Enter a User Password");
			builder.append(scanner.nextLine());

			if (builder.length() < 30) {

				for (int i = 0; i < builder.length(); i++) {

					if (Character.isDigit(builder.charAt(i)) || Character.isAlphabetic(builder.charAt(i))
							|| builder.charAt(i) == '@' || builder.charAt(i) == '_') {
						continue;
					} else {

						System.out.println();
						builder.setLength(0);
						System.out.println("!!! Enter a valid User name !!!");
						System.out.println();
						break;
					}

				}
				if (builder.length() > 0) {
					break;
				}
			} else {
				System.out.println();
				builder.setLength(0);
				System.out.println("!!! Password length must be less than 30!!!");
				System.out.println();
			}

		}

		return builder.toString();
	}

	public static String getSubjectDiscription(int choice) {
		Scanner scanner = new Scanner(System.in);

		StringBuilder builder = new StringBuilder();

		while (true) {

			System.out.println();

			if (choice == 1) {
				System.out.println("!!! Subject must contain 10 characters long !!!");
			} else if (choice == 2) {
				System.out.println("!!! Discription must contain 10 characters long !!!");
			} else {
				System.out.println("!!! Message feild will not be empty !!!");
			}

			System.out.println();

			System.out.println("Type a text here...");
			builder.append(scanner.nextLine());

			if (builder.length() > 10 && builder.length() < 100 && choice == 1) {
				break;

			} else if (builder.length() > 10 && choice == 2) {
				break;
			} else if (builder.length() > 1 && choice == 3) {
				break;
			}

			else {
				System.out.println();
				builder.setLength(0);
				System.out.println("!!! Subject and Discription must contain 10 characters long !!!");
				System.out.println();
			}

		}

		return builder.toString();
	}

	public PreparedStatement getPreparedStatement(String query) {

		PreparedStatement preparedStatement = null;
		try {

			if (connection == null) {
				connection = DBConnection.getInstance().getConnection();
				System.out.println("null");
			} else if (connection.isClosed()) {
				System.out.println("Closed");
				connection = DBConnection.getInstance().getConnection();
			}

			preparedStatement = connection.prepareStatement(query);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return preparedStatement;

	}

	public void closeConnection() {

		try {

			if (connection != null) {
				connection.close();
				System.out.println("close");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
