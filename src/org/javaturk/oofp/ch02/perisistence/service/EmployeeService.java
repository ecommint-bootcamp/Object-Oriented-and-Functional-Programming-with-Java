
package javaturk.oofp.ch02.perisistence.service;

import javaturk.oofp.ch02.perisistence.dao.AbstractDao;
import javaturk.oofp.ch02.perisistence.dao.EmployeeDao;
import javaturk.oofp.ch02.perisistence.domain.Employee;

public class EmployeeService {
	
	private AbstractDao employeeDao;
	
	public EmployeeService(EmployeeDao employeeDao){
		this.employeeDao = employeeDao;
	}
	
	public void createEmployee(Employee employee){
		employeeDao.save(employee);
	}
	
	public void changePassword(Employee employee, String newPassword){
		employee.setPassword(newPassword);
		employeeDao.update(employee);
	}
}
