package com.ies.jobportal.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "job")
public class JobEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq-gen", initialValue=1, allocationSize=1)
	@Column(name = "job_id")
	private Long jobId;

	@Column(name = "job_description")
	private String jobDescription;

	@Column(name = "job_status")
	private String jobStatus;

	@OneToOne
	@JoinColumn(name = "hiring_manager")
	private UserEntity hiringManager;

	@OneToOne
	@JoinColumn(name = "company_id")
	private CompanyEntity company;
	
	@OneToOne
	@JoinColumn(name = "recruiter")
	private UserEntity recruiter;
	
	@Column(name = "job_location")
	private String jobLocation;

	@Column(name = "job_type")
	private String jobType;

	@Column(name = "job_title")
	private String jobTitle;
	
	@Column(name = "experience")
	private int experience;
	
	@Column(name = "job_category")
	private String jobCategory;

}
