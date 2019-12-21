package com.ies.jobportal.pojo;

import java.util.Date;

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
public class Interview {

	private Long interviewId;
	private Date createdDate;
	private String roundStatus;
	private String round;
	private String roundOverallRating;
	private String roundComments;
	private Job job;
	private User interviewer;
	private Candidate candidate;
	private Date scheduledDate;
}
