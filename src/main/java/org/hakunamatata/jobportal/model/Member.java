package org.hakunamatata.jobportal.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement
@Entity(name = "Member")
@SelectBeforeUpdate
@Table(name = "member")
@NamedQuery(name = "Member.getNamebyId", query = "select name from Member where memberId = ?1")
@NamedNativeQuery(name = "Member.byFirstName", query = "select * from member where first_name = ?1", resultClass = Member.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

	@Id
	@GeneratedValue
	@Column(name = "member_id")
	private long memberId;

	@Embedded
	private Name name;

	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "phone", joinColumns = @JoinColumn(name = "member_id"))
	@GenericGenerator(name = "sequence_gen", strategy = "sequence")
	@CollectionId(columns = { @Column(name = "phone_id") }, generator = "sequence_gen", type = @Type(type = "long"))
	private Collection<Phone> phones = new ArrayList<Phone>();

	@Column(name = "email_id")
	private String emailId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id", referencedColumnName = "companyId")
	private int companyId;

}
