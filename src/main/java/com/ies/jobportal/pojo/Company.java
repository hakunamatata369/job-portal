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
public class Company {

	private Long companyId;

	private String companyName;

	private String alias;

	private String companyLogo;

	private String companyWebsite;

}
