package com.ies.jobportal.dao.converters;

import org.springframework.core.convert.converter.Converter;

import com.ies.jobportal.dao.entity.CompanyEntity;
import com.ies.jobportal.pojo.Company;

public class CompanyEntityConverter implements Converter<CompanyEntity, Company>{

	@Override
	public Company convert(CompanyEntity companyEntity) {
		Company company = Company.builder().companyName(companyEntity.getCompanyName())
				.companyWebsite(companyEntity.getCompanyWebsite()).companyLogo(companyEntity.getCompanyLogo())
				.alias(companyEntity.getAlias()).build();
		return company;
	}

}
