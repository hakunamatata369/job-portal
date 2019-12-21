package com.ies.jobportal.dao.converters;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ies.jobportal.dao.entity.CandidateEntity;
import com.ies.jobportal.pojo.Candidate;

@Component
@ConfigurationPropertiesBinding
public class CandidateEntityConverter implements Converter<CandidateEntity, Candidate> {

	@Override
	public Candidate convert(CandidateEntity candidateEntity) {
		Candidate candidate = Candidate.builder().candidateId(candidateEntity.getCandidateId())
				.emailId(candidateEntity.getEmailId()).phone(candidateEntity.getPhone()).build();
		return candidate;
	}

}
