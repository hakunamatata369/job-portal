package com.ies.jobportal.util;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ies.jobportal.dao.entity.CompanyEntity;
import com.ies.jobportal.pojo.Company;

@Component
@ConfigurationPropertiesBinding
public class CompanyEntityConverter implements Converter<CompanyEntity, Company> {

	@Override
	public Company convert(CompanyEntity companyEntity) {
		Company company = Company.builder().companyId(companyEntity.getCompanyId())
				.companyName(companyEntity.getCompanyName()).alias(companyEntity.getAlias())
				.companyLogo(companyEntity.getCompanyLogo()).companyWebsite(companyEntity.getCompanyWebsite()).build();

		return company;
	}
}
