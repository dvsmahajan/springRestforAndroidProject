package com.springRest.bugHunterAppWebservice.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="resource_details")
@NamedQueries({@NamedQuery(name="checkLogin",query="select dto from UserDTO dto where dto.empEmail=:email and dto.empPassword=:password")})
public class UserDTO implements Serializable{

	@Id
	@GenericGenerator(name="primary",strategy="increment")
	@GeneratedValue(generator="primary")
	@Column(name="resource_id")
	private Integer resourceId;
	@Column(name="emp_name")
	private String empName;
	@Column(name="emp_designation")
	private String empDesignation;
	@Column(name="emp_number")
	private String empNumber;
	@Column(name="project_id")
	private Integer projId;
	@Column(name="emp_email")
	private String empEmail;
	@Column(name="emp_password")
	private String empPassword;
	@Column(name="manager_email")
	private String managerEmail;

	public UserDTO() {
		System.out.println(this.getClass().getSimpleName()+" Is Created..........");
	}
	
	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public String getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}

	

	public int getProjId() {
		return projId;
	}

	public void setProjId(Integer projId) {
		this.projId = projId;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpPassword() {
		return empPassword;
	}



	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	@Override
	public String toString() {
		return "UserDTO [resourceId=" + resourceId + ", empName=" + empName + ", empDesignation=" + empDesignation
				+ ", empNumber=" + empNumber + ", projId=" + projId + ", empEmail=" + empEmail + ", empPassword="
				+ empPassword + ", managerEmail=" + managerEmail + "]";
	}

//	@Override
//	public String toString() {
//		return "AddResourceDTO [resourceId=" + resourceId + ", empName=" + empName + ", empDesignation="
//				+ empDesignation + ", empNumber=" + empNumber + ", projId=" + projId + ", empEmail=" + empEmail
//				+ ", empPassword=" + empPassword + ", managerEmail=" + managerEmail + "]";
//	}
	

	
}
