package com.ies.jobportal.dao.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "interview")
public class InterviewEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "interview_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq-gen", initialValue=1, allocationSize=1)
	private Long interviewId;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "round_status")
	private String roundStatus;

	@Column(name = "round")
	private String round;

	@Column(name = "round_overall_rating")
	private String roundOverallRating;
	
	@Column(name = "round_comments")
	private String roundComments;

	@OneToOne
	@JoinColumn(name = "job_id")
	private JobEntity job;

	@OneToOne
	@JoinColumn(name = "interviewer")
	private UserEntity interviewer;
	
	@OneToOne
	@JoinColumn(name = "candidate_id")
	private CandidateEntity candidate;
	
	@Column(name = "scheduled_date")
	private Date scheduledDate;
	
	/*@Column(name = "competencies")
	private String competencies;*/
}
