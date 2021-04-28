package com.spring.orm.hibernate.SpringOrmHibernate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.spring.orm.hibernate.SpringOrmHibernate.dao.EmployeeDao;
import com.spring.orm.hibernate.SpringOrmHibernate.entities.Employee;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Hello World!");
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		EmployeeDao dao = context.getBean("employeeDao", EmployeeDao.class);

		/*
		 * Employee emp1 = new Employee(); emp1.setId(1); emp1.setName("kiran");
		 * emp1.setEmail("kiranmungase@gmail.com");
		 * 
		 * int result = dao.addEmployee(emp1);
		 * System.out.println("("+result+") rows inserted...");
		 */
		System.out.println("press 1: Add Employee");
		System.out.println("press 2: Get Employee Id Employee");
		System.out.println("press 3: Get Employee All Details");
		System.out.println("press 4: Delete Employee");
		System.out.println("press 5: Update Employee");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter choice you want to performed operation");
		int input = Integer.parseInt(br.readLine());

		try {
			switch (input) {
			case 1:
				System.out.println("Enter id name and email");
				int id = Integer.parseInt(br.readLine());
				String n = br.readLine();
				String e = br.readLine();
				Employee employee = new Employee();
				employee.setId(id);
				employee.setName(n);
				employee.setEmail(e);
				int result = dao.addEmployee(employee);
				System.out.println("Add sucessfully");

				break;
			case 2:
				System.out.println("Enter id you want to fetch record..!!");
				int eid = Integer.parseInt(br.readLine());
				Employee emp = new Employee();
				emp.setId(eid);
				Employee employee2 = dao.getEmployeeId(eid);
				System.out.println(employee2);
				
				
				break;
			case 3:
				System.out.println("All the Employee Details:");
				List<Employee> employees = dao.getAllEmployee();
				for (Employee emp1 : employees) {
					System.out.println(emp1);
				}

				break;
			case 4:
				System.out.println("Enter id which you want to delete");
				int did = Integer.parseInt(br.readLine());
				Employee employee3 = new Employee();
				employee3.setId(did);
				dao.deleteEmployee(did);
				

				break;
			case 5:
				System.out.println("Enter id name and email");
				int id1 = Integer.parseInt(br.readLine());
				String n1 = br.readLine();
				String e1 = br.readLine();
				Employee employee1 = new Employee();
				employee1.setId(id1);
				employee1.setName(n1);
				employee1.setEmail(e1);
				dao.updateEmployee(employee1);
				System.out.println("Update data sucessfully");

				break;

			default:
				break;
			}
		} catch (Exception e) {
			System.out.println("Invalid option");
		}

	}
}
