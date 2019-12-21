package com.ies.jobportal.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Job {
	private Long jobId;
	private String jobDescription;
	private String jobStatus;
	private String jobLocation;
	private String jobType;
	private String jobTitle;
	private int experience;
	private String jobCategory;
	private byte[] icon;

	private User hiringManager;
	private Company company;
	private User recruiter;
}
