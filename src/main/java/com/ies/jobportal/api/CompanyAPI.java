package com.ies.jobportal.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ies.jobportal.exceptions.CompanyException;
import com.ies.jobportal.exceptions.CompanyIdNotFoundException;
import com.ies.jobportal.exceptions.UserException;
import com.ies.jobportal.request.CompanyRequest;
import com.ies.jobportal.response.CompanyResponse;
import com.ies.jobportal.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyAPI {

	private static Logger logger = LoggerFactory.getLogger(CompanyAPI.class);
	
	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<CompanyResponse> findAllCompany(CompanyRequest companyRequest) throws CompanyException {
		logger.info("Retrieving the list of companies...");
		CompanyResponse response = companyService.findAllCompanies(companyRequest);
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<CompanyResponse> createCompany(@RequestBody CompanyRequest request) throws CompanyException, UserException {
		
		CompanyResponse response = companyService.createCompany(request);
		logger.info("Creating a company...");
		return ResponseEntity.ok(response);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<CompanyResponse> updateCompany(@RequestBody CompanyRequest request) throws CompanyException, CompanyIdNotFoundException {
		CompanyResponse response = companyService.updateCompany(request);
		logger.info("Updating a company...");
		return ResponseEntity.ok(response);

	}

	@RequestMapping(value = "/delete/{companyId}", method = RequestMethod.DELETE)
	public ResponseEntity<CompanyResponse> deleteCompany(@PathVariable("companyId") Long companyId) throws CompanyException, CompanyIdNotFoundException {
		CompanyResponse response = companyService.deleteCompany(companyId);
		logger.info("Removing a company...");
		return ResponseEntity.ok(response);
	}
}
