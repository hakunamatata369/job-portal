package com.ies.jobportal.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ies.jobportal.dao.entity.CompanyEntity;
import com.ies.jobportal.pojo.Company;

@Component
public class CompanyToEntityConverter implements Converter<Company, CompanyEntity> {

	@Override
	public CompanyEntity convert(Company company) {
		CompanyEntity companyEntity = CompanyEntity.builder().companyId(company.getCompanyId())
				.companyName(company.getCompanyName()).alias(company.getAlias()).companyLogo(company.getCompanyLogo())
				.companyWebsite(company.getCompanyWebsite()).build();

		return companyEntity;
	}
}
