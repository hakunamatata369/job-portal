package com.ies.jobportal.dao.converters;

import org.springframework.core.convert.converter.Converter;

import com.ies.jobportal.dao.entity.CompanyEntity;
import com.ies.jobportal.pojo.Company;

public class CompanyToEntityConverter implements Converter<Company, CompanyEntity> {

	@Override
	public CompanyEntity convert(Company company) {
		CompanyEntity companyEntity = CompanyEntity.builder().companyName(company.getCompanyName())
				.companyWebsite(company.getCompanyWebsite()).companyLogo(company.getCompanyLogo())
				.alias(company.getAlias()).build();
		return companyEntity;
	}

}
