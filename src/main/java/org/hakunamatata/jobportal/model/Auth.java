package org.hakunamatata.jobportal.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Auth")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Auth {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "member_id", referencedColumnName = "memberId")
	private int memberId;

	@Column(name = "secret")
	private String secret;
	
	@Column(name = "create_date")
	private String createDate;
	
	@Column(name = "expire_date")
	private String expireDate;
	
	@Column(name = "expire_mode")
	private String expireMode;
}
