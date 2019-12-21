package com.ies.jobportal.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ies.jobportal.dao.CompanyRepository;
import com.ies.jobportal.dao.entity.CompanyEntity;

@RestController
@RequestMapping("/competency")
public class CompetencyAPI {

	/*@Autowired
	private CompanyService companyService;
	
	

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<CompanyResponse> findAllCompany(CompanyRequest companyRequest) throws CompanyException {
		CompanyResponse response = companyService.findAllCompanies(companyRequest);
		return ResponseEntity.ok(response);
	}*/
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@GetMapping("/all")
	public List<CompanyEntity> findAllCompanies() {
		return companyRepository.findAll();
	}
}
