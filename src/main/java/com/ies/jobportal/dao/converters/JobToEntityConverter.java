package com.ies.jobportal.dao.converters;

import org.springframework.core.convert.converter.Converter;

import com.ies.jobportal.dao.entity.JobEntity;
import com.ies.jobportal.pojo.Job;

public class JobToEntityConverter implements Converter<Job, JobEntity> {

	@Override
	public JobEntity convert(Job job) {
		JobEntity jobEntity = JobEntity.builder().jobId(job.getJobId())
				.jobDescription(job.getJobDescription()).jobStatus(job.getJobStatus()).build();
		return jobEntity;
	}

}
