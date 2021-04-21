package com.java.jdbc.miniproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
		System.out.println("Please select any one options");
		System.out.println("----------------------------------------------------------------");
		System.out.println("Press 1: Insert");
		System.out.println("Press 2: Update");
		System.out.println("Press 3: Delete");
		System.out.println("Press 4: Get");
		System.out.println("------------------------------------------------------------------");

		int option = Integer.parseInt(br.readLine());
		switch (option) {
		case 1: {
			insert();
			break;
		}
		case 2: {
			update();
			break;
		}
		case 3: {
			delete();
			break;
		}
		case 4: {
			get();
			break;
		}
		default: {
			System.out.println("Incorrect options");
		}
		}
	}

	private static void insert() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("ENter id name and email address of employee");
		int id = Integer.parseInt(br.readLine());
		String n = br.readLine();
		String e = br.readLine();
		Employee employee = new Employee(id, n, e);

		EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
		dao.addEmployee(employee);

	}

	private static void update() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the name and updated emailid");
		String n = br.readLine();
		String e = br.readLine();
		Employee employee1 = new Employee(n,e);
		EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
		dao.updateEmployee(employee1);
		

	}

	private static void delete() throws SQLException, NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter id you want to delete");
		int id = Integer.parseInt(br.readLine());
		Employee employee1 = new Employee(id);
		EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
		dao.deleteEmployee(employee1);

	}
	

	private static void get() throws SQLException {

		EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
		List<Employee> list = dao.getEmployees();
		for (Employee emp : list) {
			System.out.println(emp.toString());
		}

		// write your code here
		/*
		 * EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao(); Employee employee =
		 * new Employee(4, "Akshay", "akshay@gmail.com"); dao.addEmployee(employee);
		 * dao.updateEmployee(employee);
		 * 
		 */
		/*
		 * EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao(); Employee employee1
		 * =new Employee(); dao.updateEmployee(employee1);
		 */

		/*
		 * EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao(); Employee employee1
		 * =new Employee(); dao.deleteEmployee(employee1);
		 */

	}
}
