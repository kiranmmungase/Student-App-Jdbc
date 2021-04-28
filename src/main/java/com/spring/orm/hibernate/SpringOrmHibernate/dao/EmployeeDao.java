package com.spring.orm.hibernate.SpringOrmHibernate.dao;




import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.hibernate.SpringOrmHibernate.entities.Employee;

public class EmployeeDao {

	
	private HibernateTemplate hibernateTemplate;
	
	// insert employee
	@Transactional
	public int addEmployee(Employee employee) {
		Integer i = (Integer)hibernateTemplate.save(employee);
		
		return i;
	}
	
	public Employee getEmployeeId(int EmployeeId) {
		Employee employee = this.hibernateTemplate.get(Employee.class, EmployeeId);
		return employee;
	}
	
	public List<Employee> getAllEmployee(){
		List<Employee> employee = this.hibernateTemplate.loadAll(Employee.class);
		return employee;
	}
	@Transactional
	public void deleteEmployee(int EmployeeId) {
		Employee employee = this.hibernateTemplate.get(Employee.class, EmployeeId);
		this.hibernateTemplate.delete(employee);
		
	}
	@Transactional
	public void updateEmployee(Employee employee) {
	this.hibernateTemplate.update(employee);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	
}