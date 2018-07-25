package com.springRest.bugHunterAppWebservice.dto.project;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="project_details")
public class Project implements Serializable{

	
	@Id
	@GenericGenerator(name="primary",strategy="increment")
	@GeneratedValue(generator="primary")
	@Column(name="project_id")
	private int projectId;
	@Column(name="project_name")
	private String projName;
	@Column(name="project_type")
	private String projType;
	@Column(name="project_code")
	private String projCode;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="project_start_date")
	private Date projStartDate;
	@Column(name="project_description")
	private String projDescription;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="project_eta")
	private Date projETA;
	@Column(name="project_status")
	private String projStatus;
	
	
	public Project() {
		System.out.println(this.getClass().getSimpleName()+" Object Is Created.......");
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getProjType() {
		return projType;
	}

	public void setProjType(String projType) {
		this.projType = projType;
	}

	public String getProjCode() {
		return projCode;
	}

	public void setProjCode(String projCode) {
		this.projCode = projCode;
	}

	public Date getProjStartDate() {
		return projStartDate;
	}

	public void setProjStartDate(Date projStartDate) {
		this.projStartDate = projStartDate;
	}

	public String getProjDescription() {
		return projDescription;
	}

	public void setProjDescription(String projDescription) {
		this.projDescription = projDescription;
	}

	public Date getProjETA() {
		return projETA;
	}

	public void setProjETA(Date projETA) {
		this.projETA = projETA;
	}

	public String getProjStatus() {
		return projStatus;
	}

	public void setProjStatus(String projStatus) {
		this.projStatus = projStatus;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projName=" + projName + ", projType=" + projType
				+ ", projCode=" + projCode + ", projStartDate=" + projStartDate + ", projDescription=" + projDescription
				+ ", projETA=" + projETA + ", projStatus=" + projStatus + "]";
	}
	
}
