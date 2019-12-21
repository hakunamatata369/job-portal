package com.ies.jobportal.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "candidate")
public class CandidateEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "candidate_id")
	private Long candidateId;
	
	@Column(name = "phone_number")
	private Long phone;

	@Column(name = "email_id")
	private String emailId;
}
