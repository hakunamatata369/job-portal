package com.ies.jobportal.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.ies.jobportal.dao.CompanyRepository;
import com.ies.jobportal.dao.RoleRepository;
import com.ies.jobportal.dao.UserRepository;
import com.ies.jobportal.dao.entity.CompanyEntity;
import com.ies.jobportal.dao.entity.RoleEntity;
import com.ies.jobportal.dao.entity.UserEntity;
import com.ies.jobportal.enums.Status;
import com.ies.jobportal.exceptions.CompanyException;
import com.ies.jobportal.exceptions.CompanyIdNotFoundException;
import com.ies.jobportal.pojo.Company;
import com.ies.jobportal.request.CompanyRequest;
import com.ies.jobportal.response.CompanyResponse;

@Service
public class CompanyServiceImpl implements CompanyService {

	private static final String ADMIN = "ADMIN";
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ConversionService conversionService;

	@Override
	public CompanyResponse findAllCompanies(CompanyRequest companyRequest) throws CompanyException {

		CompanyResponse response = new CompanyResponse();
		List<CompanyEntity> companyListEntitites = companyRepository.findAll();
		companyListEntitites.parallelStream()
				.forEach(companyEntity -> response.addCompany(conversionService.convert(companyEntity, Company.class)));
		return response;
	}

	@Override
	public CompanyResponse createCompany(CompanyRequest request) throws CompanyException {
		if (null == request || null == request.getCompany())
			throw new CompanyException("Company Not found!!!");

		CompanyEntity companyEntity = companyRepository
				.saveAndFlush(conversionService.convert(request.getCompany(), CompanyEntity.class));
		Company company = conversionService.convert(companyEntity, Company.class);

		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setDescription(ADMIN.toLowerCase());
		roleEntity.setRoleName(ADMIN);
		roleEntity.setCompany(companyEntity);

		RoleEntity roleEntityRetrive = roleRepository.saveAndFlush(roleEntity);

		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName(request.getCompany().getCompanyName());
		userEntity.setLastName(ADMIN);
		userEntity.setRole(roleEntityRetrive);
		userEntity.setEmailId("admin@"+request.getCompany().getCompanyName()+".com");
		userEntity.setCompany(companyEntity);

		userRepository.saveAndFlush(userEntity);

		CompanyResponse response = new CompanyResponse();
		response.addCompany(company);
		return response;
	}

	@Override
	public CompanyResponse updateCompany(CompanyRequest request) throws CompanyException, CompanyIdNotFoundException {
		if (null == request || null == request.getCompany() || null == request.getCompany().getCompanyId())
			throw new CompanyException("Company id can't be null");

		if (!companyRepository.existsById(request.getCompany().getCompanyId()))
			throw new CompanyIdNotFoundException();

		CompanyEntity companyEntity = companyRepository
				.saveAndFlush(conversionService.convert(request.getCompany(), CompanyEntity.class));

		Company company = conversionService.convert(companyEntity, Company.class);

		CompanyResponse response = new CompanyResponse();
		response.addCompany(company);
		return response;
	}

	@Override
	public CompanyResponse deleteCompany(Long companyId) throws CompanyException, CompanyIdNotFoundException {
		if (null == companyId)
			throw new CompanyException("Company id can't be null");

		if (!companyRepository.existsById(companyId))
			throw new CompanyIdNotFoundException();

		companyRepository.deleteCompany(companyId, Status.DELETED, LocalDateTime.now());

		CompanyResponse response = new CompanyResponse();
		response.setMessage("Company Removed");
		return response;
	}
}
