package org.hakunamatata.jobportal.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

	@Column(name = "phone_type")
	private int phoneType;

	@Column(name = "phone_number")
	private long phoneNumber;

}
