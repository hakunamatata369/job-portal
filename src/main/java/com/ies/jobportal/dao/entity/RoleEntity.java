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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "role")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq-gen", initialValue=1, allocationSize=1)
	private Long roleId;

	@Column(name = "role_name")
	private String roleName;

	@Column(name = "description")
	private String description;

	@OneToOne
	@JoinColumn(name = "company_id")
	private CompanyEntity company;

	public RoleEntity(String roleName) {
		this.roleName = roleName;
	}
}
