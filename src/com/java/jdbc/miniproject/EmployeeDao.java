package com.java.jdbc.miniproject;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    void addEmployee(Employee employee) throws SQLException;
    void updateEmployee(Employee employee) throws SQLException;
    void deleteEmployee(Employee employee) throws SQLException;
    Employee getEmployeeById(int empId) throws SQLException, Exception;
    List<Employee> getEmployees() throws SQLException;
}