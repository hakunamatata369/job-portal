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
public class User {

	private Long userId;
	private String emailId;
	private String firstName;
	private String middleName;
	private String lastName;
	private Role role;
	private Company company;
	private byte[] avatar;

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof User) {
			User o = (User) obj;
			if (userId != null && o.getUserId() != null && this.userId.equals(o.getUserId())) {
				return true;
			} else {
				return false;
			}

		} else {
			return super.equals(obj);
		}

	}

	@Override
	public int hashCode() {
		if (this.userId != null) {
			return this.userId.hashCode();
		}

		return super.hashCode();
	}
}
