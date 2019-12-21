package com.ies.jobportal.service;

import com.ies.jobportal.exceptions.CompanyException;
import com.ies.jobportal.exceptions.JobException;
import com.ies.jobportal.exceptions.JobIdNotFoundException;
import com.ies.jobportal.exceptions.UserException;
import com.ies.jobportal.request.JobRequest;
import com.ies.jobportal.response.JobResponse;

public interface JobService {

	JobResponse findJobsByCompany(String token) throws JobException;
	
	JobResponse createOrUpdateJob(JobRequest request, String token) throws JobException, UserException, CompanyException;

	JobResponse deleteJob(Long jobId) throws JobException, JobIdNotFoundException;

	JobResponse getJobById(Long jobId);

	JobResponse test();

}
