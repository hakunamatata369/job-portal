package com.ies.jobportal.response;

import java.util.ArrayList;
import java.util.List;

import com.ies.jobportal.pojo.Company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CompanyResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;
	private List<Company> companyList;

	public CompanyResponse() {
		companyList = new ArrayList<Company>();
	}
	
	public void addCompany(Company company){
		companyList.add(company);
	}
}
