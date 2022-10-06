package com.rabbit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeStatus {
	
	private Employee employee;
	private String status;
	private String message;
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @param employee
	 * @param status
	 * @param message
	 */
	public EmployeeStatus(Employee employee, String status, String message) {
		super();
		this.employee = employee;
		this.status = status;
		this.message = message;
	}
	
	public EmployeeStatus() {
		super();
	}
	@Override
	public String toString() {
		return "EmployeeStatus [employee=" + employee + ", status=" + status + ", message=" + message + "]";
	}
	
	
}
