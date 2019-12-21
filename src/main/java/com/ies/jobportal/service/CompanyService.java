package com.ies.jobportal.service;

import com.ies.jobportal.exceptions.CompanyException;
import com.ies.jobportal.exceptions.CompanyIdNotFoundException;
import com.ies.jobportal.request.CompanyRequest;
import com.ies.jobportal.response.CompanyResponse;

public interface CompanyService {

	CompanyResponse findAllCompanies(CompanyRequest companyRequest) throws CompanyException;

	CompanyResponse createCompany(CompanyRequest request) throws CompanyException;

	CompanyResponse updateCompany(CompanyRequest request) throws CompanyException, CompanyIdNotFoundException;

	CompanyResponse deleteCompany(Long companyId) throws CompanyException, CompanyIdNotFoundException;
}
