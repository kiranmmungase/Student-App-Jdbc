package com.java.jdbc.miniproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

	private static Statement statement = null;
	private Connection conn;

	public EmployeeDaoImpl() throws SQLException {
		conn = ConnectionFactory.getConnection();
		statement = conn.createStatement();
	}

	@Override
	public void addEmployee(Employee employee) throws SQLException {

		String sql = "INSERT INTO employee VALUES('" + employee.getEmpId() + "','" + employee.getName() + "','"
				+ employee.getEmail() + "');";

		int results = 0;
		results = statement.executeUpdate(sql);
		if (results > 0) {
			System.out.println("Added Successfully");
		} else {
			System.out.println("Failure to add");
		}

	}

	@Override
	public void updateEmployee(Employee employee) throws SQLException {
		String sql = "update employee set email='"+employee.getEmail()+"' where name='"+ employee.getName()+"'";
        int count = 0;
        count = statement.executeUpdate(sql);

        if (count > 0) {
            System.out.println("Employee Updated Successfully");
        } else {
            System.out.println("Not completed");
        }

	}

	@Override
	public void deleteEmployee(Employee employee) throws SQLException {
		String sql = "delete from employee where eid ='"+employee.getEmpId()+"'";
        int count = 0;
        count = statement.executeUpdate(sql);

        if (count > 0) {
            System.out.println("Employee Record deleted Successfully");
        } else {
            System.out.println("Please try again  !!!");
        }
	}

	@Override
	public Employee getEmployeeById(int empId) {

		return null;
	}

	@Override
	public List<Employee> getEmployees() throws SQLException {
		List<Employee> list = new ArrayList<Employee>();
		String sql = "select * from employee";
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("eid");
			String name = rs.getString("name");
			String email = rs.getString("email");
			Employee employee = new Employee(id, name, email);
			list.add(employee);

			// System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}
		return list;
	}
}