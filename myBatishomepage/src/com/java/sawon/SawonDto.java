package com.java.sawon;

import java.util.Date;

public class SawonDto {
	private int employeeId;	//사원번호
	private String firstName; 	//이름
	private Date hireDate;	//입사년월일
	private String jobId;	//직종
	private Long salary;	//연봉
	private int departmentId;	//부서코드
	private String departmentName;	//부서명

	
	public SawonDto() {}
	
	public SawonDto(int employeeId, String firstName, Date hireDate, String jobId, Long salary, int departmentId,
			String departmentName) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.salary = salary;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "SawonDto [employeeId=" + employeeId + ", firstName=" + firstName + ", hireDate=" + hireDate + ", jobId="
				+ jobId + ", salary=" + salary + ", departmentId=" + departmentId + ", departmentName=" + departmentName
				+ "]";
	}
	
	
}
