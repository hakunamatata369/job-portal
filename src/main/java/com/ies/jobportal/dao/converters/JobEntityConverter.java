package com.ies.jobportal.dao.converters;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ies.jobportal.dao.entity.JobEntity;
import com.ies.jobportal.pojo.Job;

@Component
@ConfigurationPropertiesBinding
public class JobEntityConverter implements Converter<JobEntity, Job>{

	@Override
	public Job convert(JobEntity jobEntity) {
		Job job = Job.builder().jobId(jobEntity.getJobId())
				.jobDescription(jobEntity.getJobDescription())
				.jobLocation(jobEntity.getJobLocation()).jobType(jobEntity.getJobType())
				.jobTitle(jobEntity.getJobTitle()).experience(jobEntity.getExperience())
				.jobCategory(jobEntity.getJobCategory()).jobStatus(jobEntity.getJobStatus()).build();
		return job;
	}

}
