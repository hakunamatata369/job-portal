package org.hakunamatata.jobportal.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "company")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {

	@Id
	@GeneratedValue
	@Column(name = "company_id")	
	private long companyId;
	
	@Column(name = "comapany_name")
	private String companyName;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "phone", joinColumns = @JoinColumn(name = "company_id"))
	@GenericGenerator(name = "sequence_gen", strategy = "sequence")
	@CollectionId(columns = { @Column(name = "phone_id") }, generator = "sequence_gen", type = @Type(type = "long"))
	private Collection<Phone> phones = new ArrayList<Phone>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "company_addresses", joinColumns = @JoinColumn(name = "company_id"), inverseJoinColumns = @JoinColumn(name = "address_id"))
	private Collection<Address> addresses;
	
}
